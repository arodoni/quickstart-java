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
import io.swagger.client.model.GETJournalEntryItemType;
import io.swagger.client.model.GETJournalEntrySegmentType;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;


/**
 * GETJournalEntryDetailType
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class GETJournalEntryDetailType   {
  @SerializedName("accountingPeriodName")
  private String accountingPeriodName = null;

  @SerializedName("aggregateCurrency")
  private Boolean aggregateCurrency = null;

  @SerializedName("currency")
  private String currency = null;

  @SerializedName("customField__c")
  private String customFieldC = null;

  @SerializedName("homeCurrency")
  private String homeCurrency = null;

  @SerializedName("journalEntryDate")
  private LocalDate journalEntryDate = null;

  @SerializedName("journalEntryItems")
  private List<GETJournalEntryItemType> journalEntryItems = new ArrayList<GETJournalEntryItemType>();

  @SerializedName("notes")
  private String notes = null;

  @SerializedName("number")
  private String number = null;

  @SerializedName("segments")
  private List<GETJournalEntrySegmentType> segments = new ArrayList<GETJournalEntrySegmentType>();

  @SerializedName("status")
  private String status = null;

  @SerializedName("success")
  private Boolean success = null;

  @SerializedName("timePeriodEnd")
  private LocalDate timePeriodEnd = null;

  @SerializedName("timePeriodStart")
  private LocalDate timePeriodStart = null;

  @SerializedName("transactionType")
  private String transactionType = null;

  @SerializedName("transferDateTime")
  private DateTime transferDateTime = null;

  @SerializedName("transferredBy")
  private String transferredBy = null;

  @SerializedName("transferredToAccounting")
  private String transferredToAccounting = null;

  public GETJournalEntryDetailType accountingPeriodName(String accountingPeriodName) {
    this.accountingPeriodName = accountingPeriodName;
    return this;
  }

   /**
   * Name of the accounting period that the journal entry belongs to. 
   * @return accountingPeriodName
  **/
  @ApiModelProperty(example = "null", value = "Name of the accounting period that the journal entry belongs to. ")
  public String getAccountingPeriodName() {
    return accountingPeriodName;
  }

  public void setAccountingPeriodName(String accountingPeriodName) {
    this.accountingPeriodName = accountingPeriodName;
  }

  public GETJournalEntryDetailType aggregateCurrency(Boolean aggregateCurrency) {
    this.aggregateCurrency = aggregateCurrency;
    return this;
  }

   /**
   * Returns true if the journal entry is aggregating currencies. That is, if the journal entry was created when the [Aggregate transactions with different currencies during a Journal Run](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/C_Configure_accounting_rules#Aggregate_transactions_with_different_currencies_during_a_Journal_Run) setting was configured to `Yes`. Otherwise, returns `false`. 
   * @return aggregateCurrency
  **/
  @ApiModelProperty(example = "null", value = "Returns true if the journal entry is aggregating currencies. That is, if the journal entry was created when the [Aggregate transactions with different currencies during a Journal Run](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/C_Configure_accounting_rules#Aggregate_transactions_with_different_currencies_during_a_Journal_Run) setting was configured to `Yes`. Otherwise, returns `false`. ")
  public Boolean getAggregateCurrency() {
    return aggregateCurrency;
  }

  public void setAggregateCurrency(Boolean aggregateCurrency) {
    this.aggregateCurrency = aggregateCurrency;
  }

  public GETJournalEntryDetailType currency(String currency) {
    this.currency = currency;
    return this;
  }

   /**
   * Currency used. 
   * @return currency
  **/
  @ApiModelProperty(example = "null", value = "Currency used. ")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public GETJournalEntryDetailType customFieldC(String customFieldC) {
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

  public GETJournalEntryDetailType homeCurrency(String homeCurrency) {
    this.homeCurrency = homeCurrency;
    return this;
  }

   /**
   * Home currency used. 
   * @return homeCurrency
  **/
  @ApiModelProperty(example = "null", value = "Home currency used. ")
  public String getHomeCurrency() {
    return homeCurrency;
  }

  public void setHomeCurrency(String homeCurrency) {
    this.homeCurrency = homeCurrency;
  }

  public GETJournalEntryDetailType journalEntryDate(LocalDate journalEntryDate) {
    this.journalEntryDate = journalEntryDate;
    return this;
  }

   /**
   * Date of the journal entry. 
   * @return journalEntryDate
  **/
  @ApiModelProperty(example = "null", value = "Date of the journal entry. ")
  public LocalDate getJournalEntryDate() {
    return journalEntryDate;
  }

  public void setJournalEntryDate(LocalDate journalEntryDate) {
    this.journalEntryDate = journalEntryDate;
  }

  public GETJournalEntryDetailType journalEntryItems(List<GETJournalEntryItemType> journalEntryItems) {
    this.journalEntryItems = journalEntryItems;
    return this;
  }

  public GETJournalEntryDetailType addJournalEntryItemsItem(GETJournalEntryItemType journalEntryItemsItem) {
    this.journalEntryItems.add(journalEntryItemsItem);
    return this;
  }

   /**
   * Key name that represents the list of journal entry items. 
   * @return journalEntryItems
  **/
  @ApiModelProperty(example = "null", value = "Key name that represents the list of journal entry items. ")
  public List<GETJournalEntryItemType> getJournalEntryItems() {
    return journalEntryItems;
  }

  public void setJournalEntryItems(List<GETJournalEntryItemType> journalEntryItems) {
    this.journalEntryItems = journalEntryItems;
  }

  public GETJournalEntryDetailType notes(String notes) {
    this.notes = notes;
    return this;
  }

   /**
   *  Additional information about this record. Character limit: 2,000 
   * @return notes
  **/
  @ApiModelProperty(example = "null", value = " Additional information about this record. Character limit: 2,000 ")
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public GETJournalEntryDetailType number(String number) {
    this.number = number;
    return this;
  }

   /**
   * Journal entry number in the format JE-00000001. 
   * @return number
  **/
  @ApiModelProperty(example = "null", value = "Journal entry number in the format JE-00000001. ")
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public GETJournalEntryDetailType segments(List<GETJournalEntrySegmentType> segments) {
    this.segments = segments;
    return this;
  }

  public GETJournalEntryDetailType addSegmentsItem(GETJournalEntrySegmentType segmentsItem) {
    this.segments.add(segmentsItem);
    return this;
  }

   /**
   * List of segments that apply to the summary journal entry. 
   * @return segments
  **/
  @ApiModelProperty(example = "null", value = "List of segments that apply to the summary journal entry. ")
  public List<GETJournalEntrySegmentType> getSegments() {
    return segments;
  }

  public void setSegments(List<GETJournalEntrySegmentType> segments) {
    this.segments = segments;
  }

  public GETJournalEntryDetailType status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Status of journal entry. An enum with the values `Created` or `Cancelled`. 
   * @return status
  **/
  @ApiModelProperty(example = "null", value = "Status of journal entry. An enum with the values `Created` or `Cancelled`. ")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public GETJournalEntryDetailType success(Boolean success) {
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

  public GETJournalEntryDetailType timePeriodEnd(LocalDate timePeriodEnd) {
    this.timePeriodEnd = timePeriodEnd;
    return this;
  }

   /**
   * End date of time period included in the journal entry. 
   * @return timePeriodEnd
  **/
  @ApiModelProperty(example = "null", value = "End date of time period included in the journal entry. ")
  public LocalDate getTimePeriodEnd() {
    return timePeriodEnd;
  }

  public void setTimePeriodEnd(LocalDate timePeriodEnd) {
    this.timePeriodEnd = timePeriodEnd;
  }

  public GETJournalEntryDetailType timePeriodStart(LocalDate timePeriodStart) {
    this.timePeriodStart = timePeriodStart;
    return this;
  }

   /**
   * Start date of time period included in the journal entry. 
   * @return timePeriodStart
  **/
  @ApiModelProperty(example = "null", value = "Start date of time period included in the journal entry. ")
  public LocalDate getTimePeriodStart() {
    return timePeriodStart;
  }

  public void setTimePeriodStart(LocalDate timePeriodStart) {
    this.timePeriodStart = timePeriodStart;
  }

  public GETJournalEntryDetailType transactionType(String transactionType) {
    this.transactionType = transactionType;
    return this;
  }

   /**
   * Transaction type of the transactions included in the summary journal entry. 
   * @return transactionType
  **/
  @ApiModelProperty(example = "null", value = "Transaction type of the transactions included in the summary journal entry. ")
  public String getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }

  public GETJournalEntryDetailType transferDateTime(DateTime transferDateTime) {
    this.transferDateTime = transferDateTime;
    return this;
  }

   /**
   * Date and time that transferredToAccounting was changed to `Yes`. This field is returned only when transferredToAccounting is `Yes`. Otherwise, this field is `null`. 
   * @return transferDateTime
  **/
  @ApiModelProperty(example = "null", value = "Date and time that transferredToAccounting was changed to `Yes`. This field is returned only when transferredToAccounting is `Yes`. Otherwise, this field is `null`. ")
  public DateTime getTransferDateTime() {
    return transferDateTime;
  }

  public void setTransferDateTime(DateTime transferDateTime) {
    this.transferDateTime = transferDateTime;
  }

  public GETJournalEntryDetailType transferredBy(String transferredBy) {
    this.transferredBy = transferredBy;
    return this;
  }

   /**
   * User ID of the person who changed transferredToAccounting to `Yes`. This field is returned only when transferredToAccounting is `Yes`. Otherwise, this field is `null`. 
   * @return transferredBy
  **/
  @ApiModelProperty(example = "null", value = "User ID of the person who changed transferredToAccounting to `Yes`. This field is returned only when transferredToAccounting is `Yes`. Otherwise, this field is `null`. ")
  public String getTransferredBy() {
    return transferredBy;
  }

  public void setTransferredBy(String transferredBy) {
    this.transferredBy = transferredBy;
  }

  public GETJournalEntryDetailType transferredToAccounting(String transferredToAccounting) {
    this.transferredToAccounting = transferredToAccounting;
    return this;
  }

   /**
   * Status shows whether the journal entry has been transferred to an accounting system. The possible values are `No`, `Processing`, `Yes`, `Error`, `Ignore`. 
   * @return transferredToAccounting
  **/
  @ApiModelProperty(example = "null", value = "Status shows whether the journal entry has been transferred to an accounting system. The possible values are `No`, `Processing`, `Yes`, `Error`, `Ignore`. ")
  public String getTransferredToAccounting() {
    return transferredToAccounting;
  }

  public void setTransferredToAccounting(String transferredToAccounting) {
    this.transferredToAccounting = transferredToAccounting;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GETJournalEntryDetailType gETJournalEntryDetailType = (GETJournalEntryDetailType) o;
    return Objects.equals(this.accountingPeriodName, gETJournalEntryDetailType.accountingPeriodName) &&
        Objects.equals(this.aggregateCurrency, gETJournalEntryDetailType.aggregateCurrency) &&
        Objects.equals(this.currency, gETJournalEntryDetailType.currency) &&
        Objects.equals(this.customFieldC, gETJournalEntryDetailType.customFieldC) &&
        Objects.equals(this.homeCurrency, gETJournalEntryDetailType.homeCurrency) &&
        Objects.equals(this.journalEntryDate, gETJournalEntryDetailType.journalEntryDate) &&
        Objects.equals(this.journalEntryItems, gETJournalEntryDetailType.journalEntryItems) &&
        Objects.equals(this.notes, gETJournalEntryDetailType.notes) &&
        Objects.equals(this.number, gETJournalEntryDetailType.number) &&
        Objects.equals(this.segments, gETJournalEntryDetailType.segments) &&
        Objects.equals(this.status, gETJournalEntryDetailType.status) &&
        Objects.equals(this.success, gETJournalEntryDetailType.success) &&
        Objects.equals(this.timePeriodEnd, gETJournalEntryDetailType.timePeriodEnd) &&
        Objects.equals(this.timePeriodStart, gETJournalEntryDetailType.timePeriodStart) &&
        Objects.equals(this.transactionType, gETJournalEntryDetailType.transactionType) &&
        Objects.equals(this.transferDateTime, gETJournalEntryDetailType.transferDateTime) &&
        Objects.equals(this.transferredBy, gETJournalEntryDetailType.transferredBy) &&
        Objects.equals(this.transferredToAccounting, gETJournalEntryDetailType.transferredToAccounting);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountingPeriodName, aggregateCurrency, currency, customFieldC, homeCurrency, journalEntryDate, journalEntryItems, notes, number, segments, status, success, timePeriodEnd, timePeriodStart, transactionType, transferDateTime, transferredBy, transferredToAccounting);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GETJournalEntryDetailType {\n");
    
    sb.append("    accountingPeriodName: ").append(toIndentedString(accountingPeriodName)).append("\n");
    sb.append("    aggregateCurrency: ").append(toIndentedString(aggregateCurrency)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    customFieldC: ").append(toIndentedString(customFieldC)).append("\n");
    sb.append("    homeCurrency: ").append(toIndentedString(homeCurrency)).append("\n");
    sb.append("    journalEntryDate: ").append(toIndentedString(journalEntryDate)).append("\n");
    sb.append("    journalEntryItems: ").append(toIndentedString(journalEntryItems)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    segments: ").append(toIndentedString(segments)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    timePeriodEnd: ").append(toIndentedString(timePeriodEnd)).append("\n");
    sb.append("    timePeriodStart: ").append(toIndentedString(timePeriodStart)).append("\n");
    sb.append("    transactionType: ").append(toIndentedString(transactionType)).append("\n");
    sb.append("    transferDateTime: ").append(toIndentedString(transferDateTime)).append("\n");
    sb.append("    transferredBy: ").append(toIndentedString(transferredBy)).append("\n");
    sb.append("    transferredToAccounting: ").append(toIndentedString(transferredToAccounting)).append("\n");
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

