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
import io.swagger.client.model.POSTSrpCreateType;
import io.swagger.client.model.POSTSubscriptionPreviewTypePreviewAccountInfo;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDate;


/**
 * POSTSubscriptionPreviewType
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class POSTSubscriptionPreviewType   {
  @SerializedName("OpportunityCloseDate_QT")
  private String opportunityCloseDateQT = null;

  @SerializedName("OpportunityName_QT")
  private String opportunityNameQT = null;

  @SerializedName("QuoteBusinessType_QT")
  private String quoteBusinessTypeQT = null;

  @SerializedName("QuoteNumber_QT")
  private String quoteNumberQT = null;

  @SerializedName("QuoteType_QT")
  private String quoteTypeQT = null;

  @SerializedName("accountKey")
  private String accountKey = null;

  @SerializedName("contractEffectiveDate")
  private LocalDate contractEffectiveDate = null;

  @SerializedName("customerAcceptanceDate")
  private LocalDate customerAcceptanceDate = null;

  @SerializedName("includeExistingDraftInvoiceItems")
  private Boolean includeExistingDraftInvoiceItems = null;

  @SerializedName("initialTerm")
  private Long initialTerm = null;

  @SerializedName("initialTermPeriodType")
  private String initialTermPeriodType = null;

  @SerializedName("invoiceOwnerAccountKey")
  private String invoiceOwnerAccountKey = null;

  @SerializedName("invoiceTargetDate")
  private LocalDate invoiceTargetDate = null;

  @SerializedName("notes")
  private String notes = null;

  @SerializedName("previewAccountInfo")
  private POSTSubscriptionPreviewTypePreviewAccountInfo previewAccountInfo = null;

  @SerializedName("previewType")
  private String previewType = null;

  @SerializedName("serviceActivationDate")
  private LocalDate serviceActivationDate = null;

  @SerializedName("subscribeToRatePlans")
  private List<POSTSrpCreateType> subscribeToRatePlans = new ArrayList<POSTSrpCreateType>();

  @SerializedName("termStartDate")
  private LocalDate termStartDate = null;

  @SerializedName("termType")
  private String termType = null;

  public POSTSubscriptionPreviewType opportunityCloseDateQT(String opportunityCloseDateQT) {
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

  public POSTSubscriptionPreviewType opportunityNameQT(String opportunityNameQT) {
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

  public POSTSubscriptionPreviewType quoteBusinessTypeQT(String quoteBusinessTypeQT) {
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

  public POSTSubscriptionPreviewType quoteNumberQT(String quoteNumberQT) {
    this.quoteNumberQT = quoteNumberQT;
    return this;
  }

   /**
   * The unique identifier of the Quote. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. 
   * @return quoteNumberQT
  **/
  @ApiModelProperty(example = "null", value = "The unique identifier of the Quote. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. ")
  public String getQuoteNumberQT() {
    return quoteNumberQT;
  }

  public void setQuoteNumberQT(String quoteNumberQT) {
    this.quoteNumberQT = quoteNumberQT;
  }

  public POSTSubscriptionPreviewType quoteTypeQT(String quoteTypeQT) {
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

  public POSTSubscriptionPreviewType accountKey(String accountKey) {
    this.accountKey = accountKey;
    return this;
  }

   /**
   *  Customer account number or ID.  You must specify the account information either in this field or in the `previewAccountInfo` field with the following conditions:           * If you already have a customer account, specify the account number or ID in this field. * If you do not have a customer account, provide account information in the `previewAccountInfo` field. 
   * @return accountKey
  **/
  @ApiModelProperty(example = "null", value = " Customer account number or ID.  You must specify the account information either in this field or in the `previewAccountInfo` field with the following conditions:           * If you already have a customer account, specify the account number or ID in this field. * If you do not have a customer account, provide account information in the `previewAccountInfo` field. ")
  public String getAccountKey() {
    return accountKey;
  }

  public void setAccountKey(String accountKey) {
    this.accountKey = accountKey;
  }

  public POSTSubscriptionPreviewType contractEffectiveDate(LocalDate contractEffectiveDate) {
    this.contractEffectiveDate = contractEffectiveDate;
    return this;
  }

   /**
   * Effective contract date for this subscription, as yyyy-mm-dd. 
   * @return contractEffectiveDate
  **/
  @ApiModelProperty(example = "null", required = true, value = "Effective contract date for this subscription, as yyyy-mm-dd. ")
  public LocalDate getContractEffectiveDate() {
    return contractEffectiveDate;
  }

  public void setContractEffectiveDate(LocalDate contractEffectiveDate) {
    this.contractEffectiveDate = contractEffectiveDate;
  }

  public POSTSubscriptionPreviewType customerAcceptanceDate(LocalDate customerAcceptanceDate) {
    this.customerAcceptanceDate = customerAcceptanceDate;
    return this;
  }

   /**
   * The date on which the services or products within a subscription have been accepted by the customer, as yyyy-mm-dd.  Default value is dependent on the value of other fields. See **Notes** section for more details. 
   * @return customerAcceptanceDate
  **/
  @ApiModelProperty(example = "null", value = "The date on which the services or products within a subscription have been accepted by the customer, as yyyy-mm-dd.  Default value is dependent on the value of other fields. See **Notes** section for more details. ")
  public LocalDate getCustomerAcceptanceDate() {
    return customerAcceptanceDate;
  }

  public void setCustomerAcceptanceDate(LocalDate customerAcceptanceDate) {
    this.customerAcceptanceDate = customerAcceptanceDate;
  }

  public POSTSubscriptionPreviewType includeExistingDraftInvoiceItems(Boolean includeExistingDraftInvoiceItems) {
    this.includeExistingDraftInvoiceItems = includeExistingDraftInvoiceItems;
    return this;
  }

   /**
   * Specifies whether to include draft invoice items in subscription previews.  Values:   * `true` (default). Includes draft invoice items in amendment previews.  * `false`. Excludes draft invoice items in amendment previews. 
   * @return includeExistingDraftInvoiceItems
  **/
  @ApiModelProperty(example = "null", value = "Specifies whether to include draft invoice items in subscription previews.  Values:   * `true` (default). Includes draft invoice items in amendment previews.  * `false`. Excludes draft invoice items in amendment previews. ")
  public Boolean getIncludeExistingDraftInvoiceItems() {
    return includeExistingDraftInvoiceItems;
  }

  public void setIncludeExistingDraftInvoiceItems(Boolean includeExistingDraftInvoiceItems) {
    this.includeExistingDraftInvoiceItems = includeExistingDraftInvoiceItems;
  }

  public POSTSubscriptionPreviewType initialTerm(Long initialTerm) {
    this.initialTerm = initialTerm;
    return this;
  }

   /**
   * Duration of the first term of the subscription, in whole months. Default is `0`. If `termType` is `TERMED`, then this field is required, and the value must be greater than `0`. If `termType` is `EVERGREEN`, this field is ignored. 
   * @return initialTerm
  **/
  @ApiModelProperty(example = "null", value = "Duration of the first term of the subscription, in whole months. Default is `0`. If `termType` is `TERMED`, then this field is required, and the value must be greater than `0`. If `termType` is `EVERGREEN`, this field is ignored. ")
  public Long getInitialTerm() {
    return initialTerm;
  }

  public void setInitialTerm(Long initialTerm) {
    this.initialTerm = initialTerm;
  }

  public POSTSubscriptionPreviewType initialTermPeriodType(String initialTermPeriodType) {
    this.initialTermPeriodType = initialTermPeriodType;
    return this;
  }

   /**
   * The period type of the initial term.   Supported values are:  * `Month` * `Year` * `Day` * `Week` 
   * @return initialTermPeriodType
  **/
  @ApiModelProperty(example = "null", value = "The period type of the initial term.   Supported values are:  * `Month` * `Year` * `Day` * `Week` ")
  public String getInitialTermPeriodType() {
    return initialTermPeriodType;
  }

  public void setInitialTermPeriodType(String initialTermPeriodType) {
    this.initialTermPeriodType = initialTermPeriodType;
  }

  public POSTSubscriptionPreviewType invoiceOwnerAccountKey(String invoiceOwnerAccountKey) {
    this.invoiceOwnerAccountKey = invoiceOwnerAccountKey;
    return this;
  }

   /**
   * Invoice owner account number or ID.  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/). 
   * @return invoiceOwnerAccountKey
  **/
  @ApiModelProperty(example = "null", value = "Invoice owner account number or ID.  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/). ")
  public String getInvoiceOwnerAccountKey() {
    return invoiceOwnerAccountKey;
  }

  public void setInvoiceOwnerAccountKey(String invoiceOwnerAccountKey) {
    this.invoiceOwnerAccountKey = invoiceOwnerAccountKey;
  }

  public POSTSubscriptionPreviewType invoiceTargetDate(LocalDate invoiceTargetDate) {
    this.invoiceTargetDate = invoiceTargetDate;
    return this;
  }

   /**
   * Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date. 
   * @return invoiceTargetDate
  **/
  @ApiModelProperty(example = "null", value = "Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date. ")
  public LocalDate getInvoiceTargetDate() {
    return invoiceTargetDate;
  }

  public void setInvoiceTargetDate(LocalDate invoiceTargetDate) {
    this.invoiceTargetDate = invoiceTargetDate;
  }

  public POSTSubscriptionPreviewType notes(String notes) {
    this.notes = notes;
    return this;
  }

   /**
   * String of up to 500 characters.
   * @return notes
  **/
  @ApiModelProperty(example = "null", value = "String of up to 500 characters.")
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public POSTSubscriptionPreviewType previewAccountInfo(POSTSubscriptionPreviewTypePreviewAccountInfo previewAccountInfo) {
    this.previewAccountInfo = previewAccountInfo;
    return this;
  }

   /**
   * Get previewAccountInfo
   * @return previewAccountInfo
  **/
  @ApiModelProperty(example = "null", value = "")
  public POSTSubscriptionPreviewTypePreviewAccountInfo getPreviewAccountInfo() {
    return previewAccountInfo;
  }

  public void setPreviewAccountInfo(POSTSubscriptionPreviewTypePreviewAccountInfo previewAccountInfo) {
    this.previewAccountInfo = previewAccountInfo;
  }

  public POSTSubscriptionPreviewType previewType(String previewType) {
    this.previewType = previewType;
    return this;
  }

   /**
   * The type of preview you will receive. The possible values are `invoiceItem`, `chargeMetrics`, or `InvoiceItemChargeMetrics`. The default is `invoiceItem`. 
   * @return previewType
  **/
  @ApiModelProperty(example = "null", value = "The type of preview you will receive. The possible values are `invoiceItem`, `chargeMetrics`, or `InvoiceItemChargeMetrics`. The default is `invoiceItem`. ")
  public String getPreviewType() {
    return previewType;
  }

  public void setPreviewType(String previewType) {
    this.previewType = previewType;
  }

  public POSTSubscriptionPreviewType serviceActivationDate(LocalDate serviceActivationDate) {
    this.serviceActivationDate = serviceActivationDate;
    return this;
  }

   /**
   * The date on which the services or products within a subscription have been activated and access has been provided to the customer, as yyyy-mm-dd.  Default value is dependent on the value of other fields. See **Notes** section for more details. 
   * @return serviceActivationDate
  **/
  @ApiModelProperty(example = "null", value = "The date on which the services or products within a subscription have been activated and access has been provided to the customer, as yyyy-mm-dd.  Default value is dependent on the value of other fields. See **Notes** section for more details. ")
  public LocalDate getServiceActivationDate() {
    return serviceActivationDate;
  }

  public void setServiceActivationDate(LocalDate serviceActivationDate) {
    this.serviceActivationDate = serviceActivationDate;
  }

  public POSTSubscriptionPreviewType subscribeToRatePlans(List<POSTSrpCreateType> subscribeToRatePlans) {
    this.subscribeToRatePlans = subscribeToRatePlans;
    return this;
  }

  public POSTSubscriptionPreviewType addSubscribeToRatePlansItem(POSTSrpCreateType subscribeToRatePlansItem) {
    this.subscribeToRatePlans.add(subscribeToRatePlansItem);
    return this;
  }

   /**
   * Container for one or more rate plans for this subscription. 
   * @return subscribeToRatePlans
  **/
  @ApiModelProperty(example = "null", required = true, value = "Container for one or more rate plans for this subscription. ")
  public List<POSTSrpCreateType> getSubscribeToRatePlans() {
    return subscribeToRatePlans;
  }

  public void setSubscribeToRatePlans(List<POSTSrpCreateType> subscribeToRatePlans) {
    this.subscribeToRatePlans = subscribeToRatePlans;
  }

  public POSTSubscriptionPreviewType termStartDate(LocalDate termStartDate) {
    this.termStartDate = termStartDate;
    return this;
  }

   /**
   * The date on which the subscription term begins, as yyyy-mm-dd. If this is a renewal subscription, this date is different from the subscription start date. 
   * @return termStartDate
  **/
  @ApiModelProperty(example = "null", value = "The date on which the subscription term begins, as yyyy-mm-dd. If this is a renewal subscription, this date is different from the subscription start date. ")
  public LocalDate getTermStartDate() {
    return termStartDate;
  }

  public void setTermStartDate(LocalDate termStartDate) {
    this.termStartDate = termStartDate;
  }

  public POSTSubscriptionPreviewType termType(String termType) {
    this.termType = termType;
    return this;
  }

   /**
   * Possible values are: `TERMED`, `EVERGREEN`. 
   * @return termType
  **/
  @ApiModelProperty(example = "null", required = true, value = "Possible values are: `TERMED`, `EVERGREEN`. ")
  public String getTermType() {
    return termType;
  }

  public void setTermType(String termType) {
    this.termType = termType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    POSTSubscriptionPreviewType pOSTSubscriptionPreviewType = (POSTSubscriptionPreviewType) o;
    return Objects.equals(this.opportunityCloseDateQT, pOSTSubscriptionPreviewType.opportunityCloseDateQT) &&
        Objects.equals(this.opportunityNameQT, pOSTSubscriptionPreviewType.opportunityNameQT) &&
        Objects.equals(this.quoteBusinessTypeQT, pOSTSubscriptionPreviewType.quoteBusinessTypeQT) &&
        Objects.equals(this.quoteNumberQT, pOSTSubscriptionPreviewType.quoteNumberQT) &&
        Objects.equals(this.quoteTypeQT, pOSTSubscriptionPreviewType.quoteTypeQT) &&
        Objects.equals(this.accountKey, pOSTSubscriptionPreviewType.accountKey) &&
        Objects.equals(this.contractEffectiveDate, pOSTSubscriptionPreviewType.contractEffectiveDate) &&
        Objects.equals(this.customerAcceptanceDate, pOSTSubscriptionPreviewType.customerAcceptanceDate) &&
        Objects.equals(this.includeExistingDraftInvoiceItems, pOSTSubscriptionPreviewType.includeExistingDraftInvoiceItems) &&
        Objects.equals(this.initialTerm, pOSTSubscriptionPreviewType.initialTerm) &&
        Objects.equals(this.initialTermPeriodType, pOSTSubscriptionPreviewType.initialTermPeriodType) &&
        Objects.equals(this.invoiceOwnerAccountKey, pOSTSubscriptionPreviewType.invoiceOwnerAccountKey) &&
        Objects.equals(this.invoiceTargetDate, pOSTSubscriptionPreviewType.invoiceTargetDate) &&
        Objects.equals(this.notes, pOSTSubscriptionPreviewType.notes) &&
        Objects.equals(this.previewAccountInfo, pOSTSubscriptionPreviewType.previewAccountInfo) &&
        Objects.equals(this.previewType, pOSTSubscriptionPreviewType.previewType) &&
        Objects.equals(this.serviceActivationDate, pOSTSubscriptionPreviewType.serviceActivationDate) &&
        Objects.equals(this.subscribeToRatePlans, pOSTSubscriptionPreviewType.subscribeToRatePlans) &&
        Objects.equals(this.termStartDate, pOSTSubscriptionPreviewType.termStartDate) &&
        Objects.equals(this.termType, pOSTSubscriptionPreviewType.termType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(opportunityCloseDateQT, opportunityNameQT, quoteBusinessTypeQT, quoteNumberQT, quoteTypeQT, accountKey, contractEffectiveDate, customerAcceptanceDate, includeExistingDraftInvoiceItems, initialTerm, initialTermPeriodType, invoiceOwnerAccountKey, invoiceTargetDate, notes, previewAccountInfo, previewType, serviceActivationDate, subscribeToRatePlans, termStartDate, termType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class POSTSubscriptionPreviewType {\n");
    
    sb.append("    opportunityCloseDateQT: ").append(toIndentedString(opportunityCloseDateQT)).append("\n");
    sb.append("    opportunityNameQT: ").append(toIndentedString(opportunityNameQT)).append("\n");
    sb.append("    quoteBusinessTypeQT: ").append(toIndentedString(quoteBusinessTypeQT)).append("\n");
    sb.append("    quoteNumberQT: ").append(toIndentedString(quoteNumberQT)).append("\n");
    sb.append("    quoteTypeQT: ").append(toIndentedString(quoteTypeQT)).append("\n");
    sb.append("    accountKey: ").append(toIndentedString(accountKey)).append("\n");
    sb.append("    contractEffectiveDate: ").append(toIndentedString(contractEffectiveDate)).append("\n");
    sb.append("    customerAcceptanceDate: ").append(toIndentedString(customerAcceptanceDate)).append("\n");
    sb.append("    includeExistingDraftInvoiceItems: ").append(toIndentedString(includeExistingDraftInvoiceItems)).append("\n");
    sb.append("    initialTerm: ").append(toIndentedString(initialTerm)).append("\n");
    sb.append("    initialTermPeriodType: ").append(toIndentedString(initialTermPeriodType)).append("\n");
    sb.append("    invoiceOwnerAccountKey: ").append(toIndentedString(invoiceOwnerAccountKey)).append("\n");
    sb.append("    invoiceTargetDate: ").append(toIndentedString(invoiceTargetDate)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    previewAccountInfo: ").append(toIndentedString(previewAccountInfo)).append("\n");
    sb.append("    previewType: ").append(toIndentedString(previewType)).append("\n");
    sb.append("    serviceActivationDate: ").append(toIndentedString(serviceActivationDate)).append("\n");
    sb.append("    subscribeToRatePlans: ").append(toIndentedString(subscribeToRatePlans)).append("\n");
    sb.append("    termStartDate: ").append(toIndentedString(termStartDate)).append("\n");
    sb.append("    termType: ").append(toIndentedString(termType)).append("\n");
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

