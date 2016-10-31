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
 * ProxyGetInvoiceItem
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class ProxyGetInvoiceItem   {
  @SerializedName("AccountingCode")
  private String accountingCode = null;

  @SerializedName("AppliedToInvoiceItemId")
  private String appliedToInvoiceItemId = null;

  @SerializedName("ChargeAmount")
  private Double chargeAmount = null;

  @SerializedName("ChargeDate")
  private DateTime chargeDate = null;

  @SerializedName("ChargeName")
  private String chargeName = null;

  @SerializedName("CreatedById")
  private String createdById = null;

  @SerializedName("CreatedDate")
  private DateTime createdDate = null;

  @SerializedName("Id")
  private String id = null;

  @SerializedName("InvoiceId")
  private String invoiceId = null;

  @SerializedName("ProcessingType")
  private Double processingType = null;

  @SerializedName("ProductDescription")
  private String productDescription = null;

  @SerializedName("Quantity")
  private Double quantity = null;

  @SerializedName("RatePlanChargeId")
  private String ratePlanChargeId = null;

  @SerializedName("RevRecStartDate")
  private LocalDate revRecStartDate = null;

  @SerializedName("SKU")
  private String SKU = null;

  @SerializedName("ServiceEndDate")
  private LocalDate serviceEndDate = null;

  @SerializedName("ServiceStartDate")
  private LocalDate serviceStartDate = null;

  @SerializedName("SubscriptionId")
  private String subscriptionId = null;

  @SerializedName("TaxAmount")
  private Double taxAmount = null;

  @SerializedName("TaxCode")
  private String taxCode = null;

  @SerializedName("TaxExemptAmount")
  private Double taxExemptAmount = null;

  @SerializedName("TaxMode")
  private String taxMode = null;

  @SerializedName("UOM")
  private String UOM = null;

  @SerializedName("UnitPrice")
  private Double unitPrice = null;

  @SerializedName("UpdatedById")
  private String updatedById = null;

  @SerializedName("UpdatedDate")
  private DateTime updatedDate = null;

  public ProxyGetInvoiceItem accountingCode(String accountingCode) {
    this.accountingCode = accountingCode;
    return this;
  }

   /**
   *  The accounting code for the item's charge. Accounting codes group transactions that contain similar accounting attributes. **Character limit**: 100 **Values**: inherited from `RatePlanCharge.AccountingCode` 
   * @return accountingCode
  **/
  @ApiModelProperty(example = "null", value = " The accounting code for the item's charge. Accounting codes group transactions that contain similar accounting attributes. **Character limit**: 100 **Values**: inherited from `RatePlanCharge.AccountingCode` ")
  public String getAccountingCode() {
    return accountingCode;
  }

  public void setAccountingCode(String accountingCode) {
    this.accountingCode = accountingCode;
  }

  public ProxyGetInvoiceItem appliedToInvoiceItemId(String appliedToInvoiceItemId) {
    this.appliedToInvoiceItemId = appliedToInvoiceItemId;
    return this;
  }

   /**
   *  Associates a discount invoice item to a specific invoice item. **Character limit**: 32 **Values**: inherited from the ID of the charge that a discount applies to 
   * @return appliedToInvoiceItemId
  **/
  @ApiModelProperty(example = "null", value = " Associates a discount invoice item to a specific invoice item. **Character limit**: 32 **Values**: inherited from the ID of the charge that a discount applies to ")
  public String getAppliedToInvoiceItemId() {
    return appliedToInvoiceItemId;
  }

  public void setAppliedToInvoiceItemId(String appliedToInvoiceItemId) {
    this.appliedToInvoiceItemId = appliedToInvoiceItemId;
  }

  public ProxyGetInvoiceItem chargeAmount(Double chargeAmount) {
    this.chargeAmount = chargeAmount;
    return this;
  }

   /**
   *  The amount being charged for the invoice item. This amount doesn't include taxes regardless if the charge's tax mode is inclusive or exclusive. **Character limit**: **Values**: automatically calculated from multiple fields in multiple objects 
   * @return chargeAmount
  **/
  @ApiModelProperty(example = "null", value = " The amount being charged for the invoice item. This amount doesn't include taxes regardless if the charge's tax mode is inclusive or exclusive. **Character limit**: **Values**: automatically calculated from multiple fields in multiple objects ")
  public Double getChargeAmount() {
    return chargeAmount;
  }

  public void setChargeAmount(Double chargeAmount) {
    this.chargeAmount = chargeAmount;
  }

  public ProxyGetInvoiceItem chargeDate(DateTime chargeDate) {
    this.chargeDate = chargeDate;
    return this;
  }

   /**
   *  The date when the Invoice Item is created . **Character limit**: 29 **Values**: automatically generated 
   * @return chargeDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the Invoice Item is created . **Character limit**: 29 **Values**: automatically generated ")
  public DateTime getChargeDate() {
    return chargeDate;
  }

  public void setChargeDate(DateTime chargeDate) {
    this.chargeDate = chargeDate;
  }

  public ProxyGetInvoiceItem chargeName(String chargeName) {
    this.chargeName = chargeName;
    return this;
  }

   /**
   *  The name of the invoice item's charge. **Character limi**t: 50 **Values: **inherited from `RatePlanCharge.Name` 
   * @return chargeName
  **/
  @ApiModelProperty(example = "null", value = " The name of the invoice item's charge. **Character limi**t: 50 **Values: **inherited from `RatePlanCharge.Name` ")
  public String getChargeName() {
    return chargeName;
  }

  public void setChargeName(String chargeName) {
    this.chargeName = chargeName;
  }

  public ProxyGetInvoiceItem createdById(String createdById) {
    this.createdById = createdById;
    return this;
  }

   /**
   *  The user ID of the person who created the invoice item. **Character limit**: 32 **Values**: automatically generated 
   * @return createdById
  **/
  @ApiModelProperty(example = "null", value = " The user ID of the person who created the invoice item. **Character limit**: 32 **Values**: automatically generated ")
  public String getCreatedById() {
    return createdById;
  }

  public void setCreatedById(String createdById) {
    this.createdById = createdById;
  }

  public ProxyGetInvoiceItem createdDate(DateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }

   /**
   *  The date the invoice item was created. **Character limit:** 29 **Values**: automatically generated 
   * @return createdDate
  **/
  @ApiModelProperty(example = "null", value = " The date the invoice item was created. **Character limit:** 29 **Values**: automatically generated ")
  public DateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(DateTime createdDate) {
    this.createdDate = createdDate;
  }

  public ProxyGetInvoiceItem id(String id) {
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

  public ProxyGetInvoiceItem invoiceId(String invoiceId) {
    this.invoiceId = invoiceId;
    return this;
  }

   /**
   *  The ID of the invoice that's associated with this invoice item. **Character limit**: 32 **Values**: inherited from `Invoice.Id` 
   * @return invoiceId
  **/
  @ApiModelProperty(example = "null", value = " The ID of the invoice that's associated with this invoice item. **Character limit**: 32 **Values**: inherited from `Invoice.Id` ")
  public String getInvoiceId() {
    return invoiceId;
  }

  public void setInvoiceId(String invoiceId) {
    this.invoiceId = invoiceId;
  }

  public ProxyGetInvoiceItem processingType(Double processingType) {
    this.processingType = processingType;
    return this;
  }

   /**
   *  Identifies the kind of charge where 0 is a charge, 1 is a discount, 2 is a prepayment, and 3 is a tax. The returned value is text not decimal on data sources. **Character limit**: **Values: **  - 0: charge - 1: discount - 2: prepayment - 3: tax 
   * @return processingType
  **/
  @ApiModelProperty(example = "null", value = " Identifies the kind of charge where 0 is a charge, 1 is a discount, 2 is a prepayment, and 3 is a tax. The returned value is text not decimal on data sources. **Character limit**: **Values: **  - 0: charge - 1: discount - 2: prepayment - 3: tax ")
  public Double getProcessingType() {
    return processingType;
  }

  public void setProcessingType(Double processingType) {
    this.processingType = processingType;
  }

  public ProxyGetInvoiceItem productDescription(String productDescription) {
    this.productDescription = productDescription;
    return this;
  }

   /**
   *  A description of the product associated with this invoice item. **Character limit**: 500 **Values**: inherited from `Product.Description` 
   * @return productDescription
  **/
  @ApiModelProperty(example = "null", value = " A description of the product associated with this invoice item. **Character limit**: 500 **Values**: inherited from `Product.Description` ")
  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public ProxyGetInvoiceItem quantity(Double quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   *  The number of units for this invoice item. **Values**: inherited from `RatePlanCharge.Quantity` 
   * @return quantity
  **/
  @ApiModelProperty(example = "null", value = " The number of units for this invoice item. **Values**: inherited from `RatePlanCharge.Quantity` ")
  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public ProxyGetInvoiceItem ratePlanChargeId(String ratePlanChargeId) {
    this.ratePlanChargeId = ratePlanChargeId;
    return this;
  }

   /**
   *  The ID of the rate plan charge that's associated with this invoice item. **Character limit**: 32 **Values**: inherited from `RatePlanCharge.Id` 
   * @return ratePlanChargeId
  **/
  @ApiModelProperty(example = "null", value = " The ID of the rate plan charge that's associated with this invoice item. **Character limit**: 32 **Values**: inherited from `RatePlanCharge.Id` ")
  public String getRatePlanChargeId() {
    return ratePlanChargeId;
  }

  public void setRatePlanChargeId(String ratePlanChargeId) {
    this.ratePlanChargeId = ratePlanChargeId;
  }

  public ProxyGetInvoiceItem revRecStartDate(LocalDate revRecStartDate) {
    this.revRecStartDate = revRecStartDate;
    return this;
  }

   /**
   *  The date when revenue recognition is triggered. **Character limit**: 29 **Values**: generated from `InvoiceItem.RevRecTriggerCondition` 
   * @return revRecStartDate
  **/
  @ApiModelProperty(example = "null", value = " The date when revenue recognition is triggered. **Character limit**: 29 **Values**: generated from `InvoiceItem.RevRecTriggerCondition` ")
  public LocalDate getRevRecStartDate() {
    return revRecStartDate;
  }

  public void setRevRecStartDate(LocalDate revRecStartDate) {
    this.revRecStartDate = revRecStartDate;
  }

  public ProxyGetInvoiceItem SKU(String SKU) {
    this.SKU = SKU;
    return this;
  }

   /**
   *  The unique SKU for the product associated with this invoice item. **Character limit**: 255 **Values**: inherited from `Product.SKU` 
   * @return SKU
  **/
  @ApiModelProperty(example = "null", value = " The unique SKU for the product associated with this invoice item. **Character limit**: 255 **Values**: inherited from `Product.SKU` ")
  public String getSKU() {
    return SKU;
  }

  public void setSKU(String SKU) {
    this.SKU = SKU;
  }

  public ProxyGetInvoiceItem serviceEndDate(LocalDate serviceEndDate) {
    this.serviceEndDate = serviceEndDate;
    return this;
  }

   /**
   *  The end date of the service period associated with this invoice item. Service ends one second before the date in this value. **Character limit**: 29 **Values**: automatically generated 
   * @return serviceEndDate
  **/
  @ApiModelProperty(example = "null", value = " The end date of the service period associated with this invoice item. Service ends one second before the date in this value. **Character limit**: 29 **Values**: automatically generated ")
  public LocalDate getServiceEndDate() {
    return serviceEndDate;
  }

  public void setServiceEndDate(LocalDate serviceEndDate) {
    this.serviceEndDate = serviceEndDate;
  }

  public ProxyGetInvoiceItem serviceStartDate(LocalDate serviceStartDate) {
    this.serviceStartDate = serviceStartDate;
    return this;
  }

   /**
   *  The start date of the service period associated with this invoice item. If the associated charge is a one-time fee, then this date is the date of that charge. **Character limit:** 29 **Values**: automatically generated 
   * @return serviceStartDate
  **/
  @ApiModelProperty(example = "null", value = " The start date of the service period associated with this invoice item. If the associated charge is a one-time fee, then this date is the date of that charge. **Character limit:** 29 **Values**: automatically generated ")
  public LocalDate getServiceStartDate() {
    return serviceStartDate;
  }

  public void setServiceStartDate(LocalDate serviceStartDate) {
    this.serviceStartDate = serviceStartDate;
  }

  public ProxyGetInvoiceItem subscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
    return this;
  }

   /**
   *  The ID of the subscription associated with the invoice item. **Character limit**: 32 **Values**: inherited from `Subscription.Id` 
   * @return subscriptionId
  **/
  @ApiModelProperty(example = "null", value = " The ID of the subscription associated with the invoice item. **Character limit**: 32 **Values**: inherited from `Subscription.Id` ")
  public String getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public ProxyGetInvoiceItem taxAmount(Double taxAmount) {
    this.taxAmount = taxAmount;
    return this;
  }

   /**
   *  The amount of tax applied to the invoice item's charge. **Character limit**: **Values**: calculated from multiple fields in the ProductRatePlanCharge object 
   * @return taxAmount
  **/
  @ApiModelProperty(example = "null", value = " The amount of tax applied to the invoice item's charge. **Character limit**: **Values**: calculated from multiple fields in the ProductRatePlanCharge object ")
  public Double getTaxAmount() {
    return taxAmount;
  }

  public void setTaxAmount(Double taxAmount) {
    this.taxAmount = taxAmount;
  }

  public ProxyGetInvoiceItem taxCode(String taxCode) {
    this.taxCode = taxCode;
    return this;
  }

   /**
   *  Specifies the tax code for taxation rules. **Character limit**: 6 **Values**: inherited from `ProductRatePlanCharge.TaxCode` 
   * @return taxCode
  **/
  @ApiModelProperty(example = "null", value = " Specifies the tax code for taxation rules. **Character limit**: 6 **Values**: inherited from `ProductRatePlanCharge.TaxCode` ")
  public String getTaxCode() {
    return taxCode;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }

  public ProxyGetInvoiceItem taxExemptAmount(Double taxExemptAmount) {
    this.taxExemptAmount = taxExemptAmount;
    return this;
  }

   /**
   *  The amount of the invoice item's charge that's tax exempt. **Character limit**: **Values**: calculated from multiple fields in the ProductRatePlanCharge object 
   * @return taxExemptAmount
  **/
  @ApiModelProperty(example = "null", value = " The amount of the invoice item's charge that's tax exempt. **Character limit**: **Values**: calculated from multiple fields in the ProductRatePlanCharge object ")
  public Double getTaxExemptAmount() {
    return taxExemptAmount;
  }

  public void setTaxExemptAmount(Double taxExemptAmount) {
    this.taxExemptAmount = taxExemptAmount;
  }

  public ProxyGetInvoiceItem taxMode(String taxMode) {
    this.taxMode = taxMode;
    return this;
  }

   /**
   *  The tax mode of the invoice item. **Character limit**: 12 **Values**: `TaxExclusive`, `TaxInclusive` 
   * @return taxMode
  **/
  @ApiModelProperty(example = "null", value = " The tax mode of the invoice item. **Character limit**: 12 **Values**: `TaxExclusive`, `TaxInclusive` ")
  public String getTaxMode() {
    return taxMode;
  }

  public void setTaxMode(String taxMode) {
    this.taxMode = taxMode;
  }

  public ProxyGetInvoiceItem UOM(String UOM) {
    this.UOM = UOM;
    return this;
  }

   /**
   *  Specifies the units to measure usage. Units of measure are configured in the web-based UI: **Z-Billing > Settings** **Character limit**: **Values**: inherited from `ProductRatePlanCharge.UOM` 
   * @return UOM
  **/
  @ApiModelProperty(example = "null", value = " Specifies the units to measure usage. Units of measure are configured in the web-based UI: **Z-Billing > Settings** **Character limit**: **Values**: inherited from `ProductRatePlanCharge.UOM` ")
  public String getUOM() {
    return UOM;
  }

  public void setUOM(String UOM) {
    this.UOM = UOM;
  }

  public ProxyGetInvoiceItem unitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
    return this;
  }

   /**
   *  The per-unit price of the invoice item. **Character limit**: **Values**: calculated from multiple fields in ProductRatePlanCharge and ProductRatePlanChargeTier objets 
   * @return unitPrice
  **/
  @ApiModelProperty(example = "null", value = " The per-unit price of the invoice item. **Character limit**: **Values**: calculated from multiple fields in ProductRatePlanCharge and ProductRatePlanChargeTier objets ")
  public Double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public ProxyGetInvoiceItem updatedById(String updatedById) {
    this.updatedById = updatedById;
    return this;
  }

   /**
   *  The ID of the user who last updated the invoice item. **Character limit**: 32 **Values**: automatically generated 
   * @return updatedById
  **/
  @ApiModelProperty(example = "null", value = " The ID of the user who last updated the invoice item. **Character limit**: 32 **Values**: automatically generated ")
  public String getUpdatedById() {
    return updatedById;
  }

  public void setUpdatedById(String updatedById) {
    this.updatedById = updatedById;
  }

  public ProxyGetInvoiceItem updatedDate(DateTime updatedDate) {
    this.updatedDate = updatedDate;
    return this;
  }

   /**
   *  The date when the invoice item was last updated. **Character limit**: 29 **Values**: automatically generated 
   * @return updatedDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the invoice item was last updated. **Character limit**: 29 **Values**: automatically generated ")
  public DateTime getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(DateTime updatedDate) {
    this.updatedDate = updatedDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProxyGetInvoiceItem proxyGetInvoiceItem = (ProxyGetInvoiceItem) o;
    return Objects.equals(this.accountingCode, proxyGetInvoiceItem.accountingCode) &&
        Objects.equals(this.appliedToInvoiceItemId, proxyGetInvoiceItem.appliedToInvoiceItemId) &&
        Objects.equals(this.chargeAmount, proxyGetInvoiceItem.chargeAmount) &&
        Objects.equals(this.chargeDate, proxyGetInvoiceItem.chargeDate) &&
        Objects.equals(this.chargeName, proxyGetInvoiceItem.chargeName) &&
        Objects.equals(this.createdById, proxyGetInvoiceItem.createdById) &&
        Objects.equals(this.createdDate, proxyGetInvoiceItem.createdDate) &&
        Objects.equals(this.id, proxyGetInvoiceItem.id) &&
        Objects.equals(this.invoiceId, proxyGetInvoiceItem.invoiceId) &&
        Objects.equals(this.processingType, proxyGetInvoiceItem.processingType) &&
        Objects.equals(this.productDescription, proxyGetInvoiceItem.productDescription) &&
        Objects.equals(this.quantity, proxyGetInvoiceItem.quantity) &&
        Objects.equals(this.ratePlanChargeId, proxyGetInvoiceItem.ratePlanChargeId) &&
        Objects.equals(this.revRecStartDate, proxyGetInvoiceItem.revRecStartDate) &&
        Objects.equals(this.SKU, proxyGetInvoiceItem.SKU) &&
        Objects.equals(this.serviceEndDate, proxyGetInvoiceItem.serviceEndDate) &&
        Objects.equals(this.serviceStartDate, proxyGetInvoiceItem.serviceStartDate) &&
        Objects.equals(this.subscriptionId, proxyGetInvoiceItem.subscriptionId) &&
        Objects.equals(this.taxAmount, proxyGetInvoiceItem.taxAmount) &&
        Objects.equals(this.taxCode, proxyGetInvoiceItem.taxCode) &&
        Objects.equals(this.taxExemptAmount, proxyGetInvoiceItem.taxExemptAmount) &&
        Objects.equals(this.taxMode, proxyGetInvoiceItem.taxMode) &&
        Objects.equals(this.UOM, proxyGetInvoiceItem.UOM) &&
        Objects.equals(this.unitPrice, proxyGetInvoiceItem.unitPrice) &&
        Objects.equals(this.updatedById, proxyGetInvoiceItem.updatedById) &&
        Objects.equals(this.updatedDate, proxyGetInvoiceItem.updatedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountingCode, appliedToInvoiceItemId, chargeAmount, chargeDate, chargeName, createdById, createdDate, id, invoiceId, processingType, productDescription, quantity, ratePlanChargeId, revRecStartDate, SKU, serviceEndDate, serviceStartDate, subscriptionId, taxAmount, taxCode, taxExemptAmount, taxMode, UOM, unitPrice, updatedById, updatedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProxyGetInvoiceItem {\n");
    
    sb.append("    accountingCode: ").append(toIndentedString(accountingCode)).append("\n");
    sb.append("    appliedToInvoiceItemId: ").append(toIndentedString(appliedToInvoiceItemId)).append("\n");
    sb.append("    chargeAmount: ").append(toIndentedString(chargeAmount)).append("\n");
    sb.append("    chargeDate: ").append(toIndentedString(chargeDate)).append("\n");
    sb.append("    chargeName: ").append(toIndentedString(chargeName)).append("\n");
    sb.append("    createdById: ").append(toIndentedString(createdById)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    invoiceId: ").append(toIndentedString(invoiceId)).append("\n");
    sb.append("    processingType: ").append(toIndentedString(processingType)).append("\n");
    sb.append("    productDescription: ").append(toIndentedString(productDescription)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    ratePlanChargeId: ").append(toIndentedString(ratePlanChargeId)).append("\n");
    sb.append("    revRecStartDate: ").append(toIndentedString(revRecStartDate)).append("\n");
    sb.append("    SKU: ").append(toIndentedString(SKU)).append("\n");
    sb.append("    serviceEndDate: ").append(toIndentedString(serviceEndDate)).append("\n");
    sb.append("    serviceStartDate: ").append(toIndentedString(serviceStartDate)).append("\n");
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("    taxAmount: ").append(toIndentedString(taxAmount)).append("\n");
    sb.append("    taxCode: ").append(toIndentedString(taxCode)).append("\n");
    sb.append("    taxExemptAmount: ").append(toIndentedString(taxExemptAmount)).append("\n");
    sb.append("    taxMode: ").append(toIndentedString(taxMode)).append("\n");
    sb.append("    UOM: ").append(toIndentedString(UOM)).append("\n");
    sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
    sb.append("    updatedById: ").append(toIndentedString(updatedById)).append("\n");
    sb.append("    updatedDate: ").append(toIndentedString(updatedDate)).append("\n");
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

