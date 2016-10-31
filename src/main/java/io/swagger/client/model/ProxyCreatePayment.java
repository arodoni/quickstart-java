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
 * ProxyCreatePayment
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class ProxyCreatePayment   {
  @SerializedName("AccountId")
  private String accountId = null;

  @SerializedName("AccountingCode")
  private String accountingCode = null;

  @SerializedName("Amount")
  private Double amount = null;

  @SerializedName("AppliedCreditBalanceAmount")
  private Double appliedCreditBalanceAmount = null;

  @SerializedName("AuthTransactionId")
  private String authTransactionId = null;

  @SerializedName("Comment")
  private String comment = null;

  @SerializedName("EffectiveDate")
  private LocalDate effectiveDate = null;

  @SerializedName("Gateway")
  private String gateway = null;

  @SerializedName("GatewayOrderId")
  private String gatewayOrderId = null;

  @SerializedName("GatewayResponse")
  private String gatewayResponse = null;

  @SerializedName("GatewayResponseCode")
  private String gatewayResponseCode = null;

  @SerializedName("GatewayState")
  private String gatewayState = null;

  @SerializedName("PaymentMethodId")
  private String paymentMethodId = null;

  @SerializedName("PaymentNumber")
  private String paymentNumber = null;

  @SerializedName("ReferenceId")
  private String referenceId = null;

  @SerializedName("SoftDescriptor")
  private String softDescriptor = null;

  @SerializedName("SoftDescriptorPhone")
  private String softDescriptorPhone = null;

  @SerializedName("Status")
  private String status = null;

  @SerializedName("Type")
  private String type = null;

  public ProxyCreatePayment accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   *  The unique account ID for the customer that the payment is for. **Character limit**: 32 **Values**: a valid [account ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account) 
   * @return accountId
  **/
  @ApiModelProperty(example = "null", required = true, value = " The unique account ID for the customer that the payment is for. **Character limit**: 32 **Values**: a valid [account ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account) ")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public ProxyCreatePayment accountingCode(String accountingCode) {
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

  public ProxyCreatePayment amount(Double amount) {
    this.amount = amount;
    return this;
  }

   /**
   *  The amount of the payment. **Character limit**: 16 **Values**: a valid currency value 
   * @return amount
  **/
  @ApiModelProperty(example = "null", required = true, value = " The amount of the payment. **Character limit**: 16 **Values**: a valid currency value ")
  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public ProxyCreatePayment appliedCreditBalanceAmount(Double appliedCreditBalanceAmount) {
    this.appliedCreditBalanceAmount = appliedCreditBalanceAmount;
    return this;
  }

   /**
   *  The amount of the payment to apply to a credit balance. This field is required in a create() call when the `AppliedInvoiceAmount` field value is null. **Character limit**: 16 **Values**: a valid currency value 
   * @return appliedCreditBalanceAmount
  **/
  @ApiModelProperty(example = "null", required = true, value = " The amount of the payment to apply to a credit balance. This field is required in a create() call when the `AppliedInvoiceAmount` field value is null. **Character limit**: 16 **Values**: a valid currency value ")
  public Double getAppliedCreditBalanceAmount() {
    return appliedCreditBalanceAmount;
  }

  public void setAppliedCreditBalanceAmount(Double appliedCreditBalanceAmount) {
    this.appliedCreditBalanceAmount = appliedCreditBalanceAmount;
  }

  public ProxyCreatePayment authTransactionId(String authTransactionId) {
    this.authTransactionId = authTransactionId;
    return this;
  }

   /**
   *  The authorization transaction ID from the payment gateway. Use this field for electronic payments, such as credit cards. **Character limit**: 50 **Values**: a string of 50 characters or fewer 
   * @return authTransactionId
  **/
  @ApiModelProperty(example = "null", value = " The authorization transaction ID from the payment gateway. Use this field for electronic payments, such as credit cards. **Character limit**: 50 **Values**: a string of 50 characters or fewer ")
  public String getAuthTransactionId() {
    return authTransactionId;
  }

  public void setAuthTransactionId(String authTransactionId) {
    this.authTransactionId = authTransactionId;
  }

  public ProxyCreatePayment comment(String comment) {
    this.comment = comment;
    return this;
  }

   /**
   *  Additional information related to the payment. **Character limit**: 255 **Values**: a string of 255 characters or fewer 
   * @return comment
  **/
  @ApiModelProperty(example = "null", value = " Additional information related to the payment. **Character limit**: 255 **Values**: a string of 255 characters or fewer ")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public ProxyCreatePayment effectiveDate(LocalDate effectiveDate) {
    this.effectiveDate = effectiveDate;
    return this;
  }

   /**
   *  The date when the payment takes effect. **Character limit**: 29 **Values**: [a valid date and time value](/CB_Billing/WA_Dates_in_Zuora/A_Date_Format_and_Datetimes_in_Zuora) 
   * @return effectiveDate
  **/
  @ApiModelProperty(example = "null", required = true, value = " The date when the payment takes effect. **Character limit**: 29 **Values**: [a valid date and time value](/CB_Billing/WA_Dates_in_Zuora/A_Date_Format_and_Datetimes_in_Zuora) ")
  public LocalDate getEffectiveDate() {
    return effectiveDate;
  }

  public void setEffectiveDate(LocalDate effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  public ProxyCreatePayment gateway(String gateway) {
    this.gateway = gateway;
    return this;
  }

   /**
   *  Name of the [gateway](/C_Zuora_User_Guides/A_Billing_and_Payments/M_Payment_Gateways) instance that processes the payment. When creating a Payment, this must be a valid gateway instance name and this gateway must support the specific payment method. If not specified, the default gateway on the Account will be used. 
   * @return gateway
  **/
  @ApiModelProperty(example = "null", value = " Name of the [gateway](/C_Zuora_User_Guides/A_Billing_and_Payments/M_Payment_Gateways) instance that processes the payment. When creating a Payment, this must be a valid gateway instance name and this gateway must support the specific payment method. If not specified, the default gateway on the Account will be used. ")
  public String getGateway() {
    return gateway;
  }

  public void setGateway(String gateway) {
    this.gateway = gateway;
  }

  public ProxyCreatePayment gatewayOrderId(String gatewayOrderId) {
    this.gatewayOrderId = gatewayOrderId;
    return this;
  }

   /**
   *  A merchant-specified natural key value that can be passed to the electronic payment gateway when a payment is created. If not specified, the PaymentNumber will be passed in instead. **Character limit**: 70 **Values**: a string of 70 characters or fewer 
   * @return gatewayOrderId
  **/
  @ApiModelProperty(example = "null", value = " A merchant-specified natural key value that can be passed to the electronic payment gateway when a payment is created. If not specified, the PaymentNumber will be passed in instead. **Character limit**: 70 **Values**: a string of 70 characters or fewer ")
  public String getGatewayOrderId() {
    return gatewayOrderId;
  }

  public void setGatewayOrderId(String gatewayOrderId) {
    this.gatewayOrderId = gatewayOrderId;
  }

  public ProxyCreatePayment gatewayResponse(String gatewayResponse) {
    this.gatewayResponse = gatewayResponse;
    return this;
  }

   /**
   *  The message returned from the payment gateway for the payment. This message is gateway-dependent. **Character limit**: 500 **Values**: automatically generated 
   * @return gatewayResponse
  **/
  @ApiModelProperty(example = "null", required = true, value = " The message returned from the payment gateway for the payment. This message is gateway-dependent. **Character limit**: 500 **Values**: automatically generated ")
  public String getGatewayResponse() {
    return gatewayResponse;
  }

  public void setGatewayResponse(String gatewayResponse) {
    this.gatewayResponse = gatewayResponse;
  }

  public ProxyCreatePayment gatewayResponseCode(String gatewayResponseCode) {
    this.gatewayResponseCode = gatewayResponseCode;
    return this;
  }

   /**
   *  The code returned from the payment gateway for the payment. This code is gateway-dependent. **Character limit**: 20 **Values**: automatically generated 
   * @return gatewayResponseCode
  **/
  @ApiModelProperty(example = "null", required = true, value = " The code returned from the payment gateway for the payment. This code is gateway-dependent. **Character limit**: 20 **Values**: automatically generated ")
  public String getGatewayResponseCode() {
    return gatewayResponseCode;
  }

  public void setGatewayResponseCode(String gatewayResponseCode) {
    this.gatewayResponseCode = gatewayResponseCode;
  }

  public ProxyCreatePayment gatewayState(String gatewayState) {
    this.gatewayState = gatewayState;
    return this;
  }

   /**
   *  The status of the payment in the gateway; use for reconciliation. **Character limit**: 19 **Values**: automatically generated 
   * @return gatewayState
  **/
  @ApiModelProperty(example = "null", required = true, value = " The status of the payment in the gateway; use for reconciliation. **Character limit**: 19 **Values**: automatically generated ")
  public String getGatewayState() {
    return gatewayState;
  }

  public void setGatewayState(String gatewayState) {
    this.gatewayState = gatewayState;
  }

  public ProxyCreatePayment paymentMethodId(String paymentMethodId) {
    this.paymentMethodId = paymentMethodId;
    return this;
  }

   /**
   *  The ID of the payment method used for the payment. Required for Create. **Character limit**: 32 **Values**: automatically generated 
   * @return paymentMethodId
  **/
  @ApiModelProperty(example = "null", value = " The ID of the payment method used for the payment. Required for Create. **Character limit**: 32 **Values**: automatically generated ")
  public String getPaymentMethodId() {
    return paymentMethodId;
  }

  public void setPaymentMethodId(String paymentMethodId) {
    this.paymentMethodId = paymentMethodId;
  }

  public ProxyCreatePayment paymentNumber(String paymentNumber) {
    this.paymentNumber = paymentNumber;
    return this;
  }

   /**
   *  The unique identification number of a payment. For example: P-00000028. **Character limit**: 32 **Values**: automatically generated 
   * @return paymentNumber
  **/
  @ApiModelProperty(example = "null", required = true, value = " The unique identification number of a payment. For example: P-00000028. **Character limit**: 32 **Values**: automatically generated ")
  public String getPaymentNumber() {
    return paymentNumber;
  }

  public void setPaymentNumber(String paymentNumber) {
    this.paymentNumber = paymentNumber;
  }

  public ProxyCreatePayment referenceId(String referenceId) {
    this.referenceId = referenceId;
    return this;
  }

   /**
   *  The transaction ID returned by the payment gateway. Use this field to reconcile payments between your gateway and Z-Payments. **Character limit**: 60 **Values**: a string of 60 characters or fewer 
   * @return referenceId
  **/
  @ApiModelProperty(example = "null", value = " The transaction ID returned by the payment gateway. Use this field to reconcile payments between your gateway and Z-Payments. **Character limit**: 60 **Values**: a string of 60 characters or fewer ")
  public String getReferenceId() {
    return referenceId;
  }

  public void setReferenceId(String referenceId) {
    this.referenceId = referenceId;
  }

  public ProxyCreatePayment softDescriptor(String softDescriptor) {
    this.softDescriptor = softDescriptor;
    return this;
  }

   /**
   *  [A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/Supported_Payment_Gateways/Verifi_Global_Payment_Gateway#Soft_Descriptors_(Optional)). **Character limit**: 35 **Values**: `[SDMerchantName]*[SDProductionInfo]` 
   * @return softDescriptor
  **/
  @ApiModelProperty(example = "null", value = " [A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/Supported_Payment_Gateways/Verifi_Global_Payment_Gateway#Soft_Descriptors_(Optional)). **Character limit**: 35 **Values**: `[SDMerchantName]*[SDProductionInfo]` ")
  public String getSoftDescriptor() {
    return softDescriptor;
  }

  public void setSoftDescriptor(String softDescriptor) {
    this.softDescriptor = softDescriptor;
  }

  public ProxyCreatePayment softDescriptorPhone(String softDescriptorPhone) {
    this.softDescriptorPhone = softDescriptorPhone;
    return this;
  }

   /**
   *  [A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/Supported_Payment_Gateways/Verifi_Global_Payment_Gateway#Soft_Descriptors_(Optional)). **Character limit**: 20 **Values**: `[SDPhone]` 
   * @return softDescriptorPhone
  **/
  @ApiModelProperty(example = "null", value = " [A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/Supported_Payment_Gateways/Verifi_Global_Payment_Gateway#Soft_Descriptors_(Optional)). **Character limit**: 20 **Values**: `[SDPhone]` ")
  public String getSoftDescriptorPhone() {
    return softDescriptorPhone;
  }

  public void setSoftDescriptorPhone(String softDescriptorPhone) {
    this.softDescriptorPhone = softDescriptorPhone;
  }

  public ProxyCreatePayment status(String status) {
    this.status = status;
    return this;
  }

   /**
   *  The status of the payment in Zuora. The value depends on the type of payment. **Character limit**: 11 **Values**: one of the following:  -  Electronic payments: `Processed`, `Error`, `Voided`  -  External payments: `Processed`, `Canceled`  See [Troubleshooting Payment Runs](https://knowledgecenter.zuora.com/CB_Billing/K_Payment_Operations/CA_Payment_Runs/Troubleshooting_Payment_Runs) for more information. * Update of status can change value from `Processed` to `Canceled` when the payment type is external. 
   * @return status
  **/
  @ApiModelProperty(example = "null", required = true, value = " The status of the payment in Zuora. The value depends on the type of payment. **Character limit**: 11 **Values**: one of the following:  -  Electronic payments: `Processed`, `Error`, `Voided`  -  External payments: `Processed`, `Canceled`  See [Troubleshooting Payment Runs](https://knowledgecenter.zuora.com/CB_Billing/K_Payment_Operations/CA_Payment_Runs/Troubleshooting_Payment_Runs) for more information. * Update of status can change value from `Processed` to `Canceled` when the payment type is external. ")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ProxyCreatePayment type(String type) {
    this.type = type;
    return this;
  }

   /**
   *  Indicates if the payment is external or electronic. **Character limit**: 10 **Values**: `External`, `Electronic` 
   * @return type
  **/
  @ApiModelProperty(example = "null", required = true, value = " Indicates if the payment is external or electronic. **Character limit**: 10 **Values**: `External`, `Electronic` ")
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
    ProxyCreatePayment proxyCreatePayment = (ProxyCreatePayment) o;
    return Objects.equals(this.accountId, proxyCreatePayment.accountId) &&
        Objects.equals(this.accountingCode, proxyCreatePayment.accountingCode) &&
        Objects.equals(this.amount, proxyCreatePayment.amount) &&
        Objects.equals(this.appliedCreditBalanceAmount, proxyCreatePayment.appliedCreditBalanceAmount) &&
        Objects.equals(this.authTransactionId, proxyCreatePayment.authTransactionId) &&
        Objects.equals(this.comment, proxyCreatePayment.comment) &&
        Objects.equals(this.effectiveDate, proxyCreatePayment.effectiveDate) &&
        Objects.equals(this.gateway, proxyCreatePayment.gateway) &&
        Objects.equals(this.gatewayOrderId, proxyCreatePayment.gatewayOrderId) &&
        Objects.equals(this.gatewayResponse, proxyCreatePayment.gatewayResponse) &&
        Objects.equals(this.gatewayResponseCode, proxyCreatePayment.gatewayResponseCode) &&
        Objects.equals(this.gatewayState, proxyCreatePayment.gatewayState) &&
        Objects.equals(this.paymentMethodId, proxyCreatePayment.paymentMethodId) &&
        Objects.equals(this.paymentNumber, proxyCreatePayment.paymentNumber) &&
        Objects.equals(this.referenceId, proxyCreatePayment.referenceId) &&
        Objects.equals(this.softDescriptor, proxyCreatePayment.softDescriptor) &&
        Objects.equals(this.softDescriptorPhone, proxyCreatePayment.softDescriptorPhone) &&
        Objects.equals(this.status, proxyCreatePayment.status) &&
        Objects.equals(this.type, proxyCreatePayment.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, accountingCode, amount, appliedCreditBalanceAmount, authTransactionId, comment, effectiveDate, gateway, gatewayOrderId, gatewayResponse, gatewayResponseCode, gatewayState, paymentMethodId, paymentNumber, referenceId, softDescriptor, softDescriptorPhone, status, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProxyCreatePayment {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountingCode: ").append(toIndentedString(accountingCode)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    appliedCreditBalanceAmount: ").append(toIndentedString(appliedCreditBalanceAmount)).append("\n");
    sb.append("    authTransactionId: ").append(toIndentedString(authTransactionId)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    effectiveDate: ").append(toIndentedString(effectiveDate)).append("\n");
    sb.append("    gateway: ").append(toIndentedString(gateway)).append("\n");
    sb.append("    gatewayOrderId: ").append(toIndentedString(gatewayOrderId)).append("\n");
    sb.append("    gatewayResponse: ").append(toIndentedString(gatewayResponse)).append("\n");
    sb.append("    gatewayResponseCode: ").append(toIndentedString(gatewayResponseCode)).append("\n");
    sb.append("    gatewayState: ").append(toIndentedString(gatewayState)).append("\n");
    sb.append("    paymentMethodId: ").append(toIndentedString(paymentMethodId)).append("\n");
    sb.append("    paymentNumber: ").append(toIndentedString(paymentNumber)).append("\n");
    sb.append("    referenceId: ").append(toIndentedString(referenceId)).append("\n");
    sb.append("    softDescriptor: ").append(toIndentedString(softDescriptor)).append("\n");
    sb.append("    softDescriptorPhone: ").append(toIndentedString(softDescriptorPhone)).append("\n");
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

