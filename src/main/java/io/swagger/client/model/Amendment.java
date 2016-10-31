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
import io.swagger.client.model.RatePlanData;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;


/**
 * Amendment
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class Amendment   {
  @SerializedName("AutoRenew")
  private Boolean autoRenew = null;

  @SerializedName("Code")
  private String code = null;

  @SerializedName("ContractEffectiveDate")
  private LocalDate contractEffectiveDate = null;

  @SerializedName("CreatedById")
  private String createdById = null;

  @SerializedName("CreatedDate")
  private DateTime createdDate = null;

  @SerializedName("CurrentTerm")
  private Long currentTerm = null;

  @SerializedName("CurrentTermPeriodType")
  private String currentTermPeriodType = null;

  @SerializedName("CustomerAcceptanceDate")
  private LocalDate customerAcceptanceDate = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("DestinationAccountId")
  private String destinationAccountId = null;

  @SerializedName("DestinationInvoiceOwnerId")
  private String destinationInvoiceOwnerId = null;

  @SerializedName("EffectiveDate")
  private LocalDate effectiveDate = null;

  @SerializedName("Id")
  private String id = null;

  @SerializedName("Name")
  private String name = null;

  @SerializedName("RatePlanData")
  private RatePlanData ratePlanData = null;

  @SerializedName("RenewalSetting")
  private String renewalSetting = null;

  @SerializedName("RenewalTerm")
  private Long renewalTerm = null;

  @SerializedName("RenewalTermPeriodType")
  private String renewalTermPeriodType = null;

  @SerializedName("ServiceActivationDate")
  private LocalDate serviceActivationDate = null;

  @SerializedName("SpecificUpdateDate")
  private LocalDate specificUpdateDate = null;

  @SerializedName("Status")
  private String status = null;

  @SerializedName("SubscriptionId")
  private String subscriptionId = null;

  @SerializedName("TermStartDate")
  private LocalDate termStartDate = null;

  @SerializedName("TermType")
  private String termType = null;

  @SerializedName("Type")
  private String type = null;

  @SerializedName("UpdatedById")
  private String updatedById = null;

  @SerializedName("UpdatedDate")
  private DateTime updatedDate = null;

  @SerializedName("fieldsToNull")
  private String fieldsToNull = null;

  public Amendment autoRenew(Boolean autoRenew) {
    this.autoRenew = autoRenew;
    return this;
  }

   /**
   *  Determines whether the subscription is automatically renewed, or whether it expires at the end of the term and needs to be manually renewed. **Required:** For amendment of type TermsAndConditions when changing the automatic renewal status of a subscription. **Values**: true, false 
   * @return autoRenew
  **/
  @ApiModelProperty(example = "null", value = " Determines whether the subscription is automatically renewed, or whether it expires at the end of the term and needs to be manually renewed. **Required:** For amendment of type TermsAndConditions when changing the automatic renewal status of a subscription. **Values**: true, false ")
  public Boolean getAutoRenew() {
    return autoRenew;
  }

  public void setAutoRenew(Boolean autoRenew) {
    this.autoRenew = autoRenew;
  }

  public Amendment code(String code) {
    this.code = code;
    return this;
  }

   /**
   *  A unique alphanumeric string that identifies the amendment. **Character limit**: 50 **Values**: one of the following:  - `null` generates a value automatically - A string 
   * @return code
  **/
  @ApiModelProperty(example = "null", value = " A unique alphanumeric string that identifies the amendment. **Character limit**: 50 **Values**: one of the following:  - `null` generates a value automatically - A string ")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Amendment contractEffectiveDate(LocalDate contractEffectiveDate) {
    this.contractEffectiveDate = contractEffectiveDate;
    return this;
  }

   /**
   *  The date when the amendment's changes become effective for billing purposes. **Version notes**: -- 
   * @return contractEffectiveDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the amendment's changes become effective for billing purposes. **Version notes**: -- ")
  public LocalDate getContractEffectiveDate() {
    return contractEffectiveDate;
  }

  public void setContractEffectiveDate(LocalDate contractEffectiveDate) {
    this.contractEffectiveDate = contractEffectiveDate;
  }

  public Amendment createdById(String createdById) {
    this.createdById = createdById;
    return this;
  }

   /**
   *  The user ID of the person who created the amendment. **Character limit**: 32 **Values**: automatically generated 
   * @return createdById
  **/
  @ApiModelProperty(example = "null", value = " The user ID of the person who created the amendment. **Character limit**: 32 **Values**: automatically generated ")
  public String getCreatedById() {
    return createdById;
  }

  public void setCreatedById(String createdById) {
    this.createdById = createdById;
  }

  public Amendment createdDate(DateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }

   /**
   *  The date when the amendment was created. **Values**: automatically generated 
   * @return createdDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the amendment was created. **Values**: automatically generated ")
  public DateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(DateTime createdDate) {
    this.createdDate = createdDate;
  }

  public Amendment currentTerm(Long currentTerm) {
    this.currentTerm = currentTerm;
    return this;
  }

   /**
   *  The length of the period for the current subscription term. This field can be updated when Status is `Draft`. **Required**: Only if the value of the Type field is set to `TermsAndConditions` and TermType is set to `TERMED`. This field is not required if TermType is set to `EVERGREEN`. **Character limit**: **Values**: a valid number **Note**: The InitialTerm field is deprecated from WSDL 73.0, use the CurrentTerm field instead. 
   * @return currentTerm
  **/
  @ApiModelProperty(example = "null", value = " The length of the period for the current subscription term. This field can be updated when Status is `Draft`. **Required**: Only if the value of the Type field is set to `TermsAndConditions` and TermType is set to `TERMED`. This field is not required if TermType is set to `EVERGREEN`. **Character limit**: **Values**: a valid number **Note**: The InitialTerm field is deprecated from WSDL 73.0, use the CurrentTerm field instead. ")
  public Long getCurrentTerm() {
    return currentTerm;
  }

  public void setCurrentTerm(Long currentTerm) {
    this.currentTerm = currentTerm;
  }

  public Amendment currentTermPeriodType(String currentTermPeriodType) {
    this.currentTermPeriodType = currentTermPeriodType;
    return this;
  }

   /**
   *  The period type for the current subscription term. **Values**:  - `Month` (default) - `Year` - `Day` - `Week` **Note**:  - This field can be updated when Status is `Draft`. - This field is used with the CurrentTerm field to specify the current subscription term. 
   * @return currentTermPeriodType
  **/
  @ApiModelProperty(example = "null", value = " The period type for the current subscription term. **Values**:  - `Month` (default) - `Year` - `Day` - `Week` **Note**:  - This field can be updated when Status is `Draft`. - This field is used with the CurrentTerm field to specify the current subscription term. ")
  public String getCurrentTermPeriodType() {
    return currentTermPeriodType;
  }

  public void setCurrentTermPeriodType(String currentTermPeriodType) {
    this.currentTermPeriodType = currentTermPeriodType;
  }

  public Amendment customerAcceptanceDate(LocalDate customerAcceptanceDate) {
    this.customerAcceptanceDate = customerAcceptanceDate;
    return this;
  }

   /**
   *  The date when the customer accepts the amendment's changes to the subscription. Use this field if [Zuora is configured to require customer acceptance in Z-Billing](https://knowledgecenter.zuora.com/CB_Billing/W_Billing_and_Payments_Settings/Define_Default_Subscription_Settings). **Required**: Only if the value of the Status field is set to PendingAcceptance. **Version notes**: -- 
   * @return customerAcceptanceDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the customer accepts the amendment's changes to the subscription. Use this field if [Zuora is configured to require customer acceptance in Z-Billing](https://knowledgecenter.zuora.com/CB_Billing/W_Billing_and_Payments_Settings/Define_Default_Subscription_Settings). **Required**: Only if the value of the Status field is set to PendingAcceptance. **Version notes**: -- ")
  public LocalDate getCustomerAcceptanceDate() {
    return customerAcceptanceDate;
  }

  public void setCustomerAcceptanceDate(LocalDate customerAcceptanceDate) {
    this.customerAcceptanceDate = customerAcceptanceDate;
  }

  public Amendment description(String description) {
    this.description = description;
    return this;
  }

   /**
   *  A description of the amendment. **Character limit**: 500 **Values**: maximum 500 characters 
   * @return description
  **/
  @ApiModelProperty(example = "null", value = " A description of the amendment. **Character limit**: 500 **Values**: maximum 500 characters ")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Amendment destinationAccountId(String destinationAccountId) {
    this.destinationAccountId = destinationAccountId;
    return this;
  }

   /**
   *  The ID of the account that the subscription is being transferred to. **Character limit**: 32 **Values**: [a valid account ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account#Id) 
   * @return destinationAccountId
  **/
  @ApiModelProperty(example = "null", value = " The ID of the account that the subscription is being transferred to. **Character limit**: 32 **Values**: [a valid account ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account#Id) ")
  public String getDestinationAccountId() {
    return destinationAccountId;
  }

  public void setDestinationAccountId(String destinationAccountId) {
    this.destinationAccountId = destinationAccountId;
  }

  public Amendment destinationInvoiceOwnerId(String destinationInvoiceOwnerId) {
    this.destinationInvoiceOwnerId = destinationInvoiceOwnerId;
    return this;
  }

   /**
   *  The ID of the invoice that the subscription is being transferred to. **Character limit**: 32 **Values**: [a valid invoice ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Invoice#Id) 
   * @return destinationInvoiceOwnerId
  **/
  @ApiModelProperty(example = "null", value = " The ID of the invoice that the subscription is being transferred to. **Character limit**: 32 **Values**: [a valid invoice ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Invoice#Id) ")
  public String getDestinationInvoiceOwnerId() {
    return destinationInvoiceOwnerId;
  }

  public void setDestinationInvoiceOwnerId(String destinationInvoiceOwnerId) {
    this.destinationInvoiceOwnerId = destinationInvoiceOwnerId;
  }

  public Amendment effectiveDate(LocalDate effectiveDate) {
    this.effectiveDate = effectiveDate;
    return this;
  }

   /**
   *  The date when the amendment's changes take effective. This field validates that the amendment's changes are within valid ranges of products and product rate plans. **Required**: For the cancellation amendments. Optional for other types of amendments. **Version notes**: -- 
   * @return effectiveDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the amendment's changes take effective. This field validates that the amendment's changes are within valid ranges of products and product rate plans. **Required**: For the cancellation amendments. Optional for other types of amendments. **Version notes**: -- ")
  public LocalDate getEffectiveDate() {
    return effectiveDate;
  }

  public void setEffectiveDate(LocalDate effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  public Amendment id(String id) {
    this.id = id;
    return this;
  }

   /**
   *  The ID of this object. Upon creation of this object, this field becomes AmendmentId. **Character limit**: 32 **Values**: automatically generated 
   * @return id
  **/
  @ApiModelProperty(example = "null", value = " The ID of this object. Upon creation of this object, this field becomes AmendmentId. **Character limit**: 32 **Values**: automatically generated ")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Amendment name(String name) {
    this.name = name;
    return this;
  }

   /**
   *  The name of the amendment. **Character limit**: 100 **Values**: a string of 100 characters or fewer 
   * @return name
  **/
  @ApiModelProperty(example = "null", value = " The name of the amendment. **Character limit**: 100 **Values**: a string of 100 characters or fewer ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Amendment ratePlanData(RatePlanData ratePlanData) {
    this.ratePlanData = ratePlanData;
    return this;
  }

   /**
   *  A container for one [RatePlanData](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/F_SOAP_API_Complex_Types/RatePlanData) 
   * @return ratePlanData
  **/
  @ApiModelProperty(example = "null", value = " A container for one [RatePlanData](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/F_SOAP_API_Complex_Types/RatePlanData) ")
  public RatePlanData getRatePlanData() {
    return ratePlanData;
  }

  public void setRatePlanData(RatePlanData ratePlanData) {
    this.ratePlanData = ratePlanData;
  }

  public Amendment renewalSetting(String renewalSetting) {
    this.renewalSetting = renewalSetting;
    return this;
  }

   /**
   *  Specifies whether a termed subscription will remain termed or change to evergreen when it is renewed. **Required**: If TermType is Termed **Values**: RENEW_WITH_SPECIFIC_TERM (default), RENEW_TO_EVERGREEN 
   * @return renewalSetting
  **/
  @ApiModelProperty(example = "null", value = " Specifies whether a termed subscription will remain termed or change to evergreen when it is renewed. **Required**: If TermType is Termed **Values**: RENEW_WITH_SPECIFIC_TERM (default), RENEW_TO_EVERGREEN ")
  public String getRenewalSetting() {
    return renewalSetting;
  }

  public void setRenewalSetting(String renewalSetting) {
    this.renewalSetting = renewalSetting;
  }

  public Amendment renewalTerm(Long renewalTerm) {
    this.renewalTerm = renewalTerm;
    return this;
  }

   /**
   *  The term of renewal for the amended subscription. This field can be updated when Status is `Draft`. **Required**: Only if the value of the Type field is set to `TermsAndConditions`. **Character limit**: **Values:** a valid number 
   * @return renewalTerm
  **/
  @ApiModelProperty(example = "null", value = " The term of renewal for the amended subscription. This field can be updated when Status is `Draft`. **Required**: Only if the value of the Type field is set to `TermsAndConditions`. **Character limit**: **Values:** a valid number ")
  public Long getRenewalTerm() {
    return renewalTerm;
  }

  public void setRenewalTerm(Long renewalTerm) {
    this.renewalTerm = renewalTerm;
  }

  public Amendment renewalTermPeriodType(String renewalTermPeriodType) {
    this.renewalTermPeriodType = renewalTermPeriodType;
    return this;
  }

   /**
   *  The period type for the subscription renewal term. This field can be updated when Status is `Draft`. **Required**: Only if the value of the Type field is set to `TermsAndConditions`. This field is used with the RenewalTerm field to specify the subscription renewal term. **Values**:  - `Month` (default) - `Year` - `Day` - `Week` 
   * @return renewalTermPeriodType
  **/
  @ApiModelProperty(example = "null", value = " The period type for the subscription renewal term. This field can be updated when Status is `Draft`. **Required**: Only if the value of the Type field is set to `TermsAndConditions`. This field is used with the RenewalTerm field to specify the subscription renewal term. **Values**:  - `Month` (default) - `Year` - `Day` - `Week` ")
  public String getRenewalTermPeriodType() {
    return renewalTermPeriodType;
  }

  public void setRenewalTermPeriodType(String renewalTermPeriodType) {
    this.renewalTermPeriodType = renewalTermPeriodType;
  }

  public Amendment serviceActivationDate(LocalDate serviceActivationDate) {
    this.serviceActivationDate = serviceActivationDate;
    return this;
  }

   /**
   *  The date when service is activated. Use this field if [Zuora is configured to require service activation in Z-Billing](https://knowledgecenter.zuora.com/CB_Billing/W_Billing_and_Payments_Settings/Define_Default_Subscription_Settings). **Required**: Only if the value of the Status field is set to PendingActivation. **Version notes**: -- 
   * @return serviceActivationDate
  **/
  @ApiModelProperty(example = "null", value = " The date when service is activated. Use this field if [Zuora is configured to require service activation in Z-Billing](https://knowledgecenter.zuora.com/CB_Billing/W_Billing_and_Payments_Settings/Define_Default_Subscription_Settings). **Required**: Only if the value of the Status field is set to PendingActivation. **Version notes**: -- ")
  public LocalDate getServiceActivationDate() {
    return serviceActivationDate;
  }

  public void setServiceActivationDate(LocalDate serviceActivationDate) {
    this.serviceActivationDate = serviceActivationDate;
  }

  public Amendment specificUpdateDate(LocalDate specificUpdateDate) {
    this.specificUpdateDate = specificUpdateDate;
    return this;
  }

   /**
   *  The date when the UpdateProduct amendment takes effect. This field is only applicable if there is already a future-dated UpdateProduct amendment on the subscription. See [Create an UpdateProduct Amendment Before a Future-dated Update](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Amendment/Update_a_Product_(Amendment)#Create_an_UpdateProduct_Amendment_Before_a_Future-dated_Update_(API_version_71.0.2B)) for more information. **Required**: Only for the UpdateProduct amendments if there is already a future-dated UpdateProduct amendment on the subscription. **Version notes**: WSDL 71.0+ 
   * @return specificUpdateDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the UpdateProduct amendment takes effect. This field is only applicable if there is already a future-dated UpdateProduct amendment on the subscription. See [Create an UpdateProduct Amendment Before a Future-dated Update](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Amendment/Update_a_Product_(Amendment)#Create_an_UpdateProduct_Amendment_Before_a_Future-dated_Update_(API_version_71.0.2B)) for more information. **Required**: Only for the UpdateProduct amendments if there is already a future-dated UpdateProduct amendment on the subscription. **Version notes**: WSDL 71.0+ ")
  public LocalDate getSpecificUpdateDate() {
    return specificUpdateDate;
  }

  public void setSpecificUpdateDate(LocalDate specificUpdateDate) {
    this.specificUpdateDate = specificUpdateDate;
  }

  public Amendment status(String status) {
    this.status = status;
    return this;
  }

   /**
   *  The status of the amendment. Type: string (enum) **Character limit**: 17 **Values**: one of the following:  - Draft (default, if left null) - Pending Activation - Pending Acceptance - Completed 
   * @return status
  **/
  @ApiModelProperty(example = "null", value = " The status of the amendment. Type: string (enum) **Character limit**: 17 **Values**: one of the following:  - Draft (default, if left null) - Pending Activation - Pending Acceptance - Completed ")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Amendment subscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
    return this;
  }

   /**
   *  The ID of the subscription that the amendment changes. **Character limit**: 32 **Values**: [a valid subscription ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Subscription#Id) 
   * @return subscriptionId
  **/
  @ApiModelProperty(example = "null", value = " The ID of the subscription that the amendment changes. **Character limit**: 32 **Values**: [a valid subscription ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Subscription#Id) ")
  public String getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public Amendment termStartDate(LocalDate termStartDate) {
    this.termStartDate = termStartDate;
    return this;
  }

   /**
   *  The date when the new terms and conditions take effect. **Required**: Only if the value of the Type field is set to TermsAndConditions. **Version notes**: -- 
   * @return termStartDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the new terms and conditions take effect. **Required**: Only if the value of the Type field is set to TermsAndConditions. **Version notes**: -- ")
  public LocalDate getTermStartDate() {
    return termStartDate;
  }

  public void setTermStartDate(LocalDate termStartDate) {
    this.termStartDate = termStartDate;
  }

  public Amendment termType(String termType) {
    this.termType = termType;
    return this;
  }

   /**
   *  Indicates if the subscription isTERMED or EVERGREEN.  - A TERMED subscription has an expiration date, and must be manually renewed. - An EVERGREEN subscription doesn't have an expiration date, and must be manually ended.  **Required**: Only when as part of an amendment of type TermsAndConditions &#65279;to change the term type of a subscription. Type: string **Character limit**: 9 **Values**: TERMED, EVERGREEN 
   * @return termType
  **/
  @ApiModelProperty(example = "null", value = " Indicates if the subscription isTERMED or EVERGREEN.  - A TERMED subscription has an expiration date, and must be manually renewed. - An EVERGREEN subscription doesn't have an expiration date, and must be manually ended.  **Required**: Only when as part of an amendment of type TermsAndConditions &#65279;to change the term type of a subscription. Type: string **Character limit**: 9 **Values**: TERMED, EVERGREEN ")
  public String getTermType() {
    return termType;
  }

  public void setTermType(String termType) {
    this.termType = termType;
  }

  public Amendment type(String type) {
    this.type = type;
    return this;
  }

   /**
   *  The type of amendment. **Character limit**: 18 **Values**: one of the following:  - Cancellation - NewProduct - OwnerTransfer - RemoveProduct - Renewal - UpdateProduct - TermsAndConditions - SuspendSubscription (This value is in **Limited Availability**.) - ResumeSubscription (This value is in **Limited Availability**.) 
   * @return type
  **/
  @ApiModelProperty(example = "null", value = " The type of amendment. **Character limit**: 18 **Values**: one of the following:  - Cancellation - NewProduct - OwnerTransfer - RemoveProduct - Renewal - UpdateProduct - TermsAndConditions - SuspendSubscription (This value is in **Limited Availability**.) - ResumeSubscription (This value is in **Limited Availability**.) ")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Amendment updatedById(String updatedById) {
    this.updatedById = updatedById;
    return this;
  }

   /**
   *  The ID of the user who last updated the amendment. **Character limit**: 32 **Values**: automatically generated 
   * @return updatedById
  **/
  @ApiModelProperty(example = "null", value = " The ID of the user who last updated the amendment. **Character limit**: 32 **Values**: automatically generated ")
  public String getUpdatedById() {
    return updatedById;
  }

  public void setUpdatedById(String updatedById) {
    this.updatedById = updatedById;
  }

  public Amendment updatedDate(DateTime updatedDate) {
    this.updatedDate = updatedDate;
    return this;
  }

   /**
   *  The date when the amendment was last updated. **Values**: automatically generated 
   * @return updatedDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the amendment was last updated. **Values**: automatically generated ")
  public DateTime getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(DateTime updatedDate) {
    this.updatedDate = updatedDate;
  }

  public Amendment fieldsToNull(String fieldsToNull) {
    this.fieldsToNull = fieldsToNull;
    return this;
  }

   /**
   * 
   * @return fieldsToNull
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getFieldsToNull() {
    return fieldsToNull;
  }

  public void setFieldsToNull(String fieldsToNull) {
    this.fieldsToNull = fieldsToNull;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Amendment amendment = (Amendment) o;
    return Objects.equals(this.autoRenew, amendment.autoRenew) &&
        Objects.equals(this.code, amendment.code) &&
        Objects.equals(this.contractEffectiveDate, amendment.contractEffectiveDate) &&
        Objects.equals(this.createdById, amendment.createdById) &&
        Objects.equals(this.createdDate, amendment.createdDate) &&
        Objects.equals(this.currentTerm, amendment.currentTerm) &&
        Objects.equals(this.currentTermPeriodType, amendment.currentTermPeriodType) &&
        Objects.equals(this.customerAcceptanceDate, amendment.customerAcceptanceDate) &&
        Objects.equals(this.description, amendment.description) &&
        Objects.equals(this.destinationAccountId, amendment.destinationAccountId) &&
        Objects.equals(this.destinationInvoiceOwnerId, amendment.destinationInvoiceOwnerId) &&
        Objects.equals(this.effectiveDate, amendment.effectiveDate) &&
        Objects.equals(this.id, amendment.id) &&
        Objects.equals(this.name, amendment.name) &&
        Objects.equals(this.ratePlanData, amendment.ratePlanData) &&
        Objects.equals(this.renewalSetting, amendment.renewalSetting) &&
        Objects.equals(this.renewalTerm, amendment.renewalTerm) &&
        Objects.equals(this.renewalTermPeriodType, amendment.renewalTermPeriodType) &&
        Objects.equals(this.serviceActivationDate, amendment.serviceActivationDate) &&
        Objects.equals(this.specificUpdateDate, amendment.specificUpdateDate) &&
        Objects.equals(this.status, amendment.status) &&
        Objects.equals(this.subscriptionId, amendment.subscriptionId) &&
        Objects.equals(this.termStartDate, amendment.termStartDate) &&
        Objects.equals(this.termType, amendment.termType) &&
        Objects.equals(this.type, amendment.type) &&
        Objects.equals(this.updatedById, amendment.updatedById) &&
        Objects.equals(this.updatedDate, amendment.updatedDate) &&
        Objects.equals(this.fieldsToNull, amendment.fieldsToNull);
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoRenew, code, contractEffectiveDate, createdById, createdDate, currentTerm, currentTermPeriodType, customerAcceptanceDate, description, destinationAccountId, destinationInvoiceOwnerId, effectiveDate, id, name, ratePlanData, renewalSetting, renewalTerm, renewalTermPeriodType, serviceActivationDate, specificUpdateDate, status, subscriptionId, termStartDate, termType, type, updatedById, updatedDate, fieldsToNull);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Amendment {\n");
    
    sb.append("    autoRenew: ").append(toIndentedString(autoRenew)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    contractEffectiveDate: ").append(toIndentedString(contractEffectiveDate)).append("\n");
    sb.append("    createdById: ").append(toIndentedString(createdById)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    currentTerm: ").append(toIndentedString(currentTerm)).append("\n");
    sb.append("    currentTermPeriodType: ").append(toIndentedString(currentTermPeriodType)).append("\n");
    sb.append("    customerAcceptanceDate: ").append(toIndentedString(customerAcceptanceDate)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    destinationAccountId: ").append(toIndentedString(destinationAccountId)).append("\n");
    sb.append("    destinationInvoiceOwnerId: ").append(toIndentedString(destinationInvoiceOwnerId)).append("\n");
    sb.append("    effectiveDate: ").append(toIndentedString(effectiveDate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ratePlanData: ").append(toIndentedString(ratePlanData)).append("\n");
    sb.append("    renewalSetting: ").append(toIndentedString(renewalSetting)).append("\n");
    sb.append("    renewalTerm: ").append(toIndentedString(renewalTerm)).append("\n");
    sb.append("    renewalTermPeriodType: ").append(toIndentedString(renewalTermPeriodType)).append("\n");
    sb.append("    serviceActivationDate: ").append(toIndentedString(serviceActivationDate)).append("\n");
    sb.append("    specificUpdateDate: ").append(toIndentedString(specificUpdateDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("    termStartDate: ").append(toIndentedString(termStartDate)).append("\n");
    sb.append("    termType: ").append(toIndentedString(termType)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    updatedById: ").append(toIndentedString(updatedById)).append("\n");
    sb.append("    updatedDate: ").append(toIndentedString(updatedDate)).append("\n");
    sb.append("    fieldsToNull: ").append(toIndentedString(fieldsToNull)).append("\n");
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

