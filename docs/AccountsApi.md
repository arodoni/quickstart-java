# AccountsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gETAccount**](AccountsApi.md#gETAccount) | **GET** /accounts/{account-key} | Get account
[**gETAccountSummary**](AccountsApi.md#gETAccountSummary) | **GET** /accounts/{account-key}/Summary | Get account summary
[**pOSTAccount**](AccountsApi.md#pOSTAccount) | **POST** /accounts | Create account
[**pUTAccount**](AccountsApi.md#pUTAccount) | **PUT** /accounts/{account-key} | Update account
[**proxyDELETEAccount**](AccountsApi.md#proxyDELETEAccount) | **DELETE** /object/account/{id} | CRUD: Delete Account
[**proxyGETAccount**](AccountsApi.md#proxyGETAccount) | **GET** /object/account/{id} | CRUD: Retrieve Account
[**proxyPOSTAccount**](AccountsApi.md#proxyPOSTAccount) | **POST** /object/account | CRUD: Create Account
[**proxyPUTAccount**](AccountsApi.md#proxyPUTAccount) | **PUT** /object/account/{id} | CRUD: Update Account


<a name="gETAccount"></a>
# **gETAccount**
> GETAccountType gETAccount(accountKey)

Get account

This REST API reference describes how to retrieve basic information about a customer account.  This REST call is a quick retrieval that doesn&#39;t include the account&#39;s subscriptions, invoices, payments, or usage details. Use the [Get account summary](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Accounts/3_GET_account_summary) to get more detailed information about an account. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountsApi;


AccountsApi apiInstance = new AccountsApi();
String accountKey = "accountKey_example"; // String | Account number or account ID.
try {
    GETAccountType result = apiInstance.gETAccount(accountKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountsApi#gETAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountKey** | **String**| Account number or account ID. |

### Return type

[**GETAccountType**](GETAccountType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETAccountSummary"></a>
# **gETAccountSummary**
> GETAccountSummaryType gETAccountSummary(accountKey)

Get account summary

This REST API reference describes how to retrieve detailed information about the specified customer account.  The response includes everything retrieved with the [Get basic account information](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Accounts/2_Get_account_basics) call, plus a summary of the account&#39;s subscriptions, invoices, payments, and usage for the last six months.  ## Notes  Returns only the six most recent subscriptions based on the subscription updatedDate. Within those subscriptions, there may be many rate plans and many rate plan charges. These items are subject to the maximum limit on the array size. See [REST API basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information on concurrent request limits. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountsApi;


AccountsApi apiInstance = new AccountsApi();
String accountKey = "accountKey_example"; // String | Account number or account ID.
try {
    GETAccountSummaryType result = apiInstance.gETAccountSummary(accountKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountsApi#gETAccountSummary");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountKey** | **String**| Account number or account ID. |

### Return type

[**GETAccountSummaryType**](GETAccountSummaryType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pOSTAccount"></a>
# **pOSTAccount**
> POSTAccountResponseType pOSTAccount(request, zuoraVersion)

Create account

This REST API reference describes how to create a customer account with a credit-card payment method, a bill-to contact, and an optional sold-to contact. Request and response field descriptions and sample code are provided. Use this method to optionally create a subscription, invoice for that subscription, and collect payment through the default payment method. The transaction is atomic; if any part fails for any reason, the entire transaction is rolled back.  This API call is CORS Enabled, so you can use client-side Javascript to invoke the call. For more information, visit the [Zuora CORS REST](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/G_CORS_REST) page.  ## Notes 1. The account is created in active status.   2. The request must provide either a **creditCard** structure or the **hpmCreditCardPaymentMethodId** field (but not both). The one provided becomes the default payment method for this account. If the credit card information is declined or can&#39;t be verified, then the account is not created. 3. Customer accounts created with this call are automatically be set to Auto Pay. 4. If either the **workEmail** or **personalEmail** are specified, then the account&#39;s email delivery preference is automatically set to &#x60;true&#x60;. (In that case, emails go to the **workEmail** address, if it exists, or else the **personalEmail**.) If neither field is specified, the email delivery preference is automatically set to &#x60;false&#x60;.  ## Defaults for customerAcceptanceDate and serviceActivationDate Default values for **customerAcceptanceDate** and **serviceActivationDate** are set as follows.  |        | serviceActivationDate(SA) specified          | serviceActivationDate (SA) NOT specified  | | ------------- |:-------------:| -----:| | customerAcceptanceDate (CA) specified      | SA uses value in the request call; CA uses value in the request call| CA uses value in the request call;SA uses CE as default | | customerAcceptanceDate (CA) NOT specified      | SA uses value in the request call; CA uses SA as default |   SA and CA use CE as default | 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountsApi;


AccountsApi apiInstance = new AccountsApi();
POSTAccountType request = new POSTAccountType(); // POSTAccountType | 
String zuoraVersion = "zuoraVersion_example"; // String | The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ fields. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information.
try {
    POSTAccountResponseType result = apiInstance.pOSTAccount(request, zuoraVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountsApi#pOSTAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**POSTAccountType**](POSTAccountType.md)|  |
 **zuoraVersion** | **String**| The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ fields. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. | [optional]

### Return type

[**POSTAccountResponseType**](POSTAccountResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTAccount"></a>
# **pUTAccount**
> CommonResponseType pUTAccount(accountKey, request)

Update account

This REST API reference describes how to update a customer account by specifying the account-key.  ## Notes 1. Only the fields to be changed should be specified.  Any field that&#39;s not included in the request body will not be changed. 2. If an empty field is submitted with this call, the corresponding field in the account is emptied. 3. Email addresses: If no email addresses are specified, no change is made to the email addresses on file or to the email delivery preference. If either the **personalEmail** or **workEmail** is specified (or both), the system updates the corresponding email address(es) on file and the email delivery preference is set to &#x60;true&#x60;. (In that case, emails go to the **workEmail** address, if it exists, or else the **personalEmail**.) On the other hand, if as a result of this call both of the email addresses for the account are empty, the email delivery preference is set to &#x60;false&#x60;. 4. The bill-to and sold-to contacts are separate data entities; updating either one does not update the other. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountsApi;


AccountsApi apiInstance = new AccountsApi();
String accountKey = "accountKey_example"; // String | Account number or account ID.
PUTAccountType request = new PUTAccountType(); // PUTAccountType | 
try {
    CommonResponseType result = apiInstance.pUTAccount(accountKey, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountsApi#pUTAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountKey** | **String**| Account number or account ID. |
 **request** | [**PUTAccountType**](PUTAccountType.md)|  |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyDELETEAccount"></a>
# **proxyDELETEAccount**
> ProxyDeleteResponse proxyDELETEAccount(id)

CRUD: Delete Account



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountsApi;


AccountsApi apiInstance = new AccountsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEAccount(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountsApi#proxyDELETEAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |

### Return type

[**ProxyDeleteResponse**](ProxyDeleteResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyGETAccount"></a>
# **proxyGETAccount**
> ProxyGetAccount proxyGETAccount(id, fields)

CRUD: Retrieve Account



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountsApi;


AccountsApi apiInstance = new AccountsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetAccount result = apiInstance.proxyGETAccount(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountsApi#proxyGETAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetAccount**](ProxyGetAccount.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPOSTAccount"></a>
# **proxyPOSTAccount**
> ProxyCreateOrModifyResponse proxyPOSTAccount(createRequest)

CRUD: Create Account



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountsApi;


AccountsApi apiInstance = new AccountsApi();
ProxyCreateAccount createRequest = new ProxyCreateAccount(); // ProxyCreateAccount | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPOSTAccount(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountsApi#proxyPOSTAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyCreateAccount**](ProxyCreateAccount.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPUTAccount"></a>
# **proxyPUTAccount**
> ProxyCreateOrModifyResponse proxyPUTAccount(id, modifyRequest)

CRUD: Update Account



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountsApi;


AccountsApi apiInstance = new AccountsApi();
String id = "id_example"; // String | Object id
ProxyModifyAccount modifyRequest = new ProxyModifyAccount(); // ProxyModifyAccount | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPUTAccount(id, modifyRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountsApi#proxyPUTAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **modifyRequest** | [**ProxyModifyAccount**](ProxyModifyAccount.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

