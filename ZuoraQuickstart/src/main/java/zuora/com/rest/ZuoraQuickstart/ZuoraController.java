package zuora.com.rest.ZuoraQuickstart;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import io.swagger.client.*;
import io.swagger.client.api.*;
import io.swagger.client.model.*;

public class ZuoraController {
	//
	//holds the tenant username (also known as apiAccessKeyId) to connect to the Zuora service
	static String uid = null;
	//holds the tenant password (also known as the apiSecretAccessKey) to connect to the Zuora service
	static String pwd = null;
	//the name of a product to search for in the Zuora product catalog
	static String productToFind = "Enterprise";
	//holds the product rate plan ID returned from the product catalog after doing a search
	static String firstProductRatePlanId = null;
	//holds the product rate plan ID used to create an amendment and add a product rate plan to a subscription
	static String productRatePlanIdForUpgrade = null;
	//holds the created subscription rate plan ID to create a cancel amendment and remove a product rate plan from a subscription
	static String subscriptionRatePlanId = null;
	//holds the ID of the subscription after the upgrade in order to cancel the subscription
	static String subscriptionToCancel = null;
	//common account and subscription creation fields
	static String accountName = "ABC Unlimited";
	static String firstName = "Leo";
	static String lastName = "Liu";
	static String effectiveDate = "2016-10-01";
	//date to cancel the subscription
	static String cancelDate = "2016-11-30";
	//date to upgrade the subscription
	static String upgradeDate = "2016-12-01";
	
	public static void main(String[] args) {
		try{
			if (uid == null && pwd == null)
			{
				if (args.length < 2 || args.length > 2)
				{
					System.out.println("Please execute while passing in username then password. ex: java -jar ZuoraQuickstart.jar uid pwd");
					return;
				}
				else
				{
					uid = args[0];
					pwd = args[1];
				}
			}
			//Initialize the swagger ApiClient class which will handle logging in each for each service call
			//only one instance is needed and passed to each service call
			ApiClient apiClient = new ApiClient();
			apiClient.setBasePath("https://rest.apisandbox.zuora.com/v1");
			apiClient.addDefaultHeader("apiAccessKeyId",uid);
			apiClient.addDefaultHeader("apiSecretAccessKey", pwd);
			
			//Get the product catalog and find product rate plans to use for creating and amending subscriptions
			getProductCatalog(apiClient);
			
			//Check to see if rate plans were found
			if(firstProductRatePlanId != null)
			{
				//if a product and rate plan is found then create an account and subscription
				String subscriptionId = createAccount(apiClient, firstProductRatePlanId);
				if(subscriptionId != null)
				{
					if(productRatePlanIdForUpgrade!=null)
					{
						subscriptionId = upgradeSubscription(apiClient, subscriptionId, productRatePlanIdForUpgrade);
						if (subscriptionId != null)
						{
							System.out.println("Canceling subscriptionID:"+subscriptionId+" after upgrade");
							cancelSubscription(apiClient, subscriptionId);
						}
					} else {
						cancelSubscription(apiClient, subscriptionId);
					}
				}
				else
					System.out.println("Not Canceling subscription because it was not created");
			} else {
				System.out.println("No rate plan found so not continuing");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public static void getProductCatalog(ApiClient apiClient) throws ApiException
	{
		//Initialize the swagger generated CatalogApi which represents the Zuora Catalog service
		//Pass the apiClient to each service call
		CatalogApi catalogApi = new CatalogApi(apiClient);
		GETCatalogType g = catalogApi.gETCatalog();

		for (int prodCount=0; prodCount<g.getProducts().size(); prodCount++)
		{
			if (g.getProducts().get(prodCount).getName().equals(productToFind))
			{
				System.out.println("Product "+productToFind+" Found");
				//Just search for a max of two products
				//One product to create a subscription and a second to upgrade the subscription
				for (int rpCount=0; rpCount<g.getProducts().get(prodCount).getProductRatePlans().size() && rpCount < 2; rpCount++)
				{
					if (rpCount==0)
					{
						firstProductRatePlanId = g.getProducts().get(prodCount).getProductRatePlans().get(rpCount).getId().toString();
						System.out.println("First RP returned with ID:"+firstProductRatePlanId);
					} else if (rpCount==1)
					{
						productRatePlanIdForUpgrade = g.getProducts().get(prodCount).getProductRatePlans().get(rpCount).getId().toString();
						System.out.println("Second RP returned with ID:"+productRatePlanIdForUpgrade);
					}
				}
				break;
			}
		}
	}
	
	public static String createAccount(ApiClient apiClient, String productRatePlanId)
	{
		System.out.println("Preparing to create both account and subscription");
		AccountsApi accountsApi = new AccountsApi(apiClient);
		POSTAccountType p = new POSTAccountType();
		p.setName(accountName);
		p.setCurrency("USD");
		POSTAccountTypeBillToContact billTo = new POSTAccountTypeBillToContact();
			billTo.setFirstName(firstName);
			billTo.setLastName(lastName);
		p.setBillToContact(billTo);
		POSTAccountTypeSoldToContact soldTo = new POSTAccountTypeSoldToContact();
			soldTo.setFirstName(firstName);
			soldTo.setLastName(lastName);
			soldTo.setState("CA");
			soldTo.setCountry("USA");
			soldTo.fax(null);
		p.setSoldToContact(soldTo);
		POSTAccountTypeCreditCard card = new POSTAccountTypeCreditCard();
			card.setCardType("Visa");
			card.setCardNumber("4111111111111111");
			card.setExpirationMonth("10");
			card.setExpirationYear("2020");
			card.setSecurityCode("111");
		p.setCreditCard(card);
		POSTAccountTypeSubscription subscription = new POSTAccountTypeSubscription();
		
			LocalDate localDate = LocalDate.parse(effectiveDate);
			subscription.setContractEffectiveDate(localDate);
			subscription.setTermType("TERMED");
			subscription.setAutoRenew(false);
			subscription.setInitialTerm(new Long("12"));
			subscription.setRenewalTerm(new Long("12"));
			POSTSrpCreateType rp = new POSTSrpCreateType();
				rp.setProductRatePlanId(productRatePlanId);
			List<POSTSrpCreateType> rps = new ArrayList();
				rps.add(rp);
			subscription.setSubscribeToRatePlans(rps);
		p.setSubscription(subscription);
		try {
			POSTAccountResponseType r = accountsApi.pOSTAccount(p, null);
			System.out.println("Creating Account and Subscription Status:"+r.getSuccess());
				return r.getSubscriptionId();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void cancelSubscription(ApiClient apiClient, String subscriptionId) throws ApiException
	{
		System.out.println("Preparing to cancel subscription with ID:"+subscriptionToCancel);
		SubscriptionsApi subscriptionsApi = new SubscriptionsApi(apiClient);
		POSTSubscriptionCancellationType type = new POSTSubscriptionCancellationType();
		type.setCancellationPolicy("SpecificDate");
		type.setInvoiceCollect(false);
		LocalDate localDate = LocalDate.parse(cancelDate);
		type.setCancellationEffectiveDate(localDate);
		try {
			//POSTSubscriptionCancellationResponseType response = subscriptionsApi.pOSTSubscriptionCancellation(subscriptionId, type, null);
			POSTSubscriptionCancellationResponseType response = subscriptionsApi.pOSTSubscriptionCancellation(subscriptionToCancel, type, null);
			System.out.println("Subscription cancelation status:"+response.getSuccess());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static String upgradeSubscription(ApiClient apiClient, String subscriptionId, String ratePlanToAdd) throws ApiException
	{
		System.out.println("Preparing to upgrade created subscription with ID:"+subscriptionId);
		LocalDate localDate = LocalDate.parse(upgradeDate);
		SubscriptionsApi subscriptionsApi = new SubscriptionsApi(apiClient);
		PUTSubscriptionType subscriptionAmendments = new PUTSubscriptionType();
		
		List<PUTSrpAddType> listRatePlanAdd = new ArrayList();
			PUTSrpAddType ratePlanAdd = new PUTSrpAddType();
			ratePlanAdd.setProductRatePlanId(ratePlanToAdd);
			ratePlanAdd.setContractEffectiveDate(localDate);
			listRatePlanAdd.add(ratePlanAdd);
		subscriptionAmendments.setAdd(listRatePlanAdd);
		System.out.println("Added type 'add' for product rate plan ID:"+ratePlanToAdd);
		
		subscriptionRatePlanId = getRatePlanFromSubscription(apiClient, subscriptionId);
		List<PUTSrpRemoveType> listRatePlanRemove = new ArrayList();
			PUTSrpRemoveType ratePlanRemove = new PUTSrpRemoveType();
			ratePlanRemove.setRatePlanId(subscriptionRatePlanId);
			ratePlanRemove.setContractEffectiveDate(localDate);
			listRatePlanRemove.add(ratePlanRemove);
		subscriptionAmendments.setRemove(listRatePlanRemove);
		System.out.println("Added type 'remove' for subscription rate plan ID:"+subscriptionRatePlanId);
	
		PUTSubscriptionResponseType response = subscriptionsApi.pUTSubscription(subscriptionId, subscriptionAmendments, null);
		subscriptionToCancel = response.getSubscriptionId();
		System.out.println("Subscription upgrade status:"+response.getSuccess());

		return response.getSubscriptionId();		
	}
	
	public static String getRatePlanFromSubscription(ApiClient apiClient, String subscriptionId) throws ApiException
	{
		SubscriptionsApi subscriptionsApi = new SubscriptionsApi(apiClient);
		System.out.println("Searching for subscription rate plan to remove on subscription ID "+subscriptionId);
		GETSubscriptionTypeWithSuccess subscription = subscriptionsApi.gETOneSubscription(subscriptionId, null);
		System.out.println("Subscription Rate Plan found is:"+subscription.getRatePlans().get(0).getId());
		return subscription.getRatePlans().get(0).getId();
	}
}






