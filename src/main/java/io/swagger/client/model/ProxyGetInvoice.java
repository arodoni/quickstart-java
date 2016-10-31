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
 * ProxyGetInvoice
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class ProxyGetInvoice   {
  @SerializedName("AccountId")
  private String accountId = null;

  @SerializedName("AdjustmentAmount")
  private Double adjustmentAmount = null;

  @SerializedName("Amount")
  private Double amount = null;

  @SerializedName("AmountWithoutTax")
  private Double amountWithoutTax = null;

  @SerializedName("Balance")
  private Double balance = null;

  @SerializedName("Body")
  private String body = null;

  @SerializedName("Comments")
  private String comments = null;

  @SerializedName("CreatedById")
  private String createdById = null;

  @SerializedName("CreatedDate")
  private DateTime createdDate = null;

  @SerializedName("CreditBalanceAdjustmentAmount")
  private Double creditBalanceAdjustmentAmount = null;

  @SerializedName("DueDate")
  private LocalDate dueDate = null;

  @SerializedName("Id")
  private String id = null;

  @SerializedName("IncludesOneTime")
  private Boolean includesOneTime = null;

  @SerializedName("IncludesRecurring")
  private Boolean includesRecurring = null;

  @SerializedName("IncludesUsage")
  private Boolean includesUsage = null;

  @SerializedName("InvoiceDate")
  private LocalDate invoiceDate = null;

  @SerializedName("InvoiceNumber")
  private String invoiceNumber = null;

  @SerializedName("LastEmailSentDate")
  private DateTime lastEmailSentDate = null;

  @SerializedName("PaymentAmount")
  private Double paymentAmount = null;

  @SerializedName("PostedBy")
  private String postedBy = null;

  @SerializedName("PostedDate")
  private DateTime postedDate = null;

  @SerializedName("RefundAmount")
  private Double refundAmount = null;

  @SerializedName("Status")
  private String status = null;

  @SerializedName("TargetDate")
  private LocalDate targetDate = null;

  @SerializedName("TaxAmount")
  private Double taxAmount = null;

  @SerializedName("TaxExemptAmount")
  private Double taxExemptAmount = null;

  @SerializedName("TransferredToAccounting")
  private String transferredToAccounting = null;

  @SerializedName("UpdatedById")
  private String updatedById = null;

  @SerializedName("UpdatedDate")
  private DateTime updatedDate = null;

  public ProxyGetInvoice accountId(String accountId) {
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

  public ProxyGetInvoice adjustmentAmount(Double adjustmentAmount) {
    this.adjustmentAmount = adjustmentAmount;
    return this;
  }

   /**
   *  The amount of the invoice adjustments associated with the invoice. **Character limi**t: 16 **Values**: a valid currency amount 
   * @return adjustmentAmount
  **/
  @ApiModelProperty(example = "null", value = " The amount of the invoice adjustments associated with the invoice. **Character limi**t: 16 **Values**: a valid currency amount ")
  public Double getAdjustmentAmount() {
    return adjustmentAmount;
  }

  public void setAdjustmentAmount(Double adjustmentAmount) {
    this.adjustmentAmount = adjustmentAmount;
  }

  public ProxyGetInvoice amount(Double amount) {
    this.amount = amount;
    return this;
  }

   /**
   *  The sum of all charges and taxes associated with the invoice. **Character limit**: 16 **Values**: automatically generated 
   * @return amount
  **/
  @ApiModelProperty(example = "null", value = " The sum of all charges and taxes associated with the invoice. **Character limit**: 16 **Values**: automatically generated ")
  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public ProxyGetInvoice amountWithoutTax(Double amountWithoutTax) {
    this.amountWithoutTax = amountWithoutTax;
    return this;
  }

   /**
   *  The sum of all charges associated with the invoice. Taxes are excluded from this value. **Character limit**: 16 **Values**: automatically generated 
   * @return amountWithoutTax
  **/
  @ApiModelProperty(example = "null", value = " The sum of all charges associated with the invoice. Taxes are excluded from this value. **Character limit**: 16 **Values**: automatically generated ")
  public Double getAmountWithoutTax() {
    return amountWithoutTax;
  }

  public void setAmountWithoutTax(Double amountWithoutTax) {
    this.amountWithoutTax = amountWithoutTax;
  }

  public ProxyGetInvoice balance(Double balance) {
    this.balance = balance;
    return this;
  }

   /**
   *  The remaining balance of the invoice after all payments, adjustments, and refunds are applied. **Character limit**: 16 **Values**: automatically generated 
   * @return balance
  **/
  @ApiModelProperty(example = "null", value = " The remaining balance of the invoice after all payments, adjustments, and refunds are applied. **Character limit**: 16 **Values**: automatically generated ")
  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public ProxyGetInvoice body(String body) {
    this.body = body;
    return this;
  }

   /**
   *  Required 
   * @return body
  **/
  @ApiModelProperty(example = "null", value = " Required ")
  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public ProxyGetInvoice comments(String comments) {
    this.comments = comments;
    return this;
  }

   /**
   *  Additional information related to the invoice that a Zuora user added to the invoice. **Character limit**: 255 **Values:** a string of 255 characters or fewer 
   * @return comments
  **/
  @ApiModelProperty(example = "null", value = " Additional information related to the invoice that a Zuora user added to the invoice. **Character limit**: 255 **Values:** a string of 255 characters or fewer ")
  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public ProxyGetInvoice createdById(String createdById) {
    this.createdById = createdById;
    return this;
  }

   /**
   *  The user ID of the person who created the invoice. If a bill run generated the invoice, then the value is the user ID of person who created the bill run. **Character limit**: 32 **Values**: automatically generated 
   * @return createdById
  **/
  @ApiModelProperty(example = "null", value = " The user ID of the person who created the invoice. If a bill run generated the invoice, then the value is the user ID of person who created the bill run. **Character limit**: 32 **Values**: automatically generated ")
  public String getCreatedById() {
    return createdById;
  }

  public void setCreatedById(String createdById) {
    this.createdById = createdById;
  }

  public ProxyGetInvoice createdDate(DateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }

   /**
   *  The date when the invoice was generated. **Character limit**: 29 **Values**: automatically generated 
   * @return createdDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the invoice was generated. **Character limit**: 29 **Values**: automatically generated ")
  public DateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(DateTime createdDate) {
    this.createdDate = createdDate;
  }

  public ProxyGetInvoice creditBalanceAdjustmentAmount(Double creditBalanceAdjustmentAmount) {
    this.creditBalanceAdjustmentAmount = creditBalanceAdjustmentAmount;
    return this;
  }

   /**
   *  The currency amount of the adjustment applied to the customer's credit balance. **Character limit**: 16 **Values**: a valid currency amount This field is only available if the [Zuora Global Support](http://support.zuora.com/) to enable this feature.   
   * @return creditBalanceAdjustmentAmount
  **/
  @ApiModelProperty(example = "null", value = " The currency amount of the adjustment applied to the customer's credit balance. **Character limit**: 16 **Values**: a valid currency amount This field is only available if the [Zuora Global Support](http://support.zuora.com/) to enable this feature.   ")
  public Double getCreditBalanceAdjustmentAmount() {
    return creditBalanceAdjustmentAmount;
  }

  public void setCreditBalanceAdjustmentAmount(Double creditBalanceAdjustmentAmount) {
    this.creditBalanceAdjustmentAmount = creditBalanceAdjustmentAmount;
  }

  public ProxyGetInvoice dueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
    return this;
  }

   /**
   *  The date by which the payment for this invoice is due. **Character limit**: 29 **Version notes**: -- 
   * @return dueDate
  **/
  @ApiModelProperty(example = "null", value = " The date by which the payment for this invoice is due. **Character limit**: 29 **Version notes**: -- ")
  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public ProxyGetInvoice id(String id) {
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

  public ProxyGetInvoice includesOneTime(Boolean includesOneTime) {
    this.includesOneTime = includesOneTime;
    return this;
  }

   /**
   *  Specifies whether the invoice includes one-time charges. You can use this field only with the `generate()` call for the Invoice object. **Character limit**: 5 **Values**: automatically generated from one of the following: `True` (default), `False` 
   * @return includesOneTime
  **/
  @ApiModelProperty(example = "null", value = " Specifies whether the invoice includes one-time charges. You can use this field only with the `generate()` call for the Invoice object. **Character limit**: 5 **Values**: automatically generated from one of the following: `True` (default), `False` ")
  public Boolean getIncludesOneTime() {
    return includesOneTime;
  }

  public void setIncludesOneTime(Boolean includesOneTime) {
    this.includesOneTime = includesOneTime;
  }

  public ProxyGetInvoice includesRecurring(Boolean includesRecurring) {
    this.includesRecurring = includesRecurring;
    return this;
  }

   /**
   *  Specifies whether the invoice includes recurring charges. You can use this field only with the `generate() `call for the Invoice object. **Character limit**: 5 **Values**: automatically generated from one of the following: `True` (default), `False` 
   * @return includesRecurring
  **/
  @ApiModelProperty(example = "null", value = " Specifies whether the invoice includes recurring charges. You can use this field only with the `generate() `call for the Invoice object. **Character limit**: 5 **Values**: automatically generated from one of the following: `True` (default), `False` ")
  public Boolean getIncludesRecurring() {
    return includesRecurring;
  }

  public void setIncludesRecurring(Boolean includesRecurring) {
    this.includesRecurring = includesRecurring;
  }

  public ProxyGetInvoice includesUsage(Boolean includesUsage) {
    this.includesUsage = includesUsage;
    return this;
  }

   /**
   *  Specifies whether the invoice includes usage charges. You can use this field only with the `generate() `call for the Invoice object. **Character limit**: 5 **Values**: automatically generated from one of the following: `True `(default), `False` 
   * @return includesUsage
  **/
  @ApiModelProperty(example = "null", value = " Specifies whether the invoice includes usage charges. You can use this field only with the `generate() `call for the Invoice object. **Character limit**: 5 **Values**: automatically generated from one of the following: `True `(default), `False` ")
  public Boolean getIncludesUsage() {
    return includesUsage;
  }

  public void setIncludesUsage(Boolean includesUsage) {
    this.includesUsage = includesUsage;
  }

  public ProxyGetInvoice invoiceDate(LocalDate invoiceDate) {
    this.invoiceDate = invoiceDate;
    return this;
  }

   /**
   *  Specifies the date on which to generate the invoice. **Character limit**: 29 **Version notes**: -- 
   * @return invoiceDate
  **/
  @ApiModelProperty(example = "null", value = " Specifies the date on which to generate the invoice. **Character limit**: 29 **Version notes**: -- ")
  public LocalDate getInvoiceDate() {
    return invoiceDate;
  }

  public void setInvoiceDate(LocalDate invoiceDate) {
    this.invoiceDate = invoiceDate;
  }

  public ProxyGetInvoice invoiceNumber(String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
    return this;
  }

   /**
   *  The unique identification number for the invoice. This number is returned as a string. **Character limit**: 32 **Values**: automatically generated 
   * @return invoiceNumber
  **/
  @ApiModelProperty(example = "null", value = " The unique identification number for the invoice. This number is returned as a string. **Character limit**: 32 **Values**: automatically generated ")
  public String getInvoiceNumber() {
    return invoiceNumber;
  }

  public void setInvoiceNumber(String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
  }

  public ProxyGetInvoice lastEmailSentDate(DateTime lastEmailSentDate) {
    this.lastEmailSentDate = lastEmailSentDate;
    return this;
  }

   /**
   *  The date when the invoice was last emailed. **Character limit**: 29 **Values**: automatically generated 
   * @return lastEmailSentDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the invoice was last emailed. **Character limit**: 29 **Values**: automatically generated ")
  public DateTime getLastEmailSentDate() {
    return lastEmailSentDate;
  }

  public void setLastEmailSentDate(DateTime lastEmailSentDate) {
    this.lastEmailSentDate = lastEmailSentDate;
  }

  public ProxyGetInvoice paymentAmount(Double paymentAmount) {
    this.paymentAmount = paymentAmount;
    return this;
  }

   /**
   *  The amount of payments applied to the invoice. **Character limit**: 16 **Value**s: automatically generated 
   * @return paymentAmount
  **/
  @ApiModelProperty(example = "null", value = " The amount of payments applied to the invoice. **Character limit**: 16 **Value**s: automatically generated ")
  public Double getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(Double paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  public ProxyGetInvoice postedBy(String postedBy) {
    this.postedBy = postedBy;
    return this;
  }

   /**
   *  The user ID of the person who moved the invoice to Posted status. **Character limit**: 32 **Values**: automatically generated 
   * @return postedBy
  **/
  @ApiModelProperty(example = "null", value = " The user ID of the person who moved the invoice to Posted status. **Character limit**: 32 **Values**: automatically generated ")
  public String getPostedBy() {
    return postedBy;
  }

  public void setPostedBy(String postedBy) {
    this.postedBy = postedBy;
  }

  public ProxyGetInvoice postedDate(DateTime postedDate) {
    this.postedDate = postedDate;
    return this;
  }

   /**
   *  The date when the invoice was posted. **Character limit:** 29 **Values**: automatically generated 
   * @return postedDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the invoice was posted. **Character limit:** 29 **Values**: automatically generated ")
  public DateTime getPostedDate() {
    return postedDate;
  }

  public void setPostedDate(DateTime postedDate) {
    this.postedDate = postedDate;
  }

  public ProxyGetInvoice refundAmount(Double refundAmount) {
    this.refundAmount = refundAmount;
    return this;
  }

   /**
   *  Specifies the amount of a refund that was applied against an earlier payment on the invoice. **Character limit**: 16 **Values**: automatically generated 
   * @return refundAmount
  **/
  @ApiModelProperty(example = "null", value = " Specifies the amount of a refund that was applied against an earlier payment on the invoice. **Character limit**: 16 **Values**: automatically generated ")
  public Double getRefundAmount() {
    return refundAmount;
  }

  public void setRefundAmount(Double refundAmount) {
    this.refundAmount = refundAmount;
  }

  public ProxyGetInvoice status(String status) {
    this.status = status;
    return this;
  }

   /**
   *  The status of the invoice in the system. This status is not the status of the payment of the invoice, just the status of the invoice itself. **Character limit**: 8 **Values**: one of the following:  -  Draft (default, automatically set upon invoice creation)  -  Posted  -  Canceled  
   * @return status
  **/
  @ApiModelProperty(example = "null", value = " The status of the invoice in the system. This status is not the status of the payment of the invoice, just the status of the invoice itself. **Character limit**: 8 **Values**: one of the following:  -  Draft (default, automatically set upon invoice creation)  -  Posted  -  Canceled  ")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ProxyGetInvoice targetDate(LocalDate targetDate) {
    this.targetDate = targetDate;
    return this;
  }

   /**
   *  This date is used to determine which charges are to be billed. All charges that are to be billed on this date or prior will be included in this bill run. **Character limit**: 29 **Version notes**: -- 
   * @return targetDate
  **/
  @ApiModelProperty(example = "null", value = " This date is used to determine which charges are to be billed. All charges that are to be billed on this date or prior will be included in this bill run. **Character limit**: 29 **Version notes**: -- ")
  public LocalDate getTargetDate() {
    return targetDate;
  }

  public void setTargetDate(LocalDate targetDate) {
    this.targetDate = targetDate;
  }

  public ProxyGetInvoice taxAmount(Double taxAmount) {
    this.taxAmount = taxAmount;
    return this;
  }

   /**
   *  The total amount of the taxes applied to the invoice. **Character limit**: 16 **Values**: automatically generated 
   * @return taxAmount
  **/
  @ApiModelProperty(example = "null", value = " The total amount of the taxes applied to the invoice. **Character limit**: 16 **Values**: automatically generated ")
  public Double getTaxAmount() {
    return taxAmount;
  }

  public void setTaxAmount(Double taxAmount) {
    this.taxAmount = taxAmount;
  }

  public ProxyGetInvoice taxExemptAmount(Double taxExemptAmount) {
    this.taxExemptAmount = taxExemptAmount;
    return this;
  }

   /**
   *  The total amount of the invoice that is exempt from taxation. **Character limit**: 16 **Values**: automatically generated 
   * @return taxExemptAmount
  **/
  @ApiModelProperty(example = "null", value = " The total amount of the invoice that is exempt from taxation. **Character limit**: 16 **Values**: automatically generated ")
  public Double getTaxExemptAmount() {
    return taxExemptAmount;
  }

  public void setTaxExemptAmount(Double taxExemptAmount) {
    this.taxExemptAmount = taxExemptAmount;
  }

  public ProxyGetInvoice transferredToAccounting(String transferredToAccounting) {
    this.transferredToAccounting = transferredToAccounting;
    return this;
  }

   /**
   *  Specifies whether or not the invoice was transferred to an external accounting system, such as NetSuite. **Character limit**: 10 **Values**: Processing, Yes, Error, Ignore 
   * @return transferredToAccounting
  **/
  @ApiModelProperty(example = "null", value = " Specifies whether or not the invoice was transferred to an external accounting system, such as NetSuite. **Character limit**: 10 **Values**: Processing, Yes, Error, Ignore ")
  public String getTransferredToAccounting() {
    return transferredToAccounting;
  }

  public void setTransferredToAccounting(String transferredToAccounting) {
    this.transferredToAccounting = transferredToAccounting;
  }

  public ProxyGetInvoice updatedById(String updatedById) {
    this.updatedById = updatedById;
    return this;
  }

   /**
   * 
   * @return updatedById
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getUpdatedById() {
    return updatedById;
  }

  public void setUpdatedById(String updatedById) {
    this.updatedById = updatedById;
  }

  public ProxyGetInvoice updatedDate(DateTime updatedDate) {
    this.updatedDate = updatedDate;
    return this;
  }

   /**
   *  The date when the invoice was last updated. **Character limit**: 29 **Values**: automatically generated 
   * @return updatedDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the invoice was last updated. **Character limit**: 29 **Values**: automatically generated ")
  public DateTime getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(DateTime updatedDate) {
    this.updatedDate = updatedDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProxyGetInvoice proxyGetInvoice = (ProxyGetInvoice) o;
    return Objects.equals(this.accountId, proxyGetInvoice.accountId) &&
        Objects.equals(this.adjustmentAmount, proxyGetInvoice.adjustmentAmount) &&
        Objects.equals(this.amount, proxyGetInvoice.amount) &&
        Objects.equals(this.amountWithoutTax, proxyGetInvoice.amountWithoutTax) &&
        Objects.equals(this.balance, proxyGetInvoice.balance) &&
        Objects.equals(this.body, proxyGetInvoice.body) &&
        Objects.equals(this.comments, proxyGetInvoice.comments) &&
        Objects.equals(this.createdById, proxyGetInvoice.createdById) &&
        Objects.equals(this.createdDate, proxyGetInvoice.createdDate) &&
        Objects.equals(this.creditBalanceAdjustmentAmount, proxyGetInvoice.creditBalanceAdjustmentAmount) &&
        Objects.equals(this.dueDate, proxyGetInvoice.dueDate) &&
        Objects.equals(this.id, proxyGetInvoice.id) &&
        Objects.equals(this.includesOneTime, proxyGetInvoice.includesOneTime) &&
        Objects.equals(this.includesRecurring, proxyGetInvoice.includesRecurring) &&
        Objects.equals(this.includesUsage, proxyGetInvoice.includesUsage) &&
        Objects.equals(this.invoiceDate, proxyGetInvoice.invoiceDate) &&
        Objects.equals(this.invoiceNumber, proxyGetInvoice.invoiceNumber) &&
        Objects.equals(this.lastEmailSentDate, proxyGetInvoice.lastEmailSentDate) &&
        Objects.equals(this.paymentAmount, proxyGetInvoice.paymentAmount) &&
        Objects.equals(this.postedBy, proxyGetInvoice.postedBy) &&
        Objects.equals(this.postedDate, proxyGetInvoice.postedDate) &&
        Objects.equals(this.refundAmount, proxyGetInvoice.refundAmount) &&
        Objects.equals(this.status, proxyGetInvoice.status) &&
        Objects.equals(this.targetDate, proxyGetInvoice.targetDate) &&
        Objects.equals(this.taxAmount, proxyGetInvoice.taxAmount) &&
        Objects.equals(this.taxExemptAmount, proxyGetInvoice.taxExemptAmount) &&
        Objects.equals(this.transferredToAccounting, proxyGetInvoice.transferredToAccounting) &&
        Objects.equals(this.updatedById, proxyGetInvoice.updatedById) &&
        Objects.equals(this.updatedDate, proxyGetInvoice.updatedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, adjustmentAmount, amount, amountWithoutTax, balance, body, comments, createdById, createdDate, creditBalanceAdjustmentAmount, dueDate, id, includesOneTime, includesRecurring, includesUsage, invoiceDate, invoiceNumber, lastEmailSentDate, paymentAmount, postedBy, postedDate, refundAmount, status, targetDate, taxAmount, taxExemptAmount, transferredToAccounting, updatedById, updatedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProxyGetInvoice {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    adjustmentAmount: ").append(toIndentedString(adjustmentAmount)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    amountWithoutTax: ").append(toIndentedString(amountWithoutTax)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("    createdById: ").append(toIndentedString(createdById)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    creditBalanceAdjustmentAmount: ").append(toIndentedString(creditBalanceAdjustmentAmount)).append("\n");
    sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    includesOneTime: ").append(toIndentedString(includesOneTime)).append("\n");
    sb.append("    includesRecurring: ").append(toIndentedString(includesRecurring)).append("\n");
    sb.append("    includesUsage: ").append(toIndentedString(includesUsage)).append("\n");
    sb.append("    invoiceDate: ").append(toIndentedString(invoiceDate)).append("\n");
    sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
    sb.append("    lastEmailSentDate: ").append(toIndentedString(lastEmailSentDate)).append("\n");
    sb.append("    paymentAmount: ").append(toIndentedString(paymentAmount)).append("\n");
    sb.append("    postedBy: ").append(toIndentedString(postedBy)).append("\n");
    sb.append("    postedDate: ").append(toIndentedString(postedDate)).append("\n");
    sb.append("    refundAmount: ").append(toIndentedString(refundAmount)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    targetDate: ").append(toIndentedString(targetDate)).append("\n");
    sb.append("    taxAmount: ").append(toIndentedString(taxAmount)).append("\n");
    sb.append("    taxExemptAmount: ").append(toIndentedString(taxExemptAmount)).append("\n");
    sb.append("    transferredToAccounting: ").append(toIndentedString(transferredToAccounting)).append("\n");
    sb.append("    updatedById: ").append(toIndentedString(updatedById)).append("\n");
    sb.append("    updatedDate: ").append(toIndentedString(updatedDate)).append("\n");
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

