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
 * ProxyGetPaymentMethodSnapshot
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class ProxyGetPaymentMethodSnapshot   {
  @SerializedName("AccountId")
  private String accountId = null;

  @SerializedName("AchAbaCode")
  private String achAbaCode = null;

  @SerializedName("AchAccountName")
  private String achAccountName = null;

  @SerializedName("AchAccountNumberMask")
  private String achAccountNumberMask = null;

  @SerializedName("AchAccountType")
  private String achAccountType = null;

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

  @SerializedName("BankIdentificationNumber")
  private String bankIdentificationNumber = null;

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

  @SerializedName("BankTransferAccountNumberMask")
  private String bankTransferAccountNumberMask = null;

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

  @SerializedName("CreditCardMaskNumber")
  private String creditCardMaskNumber = null;

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

  @SerializedName("Id")
  private String id = null;

  @SerializedName("LastFailedSaleTransactionDate")
  private DateTime lastFailedSaleTransactionDate = null;

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

  @SerializedName("Name")
  private String name = null;

  @SerializedName("NumConsecutiveFailures")
  private Integer numConsecutiveFailures = null;

  @SerializedName("PaymentMethodId")
  private String paymentMethodId = null;

  @SerializedName("PaymentMethodStatus")
  private String paymentMethodStatus = null;

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

  public ProxyGetPaymentMethodSnapshot accountId(String accountId) {
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

  public ProxyGetPaymentMethodSnapshot achAbaCode(String achAbaCode) {
    this.achAbaCode = achAbaCode;
    return this;
  }

   /**
   * 
   * @return achAbaCode
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getAchAbaCode() {
    return achAbaCode;
  }

  public void setAchAbaCode(String achAbaCode) {
    this.achAbaCode = achAbaCode;
  }

  public ProxyGetPaymentMethodSnapshot achAccountName(String achAccountName) {
    this.achAccountName = achAccountName;
    return this;
  }

   /**
   * 
   * @return achAccountName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getAchAccountName() {
    return achAccountName;
  }

  public void setAchAccountName(String achAccountName) {
    this.achAccountName = achAccountName;
  }

  public ProxyGetPaymentMethodSnapshot achAccountNumberMask(String achAccountNumberMask) {
    this.achAccountNumberMask = achAccountNumberMask;
    return this;
  }

   /**
   * 
   * @return achAccountNumberMask
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getAchAccountNumberMask() {
    return achAccountNumberMask;
  }

  public void setAchAccountNumberMask(String achAccountNumberMask) {
    this.achAccountNumberMask = achAccountNumberMask;
  }

  public ProxyGetPaymentMethodSnapshot achAccountType(String achAccountType) {
    this.achAccountType = achAccountType;
    return this;
  }

   /**
   * 
   * @return achAccountType
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getAchAccountType() {
    return achAccountType;
  }

  public void setAchAccountType(String achAccountType) {
    this.achAccountType = achAccountType;
  }

  public ProxyGetPaymentMethodSnapshot achBankName(String achBankName) {
    this.achBankName = achBankName;
    return this;
  }

   /**
   * 
   * @return achBankName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getAchBankName() {
    return achBankName;
  }

  public void setAchBankName(String achBankName) {
    this.achBankName = achBankName;
  }

  public ProxyGetPaymentMethodSnapshot bankBranchCode(String bankBranchCode) {
    this.bankBranchCode = bankBranchCode;
    return this;
  }

   /**
   * 
   * @return bankBranchCode
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getBankBranchCode() {
    return bankBranchCode;
  }

  public void setBankBranchCode(String bankBranchCode) {
    this.bankBranchCode = bankBranchCode;
  }

  public ProxyGetPaymentMethodSnapshot bankCheckDigit(String bankCheckDigit) {
    this.bankCheckDigit = bankCheckDigit;
    return this;
  }

   /**
   * 
   * @return bankCheckDigit
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getBankCheckDigit() {
    return bankCheckDigit;
  }

  public void setBankCheckDigit(String bankCheckDigit) {
    this.bankCheckDigit = bankCheckDigit;
  }

  public ProxyGetPaymentMethodSnapshot bankCity(String bankCity) {
    this.bankCity = bankCity;
    return this;
  }

   /**
   * 
   * @return bankCity
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getBankCity() {
    return bankCity;
  }

  public void setBankCity(String bankCity) {
    this.bankCity = bankCity;
  }

  public ProxyGetPaymentMethodSnapshot bankCode(String bankCode) {
    this.bankCode = bankCode;
    return this;
  }

   /**
   * 
   * @return bankCode
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getBankCode() {
    return bankCode;
  }

  public void setBankCode(String bankCode) {
    this.bankCode = bankCode;
  }

  public ProxyGetPaymentMethodSnapshot bankIdentificationNumber(String bankIdentificationNumber) {
    this.bankIdentificationNumber = bankIdentificationNumber;
    return this;
  }

   /**
   * 
   * @return bankIdentificationNumber
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getBankIdentificationNumber() {
    return bankIdentificationNumber;
  }

  public void setBankIdentificationNumber(String bankIdentificationNumber) {
    this.bankIdentificationNumber = bankIdentificationNumber;
  }

  public ProxyGetPaymentMethodSnapshot bankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

   /**
   * 
   * @return bankName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public ProxyGetPaymentMethodSnapshot bankPostalCode(String bankPostalCode) {
    this.bankPostalCode = bankPostalCode;
    return this;
  }

   /**
   * 
   * @return bankPostalCode
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getBankPostalCode() {
    return bankPostalCode;
  }

  public void setBankPostalCode(String bankPostalCode) {
    this.bankPostalCode = bankPostalCode;
  }

  public ProxyGetPaymentMethodSnapshot bankStreetName(String bankStreetName) {
    this.bankStreetName = bankStreetName;
    return this;
  }

   /**
   * 
   * @return bankStreetName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getBankStreetName() {
    return bankStreetName;
  }

  public void setBankStreetName(String bankStreetName) {
    this.bankStreetName = bankStreetName;
  }

  public ProxyGetPaymentMethodSnapshot bankStreetNumber(String bankStreetNumber) {
    this.bankStreetNumber = bankStreetNumber;
    return this;
  }

   /**
   * 
   * @return bankStreetNumber
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getBankStreetNumber() {
    return bankStreetNumber;
  }

  public void setBankStreetNumber(String bankStreetNumber) {
    this.bankStreetNumber = bankStreetNumber;
  }

  public ProxyGetPaymentMethodSnapshot bankTransferAccountName(String bankTransferAccountName) {
    this.bankTransferAccountName = bankTransferAccountName;
    return this;
  }

   /**
   * 
   * @return bankTransferAccountName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getBankTransferAccountName() {
    return bankTransferAccountName;
  }

  public void setBankTransferAccountName(String bankTransferAccountName) {
    this.bankTransferAccountName = bankTransferAccountName;
  }

  public ProxyGetPaymentMethodSnapshot bankTransferAccountNumberMask(String bankTransferAccountNumberMask) {
    this.bankTransferAccountNumberMask = bankTransferAccountNumberMask;
    return this;
  }

   /**
   * 
   * @return bankTransferAccountNumberMask
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getBankTransferAccountNumberMask() {
    return bankTransferAccountNumberMask;
  }

  public void setBankTransferAccountNumberMask(String bankTransferAccountNumberMask) {
    this.bankTransferAccountNumberMask = bankTransferAccountNumberMask;
  }

  public ProxyGetPaymentMethodSnapshot bankTransferAccountType(String bankTransferAccountType) {
    this.bankTransferAccountType = bankTransferAccountType;
    return this;
  }

   /**
   * 
   * @return bankTransferAccountType
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getBankTransferAccountType() {
    return bankTransferAccountType;
  }

  public void setBankTransferAccountType(String bankTransferAccountType) {
    this.bankTransferAccountType = bankTransferAccountType;
  }

  public ProxyGetPaymentMethodSnapshot bankTransferType(String bankTransferType) {
    this.bankTransferType = bankTransferType;
    return this;
  }

   /**
   * 
   * @return bankTransferType
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getBankTransferType() {
    return bankTransferType;
  }

  public void setBankTransferType(String bankTransferType) {
    this.bankTransferType = bankTransferType;
  }

  public ProxyGetPaymentMethodSnapshot businessIdentificationCode(String businessIdentificationCode) {
    this.businessIdentificationCode = businessIdentificationCode;
    return this;
  }

   /**
   * 
   * @return businessIdentificationCode
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getBusinessIdentificationCode() {
    return businessIdentificationCode;
  }

  public void setBusinessIdentificationCode(String businessIdentificationCode) {
    this.businessIdentificationCode = businessIdentificationCode;
  }

  public ProxyGetPaymentMethodSnapshot city(String city) {
    this.city = city;
    return this;
  }

   /**
   * 
   * @return city
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public ProxyGetPaymentMethodSnapshot country(String country) {
    this.country = country;
    return this;
  }

   /**
   * 
   * @return country
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public ProxyGetPaymentMethodSnapshot creditCardAddress1(String creditCardAddress1) {
    this.creditCardAddress1 = creditCardAddress1;
    return this;
  }

   /**
   * 
   * @return creditCardAddress1
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getCreditCardAddress1() {
    return creditCardAddress1;
  }

  public void setCreditCardAddress1(String creditCardAddress1) {
    this.creditCardAddress1 = creditCardAddress1;
  }

  public ProxyGetPaymentMethodSnapshot creditCardAddress2(String creditCardAddress2) {
    this.creditCardAddress2 = creditCardAddress2;
    return this;
  }

   /**
   * 
   * @return creditCardAddress2
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getCreditCardAddress2() {
    return creditCardAddress2;
  }

  public void setCreditCardAddress2(String creditCardAddress2) {
    this.creditCardAddress2 = creditCardAddress2;
  }

  public ProxyGetPaymentMethodSnapshot creditCardCity(String creditCardCity) {
    this.creditCardCity = creditCardCity;
    return this;
  }

   /**
   * 
   * @return creditCardCity
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getCreditCardCity() {
    return creditCardCity;
  }

  public void setCreditCardCity(String creditCardCity) {
    this.creditCardCity = creditCardCity;
  }

  public ProxyGetPaymentMethodSnapshot creditCardCountry(String creditCardCountry) {
    this.creditCardCountry = creditCardCountry;
    return this;
  }

   /**
   * 
   * @return creditCardCountry
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getCreditCardCountry() {
    return creditCardCountry;
  }

  public void setCreditCardCountry(String creditCardCountry) {
    this.creditCardCountry = creditCardCountry;
  }

  public ProxyGetPaymentMethodSnapshot creditCardExpirationMonth(Integer creditCardExpirationMonth) {
    this.creditCardExpirationMonth = creditCardExpirationMonth;
    return this;
  }

   /**
   * 
   * @return creditCardExpirationMonth
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getCreditCardExpirationMonth() {
    return creditCardExpirationMonth;
  }

  public void setCreditCardExpirationMonth(Integer creditCardExpirationMonth) {
    this.creditCardExpirationMonth = creditCardExpirationMonth;
  }

  public ProxyGetPaymentMethodSnapshot creditCardExpirationYear(Integer creditCardExpirationYear) {
    this.creditCardExpirationYear = creditCardExpirationYear;
    return this;
  }

   /**
   * 
   * @return creditCardExpirationYear
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getCreditCardExpirationYear() {
    return creditCardExpirationYear;
  }

  public void setCreditCardExpirationYear(Integer creditCardExpirationYear) {
    this.creditCardExpirationYear = creditCardExpirationYear;
  }

  public ProxyGetPaymentMethodSnapshot creditCardHolderName(String creditCardHolderName) {
    this.creditCardHolderName = creditCardHolderName;
    return this;
  }

   /**
   * 
   * @return creditCardHolderName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getCreditCardHolderName() {
    return creditCardHolderName;
  }

  public void setCreditCardHolderName(String creditCardHolderName) {
    this.creditCardHolderName = creditCardHolderName;
  }

  public ProxyGetPaymentMethodSnapshot creditCardMaskNumber(String creditCardMaskNumber) {
    this.creditCardMaskNumber = creditCardMaskNumber;
    return this;
  }

   /**
   * 
   * @return creditCardMaskNumber
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getCreditCardMaskNumber() {
    return creditCardMaskNumber;
  }

  public void setCreditCardMaskNumber(String creditCardMaskNumber) {
    this.creditCardMaskNumber = creditCardMaskNumber;
  }

  public ProxyGetPaymentMethodSnapshot creditCardPostalCode(String creditCardPostalCode) {
    this.creditCardPostalCode = creditCardPostalCode;
    return this;
  }

   /**
   * 
   * @return creditCardPostalCode
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getCreditCardPostalCode() {
    return creditCardPostalCode;
  }

  public void setCreditCardPostalCode(String creditCardPostalCode) {
    this.creditCardPostalCode = creditCardPostalCode;
  }

  public ProxyGetPaymentMethodSnapshot creditCardState(String creditCardState) {
    this.creditCardState = creditCardState;
    return this;
  }

   /**
   * 
   * @return creditCardState
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getCreditCardState() {
    return creditCardState;
  }

  public void setCreditCardState(String creditCardState) {
    this.creditCardState = creditCardState;
  }

  public ProxyGetPaymentMethodSnapshot creditCardType(String creditCardType) {
    this.creditCardType = creditCardType;
    return this;
  }

   /**
   * 
   * @return creditCardType
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getCreditCardType() {
    return creditCardType;
  }

  public void setCreditCardType(String creditCardType) {
    this.creditCardType = creditCardType;
  }

  public ProxyGetPaymentMethodSnapshot deviceSessionId(String deviceSessionId) {
    this.deviceSessionId = deviceSessionId;
    return this;
  }

   /**
   * 
   * @return deviceSessionId
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getDeviceSessionId() {
    return deviceSessionId;
  }

  public void setDeviceSessionId(String deviceSessionId) {
    this.deviceSessionId = deviceSessionId;
  }

  public ProxyGetPaymentMethodSnapshot email(String email) {
    this.email = email;
    return this;
  }

   /**
   * 
   * @return email
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ProxyGetPaymentMethodSnapshot existingMandate(String existingMandate) {
    this.existingMandate = existingMandate;
    return this;
  }

   /**
   * 
   * @return existingMandate
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getExistingMandate() {
    return existingMandate;
  }

  public void setExistingMandate(String existingMandate) {
    this.existingMandate = existingMandate;
  }

  public ProxyGetPaymentMethodSnapshot firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * 
   * @return firstName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public ProxyGetPaymentMethodSnapshot IBAN(String IBAN) {
    this.IBAN = IBAN;
    return this;
  }

   /**
   * 
   * @return IBAN
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getIBAN() {
    return IBAN;
  }

  public void setIBAN(String IBAN) {
    this.IBAN = IBAN;
  }

  public ProxyGetPaymentMethodSnapshot iPAddress(String iPAddress) {
    this.iPAddress = iPAddress;
    return this;
  }

   /**
   * 
   * @return iPAddress
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getIPAddress() {
    return iPAddress;
  }

  public void setIPAddress(String iPAddress) {
    this.iPAddress = iPAddress;
  }

  public ProxyGetPaymentMethodSnapshot id(String id) {
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

  public ProxyGetPaymentMethodSnapshot lastFailedSaleTransactionDate(DateTime lastFailedSaleTransactionDate) {
    this.lastFailedSaleTransactionDate = lastFailedSaleTransactionDate;
    return this;
  }

   /**
   * 
   * @return lastFailedSaleTransactionDate
  **/
  @ApiModelProperty(example = "null", value = "")
  public DateTime getLastFailedSaleTransactionDate() {
    return lastFailedSaleTransactionDate;
  }

  public void setLastFailedSaleTransactionDate(DateTime lastFailedSaleTransactionDate) {
    this.lastFailedSaleTransactionDate = lastFailedSaleTransactionDate;
  }

  public ProxyGetPaymentMethodSnapshot lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * 
   * @return lastName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public ProxyGetPaymentMethodSnapshot lastTransactionDateTime(DateTime lastTransactionDateTime) {
    this.lastTransactionDateTime = lastTransactionDateTime;
    return this;
  }

   /**
   * 
   * @return lastTransactionDateTime
  **/
  @ApiModelProperty(example = "null", value = "")
  public DateTime getLastTransactionDateTime() {
    return lastTransactionDateTime;
  }

  public void setLastTransactionDateTime(DateTime lastTransactionDateTime) {
    this.lastTransactionDateTime = lastTransactionDateTime;
  }

  public ProxyGetPaymentMethodSnapshot lastTransactionStatus(String lastTransactionStatus) {
    this.lastTransactionStatus = lastTransactionStatus;
    return this;
  }

   /**
   * 
   * @return lastTransactionStatus
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getLastTransactionStatus() {
    return lastTransactionStatus;
  }

  public void setLastTransactionStatus(String lastTransactionStatus) {
    this.lastTransactionStatus = lastTransactionStatus;
  }

  public ProxyGetPaymentMethodSnapshot mandateCreationDate(LocalDate mandateCreationDate) {
    this.mandateCreationDate = mandateCreationDate;
    return this;
  }

   /**
   * 
   * @return mandateCreationDate
  **/
  @ApiModelProperty(example = "null", value = "")
  public LocalDate getMandateCreationDate() {
    return mandateCreationDate;
  }

  public void setMandateCreationDate(LocalDate mandateCreationDate) {
    this.mandateCreationDate = mandateCreationDate;
  }

  public ProxyGetPaymentMethodSnapshot mandateID(String mandateID) {
    this.mandateID = mandateID;
    return this;
  }

   /**
   * 
   * @return mandateID
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getMandateID() {
    return mandateID;
  }

  public void setMandateID(String mandateID) {
    this.mandateID = mandateID;
  }

  public ProxyGetPaymentMethodSnapshot mandateReceived(String mandateReceived) {
    this.mandateReceived = mandateReceived;
    return this;
  }

   /**
   * 
   * @return mandateReceived
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getMandateReceived() {
    return mandateReceived;
  }

  public void setMandateReceived(String mandateReceived) {
    this.mandateReceived = mandateReceived;
  }

  public ProxyGetPaymentMethodSnapshot mandateUpdateDate(LocalDate mandateUpdateDate) {
    this.mandateUpdateDate = mandateUpdateDate;
    return this;
  }

   /**
   * 
   * @return mandateUpdateDate
  **/
  @ApiModelProperty(example = "null", value = "")
  public LocalDate getMandateUpdateDate() {
    return mandateUpdateDate;
  }

  public void setMandateUpdateDate(LocalDate mandateUpdateDate) {
    this.mandateUpdateDate = mandateUpdateDate;
  }

  public ProxyGetPaymentMethodSnapshot maxConsecutivePaymentFailures(Integer maxConsecutivePaymentFailures) {
    this.maxConsecutivePaymentFailures = maxConsecutivePaymentFailures;
    return this;
  }

   /**
   * 
   * @return maxConsecutivePaymentFailures
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getMaxConsecutivePaymentFailures() {
    return maxConsecutivePaymentFailures;
  }

  public void setMaxConsecutivePaymentFailures(Integer maxConsecutivePaymentFailures) {
    this.maxConsecutivePaymentFailures = maxConsecutivePaymentFailures;
  }

  public ProxyGetPaymentMethodSnapshot name(String name) {
    this.name = name;
    return this;
  }

   /**
   * 
   * @return name
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProxyGetPaymentMethodSnapshot numConsecutiveFailures(Integer numConsecutiveFailures) {
    this.numConsecutiveFailures = numConsecutiveFailures;
    return this;
  }

   /**
   * 
   * @return numConsecutiveFailures
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getNumConsecutiveFailures() {
    return numConsecutiveFailures;
  }

  public void setNumConsecutiveFailures(Integer numConsecutiveFailures) {
    this.numConsecutiveFailures = numConsecutiveFailures;
  }

  public ProxyGetPaymentMethodSnapshot paymentMethodId(String paymentMethodId) {
    this.paymentMethodId = paymentMethodId;
    return this;
  }

   /**
   * 
   * @return paymentMethodId
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getPaymentMethodId() {
    return paymentMethodId;
  }

  public void setPaymentMethodId(String paymentMethodId) {
    this.paymentMethodId = paymentMethodId;
  }

  public ProxyGetPaymentMethodSnapshot paymentMethodStatus(String paymentMethodStatus) {
    this.paymentMethodStatus = paymentMethodStatus;
    return this;
  }

   /**
   * 
   * @return paymentMethodStatus
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getPaymentMethodStatus() {
    return paymentMethodStatus;
  }

  public void setPaymentMethodStatus(String paymentMethodStatus) {
    this.paymentMethodStatus = paymentMethodStatus;
  }

  public ProxyGetPaymentMethodSnapshot paymentRetryWindow(Integer paymentRetryWindow) {
    this.paymentRetryWindow = paymentRetryWindow;
    return this;
  }

   /**
   * 
   * @return paymentRetryWindow
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getPaymentRetryWindow() {
    return paymentRetryWindow;
  }

  public void setPaymentRetryWindow(Integer paymentRetryWindow) {
    this.paymentRetryWindow = paymentRetryWindow;
  }

  public ProxyGetPaymentMethodSnapshot paypalBaid(String paypalBaid) {
    this.paypalBaid = paypalBaid;
    return this;
  }

   /**
   * 
   * @return paypalBaid
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getPaypalBaid() {
    return paypalBaid;
  }

  public void setPaypalBaid(String paypalBaid) {
    this.paypalBaid = paypalBaid;
  }

  public ProxyGetPaymentMethodSnapshot paypalEmail(String paypalEmail) {
    this.paypalEmail = paypalEmail;
    return this;
  }

   /**
   * 
   * @return paypalEmail
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getPaypalEmail() {
    return paypalEmail;
  }

  public void setPaypalEmail(String paypalEmail) {
    this.paypalEmail = paypalEmail;
  }

  public ProxyGetPaymentMethodSnapshot paypalPreapprovalKey(String paypalPreapprovalKey) {
    this.paypalPreapprovalKey = paypalPreapprovalKey;
    return this;
  }

   /**
   * 
   * @return paypalPreapprovalKey
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getPaypalPreapprovalKey() {
    return paypalPreapprovalKey;
  }

  public void setPaypalPreapprovalKey(String paypalPreapprovalKey) {
    this.paypalPreapprovalKey = paypalPreapprovalKey;
  }

  public ProxyGetPaymentMethodSnapshot paypalType(String paypalType) {
    this.paypalType = paypalType;
    return this;
  }

   /**
   * 
   * @return paypalType
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getPaypalType() {
    return paypalType;
  }

  public void setPaypalType(String paypalType) {
    this.paypalType = paypalType;
  }

  public ProxyGetPaymentMethodSnapshot phone(String phone) {
    this.phone = phone;
    return this;
  }

   /**
   * 
   * @return phone
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public ProxyGetPaymentMethodSnapshot postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

   /**
   * 
   * @return postalCode
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public ProxyGetPaymentMethodSnapshot secondTokenId(String secondTokenId) {
    this.secondTokenId = secondTokenId;
    return this;
  }

   /**
   * 
   * @return secondTokenId
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getSecondTokenId() {
    return secondTokenId;
  }

  public void setSecondTokenId(String secondTokenId) {
    this.secondTokenId = secondTokenId;
  }

  public ProxyGetPaymentMethodSnapshot state(String state) {
    this.state = state;
    return this;
  }

   /**
   * 
   * @return state
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public ProxyGetPaymentMethodSnapshot streetName(String streetName) {
    this.streetName = streetName;
    return this;
  }

   /**
   * 
   * @return streetName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public ProxyGetPaymentMethodSnapshot streetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
    return this;
  }

   /**
   * 
   * @return streetNumber
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getStreetNumber() {
    return streetNumber;
  }

  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }

  public ProxyGetPaymentMethodSnapshot tokenId(String tokenId) {
    this.tokenId = tokenId;
    return this;
  }

   /**
   * 
   * @return tokenId
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getTokenId() {
    return tokenId;
  }

  public void setTokenId(String tokenId) {
    this.tokenId = tokenId;
  }

  public ProxyGetPaymentMethodSnapshot totalNumberOfErrorPayments(Integer totalNumberOfErrorPayments) {
    this.totalNumberOfErrorPayments = totalNumberOfErrorPayments;
    return this;
  }

   /**
   * 
   * @return totalNumberOfErrorPayments
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getTotalNumberOfErrorPayments() {
    return totalNumberOfErrorPayments;
  }

  public void setTotalNumberOfErrorPayments(Integer totalNumberOfErrorPayments) {
    this.totalNumberOfErrorPayments = totalNumberOfErrorPayments;
  }

  public ProxyGetPaymentMethodSnapshot totalNumberOfProcessedPayments(Integer totalNumberOfProcessedPayments) {
    this.totalNumberOfProcessedPayments = totalNumberOfProcessedPayments;
    return this;
  }

   /**
   * 
   * @return totalNumberOfProcessedPayments
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getTotalNumberOfProcessedPayments() {
    return totalNumberOfProcessedPayments;
  }

  public void setTotalNumberOfProcessedPayments(Integer totalNumberOfProcessedPayments) {
    this.totalNumberOfProcessedPayments = totalNumberOfProcessedPayments;
  }

  public ProxyGetPaymentMethodSnapshot type(String type) {
    this.type = type;
    return this;
  }

   /**
   * 
   * @return type
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ProxyGetPaymentMethodSnapshot useDefaultRetryRule(Boolean useDefaultRetryRule) {
    this.useDefaultRetryRule = useDefaultRetryRule;
    return this;
  }

   /**
   * 
   * @return useDefaultRetryRule
  **/
  @ApiModelProperty(example = "null", value = "")
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
    ProxyGetPaymentMethodSnapshot proxyGetPaymentMethodSnapshot = (ProxyGetPaymentMethodSnapshot) o;
    return Objects.equals(this.accountId, proxyGetPaymentMethodSnapshot.accountId) &&
        Objects.equals(this.achAbaCode, proxyGetPaymentMethodSnapshot.achAbaCode) &&
        Objects.equals(this.achAccountName, proxyGetPaymentMethodSnapshot.achAccountName) &&
        Objects.equals(this.achAccountNumberMask, proxyGetPaymentMethodSnapshot.achAccountNumberMask) &&
        Objects.equals(this.achAccountType, proxyGetPaymentMethodSnapshot.achAccountType) &&
        Objects.equals(this.achBankName, proxyGetPaymentMethodSnapshot.achBankName) &&
        Objects.equals(this.bankBranchCode, proxyGetPaymentMethodSnapshot.bankBranchCode) &&
        Objects.equals(this.bankCheckDigit, proxyGetPaymentMethodSnapshot.bankCheckDigit) &&
        Objects.equals(this.bankCity, proxyGetPaymentMethodSnapshot.bankCity) &&
        Objects.equals(this.bankCode, proxyGetPaymentMethodSnapshot.bankCode) &&
        Objects.equals(this.bankIdentificationNumber, proxyGetPaymentMethodSnapshot.bankIdentificationNumber) &&
        Objects.equals(this.bankName, proxyGetPaymentMethodSnapshot.bankName) &&
        Objects.equals(this.bankPostalCode, proxyGetPaymentMethodSnapshot.bankPostalCode) &&
        Objects.equals(this.bankStreetName, proxyGetPaymentMethodSnapshot.bankStreetName) &&
        Objects.equals(this.bankStreetNumber, proxyGetPaymentMethodSnapshot.bankStreetNumber) &&
        Objects.equals(this.bankTransferAccountName, proxyGetPaymentMethodSnapshot.bankTransferAccountName) &&
        Objects.equals(this.bankTransferAccountNumberMask, proxyGetPaymentMethodSnapshot.bankTransferAccountNumberMask) &&
        Objects.equals(this.bankTransferAccountType, proxyGetPaymentMethodSnapshot.bankTransferAccountType) &&
        Objects.equals(this.bankTransferType, proxyGetPaymentMethodSnapshot.bankTransferType) &&
        Objects.equals(this.businessIdentificationCode, proxyGetPaymentMethodSnapshot.businessIdentificationCode) &&
        Objects.equals(this.city, proxyGetPaymentMethodSnapshot.city) &&
        Objects.equals(this.country, proxyGetPaymentMethodSnapshot.country) &&
        Objects.equals(this.creditCardAddress1, proxyGetPaymentMethodSnapshot.creditCardAddress1) &&
        Objects.equals(this.creditCardAddress2, proxyGetPaymentMethodSnapshot.creditCardAddress2) &&
        Objects.equals(this.creditCardCity, proxyGetPaymentMethodSnapshot.creditCardCity) &&
        Objects.equals(this.creditCardCountry, proxyGetPaymentMethodSnapshot.creditCardCountry) &&
        Objects.equals(this.creditCardExpirationMonth, proxyGetPaymentMethodSnapshot.creditCardExpirationMonth) &&
        Objects.equals(this.creditCardExpirationYear, proxyGetPaymentMethodSnapshot.creditCardExpirationYear) &&
        Objects.equals(this.creditCardHolderName, proxyGetPaymentMethodSnapshot.creditCardHolderName) &&
        Objects.equals(this.creditCardMaskNumber, proxyGetPaymentMethodSnapshot.creditCardMaskNumber) &&
        Objects.equals(this.creditCardPostalCode, proxyGetPaymentMethodSnapshot.creditCardPostalCode) &&
        Objects.equals(this.creditCardState, proxyGetPaymentMethodSnapshot.creditCardState) &&
        Objects.equals(this.creditCardType, proxyGetPaymentMethodSnapshot.creditCardType) &&
        Objects.equals(this.deviceSessionId, proxyGetPaymentMethodSnapshot.deviceSessionId) &&
        Objects.equals(this.email, proxyGetPaymentMethodSnapshot.email) &&
        Objects.equals(this.existingMandate, proxyGetPaymentMethodSnapshot.existingMandate) &&
        Objects.equals(this.firstName, proxyGetPaymentMethodSnapshot.firstName) &&
        Objects.equals(this.IBAN, proxyGetPaymentMethodSnapshot.IBAN) &&
        Objects.equals(this.iPAddress, proxyGetPaymentMethodSnapshot.iPAddress) &&
        Objects.equals(this.id, proxyGetPaymentMethodSnapshot.id) &&
        Objects.equals(this.lastFailedSaleTransactionDate, proxyGetPaymentMethodSnapshot.lastFailedSaleTransactionDate) &&
        Objects.equals(this.lastName, proxyGetPaymentMethodSnapshot.lastName) &&
        Objects.equals(this.lastTransactionDateTime, proxyGetPaymentMethodSnapshot.lastTransactionDateTime) &&
        Objects.equals(this.lastTransactionStatus, proxyGetPaymentMethodSnapshot.lastTransactionStatus) &&
        Objects.equals(this.mandateCreationDate, proxyGetPaymentMethodSnapshot.mandateCreationDate) &&
        Objects.equals(this.mandateID, proxyGetPaymentMethodSnapshot.mandateID) &&
        Objects.equals(this.mandateReceived, proxyGetPaymentMethodSnapshot.mandateReceived) &&
        Objects.equals(this.mandateUpdateDate, proxyGetPaymentMethodSnapshot.mandateUpdateDate) &&
        Objects.equals(this.maxConsecutivePaymentFailures, proxyGetPaymentMethodSnapshot.maxConsecutivePaymentFailures) &&
        Objects.equals(this.name, proxyGetPaymentMethodSnapshot.name) &&
        Objects.equals(this.numConsecutiveFailures, proxyGetPaymentMethodSnapshot.numConsecutiveFailures) &&
        Objects.equals(this.paymentMethodId, proxyGetPaymentMethodSnapshot.paymentMethodId) &&
        Objects.equals(this.paymentMethodStatus, proxyGetPaymentMethodSnapshot.paymentMethodStatus) &&
        Objects.equals(this.paymentRetryWindow, proxyGetPaymentMethodSnapshot.paymentRetryWindow) &&
        Objects.equals(this.paypalBaid, proxyGetPaymentMethodSnapshot.paypalBaid) &&
        Objects.equals(this.paypalEmail, proxyGetPaymentMethodSnapshot.paypalEmail) &&
        Objects.equals(this.paypalPreapprovalKey, proxyGetPaymentMethodSnapshot.paypalPreapprovalKey) &&
        Objects.equals(this.paypalType, proxyGetPaymentMethodSnapshot.paypalType) &&
        Objects.equals(this.phone, proxyGetPaymentMethodSnapshot.phone) &&
        Objects.equals(this.postalCode, proxyGetPaymentMethodSnapshot.postalCode) &&
        Objects.equals(this.secondTokenId, proxyGetPaymentMethodSnapshot.secondTokenId) &&
        Objects.equals(this.state, proxyGetPaymentMethodSnapshot.state) &&
        Objects.equals(this.streetName, proxyGetPaymentMethodSnapshot.streetName) &&
        Objects.equals(this.streetNumber, proxyGetPaymentMethodSnapshot.streetNumber) &&
        Objects.equals(this.tokenId, proxyGetPaymentMethodSnapshot.tokenId) &&
        Objects.equals(this.totalNumberOfErrorPayments, proxyGetPaymentMethodSnapshot.totalNumberOfErrorPayments) &&
        Objects.equals(this.totalNumberOfProcessedPayments, proxyGetPaymentMethodSnapshot.totalNumberOfProcessedPayments) &&
        Objects.equals(this.type, proxyGetPaymentMethodSnapshot.type) &&
        Objects.equals(this.useDefaultRetryRule, proxyGetPaymentMethodSnapshot.useDefaultRetryRule);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, achAbaCode, achAccountName, achAccountNumberMask, achAccountType, achBankName, bankBranchCode, bankCheckDigit, bankCity, bankCode, bankIdentificationNumber, bankName, bankPostalCode, bankStreetName, bankStreetNumber, bankTransferAccountName, bankTransferAccountNumberMask, bankTransferAccountType, bankTransferType, businessIdentificationCode, city, country, creditCardAddress1, creditCardAddress2, creditCardCity, creditCardCountry, creditCardExpirationMonth, creditCardExpirationYear, creditCardHolderName, creditCardMaskNumber, creditCardPostalCode, creditCardState, creditCardType, deviceSessionId, email, existingMandate, firstName, IBAN, iPAddress, id, lastFailedSaleTransactionDate, lastName, lastTransactionDateTime, lastTransactionStatus, mandateCreationDate, mandateID, mandateReceived, mandateUpdateDate, maxConsecutivePaymentFailures, name, numConsecutiveFailures, paymentMethodId, paymentMethodStatus, paymentRetryWindow, paypalBaid, paypalEmail, paypalPreapprovalKey, paypalType, phone, postalCode, secondTokenId, state, streetName, streetNumber, tokenId, totalNumberOfErrorPayments, totalNumberOfProcessedPayments, type, useDefaultRetryRule);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProxyGetPaymentMethodSnapshot {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    achAbaCode: ").append(toIndentedString(achAbaCode)).append("\n");
    sb.append("    achAccountName: ").append(toIndentedString(achAccountName)).append("\n");
    sb.append("    achAccountNumberMask: ").append(toIndentedString(achAccountNumberMask)).append("\n");
    sb.append("    achAccountType: ").append(toIndentedString(achAccountType)).append("\n");
    sb.append("    achBankName: ").append(toIndentedString(achBankName)).append("\n");
    sb.append("    bankBranchCode: ").append(toIndentedString(bankBranchCode)).append("\n");
    sb.append("    bankCheckDigit: ").append(toIndentedString(bankCheckDigit)).append("\n");
    sb.append("    bankCity: ").append(toIndentedString(bankCity)).append("\n");
    sb.append("    bankCode: ").append(toIndentedString(bankCode)).append("\n");
    sb.append("    bankIdentificationNumber: ").append(toIndentedString(bankIdentificationNumber)).append("\n");
    sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
    sb.append("    bankPostalCode: ").append(toIndentedString(bankPostalCode)).append("\n");
    sb.append("    bankStreetName: ").append(toIndentedString(bankStreetName)).append("\n");
    sb.append("    bankStreetNumber: ").append(toIndentedString(bankStreetNumber)).append("\n");
    sb.append("    bankTransferAccountName: ").append(toIndentedString(bankTransferAccountName)).append("\n");
    sb.append("    bankTransferAccountNumberMask: ").append(toIndentedString(bankTransferAccountNumberMask)).append("\n");
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
    sb.append("    creditCardMaskNumber: ").append(toIndentedString(creditCardMaskNumber)).append("\n");
    sb.append("    creditCardPostalCode: ").append(toIndentedString(creditCardPostalCode)).append("\n");
    sb.append("    creditCardState: ").append(toIndentedString(creditCardState)).append("\n");
    sb.append("    creditCardType: ").append(toIndentedString(creditCardType)).append("\n");
    sb.append("    deviceSessionId: ").append(toIndentedString(deviceSessionId)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    existingMandate: ").append(toIndentedString(existingMandate)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    IBAN: ").append(toIndentedString(IBAN)).append("\n");
    sb.append("    iPAddress: ").append(toIndentedString(iPAddress)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lastFailedSaleTransactionDate: ").append(toIndentedString(lastFailedSaleTransactionDate)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    lastTransactionDateTime: ").append(toIndentedString(lastTransactionDateTime)).append("\n");
    sb.append("    lastTransactionStatus: ").append(toIndentedString(lastTransactionStatus)).append("\n");
    sb.append("    mandateCreationDate: ").append(toIndentedString(mandateCreationDate)).append("\n");
    sb.append("    mandateID: ").append(toIndentedString(mandateID)).append("\n");
    sb.append("    mandateReceived: ").append(toIndentedString(mandateReceived)).append("\n");
    sb.append("    mandateUpdateDate: ").append(toIndentedString(mandateUpdateDate)).append("\n");
    sb.append("    maxConsecutivePaymentFailures: ").append(toIndentedString(maxConsecutivePaymentFailures)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    numConsecutiveFailures: ").append(toIndentedString(numConsecutiveFailures)).append("\n");
    sb.append("    paymentMethodId: ").append(toIndentedString(paymentMethodId)).append("\n");
    sb.append("    paymentMethodStatus: ").append(toIndentedString(paymentMethodStatus)).append("\n");
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

