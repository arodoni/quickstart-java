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
 * ProxyGetRatePlanCharge
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class ProxyGetRatePlanCharge   {
  @SerializedName("AccountingCode")
  private String accountingCode = null;

  @SerializedName("ApplyDiscountTo")
  private String applyDiscountTo = null;

  @SerializedName("BillCycleDay")
  private Integer billCycleDay = null;

  @SerializedName("BillCycleType")
  private String billCycleType = null;

  @SerializedName("BillingPeriod")
  private String billingPeriod = null;

  @SerializedName("BillingPeriodAlignment")
  private String billingPeriodAlignment = null;

  @SerializedName("BillingTiming")
  private String billingTiming = null;

  @SerializedName("ChargeModel")
  private String chargeModel = null;

  @SerializedName("ChargeNumber")
  private String chargeNumber = null;

  @SerializedName("ChargeType")
  private String chargeType = null;

  @SerializedName("ChargedThroughDate")
  private LocalDate chargedThroughDate = null;

  @SerializedName("CreatedById")
  private String createdById = null;

  @SerializedName("CreatedDate")
  private DateTime createdDate = null;

  @SerializedName("DMRC")
  private Double DMRC = null;

  @SerializedName("DTCV")
  private Double DTCV = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("DiscountLevel")
  private String discountLevel = null;

  @SerializedName("EffectiveEndDate")
  private LocalDate effectiveEndDate = null;

  @SerializedName("EffectiveStartDate")
  private LocalDate effectiveStartDate = null;

  @SerializedName("EndDateCondition")
  private String endDateCondition = null;

  @SerializedName("Id")
  private String id = null;

  @SerializedName("IsLastSegment")
  private Boolean isLastSegment = null;

  @SerializedName("ListPriceBase")
  private String listPriceBase = null;

  @SerializedName("MRR")
  private Double MRR = null;

  @SerializedName("Name")
  private String name = null;

  @SerializedName("NumberOfPeriods")
  private Long numberOfPeriods = null;

  @SerializedName("OriginalId")
  private String originalId = null;

  @SerializedName("OverageCalculationOption")
  private String overageCalculationOption = null;

  @SerializedName("OverageUnusedUnitsCreditOption")
  private String overageUnusedUnitsCreditOption = null;

  @SerializedName("PriceChangeOption")
  private String priceChangeOption = null;

  @SerializedName("PriceIncreasePercentage")
  private Double priceIncreasePercentage = null;

  @SerializedName("ProcessedThroughDate")
  private LocalDate processedThroughDate = null;

  @SerializedName("Quantity")
  private Double quantity = null;

  @SerializedName("RatePlanId")
  private String ratePlanId = null;

  @SerializedName("RevRecCode")
  private String revRecCode = null;

  @SerializedName("RevRecTriggerCondition")
  private String revRecTriggerCondition = null;

  @SerializedName("RevenueRecognitionRuleName")
  private String revenueRecognitionRuleName = null;

  @SerializedName("Segment")
  private Integer segment = null;

  @SerializedName("SpecificBillingPeriod")
  private Long specificBillingPeriod = null;

  @SerializedName("SpecificEndDate")
  private LocalDate specificEndDate = null;

  @SerializedName("TCV")
  private Double TCV = null;

  @SerializedName("TriggerDate")
  private LocalDate triggerDate = null;

  @SerializedName("TriggerEvent")
  private String triggerEvent = null;

  @SerializedName("UOM")
  private String UOM = null;

  @SerializedName("UpToPeriods")
  private Long upToPeriods = null;

  @SerializedName("UpToPeriodsType")
  private String upToPeriodsType = null;

  @SerializedName("UpdatedById")
  private String updatedById = null;

  @SerializedName("UpdatedDate")
  private DateTime updatedDate = null;

  @SerializedName("Version")
  private Long version = null;

  @SerializedName("WeeklyBillCycleDay")
  private String weeklyBillCycleDay = null;

  public ProxyGetRatePlanCharge accountingCode(String accountingCode) {
    this.accountingCode = accountingCode;
    return this;
  }

   /**
   * The accounting code for the charge. Accounting codes group transactions that contain similar accounting attributes. **Character limit**: 100 **Values**: inherited from `ProductRatePlanCharge.AccountingCode` 
   * @return accountingCode
  **/
  @ApiModelProperty(example = "null", value = "The accounting code for the charge. Accounting codes group transactions that contain similar accounting attributes. **Character limit**: 100 **Values**: inherited from `ProductRatePlanCharge.AccountingCode` ")
  public String getAccountingCode() {
    return accountingCode;
  }

  public void setAccountingCode(String accountingCode) {
    this.accountingCode = accountingCode;
  }

  public ProxyGetRatePlanCharge applyDiscountTo(String applyDiscountTo) {
    this.applyDiscountTo = applyDiscountTo;
    return this;
  }

   /**
   *  Specifies the type of charges a specific discount applies to. **Character limit**: 21 **Values**: inherited from `ProductRatePlanCharge.ApplyDiscountTo` 
   * @return applyDiscountTo
  **/
  @ApiModelProperty(example = "null", value = " Specifies the type of charges a specific discount applies to. **Character limit**: 21 **Values**: inherited from `ProductRatePlanCharge.ApplyDiscountTo` ")
  public String getApplyDiscountTo() {
    return applyDiscountTo;
  }

  public void setApplyDiscountTo(String applyDiscountTo) {
    this.applyDiscountTo = applyDiscountTo;
  }

  public ProxyGetRatePlanCharge billCycleDay(Integer billCycleDay) {
    this.billCycleDay = billCycleDay;
    return this;
  }

   /**
   *  Indicates the charge's billing cycle day (BCD), which is when bill runs generate invoices for charges associated with the product rate plan charge or the account. **Character limit**: 2 **Values**: inherited from `ProductRatePlanCharge.BillCycleDay` 
   * @return billCycleDay
  **/
  @ApiModelProperty(example = "null", value = " Indicates the charge's billing cycle day (BCD), which is when bill runs generate invoices for charges associated with the product rate plan charge or the account. **Character limit**: 2 **Values**: inherited from `ProductRatePlanCharge.BillCycleDay` ")
  public Integer getBillCycleDay() {
    return billCycleDay;
  }

  public void setBillCycleDay(Integer billCycleDay) {
    this.billCycleDay = billCycleDay;
  }

  public ProxyGetRatePlanCharge billCycleType(String billCycleType) {
    this.billCycleType = billCycleType;
    return this;
  }

   /**
   *  Specifies how to determine the billing day for the charge. **Character limit**: 20 **Values**: inherited from `ProductRatePlanCharge.BillCycleType` **Note:** You can override the value inherited from the Product Rate Plan Charge, but only when creating a new subscription or a New Product amendment. 
   * @return billCycleType
  **/
  @ApiModelProperty(example = "null", value = " Specifies how to determine the billing day for the charge. **Character limit**: 20 **Values**: inherited from `ProductRatePlanCharge.BillCycleType` **Note:** You can override the value inherited from the Product Rate Plan Charge, but only when creating a new subscription or a New Product amendment. ")
  public String getBillCycleType() {
    return billCycleType;
  }

  public void setBillCycleType(String billCycleType) {
    this.billCycleType = billCycleType;
  }

  public ProxyGetRatePlanCharge billingPeriod(String billingPeriod) {
    this.billingPeriod = billingPeriod;
    return this;
  }

   /**
   *  Allows billing period to be overridden on rate plan charge. ****Values**: **inherited from `ProductRatePlanCharge.BillingPeriod` **Note:** You can override the value inherited from the Product Rate Plan Charge, but only when creating a new subscription or a New Product amendment. 
   * @return billingPeriod
  **/
  @ApiModelProperty(example = "null", value = " Allows billing period to be overridden on rate plan charge. ****Values**: **inherited from `ProductRatePlanCharge.BillingPeriod` **Note:** You can override the value inherited from the Product Rate Plan Charge, but only when creating a new subscription or a New Product amendment. ")
  public String getBillingPeriod() {
    return billingPeriod;
  }

  public void setBillingPeriod(String billingPeriod) {
    this.billingPeriod = billingPeriod;
  }

  public ProxyGetRatePlanCharge billingPeriodAlignment(String billingPeriodAlignment) {
    this.billingPeriodAlignment = billingPeriodAlignment;
    return this;
  }

   /**
   *  Aligns charges within the same subscription if multiple charges begin on different dates. **Character limit**: 24 **Values**: inherited from `ProductRatePlanCharge.BillingPeriodAlignment` 
   * @return billingPeriodAlignment
  **/
  @ApiModelProperty(example = "null", value = " Aligns charges within the same subscription if multiple charges begin on different dates. **Character limit**: 24 **Values**: inherited from `ProductRatePlanCharge.BillingPeriodAlignment` ")
  public String getBillingPeriodAlignment() {
    return billingPeriodAlignment;
  }

  public void setBillingPeriodAlignment(String billingPeriodAlignment) {
    this.billingPeriodAlignment = billingPeriodAlignment;
  }

  public ProxyGetRatePlanCharge billingTiming(String billingTiming) {
    this.billingTiming = billingTiming;
    return this;
  }

   /**
   *  The billing timing for the charge. You can choose to bill in advance or in arrears for recurring charge types. This field is not used in one-time or usage based charge types. **Character limit**: **Values**: one of the following:  - I`n Advance` - `In Arrears` **Note:** You can override the value inherited from the Product Rate Plan Charge when a subscription has a recurring charge type. This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  
   * @return billingTiming
  **/
  @ApiModelProperty(example = "null", value = " The billing timing for the charge. You can choose to bill in advance or in arrears for recurring charge types. This field is not used in one-time or usage based charge types. **Character limit**: **Values**: one of the following:  - I`n Advance` - `In Arrears` **Note:** You can override the value inherited from the Product Rate Plan Charge when a subscription has a recurring charge type. This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  ")
  public String getBillingTiming() {
    return billingTiming;
  }

  public void setBillingTiming(String billingTiming) {
    this.billingTiming = billingTiming;
  }

  public ProxyGetRatePlanCharge chargeModel(String chargeModel) {
    this.chargeModel = chargeModel;
    return this;
  }

   /**
   *  Determines how to evaluate charges. Charge models must be individually activated in the web-based UI. **Character limit**: 29 **Values**: inherited from `ProductRatePlanCharge.ChargeModel` 
   * @return chargeModel
  **/
  @ApiModelProperty(example = "null", value = " Determines how to evaluate charges. Charge models must be individually activated in the web-based UI. **Character limit**: 29 **Values**: inherited from `ProductRatePlanCharge.ChargeModel` ")
  public String getChargeModel() {
    return chargeModel;
  }

  public void setChargeModel(String chargeModel) {
    this.chargeModel = chargeModel;
  }

  public ProxyGetRatePlanCharge chargeNumber(String chargeNumber) {
    this.chargeNumber = chargeNumber;
    return this;
  }

   /**
   *  A unique number that identifies the charge. This number is returned as a string. **Character limit**: 50 **Values**: one of the following:  - automatically generated if left null - a unique number of 50 characters or fewer 
   * @return chargeNumber
  **/
  @ApiModelProperty(example = "null", value = " A unique number that identifies the charge. This number is returned as a string. **Character limit**: 50 **Values**: one of the following:  - automatically generated if left null - a unique number of 50 characters or fewer ")
  public String getChargeNumber() {
    return chargeNumber;
  }

  public void setChargeNumber(String chargeNumber) {
    this.chargeNumber = chargeNumber;
  }

  public ProxyGetRatePlanCharge chargeType(String chargeType) {
    this.chargeType = chargeType;
    return this;
  }

   /**
   *  Specifies the type of charge. **Character limit**: 9 **Values**: inherited from `ProductRatePlanCharge.ChargeType` 
   * @return chargeType
  **/
  @ApiModelProperty(example = "null", value = " Specifies the type of charge. **Character limit**: 9 **Values**: inherited from `ProductRatePlanCharge.ChargeType` ")
  public String getChargeType() {
    return chargeType;
  }

  public void setChargeType(String chargeType) {
    this.chargeType = chargeType;
  }

  public ProxyGetRatePlanCharge chargedThroughDate(LocalDate chargedThroughDate) {
    this.chargedThroughDate = chargedThroughDate;
    return this;
  }

   /**
   *  The date through which a customer has been billed for the charge. **Character limit**: 29 **Values**: automatically generated 
   * @return chargedThroughDate
  **/
  @ApiModelProperty(example = "null", value = " The date through which a customer has been billed for the charge. **Character limit**: 29 **Values**: automatically generated ")
  public LocalDate getChargedThroughDate() {
    return chargedThroughDate;
  }

  public void setChargedThroughDate(LocalDate chargedThroughDate) {
    this.chargedThroughDate = chargedThroughDate;
  }

  public ProxyGetRatePlanCharge createdById(String createdById) {
    this.createdById = createdById;
    return this;
  }

   /**
   * The ID of the Zuora user who created the `RatePlanCharge` object. **Character limit**: 32 **Values**: automatically generated 
   * @return createdById
  **/
  @ApiModelProperty(example = "null", value = "The ID of the Zuora user who created the `RatePlanCharge` object. **Character limit**: 32 **Values**: automatically generated ")
  public String getCreatedById() {
    return createdById;
  }

  public void setCreatedById(String createdById) {
    this.createdById = createdById;
  }

  public ProxyGetRatePlanCharge createdDate(DateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }

   /**
   *  The date when the `RatePlanCharge` object was created. **Character limit**: 29 **Values**: automatically generated 
   * @return createdDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the `RatePlanCharge` object was created. **Character limit**: 29 **Values**: automatically generated ")
  public DateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(DateTime createdDate) {
    this.createdDate = createdDate;
  }

  public ProxyGetRatePlanCharge DMRC(Double DMRC) {
    this.DMRC = DMRC;
    return this;
  }

   /**
   * A delta monthly recurring charge is the change in monthly recurring revenue caused by an amendment or a new subscription. **Character limit**: 16 **Values**: automatically generated 
   * @return DMRC
  **/
  @ApiModelProperty(example = "null", value = "A delta monthly recurring charge is the change in monthly recurring revenue caused by an amendment or a new subscription. **Character limit**: 16 **Values**: automatically generated ")
  public Double getDMRC() {
    return DMRC;
  }

  public void setDMRC(Double DMRC) {
    this.DMRC = DMRC;
  }

  public ProxyGetRatePlanCharge DTCV(Double DTCV) {
    this.DTCV = DTCV;
    return this;
  }

   /**
   *  After an Amendment, the change in the total contract value (TCV) amount for this charge, compared with its previous value. **Character limit**: 16 **Values**: automatically generated 
   * @return DTCV
  **/
  @ApiModelProperty(example = "null", value = " After an Amendment, the change in the total contract value (TCV) amount for this charge, compared with its previous value. **Character limit**: 16 **Values**: automatically generated ")
  public Double getDTCV() {
    return DTCV;
  }

  public void setDTCV(Double DTCV) {
    this.DTCV = DTCV;
  }

  public ProxyGetRatePlanCharge description(String description) {
    this.description = description;
    return this;
  }

   /**
   *  A description of the charge. **Character limit**: 500 **Values**: inherited from `ProductRatePlanCharge.Description` 
   * @return description
  **/
  @ApiModelProperty(example = "null", value = " A description of the charge. **Character limit**: 500 **Values**: inherited from `ProductRatePlanCharge.Description` ")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProxyGetRatePlanCharge discountLevel(String discountLevel) {
    this.discountLevel = discountLevel;
    return this;
  }

   /**
   * Specifies if the discount applies to just the product rate plan, the entire subscription, or to any activity in the account. **Character limit**: 12 **Values**: inherited from `ProductRatePlanCharge.DiscountLevel` 
   * @return discountLevel
  **/
  @ApiModelProperty(example = "null", value = "Specifies if the discount applies to just the product rate plan, the entire subscription, or to any activity in the account. **Character limit**: 12 **Values**: inherited from `ProductRatePlanCharge.DiscountLevel` ")
  public String getDiscountLevel() {
    return discountLevel;
  }

  public void setDiscountLevel(String discountLevel) {
    this.discountLevel = discountLevel;
  }

  public ProxyGetRatePlanCharge effectiveEndDate(LocalDate effectiveEndDate) {
    this.effectiveEndDate = effectiveEndDate;
    return this;
  }

   /**
   *  The date when the segmented charge ends or ended. **Character limit**: 16 **Values**: automatically generated 
   * @return effectiveEndDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the segmented charge ends or ended. **Character limit**: 16 **Values**: automatically generated ")
  public LocalDate getEffectiveEndDate() {
    return effectiveEndDate;
  }

  public void setEffectiveEndDate(LocalDate effectiveEndDate) {
    this.effectiveEndDate = effectiveEndDate;
  }

  public ProxyGetRatePlanCharge effectiveStartDate(LocalDate effectiveStartDate) {
    this.effectiveStartDate = effectiveStartDate;
    return this;
  }

   /**
   *  The date when the segmented charge starts or started. **Character limit**: 16 **Values**: automatically generated 
   * @return effectiveStartDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the segmented charge starts or started. **Character limit**: 16 **Values**: automatically generated ")
  public LocalDate getEffectiveStartDate() {
    return effectiveStartDate;
  }

  public void setEffectiveStartDate(LocalDate effectiveStartDate) {
    this.effectiveStartDate = effectiveStartDate;
  }

  public ProxyGetRatePlanCharge endDateCondition(String endDateCondition) {
    this.endDateCondition = endDateCondition;
    return this;
  }

   /**
   *  Defines when the charge ends after the charge trigger date. This field can be updated when **Status** is `Draft`. **Values**: one of the following:  - `SubscriptionEnd`: The charge ends on the subscription end date after the charge trigger date. This is the default value. - `FixedPeriod`: The charge ends after a specified period based on the trigger date of the charge. If you set this field to `FixedPeriod`, you must specify the length of the period and a period type by defining the `UpToPeriods` and `UpToPeriodsType` fields. - `SpecificEndDate`: The specific date on which the charge ends. If you set this field to `SpecificEndDate`, you must specify the specific date by defining the `SpecificEndDate` field.  **Note**: If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date. 
   * @return endDateCondition
  **/
  @ApiModelProperty(example = "null", value = " Defines when the charge ends after the charge trigger date. This field can be updated when **Status** is `Draft`. **Values**: one of the following:  - `SubscriptionEnd`: The charge ends on the subscription end date after the charge trigger date. This is the default value. - `FixedPeriod`: The charge ends after a specified period based on the trigger date of the charge. If you set this field to `FixedPeriod`, you must specify the length of the period and a period type by defining the `UpToPeriods` and `UpToPeriodsType` fields. - `SpecificEndDate`: The specific date on which the charge ends. If you set this field to `SpecificEndDate`, you must specify the specific date by defining the `SpecificEndDate` field.  **Note**: If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date. ")
  public String getEndDateCondition() {
    return endDateCondition;
  }

  public void setEndDateCondition(String endDateCondition) {
    this.endDateCondition = endDateCondition;
  }

  public ProxyGetRatePlanCharge id(String id) {
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

  public ProxyGetRatePlanCharge isLastSegment(Boolean isLastSegment) {
    this.isLastSegment = isLastSegment;
    return this;
  }

   /**
   * Indicates if the segment of the rate plan charge is the most recent segment. **Character limit**: 5 **Values**: automatically generated: `true`, `false` 
   * @return isLastSegment
  **/
  @ApiModelProperty(example = "null", value = "Indicates if the segment of the rate plan charge is the most recent segment. **Character limit**: 5 **Values**: automatically generated: `true`, `false` ")
  public Boolean getIsLastSegment() {
    return isLastSegment;
  }

  public void setIsLastSegment(Boolean isLastSegment) {
    this.isLastSegment = isLastSegment;
  }

  public ProxyGetRatePlanCharge listPriceBase(String listPriceBase) {
    this.listPriceBase = listPriceBase;
    return this;
  }

   /**
   * The list price base for the product rate plan charge. **Values**: one of the following:  - `Per Month` - `Per Billing Period` - `Per Week` 
   * @return listPriceBase
  **/
  @ApiModelProperty(example = "null", value = "The list price base for the product rate plan charge. **Values**: one of the following:  - `Per Month` - `Per Billing Period` - `Per Week` ")
  public String getListPriceBase() {
    return listPriceBase;
  }

  public void setListPriceBase(String listPriceBase) {
    this.listPriceBase = listPriceBase;
  }

  public ProxyGetRatePlanCharge MRR(Double MRR) {
    this.MRR = MRR;
    return this;
  }

   /**
   * Monthly recurring revenue (MRR) is the amount of recurring charges in a given month. The MRR calculation doesn't include one-time charges nor usage charges. **Character limit**: 16 **Values**: automatically generated 
   * @return MRR
  **/
  @ApiModelProperty(example = "null", value = "Monthly recurring revenue (MRR) is the amount of recurring charges in a given month. The MRR calculation doesn't include one-time charges nor usage charges. **Character limit**: 16 **Values**: automatically generated ")
  public Double getMRR() {
    return MRR;
  }

  public void setMRR(Double MRR) {
    this.MRR = MRR;
  }

  public ProxyGetRatePlanCharge name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the rate plan charge. **Character limit**: 100 **Values**: automatically generated 
   * @return name
  **/
  @ApiModelProperty(example = "null", value = "The name of the rate plan charge. **Character limit**: 100 **Values**: automatically generated ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProxyGetRatePlanCharge numberOfPeriods(Long numberOfPeriods) {
    this.numberOfPeriods = numberOfPeriods;
    return this;
  }

   /**
   * Specifies the number of periods to use when calculating charges in an overage smoothing charge model. **Character limit**: 5 **Values**: inherited from `ProductRatePlanCharge.NumberOfPeriod` 
   * @return numberOfPeriods
  **/
  @ApiModelProperty(example = "null", value = "Specifies the number of periods to use when calculating charges in an overage smoothing charge model. **Character limit**: 5 **Values**: inherited from `ProductRatePlanCharge.NumberOfPeriod` ")
  public Long getNumberOfPeriods() {
    return numberOfPeriods;
  }

  public void setNumberOfPeriods(Long numberOfPeriods) {
    this.numberOfPeriods = numberOfPeriods;
  }

  public ProxyGetRatePlanCharge originalId(String originalId) {
    this.originalId = originalId;
    return this;
  }

   /**
   * The original ID of the rate plan charge. **Character limit**: 32 **Values**: automatically generated 
   * @return originalId
  **/
  @ApiModelProperty(example = "null", value = "The original ID of the rate plan charge. **Character limit**: 32 **Values**: automatically generated ")
  public String getOriginalId() {
    return originalId;
  }

  public void setOriginalId(String originalId) {
    this.originalId = originalId;
  }

  public ProxyGetRatePlanCharge overageCalculationOption(String overageCalculationOption) {
    this.overageCalculationOption = overageCalculationOption;
    return this;
  }

   /**
   * Determines when to calculate overage charges. If the value of the SmoothingMode field is null (not specified and not inherited from ProductRatePlanCharge.SmoothingMode), the value of this field is ignored. **Character limit**: 20 **Values**: inherited from `ProductRatePlanCharge.OverageCalculationOption` 
   * @return overageCalculationOption
  **/
  @ApiModelProperty(example = "null", value = "Determines when to calculate overage charges. If the value of the SmoothingMode field is null (not specified and not inherited from ProductRatePlanCharge.SmoothingMode), the value of this field is ignored. **Character limit**: 20 **Values**: inherited from `ProductRatePlanCharge.OverageCalculationOption` ")
  public String getOverageCalculationOption() {
    return overageCalculationOption;
  }

  public void setOverageCalculationOption(String overageCalculationOption) {
    this.overageCalculationOption = overageCalculationOption;
  }

  public ProxyGetRatePlanCharge overageUnusedUnitsCreditOption(String overageUnusedUnitsCreditOption) {
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
    return this;
  }

   /**
   *  Determines whether to credit the customer with unused units of usage. **Character limit**: 20 **Values**: inherited from `ProductRatePlanCharge.OverageUnusedUnitsCreditOption` 
   * @return overageUnusedUnitsCreditOption
  **/
  @ApiModelProperty(example = "null", value = " Determines whether to credit the customer with unused units of usage. **Character limit**: 20 **Values**: inherited from `ProductRatePlanCharge.OverageUnusedUnitsCreditOption` ")
  public String getOverageUnusedUnitsCreditOption() {
    return overageUnusedUnitsCreditOption;
  }

  public void setOverageUnusedUnitsCreditOption(String overageUnusedUnitsCreditOption) {
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
  }

  public ProxyGetRatePlanCharge priceChangeOption(String priceChangeOption) {
    this.priceChangeOption = priceChangeOption;
    return this;
  }

   /**
   *  Applies an automatic price change when a termed subscription is renewed. **Character limit**: **Values**: one of the following:  - `NoChange` (default) - `SpecificPercentageValue` - `UseLatestProductCatalogPricing` 
   * @return priceChangeOption
  **/
  @ApiModelProperty(example = "null", value = " Applies an automatic price change when a termed subscription is renewed. **Character limit**: **Values**: one of the following:  - `NoChange` (default) - `SpecificPercentageValue` - `UseLatestProductCatalogPricing` ")
  public String getPriceChangeOption() {
    return priceChangeOption;
  }

  public void setPriceChangeOption(String priceChangeOption) {
    this.priceChangeOption = priceChangeOption;
  }

  public ProxyGetRatePlanCharge priceIncreasePercentage(Double priceIncreasePercentage) {
    this.priceIncreasePercentage = priceIncreasePercentage;
    return this;
  }

   /**
   *  Specifies the percentage to increase or decrease the price of renewed subscriptions. Use this field if the [`ProductRatePlanCharge.PriceChangeOption`](/D_Zuora_APIs/SOAP_API/C_SOAP_API_Reference/F_API_Objects/ProductRatePlanCharge#PriceChangeOption) value is set to SpecificPercentageValue. **Character limit**: 16 **Values**: a decimal value between -100 and 100 
   * @return priceIncreasePercentage
  **/
  @ApiModelProperty(example = "null", value = " Specifies the percentage to increase or decrease the price of renewed subscriptions. Use this field if the [`ProductRatePlanCharge.PriceChangeOption`](/D_Zuora_APIs/SOAP_API/C_SOAP_API_Reference/F_API_Objects/ProductRatePlanCharge#PriceChangeOption) value is set to SpecificPercentageValue. **Character limit**: 16 **Values**: a decimal value between -100 and 100 ")
  public Double getPriceIncreasePercentage() {
    return priceIncreasePercentage;
  }

  public void setPriceIncreasePercentage(Double priceIncreasePercentage) {
    this.priceIncreasePercentage = priceIncreasePercentage;
  }

  public ProxyGetRatePlanCharge processedThroughDate(LocalDate processedThroughDate) {
    this.processedThroughDate = processedThroughDate;
    return this;
  }

   /**
   *  The date until when charges have been processed. When billing in arrears, such as usage, this field value is the the same as the `ChargedThroughDate` value. This date is the earliest date when a charge can be amended. **Character limit**: 29 **Values**: automatically generated 
   * @return processedThroughDate
  **/
  @ApiModelProperty(example = "null", value = " The date until when charges have been processed. When billing in arrears, such as usage, this field value is the the same as the `ChargedThroughDate` value. This date is the earliest date when a charge can be amended. **Character limit**: 29 **Values**: automatically generated ")
  public LocalDate getProcessedThroughDate() {
    return processedThroughDate;
  }

  public void setProcessedThroughDate(LocalDate processedThroughDate) {
    this.processedThroughDate = processedThroughDate;
  }

  public ProxyGetRatePlanCharge quantity(Double quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   *  The default quantity of units, such as the number of authors in a hosted wiki service. Valid for all charge models except for Flat Fee pricing. **Character limit**: 16 **Values**: a valid quantity value 
   * @return quantity
  **/
  @ApiModelProperty(example = "null", value = " The default quantity of units, such as the number of authors in a hosted wiki service. Valid for all charge models except for Flat Fee pricing. **Character limit**: 16 **Values**: a valid quantity value ")
  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public ProxyGetRatePlanCharge ratePlanId(String ratePlanId) {
    this.ratePlanId = ratePlanId;
    return this;
  }

   /**
   *  The ID of the rate plan associated with the rate plan charge. **Character limit**: 32 **Values**: inherited from `RatePlan.Id` 
   * @return ratePlanId
  **/
  @ApiModelProperty(example = "null", value = " The ID of the rate plan associated with the rate plan charge. **Character limit**: 32 **Values**: inherited from `RatePlan.Id` ")
  public String getRatePlanId() {
    return ratePlanId;
  }

  public void setRatePlanId(String ratePlanId) {
    this.ratePlanId = ratePlanId;
  }

  public ProxyGetRatePlanCharge revRecCode(String revRecCode) {
    this.revRecCode = revRecCode;
    return this;
  }

   /**
   *  Associates this product rate plan charge with a specific revenue recognition code. **Character limit**: 70 **Values**: a valid revenue recognition code 
   * @return revRecCode
  **/
  @ApiModelProperty(example = "null", value = " Associates this product rate plan charge with a specific revenue recognition code. **Character limit**: 70 **Values**: a valid revenue recognition code ")
  public String getRevRecCode() {
    return revRecCode;
  }

  public void setRevRecCode(String revRecCode) {
    this.revRecCode = revRecCode;
  }

  public ProxyGetRatePlanCharge revRecTriggerCondition(String revRecTriggerCondition) {
    this.revRecTriggerCondition = revRecTriggerCondition;
    return this;
  }

   /**
   *  Specifies when revenue recognition begins. **Character limit**: 22 **Values**: one of the following:  -  `ContractEffectiveDate`  -  `ServiceActivationDate`  -  `CustomerAcceptanceDate`  
   * @return revRecTriggerCondition
  **/
  @ApiModelProperty(example = "null", value = " Specifies when revenue recognition begins. **Character limit**: 22 **Values**: one of the following:  -  `ContractEffectiveDate`  -  `ServiceActivationDate`  -  `CustomerAcceptanceDate`  ")
  public String getRevRecTriggerCondition() {
    return revRecTriggerCondition;
  }

  public void setRevRecTriggerCondition(String revRecTriggerCondition) {
    this.revRecTriggerCondition = revRecTriggerCondition;
  }

  public ProxyGetRatePlanCharge revenueRecognitionRuleName(String revenueRecognitionRuleName) {
    this.revenueRecognitionRuleName = revenueRecognitionRuleName;
    return this;
  }

   /**
   *  Specifies the Revenue Recognition Rule that you want the Rate Plan Charge to use. This field can be updated when **Status** is `Draft`. By default, the Revenue Recognition Rule is inherited from the Product Rate Plan Charge. For Amend() calls, you can use this field only for NewProduct amendments. For Update() calls, you can use this field only to update subscriptions in draft status. Note that if you use this field to specify a Revenue Recognition Rule for the Rate Plan Charge, the rule will remain as specified even if you later change the rule used by the corresponding Product Rate Plan Charge. See [Z-Billing User Role](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/d_Billing_Roles) permission enabled to use this field.  **Character limit**: n/a **Values**: name of an active Revenue Recognition Rule 
   * @return revenueRecognitionRuleName
  **/
  @ApiModelProperty(example = "null", value = " Specifies the Revenue Recognition Rule that you want the Rate Plan Charge to use. This field can be updated when **Status** is `Draft`. By default, the Revenue Recognition Rule is inherited from the Product Rate Plan Charge. For Amend() calls, you can use this field only for NewProduct amendments. For Update() calls, you can use this field only to update subscriptions in draft status. Note that if you use this field to specify a Revenue Recognition Rule for the Rate Plan Charge, the rule will remain as specified even if you later change the rule used by the corresponding Product Rate Plan Charge. See [Z-Billing User Role](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/d_Billing_Roles) permission enabled to use this field.  **Character limit**: n/a **Values**: name of an active Revenue Recognition Rule ")
  public String getRevenueRecognitionRuleName() {
    return revenueRecognitionRuleName;
  }

  public void setRevenueRecognitionRuleName(String revenueRecognitionRuleName) {
    this.revenueRecognitionRuleName = revenueRecognitionRuleName;
  }

  public ProxyGetRatePlanCharge segment(Integer segment) {
    this.segment = segment;
    return this;
  }

   /**
   *  The identifying number of the subscription rate plan segment. Segments are numbered sequentially, starting with 1. **Character limit**: 2 **Values**: automatically generated 
   * @return segment
  **/
  @ApiModelProperty(example = "null", value = " The identifying number of the subscription rate plan segment. Segments are numbered sequentially, starting with 1. **Character limit**: 2 **Values**: automatically generated ")
  public Integer getSegment() {
    return segment;
  }

  public void setSegment(Integer segment) {
    this.segment = segment;
  }

  public ProxyGetRatePlanCharge specificBillingPeriod(Long specificBillingPeriod) {
    this.specificBillingPeriod = specificBillingPeriod;
    return this;
  }

   /**
   *  Customizes the number of months or weeks for the charges billing period. This field is required if you set the value of the BillingPeriod field to `Specific Months` or `Specific Weeks`. **Character limit**: 5 **Values**: inherited from `ProductRatePlanCharge.BillingPeriod` **Note:** You can override the value inherited from the Product Rate Plan Charge, but only when creating a new subscription or a New Product amendment. 
   * @return specificBillingPeriod
  **/
  @ApiModelProperty(example = "null", value = " Customizes the number of months or weeks for the charges billing period. This field is required if you set the value of the BillingPeriod field to `Specific Months` or `Specific Weeks`. **Character limit**: 5 **Values**: inherited from `ProductRatePlanCharge.BillingPeriod` **Note:** You can override the value inherited from the Product Rate Plan Charge, but only when creating a new subscription or a New Product amendment. ")
  public Long getSpecificBillingPeriod() {
    return specificBillingPeriod;
  }

  public void setSpecificBillingPeriod(Long specificBillingPeriod) {
    this.specificBillingPeriod = specificBillingPeriod;
  }

  public ProxyGetRatePlanCharge specificEndDate(LocalDate specificEndDate) {
    this.specificEndDate = specificEndDate;
    return this;
  }

   /**
   *  The specific date on which the charge ends. **Character limit**: 29 **Values**: a valid date and time value **Note**:  - This field is only applicable when the `EndDateCondition` field is set to `SpecificEndDate`. - If the subscription ends before the specific end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the specific end date. 
   * @return specificEndDate
  **/
  @ApiModelProperty(example = "null", value = " The specific date on which the charge ends. **Character limit**: 29 **Values**: a valid date and time value **Note**:  - This field is only applicable when the `EndDateCondition` field is set to `SpecificEndDate`. - If the subscription ends before the specific end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the specific end date. ")
  public LocalDate getSpecificEndDate() {
    return specificEndDate;
  }

  public void setSpecificEndDate(LocalDate specificEndDate) {
    this.specificEndDate = specificEndDate;
  }

  public ProxyGetRatePlanCharge TCV(Double TCV) {
    this.TCV = TCV;
    return this;
  }

   /**
   *  The total contract value (TCV) is the value of a single rate plan charge in a subscription over the lifetime of the subscription. This value does not represent all charges on the subscription. The TCV includes recurring charges and one-time charges, but it doesn't include usage charge. **Character limit**: 16 **Values**: automatically generated 
   * @return TCV
  **/
  @ApiModelProperty(example = "null", value = " The total contract value (TCV) is the value of a single rate plan charge in a subscription over the lifetime of the subscription. This value does not represent all charges on the subscription. The TCV includes recurring charges and one-time charges, but it doesn't include usage charge. **Character limit**: 16 **Values**: automatically generated ")
  public Double getTCV() {
    return TCV;
  }

  public void setTCV(Double TCV) {
    this.TCV = TCV;
  }

  public ProxyGetRatePlanCharge triggerDate(LocalDate triggerDate) {
    this.triggerDate = triggerDate;
    return this;
  }

   /**
   *  The date when the charge becomes effective, and billing begins. This field is required if the `TriggerEvent` field value is `SpecificDate`. **Character limit**: 29 **Values**: [a valid date and time value](/CB_Billing/WA_Dates_in_Zuora/A_Date_Format_and_Datetimes_in_Zuora) 
   * @return triggerDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the charge becomes effective, and billing begins. This field is required if the `TriggerEvent` field value is `SpecificDate`. **Character limit**: 29 **Values**: [a valid date and time value](/CB_Billing/WA_Dates_in_Zuora/A_Date_Format_and_Datetimes_in_Zuora) ")
  public LocalDate getTriggerDate() {
    return triggerDate;
  }

  public void setTriggerDate(LocalDate triggerDate) {
    this.triggerDate = triggerDate;
  }

  public ProxyGetRatePlanCharge triggerEvent(String triggerEvent) {
    this.triggerEvent = triggerEvent;
    return this;
  }

   /**
   *  Specifies when to start billing the customer for the charge. **Note: **This field can be passed through the subscribe() and amend() calls and will override the default value set on the Product Rate Plan Charge. **Character limit**: 18 **Values**: inherited from `ProductRatePlanCharge.TriggerEvent` and can be one of the following values:  - `ContractEffective `is the date when the subscription's contract goes into effect and the charge is ready to be billed. - `ServiceActivationDate `is when the services or products for a subscription have been activated and the customers have access. - `CustomerAcceptance `is when the customer accepts the services or products for a subscription. - SpecificDate is valid only on the RatePlanCharge. 
   * @return triggerEvent
  **/
  @ApiModelProperty(example = "null", value = " Specifies when to start billing the customer for the charge. **Note: **This field can be passed through the subscribe() and amend() calls and will override the default value set on the Product Rate Plan Charge. **Character limit**: 18 **Values**: inherited from `ProductRatePlanCharge.TriggerEvent` and can be one of the following values:  - `ContractEffective `is the date when the subscription's contract goes into effect and the charge is ready to be billed. - `ServiceActivationDate `is when the services or products for a subscription have been activated and the customers have access. - `CustomerAcceptance `is when the customer accepts the services or products for a subscription. - SpecificDate is valid only on the RatePlanCharge. ")
  public String getTriggerEvent() {
    return triggerEvent;
  }

  public void setTriggerEvent(String triggerEvent) {
    this.triggerEvent = triggerEvent;
  }

  public ProxyGetRatePlanCharge UOM(String UOM) {
    this.UOM = UOM;
    return this;
  }

   /**
   *  Specifies the units to measure usage. Units of measure are configured in the web-based UI: **Z-Billing > Settings**. **Character limit**: 25 **Values**: inherited from `ProductRatePlanCharge.UOM` 
   * @return UOM
  **/
  @ApiModelProperty(example = "null", value = " Specifies the units to measure usage. Units of measure are configured in the web-based UI: **Z-Billing > Settings**. **Character limit**: 25 **Values**: inherited from `ProductRatePlanCharge.UOM` ")
  public String getUOM() {
    return UOM;
  }

  public void setUOM(String UOM) {
    this.UOM = UOM;
  }

  public ProxyGetRatePlanCharge upToPeriods(Long upToPeriods) {
    this.upToPeriods = upToPeriods;
    return this;
  }

   /**
   *  Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends. **Character limit**: 5 **Values**: inherited from `ProductRatePlanCharge.UpToPeriods` **Note**:  - You must use this field together with the `UpToPeriodsType` field to specify the time period. This field is only applicable only when the `EndDateCondition` field is set to `FixedPeriod`. - You can override the value inherited from the Product Rate Plan Charge, but only when creating a new subscription or a New Product amendment. - Use this field to override the value in `ProductRatePlanCharge.UpToPeriod`. - If you override the value in this field, enter a whole number between 0 and 65535, exclusive. - If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end. 
   * @return upToPeriods
  **/
  @ApiModelProperty(example = "null", value = " Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends. **Character limit**: 5 **Values**: inherited from `ProductRatePlanCharge.UpToPeriods` **Note**:  - You must use this field together with the `UpToPeriodsType` field to specify the time period. This field is only applicable only when the `EndDateCondition` field is set to `FixedPeriod`. - You can override the value inherited from the Product Rate Plan Charge, but only when creating a new subscription or a New Product amendment. - Use this field to override the value in `ProductRatePlanCharge.UpToPeriod`. - If you override the value in this field, enter a whole number between 0 and 65535, exclusive. - If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end. ")
  public Long getUpToPeriods() {
    return upToPeriods;
  }

  public void setUpToPeriods(Long upToPeriods) {
    this.upToPeriods = upToPeriods;
  }

  public ProxyGetRatePlanCharge upToPeriodsType(String upToPeriodsType) {
    this.upToPeriodsType = upToPeriodsType;
    return this;
  }

   /**
   *  The period type used to define when the charge ends. This field can be updated when **Status** is `Draft`. **Values**: one of the following:  - `Billing Periods` (default) - `Days` - `Weeks` - `Months` - `Years` **Note**:  - You must use this field together with the `UpToPeriods` field to specify the time period. - This field is only applicable only when the `EndDateCondition` field is set to `FixedPeriod`. 
   * @return upToPeriodsType
  **/
  @ApiModelProperty(example = "null", value = " The period type used to define when the charge ends. This field can be updated when **Status** is `Draft`. **Values**: one of the following:  - `Billing Periods` (default) - `Days` - `Weeks` - `Months` - `Years` **Note**:  - You must use this field together with the `UpToPeriods` field to specify the time period. - This field is only applicable only when the `EndDateCondition` field is set to `FixedPeriod`. ")
  public String getUpToPeriodsType() {
    return upToPeriodsType;
  }

  public void setUpToPeriodsType(String upToPeriodsType) {
    this.upToPeriodsType = upToPeriodsType;
  }

  public ProxyGetRatePlanCharge updatedById(String updatedById) {
    this.updatedById = updatedById;
    return this;
  }

   /**
   * The ID of the last user to update the object. **Character limit**: 32 **Values**: automatically generated 
   * @return updatedById
  **/
  @ApiModelProperty(example = "null", value = "The ID of the last user to update the object. **Character limit**: 32 **Values**: automatically generated ")
  public String getUpdatedById() {
    return updatedById;
  }

  public void setUpdatedById(String updatedById) {
    this.updatedById = updatedById;
  }

  public ProxyGetRatePlanCharge updatedDate(DateTime updatedDate) {
    this.updatedDate = updatedDate;
    return this;
  }

   /**
   *  The date when the object was last updated. **Character limit**: 29 **Values**: automatically generated 
   * @return updatedDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the object was last updated. **Character limit**: 29 **Values**: automatically generated ")
  public DateTime getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(DateTime updatedDate) {
    this.updatedDate = updatedDate;
  }

  public ProxyGetRatePlanCharge version(Long version) {
    this.version = version;
    return this;
  }

   /**
   *  The version of the rate plan charge. Each time a charge is amended, Zuora creates a new version of the rate plan charge. **Character limit**: 5 **Values**: automatically generated 
   * @return version
  **/
  @ApiModelProperty(example = "null", value = " The version of the rate plan charge. Each time a charge is amended, Zuora creates a new version of the rate plan charge. **Character limit**: 5 **Values**: automatically generated ")
  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public ProxyGetRatePlanCharge weeklyBillCycleDay(String weeklyBillCycleDay) {
    this.weeklyBillCycleDay = weeklyBillCycleDay;
    return this;
  }

   /**
   *  Specifies which day of the week as the bill cycle day (BCD) for the charge. This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  **Values**: one of the following:  - `Sunday` - `Monday` - `Tuesday` - `Wednesday` - `Thursday` - `Friday` - `Saturday` 
   * @return weeklyBillCycleDay
  **/
  @ApiModelProperty(example = "null", value = " Specifies which day of the week as the bill cycle day (BCD) for the charge. This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  **Values**: one of the following:  - `Sunday` - `Monday` - `Tuesday` - `Wednesday` - `Thursday` - `Friday` - `Saturday` ")
  public String getWeeklyBillCycleDay() {
    return weeklyBillCycleDay;
  }

  public void setWeeklyBillCycleDay(String weeklyBillCycleDay) {
    this.weeklyBillCycleDay = weeklyBillCycleDay;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProxyGetRatePlanCharge proxyGetRatePlanCharge = (ProxyGetRatePlanCharge) o;
    return Objects.equals(this.accountingCode, proxyGetRatePlanCharge.accountingCode) &&
        Objects.equals(this.applyDiscountTo, proxyGetRatePlanCharge.applyDiscountTo) &&
        Objects.equals(this.billCycleDay, proxyGetRatePlanCharge.billCycleDay) &&
        Objects.equals(this.billCycleType, proxyGetRatePlanCharge.billCycleType) &&
        Objects.equals(this.billingPeriod, proxyGetRatePlanCharge.billingPeriod) &&
        Objects.equals(this.billingPeriodAlignment, proxyGetRatePlanCharge.billingPeriodAlignment) &&
        Objects.equals(this.billingTiming, proxyGetRatePlanCharge.billingTiming) &&
        Objects.equals(this.chargeModel, proxyGetRatePlanCharge.chargeModel) &&
        Objects.equals(this.chargeNumber, proxyGetRatePlanCharge.chargeNumber) &&
        Objects.equals(this.chargeType, proxyGetRatePlanCharge.chargeType) &&
        Objects.equals(this.chargedThroughDate, proxyGetRatePlanCharge.chargedThroughDate) &&
        Objects.equals(this.createdById, proxyGetRatePlanCharge.createdById) &&
        Objects.equals(this.createdDate, proxyGetRatePlanCharge.createdDate) &&
        Objects.equals(this.DMRC, proxyGetRatePlanCharge.DMRC) &&
        Objects.equals(this.DTCV, proxyGetRatePlanCharge.DTCV) &&
        Objects.equals(this.description, proxyGetRatePlanCharge.description) &&
        Objects.equals(this.discountLevel, proxyGetRatePlanCharge.discountLevel) &&
        Objects.equals(this.effectiveEndDate, proxyGetRatePlanCharge.effectiveEndDate) &&
        Objects.equals(this.effectiveStartDate, proxyGetRatePlanCharge.effectiveStartDate) &&
        Objects.equals(this.endDateCondition, proxyGetRatePlanCharge.endDateCondition) &&
        Objects.equals(this.id, proxyGetRatePlanCharge.id) &&
        Objects.equals(this.isLastSegment, proxyGetRatePlanCharge.isLastSegment) &&
        Objects.equals(this.listPriceBase, proxyGetRatePlanCharge.listPriceBase) &&
        Objects.equals(this.MRR, proxyGetRatePlanCharge.MRR) &&
        Objects.equals(this.name, proxyGetRatePlanCharge.name) &&
        Objects.equals(this.numberOfPeriods, proxyGetRatePlanCharge.numberOfPeriods) &&
        Objects.equals(this.originalId, proxyGetRatePlanCharge.originalId) &&
        Objects.equals(this.overageCalculationOption, proxyGetRatePlanCharge.overageCalculationOption) &&
        Objects.equals(this.overageUnusedUnitsCreditOption, proxyGetRatePlanCharge.overageUnusedUnitsCreditOption) &&
        Objects.equals(this.priceChangeOption, proxyGetRatePlanCharge.priceChangeOption) &&
        Objects.equals(this.priceIncreasePercentage, proxyGetRatePlanCharge.priceIncreasePercentage) &&
        Objects.equals(this.processedThroughDate, proxyGetRatePlanCharge.processedThroughDate) &&
        Objects.equals(this.quantity, proxyGetRatePlanCharge.quantity) &&
        Objects.equals(this.ratePlanId, proxyGetRatePlanCharge.ratePlanId) &&
        Objects.equals(this.revRecCode, proxyGetRatePlanCharge.revRecCode) &&
        Objects.equals(this.revRecTriggerCondition, proxyGetRatePlanCharge.revRecTriggerCondition) &&
        Objects.equals(this.revenueRecognitionRuleName, proxyGetRatePlanCharge.revenueRecognitionRuleName) &&
        Objects.equals(this.segment, proxyGetRatePlanCharge.segment) &&
        Objects.equals(this.specificBillingPeriod, proxyGetRatePlanCharge.specificBillingPeriod) &&
        Objects.equals(this.specificEndDate, proxyGetRatePlanCharge.specificEndDate) &&
        Objects.equals(this.TCV, proxyGetRatePlanCharge.TCV) &&
        Objects.equals(this.triggerDate, proxyGetRatePlanCharge.triggerDate) &&
        Objects.equals(this.triggerEvent, proxyGetRatePlanCharge.triggerEvent) &&
        Objects.equals(this.UOM, proxyGetRatePlanCharge.UOM) &&
        Objects.equals(this.upToPeriods, proxyGetRatePlanCharge.upToPeriods) &&
        Objects.equals(this.upToPeriodsType, proxyGetRatePlanCharge.upToPeriodsType) &&
        Objects.equals(this.updatedById, proxyGetRatePlanCharge.updatedById) &&
        Objects.equals(this.updatedDate, proxyGetRatePlanCharge.updatedDate) &&
        Objects.equals(this.version, proxyGetRatePlanCharge.version) &&
        Objects.equals(this.weeklyBillCycleDay, proxyGetRatePlanCharge.weeklyBillCycleDay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountingCode, applyDiscountTo, billCycleDay, billCycleType, billingPeriod, billingPeriodAlignment, billingTiming, chargeModel, chargeNumber, chargeType, chargedThroughDate, createdById, createdDate, DMRC, DTCV, description, discountLevel, effectiveEndDate, effectiveStartDate, endDateCondition, id, isLastSegment, listPriceBase, MRR, name, numberOfPeriods, originalId, overageCalculationOption, overageUnusedUnitsCreditOption, priceChangeOption, priceIncreasePercentage, processedThroughDate, quantity, ratePlanId, revRecCode, revRecTriggerCondition, revenueRecognitionRuleName, segment, specificBillingPeriod, specificEndDate, TCV, triggerDate, triggerEvent, UOM, upToPeriods, upToPeriodsType, updatedById, updatedDate, version, weeklyBillCycleDay);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProxyGetRatePlanCharge {\n");
    
    sb.append("    accountingCode: ").append(toIndentedString(accountingCode)).append("\n");
    sb.append("    applyDiscountTo: ").append(toIndentedString(applyDiscountTo)).append("\n");
    sb.append("    billCycleDay: ").append(toIndentedString(billCycleDay)).append("\n");
    sb.append("    billCycleType: ").append(toIndentedString(billCycleType)).append("\n");
    sb.append("    billingPeriod: ").append(toIndentedString(billingPeriod)).append("\n");
    sb.append("    billingPeriodAlignment: ").append(toIndentedString(billingPeriodAlignment)).append("\n");
    sb.append("    billingTiming: ").append(toIndentedString(billingTiming)).append("\n");
    sb.append("    chargeModel: ").append(toIndentedString(chargeModel)).append("\n");
    sb.append("    chargeNumber: ").append(toIndentedString(chargeNumber)).append("\n");
    sb.append("    chargeType: ").append(toIndentedString(chargeType)).append("\n");
    sb.append("    chargedThroughDate: ").append(toIndentedString(chargedThroughDate)).append("\n");
    sb.append("    createdById: ").append(toIndentedString(createdById)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    DMRC: ").append(toIndentedString(DMRC)).append("\n");
    sb.append("    DTCV: ").append(toIndentedString(DTCV)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    discountLevel: ").append(toIndentedString(discountLevel)).append("\n");
    sb.append("    effectiveEndDate: ").append(toIndentedString(effectiveEndDate)).append("\n");
    sb.append("    effectiveStartDate: ").append(toIndentedString(effectiveStartDate)).append("\n");
    sb.append("    endDateCondition: ").append(toIndentedString(endDateCondition)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isLastSegment: ").append(toIndentedString(isLastSegment)).append("\n");
    sb.append("    listPriceBase: ").append(toIndentedString(listPriceBase)).append("\n");
    sb.append("    MRR: ").append(toIndentedString(MRR)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    numberOfPeriods: ").append(toIndentedString(numberOfPeriods)).append("\n");
    sb.append("    originalId: ").append(toIndentedString(originalId)).append("\n");
    sb.append("    overageCalculationOption: ").append(toIndentedString(overageCalculationOption)).append("\n");
    sb.append("    overageUnusedUnitsCreditOption: ").append(toIndentedString(overageUnusedUnitsCreditOption)).append("\n");
    sb.append("    priceChangeOption: ").append(toIndentedString(priceChangeOption)).append("\n");
    sb.append("    priceIncreasePercentage: ").append(toIndentedString(priceIncreasePercentage)).append("\n");
    sb.append("    processedThroughDate: ").append(toIndentedString(processedThroughDate)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    ratePlanId: ").append(toIndentedString(ratePlanId)).append("\n");
    sb.append("    revRecCode: ").append(toIndentedString(revRecCode)).append("\n");
    sb.append("    revRecTriggerCondition: ").append(toIndentedString(revRecTriggerCondition)).append("\n");
    sb.append("    revenueRecognitionRuleName: ").append(toIndentedString(revenueRecognitionRuleName)).append("\n");
    sb.append("    segment: ").append(toIndentedString(segment)).append("\n");
    sb.append("    specificBillingPeriod: ").append(toIndentedString(specificBillingPeriod)).append("\n");
    sb.append("    specificEndDate: ").append(toIndentedString(specificEndDate)).append("\n");
    sb.append("    TCV: ").append(toIndentedString(TCV)).append("\n");
    sb.append("    triggerDate: ").append(toIndentedString(triggerDate)).append("\n");
    sb.append("    triggerEvent: ").append(toIndentedString(triggerEvent)).append("\n");
    sb.append("    UOM: ").append(toIndentedString(UOM)).append("\n");
    sb.append("    upToPeriods: ").append(toIndentedString(upToPeriods)).append("\n");
    sb.append("    upToPeriodsType: ").append(toIndentedString(upToPeriodsType)).append("\n");
    sb.append("    updatedById: ").append(toIndentedString(updatedById)).append("\n");
    sb.append("    updatedDate: ").append(toIndentedString(updatedDate)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    weeklyBillCycleDay: ").append(toIndentedString(weeklyBillCycleDay)).append("\n");
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

