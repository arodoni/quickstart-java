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
 * POSTSubscriptionCancellationType
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class POSTSubscriptionCancellationType   {
  @SerializedName("OpportunityCloseDate_QT")
  private String opportunityCloseDateQT = null;

  @SerializedName("OpportunityName_QT")
  private String opportunityNameQT = null;

  @SerializedName("QuoteBusinessType_QT")
  private String quoteBusinessTypeQT = null;

  @SerializedName("QuoteNumber_QT")
  private String quoteNumberQT = null;

  @SerializedName("QuoteType_QT")
  private String quoteTypeQT = null;

  @SerializedName("applyCreditBalance")
  private Boolean applyCreditBalance = null;

  @SerializedName("cancellationEffectiveDate")
  private LocalDate cancellationEffectiveDate = null;

  @SerializedName("cancellationPolicy")
  private String cancellationPolicy = null;

  @SerializedName("collect")
  private Boolean collect = null;

  @SerializedName("invoice")
  private Boolean invoice = null;

  @SerializedName("invoiceCollect")
  private Boolean invoiceCollect = null;

  @SerializedName("invoiceTargetDate")
  private LocalDate invoiceTargetDate = null;

  public POSTSubscriptionCancellationType opportunityCloseDateQT(String opportunityCloseDateQT) {
    this.opportunityCloseDateQT = opportunityCloseDateQT;
    return this;
  }

   /**
   * The closing date of the Opportunity. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. 
   * @return opportunityCloseDateQT
  **/
  @ApiModelProperty(example = "null", value = "The closing date of the Opportunity. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. ")
  public String getOpportunityCloseDateQT() {
    return opportunityCloseDateQT;
  }

  public void setOpportunityCloseDateQT(String opportunityCloseDateQT) {
    this.opportunityCloseDateQT = opportunityCloseDateQT;
  }

  public POSTSubscriptionCancellationType opportunityNameQT(String opportunityNameQT) {
    this.opportunityNameQT = opportunityNameQT;
    return this;
  }

   /**
   * The unique identifier of the Opportunity. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. 
   * @return opportunityNameQT
  **/
  @ApiModelProperty(example = "null", value = "The unique identifier of the Opportunity. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. ")
  public String getOpportunityNameQT() {
    return opportunityNameQT;
  }

  public void setOpportunityNameQT(String opportunityNameQT) {
    this.opportunityNameQT = opportunityNameQT;
  }

  public POSTSubscriptionCancellationType quoteBusinessTypeQT(String quoteBusinessTypeQT) {
    this.quoteBusinessTypeQT = quoteBusinessTypeQT;
    return this;
  }

   /**
   * The specific identifier for the type of business transaction the Quote represents such as New, Upsell, Downsell, Renewal, or Churn. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. 
   * @return quoteBusinessTypeQT
  **/
  @ApiModelProperty(example = "null", value = "The specific identifier for the type of business transaction the Quote represents such as New, Upsell, Downsell, Renewal, or Churn. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. ")
  public String getQuoteBusinessTypeQT() {
    return quoteBusinessTypeQT;
  }

  public void setQuoteBusinessTypeQT(String quoteBusinessTypeQT) {
    this.quoteBusinessTypeQT = quoteBusinessTypeQT;
  }

  public POSTSubscriptionCancellationType quoteNumberQT(String quoteNumberQT) {
    this.quoteNumberQT = quoteNumberQT;
    return this;
  }

   /**
   * The unique identifier of the Quote. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. 
   * @return quoteNumberQT
  **/
  @ApiModelProperty(example = "null", value = "The unique identifier of the Quote. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. ")
  public String getQuoteNumberQT() {
    return quoteNumberQT;
  }

  public void setQuoteNumberQT(String quoteNumberQT) {
    this.quoteNumberQT = quoteNumberQT;
  }

  public POSTSubscriptionCancellationType quoteTypeQT(String quoteTypeQT) {
    this.quoteTypeQT = quoteTypeQT;
    return this;
  }

   /**
   * The Quote type that represents the subscription lifecycle stage such as New, Amendment, Renew or Cancel. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. 
   * @return quoteTypeQT
  **/
  @ApiModelProperty(example = "null", value = "The Quote type that represents the subscription lifecycle stage such as New, Amendment, Renew or Cancel. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information. ")
  public String getQuoteTypeQT() {
    return quoteTypeQT;
  }

  public void setQuoteTypeQT(String quoteTypeQT) {
    this.quoteTypeQT = quoteTypeQT;
  }

  public POSTSubscriptionCancellationType applyCreditBalance(Boolean applyCreditBalance) {
    this.applyCreditBalance = applyCreditBalance;
    return this;
  }

   /**
   * Applies a credit balance to an invoice.  If the value is `true`, the credit balance is applied to the invoice. If the value is `false`, no action is taken.  Prerequisite: invoice must be true.   **Note:** If you are using the field `invoiceCollect` rather than the field `invoice`, the `invoiceCollect` value must be `true`.  To view the credit balance adjustment, retrieve the details of the invoice using the Get Invoices method. 
   * @return applyCreditBalance
  **/
  @ApiModelProperty(example = "null", value = "Applies a credit balance to an invoice.  If the value is `true`, the credit balance is applied to the invoice. If the value is `false`, no action is taken.  Prerequisite: invoice must be true.   **Note:** If you are using the field `invoiceCollect` rather than the field `invoice`, the `invoiceCollect` value must be `true`.  To view the credit balance adjustment, retrieve the details of the invoice using the Get Invoices method. ")
  public Boolean getApplyCreditBalance() {
    return applyCreditBalance;
  }

  public void setApplyCreditBalance(Boolean applyCreditBalance) {
    this.applyCreditBalance = applyCreditBalance;
  }

  public POSTSubscriptionCancellationType cancellationEffectiveDate(LocalDate cancellationEffectiveDate) {
    this.cancellationEffectiveDate = cancellationEffectiveDate;
    return this;
  }

   /**
   * Date the cancellation takes effect, in the format yyyy-mm-dd.  Use only if `cancellationPolicy` is `SpecificDate`. Should not be earlier than the subscription contract-effective date, later than the subscription term-end date, or within a period for which the customer has been invoiced. 
   * @return cancellationEffectiveDate
  **/
  @ApiModelProperty(example = "null", value = "Date the cancellation takes effect, in the format yyyy-mm-dd.  Use only if `cancellationPolicy` is `SpecificDate`. Should not be earlier than the subscription contract-effective date, later than the subscription term-end date, or within a period for which the customer has been invoiced. ")
  public LocalDate getCancellationEffectiveDate() {
    return cancellationEffectiveDate;
  }

  public void setCancellationEffectiveDate(LocalDate cancellationEffectiveDate) {
    this.cancellationEffectiveDate = cancellationEffectiveDate;
  }

  public POSTSubscriptionCancellationType cancellationPolicy(String cancellationPolicy) {
    this.cancellationPolicy = cancellationPolicy;
    return this;
  }

   /**
   * Cancellation method. Possible values are: `EndOfCurrentTerm`, `EndOfLastInvoicePeriod`, `SpecificDate`. If using `SpecificDate`, the `cancellationEffectiveDate` field is required. 
   * @return cancellationPolicy
  **/
  @ApiModelProperty(example = "null", required = true, value = "Cancellation method. Possible values are: `EndOfCurrentTerm`, `EndOfLastInvoicePeriod`, `SpecificDate`. If using `SpecificDate`, the `cancellationEffectiveDate` field is required. ")
  public String getCancellationPolicy() {
    return cancellationPolicy;
  }

  public void setCancellationPolicy(String cancellationPolicy) {
    this.cancellationPolicy = cancellationPolicy;
  }

  public POSTSubscriptionCancellationType collect(Boolean collect) {
    this.collect = collect;
    return this;
  }

   /**
   * Collects an automatic payment for a subscription. The collection generated in this operation is only for this subscription, not for the entire customer account.  If the value is `true`, the automatic payment is collected. If the value is `false`, no action is taken.  The default value is `false`.  This field is in Zuora REST API version control. Supported minor versions are 196.0 or later. To use this field in the method, you must set the `zuora-version` parameter to the minor version number in the request header. See [Zuora REST API Versions](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics#Zuora_REST_API_Versions) for more information.  Prerequisite: `invoice` must be `true`.  
   * @return collect
  **/
  @ApiModelProperty(example = "null", value = "Collects an automatic payment for a subscription. The collection generated in this operation is only for this subscription, not for the entire customer account.  If the value is `true`, the automatic payment is collected. If the value is `false`, no action is taken.  The default value is `false`.  This field is in Zuora REST API version control. Supported minor versions are 196.0 or later. To use this field in the method, you must set the `zuora-version` parameter to the minor version number in the request header. See [Zuora REST API Versions](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics#Zuora_REST_API_Versions) for more information.  Prerequisite: `invoice` must be `true`.  ")
  public Boolean getCollect() {
    return collect;
  }

  public void setCollect(Boolean collect) {
    this.collect = collect;
  }

  public POSTSubscriptionCancellationType invoice(Boolean invoice) {
    this.invoice = invoice;
    return this;
  }

   /**
   * Creates an invoice for a subscription. The invoice generated in this operation is only for this subscription, not for the entire customer account.  If the value is `true`, an invoice is created. If the value is `false`, no action is taken.  The default value is `false`.   This field is in Zuora REST API version control. Supported minor versions are 196.0 or later. To use this field in the method, you must set the `zuora-version` parameter to the minor version number in the request header. See [Zuora REST API Versions](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics#Zuora_REST_API_Versions) for more information. 
   * @return invoice
  **/
  @ApiModelProperty(example = "null", value = "Creates an invoice for a subscription. The invoice generated in this operation is only for this subscription, not for the entire customer account.  If the value is `true`, an invoice is created. If the value is `false`, no action is taken.  The default value is `false`.   This field is in Zuora REST API version control. Supported minor versions are 196.0 or later. To use this field in the method, you must set the `zuora-version` parameter to the minor version number in the request header. See [Zuora REST API Versions](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics#Zuora_REST_API_Versions) for more information. ")
  public Boolean getInvoice() {
    return invoice;
  }

  public void setInvoice(Boolean invoice) {
    this.invoice = invoice;
  }

  public POSTSubscriptionCancellationType invoiceCollect(Boolean invoiceCollect) {
    this.invoiceCollect = invoiceCollect;
    return this;
  }

   /**
   * This field has been replaced by the `invoice` field and the `collect` field. `invoiceCollect` is available only for backward compatibility.  If `true`, an invoice is generated and payment automatically collected. Default is `false`.  This field is in Zuora REST API version control. Supported minor versions are 186.0, 187.0, 188.0, 189.0, and 196.0. See [Zuora REST API Versions](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics#Zuora_REST_API_Versions) for more information. 
   * @return invoiceCollect
  **/
  @ApiModelProperty(example = "null", required = true, value = "This field has been replaced by the `invoice` field and the `collect` field. `invoiceCollect` is available only for backward compatibility.  If `true`, an invoice is generated and payment automatically collected. Default is `false`.  This field is in Zuora REST API version control. Supported minor versions are 186.0, 187.0, 188.0, 189.0, and 196.0. See [Zuora REST API Versions](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics#Zuora_REST_API_Versions) for more information. ")
  public Boolean getInvoiceCollect() {
    return invoiceCollect;
  }

  public void setInvoiceCollect(Boolean invoiceCollect) {
    this.invoiceCollect = invoiceCollect;
  }

  public POSTSubscriptionCancellationType invoiceTargetDate(LocalDate invoiceTargetDate) {
    this.invoiceTargetDate = invoiceTargetDate;
    return this;
  }

   /**
   * If an invoice is to be generated, the date through which to calculate the charges, as yyyy-mm-dd 
   * @return invoiceTargetDate
  **/
  @ApiModelProperty(example = "null", value = "If an invoice is to be generated, the date through which to calculate the charges, as yyyy-mm-dd ")
  public LocalDate getInvoiceTargetDate() {
    return invoiceTargetDate;
  }

  public void setInvoiceTargetDate(LocalDate invoiceTargetDate) {
    this.invoiceTargetDate = invoiceTargetDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    POSTSubscriptionCancellationType pOSTSubscriptionCancellationType = (POSTSubscriptionCancellationType) o;
    return Objects.equals(this.opportunityCloseDateQT, pOSTSubscriptionCancellationType.opportunityCloseDateQT) &&
        Objects.equals(this.opportunityNameQT, pOSTSubscriptionCancellationType.opportunityNameQT) &&
        Objects.equals(this.quoteBusinessTypeQT, pOSTSubscriptionCancellationType.quoteBusinessTypeQT) &&
        Objects.equals(this.quoteNumberQT, pOSTSubscriptionCancellationType.quoteNumberQT) &&
        Objects.equals(this.quoteTypeQT, pOSTSubscriptionCancellationType.quoteTypeQT) &&
        Objects.equals(this.applyCreditBalance, pOSTSubscriptionCancellationType.applyCreditBalance) &&
        Objects.equals(this.cancellationEffectiveDate, pOSTSubscriptionCancellationType.cancellationEffectiveDate) &&
        Objects.equals(this.cancellationPolicy, pOSTSubscriptionCancellationType.cancellationPolicy) &&
        Objects.equals(this.collect, pOSTSubscriptionCancellationType.collect) &&
        Objects.equals(this.invoice, pOSTSubscriptionCancellationType.invoice) &&
        Objects.equals(this.invoiceCollect, pOSTSubscriptionCancellationType.invoiceCollect) &&
        Objects.equals(this.invoiceTargetDate, pOSTSubscriptionCancellationType.invoiceTargetDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(opportunityCloseDateQT, opportunityNameQT, quoteBusinessTypeQT, quoteNumberQT, quoteTypeQT, applyCreditBalance, cancellationEffectiveDate, cancellationPolicy, collect, invoice, invoiceCollect, invoiceTargetDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class POSTSubscriptionCancellationType {\n");
    
    sb.append("    opportunityCloseDateQT: ").append(toIndentedString(opportunityCloseDateQT)).append("\n");
    sb.append("    opportunityNameQT: ").append(toIndentedString(opportunityNameQT)).append("\n");
    sb.append("    quoteBusinessTypeQT: ").append(toIndentedString(quoteBusinessTypeQT)).append("\n");
    sb.append("    quoteNumberQT: ").append(toIndentedString(quoteNumberQT)).append("\n");
    sb.append("    quoteTypeQT: ").append(toIndentedString(quoteTypeQT)).append("\n");
    sb.append("    applyCreditBalance: ").append(toIndentedString(applyCreditBalance)).append("\n");
    sb.append("    cancellationEffectiveDate: ").append(toIndentedString(cancellationEffectiveDate)).append("\n");
    sb.append("    cancellationPolicy: ").append(toIndentedString(cancellationPolicy)).append("\n");
    sb.append("    collect: ").append(toIndentedString(collect)).append("\n");
    sb.append("    invoice: ").append(toIndentedString(invoice)).append("\n");
    sb.append("    invoiceCollect: ").append(toIndentedString(invoiceCollect)).append("\n");
    sb.append("    invoiceTargetDate: ").append(toIndentedString(invoiceTargetDate)).append("\n");
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

