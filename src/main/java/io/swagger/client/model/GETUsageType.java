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
 * GETUsageType
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class GETUsageType   {
  @SerializedName("accountId")
  private String accountId = null;

  @SerializedName("accountName")
  private String accountName = null;

  @SerializedName("accountNumber")
  private String accountNumber = null;

  @SerializedName("chargeNumber")
  private String chargeNumber = null;

  @SerializedName("customField__c")
  private String customFieldC = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("quantity")
  private String quantity = null;

  @SerializedName("sourceName")
  private String sourceName = null;

  @SerializedName("startDateTime")
  private DateTime startDateTime = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("submissionDateTime")
  private DateTime submissionDateTime = null;

  @SerializedName("subscriptionNumber")
  private String subscriptionNumber = null;

  @SerializedName("unitOfMeasure")
  private String unitOfMeasure = null;

  public GETUsageType accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * Customer account ID. 
   * @return accountId
  **/
  @ApiModelProperty(example = "null", value = "Customer account ID. ")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public GETUsageType accountName(String accountName) {
    this.accountName = accountName;
    return this;
  }

   /**
   * Customer account name. 
   * @return accountName
  **/
  @ApiModelProperty(example = "null", value = "Customer account name. ")
  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public GETUsageType accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

   /**
   * Customer account number. 
   * @return accountNumber
  **/
  @ApiModelProperty(example = "null", value = "Customer account number. ")
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public GETUsageType chargeNumber(String chargeNumber) {
    this.chargeNumber = chargeNumber;
    return this;
  }

   /**
   * Number of the rate-plan charge that pays for this usage. 
   * @return chargeNumber
  **/
  @ApiModelProperty(example = "null", value = "Number of the rate-plan charge that pays for this usage. ")
  public String getChargeNumber() {
    return chargeNumber;
  }

  public void setChargeNumber(String chargeNumber) {
    this.chargeNumber = chargeNumber;
  }

  public GETUsageType customFieldC(String customFieldC) {
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

  public GETUsageType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique ID for the usage item. 
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "Unique ID for the usage item. ")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GETUsageType quantity(String quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * Number of units used. 
   * @return quantity
  **/
  @ApiModelProperty(example = "null", value = "Number of units used. ")
  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public GETUsageType sourceName(String sourceName) {
    this.sourceName = sourceName;
    return this;
  }

   /**
   * Source of the usage data. Possible values are: `Import`, `API`. 
   * @return sourceName
  **/
  @ApiModelProperty(example = "null", value = "Source of the usage data. Possible values are: `Import`, `API`. ")
  public String getSourceName() {
    return sourceName;
  }

  public void setSourceName(String sourceName) {
    this.sourceName = sourceName;
  }

  public GETUsageType startDateTime(DateTime startDateTime) {
    this.startDateTime = startDateTime;
    return this;
  }

   /**
   * Start date of the time period in which usage is tracked. Zuora uses this field value to determine the usage date. 
   * @return startDateTime
  **/
  @ApiModelProperty(example = "null", value = "Start date of the time period in which usage is tracked. Zuora uses this field value to determine the usage date. ")
  public DateTime getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(DateTime startDateTime) {
    this.startDateTime = startDateTime;
  }

  public GETUsageType status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Possible values are: `Importing`, `Pending`, `Processed`. 
   * @return status
  **/
  @ApiModelProperty(example = "null", value = "Possible values are: `Importing`, `Pending`, `Processed`. ")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public GETUsageType submissionDateTime(DateTime submissionDateTime) {
    this.submissionDateTime = submissionDateTime;
    return this;
  }

   /**
   * Date when usage was submitted. 
   * @return submissionDateTime
  **/
  @ApiModelProperty(example = "null", value = "Date when usage was submitted. ")
  public DateTime getSubmissionDateTime() {
    return submissionDateTime;
  }

  public void setSubmissionDateTime(DateTime submissionDateTime) {
    this.submissionDateTime = submissionDateTime;
  }

  public GETUsageType subscriptionNumber(String subscriptionNumber) {
    this.subscriptionNumber = subscriptionNumber;
    return this;
  }

   /**
   * Number of the subscription covering this usage. 
   * @return subscriptionNumber
  **/
  @ApiModelProperty(example = "null", value = "Number of the subscription covering this usage. ")
  public String getSubscriptionNumber() {
    return subscriptionNumber;
  }

  public void setSubscriptionNumber(String subscriptionNumber) {
    this.subscriptionNumber = subscriptionNumber;
  }

  public GETUsageType unitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

   /**
   * Unit used to measure consumption, as configured in the web-based UI at **Z-Billing > Settings**. 
   * @return unitOfMeasure
  **/
  @ApiModelProperty(example = "null", value = "Unit used to measure consumption, as configured in the web-based UI at **Z-Billing > Settings**. ")
  public String getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GETUsageType gETUsageType = (GETUsageType) o;
    return Objects.equals(this.accountId, gETUsageType.accountId) &&
        Objects.equals(this.accountName, gETUsageType.accountName) &&
        Objects.equals(this.accountNumber, gETUsageType.accountNumber) &&
        Objects.equals(this.chargeNumber, gETUsageType.chargeNumber) &&
        Objects.equals(this.customFieldC, gETUsageType.customFieldC) &&
        Objects.equals(this.id, gETUsageType.id) &&
        Objects.equals(this.quantity, gETUsageType.quantity) &&
        Objects.equals(this.sourceName, gETUsageType.sourceName) &&
        Objects.equals(this.startDateTime, gETUsageType.startDateTime) &&
        Objects.equals(this.status, gETUsageType.status) &&
        Objects.equals(this.submissionDateTime, gETUsageType.submissionDateTime) &&
        Objects.equals(this.subscriptionNumber, gETUsageType.subscriptionNumber) &&
        Objects.equals(this.unitOfMeasure, gETUsageType.unitOfMeasure);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, accountName, accountNumber, chargeNumber, customFieldC, id, quantity, sourceName, startDateTime, status, submissionDateTime, subscriptionNumber, unitOfMeasure);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GETUsageType {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    chargeNumber: ").append(toIndentedString(chargeNumber)).append("\n");
    sb.append("    customFieldC: ").append(toIndentedString(customFieldC)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    sourceName: ").append(toIndentedString(sourceName)).append("\n");
    sb.append("    startDateTime: ").append(toIndentedString(startDateTime)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    submissionDateTime: ").append(toIndentedString(submissionDateTime)).append("\n");
    sb.append("    subscriptionNumber: ").append(toIndentedString(subscriptionNumber)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
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

