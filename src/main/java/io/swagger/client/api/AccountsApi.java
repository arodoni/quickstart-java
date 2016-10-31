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

import io.swagger.client.model.GETAccountType;
import io.swagger.client.model.GETAccountSummaryType;
import io.swagger.client.model.POSTAccountResponseType;
import io.swagger.client.model.POSTAccountType;
import io.swagger.client.model.PUTAccountType;
import io.swagger.client.model.CommonResponseType;
import io.swagger.client.model.ProxyDeleteResponse;
import io.swagger.client.model.ProxyGetAccount;
import io.swagger.client.model.ProxyNoDataResponse;
import io.swagger.client.model.ProxyCreateAccount;
import io.swagger.client.model.ProxyCreateOrModifyResponse;
import io.swagger.client.model.ProxyBadRequestResponse;
import io.swagger.client.model.ProxyModifyAccount;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsApi {
    private ApiClient apiClient;

    public AccountsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AccountsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for gETAccount */
    private com.squareup.okhttp.Call gETAccountCall(String accountKey, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'accountKey' is set
        if (accountKey == null) {
            throw new ApiException("Missing the required parameter 'accountKey' when calling gETAccount(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/accounts/{account-key}".replaceAll("\\{format\\}","json")
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
     * Get account
     * This REST API reference describes how to retrieve basic information about a customer account.  This REST call is a quick retrieval that doesn&#39;t include the account&#39;s subscriptions, invoices, payments, or usage details. Use the [Get account summary](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Accounts/3_GET_account_summary) to get more detailed information about an account. 
     * @param accountKey Account number or account ID. (required)
     * @return GETAccountType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GETAccountType gETAccount(String accountKey) throws ApiException {
        ApiResponse<GETAccountType> resp = gETAccountWithHttpInfo(accountKey);
        return resp.getData();
    }

    /**
     * Get account
     * This REST API reference describes how to retrieve basic information about a customer account.  This REST call is a quick retrieval that doesn&#39;t include the account&#39;s subscriptions, invoices, payments, or usage details. Use the [Get account summary](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Accounts/3_GET_account_summary) to get more detailed information about an account. 
     * @param accountKey Account number or account ID. (required)
     * @return ApiResponse&lt;GETAccountType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GETAccountType> gETAccountWithHttpInfo(String accountKey) throws ApiException {
        com.squareup.okhttp.Call call = gETAccountCall(accountKey, null, null);
        Type localVarReturnType = new TypeToken<GETAccountType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get account (asynchronously)
     * This REST API reference describes how to retrieve basic information about a customer account.  This REST call is a quick retrieval that doesn&#39;t include the account&#39;s subscriptions, invoices, payments, or usage details. Use the [Get account summary](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Accounts/3_GET_account_summary) to get more detailed information about an account. 
     * @param accountKey Account number or account ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call gETAccountAsync(String accountKey, final ApiCallback<GETAccountType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = gETAccountCall(accountKey, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GETAccountType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for gETAccountSummary */
    private com.squareup.okhttp.Call gETAccountSummaryCall(String accountKey, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'accountKey' is set
        if (accountKey == null) {
            throw new ApiException("Missing the required parameter 'accountKey' when calling gETAccountSummary(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/accounts/{account-key}/Summary".replaceAll("\\{format\\}","json")
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
     * Get account summary
     * This REST API reference describes how to retrieve detailed information about the specified customer account.  The response includes everything retrieved with the [Get basic account information](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Accounts/2_Get_account_basics) call, plus a summary of the account&#39;s subscriptions, invoices, payments, and usage for the last six months.  ## Notes  Returns only the six most recent subscriptions based on the subscription updatedDate. Within those subscriptions, there may be many rate plans and many rate plan charges. These items are subject to the maximum limit on the array size. See [REST API basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information on concurrent request limits. 
     * @param accountKey Account number or account ID. (required)
     * @return GETAccountSummaryType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GETAccountSummaryType gETAccountSummary(String accountKey) throws ApiException {
        ApiResponse<GETAccountSummaryType> resp = gETAccountSummaryWithHttpInfo(accountKey);
        return resp.getData();
    }

    /**
     * Get account summary
     * This REST API reference describes how to retrieve detailed information about the specified customer account.  The response includes everything retrieved with the [Get basic account information](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Accounts/2_Get_account_basics) call, plus a summary of the account&#39;s subscriptions, invoices, payments, and usage for the last six months.  ## Notes  Returns only the six most recent subscriptions based on the subscription updatedDate. Within those subscriptions, there may be many rate plans and many rate plan charges. These items are subject to the maximum limit on the array size. See [REST API basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information on concurrent request limits. 
     * @param accountKey Account number or account ID. (required)
     * @return ApiResponse&lt;GETAccountSummaryType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GETAccountSummaryType> gETAccountSummaryWithHttpInfo(String accountKey) throws ApiException {
        com.squareup.okhttp.Call call = gETAccountSummaryCall(accountKey, null, null);
        Type localVarReturnType = new TypeToken<GETAccountSummaryType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get account summary (asynchronously)
     * This REST API reference describes how to retrieve detailed information about the specified customer account.  The response includes everything retrieved with the [Get basic account information](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Accounts/2_Get_account_basics) call, plus a summary of the account&#39;s subscriptions, invoices, payments, and usage for the last six months.  ## Notes  Returns only the six most recent subscriptions based on the subscription updatedDate. Within those subscriptions, there may be many rate plans and many rate plan charges. These items are subject to the maximum limit on the array size. See [REST API basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information on concurrent request limits. 
     * @param accountKey Account number or account ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call gETAccountSummaryAsync(String accountKey, final ApiCallback<GETAccountSummaryType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = gETAccountSummaryCall(accountKey, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GETAccountSummaryType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pOSTAccount */
    private com.squareup.okhttp.Call pOSTAccountCall(POSTAccountType request, String zuoraVersion, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pOSTAccount(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/accounts".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (zuoraVersion != null)
        localVarHeaderParams.put("zuora-version", apiClient.parameterToString(zuoraVersion));

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
     * Create account
     * This REST API reference describes how to create a customer account with a credit-card payment method, a bill-to contact, and an optional sold-to contact. Request and response field descriptions and sample code are provided. Use this method to optionally create a subscription, invoice for that subscription, and collect payment through the default payment method. The transaction is atomic; if any part fails for any reason, the entire transaction is rolled back.  This API call is CORS Enabled, so you can use client-side Javascript to invoke the call. For more information, visit the [Zuora CORS REST](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/G_CORS_REST) page.  ## Notes 1. The account is created in active status.   2. The request must provide either a **creditCard** structure or the **hpmCreditCardPaymentMethodId** field (but not both). The one provided becomes the default payment method for this account. If the credit card information is declined or can&#39;t be verified, then the account is not created. 3. Customer accounts created with this call are automatically be set to Auto Pay. 4. If either the **workEmail** or **personalEmail** are specified, then the account&#39;s email delivery preference is automatically set to &#x60;true&#x60;. (In that case, emails go to the **workEmail** address, if it exists, or else the **personalEmail**.) If neither field is specified, the email delivery preference is automatically set to &#x60;false&#x60;.  ## Defaults for customerAcceptanceDate and serviceActivationDate Default values for **customerAcceptanceDate** and **serviceActivationDate** are set as follows.  |        | serviceActivationDate(SA) specified          | serviceActivationDate (SA) NOT specified  | | ------------- |:-------------:| -----:| | customerAcceptanceDate (CA) specified      | SA uses value in the request call; CA uses value in the request call| CA uses value in the request call;SA uses CE as default | | customerAcceptanceDate (CA) NOT specified      | SA uses value in the request call; CA uses SA as default |   SA and CA use CE as default | 
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ fields. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @return POSTAccountResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public POSTAccountResponseType pOSTAccount(POSTAccountType request, String zuoraVersion) throws ApiException {
        ApiResponse<POSTAccountResponseType> resp = pOSTAccountWithHttpInfo(request, zuoraVersion);
        return resp.getData();
    }

    /**
     * Create account
     * This REST API reference describes how to create a customer account with a credit-card payment method, a bill-to contact, and an optional sold-to contact. Request and response field descriptions and sample code are provided. Use this method to optionally create a subscription, invoice for that subscription, and collect payment through the default payment method. The transaction is atomic; if any part fails for any reason, the entire transaction is rolled back.  This API call is CORS Enabled, so you can use client-side Javascript to invoke the call. For more information, visit the [Zuora CORS REST](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/G_CORS_REST) page.  ## Notes 1. The account is created in active status.   2. The request must provide either a **creditCard** structure or the **hpmCreditCardPaymentMethodId** field (but not both). The one provided becomes the default payment method for this account. If the credit card information is declined or can&#39;t be verified, then the account is not created. 3. Customer accounts created with this call are automatically be set to Auto Pay. 4. If either the **workEmail** or **personalEmail** are specified, then the account&#39;s email delivery preference is automatically set to &#x60;true&#x60;. (In that case, emails go to the **workEmail** address, if it exists, or else the **personalEmail**.) If neither field is specified, the email delivery preference is automatically set to &#x60;false&#x60;.  ## Defaults for customerAcceptanceDate and serviceActivationDate Default values for **customerAcceptanceDate** and **serviceActivationDate** are set as follows.  |        | serviceActivationDate(SA) specified          | serviceActivationDate (SA) NOT specified  | | ------------- |:-------------:| -----:| | customerAcceptanceDate (CA) specified      | SA uses value in the request call; CA uses value in the request call| CA uses value in the request call;SA uses CE as default | | customerAcceptanceDate (CA) NOT specified      | SA uses value in the request call; CA uses SA as default |   SA and CA use CE as default | 
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ fields. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @return ApiResponse&lt;POSTAccountResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<POSTAccountResponseType> pOSTAccountWithHttpInfo(POSTAccountType request, String zuoraVersion) throws ApiException {
        com.squareup.okhttp.Call call = pOSTAccountCall(request, zuoraVersion, null, null);
        Type localVarReturnType = new TypeToken<POSTAccountResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create account (asynchronously)
     * This REST API reference describes how to create a customer account with a credit-card payment method, a bill-to contact, and an optional sold-to contact. Request and response field descriptions and sample code are provided. Use this method to optionally create a subscription, invoice for that subscription, and collect payment through the default payment method. The transaction is atomic; if any part fails for any reason, the entire transaction is rolled back.  This API call is CORS Enabled, so you can use client-side Javascript to invoke the call. For more information, visit the [Zuora CORS REST](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/G_CORS_REST) page.  ## Notes 1. The account is created in active status.   2. The request must provide either a **creditCard** structure or the **hpmCreditCardPaymentMethodId** field (but not both). The one provided becomes the default payment method for this account. If the credit card information is declined or can&#39;t be verified, then the account is not created. 3. Customer accounts created with this call are automatically be set to Auto Pay. 4. If either the **workEmail** or **personalEmail** are specified, then the account&#39;s email delivery preference is automatically set to &#x60;true&#x60;. (In that case, emails go to the **workEmail** address, if it exists, or else the **personalEmail**.) If neither field is specified, the email delivery preference is automatically set to &#x60;false&#x60;.  ## Defaults for customerAcceptanceDate and serviceActivationDate Default values for **customerAcceptanceDate** and **serviceActivationDate** are set as follows.  |        | serviceActivationDate(SA) specified          | serviceActivationDate (SA) NOT specified  | | ------------- |:-------------:| -----:| | customerAcceptanceDate (CA) specified      | SA uses value in the request call; CA uses value in the request call| CA uses value in the request call;SA uses CE as default | | customerAcceptanceDate (CA) NOT specified      | SA uses value in the request call; CA uses SA as default |   SA and CA use CE as default | 
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ fields. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pOSTAccountAsync(POSTAccountType request, String zuoraVersion, final ApiCallback<POSTAccountResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = pOSTAccountCall(request, zuoraVersion, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<POSTAccountResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pUTAccount */
    private com.squareup.okhttp.Call pUTAccountCall(String accountKey, PUTAccountType request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'accountKey' is set
        if (accountKey == null) {
            throw new ApiException("Missing the required parameter 'accountKey' when calling pUTAccount(Async)");
        }
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pUTAccount(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/accounts/{account-key}".replaceAll("\\{format\\}","json")
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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Update account
     * This REST API reference describes how to update a customer account by specifying the account-key.  ## Notes 1. Only the fields to be changed should be specified.  Any field that&#39;s not included in the request body will not be changed. 2. If an empty field is submitted with this call, the corresponding field in the account is emptied. 3. Email addresses: If no email addresses are specified, no change is made to the email addresses on file or to the email delivery preference. If either the **personalEmail** or **workEmail** is specified (or both), the system updates the corresponding email address(es) on file and the email delivery preference is set to &#x60;true&#x60;. (In that case, emails go to the **workEmail** address, if it exists, or else the **personalEmail**.) On the other hand, if as a result of this call both of the email addresses for the account are empty, the email delivery preference is set to &#x60;false&#x60;. 4. The bill-to and sold-to contacts are separate data entities; updating either one does not update the other. 
     * @param accountKey Account number or account ID. (required)
     * @param request  (required)
     * @return CommonResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CommonResponseType pUTAccount(String accountKey, PUTAccountType request) throws ApiException {
        ApiResponse<CommonResponseType> resp = pUTAccountWithHttpInfo(accountKey, request);
        return resp.getData();
    }

    /**
     * Update account
     * This REST API reference describes how to update a customer account by specifying the account-key.  ## Notes 1. Only the fields to be changed should be specified.  Any field that&#39;s not included in the request body will not be changed. 2. If an empty field is submitted with this call, the corresponding field in the account is emptied. 3. Email addresses: If no email addresses are specified, no change is made to the email addresses on file or to the email delivery preference. If either the **personalEmail** or **workEmail** is specified (or both), the system updates the corresponding email address(es) on file and the email delivery preference is set to &#x60;true&#x60;. (In that case, emails go to the **workEmail** address, if it exists, or else the **personalEmail**.) On the other hand, if as a result of this call both of the email addresses for the account are empty, the email delivery preference is set to &#x60;false&#x60;. 4. The bill-to and sold-to contacts are separate data entities; updating either one does not update the other. 
     * @param accountKey Account number or account ID. (required)
     * @param request  (required)
     * @return ApiResponse&lt;CommonResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CommonResponseType> pUTAccountWithHttpInfo(String accountKey, PUTAccountType request) throws ApiException {
        com.squareup.okhttp.Call call = pUTAccountCall(accountKey, request, null, null);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update account (asynchronously)
     * This REST API reference describes how to update a customer account by specifying the account-key.  ## Notes 1. Only the fields to be changed should be specified.  Any field that&#39;s not included in the request body will not be changed. 2. If an empty field is submitted with this call, the corresponding field in the account is emptied. 3. Email addresses: If no email addresses are specified, no change is made to the email addresses on file or to the email delivery preference. If either the **personalEmail** or **workEmail** is specified (or both), the system updates the corresponding email address(es) on file and the email delivery preference is set to &#x60;true&#x60;. (In that case, emails go to the **workEmail** address, if it exists, or else the **personalEmail**.) On the other hand, if as a result of this call both of the email addresses for the account are empty, the email delivery preference is set to &#x60;false&#x60;. 4. The bill-to and sold-to contacts are separate data entities; updating either one does not update the other. 
     * @param accountKey Account number or account ID. (required)
     * @param request  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pUTAccountAsync(String accountKey, PUTAccountType request, final ApiCallback<CommonResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = pUTAccountCall(accountKey, request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CommonResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyDELETEAccount */
    private com.squareup.okhttp.Call proxyDELETEAccountCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling proxyDELETEAccount(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/object/account/{id}".replaceAll("\\{format\\}","json")
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
     * CRUD: Delete Account
     * 
     * @param id Object id (required)
     * @return ProxyDeleteResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyDeleteResponse proxyDELETEAccount(String id) throws ApiException {
        ApiResponse<ProxyDeleteResponse> resp = proxyDELETEAccountWithHttpInfo(id);
        return resp.getData();
    }

    /**
     * CRUD: Delete Account
     * 
     * @param id Object id (required)
     * @return ApiResponse&lt;ProxyDeleteResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyDeleteResponse> proxyDELETEAccountWithHttpInfo(String id) throws ApiException {
        com.squareup.okhttp.Call call = proxyDELETEAccountCall(id, null, null);
        Type localVarReturnType = new TypeToken<ProxyDeleteResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * CRUD: Delete Account (asynchronously)
     * 
     * @param id Object id (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyDELETEAccountAsync(String id, final ApiCallback<ProxyDeleteResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyDELETEAccountCall(id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyDeleteResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyGETAccount */
    private com.squareup.okhttp.Call proxyGETAccountCall(String id, String fields, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling proxyGETAccount(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/object/account/{id}".replaceAll("\\{format\\}","json")
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
     * CRUD: Retrieve Account
     * 
     * @param id Object id (required)
     * @param fields Object fields to return (optional)
     * @return ProxyGetAccount
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyGetAccount proxyGETAccount(String id, String fields) throws ApiException {
        ApiResponse<ProxyGetAccount> resp = proxyGETAccountWithHttpInfo(id, fields);
        return resp.getData();
    }

    /**
     * CRUD: Retrieve Account
     * 
     * @param id Object id (required)
     * @param fields Object fields to return (optional)
     * @return ApiResponse&lt;ProxyGetAccount&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyGetAccount> proxyGETAccountWithHttpInfo(String id, String fields) throws ApiException {
        com.squareup.okhttp.Call call = proxyGETAccountCall(id, fields, null, null);
        Type localVarReturnType = new TypeToken<ProxyGetAccount>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * CRUD: Retrieve Account (asynchronously)
     * 
     * @param id Object id (required)
     * @param fields Object fields to return (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyGETAccountAsync(String id, String fields, final ApiCallback<ProxyGetAccount> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyGETAccountCall(id, fields, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyGetAccount>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyPOSTAccount */
    private com.squareup.okhttp.Call proxyPOSTAccountCall(ProxyCreateAccount createRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = createRequest;
        
        // verify the required parameter 'createRequest' is set
        if (createRequest == null) {
            throw new ApiException("Missing the required parameter 'createRequest' when calling proxyPOSTAccount(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/object/account".replaceAll("\\{format\\}","json");

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
     * CRUD: Create Account
     * 
     * @param createRequest  (required)
     * @return ProxyCreateOrModifyResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyCreateOrModifyResponse proxyPOSTAccount(ProxyCreateAccount createRequest) throws ApiException {
        ApiResponse<ProxyCreateOrModifyResponse> resp = proxyPOSTAccountWithHttpInfo(createRequest);
        return resp.getData();
    }

    /**
     * CRUD: Create Account
     * 
     * @param createRequest  (required)
     * @return ApiResponse&lt;ProxyCreateOrModifyResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyCreateOrModifyResponse> proxyPOSTAccountWithHttpInfo(ProxyCreateAccount createRequest) throws ApiException {
        com.squareup.okhttp.Call call = proxyPOSTAccountCall(createRequest, null, null);
        Type localVarReturnType = new TypeToken<ProxyCreateOrModifyResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * CRUD: Create Account (asynchronously)
     * 
     * @param createRequest  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyPOSTAccountAsync(ProxyCreateAccount createRequest, final ApiCallback<ProxyCreateOrModifyResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyPOSTAccountCall(createRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyCreateOrModifyResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyPUTAccount */
    private com.squareup.okhttp.Call proxyPUTAccountCall(String id, ProxyModifyAccount modifyRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = modifyRequest;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling proxyPUTAccount(Async)");
        }
        
        // verify the required parameter 'modifyRequest' is set
        if (modifyRequest == null) {
            throw new ApiException("Missing the required parameter 'modifyRequest' when calling proxyPUTAccount(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/object/account/{id}".replaceAll("\\{format\\}","json")
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
     * CRUD: Update Account
     * 
     * @param id Object id (required)
     * @param modifyRequest  (required)
     * @return ProxyCreateOrModifyResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyCreateOrModifyResponse proxyPUTAccount(String id, ProxyModifyAccount modifyRequest) throws ApiException {
        ApiResponse<ProxyCreateOrModifyResponse> resp = proxyPUTAccountWithHttpInfo(id, modifyRequest);
        return resp.getData();
    }

    /**
     * CRUD: Update Account
     * 
     * @param id Object id (required)
     * @param modifyRequest  (required)
     * @return ApiResponse&lt;ProxyCreateOrModifyResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyCreateOrModifyResponse> proxyPUTAccountWithHttpInfo(String id, ProxyModifyAccount modifyRequest) throws ApiException {
        com.squareup.okhttp.Call call = proxyPUTAccountCall(id, modifyRequest, null, null);
        Type localVarReturnType = new TypeToken<ProxyCreateOrModifyResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * CRUD: Update Account (asynchronously)
     * 
     * @param id Object id (required)
     * @param modifyRequest  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyPUTAccountAsync(String id, ProxyModifyAccount modifyRequest, final ApiCallback<ProxyCreateOrModifyResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyPUTAccountCall(id, modifyRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyCreateOrModifyResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
