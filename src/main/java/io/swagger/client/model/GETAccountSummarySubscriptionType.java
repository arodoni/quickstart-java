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
import io.swagger.client.model.GETAccountSummarySubscriptionRatePlanType;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDate;


/**
 * GETAccountSummarySubscriptionType
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class GETAccountSummarySubscriptionType   {
  @SerializedName("CpqBundleJsonId__QT")
  private String cpqBundleJsonIdQT = null;

  @SerializedName("OpportunityCloseDate__QT")
  private String opportunityCloseDateQT = null;

  @SerializedName("OpportunityName__QT")
  private String opportunityNameQT = null;

  @SerializedName("QuoteBusinessType__QT")
  private String quoteBusinessTypeQT = null;

  @SerializedName("QuoteNumber__QT")
  private String quoteNumberQT = null;

  @SerializedName("QuoteType__QT")
  private String quoteTypeQT = null;

  @SerializedName("autoRenew")
  private Boolean autoRenew = null;

  @SerializedName("customField__c")
  private String customFieldC = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("initialTerm")
  private String initialTerm = null;

  @SerializedName("ratePlans")
  private List<GETAccountSummarySubscriptionRatePlanType> ratePlans = new ArrayList<GETAccountSummarySubscriptionRatePlanType>();

  @SerializedName("renewalTerm")
  private String renewalTerm = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("subscriptionNumber")
  private String subscriptionNumber = null;

  @SerializedName("subscriptionStartDate")
  private LocalDate subscriptionStartDate = null;

  @SerializedName("termEndDate")
  private LocalDate termEndDate = null;

  @SerializedName("termStartDate")
  private LocalDate termStartDate = null;

  @SerializedName("termType")
  private String termType = null;

  public GETAccountSummarySubscriptionType cpqBundleJsonIdQT(String cpqBundleJsonIdQT) {
    this.cpqBundleJsonIdQT = cpqBundleJsonIdQT;
    return this;
  }

   /**
   * dummy
   * @return cpqBundleJsonIdQT
  **/
  @ApiModelProperty(example = "null", value = "dummy")
  public String getCpqBundleJsonIdQT() {
    return cpqBundleJsonIdQT;
  }

  public void setCpqBundleJsonIdQT(String cpqBundleJsonIdQT) {
    this.cpqBundleJsonIdQT = cpqBundleJsonIdQT;
  }

  public GETAccountSummarySubscriptionType opportunityCloseDateQT(String opportunityCloseDateQT) {
    this.opportunityCloseDateQT = opportunityCloseDateQT;
    return this;
  }

   /**
   * dummy
   * @return opportunityCloseDateQT
  **/
  @ApiModelProperty(example = "null", value = "dummy")
  public String getOpportunityCloseDateQT() {
    return opportunityCloseDateQT;
  }

  public void setOpportunityCloseDateQT(String opportunityCloseDateQT) {
    this.opportunityCloseDateQT = opportunityCloseDateQT;
  }

  public GETAccountSummarySubscriptionType opportunityNameQT(String opportunityNameQT) {
    this.opportunityNameQT = opportunityNameQT;
    return this;
  }

   /**
   * dummy
   * @return opportunityNameQT
  **/
  @ApiModelProperty(example = "null", value = "dummy")
  public String getOpportunityNameQT() {
    return opportunityNameQT;
  }

  public void setOpportunityNameQT(String opportunityNameQT) {
    this.opportunityNameQT = opportunityNameQT;
  }

  public GETAccountSummarySubscriptionType quoteBusinessTypeQT(String quoteBusinessTypeQT) {
    this.quoteBusinessTypeQT = quoteBusinessTypeQT;
    return this;
  }

   /**
   * dummy
   * @return quoteBusinessTypeQT
  **/
  @ApiModelProperty(example = "null", value = "dummy")
  public String getQuoteBusinessTypeQT() {
    return quoteBusinessTypeQT;
  }

  public void setQuoteBusinessTypeQT(String quoteBusinessTypeQT) {
    this.quoteBusinessTypeQT = quoteBusinessTypeQT;
  }

  public GETAccountSummarySubscriptionType quoteNumberQT(String quoteNumberQT) {
    this.quoteNumberQT = quoteNumberQT;
    return this;
  }

   /**
   * dummy
   * @return quoteNumberQT
  **/
  @ApiModelProperty(example = "null", value = "dummy")
  public String getQuoteNumberQT() {
    return quoteNumberQT;
  }

  public void setQuoteNumberQT(String quoteNumberQT) {
    this.quoteNumberQT = quoteNumberQT;
  }

  public GETAccountSummarySubscriptionType quoteTypeQT(String quoteTypeQT) {
    this.quoteTypeQT = quoteTypeQT;
    return this;
  }

   /**
   * dummy
   * @return quoteTypeQT
  **/
  @ApiModelProperty(example = "null", value = "dummy")
  public String getQuoteTypeQT() {
    return quoteTypeQT;
  }

  public void setQuoteTypeQT(String quoteTypeQT) {
    this.quoteTypeQT = quoteTypeQT;
  }

  public GETAccountSummarySubscriptionType autoRenew(Boolean autoRenew) {
    this.autoRenew = autoRenew;
    return this;
  }

   /**
   * If `true`, auto-renew is enabled. If `false`, auto-renew is disabled. 
   * @return autoRenew
  **/
  @ApiModelProperty(example = "null", value = "If `true`, auto-renew is enabled. If `false`, auto-renew is disabled. ")
  public Boolean getAutoRenew() {
    return autoRenew;
  }

  public void setAutoRenew(Boolean autoRenew) {
    this.autoRenew = autoRenew;
  }

  public GETAccountSummarySubscriptionType customFieldC(String customFieldC) {
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

  public GETAccountSummarySubscriptionType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Subscription ID. 
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "Subscription ID. ")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GETAccountSummarySubscriptionType initialTerm(String initialTerm) {
    this.initialTerm = initialTerm;
    return this;
  }

   /**
   * Duration of the initial subscription term in whole months.  
   * @return initialTerm
  **/
  @ApiModelProperty(example = "null", value = "Duration of the initial subscription term in whole months.  ")
  public String getInitialTerm() {
    return initialTerm;
  }

  public void setInitialTerm(String initialTerm) {
    this.initialTerm = initialTerm;
  }

  public GETAccountSummarySubscriptionType ratePlans(List<GETAccountSummarySubscriptionRatePlanType> ratePlans) {
    this.ratePlans = ratePlans;
    return this;
  }

  public GETAccountSummarySubscriptionType addRatePlansItem(GETAccountSummarySubscriptionRatePlanType ratePlansItem) {
    this.ratePlans.add(ratePlansItem);
    return this;
  }

   /**
   * Container for rate plans for this subscription. 
   * @return ratePlans
  **/
  @ApiModelProperty(example = "null", value = "Container for rate plans for this subscription. ")
  public List<GETAccountSummarySubscriptionRatePlanType> getRatePlans() {
    return ratePlans;
  }

  public void setRatePlans(List<GETAccountSummarySubscriptionRatePlanType> ratePlans) {
    this.ratePlans = ratePlans;
  }

  public GETAccountSummarySubscriptionType renewalTerm(String renewalTerm) {
    this.renewalTerm = renewalTerm;
    return this;
  }

   /**
   * Duration of the renewal term in whole months. 
   * @return renewalTerm
  **/
  @ApiModelProperty(example = "null", value = "Duration of the renewal term in whole months. ")
  public String getRenewalTerm() {
    return renewalTerm;
  }

  public void setRenewalTerm(String renewalTerm) {
    this.renewalTerm = renewalTerm;
  }

  public GETAccountSummarySubscriptionType status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Subscription status; possible values are: `Draft`, `PendingActivation`, `PendingAcceptance`, `Active`, `Cancelled`, `Expired`. 
   * @return status
  **/
  @ApiModelProperty(example = "null", value = "Subscription status; possible values are: `Draft`, `PendingActivation`, `PendingAcceptance`, `Active`, `Cancelled`, `Expired`. ")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public GETAccountSummarySubscriptionType subscriptionNumber(String subscriptionNumber) {
    this.subscriptionNumber = subscriptionNumber;
    return this;
  }

   /**
   * Subscription Number. 
   * @return subscriptionNumber
  **/
  @ApiModelProperty(example = "null", value = "Subscription Number. ")
  public String getSubscriptionNumber() {
    return subscriptionNumber;
  }

  public void setSubscriptionNumber(String subscriptionNumber) {
    this.subscriptionNumber = subscriptionNumber;
  }

  public GETAccountSummarySubscriptionType subscriptionStartDate(LocalDate subscriptionStartDate) {
    this.subscriptionStartDate = subscriptionStartDate;
    return this;
  }

   /**
   * Subscription start date. 
   * @return subscriptionStartDate
  **/
  @ApiModelProperty(example = "null", value = "Subscription start date. ")
  public LocalDate getSubscriptionStartDate() {
    return subscriptionStartDate;
  }

  public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
    this.subscriptionStartDate = subscriptionStartDate;
  }

  public GETAccountSummarySubscriptionType termEndDate(LocalDate termEndDate) {
    this.termEndDate = termEndDate;
    return this;
  }

   /**
   * End date of the subscription term. If the subscription is evergreen, this is either null or equal to the cancellation date, as appropriate. 
   * @return termEndDate
  **/
  @ApiModelProperty(example = "null", value = "End date of the subscription term. If the subscription is evergreen, this is either null or equal to the cancellation date, as appropriate. ")
  public LocalDate getTermEndDate() {
    return termEndDate;
  }

  public void setTermEndDate(LocalDate termEndDate) {
    this.termEndDate = termEndDate;
  }

  public GETAccountSummarySubscriptionType termStartDate(LocalDate termStartDate) {
    this.termStartDate = termStartDate;
    return this;
  }

   /**
   * Start date of the subscription term. If this is a renewal subscription, this date is different than the subscription start date. 
   * @return termStartDate
  **/
  @ApiModelProperty(example = "null", value = "Start date of the subscription term. If this is a renewal subscription, this date is different than the subscription start date. ")
  public LocalDate getTermStartDate() {
    return termStartDate;
  }

  public void setTermStartDate(LocalDate termStartDate) {
    this.termStartDate = termStartDate;
  }

  public GETAccountSummarySubscriptionType termType(String termType) {
    this.termType = termType;
    return this;
  }

   /**
   * Possible values are: `TERMED`, `EVERGREEN`. 
   * @return termType
  **/
  @ApiModelProperty(example = "null", value = "Possible values are: `TERMED`, `EVERGREEN`. ")
  public String getTermType() {
    return termType;
  }

  public void setTermType(String termType) {
    this.termType = termType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GETAccountSummarySubscriptionType gETAccountSummarySubscriptionType = (GETAccountSummarySubscriptionType) o;
    return Objects.equals(this.cpqBundleJsonIdQT, gETAccountSummarySubscriptionType.cpqBundleJsonIdQT) &&
        Objects.equals(this.opportunityCloseDateQT, gETAccountSummarySubscriptionType.opportunityCloseDateQT) &&
        Objects.equals(this.opportunityNameQT, gETAccountSummarySubscriptionType.opportunityNameQT) &&
        Objects.equals(this.quoteBusinessTypeQT, gETAccountSummarySubscriptionType.quoteBusinessTypeQT) &&
        Objects.equals(this.quoteNumberQT, gETAccountSummarySubscriptionType.quoteNumberQT) &&
        Objects.equals(this.quoteTypeQT, gETAccountSummarySubscriptionType.quoteTypeQT) &&
        Objects.equals(this.autoRenew, gETAccountSummarySubscriptionType.autoRenew) &&
        Objects.equals(this.customFieldC, gETAccountSummarySubscriptionType.customFieldC) &&
        Objects.equals(this.id, gETAccountSummarySubscriptionType.id) &&
        Objects.equals(this.initialTerm, gETAccountSummarySubscriptionType.initialTerm) &&
        Objects.equals(this.ratePlans, gETAccountSummarySubscriptionType.ratePlans) &&
        Objects.equals(this.renewalTerm, gETAccountSummarySubscriptionType.renewalTerm) &&
        Objects.equals(this.status, gETAccountSummarySubscriptionType.status) &&
        Objects.equals(this.subscriptionNumber, gETAccountSummarySubscriptionType.subscriptionNumber) &&
        Objects.equals(this.subscriptionStartDate, gETAccountSummarySubscriptionType.subscriptionStartDate) &&
        Objects.equals(this.termEndDate, gETAccountSummarySubscriptionType.termEndDate) &&
        Objects.equals(this.termStartDate, gETAccountSummarySubscriptionType.termStartDate) &&
        Objects.equals(this.termType, gETAccountSummarySubscriptionType.termType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cpqBundleJsonIdQT, opportunityCloseDateQT, opportunityNameQT, quoteBusinessTypeQT, quoteNumberQT, quoteTypeQT, autoRenew, customFieldC, id, initialTerm, ratePlans, renewalTerm, status, subscriptionNumber, subscriptionStartDate, termEndDate, termStartDate, termType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GETAccountSummarySubscriptionType {\n");
    
    sb.append("    cpqBundleJsonIdQT: ").append(toIndentedString(cpqBundleJsonIdQT)).append("\n");
    sb.append("    opportunityCloseDateQT: ").append(toIndentedString(opportunityCloseDateQT)).append("\n");
    sb.append("    opportunityNameQT: ").append(toIndentedString(opportunityNameQT)).append("\n");
    sb.append("    quoteBusinessTypeQT: ").append(toIndentedString(quoteBusinessTypeQT)).append("\n");
    sb.append("    quoteNumberQT: ").append(toIndentedString(quoteNumberQT)).append("\n");
    sb.append("    quoteTypeQT: ").append(toIndentedString(quoteTypeQT)).append("\n");
    sb.append("    autoRenew: ").append(toIndentedString(autoRenew)).append("\n");
    sb.append("    customFieldC: ").append(toIndentedString(customFieldC)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    initialTerm: ").append(toIndentedString(initialTerm)).append("\n");
    sb.append("    ratePlans: ").append(toIndentedString(ratePlans)).append("\n");
    sb.append("    renewalTerm: ").append(toIndentedString(renewalTerm)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    subscriptionNumber: ").append(toIndentedString(subscriptionNumber)).append("\n");
    sb.append("    subscriptionStartDate: ").append(toIndentedString(subscriptionStartDate)).append("\n");
    sb.append("    termEndDate: ").append(toIndentedString(termEndDate)).append("\n");
    sb.append("    termStartDate: ").append(toIndentedString(termStartDate)).append("\n");
    sb.append("    termType: ").append(toIndentedString(termType)).append("\n");
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

