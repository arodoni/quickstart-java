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
 * ProxyCreatePaymentMethod
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class ProxyCreatePaymentMethod   {
  @SerializedName("AccountId")
  private String accountId = null;

  @SerializedName("AchAbaCode")
  private String achAbaCode = null;

  @SerializedName("AchAccountName")
  private String achAccountName = null;

  @SerializedName("AchAccountType")
  private String achAccountType = null;

  @SerializedName("AchAddress1")
  private String achAddress1 = null;

  @SerializedName("AchAddress2")
  private String achAddress2 = null;

  @SerializedName("AchBankName")
  private String achBankName = null;

  @SerializedName("BankBranchCode")
  private String bankBranchCode = null;

  @SerializedName("BankCheckDigit")
  private String bankCheckDigit = null;

  @SerializedName("BankCity")
  private String bankCity = null;

  @SerializedName("BankCode")
  private String bankCode = null;

  @SerializedName("BankName")
  private String bankName = null;

  @SerializedName("BankPostalCode")
  private String bankPostalCode = null;

  @SerializedName("BankStreetName")
  private String bankStreetName = null;

  @SerializedName("BankStreetNumber")
  private String bankStreetNumber = null;

  @SerializedName("BankTransferAccountName")
  private String bankTransferAccountName = null;

  @SerializedName("BankTransferAccountType")
  private String bankTransferAccountType = null;

  @SerializedName("BankTransferType")
  private String bankTransferType = null;

  @SerializedName("BusinessIdentificationCode")
  private String businessIdentificationCode = null;

  @SerializedName("City")
  private String city = null;

  @SerializedName("Country")
  private String country = null;

  @SerializedName("CreditCardAddress1")
  private String creditCardAddress1 = null;

  @SerializedName("CreditCardAddress2")
  private String creditCardAddress2 = null;

  @SerializedName("CreditCardCity")
  private String creditCardCity = null;

  @SerializedName("CreditCardCountry")
  private String creditCardCountry = null;

  @SerializedName("CreditCardExpirationMonth")
  private Integer creditCardExpirationMonth = null;

  @SerializedName("CreditCardExpirationYear")
  private Integer creditCardExpirationYear = null;

  @SerializedName("CreditCardHolderName")
  private String creditCardHolderName = null;

  @SerializedName("CreditCardPostalCode")
  private String creditCardPostalCode = null;

  @SerializedName("CreditCardState")
  private String creditCardState = null;

  @SerializedName("CreditCardType")
  private String creditCardType = null;

  @SerializedName("DeviceSessionId")
  private String deviceSessionId = null;

  @SerializedName("Email")
  private String email = null;

  @SerializedName("ExistingMandate")
  private String existingMandate = null;

  @SerializedName("FirstName")
  private String firstName = null;

  @SerializedName("IBAN")
  private String IBAN = null;

  @SerializedName("IPAddress")
  private String iPAddress = null;

  @SerializedName("LastName")
  private String lastName = null;

  @SerializedName("LastTransactionDateTime")
  private DateTime lastTransactionDateTime = null;

  @SerializedName("LastTransactionStatus")
  private String lastTransactionStatus = null;

  @SerializedName("MandateCreationDate")
  private LocalDate mandateCreationDate = null;

  @SerializedName("MandateID")
  private String mandateID = null;

  @SerializedName("MandateReceived")
  private String mandateReceived = null;

  @SerializedName("MandateUpdateDate")
  private LocalDate mandateUpdateDate = null;

  @SerializedName("MaxConsecutivePaymentFailures")
  private Integer maxConsecutivePaymentFailures = null;

  @SerializedName("PaymentRetryWindow")
  private Integer paymentRetryWindow = null;

  @SerializedName("PaypalBaid")
  private String paypalBaid = null;

  @SerializedName("PaypalEmail")
  private String paypalEmail = null;

  @SerializedName("PaypalPreapprovalKey")
  private String paypalPreapprovalKey = null;

  @SerializedName("PaypalType")
  private String paypalType = null;

  @SerializedName("Phone")
  private String phone = null;

  @SerializedName("PostalCode")
  private String postalCode = null;

  @SerializedName("SecondTokenId")
  private String secondTokenId = null;

  @SerializedName("State")
  private String state = null;

  @SerializedName("StreetName")
  private String streetName = null;

  @SerializedName("StreetNumber")
  private String streetNumber = null;

  @SerializedName("TokenId")
  private String tokenId = null;

  @SerializedName("TotalNumberOfErrorPayments")
  private Integer totalNumberOfErrorPayments = null;

  @SerializedName("TotalNumberOfProcessedPayments")
  private Integer totalNumberOfProcessedPayments = null;

  @SerializedName("Type")
  private String type = null;

  @SerializedName("UseDefaultRetryRule")
  private Boolean useDefaultRetryRule = null;

  public ProxyCreatePaymentMethod accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   *  The ID of the customer account associated with this payment method. This field is not required for the `[account ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account) 
   * @return accountId
  **/
  @ApiModelProperty(example = "null", value = " The ID of the customer account associated with this payment method. This field is not required for the `[account ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account) ")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public ProxyCreatePaymentMethod achAbaCode(String achAbaCode) {
    this.achAbaCode = achAbaCode;
    return this;
  }

   /**
   *  The nine-digit routing number or ABA number used by banks. Use this field for ACH payment methods. **Character limit**: 9 **Values**: a string of 9 characters or fewer 
   * @return achAbaCode
  **/
  @ApiModelProperty(example = "null", value = " The nine-digit routing number or ABA number used by banks. Use this field for ACH payment methods. **Character limit**: 9 **Values**: a string of 9 characters or fewer ")
  public String getAchAbaCode() {
    return achAbaCode;
  }

  public void setAchAbaCode(String achAbaCode) {
    this.achAbaCode = achAbaCode;
  }

  public ProxyCreatePaymentMethod achAccountName(String achAccountName) {
    this.achAccountName = achAccountName;
    return this;
  }

   /**
   *  The name of the account holder, which can be either a person or a company. Use this field for ACH payment methods. **Character limit**: 70 **Values**: a string of 70 characters or fewer 
   * @return achAccountName
  **/
  @ApiModelProperty(example = "null", value = " The name of the account holder, which can be either a person or a company. Use this field for ACH payment methods. **Character limit**: 70 **Values**: a string of 70 characters or fewer ")
  public String getAchAccountName() {
    return achAccountName;
  }

  public void setAchAccountName(String achAccountName) {
    this.achAccountName = achAccountName;
  }

  public ProxyCreatePaymentMethod achAccountType(String achAccountType) {
    this.achAccountType = achAccountType;
    return this;
  }

   /**
   *  The type of bank account associated with the ACH payment. Use this field for ACH payment methods. **Character limit**: 16 **Values**:  - `BusinessChecking` - `Checking` - `Saving` 
   * @return achAccountType
  **/
  @ApiModelProperty(example = "null", value = " The type of bank account associated with the ACH payment. Use this field for ACH payment methods. **Character limit**: 16 **Values**:  - `BusinessChecking` - `Checking` - `Saving` ")
  public String getAchAccountType() {
    return achAccountType;
  }

  public void setAchAccountType(String achAccountType) {
    this.achAccountType = achAccountType;
  }

  public ProxyCreatePaymentMethod achAddress1(String achAddress1) {
    this.achAddress1 = achAddress1;
    return this;
  }

   /**
   *  Line 1 for the ACH address. Required on create for the Vantiv payment gateway. Optional for other gateways. **Character limit:** **Values:** an address 
   * @return achAddress1
  **/
  @ApiModelProperty(example = "null", value = " Line 1 for the ACH address. Required on create for the Vantiv payment gateway. Optional for other gateways. **Character limit:** **Values:** an address ")
  public String getAchAddress1() {
    return achAddress1;
  }

  public void setAchAddress1(String achAddress1) {
    this.achAddress1 = achAddress1;
  }

  public ProxyCreatePaymentMethod achAddress2(String achAddress2) {
    this.achAddress2 = achAddress2;
    return this;
  }

   /**
   *  Line 2 for the ACH address. Required on create for the Vantiv payment gateway. Optional for other gateways. **Character limit:** **Values:** an address 
   * @return achAddress2
  **/
  @ApiModelProperty(example = "null", value = " Line 2 for the ACH address. Required on create for the Vantiv payment gateway. Optional for other gateways. **Character limit:** **Values:** an address ")
  public String getAchAddress2() {
    return achAddress2;
  }

  public void setAchAddress2(String achAddress2) {
    this.achAddress2 = achAddress2;
  }

  public ProxyCreatePaymentMethod achBankName(String achBankName) {
    this.achBankName = achBankName;
    return this;
  }

   /**
   *  The name of the bank where the ACH payment account is held. Use this field for ACH payment methods. **Character limit**: 70 **Values**: a string of 70 characters or fewer 
   * @return achBankName
  **/
  @ApiModelProperty(example = "null", value = " The name of the bank where the ACH payment account is held. Use this field for ACH payment methods. **Character limit**: 70 **Values**: a string of 70 characters or fewer ")
  public String getAchBankName() {
    return achBankName;
  }

  public void setAchBankName(String achBankName) {
    this.achBankName = achBankName;
  }

  public ProxyCreatePaymentMethod bankBranchCode(String bankBranchCode) {
    this.bankBranchCode = bankBranchCode;
    return this;
  }

   /**
   *  The branch code of the bank used for direct debit. Use this field for direct debit payment methods. **Character limit**: 10 **Values**:  string of 10 characters or fewer 
   * @return bankBranchCode
  **/
  @ApiModelProperty(example = "null", value = " The branch code of the bank used for direct debit. Use this field for direct debit payment methods. **Character limit**: 10 **Values**:  string of 10 characters or fewer ")
  public String getBankBranchCode() {
    return bankBranchCode;
  }

  public void setBankBranchCode(String bankBranchCode) {
    this.bankBranchCode = bankBranchCode;
  }

  public ProxyCreatePaymentMethod bankCheckDigit(String bankCheckDigit) {
    this.bankCheckDigit = bankCheckDigit;
    return this;
  }

   /**
   * The check digit in the international bank account number, which confirms the validity of the account. Use this field for direct debit payment methods. **Character limit**: 4 **Values**:  string of 4 characters or fewer 
   * @return bankCheckDigit
  **/
  @ApiModelProperty(example = "null", value = "The check digit in the international bank account number, which confirms the validity of the account. Use this field for direct debit payment methods. **Character limit**: 4 **Values**:  string of 4 characters or fewer ")
  public String getBankCheckDigit() {
    return bankCheckDigit;
  }

  public void setBankCheckDigit(String bankCheckDigit) {
    this.bankCheckDigit = bankCheckDigit;
  }

  public ProxyCreatePaymentMethod bankCity(String bankCity) {
    this.bankCity = bankCity;
    return this;
  }

   /**
   *  The city of the direct debit bank. Use this field for direct debit payment methods. **Character limit**:70 **Values**:  string of 70 characters or fewer 
   * @return bankCity
  **/
  @ApiModelProperty(example = "null", value = " The city of the direct debit bank. Use this field for direct debit payment methods. **Character limit**:70 **Values**:  string of 70 characters or fewer ")
  public String getBankCity() {
    return bankCity;
  }

  public void setBankCity(String bankCity) {
    this.bankCity = bankCity;
  }

  public ProxyCreatePaymentMethod bankCode(String bankCode) {
    this.bankCode = bankCode;
    return this;
  }

   /**
   *  The sort code or number that identifies the bank. This is also known as the sort code. This field is required for direct debit payment methods. **Character limit**: 18 **Values**:  string of 18 characters or fewer 
   * @return bankCode
  **/
  @ApiModelProperty(example = "null", value = " The sort code or number that identifies the bank. This is also known as the sort code. This field is required for direct debit payment methods. **Character limit**: 18 **Values**:  string of 18 characters or fewer ")
  public String getBankCode() {
    return bankCode;
  }

  public void setBankCode(String bankCode) {
    this.bankCode = bankCode;
  }

  public ProxyCreatePaymentMethod bankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

   /**
   *  The name of the direct debit bank. Use this field for direct debit payment methods. **Character limit**:80 **Values**:  string of 80 characters or fewer 
   * @return bankName
  **/
  @ApiModelProperty(example = "null", value = " The name of the direct debit bank. Use this field for direct debit payment methods. **Character limit**:80 **Values**:  string of 80 characters or fewer ")
  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public ProxyCreatePaymentMethod bankPostalCode(String bankPostalCode) {
    this.bankPostalCode = bankPostalCode;
    return this;
  }

   /**
   *  The zip code or postal code of the direct debit bank. Use this field for direct debit payment methods. **Character limit**:20 **Values**:  string of 20 characters or fewer 
   * @return bankPostalCode
  **/
  @ApiModelProperty(example = "null", value = " The zip code or postal code of the direct debit bank. Use this field for direct debit payment methods. **Character limit**:20 **Values**:  string of 20 characters or fewer ")
  public String getBankPostalCode() {
    return bankPostalCode;
  }

  public void setBankPostalCode(String bankPostalCode) {
    this.bankPostalCode = bankPostalCode;
  }

  public ProxyCreatePaymentMethod bankStreetName(String bankStreetName) {
    this.bankStreetName = bankStreetName;
    return this;
  }

   /**
   *  The name of the street of the direct debit bank. Use this field for direct debit payment methods. **Character limit**:60 **Values**:  string of 60 characters or fewer 
   * @return bankStreetName
  **/
  @ApiModelProperty(example = "null", value = " The name of the street of the direct debit bank. Use this field for direct debit payment methods. **Character limit**:60 **Values**:  string of 60 characters or fewer ")
  public String getBankStreetName() {
    return bankStreetName;
  }

  public void setBankStreetName(String bankStreetName) {
    this.bankStreetName = bankStreetName;
  }

  public ProxyCreatePaymentMethod bankStreetNumber(String bankStreetNumber) {
    this.bankStreetNumber = bankStreetNumber;
    return this;
  }

   /**
   *  The number of the direct debit bank. Use this field for direct debit payment methods. **Character limit**:10 **Values**:  string of 10 characters or fewer 
   * @return bankStreetNumber
  **/
  @ApiModelProperty(example = "null", value = " The number of the direct debit bank. Use this field for direct debit payment methods. **Character limit**:10 **Values**:  string of 10 characters or fewer ")
  public String getBankStreetNumber() {
    return bankStreetNumber;
  }

  public void setBankStreetNumber(String bankStreetNumber) {
    this.bankStreetNumber = bankStreetNumber;
  }

  public ProxyCreatePaymentMethod bankTransferAccountName(String bankTransferAccountName) {
    this.bankTransferAccountName = bankTransferAccountName;
    return this;
  }

   /**
   *  The name on the direct debit bank account. Use this field for direct debit payment methods. **Character limit**: 60 **Values**:  string of 60 characters or fewer 
   * @return bankTransferAccountName
  **/
  @ApiModelProperty(example = "null", value = " The name on the direct debit bank account. Use this field for direct debit payment methods. **Character limit**: 60 **Values**:  string of 60 characters or fewer ")
  public String getBankTransferAccountName() {
    return bankTransferAccountName;
  }

  public void setBankTransferAccountName(String bankTransferAccountName) {
    this.bankTransferAccountName = bankTransferAccountName;
  }

  public ProxyCreatePaymentMethod bankTransferAccountType(String bankTransferAccountType) {
    this.bankTransferAccountType = bankTransferAccountType;
    return this;
  }

   /**
   *  The type of the customer's bank account. Use this field for direct debit payment methods. **Character limit**: 11 **Values**: `DirectDebit` 
   * @return bankTransferAccountType
  **/
  @ApiModelProperty(example = "null", value = " The type of the customer's bank account. Use this field for direct debit payment methods. **Character limit**: 11 **Values**: `DirectDebit` ")
  public String getBankTransferAccountType() {
    return bankTransferAccountType;
  }

  public void setBankTransferAccountType(String bankTransferAccountType) {
    this.bankTransferAccountType = bankTransferAccountType;
  }

  public ProxyCreatePaymentMethod bankTransferType(String bankTransferType) {
    this.bankTransferType = bankTransferType;
    return this;
  }

   /**
   *  Specifies the type of direct debit transfer. The value of this field is dependent on the country of the user. Use this field is used for direct debit payment methods. **Character limit**: 20 **Values**:  - `AutomatischIncasso` (NL) - `LastschriftDE` (Germany) - `LastschriftAT` (Austria) - `DemandeDePrelevement` (FR) - `DirectDebitUK` (UK) - `Domicil` (Belgium) - `LastschriftCH` (CH) - `RID` (Italy) - `OrdenDeDomiciliacion` (Spain) 
   * @return bankTransferType
  **/
  @ApiModelProperty(example = "null", value = " Specifies the type of direct debit transfer. The value of this field is dependent on the country of the user. Use this field is used for direct debit payment methods. **Character limit**: 20 **Values**:  - `AutomatischIncasso` (NL) - `LastschriftDE` (Germany) - `LastschriftAT` (Austria) - `DemandeDePrelevement` (FR) - `DirectDebitUK` (UK) - `Domicil` (Belgium) - `LastschriftCH` (CH) - `RID` (Italy) - `OrdenDeDomiciliacion` (Spain) ")
  public String getBankTransferType() {
    return bankTransferType;
  }

  public void setBankTransferType(String bankTransferType) {
    this.bankTransferType = bankTransferType;
  }

  public ProxyCreatePaymentMethod businessIdentificationCode(String businessIdentificationCode) {
    this.businessIdentificationCode = businessIdentificationCode;
    return this;
  }

   /**
   *  The business identification code for Swiss direct payment methods that use the Global Collect payment gateway. Use this field only for direct debit payments in Switzerland with Global Collect. **Character limit**: 11 **Values**: string of 11 characters or fewer 
   * @return businessIdentificationCode
  **/
  @ApiModelProperty(example = "null", value = " The business identification code for Swiss direct payment methods that use the Global Collect payment gateway. Use this field only for direct debit payments in Switzerland with Global Collect. **Character limit**: 11 **Values**: string of 11 characters or fewer ")
  public String getBusinessIdentificationCode() {
    return businessIdentificationCode;
  }

  public void setBusinessIdentificationCode(String businessIdentificationCode) {
    this.businessIdentificationCode = businessIdentificationCode;
  }

  public ProxyCreatePaymentMethod city(String city) {
    this.city = city;
    return this;
  }

   /**
   *  The city of the customer's address. Use this field for direct debit payment methods. **Character limit**:80 **Values**:  string of 80 characters or fewer 
   * @return city
  **/
  @ApiModelProperty(example = "null", value = " The city of the customer's address. Use this field for direct debit payment methods. **Character limit**:80 **Values**:  string of 80 characters or fewer ")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public ProxyCreatePaymentMethod country(String country) {
    this.country = country;
    return this;
  }

   /**
   *  The two-letter country code of the customer's address. Use this field for direct debit payment methods. **Character limit**: 2 **Values**: [a valid country code](/BC_Developers/SOAP_API/J_Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes) 
   * @return country
  **/
  @ApiModelProperty(example = "null", value = " The two-letter country code of the customer's address. Use this field for direct debit payment methods. **Character limit**: 2 **Values**: [a valid country code](/BC_Developers/SOAP_API/J_Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes) ")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public ProxyCreatePaymentMethod creditCardAddress1(String creditCardAddress1) {
    this.creditCardAddress1 = creditCardAddress1;
    return this;
  }

   /**
   *  The first line of the card holder's address, which is often a street address or business name. Use this field for credit card and direct debit payment methods. **Character limit**: 255 **Values**: a string of 255 characters or fewer 
   * @return creditCardAddress1
  **/
  @ApiModelProperty(example = "null", value = " The first line of the card holder's address, which is often a street address or business name. Use this field for credit card and direct debit payment methods. **Character limit**: 255 **Values**: a string of 255 characters or fewer ")
  public String getCreditCardAddress1() {
    return creditCardAddress1;
  }

  public void setCreditCardAddress1(String creditCardAddress1) {
    this.creditCardAddress1 = creditCardAddress1;
  }

  public ProxyCreatePaymentMethod creditCardAddress2(String creditCardAddress2) {
    this.creditCardAddress2 = creditCardAddress2;
    return this;
  }

   /**
   *  The second line of the card holder's address. Use this field for credit card and direct debit payment methods. **Character limit**: 255 **Values**: a string of 255 characters or fewer 
   * @return creditCardAddress2
  **/
  @ApiModelProperty(example = "null", value = " The second line of the card holder's address. Use this field for credit card and direct debit payment methods. **Character limit**: 255 **Values**: a string of 255 characters or fewer ")
  public String getCreditCardAddress2() {
    return creditCardAddress2;
  }

  public void setCreditCardAddress2(String creditCardAddress2) {
    this.creditCardAddress2 = creditCardAddress2;
  }

  public ProxyCreatePaymentMethod creditCardCity(String creditCardCity) {
    this.creditCardCity = creditCardCity;
    return this;
  }

   /**
   *  The city of the card holder's address. Use this field for credit card and direct debit payment methods **Character limit**: 40 **Values**: a string of 40 characters or fewer 
   * @return creditCardCity
  **/
  @ApiModelProperty(example = "null", value = " The city of the card holder's address. Use this field for credit card and direct debit payment methods **Character limit**: 40 **Values**: a string of 40 characters or fewer ")
  public String getCreditCardCity() {
    return creditCardCity;
  }

  public void setCreditCardCity(String creditCardCity) {
    this.creditCardCity = creditCardCity;
  }

  public ProxyCreatePaymentMethod creditCardCountry(String creditCardCountry) {
    this.creditCardCountry = creditCardCountry;
    return this;
  }

   /**
   *  The country of the card holder's address. See [a supported country name](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/J_Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes) 
   * @return creditCardCountry
  **/
  @ApiModelProperty(example = "null", value = " The country of the card holder's address. See [a supported country name](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/J_Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes) ")
  public String getCreditCardCountry() {
    return creditCardCountry;
  }

  public void setCreditCardCountry(String creditCardCountry) {
    this.creditCardCountry = creditCardCountry;
  }

  public ProxyCreatePaymentMethod creditCardExpirationMonth(Integer creditCardExpirationMonth) {
    this.creditCardExpirationMonth = creditCardExpirationMonth;
    return this;
  }

   /**
   *  The expiration month of the credit card or debit card. Use this field for credit card and direct debit payment methods. **Character limit**: 2 **Values**: a two-digit number, 01 - 12 
   * @return creditCardExpirationMonth
  **/
  @ApiModelProperty(example = "null", value = " The expiration month of the credit card or debit card. Use this field for credit card and direct debit payment methods. **Character limit**: 2 **Values**: a two-digit number, 01 - 12 ")
  public Integer getCreditCardExpirationMonth() {
    return creditCardExpirationMonth;
  }

  public void setCreditCardExpirationMonth(Integer creditCardExpirationMonth) {
    this.creditCardExpirationMonth = creditCardExpirationMonth;
  }

  public ProxyCreatePaymentMethod creditCardExpirationYear(Integer creditCardExpirationYear) {
    this.creditCardExpirationYear = creditCardExpirationYear;
    return this;
  }

   /**
   *  The expiration month of the credit card or debit card. Use this field for credit card and direct debit payment methods. **Character limit**: 4 **Values**: a four-digit number 
   * @return creditCardExpirationYear
  **/
  @ApiModelProperty(example = "null", value = " The expiration month of the credit card or debit card. Use this field for credit card and direct debit payment methods. **Character limit**: 4 **Values**: a four-digit number ")
  public Integer getCreditCardExpirationYear() {
    return creditCardExpirationYear;
  }

  public void setCreditCardExpirationYear(Integer creditCardExpirationYear) {
    this.creditCardExpirationYear = creditCardExpirationYear;
  }

  public ProxyCreatePaymentMethod creditCardHolderName(String creditCardHolderName) {
    this.creditCardHolderName = creditCardHolderName;
    return this;
  }

   /**
   *  The full name of the card holder. Use this field for credit card and direct debit payment methods. **Character limit**: 50 **Values**: a string of 50 characters or fewer 
   * @return creditCardHolderName
  **/
  @ApiModelProperty(example = "null", value = " The full name of the card holder. Use this field for credit card and direct debit payment methods. **Character limit**: 50 **Values**: a string of 50 characters or fewer ")
  public String getCreditCardHolderName() {
    return creditCardHolderName;
  }

  public void setCreditCardHolderName(String creditCardHolderName) {
    this.creditCardHolderName = creditCardHolderName;
  }

  public ProxyCreatePaymentMethod creditCardPostalCode(String creditCardPostalCode) {
    this.creditCardPostalCode = creditCardPostalCode;
    return this;
  }

   /**
   *  The billing address's zip code. This field is required only when you define a debit card or credit card payment. **Character limit**: 20 **Values**: a string of 20 characters or fewer 
   * @return creditCardPostalCode
  **/
  @ApiModelProperty(example = "null", value = " The billing address's zip code. This field is required only when you define a debit card or credit card payment. **Character limit**: 20 **Values**: a string of 20 characters or fewer ")
  public String getCreditCardPostalCode() {
    return creditCardPostalCode;
  }

  public void setCreditCardPostalCode(String creditCardPostalCode) {
    this.creditCardPostalCode = creditCardPostalCode;
  }

  public ProxyCreatePaymentMethod creditCardState(String creditCardState) {
    this.creditCardState = creditCardState;
    return this;
  }

   /**
   *  The billing address's state. Use this field is if the `CreditCardCountry` value is either Canada or the US. State names must be spelled in full. For more information see the list of [a valid state name](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/J_Country%2C_State%2C_and_Province_Codes/B_State_Names_and_2-Digit_Codes) 
   * @return creditCardState
  **/
  @ApiModelProperty(example = "null", value = " The billing address's state. Use this field is if the `CreditCardCountry` value is either Canada or the US. State names must be spelled in full. For more information see the list of [a valid state name](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/J_Country%2C_State%2C_and_Province_Codes/B_State_Names_and_2-Digit_Codes) ")
  public String getCreditCardState() {
    return creditCardState;
  }

  public void setCreditCardState(String creditCardState) {
    this.creditCardState = creditCardState;
  }

  public ProxyCreatePaymentMethod creditCardType(String creditCardType) {
    this.creditCardType = creditCardType;
    return this;
  }

   /**
   *  The type of credit card or debit card. This field is required only when you define a debit card or credit card payment. **Character limit**: 32 **Values**: `AmericanExpress`, `Discover`, `MasterCard`, `Visa` 
   * @return creditCardType
  **/
  @ApiModelProperty(example = "null", value = " The type of credit card or debit card. This field is required only when you define a debit card or credit card payment. **Character limit**: 32 **Values**: `AmericanExpress`, `Discover`, `MasterCard`, `Visa` ")
  public String getCreditCardType() {
    return creditCardType;
  }

  public void setCreditCardType(String creditCardType) {
    this.creditCardType = creditCardType;
  }

  public ProxyCreatePaymentMethod deviceSessionId(String deviceSessionId) {
    this.deviceSessionId = deviceSessionId;
    return this;
  }

   /**
   *  The session ID of the user when the `PaymentMethod` was created or updated. Some gateways use this field for fraud prevention. If this field is passed to Zuora, then Zuora passes this field to supported gateways. Currently only Verifi supports this field. **Character limit**: 255 **Values**: 
   * @return deviceSessionId
  **/
  @ApiModelProperty(example = "null", value = " The session ID of the user when the `PaymentMethod` was created or updated. Some gateways use this field for fraud prevention. If this field is passed to Zuora, then Zuora passes this field to supported gateways. Currently only Verifi supports this field. **Character limit**: 255 **Values**: ")
  public String getDeviceSessionId() {
    return deviceSessionId;
  }

  public void setDeviceSessionId(String deviceSessionId) {
    this.deviceSessionId = deviceSessionId;
  }

  public ProxyCreatePaymentMethod email(String email) {
    this.email = email;
    return this;
  }

   /**
   *  An email address for the payment method in addition to the bill to contact email address. **Character limit**: 80 **Values**: a string of 80 characters or fewer 
   * @return email
  **/
  @ApiModelProperty(example = "null", value = " An email address for the payment method in addition to the bill to contact email address. **Character limit**: 80 **Values**: a string of 80 characters or fewer ")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ProxyCreatePaymentMethod existingMandate(String existingMandate) {
    this.existingMandate = existingMandate;
    return this;
  }

   /**
   *  Indicates if the customer has an existing mandate or a new mandate. A mandate is a signed authorization for UK and NL customers. When you are migrating mandates from another system, be sure to set this field correctly. If you indicate that a new mandate is an existing mandate or vice-versa, then transactions fail. This field is used only for the direct debit payment method. **Character limit**: 3 **Values**: `Yes`, `No` 
   * @return existingMandate
  **/
  @ApiModelProperty(example = "null", value = " Indicates if the customer has an existing mandate or a new mandate. A mandate is a signed authorization for UK and NL customers. When you are migrating mandates from another system, be sure to set this field correctly. If you indicate that a new mandate is an existing mandate or vice-versa, then transactions fail. This field is used only for the direct debit payment method. **Character limit**: 3 **Values**: `Yes`, `No` ")
  public String getExistingMandate() {
    return existingMandate;
  }

  public void setExistingMandate(String existingMandate) {
    this.existingMandate = existingMandate;
  }

  public ProxyCreatePaymentMethod firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   *  The customer's first name. This field is used only for the direct debit payment method. **Character limit**: 30 **Values**: a string of 30 characters or fewer 
   * @return firstName
  **/
  @ApiModelProperty(example = "null", value = " The customer's first name. This field is used only for the direct debit payment method. **Character limit**: 30 **Values**: a string of 30 characters or fewer ")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public ProxyCreatePaymentMethod IBAN(String IBAN) {
    this.IBAN = IBAN;
    return this;
  }

   /**
   *  The International Bank Account Number. This field is used only for the direct debit payment method. **Character limit**: 42 **Values**: a string of 42 characters or fewer 
   * @return IBAN
  **/
  @ApiModelProperty(example = "null", value = " The International Bank Account Number. This field is used only for the direct debit payment method. **Character limit**: 42 **Values**: a string of 42 characters or fewer ")
  public String getIBAN() {
    return IBAN;
  }

  public void setIBAN(String IBAN) {
    this.IBAN = IBAN;
  }

  public ProxyCreatePaymentMethod iPAddress(String iPAddress) {
    this.iPAddress = iPAddress;
    return this;
  }

   /**
   *  The IP address of the user when the payment method was created or updated. Some gateways use this field for fraud prevention. If this field is passed to Zuora, then Zuora passes this field to supported gateways. Currently PayPal, CyberSource, Authorize.Net, and Verifi support this field. **Character limit**: 15 **Values**: a string of 15 characters or fewer 
   * @return iPAddress
  **/
  @ApiModelProperty(example = "null", value = " The IP address of the user when the payment method was created or updated. Some gateways use this field for fraud prevention. If this field is passed to Zuora, then Zuora passes this field to supported gateways. Currently PayPal, CyberSource, Authorize.Net, and Verifi support this field. **Character limit**: 15 **Values**: a string of 15 characters or fewer ")
  public String getIPAddress() {
    return iPAddress;
  }

  public void setIPAddress(String iPAddress) {
    this.iPAddress = iPAddress;
  }

  public ProxyCreatePaymentMethod lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   *  The customer's last name. This field is used only for the direct debit payment method. **Character limit**: 70 **Values**: a string of 70 characters or fewer 
   * @return lastName
  **/
  @ApiModelProperty(example = "null", value = " The customer's last name. This field is used only for the direct debit payment method. **Character limit**: 70 **Values**: a string of 70 characters or fewer ")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public ProxyCreatePaymentMethod lastTransactionDateTime(DateTime lastTransactionDateTime) {
    this.lastTransactionDateTime = lastTransactionDateTime;
    return this;
  }

   /**
   *  The date of the most recent transaction. **Character limit**: 29 **Values**: [a valid date and time value](/CB_Billing/WA_Dates_in_Zuora/A_Date_Format_and_Datetimes_in_Zuora) 
   * @return lastTransactionDateTime
  **/
  @ApiModelProperty(example = "null", value = " The date of the most recent transaction. **Character limit**: 29 **Values**: [a valid date and time value](/CB_Billing/WA_Dates_in_Zuora/A_Date_Format_and_Datetimes_in_Zuora) ")
  public DateTime getLastTransactionDateTime() {
    return lastTransactionDateTime;
  }

  public void setLastTransactionDateTime(DateTime lastTransactionDateTime) {
    this.lastTransactionDateTime = lastTransactionDateTime;
  }

  public ProxyCreatePaymentMethod lastTransactionStatus(String lastTransactionStatus) {
    this.lastTransactionStatus = lastTransactionStatus;
    return this;
  }

   /**
   *  The status of the most recent transaction. **Character limit**: 39 **Values**: automatically generated 
   * @return lastTransactionStatus
  **/
  @ApiModelProperty(example = "null", value = " The status of the most recent transaction. **Character limit**: 39 **Values**: automatically generated ")
  public String getLastTransactionStatus() {
    return lastTransactionStatus;
  }

  public void setLastTransactionStatus(String lastTransactionStatus) {
    this.lastTransactionStatus = lastTransactionStatus;
  }

  public ProxyCreatePaymentMethod mandateCreationDate(LocalDate mandateCreationDate) {
    this.mandateCreationDate = mandateCreationDate;
    return this;
  }

   /**
   *  The date when the mandate was created. A mandate is a signed authorization for UK and NL customers. This field is used only for the direct debit payment method. **Character limit**: 29 **Values**: [a valid date and time value](/CB_Billing/WA_Dates_in_Zuora/A_Date_Format_and_Datetimes_in_Zuora) 
   * @return mandateCreationDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the mandate was created. A mandate is a signed authorization for UK and NL customers. This field is used only for the direct debit payment method. **Character limit**: 29 **Values**: [a valid date and time value](/CB_Billing/WA_Dates_in_Zuora/A_Date_Format_and_Datetimes_in_Zuora) ")
  public LocalDate getMandateCreationDate() {
    return mandateCreationDate;
  }

  public void setMandateCreationDate(LocalDate mandateCreationDate) {
    this.mandateCreationDate = mandateCreationDate;
  }

  public ProxyCreatePaymentMethod mandateID(String mandateID) {
    this.mandateID = mandateID;
    return this;
  }

   /**
   *  The ID of the mandate. A mandate is a signed authorization for UK and NL customers. This field is used only for the direct debit payment method. **Character limit**: 36 **Values**: a string of 36 characters or fewer 
   * @return mandateID
  **/
  @ApiModelProperty(example = "null", value = " The ID of the mandate. A mandate is a signed authorization for UK and NL customers. This field is used only for the direct debit payment method. **Character limit**: 36 **Values**: a string of 36 characters or fewer ")
  public String getMandateID() {
    return mandateID;
  }

  public void setMandateID(String mandateID) {
    this.mandateID = mandateID;
  }

  public ProxyCreatePaymentMethod mandateReceived(String mandateReceived) {
    this.mandateReceived = mandateReceived;
    return this;
  }

   /**
   *  Indicates if  the mandate was received. A mandate is a signed authorization for UK and NL customers. This field is used only for the direct debit payment method. **Character limit**: 3 **Values**: `Yes`, `No `(case-sensitive) 
   * @return mandateReceived
  **/
  @ApiModelProperty(example = "null", value = " Indicates if  the mandate was received. A mandate is a signed authorization for UK and NL customers. This field is used only for the direct debit payment method. **Character limit**: 3 **Values**: `Yes`, `No `(case-sensitive) ")
  public String getMandateReceived() {
    return mandateReceived;
  }

  public void setMandateReceived(String mandateReceived) {
    this.mandateReceived = mandateReceived;
  }

  public ProxyCreatePaymentMethod mandateUpdateDate(LocalDate mandateUpdateDate) {
    this.mandateUpdateDate = mandateUpdateDate;
    return this;
  }

   /**
   *  The date when the mandate was last updated. A mandate is a signed authorization for UK and NL customers. This field is used only for the direct debit payment method. **Character limit**: 29 **Values**: [a valid date and time value](/CB_Billing/WA_Dates_in_Zuora/A_Date_Format_and_Datetimes_in_Zuora) 
   * @return mandateUpdateDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the mandate was last updated. A mandate is a signed authorization for UK and NL customers. This field is used only for the direct debit payment method. **Character limit**: 29 **Values**: [a valid date and time value](/CB_Billing/WA_Dates_in_Zuora/A_Date_Format_and_Datetimes_in_Zuora) ")
  public LocalDate getMandateUpdateDate() {
    return mandateUpdateDate;
  }

  public void setMandateUpdateDate(LocalDate mandateUpdateDate) {
    this.mandateUpdateDate = mandateUpdateDate;
  }

  public ProxyCreatePaymentMethod maxConsecutivePaymentFailures(Integer maxConsecutivePaymentFailures) {
    this.maxConsecutivePaymentFailures = maxConsecutivePaymentFailures;
    return this;
  }

   /**
   *  Specifies the number of allowable consecutive failures Zuora attempts with the payment method before stopping. **Values**: a valid number 
   * @return maxConsecutivePaymentFailures
  **/
  @ApiModelProperty(example = "null", value = " Specifies the number of allowable consecutive failures Zuora attempts with the payment method before stopping. **Values**: a valid number ")
  public Integer getMaxConsecutivePaymentFailures() {
    return maxConsecutivePaymentFailures;
  }

  public void setMaxConsecutivePaymentFailures(Integer maxConsecutivePaymentFailures) {
    this.maxConsecutivePaymentFailures = maxConsecutivePaymentFailures;
  }

  public ProxyCreatePaymentMethod paymentRetryWindow(Integer paymentRetryWindow) {
    this.paymentRetryWindow = paymentRetryWindow;
    return this;
  }

   /**
   *  The retry interval setting, which prevents making a payment attempt if the last failed attempt was within the last specified number of hours. This field is required if the `UseDefaultRetryRule` field value is set to `false`. **Character limit**: 4 **Values**: a whole number between 1 and 1000, exclusive 
   * @return paymentRetryWindow
  **/
  @ApiModelProperty(example = "null", value = " The retry interval setting, which prevents making a payment attempt if the last failed attempt was within the last specified number of hours. This field is required if the `UseDefaultRetryRule` field value is set to `false`. **Character limit**: 4 **Values**: a whole number between 1 and 1000, exclusive ")
  public Integer getPaymentRetryWindow() {
    return paymentRetryWindow;
  }

  public void setPaymentRetryWindow(Integer paymentRetryWindow) {
    this.paymentRetryWindow = paymentRetryWindow;
  }

  public ProxyCreatePaymentMethod paypalBaid(String paypalBaid) {
    this.paypalBaid = paypalBaid;
    return this;
  }

   /**
   *  The PayPal billing agreement ID, which is a contract between two PayPal accounts. Typically, the selling party initiates a request to create a BAID, and sends it to buying party for acceptance. The seller can keep track of the BAID and use it for future charges against the buyer. This field is required when defining a PayPal payment method. **Character limit**: 64 **Values**: a string of 64 characters or fewer 
   * @return paypalBaid
  **/
  @ApiModelProperty(example = "null", value = " The PayPal billing agreement ID, which is a contract between two PayPal accounts. Typically, the selling party initiates a request to create a BAID, and sends it to buying party for acceptance. The seller can keep track of the BAID and use it for future charges against the buyer. This field is required when defining a PayPal payment method. **Character limit**: 64 **Values**: a string of 64 characters or fewer ")
  public String getPaypalBaid() {
    return paypalBaid;
  }

  public void setPaypalBaid(String paypalBaid) {
    this.paypalBaid = paypalBaid;
  }

  public ProxyCreatePaymentMethod paypalEmail(String paypalEmail) {
    this.paypalEmail = paypalEmail;
    return this;
  }

   /**
   *  The email address associated with the account holder's PayPal account or of the PayPal account of the person paying for the service. This field is required only when you define a PayPal payment method. **Character limit**: 80 **Values**: a string of 80 characters or fewer 
   * @return paypalEmail
  **/
  @ApiModelProperty(example = "null", value = " The email address associated with the account holder's PayPal account or of the PayPal account of the person paying for the service. This field is required only when you define a PayPal payment method. **Character limit**: 80 **Values**: a string of 80 characters or fewer ")
  public String getPaypalEmail() {
    return paypalEmail;
  }

  public void setPaypalEmail(String paypalEmail) {
    this.paypalEmail = paypalEmail;
  }

  public ProxyCreatePaymentMethod paypalPreapprovalKey(String paypalPreapprovalKey) {
    this.paypalPreapprovalKey = paypalPreapprovalKey;
    return this;
  }

   /**
   *  PayPal's Adaptive Payments API key. Zuora does not create this key, nor does it call PayPal to generate it. You must use PayPal's Adaptive Payments' API to generate this key, and then pass it to Zuora. Zuora uses this key to authorize future payments to PayPal's Adaptive Payments API. This field is required when you use PayPal Adaptive Payments gateway. **Character limit**: 32 **Values**: a valid PayPal Adaptive Payment pre-approval key 
   * @return paypalPreapprovalKey
  **/
  @ApiModelProperty(example = "null", value = " PayPal's Adaptive Payments API key. Zuora does not create this key, nor does it call PayPal to generate it. You must use PayPal's Adaptive Payments' API to generate this key, and then pass it to Zuora. Zuora uses this key to authorize future payments to PayPal's Adaptive Payments API. This field is required when you use PayPal Adaptive Payments gateway. **Character limit**: 32 **Values**: a valid PayPal Adaptive Payment pre-approval key ")
  public String getPaypalPreapprovalKey() {
    return paypalPreapprovalKey;
  }

  public void setPaypalPreapprovalKey(String paypalPreapprovalKey) {
    this.paypalPreapprovalKey = paypalPreapprovalKey;
  }

  public ProxyCreatePaymentMethod paypalType(String paypalType) {
    this.paypalType = paypalType;
    return this;
  }

   /**
   *  Specifies the PayPal gateway: PayFlow Pro (Express Checkout) or Adaptive Payments. This field is required when you use PayPal Adaptive Payments or Payflow Pro (Express Checkout) gateways. **Character limit**: 32 **Values**: `ExpressCheckout`, `AdaptivePayments` 
   * @return paypalType
  **/
  @ApiModelProperty(example = "null", value = " Specifies the PayPal gateway: PayFlow Pro (Express Checkout) or Adaptive Payments. This field is required when you use PayPal Adaptive Payments or Payflow Pro (Express Checkout) gateways. **Character limit**: 32 **Values**: `ExpressCheckout`, `AdaptivePayments` ")
  public String getPaypalType() {
    return paypalType;
  }

  public void setPaypalType(String paypalType) {
    this.paypalType = paypalType;
  }

  public ProxyCreatePaymentMethod phone(String phone) {
    this.phone = phone;
    return this;
  }

   /**
   *  The phone number that the account holder registered with the bank. This field is used for credit card validation when passing to a gateway. **Character limit**: 40 **Values**: a string of 40 characters or fewer 
   * @return phone
  **/
  @ApiModelProperty(example = "null", value = " The phone number that the account holder registered with the bank. This field is used for credit card validation when passing to a gateway. **Character limit**: 40 **Values**: a string of 40 characters or fewer ")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public ProxyCreatePaymentMethod postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

   /**
   *  The zip code of the customer's address. This field is used only for the direct debit payment method. **Character limit**: 20 **Values**: a string of 20 characters or fewer 
   * @return postalCode
  **/
  @ApiModelProperty(example = "null", value = " The zip code of the customer's address. This field is used only for the direct debit payment method. **Character limit**: 20 **Values**: a string of 20 characters or fewer ")
  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public ProxyCreatePaymentMethod secondTokenId(String secondTokenId) {
    this.secondTokenId = secondTokenId;
    return this;
  }

   /**
   *  A gateway unique identifier that replaces sensitive payment method data. SecondTokenId is conditionally required only when TokenID is being used to represent a gateway customer profile. SecondTokenId is used in the CC Reference Transaction payment method. **Character limit**: 64 **Values**: a string of 64 characters or fewer 
   * @return secondTokenId
  **/
  @ApiModelProperty(example = "null", value = " A gateway unique identifier that replaces sensitive payment method data. SecondTokenId is conditionally required only when TokenID is being used to represent a gateway customer profile. SecondTokenId is used in the CC Reference Transaction payment method. **Character limit**: 64 **Values**: a string of 64 characters or fewer ")
  public String getSecondTokenId() {
    return secondTokenId;
  }

  public void setSecondTokenId(String secondTokenId) {
    this.secondTokenId = secondTokenId;
  }

  public ProxyCreatePaymentMethod state(String state) {
    this.state = state;
    return this;
  }

   /**
   *  The state of the customer's address. This field is used only for the direct debit payment method. **Character limit**: 70 **Values**: a string of 70 characters or fewer 
   * @return state
  **/
  @ApiModelProperty(example = "null", value = " The state of the customer's address. This field is used only for the direct debit payment method. **Character limit**: 70 **Values**: a string of 70 characters or fewer ")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public ProxyCreatePaymentMethod streetName(String streetName) {
    this.streetName = streetName;
    return this;
  }

   /**
   *  The street name of the customer's address. This field is used only for the direct debit payment method. **Character limit**: 100 **Values**: a string of 100 characters or fewer 
   * @return streetName
  **/
  @ApiModelProperty(example = "null", value = " The street name of the customer's address. This field is used only for the direct debit payment method. **Character limit**: 100 **Values**: a string of 100 characters or fewer ")
  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public ProxyCreatePaymentMethod streetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
    return this;
  }

   /**
   *  The street number of the customer's address. This field is used only for the direct debit payment method. **Character limit**: 30 **Values**: a string of 30 characters or fewer 
   * @return streetNumber
  **/
  @ApiModelProperty(example = "null", value = " The street number of the customer's address. This field is used only for the direct debit payment method. **Character limit**: 30 **Values**: a string of 30 characters or fewer ")
  public String getStreetNumber() {
    return streetNumber;
  }

  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }

  public ProxyCreatePaymentMethod tokenId(String tokenId) {
    this.tokenId = tokenId;
    return this;
  }

   /**
   *  A gateway unique identifier that replaces sensitive payment method data or represents a gateway's unique customer profile. When TokenId is used to represent a customer profile, then SecondTokenId is conditionally required for representing the underlying tokenized payment method. TokenId is required for the CC Reference Transaction payment method. **Character limit**: 255 **Values**: a string of 255 characters or fewer 
   * @return tokenId
  **/
  @ApiModelProperty(example = "null", value = " A gateway unique identifier that replaces sensitive payment method data or represents a gateway's unique customer profile. When TokenId is used to represent a customer profile, then SecondTokenId is conditionally required for representing the underlying tokenized payment method. TokenId is required for the CC Reference Transaction payment method. **Character limit**: 255 **Values**: a string of 255 characters or fewer ")
  public String getTokenId() {
    return tokenId;
  }

  public void setTokenId(String tokenId) {
    this.tokenId = tokenId;
  }

  public ProxyCreatePaymentMethod totalNumberOfErrorPayments(Integer totalNumberOfErrorPayments) {
    this.totalNumberOfErrorPayments = totalNumberOfErrorPayments;
    return this;
  }

   /**
   *  The number of error payments that used this payment method. **Character limit**: **Values**: automatically generated 
   * @return totalNumberOfErrorPayments
  **/
  @ApiModelProperty(example = "null", required = true, value = " The number of error payments that used this payment method. **Character limit**: **Values**: automatically generated ")
  public Integer getTotalNumberOfErrorPayments() {
    return totalNumberOfErrorPayments;
  }

  public void setTotalNumberOfErrorPayments(Integer totalNumberOfErrorPayments) {
    this.totalNumberOfErrorPayments = totalNumberOfErrorPayments;
  }

  public ProxyCreatePaymentMethod totalNumberOfProcessedPayments(Integer totalNumberOfProcessedPayments) {
    this.totalNumberOfProcessedPayments = totalNumberOfProcessedPayments;
    return this;
  }

   /**
   *  The number of successful payments that used this payment method. **Character limit**: **Values**: automatically generated 
   * @return totalNumberOfProcessedPayments
  **/
  @ApiModelProperty(example = "null", required = true, value = " The number of successful payments that used this payment method. **Character limit**: **Values**: automatically generated ")
  public Integer getTotalNumberOfProcessedPayments() {
    return totalNumberOfProcessedPayments;
  }

  public void setTotalNumberOfProcessedPayments(Integer totalNumberOfProcessedPayments) {
    this.totalNumberOfProcessedPayments = totalNumberOfProcessedPayments;
  }

  public ProxyCreatePaymentMethod type(String type) {
    this.type = type;
    return this;
  }

   /**
   *  Create Query Update Delete Filter 
   * @return type
  **/
  @ApiModelProperty(example = "null", required = true, value = " Create Query Update Delete Filter ")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ProxyCreatePaymentMethod useDefaultRetryRule(Boolean useDefaultRetryRule) {
    this.useDefaultRetryRule = useDefaultRetryRule;
    return this;
  }

   /**
   *  Determines whether to use the default retry rules configured in the [Z-Payments settings](https://knowledgecenter.zuora.com/CB_Billing/L_Payment_Methods/H_Configure_Payment_Method_Retry_Rules). Set this to `true` to use the default retry rules. Set this to `false` to set the specific rules for this payment method. If you set this value to `false`, then the fields, `PaymentRetryWindow` and `MaxConsecutivePaymentFailures`, are required. **Character limit**: 5 **Values**: `t``rue`, `false` 
   * @return useDefaultRetryRule
  **/
  @ApiModelProperty(example = "null", required = true, value = " Determines whether to use the default retry rules configured in the [Z-Payments settings](https://knowledgecenter.zuora.com/CB_Billing/L_Payment_Methods/H_Configure_Payment_Method_Retry_Rules). Set this to `true` to use the default retry rules. Set this to `false` to set the specific rules for this payment method. If you set this value to `false`, then the fields, `PaymentRetryWindow` and `MaxConsecutivePaymentFailures`, are required. **Character limit**: 5 **Values**: `t``rue`, `false` ")
  public Boolean getUseDefaultRetryRule() {
    return useDefaultRetryRule;
  }

  public void setUseDefaultRetryRule(Boolean useDefaultRetryRule) {
    this.useDefaultRetryRule = useDefaultRetryRule;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProxyCreatePaymentMethod proxyCreatePaymentMethod = (ProxyCreatePaymentMethod) o;
    return Objects.equals(this.accountId, proxyCreatePaymentMethod.accountId) &&
        Objects.equals(this.achAbaCode, proxyCreatePaymentMethod.achAbaCode) &&
        Objects.equals(this.achAccountName, proxyCreatePaymentMethod.achAccountName) &&
        Objects.equals(this.achAccountType, proxyCreatePaymentMethod.achAccountType) &&
        Objects.equals(this.achAddress1, proxyCreatePaymentMethod.achAddress1) &&
        Objects.equals(this.achAddress2, proxyCreatePaymentMethod.achAddress2) &&
        Objects.equals(this.achBankName, proxyCreatePaymentMethod.achBankName) &&
        Objects.equals(this.bankBranchCode, proxyCreatePaymentMethod.bankBranchCode) &&
        Objects.equals(this.bankCheckDigit, proxyCreatePaymentMethod.bankCheckDigit) &&
        Objects.equals(this.bankCity, proxyCreatePaymentMethod.bankCity) &&
        Objects.equals(this.bankCode, proxyCreatePaymentMethod.bankCode) &&
        Objects.equals(this.bankName, proxyCreatePaymentMethod.bankName) &&
        Objects.equals(this.bankPostalCode, proxyCreatePaymentMethod.bankPostalCode) &&
        Objects.equals(this.bankStreetName, proxyCreatePaymentMethod.bankStreetName) &&
        Objects.equals(this.bankStreetNumber, proxyCreatePaymentMethod.bankStreetNumber) &&
        Objects.equals(this.bankTransferAccountName, proxyCreatePaymentMethod.bankTransferAccountName) &&
        Objects.equals(this.bankTransferAccountType, proxyCreatePaymentMethod.bankTransferAccountType) &&
        Objects.equals(this.bankTransferType, proxyCreatePaymentMethod.bankTransferType) &&
        Objects.equals(this.businessIdentificationCode, proxyCreatePaymentMethod.businessIdentificationCode) &&
        Objects.equals(this.city, proxyCreatePaymentMethod.city) &&
        Objects.equals(this.country, proxyCreatePaymentMethod.country) &&
        Objects.equals(this.creditCardAddress1, proxyCreatePaymentMethod.creditCardAddress1) &&
        Objects.equals(this.creditCardAddress2, proxyCreatePaymentMethod.creditCardAddress2) &&
        Objects.equals(this.creditCardCity, proxyCreatePaymentMethod.creditCardCity) &&
        Objects.equals(this.creditCardCountry, proxyCreatePaymentMethod.creditCardCountry) &&
        Objects.equals(this.creditCardExpirationMonth, proxyCreatePaymentMethod.creditCardExpirationMonth) &&
        Objects.equals(this.creditCardExpirationYear, proxyCreatePaymentMethod.creditCardExpirationYear) &&
        Objects.equals(this.creditCardHolderName, proxyCreatePaymentMethod.creditCardHolderName) &&
        Objects.equals(this.creditCardPostalCode, proxyCreatePaymentMethod.creditCardPostalCode) &&
        Objects.equals(this.creditCardState, proxyCreatePaymentMethod.creditCardState) &&
        Objects.equals(this.creditCardType, proxyCreatePaymentMethod.creditCardType) &&
        Objects.equals(this.deviceSessionId, proxyCreatePaymentMethod.deviceSessionId) &&
        Objects.equals(this.email, proxyCreatePaymentMethod.email) &&
        Objects.equals(this.existingMandate, proxyCreatePaymentMethod.existingMandate) &&
        Objects.equals(this.firstName, proxyCreatePaymentMethod.firstName) &&
        Objects.equals(this.IBAN, proxyCreatePaymentMethod.IBAN) &&
        Objects.equals(this.iPAddress, proxyCreatePaymentMethod.iPAddress) &&
        Objects.equals(this.lastName, proxyCreatePaymentMethod.lastName) &&
        Objects.equals(this.lastTransactionDateTime, proxyCreatePaymentMethod.lastTransactionDateTime) &&
        Objects.equals(this.lastTransactionStatus, proxyCreatePaymentMethod.lastTransactionStatus) &&
        Objects.equals(this.mandateCreationDate, proxyCreatePaymentMethod.mandateCreationDate) &&
        Objects.equals(this.mandateID, proxyCreatePaymentMethod.mandateID) &&
        Objects.equals(this.mandateReceived, proxyCreatePaymentMethod.mandateReceived) &&
        Objects.equals(this.mandateUpdateDate, proxyCreatePaymentMethod.mandateUpdateDate) &&
        Objects.equals(this.maxConsecutivePaymentFailures, proxyCreatePaymentMethod.maxConsecutivePaymentFailures) &&
        Objects.equals(this.paymentRetryWindow, proxyCreatePaymentMethod.paymentRetryWindow) &&
        Objects.equals(this.paypalBaid, proxyCreatePaymentMethod.paypalBaid) &&
        Objects.equals(this.paypalEmail, proxyCreatePaymentMethod.paypalEmail) &&
        Objects.equals(this.paypalPreapprovalKey, proxyCreatePaymentMethod.paypalPreapprovalKey) &&
        Objects.equals(this.paypalType, proxyCreatePaymentMethod.paypalType) &&
        Objects.equals(this.phone, proxyCreatePaymentMethod.phone) &&
        Objects.equals(this.postalCode, proxyCreatePaymentMethod.postalCode) &&
        Objects.equals(this.secondTokenId, proxyCreatePaymentMethod.secondTokenId) &&
        Objects.equals(this.state, proxyCreatePaymentMethod.state) &&
        Objects.equals(this.streetName, proxyCreatePaymentMethod.streetName) &&
        Objects.equals(this.streetNumber, proxyCreatePaymentMethod.streetNumber) &&
        Objects.equals(this.tokenId, proxyCreatePaymentMethod.tokenId) &&
        Objects.equals(this.totalNumberOfErrorPayments, proxyCreatePaymentMethod.totalNumberOfErrorPayments) &&
        Objects.equals(this.totalNumberOfProcessedPayments, proxyCreatePaymentMethod.totalNumberOfProcessedPayments) &&
        Objects.equals(this.type, proxyCreatePaymentMethod.type) &&
        Objects.equals(this.useDefaultRetryRule, proxyCreatePaymentMethod.useDefaultRetryRule);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, achAbaCode, achAccountName, achAccountType, achAddress1, achAddress2, achBankName, bankBranchCode, bankCheckDigit, bankCity, bankCode, bankName, bankPostalCode, bankStreetName, bankStreetNumber, bankTransferAccountName, bankTransferAccountType, bankTransferType, businessIdentificationCode, city, country, creditCardAddress1, creditCardAddress2, creditCardCity, creditCardCountry, creditCardExpirationMonth, creditCardExpirationYear, creditCardHolderName, creditCardPostalCode, creditCardState, creditCardType, deviceSessionId, email, existingMandate, firstName, IBAN, iPAddress, lastName, lastTransactionDateTime, lastTransactionStatus, mandateCreationDate, mandateID, mandateReceived, mandateUpdateDate, maxConsecutivePaymentFailures, paymentRetryWindow, paypalBaid, paypalEmail, paypalPreapprovalKey, paypalType, phone, postalCode, secondTokenId, state, streetName, streetNumber, tokenId, totalNumberOfErrorPayments, totalNumberOfProcessedPayments, type, useDefaultRetryRule);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProxyCreatePaymentMethod {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    achAbaCode: ").append(toIndentedString(achAbaCode)).append("\n");
    sb.append("    achAccountName: ").append(toIndentedString(achAccountName)).append("\n");
    sb.append("    achAccountType: ").append(toIndentedString(achAccountType)).append("\n");
    sb.append("    achAddress1: ").append(toIndentedString(achAddress1)).append("\n");
    sb.append("    achAddress2: ").append(toIndentedString(achAddress2)).append("\n");
    sb.append("    achBankName: ").append(toIndentedString(achBankName)).append("\n");
    sb.append("    bankBranchCode: ").append(toIndentedString(bankBranchCode)).append("\n");
    sb.append("    bankCheckDigit: ").append(toIndentedString(bankCheckDigit)).append("\n");
    sb.append("    bankCity: ").append(toIndentedString(bankCity)).append("\n");
    sb.append("    bankCode: ").append(toIndentedString(bankCode)).append("\n");
    sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
    sb.append("    bankPostalCode: ").append(toIndentedString(bankPostalCode)).append("\n");
    sb.append("    bankStreetName: ").append(toIndentedString(bankStreetName)).append("\n");
    sb.append("    bankStreetNumber: ").append(toIndentedString(bankStreetNumber)).append("\n");
    sb.append("    bankTransferAccountName: ").append(toIndentedString(bankTransferAccountName)).append("\n");
    sb.append("    bankTransferAccountType: ").append(toIndentedString(bankTransferAccountType)).append("\n");
    sb.append("    bankTransferType: ").append(toIndentedString(bankTransferType)).append("\n");
    sb.append("    businessIdentificationCode: ").append(toIndentedString(businessIdentificationCode)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    creditCardAddress1: ").append(toIndentedString(creditCardAddress1)).append("\n");
    sb.append("    creditCardAddress2: ").append(toIndentedString(creditCardAddress2)).append("\n");
    sb.append("    creditCardCity: ").append(toIndentedString(creditCardCity)).append("\n");
    sb.append("    creditCardCountry: ").append(toIndentedString(creditCardCountry)).append("\n");
    sb.append("    creditCardExpirationMonth: ").append(toIndentedString(creditCardExpirationMonth)).append("\n");
    sb.append("    creditCardExpirationYear: ").append(toIndentedString(creditCardExpirationYear)).append("\n");
    sb.append("    creditCardHolderName: ").append(toIndentedString(creditCardHolderName)).append("\n");
    sb.append("    creditCardPostalCode: ").append(toIndentedString(creditCardPostalCode)).append("\n");
    sb.append("    creditCardState: ").append(toIndentedString(creditCardState)).append("\n");
    sb.append("    creditCardType: ").append(toIndentedString(creditCardType)).append("\n");
    sb.append("    deviceSessionId: ").append(toIndentedString(deviceSessionId)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    existingMandate: ").append(toIndentedString(existingMandate)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    IBAN: ").append(toIndentedString(IBAN)).append("\n");
    sb.append("    iPAddress: ").append(toIndentedString(iPAddress)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    lastTransactionDateTime: ").append(toIndentedString(lastTransactionDateTime)).append("\n");
    sb.append("    lastTransactionStatus: ").append(toIndentedString(lastTransactionStatus)).append("\n");
    sb.append("    mandateCreationDate: ").append(toIndentedString(mandateCreationDate)).append("\n");
    sb.append("    mandateID: ").append(toIndentedString(mandateID)).append("\n");
    sb.append("    mandateReceived: ").append(toIndentedString(mandateReceived)).append("\n");
    sb.append("    mandateUpdateDate: ").append(toIndentedString(mandateUpdateDate)).append("\n");
    sb.append("    maxConsecutivePaymentFailures: ").append(toIndentedString(maxConsecutivePaymentFailures)).append("\n");
    sb.append("    paymentRetryWindow: ").append(toIndentedString(paymentRetryWindow)).append("\n");
    sb.append("    paypalBaid: ").append(toIndentedString(paypalBaid)).append("\n");
    sb.append("    paypalEmail: ").append(toIndentedString(paypalEmail)).append("\n");
    sb.append("    paypalPreapprovalKey: ").append(toIndentedString(paypalPreapprovalKey)).append("\n");
    sb.append("    paypalType: ").append(toIndentedString(paypalType)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    secondTokenId: ").append(toIndentedString(secondTokenId)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    streetName: ").append(toIndentedString(streetName)).append("\n");
    sb.append("    streetNumber: ").append(toIndentedString(streetNumber)).append("\n");
    sb.append("    tokenId: ").append(toIndentedString(tokenId)).append("\n");
    sb.append("    totalNumberOfErrorPayments: ").append(toIndentedString(totalNumberOfErrorPayments)).append("\n");
    sb.append("    totalNumberOfProcessedPayments: ").append(toIndentedString(totalNumberOfProcessedPayments)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    useDefaultRetryRule: ").append(toIndentedString(useDefaultRetryRule)).append("\n");
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

