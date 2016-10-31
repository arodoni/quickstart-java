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


package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import io.swagger.client.model.CommonResponseType;
import io.swagger.client.model.GETRSDetailType;
import io.swagger.client.model.GETRSDetailsByChargeType;
import io.swagger.client.model.POSTRevenueScheduleByDateRangeType;
import io.swagger.client.model.POSTRevenueScheduleByTransactionResponseType;
import io.swagger.client.model.POSTRevenueScheduleByTransactionType;
import io.swagger.client.model.POSTRevenueScheduleByChargeResponseType;
import io.swagger.client.model.POSTRevenueScheduleByChargeType;
import io.swagger.client.model.PUTRSBasicInfoType;
import io.swagger.client.model.PUTRevenueScheduleResponseType;
import io.swagger.client.model.PUTAllocateManuallyType;
import io.swagger.client.model.PUTRSTermType;
import io.swagger.client.model.PUTSpecificDateAllocationType;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RevenueSchedulesApi {
    private ApiClient apiClient;

    public RevenueSchedulesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public RevenueSchedulesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for dELETERS */
    private com.squareup.okhttp.Call dELETERSCall(String rsNumber, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'rsNumber' is set
        if (rsNumber == null) {
            throw new ApiException("Missing the required parameter 'rsNumber' when calling dELETERS(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/revenue-schedules/{rs-number}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "rs-number" + "\\}", apiClient.escapeString(rsNumber.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Delete revenue schedule
     * This REST API reference describes how to delete a revenue schedule by specifying its revenue schedule number ## Prerequisites You must have the Delete Custom Revenue Schedule [Z-Finance permission](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/Administrator_Settings/User_Roles/Z-Finance_Roles#Z-Finance_Permissions). 
     * @param rsNumber  Revenue schedule number of the revenue schedule you want to delete, for example, RS-00000256. To be deleted, the revenue schedule: * Must be using a custom unlimited recognition rule. * Cannot have any revenue in a closed accounting period. * Cannot be included in a summary journal entry. * Cannot have a revenue schedule date in a closed accounting period.  (required)
     * @return CommonResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CommonResponseType dELETERS(String rsNumber) throws ApiException {
        ApiResponse<CommonResponseType> resp = dELETERSWithHttpInfo(rsNumber);
        return resp.getData();
    }

    /**
     * Delete revenue schedule
     * This REST API reference describes how to delete a revenue schedule by specifying its revenue schedule number ## Prerequisites You must have the Delete Custom Revenue Schedule [Z-Finance permission](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/Administrator_Settings/User_Roles/Z-Finance_Roles#Z-Finance_Permissions). 
     * @param rsNumber  Revenue schedule number of the revenue schedule you want to delete, for example, RS-00000256. To be deleted, the revenue schedule: * Must be using a custom unlimited recognition rule. * Cannot have any revenue in a closed accounting period. * Cannot be included in a summary journal entry. * Cannot have a revenue schedule date in a closed accounting period.  (required)
     * @return ApiResponse&lt;CommonResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CommonResponseType> dELETERSWithHttpInfo(String rsNumber) throws ApiException {
        com.squareup.okhttp.Call call = dELETERSCall(rsNumber, null, null);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete revenue schedule (asynchronously)
     * This REST API reference describes how to delete a revenue schedule by specifying its revenue schedule number ## Prerequisites You must have the Delete Custom Revenue Schedule [Z-Finance permission](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/Administrator_Settings/User_Roles/Z-Finance_Roles#Z-Finance_Permissions). 
     * @param rsNumber  Revenue schedule number of the revenue schedule you want to delete, for example, RS-00000256. To be deleted, the revenue schedule: * Must be using a custom unlimited recognition rule. * Cannot have any revenue in a closed accounting period. * Cannot be included in a summary journal entry. * Cannot have a revenue schedule date in a closed accounting period.  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call dELETERSAsync(String rsNumber, final ApiCallback<CommonResponseType> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = dELETERSCall(rsNumber, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for gETRSDetail */
    private com.squareup.okhttp.Call gETRSDetailCall(String rsNumber, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'rsNumber' is set
        if (rsNumber == null) {
            throw new ApiException("Missing the required parameter 'rsNumber' when calling gETRSDetail(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/revenue-schedules/{rs-number}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "rs-number" + "\\}", apiClient.escapeString(rsNumber.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Get revenue schedule details
     * This REST API reference describes how to get the details of a revenue schedule by specifying the revenue schedule number. Request and response field descriptions and sample code are provided.
     * @param rsNumber Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  (required)
     * @return GETRSDetailType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GETRSDetailType gETRSDetail(String rsNumber) throws ApiException {
        ApiResponse<GETRSDetailType> resp = gETRSDetailWithHttpInfo(rsNumber);
        return resp.getData();
    }

    /**
     * Get revenue schedule details
     * This REST API reference describes how to get the details of a revenue schedule by specifying the revenue schedule number. Request and response field descriptions and sample code are provided.
     * @param rsNumber Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  (required)
     * @return ApiResponse&lt;GETRSDetailType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GETRSDetailType> gETRSDetailWithHttpInfo(String rsNumber) throws ApiException {
        com.squareup.okhttp.Call call = gETRSDetailCall(rsNumber, null, null);
        Type localVarReturnType = new TypeToken<GETRSDetailType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get revenue schedule details (asynchronously)
     * This REST API reference describes how to get the details of a revenue schedule by specifying the revenue schedule number. Request and response field descriptions and sample code are provided.
     * @param rsNumber Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call gETRSDetailAsync(String rsNumber, final ApiCallback<GETRSDetailType> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = gETRSDetailCall(rsNumber, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GETRSDetailType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for gETRSDetailsByCharge */
    private com.squareup.okhttp.Call gETRSDetailsByChargeCall(String chargeKey, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'chargeKey' is set
        if (chargeKey == null) {
            throw new ApiException("Missing the required parameter 'chargeKey' when calling gETRSDetailsByCharge(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/revenue-schedules/subscription-charges/{charge-key}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "charge-key" + "\\}", apiClient.escapeString(chargeKey.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Get revenue schedule by subscription charge
     * This REST API reference describes how to get the revenue schedule details by specifying subscription charge ID. Request and response field descriptions and sample code are provided
     * @param chargeKey ID of the subscription rate plan charge; for example, 402892793e173340013e173b81000012. (required)
     * @return GETRSDetailsByChargeType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GETRSDetailsByChargeType gETRSDetailsByCharge(String chargeKey) throws ApiException {
        ApiResponse<GETRSDetailsByChargeType> resp = gETRSDetailsByChargeWithHttpInfo(chargeKey);
        return resp.getData();
    }

    /**
     * Get revenue schedule by subscription charge
     * This REST API reference describes how to get the revenue schedule details by specifying subscription charge ID. Request and response field descriptions and sample code are provided
     * @param chargeKey ID of the subscription rate plan charge; for example, 402892793e173340013e173b81000012. (required)
     * @return ApiResponse&lt;GETRSDetailsByChargeType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GETRSDetailsByChargeType> gETRSDetailsByChargeWithHttpInfo(String chargeKey) throws ApiException {
        com.squareup.okhttp.Call call = gETRSDetailsByChargeCall(chargeKey, null, null);
        Type localVarReturnType = new TypeToken<GETRSDetailsByChargeType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get revenue schedule by subscription charge (asynchronously)
     * This REST API reference describes how to get the revenue schedule details by specifying subscription charge ID. Request and response field descriptions and sample code are provided
     * @param chargeKey ID of the subscription rate plan charge; for example, 402892793e173340013e173b81000012. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call gETRSDetailsByChargeAsync(String chargeKey, final ApiCallback<GETRSDetailsByChargeType> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = gETRSDetailsByChargeCall(chargeKey, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GETRSDetailsByChargeType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for gETRSbyInvoiceItem */
    private com.squareup.okhttp.Call gETRSbyInvoiceItemCall(String invoiceItemId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'invoiceItemId' is set
        if (invoiceItemId == null) {
            throw new ApiException("Missing the required parameter 'invoiceItemId' when calling gETRSbyInvoiceItem(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/revenue-schedules/invoice-items/{invoice-item-id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "invoice-item-id" + "\\}", apiClient.escapeString(invoiceItemId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Get a revenue schedule by invoice item ID
     * This REST API reference describes how to get the details of a revenue schedule by specifying the invoice item ID.
     * @param invoiceItemId A valid Invoice Item ID. (required)
     * @return GETRSDetailType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GETRSDetailType gETRSbyInvoiceItem(String invoiceItemId) throws ApiException {
        ApiResponse<GETRSDetailType> resp = gETRSbyInvoiceItemWithHttpInfo(invoiceItemId);
        return resp.getData();
    }

    /**
     * Get a revenue schedule by invoice item ID
     * This REST API reference describes how to get the details of a revenue schedule by specifying the invoice item ID.
     * @param invoiceItemId A valid Invoice Item ID. (required)
     * @return ApiResponse&lt;GETRSDetailType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GETRSDetailType> gETRSbyInvoiceItemWithHttpInfo(String invoiceItemId) throws ApiException {
        com.squareup.okhttp.Call call = gETRSbyInvoiceItemCall(invoiceItemId, null, null);
        Type localVarReturnType = new TypeToken<GETRSDetailType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a revenue schedule by invoice item ID (asynchronously)
     * This REST API reference describes how to get the details of a revenue schedule by specifying the invoice item ID.
     * @param invoiceItemId A valid Invoice Item ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call gETRSbyInvoiceItemAsync(String invoiceItemId, final ApiCallback<GETRSDetailType> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = gETRSbyInvoiceItemCall(invoiceItemId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GETRSDetailType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for gETRSbyInvoiceItemAdjustment */
    private com.squareup.okhttp.Call gETRSbyInvoiceItemAdjustmentCall(String invoiceItemAdjId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'invoiceItemAdjId' is set
        if (invoiceItemAdjId == null) {
            throw new ApiException("Missing the required parameter 'invoiceItemAdjId' when calling gETRSbyInvoiceItemAdjustment(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/revenue-schedules/invoice-item-adjustments/{invoice-item-adj-id}/".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "invoice-item-adj-id" + "\\}", apiClient.escapeString(invoiceItemAdjId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Get a revenue schedule by invoice item adjustment
     * This REST API reference describes how to get the details of a revenue schedule by specifying a valid invoice item adjustment identifier. Request and response field descriptions and sample code are provided. 
     * @param invoiceItemAdjId ID or number of the Invoice Item Adjustment, for example, e20b07fd416dcfcf0141c81164fd0a72. (required)
     * @return GETRSDetailType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GETRSDetailType gETRSbyInvoiceItemAdjustment(String invoiceItemAdjId) throws ApiException {
        ApiResponse<GETRSDetailType> resp = gETRSbyInvoiceItemAdjustmentWithHttpInfo(invoiceItemAdjId);
        return resp.getData();
    }

    /**
     * Get a revenue schedule by invoice item adjustment
     * This REST API reference describes how to get the details of a revenue schedule by specifying a valid invoice item adjustment identifier. Request and response field descriptions and sample code are provided. 
     * @param invoiceItemAdjId ID or number of the Invoice Item Adjustment, for example, e20b07fd416dcfcf0141c81164fd0a72. (required)
     * @return ApiResponse&lt;GETRSDetailType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GETRSDetailType> gETRSbyInvoiceItemAdjustmentWithHttpInfo(String invoiceItemAdjId) throws ApiException {
        com.squareup.okhttp.Call call = gETRSbyInvoiceItemAdjustmentCall(invoiceItemAdjId, null, null);
        Type localVarReturnType = new TypeToken<GETRSDetailType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a revenue schedule by invoice item adjustment (asynchronously)
     * This REST API reference describes how to get the details of a revenue schedule by specifying a valid invoice item adjustment identifier. Request and response field descriptions and sample code are provided. 
     * @param invoiceItemAdjId ID or number of the Invoice Item Adjustment, for example, e20b07fd416dcfcf0141c81164fd0a72. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call gETRSbyInvoiceItemAdjustmentAsync(String invoiceItemAdjId, final ApiCallback<GETRSDetailType> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = gETRSbyInvoiceItemAdjustmentCall(invoiceItemAdjId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GETRSDetailType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pOSTRSforInvoiceItemAdjustmentDistributeByDateRange */
    private com.squareup.okhttp.Call pOSTRSforInvoiceItemAdjustmentDistributeByDateRangeCall(String invoiceItemAdjKey, POSTRevenueScheduleByDateRangeType request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'invoiceItemAdjKey' is set
        if (invoiceItemAdjKey == null) {
            throw new ApiException("Missing the required parameter 'invoiceItemAdjKey' when calling pOSTRSforInvoiceItemAdjustmentDistributeByDateRange(Async)");
        }
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pOSTRSforInvoiceItemAdjustmentDistributeByDateRange(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/revenue-schedules/invoice-item-adjustments/{invoice-item-adj-key}/distribute-revenue-with-date-range".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "invoice-item-adj-key" + "\\}", apiClient.escapeString(invoiceItemAdjKey.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Create a revenue schedule for an Invoice Item Adjustment (distribute by date range)
     * This REST API reference describes how to create a revenue schedule for an Invoice Item Adjustment and distribute the revenue by specifying the recognition start and end dates.
     * @param invoiceItemAdjKey ID or number of the Invoice Item Adjustment, for example, e20b07fd416dcfcf0141c81164fd0a72. If the specified Invoice Item Adjustment is already associated with a revenue schedule, the call will fail.  (required)
     * @param request  (required)
     * @return POSTRevenueScheduleByTransactionResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public POSTRevenueScheduleByTransactionResponseType pOSTRSforInvoiceItemAdjustmentDistributeByDateRange(String invoiceItemAdjKey, POSTRevenueScheduleByDateRangeType request) throws ApiException {
        ApiResponse<POSTRevenueScheduleByTransactionResponseType> resp = pOSTRSforInvoiceItemAdjustmentDistributeByDateRangeWithHttpInfo(invoiceItemAdjKey, request);
        return resp.getData();
    }

    /**
     * Create a revenue schedule for an Invoice Item Adjustment (distribute by date range)
     * This REST API reference describes how to create a revenue schedule for an Invoice Item Adjustment and distribute the revenue by specifying the recognition start and end dates.
     * @param invoiceItemAdjKey ID or number of the Invoice Item Adjustment, for example, e20b07fd416dcfcf0141c81164fd0a72. If the specified Invoice Item Adjustment is already associated with a revenue schedule, the call will fail.  (required)
     * @param request  (required)
     * @return ApiResponse&lt;POSTRevenueScheduleByTransactionResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<POSTRevenueScheduleByTransactionResponseType> pOSTRSforInvoiceItemAdjustmentDistributeByDateRangeWithHttpInfo(String invoiceItemAdjKey, POSTRevenueScheduleByDateRangeType request) throws ApiException {
        com.squareup.okhttp.Call call = pOSTRSforInvoiceItemAdjustmentDistributeByDateRangeCall(invoiceItemAdjKey, request, null, null);
        Type localVarReturnType = new TypeToken<POSTRevenueScheduleByTransactionResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a revenue schedule for an Invoice Item Adjustment (distribute by date range) (asynchronously)
     * This REST API reference describes how to create a revenue schedule for an Invoice Item Adjustment and distribute the revenue by specifying the recognition start and end dates.
     * @param invoiceItemAdjKey ID or number of the Invoice Item Adjustment, for example, e20b07fd416dcfcf0141c81164fd0a72. If the specified Invoice Item Adjustment is already associated with a revenue schedule, the call will fail.  (required)
     * @param request  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pOSTRSforInvoiceItemAdjustmentDistributeByDateRangeAsync(String invoiceItemAdjKey, POSTRevenueScheduleByDateRangeType request, final ApiCallback<POSTRevenueScheduleByTransactionResponseType> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = pOSTRSforInvoiceItemAdjustmentDistributeByDateRangeCall(invoiceItemAdjKey, request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<POSTRevenueScheduleByTransactionResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pOSTRSforInvoiceItemAdjustmentManualDistribution */
    private com.squareup.okhttp.Call pOSTRSforInvoiceItemAdjustmentManualDistributionCall(String invoiceItemAdjKey, POSTRevenueScheduleByTransactionType request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'invoiceItemAdjKey' is set
        if (invoiceItemAdjKey == null) {
            throw new ApiException("Missing the required parameter 'invoiceItemAdjKey' when calling pOSTRSforInvoiceItemAdjustmentManualDistribution(Async)");
        }
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pOSTRSforInvoiceItemAdjustmentManualDistribution(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/revenue-schedules/invoice-item-adjustments/{invoice-item-adj-key}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "invoice-item-adj-key" + "\\}", apiClient.escapeString(invoiceItemAdjKey.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Create a revenue schedule for an Invoice Item Adjustment (manual distribution)
     * This REST API reference describes how to create a revenue schedule for an Invoice Item Adjustment and manually distribute the revenue.
     * @param invoiceItemAdjKey ID or number of the Invoice Item Adjustment, for example, e20b07fd416dcfcf0141c81164fd0a72. If the specified Invoice Item Adjustment is already associated with a revenue schedule, the call will fail.  (required)
     * @param request  (required)
     * @return POSTRevenueScheduleByTransactionResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public POSTRevenueScheduleByTransactionResponseType pOSTRSforInvoiceItemAdjustmentManualDistribution(String invoiceItemAdjKey, POSTRevenueScheduleByTransactionType request) throws ApiException {
        ApiResponse<POSTRevenueScheduleByTransactionResponseType> resp = pOSTRSforInvoiceItemAdjustmentManualDistributionWithHttpInfo(invoiceItemAdjKey, request);
        return resp.getData();
    }

    /**
     * Create a revenue schedule for an Invoice Item Adjustment (manual distribution)
     * This REST API reference describes how to create a revenue schedule for an Invoice Item Adjustment and manually distribute the revenue.
     * @param invoiceItemAdjKey ID or number of the Invoice Item Adjustment, for example, e20b07fd416dcfcf0141c81164fd0a72. If the specified Invoice Item Adjustment is already associated with a revenue schedule, the call will fail.  (required)
     * @param request  (required)
     * @return ApiResponse&lt;POSTRevenueScheduleByTransactionResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<POSTRevenueScheduleByTransactionResponseType> pOSTRSforInvoiceItemAdjustmentManualDistributionWithHttpInfo(String invoiceItemAdjKey, POSTRevenueScheduleByTransactionType request) throws ApiException {
        com.squareup.okhttp.Call call = pOSTRSforInvoiceItemAdjustmentManualDistributionCall(invoiceItemAdjKey, request, null, null);
        Type localVarReturnType = new TypeToken<POSTRevenueScheduleByTransactionResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a revenue schedule for an Invoice Item Adjustment (manual distribution) (asynchronously)
     * This REST API reference describes how to create a revenue schedule for an Invoice Item Adjustment and manually distribute the revenue.
     * @param invoiceItemAdjKey ID or number of the Invoice Item Adjustment, for example, e20b07fd416dcfcf0141c81164fd0a72. If the specified Invoice Item Adjustment is already associated with a revenue schedule, the call will fail.  (required)
     * @param request  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pOSTRSforInvoiceItemAdjustmentManualDistributionAsync(String invoiceItemAdjKey, POSTRevenueScheduleByTransactionType request, final ApiCallback<POSTRevenueScheduleByTransactionResponseType> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = pOSTRSforInvoiceItemAdjustmentManualDistributionCall(invoiceItemAdjKey, request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<POSTRevenueScheduleByTransactionResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pOSTRSforInvoiceItemDistributeByDateRange */
    private com.squareup.okhttp.Call pOSTRSforInvoiceItemDistributeByDateRangeCall(String invoiceItemId, POSTRevenueScheduleByDateRangeType request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'invoiceItemId' is set
        if (invoiceItemId == null) {
            throw new ApiException("Missing the required parameter 'invoiceItemId' when calling pOSTRSforInvoiceItemDistributeByDateRange(Async)");
        }
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pOSTRSforInvoiceItemDistributeByDateRange(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/revenue-schedules/invoice-items/{invoice-item-id}/distribute-revenue-with-date-range".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "invoice-item-id" + "\\}", apiClient.escapeString(invoiceItemId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Create a revenue schedule for an Invoice Item (distribute by date range)
     * This REST API reference describes how to create a revenue schedule for an Invoice Item and distribute the revenue by specifying the recognition start and end dates.
     * @param invoiceItemId ID of the Invoice Item, for example, e20b07fd416dcfcf0141c81164fd0a75. If the specified Invoice Item is already associated with a revenue schedule, the call will fail.  (required)
     * @param request  (required)
     * @return POSTRevenueScheduleByTransactionResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public POSTRevenueScheduleByTransactionResponseType pOSTRSforInvoiceItemDistributeByDateRange(String invoiceItemId, POSTRevenueScheduleByDateRangeType request) throws ApiException {
        ApiResponse<POSTRevenueScheduleByTransactionResponseType> resp = pOSTRSforInvoiceItemDistributeByDateRangeWithHttpInfo(invoiceItemId, request);
        return resp.getData();
    }

    /**
     * Create a revenue schedule for an Invoice Item (distribute by date range)
     * This REST API reference describes how to create a revenue schedule for an Invoice Item and distribute the revenue by specifying the recognition start and end dates.
     * @param invoiceItemId ID of the Invoice Item, for example, e20b07fd416dcfcf0141c81164fd0a75. If the specified Invoice Item is already associated with a revenue schedule, the call will fail.  (required)
     * @param request  (required)
     * @return ApiResponse&lt;POSTRevenueScheduleByTransactionResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<POSTRevenueScheduleByTransactionResponseType> pOSTRSforInvoiceItemDistributeByDateRangeWithHttpInfo(String invoiceItemId, POSTRevenueScheduleByDateRangeType request) throws ApiException {
        com.squareup.okhttp.Call call = pOSTRSforInvoiceItemDistributeByDateRangeCall(invoiceItemId, request, null, null);
        Type localVarReturnType = new TypeToken<POSTRevenueScheduleByTransactionResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a revenue schedule for an Invoice Item (distribute by date range) (asynchronously)
     * This REST API reference describes how to create a revenue schedule for an Invoice Item and distribute the revenue by specifying the recognition start and end dates.
     * @param invoiceItemId ID of the Invoice Item, for example, e20b07fd416dcfcf0141c81164fd0a75. If the specified Invoice Item is already associated with a revenue schedule, the call will fail.  (required)
     * @param request  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pOSTRSforInvoiceItemDistributeByDateRangeAsync(String invoiceItemId, POSTRevenueScheduleByDateRangeType request, final ApiCallback<POSTRevenueScheduleByTransactionResponseType> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = pOSTRSforInvoiceItemDistributeByDateRangeCall(invoiceItemId, request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<POSTRevenueScheduleByTransactionResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pOSTRSforInvoiceItemManualDistribution */
    private com.squareup.okhttp.Call pOSTRSforInvoiceItemManualDistributionCall(String invoiceItemId, POSTRevenueScheduleByTransactionType request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'invoiceItemId' is set
        if (invoiceItemId == null) {
            throw new ApiException("Missing the required parameter 'invoiceItemId' when calling pOSTRSforInvoiceItemManualDistribution(Async)");
        }
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pOSTRSforInvoiceItemManualDistribution(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/revenue-schedules/invoice-items/{invoice-item-id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "invoice-item-id" + "\\}", apiClient.escapeString(invoiceItemId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Create a revenue schedule for an Invoice Item (manual distribution)
     * This REST API reference describes how to create a revenue schedule for an Invoice Item and manually distribute the revenue.
     * @param invoiceItemId ID of the Invoice Item, for example, e20b07fd416dcfcf0141c81164fd0a75. If the specified Invoice Item is already associated with a revenue schedule, the call will fail.  (required)
     * @param request  (required)
     * @return POSTRevenueScheduleByTransactionResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public POSTRevenueScheduleByTransactionResponseType pOSTRSforInvoiceItemManualDistribution(String invoiceItemId, POSTRevenueScheduleByTransactionType request) throws ApiException {
        ApiResponse<POSTRevenueScheduleByTransactionResponseType> resp = pOSTRSforInvoiceItemManualDistributionWithHttpInfo(invoiceItemId, request);
        return resp.getData();
    }

    /**
     * Create a revenue schedule for an Invoice Item (manual distribution)
     * This REST API reference describes how to create a revenue schedule for an Invoice Item and manually distribute the revenue.
     * @param invoiceItemId ID of the Invoice Item, for example, e20b07fd416dcfcf0141c81164fd0a75. If the specified Invoice Item is already associated with a revenue schedule, the call will fail.  (required)
     * @param request  (required)
     * @return ApiResponse&lt;POSTRevenueScheduleByTransactionResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<POSTRevenueScheduleByTransactionResponseType> pOSTRSforInvoiceItemManualDistributionWithHttpInfo(String invoiceItemId, POSTRevenueScheduleByTransactionType request) throws ApiException {
        com.squareup.okhttp.Call call = pOSTRSforInvoiceItemManualDistributionCall(invoiceItemId, request, null, null);
        Type localVarReturnType = new TypeToken<POSTRevenueScheduleByTransactionResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a revenue schedule for an Invoice Item (manual distribution) (asynchronously)
     * This REST API reference describes how to create a revenue schedule for an Invoice Item and manually distribute the revenue.
     * @param invoiceItemId ID of the Invoice Item, for example, e20b07fd416dcfcf0141c81164fd0a75. If the specified Invoice Item is already associated with a revenue schedule, the call will fail.  (required)
     * @param request  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pOSTRSforInvoiceItemManualDistributionAsync(String invoiceItemId, POSTRevenueScheduleByTransactionType request, final ApiCallback<POSTRevenueScheduleByTransactionResponseType> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = pOSTRSforInvoiceItemManualDistributionCall(invoiceItemId, request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<POSTRevenueScheduleByTransactionResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pOSTRevenueScheduleByChargeResponse */
    private com.squareup.okhttp.Call pOSTRevenueScheduleByChargeResponseCall(String chargeKey, POSTRevenueScheduleByChargeType request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'chargeKey' is set
        if (chargeKey == null) {
            throw new ApiException("Missing the required parameter 'chargeKey' when calling pOSTRevenueScheduleByChargeResponse(Async)");
        }
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pOSTRevenueScheduleByChargeResponse(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/revenue-schedules/subscription-charges/{charge-key}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "charge-key" + "\\}", apiClient.escapeString(chargeKey.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Create a revenue schedule on a subscription charge
     * This REST API reference describes how to create a revenue schedule by specifying the subscription charge. This method is for custom unlimited revenue recognition only.
     * @param chargeKey ID of the subscription rate plan charge; for example, 402892793e173340013e173b81000012. (required)
     * @param request  (required)
     * @return POSTRevenueScheduleByChargeResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public POSTRevenueScheduleByChargeResponseType pOSTRevenueScheduleByChargeResponse(String chargeKey, POSTRevenueScheduleByChargeType request) throws ApiException {
        ApiResponse<POSTRevenueScheduleByChargeResponseType> resp = pOSTRevenueScheduleByChargeResponseWithHttpInfo(chargeKey, request);
        return resp.getData();
    }

    /**
     * Create a revenue schedule on a subscription charge
     * This REST API reference describes how to create a revenue schedule by specifying the subscription charge. This method is for custom unlimited revenue recognition only.
     * @param chargeKey ID of the subscription rate plan charge; for example, 402892793e173340013e173b81000012. (required)
     * @param request  (required)
     * @return ApiResponse&lt;POSTRevenueScheduleByChargeResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<POSTRevenueScheduleByChargeResponseType> pOSTRevenueScheduleByChargeResponseWithHttpInfo(String chargeKey, POSTRevenueScheduleByChargeType request) throws ApiException {
        com.squareup.okhttp.Call call = pOSTRevenueScheduleByChargeResponseCall(chargeKey, request, null, null);
        Type localVarReturnType = new TypeToken<POSTRevenueScheduleByChargeResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a revenue schedule on a subscription charge (asynchronously)
     * This REST API reference describes how to create a revenue schedule by specifying the subscription charge. This method is for custom unlimited revenue recognition only.
     * @param chargeKey ID of the subscription rate plan charge; for example, 402892793e173340013e173b81000012. (required)
     * @param request  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pOSTRevenueScheduleByChargeResponseAsync(String chargeKey, POSTRevenueScheduleByChargeType request, final ApiCallback<POSTRevenueScheduleByChargeResponseType> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = pOSTRevenueScheduleByChargeResponseCall(chargeKey, request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<POSTRevenueScheduleByChargeResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pUTRSBasicInfo */
    private com.squareup.okhttp.Call pUTRSBasicInfoCall(String rsNumber, PUTRSBasicInfoType request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'rsNumber' is set
        if (rsNumber == null) {
            throw new ApiException("Missing the required parameter 'rsNumber' when calling pUTRSBasicInfo(Async)");
        }
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pUTRSBasicInfo(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/revenue-schedules/{rs-number}/basic-information".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "rs-number" + "\\}", apiClient.escapeString(rsNumber.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Update revenue schedule basic information
     * This REST API reference describes how to get basic information of a revenue schedule by specifying the revenue schedule number. Request and response field descriptions and sample code are provided. 
     * @param rsNumber Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  (required)
     * @param request  (required)
     * @return CommonResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CommonResponseType pUTRSBasicInfo(String rsNumber, PUTRSBasicInfoType request) throws ApiException {
        ApiResponse<CommonResponseType> resp = pUTRSBasicInfoWithHttpInfo(rsNumber, request);
        return resp.getData();
    }

    /**
     * Update revenue schedule basic information
     * This REST API reference describes how to get basic information of a revenue schedule by specifying the revenue schedule number. Request and response field descriptions and sample code are provided. 
     * @param rsNumber Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  (required)
     * @param request  (required)
     * @return ApiResponse&lt;CommonResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CommonResponseType> pUTRSBasicInfoWithHttpInfo(String rsNumber, PUTRSBasicInfoType request) throws ApiException {
        com.squareup.okhttp.Call call = pUTRSBasicInfoCall(rsNumber, request, null, null);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update revenue schedule basic information (asynchronously)
     * This REST API reference describes how to get basic information of a revenue schedule by specifying the revenue schedule number. Request and response field descriptions and sample code are provided. 
     * @param rsNumber Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  (required)
     * @param request  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pUTRSBasicInfoAsync(String rsNumber, PUTRSBasicInfoType request, final ApiCallback<CommonResponseType> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = pUTRSBasicInfoCall(rsNumber, request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pUTRevenueAcrossAP */
    private com.squareup.okhttp.Call pUTRevenueAcrossAPCall(String rsNumber, PUTAllocateManuallyType request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'rsNumber' is set
        if (rsNumber == null) {
            throw new ApiException("Missing the required parameter 'rsNumber' when calling pUTRevenueAcrossAP(Async)");
        }
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pUTRevenueAcrossAP(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/revenue-schedules/{rs-number}/distribute-revenue-across-accounting-periods".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "rs-number" + "\\}", apiClient.escapeString(rsNumber.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Distribute revenue across accounting periods
     * This REST API reference describes how to distribute revenue by specifying the revenue schedule number. Request and response field descriptions and sample code are provided.
     * @param rsNumber Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  (required)
     * @param request  (required)
     * @return PUTRevenueScheduleResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PUTRevenueScheduleResponseType pUTRevenueAcrossAP(String rsNumber, PUTAllocateManuallyType request) throws ApiException {
        ApiResponse<PUTRevenueScheduleResponseType> resp = pUTRevenueAcrossAPWithHttpInfo(rsNumber, request);
        return resp.getData();
    }

    /**
     * Distribute revenue across accounting periods
     * This REST API reference describes how to distribute revenue by specifying the revenue schedule number. Request and response field descriptions and sample code are provided.
     * @param rsNumber Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  (required)
     * @param request  (required)
     * @return ApiResponse&lt;PUTRevenueScheduleResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PUTRevenueScheduleResponseType> pUTRevenueAcrossAPWithHttpInfo(String rsNumber, PUTAllocateManuallyType request) throws ApiException {
        com.squareup.okhttp.Call call = pUTRevenueAcrossAPCall(rsNumber, request, null, null);
        Type localVarReturnType = new TypeToken<PUTRevenueScheduleResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Distribute revenue across accounting periods (asynchronously)
     * This REST API reference describes how to distribute revenue by specifying the revenue schedule number. Request and response field descriptions and sample code are provided.
     * @param rsNumber Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  (required)
     * @param request  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pUTRevenueAcrossAPAsync(String rsNumber, PUTAllocateManuallyType request, final ApiCallback<PUTRevenueScheduleResponseType> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = pUTRevenueAcrossAPCall(rsNumber, request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PUTRevenueScheduleResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pUTRevenueByRecognitionStartandEndDates */
    private com.squareup.okhttp.Call pUTRevenueByRecognitionStartandEndDatesCall(String rsNumber, PUTRSTermType request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'rsNumber' is set
        if (rsNumber == null) {
            throw new ApiException("Missing the required parameter 'rsNumber' when calling pUTRevenueByRecognitionStartandEndDates(Async)");
        }
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pUTRevenueByRecognitionStartandEndDates(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/revenue-schedules/{rs-number}/distribute-revenue-with-date-range".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "rs-number" + "\\}", apiClient.escapeString(rsNumber.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Distribute revenue by recognition start and end dates
     * This REST API reference describes how to distribute revenue by specifying the recognition start and end dates. Request and response field descriptions and sample code are provided.
     * @param rsNumber Revenue schedule number. Specify the revenue schedule whose revenue you want to distribute.    The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  (required)
     * @param request  (required)
     * @return PUTRevenueScheduleResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PUTRevenueScheduleResponseType pUTRevenueByRecognitionStartandEndDates(String rsNumber, PUTRSTermType request) throws ApiException {
        ApiResponse<PUTRevenueScheduleResponseType> resp = pUTRevenueByRecognitionStartandEndDatesWithHttpInfo(rsNumber, request);
        return resp.getData();
    }

    /**
     * Distribute revenue by recognition start and end dates
     * This REST API reference describes how to distribute revenue by specifying the recognition start and end dates. Request and response field descriptions and sample code are provided.
     * @param rsNumber Revenue schedule number. Specify the revenue schedule whose revenue you want to distribute.    The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  (required)
     * @param request  (required)
     * @return ApiResponse&lt;PUTRevenueScheduleResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PUTRevenueScheduleResponseType> pUTRevenueByRecognitionStartandEndDatesWithHttpInfo(String rsNumber, PUTRSTermType request) throws ApiException {
        com.squareup.okhttp.Call call = pUTRevenueByRecognitionStartandEndDatesCall(rsNumber, request, null, null);
        Type localVarReturnType = new TypeToken<PUTRevenueScheduleResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Distribute revenue by recognition start and end dates (asynchronously)
     * This REST API reference describes how to distribute revenue by specifying the recognition start and end dates. Request and response field descriptions and sample code are provided.
     * @param rsNumber Revenue schedule number. Specify the revenue schedule whose revenue you want to distribute.    The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  (required)
     * @param request  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pUTRevenueByRecognitionStartandEndDatesAsync(String rsNumber, PUTRSTermType request, final ApiCallback<PUTRevenueScheduleResponseType> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = pUTRevenueByRecognitionStartandEndDatesCall(rsNumber, request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PUTRevenueScheduleResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pUTRevenueSpecificDate */
    private com.squareup.okhttp.Call pUTRevenueSpecificDateCall(String rsNumber, PUTSpecificDateAllocationType request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'rsNumber' is set
        if (rsNumber == null) {
            throw new ApiException("Missing the required parameter 'rsNumber' when calling pUTRevenueSpecificDate(Async)");
        }
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pUTRevenueSpecificDate(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/revenue-schedules/{rs-number}/distribute-revenue-on-specific-date".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "rs-number" + "\\}", apiClient.escapeString(rsNumber.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Distribute revenue on a specific date
     * This REST API reference describes how to distribute revenue on a specific recognition date. Request and response field descriptions and sample code are provided.
     * @param rsNumber Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  (required)
     * @param request  (required)
     * @return PUTRevenueScheduleResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PUTRevenueScheduleResponseType pUTRevenueSpecificDate(String rsNumber, PUTSpecificDateAllocationType request) throws ApiException {
        ApiResponse<PUTRevenueScheduleResponseType> resp = pUTRevenueSpecificDateWithHttpInfo(rsNumber, request);
        return resp.getData();
    }

    /**
     * Distribute revenue on a specific date
     * This REST API reference describes how to distribute revenue on a specific recognition date. Request and response field descriptions and sample code are provided.
     * @param rsNumber Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  (required)
     * @param request  (required)
     * @return ApiResponse&lt;PUTRevenueScheduleResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PUTRevenueScheduleResponseType> pUTRevenueSpecificDateWithHttpInfo(String rsNumber, PUTSpecificDateAllocationType request) throws ApiException {
        com.squareup.okhttp.Call call = pUTRevenueSpecificDateCall(rsNumber, request, null, null);
        Type localVarReturnType = new TypeToken<PUTRevenueScheduleResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Distribute revenue on a specific date (asynchronously)
     * This REST API reference describes how to distribute revenue on a specific recognition date. Request and response field descriptions and sample code are provided.
     * @param rsNumber Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  (required)
     * @param request  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pUTRevenueSpecificDateAsync(String rsNumber, PUTSpecificDateAllocationType request, final ApiCallback<PUTRevenueScheduleResponseType> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = pUTRevenueSpecificDateCall(rsNumber, request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PUTRevenueScheduleResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
