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

import io.swagger.client.model.GETSubscriptionTypeWithSuccess;
import io.swagger.client.model.GETSubscriptionWrapper;
import io.swagger.client.model.POSTSubscriptionResponseType;
import io.swagger.client.model.POSTSubscriptionType;
import io.swagger.client.model.POSTSubscriptionCancellationType;
import io.swagger.client.model.POSTSubscriptionCancellationResponseType;
import io.swagger.client.model.POSTSubscriptionPreviewResponseType;
import io.swagger.client.model.POSTSubscriptionPreviewType;
import io.swagger.client.model.PUTRenewSubscriptionResponseType;
import io.swagger.client.model.PUTRenewSubscriptionType;
import io.swagger.client.model.PUTSubscriptionType;
import io.swagger.client.model.PUTSubscriptionResponseType;
import io.swagger.client.model.PUTSubscriptionResumeResponseType;
import io.swagger.client.model.PUTSubscriptionResumeType;
import io.swagger.client.model.PUTSubscriptionSuspendResponseType;
import io.swagger.client.model.PUTSubscriptionSuspendType;
import io.swagger.client.model.ProxyDeleteResponse;
import io.swagger.client.model.ProxyGetSubscription;
import io.swagger.client.model.ProxyNoDataResponse;
import io.swagger.client.model.ProxyCreateOrModifyResponse;
import io.swagger.client.model.ProxyBadRequestResponse;
import io.swagger.client.model.ProxyCreateSubscription;
import io.swagger.client.model.ProxyModifySubscription;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubscriptionsApi {
    private ApiClient apiClient;

    public SubscriptionsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SubscriptionsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for gETOneSubscription */
    private com.squareup.okhttp.Call gETOneSubscriptionCall(String subscriptionKey, String chargeDetail, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'subscriptionKey' is set
        if (subscriptionKey == null) {
            throw new ApiException("Missing the required parameter 'subscriptionKey' when calling gETOneSubscription(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/subscriptions/{subscription-key}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "subscription-key" + "\\}", apiClient.escapeString(subscriptionKey.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (chargeDetail != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "charge-detail", chargeDetail));

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
     * Get subscriptions by key
     * This REST API reference describes how to retrieve detailed information about a specified subscription in the latest version. 
     * @param subscriptionKey Possible values are:   * a subscription number   * a subscription ID  (required)
     * @param chargeDetail  The segmented rate plan charges. When an amendment results in a change to a charge, Zuora creates a segmented rate plan charge. Use this field to track segment charges.  Possible values are:   * __last-segment__: (Default) The last rate plan charge on the subscription. The last rate plan charge is the last one in the order of time on the subscription rather than the most recent changed charge on the subscription.  * __current-segment__: The segmented charge that is active on today’s date (effectiveStartDate &lt;&#x3D; today’s date &lt; effectiveEndDate).    * __all-segments__: All the segmented charges.   * __specific-segment&amp;as-of-date&#x3D;date__: The segmented charge that is active on a date you specified (effectiveStartDate &lt;&#x3D; specific date &lt; effectiveEndDate). The format of the date is yyyy-mm-dd.  (optional)
     * @return GETSubscriptionTypeWithSuccess
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GETSubscriptionTypeWithSuccess gETOneSubscription(String subscriptionKey, String chargeDetail) throws ApiException {
        ApiResponse<GETSubscriptionTypeWithSuccess> resp = gETOneSubscriptionWithHttpInfo(subscriptionKey, chargeDetail);
        return resp.getData();
    }

    /**
     * Get subscriptions by key
     * This REST API reference describes how to retrieve detailed information about a specified subscription in the latest version. 
     * @param subscriptionKey Possible values are:   * a subscription number   * a subscription ID  (required)
     * @param chargeDetail  The segmented rate plan charges. When an amendment results in a change to a charge, Zuora creates a segmented rate plan charge. Use this field to track segment charges.  Possible values are:   * __last-segment__: (Default) The last rate plan charge on the subscription. The last rate plan charge is the last one in the order of time on the subscription rather than the most recent changed charge on the subscription.  * __current-segment__: The segmented charge that is active on today’s date (effectiveStartDate &lt;&#x3D; today’s date &lt; effectiveEndDate).    * __all-segments__: All the segmented charges.   * __specific-segment&amp;as-of-date&#x3D;date__: The segmented charge that is active on a date you specified (effectiveStartDate &lt;&#x3D; specific date &lt; effectiveEndDate). The format of the date is yyyy-mm-dd.  (optional)
     * @return ApiResponse&lt;GETSubscriptionTypeWithSuccess&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GETSubscriptionTypeWithSuccess> gETOneSubscriptionWithHttpInfo(String subscriptionKey, String chargeDetail) throws ApiException {
        com.squareup.okhttp.Call call = gETOneSubscriptionCall(subscriptionKey, chargeDetail, null, null);
        Type localVarReturnType = new TypeToken<GETSubscriptionTypeWithSuccess>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get subscriptions by key (asynchronously)
     * This REST API reference describes how to retrieve detailed information about a specified subscription in the latest version. 
     * @param subscriptionKey Possible values are:   * a subscription number   * a subscription ID  (required)
     * @param chargeDetail  The segmented rate plan charges. When an amendment results in a change to a charge, Zuora creates a segmented rate plan charge. Use this field to track segment charges.  Possible values are:   * __last-segment__: (Default) The last rate plan charge on the subscription. The last rate plan charge is the last one in the order of time on the subscription rather than the most recent changed charge on the subscription.  * __current-segment__: The segmented charge that is active on today’s date (effectiveStartDate &lt;&#x3D; today’s date &lt; effectiveEndDate).    * __all-segments__: All the segmented charges.   * __specific-segment&amp;as-of-date&#x3D;date__: The segmented charge that is active on a date you specified (effectiveStartDate &lt;&#x3D; specific date &lt; effectiveEndDate). The format of the date is yyyy-mm-dd.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call gETOneSubscriptionAsync(String subscriptionKey, String chargeDetail, final ApiCallback<GETSubscriptionTypeWithSuccess> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = gETOneSubscriptionCall(subscriptionKey, chargeDetail, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GETSubscriptionTypeWithSuccess>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for gETSubscription */
    private com.squareup.okhttp.Call gETSubscriptionCall(String accountKey, String chargeDetail, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'accountKey' is set
        if (accountKey == null) {
            throw new ApiException("Missing the required parameter 'accountKey' when calling gETSubscription(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/subscriptions/accounts/{account-key}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "account-key" + "\\}", apiClient.escapeString(accountKey.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (chargeDetail != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "charge-detail", chargeDetail));

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
     * Get subscriptions by account
     * Retrieves all subscriptions associated with the specified account. Zuora only returns the latest version of the subscriptions.  Subscription data is returned in reverse chronological order based on &#x60;updatedDate&#x60;. 
     * @param accountKey  Possible values are: * an account number * an account ID  (required)
     * @param chargeDetail The segmented rate plan charges.  When an amendment results in a change to a charge, Zuora creates a segmented rate plan charge. Use this field to track segment charges.  Possible values are:  * &#x60;last-segment&#x60;: (Default) The last rate plan charge on the subscription. The last rate plan charge is the last one in the order of time on the subscription rather than the most recent updated charge on the subscription. * &#x60;current-segment&#x60;: The segmented charge that is active on today’s date (**effectiveStartDate** &lt;&#x3D; today’s date &lt; **effectiveEndDate**). * &#x60;all-segments&#x60;: All the segmented charges. * &#x60;specific-segment&amp;as-of-date&#x3D;date&#x60;: The segmented charge that is active on a date you specified (**effectiveStartDate** &lt;&#x3D; specific date &lt; **effectiveEndDate**). The format of the date is yyyy-mm-dd.  (optional)
     * @return GETSubscriptionWrapper
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GETSubscriptionWrapper gETSubscription(String accountKey, String chargeDetail) throws ApiException {
        ApiResponse<GETSubscriptionWrapper> resp = gETSubscriptionWithHttpInfo(accountKey, chargeDetail);
        return resp.getData();
    }

    /**
     * Get subscriptions by account
     * Retrieves all subscriptions associated with the specified account. Zuora only returns the latest version of the subscriptions.  Subscription data is returned in reverse chronological order based on &#x60;updatedDate&#x60;. 
     * @param accountKey  Possible values are: * an account number * an account ID  (required)
     * @param chargeDetail The segmented rate plan charges.  When an amendment results in a change to a charge, Zuora creates a segmented rate plan charge. Use this field to track segment charges.  Possible values are:  * &#x60;last-segment&#x60;: (Default) The last rate plan charge on the subscription. The last rate plan charge is the last one in the order of time on the subscription rather than the most recent updated charge on the subscription. * &#x60;current-segment&#x60;: The segmented charge that is active on today’s date (**effectiveStartDate** &lt;&#x3D; today’s date &lt; **effectiveEndDate**). * &#x60;all-segments&#x60;: All the segmented charges. * &#x60;specific-segment&amp;as-of-date&#x3D;date&#x60;: The segmented charge that is active on a date you specified (**effectiveStartDate** &lt;&#x3D; specific date &lt; **effectiveEndDate**). The format of the date is yyyy-mm-dd.  (optional)
     * @return ApiResponse&lt;GETSubscriptionWrapper&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GETSubscriptionWrapper> gETSubscriptionWithHttpInfo(String accountKey, String chargeDetail) throws ApiException {
        com.squareup.okhttp.Call call = gETSubscriptionCall(accountKey, chargeDetail, null, null);
        Type localVarReturnType = new TypeToken<GETSubscriptionWrapper>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get subscriptions by account (asynchronously)
     * Retrieves all subscriptions associated with the specified account. Zuora only returns the latest version of the subscriptions.  Subscription data is returned in reverse chronological order based on &#x60;updatedDate&#x60;. 
     * @param accountKey  Possible values are: * an account number * an account ID  (required)
     * @param chargeDetail The segmented rate plan charges.  When an amendment results in a change to a charge, Zuora creates a segmented rate plan charge. Use this field to track segment charges.  Possible values are:  * &#x60;last-segment&#x60;: (Default) The last rate plan charge on the subscription. The last rate plan charge is the last one in the order of time on the subscription rather than the most recent updated charge on the subscription. * &#x60;current-segment&#x60;: The segmented charge that is active on today’s date (**effectiveStartDate** &lt;&#x3D; today’s date &lt; **effectiveEndDate**). * &#x60;all-segments&#x60;: All the segmented charges. * &#x60;specific-segment&amp;as-of-date&#x3D;date&#x60;: The segmented charge that is active on a date you specified (**effectiveStartDate** &lt;&#x3D; specific date &lt; **effectiveEndDate**). The format of the date is yyyy-mm-dd.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call gETSubscriptionAsync(String accountKey, String chargeDetail, final ApiCallback<GETSubscriptionWrapper> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = gETSubscriptionCall(accountKey, chargeDetail, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GETSubscriptionWrapper>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pOSTSubscription */
    private com.squareup.okhttp.Call pOSTSubscriptionCall(POSTSubscriptionType request, String zuoraVersion, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pOSTSubscription(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/subscriptions".replaceAll("\\{format\\}","json");

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
     * Create subscription
     * This REST API reference describes how to create a new subscription for an existing customer account.  ## Notes If invoiceCollect is &#x60;true&#x60;, the call will not return success &#x3D; &#x60;true&#x60; unless the subscription, invoice, and payment are all successful.  Default values for **customerAcceptanceDate** and **serviceActivationDate** are set as follows.  |        | serviceActivationDate(SA) specified          | serviceActivationDate (SA) NOT specified  | | ------------- |:-------------:| -----:| | customerAcceptanceDate (CA) specified| SA uses value in the request call; CA uses value in the request call| CA uses value in the request call;SA uses CE as default | | customerAcceptanceDate (CA) NOT specified      | SA uses value in the request call; CA uses SA as default |   SA and CA use CE as default | 
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @return POSTSubscriptionResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public POSTSubscriptionResponseType pOSTSubscription(POSTSubscriptionType request, String zuoraVersion) throws ApiException {
        ApiResponse<POSTSubscriptionResponseType> resp = pOSTSubscriptionWithHttpInfo(request, zuoraVersion);
        return resp.getData();
    }

    /**
     * Create subscription
     * This REST API reference describes how to create a new subscription for an existing customer account.  ## Notes If invoiceCollect is &#x60;true&#x60;, the call will not return success &#x3D; &#x60;true&#x60; unless the subscription, invoice, and payment are all successful.  Default values for **customerAcceptanceDate** and **serviceActivationDate** are set as follows.  |        | serviceActivationDate(SA) specified          | serviceActivationDate (SA) NOT specified  | | ------------- |:-------------:| -----:| | customerAcceptanceDate (CA) specified| SA uses value in the request call; CA uses value in the request call| CA uses value in the request call;SA uses CE as default | | customerAcceptanceDate (CA) NOT specified      | SA uses value in the request call; CA uses SA as default |   SA and CA use CE as default | 
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @return ApiResponse&lt;POSTSubscriptionResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<POSTSubscriptionResponseType> pOSTSubscriptionWithHttpInfo(POSTSubscriptionType request, String zuoraVersion) throws ApiException {
        com.squareup.okhttp.Call call = pOSTSubscriptionCall(request, zuoraVersion, null, null);
        Type localVarReturnType = new TypeToken<POSTSubscriptionResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create subscription (asynchronously)
     * This REST API reference describes how to create a new subscription for an existing customer account.  ## Notes If invoiceCollect is &#x60;true&#x60;, the call will not return success &#x3D; &#x60;true&#x60; unless the subscription, invoice, and payment are all successful.  Default values for **customerAcceptanceDate** and **serviceActivationDate** are set as follows.  |        | serviceActivationDate(SA) specified          | serviceActivationDate (SA) NOT specified  | | ------------- |:-------------:| -----:| | customerAcceptanceDate (CA) specified| SA uses value in the request call; CA uses value in the request call| CA uses value in the request call;SA uses CE as default | | customerAcceptanceDate (CA) NOT specified      | SA uses value in the request call; CA uses SA as default |   SA and CA use CE as default | 
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pOSTSubscriptionAsync(POSTSubscriptionType request, String zuoraVersion, final ApiCallback<POSTSubscriptionResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = pOSTSubscriptionCall(request, zuoraVersion, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<POSTSubscriptionResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pOSTSubscriptionCancellation */
    private com.squareup.okhttp.Call pOSTSubscriptionCancellationCall(String subscriptionKey, POSTSubscriptionCancellationType request, String zuoraVersion, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'subscriptionKey' is set
        if (subscriptionKey == null) {
            throw new ApiException("Missing the required parameter 'subscriptionKey' when calling pOSTSubscriptionCancellation(Async)");
        }
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pOSTSubscriptionCancellation(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/subscriptions/{subscription-key}/cancel".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "subscription-key" + "\\}", apiClient.escapeString(subscriptionKey.toString()));

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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Cancel subscription
     * This REST API reference describes how to cancel an active subscription. 
     * @param subscriptionKey Subscription number or ID. Subscription status must be &#x60;Active&#x60;. (required)
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @return POSTSubscriptionCancellationResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public POSTSubscriptionCancellationResponseType pOSTSubscriptionCancellation(String subscriptionKey, POSTSubscriptionCancellationType request, String zuoraVersion) throws ApiException {
        ApiResponse<POSTSubscriptionCancellationResponseType> resp = pOSTSubscriptionCancellationWithHttpInfo(subscriptionKey, request, zuoraVersion);
        return resp.getData();
    }

    /**
     * Cancel subscription
     * This REST API reference describes how to cancel an active subscription. 
     * @param subscriptionKey Subscription number or ID. Subscription status must be &#x60;Active&#x60;. (required)
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @return ApiResponse&lt;POSTSubscriptionCancellationResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<POSTSubscriptionCancellationResponseType> pOSTSubscriptionCancellationWithHttpInfo(String subscriptionKey, POSTSubscriptionCancellationType request, String zuoraVersion) throws ApiException {
        com.squareup.okhttp.Call call = pOSTSubscriptionCancellationCall(subscriptionKey, request, zuoraVersion, null, null);
        Type localVarReturnType = new TypeToken<POSTSubscriptionCancellationResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Cancel subscription (asynchronously)
     * This REST API reference describes how to cancel an active subscription. 
     * @param subscriptionKey Subscription number or ID. Subscription status must be &#x60;Active&#x60;. (required)
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pOSTSubscriptionCancellationAsync(String subscriptionKey, POSTSubscriptionCancellationType request, String zuoraVersion, final ApiCallback<POSTSubscriptionCancellationResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = pOSTSubscriptionCancellationCall(subscriptionKey, request, zuoraVersion, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<POSTSubscriptionCancellationResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pOSTSubscriptionPreview */
    private com.squareup.okhttp.Call pOSTSubscriptionPreviewCall(POSTSubscriptionPreviewType request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pOSTSubscriptionPreview(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/subscriptions/preview".replaceAll("\\{format\\}","json");

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
     * Preview subscription
     * The REST API reference describes how to create a new subscription in preview mode. This call does not require a valid customer account. It can be used to show potential new customers a preview of a subscription with complete details and charges before creating an account, or to let existing customers preview a subscription with all charges before committing.  ## Notes Default values for **customerAcceptanceDate** and **serviceActivationDate** are set as follows.  |        | serviceActivationDate (SA) specified          | serviceActivationDate (SA) NOT specified  | | ------------- |:-------------:| -----:| | customerAcceptanceDate (CA) specified      | SA uses value in the request call; CA uses value in the request call| CA uses value in the request call;SA uses CE as default | | customerAcceptanceDate (CA) NOT specified      | SA uses value in the request call; CA uses SA as default |   SA and CA use CE as default | 
     * @param request  (required)
     * @return POSTSubscriptionPreviewResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public POSTSubscriptionPreviewResponseType pOSTSubscriptionPreview(POSTSubscriptionPreviewType request) throws ApiException {
        ApiResponse<POSTSubscriptionPreviewResponseType> resp = pOSTSubscriptionPreviewWithHttpInfo(request);
        return resp.getData();
    }

    /**
     * Preview subscription
     * The REST API reference describes how to create a new subscription in preview mode. This call does not require a valid customer account. It can be used to show potential new customers a preview of a subscription with complete details and charges before creating an account, or to let existing customers preview a subscription with all charges before committing.  ## Notes Default values for **customerAcceptanceDate** and **serviceActivationDate** are set as follows.  |        | serviceActivationDate (SA) specified          | serviceActivationDate (SA) NOT specified  | | ------------- |:-------------:| -----:| | customerAcceptanceDate (CA) specified      | SA uses value in the request call; CA uses value in the request call| CA uses value in the request call;SA uses CE as default | | customerAcceptanceDate (CA) NOT specified      | SA uses value in the request call; CA uses SA as default |   SA and CA use CE as default | 
     * @param request  (required)
     * @return ApiResponse&lt;POSTSubscriptionPreviewResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<POSTSubscriptionPreviewResponseType> pOSTSubscriptionPreviewWithHttpInfo(POSTSubscriptionPreviewType request) throws ApiException {
        com.squareup.okhttp.Call call = pOSTSubscriptionPreviewCall(request, null, null);
        Type localVarReturnType = new TypeToken<POSTSubscriptionPreviewResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Preview subscription (asynchronously)
     * The REST API reference describes how to create a new subscription in preview mode. This call does not require a valid customer account. It can be used to show potential new customers a preview of a subscription with complete details and charges before creating an account, or to let existing customers preview a subscription with all charges before committing.  ## Notes Default values for **customerAcceptanceDate** and **serviceActivationDate** are set as follows.  |        | serviceActivationDate (SA) specified          | serviceActivationDate (SA) NOT specified  | | ------------- |:-------------:| -----:| | customerAcceptanceDate (CA) specified      | SA uses value in the request call; CA uses value in the request call| CA uses value in the request call;SA uses CE as default | | customerAcceptanceDate (CA) NOT specified      | SA uses value in the request call; CA uses SA as default |   SA and CA use CE as default | 
     * @param request  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pOSTSubscriptionPreviewAsync(POSTSubscriptionPreviewType request, final ApiCallback<POSTSubscriptionPreviewResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = pOSTSubscriptionPreviewCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<POSTSubscriptionPreviewResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pUTRenewSubscription */
    private com.squareup.okhttp.Call pUTRenewSubscriptionCall(String subscriptionKey, PUTRenewSubscriptionType request, String zuoraVersion, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'subscriptionKey' is set
        if (subscriptionKey == null) {
            throw new ApiException("Missing the required parameter 'subscriptionKey' when calling pUTRenewSubscription(Async)");
        }
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pUTRenewSubscription(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/subscriptions/{subscription-key}/renew".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "subscription-key" + "\\}", apiClient.escapeString(subscriptionKey.toString()));

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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Renew subscription
     * Renews a termed subscription using existing renewal terms. 
     * @param subscriptionKey Subscription number or ID (required)
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @return PUTRenewSubscriptionResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PUTRenewSubscriptionResponseType pUTRenewSubscription(String subscriptionKey, PUTRenewSubscriptionType request, String zuoraVersion) throws ApiException {
        ApiResponse<PUTRenewSubscriptionResponseType> resp = pUTRenewSubscriptionWithHttpInfo(subscriptionKey, request, zuoraVersion);
        return resp.getData();
    }

    /**
     * Renew subscription
     * Renews a termed subscription using existing renewal terms. 
     * @param subscriptionKey Subscription number or ID (required)
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @return ApiResponse&lt;PUTRenewSubscriptionResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PUTRenewSubscriptionResponseType> pUTRenewSubscriptionWithHttpInfo(String subscriptionKey, PUTRenewSubscriptionType request, String zuoraVersion) throws ApiException {
        com.squareup.okhttp.Call call = pUTRenewSubscriptionCall(subscriptionKey, request, zuoraVersion, null, null);
        Type localVarReturnType = new TypeToken<PUTRenewSubscriptionResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Renew subscription (asynchronously)
     * Renews a termed subscription using existing renewal terms. 
     * @param subscriptionKey Subscription number or ID (required)
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pUTRenewSubscriptionAsync(String subscriptionKey, PUTRenewSubscriptionType request, String zuoraVersion, final ApiCallback<PUTRenewSubscriptionResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = pUTRenewSubscriptionCall(subscriptionKey, request, zuoraVersion, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PUTRenewSubscriptionResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pUTSubscription */
    private com.squareup.okhttp.Call pUTSubscriptionCall(String subscriptionKey, PUTSubscriptionType request, String zuoraVersion, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'subscriptionKey' is set
        if (subscriptionKey == null) {
            throw new ApiException("Missing the required parameter 'subscriptionKey' when calling pUTSubscription(Async)");
        }
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pUTSubscription(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/subscriptions/{subscription-key}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "subscription-key" + "\\}", apiClient.escapeString(subscriptionKey.toString()));

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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Update subscription
     * Use this call to make the following kinds of changes to a subscription:   * Add a note   * Change the renewal term or auto-renewal flag   * Change the term length or change between evergreen and termed   * Add a new product rate plan   * Remove an existing subscription rate plan   * Change the quantity or price of an existing subscription rate plan  ## Notes * The Update Subscription call creates a new subscription, which has the old subscription number but a new subscription ID.  The old subscription is canceled but remains in the system. * In one request, this call can make:   * Up to 9 combined add, update, and remove changes   * No more than 1 change to terms &amp; conditions * Updates are performed in the following sequence:   1. First change the notes on the existing subscription, if requested.   2. Then change the terms and conditions, if requested.   3. Then perform the remaining amendments based upon the effective dates specified. If multiple amendments have the same contract-effective dates, then execute adds before updates, and updates before removes. * The update operation is atomic. If any of the updates fails, the entire operation is rolled back.  ## Override a Tiered Price There are two ways you override a tiered price:  * Override a specific tier number For example: &#x60;tiers[{tier:1,price:8},{tier:2,price:6}]&#x60;  * Override the entire tier structure For example:  &#x60;tiers[{tier:1,price:8,startingUnit:1,endingUnit:100,priceFormat:\&quot;FlatFee\&quot;}, {tier:2,price:6,startingUnit:101,priceFormat:\&quot;FlatFee\&quot;}]&#x60;  If you just override a specific tier, do not include the &#x60;startingUnit&#x60; field in the request. 
     * @param subscriptionKey Subscription number or ID. (required)
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @return PUTSubscriptionResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PUTSubscriptionResponseType pUTSubscription(String subscriptionKey, PUTSubscriptionType request, String zuoraVersion) throws ApiException {
        ApiResponse<PUTSubscriptionResponseType> resp = pUTSubscriptionWithHttpInfo(subscriptionKey, request, zuoraVersion);
        return resp.getData();
    }

    /**
     * Update subscription
     * Use this call to make the following kinds of changes to a subscription:   * Add a note   * Change the renewal term or auto-renewal flag   * Change the term length or change between evergreen and termed   * Add a new product rate plan   * Remove an existing subscription rate plan   * Change the quantity or price of an existing subscription rate plan  ## Notes * The Update Subscription call creates a new subscription, which has the old subscription number but a new subscription ID.  The old subscription is canceled but remains in the system. * In one request, this call can make:   * Up to 9 combined add, update, and remove changes   * No more than 1 change to terms &amp; conditions * Updates are performed in the following sequence:   1. First change the notes on the existing subscription, if requested.   2. Then change the terms and conditions, if requested.   3. Then perform the remaining amendments based upon the effective dates specified. If multiple amendments have the same contract-effective dates, then execute adds before updates, and updates before removes. * The update operation is atomic. If any of the updates fails, the entire operation is rolled back.  ## Override a Tiered Price There are two ways you override a tiered price:  * Override a specific tier number For example: &#x60;tiers[{tier:1,price:8},{tier:2,price:6}]&#x60;  * Override the entire tier structure For example:  &#x60;tiers[{tier:1,price:8,startingUnit:1,endingUnit:100,priceFormat:\&quot;FlatFee\&quot;}, {tier:2,price:6,startingUnit:101,priceFormat:\&quot;FlatFee\&quot;}]&#x60;  If you just override a specific tier, do not include the &#x60;startingUnit&#x60; field in the request. 
     * @param subscriptionKey Subscription number or ID. (required)
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @return ApiResponse&lt;PUTSubscriptionResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PUTSubscriptionResponseType> pUTSubscriptionWithHttpInfo(String subscriptionKey, PUTSubscriptionType request, String zuoraVersion) throws ApiException {
        com.squareup.okhttp.Call call = pUTSubscriptionCall(subscriptionKey, request, zuoraVersion, null, null);
        Type localVarReturnType = new TypeToken<PUTSubscriptionResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update subscription (asynchronously)
     * Use this call to make the following kinds of changes to a subscription:   * Add a note   * Change the renewal term or auto-renewal flag   * Change the term length or change between evergreen and termed   * Add a new product rate plan   * Remove an existing subscription rate plan   * Change the quantity or price of an existing subscription rate plan  ## Notes * The Update Subscription call creates a new subscription, which has the old subscription number but a new subscription ID.  The old subscription is canceled but remains in the system. * In one request, this call can make:   * Up to 9 combined add, update, and remove changes   * No more than 1 change to terms &amp; conditions * Updates are performed in the following sequence:   1. First change the notes on the existing subscription, if requested.   2. Then change the terms and conditions, if requested.   3. Then perform the remaining amendments based upon the effective dates specified. If multiple amendments have the same contract-effective dates, then execute adds before updates, and updates before removes. * The update operation is atomic. If any of the updates fails, the entire operation is rolled back.  ## Override a Tiered Price There are two ways you override a tiered price:  * Override a specific tier number For example: &#x60;tiers[{tier:1,price:8},{tier:2,price:6}]&#x60;  * Override the entire tier structure For example:  &#x60;tiers[{tier:1,price:8,startingUnit:1,endingUnit:100,priceFormat:\&quot;FlatFee\&quot;}, {tier:2,price:6,startingUnit:101,priceFormat:\&quot;FlatFee\&quot;}]&#x60;  If you just override a specific tier, do not include the &#x60;startingUnit&#x60; field in the request. 
     * @param subscriptionKey Subscription number or ID. (required)
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pUTSubscriptionAsync(String subscriptionKey, PUTSubscriptionType request, String zuoraVersion, final ApiCallback<PUTSubscriptionResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = pUTSubscriptionCall(subscriptionKey, request, zuoraVersion, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PUTSubscriptionResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pUTSubscriptionResume */
    private com.squareup.okhttp.Call pUTSubscriptionResumeCall(String subscriptionKey, PUTSubscriptionResumeType request, String zuoraVersion, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'subscriptionKey' is set
        if (subscriptionKey == null) {
            throw new ApiException("Missing the required parameter 'subscriptionKey' when calling pUTSubscriptionResume(Async)");
        }
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pUTSubscriptionResume(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/subscriptions/{subscription-key}/resume".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "subscription-key" + "\\}", apiClient.escapeString(subscriptionKey.toString()));

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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Resume subscription
     * This REST API reference describes how to resume a suspended subscription.   This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://suport.zuora.com).  
     * @param subscriptionKey Subscription number or ID. Subscription status must be Active. (required)
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @return PUTSubscriptionResumeResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PUTSubscriptionResumeResponseType pUTSubscriptionResume(String subscriptionKey, PUTSubscriptionResumeType request, String zuoraVersion) throws ApiException {
        ApiResponse<PUTSubscriptionResumeResponseType> resp = pUTSubscriptionResumeWithHttpInfo(subscriptionKey, request, zuoraVersion);
        return resp.getData();
    }

    /**
     * Resume subscription
     * This REST API reference describes how to resume a suspended subscription.   This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://suport.zuora.com).  
     * @param subscriptionKey Subscription number or ID. Subscription status must be Active. (required)
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @return ApiResponse&lt;PUTSubscriptionResumeResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PUTSubscriptionResumeResponseType> pUTSubscriptionResumeWithHttpInfo(String subscriptionKey, PUTSubscriptionResumeType request, String zuoraVersion) throws ApiException {
        com.squareup.okhttp.Call call = pUTSubscriptionResumeCall(subscriptionKey, request, zuoraVersion, null, null);
        Type localVarReturnType = new TypeToken<PUTSubscriptionResumeResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Resume subscription (asynchronously)
     * This REST API reference describes how to resume a suspended subscription.   This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://suport.zuora.com).  
     * @param subscriptionKey Subscription number or ID. Subscription status must be Active. (required)
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pUTSubscriptionResumeAsync(String subscriptionKey, PUTSubscriptionResumeType request, String zuoraVersion, final ApiCallback<PUTSubscriptionResumeResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = pUTSubscriptionResumeCall(subscriptionKey, request, zuoraVersion, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PUTSubscriptionResumeResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pUTSubscriptionSuspend */
    private com.squareup.okhttp.Call pUTSubscriptionSuspendCall(String subscriptionKey, PUTSubscriptionSuspendType request, String zuoraVersion, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // verify the required parameter 'subscriptionKey' is set
        if (subscriptionKey == null) {
            throw new ApiException("Missing the required parameter 'subscriptionKey' when calling pUTSubscriptionSuspend(Async)");
        }
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pUTSubscriptionSuspend(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/subscriptions/{subscription-key}/suspend".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "subscription-key" + "\\}", apiClient.escapeString(subscriptionKey.toString()));

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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Suspend subscription
     * This REST API reference describes how to suspend an active subscription.   This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://suport.zuora.com). 
     * @param subscriptionKey Subscription number or ID. Subscription status must be Active. (required)
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @return PUTSubscriptionSuspendResponseType
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PUTSubscriptionSuspendResponseType pUTSubscriptionSuspend(String subscriptionKey, PUTSubscriptionSuspendType request, String zuoraVersion) throws ApiException {
        ApiResponse<PUTSubscriptionSuspendResponseType> resp = pUTSubscriptionSuspendWithHttpInfo(subscriptionKey, request, zuoraVersion);
        return resp.getData();
    }

    /**
     * Suspend subscription
     * This REST API reference describes how to suspend an active subscription.   This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://suport.zuora.com). 
     * @param subscriptionKey Subscription number or ID. Subscription status must be Active. (required)
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @return ApiResponse&lt;PUTSubscriptionSuspendResponseType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PUTSubscriptionSuspendResponseType> pUTSubscriptionSuspendWithHttpInfo(String subscriptionKey, PUTSubscriptionSuspendType request, String zuoraVersion) throws ApiException {
        com.squareup.okhttp.Call call = pUTSubscriptionSuspendCall(subscriptionKey, request, zuoraVersion, null, null);
        Type localVarReturnType = new TypeToken<PUTSubscriptionSuspendResponseType>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Suspend subscription (asynchronously)
     * This REST API reference describes how to suspend an active subscription.   This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://suport.zuora.com). 
     * @param subscriptionKey Subscription number or ID. Subscription status must be Active. (required)
     * @param request  (required)
     * @param zuoraVersion The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pUTSubscriptionSuspendAsync(String subscriptionKey, PUTSubscriptionSuspendType request, String zuoraVersion, final ApiCallback<PUTSubscriptionSuspendResponseType> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = pUTSubscriptionSuspendCall(subscriptionKey, request, zuoraVersion, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PUTSubscriptionSuspendResponseType>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyDELETESubscription */
    private com.squareup.okhttp.Call proxyDELETESubscriptionCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling proxyDELETESubscription(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/object/subscription/{id}".replaceAll("\\{format\\}","json")
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
     * CRUD: Delete Subscription
     * 
     * @param id Object id (required)
     * @return ProxyDeleteResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyDeleteResponse proxyDELETESubscription(String id) throws ApiException {
        ApiResponse<ProxyDeleteResponse> resp = proxyDELETESubscriptionWithHttpInfo(id);
        return resp.getData();
    }

    /**
     * CRUD: Delete Subscription
     * 
     * @param id Object id (required)
     * @return ApiResponse&lt;ProxyDeleteResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyDeleteResponse> proxyDELETESubscriptionWithHttpInfo(String id) throws ApiException {
        com.squareup.okhttp.Call call = proxyDELETESubscriptionCall(id, null, null);
        Type localVarReturnType = new TypeToken<ProxyDeleteResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * CRUD: Delete Subscription (asynchronously)
     * 
     * @param id Object id (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyDELETESubscriptionAsync(String id, final ApiCallback<ProxyDeleteResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyDELETESubscriptionCall(id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyDeleteResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyGETSubscription */
    private com.squareup.okhttp.Call proxyGETSubscriptionCall(String id, String fields, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling proxyGETSubscription(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/object/subscription/{id}".replaceAll("\\{format\\}","json")
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
     * CRUD: Retrieve Subscription
     * 
     * @param id Object id (required)
     * @param fields Object fields to return (optional)
     * @return ProxyGetSubscription
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyGetSubscription proxyGETSubscription(String id, String fields) throws ApiException {
        ApiResponse<ProxyGetSubscription> resp = proxyGETSubscriptionWithHttpInfo(id, fields);
        return resp.getData();
    }

    /**
     * CRUD: Retrieve Subscription
     * 
     * @param id Object id (required)
     * @param fields Object fields to return (optional)
     * @return ApiResponse&lt;ProxyGetSubscription&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyGetSubscription> proxyGETSubscriptionWithHttpInfo(String id, String fields) throws ApiException {
        com.squareup.okhttp.Call call = proxyGETSubscriptionCall(id, fields, null, null);
        Type localVarReturnType = new TypeToken<ProxyGetSubscription>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * CRUD: Retrieve Subscription (asynchronously)
     * 
     * @param id Object id (required)
     * @param fields Object fields to return (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyGETSubscriptionAsync(String id, String fields, final ApiCallback<ProxyGetSubscription> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyGETSubscriptionCall(id, fields, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyGetSubscription>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyPOSTSubscription */
    private com.squareup.okhttp.Call proxyPOSTSubscriptionCall(ProxyCreateSubscription createRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = createRequest;
        
        // verify the required parameter 'createRequest' is set
        if (createRequest == null) {
            throw new ApiException("Missing the required parameter 'createRequest' when calling proxyPOSTSubscription(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/object/subscription".replaceAll("\\{format\\}","json");

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
     * CRUD: Create Subscription
     * 
     * @param createRequest  (required)
     * @return ProxyCreateOrModifyResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyCreateOrModifyResponse proxyPOSTSubscription(ProxyCreateSubscription createRequest) throws ApiException {
        ApiResponse<ProxyCreateOrModifyResponse> resp = proxyPOSTSubscriptionWithHttpInfo(createRequest);
        return resp.getData();
    }

    /**
     * CRUD: Create Subscription
     * 
     * @param createRequest  (required)
     * @return ApiResponse&lt;ProxyCreateOrModifyResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyCreateOrModifyResponse> proxyPOSTSubscriptionWithHttpInfo(ProxyCreateSubscription createRequest) throws ApiException {
        com.squareup.okhttp.Call call = proxyPOSTSubscriptionCall(createRequest, null, null);
        Type localVarReturnType = new TypeToken<ProxyCreateOrModifyResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * CRUD: Create Subscription (asynchronously)
     * 
     * @param createRequest  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyPOSTSubscriptionAsync(ProxyCreateSubscription createRequest, final ApiCallback<ProxyCreateOrModifyResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyPOSTSubscriptionCall(createRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyCreateOrModifyResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for proxyPUTSubscription */
    private com.squareup.okhttp.Call proxyPUTSubscriptionCall(String id, ProxyModifySubscription modifyRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = modifyRequest;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling proxyPUTSubscription(Async)");
        }
        
        // verify the required parameter 'modifyRequest' is set
        if (modifyRequest == null) {
            throw new ApiException("Missing the required parameter 'modifyRequest' when calling proxyPUTSubscription(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/object/subscription/{id}".replaceAll("\\{format\\}","json")
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
     * CRUD: Update Subscription
     * 
     * @param id Object id (required)
     * @param modifyRequest  (required)
     * @return ProxyCreateOrModifyResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProxyCreateOrModifyResponse proxyPUTSubscription(String id, ProxyModifySubscription modifyRequest) throws ApiException {
        ApiResponse<ProxyCreateOrModifyResponse> resp = proxyPUTSubscriptionWithHttpInfo(id, modifyRequest);
        return resp.getData();
    }

    /**
     * CRUD: Update Subscription
     * 
     * @param id Object id (required)
     * @param modifyRequest  (required)
     * @return ApiResponse&lt;ProxyCreateOrModifyResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProxyCreateOrModifyResponse> proxyPUTSubscriptionWithHttpInfo(String id, ProxyModifySubscription modifyRequest) throws ApiException {
        com.squareup.okhttp.Call call = proxyPUTSubscriptionCall(id, modifyRequest, null, null);
        Type localVarReturnType = new TypeToken<ProxyCreateOrModifyResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * CRUD: Update Subscription (asynchronously)
     * 
     * @param id Object id (required)
     * @param modifyRequest  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call proxyPUTSubscriptionAsync(String id, ProxyModifySubscription modifyRequest, final ApiCallback<ProxyCreateOrModifyResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = proxyPUTSubscriptionCall(id, modifyRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProxyCreateOrModifyResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
