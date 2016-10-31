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
 * RatePlan
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class RatePlan   {
  @SerializedName("AmendmentId")
  private String amendmentId = null;

  @SerializedName("AmendmentSubscriptionRatePlanId")
  private String amendmentSubscriptionRatePlanId = null;

  @SerializedName("AmendmentType")
  private String amendmentType = null;

  @SerializedName("CreatedById")
  private String createdById = null;

  @SerializedName("CreatedDate")
  private DateTime createdDate = null;

  @SerializedName("Id")
  private String id = null;

  @SerializedName("Name")
  private String name = null;

  @SerializedName("ProductRatePlanId")
  private String productRatePlanId = null;

  @SerializedName("SubscriptionId")
  private String subscriptionId = null;

  @SerializedName("UpdatedById")
  private String updatedById = null;

  @SerializedName("UpdatedDate")
  private DateTime updatedDate = null;

  @SerializedName("fieldsToNull")
  private String fieldsToNull = null;

  public RatePlan amendmentId(String amendmentId) {
    this.amendmentId = amendmentId;
    return this;
  }

   /**
   *  The ID of the amendment associated with the rate plan. This field only applies to amendment rate plans. **Character limit**: 32 **Values**: a valid amendment ID 
   * @return amendmentId
  **/
  @ApiModelProperty(example = "null", value = " The ID of the amendment associated with the rate plan. This field only applies to amendment rate plans. **Character limit**: 32 **Values**: a valid amendment ID ")
  public String getAmendmentId() {
    return amendmentId;
  }

  public void setAmendmentId(String amendmentId) {
    this.amendmentId = amendmentId;
  }

  public RatePlan amendmentSubscriptionRatePlanId(String amendmentSubscriptionRatePlanId) {
    this.amendmentSubscriptionRatePlanId = amendmentSubscriptionRatePlanId;
    return this;
  }

   /**
   * The ID of the subscription rate plan modified by the amendment. This field only applies to amendment rate plans. **Character limit**: 32 **Values**: a valid rate plan ID 
   * @return amendmentSubscriptionRatePlanId
  **/
  @ApiModelProperty(example = "null", value = "The ID of the subscription rate plan modified by the amendment. This field only applies to amendment rate plans. **Character limit**: 32 **Values**: a valid rate plan ID ")
  public String getAmendmentSubscriptionRatePlanId() {
    return amendmentSubscriptionRatePlanId;
  }

  public void setAmendmentSubscriptionRatePlanId(String amendmentSubscriptionRatePlanId) {
    this.amendmentSubscriptionRatePlanId = amendmentSubscriptionRatePlanId;
  }

  public RatePlan amendmentType(String amendmentType) {
    this.amendmentType = amendmentType;
    return this;
  }

   /**
   * The type of amendment associated with the rate plan. This field only applies to amendment rate plans. **Character limit**: 18 **Values**: inherited from `Amendment.Type` 
   * @return amendmentType
  **/
  @ApiModelProperty(example = "null", value = "The type of amendment associated with the rate plan. This field only applies to amendment rate plans. **Character limit**: 18 **Values**: inherited from `Amendment.Type` ")
  public String getAmendmentType() {
    return amendmentType;
  }

  public void setAmendmentType(String amendmentType) {
    this.amendmentType = amendmentType;
  }

  public RatePlan createdById(String createdById) {
    this.createdById = createdById;
    return this;
  }

   /**
   * The ID of the Zuora user who created the RatePlan object. **Character limit**: 32 **Values**: automatically generated 
   * @return createdById
  **/
  @ApiModelProperty(example = "null", value = "The ID of the Zuora user who created the RatePlan object. **Character limit**: 32 **Values**: automatically generated ")
  public String getCreatedById() {
    return createdById;
  }

  public void setCreatedById(String createdById) {
    this.createdById = createdById;
  }

  public RatePlan createdDate(DateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }

   /**
   * The date when the `RatePlan` object was last updated. **Character limit**: 29 **Values**: automatically generated 
   * @return createdDate
  **/
  @ApiModelProperty(example = "null", value = "The date when the `RatePlan` object was last updated. **Character limit**: 29 **Values**: automatically generated ")
  public DateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(DateTime createdDate) {
    this.createdDate = createdDate;
  }

  public RatePlan id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of this object. Upon creation, the ID of this object is `RatePlanId`. **Character limit**: 32 **Values**: automatically generated 
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "The ID of this object. Upon creation, the ID of this object is `RatePlanId`. **Character limit**: 32 **Values**: automatically generated ")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RatePlan name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the rate plan. Leave this null in a subscribe() call to to inherited the `ProductRatePlan.Name` field value. **Character limit**: 100 **Values**: a string of 100 characters or fewer or inherited from ProductRatePlan.Name 
   * @return name
  **/
  @ApiModelProperty(example = "null", value = "The name of the rate plan. Leave this null in a subscribe() call to to inherited the `ProductRatePlan.Name` field value. **Character limit**: 100 **Values**: a string of 100 characters or fewer or inherited from ProductRatePlan.Name ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RatePlan productRatePlanId(String productRatePlanId) {
    this.productRatePlanId = productRatePlanId;
    return this;
  }

   /**
   * The ID of the associated product rate plan. **Character limit**: 32 **Values**: a valid product rate plan ID 
   * @return productRatePlanId
  **/
  @ApiModelProperty(example = "null", value = "The ID of the associated product rate plan. **Character limit**: 32 **Values**: a valid product rate plan ID ")
  public String getProductRatePlanId() {
    return productRatePlanId;
  }

  public void setProductRatePlanId(String productRatePlanId) {
    this.productRatePlanId = productRatePlanId;
  }

  public RatePlan subscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
    return this;
  }

   /**
   * The ID of the subscription that the rate plan belongs to. **Character limit**: 32 **Values**: a valid subscription ID 
   * @return subscriptionId
  **/
  @ApiModelProperty(example = "null", value = "The ID of the subscription that the rate plan belongs to. **Character limit**: 32 **Values**: a valid subscription ID ")
  public String getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public RatePlan updatedById(String updatedById) {
    this.updatedById = updatedById;
    return this;
  }

   /**
   *  The ID of the user who last updated the rate plan. **Character limit**: 32 **Values**: automatically generated 
   * @return updatedById
  **/
  @ApiModelProperty(example = "null", value = " The ID of the user who last updated the rate plan. **Character limit**: 32 **Values**: automatically generated ")
  public String getUpdatedById() {
    return updatedById;
  }

  public void setUpdatedById(String updatedById) {
    this.updatedById = updatedById;
  }

  public RatePlan updatedDate(DateTime updatedDate) {
    this.updatedDate = updatedDate;
    return this;
  }

   /**
   *  The date when the rate plan was last updated. **Character limit**: 29 **Values**: automatically generated 
   * @return updatedDate
  **/
  @ApiModelProperty(example = "null", value = " The date when the rate plan was last updated. **Character limit**: 29 **Values**: automatically generated ")
  public DateTime getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(DateTime updatedDate) {
    this.updatedDate = updatedDate;
  }

  public RatePlan fieldsToNull(String fieldsToNull) {
    this.fieldsToNull = fieldsToNull;
    return this;
  }

   /**
   * 
   * @return fieldsToNull
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getFieldsToNull() {
    return fieldsToNull;
  }

  public void setFieldsToNull(String fieldsToNull) {
    this.fieldsToNull = fieldsToNull;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RatePlan ratePlan = (RatePlan) o;
    return Objects.equals(this.amendmentId, ratePlan.amendmentId) &&
        Objects.equals(this.amendmentSubscriptionRatePlanId, ratePlan.amendmentSubscriptionRatePlanId) &&
        Objects.equals(this.amendmentType, ratePlan.amendmentType) &&
        Objects.equals(this.createdById, ratePlan.createdById) &&
        Objects.equals(this.createdDate, ratePlan.createdDate) &&
        Objects.equals(this.id, ratePlan.id) &&
        Objects.equals(this.name, ratePlan.name) &&
        Objects.equals(this.productRatePlanId, ratePlan.productRatePlanId) &&
        Objects.equals(this.subscriptionId, ratePlan.subscriptionId) &&
        Objects.equals(this.updatedById, ratePlan.updatedById) &&
        Objects.equals(this.updatedDate, ratePlan.updatedDate) &&
        Objects.equals(this.fieldsToNull, ratePlan.fieldsToNull);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amendmentId, amendmentSubscriptionRatePlanId, amendmentType, createdById, createdDate, id, name, productRatePlanId, subscriptionId, updatedById, updatedDate, fieldsToNull);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RatePlan {\n");
    
    sb.append("    amendmentId: ").append(toIndentedString(amendmentId)).append("\n");
    sb.append("    amendmentSubscriptionRatePlanId: ").append(toIndentedString(amendmentSubscriptionRatePlanId)).append("\n");
    sb.append("    amendmentType: ").append(toIndentedString(amendmentType)).append("\n");
    sb.append("    createdById: ").append(toIndentedString(createdById)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    productRatePlanId: ").append(toIndentedString(productRatePlanId)).append("\n");
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("    updatedById: ").append(toIndentedString(updatedById)).append("\n");
    sb.append("    updatedDate: ").append(toIndentedString(updatedDate)).append("\n");
    sb.append("    fieldsToNull: ").append(toIndentedString(fieldsToNull)).append("\n");
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

