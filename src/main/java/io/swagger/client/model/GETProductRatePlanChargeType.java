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
import io.swagger.client.model.GETProductRatePlanChargePricingType;
import io.swagger.client.model.GETProductRatePlanChargeTypeFinanceInformation;
import java.util.ArrayList;
import java.util.List;


/**
 * GETProductRatePlanChargeType
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class GETProductRatePlanChargeType   {
  @SerializedName("applyDiscountTo")
  private String applyDiscountTo = null;

  @SerializedName("billingDay")
  private String billingDay = null;

  @SerializedName("billingPeriod")
  private String billingPeriod = null;

  @SerializedName("billingPeriodAlignment")
  private String billingPeriodAlignment = null;

  @SerializedName("billingTiming")
  private String billingTiming = null;

  @SerializedName("customField__c")
  private String customFieldC = null;

  @SerializedName("defaultQuantity")
  private String defaultQuantity = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("discountLevel")
  private String discountLevel = null;

  @SerializedName("endDateCondition")
  private String endDateCondition = null;

  @SerializedName("financeInformation")
  private GETProductRatePlanChargeTypeFinanceInformation financeInformation = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("includedUnits")
  private String includedUnits = null;

  @SerializedName("listPriceBase")
  private String listPriceBase = null;

  @SerializedName("maxQuantity")
  private String maxQuantity = null;

  @SerializedName("minQuantity")
  private String minQuantity = null;

  @SerializedName("model")
  private String model = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("numberOfPeriods")
  private Long numberOfPeriods = null;

  @SerializedName("overageCalculationOption")
  private String overageCalculationOption = null;

  @SerializedName("overageUnusedUnitsCreditOption")
  private String overageUnusedUnitsCreditOption = null;

  @SerializedName("prepayPeriods")
  private Long prepayPeriods = null;

  @SerializedName("priceChangeOption")
  private String priceChangeOption = null;

  @SerializedName("priceIncreasePercentage")
  private String priceIncreasePercentage = null;

  @SerializedName("pricing")
  private List<GETProductRatePlanChargePricingType> pricing = new ArrayList<GETProductRatePlanChargePricingType>();

  @SerializedName("pricingSummary")
  private List<String> pricingSummary = new ArrayList<String>();

  @SerializedName("ratingGroup")
  private String ratingGroup = null;

  @SerializedName("revenueRecognitionRuleName")
  private String revenueRecognitionRuleName = null;

  @SerializedName("smoothingModel")
  private String smoothingModel = null;

  @SerializedName("specificBillingPeriod")
  private Long specificBillingPeriod = null;

  @SerializedName("taxCode")
  private String taxCode = null;

  @SerializedName("taxMode")
  private String taxMode = null;

  @SerializedName("taxable")
  private Boolean taxable = null;

  @SerializedName("triggerEvent")
  private String triggerEvent = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("uom")
  private String uom = null;

  @SerializedName("upToPeriods")
  private Long upToPeriods = null;

  @SerializedName("upToPeriodsType")
  private String upToPeriodsType = null;

  @SerializedName("usageRecordRatingOption")
  private String usageRecordRatingOption = null;

  @SerializedName("useDiscountSpecificAccountingCode")
  private Boolean useDiscountSpecificAccountingCode = null;

  @SerializedName("useTenantDefaultForPriceChange")
  private Boolean useTenantDefaultForPriceChange = null;

  public GETProductRatePlanChargeType applyDiscountTo(String applyDiscountTo) {
    this.applyDiscountTo = applyDiscountTo;
    return this;
  }

   /**
   * Specifies where (to what charge type) the discount will be applied. These field values are case-sensitive.  Permissible values: - RECURRING - USAGE - ONETIMERECURRING - ONETIMEUSAGE - RECURRINGUSAGE - ONETIMERECURRINGUSAGE 
   * @return applyDiscountTo
  **/
  @ApiModelProperty(example = "null", value = "Specifies where (to what charge type) the discount will be applied. These field values are case-sensitive.  Permissible values: - RECURRING - USAGE - ONETIMERECURRING - ONETIMEUSAGE - RECURRINGUSAGE - ONETIMERECURRINGUSAGE ")
  public String getApplyDiscountTo() {
    return applyDiscountTo;
  }

  public void setApplyDiscountTo(String applyDiscountTo) {
    this.applyDiscountTo = applyDiscountTo;
  }

  public GETProductRatePlanChargeType billingDay(String billingDay) {
    this.billingDay = billingDay;
    return this;
  }

   /**
   * The [bill cycle day](https://knowledgecenter.zuora.com/CB_Billing/WA_Dates_in_Zuora/C_Customer_Account_Dates%3A_Bill_Cycle_Day) (BCD) for the charge. The BCD determines which day of the month or week the customer is billed. The BCD value in the account can override the BCD in this object. 
   * @return billingDay
  **/
  @ApiModelProperty(example = "null", value = "The [bill cycle day](https://knowledgecenter.zuora.com/CB_Billing/WA_Dates_in_Zuora/C_Customer_Account_Dates%3A_Bill_Cycle_Day) (BCD) for the charge. The BCD determines which day of the month or week the customer is billed. The BCD value in the account can override the BCD in this object. ")
  public String getBillingDay() {
    return billingDay;
  }

  public void setBillingDay(String billingDay) {
    this.billingDay = billingDay;
  }

  public GETProductRatePlanChargeType billingPeriod(String billingPeriod) {
    this.billingPeriod = billingPeriod;
    return this;
  }

   /**
   * The billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD).  Values: - Month - Quarter - Annual - Semi-Annual - Specific Months - Week - Specific_Weeks 
   * @return billingPeriod
  **/
  @ApiModelProperty(example = "null", value = "The billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD).  Values: - Month - Quarter - Annual - Semi-Annual - Specific Months - Week - Specific_Weeks ")
  public String getBillingPeriod() {
    return billingPeriod;
  }

  public void setBillingPeriod(String billingPeriod) {
    this.billingPeriod = billingPeriod;
  }

  public GETProductRatePlanChargeType billingPeriodAlignment(String billingPeriodAlignment) {
    this.billingPeriodAlignment = billingPeriodAlignment;
    return this;
  }

   /**
   * Aligns charges within the same subscription if multiple charges begin on different dates.  Possible values: - AlignToCharge - AlignToSubscriptionStart - AlignToTermStart 
   * @return billingPeriodAlignment
  **/
  @ApiModelProperty(example = "null", value = "Aligns charges within the same subscription if multiple charges begin on different dates.  Possible values: - AlignToCharge - AlignToSubscriptionStart - AlignToTermStart ")
  public String getBillingPeriodAlignment() {
    return billingPeriodAlignment;
  }

  public void setBillingPeriodAlignment(String billingPeriodAlignment) {
    this.billingPeriodAlignment = billingPeriodAlignment;
  }

  public GETProductRatePlanChargeType billingTiming(String billingTiming) {
    this.billingTiming = billingTiming;
    return this;
  }

   /**
   * The billing timing for the charge. You can choose to bill for charges in advance or in arrears.  Values: - In Advance - In Arrears  **Note:** This feature is in Limited Availability. If you wish to have access to the feature, submit a request at [Zuora Global Support](https://support.zuora.com).  
   * @return billingTiming
  **/
  @ApiModelProperty(example = "null", value = "The billing timing for the charge. You can choose to bill for charges in advance or in arrears.  Values: - In Advance - In Arrears  **Note:** This feature is in Limited Availability. If you wish to have access to the feature, submit a request at [Zuora Global Support](https://support.zuora.com).  ")
  public String getBillingTiming() {
    return billingTiming;
  }

  public void setBillingTiming(String billingTiming) {
    this.billingTiming = billingTiming;
  }

  public GETProductRatePlanChargeType customFieldC(String customFieldC) {
    this.customFieldC = customFieldC;
    return this;
  }

   /**
   * Any custom fields defined for this object. 
   * @return customFieldC
  **/
  @ApiModelProperty(example = "null", value = "Any custom fields defined for this object. ")
  public String getCustomFieldC() {
    return customFieldC;
  }

  public void setCustomFieldC(String customFieldC) {
    this.customFieldC = customFieldC;
  }

  public GETProductRatePlanChargeType defaultQuantity(String defaultQuantity) {
    this.defaultQuantity = defaultQuantity;
    return this;
  }

   /**
   * The default quantity of units.  This field is required if you use a per-unit charge model. 
   * @return defaultQuantity
  **/
  @ApiModelProperty(example = "null", value = "The default quantity of units.  This field is required if you use a per-unit charge model. ")
  public String getDefaultQuantity() {
    return defaultQuantity;
  }

  public void setDefaultQuantity(String defaultQuantity) {
    this.defaultQuantity = defaultQuantity;
  }

  public GETProductRatePlanChargeType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Usually a brief line item summary of the Rate Plan Charge. 
   * @return description
  **/
  @ApiModelProperty(example = "null", value = "Usually a brief line item summary of the Rate Plan Charge. ")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public GETProductRatePlanChargeType discountLevel(String discountLevel) {
    this.discountLevel = discountLevel;
    return this;
  }

   /**
   * The level of the discount.   Values: - RatePlan - Subscription - Account 
   * @return discountLevel
  **/
  @ApiModelProperty(example = "null", value = "The level of the discount.   Values: - RatePlan - Subscription - Account ")
  public String getDiscountLevel() {
    return discountLevel;
  }

  public void setDiscountLevel(String discountLevel) {
    this.discountLevel = discountLevel;
  }

  public GETProductRatePlanChargeType endDateCondition(String endDateCondition) {
    this.endDateCondition = endDateCondition;
    return this;
  }

   /**
   * Defines when the charge ends after the charge trigger date. If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date.  Values: - Subscription_End - Fixed_Period 
   * @return endDateCondition
  **/
  @ApiModelProperty(example = "null", value = "Defines when the charge ends after the charge trigger date. If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date.  Values: - Subscription_End - Fixed_Period ")
  public String getEndDateCondition() {
    return endDateCondition;
  }

  public void setEndDateCondition(String endDateCondition) {
    this.endDateCondition = endDateCondition;
  }

  public GETProductRatePlanChargeType financeInformation(GETProductRatePlanChargeTypeFinanceInformation financeInformation) {
    this.financeInformation = financeInformation;
    return this;
  }

   /**
   * Get financeInformation
   * @return financeInformation
  **/
  @ApiModelProperty(example = "null", value = "")
  public GETProductRatePlanChargeTypeFinanceInformation getFinanceInformation() {
    return financeInformation;
  }

  public void setFinanceInformation(GETProductRatePlanChargeTypeFinanceInformation financeInformation) {
    this.financeInformation = financeInformation;
  }

  public GETProductRatePlanChargeType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique product rate-plan charge ID. 
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "Unique product rate-plan charge ID. ")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GETProductRatePlanChargeType includedUnits(String includedUnits) {
    this.includedUnits = includedUnits;
    return this;
  }

   /**
   * Specifies the number of units in the base set of units when the charge model is Overage. 
   * @return includedUnits
  **/
  @ApiModelProperty(example = "null", value = "Specifies the number of units in the base set of units when the charge model is Overage. ")
  public String getIncludedUnits() {
    return includedUnits;
  }

  public void setIncludedUnits(String includedUnits) {
    this.includedUnits = includedUnits;
  }

  public GETProductRatePlanChargeType listPriceBase(String listPriceBase) {
    this.listPriceBase = listPriceBase;
    return this;
  }

   /**
   * The list price base for the product rate plan charge.  Values: - Month - Billing Period - Per_Week 
   * @return listPriceBase
  **/
  @ApiModelProperty(example = "null", value = "The list price base for the product rate plan charge.  Values: - Month - Billing Period - Per_Week ")
  public String getListPriceBase() {
    return listPriceBase;
  }

  public void setListPriceBase(String listPriceBase) {
    this.listPriceBase = listPriceBase;
  }

  public GETProductRatePlanChargeType maxQuantity(String maxQuantity) {
    this.maxQuantity = maxQuantity;
    return this;
  }

   /**
   * Specifies the maximum number of units for this charge. Use this field and the `minQuantity` field to create a range of units allowed in a product rate plan charge. 
   * @return maxQuantity
  **/
  @ApiModelProperty(example = "null", value = "Specifies the maximum number of units for this charge. Use this field and the `minQuantity` field to create a range of units allowed in a product rate plan charge. ")
  public String getMaxQuantity() {
    return maxQuantity;
  }

  public void setMaxQuantity(String maxQuantity) {
    this.maxQuantity = maxQuantity;
  }

  public GETProductRatePlanChargeType minQuantity(String minQuantity) {
    this.minQuantity = minQuantity;
    return this;
  }

   /**
   * Specifies the minimum number of units for this charge. Use this field and the `maxQuantity` field to create a range of units allowed in a product rate plan charge. 
   * @return minQuantity
  **/
  @ApiModelProperty(example = "null", value = "Specifies the minimum number of units for this charge. Use this field and the `maxQuantity` field to create a range of units allowed in a product rate plan charge. ")
  public String getMinQuantity() {
    return minQuantity;
  }

  public void setMinQuantity(String minQuantity) {
    this.minQuantity = minQuantity;
  }

  public GETProductRatePlanChargeType model(String model) {
    this.model = model;
    return this;
  }

   /**
   * Charge model which determines how charges are calculated.  [Charge models](https://knowledgecenter.zuora.com/BC_Subscription_Management/Product_Catalog/B_Charge_Models) must be individually activated in Z-Billing administration.   Possible values are: - FlatFee - PerUnit - Overage - Volume - Tiered - TieredWithOverage - DiscountFixedAmount - DiscountPercentage The [Pricing Summaries](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Catalog#Pricing_Summaries) section below details these charge models and their associated pricingSummary values. 
   * @return model
  **/
  @ApiModelProperty(example = "null", value = "Charge model which determines how charges are calculated.  [Charge models](https://knowledgecenter.zuora.com/BC_Subscription_Management/Product_Catalog/B_Charge_Models) must be individually activated in Z-Billing administration.   Possible values are: - FlatFee - PerUnit - Overage - Volume - Tiered - TieredWithOverage - DiscountFixedAmount - DiscountPercentage The [Pricing Summaries](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Catalog#Pricing_Summaries) section below details these charge models and their associated pricingSummary values. ")
  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public GETProductRatePlanChargeType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the product rate-plan charge. (Not required to be unique.) 
   * @return name
  **/
  @ApiModelProperty(example = "null", value = "Name of the product rate-plan charge. (Not required to be unique.) ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GETProductRatePlanChargeType numberOfPeriods(Long numberOfPeriods) {
    this.numberOfPeriods = numberOfPeriods;
    return this;
  }

   /**
   * Value specifies the number of periods used in the smoothing model calculations Used when overage smoothing model is `RollingWindow` or `Rollover`. 
   * @return numberOfPeriods
  **/
  @ApiModelProperty(example = "null", value = "Value specifies the number of periods used in the smoothing model calculations Used when overage smoothing model is `RollingWindow` or `Rollover`. ")
  public Long getNumberOfPeriods() {
    return numberOfPeriods;
  }

  public void setNumberOfPeriods(Long numberOfPeriods) {
    this.numberOfPeriods = numberOfPeriods;
  }

  public GETProductRatePlanChargeType overageCalculationOption(String overageCalculationOption) {
    this.overageCalculationOption = overageCalculationOption;
    return this;
  }

   /**
   * Value specifies when to calculate overage charges.  Values: - EndOfSmoothingPeriod - PerBillingPeriod 
   * @return overageCalculationOption
  **/
  @ApiModelProperty(example = "null", value = "Value specifies when to calculate overage charges.  Values: - EndOfSmoothingPeriod - PerBillingPeriod ")
  public String getOverageCalculationOption() {
    return overageCalculationOption;
  }

  public void setOverageCalculationOption(String overageCalculationOption) {
    this.overageCalculationOption = overageCalculationOption;
  }

  public GETProductRatePlanChargeType overageUnusedUnitsCreditOption(String overageUnusedUnitsCreditOption) {
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
    return this;
  }

   /**
   * Determines whether to credit the customer with unused units of usage.  Values: - NoCredit - CreditBySpecificRate 
   * @return overageUnusedUnitsCreditOption
  **/
  @ApiModelProperty(example = "null", value = "Determines whether to credit the customer with unused units of usage.  Values: - NoCredit - CreditBySpecificRate ")
  public String getOverageUnusedUnitsCreditOption() {
    return overageUnusedUnitsCreditOption;
  }

  public void setOverageUnusedUnitsCreditOption(String overageUnusedUnitsCreditOption) {
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
  }

  public GETProductRatePlanChargeType prepayPeriods(Long prepayPeriods) {
    this.prepayPeriods = prepayPeriods;
    return this;
  }

   /**
   * The number of periods to which prepayment is set.   **Note:** This field is only available if you already have the [prepayment](https://knowledgecenter.zuora.com/BC_Subscription_Management/Product_Catalog/A_Product_Catalog_Concepts/zz_Prepayments) feature enabled. The prepayment feature is deprecated and available only for backward compatibility. Zuora does not support enabling this feature anymore. 
   * @return prepayPeriods
  **/
  @ApiModelProperty(example = "null", value = "The number of periods to which prepayment is set.   **Note:** This field is only available if you already have the [prepayment](https://knowledgecenter.zuora.com/BC_Subscription_Management/Product_Catalog/A_Product_Catalog_Concepts/zz_Prepayments) feature enabled. The prepayment feature is deprecated and available only for backward compatibility. Zuora does not support enabling this feature anymore. ")
  public Long getPrepayPeriods() {
    return prepayPeriods;
  }

  public void setPrepayPeriods(Long prepayPeriods) {
    this.prepayPeriods = prepayPeriods;
  }

  public GETProductRatePlanChargeType priceChangeOption(String priceChangeOption) {
    this.priceChangeOption = priceChangeOption;
    return this;
  }

   /**
   * Applies an automatic price change when a termed subscription is renewed and the following applies:  1. AutomatedPriceChange setting is on 2. Charge type is not one-time 3. Charge model is not discount fixed amount  Values: - NoChange (default) - SpecificPercentageValue - UseLatestProductCatalogPricing 
   * @return priceChangeOption
  **/
  @ApiModelProperty(example = "null", value = "Applies an automatic price change when a termed subscription is renewed and the following applies:  1. AutomatedPriceChange setting is on 2. Charge type is not one-time 3. Charge model is not discount fixed amount  Values: - NoChange (default) - SpecificPercentageValue - UseLatestProductCatalogPricing ")
  public String getPriceChangeOption() {
    return priceChangeOption;
  }

  public void setPriceChangeOption(String priceChangeOption) {
    this.priceChangeOption = priceChangeOption;
  }

  public GETProductRatePlanChargeType priceIncreasePercentage(String priceIncreasePercentage) {
    this.priceIncreasePercentage = priceIncreasePercentage;
    return this;
  }

   /**
   * Specifies the percentage to increase or decrease the price of a termed subscription's renewal. Use this field if you set the `PriceChangeOption` value to `SpecificPercentageValue`.  1. AutomatedPriceChange setting is on 2. Charge type is not one-time 3. Charge model is not discount fixed amount  Values: a decimal between -100 and 100 
   * @return priceIncreasePercentage
  **/
  @ApiModelProperty(example = "null", value = "Specifies the percentage to increase or decrease the price of a termed subscription's renewal. Use this field if you set the `PriceChangeOption` value to `SpecificPercentageValue`.  1. AutomatedPriceChange setting is on 2. Charge type is not one-time 3. Charge model is not discount fixed amount  Values: a decimal between -100 and 100 ")
  public String getPriceIncreasePercentage() {
    return priceIncreasePercentage;
  }

  public void setPriceIncreasePercentage(String priceIncreasePercentage) {
    this.priceIncreasePercentage = priceIncreasePercentage;
  }

  public GETProductRatePlanChargeType pricing(List<GETProductRatePlanChargePricingType> pricing) {
    this.pricing = pricing;
    return this;
  }

  public GETProductRatePlanChargeType addPricingItem(GETProductRatePlanChargePricingType pricingItem) {
    this.pricing.add(pricingItem);
    return this;
  }

   /**
   * One or more price charge models with attributes that further describe the model.  Some attributes show as null values when not applicable. 
   * @return pricing
  **/
  @ApiModelProperty(example = "null", value = "One or more price charge models with attributes that further describe the model.  Some attributes show as null values when not applicable. ")
  public List<GETProductRatePlanChargePricingType> getPricing() {
    return pricing;
  }

  public void setPricing(List<GETProductRatePlanChargePricingType> pricing) {
    this.pricing = pricing;
  }

  public GETProductRatePlanChargeType pricingSummary(List<String> pricingSummary) {
    this.pricingSummary = pricingSummary;
    return this;
  }

  public GETProductRatePlanChargeType addPricingSummaryItem(String pricingSummaryItem) {
    this.pricingSummary.add(pricingSummaryItem);
    return this;
  }

   /**
   * A concise description of the charge model and pricing that is suitable to show to your customers. See [Pricing Summaries](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Catalog#Pricing_Summaries) below for more information. 
   * @return pricingSummary
  **/
  @ApiModelProperty(example = "null", value = "A concise description of the charge model and pricing that is suitable to show to your customers. See [Pricing Summaries](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Catalog#Pricing_Summaries) below for more information. ")
  public List<String> getPricingSummary() {
    return pricingSummary;
  }

  public void setPricingSummary(List<String> pricingSummary) {
    this.pricingSummary = pricingSummary;
  }

  public GETProductRatePlanChargeType ratingGroup(String ratingGroup) {
    this.ratingGroup = ratingGroup;
    return this;
  }

   /**
   * Specifies a rating group based on which usage records are rated.   **Note:** This feature is in Limited Availability. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  
   * @return ratingGroup
  **/
  @ApiModelProperty(example = "null", value = "Specifies a rating group based on which usage records are rated.   **Note:** This feature is in Limited Availability. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  ")
  public String getRatingGroup() {
    return ratingGroup;
  }

  public void setRatingGroup(String ratingGroup) {
    this.ratingGroup = ratingGroup;
  }

  public GETProductRatePlanChargeType revenueRecognitionRuleName(String revenueRecognitionRuleName) {
    this.revenueRecognitionRuleName = revenueRecognitionRuleName;
    return this;
  }

   /**
   * The name of the revenue recognition rule governing the revenue schedule. 
   * @return revenueRecognitionRuleName
  **/
  @ApiModelProperty(example = "null", value = "The name of the revenue recognition rule governing the revenue schedule. ")
  public String getRevenueRecognitionRuleName() {
    return revenueRecognitionRuleName;
  }

  public void setRevenueRecognitionRuleName(String revenueRecognitionRuleName) {
    this.revenueRecognitionRuleName = revenueRecognitionRuleName;
  }

  public GETProductRatePlanChargeType smoothingModel(String smoothingModel) {
    this.smoothingModel = smoothingModel;
    return this;
  }

   /**
   * Specifies the smoothing model for an [overage smoothing charge model](https://knowledgecenter.zuora.com/CB_Billing/D_Product_Catalog/B_Charge_Models/A_Overage_Smoothing_Charge_Model) or an tiered with overage model, which is an advanced type of a usage model that avoids spikes in usage charges. If a customer's usage spikes in a single period, then an overage smoothing model eases overage charges by considering usage and multiple periods.  One of the following values shows which smoothing model will be applied to the charge when `Overage` or `Tiered with Overage` is used:  - `RollingWindow` considers a number of periods to smooth usage. The rolling window starts and increments forward based on billing frequency. When allowed usage is met, then period resets and a new window begins. - `Rollover` considers a fixed number of periods before calculating usage. The net balance at the end of a period is unused usage, which is carried over to the next period's balance. 
   * @return smoothingModel
  **/
  @ApiModelProperty(example = "null", value = "Specifies the smoothing model for an [overage smoothing charge model](https://knowledgecenter.zuora.com/CB_Billing/D_Product_Catalog/B_Charge_Models/A_Overage_Smoothing_Charge_Model) or an tiered with overage model, which is an advanced type of a usage model that avoids spikes in usage charges. If a customer's usage spikes in a single period, then an overage smoothing model eases overage charges by considering usage and multiple periods.  One of the following values shows which smoothing model will be applied to the charge when `Overage` or `Tiered with Overage` is used:  - `RollingWindow` considers a number of periods to smooth usage. The rolling window starts and increments forward based on billing frequency. When allowed usage is met, then period resets and a new window begins. - `Rollover` considers a fixed number of periods before calculating usage. The net balance at the end of a period is unused usage, which is carried over to the next period's balance. ")
  public String getSmoothingModel() {
    return smoothingModel;
  }

  public void setSmoothingModel(String smoothingModel) {
    this.smoothingModel = smoothingModel;
  }

  public GETProductRatePlanChargeType specificBillingPeriod(Long specificBillingPeriod) {
    this.specificBillingPeriod = specificBillingPeriod;
    return this;
  }

   /**
   * When the billing period is set to `Specific` Months then this positive integer reflects the number of months for billing period charges. 
   * @return specificBillingPeriod
  **/
  @ApiModelProperty(example = "null", value = "When the billing period is set to `Specific` Months then this positive integer reflects the number of months for billing period charges. ")
  public Long getSpecificBillingPeriod() {
    return specificBillingPeriod;
  }

  public void setSpecificBillingPeriod(Long specificBillingPeriod) {
    this.specificBillingPeriod = specificBillingPeriod;
  }

  public GETProductRatePlanChargeType taxCode(String taxCode) {
    this.taxCode = taxCode;
    return this;
  }

   /**
   * Specifies the [tax code](https://knowledgecenter.zuora.com/CB_Billing/J_Billing_Operations/L_Taxes/A_Z-Tax/B_Configure_Tax_Codes_in_Z-Billing) for taxation rules; used by Z-Tax. 
   * @return taxCode
  **/
  @ApiModelProperty(example = "null", value = "Specifies the [tax code](https://knowledgecenter.zuora.com/CB_Billing/J_Billing_Operations/L_Taxes/A_Z-Tax/B_Configure_Tax_Codes_in_Z-Billing) for taxation rules; used by Z-Tax. ")
  public String getTaxCode() {
    return taxCode;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }

  public GETProductRatePlanChargeType taxMode(String taxMode) {
    this.taxMode = taxMode;
    return this;
  }

   /**
   * Specifies how to define taxation for the charge; used by Z-Tax. Possible values are: `TaxExclusive`, `TaxInclusive`. 
   * @return taxMode
  **/
  @ApiModelProperty(example = "null", value = "Specifies how to define taxation for the charge; used by Z-Tax. Possible values are: `TaxExclusive`, `TaxInclusive`. ")
  public String getTaxMode() {
    return taxMode;
  }

  public void setTaxMode(String taxMode) {
    this.taxMode = taxMode;
  }

  public GETProductRatePlanChargeType taxable(Boolean taxable) {
    this.taxable = taxable;
    return this;
  }

   /**
   * Specifies whether the charge is taxable; used by Z-Tax. Possible values are:`true`, `false`. 
   * @return taxable
  **/
  @ApiModelProperty(example = "null", value = "Specifies whether the charge is taxable; used by Z-Tax. Possible values are:`true`, `false`. ")
  public Boolean getTaxable() {
    return taxable;
  }

  public void setTaxable(Boolean taxable) {
    this.taxable = taxable;
  }

  public GETProductRatePlanChargeType triggerEvent(String triggerEvent) {
    this.triggerEvent = triggerEvent;
    return this;
  }

   /**
   * Specifies when to start billing the customer for the charge.  Values: one of the following: - `ContractEffective` is the date when the subscription's contract goes into effect and the charge is ready to be billed. - `ServiceActivation` is the date when the services or products for a subscription have been activated and the customers have access. - `CustomerAcceptance` is when the customer accepts the services or products for a subscription.  - `SpecificDate` is the date specified. 
   * @return triggerEvent
  **/
  @ApiModelProperty(example = "null", value = "Specifies when to start billing the customer for the charge.  Values: one of the following: - `ContractEffective` is the date when the subscription's contract goes into effect and the charge is ready to be billed. - `ServiceActivation` is the date when the services or products for a subscription have been activated and the customers have access. - `CustomerAcceptance` is when the customer accepts the services or products for a subscription.  - `SpecificDate` is the date specified. ")
  public String getTriggerEvent() {
    return triggerEvent;
  }

  public void setTriggerEvent(String triggerEvent) {
    this.triggerEvent = triggerEvent;
  }

  public GETProductRatePlanChargeType type(String type) {
    this.type = type;
    return this;
  }

   /**
   * The type of charge. Possible values are: `OneTime`, `Recurring`, `Usage`. 
   * @return type
  **/
  @ApiModelProperty(example = "null", value = "The type of charge. Possible values are: `OneTime`, `Recurring`, `Usage`. ")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public GETProductRatePlanChargeType uom(String uom) {
    this.uom = uom;
    return this;
  }

   /**
   * Describes the Units of Measure (uom) configured in **Z-Billing > Settings** for the productRatePlanCharges.  Values: `Each`, `License`, `Seat`, or `null` 
   * @return uom
  **/
  @ApiModelProperty(example = "null", value = "Describes the Units of Measure (uom) configured in **Z-Billing > Settings** for the productRatePlanCharges.  Values: `Each`, `License`, `Seat`, or `null` ")
  public String getUom() {
    return uom;
  }

  public void setUom(String uom) {
    this.uom = uom;
  }

  public GETProductRatePlanChargeType upToPeriods(Long upToPeriods) {
    this.upToPeriods = upToPeriods;
    return this;
  }

   /**
   * Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends. If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end. 
   * @return upToPeriods
  **/
  @ApiModelProperty(example = "null", value = "Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends. If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end. ")
  public Long getUpToPeriods() {
    return upToPeriods;
  }

  public void setUpToPeriods(Long upToPeriods) {
    this.upToPeriods = upToPeriods;
  }

  public GETProductRatePlanChargeType upToPeriodsType(String upToPeriodsType) {
    this.upToPeriodsType = upToPeriodsType;
    return this;
  }

   /**
   * The period type used to define when the charge ends.  Values: - Billing_Periods - Days - Weeks - Months - Years    
   * @return upToPeriodsType
  **/
  @ApiModelProperty(example = "null", value = "The period type used to define when the charge ends.  Values: - Billing_Periods - Days - Weeks - Months - Years    ")
  public String getUpToPeriodsType() {
    return upToPeriodsType;
  }

  public void setUpToPeriodsType(String upToPeriodsType) {
    this.upToPeriodsType = upToPeriodsType;
  }

  public GETProductRatePlanChargeType usageRecordRatingOption(String usageRecordRatingOption) {
    this.usageRecordRatingOption = usageRecordRatingOption;
    return this;
  }

   /**
   * Determines how Zuora processes usage records for per-unit usage charges.  
   * @return usageRecordRatingOption
  **/
  @ApiModelProperty(example = "null", value = "Determines how Zuora processes usage records for per-unit usage charges.  ")
  public String getUsageRecordRatingOption() {
    return usageRecordRatingOption;
  }

  public void setUsageRecordRatingOption(String usageRecordRatingOption) {
    this.usageRecordRatingOption = usageRecordRatingOption;
  }

  public GETProductRatePlanChargeType useDiscountSpecificAccountingCode(Boolean useDiscountSpecificAccountingCode) {
    this.useDiscountSpecificAccountingCode = useDiscountSpecificAccountingCode;
    return this;
  }

   /**
   * Determines whether to define a new accounting code for the new discount charge. Values: `true`, `false` 
   * @return useDiscountSpecificAccountingCode
  **/
  @ApiModelProperty(example = "null", value = "Determines whether to define a new accounting code for the new discount charge. Values: `true`, `false` ")
  public Boolean getUseDiscountSpecificAccountingCode() {
    return useDiscountSpecificAccountingCode;
  }

  public void setUseDiscountSpecificAccountingCode(Boolean useDiscountSpecificAccountingCode) {
    this.useDiscountSpecificAccountingCode = useDiscountSpecificAccountingCode;
  }

  public GETProductRatePlanChargeType useTenantDefaultForPriceChange(Boolean useTenantDefaultForPriceChange) {
    this.useTenantDefaultForPriceChange = useTenantDefaultForPriceChange;
    return this;
  }

   /**
   * Shows the tenant-level percentage uplift value for an automatic price change to a termed subscription's renewal. You set the tenant uplift value in the web-based UI: **Z-Billing > Define Default Subscription Settings**.  Values: `true`, `false` 
   * @return useTenantDefaultForPriceChange
  **/
  @ApiModelProperty(example = "null", value = "Shows the tenant-level percentage uplift value for an automatic price change to a termed subscription's renewal. You set the tenant uplift value in the web-based UI: **Z-Billing > Define Default Subscription Settings**.  Values: `true`, `false` ")
  public Boolean getUseTenantDefaultForPriceChange() {
    return useTenantDefaultForPriceChange;
  }

  public void setUseTenantDefaultForPriceChange(Boolean useTenantDefaultForPriceChange) {
    this.useTenantDefaultForPriceChange = useTenantDefaultForPriceChange;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GETProductRatePlanChargeType gETProductRatePlanChargeType = (GETProductRatePlanChargeType) o;
    return Objects.equals(this.applyDiscountTo, gETProductRatePlanChargeType.applyDiscountTo) &&
        Objects.equals(this.billingDay, gETProductRatePlanChargeType.billingDay) &&
        Objects.equals(this.billingPeriod, gETProductRatePlanChargeType.billingPeriod) &&
        Objects.equals(this.billingPeriodAlignment, gETProductRatePlanChargeType.billingPeriodAlignment) &&
        Objects.equals(this.billingTiming, gETProductRatePlanChargeType.billingTiming) &&
        Objects.equals(this.customFieldC, gETProductRatePlanChargeType.customFieldC) &&
        Objects.equals(this.defaultQuantity, gETProductRatePlanChargeType.defaultQuantity) &&
        Objects.equals(this.description, gETProductRatePlanChargeType.description) &&
        Objects.equals(this.discountLevel, gETProductRatePlanChargeType.discountLevel) &&
        Objects.equals(this.endDateCondition, gETProductRatePlanChargeType.endDateCondition) &&
        Objects.equals(this.financeInformation, gETProductRatePlanChargeType.financeInformation) &&
        Objects.equals(this.id, gETProductRatePlanChargeType.id) &&
        Objects.equals(this.includedUnits, gETProductRatePlanChargeType.includedUnits) &&
        Objects.equals(this.listPriceBase, gETProductRatePlanChargeType.listPriceBase) &&
        Objects.equals(this.maxQuantity, gETProductRatePlanChargeType.maxQuantity) &&
        Objects.equals(this.minQuantity, gETProductRatePlanChargeType.minQuantity) &&
        Objects.equals(this.model, gETProductRatePlanChargeType.model) &&
        Objects.equals(this.name, gETProductRatePlanChargeType.name) &&
        Objects.equals(this.numberOfPeriods, gETProductRatePlanChargeType.numberOfPeriods) &&
        Objects.equals(this.overageCalculationOption, gETProductRatePlanChargeType.overageCalculationOption) &&
        Objects.equals(this.overageUnusedUnitsCreditOption, gETProductRatePlanChargeType.overageUnusedUnitsCreditOption) &&
        Objects.equals(this.prepayPeriods, gETProductRatePlanChargeType.prepayPeriods) &&
        Objects.equals(this.priceChangeOption, gETProductRatePlanChargeType.priceChangeOption) &&
        Objects.equals(this.priceIncreasePercentage, gETProductRatePlanChargeType.priceIncreasePercentage) &&
        Objects.equals(this.pricing, gETProductRatePlanChargeType.pricing) &&
        Objects.equals(this.pricingSummary, gETProductRatePlanChargeType.pricingSummary) &&
        Objects.equals(this.ratingGroup, gETProductRatePlanChargeType.ratingGroup) &&
        Objects.equals(this.revenueRecognitionRuleName, gETProductRatePlanChargeType.revenueRecognitionRuleName) &&
        Objects.equals(this.smoothingModel, gETProductRatePlanChargeType.smoothingModel) &&
        Objects.equals(this.specificBillingPeriod, gETProductRatePlanChargeType.specificBillingPeriod) &&
        Objects.equals(this.taxCode, gETProductRatePlanChargeType.taxCode) &&
        Objects.equals(this.taxMode, gETProductRatePlanChargeType.taxMode) &&
        Objects.equals(this.taxable, gETProductRatePlanChargeType.taxable) &&
        Objects.equals(this.triggerEvent, gETProductRatePlanChargeType.triggerEvent) &&
        Objects.equals(this.type, gETProductRatePlanChargeType.type) &&
        Objects.equals(this.uom, gETProductRatePlanChargeType.uom) &&
        Objects.equals(this.upToPeriods, gETProductRatePlanChargeType.upToPeriods) &&
        Objects.equals(this.upToPeriodsType, gETProductRatePlanChargeType.upToPeriodsType) &&
        Objects.equals(this.usageRecordRatingOption, gETProductRatePlanChargeType.usageRecordRatingOption) &&
        Objects.equals(this.useDiscountSpecificAccountingCode, gETProductRatePlanChargeType.useDiscountSpecificAccountingCode) &&
        Objects.equals(this.useTenantDefaultForPriceChange, gETProductRatePlanChargeType.useTenantDefaultForPriceChange);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applyDiscountTo, billingDay, billingPeriod, billingPeriodAlignment, billingTiming, customFieldC, defaultQuantity, description, discountLevel, endDateCondition, financeInformation, id, includedUnits, listPriceBase, maxQuantity, minQuantity, model, name, numberOfPeriods, overageCalculationOption, overageUnusedUnitsCreditOption, prepayPeriods, priceChangeOption, priceIncreasePercentage, pricing, pricingSummary, ratingGroup, revenueRecognitionRuleName, smoothingModel, specificBillingPeriod, taxCode, taxMode, taxable, triggerEvent, type, uom, upToPeriods, upToPeriodsType, usageRecordRatingOption, useDiscountSpecificAccountingCode, useTenantDefaultForPriceChange);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GETProductRatePlanChargeType {\n");
    
    sb.append("    applyDiscountTo: ").append(toIndentedString(applyDiscountTo)).append("\n");
    sb.append("    billingDay: ").append(toIndentedString(billingDay)).append("\n");
    sb.append("    billingPeriod: ").append(toIndentedString(billingPeriod)).append("\n");
    sb.append("    billingPeriodAlignment: ").append(toIndentedString(billingPeriodAlignment)).append("\n");
    sb.append("    billingTiming: ").append(toIndentedString(billingTiming)).append("\n");
    sb.append("    customFieldC: ").append(toIndentedString(customFieldC)).append("\n");
    sb.append("    defaultQuantity: ").append(toIndentedString(defaultQuantity)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    discountLevel: ").append(toIndentedString(discountLevel)).append("\n");
    sb.append("    endDateCondition: ").append(toIndentedString(endDateCondition)).append("\n");
    sb.append("    financeInformation: ").append(toIndentedString(financeInformation)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    includedUnits: ").append(toIndentedString(includedUnits)).append("\n");
    sb.append("    listPriceBase: ").append(toIndentedString(listPriceBase)).append("\n");
    sb.append("    maxQuantity: ").append(toIndentedString(maxQuantity)).append("\n");
    sb.append("    minQuantity: ").append(toIndentedString(minQuantity)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    numberOfPeriods: ").append(toIndentedString(numberOfPeriods)).append("\n");
    sb.append("    overageCalculationOption: ").append(toIndentedString(overageCalculationOption)).append("\n");
    sb.append("    overageUnusedUnitsCreditOption: ").append(toIndentedString(overageUnusedUnitsCreditOption)).append("\n");
    sb.append("    prepayPeriods: ").append(toIndentedString(prepayPeriods)).append("\n");
    sb.append("    priceChangeOption: ").append(toIndentedString(priceChangeOption)).append("\n");
    sb.append("    priceIncreasePercentage: ").append(toIndentedString(priceIncreasePercentage)).append("\n");
    sb.append("    pricing: ").append(toIndentedString(pricing)).append("\n");
    sb.append("    pricingSummary: ").append(toIndentedString(pricingSummary)).append("\n");
    sb.append("    ratingGroup: ").append(toIndentedString(ratingGroup)).append("\n");
    sb.append("    revenueRecognitionRuleName: ").append(toIndentedString(revenueRecognitionRuleName)).append("\n");
    sb.append("    smoothingModel: ").append(toIndentedString(smoothingModel)).append("\n");
    sb.append("    specificBillingPeriod: ").append(toIndentedString(specificBillingPeriod)).append("\n");
    sb.append("    taxCode: ").append(toIndentedString(taxCode)).append("\n");
    sb.append("    taxMode: ").append(toIndentedString(taxMode)).append("\n");
    sb.append("    taxable: ").append(toIndentedString(taxable)).append("\n");
    sb.append("    triggerEvent: ").append(toIndentedString(triggerEvent)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    uom: ").append(toIndentedString(uom)).append("\n");
    sb.append("    upToPeriods: ").append(toIndentedString(upToPeriods)).append("\n");
    sb.append("    upToPeriodsType: ").append(toIndentedString(upToPeriodsType)).append("\n");
    sb.append("    usageRecordRatingOption: ").append(toIndentedString(usageRecordRatingOption)).append("\n");
    sb.append("    useDiscountSpecificAccountingCode: ").append(toIndentedString(useDiscountSpecificAccountingCode)).append("\n");
    sb.append("    useTenantDefaultForPriceChange: ").append(toIndentedString(useTenantDefaultForPriceChange)).append("\n");
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

