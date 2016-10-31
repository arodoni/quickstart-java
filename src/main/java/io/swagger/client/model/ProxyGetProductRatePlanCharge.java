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


/**
 * ProxyGetProductRatePlanCharge
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class ProxyGetProductRatePlanCharge   {
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

  @SerializedName("ChargeType")
  private String chargeType = null;

  @SerializedName("CreatedById")
  private String createdById = null;

  @SerializedName("CreatedDate")
  private DateTime createdDate = null;

  @SerializedName("DefaultQuantity")
  private Double defaultQuantity = null;

  @SerializedName("DeferredRevenueAccount")
  private String deferredRevenueAccount = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("DiscountLevel")
  private String discountLevel = null;

  @SerializedName("EndDateCondition")
  private String endDateCondition = null;

  @SerializedName("Id")
  private String id = null;

  @SerializedName("IncludedUnits")
  private Double includedUnits = null;

  @SerializedName("LegacyRevenueReporting")
  private Boolean legacyRevenueReporting = null;

  @SerializedName("ListPriceBase")
  private String listPriceBase = null;

  @SerializedName("MaxQuantity")
  private Double maxQuantity = null;

  @SerializedName("MinQuantity")
  private Double minQuantity = null;

  @SerializedName("Name")
  private String name = null;

  @SerializedName("NumberOfPeriod")
  private Long numberOfPeriod = null;

  @SerializedName("OverageCalculationOption")
  private String overageCalculationOption = null;

  @SerializedName("OverageUnusedUnitsCreditOption")
  private String overageUnusedUnitsCreditOption = null;

  @SerializedName("PriceChangeOption")
  private String priceChangeOption = null;

  @SerializedName("PriceIncreasePercentage")
  private Double priceIncreasePercentage = null;

  @SerializedName("ProductRatePlanId")
  private String productRatePlanId = null;

  @SerializedName("RecognizedRevenueAccount")
  private String recognizedRevenueAccount = null;

  @SerializedName("RevRecCode")
  private String revRecCode = null;

  @SerializedName("RevRecTriggerCondition")
  private String revRecTriggerCondition = null;

  @SerializedName("RevenueRecognitionRuleName")
  private String revenueRecognitionRuleName = null;

  @SerializedName("SmoothingModel")
  private String smoothingModel = null;

  @SerializedName("SpecificBillingPeriod")
  private Long specificBillingPeriod = null;

  @SerializedName("TaxCode")
  private String taxCode = null;

  @SerializedName("TaxMode")
  private String taxMode = null;

  @SerializedName("Taxable")
  private Boolean taxable = null;

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

  @SerializedName("UseDiscountSpecificAccountingCode")
  private Boolean useDiscountSpecificAccountingCode = null;

  @SerializedName("UseTenantDefaultForPriceChange")
  private Boolean useTenantDefaultForPriceChange = null;

  @SerializedName("WeeklyBillCycleDay")
  private String weeklyBillCycleDay = null;

  public ProxyGetProductRatePlanCharge accountingCode(String accountingCode) {
    this.accountingCode = accountingCode;
    return this;
  }

   /**
   * The accounting code for the charge. Accounting codes group transactions that contain similar accounting attributes. **Character limit**: 100 **Values**: an active accounting code in your Zuora Chart of Accounts 
   * @return accountingCode
  **/
  @ApiModelProperty(example = "null", value = "The accounting code for the charge. Accounting codes group transactions that contain similar accounting attributes. **Character limit**: 100 **Values**: an active accounting code in your Zuora Chart of Accounts ")
  public String getAccountingCode() {
    return accountingCode;
  }

  public void setAccountingCode(String accountingCode) {
    this.accountingCode = accountingCode;
  }

  public ProxyGetProductRatePlanCharge applyDiscountTo(String applyDiscountTo) {
    this.applyDiscountTo = applyDiscountTo;
    return this;
  }

   /**
   * Specifies the type of charges that you want a specific discount to apply to. All field values are case sensitive: note that these values are in all-caps. **Character limit**: 21 **Values**: one of the following:  - `ONETIME (1)` - `RECURRING (2)` - `USAGE (4)` - `ONETIMERECURRING (3)` - `ONETIMEUSAGE (5)` - `RECURRINGUSAGE (6)` - `ONETIMERECURRINGUSAGE (7)` 
   * @return applyDiscountTo
  **/
  @ApiModelProperty(example = "null", value = "Specifies the type of charges that you want a specific discount to apply to. All field values are case sensitive: note that these values are in all-caps. **Character limit**: 21 **Values**: one of the following:  - `ONETIME (1)` - `RECURRING (2)` - `USAGE (4)` - `ONETIMERECURRING (3)` - `ONETIMEUSAGE (5)` - `RECURRINGUSAGE (6)` - `ONETIMERECURRINGUSAGE (7)` ")
  public String getApplyDiscountTo() {
    return applyDiscountTo;
  }

  public void setApplyDiscountTo(String applyDiscountTo) {
    this.applyDiscountTo = applyDiscountTo;
  }

  public ProxyGetProductRatePlanCharge billCycleDay(Integer billCycleDay) {
    this.billCycleDay = billCycleDay;
    return this;
  }

   /**
   *  Sets the bill cycle day (BCD) for the charge. The BCD determines which day of the month customer is billed. The BCD value in the account can override the BCD in this object. **Character limit**: 2 **Values**: a valid BCD integer, 1 - 31 
   * @return billCycleDay
  **/
  @ApiModelProperty(example = "null", value = " Sets the bill cycle day (BCD) for the charge. The BCD determines which day of the month customer is billed. The BCD value in the account can override the BCD in this object. **Character limit**: 2 **Values**: a valid BCD integer, 1 - 31 ")
  public Integer getBillCycleDay() {
    return billCycleDay;
  }

  public void setBillCycleDay(Integer billCycleDay) {
    this.billCycleDay = billCycleDay;
  }

  public ProxyGetProductRatePlanCharge billCycleType(String billCycleType) {
    this.billCycleType = billCycleType;
    return this;
  }

   /**
   *  Specifies how to determine the billing day for the charge. **Character limit**: 20 **Values**: one of the following:  - `DefaultFromCustomer` - `SpecificDayofMonth:` - `SubscriptionStartDay` - `ChargeTriggerDay` - `SpecificDayofWeek` **Note**:  - If you set this field to `SpecificDayofMonth`, you must specify which day of the month as the billing day for the charge in the BillCycleDay field. - If you set this field to `SpecificDayofWeek`, you must specify which day of the week as the billing day for the charge in the WeeklyBillCycleDay field. 
   * @return billCycleType
  **/
  @ApiModelProperty(example = "null", value = " Specifies how to determine the billing day for the charge. **Character limit**: 20 **Values**: one of the following:  - `DefaultFromCustomer` - `SpecificDayofMonth:` - `SubscriptionStartDay` - `ChargeTriggerDay` - `SpecificDayofWeek` **Note**:  - If you set this field to `SpecificDayofMonth`, you must specify which day of the month as the billing day for the charge in the BillCycleDay field. - If you set this field to `SpecificDayofWeek`, you must specify which day of the week as the billing day for the charge in the WeeklyBillCycleDay field. ")
  public String getBillCycleType() {
    return billCycleType;
  }

  public void setBillCycleType(String billCycleType) {
    this.billCycleType = billCycleType;
  }

  public ProxyGetProductRatePlanCharge billingPeriod(String billingPeriod) {
    this.billingPeriod = billingPeriod;
    return this;
  }

   /**
   *  The billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD). **Character limit**: 15 **Values**: one of the following  - `Month` - `Quarter` - `Annual` - `Semi-Annual` - `Specific Months` - `Subscription Term` (This value is in **Limited Availability**.) - `Week` - `Specific Weeks` **Note**: Specify the number of months or weeks in the SpecificBillingPeriod field if you set this field to `Specific Months` or `Specific Weeks`. 
   * @return billingPeriod
  **/
  @ApiModelProperty(example = "null", value = " The billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD). **Character limit**: 15 **Values**: one of the following  - `Month` - `Quarter` - `Annual` - `Semi-Annual` - `Specific Months` - `Subscription Term` (This value is in **Limited Availability**.) - `Week` - `Specific Weeks` **Note**: Specify the number of months or weeks in the SpecificBillingPeriod field if you set this field to `Specific Months` or `Specific Weeks`. ")
  public String getBillingPeriod() {
    return billingPeriod;
  }

  public void setBillingPeriod(String billingPeriod) {
    this.billingPeriod = billingPeriod;
  }

  public ProxyGetProductRatePlanCharge billingPeriodAlignment(String billingPeriodAlignment) {
    this.billingPeriodAlignment = billingPeriodAlignment;
    return this;
  }

   /**
   *  Aligns charges within the same subscription if multiple charges begin on different dates. **Character limit**: 24 **Values**: one of the following:  - `AlignToCharge` - `AlignToSubscriptionStart` - `AlignToTermStart` 
   * @return billingPeriodAlignment
  **/
  @ApiModelProperty(example = "null", value = " Aligns charges within the same subscription if multiple charges begin on different dates. **Character limit**: 24 **Values**: one of the following:  - `AlignToCharge` - `AlignToSubscriptionStart` - `AlignToTermStart` ")
  public String getBillingPeriodAlignment() {
    return billingPeriodAlignment;
  }

  public void setBillingPeriodAlignment(String billingPeriodAlignment) {
    this.billingPeriodAlignment = billingPeriodAlignment;
  }

  public ProxyGetProductRatePlanCharge billingTiming(String billingTiming) {
    this.billingTiming = billingTiming;
    return this;
  }

   /**
   *  The billing timing for the charge. You can choose to bill in advance or in arrears for recurring charge types. This field is not used in one-time or usage based charge types. **Character limit**: **Values**: one of the following:  - `In Advance` - `In Arrears`  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  
   * @return billingTiming
  **/
  @ApiModelProperty(example = "null", value = " The billing timing for the charge. You can choose to bill in advance or in arrears for recurring charge types. This field is not used in one-time or usage based charge types. **Character limit**: **Values**: one of the following:  - `In Advance` - `In Arrears`  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  ")
  public String getBillingTiming() {
    return billingTiming;
  }

  public void setBillingTiming(String billingTiming) {
    this.billingTiming = billingTiming;
  }

  public ProxyGetProductRatePlanCharge chargeModel(String chargeModel) {
    this.chargeModel = chargeModel;
    return this;
  }

   /**
   *  Determines how to calculate charges. Charge models must be individually activated in Z-Billing administration. **Character limit**: 27 **Values**: one of the following:  - `Discount-Fixed Amount` - `Discount-Percentage` - `Flat Fee Pricing` - `Per Unit Pricing` - `Overage Pricing` - `Tiered Pricing` - `Tiered with Overage Pricing` - `Volume Pricing` 
   * @return chargeModel
  **/
  @ApiModelProperty(example = "null", value = " Determines how to calculate charges. Charge models must be individually activated in Z-Billing administration. **Character limit**: 27 **Values**: one of the following:  - `Discount-Fixed Amount` - `Discount-Percentage` - `Flat Fee Pricing` - `Per Unit Pricing` - `Overage Pricing` - `Tiered Pricing` - `Tiered with Overage Pricing` - `Volume Pricing` ")
  public String getChargeModel() {
    return chargeModel;
  }

  public void setChargeModel(String chargeModel) {
    this.chargeModel = chargeModel;
  }

  public ProxyGetProductRatePlanCharge chargeType(String chargeType) {
    this.chargeType = chargeType;
    return this;
  }

   /**
   *  Specifies the type of charge. **Character limit**: 9 **Values**: one of the following:  - `OneTime` - `Recurring` - `Usage` 
   * @return chargeType
  **/
  @ApiModelProperty(example = "null", value = " Specifies the type of charge. **Character limit**: 9 **Values**: one of the following:  - `OneTime` - `Recurring` - `Usage` ")
  public String getChargeType() {
    return chargeType;
  }

  public void setChargeType(String chargeType) {
    this.chargeType = chargeType;
  }

  public ProxyGetProductRatePlanCharge createdById(String createdById) {
    this.createdById = createdById;
    return this;
  }

   /**
   * The ID of the Zuora user who created the `ProductRatePlanCharge` object. **Character limit**: 32 **Values**: automatically generated 
   * @return createdById
  **/
  @ApiModelProperty(example = "null", value = "The ID of the Zuora user who created the `ProductRatePlanCharge` object. **Character limit**: 32 **Values**: automatically generated ")
  public String getCreatedById() {
    return createdById;
  }

  public void setCreatedById(String createdById) {
    this.createdById = createdById;
  }

  public ProxyGetProductRatePlanCharge createdDate(DateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }

   /**
   *  The date when the  `ProductRatePlanCharge` object was created. **Character limit**: 29 **Values**: automatically generated 
   * @return createdDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the  `ProductRatePlanCharge` object was created. **Character limit**: 29 **Values**: automatically generated ")
  public DateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(DateTime createdDate) {
    this.createdDate = createdDate;
  }

  public ProxyGetProductRatePlanCharge defaultQuantity(Double defaultQuantity) {
    this.defaultQuantity = defaultQuantity;
    return this;
  }

   /**
   *  The default quantity of units, such as the number of authors in a hosted wiki service. This field is required if you use a per-unit pricing model. **Character limit**: 16 **Values**: a valid quantity value 
   * @return defaultQuantity
  **/
  @ApiModelProperty(example = "null", value = " The default quantity of units, such as the number of authors in a hosted wiki service. This field is required if you use a per-unit pricing model. **Character limit**: 16 **Values**: a valid quantity value ")
  public Double getDefaultQuantity() {
    return defaultQuantity;
  }

  public void setDefaultQuantity(Double defaultQuantity) {
    this.defaultQuantity = defaultQuantity;
  }

  public ProxyGetProductRatePlanCharge deferredRevenueAccount(String deferredRevenueAccount) {
    this.deferredRevenueAccount = deferredRevenueAccount;
    return this;
  }

   /**
   *  The name of the deferred revenue account for this charge. **Character limit**: 100 **Values**: an active accounting code in your Zuora Chart of Accounts This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  
   * @return deferredRevenueAccount
  **/
  @ApiModelProperty(example = "null", value = " The name of the deferred revenue account for this charge. **Character limit**: 100 **Values**: an active accounting code in your Zuora Chart of Accounts This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  ")
  public String getDeferredRevenueAccount() {
    return deferredRevenueAccount;
  }

  public void setDeferredRevenueAccount(String deferredRevenueAccount) {
    this.deferredRevenueAccount = deferredRevenueAccount;
  }

  public ProxyGetProductRatePlanCharge description(String description) {
    this.description = description;
    return this;
  }

   /**
   * A description of the charge. **Character limit**: 500 **Values**: a string of 500 characters or fewer 
   * @return description
  **/
  @ApiModelProperty(example = "null", value = "A description of the charge. **Character limit**: 500 **Values**: a string of 500 characters or fewer ")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProxyGetProductRatePlanCharge discountLevel(String discountLevel) {
    this.discountLevel = discountLevel;
    return this;
  }

   /**
   *  Specifies if the discount applies to just the product rate plan, the entire subscription, or to any activity in the account. **Character limit**: 12 **Values**: one of the following:  - `rateplan` - `subscription`, `account` 
   * @return discountLevel
  **/
  @ApiModelProperty(example = "null", value = " Specifies if the discount applies to just the product rate plan, the entire subscription, or to any activity in the account. **Character limit**: 12 **Values**: one of the following:  - `rateplan` - `subscription`, `account` ")
  public String getDiscountLevel() {
    return discountLevel;
  }

  public void setDiscountLevel(String discountLevel) {
    this.discountLevel = discountLevel;
  }

  public ProxyGetProductRatePlanCharge endDateCondition(String endDateCondition) {
    this.endDateCondition = endDateCondition;
    return this;
  }

   /**
   *  Defines when the charge ends after the charge trigger date. **Values**: one of the following:  - `SubscriptionEnd`: The charge ends on the subscription end date after a specified period based on the trigger date of the charge. This is the default value. - `FixedPeriod`: The charge ends after a specified period based on the trigger date of the charge. If you set this field to `FixedPeriod`, you must specify the length of the period and a period type by defining the `UpToPeriods` and `UpToPeriodsType` fields. **Note**: If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date. 
   * @return endDateCondition
  **/
  @ApiModelProperty(example = "null", value = " Defines when the charge ends after the charge trigger date. **Values**: one of the following:  - `SubscriptionEnd`: The charge ends on the subscription end date after a specified period based on the trigger date of the charge. This is the default value. - `FixedPeriod`: The charge ends after a specified period based on the trigger date of the charge. If you set this field to `FixedPeriod`, you must specify the length of the period and a period type by defining the `UpToPeriods` and `UpToPeriodsType` fields. **Note**: If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date. ")
  public String getEndDateCondition() {
    return endDateCondition;
  }

  public void setEndDateCondition(String endDateCondition) {
    this.endDateCondition = endDateCondition;
  }

  public ProxyGetProductRatePlanCharge id(String id) {
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

  public ProxyGetProductRatePlanCharge includedUnits(Double includedUnits) {
    this.includedUnits = includedUnits;
    return this;
  }

   /**
   * Specifies the number of units in the base set of units. **Character limit**: 16 **Values**: a positive decimal value 
   * @return includedUnits
  **/
  @ApiModelProperty(example = "null", value = "Specifies the number of units in the base set of units. **Character limit**: 16 **Values**: a positive decimal value ")
  public Double getIncludedUnits() {
    return includedUnits;
  }

  public void setIncludedUnits(Double includedUnits) {
    this.includedUnits = includedUnits;
  }

  public ProxyGetProductRatePlanCharge legacyRevenueReporting(Boolean legacyRevenueReporting) {
    this.legacyRevenueReporting = legacyRevenueReporting;
    return this;
  }

   /**
   * 
   * @return legacyRevenueReporting
  **/
  @ApiModelProperty(example = "null", value = "")
  public Boolean getLegacyRevenueReporting() {
    return legacyRevenueReporting;
  }

  public void setLegacyRevenueReporting(Boolean legacyRevenueReporting) {
    this.legacyRevenueReporting = legacyRevenueReporting;
  }

  public ProxyGetProductRatePlanCharge listPriceBase(String listPriceBase) {
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

  public ProxyGetProductRatePlanCharge maxQuantity(Double maxQuantity) {
    this.maxQuantity = maxQuantity;
    return this;
  }

   /**
   *  Specifies the maximum number of units for this charge. Use this field and the `MinQuantity` field to create a range of units allowed in a product rate plan charge. **Character limit**: 16 **Values**: a positive decimal value 
   * @return maxQuantity
  **/
  @ApiModelProperty(example = "null", value = " Specifies the maximum number of units for this charge. Use this field and the `MinQuantity` field to create a range of units allowed in a product rate plan charge. **Character limit**: 16 **Values**: a positive decimal value ")
  public Double getMaxQuantity() {
    return maxQuantity;
  }

  public void setMaxQuantity(Double maxQuantity) {
    this.maxQuantity = maxQuantity;
  }

  public ProxyGetProductRatePlanCharge minQuantity(Double minQuantity) {
    this.minQuantity = minQuantity;
    return this;
  }

   /**
   * Specifies the minimum number of units for this charge. Use this field and the `MaxQuantity` field to create a range of units allowed in a product rate plan charge. **Character limit**: 16 **Values**: a positive decimal value 
   * @return minQuantity
  **/
  @ApiModelProperty(example = "null", value = "Specifies the minimum number of units for this charge. Use this field and the `MaxQuantity` field to create a range of units allowed in a product rate plan charge. **Character limit**: 16 **Values**: a positive decimal value ")
  public Double getMinQuantity() {
    return minQuantity;
  }

  public void setMinQuantity(Double minQuantity) {
    this.minQuantity = minQuantity;
  }

  public ProxyGetProductRatePlanCharge name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the product rate plan charge. **Character limit**: 100 **Values**: a string of 100 characters or fewer 
   * @return name
  **/
  @ApiModelProperty(example = "null", value = "The name of the product rate plan charge. **Character limit**: 100 **Values**: a string of 100 characters or fewer ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProxyGetProductRatePlanCharge numberOfPeriod(Long numberOfPeriod) {
    this.numberOfPeriod = numberOfPeriod;
    return this;
  }

   /**
   * Specifies the number of periods to use when calculating charges in an overage smoothing charge model. **Character limit**: **Values**: a positive whole number 
   * @return numberOfPeriod
  **/
  @ApiModelProperty(example = "null", value = "Specifies the number of periods to use when calculating charges in an overage smoothing charge model. **Character limit**: **Values**: a positive whole number ")
  public Long getNumberOfPeriod() {
    return numberOfPeriod;
  }

  public void setNumberOfPeriod(Long numberOfPeriod) {
    this.numberOfPeriod = numberOfPeriod;
  }

  public ProxyGetProductRatePlanCharge overageCalculationOption(String overageCalculationOption) {
    this.overageCalculationOption = overageCalculationOption;
    return this;
  }

   /**
   * Determines when to calculate overage charges. If the value of the SmoothingMode field is not specified, the value of this field is ignored. **Character limit**: 20 **Values**: one of the following:  - `EndOfSmoothingPeriod`: This option is used by default. The overage is charged at the end of the smoothing period. - `PerBillingPeriod`: The overage is charged on-demand rather than waiting until the end of the smoothing period. 
   * @return overageCalculationOption
  **/
  @ApiModelProperty(example = "null", value = "Determines when to calculate overage charges. If the value of the SmoothingMode field is not specified, the value of this field is ignored. **Character limit**: 20 **Values**: one of the following:  - `EndOfSmoothingPeriod`: This option is used by default. The overage is charged at the end of the smoothing period. - `PerBillingPeriod`: The overage is charged on-demand rather than waiting until the end of the smoothing period. ")
  public String getOverageCalculationOption() {
    return overageCalculationOption;
  }

  public void setOverageCalculationOption(String overageCalculationOption) {
    this.overageCalculationOption = overageCalculationOption;
  }

  public ProxyGetProductRatePlanCharge overageUnusedUnitsCreditOption(String overageUnusedUnitsCreditOption) {
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
    return this;
  }

   /**
   *  Determines whether to credit the customer with unused units of usage. **Character limit**: 20 **Values**: one of the following:  - `NoCredit` - `CreditBySpecificRate` 
   * @return overageUnusedUnitsCreditOption
  **/
  @ApiModelProperty(example = "null", value = " Determines whether to credit the customer with unused units of usage. **Character limit**: 20 **Values**: one of the following:  - `NoCredit` - `CreditBySpecificRate` ")
  public String getOverageUnusedUnitsCreditOption() {
    return overageUnusedUnitsCreditOption;
  }

  public void setOverageUnusedUnitsCreditOption(String overageUnusedUnitsCreditOption) {
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
  }

  public ProxyGetProductRatePlanCharge priceChangeOption(String priceChangeOption) {
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

  public ProxyGetProductRatePlanCharge priceIncreasePercentage(Double priceIncreasePercentage) {
    this.priceIncreasePercentage = priceIncreasePercentage;
    return this;
  }

   /**
   *  Specifies the percentage to increase or decrease the price of a termed subscription's renewal. Use this field if you set the [`PriceChangeOption`](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/ProductRatePlanCharge#PriceIncreaseOption) value to `SpecificPercentageValue`. **Character limit**: 16 **Values**: a decimal value between -100 and 100 
   * @return priceIncreasePercentage
  **/
  @ApiModelProperty(example = "null", value = " Specifies the percentage to increase or decrease the price of a termed subscription's renewal. Use this field if you set the [`PriceChangeOption`](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/ProductRatePlanCharge#PriceIncreaseOption) value to `SpecificPercentageValue`. **Character limit**: 16 **Values**: a decimal value between -100 and 100 ")
  public Double getPriceIncreasePercentage() {
    return priceIncreasePercentage;
  }

  public void setPriceIncreasePercentage(Double priceIncreasePercentage) {
    this.priceIncreasePercentage = priceIncreasePercentage;
  }

  public ProxyGetProductRatePlanCharge productRatePlanId(String productRatePlanId) {
    this.productRatePlanId = productRatePlanId;
    return this;
  }

   /**
   *  The ID of the product rate plan associated with this product rate plan charge. **Character limit**: 32 **Values**: a valid product rate plan ID 
   * @return productRatePlanId
  **/
  @ApiModelProperty(example = "null", value = " The ID of the product rate plan associated with this product rate plan charge. **Character limit**: 32 **Values**: a valid product rate plan ID ")
  public String getProductRatePlanId() {
    return productRatePlanId;
  }

  public void setProductRatePlanId(String productRatePlanId) {
    this.productRatePlanId = productRatePlanId;
  }

  public ProxyGetProductRatePlanCharge recognizedRevenueAccount(String recognizedRevenueAccount) {
    this.recognizedRevenueAccount = recognizedRevenueAccount;
    return this;
  }

   /**
   *  The name of the recognized revenue account for this charge.  - Required when the Allow Blank Accounting Code setting is No. - Optional when the Allow Blank Accounting Code setting is Yes. Navigate to **Z-Finance Settings > Configure Accounting Rules** to check this setting. **Character limit**: 100 **Values**: an active accounting code in your Zuora Chart of Accounts This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  
   * @return recognizedRevenueAccount
  **/
  @ApiModelProperty(example = "null", value = " The name of the recognized revenue account for this charge.  - Required when the Allow Blank Accounting Code setting is No. - Optional when the Allow Blank Accounting Code setting is Yes. Navigate to **Z-Finance Settings > Configure Accounting Rules** to check this setting. **Character limit**: 100 **Values**: an active accounting code in your Zuora Chart of Accounts This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  ")
  public String getRecognizedRevenueAccount() {
    return recognizedRevenueAccount;
  }

  public void setRecognizedRevenueAccount(String recognizedRevenueAccount) {
    this.recognizedRevenueAccount = recognizedRevenueAccount;
  }

  public ProxyGetProductRatePlanCharge revRecCode(String revRecCode) {
    this.revRecCode = revRecCode;
    return this;
  }

   /**
   * Associates this product rate plan charge with a specific revenue recognition code. **Character limit**: 70 **Values**: a valid revenue recognition code 
   * @return revRecCode
  **/
  @ApiModelProperty(example = "null", value = "Associates this product rate plan charge with a specific revenue recognition code. **Character limit**: 70 **Values**: a valid revenue recognition code ")
  public String getRevRecCode() {
    return revRecCode;
  }

  public void setRevRecCode(String revRecCode) {
    this.revRecCode = revRecCode;
  }

  public ProxyGetProductRatePlanCharge revRecTriggerCondition(String revRecTriggerCondition) {
    this.revRecTriggerCondition = revRecTriggerCondition;
    return this;
  }

   /**
   *  Specifies when revenue recognition begins. **Character limit**: 22 **Values**: one of the following:  - `ContractEffectiveDate` - `ServiceActivationDate` - `CustomerAcceptanceDate` 
   * @return revRecTriggerCondition
  **/
  @ApiModelProperty(example = "null", value = " Specifies when revenue recognition begins. **Character limit**: 22 **Values**: one of the following:  - `ContractEffectiveDate` - `ServiceActivationDate` - `CustomerAcceptanceDate` ")
  public String getRevRecTriggerCondition() {
    return revRecTriggerCondition;
  }

  public void setRevRecTriggerCondition(String revRecTriggerCondition) {
    this.revRecTriggerCondition = revRecTriggerCondition;
  }

  public ProxyGetProductRatePlanCharge revenueRecognitionRuleName(String revenueRecognitionRuleName) {
    this.revenueRecognitionRuleName = revenueRecognitionRuleName;
    return this;
  }

   /**
   * Determines when to recognize the revenue for this charge. **Character limit**: 25 **Values**: one of the following:  - `Recognize upon invoicing` - `Recognize daily over time` 
   * @return revenueRecognitionRuleName
  **/
  @ApiModelProperty(example = "null", value = "Determines when to recognize the revenue for this charge. **Character limit**: 25 **Values**: one of the following:  - `Recognize upon invoicing` - `Recognize daily over time` ")
  public String getRevenueRecognitionRuleName() {
    return revenueRecognitionRuleName;
  }

  public void setRevenueRecognitionRuleName(String revenueRecognitionRuleName) {
    this.revenueRecognitionRuleName = revenueRecognitionRuleName;
  }

  public ProxyGetProductRatePlanCharge smoothingModel(String smoothingModel) {
    this.smoothingModel = smoothingModel;
    return this;
  }

   /**
   *  Specifies the smoothing model for an overage smoothing charge model. **Character limit**: 22 **Values**: one of the following:  - `RollingWindow` - `Rollover` 
   * @return smoothingModel
  **/
  @ApiModelProperty(example = "null", value = " Specifies the smoothing model for an overage smoothing charge model. **Character limit**: 22 **Values**: one of the following:  - `RollingWindow` - `Rollover` ")
  public String getSmoothingModel() {
    return smoothingModel;
  }

  public void setSmoothingModel(String smoothingModel) {
    this.smoothingModel = smoothingModel;
  }

  public ProxyGetProductRatePlanCharge specificBillingPeriod(Long specificBillingPeriod) {
    this.specificBillingPeriod = specificBillingPeriod;
    return this;
  }

   /**
   *  Customizes the number of months or weeks for the charges billing period. This field is required if you set the value of the BillingPeriod field to `Specific Months` or `Specific Weeks`. **Values**: a positive integer 
   * @return specificBillingPeriod
  **/
  @ApiModelProperty(example = "null", value = " Customizes the number of months or weeks for the charges billing period. This field is required if you set the value of the BillingPeriod field to `Specific Months` or `Specific Weeks`. **Values**: a positive integer ")
  public Long getSpecificBillingPeriod() {
    return specificBillingPeriod;
  }

  public void setSpecificBillingPeriod(Long specificBillingPeriod) {
    this.specificBillingPeriod = specificBillingPeriod;
  }

  public ProxyGetProductRatePlanCharge taxCode(String taxCode) {
    this.taxCode = taxCode;
    return this;
  }

   /**
   *  Specifies the tax code for taxation rules. Required when the Taxable field is set to `True`. **Character limit**: 64 **Values**: a valid tax code 
   * @return taxCode
  **/
  @ApiModelProperty(example = "null", value = " Specifies the tax code for taxation rules. Required when the Taxable field is set to `True`. **Character limit**: 64 **Values**: a valid tax code ")
  public String getTaxCode() {
    return taxCode;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }

  public ProxyGetProductRatePlanCharge taxMode(String taxMode) {
    this.taxMode = taxMode;
    return this;
  }

   /**
   *  Determines how to define taxation for the charge. Required when the Taxable field is set to `True`. **Character limit**: 12 **Values**: one of the following:  - `TaxExclusive` - `TaxInclusive` 
   * @return taxMode
  **/
  @ApiModelProperty(example = "null", value = " Determines how to define taxation for the charge. Required when the Taxable field is set to `True`. **Character limit**: 12 **Values**: one of the following:  - `TaxExclusive` - `TaxInclusive` ")
  public String getTaxMode() {
    return taxMode;
  }

  public void setTaxMode(String taxMode) {
    this.taxMode = taxMode;
  }

  public ProxyGetProductRatePlanCharge taxable(Boolean taxable) {
    this.taxable = taxable;
    return this;
  }

   /**
   *  Determines whether the charge is taxable. When set to `True`, the TaxMode and TaxCode fields are required when creating or updating th ProductRatePlanCharge object. **Character limit**: 5 **Values**: `True`, `False` 
   * @return taxable
  **/
  @ApiModelProperty(example = "null", value = " Determines whether the charge is taxable. When set to `True`, the TaxMode and TaxCode fields are required when creating or updating th ProductRatePlanCharge object. **Character limit**: 5 **Values**: `True`, `False` ")
  public Boolean getTaxable() {
    return taxable;
  }

  public void setTaxable(Boolean taxable) {
    this.taxable = taxable;
  }

  public ProxyGetProductRatePlanCharge triggerEvent(String triggerEvent) {
    this.triggerEvent = triggerEvent;
    return this;
  }

   /**
   *  Specifies when to start billing the customer for the charge. **Character limit**: 18 **Values**: one of the following:  - `ContractEffective` is the date when the subscription's contract goes into effect and the charge is ready to be billed. - `ServiceActivation` is the date when the services or products for a subscription have been activated and the customers have access. - `CustomerAcceptance` is when the customer accepts the services or products for a subscription. 
   * @return triggerEvent
  **/
  @ApiModelProperty(example = "null", value = " Specifies when to start billing the customer for the charge. **Character limit**: 18 **Values**: one of the following:  - `ContractEffective` is the date when the subscription's contract goes into effect and the charge is ready to be billed. - `ServiceActivation` is the date when the services or products for a subscription have been activated and the customers have access. - `CustomerAcceptance` is when the customer accepts the services or products for a subscription. ")
  public String getTriggerEvent() {
    return triggerEvent;
  }

  public void setTriggerEvent(String triggerEvent) {
    this.triggerEvent = triggerEvent;
  }

  public ProxyGetProductRatePlanCharge UOM(String UOM) {
    this.UOM = UOM;
    return this;
  }

   /**
   *  Specifies the units to measure usage. Units of measure are configured in the web-based UI: **Z-Billing > Settings**. **Character limit**: 25 **Values**: a configured unit of measure **Note**: You must specify this field when creating the following charge models:  - Per Unit Pricing - Volume Pricing - Overage Pricing - Tiered Pricing - Tiered with Overage Pricing 
   * @return UOM
  **/
  @ApiModelProperty(example = "null", value = " Specifies the units to measure usage. Units of measure are configured in the web-based UI: **Z-Billing > Settings**. **Character limit**: 25 **Values**: a configured unit of measure **Note**: You must specify this field when creating the following charge models:  - Per Unit Pricing - Volume Pricing - Overage Pricing - Tiered Pricing - Tiered with Overage Pricing ")
  public String getUOM() {
    return UOM;
  }

  public void setUOM(String UOM) {
    this.UOM = UOM;
  }

  public ProxyGetProductRatePlanCharge upToPeriods(Long upToPeriods) {
    this.upToPeriods = upToPeriods;
    return this;
  }

   /**
   *  Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends. **Character limit**: 5 **Values**: a whole number between 0 and 65535, exclusive **Note**:  - You must use this field together with the `UpToPeriodsType` field to specify the time period. This field is applicable only when the `EndDateCondition` field is set to `FixedPeriod`. - If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end. 
   * @return upToPeriods
  **/
  @ApiModelProperty(example = "null", value = " Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends. **Character limit**: 5 **Values**: a whole number between 0 and 65535, exclusive **Note**:  - You must use this field together with the `UpToPeriodsType` field to specify the time period. This field is applicable only when the `EndDateCondition` field is set to `FixedPeriod`. - If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end. ")
  public Long getUpToPeriods() {
    return upToPeriods;
  }

  public void setUpToPeriods(Long upToPeriods) {
    this.upToPeriods = upToPeriods;
  }

  public ProxyGetProductRatePlanCharge upToPeriodsType(String upToPeriodsType) {
    this.upToPeriodsType = upToPeriodsType;
    return this;
  }

   /**
   *  The period type used to define when the charge ends. **Character limit**: -- **Values**: one of the following:  - `Billing Periods` (default) - `Days` - `Weeks` - `Months` - Years **Note**:  - You must use this field together with the `UpToPeriods` field to specify the time period. - This field is applicable only when the `EndDateCondition` field is set to `FixedPeriod`. 
   * @return upToPeriodsType
  **/
  @ApiModelProperty(example = "null", value = " The period type used to define when the charge ends. **Character limit**: -- **Values**: one of the following:  - `Billing Periods` (default) - `Days` - `Weeks` - `Months` - Years **Note**:  - You must use this field together with the `UpToPeriods` field to specify the time period. - This field is applicable only when the `EndDateCondition` field is set to `FixedPeriod`. ")
  public String getUpToPeriodsType() {
    return upToPeriodsType;
  }

  public void setUpToPeriodsType(String upToPeriodsType) {
    this.upToPeriodsType = upToPeriodsType;
  }

  public ProxyGetProductRatePlanCharge updatedById(String updatedById) {
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

  public ProxyGetProductRatePlanCharge updatedDate(DateTime updatedDate) {
    this.updatedDate = updatedDate;
    return this;
  }

   /**
   * The date when the object was last updated. **Character limit**: 29 **Values**: automatically generated 
   * @return updatedDate
  **/
  @ApiModelProperty(example = "null", value = "The date when the object was last updated. **Character limit**: 29 **Values**: automatically generated ")
  public DateTime getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(DateTime updatedDate) {
    this.updatedDate = updatedDate;
  }

  public ProxyGetProductRatePlanCharge useDiscountSpecificAccountingCode(Boolean useDiscountSpecificAccountingCode) {
    this.useDiscountSpecificAccountingCode = useDiscountSpecificAccountingCode;
    return this;
  }

   /**
   * Determines whether to define a new accounting code for the new discount charge. **Character limit**: 5 **Values**: `True`, `False` 
   * @return useDiscountSpecificAccountingCode
  **/
  @ApiModelProperty(example = "null", value = "Determines whether to define a new accounting code for the new discount charge. **Character limit**: 5 **Values**: `True`, `False` ")
  public Boolean getUseDiscountSpecificAccountingCode() {
    return useDiscountSpecificAccountingCode;
  }

  public void setUseDiscountSpecificAccountingCode(Boolean useDiscountSpecificAccountingCode) {
    this.useDiscountSpecificAccountingCode = useDiscountSpecificAccountingCode;
  }

  public ProxyGetProductRatePlanCharge useTenantDefaultForPriceChange(Boolean useTenantDefaultForPriceChange) {
    this.useTenantDefaultForPriceChange = useTenantDefaultForPriceChange;
    return this;
  }

   /**
   *  Applies the tenant-level percentage uplift value for an automatic price change to a termed subscription's renewal. You set the tenant uplift value in the web-based UI: **Z-Billing > Define Default Subscription Settings** **Character limit**: 5 **Values**: `true`, `false` 
   * @return useTenantDefaultForPriceChange
  **/
  @ApiModelProperty(example = "null", value = " Applies the tenant-level percentage uplift value for an automatic price change to a termed subscription's renewal. You set the tenant uplift value in the web-based UI: **Z-Billing > Define Default Subscription Settings** **Character limit**: 5 **Values**: `true`, `false` ")
  public Boolean getUseTenantDefaultForPriceChange() {
    return useTenantDefaultForPriceChange;
  }

  public void setUseTenantDefaultForPriceChange(Boolean useTenantDefaultForPriceChange) {
    this.useTenantDefaultForPriceChange = useTenantDefaultForPriceChange;
  }

  public ProxyGetProductRatePlanCharge weeklyBillCycleDay(String weeklyBillCycleDay) {
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
    ProxyGetProductRatePlanCharge proxyGetProductRatePlanCharge = (ProxyGetProductRatePlanCharge) o;
    return Objects.equals(this.accountingCode, proxyGetProductRatePlanCharge.accountingCode) &&
        Objects.equals(this.applyDiscountTo, proxyGetProductRatePlanCharge.applyDiscountTo) &&
        Objects.equals(this.billCycleDay, proxyGetProductRatePlanCharge.billCycleDay) &&
        Objects.equals(this.billCycleType, proxyGetProductRatePlanCharge.billCycleType) &&
        Objects.equals(this.billingPeriod, proxyGetProductRatePlanCharge.billingPeriod) &&
        Objects.equals(this.billingPeriodAlignment, proxyGetProductRatePlanCharge.billingPeriodAlignment) &&
        Objects.equals(this.billingTiming, proxyGetProductRatePlanCharge.billingTiming) &&
        Objects.equals(this.chargeModel, proxyGetProductRatePlanCharge.chargeModel) &&
        Objects.equals(this.chargeType, proxyGetProductRatePlanCharge.chargeType) &&
        Objects.equals(this.createdById, proxyGetProductRatePlanCharge.createdById) &&
        Objects.equals(this.createdDate, proxyGetProductRatePlanCharge.createdDate) &&
        Objects.equals(this.defaultQuantity, proxyGetProductRatePlanCharge.defaultQuantity) &&
        Objects.equals(this.deferredRevenueAccount, proxyGetProductRatePlanCharge.deferredRevenueAccount) &&
        Objects.equals(this.description, proxyGetProductRatePlanCharge.description) &&
        Objects.equals(this.discountLevel, proxyGetProductRatePlanCharge.discountLevel) &&
        Objects.equals(this.endDateCondition, proxyGetProductRatePlanCharge.endDateCondition) &&
        Objects.equals(this.id, proxyGetProductRatePlanCharge.id) &&
        Objects.equals(this.includedUnits, proxyGetProductRatePlanCharge.includedUnits) &&
        Objects.equals(this.legacyRevenueReporting, proxyGetProductRatePlanCharge.legacyRevenueReporting) &&
        Objects.equals(this.listPriceBase, proxyGetProductRatePlanCharge.listPriceBase) &&
        Objects.equals(this.maxQuantity, proxyGetProductRatePlanCharge.maxQuantity) &&
        Objects.equals(this.minQuantity, proxyGetProductRatePlanCharge.minQuantity) &&
        Objects.equals(this.name, proxyGetProductRatePlanCharge.name) &&
        Objects.equals(this.numberOfPeriod, proxyGetProductRatePlanCharge.numberOfPeriod) &&
        Objects.equals(this.overageCalculationOption, proxyGetProductRatePlanCharge.overageCalculationOption) &&
        Objects.equals(this.overageUnusedUnitsCreditOption, proxyGetProductRatePlanCharge.overageUnusedUnitsCreditOption) &&
        Objects.equals(this.priceChangeOption, proxyGetProductRatePlanCharge.priceChangeOption) &&
        Objects.equals(this.priceIncreasePercentage, proxyGetProductRatePlanCharge.priceIncreasePercentage) &&
        Objects.equals(this.productRatePlanId, proxyGetProductRatePlanCharge.productRatePlanId) &&
        Objects.equals(this.recognizedRevenueAccount, proxyGetProductRatePlanCharge.recognizedRevenueAccount) &&
        Objects.equals(this.revRecCode, proxyGetProductRatePlanCharge.revRecCode) &&
        Objects.equals(this.revRecTriggerCondition, proxyGetProductRatePlanCharge.revRecTriggerCondition) &&
        Objects.equals(this.revenueRecognitionRuleName, proxyGetProductRatePlanCharge.revenueRecognitionRuleName) &&
        Objects.equals(this.smoothingModel, proxyGetProductRatePlanCharge.smoothingModel) &&
        Objects.equals(this.specificBillingPeriod, proxyGetProductRatePlanCharge.specificBillingPeriod) &&
        Objects.equals(this.taxCode, proxyGetProductRatePlanCharge.taxCode) &&
        Objects.equals(this.taxMode, proxyGetProductRatePlanCharge.taxMode) &&
        Objects.equals(this.taxable, proxyGetProductRatePlanCharge.taxable) &&
        Objects.equals(this.triggerEvent, proxyGetProductRatePlanCharge.triggerEvent) &&
        Objects.equals(this.UOM, proxyGetProductRatePlanCharge.UOM) &&
        Objects.equals(this.upToPeriods, proxyGetProductRatePlanCharge.upToPeriods) &&
        Objects.equals(this.upToPeriodsType, proxyGetProductRatePlanCharge.upToPeriodsType) &&
        Objects.equals(this.updatedById, proxyGetProductRatePlanCharge.updatedById) &&
        Objects.equals(this.updatedDate, proxyGetProductRatePlanCharge.updatedDate) &&
        Objects.equals(this.useDiscountSpecificAccountingCode, proxyGetProductRatePlanCharge.useDiscountSpecificAccountingCode) &&
        Objects.equals(this.useTenantDefaultForPriceChange, proxyGetProductRatePlanCharge.useTenantDefaultForPriceChange) &&
        Objects.equals(this.weeklyBillCycleDay, proxyGetProductRatePlanCharge.weeklyBillCycleDay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountingCode, applyDiscountTo, billCycleDay, billCycleType, billingPeriod, billingPeriodAlignment, billingTiming, chargeModel, chargeType, createdById, createdDate, defaultQuantity, deferredRevenueAccount, description, discountLevel, endDateCondition, id, includedUnits, legacyRevenueReporting, listPriceBase, maxQuantity, minQuantity, name, numberOfPeriod, overageCalculationOption, overageUnusedUnitsCreditOption, priceChangeOption, priceIncreasePercentage, productRatePlanId, recognizedRevenueAccount, revRecCode, revRecTriggerCondition, revenueRecognitionRuleName, smoothingModel, specificBillingPeriod, taxCode, taxMode, taxable, triggerEvent, UOM, upToPeriods, upToPeriodsType, updatedById, updatedDate, useDiscountSpecificAccountingCode, useTenantDefaultForPriceChange, weeklyBillCycleDay);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProxyGetProductRatePlanCharge {\n");
    
    sb.append("    accountingCode: ").append(toIndentedString(accountingCode)).append("\n");
    sb.append("    applyDiscountTo: ").append(toIndentedString(applyDiscountTo)).append("\n");
    sb.append("    billCycleDay: ").append(toIndentedString(billCycleDay)).append("\n");
    sb.append("    billCycleType: ").append(toIndentedString(billCycleType)).append("\n");
    sb.append("    billingPeriod: ").append(toIndentedString(billingPeriod)).append("\n");
    sb.append("    billingPeriodAlignment: ").append(toIndentedString(billingPeriodAlignment)).append("\n");
    sb.append("    billingTiming: ").append(toIndentedString(billingTiming)).append("\n");
    sb.append("    chargeModel: ").append(toIndentedString(chargeModel)).append("\n");
    sb.append("    chargeType: ").append(toIndentedString(chargeType)).append("\n");
    sb.append("    createdById: ").append(toIndentedString(createdById)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    defaultQuantity: ").append(toIndentedString(defaultQuantity)).append("\n");
    sb.append("    deferredRevenueAccount: ").append(toIndentedString(deferredRevenueAccount)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    discountLevel: ").append(toIndentedString(discountLevel)).append("\n");
    sb.append("    endDateCondition: ").append(toIndentedString(endDateCondition)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    includedUnits: ").append(toIndentedString(includedUnits)).append("\n");
    sb.append("    legacyRevenueReporting: ").append(toIndentedString(legacyRevenueReporting)).append("\n");
    sb.append("    listPriceBase: ").append(toIndentedString(listPriceBase)).append("\n");
    sb.append("    maxQuantity: ").append(toIndentedString(maxQuantity)).append("\n");
    sb.append("    minQuantity: ").append(toIndentedString(minQuantity)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    numberOfPeriod: ").append(toIndentedString(numberOfPeriod)).append("\n");
    sb.append("    overageCalculationOption: ").append(toIndentedString(overageCalculationOption)).append("\n");
    sb.append("    overageUnusedUnitsCreditOption: ").append(toIndentedString(overageUnusedUnitsCreditOption)).append("\n");
    sb.append("    priceChangeOption: ").append(toIndentedString(priceChangeOption)).append("\n");
    sb.append("    priceIncreasePercentage: ").append(toIndentedString(priceIncreasePercentage)).append("\n");
    sb.append("    productRatePlanId: ").append(toIndentedString(productRatePlanId)).append("\n");
    sb.append("    recognizedRevenueAccount: ").append(toIndentedString(recognizedRevenueAccount)).append("\n");
    sb.append("    revRecCode: ").append(toIndentedString(revRecCode)).append("\n");
    sb.append("    revRecTriggerCondition: ").append(toIndentedString(revRecTriggerCondition)).append("\n");
    sb.append("    revenueRecognitionRuleName: ").append(toIndentedString(revenueRecognitionRuleName)).append("\n");
    sb.append("    smoothingModel: ").append(toIndentedString(smoothingModel)).append("\n");
    sb.append("    specificBillingPeriod: ").append(toIndentedString(specificBillingPeriod)).append("\n");
    sb.append("    taxCode: ").append(toIndentedString(taxCode)).append("\n");
    sb.append("    taxMode: ").append(toIndentedString(taxMode)).append("\n");
    sb.append("    taxable: ").append(toIndentedString(taxable)).append("\n");
    sb.append("    triggerEvent: ").append(toIndentedString(triggerEvent)).append("\n");
    sb.append("    UOM: ").append(toIndentedString(UOM)).append("\n");
    sb.append("    upToPeriods: ").append(toIndentedString(upToPeriods)).append("\n");
    sb.append("    upToPeriodsType: ").append(toIndentedString(upToPeriodsType)).append("\n");
    sb.append("    updatedById: ").append(toIndentedString(updatedById)).append("\n");
    sb.append("    updatedDate: ").append(toIndentedString(updatedDate)).append("\n");
    sb.append("    useDiscountSpecificAccountingCode: ").append(toIndentedString(useDiscountSpecificAccountingCode)).append("\n");
    sb.append("    useTenantDefaultForPriceChange: ").append(toIndentedString(useTenantDefaultForPriceChange)).append("\n");
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

