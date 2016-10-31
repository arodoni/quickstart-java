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


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.GETSubscriptionRatePlanType;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDate;


/**
 * GETSubscriptionTypeWithSuccess
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class GETSubscriptionTypeWithSuccess   {
  @SerializedName("CpqBundleJsonId__QT")
  private String cpqBundleJsonIdQT = null;

  @SerializedName("OpportunityCloseDate__QT")
  private String opportunityCloseDateQT = null;

  @SerializedName("OpportunityName__QT")
  private String opportunityNameQT = null;

  @SerializedName("QuoteBusinessType__QT")
  private String quoteBusinessTypeQT = null;

  @SerializedName("QuoteNumber__QT")
  private String quoteNumberQT = null;

  @SerializedName("QuoteType__QT")
  private String quoteTypeQT = null;

  @SerializedName("accountId")
  private String accountId = null;

  @SerializedName("accountName")
  private String accountName = null;

  @SerializedName("accountNumber")
  private String accountNumber = null;

  @SerializedName("autoRenew")
  private Boolean autoRenew = null;

  @SerializedName("contractEffectiveDate")
  private LocalDate contractEffectiveDate = null;

  @SerializedName("contractedMrr")
  private String contractedMrr = null;

  @SerializedName("currentTerm")
  private Long currentTerm = null;

  @SerializedName("currentTermPeriodType")
  private String currentTermPeriodType = null;

  @SerializedName("customField__c")
  private String customFieldC = null;

  @SerializedName("customerAcceptanceDate")
  private LocalDate customerAcceptanceDate = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("initialTerm")
  private Long initialTerm = null;

  @SerializedName("initialTermPeriodType")
  private String initialTermPeriodType = null;

  @SerializedName("invoiceOwnerAccountId")
  private String invoiceOwnerAccountId = null;

  @SerializedName("invoiceOwnerAccountName")
  private String invoiceOwnerAccountName = null;

  @SerializedName("invoiceOwnerAccountNumber")
  private String invoiceOwnerAccountNumber = null;

  @SerializedName("invoiceSeparately")
  private String invoiceSeparately = null;

  @SerializedName("notes")
  private String notes = null;

  @SerializedName("ratePlans")
  private List<GETSubscriptionRatePlanType> ratePlans = new ArrayList<GETSubscriptionRatePlanType>();

  @SerializedName("renewalSetting")
  private String renewalSetting = null;

  @SerializedName("renewalTerm")
  private Long renewalTerm = null;

  @SerializedName("renewalTermPeriodType")
  private String renewalTermPeriodType = null;

  @SerializedName("serviceActivationDate")
  private LocalDate serviceActivationDate = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("subscriptionNumber")
  private String subscriptionNumber = null;

  @SerializedName("subscriptionStartDate")
  private LocalDate subscriptionStartDate = null;

  @SerializedName("success")
  private Boolean success = null;

  @SerializedName("termEndDate")
  private LocalDate termEndDate = null;

  @SerializedName("termStartDate")
  private LocalDate termStartDate = null;

  @SerializedName("termType")
  private String termType = null;

  @SerializedName("totalContractedValue")
  private String totalContractedValue = null;

  public GETSubscriptionTypeWithSuccess cpqBundleJsonIdQT(String cpqBundleJsonIdQT) {
    this.cpqBundleJsonIdQT = cpqBundleJsonIdQT;
    return this;
  }

   /**
   * 
   * @return cpqBundleJsonIdQT
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getCpqBundleJsonIdQT() {
    return cpqBundleJsonIdQT;
  }

  public void setCpqBundleJsonIdQT(String cpqBundleJsonIdQT) {
    this.cpqBundleJsonIdQT = cpqBundleJsonIdQT;
  }

  public GETSubscriptionTypeWithSuccess opportunityCloseDateQT(String opportunityCloseDateQT) {
    this.opportunityCloseDateQT = opportunityCloseDateQT;
    return this;
  }

   /**
   * The closing date of the Opportunity. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. 
   * @return opportunityCloseDateQT
  **/
  @ApiModelProperty(example = "null", value = "The closing date of the Opportunity. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. ")
  public String getOpportunityCloseDateQT() {
    return opportunityCloseDateQT;
  }

  public void setOpportunityCloseDateQT(String opportunityCloseDateQT) {
    this.opportunityCloseDateQT = opportunityCloseDateQT;
  }

  public GETSubscriptionTypeWithSuccess opportunityNameQT(String opportunityNameQT) {
    this.opportunityNameQT = opportunityNameQT;
    return this;
  }

   /**
   * The unique identifier of the Opportunity. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. 
   * @return opportunityNameQT
  **/
  @ApiModelProperty(example = "null", value = "The unique identifier of the Opportunity. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. ")
  public String getOpportunityNameQT() {
    return opportunityNameQT;
  }

  public void setOpportunityNameQT(String opportunityNameQT) {
    this.opportunityNameQT = opportunityNameQT;
  }

  public GETSubscriptionTypeWithSuccess quoteBusinessTypeQT(String quoteBusinessTypeQT) {
    this.quoteBusinessTypeQT = quoteBusinessTypeQT;
    return this;
  }

   /**
   * The specific identifier for the type of business transaction the Quote represents such as New, Upsell, Downsell, Renewal, or Churn. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. 
   * @return quoteBusinessTypeQT
  **/
  @ApiModelProperty(example = "null", value = "The specific identifier for the type of business transaction the Quote represents such as New, Upsell, Downsell, Renewal, or Churn. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. ")
  public String getQuoteBusinessTypeQT() {
    return quoteBusinessTypeQT;
  }

  public void setQuoteBusinessTypeQT(String quoteBusinessTypeQT) {
    this.quoteBusinessTypeQT = quoteBusinessTypeQT;
  }

  public GETSubscriptionTypeWithSuccess quoteNumberQT(String quoteNumberQT) {
    this.quoteNumberQT = quoteNumberQT;
    return this;
  }

   /**
   * The unique identifier of the Quote. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.  See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. 
   * @return quoteNumberQT
  **/
  @ApiModelProperty(example = "null", value = "The unique identifier of the Quote. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.  See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. ")
  public String getQuoteNumberQT() {
    return quoteNumberQT;
  }

  public void setQuoteNumberQT(String quoteNumberQT) {
    this.quoteNumberQT = quoteNumberQT;
  }

  public GETSubscriptionTypeWithSuccess quoteTypeQT(String quoteTypeQT) {
    this.quoteTypeQT = quoteTypeQT;
    return this;
  }

   /**
   * The Quote type that represents the subscription lifecycle stage such as New, Amendment, Renew or Cancel. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. 
   * @return quoteTypeQT
  **/
  @ApiModelProperty(example = "null", value = "The Quote type that represents the subscription lifecycle stage such as New, Amendment, Renew or Cancel. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. ")
  public String getQuoteTypeQT() {
    return quoteTypeQT;
  }

  public void setQuoteTypeQT(String quoteTypeQT) {
    this.quoteTypeQT = quoteTypeQT;
  }

  public GETSubscriptionTypeWithSuccess accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * 
   * @return accountId
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public GETSubscriptionTypeWithSuccess accountName(String accountName) {
    this.accountName = accountName;
    return this;
  }

   /**
   * 
   * @return accountName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public GETSubscriptionTypeWithSuccess accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

   /**
   * 
   * @return accountNumber
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public GETSubscriptionTypeWithSuccess autoRenew(Boolean autoRenew) {
    this.autoRenew = autoRenew;
    return this;
  }

   /**
   * If `true`, the subscription automatically renews at the end of the term. Default is `false`. 
   * @return autoRenew
  **/
  @ApiModelProperty(example = "null", value = "If `true`, the subscription automatically renews at the end of the term. Default is `false`. ")
  public Boolean getAutoRenew() {
    return autoRenew;
  }

  public void setAutoRenew(Boolean autoRenew) {
    this.autoRenew = autoRenew;
  }

  public GETSubscriptionTypeWithSuccess contractEffectiveDate(LocalDate contractEffectiveDate) {
    this.contractEffectiveDate = contractEffectiveDate;
    return this;
  }

   /**
   * Effective contract date for this subscription, as yyyy-mm-dd. 
   * @return contractEffectiveDate
  **/
  @ApiModelProperty(example = "null", value = "Effective contract date for this subscription, as yyyy-mm-dd. ")
  public LocalDate getContractEffectiveDate() {
    return contractEffectiveDate;
  }

  public void setContractEffectiveDate(LocalDate contractEffectiveDate) {
    this.contractEffectiveDate = contractEffectiveDate;
  }

  public GETSubscriptionTypeWithSuccess contractedMrr(String contractedMrr) {
    this.contractedMrr = contractedMrr;
    return this;
  }

   /**
   * Monthly recurring revenue of the subscription. 
   * @return contractedMrr
  **/
  @ApiModelProperty(example = "null", value = "Monthly recurring revenue of the subscription. ")
  public String getContractedMrr() {
    return contractedMrr;
  }

  public void setContractedMrr(String contractedMrr) {
    this.contractedMrr = contractedMrr;
  }

  public GETSubscriptionTypeWithSuccess currentTerm(Long currentTerm) {
    this.currentTerm = currentTerm;
    return this;
  }

   /**
   * The length of the period for the current subscription term. 
   * @return currentTerm
  **/
  @ApiModelProperty(example = "null", value = "The length of the period for the current subscription term. ")
  public Long getCurrentTerm() {
    return currentTerm;
  }

  public void setCurrentTerm(Long currentTerm) {
    this.currentTerm = currentTerm;
  }

  public GETSubscriptionTypeWithSuccess currentTermPeriodType(String currentTermPeriodType) {
    this.currentTermPeriodType = currentTermPeriodType;
    return this;
  }

   /**
   * The period type for the current subscription term.  Values are:  * `Month` (default) * `Year` * `Day` * `Week` 
   * @return currentTermPeriodType
  **/
  @ApiModelProperty(example = "null", value = "The period type for the current subscription term.  Values are:  * `Month` (default) * `Year` * `Day` * `Week` ")
  public String getCurrentTermPeriodType() {
    return currentTermPeriodType;
  }

  public void setCurrentTermPeriodType(String currentTermPeriodType) {
    this.currentTermPeriodType = currentTermPeriodType;
  }

  public GETSubscriptionTypeWithSuccess customFieldC(String customFieldC) {
    this.customFieldC = customFieldC;
    return this;
  }

   /**
   * Any custom fields defined for this object. 
   * @return customFieldC
  **/
  @ApiModelProperty(example = "null", value = "Any custom fields defined for this object. ")
  public String getCustomFieldC() {
    return customFieldC;
  }

  public void setCustomFieldC(String customFieldC) {
    this.customFieldC = customFieldC;
  }

  public GETSubscriptionTypeWithSuccess customerAcceptanceDate(LocalDate customerAcceptanceDate) {
    this.customerAcceptanceDate = customerAcceptanceDate;
    return this;
  }

   /**
   * The date on which the services or products within a subscription have been accepted by the customer, as yyyy-mm-dd. 
   * @return customerAcceptanceDate
  **/
  @ApiModelProperty(example = "null", value = "The date on which the services or products within a subscription have been accepted by the customer, as yyyy-mm-dd. ")
  public LocalDate getCustomerAcceptanceDate() {
    return customerAcceptanceDate;
  }

  public void setCustomerAcceptanceDate(LocalDate customerAcceptanceDate) {
    this.customerAcceptanceDate = customerAcceptanceDate;
  }

  public GETSubscriptionTypeWithSuccess id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Subscription ID. 
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "Subscription ID. ")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GETSubscriptionTypeWithSuccess initialTerm(Long initialTerm) {
    this.initialTerm = initialTerm;
    return this;
  }

   /**
   * The length of the period for the first subscription term. 
   * @return initialTerm
  **/
  @ApiModelProperty(example = "null", value = "The length of the period for the first subscription term. ")
  public Long getInitialTerm() {
    return initialTerm;
  }

  public void setInitialTerm(Long initialTerm) {
    this.initialTerm = initialTerm;
  }

  public GETSubscriptionTypeWithSuccess initialTermPeriodType(String initialTermPeriodType) {
    this.initialTermPeriodType = initialTermPeriodType;
    return this;
  }

   /**
   * The period type for the first subscription term.  Values are:  * `Month` (default) * `Year` * `Day` * `Week` 
   * @return initialTermPeriodType
  **/
  @ApiModelProperty(example = "null", value = "The period type for the first subscription term.  Values are:  * `Month` (default) * `Year` * `Day` * `Week` ")
  public String getInitialTermPeriodType() {
    return initialTermPeriodType;
  }

  public void setInitialTermPeriodType(String initialTermPeriodType) {
    this.initialTermPeriodType = initialTermPeriodType;
  }

  public GETSubscriptionTypeWithSuccess invoiceOwnerAccountId(String invoiceOwnerAccountId) {
    this.invoiceOwnerAccountId = invoiceOwnerAccountId;
    return this;
  }

   /**
   * 
   * @return invoiceOwnerAccountId
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getInvoiceOwnerAccountId() {
    return invoiceOwnerAccountId;
  }

  public void setInvoiceOwnerAccountId(String invoiceOwnerAccountId) {
    this.invoiceOwnerAccountId = invoiceOwnerAccountId;
  }

  public GETSubscriptionTypeWithSuccess invoiceOwnerAccountName(String invoiceOwnerAccountName) {
    this.invoiceOwnerAccountName = invoiceOwnerAccountName;
    return this;
  }

   /**
   * 
   * @return invoiceOwnerAccountName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getInvoiceOwnerAccountName() {
    return invoiceOwnerAccountName;
  }

  public void setInvoiceOwnerAccountName(String invoiceOwnerAccountName) {
    this.invoiceOwnerAccountName = invoiceOwnerAccountName;
  }

  public GETSubscriptionTypeWithSuccess invoiceOwnerAccountNumber(String invoiceOwnerAccountNumber) {
    this.invoiceOwnerAccountNumber = invoiceOwnerAccountNumber;
    return this;
  }

   /**
   * 
   * @return invoiceOwnerAccountNumber
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getInvoiceOwnerAccountNumber() {
    return invoiceOwnerAccountNumber;
  }

  public void setInvoiceOwnerAccountNumber(String invoiceOwnerAccountNumber) {
    this.invoiceOwnerAccountNumber = invoiceOwnerAccountNumber;
  }

  public GETSubscriptionTypeWithSuccess invoiceSeparately(String invoiceSeparately) {
    this.invoiceSeparately = invoiceSeparately;
    return this;
  }

   /**
   * Separates a single subscription from other subscriptions and creates an invoice for the subscription.   If the value is `true`, the subscription is billed separately from other subscriptions. If the value is `false`, the subscription is included with other subscriptions in the account invoice. 
   * @return invoiceSeparately
  **/
  @ApiModelProperty(example = "null", value = "Separates a single subscription from other subscriptions and creates an invoice for the subscription.   If the value is `true`, the subscription is billed separately from other subscriptions. If the value is `false`, the subscription is included with other subscriptions in the account invoice. ")
  public String getInvoiceSeparately() {
    return invoiceSeparately;
  }

  public void setInvoiceSeparately(String invoiceSeparately) {
    this.invoiceSeparately = invoiceSeparately;
  }

  public GETSubscriptionTypeWithSuccess notes(String notes) {
    this.notes = notes;
    return this;
  }

   /**
   * A string of up to 65,535 characters. 
   * @return notes
  **/
  @ApiModelProperty(example = "null", value = "A string of up to 65,535 characters. ")
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public GETSubscriptionTypeWithSuccess ratePlans(List<GETSubscriptionRatePlanType> ratePlans) {
    this.ratePlans = ratePlans;
    return this;
  }

  public GETSubscriptionTypeWithSuccess addRatePlansItem(GETSubscriptionRatePlanType ratePlansItem) {
    this.ratePlans.add(ratePlansItem);
    return this;
  }

   /**
   * Container for rate plans. 
   * @return ratePlans
  **/
  @ApiModelProperty(example = "null", value = "Container for rate plans. ")
  public List<GETSubscriptionRatePlanType> getRatePlans() {
    return ratePlans;
  }

  public void setRatePlans(List<GETSubscriptionRatePlanType> ratePlans) {
    this.ratePlans = ratePlans;
  }

  public GETSubscriptionTypeWithSuccess renewalSetting(String renewalSetting) {
    this.renewalSetting = renewalSetting;
    return this;
  }

   /**
   * Specifies whether a termed subscription will remain `TERMED` or change to `EVERGREEN` when it is renewed.   Values are:  * `RENEW_WITH_SPECIFIC_TERM` (default) * `RENEW_TO_EVERGREEN` 
   * @return renewalSetting
  **/
  @ApiModelProperty(example = "null", value = "Specifies whether a termed subscription will remain `TERMED` or change to `EVERGREEN` when it is renewed.   Values are:  * `RENEW_WITH_SPECIFIC_TERM` (default) * `RENEW_TO_EVERGREEN` ")
  public String getRenewalSetting() {
    return renewalSetting;
  }

  public void setRenewalSetting(String renewalSetting) {
    this.renewalSetting = renewalSetting;
  }

  public GETSubscriptionTypeWithSuccess renewalTerm(Long renewalTerm) {
    this.renewalTerm = renewalTerm;
    return this;
  }

   /**
   * The length of the period for the subscription renewal term. 
   * @return renewalTerm
  **/
  @ApiModelProperty(example = "null", value = "The length of the period for the subscription renewal term. ")
  public Long getRenewalTerm() {
    return renewalTerm;
  }

  public void setRenewalTerm(Long renewalTerm) {
    this.renewalTerm = renewalTerm;
  }

  public GETSubscriptionTypeWithSuccess renewalTermPeriodType(String renewalTermPeriodType) {
    this.renewalTermPeriodType = renewalTermPeriodType;
    return this;
  }

   /**
   * The period type for the subscription renewal term.  Values are:  * `Month` (default) * `Year` * `Day` * `Week` 
   * @return renewalTermPeriodType
  **/
  @ApiModelProperty(example = "null", value = "The period type for the subscription renewal term.  Values are:  * `Month` (default) * `Year` * `Day` * `Week` ")
  public String getRenewalTermPeriodType() {
    return renewalTermPeriodType;
  }

  public void setRenewalTermPeriodType(String renewalTermPeriodType) {
    this.renewalTermPeriodType = renewalTermPeriodType;
  }

  public GETSubscriptionTypeWithSuccess serviceActivationDate(LocalDate serviceActivationDate) {
    this.serviceActivationDate = serviceActivationDate;
    return this;
  }

   /**
   * The date on which the services or products within a subscription have been activated and access has been provided to the customer, as yyyy-mm-dd 
   * @return serviceActivationDate
  **/
  @ApiModelProperty(example = "null", value = "The date on which the services or products within a subscription have been activated and access has been provided to the customer, as yyyy-mm-dd ")
  public LocalDate getServiceActivationDate() {
    return serviceActivationDate;
  }

  public void setServiceActivationDate(LocalDate serviceActivationDate) {
    this.serviceActivationDate = serviceActivationDate;
  }

  public GETSubscriptionTypeWithSuccess status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Subscription status; possible values are:  * `Draft` * `PendingActivation` * `PendingAcceptance` * `Active` * `Cancelled` * `Suspended` (This value is in Limited Availability.) 
   * @return status
  **/
  @ApiModelProperty(example = "null", value = "Subscription status; possible values are:  * `Draft` * `PendingActivation` * `PendingAcceptance` * `Active` * `Cancelled` * `Suspended` (This value is in Limited Availability.) ")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public GETSubscriptionTypeWithSuccess subscriptionNumber(String subscriptionNumber) {
    this.subscriptionNumber = subscriptionNumber;
    return this;
  }

   /**
   * 
   * @return subscriptionNumber
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getSubscriptionNumber() {
    return subscriptionNumber;
  }

  public void setSubscriptionNumber(String subscriptionNumber) {
    this.subscriptionNumber = subscriptionNumber;
  }

  public GETSubscriptionTypeWithSuccess subscriptionStartDate(LocalDate subscriptionStartDate) {
    this.subscriptionStartDate = subscriptionStartDate;
    return this;
  }

   /**
   * Date the subscription becomes effective. 
   * @return subscriptionStartDate
  **/
  @ApiModelProperty(example = "null", value = "Date the subscription becomes effective. ")
  public LocalDate getSubscriptionStartDate() {
    return subscriptionStartDate;
  }

  public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
    this.subscriptionStartDate = subscriptionStartDate;
  }

  public GETSubscriptionTypeWithSuccess success(Boolean success) {
    this.success = success;
    return this;
  }

   /**
   * Returns `true` if the request was processed successfully. 
   * @return success
  **/
  @ApiModelProperty(example = "null", value = "Returns `true` if the request was processed successfully. ")
  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public GETSubscriptionTypeWithSuccess termEndDate(LocalDate termEndDate) {
    this.termEndDate = termEndDate;
    return this;
  }

   /**
   * Date the subscription term ends. If the subscription is evergreen, this is null or is the cancellation date (if one has been set). 
   * @return termEndDate
  **/
  @ApiModelProperty(example = "null", value = "Date the subscription term ends. If the subscription is evergreen, this is null or is the cancellation date (if one has been set). ")
  public LocalDate getTermEndDate() {
    return termEndDate;
  }

  public void setTermEndDate(LocalDate termEndDate) {
    this.termEndDate = termEndDate;
  }

  public GETSubscriptionTypeWithSuccess termStartDate(LocalDate termStartDate) {
    this.termStartDate = termStartDate;
    return this;
  }

   /**
   * Date the subscription term begins. If this is a renewal subscription, this date is different from the subscription start date. 
   * @return termStartDate
  **/
  @ApiModelProperty(example = "null", value = "Date the subscription term begins. If this is a renewal subscription, this date is different from the subscription start date. ")
  public LocalDate getTermStartDate() {
    return termStartDate;
  }

  public void setTermStartDate(LocalDate termStartDate) {
    this.termStartDate = termStartDate;
  }

  public GETSubscriptionTypeWithSuccess termType(String termType) {
    this.termType = termType;
    return this;
  }

   /**
   * Possible values are: `TERMED`, `EVERGREEN`. 
   * @return termType
  **/
  @ApiModelProperty(example = "null", value = "Possible values are: `TERMED`, `EVERGREEN`. ")
  public String getTermType() {
    return termType;
  }

  public void setTermType(String termType) {
    this.termType = termType;
  }

  public GETSubscriptionTypeWithSuccess totalContractedValue(String totalContractedValue) {
    this.totalContractedValue = totalContractedValue;
    return this;
  }

   /**
   * Total contracted value of the subscription. 
   * @return totalContractedValue
  **/
  @ApiModelProperty(example = "null", value = "Total contracted value of the subscription. ")
  public String getTotalContractedValue() {
    return totalContractedValue;
  }

  public void setTotalContractedValue(String totalContractedValue) {
    this.totalContractedValue = totalContractedValue;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GETSubscriptionTypeWithSuccess gETSubscriptionTypeWithSuccess = (GETSubscriptionTypeWithSuccess) o;
    return Objects.equals(this.cpqBundleJsonIdQT, gETSubscriptionTypeWithSuccess.cpqBundleJsonIdQT) &&
        Objects.equals(this.opportunityCloseDateQT, gETSubscriptionTypeWithSuccess.opportunityCloseDateQT) &&
        Objects.equals(this.opportunityNameQT, gETSubscriptionTypeWithSuccess.opportunityNameQT) &&
        Objects.equals(this.quoteBusinessTypeQT, gETSubscriptionTypeWithSuccess.quoteBusinessTypeQT) &&
        Objects.equals(this.quoteNumberQT, gETSubscriptionTypeWithSuccess.quoteNumberQT) &&
        Objects.equals(this.quoteTypeQT, gETSubscriptionTypeWithSuccess.quoteTypeQT) &&
        Objects.equals(this.accountId, gETSubscriptionTypeWithSuccess.accountId) &&
        Objects.equals(this.accountName, gETSubscriptionTypeWithSuccess.accountName) &&
        Objects.equals(this.accountNumber, gETSubscriptionTypeWithSuccess.accountNumber) &&
        Objects.equals(this.autoRenew, gETSubscriptionTypeWithSuccess.autoRenew) &&
        Objects.equals(this.contractEffectiveDate, gETSubscriptionTypeWithSuccess.contractEffectiveDate) &&
        Objects.equals(this.contractedMrr, gETSubscriptionTypeWithSuccess.contractedMrr) &&
        Objects.equals(this.currentTerm, gETSubscriptionTypeWithSuccess.currentTerm) &&
        Objects.equals(this.currentTermPeriodType, gETSubscriptionTypeWithSuccess.currentTermPeriodType) &&
        Objects.equals(this.customFieldC, gETSubscriptionTypeWithSuccess.customFieldC) &&
        Objects.equals(this.customerAcceptanceDate, gETSubscriptionTypeWithSuccess.customerAcceptanceDate) &&
        Objects.equals(this.id, gETSubscriptionTypeWithSuccess.id) &&
        Objects.equals(this.initialTerm, gETSubscriptionTypeWithSuccess.initialTerm) &&
        Objects.equals(this.initialTermPeriodType, gETSubscriptionTypeWithSuccess.initialTermPeriodType) &&
        Objects.equals(this.invoiceOwnerAccountId, gETSubscriptionTypeWithSuccess.invoiceOwnerAccountId) &&
        Objects.equals(this.invoiceOwnerAccountName, gETSubscriptionTypeWithSuccess.invoiceOwnerAccountName) &&
        Objects.equals(this.invoiceOwnerAccountNumber, gETSubscriptionTypeWithSuccess.invoiceOwnerAccountNumber) &&
        Objects.equals(this.invoiceSeparately, gETSubscriptionTypeWithSuccess.invoiceSeparately) &&
        Objects.equals(this.notes, gETSubscriptionTypeWithSuccess.notes) &&
        Objects.equals(this.ratePlans, gETSubscriptionTypeWithSuccess.ratePlans) &&
        Objects.equals(this.renewalSetting, gETSubscriptionTypeWithSuccess.renewalSetting) &&
        Objects.equals(this.renewalTerm, gETSubscriptionTypeWithSuccess.renewalTerm) &&
        Objects.equals(this.renewalTermPeriodType, gETSubscriptionTypeWithSuccess.renewalTermPeriodType) &&
        Objects.equals(this.serviceActivationDate, gETSubscriptionTypeWithSuccess.serviceActivationDate) &&
        Objects.equals(this.status, gETSubscriptionTypeWithSuccess.status) &&
        Objects.equals(this.subscriptionNumber, gETSubscriptionTypeWithSuccess.subscriptionNumber) &&
        Objects.equals(this.subscriptionStartDate, gETSubscriptionTypeWithSuccess.subscriptionStartDate) &&
        Objects.equals(this.success, gETSubscriptionTypeWithSuccess.success) &&
        Objects.equals(this.termEndDate, gETSubscriptionTypeWithSuccess.termEndDate) &&
        Objects.equals(this.termStartDate, gETSubscriptionTypeWithSuccess.termStartDate) &&
        Objects.equals(this.termType, gETSubscriptionTypeWithSuccess.termType) &&
        Objects.equals(this.totalContractedValue, gETSubscriptionTypeWithSuccess.totalContractedValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cpqBundleJsonIdQT, opportunityCloseDateQT, opportunityNameQT, quoteBusinessTypeQT, quoteNumberQT, quoteTypeQT, accountId, accountName, accountNumber, autoRenew, contractEffectiveDate, contractedMrr, currentTerm, currentTermPeriodType, customFieldC, customerAcceptanceDate, id, initialTerm, initialTermPeriodType, invoiceOwnerAccountId, invoiceOwnerAccountName, invoiceOwnerAccountNumber, invoiceSeparately, notes, ratePlans, renewalSetting, renewalTerm, renewalTermPeriodType, serviceActivationDate, status, subscriptionNumber, subscriptionStartDate, success, termEndDate, termStartDate, termType, totalContractedValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GETSubscriptionTypeWithSuccess {\n");
    
    sb.append("    cpqBundleJsonIdQT: ").append(toIndentedString(cpqBundleJsonIdQT)).append("\n");
    sb.append("    opportunityCloseDateQT: ").append(toIndentedString(opportunityCloseDateQT)).append("\n");
    sb.append("    opportunityNameQT: ").append(toIndentedString(opportunityNameQT)).append("\n");
    sb.append("    quoteBusinessTypeQT: ").append(toIndentedString(quoteBusinessTypeQT)).append("\n");
    sb.append("    quoteNumberQT: ").append(toIndentedString(quoteNumberQT)).append("\n");
    sb.append("    quoteTypeQT: ").append(toIndentedString(quoteTypeQT)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    autoRenew: ").append(toIndentedString(autoRenew)).append("\n");
    sb.append("    contractEffectiveDate: ").append(toIndentedString(contractEffectiveDate)).append("\n");
    sb.append("    contractedMrr: ").append(toIndentedString(contractedMrr)).append("\n");
    sb.append("    currentTerm: ").append(toIndentedString(currentTerm)).append("\n");
    sb.append("    currentTermPeriodType: ").append(toIndentedString(currentTermPeriodType)).append("\n");
    sb.append("    customFieldC: ").append(toIndentedString(customFieldC)).append("\n");
    sb.append("    customerAcceptanceDate: ").append(toIndentedString(customerAcceptanceDate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    initialTerm: ").append(toIndentedString(initialTerm)).append("\n");
    sb.append("    initialTermPeriodType: ").append(toIndentedString(initialTermPeriodType)).append("\n");
    sb.append("    invoiceOwnerAccountId: ").append(toIndentedString(invoiceOwnerAccountId)).append("\n");
    sb.append("    invoiceOwnerAccountName: ").append(toIndentedString(invoiceOwnerAccountName)).append("\n");
    sb.append("    invoiceOwnerAccountNumber: ").append(toIndentedString(invoiceOwnerAccountNumber)).append("\n");
    sb.append("    invoiceSeparately: ").append(toIndentedString(invoiceSeparately)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    ratePlans: ").append(toIndentedString(ratePlans)).append("\n");
    sb.append("    renewalSetting: ").append(toIndentedString(renewalSetting)).append("\n");
    sb.append("    renewalTerm: ").append(toIndentedString(renewalTerm)).append("\n");
    sb.append("    renewalTermPeriodType: ").append(toIndentedString(renewalTermPeriodType)).append("\n");
    sb.append("    serviceActivationDate: ").append(toIndentedString(serviceActivationDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    subscriptionNumber: ").append(toIndentedString(subscriptionNumber)).append("\n");
    sb.append("    subscriptionStartDate: ").append(toIndentedString(subscriptionStartDate)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    termEndDate: ").append(toIndentedString(termEndDate)).append("\n");
    sb.append("    termStartDate: ").append(toIndentedString(termStartDate)).append("\n");
    sb.append("    termType: ").append(toIndentedString(termType)).append("\n");
    sb.append("    totalContractedValue: ").append(toIndentedString(totalContractedValue)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

