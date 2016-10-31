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
import io.swagger.client.model.GETTierType;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDate;


/**
 * GETSubscriptionRatePlanChargesType
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class GETSubscriptionRatePlanChargesType   {
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

  @SerializedName("chargedThroughDate")
  private LocalDate chargedThroughDate = null;

  @SerializedName("currency")
  private String currency = null;

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

  @SerializedName("dmrc")
  private String dmrc = null;

  @SerializedName("done")
  private Boolean done = null;

  @SerializedName("dtcv")
  private String dtcv = null;

  @SerializedName("effectiveEndDate")
  private LocalDate effectiveEndDate = null;

  @SerializedName("effectiveStartDate")
  private LocalDate effectiveStartDate = null;

  @SerializedName("endDateCondition")
  private String endDateCondition = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("includedUnits")
  private String includedUnits = null;

  @SerializedName("listPriceBase")
  private String listPriceBase = null;

  @SerializedName("model")
  private String model = null;

  @SerializedName("mrr")
  private String mrr = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("number")
  private String number = null;

  @SerializedName("numberOfPeriods")
  private Long numberOfPeriods = null;

  @SerializedName("originalChargeId")
  private String originalChargeId = null;

  @SerializedName("overageCalculationOption")
  private String overageCalculationOption = null;

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

  @SerializedName("pricingSummary")
  private String pricingSummary = null;

  @SerializedName("processedThroughDate")
  private LocalDate processedThroughDate = null;

  @SerializedName("productRatePlanChargeId")
  private String productRatePlanChargeId = null;

  @SerializedName("quantity")
  private String quantity = null;

  @SerializedName("ratingGroup")
  private String ratingGroup = null;

  @SerializedName("segment")
  private String segment = null;

  @SerializedName("smoothingModel")
  private String smoothingModel = null;

  @SerializedName("specificBillingPeriod")
  private Long specificBillingPeriod = null;

  @SerializedName("specificEndDate")
  private LocalDate specificEndDate = null;

  @SerializedName("tcv")
  private String tcv = null;

  @SerializedName("tiers")
  private List<GETTierType> tiers = new ArrayList<GETTierType>();

  @SerializedName("triggerDate")
  private LocalDate triggerDate = null;

  @SerializedName("triggerEvent")
  private String triggerEvent = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("unusedUnitsCreditRates")
  private String unusedUnitsCreditRates = null;

  @SerializedName("uom")
  private String uom = null;

  @SerializedName("upToPeriods")
  private String upToPeriods = null;

  @SerializedName("upToPeriodsType")
  private String upToPeriodsType = null;

  @SerializedName("usageRecordRatingOption")
  private String usageRecordRatingOption = null;

  @SerializedName("version")
  private Long version = null;

  public GETSubscriptionRatePlanChargesType applyDiscountTo(String applyDiscountTo) {
    this.applyDiscountTo = applyDiscountTo;
    return this;
  }

   /**
   * Specifies the type of charges a specific discount applies to.   This field is only used when applied to a discount charge model. If you are not using a discount charge model, the value is null.  Possible values:  * `RECURRING` * `USAGE` * `ONETIMERECURRING` * `ONETIMEUSAGE` * `RECURRINGUSAGE` * `ONETIMERECURRINGUSAGE` 
   * @return applyDiscountTo
  **/
  @ApiModelProperty(example = "null", value = "Specifies the type of charges a specific discount applies to.   This field is only used when applied to a discount charge model. If you are not using a discount charge model, the value is null.  Possible values:  * `RECURRING` * `USAGE` * `ONETIMERECURRING` * `ONETIMEUSAGE` * `RECURRINGUSAGE` * `ONETIMERECURRINGUSAGE` ")
  public String getApplyDiscountTo() {
    return applyDiscountTo;
  }

  public void setApplyDiscountTo(String applyDiscountTo) {
    this.applyDiscountTo = applyDiscountTo;
  }

  public GETSubscriptionRatePlanChargesType billingDay(String billingDay) {
    this.billingDay = billingDay;
    return this;
  }

   /**
   * Billing cycle day (BCD), which is when bill runs generate invoices for charges associated with the product rate plan charge or the account.    Values:  * `DefaultFromCustomer` * `SpecificDayofMonth(#)` * `SubscriptionStartDay` * `ChargeTriggerDay` * `SpecificDayOfWeek/dayofweek`: in which dayofweek is the day in the week you define your billing periods to start.  In the response data, a day-of-the-month value (`1`-`31`) appears in place of the hash sign above (\"#\"). If this value exceeds the number of days in a particular month, the last day of the month is used as the BCD. 
   * @return billingDay
  **/
  @ApiModelProperty(example = "null", value = "Billing cycle day (BCD), which is when bill runs generate invoices for charges associated with the product rate plan charge or the account.    Values:  * `DefaultFromCustomer` * `SpecificDayofMonth(#)` * `SubscriptionStartDay` * `ChargeTriggerDay` * `SpecificDayOfWeek/dayofweek`: in which dayofweek is the day in the week you define your billing periods to start.  In the response data, a day-of-the-month value (`1`-`31`) appears in place of the hash sign above (\"#\"). If this value exceeds the number of days in a particular month, the last day of the month is used as the BCD. ")
  public String getBillingDay() {
    return billingDay;
  }

  public void setBillingDay(String billingDay) {
    this.billingDay = billingDay;
  }

  public GETSubscriptionRatePlanChargesType billingPeriod(String billingPeriod) {
    this.billingPeriod = billingPeriod;
    return this;
  }

   /**
   * Allows billing period to be overridden on the rate plan charge. 
   * @return billingPeriod
  **/
  @ApiModelProperty(example = "null", value = "Allows billing period to be overridden on the rate plan charge. ")
  public String getBillingPeriod() {
    return billingPeriod;
  }

  public void setBillingPeriod(String billingPeriod) {
    this.billingPeriod = billingPeriod;
  }

  public GETSubscriptionRatePlanChargesType billingPeriodAlignment(String billingPeriodAlignment) {
    this.billingPeriodAlignment = billingPeriodAlignment;
    return this;
  }

   /**
   * Possible values:  * `AlignToCharge` * `AlignToSubscriptionStart` * `AlignToTermStart` 
   * @return billingPeriodAlignment
  **/
  @ApiModelProperty(example = "null", value = "Possible values:  * `AlignToCharge` * `AlignToSubscriptionStart` * `AlignToTermStart` ")
  public String getBillingPeriodAlignment() {
    return billingPeriodAlignment;
  }

  public void setBillingPeriodAlignment(String billingPeriodAlignment) {
    this.billingPeriodAlignment = billingPeriodAlignment;
  }

  public GETSubscriptionRatePlanChargesType billingTiming(String billingTiming) {
    this.billingTiming = billingTiming;
    return this;
  }

   /**
   * The billing timing for the charge. This field is only used if the `ratePlanChargeType` value is `Recurring`.  Possible values are:  * `In Advance` * `In Arrears`  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/). 
   * @return billingTiming
  **/
  @ApiModelProperty(example = "null", value = "The billing timing for the charge. This field is only used if the `ratePlanChargeType` value is `Recurring`.  Possible values are:  * `In Advance` * `In Arrears`  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/). ")
  public String getBillingTiming() {
    return billingTiming;
  }

  public void setBillingTiming(String billingTiming) {
    this.billingTiming = billingTiming;
  }

  public GETSubscriptionRatePlanChargesType chargedThroughDate(LocalDate chargedThroughDate) {
    this.chargedThroughDate = chargedThroughDate;
    return this;
  }

   /**
   * The date through which a customer has been billed for the charge. 
   * @return chargedThroughDate
  **/
  @ApiModelProperty(example = "null", value = "The date through which a customer has been billed for the charge. ")
  public LocalDate getChargedThroughDate() {
    return chargedThroughDate;
  }

  public void setChargedThroughDate(LocalDate chargedThroughDate) {
    this.chargedThroughDate = chargedThroughDate;
  }

  public GETSubscriptionRatePlanChargesType currency(String currency) {
    this.currency = currency;
    return this;
  }

   /**
   * Currency used by the account. For example, `USD` or `EUR`. 
   * @return currency
  **/
  @ApiModelProperty(example = "null", value = "Currency used by the account. For example, `USD` or `EUR`. ")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public GETSubscriptionRatePlanChargesType customFieldC(String customFieldC) {
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

  public GETSubscriptionRatePlanChargesType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description of the rate plan charge. 
   * @return description
  **/
  @ApiModelProperty(example = "null", value = "Description of the rate plan charge. ")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public GETSubscriptionRatePlanChargesType discountAmount(String discountAmount) {
    this.discountAmount = discountAmount;
    return this;
  }

   /**
   * The amount of the discount. 
   * @return discountAmount
  **/
  @ApiModelProperty(example = "null", value = "The amount of the discount. ")
  public String getDiscountAmount() {
    return discountAmount;
  }

  public void setDiscountAmount(String discountAmount) {
    this.discountAmount = discountAmount;
  }

  public GETSubscriptionRatePlanChargesType discountLevel(String discountLevel) {
    this.discountLevel = discountLevel;
    return this;
  }

   /**
   * The level of the discount. Values: `RatePlan`, `Subscription`, `Account`. 
   * @return discountLevel
  **/
  @ApiModelProperty(example = "null", value = "The level of the discount. Values: `RatePlan`, `Subscription`, `Account`. ")
  public String getDiscountLevel() {
    return discountLevel;
  }

  public void setDiscountLevel(String discountLevel) {
    this.discountLevel = discountLevel;
  }

  public GETSubscriptionRatePlanChargesType discountPercentage(String discountPercentage) {
    this.discountPercentage = discountPercentage;
    return this;
  }

   /**
   * The amount of the discount as a percentage. 
   * @return discountPercentage
  **/
  @ApiModelProperty(example = "null", value = "The amount of the discount as a percentage. ")
  public String getDiscountPercentage() {
    return discountPercentage;
  }

  public void setDiscountPercentage(String discountPercentage) {
    this.discountPercentage = discountPercentage;
  }

  public GETSubscriptionRatePlanChargesType dmrc(String dmrc) {
    this.dmrc = dmrc;
    return this;
  }

   /**
   * The change (delta) of monthly recurring charge exists when the change in monthly recurring revenue caused by an amendment or a new subscription. 
   * @return dmrc
  **/
  @ApiModelProperty(example = "null", value = "The change (delta) of monthly recurring charge exists when the change in monthly recurring revenue caused by an amendment or a new subscription. ")
  public String getDmrc() {
    return dmrc;
  }

  public void setDmrc(String dmrc) {
    this.dmrc = dmrc;
  }

  public GETSubscriptionRatePlanChargesType done(Boolean done) {
    this.done = done;
    return this;
  }

   /**
   * A value of `true` indicates that an invoice for a charge segment has been completed. A value of `false` indicates that an invoice has not bee completed for the charge segment. 
   * @return done
  **/
  @ApiModelProperty(example = "null", value = "A value of `true` indicates that an invoice for a charge segment has been completed. A value of `false` indicates that an invoice has not bee completed for the charge segment. ")
  public Boolean getDone() {
    return done;
  }

  public void setDone(Boolean done) {
    this.done = done;
  }

  public GETSubscriptionRatePlanChargesType dtcv(String dtcv) {
    this.dtcv = dtcv;
    return this;
  }

   /**
   * After an amendment or an AutomatedPriceChange event, `dtcv` displays the change (delta) for the total contract value (TCV) amount for this charge, compared with its previous value with recurring charge types. 
   * @return dtcv
  **/
  @ApiModelProperty(example = "null", value = "After an amendment or an AutomatedPriceChange event, `dtcv` displays the change (delta) for the total contract value (TCV) amount for this charge, compared with its previous value with recurring charge types. ")
  public String getDtcv() {
    return dtcv;
  }

  public void setDtcv(String dtcv) {
    this.dtcv = dtcv;
  }

  public GETSubscriptionRatePlanChargesType effectiveEndDate(LocalDate effectiveEndDate) {
    this.effectiveEndDate = effectiveEndDate;
    return this;
  }

   /**
   * The effective end date of the rate plan charge. 
   * @return effectiveEndDate
  **/
  @ApiModelProperty(example = "null", value = "The effective end date of the rate plan charge. ")
  public LocalDate getEffectiveEndDate() {
    return effectiveEndDate;
  }

  public void setEffectiveEndDate(LocalDate effectiveEndDate) {
    this.effectiveEndDate = effectiveEndDate;
  }

  public GETSubscriptionRatePlanChargesType effectiveStartDate(LocalDate effectiveStartDate) {
    this.effectiveStartDate = effectiveStartDate;
    return this;
  }

   /**
   * The effective start date of the rate plan charge. 
   * @return effectiveStartDate
  **/
  @ApiModelProperty(example = "null", value = "The effective start date of the rate plan charge. ")
  public LocalDate getEffectiveStartDate() {
    return effectiveStartDate;
  }

  public void setEffectiveStartDate(LocalDate effectiveStartDate) {
    this.effectiveStartDate = effectiveStartDate;
  }

  public GETSubscriptionRatePlanChargesType endDateCondition(String endDateCondition) {
    this.endDateCondition = endDateCondition;
    return this;
  }

   /**
   * Defines when the charge ends after the charge trigger date.  If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date.  Values:  * `Subscription_End` * `Fixed_Period` * `Specific_End_Date` 
   * @return endDateCondition
  **/
  @ApiModelProperty(example = "null", value = "Defines when the charge ends after the charge trigger date.  If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date.  Values:  * `Subscription_End` * `Fixed_Period` * `Specific_End_Date` ")
  public String getEndDateCondition() {
    return endDateCondition;
  }

  public void setEndDateCondition(String endDateCondition) {
    this.endDateCondition = endDateCondition;
  }

  public GETSubscriptionRatePlanChargesType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Rate plan charge ID. 
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "Rate plan charge ID. ")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GETSubscriptionRatePlanChargesType includedUnits(String includedUnits) {
    this.includedUnits = includedUnits;
    return this;
  }

   /**
   * Specifies the number of units in the base set of units. 
   * @return includedUnits
  **/
  @ApiModelProperty(example = "null", value = "Specifies the number of units in the base set of units. ")
  public String getIncludedUnits() {
    return includedUnits;
  }

  public void setIncludedUnits(String includedUnits) {
    this.includedUnits = includedUnits;
  }

  public GETSubscriptionRatePlanChargesType listPriceBase(String listPriceBase) {
    this.listPriceBase = listPriceBase;
    return this;
  }

   /**
   * List price base; possible values are:  * `Per_Billing_Period` * `Per_Month` * `Per_Week` 
   * @return listPriceBase
  **/
  @ApiModelProperty(example = "null", value = "List price base; possible values are:  * `Per_Billing_Period` * `Per_Month` * `Per_Week` ")
  public String getListPriceBase() {
    return listPriceBase;
  }

  public void setListPriceBase(String listPriceBase) {
    this.listPriceBase = listPriceBase;
  }

  public GETSubscriptionRatePlanChargesType model(String model) {
    this.model = model;
    return this;
  }

   /**
   * Charge model; possible values are:  * `FlatFee` * `PerUnit` * `Overage` * `Volume` * `Tiered` * `TieredWithOverage` * `DiscountFixedAmount` * `DiscountPercentage` 
   * @return model
  **/
  @ApiModelProperty(example = "null", value = "Charge model; possible values are:  * `FlatFee` * `PerUnit` * `Overage` * `Volume` * `Tiered` * `TieredWithOverage` * `DiscountFixedAmount` * `DiscountPercentage` ")
  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public GETSubscriptionRatePlanChargesType mrr(String mrr) {
    this.mrr = mrr;
    return this;
  }

   /**
   * Monthly recurring revenue of the rate plan charge. 
   * @return mrr
  **/
  @ApiModelProperty(example = "null", value = "Monthly recurring revenue of the rate plan charge. ")
  public String getMrr() {
    return mrr;
  }

  public void setMrr(String mrr) {
    this.mrr = mrr;
  }

  public GETSubscriptionRatePlanChargesType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Charge name. 
   * @return name
  **/
  @ApiModelProperty(example = "null", value = "Charge name. ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GETSubscriptionRatePlanChargesType number(String number) {
    this.number = number;
    return this;
  }

   /**
   * Charge number. 
   * @return number
  **/
  @ApiModelProperty(example = "null", value = "Charge number. ")
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public GETSubscriptionRatePlanChargesType numberOfPeriods(Long numberOfPeriods) {
    this.numberOfPeriods = numberOfPeriods;
    return this;
  }

   /**
   * Specifies the number of periods to use when calculating charges in an overage smoothing charge model. 
   * @return numberOfPeriods
  **/
  @ApiModelProperty(example = "null", value = "Specifies the number of periods to use when calculating charges in an overage smoothing charge model. ")
  public Long getNumberOfPeriods() {
    return numberOfPeriods;
  }

  public void setNumberOfPeriods(Long numberOfPeriods) {
    this.numberOfPeriods = numberOfPeriods;
  }

  public GETSubscriptionRatePlanChargesType originalChargeId(String originalChargeId) {
    this.originalChargeId = originalChargeId;
    return this;
  }

   /**
   * The original ID of the rate plan charge. 
   * @return originalChargeId
  **/
  @ApiModelProperty(example = "null", value = "The original ID of the rate plan charge. ")
  public String getOriginalChargeId() {
    return originalChargeId;
  }

  public void setOriginalChargeId(String originalChargeId) {
    this.originalChargeId = originalChargeId;
  }

  public GETSubscriptionRatePlanChargesType overageCalculationOption(String overageCalculationOption) {
    this.overageCalculationOption = overageCalculationOption;
    return this;
  }

   /**
   * Determines when to calculate overage charges. 
   * @return overageCalculationOption
  **/
  @ApiModelProperty(example = "null", value = "Determines when to calculate overage charges. ")
  public String getOverageCalculationOption() {
    return overageCalculationOption;
  }

  public void setOverageCalculationOption(String overageCalculationOption) {
    this.overageCalculationOption = overageCalculationOption;
  }

  public GETSubscriptionRatePlanChargesType overagePrice(String overagePrice) {
    this.overagePrice = overagePrice;
    return this;
  }

   /**
   * The price for units over the allowed amount. 
   * @return overagePrice
  **/
  @ApiModelProperty(example = "null", value = "The price for units over the allowed amount. ")
  public String getOveragePrice() {
    return overagePrice;
  }

  public void setOveragePrice(String overagePrice) {
    this.overagePrice = overagePrice;
  }

  public GETSubscriptionRatePlanChargesType overageUnusedUnitsCreditOption(String overageUnusedUnitsCreditOption) {
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
    return this;
  }

   /**
   * Determines whether to credit the customer with unused units of usage. 
   * @return overageUnusedUnitsCreditOption
  **/
  @ApiModelProperty(example = "null", value = "Determines whether to credit the customer with unused units of usage. ")
  public String getOverageUnusedUnitsCreditOption() {
    return overageUnusedUnitsCreditOption;
  }

  public void setOverageUnusedUnitsCreditOption(String overageUnusedUnitsCreditOption) {
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
  }

  public GETSubscriptionRatePlanChargesType price(String price) {
    this.price = price;
    return this;
  }

   /**
   * The price associated with the rate plan charge expressed as a decimal. 
   * @return price
  **/
  @ApiModelProperty(example = "null", value = "The price associated with the rate plan charge expressed as a decimal. ")
  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public GETSubscriptionRatePlanChargesType priceChangeOption(String priceChangeOption) {
    this.priceChangeOption = priceChangeOption;
    return this;
  }

   /**
   * When the following is true:  1. AutomatedPriceChange setting is on  2. Charge type is not one-time  3. Charge model is not discount percentage  Then an automatic price change can have a value for when a termed subscription is renewed.   Values (one of the following):  * `NoChange` (default) * `SpecificPercentageValue` * `UseLatestProductCatalogPricing` 
   * @return priceChangeOption
  **/
  @ApiModelProperty(example = "null", value = "When the following is true:  1. AutomatedPriceChange setting is on  2. Charge type is not one-time  3. Charge model is not discount percentage  Then an automatic price change can have a value for when a termed subscription is renewed.   Values (one of the following):  * `NoChange` (default) * `SpecificPercentageValue` * `UseLatestProductCatalogPricing` ")
  public String getPriceChangeOption() {
    return priceChangeOption;
  }

  public void setPriceChangeOption(String priceChangeOption) {
    this.priceChangeOption = priceChangeOption;
  }

  public GETSubscriptionRatePlanChargesType priceIncreasePercentage(String priceIncreasePercentage) {
    this.priceIncreasePercentage = priceIncreasePercentage;
    return this;
  }

   /**
   * A planned future price increase amount as a percentage. 
   * @return priceIncreasePercentage
  **/
  @ApiModelProperty(example = "null", value = "A planned future price increase amount as a percentage. ")
  public String getPriceIncreasePercentage() {
    return priceIncreasePercentage;
  }

  public void setPriceIncreasePercentage(String priceIncreasePercentage) {
    this.priceIncreasePercentage = priceIncreasePercentage;
  }

  public GETSubscriptionRatePlanChargesType pricingSummary(String pricingSummary) {
    this.pricingSummary = pricingSummary;
    return this;
  }

   /**
   * Concise description of rate plan charge model. 
   * @return pricingSummary
  **/
  @ApiModelProperty(example = "null", value = "Concise description of rate plan charge model. ")
  public String getPricingSummary() {
    return pricingSummary;
  }

  public void setPricingSummary(String pricingSummary) {
    this.pricingSummary = pricingSummary;
  }

  public GETSubscriptionRatePlanChargesType processedThroughDate(LocalDate processedThroughDate) {
    this.processedThroughDate = processedThroughDate;
    return this;
  }

   /**
   * The date until when charges have been processed. When billing in arrears, such as usage, this field value is the the same as the `ChargedThroughDate` value. This date is the earliest date when a charge can be amended. 
   * @return processedThroughDate
  **/
  @ApiModelProperty(example = "null", value = "The date until when charges have been processed. When billing in arrears, such as usage, this field value is the the same as the `ChargedThroughDate` value. This date is the earliest date when a charge can be amended. ")
  public LocalDate getProcessedThroughDate() {
    return processedThroughDate;
  }

  public void setProcessedThroughDate(LocalDate processedThroughDate) {
    this.processedThroughDate = processedThroughDate;
  }

  public GETSubscriptionRatePlanChargesType productRatePlanChargeId(String productRatePlanChargeId) {
    this.productRatePlanChargeId = productRatePlanChargeId;
    return this;
  }

   /**
   * 
   * @return productRatePlanChargeId
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getProductRatePlanChargeId() {
    return productRatePlanChargeId;
  }

  public void setProductRatePlanChargeId(String productRatePlanChargeId) {
    this.productRatePlanChargeId = productRatePlanChargeId;
  }

  public GETSubscriptionRatePlanChargesType quantity(String quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * The quantity of units, such as the number of authors in a hosted wiki service. Valid for all charge models except for Flat Fee pricing. 
   * @return quantity
  **/
  @ApiModelProperty(example = "null", value = "The quantity of units, such as the number of authors in a hosted wiki service. Valid for all charge models except for Flat Fee pricing. ")
  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public GETSubscriptionRatePlanChargesType ratingGroup(String ratingGroup) {
    this.ratingGroup = ratingGroup;
    return this;
  }

   /**
   * Specifies a rating group based on which usage records are rated.   Possible values are:  * `ByBillingPeriod` (default) * `ByUsageStartDate` * `ByUsageRecord` * `ByUsageUpload`  **Note:** This field is only used for per unit, volume pricing, and tiered pricing charge models. Use this field only for Usage charges. One-Time Charges and Recurring Charges return `NULL`.  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/). 
   * @return ratingGroup
  **/
  @ApiModelProperty(example = "null", value = "Specifies a rating group based on which usage records are rated.   Possible values are:  * `ByBillingPeriod` (default) * `ByUsageStartDate` * `ByUsageRecord` * `ByUsageUpload`  **Note:** This field is only used for per unit, volume pricing, and tiered pricing charge models. Use this field only for Usage charges. One-Time Charges and Recurring Charges return `NULL`.  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/). ")
  public String getRatingGroup() {
    return ratingGroup;
  }

  public void setRatingGroup(String ratingGroup) {
    this.ratingGroup = ratingGroup;
  }

  public GETSubscriptionRatePlanChargesType segment(String segment) {
    this.segment = segment;
    return this;
  }

   /**
   * The identifying number of the subscription rate plan segment. Segments are numbered sequentially, starting with 1. 
   * @return segment
  **/
  @ApiModelProperty(example = "null", value = "The identifying number of the subscription rate plan segment. Segments are numbered sequentially, starting with 1. ")
  public String getSegment() {
    return segment;
  }

  public void setSegment(String segment) {
    this.segment = segment;
  }

  public GETSubscriptionRatePlanChargesType smoothingModel(String smoothingModel) {
    this.smoothingModel = smoothingModel;
    return this;
  }

   /**
   * Specifies when revenue recognition begins. When charge model is `Overage` or `TieredWithOverage`, `smoothingModel` will be one of the following values:  * `ContractEffectiveDate` * `ServiceActivationDate` * `CustomerAcceptanceDate` 
   * @return smoothingModel
  **/
  @ApiModelProperty(example = "null", value = "Specifies when revenue recognition begins. When charge model is `Overage` or `TieredWithOverage`, `smoothingModel` will be one of the following values:  * `ContractEffectiveDate` * `ServiceActivationDate` * `CustomerAcceptanceDate` ")
  public String getSmoothingModel() {
    return smoothingModel;
  }

  public void setSmoothingModel(String smoothingModel) {
    this.smoothingModel = smoothingModel;
  }

  public GETSubscriptionRatePlanChargesType specificBillingPeriod(Long specificBillingPeriod) {
    this.specificBillingPeriod = specificBillingPeriod;
    return this;
  }

   /**
   * Customizes the number of month or week for the charges billing period. This field is required if you set the value of the `BillingPeriod` field to `Specific_Months` or `Specific_Weeks`. 
   * @return specificBillingPeriod
  **/
  @ApiModelProperty(example = "null", value = "Customizes the number of month or week for the charges billing period. This field is required if you set the value of the `BillingPeriod` field to `Specific_Months` or `Specific_Weeks`. ")
  public Long getSpecificBillingPeriod() {
    return specificBillingPeriod;
  }

  public void setSpecificBillingPeriod(Long specificBillingPeriod) {
    this.specificBillingPeriod = specificBillingPeriod;
  }

  public GETSubscriptionRatePlanChargesType specificEndDate(LocalDate specificEndDate) {
    this.specificEndDate = specificEndDate;
    return this;
  }

   /**
   * The specific date on which the charge ends. If the subscription ends before the specific end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the specific end date. 
   * @return specificEndDate
  **/
  @ApiModelProperty(example = "null", value = "The specific date on which the charge ends. If the subscription ends before the specific end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the specific end date. ")
  public LocalDate getSpecificEndDate() {
    return specificEndDate;
  }

  public void setSpecificEndDate(LocalDate specificEndDate) {
    this.specificEndDate = specificEndDate;
  }

  public GETSubscriptionRatePlanChargesType tcv(String tcv) {
    this.tcv = tcv;
    return this;
  }

   /**
   * The total contract value. 
   * @return tcv
  **/
  @ApiModelProperty(example = "null", value = "The total contract value. ")
  public String getTcv() {
    return tcv;
  }

  public void setTcv(String tcv) {
    this.tcv = tcv;
  }

  public GETSubscriptionRatePlanChargesType tiers(List<GETTierType> tiers) {
    this.tiers = tiers;
    return this;
  }

  public GETSubscriptionRatePlanChargesType addTiersItem(GETTierType tiersItem) {
    this.tiers.add(tiersItem);
    return this;
  }

   /**
   * One or many defined ranges with distinct pricing. 
   * @return tiers
  **/
  @ApiModelProperty(example = "null", value = "One or many defined ranges with distinct pricing. ")
  public List<GETTierType> getTiers() {
    return tiers;
  }

  public void setTiers(List<GETTierType> tiers) {
    this.tiers = tiers;
  }

  public GETSubscriptionRatePlanChargesType triggerDate(LocalDate triggerDate) {
    this.triggerDate = triggerDate;
    return this;
  }

   /**
   * The date that the rate plan charge will be triggered. 
   * @return triggerDate
  **/
  @ApiModelProperty(example = "null", value = "The date that the rate plan charge will be triggered. ")
  public LocalDate getTriggerDate() {
    return triggerDate;
  }

  public void setTriggerDate(LocalDate triggerDate) {
    this.triggerDate = triggerDate;
  }

  public GETSubscriptionRatePlanChargesType triggerEvent(String triggerEvent) {
    this.triggerEvent = triggerEvent;
    return this;
  }

   /**
   * The event that will cause the rate plan charge to be triggered.  Possible values:   * `ContractEffective` * `ServiceActivation` * `CustomerAcceptance` * `SpecificDate` 
   * @return triggerEvent
  **/
  @ApiModelProperty(example = "null", value = "The event that will cause the rate plan charge to be triggered.  Possible values:   * `ContractEffective` * `ServiceActivation` * `CustomerAcceptance` * `SpecificDate` ")
  public String getTriggerEvent() {
    return triggerEvent;
  }

  public void setTriggerEvent(String triggerEvent) {
    this.triggerEvent = triggerEvent;
  }

  public GETSubscriptionRatePlanChargesType type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Charge type. Possible values are: `OneTime`, `Recurring`, `Usage`. 
   * @return type
  **/
  @ApiModelProperty(example = "null", value = "Charge type. Possible values are: `OneTime`, `Recurring`, `Usage`. ")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public GETSubscriptionRatePlanChargesType unusedUnitsCreditRates(String unusedUnitsCreditRates) {
    this.unusedUnitsCreditRates = unusedUnitsCreditRates;
    return this;
  }

   /**
   * Specifies the rate to credit a customer for unused units of usage. This field is applicable only for overage charge models when the  `OverageUnusedUnitsCreditOption` field value is `CreditBySpecificRate`. 
   * @return unusedUnitsCreditRates
  **/
  @ApiModelProperty(example = "null", value = "Specifies the rate to credit a customer for unused units of usage. This field is applicable only for overage charge models when the  `OverageUnusedUnitsCreditOption` field value is `CreditBySpecificRate`. ")
  public String getUnusedUnitsCreditRates() {
    return unusedUnitsCreditRates;
  }

  public void setUnusedUnitsCreditRates(String unusedUnitsCreditRates) {
    this.unusedUnitsCreditRates = unusedUnitsCreditRates;
  }

  public GETSubscriptionRatePlanChargesType uom(String uom) {
    this.uom = uom;
    return this;
  }

   /**
   * Specifies the units to measure usage.  
   * @return uom
  **/
  @ApiModelProperty(example = "null", value = "Specifies the units to measure usage.  ")
  public String getUom() {
    return uom;
  }

  public void setUom(String uom) {
    this.uom = uom;
  }

  public GETSubscriptionRatePlanChargesType upToPeriods(String upToPeriods) {
    this.upToPeriods = upToPeriods;
    return this;
  }

   /**
   * Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends.  If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end. 
   * @return upToPeriods
  **/
  @ApiModelProperty(example = "null", value = "Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends.  If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end. ")
  public String getUpToPeriods() {
    return upToPeriods;
  }

  public void setUpToPeriods(String upToPeriods) {
    this.upToPeriods = upToPeriods;
  }

  public GETSubscriptionRatePlanChargesType upToPeriodsType(String upToPeriodsType) {
    this.upToPeriodsType = upToPeriodsType;
    return this;
  }

   /**
   * The period type used to define when the charge ends.   Values:  * `Billing_Periods` * `Days` * `Weeks` * `Months` * `Years` 
   * @return upToPeriodsType
  **/
  @ApiModelProperty(example = "null", value = "The period type used to define when the charge ends.   Values:  * `Billing_Periods` * `Days` * `Weeks` * `Months` * `Years` ")
  public String getUpToPeriodsType() {
    return upToPeriodsType;
  }

  public void setUpToPeriodsType(String upToPeriodsType) {
    this.upToPeriodsType = upToPeriodsType;
  }

  public GETSubscriptionRatePlanChargesType usageRecordRatingOption(String usageRecordRatingOption) {
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

  public GETSubscriptionRatePlanChargesType version(Long version) {
    this.version = version;
    return this;
  }

   /**
   * Rate plan charge revision number. 
   * @return version
  **/
  @ApiModelProperty(example = "null", value = "Rate plan charge revision number. ")
  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GETSubscriptionRatePlanChargesType gETSubscriptionRatePlanChargesType = (GETSubscriptionRatePlanChargesType) o;
    return Objects.equals(this.applyDiscountTo, gETSubscriptionRatePlanChargesType.applyDiscountTo) &&
        Objects.equals(this.billingDay, gETSubscriptionRatePlanChargesType.billingDay) &&
        Objects.equals(this.billingPeriod, gETSubscriptionRatePlanChargesType.billingPeriod) &&
        Objects.equals(this.billingPeriodAlignment, gETSubscriptionRatePlanChargesType.billingPeriodAlignment) &&
        Objects.equals(this.billingTiming, gETSubscriptionRatePlanChargesType.billingTiming) &&
        Objects.equals(this.chargedThroughDate, gETSubscriptionRatePlanChargesType.chargedThroughDate) &&
        Objects.equals(this.currency, gETSubscriptionRatePlanChargesType.currency) &&
        Objects.equals(this.customFieldC, gETSubscriptionRatePlanChargesType.customFieldC) &&
        Objects.equals(this.description, gETSubscriptionRatePlanChargesType.description) &&
        Objects.equals(this.discountAmount, gETSubscriptionRatePlanChargesType.discountAmount) &&
        Objects.equals(this.discountLevel, gETSubscriptionRatePlanChargesType.discountLevel) &&
        Objects.equals(this.discountPercentage, gETSubscriptionRatePlanChargesType.discountPercentage) &&
        Objects.equals(this.dmrc, gETSubscriptionRatePlanChargesType.dmrc) &&
        Objects.equals(this.done, gETSubscriptionRatePlanChargesType.done) &&
        Objects.equals(this.dtcv, gETSubscriptionRatePlanChargesType.dtcv) &&
        Objects.equals(this.effectiveEndDate, gETSubscriptionRatePlanChargesType.effectiveEndDate) &&
        Objects.equals(this.effectiveStartDate, gETSubscriptionRatePlanChargesType.effectiveStartDate) &&
        Objects.equals(this.endDateCondition, gETSubscriptionRatePlanChargesType.endDateCondition) &&
        Objects.equals(this.id, gETSubscriptionRatePlanChargesType.id) &&
        Objects.equals(this.includedUnits, gETSubscriptionRatePlanChargesType.includedUnits) &&
        Objects.equals(this.listPriceBase, gETSubscriptionRatePlanChargesType.listPriceBase) &&
        Objects.equals(this.model, gETSubscriptionRatePlanChargesType.model) &&
        Objects.equals(this.mrr, gETSubscriptionRatePlanChargesType.mrr) &&
        Objects.equals(this.name, gETSubscriptionRatePlanChargesType.name) &&
        Objects.equals(this.number, gETSubscriptionRatePlanChargesType.number) &&
        Objects.equals(this.numberOfPeriods, gETSubscriptionRatePlanChargesType.numberOfPeriods) &&
        Objects.equals(this.originalChargeId, gETSubscriptionRatePlanChargesType.originalChargeId) &&
        Objects.equals(this.overageCalculationOption, gETSubscriptionRatePlanChargesType.overageCalculationOption) &&
        Objects.equals(this.overagePrice, gETSubscriptionRatePlanChargesType.overagePrice) &&
        Objects.equals(this.overageUnusedUnitsCreditOption, gETSubscriptionRatePlanChargesType.overageUnusedUnitsCreditOption) &&
        Objects.equals(this.price, gETSubscriptionRatePlanChargesType.price) &&
        Objects.equals(this.priceChangeOption, gETSubscriptionRatePlanChargesType.priceChangeOption) &&
        Objects.equals(this.priceIncreasePercentage, gETSubscriptionRatePlanChargesType.priceIncreasePercentage) &&
        Objects.equals(this.pricingSummary, gETSubscriptionRatePlanChargesType.pricingSummary) &&
        Objects.equals(this.processedThroughDate, gETSubscriptionRatePlanChargesType.processedThroughDate) &&
        Objects.equals(this.productRatePlanChargeId, gETSubscriptionRatePlanChargesType.productRatePlanChargeId) &&
        Objects.equals(this.quantity, gETSubscriptionRatePlanChargesType.quantity) &&
        Objects.equals(this.ratingGroup, gETSubscriptionRatePlanChargesType.ratingGroup) &&
        Objects.equals(this.segment, gETSubscriptionRatePlanChargesType.segment) &&
        Objects.equals(this.smoothingModel, gETSubscriptionRatePlanChargesType.smoothingModel) &&
        Objects.equals(this.specificBillingPeriod, gETSubscriptionRatePlanChargesType.specificBillingPeriod) &&
        Objects.equals(this.specificEndDate, gETSubscriptionRatePlanChargesType.specificEndDate) &&
        Objects.equals(this.tcv, gETSubscriptionRatePlanChargesType.tcv) &&
        Objects.equals(this.tiers, gETSubscriptionRatePlanChargesType.tiers) &&
        Objects.equals(this.triggerDate, gETSubscriptionRatePlanChargesType.triggerDate) &&
        Objects.equals(this.triggerEvent, gETSubscriptionRatePlanChargesType.triggerEvent) &&
        Objects.equals(this.type, gETSubscriptionRatePlanChargesType.type) &&
        Objects.equals(this.unusedUnitsCreditRates, gETSubscriptionRatePlanChargesType.unusedUnitsCreditRates) &&
        Objects.equals(this.uom, gETSubscriptionRatePlanChargesType.uom) &&
        Objects.equals(this.upToPeriods, gETSubscriptionRatePlanChargesType.upToPeriods) &&
        Objects.equals(this.upToPeriodsType, gETSubscriptionRatePlanChargesType.upToPeriodsType) &&
        Objects.equals(this.usageRecordRatingOption, gETSubscriptionRatePlanChargesType.usageRecordRatingOption) &&
        Objects.equals(this.version, gETSubscriptionRatePlanChargesType.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applyDiscountTo, billingDay, billingPeriod, billingPeriodAlignment, billingTiming, chargedThroughDate, currency, customFieldC, description, discountAmount, discountLevel, discountPercentage, dmrc, done, dtcv, effectiveEndDate, effectiveStartDate, endDateCondition, id, includedUnits, listPriceBase, model, mrr, name, number, numberOfPeriods, originalChargeId, overageCalculationOption, overagePrice, overageUnusedUnitsCreditOption, price, priceChangeOption, priceIncreasePercentage, pricingSummary, processedThroughDate, productRatePlanChargeId, quantity, ratingGroup, segment, smoothingModel, specificBillingPeriod, specificEndDate, tcv, tiers, triggerDate, triggerEvent, type, unusedUnitsCreditRates, uom, upToPeriods, upToPeriodsType, usageRecordRatingOption, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GETSubscriptionRatePlanChargesType {\n");
    
    sb.append("    applyDiscountTo: ").append(toIndentedString(applyDiscountTo)).append("\n");
    sb.append("    billingDay: ").append(toIndentedString(billingDay)).append("\n");
    sb.append("    billingPeriod: ").append(toIndentedString(billingPeriod)).append("\n");
    sb.append("    billingPeriodAlignment: ").append(toIndentedString(billingPeriodAlignment)).append("\n");
    sb.append("    billingTiming: ").append(toIndentedString(billingTiming)).append("\n");
    sb.append("    chargedThroughDate: ").append(toIndentedString(chargedThroughDate)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    customFieldC: ").append(toIndentedString(customFieldC)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    discountAmount: ").append(toIndentedString(discountAmount)).append("\n");
    sb.append("    discountLevel: ").append(toIndentedString(discountLevel)).append("\n");
    sb.append("    discountPercentage: ").append(toIndentedString(discountPercentage)).append("\n");
    sb.append("    dmrc: ").append(toIndentedString(dmrc)).append("\n");
    sb.append("    done: ").append(toIndentedString(done)).append("\n");
    sb.append("    dtcv: ").append(toIndentedString(dtcv)).append("\n");
    sb.append("    effectiveEndDate: ").append(toIndentedString(effectiveEndDate)).append("\n");
    sb.append("    effectiveStartDate: ").append(toIndentedString(effectiveStartDate)).append("\n");
    sb.append("    endDateCondition: ").append(toIndentedString(endDateCondition)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    includedUnits: ").append(toIndentedString(includedUnits)).append("\n");
    sb.append("    listPriceBase: ").append(toIndentedString(listPriceBase)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    mrr: ").append(toIndentedString(mrr)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    numberOfPeriods: ").append(toIndentedString(numberOfPeriods)).append("\n");
    sb.append("    originalChargeId: ").append(toIndentedString(originalChargeId)).append("\n");
    sb.append("    overageCalculationOption: ").append(toIndentedString(overageCalculationOption)).append("\n");
    sb.append("    overagePrice: ").append(toIndentedString(overagePrice)).append("\n");
    sb.append("    overageUnusedUnitsCreditOption: ").append(toIndentedString(overageUnusedUnitsCreditOption)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    priceChangeOption: ").append(toIndentedString(priceChangeOption)).append("\n");
    sb.append("    priceIncreasePercentage: ").append(toIndentedString(priceIncreasePercentage)).append("\n");
    sb.append("    pricingSummary: ").append(toIndentedString(pricingSummary)).append("\n");
    sb.append("    processedThroughDate: ").append(toIndentedString(processedThroughDate)).append("\n");
    sb.append("    productRatePlanChargeId: ").append(toIndentedString(productRatePlanChargeId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    ratingGroup: ").append(toIndentedString(ratingGroup)).append("\n");
    sb.append("    segment: ").append(toIndentedString(segment)).append("\n");
    sb.append("    smoothingModel: ").append(toIndentedString(smoothingModel)).append("\n");
    sb.append("    specificBillingPeriod: ").append(toIndentedString(specificBillingPeriod)).append("\n");
    sb.append("    specificEndDate: ").append(toIndentedString(specificEndDate)).append("\n");
    sb.append("    tcv: ").append(toIndentedString(tcv)).append("\n");
    sb.append("    tiers: ").append(toIndentedString(tiers)).append("\n");
    sb.append("    triggerDate: ").append(toIndentedString(triggerDate)).append("\n");
    sb.append("    triggerEvent: ").append(toIndentedString(triggerEvent)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    unusedUnitsCreditRates: ").append(toIndentedString(unusedUnitsCreditRates)).append("\n");
    sb.append("    uom: ").append(toIndentedString(uom)).append("\n");
    sb.append("    upToPeriods: ").append(toIndentedString(upToPeriods)).append("\n");
    sb.append("    upToPeriodsType: ").append(toIndentedString(upToPeriodsType)).append("\n");
    sb.append("    usageRecordRatingOption: ").append(toIndentedString(usageRecordRatingOption)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

