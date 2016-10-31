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
import io.swagger.client.model.POSTAccountTypeBillToContact;
import io.swagger.client.model.POSTAccountTypeCreditCard;
import io.swagger.client.model.POSTAccountTypeSoldToContact;
import io.swagger.client.model.POSTAccountTypeSubscription;
import io.swagger.client.model.POSTAccountTypeTaxInfo;
import org.joda.time.LocalDate;


/**
 * POSTAccountType
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class POSTAccountType   {
  @SerializedName("accountNumber")
  private String accountNumber = null;

  @SerializedName("applyCreditBalance")
  private Boolean applyCreditBalance = null;

  @SerializedName("autoPay")
  private Boolean autoPay = null;

  @SerializedName("batch")
  private String batch = null;

  @SerializedName("billCycleDay")
  private Long billCycleDay = null;

  @SerializedName("billToContact")
  private POSTAccountTypeBillToContact billToContact = null;

  @SerializedName("collect")
  private String collect = null;

  @SerializedName("communicationProfileId")
  private String communicationProfileId = null;

  @SerializedName("creditCard")
  private POSTAccountTypeCreditCard creditCard = null;

  @SerializedName("crmId")
  private String crmId = null;

  @SerializedName("currency")
  private String currency = null;

  @SerializedName("customField__c")
  private String customFieldC = null;

  @SerializedName("hpmCreditCardPaymentMethodId")
  private String hpmCreditCardPaymentMethodId = null;

  @SerializedName("invoice")
  private String invoice = null;

  @SerializedName("invoiceCollect")
  private Boolean invoiceCollect = null;

  @SerializedName("invoiceTargetDate")
  private LocalDate invoiceTargetDate = null;

  @SerializedName("invoiceTemplateId")
  private String invoiceTemplateId = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("notes")
  private String notes = null;

  @SerializedName("paymentGateway")
  private String paymentGateway = null;

  @SerializedName("paymentTerm")
  private String paymentTerm = null;

  @SerializedName("soldToContact")
  private POSTAccountTypeSoldToContact soldToContact = null;

  @SerializedName("subscription")
  private POSTAccountTypeSubscription subscription = null;

  @SerializedName("tagging")
  private String tagging = null;

  @SerializedName("taxInfo")
  private POSTAccountTypeTaxInfo taxInfo = null;

  public POSTAccountType accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

   /**
   * A unique account number, up to 50 characters that do not begin with the default account number prefix.  If no account number is specified, one is generated. 
   * @return accountNumber
  **/
  @ApiModelProperty(example = "null", value = "A unique account number, up to 50 characters that do not begin with the default account number prefix.  If no account number is specified, one is generated. ")
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public POSTAccountType applyCreditBalance(Boolean applyCreditBalance) {
    this.applyCreditBalance = applyCreditBalance;
    return this;
  }

   /**
   * Applies a credit balance to an invoice.   If the value is `true`, the credit balance is applied to the invoice. If the value is `false`, no action is taken.  Prerequisite: `invoice` must be `true`.   **Note:** If you are using the field `invoiceCollect` rather than the field `invoice`, the `invoiceCollect` value must be `true`.  To view the credit balance adjustment, retrieve the details of the invoice using the Get Invoices method. 
   * @return applyCreditBalance
  **/
  @ApiModelProperty(example = "null", value = "Applies a credit balance to an invoice.   If the value is `true`, the credit balance is applied to the invoice. If the value is `false`, no action is taken.  Prerequisite: `invoice` must be `true`.   **Note:** If you are using the field `invoiceCollect` rather than the field `invoice`, the `invoiceCollect` value must be `true`.  To view the credit balance adjustment, retrieve the details of the invoice using the Get Invoices method. ")
  public Boolean getApplyCreditBalance() {
    return applyCreditBalance;
  }

  public void setApplyCreditBalance(Boolean applyCreditBalance) {
    this.applyCreditBalance = applyCreditBalance;
  }

  public POSTAccountType autoPay(Boolean autoPay) {
    this.autoPay = autoPay;
    return this;
  }

   /**
   * Specifies whether future payments are to be automatically billed when they are due. Possible values are: `true`, `false`. 
   * @return autoPay
  **/
  @ApiModelProperty(example = "null", value = "Specifies whether future payments are to be automatically billed when they are due. Possible values are: `true`, `false`. ")
  public Boolean getAutoPay() {
    return autoPay;
  }

  public void setAutoPay(Boolean autoPay) {
    this.autoPay = autoPay;
  }

  public POSTAccountType batch(String batch) {
    this.batch = batch;
    return this;
  }

   /**
   * The alias name given to a batch. A string of 50 characters or less. 
   * @return batch
  **/
  @ApiModelProperty(example = "null", value = "The alias name given to a batch. A string of 50 characters or less. ")
  public String getBatch() {
    return batch;
  }

  public void setBatch(String batch) {
    this.batch = batch;
  }

  public POSTAccountType billCycleDay(Long billCycleDay) {
    this.billCycleDay = billCycleDay;
    return this;
  }

   /**
   * The account's bill cycle day (BCD), when bill runs generate invoices for the account.  Specify any day of the month (1-31, where 31 = end-of-month), or 0 for auto-set.  Required if no subscription will be created.   Optional if a subscription is created and defaults to the day-of-the-month of the subscription's `contractEffectiveDate`. 
   * @return billCycleDay
  **/
  @ApiModelProperty(example = "null", value = "The account's bill cycle day (BCD), when bill runs generate invoices for the account.  Specify any day of the month (1-31, where 31 = end-of-month), or 0 for auto-set.  Required if no subscription will be created.   Optional if a subscription is created and defaults to the day-of-the-month of the subscription's `contractEffectiveDate`. ")
  public Long getBillCycleDay() {
    return billCycleDay;
  }

  public void setBillCycleDay(Long billCycleDay) {
    this.billCycleDay = billCycleDay;
  }

  public POSTAccountType billToContact(POSTAccountTypeBillToContact billToContact) {
    this.billToContact = billToContact;
    return this;
  }

   /**
   * Get billToContact
   * @return billToContact
  **/
  @ApiModelProperty(example = "null", value = "")
  public POSTAccountTypeBillToContact getBillToContact() {
    return billToContact;
  }

  public void setBillToContact(POSTAccountTypeBillToContact billToContact) {
    this.billToContact = billToContact;
  }

  public POSTAccountType collect(String collect) {
    this.collect = collect;
    return this;
  }

   /**
   * Collects an automatic payment for a subscription. The collection generated in this operation is only for this subscription, not for the entire customer account.  If the value is `true`, the automatic payment is collected. If the value is `false`, no action is taken.  The default value is `true`.  Prerequisite: invoice must be `true`.   **Note:** This field is in Zuora REST API version control. Supported minor versions are 196.0 or later. To use this field in the method, you must set the `zuora-version` parameter to the minor version number in the request header. See [Zuora REST API Versions](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. 
   * @return collect
  **/
  @ApiModelProperty(example = "null", value = "Collects an automatic payment for a subscription. The collection generated in this operation is only for this subscription, not for the entire customer account.  If the value is `true`, the automatic payment is collected. If the value is `false`, no action is taken.  The default value is `true`.  Prerequisite: invoice must be `true`.   **Note:** This field is in Zuora REST API version control. Supported minor versions are 196.0 or later. To use this field in the method, you must set the `zuora-version` parameter to the minor version number in the request header. See [Zuora REST API Versions](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. ")
  public String getCollect() {
    return collect;
  }

  public void setCollect(String collect) {
    this.collect = collect;
  }

  public POSTAccountType communicationProfileId(String communicationProfileId) {
    this.communicationProfileId = communicationProfileId;
    return this;
  }

   /**
   * The ID of a [communication profile](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Communication_Profile).  
   * @return communicationProfileId
  **/
  @ApiModelProperty(example = "null", value = "The ID of a [communication profile](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Communication_Profile).  ")
  public String getCommunicationProfileId() {
    return communicationProfileId;
  }

  public void setCommunicationProfileId(String communicationProfileId) {
    this.communicationProfileId = communicationProfileId;
  }

  public POSTAccountType creditCard(POSTAccountTypeCreditCard creditCard) {
    this.creditCard = creditCard;
    return this;
  }

   /**
   * Get creditCard
   * @return creditCard
  **/
  @ApiModelProperty(example = "null", value = "")
  public POSTAccountTypeCreditCard getCreditCard() {
    return creditCard;
  }

  public void setCreditCard(POSTAccountTypeCreditCard creditCard) {
    this.creditCard = creditCard;
  }

  public POSTAccountType crmId(String crmId) {
    this.crmId = crmId;
    return this;
  }

   /**
   * CRM account ID for the account, up to 100 characters. 
   * @return crmId
  **/
  @ApiModelProperty(example = "null", value = "CRM account ID for the account, up to 100 characters. ")
  public String getCrmId() {
    return crmId;
  }

  public void setCrmId(String crmId) {
    this.crmId = crmId;
  }

  public POSTAccountType currency(String currency) {
    this.currency = currency;
    return this;
  }

   /**
   * A currency as defined in [Billing Settings in the Zuora UI](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Customize_Currencies). 
   * @return currency
  **/
  @ApiModelProperty(example = "null", required = true, value = "A currency as defined in [Billing Settings in the Zuora UI](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Customize_Currencies). ")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public POSTAccountType customFieldC(String customFieldC) {
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

  public POSTAccountType hpmCreditCardPaymentMethodId(String hpmCreditCardPaymentMethodId) {
    this.hpmCreditCardPaymentMethodId = hpmCreditCardPaymentMethodId;
    return this;
  }

   /**
   * The ID of the HPM credit card payment method associated with this account. You must provide either this field or the `creditCard` structure, but not both.  **Note:** Non-credit card payment methods are not supported. 
   * @return hpmCreditCardPaymentMethodId
  **/
  @ApiModelProperty(example = "null", value = "The ID of the HPM credit card payment method associated with this account. You must provide either this field or the `creditCard` structure, but not both.  **Note:** Non-credit card payment methods are not supported. ")
  public String getHpmCreditCardPaymentMethodId() {
    return hpmCreditCardPaymentMethodId;
  }

  public void setHpmCreditCardPaymentMethodId(String hpmCreditCardPaymentMethodId) {
    this.hpmCreditCardPaymentMethodId = hpmCreditCardPaymentMethodId;
  }

  public POSTAccountType invoice(String invoice) {
    this.invoice = invoice;
    return this;
  }

   /**
   * Creates an invoice for a subscription. The invoice generated in this operation is only for this subscription, not for the entire customer account.  If the value is `true`, an invoice is created. If the value is `false`, no action is taken.  The default value is `true`.   **Note:** This field is in Zuora REST API version control. Supported minor versions are 196.0 or later. To use this field in the method, you must set the `zuora-version` parameter to the minor version number in the request header. See [Zuora REST API Versions](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. 
   * @return invoice
  **/
  @ApiModelProperty(example = "null", value = "Creates an invoice for a subscription. The invoice generated in this operation is only for this subscription, not for the entire customer account.  If the value is `true`, an invoice is created. If the value is `false`, no action is taken.  The default value is `true`.   **Note:** This field is in Zuora REST API version control. Supported minor versions are 196.0 or later. To use this field in the method, you must set the `zuora-version` parameter to the minor version number in the request header. See [Zuora REST API Versions](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. ")
  public String getInvoice() {
    return invoice;
  }

  public void setInvoice(String invoice) {
    this.invoice = invoice;
  }

  public POSTAccountType invoiceCollect(Boolean invoiceCollect) {
    this.invoiceCollect = invoiceCollect;
    return this;
  }

   /**
   * **Note:** This field has been replaced by the `invoice` field and the `collect` field. `invoiceCollect` is available only for backward compatibility.  If `true` (default), and a subscription is created, an invoice is generated at account creation time and payment is immediately collected using the account's default payment method.  This field is in Zuora REST API version control. Supported minor versions are 186.0, 187.0, 188.0, 189.0, and 196.0. See [Zuora REST API Versions](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. 
   * @return invoiceCollect
  **/
  @ApiModelProperty(example = "null", value = "**Note:** This field has been replaced by the `invoice` field and the `collect` field. `invoiceCollect` is available only for backward compatibility.  If `true` (default), and a subscription is created, an invoice is generated at account creation time and payment is immediately collected using the account's default payment method.  This field is in Zuora REST API version control. Supported minor versions are 186.0, 187.0, 188.0, 189.0, and 196.0. See [Zuora REST API Versions](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. ")
  public Boolean getInvoiceCollect() {
    return invoiceCollect;
  }

  public void setInvoiceCollect(Boolean invoiceCollect) {
    this.invoiceCollect = invoiceCollect;
  }

  public POSTAccountType invoiceTargetDate(LocalDate invoiceTargetDate) {
    this.invoiceTargetDate = invoiceTargetDate;
    return this;
  }

   /**
   * If `invoiceCollect` is true, the target date for the invoice (that is, the date through which charges should be calculated). In `yyyy-mm-dd` format; defaults to the current date. 
   * @return invoiceTargetDate
  **/
  @ApiModelProperty(example = "null", value = "If `invoiceCollect` is true, the target date for the invoice (that is, the date through which charges should be calculated). In `yyyy-mm-dd` format; defaults to the current date. ")
  public LocalDate getInvoiceTargetDate() {
    return invoiceTargetDate;
  }

  public void setInvoiceTargetDate(LocalDate invoiceTargetDate) {
    this.invoiceTargetDate = invoiceTargetDate;
  }

  public POSTAccountType invoiceTemplateId(String invoiceTemplateId) {
    this.invoiceTemplateId = invoiceTemplateId;
    return this;
  }

   /**
   * Invoice template ID, configured in [Billing Settings in the Zuora UI](https://knowledgecenter.zuora.com/CB_Billing/IA_Invoices/Creating_a_Custom_Invoice_Template). 
   * @return invoiceTemplateId
  **/
  @ApiModelProperty(example = "null", value = "Invoice template ID, configured in [Billing Settings in the Zuora UI](https://knowledgecenter.zuora.com/CB_Billing/IA_Invoices/Creating_a_Custom_Invoice_Template). ")
  public String getInvoiceTemplateId() {
    return invoiceTemplateId;
  }

  public void setInvoiceTemplateId(String invoiceTemplateId) {
    this.invoiceTemplateId = invoiceTemplateId;
  }

  public POSTAccountType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Account name, up to 255 characters. 
   * @return name
  **/
  @ApiModelProperty(example = "null", required = true, value = "Account name, up to 255 characters. ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public POSTAccountType notes(String notes) {
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

  public POSTAccountType paymentGateway(String paymentGateway) {
    this.paymentGateway = paymentGateway;
    return this;
  }

   /**
   * The name of the payment gateway instance. If null or left unassigned, the Account will use the Default Gateway. 
   * @return paymentGateway
  **/
  @ApiModelProperty(example = "null", value = "The name of the payment gateway instance. If null or left unassigned, the Account will use the Default Gateway. ")
  public String getPaymentGateway() {
    return paymentGateway;
  }

  public void setPaymentGateway(String paymentGateway) {
    this.paymentGateway = paymentGateway;
  }

  public POSTAccountType paymentTerm(String paymentTerm) {
    this.paymentTerm = paymentTerm;
    return this;
  }

   /**
   * Payment terms for this account. Possible values are: `Due Upon Receipt`, `Net 30`, `Net 60`, `Net 90`. 
   * @return paymentTerm
  **/
  @ApiModelProperty(example = "null", value = "Payment terms for this account. Possible values are: `Due Upon Receipt`, `Net 30`, `Net 60`, `Net 90`. ")
  public String getPaymentTerm() {
    return paymentTerm;
  }

  public void setPaymentTerm(String paymentTerm) {
    this.paymentTerm = paymentTerm;
  }

  public POSTAccountType soldToContact(POSTAccountTypeSoldToContact soldToContact) {
    this.soldToContact = soldToContact;
    return this;
  }

   /**
   * Get soldToContact
   * @return soldToContact
  **/
  @ApiModelProperty(example = "null", value = "")
  public POSTAccountTypeSoldToContact getSoldToContact() {
    return soldToContact;
  }

  public void setSoldToContact(POSTAccountTypeSoldToContact soldToContact) {
    this.soldToContact = soldToContact;
  }

  public POSTAccountType subscription(POSTAccountTypeSubscription subscription) {
    this.subscription = subscription;
    return this;
  }

   /**
   * Get subscription
   * @return subscription
  **/
  @ApiModelProperty(example = "null", value = "")
  public POSTAccountTypeSubscription getSubscription() {
    return subscription;
  }

  public void setSubscription(POSTAccountTypeSubscription subscription) {
    this.subscription = subscription;
  }

  public POSTAccountType tagging(String tagging) {
    this.tagging = tagging;
    return this;
  }

   /**
   * dummy
   * @return tagging
  **/
  @ApiModelProperty(example = "null", value = "dummy")
  public String getTagging() {
    return tagging;
  }

  public void setTagging(String tagging) {
    this.tagging = tagging;
  }

  public POSTAccountType taxInfo(POSTAccountTypeTaxInfo taxInfo) {
    this.taxInfo = taxInfo;
    return this;
  }

   /**
   * Get taxInfo
   * @return taxInfo
  **/
  @ApiModelProperty(example = "null", value = "")
  public POSTAccountTypeTaxInfo getTaxInfo() {
    return taxInfo;
  }

  public void setTaxInfo(POSTAccountTypeTaxInfo taxInfo) {
    this.taxInfo = taxInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    POSTAccountType pOSTAccountType = (POSTAccountType) o;
    return Objects.equals(this.accountNumber, pOSTAccountType.accountNumber) &&
        Objects.equals(this.applyCreditBalance, pOSTAccountType.applyCreditBalance) &&
        Objects.equals(this.autoPay, pOSTAccountType.autoPay) &&
        Objects.equals(this.batch, pOSTAccountType.batch) &&
        Objects.equals(this.billCycleDay, pOSTAccountType.billCycleDay) &&
        Objects.equals(this.billToContact, pOSTAccountType.billToContact) &&
        Objects.equals(this.collect, pOSTAccountType.collect) &&
        Objects.equals(this.communicationProfileId, pOSTAccountType.communicationProfileId) &&
        Objects.equals(this.creditCard, pOSTAccountType.creditCard) &&
        Objects.equals(this.crmId, pOSTAccountType.crmId) &&
        Objects.equals(this.currency, pOSTAccountType.currency) &&
        Objects.equals(this.customFieldC, pOSTAccountType.customFieldC) &&
        Objects.equals(this.hpmCreditCardPaymentMethodId, pOSTAccountType.hpmCreditCardPaymentMethodId) &&
        Objects.equals(this.invoice, pOSTAccountType.invoice) &&
        Objects.equals(this.invoiceCollect, pOSTAccountType.invoiceCollect) &&
        Objects.equals(this.invoiceTargetDate, pOSTAccountType.invoiceTargetDate) &&
        Objects.equals(this.invoiceTemplateId, pOSTAccountType.invoiceTemplateId) &&
        Objects.equals(this.name, pOSTAccountType.name) &&
        Objects.equals(this.notes, pOSTAccountType.notes) &&
        Objects.equals(this.paymentGateway, pOSTAccountType.paymentGateway) &&
        Objects.equals(this.paymentTerm, pOSTAccountType.paymentTerm) &&
        Objects.equals(this.soldToContact, pOSTAccountType.soldToContact) &&
        Objects.equals(this.subscription, pOSTAccountType.subscription) &&
        Objects.equals(this.tagging, pOSTAccountType.tagging) &&
        Objects.equals(this.taxInfo, pOSTAccountType.taxInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber, applyCreditBalance, autoPay, batch, billCycleDay, billToContact, collect, communicationProfileId, creditCard, crmId, currency, customFieldC, hpmCreditCardPaymentMethodId, invoice, invoiceCollect, invoiceTargetDate, invoiceTemplateId, name, notes, paymentGateway, paymentTerm, soldToContact, subscription, tagging, taxInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class POSTAccountType {\n");
    
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    applyCreditBalance: ").append(toIndentedString(applyCreditBalance)).append("\n");
    sb.append("    autoPay: ").append(toIndentedString(autoPay)).append("\n");
    sb.append("    batch: ").append(toIndentedString(batch)).append("\n");
    sb.append("    billCycleDay: ").append(toIndentedString(billCycleDay)).append("\n");
    sb.append("    billToContact: ").append(toIndentedString(billToContact)).append("\n");
    sb.append("    collect: ").append(toIndentedString(collect)).append("\n");
    sb.append("    communicationProfileId: ").append(toIndentedString(communicationProfileId)).append("\n");
    sb.append("    creditCard: ").append(toIndentedString(creditCard)).append("\n");
    sb.append("    crmId: ").append(toIndentedString(crmId)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    customFieldC: ").append(toIndentedString(customFieldC)).append("\n");
    sb.append("    hpmCreditCardPaymentMethodId: ").append(toIndentedString(hpmCreditCardPaymentMethodId)).append("\n");
    sb.append("    invoice: ").append(toIndentedString(invoice)).append("\n");
    sb.append("    invoiceCollect: ").append(toIndentedString(invoiceCollect)).append("\n");
    sb.append("    invoiceTargetDate: ").append(toIndentedString(invoiceTargetDate)).append("\n");
    sb.append("    invoiceTemplateId: ").append(toIndentedString(invoiceTemplateId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    paymentGateway: ").append(toIndentedString(paymentGateway)).append("\n");
    sb.append("    paymentTerm: ").append(toIndentedString(paymentTerm)).append("\n");
    sb.append("    soldToContact: ").append(toIndentedString(soldToContact)).append("\n");
    sb.append("    subscription: ").append(toIndentedString(subscription)).append("\n");
    sb.append("    tagging: ").append(toIndentedString(tagging)).append("\n");
    sb.append("    taxInfo: ").append(toIndentedString(taxInfo)).append("\n");
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

