/**
 * Zuora REST API Reference
 *  # Introduction  Welcome to the reference documentation for the Zuora REST API!   [REST](http://en.wikipedia.org/wiki/REST_API \"http://en.wikipedia.org/wiki/REST_API\") is a web-service protocol that lends itself to rapid development by using everyday HTTP and JSON technology. REST offers the following:  *   Easy to use and learn for developers *   Works with virtually any language and platform *   Use case-oriented calls *   Well-suited for solutions that fall outside the traditional desktop application model  The Zuora REST API provides a set of use case-oriented calls that:  *   Enable Web Storefront integration between your websites. *   Support self-service subscriber sign-ups and account management. *   Process revenue schedules through custom revenue rule models.  ## Set up an API User Account  Few setup steps are required to use the Zuora REST API. No special software libraries or development tools are needed. Take a moment to set up an API user account. See [Creating an API](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/AB_Getting_started_with_the__SOAP_API/F_Create_an_API_User) user.  Note that a user role does not have write access to Zuora REST services unless it has the API Write Access permission as described in those instructions.  Use the API user account only for API calls, and avoid using it to log into the Zuora UI. Logging into the UI enables a security feature that periodically expires the account's password, which may eventually cause authentication failures with the API.  ## Authentication  There are three ways to authenticate:  * Use an authorization cookie. The cookie authorizes the user to make calls to the REST API for the duration specified in  **Administration > Security Policies > Session timeout**. The cookie expiration time is reset with this duration after every call to the REST API. To obtain a cookie, call the REST  `connections` resource with the following API user information:     *   ID     *   password     *   entity Id or entity name (Only for [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity \"Multi-entity\"). See \"Entity Id and Entity Name\" below for more information.)  *   Include the following parameters in the request header, which re-authenticates the user with each request:     *   `apiAccessKeyId`     *   `apiSecretAccessKey`     *   `entityId` or `entityName` (Only for [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity \"Multi-entity\"). See \"Entity Id and Entity Name\" below for more information.) *   For CORS-enabled APIs only: Include a 'single-use' token in the request header, which re-authenticates the user with each request. See below for more details.   ## Errors  Responses and error codes are detailed in [Responses and errors](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/3_Responses_and_errors \"Responses and errors\").   ## Entity Id and Entity Name  The `entityId` and `entityName`  parameters are only used for  [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity).  The  `entityId` parameter specifies the Id of the entity that you want to access. The `entityName` parameter specifies the [name of the entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity/B_Introduction_to_Entity_and_Entity_Hierarchy#Name_and_Display_Name \"Introduction to Entity and Entity Hierarchy\") that you want to access. Note that you must have permission to access the entity. You can get the entity Id and entity name through the REST GET Entities call.  You can specify either the  `entityId` or `entityName` parameter in the authentication to access and view an entity.  *   If both `entityId` and `entityName` are specified in the authentication, an error occurs.  *   If neither  `entityId` nor  `entityName` is specified in the authentication, you will log in to the entity in which your user account is created.   See [API User Authentication](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity/A_Overview_of_Multi-entity#API_User_Authentication \"Zuora Multi-entity\") for more information.  ## Token Authentication for CORS-Enabled APIs  The CORS mechanism enables REST API calls to Zuora to be made directly from your customer's browser, with all credit card and security information transmitted directly to Zuora. This minimizes your PCI compliance burden, allows you to implement advanced validation on your payment forms, and makes your payment forms look just like any other part of your website.  For security reasons, instead of using cookies, an API request via CORS uses **tokens** for authentication.  The token method of authentication is only designed for use with requests that must originate from your customer's browser; **it should not be considered a replacement to the existing cookie authentication** mechanism.  See [Zuora CORS REST ](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/G_CORS_REST \"Zuora CORS REST\")for details on how CORS works and how you can begin to implement customer calls to the Zuora REST APIs. See  [HMAC Signatures](/BC_Developers/REST_API/B_REST_API_reference/HMAC_Signatures \"HMAC Signatures\") for details on the HMAC method that returns the authentication token.   ## Zuora REST API Versions  The Zuora REST API is in version control. Versioning ensures that Zuora REST API changes are backward compatible. Zuora uses a major and minor version nomenclature to manage changes. By specifying a version in a REST request, you can get expected responses regardless of future changes to the API.   ### Major Version  The major version number of the REST API appears in the REST URL. Currently, Zuora only supports the **v1** major version. For example,  `POST https://rest.zuora.com/v1/subscriptions` .   ### Minor Version  Zuora uses minor versions for the REST API to control small changes. For example, a field in a REST method is deprecated and a new field is used to replace it.   Some fields in the REST methods are supported as of minor versions. If a field is not noted with a minor version, this field is available for all minor versions. If a field is noted with a minor version, this field is in version control. You must specify the supported minor version in the request header to process without an error.   If a field is in version control, it is either with a minimum minor version or a maximum minor version, or both of them. You can only use this field with the minor version between the minimum and the maximum minor versions. For example, the  `invoiceCollect` field in the POST Subscription method is in version control and its maximum minor version is 189.0. You can only use this field with the minor version 189.0 or earlier.  The supported minor versions are not serial, see [Zuora REST API Minor Version History](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/Zuora_REST_API_Minor_Version_History \"Zuora REST API Minor Version History\") for the fields and their supported minor versions. In our REST API documentation, if a field or feature requires a minor version number, we note that in the field description.  You only need to specify the version number when you use the fields require a minor version. To specify the minor version, set the `zuora-version` parameter to the minor version number in the request header for the request call. For example, the `collect` field is in 196.0 minor version. If you want to use this field for the POST Subscription method, set the  `zuora-version` parameter to `196.0` in the request header. The `zuora-version` parameter is case sensitive.   For all the REST API fields, by default, if the minor version is not specified in the request header, Zuora will use the minimum minor version of the REST API to avoid breaking your integration.    ## URLs and Endpoints  The following REST services are provided in Zuora.  | Service                 | Base URL for REST Endpoints                                                                                                                                         | |-------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------| | Production REST service | https://rest.zuora.com/v1                                                                                                                                           | | Sandbox REST service    | https://rest.apisandbox.zuora.com/v1                                                                                                                                | | Services REST service   | https://services123.zuora.com/apps/v1/  (where \"123\" is replaced by the number of your actual services environment)  The production service provides access to your live user data. The sandbox environment is a good place to test your code without affecting real-world data.  To use it, you must be provisioned with a sandbox tenant - your Zuora representative can help with this if needed.   ## Requests and Responses   ### HTTP Request Body  Most of the parameters and data accompanying your requests will be contained in the body of the HTTP request.  The Zuora REST API accepts JSON in the HTTP request body.  No other data format (e.g., XML) is supported.   #### Testing a Request  Use a third party client, such as Postman or Advanced REST Client, to test the Zuora REST API.  You can test the Zuora REST API from the Zuora sandbox or  production service. If connecting to the production service, bear in mind that you are working with your live production data, not sample data or test data.  #### Testing with Credit Cards  Sooner or later it will probably be necessary to test some transactions that involve credit cards. For suggestions on how to handle this, see [Going Live With Your Payment Gateway](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/C_Managing_Payment_Gateways/B_Going_Live_Payment_Gateways#Testing_with_Credit_Cards \"C_Zuora_User_Guides/A_Billing_and_Payments/M_Payment_Gateways/C_Managing_Payment_Gateways/B_Going_Live_Payment_Gateways#Testing_with_Credit_Cards\").   ## Request IDs  As a general rule, when asked to supply a \"key\" for an account or subscription (accountKey, account-key, subscriptionKey, subscription-key), you can provide either the actual ID or the number of the entity.  ## Pagination  When retrieving information (using GET methods), the optional `pageSize` query parameter sets the maximum number of rows to return in a response. The maximum is `40`; larger values are treated as `40`. If this value is empty or invalid, `pageSize` typically defaults to `10`.  The default value for the maximum number of rows retrieved can be overridden at the method level.  If more rows are available, the response will include a `nextPage` element, which contains a URL for requesting the next page.  If this value is not provided, no more rows are available. No \"previous page\" element is explicitly provided; to support backward paging, use the previous call.  ### Array Size  For data items that are not paginated, the REST API supports arrays of up to 300 rows.  Thus, for instance, repeated pagination can retrieve thousands of customer accounts, but within any account an array of no more than 300 rate plans is returned. 
 *
 * OpenAPI spec version: 0.0.1
 * Contact: docs@zuora.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.GETSubscriptionTypeWithSuccess;
import io.swagger.client.model.GETSubscriptionWrapper;
import io.swagger.client.model.POSTSubscriptionResponseType;
import io.swagger.client.model.POSTSubscriptionType;
import io.swagger.client.model.POSTSubscriptionCancellationType;
import io.swagger.client.model.POSTSubscriptionCancellationResponseType;
import io.swagger.client.model.POSTSubscriptionPreviewResponseType;
import io.swagger.client.model.POSTSubscriptionPreviewType;
import io.swagger.client.model.PUTRenewSubscriptionResponseType;
import io.swagger.client.model.PUTRenewSubscriptionType;
import io.swagger.client.model.PUTSubscriptionType;
import io.swagger.client.model.PUTSubscriptionResponseType;
import io.swagger.client.model.PUTSubscriptionResumeResponseType;
import io.swagger.client.model.PUTSubscriptionResumeType;
import io.swagger.client.model.PUTSubscriptionSuspendResponseType;
import io.swagger.client.model.PUTSubscriptionSuspendType;
import io.swagger.client.model.ProxyDeleteResponse;
import io.swagger.client.model.ProxyGetSubscription;
import io.swagger.client.model.ProxyNoDataResponse;
import io.swagger.client.model.ProxyCreateOrModifyResponse;
import io.swagger.client.model.ProxyBadRequestResponse;
import io.swagger.client.model.ProxyCreateSubscription;
import io.swagger.client.model.ProxyModifySubscription;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SubscriptionsApi
 */
public class SubscriptionsApiTest {

    private final SubscriptionsApi api = new SubscriptionsApi();

    
    /**
     * Get subscriptions by key
     *
     * This REST API reference describes how to retrieve detailed information about a specified subscription in the latest version. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void gETOneSubscriptionTest() throws ApiException {
        String subscriptionKey = null;
        String chargeDetail = null;
        // GETSubscriptionTypeWithSuccess response = api.gETOneSubscription(subscriptionKey, chargeDetail);

        // TODO: test validations
    }
    
    /**
     * Get subscriptions by account
     *
     * Retrieves all subscriptions associated with the specified account. Zuora only returns the latest version of the subscriptions.  Subscription data is returned in reverse chronological order based on &#x60;updatedDate&#x60;. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void gETSubscriptionTest() throws ApiException {
        String accountKey = null;
        String chargeDetail = null;
        // GETSubscriptionWrapper response = api.gETSubscription(accountKey, chargeDetail);

        // TODO: test validations
    }
    
    /**
     * Create subscription
     *
     * This REST API reference describes how to create a new subscription for an existing customer account.  ## Notes If invoiceCollect is &#x60;true&#x60;, the call will not return success &#x3D; &#x60;true&#x60; unless the subscription, invoice, and payment are all successful.  Default values for **customerAcceptanceDate** and **serviceActivationDate** are set as follows.  |        | serviceActivationDate(SA) specified          | serviceActivationDate (SA) NOT specified  | | ------------- |:-------------:| -----:| | customerAcceptanceDate (CA) specified| SA uses value in the request call; CA uses value in the request call| CA uses value in the request call;SA uses CE as default | | customerAcceptanceDate (CA) NOT specified      | SA uses value in the request call; CA uses SA as default |   SA and CA use CE as default | 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pOSTSubscriptionTest() throws ApiException {
        POSTSubscriptionType request = null;
        String zuoraVersion = null;
        // POSTSubscriptionResponseType response = api.pOSTSubscription(request, zuoraVersion);

        // TODO: test validations
    }
    
    /**
     * Cancel subscription
     *
     * This REST API reference describes how to cancel an active subscription. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pOSTSubscriptionCancellationTest() throws ApiException {
        String subscriptionKey = null;
        POSTSubscriptionCancellationType request = null;
        String zuoraVersion = null;
        // POSTSubscriptionCancellationResponseType response = api.pOSTSubscriptionCancellation(subscriptionKey, request, zuoraVersion);

        // TODO: test validations
    }
    
    /**
     * Preview subscription
     *
     * The REST API reference describes how to create a new subscription in preview mode. This call does not require a valid customer account. It can be used to show potential new customers a preview of a subscription with complete details and charges before creating an account, or to let existing customers preview a subscription with all charges before committing.  ## Notes Default values for **customerAcceptanceDate** and **serviceActivationDate** are set as follows.  |        | serviceActivationDate (SA) specified          | serviceActivationDate (SA) NOT specified  | | ------------- |:-------------:| -----:| | customerAcceptanceDate (CA) specified      | SA uses value in the request call; CA uses value in the request call| CA uses value in the request call;SA uses CE as default | | customerAcceptanceDate (CA) NOT specified      | SA uses value in the request call; CA uses SA as default |   SA and CA use CE as default | 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pOSTSubscriptionPreviewTest() throws ApiException {
        POSTSubscriptionPreviewType request = null;
        // POSTSubscriptionPreviewResponseType response = api.pOSTSubscriptionPreview(request);

        // TODO: test validations
    }
    
    /**
     * Renew subscription
     *
     * Renews a termed subscription using existing renewal terms. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pUTRenewSubscriptionTest() throws ApiException {
        String subscriptionKey = null;
        PUTRenewSubscriptionType request = null;
        String zuoraVersion = null;
        // PUTRenewSubscriptionResponseType response = api.pUTRenewSubscription(subscriptionKey, request, zuoraVersion);

        // TODO: test validations
    }
    
    /**
     * Update subscription
     *
     * Use this call to make the following kinds of changes to a subscription:   * Add a note   * Change the renewal term or auto-renewal flag   * Change the term length or change between evergreen and termed   * Add a new product rate plan   * Remove an existing subscription rate plan   * Change the quantity or price of an existing subscription rate plan  ## Notes * The Update Subscription call creates a new subscription, which has the old subscription number but a new subscription ID.  The old subscription is canceled but remains in the system. * In one request, this call can make:   * Up to 9 combined add, update, and remove changes   * No more than 1 change to terms &amp; conditions * Updates are performed in the following sequence:   1. First change the notes on the existing subscription, if requested.   2. Then change the terms and conditions, if requested.   3. Then perform the remaining amendments based upon the effective dates specified. If multiple amendments have the same contract-effective dates, then execute adds before updates, and updates before removes. * The update operation is atomic. If any of the updates fails, the entire operation is rolled back.  ## Override a Tiered Price There are two ways you override a tiered price:  * Override a specific tier number For example: &#x60;tiers[{tier:1,price:8},{tier:2,price:6}]&#x60;  * Override the entire tier structure For example:  &#x60;tiers[{tier:1,price:8,startingUnit:1,endingUnit:100,priceFormat:\&quot;FlatFee\&quot;}, {tier:2,price:6,startingUnit:101,priceFormat:\&quot;FlatFee\&quot;}]&#x60;  If you just override a specific tier, do not include the &#x60;startingUnit&#x60; field in the request. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pUTSubscriptionTest() throws ApiException {
        String subscriptionKey = null;
        PUTSubscriptionType request = null;
        String zuoraVersion = null;
        // PUTSubscriptionResponseType response = api.pUTSubscription(subscriptionKey, request, zuoraVersion);

        // TODO: test validations
    }
    
    /**
     * Resume subscription
     *
     * This REST API reference describes how to resume a suspended subscription.   This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://suport.zuora.com).  
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pUTSubscriptionResumeTest() throws ApiException {
        String subscriptionKey = null;
        PUTSubscriptionResumeType request = null;
        String zuoraVersion = null;
        // PUTSubscriptionResumeResponseType response = api.pUTSubscriptionResume(subscriptionKey, request, zuoraVersion);

        // TODO: test validations
    }
    
    /**
     * Suspend subscription
     *
     * This REST API reference describes how to suspend an active subscription.   This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://suport.zuora.com). 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pUTSubscriptionSuspendTest() throws ApiException {
        String subscriptionKey = null;
        PUTSubscriptionSuspendType request = null;
        String zuoraVersion = null;
        // PUTSubscriptionSuspendResponseType response = api.pUTSubscriptionSuspend(subscriptionKey, request, zuoraVersion);

        // TODO: test validations
    }
    
    /**
     * CRUD: Delete Subscription
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void proxyDELETESubscriptionTest() throws ApiException {
        String id = null;
        // ProxyDeleteResponse response = api.proxyDELETESubscription(id);

        // TODO: test validations
    }
    
    /**
     * CRUD: Retrieve Subscription
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void proxyGETSubscriptionTest() throws ApiException {
        String id = null;
        String fields = null;
        // ProxyGetSubscription response = api.proxyGETSubscription(id, fields);

        // TODO: test validations
    }
    
    /**
     * CRUD: Create Subscription
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void proxyPOSTSubscriptionTest() throws ApiException {
        ProxyCreateSubscription createRequest = null;
        // ProxyCreateOrModifyResponse response = api.proxyPOSTSubscription(createRequest);

        // TODO: test validations
    }
    
    /**
     * CRUD: Update Subscription
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void proxyPUTSubscriptionTest() throws ApiException {
        String id = null;
        ProxyModifySubscription modifyRequest = null;
        // ProxyCreateOrModifyResponse response = api.proxyPUTSubscription(id, modifyRequest);

        // TODO: test validations
    }
    
}
