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
import org.joda.time.DateTime;
import org.joda.time.LocalDate;


/**
 * ProxyGetAccount
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class ProxyGetAccount   {
  @SerializedName("AccountNumber")
  private String accountNumber = null;

  @SerializedName("AdditionalEmailAddresses")
  private String additionalEmailAddresses = null;

  @SerializedName("AllowInvoiceEdit")
  private Boolean allowInvoiceEdit = null;

  @SerializedName("AutoPay")
  private Boolean autoPay = null;

  @SerializedName("Balance")
  private Double balance = null;

  @SerializedName("Batch")
  private String batch = null;

  @SerializedName("BcdSettingOption")
  private String bcdSettingOption = null;

  @SerializedName("BillCycleDay")
  private Integer billCycleDay = null;

  @SerializedName("BillToId")
  private String billToId = null;

  @SerializedName("CommunicationProfileId")
  private String communicationProfileId = null;

  @SerializedName("CreatedById")
  private String createdById = null;

  @SerializedName("CreatedDate")
  private DateTime createdDate = null;

  @SerializedName("CreditBalance")
  private Double creditBalance = null;

  @SerializedName("CrmId")
  private String crmId = null;

  @SerializedName("Currency")
  private String currency = null;

  @SerializedName("CustomerServiceRepName")
  private String customerServiceRepName = null;

  @SerializedName("DefaultPaymentMethodId")
  private String defaultPaymentMethodId = null;

  @SerializedName("Id")
  private String id = null;

  @SerializedName("InvoiceDeliveryPrefsEmail")
  private Boolean invoiceDeliveryPrefsEmail = null;

  @SerializedName("InvoiceDeliveryPrefsPrint")
  private Boolean invoiceDeliveryPrefsPrint = null;

  @SerializedName("InvoiceTemplateId")
  private String invoiceTemplateId = null;

  @SerializedName("LastInvoiceDate")
  private LocalDate lastInvoiceDate = null;

  @SerializedName("Name")
  private String name = null;

  @SerializedName("Notes")
  private String notes = null;

  @SerializedName("ParentId")
  private String parentId = null;

  @SerializedName("PaymentGateway")
  private String paymentGateway = null;

  @SerializedName("PaymentTerm")
  private String paymentTerm = null;

  @SerializedName("PurchaseOrderNumber")
  private String purchaseOrderNumber = null;

  @SerializedName("SalesRepName")
  private String salesRepName = null;

  @SerializedName("SoldToId")
  private String soldToId = null;

  @SerializedName("Status")
  private String status = null;

  @SerializedName("TaxCompanyCode")
  private String taxCompanyCode = null;

  @SerializedName("TaxExemptCertificateID")
  private String taxExemptCertificateID = null;

  @SerializedName("TaxExemptCertificateType")
  private String taxExemptCertificateType = null;

  @SerializedName("TaxExemptDescription")
  private String taxExemptDescription = null;

  @SerializedName("TaxExemptEffectiveDate")
  private LocalDate taxExemptEffectiveDate = null;

  @SerializedName("TaxExemptExpirationDate")
  private LocalDate taxExemptExpirationDate = null;

  @SerializedName("TaxExemptIssuingJurisdiction")
  private String taxExemptIssuingJurisdiction = null;

  @SerializedName("TaxExemptStatus")
  private String taxExemptStatus = null;

  @SerializedName("TotalInvoiceBalance")
  private Double totalInvoiceBalance = null;

  @SerializedName("UpdatedById")
  private String updatedById = null;

  @SerializedName("UpdatedDate")
  private DateTime updatedDate = null;

  @SerializedName("VATId")
  private String vATId = null;

  public ProxyGetAccount accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

   /**
   * Unique account number assigned to the account. **Character limit**: 50 **Values**: one of the following:  - null to auto-generate - a string of 50 characters or fewer that doesn't begin with the default account number prefix 
   * @return accountNumber
  **/
  @ApiModelProperty(example = "null", value = "Unique account number assigned to the account. **Character limit**: 50 **Values**: one of the following:  - null to auto-generate - a string of 50 characters or fewer that doesn't begin with the default account number prefix ")
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public ProxyGetAccount additionalEmailAddresses(String additionalEmailAddresses) {
    this.additionalEmailAddresses = additionalEmailAddresses;
    return this;
  }

   /**
   * List of additional email addresses to receive emailed invoices. **Character limit**: 120 **Values**: comma-separated list of email addresses 
   * @return additionalEmailAddresses
  **/
  @ApiModelProperty(example = "null", value = "List of additional email addresses to receive emailed invoices. **Character limit**: 120 **Values**: comma-separated list of email addresses ")
  public String getAdditionalEmailAddresses() {
    return additionalEmailAddresses;
  }

  public void setAdditionalEmailAddresses(String additionalEmailAddresses) {
    this.additionalEmailAddresses = additionalEmailAddresses;
  }

  public ProxyGetAccount allowInvoiceEdit(Boolean allowInvoiceEdit) {
    this.allowInvoiceEdit = allowInvoiceEdit;
    return this;
  }

   /**
   *  Indicates if associated invoices can be edited. **Character limit**: 5 **Values**: `true`, `false` (default if left null) 
   * @return allowInvoiceEdit
  **/
  @ApiModelProperty(example = "null", value = " Indicates if associated invoices can be edited. **Character limit**: 5 **Values**: `true`, `false` (default if left null) ")
  public Boolean getAllowInvoiceEdit() {
    return allowInvoiceEdit;
  }

  public void setAllowInvoiceEdit(Boolean allowInvoiceEdit) {
    this.allowInvoiceEdit = allowInvoiceEdit;
  }

  public ProxyGetAccount autoPay(Boolean autoPay) {
    this.autoPay = autoPay;
    return this;
  }

   /**
   *  Indicates if future payments are automatically collected when they're due during a Payment Run. **Character limit**: 5 **Values**: `true`, `false` (default) 
   * @return autoPay
  **/
  @ApiModelProperty(example = "null", value = " Indicates if future payments are automatically collected when they're due during a Payment Run. **Character limit**: 5 **Values**: `true`, `false` (default) ")
  public Boolean getAutoPay() {
    return autoPay;
  }

  public void setAutoPay(Boolean autoPay) {
    this.autoPay = autoPay;
  }

  public ProxyGetAccount balance(Double balance) {
    this.balance = balance;
    return this;
  }

   /**
   * Current outstanding balance for the account. **Character limit**: 16 **Values**: automatically generated 
   * @return balance
  **/
  @ApiModelProperty(example = "null", value = "Current outstanding balance for the account. **Character limit**: 16 **Values**: automatically generated ")
  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public ProxyGetAccount batch(String batch) {
    this.batch = batch;
    return this;
  }

   /**
   *  Organizes your customer accounts into groups to optimize your billing and payment operations. Required if use the [subscribe()](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E_SOAP_API_Calls/subscribe_call) call, optional for other supported calls. **Character limit**: 20 **Values**:any system-defined batch (`Batch1` - `Batch50 `or by name). 
   * @return batch
  **/
  @ApiModelProperty(example = "null", value = " Organizes your customer accounts into groups to optimize your billing and payment operations. Required if use the [subscribe()](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E_SOAP_API_Calls/subscribe_call) call, optional for other supported calls. **Character limit**: 20 **Values**:any system-defined batch (`Batch1` - `Batch50 `or by name). ")
  public String getBatch() {
    return batch;
  }

  public void setBatch(String batch) {
    this.batch = batch;
  }

  public ProxyGetAccount bcdSettingOption(String bcdSettingOption) {
    this.bcdSettingOption = bcdSettingOption;
    return this;
  }

   /**
   * Billing cycle day setting option. **Character limit**: 9 **Values**: `AutoSet`, `ManualSet` 
   * @return bcdSettingOption
  **/
  @ApiModelProperty(example = "null", value = "Billing cycle day setting option. **Character limit**: 9 **Values**: `AutoSet`, `ManualSet` ")
  public String getBcdSettingOption() {
    return bcdSettingOption;
  }

  public void setBcdSettingOption(String bcdSettingOption) {
    this.bcdSettingOption = bcdSettingOption;
  }

  public ProxyGetAccount billCycleDay(Integer billCycleDay) {
    this.billCycleDay = billCycleDay;
    return this;
  }

   /**
   * Billing cycle day (BCD) on which bill runs generate invoices for the account. **Character limit**: 2 **Values**: any activated system-defined bill cycle day (`1` - `31`) 
   * @return billCycleDay
  **/
  @ApiModelProperty(example = "null", value = "Billing cycle day (BCD) on which bill runs generate invoices for the account. **Character limit**: 2 **Values**: any activated system-defined bill cycle day (`1` - `31`) ")
  public Integer getBillCycleDay() {
    return billCycleDay;
  }

  public void setBillCycleDay(Integer billCycleDay) {
    this.billCycleDay = billCycleDay;
  }

  public ProxyGetAccount billToId(String billToId) {
    this.billToId = billToId;
    return this;
  }

   /**
   * ID of the person to bill for the account. **Character limit**: 32 **Values**: a valid contact ID for the account 
   * @return billToId
  **/
  @ApiModelProperty(example = "null", value = "ID of the person to bill for the account. **Character limit**: 32 **Values**: a valid contact ID for the account ")
  public String getBillToId() {
    return billToId;
  }

  public void setBillToId(String billToId) {
    this.billToId = billToId;
  }

  public ProxyGetAccount communicationProfileId(String communicationProfileId) {
    this.communicationProfileId = communicationProfileId;
    return this;
  }

   /**
   * Associates the account with a specified communication profile. **Character limit**: 32 **Values**: a valid communication profile ID 
   * @return communicationProfileId
  **/
  @ApiModelProperty(example = "null", value = "Associates the account with a specified communication profile. **Character limit**: 32 **Values**: a valid communication profile ID ")
  public String getCommunicationProfileId() {
    return communicationProfileId;
  }

  public void setCommunicationProfileId(String communicationProfileId) {
    this.communicationProfileId = communicationProfileId;
  }

  public ProxyGetAccount createdById(String createdById) {
    this.createdById = createdById;
    return this;
  }

   /**
   * ID of the Zuora user who created the Account object. **Character limit**: 32 **Values**: automatically generated 
   * @return createdById
  **/
  @ApiModelProperty(example = "null", value = "ID of the Zuora user who created the Account object. **Character limit**: 32 **Values**: automatically generated ")
  public String getCreatedById() {
    return createdById;
  }

  public void setCreatedById(String createdById) {
    this.createdById = createdById;
  }

  public ProxyGetAccount createdDate(DateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }

   /**
   * Date when the Account object was created. **Character limit**: 29 **Values**: automatically generated 
   * @return createdDate
  **/
  @ApiModelProperty(example = "null", value = "Date when the Account object was created. **Character limit**: 29 **Values**: automatically generated ")
  public DateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(DateTime createdDate) {
    this.createdDate = createdDate;
  }

  public ProxyGetAccount creditBalance(Double creditBalance) {
    this.creditBalance = creditBalance;
    return this;
  }

   /**
   * Total credit balance for the account. **Character limit**: 16 **Values**: automatically generated 
   * @return creditBalance
  **/
  @ApiModelProperty(example = "null", value = "Total credit balance for the account. **Character limit**: 16 **Values**: automatically generated ")
  public Double getCreditBalance() {
    return creditBalance;
  }

  public void setCreditBalance(Double creditBalance) {
    this.creditBalance = creditBalance;
  }

  public ProxyGetAccount crmId(String crmId) {
    this.crmId = crmId;
    return this;
  }

   /**
   * CRM account ID for the account. A CRM is a customer relationship management system, such as Salesforce.com. **Character limit**: 100 **Values**: a string of 100 characters or fewer 
   * @return crmId
  **/
  @ApiModelProperty(example = "null", value = "CRM account ID for the account. A CRM is a customer relationship management system, such as Salesforce.com. **Character limit**: 100 **Values**: a string of 100 characters or fewer ")
  public String getCrmId() {
    return crmId;
  }

  public void setCrmId(String crmId) {
    this.crmId = crmId;
  }

  public ProxyGetAccount currency(String currency) {
    this.currency = currency;
    return this;
  }

   /**
   *  Currency that the customer is billed in. See [a currency value defined in the Zuora Ui admin settings](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Customize_Currencies) 
   * @return currency
  **/
  @ApiModelProperty(example = "null", value = " Currency that the customer is billed in. See [a currency value defined in the Zuora Ui admin settings](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Customize_Currencies) ")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public ProxyGetAccount customerServiceRepName(String customerServiceRepName) {
    this.customerServiceRepName = customerServiceRepName;
    return this;
  }

   /**
   * Name of the account's customer service representative, if applicable. **Character limit**: 50 **Values**: a string of 50 characters or fewer 
   * @return customerServiceRepName
  **/
  @ApiModelProperty(example = "null", value = "Name of the account's customer service representative, if applicable. **Character limit**: 50 **Values**: a string of 50 characters or fewer ")
  public String getCustomerServiceRepName() {
    return customerServiceRepName;
  }

  public void setCustomerServiceRepName(String customerServiceRepName) {
    this.customerServiceRepName = customerServiceRepName;
  }

  public ProxyGetAccount defaultPaymentMethodId(String defaultPaymentMethodId) {
    this.defaultPaymentMethodId = defaultPaymentMethodId;
    return this;
  }

   /**
   * ID of the default payment method for the account. This field is required if the AutoPay field is set to `true`. **Character limit**: 32 **Values**: [a valid ID for an existing payment method](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/PaymentMethod) 
   * @return defaultPaymentMethodId
  **/
  @ApiModelProperty(example = "null", value = "ID of the default payment method for the account. This field is required if the AutoPay field is set to `true`. **Character limit**: 32 **Values**: [a valid ID for an existing payment method](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/PaymentMethod) ")
  public String getDefaultPaymentMethodId() {
    return defaultPaymentMethodId;
  }

  public void setDefaultPaymentMethodId(String defaultPaymentMethodId) {
    this.defaultPaymentMethodId = defaultPaymentMethodId;
  }

  public ProxyGetAccount id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Object identifier.
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "Object identifier.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProxyGetAccount invoiceDeliveryPrefsEmail(Boolean invoiceDeliveryPrefsEmail) {
    this.invoiceDeliveryPrefsEmail = invoiceDeliveryPrefsEmail;
    return this;
  }

   /**
   * Indicates if the customer wants to receive invoices through email.  **Character limit**: 5 **Values**: `true`, `false` (default if left null) 
   * @return invoiceDeliveryPrefsEmail
  **/
  @ApiModelProperty(example = "null", value = "Indicates if the customer wants to receive invoices through email.  **Character limit**: 5 **Values**: `true`, `false` (default if left null) ")
  public Boolean getInvoiceDeliveryPrefsEmail() {
    return invoiceDeliveryPrefsEmail;
  }

  public void setInvoiceDeliveryPrefsEmail(Boolean invoiceDeliveryPrefsEmail) {
    this.invoiceDeliveryPrefsEmail = invoiceDeliveryPrefsEmail;
  }

  public ProxyGetAccount invoiceDeliveryPrefsPrint(Boolean invoiceDeliveryPrefsPrint) {
    this.invoiceDeliveryPrefsPrint = invoiceDeliveryPrefsPrint;
    return this;
  }

   /**
   * Indicates if the customer wants to receive printed invoices, such as through postal mail. **Character limit**: 5 **Values**: `true`, `false` (default if left null) 
   * @return invoiceDeliveryPrefsPrint
  **/
  @ApiModelProperty(example = "null", value = "Indicates if the customer wants to receive printed invoices, such as through postal mail. **Character limit**: 5 **Values**: `true`, `false` (default if left null) ")
  public Boolean getInvoiceDeliveryPrefsPrint() {
    return invoiceDeliveryPrefsPrint;
  }

  public void setInvoiceDeliveryPrefsPrint(Boolean invoiceDeliveryPrefsPrint) {
    this.invoiceDeliveryPrefsPrint = invoiceDeliveryPrefsPrint;
  }

  public ProxyGetAccount invoiceTemplateId(String invoiceTemplateId) {
    this.invoiceTemplateId = invoiceTemplateId;
    return this;
  }

   /**
   * The ID of the invoice template. Each customer account can use a specific invoice template for invoice generation. **Character limit**: 32 **Values**: a[ valid template ID configured in Z-Billing Settings](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Manage_Invoice_Rules_and_Templates) To find the ID of your current invoice template: In Zuora, navigate to **Settings > Z-Billing > Manage Invoice Rules and Templates** and click **Show Id **next to the template you want to use.   
   * @return invoiceTemplateId
  **/
  @ApiModelProperty(example = "null", value = "The ID of the invoice template. Each customer account can use a specific invoice template for invoice generation. **Character limit**: 32 **Values**: a[ valid template ID configured in Z-Billing Settings](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Manage_Invoice_Rules_and_Templates) To find the ID of your current invoice template: In Zuora, navigate to **Settings > Z-Billing > Manage Invoice Rules and Templates** and click **Show Id **next to the template you want to use.   ")
  public String getInvoiceTemplateId() {
    return invoiceTemplateId;
  }

  public void setInvoiceTemplateId(String invoiceTemplateId) {
    this.invoiceTemplateId = invoiceTemplateId;
  }

  public ProxyGetAccount lastInvoiceDate(LocalDate lastInvoiceDate) {
    this.lastInvoiceDate = lastInvoiceDate;
    return this;
  }

   /**
   *  The date when the previous invoice was generated for the account. The field value is null if no invoice has ever been generated for the account. **Character limit**: 29 **Values**: automatically generated 
   * @return lastInvoiceDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the previous invoice was generated for the account. The field value is null if no invoice has ever been generated for the account. **Character limit**: 29 **Values**: automatically generated ")
  public LocalDate getLastInvoiceDate() {
    return lastInvoiceDate;
  }

  public void setLastInvoiceDate(LocalDate lastInvoiceDate) {
    this.lastInvoiceDate = lastInvoiceDate;
  }

  public ProxyGetAccount name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the account as displayed in the Zuora UI. **Character limit**: 255 **Values**: a string of 255 characters or fewer 
   * @return name
  **/
  @ApiModelProperty(example = "null", value = "Name of the account as displayed in the Zuora UI. **Character limit**: 255 **Values**: a string of 255 characters or fewer ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProxyGetAccount notes(String notes) {
    this.notes = notes;
    return this;
  }

   /**
   *  Comments about the account. **Character limit**: 65,535 **Values**: a string of 65,535 characters 
   * @return notes
  **/
  @ApiModelProperty(example = "null", value = " Comments about the account. **Character limit**: 65,535 **Values**: a string of 65,535 characters ")
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public ProxyGetAccount parentId(String parentId) {
    this.parentId = parentId;
    return this;
  }

   /**
   * Identifier of the parent customer account for this Account object. Use this field if you have customer hierarchy enabled. **Character limit**: 32 **Values**: [a valid account ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account#Id) 
   * @return parentId
  **/
  @ApiModelProperty(example = "null", value = "Identifier of the parent customer account for this Account object. Use this field if you have customer hierarchy enabled. **Character limit**: 32 **Values**: [a valid account ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account#Id) ")
  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public ProxyGetAccount paymentGateway(String paymentGateway) {
    this.paymentGateway = paymentGateway;
    return this;
  }

   /**
   * Gateway used for processing electronic payments and refunds. **Character limit**: 40 **Values**: one of the following:  - a valid configured gateway name - Null to inherit the default value set in Z-Payment Settings 
   * @return paymentGateway
  **/
  @ApiModelProperty(example = "null", value = "Gateway used for processing electronic payments and refunds. **Character limit**: 40 **Values**: one of the following:  - a valid configured gateway name - Null to inherit the default value set in Z-Payment Settings ")
  public String getPaymentGateway() {
    return paymentGateway;
  }

  public void setPaymentGateway(String paymentGateway) {
    this.paymentGateway = paymentGateway;
  }

  public ProxyGetAccount paymentTerm(String paymentTerm) {
    this.paymentTerm = paymentTerm;
    return this;
  }

   /**
   * Indicates when the customer pays for subscriptions. **Character limit**: 100 **Values**: [a valid, active payment term defined in the web-based UI administrative settings](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Payment_Terms) 
   * @return paymentTerm
  **/
  @ApiModelProperty(example = "null", value = "Indicates when the customer pays for subscriptions. **Character limit**: 100 **Values**: [a valid, active payment term defined in the web-based UI administrative settings](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Payment_Terms) ")
  public String getPaymentTerm() {
    return paymentTerm;
  }

  public void setPaymentTerm(String paymentTerm) {
    this.paymentTerm = paymentTerm;
  }

  public ProxyGetAccount purchaseOrderNumber(String purchaseOrderNumber) {
    this.purchaseOrderNumber = purchaseOrderNumber;
    return this;
  }

   /**
   * The number of the purchase order associated with this account. Purchase order information generally comes from customers. **Character limit**: 100 **Values**: a string of 100 characters or fewer 
   * @return purchaseOrderNumber
  **/
  @ApiModelProperty(example = "null", value = "The number of the purchase order associated with this account. Purchase order information generally comes from customers. **Character limit**: 100 **Values**: a string of 100 characters or fewer ")
  public String getPurchaseOrderNumber() {
    return purchaseOrderNumber;
  }

  public void setPurchaseOrderNumber(String purchaseOrderNumber) {
    this.purchaseOrderNumber = purchaseOrderNumber;
  }

  public ProxyGetAccount salesRepName(String salesRepName) {
    this.salesRepName = salesRepName;
    return this;
  }

   /**
   * The name of the sales representative associated with this account, if applicable. **Character limit**: 50 **Values**: a string of 50 characters or fewer 
   * @return salesRepName
  **/
  @ApiModelProperty(example = "null", value = "The name of the sales representative associated with this account, if applicable. **Character limit**: 50 **Values**: a string of 50 characters or fewer ")
  public String getSalesRepName() {
    return salesRepName;
  }

  public void setSalesRepName(String salesRepName) {
    this.salesRepName = salesRepName;
  }

  public ProxyGetAccount soldToId(String soldToId) {
    this.soldToId = soldToId;
    return this;
  }

   /**
   * ID of the person who bought the subscription associated with the account. **Character limit**: 32 **Values**: [a valid contact ID for the account](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Contact) 
   * @return soldToId
  **/
  @ApiModelProperty(example = "null", value = "ID of the person who bought the subscription associated with the account. **Character limit**: 32 **Values**: [a valid contact ID for the account](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Contact) ")
  public String getSoldToId() {
    return soldToId;
  }

  public void setSoldToId(String soldToId) {
    this.soldToId = soldToId;
  }

  public ProxyGetAccount status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Status of the account in the system. **Character limit**: 8 **Values**: one of the following:  - leave null if you're using `subscribe()` - if you're using `create()`: - `Draft` - `Active` - `Canceled` 
   * @return status
  **/
  @ApiModelProperty(example = "null", value = "Status of the account in the system. **Character limit**: 8 **Values**: one of the following:  - leave null if you're using `subscribe()` - if you're using `create()`: - `Draft` - `Active` - `Canceled` ")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ProxyGetAccount taxCompanyCode(String taxCompanyCode) {
    this.taxCompanyCode = taxCompanyCode;
    return this;
  }

   /**
   *  Unique code that identifies a company account in Avalara. Use this field to calculate taxes based on origin and sold-to addresses in Avalara. This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  **Character limit**: 50 **Values**: a valid company code 
   * @return taxCompanyCode
  **/
  @ApiModelProperty(example = "null", value = " Unique code that identifies a company account in Avalara. Use this field to calculate taxes based on origin and sold-to addresses in Avalara. This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  **Character limit**: 50 **Values**: a valid company code ")
  public String getTaxCompanyCode() {
    return taxCompanyCode;
  }

  public void setTaxCompanyCode(String taxCompanyCode) {
    this.taxCompanyCode = taxCompanyCode;
  }

  public ProxyGetAccount taxExemptCertificateID(String taxExemptCertificateID) {
    this.taxExemptCertificateID = taxExemptCertificateID;
    return this;
  }

   /**
   * ID of your customer's tax exemption certificate. **Character limit**: 32 **Values**: a string of 32 characters or fewer 
   * @return taxExemptCertificateID
  **/
  @ApiModelProperty(example = "null", value = "ID of your customer's tax exemption certificate. **Character limit**: 32 **Values**: a string of 32 characters or fewer ")
  public String getTaxExemptCertificateID() {
    return taxExemptCertificateID;
  }

  public void setTaxExemptCertificateID(String taxExemptCertificateID) {
    this.taxExemptCertificateID = taxExemptCertificateID;
  }

  public ProxyGetAccount taxExemptCertificateType(String taxExemptCertificateType) {
    this.taxExemptCertificateType = taxExemptCertificateType;
    return this;
  }

   /**
   * Type of the tax exemption certificate that your customer holds.  **Character limit**: 32 **Values**: a string of 32 characters or fewer 
   * @return taxExemptCertificateType
  **/
  @ApiModelProperty(example = "null", value = "Type of the tax exemption certificate that your customer holds.  **Character limit**: 32 **Values**: a string of 32 characters or fewer ")
  public String getTaxExemptCertificateType() {
    return taxExemptCertificateType;
  }

  public void setTaxExemptCertificateType(String taxExemptCertificateType) {
    this.taxExemptCertificateType = taxExemptCertificateType;
  }

  public ProxyGetAccount taxExemptDescription(String taxExemptDescription) {
    this.taxExemptDescription = taxExemptDescription;
    return this;
  }

   /**
   * Description of the tax exemption certificate that your customer holds. **Character limit**: 500 **Values**: a string of 500 characters or fewer 
   * @return taxExemptDescription
  **/
  @ApiModelProperty(example = "null", value = "Description of the tax exemption certificate that your customer holds. **Character limit**: 500 **Values**: a string of 500 characters or fewer ")
  public String getTaxExemptDescription() {
    return taxExemptDescription;
  }

  public void setTaxExemptDescription(String taxExemptDescription) {
    this.taxExemptDescription = taxExemptDescription;
  }

  public ProxyGetAccount taxExemptEffectiveDate(LocalDate taxExemptEffectiveDate) {
    this.taxExemptEffectiveDate = taxExemptEffectiveDate;
    return this;
  }

   /**
   * Date when the the customer's tax exemption starts. **Character limit**: 29 **Version notes**: requires Z-Tax 
   * @return taxExemptEffectiveDate
  **/
  @ApiModelProperty(example = "null", value = "Date when the the customer's tax exemption starts. **Character limit**: 29 **Version notes**: requires Z-Tax ")
  public LocalDate getTaxExemptEffectiveDate() {
    return taxExemptEffectiveDate;
  }

  public void setTaxExemptEffectiveDate(LocalDate taxExemptEffectiveDate) {
    this.taxExemptEffectiveDate = taxExemptEffectiveDate;
  }

  public ProxyGetAccount taxExemptExpirationDate(LocalDate taxExemptExpirationDate) {
    this.taxExemptExpirationDate = taxExemptExpirationDate;
    return this;
  }

   /**
   * Date when the customer's tax exemption certificate expires  **Character limit**: 29 **Version notes**: requires Z-Tax 
   * @return taxExemptExpirationDate
  **/
  @ApiModelProperty(example = "null", value = "Date when the customer's tax exemption certificate expires  **Character limit**: 29 **Version notes**: requires Z-Tax ")
  public LocalDate getTaxExemptExpirationDate() {
    return taxExemptExpirationDate;
  }

  public void setTaxExemptExpirationDate(LocalDate taxExemptExpirationDate) {
    this.taxExemptExpirationDate = taxExemptExpirationDate;
  }

  public ProxyGetAccount taxExemptIssuingJurisdiction(String taxExemptIssuingJurisdiction) {
    this.taxExemptIssuingJurisdiction = taxExemptIssuingJurisdiction;
    return this;
  }

   /**
   * Indicates the jurisdiction in which the customer's tax exemption certificate was issued. **Character limit**: 32 **Values**: a string of 32 characters or fewer 
   * @return taxExemptIssuingJurisdiction
  **/
  @ApiModelProperty(example = "null", value = "Indicates the jurisdiction in which the customer's tax exemption certificate was issued. **Character limit**: 32 **Values**: a string of 32 characters or fewer ")
  public String getTaxExemptIssuingJurisdiction() {
    return taxExemptIssuingJurisdiction;
  }

  public void setTaxExemptIssuingJurisdiction(String taxExemptIssuingJurisdiction) {
    this.taxExemptIssuingJurisdiction = taxExemptIssuingJurisdiction;
  }

  public ProxyGetAccount taxExemptStatus(String taxExemptStatus) {
    this.taxExemptStatus = taxExemptStatus;
    return this;
  }

   /**
   *  Status of the account's tax exemption. Required if you use Z-Tax. This field is unavailable if you don't use Z-Tax. **Character limit**: 19 **Values**: one of the following:  - `Yes` - `No` - `PendingVerification` 
   * @return taxExemptStatus
  **/
  @ApiModelProperty(example = "null", value = " Status of the account's tax exemption. Required if you use Z-Tax. This field is unavailable if you don't use Z-Tax. **Character limit**: 19 **Values**: one of the following:  - `Yes` - `No` - `PendingVerification` ")
  public String getTaxExemptStatus() {
    return taxExemptStatus;
  }

  public void setTaxExemptStatus(String taxExemptStatus) {
    this.taxExemptStatus = taxExemptStatus;
  }

  public ProxyGetAccount totalInvoiceBalance(Double totalInvoiceBalance) {
    this.totalInvoiceBalance = totalInvoiceBalance;
    return this;
  }

   /**
   * Total balance of the account's invoices. **Character limit**: 16 **Values**: a valid currency value 
   * @return totalInvoiceBalance
  **/
  @ApiModelProperty(example = "null", value = "Total balance of the account's invoices. **Character limit**: 16 **Values**: a valid currency value ")
  public Double getTotalInvoiceBalance() {
    return totalInvoiceBalance;
  }

  public void setTotalInvoiceBalance(Double totalInvoiceBalance) {
    this.totalInvoiceBalance = totalInvoiceBalance;
  }

  public ProxyGetAccount updatedById(String updatedById) {
    this.updatedById = updatedById;
    return this;
  }

   /**
   * ID of the user who last updated the account. **Character limit**: 32 **Values**: automatically generated 
   * @return updatedById
  **/
  @ApiModelProperty(example = "null", value = "ID of the user who last updated the account. **Character limit**: 32 **Values**: automatically generated ")
  public String getUpdatedById() {
    return updatedById;
  }

  public void setUpdatedById(String updatedById) {
    this.updatedById = updatedById;
  }

  public ProxyGetAccount updatedDate(DateTime updatedDate) {
    this.updatedDate = updatedDate;
    return this;
  }

   /**
   * Date when the account was last updated. **Character limit**: 29 **Values**: automatically generated 
   * @return updatedDate
  **/
  @ApiModelProperty(example = "null", value = "Date when the account was last updated. **Character limit**: 29 **Values**: automatically generated ")
  public DateTime getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(DateTime updatedDate) {
    this.updatedDate = updatedDate;
  }

  public ProxyGetAccount vATId(String vATId) {
    this.vATId = vATId;
    return this;
  }

   /**
   *  EU Value Added Tax ID. This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  **Character limit**: 25 **Values**: a valid Value Added Tax ID 
   * @return vATId
  **/
  @ApiModelProperty(example = "null", value = " EU Value Added Tax ID. This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  **Character limit**: 25 **Values**: a valid Value Added Tax ID ")
  public String getVATId() {
    return vATId;
  }

  public void setVATId(String vATId) {
    this.vATId = vATId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProxyGetAccount proxyGetAccount = (ProxyGetAccount) o;
    return Objects.equals(this.accountNumber, proxyGetAccount.accountNumber) &&
        Objects.equals(this.additionalEmailAddresses, proxyGetAccount.additionalEmailAddresses) &&
        Objects.equals(this.allowInvoiceEdit, proxyGetAccount.allowInvoiceEdit) &&
        Objects.equals(this.autoPay, proxyGetAccount.autoPay) &&
        Objects.equals(this.balance, proxyGetAccount.balance) &&
        Objects.equals(this.batch, proxyGetAccount.batch) &&
        Objects.equals(this.bcdSettingOption, proxyGetAccount.bcdSettingOption) &&
        Objects.equals(this.billCycleDay, proxyGetAccount.billCycleDay) &&
        Objects.equals(this.billToId, proxyGetAccount.billToId) &&
        Objects.equals(this.communicationProfileId, proxyGetAccount.communicationProfileId) &&
        Objects.equals(this.createdById, proxyGetAccount.createdById) &&
        Objects.equals(this.createdDate, proxyGetAccount.createdDate) &&
        Objects.equals(this.creditBalance, proxyGetAccount.creditBalance) &&
        Objects.equals(this.crmId, proxyGetAccount.crmId) &&
        Objects.equals(this.currency, proxyGetAccount.currency) &&
        Objects.equals(this.customerServiceRepName, proxyGetAccount.customerServiceRepName) &&
        Objects.equals(this.defaultPaymentMethodId, proxyGetAccount.defaultPaymentMethodId) &&
        Objects.equals(this.id, proxyGetAccount.id) &&
        Objects.equals(this.invoiceDeliveryPrefsEmail, proxyGetAccount.invoiceDeliveryPrefsEmail) &&
        Objects.equals(this.invoiceDeliveryPrefsPrint, proxyGetAccount.invoiceDeliveryPrefsPrint) &&
        Objects.equals(this.invoiceTemplateId, proxyGetAccount.invoiceTemplateId) &&
        Objects.equals(this.lastInvoiceDate, proxyGetAccount.lastInvoiceDate) &&
        Objects.equals(this.name, proxyGetAccount.name) &&
        Objects.equals(this.notes, proxyGetAccount.notes) &&
        Objects.equals(this.parentId, proxyGetAccount.parentId) &&
        Objects.equals(this.paymentGateway, proxyGetAccount.paymentGateway) &&
        Objects.equals(this.paymentTerm, proxyGetAccount.paymentTerm) &&
        Objects.equals(this.purchaseOrderNumber, proxyGetAccount.purchaseOrderNumber) &&
        Objects.equals(this.salesRepName, proxyGetAccount.salesRepName) &&
        Objects.equals(this.soldToId, proxyGetAccount.soldToId) &&
        Objects.equals(this.status, proxyGetAccount.status) &&
        Objects.equals(this.taxCompanyCode, proxyGetAccount.taxCompanyCode) &&
        Objects.equals(this.taxExemptCertificateID, proxyGetAccount.taxExemptCertificateID) &&
        Objects.equals(this.taxExemptCertificateType, proxyGetAccount.taxExemptCertificateType) &&
        Objects.equals(this.taxExemptDescription, proxyGetAccount.taxExemptDescription) &&
        Objects.equals(this.taxExemptEffectiveDate, proxyGetAccount.taxExemptEffectiveDate) &&
        Objects.equals(this.taxExemptExpirationDate, proxyGetAccount.taxExemptExpirationDate) &&
        Objects.equals(this.taxExemptIssuingJurisdiction, proxyGetAccount.taxExemptIssuingJurisdiction) &&
        Objects.equals(this.taxExemptStatus, proxyGetAccount.taxExemptStatus) &&
        Objects.equals(this.totalInvoiceBalance, proxyGetAccount.totalInvoiceBalance) &&
        Objects.equals(this.updatedById, proxyGetAccount.updatedById) &&
        Objects.equals(this.updatedDate, proxyGetAccount.updatedDate) &&
        Objects.equals(this.vATId, proxyGetAccount.vATId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber, additionalEmailAddresses, allowInvoiceEdit, autoPay, balance, batch, bcdSettingOption, billCycleDay, billToId, communicationProfileId, createdById, createdDate, creditBalance, crmId, currency, customerServiceRepName, defaultPaymentMethodId, id, invoiceDeliveryPrefsEmail, invoiceDeliveryPrefsPrint, invoiceTemplateId, lastInvoiceDate, name, notes, parentId, paymentGateway, paymentTerm, purchaseOrderNumber, salesRepName, soldToId, status, taxCompanyCode, taxExemptCertificateID, taxExemptCertificateType, taxExemptDescription, taxExemptEffectiveDate, taxExemptExpirationDate, taxExemptIssuingJurisdiction, taxExemptStatus, totalInvoiceBalance, updatedById, updatedDate, vATId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProxyGetAccount {\n");
    
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    additionalEmailAddresses: ").append(toIndentedString(additionalEmailAddresses)).append("\n");
    sb.append("    allowInvoiceEdit: ").append(toIndentedString(allowInvoiceEdit)).append("\n");
    sb.append("    autoPay: ").append(toIndentedString(autoPay)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    batch: ").append(toIndentedString(batch)).append("\n");
    sb.append("    bcdSettingOption: ").append(toIndentedString(bcdSettingOption)).append("\n");
    sb.append("    billCycleDay: ").append(toIndentedString(billCycleDay)).append("\n");
    sb.append("    billToId: ").append(toIndentedString(billToId)).append("\n");
    sb.append("    communicationProfileId: ").append(toIndentedString(communicationProfileId)).append("\n");
    sb.append("    createdById: ").append(toIndentedString(createdById)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    creditBalance: ").append(toIndentedString(creditBalance)).append("\n");
    sb.append("    crmId: ").append(toIndentedString(crmId)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    customerServiceRepName: ").append(toIndentedString(customerServiceRepName)).append("\n");
    sb.append("    defaultPaymentMethodId: ").append(toIndentedString(defaultPaymentMethodId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    invoiceDeliveryPrefsEmail: ").append(toIndentedString(invoiceDeliveryPrefsEmail)).append("\n");
    sb.append("    invoiceDeliveryPrefsPrint: ").append(toIndentedString(invoiceDeliveryPrefsPrint)).append("\n");
    sb.append("    invoiceTemplateId: ").append(toIndentedString(invoiceTemplateId)).append("\n");
    sb.append("    lastInvoiceDate: ").append(toIndentedString(lastInvoiceDate)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    paymentGateway: ").append(toIndentedString(paymentGateway)).append("\n");
    sb.append("    paymentTerm: ").append(toIndentedString(paymentTerm)).append("\n");
    sb.append("    purchaseOrderNumber: ").append(toIndentedString(purchaseOrderNumber)).append("\n");
    sb.append("    salesRepName: ").append(toIndentedString(salesRepName)).append("\n");
    sb.append("    soldToId: ").append(toIndentedString(soldToId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    taxCompanyCode: ").append(toIndentedString(taxCompanyCode)).append("\n");
    sb.append("    taxExemptCertificateID: ").append(toIndentedString(taxExemptCertificateID)).append("\n");
    sb.append("    taxExemptCertificateType: ").append(toIndentedString(taxExemptCertificateType)).append("\n");
    sb.append("    taxExemptDescription: ").append(toIndentedString(taxExemptDescription)).append("\n");
    sb.append("    taxExemptEffectiveDate: ").append(toIndentedString(taxExemptEffectiveDate)).append("\n");
    sb.append("    taxExemptExpirationDate: ").append(toIndentedString(taxExemptExpirationDate)).append("\n");
    sb.append("    taxExemptIssuingJurisdiction: ").append(toIndentedString(taxExemptIssuingJurisdiction)).append("\n");
    sb.append("    taxExemptStatus: ").append(toIndentedString(taxExemptStatus)).append("\n");
    sb.append("    totalInvoiceBalance: ").append(toIndentedString(totalInvoiceBalance)).append("\n");
    sb.append("    updatedById: ").append(toIndentedString(updatedById)).append("\n");
    sb.append("    updatedDate: ").append(toIndentedString(updatedDate)).append("\n");
    sb.append("    vATId: ").append(toIndentedString(vATId)).append("\n");
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

