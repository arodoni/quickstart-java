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
 * ProxyCreateInvoiceAdjustment
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class ProxyCreateInvoiceAdjustment   {
  @SerializedName("AccountId")
  private String accountId = null;

  @SerializedName("AccountingCode")
  private String accountingCode = null;

  @SerializedName("AdjustmentDate")
  private LocalDate adjustmentDate = null;

  @SerializedName("AdjustmentNumber")
  private String adjustmentNumber = null;

  @SerializedName("Amount")
  private Double amount = null;

  @SerializedName("Comments")
  private String comments = null;

  @SerializedName("CustomerName")
  private String customerName = null;

  @SerializedName("CustomerNumber")
  private String customerNumber = null;

  @SerializedName("ImpactAmount")
  private Double impactAmount = null;

  @SerializedName("InvoiceId")
  private String invoiceId = null;

  @SerializedName("InvoiceNumber")
  private String invoiceNumber = null;

  @SerializedName("ReasonCode")
  private String reasonCode = null;

  @SerializedName("ReferenceId")
  private String referenceId = null;

  @SerializedName("Status")
  private String status = null;

  @SerializedName("Type")
  private String type = null;

  public ProxyCreateInvoiceAdjustment accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   *  The ID of the account that owns the invoice. **Character limit**: 32 **Values**: inherited from `[Account](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account).ID` for the invoice owner 
   * @return accountId
  **/
  @ApiModelProperty(example = "null", required = true, value = " The ID of the account that owns the invoice. **Character limit**: 32 **Values**: inherited from `[Account](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account).ID` for the invoice owner ")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public ProxyCreateInvoiceAdjustment accountingCode(String accountingCode) {
    this.accountingCode = accountingCode;
    return this;
  }

   /**
   *  The [Chart of Accounts](/CA_Billing_and_Payments/C_Billing_and_Payments_Settings/U_Configure_Accounting_Codes/D_Set_Up_Chart_of_Accounts) and is active 
   * @return accountingCode
  **/
  @ApiModelProperty(example = "null", value = " The [Chart of Accounts](/CA_Billing_and_Payments/C_Billing_and_Payments_Settings/U_Configure_Accounting_Codes/D_Set_Up_Chart_of_Accounts) and is active ")
  public String getAccountingCode() {
    return accountingCode;
  }

  public void setAccountingCode(String accountingCode) {
    this.accountingCode = accountingCode;
  }

  public ProxyCreateInvoiceAdjustment adjustmentDate(LocalDate adjustmentDate) {
    this.adjustmentDate = adjustmentDate;
    return this;
  }

   /**
   *  The date when the invoice adjustment is applied. This date must be the same as the invoice's date or later. **Character limit**: 29 **Values**: Leave null to automatically generate the current date 
   * @return adjustmentDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the invoice adjustment is applied. This date must be the same as the invoice's date or later. **Character limit**: 29 **Values**: Leave null to automatically generate the current date ")
  public LocalDate getAdjustmentDate() {
    return adjustmentDate;
  }

  public void setAdjustmentDate(LocalDate adjustmentDate) {
    this.adjustmentDate = adjustmentDate;
  }

  public ProxyCreateInvoiceAdjustment adjustmentNumber(String adjustmentNumber) {
    this.adjustmentNumber = adjustmentNumber;
    return this;
  }

   /**
   *  A unique string to identify an individual invoice adjustment. **Character limit**: 255 **Values**: automatically generated 
   * @return adjustmentNumber
  **/
  @ApiModelProperty(example = "null", required = true, value = " A unique string to identify an individual invoice adjustment. **Character limit**: 255 **Values**: automatically generated ")
  public String getAdjustmentNumber() {
    return adjustmentNumber;
  }

  public void setAdjustmentNumber(String adjustmentNumber) {
    this.adjustmentNumber = adjustmentNumber;
  }

  public ProxyCreateInvoiceAdjustment amount(Double amount) {
    this.amount = amount;
    return this;
  }

   /**
   *  The amount of the invoice adjustment. **Character limit**: 16 **Values**: a valid currency amount 
   * @return amount
  **/
  @ApiModelProperty(example = "null", required = true, value = " The amount of the invoice adjustment. **Character limit**: 16 **Values**: a valid currency amount ")
  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public ProxyCreateInvoiceAdjustment comments(String comments) {
    this.comments = comments;
    return this;
  }

   /**
   *  Use this field to record comments about the invoice adjustment. **Character limit**: 255 **Values**: a string of 255 characters or fewer 
   * @return comments
  **/
  @ApiModelProperty(example = "null", value = " Use this field to record comments about the invoice adjustment. **Character limit**: 255 **Values**: a string of 255 characters or fewer ")
  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public ProxyCreateInvoiceAdjustment customerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

   /**
   *  The name of the account that owns the associated invoice. **Character limit**: 50 **Values**: inherited from `[Account](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account).Name` 
   * @return customerName
  **/
  @ApiModelProperty(example = "null", required = true, value = " The name of the account that owns the associated invoice. **Character limit**: 50 **Values**: inherited from `[Account](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account).Name` ")
  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public ProxyCreateInvoiceAdjustment customerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
    return this;
  }

   /**
   *  The unique account number of the customer's account. **Character limit**: 70 **Values**: inherited from `[Account](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account).AccountNumber` 
   * @return customerNumber
  **/
  @ApiModelProperty(example = "null", required = true, value = " The unique account number of the customer's account. **Character limit**: 70 **Values**: inherited from `[Account](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account).AccountNumber` ")
  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public ProxyCreateInvoiceAdjustment impactAmount(Double impactAmount) {
    this.impactAmount = impactAmount;
    return this;
  }

   /**
   *  The amount that changes the balance of the associated invoice. **Character limit**: 16 **Values**: automatically calculated 
   * @return impactAmount
  **/
  @ApiModelProperty(example = "null", required = true, value = " The amount that changes the balance of the associated invoice. **Character limit**: 16 **Values**: automatically calculated ")
  public Double getImpactAmount() {
    return impactAmount;
  }

  public void setImpactAmount(Double impactAmount) {
    this.impactAmount = impactAmount;
  }

  public ProxyCreateInvoiceAdjustment invoiceId(String invoiceId) {
    this.invoiceId = invoiceId;
    return this;
  }

   /**
   *  The ID of the invoice associated with the adjustment. This field is required if you don't specify a value for the `InvoiceNumber` field. **Character limit**: 32 **Values**: [a valid invoice ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Invoice) 
   * @return invoiceId
  **/
  @ApiModelProperty(example = "null", value = " The ID of the invoice associated with the adjustment. This field is required if you don't specify a value for the `InvoiceNumber` field. **Character limit**: 32 **Values**: [a valid invoice ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Invoice) ")
  public String getInvoiceId() {
    return invoiceId;
  }

  public void setInvoiceId(String invoiceId) {
    this.invoiceId = invoiceId;
  }

  public ProxyCreateInvoiceAdjustment invoiceNumber(String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
    return this;
  }

   /**
   *  The unique identification number for the associated invoice. This field is required if you don't specify a value for the `InvoiceId` field. **Character limit**: 32 **Values**: [a valid invoice number](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Invoice) 
   * @return invoiceNumber
  **/
  @ApiModelProperty(example = "null", value = " The unique identification number for the associated invoice. This field is required if you don't specify a value for the `InvoiceId` field. **Character limit**: 32 **Values**: [a valid invoice number](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Invoice) ")
  public String getInvoiceNumber() {
    return invoiceNumber;
  }

  public void setInvoiceNumber(String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
  }

  public ProxyCreateInvoiceAdjustment reasonCode(String reasonCode) {
    this.reasonCode = reasonCode;
    return this;
  }

   /**
   *  A code identifying the reason for the transaction. Must be an existing reason code or empty. If you do not specify a value, Zuora uses the default reason code. **Character limit**: 32 **V****alues**: a valid [reason code](/C_Zuora_User_Guides/A_Billing_and_Payments/R_Reason_Codes_for_Payment_Operations) 
   * @return reasonCode
  **/
  @ApiModelProperty(example = "null", value = " A code identifying the reason for the transaction. Must be an existing reason code or empty. If you do not specify a value, Zuora uses the default reason code. **Character limit**: 32 **V****alues**: a valid [reason code](/C_Zuora_User_Guides/A_Billing_and_Payments/R_Reason_Codes_for_Payment_Operations) ")
  public String getReasonCode() {
    return reasonCode;
  }

  public void setReasonCode(String reasonCode) {
    this.reasonCode = reasonCode;
  }

  public ProxyCreateInvoiceAdjustment referenceId(String referenceId) {
    this.referenceId = referenceId;
    return this;
  }

   /**
   *  A code to reference an object external to Zuora. For example, you can use this field to reference a case number in an external system. **Character limit**: 60 **Values**: a string of 60 characters or fewer 
   * @return referenceId
  **/
  @ApiModelProperty(example = "null", value = " A code to reference an object external to Zuora. For example, you can use this field to reference a case number in an external system. **Character limit**: 60 **Values**: a string of 60 characters or fewer ")
  public String getReferenceId() {
    return referenceId;
  }

  public void setReferenceId(String referenceId) {
    this.referenceId = referenceId;
  }

  public ProxyCreateInvoiceAdjustment status(String status) {
    this.status = status;
    return this;
  }

   /**
   *  The status of the invoice adjustment. This field is required in `query()` calls, but is automatically generated in other calls. **Character limit**: 9 **Values**: `Canceled`, `Processed` 
   * @return status
  **/
  @ApiModelProperty(example = "null", required = true, value = " The status of the invoice adjustment. This field is required in `query()` calls, but is automatically generated in other calls. **Character limit**: 9 **Values**: `Canceled`, `Processed` ")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ProxyCreateInvoiceAdjustment type(String type) {
    this.type = type;
    return this;
  }

   /**
   *  Indicates whether the adjustment credits or debits the invoice amount. **Character limit**: 6 **Values**: `Credit`, `Charge` 
   * @return type
  **/
  @ApiModelProperty(example = "null", required = true, value = " Indicates whether the adjustment credits or debits the invoice amount. **Character limit**: 6 **Values**: `Credit`, `Charge` ")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProxyCreateInvoiceAdjustment proxyCreateInvoiceAdjustment = (ProxyCreateInvoiceAdjustment) o;
    return Objects.equals(this.accountId, proxyCreateInvoiceAdjustment.accountId) &&
        Objects.equals(this.accountingCode, proxyCreateInvoiceAdjustment.accountingCode) &&
        Objects.equals(this.adjustmentDate, proxyCreateInvoiceAdjustment.adjustmentDate) &&
        Objects.equals(this.adjustmentNumber, proxyCreateInvoiceAdjustment.adjustmentNumber) &&
        Objects.equals(this.amount, proxyCreateInvoiceAdjustment.amount) &&
        Objects.equals(this.comments, proxyCreateInvoiceAdjustment.comments) &&
        Objects.equals(this.customerName, proxyCreateInvoiceAdjustment.customerName) &&
        Objects.equals(this.customerNumber, proxyCreateInvoiceAdjustment.customerNumber) &&
        Objects.equals(this.impactAmount, proxyCreateInvoiceAdjustment.impactAmount) &&
        Objects.equals(this.invoiceId, proxyCreateInvoiceAdjustment.invoiceId) &&
        Objects.equals(this.invoiceNumber, proxyCreateInvoiceAdjustment.invoiceNumber) &&
        Objects.equals(this.reasonCode, proxyCreateInvoiceAdjustment.reasonCode) &&
        Objects.equals(this.referenceId, proxyCreateInvoiceAdjustment.referenceId) &&
        Objects.equals(this.status, proxyCreateInvoiceAdjustment.status) &&
        Objects.equals(this.type, proxyCreateInvoiceAdjustment.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, accountingCode, adjustmentDate, adjustmentNumber, amount, comments, customerName, customerNumber, impactAmount, invoiceId, invoiceNumber, reasonCode, referenceId, status, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProxyCreateInvoiceAdjustment {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountingCode: ").append(toIndentedString(accountingCode)).append("\n");
    sb.append("    adjustmentDate: ").append(toIndentedString(adjustmentDate)).append("\n");
    sb.append("    adjustmentNumber: ").append(toIndentedString(adjustmentNumber)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("    customerName: ").append(toIndentedString(customerName)).append("\n");
    sb.append("    customerNumber: ").append(toIndentedString(customerNumber)).append("\n");
    sb.append("    impactAmount: ").append(toIndentedString(impactAmount)).append("\n");
    sb.append("    invoiceId: ").append(toIndentedString(invoiceId)).append("\n");
    sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
    sb.append("    reasonCode: ").append(toIndentedString(reasonCode)).append("\n");
    sb.append("    referenceId: ").append(toIndentedString(referenceId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

