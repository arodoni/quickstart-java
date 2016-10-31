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
import org.joda.time.LocalDate;


/**
 * ProxyCreateSubscription
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class ProxyCreateSubscription   {
  @SerializedName("AccountId")
  private String accountId = null;

  @SerializedName("AutoRenew")
  private Boolean autoRenew = null;

  @SerializedName("CancelledDate")
  private LocalDate cancelledDate = null;

  @SerializedName("ContractAcceptanceDate")
  private LocalDate contractAcceptanceDate = null;

  @SerializedName("ContractEffectiveDate")
  private LocalDate contractEffectiveDate = null;

  @SerializedName("CpqBundleJsonId__QT")
  private String cpqBundleJsonIdQT = null;

  @SerializedName("CurrentTermPeriodType")
  private String currentTermPeriodType = null;

  @SerializedName("InitialTerm")
  private Integer initialTerm = null;

  @SerializedName("InitialTermPeriodType")
  private String initialTermPeriodType = null;

  @SerializedName("InvoiceOwnerId")
  private String invoiceOwnerId = null;

  @SerializedName("IsInvoiceSeparate")
  private Boolean isInvoiceSeparate = null;

  @SerializedName("Name")
  private String name = null;

  @SerializedName("Notes")
  private String notes = null;

  @SerializedName("OpportunityCloseDate__QT")
  private LocalDate opportunityCloseDateQT = null;

  @SerializedName("OpportunityName__QT")
  private String opportunityNameQT = null;

  @SerializedName("QuoteBusinessType__QT")
  private String quoteBusinessTypeQT = null;

  @SerializedName("QuoteNumber__QT")
  private String quoteNumberQT = null;

  @SerializedName("QuoteType__QT")
  private String quoteTypeQT = null;

  @SerializedName("RenewalSetting")
  private String renewalSetting = null;

  @SerializedName("RenewalTerm")
  private Integer renewalTerm = null;

  @SerializedName("RenewalTermPeriodType")
  private String renewalTermPeriodType = null;

  @SerializedName("ServiceActivationDate")
  private LocalDate serviceActivationDate = null;

  @SerializedName("Status")
  private String status = null;

  @SerializedName("TermStartDate")
  private LocalDate termStartDate = null;

  @SerializedName("TermType")
  private String termType = null;

  @SerializedName("Version")
  private Integer version = null;

  public ProxyCreateSubscription accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   *  This field can be updated when **Status** is `Draft`. The ID of the [a valid account ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account) 
   * @return accountId
  **/
  @ApiModelProperty(example = "null", required = true, value = " This field can be updated when **Status** is `Draft`. The ID of the [a valid account ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account) ")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public ProxyCreateSubscription autoRenew(Boolean autoRenew) {
    this.autoRenew = autoRenew;
    return this;
  }

   /**
   *  This field can be updated when **Status** is `Draft`. Indicates if the subscription automatically renews at the end of the term. **Values**: `true`, `false` 
   * @return autoRenew
  **/
  @ApiModelProperty(example = "null", value = " This field can be updated when **Status** is `Draft`. Indicates if the subscription automatically renews at the end of the term. **Values**: `true`, `false` ")
  public Boolean getAutoRenew() {
    return autoRenew;
  }

  public void setAutoRenew(Boolean autoRenew) {
    this.autoRenew = autoRenew;
  }

  public ProxyCreateSubscription cancelledDate(LocalDate cancelledDate) {
    this.cancelledDate = cancelledDate;
    return this;
  }

   /**
   *  The date of the [Amendment object](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Amendment) that canceled the subscription. **Values**: inherited from `Amendment.EffectiveDate` 
   * @return cancelledDate
  **/
  @ApiModelProperty(example = "null", value = " The date of the [Amendment object](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Amendment) that canceled the subscription. **Values**: inherited from `Amendment.EffectiveDate` ")
  public LocalDate getCancelledDate() {
    return cancelledDate;
  }

  public void setCancelledDate(LocalDate cancelledDate) {
    this.cancelledDate = cancelledDate;
  }

  public ProxyCreateSubscription contractAcceptanceDate(LocalDate contractAcceptanceDate) {
    this.contractAcceptanceDate = contractAcceptanceDate;
    return this;
  }

   /**
   *  The date when the customer accepts the contract. This field can be updated when **Status** is `Draft`. **Note**: The service activation date is only required if the [Require Service Activation of Orders?](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Default_Subscription_Settings#Require_Service_Activation_of_Orders.3F) Setting is set to `Yes`. If this setting is set to `Yes`:  - If ContractAcceptanceDate field is required, you must set this field, ContractAcceptanceDate, and ContractEffectiveDate fields in the subscribe call to activate a subscription. - If ContractAcceptanceDate field is not required, you must set both this field and the ContractEffectiveDate field in the subscribe call to activate a subscription. If you only set a valid date in the ContractEffectiveDate field, the subscribe call still returns success, but the subscription is in `DRAT` status. 
   * @return contractAcceptanceDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the customer accepts the contract. This field can be updated when **Status** is `Draft`. **Note**: The service activation date is only required if the [Require Service Activation of Orders?](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Default_Subscription_Settings#Require_Service_Activation_of_Orders.3F) Setting is set to `Yes`. If this setting is set to `Yes`:  - If ContractAcceptanceDate field is required, you must set this field, ContractAcceptanceDate, and ContractEffectiveDate fields in the subscribe call to activate a subscription. - If ContractAcceptanceDate field is not required, you must set both this field and the ContractEffectiveDate field in the subscribe call to activate a subscription. If you only set a valid date in the ContractEffectiveDate field, the subscribe call still returns success, but the subscription is in `DRAT` status. ")
  public LocalDate getContractAcceptanceDate() {
    return contractAcceptanceDate;
  }

  public void setContractAcceptanceDate(LocalDate contractAcceptanceDate) {
    this.contractAcceptanceDate = contractAcceptanceDate;
  }

  public ProxyCreateSubscription contractEffectiveDate(LocalDate contractEffectiveDate) {
    this.contractEffectiveDate = contractEffectiveDate;
    return this;
  }

   /**
   *  The date when the contract takes effect. This field can be updated when **Status** is `Draft`. **Note**: This field is required in the subscribe call. If you set the value of this field to null and both the ServiceActivationDate and ContractAcceptanceDate fields are not required, the subscribe call still returns success, but the new subscription is in `DRAFT` status. To activate the subscription, you must set a valid date to this field. 
   * @return contractEffectiveDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the contract takes effect. This field can be updated when **Status** is `Draft`. **Note**: This field is required in the subscribe call. If you set the value of this field to null and both the ServiceActivationDate and ContractAcceptanceDate fields are not required, the subscribe call still returns success, but the new subscription is in `DRAFT` status. To activate the subscription, you must set a valid date to this field. ")
  public LocalDate getContractEffectiveDate() {
    return contractEffectiveDate;
  }

  public void setContractEffectiveDate(LocalDate contractEffectiveDate) {
    this.contractEffectiveDate = contractEffectiveDate;
  }

  public ProxyCreateSubscription cpqBundleJsonIdQT(String cpqBundleJsonIdQT) {
    this.cpqBundleJsonIdQT = cpqBundleJsonIdQT;
    return this;
  }

   /**
   *  The Bundle product structures from Zuora Quotes if you utilize Bundling in Salesforce. Do not change the value in this field. **Character limit**: 32 **Values**: N/A 
   * @return cpqBundleJsonIdQT
  **/
  @ApiModelProperty(example = "null", value = " The Bundle product structures from Zuora Quotes if you utilize Bundling in Salesforce. Do not change the value in this field. **Character limit**: 32 **Values**: N/A ")
  public String getCpqBundleJsonIdQT() {
    return cpqBundleJsonIdQT;
  }

  public void setCpqBundleJsonIdQT(String cpqBundleJsonIdQT) {
    this.cpqBundleJsonIdQT = cpqBundleJsonIdQT;
  }

  public ProxyCreateSubscription currentTermPeriodType(String currentTermPeriodType) {
    this.currentTermPeriodType = currentTermPeriodType;
    return this;
  }

   /**
   *  The period type for the current subscription term. This field is used with the CurrentTerm field to specify the current subscription term. **Values**:  - `Month` (default) - `Year` - `Day` - `Week` 
   * @return currentTermPeriodType
  **/
  @ApiModelProperty(example = "null", value = " The period type for the current subscription term. This field is used with the CurrentTerm field to specify the current subscription term. **Values**:  - `Month` (default) - `Year` - `Day` - `Week` ")
  public String getCurrentTermPeriodType() {
    return currentTermPeriodType;
  }

  public void setCurrentTermPeriodType(String currentTermPeriodType) {
    this.currentTermPeriodType = currentTermPeriodType;
  }

  public ProxyCreateSubscription initialTerm(Integer initialTerm) {
    this.initialTerm = initialTerm;
    return this;
  }

   /**
   *  The length of the period for the first subscription term. This field can be updated when Status is `Draft`. If you use the subscribe() call, this field is required. **Required**: If TermType is Termed **Character limit**: 20 **Values**: any valid number. The default value is 0. 
   * @return initialTerm
  **/
  @ApiModelProperty(example = "null", value = " The length of the period for the first subscription term. This field can be updated when Status is `Draft`. If you use the subscribe() call, this field is required. **Required**: If TermType is Termed **Character limit**: 20 **Values**: any valid number. The default value is 0. ")
  public Integer getInitialTerm() {
    return initialTerm;
  }

  public void setInitialTerm(Integer initialTerm) {
    this.initialTerm = initialTerm;
  }

  public ProxyCreateSubscription initialTermPeriodType(String initialTermPeriodType) {
    this.initialTermPeriodType = initialTermPeriodType;
    return this;
  }

   /**
   *  The period type for the first subscription term. **Values**:  - `Month` (default) - `Year` - `Day` - `Week` **Note**:  - This field can be updated when Status is `Draft`. - This field is used with the InitialTerm field to specify the initial subscription term. 
   * @return initialTermPeriodType
  **/
  @ApiModelProperty(example = "null", value = " The period type for the first subscription term. **Values**:  - `Month` (default) - `Year` - `Day` - `Week` **Note**:  - This field can be updated when Status is `Draft`. - This field is used with the InitialTerm field to specify the initial subscription term. ")
  public String getInitialTermPeriodType() {
    return initialTermPeriodType;
  }

  public void setInitialTermPeriodType(String initialTermPeriodType) {
    this.initialTermPeriodType = initialTermPeriodType;
  }

  public ProxyCreateSubscription invoiceOwnerId(String invoiceOwnerId) {
    this.invoiceOwnerId = invoiceOwnerId;
    return this;
  }

   /**
   *  This field can be updated when **Status** is `Draft`. The [a valid account ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account) 
   * @return invoiceOwnerId
  **/
  @ApiModelProperty(example = "null", required = true, value = " This field can be updated when **Status** is `Draft`. The [a valid account ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account) ")
  public String getInvoiceOwnerId() {
    return invoiceOwnerId;
  }

  public void setInvoiceOwnerId(String invoiceOwnerId) {
    this.invoiceOwnerId = invoiceOwnerId;
  }

  public ProxyCreateSubscription isInvoiceSeparate(Boolean isInvoiceSeparate) {
    this.isInvoiceSeparate = isInvoiceSeparate;
    return this;
  }

   /**
   *  Determines if the subscription is invoiced separately. If `TRUE`, then all charges for this subscription are collected into the subscription's own invoice. **V****alues**: `TRUE`, `FALSE `(default) 
   * @return isInvoiceSeparate
  **/
  @ApiModelProperty(example = "null", value = " Determines if the subscription is invoiced separately. If `TRUE`, then all charges for this subscription are collected into the subscription's own invoice. **V****alues**: `TRUE`, `FALSE `(default) ")
  public Boolean getIsInvoiceSeparate() {
    return isInvoiceSeparate;
  }

  public void setIsInvoiceSeparate(Boolean isInvoiceSeparate) {
    this.isInvoiceSeparate = isInvoiceSeparate;
  }

  public ProxyCreateSubscription name(String name) {
    this.name = name;
    return this;
  }

   /**
   *  The unique identifier of the subscription. If you don't specify a value, then Zuora generates a name automatically. Whether auto-generated or manually specified, the subscription name must be unique. Otherwise an error will occur. In WSDL 69+, you can change this value only when the subscription is in `Draft` status. Once the subscription is activated, you can't change this value, nor can you use this value for a different subscription. **Character limit**: 100 **Values**: one of the following:  - leave null to automatically generate - a string of 100 characters or fewer 
   * @return name
  **/
  @ApiModelProperty(example = "null", value = " The unique identifier of the subscription. If you don't specify a value, then Zuora generates a name automatically. Whether auto-generated or manually specified, the subscription name must be unique. Otherwise an error will occur. In WSDL 69+, you can change this value only when the subscription is in `Draft` status. Once the subscription is activated, you can't change this value, nor can you use this value for a different subscription. **Character limit**: 100 **Values**: one of the following:  - leave null to automatically generate - a string of 100 characters or fewer ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProxyCreateSubscription notes(String notes) {
    this.notes = notes;
    return this;
  }

   /**
   *  Use this field to record comments about the subscription. **Character limit**: 500 **Values**: a string of 500 characters or fewer 
   * @return notes
  **/
  @ApiModelProperty(example = "null", value = " Use this field to record comments about the subscription. **Character limit**: 500 **Values**: a string of 500 characters or fewer ")
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public ProxyCreateSubscription opportunityCloseDateQT(LocalDate opportunityCloseDateQT) {
    this.opportunityCloseDateQT = opportunityCloseDateQT;
    return this;
  }

   /**
   *  The closing date of the Opportunity. This field is used in Zuora Reporting Data Sources to report on Subscription metrics. If the subscription was originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. **Character limit**: **Values**: populated by Zuora Quotes 
   * @return opportunityCloseDateQT
  **/
  @ApiModelProperty(example = "null", value = " The closing date of the Opportunity. This field is used in Zuora Reporting Data Sources to report on Subscription metrics. If the subscription was originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. **Character limit**: **Values**: populated by Zuora Quotes ")
  public LocalDate getOpportunityCloseDateQT() {
    return opportunityCloseDateQT;
  }

  public void setOpportunityCloseDateQT(LocalDate opportunityCloseDateQT) {
    this.opportunityCloseDateQT = opportunityCloseDateQT;
  }

  public ProxyCreateSubscription opportunityNameQT(String opportunityNameQT) {
    this.opportunityNameQT = opportunityNameQT;
    return this;
  }

   /**
   *  The unique identifier of the Opportunity. This field is used in the Zuora Reporting Data Sources to report on Subscription metrics. If the subscription was originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. **Character limit**: 100 **Values**: populated by Zuora Quotes 
   * @return opportunityNameQT
  **/
  @ApiModelProperty(example = "null", value = " The unique identifier of the Opportunity. This field is used in the Zuora Reporting Data Sources to report on Subscription metrics. If the subscription was originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. **Character limit**: 100 **Values**: populated by Zuora Quotes ")
  public String getOpportunityNameQT() {
    return opportunityNameQT;
  }

  public void setOpportunityNameQT(String opportunityNameQT) {
    this.opportunityNameQT = opportunityNameQT;
  }

  public ProxyCreateSubscription quoteBusinessTypeQT(String quoteBusinessTypeQT) {
    this.quoteBusinessTypeQT = quoteBusinessTypeQT;
    return this;
  }

   /**
   *  The specific identifier for the type of business transaction the Quote represents such as New, Upsell, Downsell, Renewal or Churn. This field is used in the Zuora Reporting Data Sources to report on Subscription metrics. If the subscription was originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. **Character limit**: 32 **Values**: populated by Zuora Quotes 
   * @return quoteBusinessTypeQT
  **/
  @ApiModelProperty(example = "null", value = " The specific identifier for the type of business transaction the Quote represents such as New, Upsell, Downsell, Renewal or Churn. This field is used in the Zuora Reporting Data Sources to report on Subscription metrics. If the subscription was originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. **Character limit**: 32 **Values**: populated by Zuora Quotes ")
  public String getQuoteBusinessTypeQT() {
    return quoteBusinessTypeQT;
  }

  public void setQuoteBusinessTypeQT(String quoteBusinessTypeQT) {
    this.quoteBusinessTypeQT = quoteBusinessTypeQT;
  }

  public ProxyCreateSubscription quoteNumberQT(String quoteNumberQT) {
    this.quoteNumberQT = quoteNumberQT;
    return this;
  }

   /**
   *  The unique identifier of the Quote. This field is used in the Zuora Reporting Data Sources to report on Subscription metrics. If the subscription was originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. **Character limit**: 32 **Values**: populated by Zuora Quotes 
   * @return quoteNumberQT
  **/
  @ApiModelProperty(example = "null", value = " The unique identifier of the Quote. This field is used in the Zuora Reporting Data Sources to report on Subscription metrics. If the subscription was originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. **Character limit**: 32 **Values**: populated by Zuora Quotes ")
  public String getQuoteNumberQT() {
    return quoteNumberQT;
  }

  public void setQuoteNumberQT(String quoteNumberQT) {
    this.quoteNumberQT = quoteNumberQT;
  }

  public ProxyCreateSubscription quoteTypeQT(String quoteTypeQT) {
    this.quoteTypeQT = quoteTypeQT;
    return this;
  }

   /**
   *  The Quote type that represents the subscription lifecycle stage such as New, Amendment, Renew or Cancel. This field is used in the Zuora Reporting Data Sources to report on Subscription metrics. If the subscription was originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. **Character limit**: 32 **Values**: populated by Zuora Quotes 
   * @return quoteTypeQT
  **/
  @ApiModelProperty(example = "null", value = " The Quote type that represents the subscription lifecycle stage such as New, Amendment, Renew or Cancel. This field is used in the Zuora Reporting Data Sources to report on Subscription metrics. If the subscription was originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. **Character limit**: 32 **Values**: populated by Zuora Quotes ")
  public String getQuoteTypeQT() {
    return quoteTypeQT;
  }

  public void setQuoteTypeQT(String quoteTypeQT) {
    this.quoteTypeQT = quoteTypeQT;
  }

  public ProxyCreateSubscription renewalSetting(String renewalSetting) {
    this.renewalSetting = renewalSetting;
    return this;
  }

   /**
   *  This field can be updated when **Status** is `Draft`. Specifies whether a termed subscription will remain termed or change to evergreen when it is renewed. **Required**: If TermType is Termed **Values**: `RENEW_WITH_SPECIFIC_TERM `(default), `RENEW_TO_EVERGREEN` 
   * @return renewalSetting
  **/
  @ApiModelProperty(example = "null", required = true, value = " This field can be updated when **Status** is `Draft`. Specifies whether a termed subscription will remain termed or change to evergreen when it is renewed. **Required**: If TermType is Termed **Values**: `RENEW_WITH_SPECIFIC_TERM `(default), `RENEW_TO_EVERGREEN` ")
  public String getRenewalSetting() {
    return renewalSetting;
  }

  public void setRenewalSetting(String renewalSetting) {
    this.renewalSetting = renewalSetting;
  }

  public ProxyCreateSubscription renewalTerm(Integer renewalTerm) {
    this.renewalTerm = renewalTerm;
    return this;
  }

   /**
   *  The length of the period for the subscription renewal term. This field can be updated when **Status** is `Draft`. If you use the subscribe() call, this field is required. **Required**: If TermType is Termed. **Character limit**: 20 **Values**: one of the following:  - leave null to default to `0` - any number 
   * @return renewalTerm
  **/
  @ApiModelProperty(example = "null", value = " The length of the period for the subscription renewal term. This field can be updated when **Status** is `Draft`. If you use the subscribe() call, this field is required. **Required**: If TermType is Termed. **Character limit**: 20 **Values**: one of the following:  - leave null to default to `0` - any number ")
  public Integer getRenewalTerm() {
    return renewalTerm;
  }

  public void setRenewalTerm(Integer renewalTerm) {
    this.renewalTerm = renewalTerm;
  }

  public ProxyCreateSubscription renewalTermPeriodType(String renewalTermPeriodType) {
    this.renewalTermPeriodType = renewalTermPeriodType;
    return this;
  }

   /**
   *  The period type for the subscription renewal term. **Values**:  - `Month` (default) - `Year` - `Day` - `Week` **Note**:  - This field is used with the RenewalTerm field to specify the subscription renewal term. - This field can be updated when Status is `Draft`. 
   * @return renewalTermPeriodType
  **/
  @ApiModelProperty(example = "null", value = " The period type for the subscription renewal term. **Values**:  - `Month` (default) - `Year` - `Day` - `Week` **Note**:  - This field is used with the RenewalTerm field to specify the subscription renewal term. - This field can be updated when Status is `Draft`. ")
  public String getRenewalTermPeriodType() {
    return renewalTermPeriodType;
  }

  public void setRenewalTermPeriodType(String renewalTermPeriodType) {
    this.renewalTermPeriodType = renewalTermPeriodType;
  }

  public ProxyCreateSubscription serviceActivationDate(LocalDate serviceActivationDate) {
    this.serviceActivationDate = serviceActivationDate;
    return this;
  }

   /**
   *  The date when the subscription is activated. This field can be updated when **Status** is `Draft`. **Character limit**: 29 **Note**: The service activation date is only required if the [Require Service Activation of Orders?](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Default_Subscription_Settings#Require_Service_Activation_of_Orders.3F) Setting is set to `Yes`. If this setting is set to `Yes`:  - If ContractAcceptanceDate field is required, you must set this field, ContractAcceptanceDate, and ContractEffectiveDate fields in the subscribe call to activate a subscription. - If ContractAcceptanceDate field is not required, you must set both this field and the ContractEffectiveDate field in the subscribe call to activate a subscription. If you only set a valid date in the ContractEffectiveDate field, the subscribe call still returns success, but the subscription is in `DRAT` status. 
   * @return serviceActivationDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the subscription is activated. This field can be updated when **Status** is `Draft`. **Character limit**: 29 **Note**: The service activation date is only required if the [Require Service Activation of Orders?](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Default_Subscription_Settings#Require_Service_Activation_of_Orders.3F) Setting is set to `Yes`. If this setting is set to `Yes`:  - If ContractAcceptanceDate field is required, you must set this field, ContractAcceptanceDate, and ContractEffectiveDate fields in the subscribe call to activate a subscription. - If ContractAcceptanceDate field is not required, you must set both this field and the ContractEffectiveDate field in the subscribe call to activate a subscription. If you only set a valid date in the ContractEffectiveDate field, the subscribe call still returns success, but the subscription is in `DRAT` status. ")
  public LocalDate getServiceActivationDate() {
    return serviceActivationDate;
  }

  public void setServiceActivationDate(LocalDate serviceActivationDate) {
    this.serviceActivationDate = serviceActivationDate;
  }

  public ProxyCreateSubscription status(String status) {
    this.status = status;
    return this;
  }

   /**
   *  The status of the subscription. **Character limit**: 17 **Values**: automatically generated **Possible values**: one of the following:  - `Draft` - `PendingActivation` - `PendingAcceptance` - `Active` - `Cancelled` - `Expired` - `Suspended` (This value is in **Limited Availability**.) 
   * @return status
  **/
  @ApiModelProperty(example = "null", value = " The status of the subscription. **Character limit**: 17 **Values**: automatically generated **Possible values**: one of the following:  - `Draft` - `PendingActivation` - `PendingAcceptance` - `Active` - `Cancelled` - `Expired` - `Suspended` (This value is in **Limited Availability**.) ")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ProxyCreateSubscription termStartDate(LocalDate termStartDate) {
    this.termStartDate = termStartDate;
    return this;
  }

   /**
   *  This field can be updated when **Status** is `Draft`. The date when the subscription term begins. If this is a renewal subscription, then this date is different from the subscription start date. **Character limit**: 29 **Version notes**: -- 
   * @return termStartDate
  **/
  @ApiModelProperty(example = "null", value = " This field can be updated when **Status** is `Draft`. The date when the subscription term begins. If this is a renewal subscription, then this date is different from the subscription start date. **Character limit**: 29 **Version notes**: -- ")
  public LocalDate getTermStartDate() {
    return termStartDate;
  }

  public void setTermStartDate(LocalDate termStartDate) {
    this.termStartDate = termStartDate;
  }

  public ProxyCreateSubscription termType(String termType) {
    this.termType = termType;
    return this;
  }

   /**
   *  This field can be updated when **Status** is `Draft`. Indicates if a subscription is [termed or evergreen](https://knowledgecenter.zuora.com/BC_Subscription_Management/Subscriptions#Termed_and_Evergreen_Subscriptions). A termed subscription has a specific end date and requires manual renewal. An evergreen subscription doesn't have an end date and doesn't need renewal. This field can be updated when the subscription status is Draft. **Character limit**: 9 **Values**: `TERMED`, `EVERGREEN` 
   * @return termType
  **/
  @ApiModelProperty(example = "null", value = " This field can be updated when **Status** is `Draft`. Indicates if a subscription is [termed or evergreen](https://knowledgecenter.zuora.com/BC_Subscription_Management/Subscriptions#Termed_and_Evergreen_Subscriptions). A termed subscription has a specific end date and requires manual renewal. An evergreen subscription doesn't have an end date and doesn't need renewal. This field can be updated when the subscription status is Draft. **Character limit**: 9 **Values**: `TERMED`, `EVERGREEN` ")
  public String getTermType() {
    return termType;
  }

  public void setTermType(String termType) {
    this.termType = termType;
  }

  public ProxyCreateSubscription version(Integer version) {
    this.version = version;
    return this;
  }

   /**
   *  The version number of the subscription. **Values**: automatically generated 
   * @return version
  **/
  @ApiModelProperty(example = "null", value = " The version number of the subscription. **Values**: automatically generated ")
  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProxyCreateSubscription proxyCreateSubscription = (ProxyCreateSubscription) o;
    return Objects.equals(this.accountId, proxyCreateSubscription.accountId) &&
        Objects.equals(this.autoRenew, proxyCreateSubscription.autoRenew) &&
        Objects.equals(this.cancelledDate, proxyCreateSubscription.cancelledDate) &&
        Objects.equals(this.contractAcceptanceDate, proxyCreateSubscription.contractAcceptanceDate) &&
        Objects.equals(this.contractEffectiveDate, proxyCreateSubscription.contractEffectiveDate) &&
        Objects.equals(this.cpqBundleJsonIdQT, proxyCreateSubscription.cpqBundleJsonIdQT) &&
        Objects.equals(this.currentTermPeriodType, proxyCreateSubscription.currentTermPeriodType) &&
        Objects.equals(this.initialTerm, proxyCreateSubscription.initialTerm) &&
        Objects.equals(this.initialTermPeriodType, proxyCreateSubscription.initialTermPeriodType) &&
        Objects.equals(this.invoiceOwnerId, proxyCreateSubscription.invoiceOwnerId) &&
        Objects.equals(this.isInvoiceSeparate, proxyCreateSubscription.isInvoiceSeparate) &&
        Objects.equals(this.name, proxyCreateSubscription.name) &&
        Objects.equals(this.notes, proxyCreateSubscription.notes) &&
        Objects.equals(this.opportunityCloseDateQT, proxyCreateSubscription.opportunityCloseDateQT) &&
        Objects.equals(this.opportunityNameQT, proxyCreateSubscription.opportunityNameQT) &&
        Objects.equals(this.quoteBusinessTypeQT, proxyCreateSubscription.quoteBusinessTypeQT) &&
        Objects.equals(this.quoteNumberQT, proxyCreateSubscription.quoteNumberQT) &&
        Objects.equals(this.quoteTypeQT, proxyCreateSubscription.quoteTypeQT) &&
        Objects.equals(this.renewalSetting, proxyCreateSubscription.renewalSetting) &&
        Objects.equals(this.renewalTerm, proxyCreateSubscription.renewalTerm) &&
        Objects.equals(this.renewalTermPeriodType, proxyCreateSubscription.renewalTermPeriodType) &&
        Objects.equals(this.serviceActivationDate, proxyCreateSubscription.serviceActivationDate) &&
        Objects.equals(this.status, proxyCreateSubscription.status) &&
        Objects.equals(this.termStartDate, proxyCreateSubscription.termStartDate) &&
        Objects.equals(this.termType, proxyCreateSubscription.termType) &&
        Objects.equals(this.version, proxyCreateSubscription.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, autoRenew, cancelledDate, contractAcceptanceDate, contractEffectiveDate, cpqBundleJsonIdQT, currentTermPeriodType, initialTerm, initialTermPeriodType, invoiceOwnerId, isInvoiceSeparate, name, notes, opportunityCloseDateQT, opportunityNameQT, quoteBusinessTypeQT, quoteNumberQT, quoteTypeQT, renewalSetting, renewalTerm, renewalTermPeriodType, serviceActivationDate, status, termStartDate, termType, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProxyCreateSubscription {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    autoRenew: ").append(toIndentedString(autoRenew)).append("\n");
    sb.append("    cancelledDate: ").append(toIndentedString(cancelledDate)).append("\n");
    sb.append("    contractAcceptanceDate: ").append(toIndentedString(contractAcceptanceDate)).append("\n");
    sb.append("    contractEffectiveDate: ").append(toIndentedString(contractEffectiveDate)).append("\n");
    sb.append("    cpqBundleJsonIdQT: ").append(toIndentedString(cpqBundleJsonIdQT)).append("\n");
    sb.append("    currentTermPeriodType: ").append(toIndentedString(currentTermPeriodType)).append("\n");
    sb.append("    initialTerm: ").append(toIndentedString(initialTerm)).append("\n");
    sb.append("    initialTermPeriodType: ").append(toIndentedString(initialTermPeriodType)).append("\n");
    sb.append("    invoiceOwnerId: ").append(toIndentedString(invoiceOwnerId)).append("\n");
    sb.append("    isInvoiceSeparate: ").append(toIndentedString(isInvoiceSeparate)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    opportunityCloseDateQT: ").append(toIndentedString(opportunityCloseDateQT)).append("\n");
    sb.append("    opportunityNameQT: ").append(toIndentedString(opportunityNameQT)).append("\n");
    sb.append("    quoteBusinessTypeQT: ").append(toIndentedString(quoteBusinessTypeQT)).append("\n");
    sb.append("    quoteNumberQT: ").append(toIndentedString(quoteNumberQT)).append("\n");
    sb.append("    quoteTypeQT: ").append(toIndentedString(quoteTypeQT)).append("\n");
    sb.append("    renewalSetting: ").append(toIndentedString(renewalSetting)).append("\n");
    sb.append("    renewalTerm: ").append(toIndentedString(renewalTerm)).append("\n");
    sb.append("    renewalTermPeriodType: ").append(toIndentedString(renewalTermPeriodType)).append("\n");
    sb.append("    serviceActivationDate: ").append(toIndentedString(serviceActivationDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    termStartDate: ").append(toIndentedString(termStartDate)).append("\n");
    sb.append("    termType: ").append(toIndentedString(termType)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

