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
import io.swagger.client.model.GETRsRevenueItemType;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;


/**
 * GETRSDetailType
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class GETRSDetailType   {
  @SerializedName("accountId")
  private String accountId = null;

  @SerializedName("amount")
  private String amount = null;

  @SerializedName("createdOn")
  private DateTime createdOn = null;

  @SerializedName("currency")
  private String currency = null;

  @SerializedName("customField__c")
  private String customFieldC = null;

  @SerializedName("linkedTransactionId")
  private String linkedTransactionId = null;

  @SerializedName("linkedTransactionNumber")
  private String linkedTransactionNumber = null;

  @SerializedName("linkedTransactionType")
  private String linkedTransactionType = null;

  @SerializedName("notes")
  private String notes = null;

  @SerializedName("number")
  private String number = null;

  @SerializedName("recognitionRuleName")
  private String recognitionRuleName = null;

  @SerializedName("recognizedRevenue")
  private String recognizedRevenue = null;

  @SerializedName("referenceId")
  private String referenceId = null;

  @SerializedName("revenueItems")
  private List<GETRsRevenueItemType> revenueItems = new ArrayList<GETRsRevenueItemType>();

  @SerializedName("revenueScheduleDate")
  private LocalDate revenueScheduleDate = null;

  @SerializedName("subscriptionChargeId")
  private String subscriptionChargeId = null;

  @SerializedName("subscriptionId")
  private String subscriptionId = null;

  @SerializedName("success")
  private Boolean success = null;

  @SerializedName("undistributedUnrecognizedRevenue")
  private String undistributedUnrecognizedRevenue = null;

  @SerializedName("unrecognizedRevenue")
  private String unrecognizedRevenue = null;

  @SerializedName("updatedOn")
  private DateTime updatedOn = null;

  public GETRSDetailType accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * An account ID. 
   * @return accountId
  **/
  @ApiModelProperty(example = "null", value = "An account ID. ")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public GETRSDetailType amount(String amount) {
    this.amount = amount;
    return this;
  }

   /**
   * The revenue schedule amount, which is the sum of all revenue items. This field cannot be null and must be formatted based on the currency, such as `JPY 30` or `USD 30.15`. Test out the currency to ensure you are using the proper formatting otherwise, the response will fail and this error message is returned: `Allocation amount with wrong decimal places.` 
   * @return amount
  **/
  @ApiModelProperty(example = "null", value = "The revenue schedule amount, which is the sum of all revenue items. This field cannot be null and must be formatted based on the currency, such as `JPY 30` or `USD 30.15`. Test out the currency to ensure you are using the proper formatting otherwise, the response will fail and this error message is returned: `Allocation amount with wrong decimal places.` ")
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public GETRSDetailType createdOn(DateTime createdOn) {
    this.createdOn = createdOn;
    return this;
  }

   /**
   * The date when the record was created in `YYYY-MM-DD HH:MM:SS` format. 
   * @return createdOn
  **/
  @ApiModelProperty(example = "null", value = "The date when the record was created in `YYYY-MM-DD HH:MM:SS` format. ")
  public DateTime getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(DateTime createdOn) {
    this.createdOn = createdOn;
  }

  public GETRSDetailType currency(String currency) {
    this.currency = currency;
    return this;
  }

   /**
   * The type of currency used. 
   * @return currency
  **/
  @ApiModelProperty(example = "null", value = "The type of currency used. ")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public GETRSDetailType customFieldC(String customFieldC) {
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

  public GETRSDetailType linkedTransactionId(String linkedTransactionId) {
    this.linkedTransactionId = linkedTransactionId;
    return this;
  }

   /**
   * The linked transaction ID for billing transactions. This field is used for all rules except the custom unlimited or manual recognition rule models. If using the custom unlimited rule model, then the field value must be null. If the field is not null, then the referenceId field must be null.  
   * @return linkedTransactionId
  **/
  @ApiModelProperty(example = "null", value = "The linked transaction ID for billing transactions. This field is used for all rules except the custom unlimited or manual recognition rule models. If using the custom unlimited rule model, then the field value must be null. If the field is not null, then the referenceId field must be null.  ")
  public String getLinkedTransactionId() {
    return linkedTransactionId;
  }

  public void setLinkedTransactionId(String linkedTransactionId) {
    this.linkedTransactionId = linkedTransactionId;
  }

  public GETRSDetailType linkedTransactionNumber(String linkedTransactionNumber) {
    this.linkedTransactionNumber = linkedTransactionNumber;
    return this;
  }

   /**
   * The number for the linked invoice item or invoice item adjustment transaction. This field is used for all rules except the custom unlimited or manual recognition rule models.  If using the custom unlimited or manual recognition rule models, then the field value is null.  
   * @return linkedTransactionNumber
  **/
  @ApiModelProperty(example = "null", value = "The number for the linked invoice item or invoice item adjustment transaction. This field is used for all rules except the custom unlimited or manual recognition rule models.  If using the custom unlimited or manual recognition rule models, then the field value is null.  ")
  public String getLinkedTransactionNumber() {
    return linkedTransactionNumber;
  }

  public void setLinkedTransactionNumber(String linkedTransactionNumber) {
    this.linkedTransactionNumber = linkedTransactionNumber;
  }

  public GETRSDetailType linkedTransactionType(String linkedTransactionType) {
    this.linkedTransactionType = linkedTransactionType;
    return this;
  }

   /**
   * The type of linked transaction for billing transactions, which can be invoice item or invoice item adjustment. This field is used for all rules except the custom unlimited or manual recognition rule models. 
   * @return linkedTransactionType
  **/
  @ApiModelProperty(example = "null", value = "The type of linked transaction for billing transactions, which can be invoice item or invoice item adjustment. This field is used for all rules except the custom unlimited or manual recognition rule models. ")
  public String getLinkedTransactionType() {
    return linkedTransactionType;
  }

  public void setLinkedTransactionType(String linkedTransactionType) {
    this.linkedTransactionType = linkedTransactionType;
  }

  public GETRSDetailType notes(String notes) {
    this.notes = notes;
    return this;
  }

   /**
   * Additional information about this record. 
   * @return notes
  **/
  @ApiModelProperty(example = "null", value = "Additional information about this record. ")
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public GETRSDetailType number(String number) {
    this.number = number;
    return this;
  }

   /**
   * Revenue schedule number. The revenue schedule number is always prefixed with \"RS\", for example, \"RS-00000001\". 
   * @return number
  **/
  @ApiModelProperty(example = "null", value = "Revenue schedule number. The revenue schedule number is always prefixed with \"RS\", for example, \"RS-00000001\". ")
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public GETRSDetailType recognitionRuleName(String recognitionRuleName) {
    this.recognitionRuleName = recognitionRuleName;
    return this;
  }

   /**
   * The name of the recognition rule. 
   * @return recognitionRuleName
  **/
  @ApiModelProperty(example = "null", value = "The name of the recognition rule. ")
  public String getRecognitionRuleName() {
    return recognitionRuleName;
  }

  public void setRecognitionRuleName(String recognitionRuleName) {
    this.recognitionRuleName = recognitionRuleName;
  }

  public GETRSDetailType recognizedRevenue(String recognizedRevenue) {
    this.recognizedRevenue = recognizedRevenue;
    return this;
  }

   /**
   * The revenue that was distributed in a closed accounting period. 
   * @return recognizedRevenue
  **/
  @ApiModelProperty(example = "null", value = "The revenue that was distributed in a closed accounting period. ")
  public String getRecognizedRevenue() {
    return recognizedRevenue;
  }

  public void setRecognizedRevenue(String recognizedRevenue) {
    this.recognizedRevenue = recognizedRevenue;
  }

  public GETRSDetailType referenceId(String referenceId) {
    this.referenceId = referenceId;
    return this;
  }

   /**
   * Reference ID is used only in the custom unlimited rule to create a revenue schedule. In this scenario, the revenue schedule is not linked to an invoice item or invoice item adjustment. 
   * @return referenceId
  **/
  @ApiModelProperty(example = "null", value = "Reference ID is used only in the custom unlimited rule to create a revenue schedule. In this scenario, the revenue schedule is not linked to an invoice item or invoice item adjustment. ")
  public String getReferenceId() {
    return referenceId;
  }

  public void setReferenceId(String referenceId) {
    this.referenceId = referenceId;
  }

  public GETRSDetailType revenueItems(List<GETRsRevenueItemType> revenueItems) {
    this.revenueItems = revenueItems;
    return this;
  }

  public GETRSDetailType addRevenueItemsItem(GETRsRevenueItemType revenueItemsItem) {
    this.revenueItems.add(revenueItemsItem);
    return this;
  }

   /**
   * Revenue items are listed in ascending order by the accounting period start date. 
   * @return revenueItems
  **/
  @ApiModelProperty(example = "null", value = "Revenue items are listed in ascending order by the accounting period start date. ")
  public List<GETRsRevenueItemType> getRevenueItems() {
    return revenueItems;
  }

  public void setRevenueItems(List<GETRsRevenueItemType> revenueItems) {
    this.revenueItems = revenueItems;
  }

  public GETRSDetailType revenueScheduleDate(LocalDate revenueScheduleDate) {
    this.revenueScheduleDate = revenueScheduleDate;
    return this;
  }

   /**
   * The effective date of the revenue schedule. For example, the revenue schedule date for bookings-based revenue recognition is typically set to the order date or contract date.  The date cannot be in a closed accounting period. The date must be in the `YYYY-MM-DD` format. 
   * @return revenueScheduleDate
  **/
  @ApiModelProperty(example = "null", value = "The effective date of the revenue schedule. For example, the revenue schedule date for bookings-based revenue recognition is typically set to the order date or contract date.  The date cannot be in a closed accounting period. The date must be in the `YYYY-MM-DD` format. ")
  public LocalDate getRevenueScheduleDate() {
    return revenueScheduleDate;
  }

  public void setRevenueScheduleDate(LocalDate revenueScheduleDate) {
    this.revenueScheduleDate = revenueScheduleDate;
  }

  public GETRSDetailType subscriptionChargeId(String subscriptionChargeId) {
    this.subscriptionChargeId = subscriptionChargeId;
    return this;
  }

   /**
   * The original subscription charge ID. 
   * @return subscriptionChargeId
  **/
  @ApiModelProperty(example = "null", value = "The original subscription charge ID. ")
  public String getSubscriptionChargeId() {
    return subscriptionChargeId;
  }

  public void setSubscriptionChargeId(String subscriptionChargeId) {
    this.subscriptionChargeId = subscriptionChargeId;
  }

  public GETRSDetailType subscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
    return this;
  }

   /**
   * The original subscription ID. 
   * @return subscriptionId
  **/
  @ApiModelProperty(example = "null", value = "The original subscription ID. ")
  public String getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public GETRSDetailType success(Boolean success) {
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

  public GETRSDetailType undistributedUnrecognizedRevenue(String undistributedUnrecognizedRevenue) {
    this.undistributedUnrecognizedRevenue = undistributedUnrecognizedRevenue;
    return this;
  }

   /**
   * Revenue in the open-ended accounting period. 
   * @return undistributedUnrecognizedRevenue
  **/
  @ApiModelProperty(example = "null", value = "Revenue in the open-ended accounting period. ")
  public String getUndistributedUnrecognizedRevenue() {
    return undistributedUnrecognizedRevenue;
  }

  public void setUndistributedUnrecognizedRevenue(String undistributedUnrecognizedRevenue) {
    this.undistributedUnrecognizedRevenue = undistributedUnrecognizedRevenue;
  }

  public GETRSDetailType unrecognizedRevenue(String unrecognizedRevenue) {
    this.unrecognizedRevenue = unrecognizedRevenue;
    return this;
  }

   /**
   * Revenue distributed in all open accounting periods, which includes the open-ended accounting period. 
   * @return unrecognizedRevenue
  **/
  @ApiModelProperty(example = "null", value = "Revenue distributed in all open accounting periods, which includes the open-ended accounting period. ")
  public String getUnrecognizedRevenue() {
    return unrecognizedRevenue;
  }

  public void setUnrecognizedRevenue(String unrecognizedRevenue) {
    this.unrecognizedRevenue = unrecognizedRevenue;
  }

  public GETRSDetailType updatedOn(DateTime updatedOn) {
    this.updatedOn = updatedOn;
    return this;
  }

   /**
   * The date when the revenue automation start date was set. 
   * @return updatedOn
  **/
  @ApiModelProperty(example = "null", value = "The date when the revenue automation start date was set. ")
  public DateTime getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(DateTime updatedOn) {
    this.updatedOn = updatedOn;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GETRSDetailType gETRSDetailType = (GETRSDetailType) o;
    return Objects.equals(this.accountId, gETRSDetailType.accountId) &&
        Objects.equals(this.amount, gETRSDetailType.amount) &&
        Objects.equals(this.createdOn, gETRSDetailType.createdOn) &&
        Objects.equals(this.currency, gETRSDetailType.currency) &&
        Objects.equals(this.customFieldC, gETRSDetailType.customFieldC) &&
        Objects.equals(this.linkedTransactionId, gETRSDetailType.linkedTransactionId) &&
        Objects.equals(this.linkedTransactionNumber, gETRSDetailType.linkedTransactionNumber) &&
        Objects.equals(this.linkedTransactionType, gETRSDetailType.linkedTransactionType) &&
        Objects.equals(this.notes, gETRSDetailType.notes) &&
        Objects.equals(this.number, gETRSDetailType.number) &&
        Objects.equals(this.recognitionRuleName, gETRSDetailType.recognitionRuleName) &&
        Objects.equals(this.recognizedRevenue, gETRSDetailType.recognizedRevenue) &&
        Objects.equals(this.referenceId, gETRSDetailType.referenceId) &&
        Objects.equals(this.revenueItems, gETRSDetailType.revenueItems) &&
        Objects.equals(this.revenueScheduleDate, gETRSDetailType.revenueScheduleDate) &&
        Objects.equals(this.subscriptionChargeId, gETRSDetailType.subscriptionChargeId) &&
        Objects.equals(this.subscriptionId, gETRSDetailType.subscriptionId) &&
        Objects.equals(this.success, gETRSDetailType.success) &&
        Objects.equals(this.undistributedUnrecognizedRevenue, gETRSDetailType.undistributedUnrecognizedRevenue) &&
        Objects.equals(this.unrecognizedRevenue, gETRSDetailType.unrecognizedRevenue) &&
        Objects.equals(this.updatedOn, gETRSDetailType.updatedOn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, amount, createdOn, currency, customFieldC, linkedTransactionId, linkedTransactionNumber, linkedTransactionType, notes, number, recognitionRuleName, recognizedRevenue, referenceId, revenueItems, revenueScheduleDate, subscriptionChargeId, subscriptionId, success, undistributedUnrecognizedRevenue, unrecognizedRevenue, updatedOn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GETRSDetailType {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    customFieldC: ").append(toIndentedString(customFieldC)).append("\n");
    sb.append("    linkedTransactionId: ").append(toIndentedString(linkedTransactionId)).append("\n");
    sb.append("    linkedTransactionNumber: ").append(toIndentedString(linkedTransactionNumber)).append("\n");
    sb.append("    linkedTransactionType: ").append(toIndentedString(linkedTransactionType)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    recognitionRuleName: ").append(toIndentedString(recognitionRuleName)).append("\n");
    sb.append("    recognizedRevenue: ").append(toIndentedString(recognizedRevenue)).append("\n");
    sb.append("    referenceId: ").append(toIndentedString(referenceId)).append("\n");
    sb.append("    revenueItems: ").append(toIndentedString(revenueItems)).append("\n");
    sb.append("    revenueScheduleDate: ").append(toIndentedString(revenueScheduleDate)).append("\n");
    sb.append("    subscriptionChargeId: ").append(toIndentedString(subscriptionChargeId)).append("\n");
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    undistributedUnrecognizedRevenue: ").append(toIndentedString(undistributedUnrecognizedRevenue)).append("\n");
    sb.append("    unrecognizedRevenue: ").append(toIndentedString(unrecognizedRevenue)).append("\n");
    sb.append("    updatedOn: ").append(toIndentedString(updatedOn)).append("\n");
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

