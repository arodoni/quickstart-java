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
import io.swagger.client.model.GETPaymentMethodsType;
import io.swagger.client.model.POSTPaymentMethodResponseType;
import io.swagger.client.model.POSTPaymentMethodType;
import io.swagger.client.model.PUTPaymentMethodResponseType;
import io.swagger.client.model.PUTPaymentMethodType;
import io.swagger.client.model.ProxyDeleteResponse;
import io.swagger.client.model.ProxyGetPaymentMethod;
import io.swagger.client.model.ProxyNoDataResponse;
import io.swagger.client.model.ProxyCreateOrModifyResponse;
import io.swagger.client.model.ProxyBadRequestResponse;
import io.swagger.client.model.ProxyCreatePaymentMethod;
import io.swagger.client.model.ProxyModifyPaymentMethod;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentMethodsApi {
    private ApiClient apiClient;

    public PaymentMethodsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public PaymentMethodsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for dELETEPaymentMethods */
    private com.squareup.okhttp.Call dELETEPaymentMethodsCall(String paymentMethodId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'paymentMethodId' is set
        if (paymentMethodId == null) {
            throw new ApiException("Missing the required parameter 'paymentMethodId' when calling dELETEPaymentMethods(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/payment-methods/{payment-method-id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "payment-method-id" + "\\}", apiClient.escapeString(paymentMethodId.toString()));

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
     * Delete payment method
     * Deletes a credit card payment method from the specified customer account.  If the specified payment method is the account&#39;s default payment method, the request will fail.  In that case, you must first designate a different payment method for that customer to be the default. 
     * @param paymentMethodId Unique identifier of a payment method. (Since this ID is unique, and linked to a customer account in the system, no customer identifier is needed.) (required)
     * @return CommonResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CommonResponseType dELETEPaymentMethods(String paymentMethodId) throws ApiException {
        ApiResponse<CommonResponseType> resp = dELETEPaymentMethodsWithHttpInfo(paymentMethodId);
        return resp.getData();
    }

    /**
     * Delete payment method
     * Deletes a credit card payment method from the specified customer account.  If the specified payment method is the account&#39;s default payment method, the request will fail.  In that case, you must first designate a different payment method for that customer to be the default. 
     * @param paymentMethodId Unique identifier of a payment method. (Since this ID is unique, and linked to a customer account in the system, no customer identifier is needed.) (required)
     * @return ApiResponse&lt;CommonResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CommonResponseType> dELETEPaymentMethodsWithHttpInfo(String paymentMethodId) throws ApiException {
        com.squareup.okhttp.Call call = dELETEPaymentMethodsCall(paymentMethodId, null, null);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete payment method (asynchronously)
     * Deletes a credit card payment method from the specified customer account.  If the specified payment method is the account&#39;s default payment method, the request will fail.  In that case, you must first designate a different payment method for that customer to be the default. 
     * @param paymentMethodId Unique identifier of a payment method. (Since this ID is unique, and linked to a customer account in the system, no customer identifier is needed.) (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call dELETEPaymentMethodsAsync(String paymentMethodId, final ApiCallback<CommonResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = dELETEPaymentMethodsCall(paymentMethodId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for gETPaymentMethods */
    private com.squareup.okhttp.Call gETPaymentMethodsCall(String accountKey, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'accountKey' is set
        if (accountKey == null) {
            throw new ApiException("Missing the required parameter 'accountKey' when calling gETPaymentMethods(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/payment-methods/credit-cards/accounts/{account-key}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "account-key" + "\\}", apiClient.escapeString(accountKey.toString()));

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
     * Get payment methods
     * This REST API reference describes how to retrieve all credit card information for the specified customer account.   ## Notes The response includes details credit or debit cards for the specified customer account. Card numbers are masked, e.g., \&quot;************1234\&quot;. Cards are returned in reverse chronological order of last update.  You can send requests for bank transfer payment methods types. The response will not include bank transfer details.  The response only includes payment details on payment methods that are credit or debit cards. 
     * @param accountKey Account number or account ID. (required)
     * @return GETPaymentMethodsType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GETPaymentMethodsType gETPaymentMethods(String accountKey) throws ApiException {
        ApiResponse<GETPaymentMethodsType> resp = gETPaymentMethodsWithHttpInfo(accountKey);
        return resp.getData();
    }

    /**
     * Get payment methods
     * This REST API reference describes how to retrieve all credit card information for the specified customer account.   ## Notes The response includes details credit or debit cards for the specified customer account. Card numbers are masked, e.g., \&quot;************1234\&quot;. Cards are returned in reverse chronological order of last update.  You can send requests for bank transfer payment methods types. The response will not include bank transfer details.  The response only includes payment details on payment methods that are credit or debit cards. 
     * @param accountKey Account number or account ID. (required)
     * @return ApiResponse&lt;GETPaymentMethodsType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GETPaymentMethodsType> gETPaymentMethodsWithHttpInfo(String accountKey) throws ApiException {
        com.squareup.okhttp.Call call = gETPaymentMethodsCall(accountKey, null, null);
        Type localVarReturnType = new TypeToken<GETPaymentMethodsType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get payment methods (asynchronously)
     * This REST API reference describes how to retrieve all credit card information for the specified customer account.   ## Notes The response includes details credit or debit cards for the specified customer account. Card numbers are masked, e.g., \&quot;************1234\&quot;. Cards are returned in reverse chronological order of last update.  You can send requests for bank transfer payment methods types. The response will not include bank transfer details.  The response only includes payment details on payment methods that are credit or debit cards. 
     * @param accountKey Account number or account ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call gETPaymentMethodsAsync(String accountKey, final ApiCallback<GETPaymentMethodsType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = gETPaymentMethodsCall(accountKey, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GETPaymentMethodsType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pOSTPaymentMethod */
    private com.squareup.okhttp.Call pOSTPaymentMethodCall(POSTPaymentMethodType request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pOSTPaymentMethod(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/payment-methods/credit-cards".replaceAll("\\{format\\}","json");

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
     * Create payment method
     * This REST API reference describes how to create a new credit card payment method for a customer account.  ## Notes  This API call is CORS Enabled. Use client-side JavaScript to invoke the call. See [Zuora CORS REST](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/G_CORS_REST) for more information.  
     * @param request  (required)
     * @return POSTPaymentMethodResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public POSTPaymentMethodResponseType pOSTPaymentMethod(POSTPaymentMethodType request) throws ApiException {
        ApiResponse<POSTPaymentMethodResponseType> resp = pOSTPaymentMethodWithHttpInfo(request);
        return resp.getData();
    }

    /**
     * Create payment method
     * This REST API reference describes how to create a new credit card payment method for a customer account.  ## Notes  This API call is CORS Enabled. Use client-side JavaScript to invoke the call. See [Zuora CORS REST](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/G_CORS_REST) for more information.  
     * @param request  (required)
     * @return ApiResponse&lt;POSTPaymentMethodResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<POSTPaymentMethodResponseType> pOSTPaymentMethodWithHttpInfo(POSTPaymentMethodType request) throws ApiException {
        com.squareup.okhttp.Call call = pOSTPaymentMethodCall(request, null, null);
        Type localVarReturnType = new TypeToken<POSTPaymentMethodResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create payment method (asynchronously)
     * This REST API reference describes how to create a new credit card payment method for a customer account.  ## Notes  This API call is CORS Enabled. Use client-side JavaScript to invoke the call. See [Zuora CORS REST](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/G_CORS_REST) for more information.  
     * @param request  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pOSTPaymentMethodAsync(POSTPaymentMethodType request, final ApiCallback<POSTPaymentMethodResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = pOSTPaymentMethodCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<POSTPaymentMethodResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pUTPaymentMethods */
    private com.squareup.okhttp.Call pUTPaymentMethodsCall(String paymentMethodId, PUTPaymentMethodType request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'paymentMethodId' is set
        if (paymentMethodId == null) {
            throw new ApiException("Missing the required parameter 'paymentMethodId' when calling pUTPaymentMethods(Async)");
        }
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pUTPaymentMethods(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/payment-methods/credit-cards/{payment-method-id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "payment-method-id" + "\\}", apiClient.escapeString(paymentMethodId.toString()));

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
     * Update payment method
     * Updates an existing credit card payment method for the specified customer account. 
     * @param paymentMethodId Unique ID of the payment method to update. (required)
     * @param request  (required)
     * @return PUTPaymentMethodResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PUTPaymentMethodResponseType pUTPaymentMethods(String paymentMethodId, PUTPaymentMethodType request) throws ApiException {
        ApiResponse<PUTPaymentMethodResponseType> resp = pUTPaymentMethodsWithHttpInfo(paymentMethodId, request);
        return resp.getData();
    }

    /**
     * Update payment method
     * Updates an existing credit card payment method for the specified customer account. 
     * @param paymentMethodId Unique ID of the payment method to update. (required)
     * @param request  (required)
     * @return ApiResponse&lt;PUTPaymentMethodResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PUTPaymentMethodResponseType> pUTPaymentMethodsWithHttpInfo(String paymentMethodId, PUTPaymentMethodType request) throws ApiException {
        com.squareup.okhttp.Call call = pUTPaymentMethodsCall(paymentMethodId, request, null, null);
        Type localVarReturnType = new TypeToken<PUTPaymentMethodResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update payment method (asynchronously)
     * Updates an existing credit card payment method for the specified customer account. 
     * @param paymentMethodId Unique ID of the payment method to update. (required)
     * @param request  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pUTPaymentMethodsAsync(String paymentMethodId, PUTPaymentMethodType request, final ApiCallback<PUTPaymentMethodResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = pUTPaymentMethodsCall(paymentMethodId, request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PUTPaymentMethodResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyDELETEPaymentMethod */
    private com.squareup.okhttp.Call proxyDELETEPaymentMethodCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling proxyDELETEPaymentMethod(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/object/payment-method/{id}".replaceAll("\\{format\\}","json")
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
     * CRUD: Delete PaymentMethod
     * 
     * @param id Object id (required)
     * @return ProxyDeleteResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyDeleteResponse proxyDELETEPaymentMethod(String id) throws ApiException {
        ApiResponse<ProxyDeleteResponse> resp = proxyDELETEPaymentMethodWithHttpInfo(id);
        return resp.getData();
    }

    /**
     * CRUD: Delete PaymentMethod
     * 
     * @param id Object id (required)
     * @return ApiResponse&lt;ProxyDeleteResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyDeleteResponse> proxyDELETEPaymentMethodWithHttpInfo(String id) throws ApiException {
        com.squareup.okhttp.Call call = proxyDELETEPaymentMethodCall(id, null, null);
        Type localVarReturnType = new TypeToken<ProxyDeleteResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * CRUD: Delete PaymentMethod (asynchronously)
     * 
     * @param id Object id (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyDELETEPaymentMethodAsync(String id, final ApiCallback<ProxyDeleteResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyDELETEPaymentMethodCall(id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyDeleteResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyGETPaymentMethod */
    private com.squareup.okhttp.Call proxyGETPaymentMethodCall(String id, String fields, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling proxyGETPaymentMethod(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/object/payment-method/{id}".replaceAll("\\{format\\}","json")
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
     * CRUD: Retrieve PaymentMethod
     * 
     * @param id Object id (required)
     * @param fields Object fields to return (optional)
     * @return ProxyGetPaymentMethod
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyGetPaymentMethod proxyGETPaymentMethod(String id, String fields) throws ApiException {
        ApiResponse<ProxyGetPaymentMethod> resp = proxyGETPaymentMethodWithHttpInfo(id, fields);
        return resp.getData();
    }

    /**
     * CRUD: Retrieve PaymentMethod
     * 
     * @param id Object id (required)
     * @param fields Object fields to return (optional)
     * @return ApiResponse&lt;ProxyGetPaymentMethod&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyGetPaymentMethod> proxyGETPaymentMethodWithHttpInfo(String id, String fields) throws ApiException {
        com.squareup.okhttp.Call call = proxyGETPaymentMethodCall(id, fields, null, null);
        Type localVarReturnType = new TypeToken<ProxyGetPaymentMethod>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * CRUD: Retrieve PaymentMethod (asynchronously)
     * 
     * @param id Object id (required)
     * @param fields Object fields to return (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyGETPaymentMethodAsync(String id, String fields, final ApiCallback<ProxyGetPaymentMethod> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyGETPaymentMethodCall(id, fields, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyGetPaymentMethod>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyPOSTPaymentMethod */
    private com.squareup.okhttp.Call proxyPOSTPaymentMethodCall(ProxyCreatePaymentMethod createRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = createRequest;
        
        // verify the required parameter 'createRequest' is set
        if (createRequest == null) {
            throw new ApiException("Missing the required parameter 'createRequest' when calling proxyPOSTPaymentMethod(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/object/payment-method".replaceAll("\\{format\\}","json");

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
     * CRUD: Create PaymentMethod
     * 
     * @param createRequest  (required)
     * @return ProxyCreateOrModifyResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyCreateOrModifyResponse proxyPOSTPaymentMethod(ProxyCreatePaymentMethod createRequest) throws ApiException {
        ApiResponse<ProxyCreateOrModifyResponse> resp = proxyPOSTPaymentMethodWithHttpInfo(createRequest);
        return resp.getData();
    }

    /**
     * CRUD: Create PaymentMethod
     * 
     * @param createRequest  (required)
     * @return ApiResponse&lt;ProxyCreateOrModifyResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyCreateOrModifyResponse> proxyPOSTPaymentMethodWithHttpInfo(ProxyCreatePaymentMethod createRequest) throws ApiException {
        com.squareup.okhttp.Call call = proxyPOSTPaymentMethodCall(createRequest, null, null);
        Type localVarReturnType = new TypeToken<ProxyCreateOrModifyResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * CRUD: Create PaymentMethod (asynchronously)
     * 
     * @param createRequest  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyPOSTPaymentMethodAsync(ProxyCreatePaymentMethod createRequest, final ApiCallback<ProxyCreateOrModifyResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyPOSTPaymentMethodCall(createRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyCreateOrModifyResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyPUTPaymentMethod */
    private com.squareup.okhttp.Call proxyPUTPaymentMethodCall(String id, ProxyModifyPaymentMethod modifyRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = modifyRequest;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling proxyPUTPaymentMethod(Async)");
        }
        
        // verify the required parameter 'modifyRequest' is set
        if (modifyRequest == null) {
            throw new ApiException("Missing the required parameter 'modifyRequest' when calling proxyPUTPaymentMethod(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/object/payment-method/{id}".replaceAll("\\{format\\}","json")
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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * CRUD: Update PaymentMethod
     * 
     * @param id Object id (required)
     * @param modifyRequest  (required)
     * @return ProxyCreateOrModifyResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyCreateOrModifyResponse proxyPUTPaymentMethod(String id, ProxyModifyPaymentMethod modifyRequest) throws ApiException {
        ApiResponse<ProxyCreateOrModifyResponse> resp = proxyPUTPaymentMethodWithHttpInfo(id, modifyRequest);
        return resp.getData();
    }

    /**
     * CRUD: Update PaymentMethod
     * 
     * @param id Object id (required)
     * @param modifyRequest  (required)
     * @return ApiResponse&lt;ProxyCreateOrModifyResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyCreateOrModifyResponse> proxyPUTPaymentMethodWithHttpInfo(String id, ProxyModifyPaymentMethod modifyRequest) throws ApiException {
        com.squareup.okhttp.Call call = proxyPUTPaymentMethodCall(id, modifyRequest, null, null);
        Type localVarReturnType = new TypeToken<ProxyCreateOrModifyResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * CRUD: Update PaymentMethod (asynchronously)
     * 
     * @param id Object id (required)
     * @param modifyRequest  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyPUTPaymentMethodAsync(String id, ProxyModifyPaymentMethod modifyRequest, final ApiCallback<ProxyCreateOrModifyResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyPUTPaymentMethodCall(id, modifyRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyCreateOrModifyResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
