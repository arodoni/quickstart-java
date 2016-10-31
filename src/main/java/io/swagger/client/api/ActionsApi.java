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

import io.swagger.client.model.ProxyActionamendResponse;
import io.swagger.client.model.ProxyBadRequestResponse;
import io.swagger.client.model.ProxyActionamendRequest;
import io.swagger.client.model.ProxyActioncreateRequest;
import io.swagger.client.model.ProxyActioncreateResponse;
import io.swagger.client.model.ProxyActiondeleteRequest;
import io.swagger.client.model.ProxyActiondeleteResponse;
import io.swagger.client.model.ProxyActionexecuteResponse;
import io.swagger.client.model.ProxyActionexecuteRequest;
import io.swagger.client.model.ProxyActiongenerateRequest;
import io.swagger.client.model.ProxyActiongenerateResponse;
import io.swagger.client.model.ProxyActiongetUserInfoResponse;
import io.swagger.client.model.ProxyActionloginResponse;
import io.swagger.client.model.ProxyActionloginRequest;
import io.swagger.client.model.ProxyActionqueryResponse;
import io.swagger.client.model.ProxyActionqueryRequest;
import io.swagger.client.model.ProxyActionqueryMoreResponse;
import io.swagger.client.model.ProxyActionqueryMoreRequest;
import io.swagger.client.model.ProxyActionsubscribeResponse;
import io.swagger.client.model.ProxyActionsubscribeRequest;
import io.swagger.client.model.ProxyActionupdateResponse;
import io.swagger.client.model.ProxyActionupdateRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionsApi {
    private ApiClient apiClient;

    public ActionsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ActionsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for proxyActionPOSTamend */
    private com.squareup.okhttp.Call proxyActionPOSTamendCall(ProxyActionamendRequest amendRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = amendRequest;
        
        // verify the required parameter 'amendRequest' is set
        if (amendRequest == null) {
            throw new ApiException("Missing the required parameter 'amendRequest' when calling proxyActionPOSTamend(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/action/amend".replaceAll("\\{format\\}","json");

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
     * Amend
     * 
     * @param amendRequest  (required)
     * @return ProxyActionamendResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyActionamendResponse proxyActionPOSTamend(ProxyActionamendRequest amendRequest) throws ApiException {
        ApiResponse<ProxyActionamendResponse> resp = proxyActionPOSTamendWithHttpInfo(amendRequest);
        return resp.getData();
    }

    /**
     * Amend
     * 
     * @param amendRequest  (required)
     * @return ApiResponse&lt;ProxyActionamendResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyActionamendResponse> proxyActionPOSTamendWithHttpInfo(ProxyActionamendRequest amendRequest) throws ApiException {
        com.squareup.okhttp.Call call = proxyActionPOSTamendCall(amendRequest, null, null);
        Type localVarReturnType = new TypeToken<ProxyActionamendResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Amend (asynchronously)
     * 
     * @param amendRequest  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyActionPOSTamendAsync(ProxyActionamendRequest amendRequest, final ApiCallback<ProxyActionamendResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyActionPOSTamendCall(amendRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyActionamendResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyActionPOSTcreate */
    private com.squareup.okhttp.Call proxyActionPOSTcreateCall(ProxyActioncreateRequest createRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = createRequest;
        
        // verify the required parameter 'createRequest' is set
        if (createRequest == null) {
            throw new ApiException("Missing the required parameter 'createRequest' when calling proxyActionPOSTcreate(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/action/create".replaceAll("\\{format\\}","json");

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
     * Create
     * 
     * @param createRequest  (required)
     * @return ProxyActioncreateResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyActioncreateResponse proxyActionPOSTcreate(ProxyActioncreateRequest createRequest) throws ApiException {
        ApiResponse<ProxyActioncreateResponse> resp = proxyActionPOSTcreateWithHttpInfo(createRequest);
        return resp.getData();
    }

    /**
     * Create
     * 
     * @param createRequest  (required)
     * @return ApiResponse&lt;ProxyActioncreateResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyActioncreateResponse> proxyActionPOSTcreateWithHttpInfo(ProxyActioncreateRequest createRequest) throws ApiException {
        com.squareup.okhttp.Call call = proxyActionPOSTcreateCall(createRequest, null, null);
        Type localVarReturnType = new TypeToken<ProxyActioncreateResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create (asynchronously)
     * 
     * @param createRequest  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyActionPOSTcreateAsync(ProxyActioncreateRequest createRequest, final ApiCallback<ProxyActioncreateResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyActionPOSTcreateCall(createRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyActioncreateResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyActionPOSTdelete */
    private com.squareup.okhttp.Call proxyActionPOSTdeleteCall(ProxyActiondeleteRequest deleteRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = deleteRequest;
        
        // verify the required parameter 'deleteRequest' is set
        if (deleteRequest == null) {
            throw new ApiException("Missing the required parameter 'deleteRequest' when calling proxyActionPOSTdelete(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/action/delete".replaceAll("\\{format\\}","json");

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
     * Delete
     * Deletes one or more objects of the same type. You can specify different types in different delete calls, but each delete call must only apply to one type of object.  You can use this call with a string type of [zObject](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/zObject) and a list of IDs of that type. It returns an array of [DeleteResult](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/F_SOAP_API_Complex_Types/DeleteResult), indicating the success or failure of deleting each object.  The following information applies to this call:  * You will need to first determine the IDs for the objects you wish to delete. * You cannot pass in any null IDs. * All objects in a specific delete call must be of the same type.   ### Objects per Call 50 objects are supported in a single call.  ### Rate Limiting 1,000 calls are supported per 10-minute time window per tenant.  If you approach or exceed this limit, you will receive a 429 error. Multi-threading causes you to approach this limit more quickly. 
     * @param deleteRequest  (required)
     * @return ProxyActiondeleteResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyActiondeleteResponse proxyActionPOSTdelete(ProxyActiondeleteRequest deleteRequest) throws ApiException {
        ApiResponse<ProxyActiondeleteResponse> resp = proxyActionPOSTdeleteWithHttpInfo(deleteRequest);
        return resp.getData();
    }

    /**
     * Delete
     * Deletes one or more objects of the same type. You can specify different types in different delete calls, but each delete call must only apply to one type of object.  You can use this call with a string type of [zObject](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/zObject) and a list of IDs of that type. It returns an array of [DeleteResult](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/F_SOAP_API_Complex_Types/DeleteResult), indicating the success or failure of deleting each object.  The following information applies to this call:  * You will need to first determine the IDs for the objects you wish to delete. * You cannot pass in any null IDs. * All objects in a specific delete call must be of the same type.   ### Objects per Call 50 objects are supported in a single call.  ### Rate Limiting 1,000 calls are supported per 10-minute time window per tenant.  If you approach or exceed this limit, you will receive a 429 error. Multi-threading causes you to approach this limit more quickly. 
     * @param deleteRequest  (required)
     * @return ApiResponse&lt;ProxyActiondeleteResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyActiondeleteResponse> proxyActionPOSTdeleteWithHttpInfo(ProxyActiondeleteRequest deleteRequest) throws ApiException {
        com.squareup.okhttp.Call call = proxyActionPOSTdeleteCall(deleteRequest, null, null);
        Type localVarReturnType = new TypeToken<ProxyActiondeleteResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete (asynchronously)
     * Deletes one or more objects of the same type. You can specify different types in different delete calls, but each delete call must only apply to one type of object.  You can use this call with a string type of [zObject](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/zObject) and a list of IDs of that type. It returns an array of [DeleteResult](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/F_SOAP_API_Complex_Types/DeleteResult), indicating the success or failure of deleting each object.  The following information applies to this call:  * You will need to first determine the IDs for the objects you wish to delete. * You cannot pass in any null IDs. * All objects in a specific delete call must be of the same type.   ### Objects per Call 50 objects are supported in a single call.  ### Rate Limiting 1,000 calls are supported per 10-minute time window per tenant.  If you approach or exceed this limit, you will receive a 429 error. Multi-threading causes you to approach this limit more quickly. 
     * @param deleteRequest  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyActionPOSTdeleteAsync(ProxyActiondeleteRequest deleteRequest, final ApiCallback<ProxyActiondeleteResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyActionPOSTdeleteCall(deleteRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyActiondeleteResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyActionPOSTexecute */
    private com.squareup.okhttp.Call proxyActionPOSTexecuteCall(ProxyActionexecuteRequest executeRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = executeRequest;
        
        // verify the required parameter 'executeRequest' is set
        if (executeRequest == null) {
            throw new ApiException("Missing the required parameter 'executeRequest' when calling proxyActionPOSTexecute(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/action/execute".replaceAll("\\{format\\}","json");

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
     * Execute
     * Use the execute call to execute a process to split an invoice into multiple invoices. The original invoice must be in draft status. The resulting invoices are called split invoices. ## Note This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com).   To split a draft invoice into multiple split invoices:  1. Use the create call to create a separate [InvoiceSplitItem object](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/InvoiceSplitItem) for each split invoice that you want to create from the original draft invoice. 2. Use the create call to create a single [InvoiceSplit object](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/InvoiceSplit) to collect all of the InvoiceSplitItem objects. 3. Use the execute call to split the draft invoice into multiple split invoices.  You need to create InvoiceSplitItem objects and an InvoiceSplit object before you can use the execute call.   * Supported objects: InvoiceSplit * Asynchronous process: yes 
     * @param executeRequest  (required)
     * @return ProxyActionexecuteResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyActionexecuteResponse proxyActionPOSTexecute(ProxyActionexecuteRequest executeRequest) throws ApiException {
        ApiResponse<ProxyActionexecuteResponse> resp = proxyActionPOSTexecuteWithHttpInfo(executeRequest);
        return resp.getData();
    }

    /**
     * Execute
     * Use the execute call to execute a process to split an invoice into multiple invoices. The original invoice must be in draft status. The resulting invoices are called split invoices. ## Note This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com).   To split a draft invoice into multiple split invoices:  1. Use the create call to create a separate [InvoiceSplitItem object](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/InvoiceSplitItem) for each split invoice that you want to create from the original draft invoice. 2. Use the create call to create a single [InvoiceSplit object](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/InvoiceSplit) to collect all of the InvoiceSplitItem objects. 3. Use the execute call to split the draft invoice into multiple split invoices.  You need to create InvoiceSplitItem objects and an InvoiceSplit object before you can use the execute call.   * Supported objects: InvoiceSplit * Asynchronous process: yes 
     * @param executeRequest  (required)
     * @return ApiResponse&lt;ProxyActionexecuteResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyActionexecuteResponse> proxyActionPOSTexecuteWithHttpInfo(ProxyActionexecuteRequest executeRequest) throws ApiException {
        com.squareup.okhttp.Call call = proxyActionPOSTexecuteCall(executeRequest, null, null);
        Type localVarReturnType = new TypeToken<ProxyActionexecuteResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Execute (asynchronously)
     * Use the execute call to execute a process to split an invoice into multiple invoices. The original invoice must be in draft status. The resulting invoices are called split invoices. ## Note This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com).   To split a draft invoice into multiple split invoices:  1. Use the create call to create a separate [InvoiceSplitItem object](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/InvoiceSplitItem) for each split invoice that you want to create from the original draft invoice. 2. Use the create call to create a single [InvoiceSplit object](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/InvoiceSplit) to collect all of the InvoiceSplitItem objects. 3. Use the execute call to split the draft invoice into multiple split invoices.  You need to create InvoiceSplitItem objects and an InvoiceSplit object before you can use the execute call.   * Supported objects: InvoiceSplit * Asynchronous process: yes 
     * @param executeRequest  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyActionPOSTexecuteAsync(ProxyActionexecuteRequest executeRequest, final ApiCallback<ProxyActionexecuteResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyActionPOSTexecuteCall(executeRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyActionexecuteResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyActionPOSTgenerate */
    private com.squareup.okhttp.Call proxyActionPOSTgenerateCall(ProxyActiongenerateRequest generateRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = generateRequest;
        
        // verify the required parameter 'generateRequest' is set
        if (generateRequest == null) {
            throw new ApiException("Missing the required parameter 'generateRequest' when calling proxyActionPOSTgenerate(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/action/generate".replaceAll("\\{format\\}","json");

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
     * Generate
     * Use the generate call to generate an on demand invoice for a specific customer. This process is similar to the process in the Zuora user interface in which you create an ad-hoc bill run for a specific customer account.  * Supported objects: Invoice * Asynchronous process: yes  The id of the generated invoice is returned in the response. If multiple invoices are generated, only the id of the first invoice generated is returned. This occurs when an account has multiple subscriptions with the [invoice subscription separately](https://knowledgecenter.zuora.com/BC_Subscription_Management/Subscriptions/B_Creating_Subscriptions/Invoicing_Subscriptions_Separately) option enabled.  ## Limits Rate limit: 8000 calls per 10-minute block, per-tenant  If you approach or exceed the limits, then you receive a 429 error. 
     * @param generateRequest  (required)
     * @return ProxyActiongenerateResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyActiongenerateResponse proxyActionPOSTgenerate(ProxyActiongenerateRequest generateRequest) throws ApiException {
        ApiResponse<ProxyActiongenerateResponse> resp = proxyActionPOSTgenerateWithHttpInfo(generateRequest);
        return resp.getData();
    }

    /**
     * Generate
     * Use the generate call to generate an on demand invoice for a specific customer. This process is similar to the process in the Zuora user interface in which you create an ad-hoc bill run for a specific customer account.  * Supported objects: Invoice * Asynchronous process: yes  The id of the generated invoice is returned in the response. If multiple invoices are generated, only the id of the first invoice generated is returned. This occurs when an account has multiple subscriptions with the [invoice subscription separately](https://knowledgecenter.zuora.com/BC_Subscription_Management/Subscriptions/B_Creating_Subscriptions/Invoicing_Subscriptions_Separately) option enabled.  ## Limits Rate limit: 8000 calls per 10-minute block, per-tenant  If you approach or exceed the limits, then you receive a 429 error. 
     * @param generateRequest  (required)
     * @return ApiResponse&lt;ProxyActiongenerateResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyActiongenerateResponse> proxyActionPOSTgenerateWithHttpInfo(ProxyActiongenerateRequest generateRequest) throws ApiException {
        com.squareup.okhttp.Call call = proxyActionPOSTgenerateCall(generateRequest, null, null);
        Type localVarReturnType = new TypeToken<ProxyActiongenerateResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Generate (asynchronously)
     * Use the generate call to generate an on demand invoice for a specific customer. This process is similar to the process in the Zuora user interface in which you create an ad-hoc bill run for a specific customer account.  * Supported objects: Invoice * Asynchronous process: yes  The id of the generated invoice is returned in the response. If multiple invoices are generated, only the id of the first invoice generated is returned. This occurs when an account has multiple subscriptions with the [invoice subscription separately](https://knowledgecenter.zuora.com/BC_Subscription_Management/Subscriptions/B_Creating_Subscriptions/Invoicing_Subscriptions_Separately) option enabled.  ## Limits Rate limit: 8000 calls per 10-minute block, per-tenant  If you approach or exceed the limits, then you receive a 429 error. 
     * @param generateRequest  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyActionPOSTgenerateAsync(ProxyActiongenerateRequest generateRequest, final ApiCallback<ProxyActiongenerateResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyActionPOSTgenerateCall(generateRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyActiongenerateResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyActionPOSTgetUserInfo */
    private com.squareup.okhttp.Call proxyActionPOSTgetUserInfoCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/action/getUserInfo".replaceAll("\\{format\\}","json");

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
     * GetUserInfo
     * 
     * @return ProxyActiongetUserInfoResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyActiongetUserInfoResponse proxyActionPOSTgetUserInfo() throws ApiException {
        ApiResponse<ProxyActiongetUserInfoResponse> resp = proxyActionPOSTgetUserInfoWithHttpInfo();
        return resp.getData();
    }

    /**
     * GetUserInfo
     * 
     * @return ApiResponse&lt;ProxyActiongetUserInfoResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyActiongetUserInfoResponse> proxyActionPOSTgetUserInfoWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = proxyActionPOSTgetUserInfoCall(null, null);
        Type localVarReturnType = new TypeToken<ProxyActiongetUserInfoResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * GetUserInfo (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyActionPOSTgetUserInfoAsync(final ApiCallback<ProxyActiongetUserInfoResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyActionPOSTgetUserInfoCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyActiongetUserInfoResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyActionPOSTlogin */
    private com.squareup.okhttp.Call proxyActionPOSTloginCall(ProxyActionloginRequest loginRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = loginRequest;
        
        // verify the required parameter 'loginRequest' is set
        if (loginRequest == null) {
            throw new ApiException("Missing the required parameter 'loginRequest' when calling proxyActionPOSTlogin(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/action/login".replaceAll("\\{format\\}","json");

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
     * Login
     * 
     * @param loginRequest  (required)
     * @return ProxyActionloginResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyActionloginResponse proxyActionPOSTlogin(ProxyActionloginRequest loginRequest) throws ApiException {
        ApiResponse<ProxyActionloginResponse> resp = proxyActionPOSTloginWithHttpInfo(loginRequest);
        return resp.getData();
    }

    /**
     * Login
     * 
     * @param loginRequest  (required)
     * @return ApiResponse&lt;ProxyActionloginResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyActionloginResponse> proxyActionPOSTloginWithHttpInfo(ProxyActionloginRequest loginRequest) throws ApiException {
        com.squareup.okhttp.Call call = proxyActionPOSTloginCall(loginRequest, null, null);
        Type localVarReturnType = new TypeToken<ProxyActionloginResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Login (asynchronously)
     * 
     * @param loginRequest  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyActionPOSTloginAsync(ProxyActionloginRequest loginRequest, final ApiCallback<ProxyActionloginResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyActionPOSTloginCall(loginRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyActionloginResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyActionPOSTquery */
    private com.squareup.okhttp.Call proxyActionPOSTqueryCall(ProxyActionqueryRequest queryRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = queryRequest;
        
        // verify the required parameter 'queryRequest' is set
        if (queryRequest == null) {
            throw new ApiException("Missing the required parameter 'queryRequest' when calling proxyActionPOSTquery(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/action/query".replaceAll("\\{format\\}","json");

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
     * Query
     * The query call sends a query expression by specifying the object to query, the fields to retrieve from that object, and any filters to determine whether a given object should be queried.   You can use [Zuora Object Query Language](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/M_Zuora_Object_Query_Language) construct those queries, passing them through the &#x60;queryString&#x60;.   Once the call is made, the API executes the query against the specified object and returns a query response object to your application. Your application can then iterate through rows in the query response to retrieve information.  ## Limitations   This call has the following limitations:  * All keywords must be in lower case. * The number of records returned is limited to 2000 records 
     * @param queryRequest  (required)
     * @return ProxyActionqueryResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyActionqueryResponse proxyActionPOSTquery(ProxyActionqueryRequest queryRequest) throws ApiException {
        ApiResponse<ProxyActionqueryResponse> resp = proxyActionPOSTqueryWithHttpInfo(queryRequest);
        return resp.getData();
    }

    /**
     * Query
     * The query call sends a query expression by specifying the object to query, the fields to retrieve from that object, and any filters to determine whether a given object should be queried.   You can use [Zuora Object Query Language](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/M_Zuora_Object_Query_Language) construct those queries, passing them through the &#x60;queryString&#x60;.   Once the call is made, the API executes the query against the specified object and returns a query response object to your application. Your application can then iterate through rows in the query response to retrieve information.  ## Limitations   This call has the following limitations:  * All keywords must be in lower case. * The number of records returned is limited to 2000 records 
     * @param queryRequest  (required)
     * @return ApiResponse&lt;ProxyActionqueryResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyActionqueryResponse> proxyActionPOSTqueryWithHttpInfo(ProxyActionqueryRequest queryRequest) throws ApiException {
        com.squareup.okhttp.Call call = proxyActionPOSTqueryCall(queryRequest, null, null);
        Type localVarReturnType = new TypeToken<ProxyActionqueryResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Query (asynchronously)
     * The query call sends a query expression by specifying the object to query, the fields to retrieve from that object, and any filters to determine whether a given object should be queried.   You can use [Zuora Object Query Language](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/M_Zuora_Object_Query_Language) construct those queries, passing them through the &#x60;queryString&#x60;.   Once the call is made, the API executes the query against the specified object and returns a query response object to your application. Your application can then iterate through rows in the query response to retrieve information.  ## Limitations   This call has the following limitations:  * All keywords must be in lower case. * The number of records returned is limited to 2000 records 
     * @param queryRequest  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyActionPOSTqueryAsync(ProxyActionqueryRequest queryRequest, final ApiCallback<ProxyActionqueryResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyActionPOSTqueryCall(queryRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyActionqueryResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyActionPOSTqueryMore */
    private com.squareup.okhttp.Call proxyActionPOSTqueryMoreCall(ProxyActionqueryMoreRequest queryMoreRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = queryMoreRequest;
        
        // verify the required parameter 'queryMoreRequest' is set
        if (queryMoreRequest == null) {
            throw new ApiException("Missing the required parameter 'queryMoreRequest' when calling proxyActionPOSTqueryMore(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/action/queryMore".replaceAll("\\{format\\}","json");

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
     * QueryMore
     * Use queryMore to request additional results from a previous query call. If your initial query call returns more than 2000 results, you can use queryMore to query for the additional results.   Any &#x60;queryLocator&#x60; results greater than 2,000, will only be stored by Zuora for 5 days before it is deleted.    This call sends a request for additional results from an initial query call. If the initial query call returns more than 2000 results, you can use the &#x60;queryLocator&#x60; returned from query to request the next set of results.   **Note:** Zuora expires queryMore cursors after 15 minutes of activity.   To use queryMore, you first construct a query call. By default, the query call will return up to 2000 results. If there are more than 2000 results, query will return a boolean &#x60;done&#x60;, which will be marked as &#x60;false&#x60;, and a &#x60;queryLocator&#x60;, which is a marker you will pass to queryMore to get the next set of results. 
     * @param queryMoreRequest  (required)
     * @return ProxyActionqueryMoreResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyActionqueryMoreResponse proxyActionPOSTqueryMore(ProxyActionqueryMoreRequest queryMoreRequest) throws ApiException {
        ApiResponse<ProxyActionqueryMoreResponse> resp = proxyActionPOSTqueryMoreWithHttpInfo(queryMoreRequest);
        return resp.getData();
    }

    /**
     * QueryMore
     * Use queryMore to request additional results from a previous query call. If your initial query call returns more than 2000 results, you can use queryMore to query for the additional results.   Any &#x60;queryLocator&#x60; results greater than 2,000, will only be stored by Zuora for 5 days before it is deleted.    This call sends a request for additional results from an initial query call. If the initial query call returns more than 2000 results, you can use the &#x60;queryLocator&#x60; returned from query to request the next set of results.   **Note:** Zuora expires queryMore cursors after 15 minutes of activity.   To use queryMore, you first construct a query call. By default, the query call will return up to 2000 results. If there are more than 2000 results, query will return a boolean &#x60;done&#x60;, which will be marked as &#x60;false&#x60;, and a &#x60;queryLocator&#x60;, which is a marker you will pass to queryMore to get the next set of results. 
     * @param queryMoreRequest  (required)
     * @return ApiResponse&lt;ProxyActionqueryMoreResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyActionqueryMoreResponse> proxyActionPOSTqueryMoreWithHttpInfo(ProxyActionqueryMoreRequest queryMoreRequest) throws ApiException {
        com.squareup.okhttp.Call call = proxyActionPOSTqueryMoreCall(queryMoreRequest, null, null);
        Type localVarReturnType = new TypeToken<ProxyActionqueryMoreResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * QueryMore (asynchronously)
     * Use queryMore to request additional results from a previous query call. If your initial query call returns more than 2000 results, you can use queryMore to query for the additional results.   Any &#x60;queryLocator&#x60; results greater than 2,000, will only be stored by Zuora for 5 days before it is deleted.    This call sends a request for additional results from an initial query call. If the initial query call returns more than 2000 results, you can use the &#x60;queryLocator&#x60; returned from query to request the next set of results.   **Note:** Zuora expires queryMore cursors after 15 minutes of activity.   To use queryMore, you first construct a query call. By default, the query call will return up to 2000 results. If there are more than 2000 results, query will return a boolean &#x60;done&#x60;, which will be marked as &#x60;false&#x60;, and a &#x60;queryLocator&#x60;, which is a marker you will pass to queryMore to get the next set of results. 
     * @param queryMoreRequest  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyActionPOSTqueryMoreAsync(ProxyActionqueryMoreRequest queryMoreRequest, final ApiCallback<ProxyActionqueryMoreResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyActionPOSTqueryMoreCall(queryMoreRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyActionqueryMoreResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyActionPOSTsubscribe */
    private com.squareup.okhttp.Call proxyActionPOSTsubscribeCall(ProxyActionsubscribeRequest subscribeRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = subscribeRequest;
        
        // verify the required parameter 'subscribeRequest' is set
        if (subscribeRequest == null) {
            throw new ApiException("Missing the required parameter 'subscribeRequest' when calling proxyActionPOSTsubscribe(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/action/subscribe".replaceAll("\\{format\\}","json");

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
     * Subscribe
     * 
     * @param subscribeRequest  (required)
     * @return ProxyActionsubscribeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyActionsubscribeResponse proxyActionPOSTsubscribe(ProxyActionsubscribeRequest subscribeRequest) throws ApiException {
        ApiResponse<ProxyActionsubscribeResponse> resp = proxyActionPOSTsubscribeWithHttpInfo(subscribeRequest);
        return resp.getData();
    }

    /**
     * Subscribe
     * 
     * @param subscribeRequest  (required)
     * @return ApiResponse&lt;ProxyActionsubscribeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyActionsubscribeResponse> proxyActionPOSTsubscribeWithHttpInfo(ProxyActionsubscribeRequest subscribeRequest) throws ApiException {
        com.squareup.okhttp.Call call = proxyActionPOSTsubscribeCall(subscribeRequest, null, null);
        Type localVarReturnType = new TypeToken<ProxyActionsubscribeResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Subscribe (asynchronously)
     * 
     * @param subscribeRequest  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyActionPOSTsubscribeAsync(ProxyActionsubscribeRequest subscribeRequest, final ApiCallback<ProxyActionsubscribeResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyActionPOSTsubscribeCall(subscribeRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyActionsubscribeResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyActionPOSTupdate */
    private com.squareup.okhttp.Call proxyActionPOSTupdateCall(ProxyActionupdateRequest updateRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = updateRequest;
        
        // verify the required parameter 'updateRequest' is set
        if (updateRequest == null) {
            throw new ApiException("Missing the required parameter 'updateRequest' when calling proxyActionPOSTupdate(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/action/update".replaceAll("\\{format\\}","json");

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
     * Update
     * 
     * @param updateRequest  (required)
     * @return ProxyActionupdateResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyActionupdateResponse proxyActionPOSTupdate(ProxyActionupdateRequest updateRequest) throws ApiException {
        ApiResponse<ProxyActionupdateResponse> resp = proxyActionPOSTupdateWithHttpInfo(updateRequest);
        return resp.getData();
    }

    /**
     * Update
     * 
     * @param updateRequest  (required)
     * @return ApiResponse&lt;ProxyActionupdateResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyActionupdateResponse> proxyActionPOSTupdateWithHttpInfo(ProxyActionupdateRequest updateRequest) throws ApiException {
        com.squareup.okhttp.Call call = proxyActionPOSTupdateCall(updateRequest, null, null);
        Type localVarReturnType = new TypeToken<ProxyActionupdateResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update (asynchronously)
     * 
     * @param updateRequest  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyActionPOSTupdateAsync(ProxyActionupdateRequest updateRequest, final ApiCallback<ProxyActionupdateResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyActionPOSTupdateCall(updateRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyActionupdateResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
