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
 * ProxyGetCreditBalanceAdjustment
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class ProxyGetCreditBalanceAdjustment   {
  @SerializedName("AccountId")
  private String accountId = null;

  @SerializedName("AccountingCode")
  private String accountingCode = null;

  @SerializedName("AdjustmentDate")
  private LocalDate adjustmentDate = null;

  @SerializedName("Amount")
  private Double amount = null;

  @SerializedName("CancelledOn")
  private DateTime cancelledOn = null;

  @SerializedName("Comment")
  private String comment = null;

  @SerializedName("CreatedById")
  private String createdById = null;

  @SerializedName("CreatedDate")
  private DateTime createdDate = null;

  @SerializedName("Id")
  private String id = null;

  @SerializedName("IntegrationId__NS")
  private String integrationIdNS = null;

  @SerializedName("IntegrationStatus__NS")
  private String integrationStatusNS = null;

  @SerializedName("Number")
  private String number = null;

  @SerializedName("ReasonCode")
  private String reasonCode = null;

  @SerializedName("ReferenceId")
  private String referenceId = null;

  @SerializedName("SourceTransactionId")
  private String sourceTransactionId = null;

  @SerializedName("SourceTransactionNumber")
  private String sourceTransactionNumber = null;

  @SerializedName("SourceTransactionType")
  private String sourceTransactionType = null;

  @SerializedName("Status")
  private String status = null;

  @SerializedName("SyncDate__NS")
  private String syncDateNS = null;

  @SerializedName("TransferredToAccounting")
  private String transferredToAccounting = null;

  @SerializedName("Type")
  private String type = null;

  @SerializedName("UpdatedById")
  private String updatedById = null;

  @SerializedName("UpdatedDate")
  private DateTime updatedDate = null;

  public ProxyGetCreditBalanceAdjustment accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   *  The account ID of the credit balance's account. Zuora generates this value from the source transaction. **Character limit**: 32 **V****alues**: automatically generated from:  - CreditBalanceAdjustment.SourceTransactionId or - CreditBalanceAdjustment.SourceTransactionNumber 
   * @return accountId
  **/
  @ApiModelProperty(example = "null", value = " The account ID of the credit balance's account. Zuora generates this value from the source transaction. **Character limit**: 32 **V****alues**: automatically generated from:  - CreditBalanceAdjustment.SourceTransactionId or - CreditBalanceAdjustment.SourceTransactionNumber ")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public ProxyGetCreditBalanceAdjustment accountingCode(String accountingCode) {
    this.accountingCode = accountingCode;
    return this;
  }

   /**
   *  The [Chart of Accounts](/CB_Billing/W_Billing_and_Payments_Settings/V_Configure_Accounting_Codes/D_Set_Up_Chart_of_Accounts) 
   * @return accountingCode
  **/
  @ApiModelProperty(example = "null", value = " The [Chart of Accounts](/CB_Billing/W_Billing_and_Payments_Settings/V_Configure_Accounting_Codes/D_Set_Up_Chart_of_Accounts) ")
  public String getAccountingCode() {
    return accountingCode;
  }

  public void setAccountingCode(String accountingCode) {
    this.accountingCode = accountingCode;
  }

  public ProxyGetCreditBalanceAdjustment adjustmentDate(LocalDate adjustmentDate) {
    this.adjustmentDate = adjustmentDate;
    return this;
  }

   /**
   *  The date when the credit balance adjustment is applied. **Character limit**: 29 **Values**: automatically generated 
   * @return adjustmentDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the credit balance adjustment is applied. **Character limit**: 29 **Values**: automatically generated ")
  public LocalDate getAdjustmentDate() {
    return adjustmentDate;
  }

  public void setAdjustmentDate(LocalDate adjustmentDate) {
    this.adjustmentDate = adjustmentDate;
  }

  public ProxyGetCreditBalanceAdjustment amount(Double amount) {
    this.amount = amount;
    return this;
  }

   /**
   *  The amount of the adjustment. **Character limit**: 16 **Values**: a valid currency amount 
   * @return amount
  **/
  @ApiModelProperty(example = "null", value = " The amount of the adjustment. **Character limit**: 16 **Values**: a valid currency amount ")
  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public ProxyGetCreditBalanceAdjustment cancelledOn(DateTime cancelledOn) {
    this.cancelledOn = cancelledOn;
    return this;
  }

   /**
   *  The date when the credit balance adjustment was canceled. **Character limit**: 29 **Values**: automatically generated 
   * @return cancelledOn
  **/
  @ApiModelProperty(example = "null", value = " The date when the credit balance adjustment was canceled. **Character limit**: 29 **Values**: automatically generated ")
  public DateTime getCancelledOn() {
    return cancelledOn;
  }

  public void setCancelledOn(DateTime cancelledOn) {
    this.cancelledOn = cancelledOn;
  }

  public ProxyGetCreditBalanceAdjustment comment(String comment) {
    this.comment = comment;
    return this;
  }

   /**
   *  Use this field to record comments about the credit balance adjustment. **Character limit**: 255 **Values**: a string of 255 characters or fewer 
   * @return comment
  **/
  @ApiModelProperty(example = "null", value = " Use this field to record comments about the credit balance adjustment. **Character limit**: 255 **Values**: a string of 255 characters or fewer ")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public ProxyGetCreditBalanceAdjustment createdById(String createdById) {
    this.createdById = createdById;
    return this;
  }

   /**
   *  The user ID of the person who created the credit balance adjustment. **Character limit**: 32 **Values**: automatically generated 
   * @return createdById
  **/
  @ApiModelProperty(example = "null", value = " The user ID of the person who created the credit balance adjustment. **Character limit**: 32 **Values**: automatically generated ")
  public String getCreatedById() {
    return createdById;
  }

  public void setCreatedById(String createdById) {
    this.createdById = createdById;
  }

  public ProxyGetCreditBalanceAdjustment createdDate(DateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }

   /**
   *  The date when the credit balance adjustmentwas generated. **Character limit**: 29 **Values**: automatically generated 
   * @return createdDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the credit balance adjustmentwas generated. **Character limit**: 29 **Values**: automatically generated ")
  public DateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(DateTime createdDate) {
    this.createdDate = createdDate;
  }

  public ProxyGetCreditBalanceAdjustment id(String id) {
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

  public ProxyGetCreditBalanceAdjustment integrationIdNS(String integrationIdNS) {
    this.integrationIdNS = integrationIdNS;
    return this;
  }

   /**
   * 
   * @return integrationIdNS
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getIntegrationIdNS() {
    return integrationIdNS;
  }

  public void setIntegrationIdNS(String integrationIdNS) {
    this.integrationIdNS = integrationIdNS;
  }

  public ProxyGetCreditBalanceAdjustment integrationStatusNS(String integrationStatusNS) {
    this.integrationStatusNS = integrationStatusNS;
    return this;
  }

   /**
   * 
   * @return integrationStatusNS
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getIntegrationStatusNS() {
    return integrationStatusNS;
  }

  public void setIntegrationStatusNS(String integrationStatusNS) {
    this.integrationStatusNS = integrationStatusNS;
  }

  public ProxyGetCreditBalanceAdjustment number(String number) {
    this.number = number;
    return this;
  }

   /**
   *  A unique identifier for the credit balance adjustment. Zuora generates this number in the format, <em>CBA-xxxxxxxx</em>, such as CBA-00375919. **Character limit**: 255 **Values**: automatically generated 
   * @return number
  **/
  @ApiModelProperty(example = "null", value = " A unique identifier for the credit balance adjustment. Zuora generates this number in the format, <em>CBA-xxxxxxxx</em>, such as CBA-00375919. **Character limit**: 255 **Values**: automatically generated ")
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public ProxyGetCreditBalanceAdjustment reasonCode(String reasonCode) {
    this.reasonCode = reasonCode;
    return this;
  }

   /**
   *  A code identifying the reason for the transaction. Must be an existing reason code or empty. If you do not specify a value, Zuora uses the default reason code. **Character limit**: 32 **V****alues**: a valid [reason code](/CB_Billing/K_Payment_Operations/Reason_Codes_for_Payment_Operations) 
   * @return reasonCode
  **/
  @ApiModelProperty(example = "null", value = " A code identifying the reason for the transaction. Must be an existing reason code or empty. If you do not specify a value, Zuora uses the default reason code. **Character limit**: 32 **V****alues**: a valid [reason code](/CB_Billing/K_Payment_Operations/Reason_Codes_for_Payment_Operations) ")
  public String getReasonCode() {
    return reasonCode;
  }

  public void setReasonCode(String reasonCode) {
    this.reasonCode = reasonCode;
  }

  public ProxyGetCreditBalanceAdjustment referenceId(String referenceId) {
    this.referenceId = referenceId;
    return this;
  }

   /**
   *  The ID of the payment that the credit balance adjustment is for. **Character limit**: 32 **Values**: a string of 60 characters or fewer 
   * @return referenceId
  **/
  @ApiModelProperty(example = "null", value = " The ID of the payment that the credit balance adjustment is for. **Character limit**: 32 **Values**: a string of 60 characters or fewer ")
  public String getReferenceId() {
    return referenceId;
  }

  public void setReferenceId(String referenceId) {
    this.referenceId = referenceId;
  }

  public ProxyGetCreditBalanceAdjustment sourceTransactionId(String sourceTransactionId) {
    this.sourceTransactionId = sourceTransactionId;
    return this;
  }

   /**
   *  The ID of the object that the credit balance adjustment is applied to. You must specify a value for either the `SourceTransactionId` field or the `SourceTransactionNumber` field. **Character limit**: 32 **Values**: one of the following:  - InvoiceId - PaymentId - RefundId 
   * @return sourceTransactionId
  **/
  @ApiModelProperty(example = "null", value = " The ID of the object that the credit balance adjustment is applied to. You must specify a value for either the `SourceTransactionId` field or the `SourceTransactionNumber` field. **Character limit**: 32 **Values**: one of the following:  - InvoiceId - PaymentId - RefundId ")
  public String getSourceTransactionId() {
    return sourceTransactionId;
  }

  public void setSourceTransactionId(String sourceTransactionId) {
    this.sourceTransactionId = sourceTransactionId;
  }

  public ProxyGetCreditBalanceAdjustment sourceTransactionNumber(String sourceTransactionNumber) {
    this.sourceTransactionNumber = sourceTransactionNumber;
    return this;
  }

   /**
   *  The number of the object that the credit balance adjustment is applied to. You must specify a value for either the `SourceTransactionId` field or the `SourceTransactionNumber` field. **Character limit**: 50 **Values**: one of the following:  - InvoiceNumber - PaymentNumber - RefundNumber 
   * @return sourceTransactionNumber
  **/
  @ApiModelProperty(example = "null", value = " The number of the object that the credit balance adjustment is applied to. You must specify a value for either the `SourceTransactionId` field or the `SourceTransactionNumber` field. **Character limit**: 50 **Values**: one of the following:  - InvoiceNumber - PaymentNumber - RefundNumber ")
  public String getSourceTransactionNumber() {
    return sourceTransactionNumber;
  }

  public void setSourceTransactionNumber(String sourceTransactionNumber) {
    this.sourceTransactionNumber = sourceTransactionNumber;
  }

  public ProxyGetCreditBalanceAdjustment sourceTransactionType(String sourceTransactionType) {
    this.sourceTransactionType = sourceTransactionType;
    return this;
  }

   /**
   *  The source of the credit balance adjustment. **Character limit**: **Values**: automatically generated; one of the following:  - Invoice - Payment - Refund 
   * @return sourceTransactionType
  **/
  @ApiModelProperty(example = "null", value = " The source of the credit balance adjustment. **Character limit**: **Values**: automatically generated; one of the following:  - Invoice - Payment - Refund ")
  public String getSourceTransactionType() {
    return sourceTransactionType;
  }

  public void setSourceTransactionType(String sourceTransactionType) {
    this.sourceTransactionType = sourceTransactionType;
  }

  public ProxyGetCreditBalanceAdjustment status(String status) {
    this.status = status;
    return this;
  }

   /**
   *  The status of the credit balance adjustment. **Character limit**: 9 **Values**: automatically generated; one of the following:  - Processed - Canceled 
   * @return status
  **/
  @ApiModelProperty(example = "null", value = " The status of the credit balance adjustment. **Character limit**: 9 **Values**: automatically generated; one of the following:  - Processed - Canceled ")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ProxyGetCreditBalanceAdjustment syncDateNS(String syncDateNS) {
    this.syncDateNS = syncDateNS;
    return this;
  }

   /**
   * 
   * @return syncDateNS
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getSyncDateNS() {
    return syncDateNS;
  }

  public void setSyncDateNS(String syncDateNS) {
    this.syncDateNS = syncDateNS;
  }

  public ProxyGetCreditBalanceAdjustment transferredToAccounting(String transferredToAccounting) {
    this.transferredToAccounting = transferredToAccounting;
    return this;
  }

   /**
   *  Indicates the status of the credit balance adjustment's transfer to an external accounting system, such as NetSuite. **Character limit**: **Values**: one of the following:  - Processing - Yes - Error - Ignore 
   * @return transferredToAccounting
  **/
  @ApiModelProperty(example = "null", value = " Indicates the status of the credit balance adjustment's transfer to an external accounting system, such as NetSuite. **Character limit**: **Values**: one of the following:  - Processing - Yes - Error - Ignore ")
  public String getTransferredToAccounting() {
    return transferredToAccounting;
  }

  public void setTransferredToAccounting(String transferredToAccounting) {
    this.transferredToAccounting = transferredToAccounting;
  }

  public ProxyGetCreditBalanceAdjustment type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Create Query Filter
   * @return type
  **/
  @ApiModelProperty(example = "null", value = "Create Query Filter")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ProxyGetCreditBalanceAdjustment updatedById(String updatedById) {
    this.updatedById = updatedById;
    return this;
  }

   /**
   *  The ID of the user who last updated the credit balance adjustment. **Character limit**: 32 **Values**: automatically generated 
   * @return updatedById
  **/
  @ApiModelProperty(example = "null", value = " The ID of the user who last updated the credit balance adjustment. **Character limit**: 32 **Values**: automatically generated ")
  public String getUpdatedById() {
    return updatedById;
  }

  public void setUpdatedById(String updatedById) {
    this.updatedById = updatedById;
  }

  public ProxyGetCreditBalanceAdjustment updatedDate(DateTime updatedDate) {
    this.updatedDate = updatedDate;
    return this;
  }

   /**
   *  The date when the credit balance adjustment was last updated. **Character limit**: 29 **Values**: automatically generated 
   * @return updatedDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the credit balance adjustment was last updated. **Character limit**: 29 **Values**: automatically generated ")
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
    ProxyGetCreditBalanceAdjustment proxyGetCreditBalanceAdjustment = (ProxyGetCreditBalanceAdjustment) o;
    return Objects.equals(this.accountId, proxyGetCreditBalanceAdjustment.accountId) &&
        Objects.equals(this.accountingCode, proxyGetCreditBalanceAdjustment.accountingCode) &&
        Objects.equals(this.adjustmentDate, proxyGetCreditBalanceAdjustment.adjustmentDate) &&
        Objects.equals(this.amount, proxyGetCreditBalanceAdjustment.amount) &&
        Objects.equals(this.cancelledOn, proxyGetCreditBalanceAdjustment.cancelledOn) &&
        Objects.equals(this.comment, proxyGetCreditBalanceAdjustment.comment) &&
        Objects.equals(this.createdById, proxyGetCreditBalanceAdjustment.createdById) &&
        Objects.equals(this.createdDate, proxyGetCreditBalanceAdjustment.createdDate) &&
        Objects.equals(this.id, proxyGetCreditBalanceAdjustment.id) &&
        Objects.equals(this.integrationIdNS, proxyGetCreditBalanceAdjustment.integrationIdNS) &&
        Objects.equals(this.integrationStatusNS, proxyGetCreditBalanceAdjustment.integrationStatusNS) &&
        Objects.equals(this.number, proxyGetCreditBalanceAdjustment.number) &&
        Objects.equals(this.reasonCode, proxyGetCreditBalanceAdjustment.reasonCode) &&
        Objects.equals(this.referenceId, proxyGetCreditBalanceAdjustment.referenceId) &&
        Objects.equals(this.sourceTransactionId, proxyGetCreditBalanceAdjustment.sourceTransactionId) &&
        Objects.equals(this.sourceTransactionNumber, proxyGetCreditBalanceAdjustment.sourceTransactionNumber) &&
        Objects.equals(this.sourceTransactionType, proxyGetCreditBalanceAdjustment.sourceTransactionType) &&
        Objects.equals(this.status, proxyGetCreditBalanceAdjustment.status) &&
        Objects.equals(this.syncDateNS, proxyGetCreditBalanceAdjustment.syncDateNS) &&
        Objects.equals(this.transferredToAccounting, proxyGetCreditBalanceAdjustment.transferredToAccounting) &&
        Objects.equals(this.type, proxyGetCreditBalanceAdjustment.type) &&
        Objects.equals(this.updatedById, proxyGetCreditBalanceAdjustment.updatedById) &&
        Objects.equals(this.updatedDate, proxyGetCreditBalanceAdjustment.updatedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, accountingCode, adjustmentDate, amount, cancelledOn, comment, createdById, createdDate, id, integrationIdNS, integrationStatusNS, number, reasonCode, referenceId, sourceTransactionId, sourceTransactionNumber, sourceTransactionType, status, syncDateNS, transferredToAccounting, type, updatedById, updatedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProxyGetCreditBalanceAdjustment {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountingCode: ").append(toIndentedString(accountingCode)).append("\n");
    sb.append("    adjustmentDate: ").append(toIndentedString(adjustmentDate)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    cancelledOn: ").append(toIndentedString(cancelledOn)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    createdById: ").append(toIndentedString(createdById)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    integrationIdNS: ").append(toIndentedString(integrationIdNS)).append("\n");
    sb.append("    integrationStatusNS: ").append(toIndentedString(integrationStatusNS)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    reasonCode: ").append(toIndentedString(reasonCode)).append("\n");
    sb.append("    referenceId: ").append(toIndentedString(referenceId)).append("\n");
    sb.append("    sourceTransactionId: ").append(toIndentedString(sourceTransactionId)).append("\n");
    sb.append("    sourceTransactionNumber: ").append(toIndentedString(sourceTransactionNumber)).append("\n");
    sb.append("    sourceTransactionType: ").append(toIndentedString(sourceTransactionType)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    syncDateNS: ").append(toIndentedString(syncDateNS)).append("\n");
    sb.append("    transferredToAccounting: ").append(toIndentedString(transferredToAccounting)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

