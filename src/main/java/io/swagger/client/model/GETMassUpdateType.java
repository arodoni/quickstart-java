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
 * GETMassUpdateType
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class GETMassUpdateType   {
  @SerializedName("actionType")
  private String actionType = null;

  @SerializedName("endedOn")
  private DateTime endedOn = null;

  @SerializedName("errorCount")
  private String errorCount = null;

  @SerializedName("inputSize")
  private Long inputSize = null;

  @SerializedName("outputSize")
  private Long outputSize = null;

  @SerializedName("outputType")
  private String outputType = null;

  @SerializedName("outputURL")
  private String outputURL = null;

  @SerializedName("processedCount")
  private String processedCount = null;

  @SerializedName("startedOn")
  private DateTime startedOn = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("success")
  private Boolean success = null;

  @SerializedName("successCount")
  private String successCount = null;

  @SerializedName("totalCount")
  private String totalCount = null;

  @SerializedName("uploadedBy")
  private String uploadedBy = null;

  @SerializedName("uploadedOn")
  private DateTime uploadedOn = null;

  public GETMassUpdateType actionType(String actionType) {
    this.actionType = actionType;
    return this;
  }

   /**
   * Type of mass action. 
   * @return actionType
  **/
  @ApiModelProperty(example = "null", value = "Type of mass action. ")
  public String getActionType() {
    return actionType;
  }

  public void setActionType(String actionType) {
    this.actionType = actionType;
  }

  public GETMassUpdateType endedOn(DateTime endedOn) {
    this.endedOn = endedOn;
    return this;
  }

   /**
   * Date and time that the mass action was completed. The format is `yyyy-MM-dd hh:mm:ss`. 
   * @return endedOn
  **/
  @ApiModelProperty(example = "null", value = "Date and time that the mass action was completed. The format is `yyyy-MM-dd hh:mm:ss`. ")
  public DateTime getEndedOn() {
    return endedOn;
  }

  public void setEndedOn(DateTime endedOn) {
    this.endedOn = endedOn;
  }

  public GETMassUpdateType errorCount(String errorCount) {
    this.errorCount = errorCount;
    return this;
  }

   /**
   * Total number of failed records.  This field is updated in real time. When the mass action **status** is Processing, this field returns the number of records that have failed so far. When the mass action **status** is Pending, this field is null. 
   * @return errorCount
  **/
  @ApiModelProperty(example = "null", value = "Total number of failed records.  This field is updated in real time. When the mass action **status** is Processing, this field returns the number of records that have failed so far. When the mass action **status** is Pending, this field is null. ")
  public String getErrorCount() {
    return errorCount;
  }

  public void setErrorCount(String errorCount) {
    this.errorCount = errorCount;
  }

  public GETMassUpdateType inputSize(Long inputSize) {
    this.inputSize = inputSize;
    return this;
  }

   /**
   * Size of the input file in bytes. 
   * @return inputSize
  **/
  @ApiModelProperty(example = "null", value = "Size of the input file in bytes. ")
  public Long getInputSize() {
    return inputSize;
  }

  public void setInputSize(Long inputSize) {
    this.inputSize = inputSize;
  }

  public GETMassUpdateType outputSize(Long outputSize) {
    this.outputSize = outputSize;
    return this;
  }

   /**
   * Size of the response file in bytes. 
   * @return outputSize
  **/
  @ApiModelProperty(example = "null", value = "Size of the response file in bytes. ")
  public Long getOutputSize() {
    return outputSize;
  }

  public void setOutputSize(Long outputSize) {
    this.outputSize = outputSize;
  }

  public GETMassUpdateType outputType(String outputType) {
    this.outputType = outputType;
    return this;
  }

   /**
   * Type of output for the response file. The following table describes the output type.  | Output Type    | Description                         | |----------------|-------------------------------------| | (url:.csv.zip) | URL pointing to a zipped .csv file. | 
   * @return outputType
  **/
  @ApiModelProperty(example = "null", value = "Type of output for the response file. The following table describes the output type.  | Output Type    | Description                         | |----------------|-------------------------------------| | (url:.csv.zip) | URL pointing to a zipped .csv file. | ")
  public String getOutputType() {
    return outputType;
  }

  public void setOutputType(String outputType) {
    this.outputType = outputType;
  }

  public GETMassUpdateType outputURL(String outputURL) {
    this.outputURL = outputURL;
    return this;
  }

   /**
   * URL to download the response file. The response file is a zipped .csv file.  The response file is identical to the file you uploaded to perform the mass action, with additional columns providing information about the outcome of each record. See the [Supported Mass Actions](https://knowledgecenter.zuora.com/CC_Finance/Mass_Updater) articles for more information about the response file for each type of mass action.  This field only returns a value when the mass action **status** is Completed or Stopped. Otherwise, this field is null. 
   * @return outputURL
  **/
  @ApiModelProperty(example = "null", value = "URL to download the response file. The response file is a zipped .csv file.  The response file is identical to the file you uploaded to perform the mass action, with additional columns providing information about the outcome of each record. See the [Supported Mass Actions](https://knowledgecenter.zuora.com/CC_Finance/Mass_Updater) articles for more information about the response file for each type of mass action.  This field only returns a value when the mass action **status** is Completed or Stopped. Otherwise, this field is null. ")
  public String getOutputURL() {
    return outputURL;
  }

  public void setOutputURL(String outputURL) {
    this.outputURL = outputURL;
  }

  public GETMassUpdateType processedCount(String processedCount) {
    this.processedCount = processedCount;
    return this;
  }

   /**
   * Total number of processed records. This field is equal to the sum of `errorCount` and `successCount`.  This field is updated in real time. When the mass action **status** is Processing, this field returns the number of records that have been processed so far. When the mass action **status** is Pending, this field is null. 
   * @return processedCount
  **/
  @ApiModelProperty(example = "null", value = "Total number of processed records. This field is equal to the sum of `errorCount` and `successCount`.  This field is updated in real time. When the mass action **status** is Processing, this field returns the number of records that have been processed so far. When the mass action **status** is Pending, this field is null. ")
  public String getProcessedCount() {
    return processedCount;
  }

  public void setProcessedCount(String processedCount) {
    this.processedCount = processedCount;
  }

  public GETMassUpdateType startedOn(DateTime startedOn) {
    this.startedOn = startedOn;
    return this;
  }

   /**
   * Date and time that Zuora started processing the mass action. The format is `yyyy-MM-dd hh:mm:ss`. 
   * @return startedOn
  **/
  @ApiModelProperty(example = "null", value = "Date and time that Zuora started processing the mass action. The format is `yyyy-MM-dd hh:mm:ss`. ")
  public DateTime getStartedOn() {
    return startedOn;
  }

  public void setStartedOn(DateTime startedOn) {
    this.startedOn = startedOn;
  }

  public GETMassUpdateType status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Status of the mass action. The following table describes the mass action statuses.  | Status     | Description                                                                | |------------|----------------------------------------------------------------------------| | Pending    | Mass action has not yet started being processed.                           | | Processing | Mass action is in progress.                                                | | Stopping   | Mass action is in the process of stopping, but has not yet stopped.        | | Stopped    | Mass action has stopped.                                                   | | Completed  | Mass action was successfully completed. There may still be failed records. | | Failed     | Mass action failed. No records are processed. No response file is created. | 
   * @return status
  **/
  @ApiModelProperty(example = "null", value = "Status of the mass action. The following table describes the mass action statuses.  | Status     | Description                                                                | |------------|----------------------------------------------------------------------------| | Pending    | Mass action has not yet started being processed.                           | | Processing | Mass action is in progress.                                                | | Stopping   | Mass action is in the process of stopping, but has not yet stopped.        | | Stopped    | Mass action has stopped.                                                   | | Completed  | Mass action was successfully completed. There may still be failed records. | | Failed     | Mass action failed. No records are processed. No response file is created. | ")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public GETMassUpdateType success(Boolean success) {
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

  public GETMassUpdateType successCount(String successCount) {
    this.successCount = successCount;
    return this;
  }

   /**
   * Total number of successful records. This field is updated in real time. When the mass action **status** is Processing, this field returns the number of records that have succeeded so far. When the mass action **status** is Pending, this field is null. 
   * @return successCount
  **/
  @ApiModelProperty(example = "null", value = "Total number of successful records. This field is updated in real time. When the mass action **status** is Processing, this field returns the number of records that have succeeded so far. When the mass action **status** is Pending, this field is null. ")
  public String getSuccessCount() {
    return successCount;
  }

  public void setSuccessCount(String successCount) {
    this.successCount = successCount;
  }

  public GETMassUpdateType totalCount(String totalCount) {
    this.totalCount = totalCount;
    return this;
  }

   /**
   * Total number of records in the uploaded mass action file. When the mass action **status** is Pending, this field is null. 
   * @return totalCount
  **/
  @ApiModelProperty(example = "null", value = "Total number of records in the uploaded mass action file. When the mass action **status** is Pending, this field is null. ")
  public String getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(String totalCount) {
    this.totalCount = totalCount;
  }

  public GETMassUpdateType uploadedBy(String uploadedBy) {
    this.uploadedBy = uploadedBy;
    return this;
  }

   /**
   * Email of the person who uploaded the mass action file. 
   * @return uploadedBy
  **/
  @ApiModelProperty(example = "null", value = "Email of the person who uploaded the mass action file. ")
  public String getUploadedBy() {
    return uploadedBy;
  }

  public void setUploadedBy(String uploadedBy) {
    this.uploadedBy = uploadedBy;
  }

  public GETMassUpdateType uploadedOn(DateTime uploadedOn) {
    this.uploadedOn = uploadedOn;
    return this;
  }

   /**
   * Date and time that the mass action file was uploaded. The format is `yyyy-MM-dd hh:mm:ss`. 
   * @return uploadedOn
  **/
  @ApiModelProperty(example = "null", value = "Date and time that the mass action file was uploaded. The format is `yyyy-MM-dd hh:mm:ss`. ")
  public DateTime getUploadedOn() {
    return uploadedOn;
  }

  public void setUploadedOn(DateTime uploadedOn) {
    this.uploadedOn = uploadedOn;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GETMassUpdateType gETMassUpdateType = (GETMassUpdateType) o;
    return Objects.equals(this.actionType, gETMassUpdateType.actionType) &&
        Objects.equals(this.endedOn, gETMassUpdateType.endedOn) &&
        Objects.equals(this.errorCount, gETMassUpdateType.errorCount) &&
        Objects.equals(this.inputSize, gETMassUpdateType.inputSize) &&
        Objects.equals(this.outputSize, gETMassUpdateType.outputSize) &&
        Objects.equals(this.outputType, gETMassUpdateType.outputType) &&
        Objects.equals(this.outputURL, gETMassUpdateType.outputURL) &&
        Objects.equals(this.processedCount, gETMassUpdateType.processedCount) &&
        Objects.equals(this.startedOn, gETMassUpdateType.startedOn) &&
        Objects.equals(this.status, gETMassUpdateType.status) &&
        Objects.equals(this.success, gETMassUpdateType.success) &&
        Objects.equals(this.successCount, gETMassUpdateType.successCount) &&
        Objects.equals(this.totalCount, gETMassUpdateType.totalCount) &&
        Objects.equals(this.uploadedBy, gETMassUpdateType.uploadedBy) &&
        Objects.equals(this.uploadedOn, gETMassUpdateType.uploadedOn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(actionType, endedOn, errorCount, inputSize, outputSize, outputType, outputURL, processedCount, startedOn, status, success, successCount, totalCount, uploadedBy, uploadedOn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GETMassUpdateType {\n");
    
    sb.append("    actionType: ").append(toIndentedString(actionType)).append("\n");
    sb.append("    endedOn: ").append(toIndentedString(endedOn)).append("\n");
    sb.append("    errorCount: ").append(toIndentedString(errorCount)).append("\n");
    sb.append("    inputSize: ").append(toIndentedString(inputSize)).append("\n");
    sb.append("    outputSize: ").append(toIndentedString(outputSize)).append("\n");
    sb.append("    outputType: ").append(toIndentedString(outputType)).append("\n");
    sb.append("    outputURL: ").append(toIndentedString(outputURL)).append("\n");
    sb.append("    processedCount: ").append(toIndentedString(processedCount)).append("\n");
    sb.append("    startedOn: ").append(toIndentedString(startedOn)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    successCount: ").append(toIndentedString(successCount)).append("\n");
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
    sb.append("    uploadedBy: ").append(toIndentedString(uploadedBy)).append("\n");
    sb.append("    uploadedOn: ").append(toIndentedString(uploadedOn)).append("\n");
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

