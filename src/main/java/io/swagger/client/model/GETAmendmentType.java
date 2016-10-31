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
 * GETAmendmentType
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class GETAmendmentType   {
  @SerializedName("autoRenew")
  private Boolean autoRenew = null;

  @SerializedName("baseRatePlanId")
  private String baseRatePlanId = null;

  @SerializedName("baseSubscriptionId")
  private String baseSubscriptionId = null;

  @SerializedName("code")
  private String code = null;

  @SerializedName("contractEffectiveDate")
  private LocalDate contractEffectiveDate = null;

  @SerializedName("currentTerm")
  private Long currentTerm = null;

  @SerializedName("currentTermPeriodType")
  private String currentTermPeriodType = null;

  @SerializedName("customerAcceptanceDate")
  private LocalDate customerAcceptanceDate = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("destinationAccountId")
  private String destinationAccountId = null;

  @SerializedName("destinationInvoiceOwnerId")
  private String destinationInvoiceOwnerId = null;

  @SerializedName("effectiveDate")
  private LocalDate effectiveDate = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("newRatePlanId")
  private String newRatePlanId = null;

  @SerializedName("newSubscriptionId")
  private String newSubscriptionId = null;

  @SerializedName("renewalSetting")
  private String renewalSetting = null;

  @SerializedName("renewalTerm")
  private Long renewalTerm = null;

  @SerializedName("renewalTermPeriodType")
  private String renewalTermPeriodType = null;

  @SerializedName("resumeDate")
  private LocalDate resumeDate = null;

  @SerializedName("serviceActivationDate")
  private LocalDate serviceActivationDate = null;

  @SerializedName("specificUpdateDate")
  private LocalDate specificUpdateDate = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("success")
  private Boolean success = null;

  @SerializedName("suspendDate")
  private LocalDate suspendDate = null;

  @SerializedName("termStartDate")
  private LocalDate termStartDate = null;

  @SerializedName("termType")
  private String termType = null;

  @SerializedName("type")
  private String type = null;

  public GETAmendmentType autoRenew(Boolean autoRenew) {
    this.autoRenew = autoRenew;
    return this;
  }

   /**
   * Determines whether the subscription is automatically renewed, or whether it expires at the end of the term and needs to be manually renewed.  
   * @return autoRenew
  **/
  @ApiModelProperty(example = "null", value = "Determines whether the subscription is automatically renewed, or whether it expires at the end of the term and needs to be manually renewed.  ")
  public Boolean getAutoRenew() {
    return autoRenew;
  }

  public void setAutoRenew(Boolean autoRenew) {
    this.autoRenew = autoRenew;
  }

  public GETAmendmentType baseRatePlanId(String baseRatePlanId) {
    this.baseRatePlanId = baseRatePlanId;
    return this;
  }

   /**
   * The rate plan ID on which changes are made. Only the Update or Remove amendment returns a base rate plan ID. 
   * @return baseRatePlanId
  **/
  @ApiModelProperty(example = "null", value = "The rate plan ID on which changes are made. Only the Update or Remove amendment returns a base rate plan ID. ")
  public String getBaseRatePlanId() {
    return baseRatePlanId;
  }

  public void setBaseRatePlanId(String baseRatePlanId) {
    this.baseRatePlanId = baseRatePlanId;
  }

  public GETAmendmentType baseSubscriptionId(String baseSubscriptionId) {
    this.baseSubscriptionId = baseSubscriptionId;
    return this;
  }

   /**
   * The ID of the subscription based on which the amendment is created. 
   * @return baseSubscriptionId
  **/
  @ApiModelProperty(example = "null", value = "The ID of the subscription based on which the amendment is created. ")
  public String getBaseSubscriptionId() {
    return baseSubscriptionId;
  }

  public void setBaseSubscriptionId(String baseSubscriptionId) {
    this.baseSubscriptionId = baseSubscriptionId;
  }

  public GETAmendmentType code(String code) {
    this.code = code;
    return this;
  }

   /**
   * The amendment code. 
   * @return code
  **/
  @ApiModelProperty(example = "null", value = "The amendment code. ")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public GETAmendmentType contractEffectiveDate(LocalDate contractEffectiveDate) {
    this.contractEffectiveDate = contractEffectiveDate;
    return this;
  }

   /**
   * The date when the amendment becomes effective for billing purposes, as `yyyy-mm-dd`. 
   * @return contractEffectiveDate
  **/
  @ApiModelProperty(example = "null", value = "The date when the amendment becomes effective for billing purposes, as `yyyy-mm-dd`. ")
  public LocalDate getContractEffectiveDate() {
    return contractEffectiveDate;
  }

  public void setContractEffectiveDate(LocalDate contractEffectiveDate) {
    this.contractEffectiveDate = contractEffectiveDate;
  }

  public GETAmendmentType currentTerm(Long currentTerm) {
    this.currentTerm = currentTerm;
    return this;
  }

   /**
   * The length of the period for the current subscription term.  
   * @return currentTerm
  **/
  @ApiModelProperty(example = "null", value = "The length of the period for the current subscription term.  ")
  public Long getCurrentTerm() {
    return currentTerm;
  }

  public void setCurrentTerm(Long currentTerm) {
    this.currentTerm = currentTerm;
  }

  public GETAmendmentType currentTermPeriodType(String currentTermPeriodType) {
    this.currentTermPeriodType = currentTermPeriodType;
    return this;
  }

   /**
   * The period type for the current subscription term. Possible values are:  - Month - Year - Day - Week 
   * @return currentTermPeriodType
  **/
  @ApiModelProperty(example = "null", value = "The period type for the current subscription term. Possible values are:  - Month - Year - Day - Week ")
  public String getCurrentTermPeriodType() {
    return currentTermPeriodType;
  }

  public void setCurrentTermPeriodType(String currentTermPeriodType) {
    this.currentTermPeriodType = currentTermPeriodType;
  }

  public GETAmendmentType customerAcceptanceDate(LocalDate customerAcceptanceDate) {
    this.customerAcceptanceDate = customerAcceptanceDate;
    return this;
  }

   /**
   * The date when the customer accepts the amendment changes to the subscription, as `yyyy-mm-dd`. 
   * @return customerAcceptanceDate
  **/
  @ApiModelProperty(example = "null", value = "The date when the customer accepts the amendment changes to the subscription, as `yyyy-mm-dd`. ")
  public LocalDate getCustomerAcceptanceDate() {
    return customerAcceptanceDate;
  }

  public void setCustomerAcceptanceDate(LocalDate customerAcceptanceDate) {
    this.customerAcceptanceDate = customerAcceptanceDate;
  }

  public GETAmendmentType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description of the amendment. 
   * @return description
  **/
  @ApiModelProperty(example = "null", value = "Description of the amendment. ")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public GETAmendmentType destinationAccountId(String destinationAccountId) {
    this.destinationAccountId = destinationAccountId;
    return this;
  }

   /**
   * The ID of the account that the subscription is being transferred to. 
   * @return destinationAccountId
  **/
  @ApiModelProperty(example = "null", value = "The ID of the account that the subscription is being transferred to. ")
  public String getDestinationAccountId() {
    return destinationAccountId;
  }

  public void setDestinationAccountId(String destinationAccountId) {
    this.destinationAccountId = destinationAccountId;
  }

  public GETAmendmentType destinationInvoiceOwnerId(String destinationInvoiceOwnerId) {
    this.destinationInvoiceOwnerId = destinationInvoiceOwnerId;
    return this;
  }

   /**
   * The ID of the invoice that the subscription is being transferred to. 
   * @return destinationInvoiceOwnerId
  **/
  @ApiModelProperty(example = "null", value = "The ID of the invoice that the subscription is being transferred to. ")
  public String getDestinationInvoiceOwnerId() {
    return destinationInvoiceOwnerId;
  }

  public void setDestinationInvoiceOwnerId(String destinationInvoiceOwnerId) {
    this.destinationInvoiceOwnerId = destinationInvoiceOwnerId;
  }

  public GETAmendmentType effectiveDate(LocalDate effectiveDate) {
    this.effectiveDate = effectiveDate;
    return this;
  }

   /**
   * The date when the amendment changes take effective.  
   * @return effectiveDate
  **/
  @ApiModelProperty(example = "null", value = "The date when the amendment changes take effective.  ")
  public LocalDate getEffectiveDate() {
    return effectiveDate;
  }

  public void setEffectiveDate(LocalDate effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  public GETAmendmentType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The amendment ID. 
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "The amendment ID. ")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GETAmendmentType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the amendment. 
   * @return name
  **/
  @ApiModelProperty(example = "null", value = "The name of the amendment. ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GETAmendmentType newRatePlanId(String newRatePlanId) {
    this.newRatePlanId = newRatePlanId;
    return this;
  }

   /**
   * The ID of the rate plan charge on which amendment is made. Only the Add or Update amendment returns a new rate plan ID. 
   * @return newRatePlanId
  **/
  @ApiModelProperty(example = "null", value = "The ID of the rate plan charge on which amendment is made. Only the Add or Update amendment returns a new rate plan ID. ")
  public String getNewRatePlanId() {
    return newRatePlanId;
  }

  public void setNewRatePlanId(String newRatePlanId) {
    this.newRatePlanId = newRatePlanId;
  }

  public GETAmendmentType newSubscriptionId(String newSubscriptionId) {
    this.newSubscriptionId = newSubscriptionId;
    return this;
  }

   /**
   * The ID of the subscription that the amendment changes. 
   * @return newSubscriptionId
  **/
  @ApiModelProperty(example = "null", value = "The ID of the subscription that the amendment changes. ")
  public String getNewSubscriptionId() {
    return newSubscriptionId;
  }

  public void setNewSubscriptionId(String newSubscriptionId) {
    this.newSubscriptionId = newSubscriptionId;
  }

  public GETAmendmentType renewalSetting(String renewalSetting) {
    this.renewalSetting = renewalSetting;
    return this;
  }

   /**
   * Specifies whether a termed subscription will remain termed or change to evergreen when it is renewed. Possible values are:  - RENEW_WITH_SPECIFIC_TERM - RENEW_TO_EVERGREEN 
   * @return renewalSetting
  **/
  @ApiModelProperty(example = "null", value = "Specifies whether a termed subscription will remain termed or change to evergreen when it is renewed. Possible values are:  - RENEW_WITH_SPECIFIC_TERM - RENEW_TO_EVERGREEN ")
  public String getRenewalSetting() {
    return renewalSetting;
  }

  public void setRenewalSetting(String renewalSetting) {
    this.renewalSetting = renewalSetting;
  }

  public GETAmendmentType renewalTerm(Long renewalTerm) {
    this.renewalTerm = renewalTerm;
    return this;
  }

   /**
   * The term of renewal for the amended subscription. 
   * @return renewalTerm
  **/
  @ApiModelProperty(example = "null", value = "The term of renewal for the amended subscription. ")
  public Long getRenewalTerm() {
    return renewalTerm;
  }

  public void setRenewalTerm(Long renewalTerm) {
    this.renewalTerm = renewalTerm;
  }

  public GETAmendmentType renewalTermPeriodType(String renewalTermPeriodType) {
    this.renewalTermPeriodType = renewalTermPeriodType;
    return this;
  }

   /**
   * The period type for the subscription renewal term. Possible values are:  - Month - Year - Day - Week 
   * @return renewalTermPeriodType
  **/
  @ApiModelProperty(example = "null", value = "The period type for the subscription renewal term. Possible values are:  - Month - Year - Day - Week ")
  public String getRenewalTermPeriodType() {
    return renewalTermPeriodType;
  }

  public void setRenewalTermPeriodType(String renewalTermPeriodType) {
    this.renewalTermPeriodType = renewalTermPeriodType;
  }

  public GETAmendmentType resumeDate(LocalDate resumeDate) {
    this.resumeDate = resumeDate;
    return this;
  }

   /**
   * The date when the subscription resumption takes effect, as `yyyy-mm-dd`.  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/). 
   * @return resumeDate
  **/
  @ApiModelProperty(example = "null", value = "The date when the subscription resumption takes effect, as `yyyy-mm-dd`.  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/). ")
  public LocalDate getResumeDate() {
    return resumeDate;
  }

  public void setResumeDate(LocalDate resumeDate) {
    this.resumeDate = resumeDate;
  }

  public GETAmendmentType serviceActivationDate(LocalDate serviceActivationDate) {
    this.serviceActivationDate = serviceActivationDate;
    return this;
  }

   /**
   * The date when service is activated, as `yyyy-mm-dd`. 
   * @return serviceActivationDate
  **/
  @ApiModelProperty(example = "null", value = "The date when service is activated, as `yyyy-mm-dd`. ")
  public LocalDate getServiceActivationDate() {
    return serviceActivationDate;
  }

  public void setServiceActivationDate(LocalDate serviceActivationDate) {
    this.serviceActivationDate = serviceActivationDate;
  }

  public GETAmendmentType specificUpdateDate(LocalDate specificUpdateDate) {
    this.specificUpdateDate = specificUpdateDate;
    return this;
  }

   /**
   * The date when the Update Product amendment takes effect.  Only for the Update Product amendments if there is already a future-dated Update Product amendment on the subscription. 
   * @return specificUpdateDate
  **/
  @ApiModelProperty(example = "null", value = "The date when the Update Product amendment takes effect.  Only for the Update Product amendments if there is already a future-dated Update Product amendment on the subscription. ")
  public LocalDate getSpecificUpdateDate() {
    return specificUpdateDate;
  }

  public void setSpecificUpdateDate(LocalDate specificUpdateDate) {
    this.specificUpdateDate = specificUpdateDate;
  }

  public GETAmendmentType status(String status) {
    this.status = status;
    return this;
  }

   /**
   * The status of the amendment. Possible values are:  - Draft  - Pending Activation - Pending Acceptance - Completed 
   * @return status
  **/
  @ApiModelProperty(example = "null", value = "The status of the amendment. Possible values are:  - Draft  - Pending Activation - Pending Acceptance - Completed ")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public GETAmendmentType success(Boolean success) {
    this.success = success;
    return this;
  }

   /**
   * Returns `true` if the request was processed successfully. 
   * @return success
  **/
  @ApiModelProperty(example = "null", value = "Returns `true` if the request was processed successfully. ")
  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public GETAmendmentType suspendDate(LocalDate suspendDate) {
    this.suspendDate = suspendDate;
    return this;
  }

   /**
   * The date when the subscription suspension takes effect, as `yyyy-mm-dd`.  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/). 
   * @return suspendDate
  **/
  @ApiModelProperty(example = "null", value = "The date when the subscription suspension takes effect, as `yyyy-mm-dd`.  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/). ")
  public LocalDate getSuspendDate() {
    return suspendDate;
  }

  public void setSuspendDate(LocalDate suspendDate) {
    this.suspendDate = suspendDate;
  }

  public GETAmendmentType termStartDate(LocalDate termStartDate) {
    this.termStartDate = termStartDate;
    return this;
  }

   /**
   * The date when the new terms and conditions take effect. 
   * @return termStartDate
  **/
  @ApiModelProperty(example = "null", value = "The date when the new terms and conditions take effect. ")
  public LocalDate getTermStartDate() {
    return termStartDate;
  }

  public void setTermStartDate(LocalDate termStartDate) {
    this.termStartDate = termStartDate;
  }

  public GETAmendmentType termType(String termType) {
    this.termType = termType;
    return this;
  }

   /**
   * Indicates if the subscription is `TERMED` or `EVERGREEN`. 
   * @return termType
  **/
  @ApiModelProperty(example = "null", value = "Indicates if the subscription is `TERMED` or `EVERGREEN`. ")
  public String getTermType() {
    return termType;
  }

  public void setTermType(String termType) {
    this.termType = termType;
  }

  public GETAmendmentType type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Type of the amendment. Possible values are:  - Cancellation - NewProduct - OwnerTransfer - RemoveProduct - Renewal - UpdateProduct - TermsAndConditions 
   * @return type
  **/
  @ApiModelProperty(example = "null", value = "Type of the amendment. Possible values are:  - Cancellation - NewProduct - OwnerTransfer - RemoveProduct - Renewal - UpdateProduct - TermsAndConditions ")
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
    GETAmendmentType gETAmendmentType = (GETAmendmentType) o;
    return Objects.equals(this.autoRenew, gETAmendmentType.autoRenew) &&
        Objects.equals(this.baseRatePlanId, gETAmendmentType.baseRatePlanId) &&
        Objects.equals(this.baseSubscriptionId, gETAmendmentType.baseSubscriptionId) &&
        Objects.equals(this.code, gETAmendmentType.code) &&
        Objects.equals(this.contractEffectiveDate, gETAmendmentType.contractEffectiveDate) &&
        Objects.equals(this.currentTerm, gETAmendmentType.currentTerm) &&
        Objects.equals(this.currentTermPeriodType, gETAmendmentType.currentTermPeriodType) &&
        Objects.equals(this.customerAcceptanceDate, gETAmendmentType.customerAcceptanceDate) &&
        Objects.equals(this.description, gETAmendmentType.description) &&
        Objects.equals(this.destinationAccountId, gETAmendmentType.destinationAccountId) &&
        Objects.equals(this.destinationInvoiceOwnerId, gETAmendmentType.destinationInvoiceOwnerId) &&
        Objects.equals(this.effectiveDate, gETAmendmentType.effectiveDate) &&
        Objects.equals(this.id, gETAmendmentType.id) &&
        Objects.equals(this.name, gETAmendmentType.name) &&
        Objects.equals(this.newRatePlanId, gETAmendmentType.newRatePlanId) &&
        Objects.equals(this.newSubscriptionId, gETAmendmentType.newSubscriptionId) &&
        Objects.equals(this.renewalSetting, gETAmendmentType.renewalSetting) &&
        Objects.equals(this.renewalTerm, gETAmendmentType.renewalTerm) &&
        Objects.equals(this.renewalTermPeriodType, gETAmendmentType.renewalTermPeriodType) &&
        Objects.equals(this.resumeDate, gETAmendmentType.resumeDate) &&
        Objects.equals(this.serviceActivationDate, gETAmendmentType.serviceActivationDate) &&
        Objects.equals(this.specificUpdateDate, gETAmendmentType.specificUpdateDate) &&
        Objects.equals(this.status, gETAmendmentType.status) &&
        Objects.equals(this.success, gETAmendmentType.success) &&
        Objects.equals(this.suspendDate, gETAmendmentType.suspendDate) &&
        Objects.equals(this.termStartDate, gETAmendmentType.termStartDate) &&
        Objects.equals(this.termType, gETAmendmentType.termType) &&
        Objects.equals(this.type, gETAmendmentType.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoRenew, baseRatePlanId, baseSubscriptionId, code, contractEffectiveDate, currentTerm, currentTermPeriodType, customerAcceptanceDate, description, destinationAccountId, destinationInvoiceOwnerId, effectiveDate, id, name, newRatePlanId, newSubscriptionId, renewalSetting, renewalTerm, renewalTermPeriodType, resumeDate, serviceActivationDate, specificUpdateDate, status, success, suspendDate, termStartDate, termType, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GETAmendmentType {\n");
    
    sb.append("    autoRenew: ").append(toIndentedString(autoRenew)).append("\n");
    sb.append("    baseRatePlanId: ").append(toIndentedString(baseRatePlanId)).append("\n");
    sb.append("    baseSubscriptionId: ").append(toIndentedString(baseSubscriptionId)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    contractEffectiveDate: ").append(toIndentedString(contractEffectiveDate)).append("\n");
    sb.append("    currentTerm: ").append(toIndentedString(currentTerm)).append("\n");
    sb.append("    currentTermPeriodType: ").append(toIndentedString(currentTermPeriodType)).append("\n");
    sb.append("    customerAcceptanceDate: ").append(toIndentedString(customerAcceptanceDate)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    destinationAccountId: ").append(toIndentedString(destinationAccountId)).append("\n");
    sb.append("    destinationInvoiceOwnerId: ").append(toIndentedString(destinationInvoiceOwnerId)).append("\n");
    sb.append("    effectiveDate: ").append(toIndentedString(effectiveDate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    newRatePlanId: ").append(toIndentedString(newRatePlanId)).append("\n");
    sb.append("    newSubscriptionId: ").append(toIndentedString(newSubscriptionId)).append("\n");
    sb.append("    renewalSetting: ").append(toIndentedString(renewalSetting)).append("\n");
    sb.append("    renewalTerm: ").append(toIndentedString(renewalTerm)).append("\n");
    sb.append("    renewalTermPeriodType: ").append(toIndentedString(renewalTermPeriodType)).append("\n");
    sb.append("    resumeDate: ").append(toIndentedString(resumeDate)).append("\n");
    sb.append("    serviceActivationDate: ").append(toIndentedString(serviceActivationDate)).append("\n");
    sb.append("    specificUpdateDate: ").append(toIndentedString(specificUpdateDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    suspendDate: ").append(toIndentedString(suspendDate)).append("\n");
    sb.append("    termStartDate: ").append(toIndentedString(termStartDate)).append("\n");
    sb.append("    termType: ").append(toIndentedString(termType)).append("\n");
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

