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
import io.swagger.client.model.GETAccountingPeriodType;
import io.swagger.client.model.GETAccountingPeriodsType;
import io.swagger.client.model.POSTAccountingPeriodResponseType;
import io.swagger.client.model.POSTAccountingPeriodType;
import io.swagger.client.model.PUTAccountingPeriodType;
import io.swagger.client.model.ProxyDeleteResponse;
import io.swagger.client.model.ProxyGetAccountingPeriod;
import io.swagger.client.model.ProxyNoDataResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountingPeriodsApi {
    private ApiClient apiClient;

    public AccountingPeriodsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AccountingPeriodsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for dELETEAccountingPeriod */
    private com.squareup.okhttp.Call dELETEAccountingPeriodCall(String apId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'apId' is set
        if (apId == null) {
            throw new ApiException("Missing the required parameter 'apId' when calling dELETEAccountingPeriod(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/accounting-periods/{ap-id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "ap-id" + "\\}", apiClient.escapeString(apId.toString()));

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
     * Delete accounting period
     *  Deletes an accounting period.  Prerequisites -------------   * You must have Zuora Finance enabled on your tenant.   * You must have the Delete Accounting Period user permission. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).   Limitations -----------  The accounting period to be deleted:  * Must be the most recent accounting period  * Must be an open accounting period  * Must have no revenue distributed into it  * Must not have any active journal entries  * Must not be the open-ended accounting period  * Must not be in the process of running a trial balance 
     * @param apId ID of the accounting period you want to delete. (required)
     * @return CommonResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CommonResponseType dELETEAccountingPeriod(String apId) throws ApiException {
        ApiResponse<CommonResponseType> resp = dELETEAccountingPeriodWithHttpInfo(apId);
        return resp.getData();
    }

    /**
     * Delete accounting period
     *  Deletes an accounting period.  Prerequisites -------------   * You must have Zuora Finance enabled on your tenant.   * You must have the Delete Accounting Period user permission. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).   Limitations -----------  The accounting period to be deleted:  * Must be the most recent accounting period  * Must be an open accounting period  * Must have no revenue distributed into it  * Must not have any active journal entries  * Must not be the open-ended accounting period  * Must not be in the process of running a trial balance 
     * @param apId ID of the accounting period you want to delete. (required)
     * @return ApiResponse&lt;CommonResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CommonResponseType> dELETEAccountingPeriodWithHttpInfo(String apId) throws ApiException {
        com.squareup.okhttp.Call call = dELETEAccountingPeriodCall(apId, null, null);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete accounting period (asynchronously)
     *  Deletes an accounting period.  Prerequisites -------------   * You must have Zuora Finance enabled on your tenant.   * You must have the Delete Accounting Period user permission. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).   Limitations -----------  The accounting period to be deleted:  * Must be the most recent accounting period  * Must be an open accounting period  * Must have no revenue distributed into it  * Must not have any active journal entries  * Must not be the open-ended accounting period  * Must not be in the process of running a trial balance 
     * @param apId ID of the accounting period you want to delete. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call dELETEAccountingPeriodAsync(String apId, final ApiCallback<CommonResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = dELETEAccountingPeriodCall(apId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for gETAccountingPeriod */
    private com.squareup.okhttp.Call gETAccountingPeriodCall(String apId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'apId' is set
        if (apId == null) {
            throw new ApiException("Missing the required parameter 'apId' when calling gETAccountingPeriod(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/accounting-periods/{ap-id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "ap-id" + "\\}", apiClient.escapeString(apId.toString()));

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
     * Get accounting period
     * Retrieves an accounting period. Prerequisites -------------  You must have Zuora Finance enabled on your tenant. 
     * @param apId ID of the accounting period you want to get. (required)
     * @return GETAccountingPeriodType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GETAccountingPeriodType gETAccountingPeriod(String apId) throws ApiException {
        ApiResponse<GETAccountingPeriodType> resp = gETAccountingPeriodWithHttpInfo(apId);
        return resp.getData();
    }

    /**
     * Get accounting period
     * Retrieves an accounting period. Prerequisites -------------  You must have Zuora Finance enabled on your tenant. 
     * @param apId ID of the accounting period you want to get. (required)
     * @return ApiResponse&lt;GETAccountingPeriodType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GETAccountingPeriodType> gETAccountingPeriodWithHttpInfo(String apId) throws ApiException {
        com.squareup.okhttp.Call call = gETAccountingPeriodCall(apId, null, null);
        Type localVarReturnType = new TypeToken<GETAccountingPeriodType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get accounting period (asynchronously)
     * Retrieves an accounting period. Prerequisites -------------  You must have Zuora Finance enabled on your tenant. 
     * @param apId ID of the accounting period you want to get. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call gETAccountingPeriodAsync(String apId, final ApiCallback<GETAccountingPeriodType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = gETAccountingPeriodCall(apId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GETAccountingPeriodType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for gETAccountingPeriods */
    private com.squareup.okhttp.Call gETAccountingPeriodsCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/accounting-periods".replaceAll("\\{format\\}","json");

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
     * Get all accounting periods
     * Retrieves all accounting periods on your tenant.
     * @return GETAccountingPeriodsType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GETAccountingPeriodsType gETAccountingPeriods() throws ApiException {
        ApiResponse<GETAccountingPeriodsType> resp = gETAccountingPeriodsWithHttpInfo();
        return resp.getData();
    }

    /**
     * Get all accounting periods
     * Retrieves all accounting periods on your tenant.
     * @return ApiResponse&lt;GETAccountingPeriodsType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GETAccountingPeriodsType> gETAccountingPeriodsWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = gETAccountingPeriodsCall(null, null);
        Type localVarReturnType = new TypeToken<GETAccountingPeriodsType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get all accounting periods (asynchronously)
     * Retrieves all accounting periods on your tenant.
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call gETAccountingPeriodsAsync(final ApiCallback<GETAccountingPeriodsType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = gETAccountingPeriodsCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GETAccountingPeriodsType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pOSTAccountingPeriod */
    private com.squareup.okhttp.Call pOSTAccountingPeriodCall(POSTAccountingPeriodType request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pOSTAccountingPeriod(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/accounting-periods".replaceAll("\\{format\\}","json");

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
     * Create accounting period
     * Creates an accounting period. Prerequisites ------------- * You must have Zuora Finance enabled on your tenant. * You must have the Create Accounting Period user permission. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/Z-Finance_Roles).  Limitations ----------- * When creating the first accounting period on your tenant, the start date must be equal to or earlier than the date of the earliest transaction on the tenant. * Start and end dates of accounting periods must be contiguous. For example, if one accounting period ends on January 31, the next period must start on February 1. * If you have the Revenue Recognition Package and have enabled the \&quot;Monthly recognition over time\&quot; revenue recognition model, the accounting period start date and end date must be on the first day and last day of the month, respectively. Note that the start and end dates do not necessarily have to be in the same month.
     * @param request  (required)
     * @return POSTAccountingPeriodResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public POSTAccountingPeriodResponseType pOSTAccountingPeriod(POSTAccountingPeriodType request) throws ApiException {
        ApiResponse<POSTAccountingPeriodResponseType> resp = pOSTAccountingPeriodWithHttpInfo(request);
        return resp.getData();
    }

    /**
     * Create accounting period
     * Creates an accounting period. Prerequisites ------------- * You must have Zuora Finance enabled on your tenant. * You must have the Create Accounting Period user permission. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/Z-Finance_Roles).  Limitations ----------- * When creating the first accounting period on your tenant, the start date must be equal to or earlier than the date of the earliest transaction on the tenant. * Start and end dates of accounting periods must be contiguous. For example, if one accounting period ends on January 31, the next period must start on February 1. * If you have the Revenue Recognition Package and have enabled the \&quot;Monthly recognition over time\&quot; revenue recognition model, the accounting period start date and end date must be on the first day and last day of the month, respectively. Note that the start and end dates do not necessarily have to be in the same month.
     * @param request  (required)
     * @return ApiResponse&lt;POSTAccountingPeriodResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<POSTAccountingPeriodResponseType> pOSTAccountingPeriodWithHttpInfo(POSTAccountingPeriodType request) throws ApiException {
        com.squareup.okhttp.Call call = pOSTAccountingPeriodCall(request, null, null);
        Type localVarReturnType = new TypeToken<POSTAccountingPeriodResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create accounting period (asynchronously)
     * Creates an accounting period. Prerequisites ------------- * You must have Zuora Finance enabled on your tenant. * You must have the Create Accounting Period user permission. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/Z-Finance_Roles).  Limitations ----------- * When creating the first accounting period on your tenant, the start date must be equal to or earlier than the date of the earliest transaction on the tenant. * Start and end dates of accounting periods must be contiguous. For example, if one accounting period ends on January 31, the next period must start on February 1. * If you have the Revenue Recognition Package and have enabled the \&quot;Monthly recognition over time\&quot; revenue recognition model, the accounting period start date and end date must be on the first day and last day of the month, respectively. Note that the start and end dates do not necessarily have to be in the same month.
     * @param request  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pOSTAccountingPeriodAsync(POSTAccountingPeriodType request, final ApiCallback<POSTAccountingPeriodResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = pOSTAccountingPeriodCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<POSTAccountingPeriodResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pUTCloseAccountingPeriod */
    private com.squareup.okhttp.Call pUTCloseAccountingPeriodCall(String apId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'apId' is set
        if (apId == null) {
            throw new ApiException("Missing the required parameter 'apId' when calling pUTCloseAccountingPeriod(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/accounting-periods/{ap-id}/close".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "ap-id" + "\\}", apiClient.escapeString(apId.toString()));

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
     * Close accounting period
     * Close an [accounting period](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods) by accounting period ID.  Prerequisites ------------- You must have Zuora Finance enabled on your tenant. You must have the Manage Close Process and Run Trial Balance user permissions. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles). Limitations ----------- * The accounting period cannot already be closed. * The accounting period cannot be in the process of running a trial balance. * All earlier accounting periods must be closed. * There must be no required action items for the accounting period. See [Reconcile Transactions Before Closing an Accounting Period](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/G_Reconcile_transactions_before_closing_an_accounting_period) for more information.  Notes ----- When you close an accounting period in Zuora, a trial balance is automatically run for that period. A successful response means only that the accounting period is now closed, but does not mean that the trial balance has successfully completed.
     * @param apId ID of the accounting period you want to close. (required)
     * @return CommonResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CommonResponseType pUTCloseAccountingPeriod(String apId) throws ApiException {
        ApiResponse<CommonResponseType> resp = pUTCloseAccountingPeriodWithHttpInfo(apId);
        return resp.getData();
    }

    /**
     * Close accounting period
     * Close an [accounting period](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods) by accounting period ID.  Prerequisites ------------- You must have Zuora Finance enabled on your tenant. You must have the Manage Close Process and Run Trial Balance user permissions. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles). Limitations ----------- * The accounting period cannot already be closed. * The accounting period cannot be in the process of running a trial balance. * All earlier accounting periods must be closed. * There must be no required action items for the accounting period. See [Reconcile Transactions Before Closing an Accounting Period](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/G_Reconcile_transactions_before_closing_an_accounting_period) for more information.  Notes ----- When you close an accounting period in Zuora, a trial balance is automatically run for that period. A successful response means only that the accounting period is now closed, but does not mean that the trial balance has successfully completed.
     * @param apId ID of the accounting period you want to close. (required)
     * @return ApiResponse&lt;CommonResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CommonResponseType> pUTCloseAccountingPeriodWithHttpInfo(String apId) throws ApiException {
        com.squareup.okhttp.Call call = pUTCloseAccountingPeriodCall(apId, null, null);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Close accounting period (asynchronously)
     * Close an [accounting period](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods) by accounting period ID.  Prerequisites ------------- You must have Zuora Finance enabled on your tenant. You must have the Manage Close Process and Run Trial Balance user permissions. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles). Limitations ----------- * The accounting period cannot already be closed. * The accounting period cannot be in the process of running a trial balance. * All earlier accounting periods must be closed. * There must be no required action items for the accounting period. See [Reconcile Transactions Before Closing an Accounting Period](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/G_Reconcile_transactions_before_closing_an_accounting_period) for more information.  Notes ----- When you close an accounting period in Zuora, a trial balance is automatically run for that period. A successful response means only that the accounting period is now closed, but does not mean that the trial balance has successfully completed.
     * @param apId ID of the accounting period you want to close. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pUTCloseAccountingPeriodAsync(String apId, final ApiCallback<CommonResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = pUTCloseAccountingPeriodCall(apId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pUTPendingCloseAccountingPeriod */
    private com.squareup.okhttp.Call pUTPendingCloseAccountingPeriodCall(String apId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'apId' is set
        if (apId == null) {
            throw new ApiException("Missing the required parameter 'apId' when calling pUTPendingCloseAccountingPeriod(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/accounting-periods/{ap-id}/pending-close".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "ap-id" + "\\}", apiClient.escapeString(apId.toString()));

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
     * Set accounting period to pending close
     * Sets an accounting period to pending close.   Prerequisites -------------  * You must have Zuora Finance enabled on your tenant. * You must have the Manage Close Process and Run Trial Balance user permissions. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).              Limitations   -----------    * The accounting period cannot be closed or pending close.    * The accounting period cannot be in the process of running a trial balance.    * All earlier accounting periods must be closed.     Notes ----- When you set an accounting period to pending close in Zuora, a trial balance is automatically run for that period. A response of &#x60;{ \&quot;success\&quot;: true }&#x60;  means only that the accounting period status is now pending close, but does not mean that the trial balance has successfully completed. You can use the Get Accounting Period REST API call to view details about the outcome of the trial balance. 
     * @param apId ID of the accounting period you want to set to pending close. (required)
     * @return CommonResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CommonResponseType pUTPendingCloseAccountingPeriod(String apId) throws ApiException {
        ApiResponse<CommonResponseType> resp = pUTPendingCloseAccountingPeriodWithHttpInfo(apId);
        return resp.getData();
    }

    /**
     * Set accounting period to pending close
     * Sets an accounting period to pending close.   Prerequisites -------------  * You must have Zuora Finance enabled on your tenant. * You must have the Manage Close Process and Run Trial Balance user permissions. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).              Limitations   -----------    * The accounting period cannot be closed or pending close.    * The accounting period cannot be in the process of running a trial balance.    * All earlier accounting periods must be closed.     Notes ----- When you set an accounting period to pending close in Zuora, a trial balance is automatically run for that period. A response of &#x60;{ \&quot;success\&quot;: true }&#x60;  means only that the accounting period status is now pending close, but does not mean that the trial balance has successfully completed. You can use the Get Accounting Period REST API call to view details about the outcome of the trial balance. 
     * @param apId ID of the accounting period you want to set to pending close. (required)
     * @return ApiResponse&lt;CommonResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CommonResponseType> pUTPendingCloseAccountingPeriodWithHttpInfo(String apId) throws ApiException {
        com.squareup.okhttp.Call call = pUTPendingCloseAccountingPeriodCall(apId, null, null);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Set accounting period to pending close (asynchronously)
     * Sets an accounting period to pending close.   Prerequisites -------------  * You must have Zuora Finance enabled on your tenant. * You must have the Manage Close Process and Run Trial Balance user permissions. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).              Limitations   -----------    * The accounting period cannot be closed or pending close.    * The accounting period cannot be in the process of running a trial balance.    * All earlier accounting periods must be closed.     Notes ----- When you set an accounting period to pending close in Zuora, a trial balance is automatically run for that period. A response of &#x60;{ \&quot;success\&quot;: true }&#x60;  means only that the accounting period status is now pending close, but does not mean that the trial balance has successfully completed. You can use the Get Accounting Period REST API call to view details about the outcome of the trial balance. 
     * @param apId ID of the accounting period you want to set to pending close. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pUTPendingCloseAccountingPeriodAsync(String apId, final ApiCallback<CommonResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = pUTPendingCloseAccountingPeriodCall(apId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pUTReopenAccountingPeriod */
    private com.squareup.okhttp.Call pUTReopenAccountingPeriodCall(String apId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'apId' is set
        if (apId == null) {
            throw new ApiException("Missing the required parameter 'apId' when calling pUTReopenAccountingPeriod(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/accounting-periods/{ap-id}/reopen".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "ap-id" + "\\}", apiClient.escapeString(apId.toString()));

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
     * Re-open accounting period
     * Re-opens an accounting period. See [Re-Open Accounting Periods](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/H_Reopen_accounting_periods) for more information. Prerequisites ------------- * You must have Zuora Finance enabled on your tenant. * You must have the Manage Close Process and Run Trial Balance user permissions. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).  Limitations ----------- * The accounting period must be closed or pending close. * You can only re-open an accounting period that is immediately previous to an open period. See [re-open an accounting period](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/H_Reopen_accounting_periods) for an example.
     * @param apId ID of the accounting period that you want to re-open. (required)
     * @return CommonResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CommonResponseType pUTReopenAccountingPeriod(String apId) throws ApiException {
        ApiResponse<CommonResponseType> resp = pUTReopenAccountingPeriodWithHttpInfo(apId);
        return resp.getData();
    }

    /**
     * Re-open accounting period
     * Re-opens an accounting period. See [Re-Open Accounting Periods](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/H_Reopen_accounting_periods) for more information. Prerequisites ------------- * You must have Zuora Finance enabled on your tenant. * You must have the Manage Close Process and Run Trial Balance user permissions. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).  Limitations ----------- * The accounting period must be closed or pending close. * You can only re-open an accounting period that is immediately previous to an open period. See [re-open an accounting period](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/H_Reopen_accounting_periods) for an example.
     * @param apId ID of the accounting period that you want to re-open. (required)
     * @return ApiResponse&lt;CommonResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CommonResponseType> pUTReopenAccountingPeriodWithHttpInfo(String apId) throws ApiException {
        com.squareup.okhttp.Call call = pUTReopenAccountingPeriodCall(apId, null, null);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Re-open accounting period (asynchronously)
     * Re-opens an accounting period. See [Re-Open Accounting Periods](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/H_Reopen_accounting_periods) for more information. Prerequisites ------------- * You must have Zuora Finance enabled on your tenant. * You must have the Manage Close Process and Run Trial Balance user permissions. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).  Limitations ----------- * The accounting period must be closed or pending close. * You can only re-open an accounting period that is immediately previous to an open period. See [re-open an accounting period](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/H_Reopen_accounting_periods) for an example.
     * @param apId ID of the accounting period that you want to re-open. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pUTReopenAccountingPeriodAsync(String apId, final ApiCallback<CommonResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = pUTReopenAccountingPeriodCall(apId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pUTRunTrialBalance */
    private com.squareup.okhttp.Call pUTRunTrialBalanceCall(String apId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'apId' is set
        if (apId == null) {
            throw new ApiException("Missing the required parameter 'apId' when calling pUTRunTrialBalance(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/accounting-periods/{ap-id}/run-trial-balance".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "ap-id" + "\\}", apiClient.escapeString(apId.toString()));

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
     * Run trial balance
     * Runs the trial balance for an accounting period. See [Run a Trial Balance](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/D_Run_a_trial_balance) for more information.  Prerequisites -------------  * You must have Zuora Finance enabled on your tenant.  * You must have the Manage Close Process and Run Trial Balance user permissions. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).             Limitations  -----------    * The accounting period must be open.    * The accounting period cannot already be in the process of running a trial balance.   Notes ----- The trial balance is run asynchronously. A response of &#x60;{ \&quot;success\&quot;: true }&#x60; means only that the trial balance has started processing, but does not mean that the trial balance has successfully completed. You can use the [Get Accounting Period](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Accounting_Periods/Get_Accounting_Period) REST API call to view details about the outcome of the trial balance. 
     * @param apId ID of the accounting period for which you want to run a trial balance. (required)
     * @return CommonResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CommonResponseType pUTRunTrialBalance(String apId) throws ApiException {
        ApiResponse<CommonResponseType> resp = pUTRunTrialBalanceWithHttpInfo(apId);
        return resp.getData();
    }

    /**
     * Run trial balance
     * Runs the trial balance for an accounting period. See [Run a Trial Balance](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/D_Run_a_trial_balance) for more information.  Prerequisites -------------  * You must have Zuora Finance enabled on your tenant.  * You must have the Manage Close Process and Run Trial Balance user permissions. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).             Limitations  -----------    * The accounting period must be open.    * The accounting period cannot already be in the process of running a trial balance.   Notes ----- The trial balance is run asynchronously. A response of &#x60;{ \&quot;success\&quot;: true }&#x60; means only that the trial balance has started processing, but does not mean that the trial balance has successfully completed. You can use the [Get Accounting Period](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Accounting_Periods/Get_Accounting_Period) REST API call to view details about the outcome of the trial balance. 
     * @param apId ID of the accounting period for which you want to run a trial balance. (required)
     * @return ApiResponse&lt;CommonResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CommonResponseType> pUTRunTrialBalanceWithHttpInfo(String apId) throws ApiException {
        com.squareup.okhttp.Call call = pUTRunTrialBalanceCall(apId, null, null);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Run trial balance (asynchronously)
     * Runs the trial balance for an accounting period. See [Run a Trial Balance](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/D_Run_a_trial_balance) for more information.  Prerequisites -------------  * You must have Zuora Finance enabled on your tenant.  * You must have the Manage Close Process and Run Trial Balance user permissions. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).             Limitations  -----------    * The accounting period must be open.    * The accounting period cannot already be in the process of running a trial balance.   Notes ----- The trial balance is run asynchronously. A response of &#x60;{ \&quot;success\&quot;: true }&#x60; means only that the trial balance has started processing, but does not mean that the trial balance has successfully completed. You can use the [Get Accounting Period](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Accounting_Periods/Get_Accounting_Period) REST API call to view details about the outcome of the trial balance. 
     * @param apId ID of the accounting period for which you want to run a trial balance. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pUTRunTrialBalanceAsync(String apId, final ApiCallback<CommonResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = pUTRunTrialBalanceCall(apId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pUTUpdateAccountingPeriod */
    private com.squareup.okhttp.Call pUTUpdateAccountingPeriodCall(String apId, PUTAccountingPeriodType request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'apId' is set
        if (apId == null) {
            throw new ApiException("Missing the required parameter 'apId' when calling pUTUpdateAccountingPeriod(Async)");
        }
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pUTUpdateAccountingPeriod(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/accounting-periods/{ap-id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "ap-id" + "\\}", apiClient.escapeString(apId.toString()));

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
     * Update accounting period
     *  Updates an accounting period.  Prerequisites -------------  * You must have Zuora Finance enabled on your tenant.  * You must have the Create Accounting Period user permission. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).  Limitations -----------  * You can update the start date of only the earliest accounting period on your tenant. You cannot update the start date of later periods.  * If you update the earliest accounting period, the start date must be equal to or earlier than the date of the earliest transaction on the tenant.  * Start and end dates of accounting periods must be contiguous. For example, if one accounting period ends on January 31, the next period must start on February 1.  * If you have the Revenue Recognition Package and have enabled the \&quot;Monthly recognition over time\&quot; revenue recognition model, the accounting period start date and end date must be on the first day and last day of the month, respectively. Note that the start and end dates do not necessarily have to be in the same month.  * You cannot update the start date or end date of an accounting period if:   * Any revenue has been distributed into the period.   * The period has any active journal entries. 
     * @param apId ID of the accounting period you want to update. (required)
     * @param request  (required)
     * @return CommonResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CommonResponseType pUTUpdateAccountingPeriod(String apId, PUTAccountingPeriodType request) throws ApiException {
        ApiResponse<CommonResponseType> resp = pUTUpdateAccountingPeriodWithHttpInfo(apId, request);
        return resp.getData();
    }

    /**
     * Update accounting period
     *  Updates an accounting period.  Prerequisites -------------  * You must have Zuora Finance enabled on your tenant.  * You must have the Create Accounting Period user permission. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).  Limitations -----------  * You can update the start date of only the earliest accounting period on your tenant. You cannot update the start date of later periods.  * If you update the earliest accounting period, the start date must be equal to or earlier than the date of the earliest transaction on the tenant.  * Start and end dates of accounting periods must be contiguous. For example, if one accounting period ends on January 31, the next period must start on February 1.  * If you have the Revenue Recognition Package and have enabled the \&quot;Monthly recognition over time\&quot; revenue recognition model, the accounting period start date and end date must be on the first day and last day of the month, respectively. Note that the start and end dates do not necessarily have to be in the same month.  * You cannot update the start date or end date of an accounting period if:   * Any revenue has been distributed into the period.   * The period has any active journal entries. 
     * @param apId ID of the accounting period you want to update. (required)
     * @param request  (required)
     * @return ApiResponse&lt;CommonResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CommonResponseType> pUTUpdateAccountingPeriodWithHttpInfo(String apId, PUTAccountingPeriodType request) throws ApiException {
        com.squareup.okhttp.Call call = pUTUpdateAccountingPeriodCall(apId, request, null, null);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update accounting period (asynchronously)
     *  Updates an accounting period.  Prerequisites -------------  * You must have Zuora Finance enabled on your tenant.  * You must have the Create Accounting Period user permission. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).  Limitations -----------  * You can update the start date of only the earliest accounting period on your tenant. You cannot update the start date of later periods.  * If you update the earliest accounting period, the start date must be equal to or earlier than the date of the earliest transaction on the tenant.  * Start and end dates of accounting periods must be contiguous. For example, if one accounting period ends on January 31, the next period must start on February 1.  * If you have the Revenue Recognition Package and have enabled the \&quot;Monthly recognition over time\&quot; revenue recognition model, the accounting period start date and end date must be on the first day and last day of the month, respectively. Note that the start and end dates do not necessarily have to be in the same month.  * You cannot update the start date or end date of an accounting period if:   * Any revenue has been distributed into the period.   * The period has any active journal entries. 
     * @param apId ID of the accounting period you want to update. (required)
     * @param request  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pUTUpdateAccountingPeriodAsync(String apId, PUTAccountingPeriodType request, final ApiCallback<CommonResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = pUTUpdateAccountingPeriodCall(apId, request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyDELETEAccountingPeriod */
    private com.squareup.okhttp.Call proxyDELETEAccountingPeriodCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling proxyDELETEAccountingPeriod(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/object/accounting-period/{id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
     * CRUD: Delete AccountingPeriod
     * 
     * @param id Object id (required)
     * @return ProxyDeleteResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyDeleteResponse proxyDELETEAccountingPeriod(String id) throws ApiException {
        ApiResponse<ProxyDeleteResponse> resp = proxyDELETEAccountingPeriodWithHttpInfo(id);
        return resp.getData();
    }

    /**
     * CRUD: Delete AccountingPeriod
     * 
     * @param id Object id (required)
     * @return ApiResponse&lt;ProxyDeleteResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyDeleteResponse> proxyDELETEAccountingPeriodWithHttpInfo(String id) throws ApiException {
        com.squareup.okhttp.Call call = proxyDELETEAccountingPeriodCall(id, null, null);
        Type localVarReturnType = new TypeToken<ProxyDeleteResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * CRUD: Delete AccountingPeriod (asynchronously)
     * 
     * @param id Object id (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyDELETEAccountingPeriodAsync(String id, final ApiCallback<ProxyDeleteResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyDELETEAccountingPeriodCall(id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyDeleteResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyGETAccountingPeriod */
    private com.squareup.okhttp.Call proxyGETAccountingPeriodCall(String id, String fields, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling proxyGETAccountingPeriod(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/object/accounting-period/{id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (fields != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "fields", fields));

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
     * CRUD: Retrieve AccountingPeriod
     * 
     * @param id Object id (required)
     * @param fields Object fields to return (optional)
     * @return ProxyGetAccountingPeriod
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyGetAccountingPeriod proxyGETAccountingPeriod(String id, String fields) throws ApiException {
        ApiResponse<ProxyGetAccountingPeriod> resp = proxyGETAccountingPeriodWithHttpInfo(id, fields);
        return resp.getData();
    }

    /**
     * CRUD: Retrieve AccountingPeriod
     * 
     * @param id Object id (required)
     * @param fields Object fields to return (optional)
     * @return ApiResponse&lt;ProxyGetAccountingPeriod&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyGetAccountingPeriod> proxyGETAccountingPeriodWithHttpInfo(String id, String fields) throws ApiException {
        com.squareup.okhttp.Call call = proxyGETAccountingPeriodCall(id, fields, null, null);
        Type localVarReturnType = new TypeToken<ProxyGetAccountingPeriod>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * CRUD: Retrieve AccountingPeriod (asynchronously)
     * 
     * @param id Object id (required)
     * @param fields Object fields to return (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyGETAccountingPeriodAsync(String id, String fields, final ApiCallback<ProxyGetAccountingPeriod> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyGETAccountingPeriodCall(id, fields, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyGetAccountingPeriod>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
