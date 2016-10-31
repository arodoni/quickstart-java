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
import io.swagger.client.model.POSTTierType;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDate;


/**
 * PUTScAddType
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class PUTScAddType   {
  @SerializedName("applyDiscountTo")
  private String applyDiscountTo = null;

  @SerializedName("billCycleDay")
  private String billCycleDay = null;

  @SerializedName("billCycleType")
  private String billCycleType = null;

  @SerializedName("billingPeriod")
  private String billingPeriod = null;

  @SerializedName("billingPeriodAlignment")
  private String billingPeriodAlignment = null;

  @SerializedName("billingTiming")
  private String billingTiming = null;

  @SerializedName("customField__c")
  private String customFieldC = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("discountAmount")
  private String discountAmount = null;

  @SerializedName("discountLevel")
  private String discountLevel = null;

  @SerializedName("discountPercentage")
  private String discountPercentage = null;

  @SerializedName("endDateCondition")
  private String endDateCondition = null;

  @SerializedName("includedUnits")
  private String includedUnits = null;

  @SerializedName("listPriceBase")
  private String listPriceBase = null;

  @SerializedName("number")
  private String number = null;

  @SerializedName("numberOfPeriods")
  private Long numberOfPeriods = null;

  @SerializedName("overagePrice")
  private String overagePrice = null;

  @SerializedName("overageUnusedUnitsCreditOption")
  private String overageUnusedUnitsCreditOption = null;

  @SerializedName("price")
  private String price = null;

  @SerializedName("priceChangeOption")
  private String priceChangeOption = null;

  @SerializedName("priceIncreasePercentage")
  private String priceIncreasePercentage = null;

  @SerializedName("productRatePlanChargeId")
  private String productRatePlanChargeId = null;

  @SerializedName("quantity")
  private String quantity = null;

  @SerializedName("ratingGroup")
  private String ratingGroup = null;

  @SerializedName("specificBillingPeriod")
  private Long specificBillingPeriod = null;

  @SerializedName("specificEndDate")
  private LocalDate specificEndDate = null;

  @SerializedName("tiers")
  private List<POSTTierType> tiers = new ArrayList<POSTTierType>();

  @SerializedName("triggerDate")
  private LocalDate triggerDate = null;

  @SerializedName("triggerEvent")
  private String triggerEvent = null;

  @SerializedName("unusedUnitsCreditRates")
  private String unusedUnitsCreditRates = null;

  @SerializedName("upToPeriods")
  private Long upToPeriods = null;

  @SerializedName("upToPeriodsType")
  private String upToPeriodsType = null;

  public PUTScAddType applyDiscountTo(String applyDiscountTo) {
    this.applyDiscountTo = applyDiscountTo;
    return this;
  }

   /**
   * Specifies the type of charges that you want a specific discount to apply to.  Values:  * `ONETIME` * `RECURRING` * `USAGE` * `ONETIMERECURRING` * `ONETIMEUSAGE` * `RECURRINGUSAGE` * `ONETIMERECURRINGUSAGE`  Available for the following charge type for the Discount-Fixed Amount and Discount-Percentage charge models:  * Recurring 
   * @return applyDiscountTo
  **/
  @ApiModelProperty(example = "null", value = "Specifies the type of charges that you want a specific discount to apply to.  Values:  * `ONETIME` * `RECURRING` * `USAGE` * `ONETIMERECURRING` * `ONETIMEUSAGE` * `RECURRINGUSAGE` * `ONETIMERECURRINGUSAGE`  Available for the following charge type for the Discount-Fixed Amount and Discount-Percentage charge models:  * Recurring ")
  public String getApplyDiscountTo() {
    return applyDiscountTo;
  }

  public void setApplyDiscountTo(String applyDiscountTo) {
    this.applyDiscountTo = applyDiscountTo;
  }

  public PUTScAddType billCycleDay(String billCycleDay) {
    this.billCycleDay = billCycleDay;
    return this;
  }

   /**
   * Sets the bill cycle day (BCD) for the charge. The BCD determines which day of the month customer is billed.  Values: `1`-`31`  Available for the following charge types:  * Recurring * Usage-based 
   * @return billCycleDay
  **/
  @ApiModelProperty(example = "null", value = "Sets the bill cycle day (BCD) for the charge. The BCD determines which day of the month customer is billed.  Values: `1`-`31`  Available for the following charge types:  * Recurring * Usage-based ")
  public String getBillCycleDay() {
    return billCycleDay;
  }

  public void setBillCycleDay(String billCycleDay) {
    this.billCycleDay = billCycleDay;
  }

  public PUTScAddType billCycleType(String billCycleType) {
    this.billCycleType = billCycleType;
    return this;
  }

   /**
   * Specifies how to determine the billing day for the charge. When this field is set to `SpecificDayOfMonth`, set the `BillCycleDay` field. When this field is set to `SpecificDayOfWeek`, set the `weeklyBillCycleDay` field.  Values:  * `DefaultFromCustomer` * `SpecificDayOfMonth` * `SubscriptionStartDay` * `ChargeTriggerDay` * `SpecificDayOfWeek`  Available for the following charge types:  * Recurring * Usage-based 
   * @return billCycleType
  **/
  @ApiModelProperty(example = "null", value = "Specifies how to determine the billing day for the charge. When this field is set to `SpecificDayOfMonth`, set the `BillCycleDay` field. When this field is set to `SpecificDayOfWeek`, set the `weeklyBillCycleDay` field.  Values:  * `DefaultFromCustomer` * `SpecificDayOfMonth` * `SubscriptionStartDay` * `ChargeTriggerDay` * `SpecificDayOfWeek`  Available for the following charge types:  * Recurring * Usage-based ")
  public String getBillCycleType() {
    return billCycleType;
  }

  public void setBillCycleType(String billCycleType) {
    this.billCycleType = billCycleType;
  }

  public PUTScAddType billingPeriod(String billingPeriod) {
    this.billingPeriod = billingPeriod;
    return this;
  }

   /**
   * Billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD).  Values:  * `Month` * `Quarter` * `Semi_Annual` * `Annual` * `Eighteen_Months` * `Two_Years` * `Three_Years` * `Five_Years` * `Specific_Months` * `Subscription_Term` * `Week` * `Specific_Weeks`  Available for the following charge types:  * Recurring * Usage-based 
   * @return billingPeriod
  **/
  @ApiModelProperty(example = "null", value = "Billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD).  Values:  * `Month` * `Quarter` * `Semi_Annual` * `Annual` * `Eighteen_Months` * `Two_Years` * `Three_Years` * `Five_Years` * `Specific_Months` * `Subscription_Term` * `Week` * `Specific_Weeks`  Available for the following charge types:  * Recurring * Usage-based ")
  public String getBillingPeriod() {
    return billingPeriod;
  }

  public void setBillingPeriod(String billingPeriod) {
    this.billingPeriod = billingPeriod;
  }

  public PUTScAddType billingPeriodAlignment(String billingPeriodAlignment) {
    this.billingPeriodAlignment = billingPeriodAlignment;
    return this;
  }

   /**
   * Aligns charges within the same subscription if multiple charges begin on different dates.  Values:  * `AlignToCharge` * `AlignToSubscriptionStart` * `AlignToTermStart`  Available for the following charge types:  * Recurring * Usage-based 
   * @return billingPeriodAlignment
  **/
  @ApiModelProperty(example = "null", value = "Aligns charges within the same subscription if multiple charges begin on different dates.  Values:  * `AlignToCharge` * `AlignToSubscriptionStart` * `AlignToTermStart`  Available for the following charge types:  * Recurring * Usage-based ")
  public String getBillingPeriodAlignment() {
    return billingPeriodAlignment;
  }

  public void setBillingPeriodAlignment(String billingPeriodAlignment) {
    this.billingPeriodAlignment = billingPeriodAlignment;
  }

  public PUTScAddType billingTiming(String billingTiming) {
    this.billingTiming = billingTiming;
    return this;
  }

   /**
   * Billing timing for the charge for recurring charge types. Not avaliable for one time, usage and discount charges.  Values:  * `IN_ADVANCE` (default) * `IN_ARREARS` 
   * @return billingTiming
  **/
  @ApiModelProperty(example = "null", value = "Billing timing for the charge for recurring charge types. Not avaliable for one time, usage and discount charges.  Values:  * `IN_ADVANCE` (default) * `IN_ARREARS` ")
  public String getBillingTiming() {
    return billingTiming;
  }

  public void setBillingTiming(String billingTiming) {
    this.billingTiming = billingTiming;
  }

  public PUTScAddType customFieldC(String customFieldC) {
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

  public PUTScAddType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description of the charge. 
   * @return description
  **/
  @ApiModelProperty(example = "null", value = "Description of the charge. ")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PUTScAddType discountAmount(String discountAmount) {
    this.discountAmount = discountAmount;
    return this;
  }

   /**
   * Specifies the amount of fixed-amount discount.  Available for the following charge type for the Discount-Fixed Amount charge model:  * Recurring 
   * @return discountAmount
  **/
  @ApiModelProperty(example = "null", value = "Specifies the amount of fixed-amount discount.  Available for the following charge type for the Discount-Fixed Amount charge model:  * Recurring ")
  public String getDiscountAmount() {
    return discountAmount;
  }

  public void setDiscountAmount(String discountAmount) {
    this.discountAmount = discountAmount;
  }

  public PUTScAddType discountLevel(String discountLevel) {
    this.discountLevel = discountLevel;
    return this;
  }

   /**
   * Specifies if the discount applies to the product rate plan only , the entire subscription, or to any activity in the account.  Values:  * `rateplan` * `subscription` * `account`  Available for the following charge type for the Discount-Fixed Amount and Discount-Percentage charge models:  * Recurring 
   * @return discountLevel
  **/
  @ApiModelProperty(example = "null", value = "Specifies if the discount applies to the product rate plan only , the entire subscription, or to any activity in the account.  Values:  * `rateplan` * `subscription` * `account`  Available for the following charge type for the Discount-Fixed Amount and Discount-Percentage charge models:  * Recurring ")
  public String getDiscountLevel() {
    return discountLevel;
  }

  public void setDiscountLevel(String discountLevel) {
    this.discountLevel = discountLevel;
  }

  public PUTScAddType discountPercentage(String discountPercentage) {
    this.discountPercentage = discountPercentage;
    return this;
  }

   /**
   * Specifies the percentage of a percentage discount.   Available for the following charge type for the Discount-Percentage charge model:  * Recurring 
   * @return discountPercentage
  **/
  @ApiModelProperty(example = "null", value = "Specifies the percentage of a percentage discount.   Available for the following charge type for the Discount-Percentage charge model:  * Recurring ")
  public String getDiscountPercentage() {
    return discountPercentage;
  }

  public void setDiscountPercentage(String discountPercentage) {
    this.discountPercentage = discountPercentage;
  }

  public PUTScAddType endDateCondition(String endDateCondition) {
    this.endDateCondition = endDateCondition;
    return this;
  }

   /**
   * Defines when the charge ends after the charge trigger date. If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date.  Values:  * `Subscription_End` * `Fixed_Period` * `Specific_End_Date` 
   * @return endDateCondition
  **/
  @ApiModelProperty(example = "null", value = "Defines when the charge ends after the charge trigger date. If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date.  Values:  * `Subscription_End` * `Fixed_Period` * `Specific_End_Date` ")
  public String getEndDateCondition() {
    return endDateCondition;
  }

  public void setEndDateCondition(String endDateCondition) {
    this.endDateCondition = endDateCondition;
  }

  public PUTScAddType includedUnits(String includedUnits) {
    this.includedUnits = includedUnits;
    return this;
  }

   /**
   * Specifies the number of units in the base set of units for this charge. Must be >=`0`.  Available for the following charge types for the Overage charge model:  * Recurring * Usage-based 
   * @return includedUnits
  **/
  @ApiModelProperty(example = "null", value = "Specifies the number of units in the base set of units for this charge. Must be >=`0`.  Available for the following charge types for the Overage charge model:  * Recurring * Usage-based ")
  public String getIncludedUnits() {
    return includedUnits;
  }

  public void setIncludedUnits(String includedUnits) {
    this.includedUnits = includedUnits;
  }

  public PUTScAddType listPriceBase(String listPriceBase) {
    this.listPriceBase = listPriceBase;
    return this;
  }

   /**
   * The list price base for the product rate plan charge.  Values:  * `Per_Billing_Period` * `Per_Month` * `Per_Week`  Available for the following charge type for the Flat Fee, Per Unit, Volume Pricing, and Tiered Pricing charge models:  * Recurring 
   * @return listPriceBase
  **/
  @ApiModelProperty(example = "null", value = "The list price base for the product rate plan charge.  Values:  * `Per_Billing_Period` * `Per_Month` * `Per_Week`  Available for the following charge type for the Flat Fee, Per Unit, Volume Pricing, and Tiered Pricing charge models:  * Recurring ")
  public String getListPriceBase() {
    return listPriceBase;
  }

  public void setListPriceBase(String listPriceBase) {
    this.listPriceBase = listPriceBase;
  }

  public PUTScAddType number(String number) {
    this.number = number;
    return this;
  }

   /**
   * Unique number that identifies the charge. System-generated if not provided. 
   * @return number
  **/
  @ApiModelProperty(example = "null", value = "Unique number that identifies the charge. System-generated if not provided. ")
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public PUTScAddType numberOfPeriods(Long numberOfPeriods) {
    this.numberOfPeriods = numberOfPeriods;
    return this;
  }

   /**
   * Specifies the number of periods to use when calculating charges in an overage smoothing charge model.  Available for the following charge type for the Overage and Tiered with Overage charge models:  * Usage-based 
   * @return numberOfPeriods
  **/
  @ApiModelProperty(example = "null", value = "Specifies the number of periods to use when calculating charges in an overage smoothing charge model.  Available for the following charge type for the Overage and Tiered with Overage charge models:  * Usage-based ")
  public Long getNumberOfPeriods() {
    return numberOfPeriods;
  }

  public void setNumberOfPeriods(Long numberOfPeriods) {
    this.numberOfPeriods = numberOfPeriods;
  }

  public PUTScAddType overagePrice(String overagePrice) {
    this.overagePrice = overagePrice;
    return this;
  }

   /**
   * Price for units over the allowed amount.   Available for the following charge type for the Overage and Tiered with Overage charge models:  * Usage-based 
   * @return overagePrice
  **/
  @ApiModelProperty(example = "null", value = "Price for units over the allowed amount.   Available for the following charge type for the Overage and Tiered with Overage charge models:  * Usage-based ")
  public String getOveragePrice() {
    return overagePrice;
  }

  public void setOveragePrice(String overagePrice) {
    this.overagePrice = overagePrice;
  }

  public PUTScAddType overageUnusedUnitsCreditOption(String overageUnusedUnitsCreditOption) {
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
    return this;
  }

   /**
   * Determines whether to credit the customer with unused units of usage.  Values:  * `NoCredit` * `CreditBySpecificRate`  Available for the following charge type for the Overage and Tiered with Overage charge models:  * Usage-based 
   * @return overageUnusedUnitsCreditOption
  **/
  @ApiModelProperty(example = "null", value = "Determines whether to credit the customer with unused units of usage.  Values:  * `NoCredit` * `CreditBySpecificRate`  Available for the following charge type for the Overage and Tiered with Overage charge models:  * Usage-based ")
  public String getOverageUnusedUnitsCreditOption() {
    return overageUnusedUnitsCreditOption;
  }

  public void setOverageUnusedUnitsCreditOption(String overageUnusedUnitsCreditOption) {
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
  }

  public PUTScAddType price(String price) {
    this.price = price;
    return this;
  }

   /**
   * Price for units in the subscription rate plan.  Supports all charge types for the Flat Fee and Per Unit charge models 
   * @return price
  **/
  @ApiModelProperty(example = "null", value = "Price for units in the subscription rate plan.  Supports all charge types for the Flat Fee and Per Unit charge models ")
  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public PUTScAddType priceChangeOption(String priceChangeOption) {
    this.priceChangeOption = priceChangeOption;
    return this;
  }

   /**
   * Applies an automatic price change when a termed subscription is renewed. The Z-Billing Admin setting Enable Automatic Price Change When Subscriptions are Renewed?  must be set to Yes to use this field.  See Define Default Subscription Settings for more information on setting this option.  Values:  * `NoChange` (default) * `SpecificPercentageValue` * `UseLatestProductCatalogPricing`  Available for the following charge types:  * Recurring * Usage-based * Not available for the Fixed-Amount Discount charge model. 
   * @return priceChangeOption
  **/
  @ApiModelProperty(example = "null", value = "Applies an automatic price change when a termed subscription is renewed. The Z-Billing Admin setting Enable Automatic Price Change When Subscriptions are Renewed?  must be set to Yes to use this field.  See Define Default Subscription Settings for more information on setting this option.  Values:  * `NoChange` (default) * `SpecificPercentageValue` * `UseLatestProductCatalogPricing`  Available for the following charge types:  * Recurring * Usage-based * Not available for the Fixed-Amount Discount charge model. ")
  public String getPriceChangeOption() {
    return priceChangeOption;
  }

  public void setPriceChangeOption(String priceChangeOption) {
    this.priceChangeOption = priceChangeOption;
  }

  public PUTScAddType priceIncreasePercentage(String priceIncreasePercentage) {
    this.priceIncreasePercentage = priceIncreasePercentage;
    return this;
  }

   /**
   * Specifies the percentage to increase or decrease the price of a termed subscription's renewal. Required if you set the `PriceChangeOption` field to `SpecificPercentageValue`.  Decimal between -100 and 100.  Available for the following charge types:  * Recurring * Usage-based  Not available for the Fixed-Amount Discount charge model. 
   * @return priceIncreasePercentage
  **/
  @ApiModelProperty(example = "null", value = "Specifies the percentage to increase or decrease the price of a termed subscription's renewal. Required if you set the `PriceChangeOption` field to `SpecificPercentageValue`.  Decimal between -100 and 100.  Available for the following charge types:  * Recurring * Usage-based  Not available for the Fixed-Amount Discount charge model. ")
  public String getPriceIncreasePercentage() {
    return priceIncreasePercentage;
  }

  public void setPriceIncreasePercentage(String priceIncreasePercentage) {
    this.priceIncreasePercentage = priceIncreasePercentage;
  }

  public PUTScAddType productRatePlanChargeId(String productRatePlanChargeId) {
    this.productRatePlanChargeId = productRatePlanChargeId;
    return this;
  }

   /**
   * 
   * @return productRatePlanChargeId
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getProductRatePlanChargeId() {
    return productRatePlanChargeId;
  }

  public void setProductRatePlanChargeId(String productRatePlanChargeId) {
    this.productRatePlanChargeId = productRatePlanChargeId;
  }

  public PUTScAddType quantity(String quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * Number of units. Must be >=`0`.  Available for the following charge types for the Per Unit, Volume Pricing, and Tiered Pricing charge models:  * One-time * Recurring 
   * @return quantity
  **/
  @ApiModelProperty(example = "null", value = "Number of units. Must be >=`0`.  Available for the following charge types for the Per Unit, Volume Pricing, and Tiered Pricing charge models:  * One-time * Recurring ")
  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public PUTScAddType ratingGroup(String ratingGroup) {
    this.ratingGroup = ratingGroup;
    return this;
  }

   /**
   * Specifies a rating group based on which usage records are rated. See [Usages Rating by Group](https://knowledgecenter.zuora.com/CB_Billing/J_Billing_Operations/Usage/Usage_Rating_by_Group) for more information.  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  Values:  * `ByBillingPeriod` (default): The rating is based on all the usages in a billing period.        * `ByUsageStartDate`: The rating is based on all the usages on the same usage start date.  * `ByUsageRecord`: The rating is based on each usage record. * `ByUsageUpload`: The rating is based on all the usages in a uploaded usage file (.xls or .csv).  The `ByBillingPeriod` value can be applied for all charge models. The `ByUsageStartDate`, `ByUsageRecord`, and `ByUsageUpload` values can only be applied for per unit, volume pricing, and tiered pricing charge models. Use this field only for Usage charges. One-Time Charges and Recurring Charges return `NULL`. 
   * @return ratingGroup
  **/
  @ApiModelProperty(example = "null", value = "Specifies a rating group based on which usage records are rated. See [Usages Rating by Group](https://knowledgecenter.zuora.com/CB_Billing/J_Billing_Operations/Usage/Usage_Rating_by_Group) for more information.  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  Values:  * `ByBillingPeriod` (default): The rating is based on all the usages in a billing period.        * `ByUsageStartDate`: The rating is based on all the usages on the same usage start date.  * `ByUsageRecord`: The rating is based on each usage record. * `ByUsageUpload`: The rating is based on all the usages in a uploaded usage file (.xls or .csv).  The `ByBillingPeriod` value can be applied for all charge models. The `ByUsageStartDate`, `ByUsageRecord`, and `ByUsageUpload` values can only be applied for per unit, volume pricing, and tiered pricing charge models. Use this field only for Usage charges. One-Time Charges and Recurring Charges return `NULL`. ")
  public String getRatingGroup() {
    return ratingGroup;
  }

  public void setRatingGroup(String ratingGroup) {
    this.ratingGroup = ratingGroup;
  }

  public PUTScAddType specificBillingPeriod(Long specificBillingPeriod) {
    this.specificBillingPeriod = specificBillingPeriod;
    return this;
  }

   /**
   * Specifies the number of month or week for the charges billing period. Required if you set the value of the `billingPeriod` field to `Specific_Months` or `Specific_Weeks`.  Available for the following charge types:  * Recurring * Usage-based 
   * @return specificBillingPeriod
  **/
  @ApiModelProperty(example = "null", value = "Specifies the number of month or week for the charges billing period. Required if you set the value of the `billingPeriod` field to `Specific_Months` or `Specific_Weeks`.  Available for the following charge types:  * Recurring * Usage-based ")
  public Long getSpecificBillingPeriod() {
    return specificBillingPeriod;
  }

  public void setSpecificBillingPeriod(Long specificBillingPeriod) {
    this.specificBillingPeriod = specificBillingPeriod;
  }

  public PUTScAddType specificEndDate(LocalDate specificEndDate) {
    this.specificEndDate = specificEndDate;
    return this;
  }

   /**
   * Defines when the charge ends after the charge trigger date.  This field is only applicable when the `endDateCondition` field is set to `Specific_End_Date`.  If the subscription ends before the specific end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the specific end date. 
   * @return specificEndDate
  **/
  @ApiModelProperty(example = "null", value = "Defines when the charge ends after the charge trigger date.  This field is only applicable when the `endDateCondition` field is set to `Specific_End_Date`.  If the subscription ends before the specific end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the specific end date. ")
  public LocalDate getSpecificEndDate() {
    return specificEndDate;
  }

  public void setSpecificEndDate(LocalDate specificEndDate) {
    this.specificEndDate = specificEndDate;
  }

  public PUTScAddType tiers(List<POSTTierType> tiers) {
    this.tiers = tiers;
    return this;
  }

  public PUTScAddType addTiersItem(POSTTierType tiersItem) {
    this.tiers.add(tiersItem);
    return this;
  }

   /**
   * Container for Volume, Tiered or Tiered with Overage charge models. Supports the following charge types:  * One-time * Recurring * Usage-based 
   * @return tiers
  **/
  @ApiModelProperty(example = "null", value = "Container for Volume, Tiered or Tiered with Overage charge models. Supports the following charge types:  * One-time * Recurring * Usage-based ")
  public List<POSTTierType> getTiers() {
    return tiers;
  }

  public void setTiers(List<POSTTierType> tiers) {
    this.tiers = tiers;
  }

  public PUTScAddType triggerDate(LocalDate triggerDate) {
    this.triggerDate = triggerDate;
    return this;
  }

   /**
   * Specifies when to start billing the customer for the charge. Required if the `triggerEvent` field is set to `USD`. 
   * @return triggerDate
  **/
  @ApiModelProperty(example = "null", value = "Specifies when to start billing the customer for the charge. Required if the `triggerEvent` field is set to `USD`. ")
  public LocalDate getTriggerDate() {
    return triggerDate;
  }

  public void setTriggerDate(LocalDate triggerDate) {
    this.triggerDate = triggerDate;
  }

  public PUTScAddType triggerEvent(String triggerEvent) {
    this.triggerEvent = triggerEvent;
    return this;
  }

   /**
   * Specifies when to start billing the customer for the charge.  Values:  * `UCE` * `USA` * `UCA` * `USD` 
   * @return triggerEvent
  **/
  @ApiModelProperty(example = "null", value = "Specifies when to start billing the customer for the charge.  Values:  * `UCE` * `USA` * `UCA` * `USD` ")
  public String getTriggerEvent() {
    return triggerEvent;
  }

  public void setTriggerEvent(String triggerEvent) {
    this.triggerEvent = triggerEvent;
  }

  public PUTScAddType unusedUnitsCreditRates(String unusedUnitsCreditRates) {
    this.unusedUnitsCreditRates = unusedUnitsCreditRates;
    return this;
  }

   /**
   * Specifies the rate to credit a customer for unused units of usage. This field applies only for overage charge models when the `OverageUnusedUnitsCreditOption` field is set to `CreditBySpecificRate`.  Available for the following charge type for the Overage and Tiered with Overage charge models:  * Usage-based 
   * @return unusedUnitsCreditRates
  **/
  @ApiModelProperty(example = "null", value = "Specifies the rate to credit a customer for unused units of usage. This field applies only for overage charge models when the `OverageUnusedUnitsCreditOption` field is set to `CreditBySpecificRate`.  Available for the following charge type for the Overage and Tiered with Overage charge models:  * Usage-based ")
  public String getUnusedUnitsCreditRates() {
    return unusedUnitsCreditRates;
  }

  public void setUnusedUnitsCreditRates(String unusedUnitsCreditRates) {
    this.unusedUnitsCreditRates = unusedUnitsCreditRates;
  }

  public PUTScAddType upToPeriods(Long upToPeriods) {
    this.upToPeriods = upToPeriods;
    return this;
  }

   /**
   * The period type used to define when the charge ends.   Values:  * `Billing_Periods` * `Days` * `Weeks` * `Months` * `Years`  You must use this field together with the `upToPeriods` field to specify the time period.  This field is applicable only when the `endDateCondition` field is set to `Fixed_Period`.  
   * @return upToPeriods
  **/
  @ApiModelProperty(example = "null", value = "The period type used to define when the charge ends.   Values:  * `Billing_Periods` * `Days` * `Weeks` * `Months` * `Years`  You must use this field together with the `upToPeriods` field to specify the time period.  This field is applicable only when the `endDateCondition` field is set to `Fixed_Period`.  ")
  public Long getUpToPeriods() {
    return upToPeriods;
  }

  public void setUpToPeriods(Long upToPeriods) {
    this.upToPeriods = upToPeriods;
  }

  public PUTScAddType upToPeriodsType(String upToPeriodsType) {
    this.upToPeriodsType = upToPeriodsType;
    return this;
  }

   /**
   * The period type used to define when the charge ends.   Values:  * `Billing_Periods` * `Days` * `Weeks` * `Months` * `Years`  You must use this field together with the `upToPeriods` field to specify the time period.  This field is applicable only when the `endDateCondition` field is set to `Fixed_Period`.  
   * @return upToPeriodsType
  **/
  @ApiModelProperty(example = "null", value = "The period type used to define when the charge ends.   Values:  * `Billing_Periods` * `Days` * `Weeks` * `Months` * `Years`  You must use this field together with the `upToPeriods` field to specify the time period.  This field is applicable only when the `endDateCondition` field is set to `Fixed_Period`.  ")
  public String getUpToPeriodsType() {
    return upToPeriodsType;
  }

  public void setUpToPeriodsType(String upToPeriodsType) {
    this.upToPeriodsType = upToPeriodsType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PUTScAddType pUTScAddType = (PUTScAddType) o;
    return Objects.equals(this.applyDiscountTo, pUTScAddType.applyDiscountTo) &&
        Objects.equals(this.billCycleDay, pUTScAddType.billCycleDay) &&
        Objects.equals(this.billCycleType, pUTScAddType.billCycleType) &&
        Objects.equals(this.billingPeriod, pUTScAddType.billingPeriod) &&
        Objects.equals(this.billingPeriodAlignment, pUTScAddType.billingPeriodAlignment) &&
        Objects.equals(this.billingTiming, pUTScAddType.billingTiming) &&
        Objects.equals(this.customFieldC, pUTScAddType.customFieldC) &&
        Objects.equals(this.description, pUTScAddType.description) &&
        Objects.equals(this.discountAmount, pUTScAddType.discountAmount) &&
        Objects.equals(this.discountLevel, pUTScAddType.discountLevel) &&
        Objects.equals(this.discountPercentage, pUTScAddType.discountPercentage) &&
        Objects.equals(this.endDateCondition, pUTScAddType.endDateCondition) &&
        Objects.equals(this.includedUnits, pUTScAddType.includedUnits) &&
        Objects.equals(this.listPriceBase, pUTScAddType.listPriceBase) &&
        Objects.equals(this.number, pUTScAddType.number) &&
        Objects.equals(this.numberOfPeriods, pUTScAddType.numberOfPeriods) &&
        Objects.equals(this.overagePrice, pUTScAddType.overagePrice) &&
        Objects.equals(this.overageUnusedUnitsCreditOption, pUTScAddType.overageUnusedUnitsCreditOption) &&
        Objects.equals(this.price, pUTScAddType.price) &&
        Objects.equals(this.priceChangeOption, pUTScAddType.priceChangeOption) &&
        Objects.equals(this.priceIncreasePercentage, pUTScAddType.priceIncreasePercentage) &&
        Objects.equals(this.productRatePlanChargeId, pUTScAddType.productRatePlanChargeId) &&
        Objects.equals(this.quantity, pUTScAddType.quantity) &&
        Objects.equals(this.ratingGroup, pUTScAddType.ratingGroup) &&
        Objects.equals(this.specificBillingPeriod, pUTScAddType.specificBillingPeriod) &&
        Objects.equals(this.specificEndDate, pUTScAddType.specificEndDate) &&
        Objects.equals(this.tiers, pUTScAddType.tiers) &&
        Objects.equals(this.triggerDate, pUTScAddType.triggerDate) &&
        Objects.equals(this.triggerEvent, pUTScAddType.triggerEvent) &&
        Objects.equals(this.unusedUnitsCreditRates, pUTScAddType.unusedUnitsCreditRates) &&
        Objects.equals(this.upToPeriods, pUTScAddType.upToPeriods) &&
        Objects.equals(this.upToPeriodsType, pUTScAddType.upToPeriodsType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applyDiscountTo, billCycleDay, billCycleType, billingPeriod, billingPeriodAlignment, billingTiming, customFieldC, description, discountAmount, discountLevel, discountPercentage, endDateCondition, includedUnits, listPriceBase, number, numberOfPeriods, overagePrice, overageUnusedUnitsCreditOption, price, priceChangeOption, priceIncreasePercentage, productRatePlanChargeId, quantity, ratingGroup, specificBillingPeriod, specificEndDate, tiers, triggerDate, triggerEvent, unusedUnitsCreditRates, upToPeriods, upToPeriodsType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PUTScAddType {\n");
    
    sb.append("    applyDiscountTo: ").append(toIndentedString(applyDiscountTo)).append("\n");
    sb.append("    billCycleDay: ").append(toIndentedString(billCycleDay)).append("\n");
    sb.append("    billCycleType: ").append(toIndentedString(billCycleType)).append("\n");
    sb.append("    billingPeriod: ").append(toIndentedString(billingPeriod)).append("\n");
    sb.append("    billingPeriodAlignment: ").append(toIndentedString(billingPeriodAlignment)).append("\n");
    sb.append("    billingTiming: ").append(toIndentedString(billingTiming)).append("\n");
    sb.append("    customFieldC: ").append(toIndentedString(customFieldC)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    discountAmount: ").append(toIndentedString(discountAmount)).append("\n");
    sb.append("    discountLevel: ").append(toIndentedString(discountLevel)).append("\n");
    sb.append("    discountPercentage: ").append(toIndentedString(discountPercentage)).append("\n");
    sb.append("    endDateCondition: ").append(toIndentedString(endDateCondition)).append("\n");
    sb.append("    includedUnits: ").append(toIndentedString(includedUnits)).append("\n");
    sb.append("    listPriceBase: ").append(toIndentedString(listPriceBase)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    numberOfPeriods: ").append(toIndentedString(numberOfPeriods)).append("\n");
    sb.append("    overagePrice: ").append(toIndentedString(overagePrice)).append("\n");
    sb.append("    overageUnusedUnitsCreditOption: ").append(toIndentedString(overageUnusedUnitsCreditOption)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    priceChangeOption: ").append(toIndentedString(priceChangeOption)).append("\n");
    sb.append("    priceIncreasePercentage: ").append(toIndentedString(priceIncreasePercentage)).append("\n");
    sb.append("    productRatePlanChargeId: ").append(toIndentedString(productRatePlanChargeId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    ratingGroup: ").append(toIndentedString(ratingGroup)).append("\n");
    sb.append("    specificBillingPeriod: ").append(toIndentedString(specificBillingPeriod)).append("\n");
    sb.append("    specificEndDate: ").append(toIndentedString(specificEndDate)).append("\n");
    sb.append("    tiers: ").append(toIndentedString(tiers)).append("\n");
    sb.append("    triggerDate: ").append(toIndentedString(triggerDate)).append("\n");
    sb.append("    triggerEvent: ").append(toIndentedString(triggerEvent)).append("\n");
    sb.append("    unusedUnitsCreditRates: ").append(toIndentedString(unusedUnitsCreditRates)).append("\n");
    sb.append("    upToPeriods: ").append(toIndentedString(upToPeriods)).append("\n");
    sb.append("    upToPeriodsType: ").append(toIndentedString(upToPeriodsType)).append("\n");
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

