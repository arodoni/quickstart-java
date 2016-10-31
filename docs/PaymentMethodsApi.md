# PaymentMethodsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**dELETEPaymentMethods**](PaymentMethodsApi.md#dELETEPaymentMethods) | **DELETE** /payment-methods/{payment-method-id} | Delete payment method
[**gETPaymentMethods**](PaymentMethodsApi.md#gETPaymentMethods) | **GET** /payment-methods/credit-cards/accounts/{account-key} | Get payment methods
[**pOSTPaymentMethod**](PaymentMethodsApi.md#pOSTPaymentMethod) | **POST** /payment-methods/credit-cards | Create payment method
[**pUTPaymentMethods**](PaymentMethodsApi.md#pUTPaymentMethods) | **PUT** /payment-methods/credit-cards/{payment-method-id} | Update payment method
[**proxyDELETEPaymentMethod**](PaymentMethodsApi.md#proxyDELETEPaymentMethod) | **DELETE** /object/payment-method/{id} | CRUD: Delete PaymentMethod
[**proxyGETPaymentMethod**](PaymentMethodsApi.md#proxyGETPaymentMethod) | **GET** /object/payment-method/{id} | CRUD: Retrieve PaymentMethod
[**proxyPOSTPaymentMethod**](PaymentMethodsApi.md#proxyPOSTPaymentMethod) | **POST** /object/payment-method | CRUD: Create PaymentMethod
[**proxyPUTPaymentMethod**](PaymentMethodsApi.md#proxyPUTPaymentMethod) | **PUT** /object/payment-method/{id} | CRUD: Update PaymentMethod


<a name="dELETEPaymentMethods"></a>
# **dELETEPaymentMethods**
> CommonResponseType dELETEPaymentMethods(paymentMethodId)

Delete payment method

Deletes a credit card payment method from the specified customer account.  If the specified payment method is the account&#39;s default payment method, the request will fail.  In that case, you must first designate a different payment method for that customer to be the default. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentMethodsApi;


PaymentMethodsApi apiInstance = new PaymentMethodsApi();
String paymentMethodId = "paymentMethodId_example"; // String | Unique identifier of a payment method. (Since this ID is unique, and linked to a customer account in the system, no customer identifier is needed.)
try {
    CommonResponseType result = apiInstance.dELETEPaymentMethods(paymentMethodId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentMethodsApi#dELETEPaymentMethods");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **paymentMethodId** | **String**| Unique identifier of a payment method. (Since this ID is unique, and linked to a customer account in the system, no customer identifier is needed.) |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETPaymentMethods"></a>
# **gETPaymentMethods**
> GETPaymentMethodsType gETPaymentMethods(accountKey)

Get payment methods

This REST API reference describes how to retrieve all credit card information for the specified customer account.   ## Notes The response includes details credit or debit cards for the specified customer account. Card numbers are masked, e.g., \&quot;************1234\&quot;. Cards are returned in reverse chronological order of last update.  You can send requests for bank transfer payment methods types. The response will not include bank transfer details.  The response only includes payment details on payment methods that are credit or debit cards. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentMethodsApi;


PaymentMethodsApi apiInstance = new PaymentMethodsApi();
String accountKey = "accountKey_example"; // String | Account number or account ID.
try {
    GETPaymentMethodsType result = apiInstance.gETPaymentMethods(accountKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentMethodsApi#gETPaymentMethods");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountKey** | **String**| Account number or account ID. |

### Return type

[**GETPaymentMethodsType**](GETPaymentMethodsType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pOSTPaymentMethod"></a>
# **pOSTPaymentMethod**
> POSTPaymentMethodResponseType pOSTPaymentMethod(request)

Create payment method

This REST API reference describes how to create a new credit card payment method for a customer account.  ## Notes  This API call is CORS Enabled. Use client-side JavaScript to invoke the call. See [Zuora CORS REST](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/G_CORS_REST) for more information.  

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentMethodsApi;


PaymentMethodsApi apiInstance = new PaymentMethodsApi();
POSTPaymentMethodType request = new POSTPaymentMethodType(); // POSTPaymentMethodType | 
try {
    POSTPaymentMethodResponseType result = apiInstance.pOSTPaymentMethod(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentMethodsApi#pOSTPaymentMethod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**POSTPaymentMethodType**](POSTPaymentMethodType.md)|  |

### Return type

[**POSTPaymentMethodResponseType**](POSTPaymentMethodResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTPaymentMethods"></a>
# **pUTPaymentMethods**
> PUTPaymentMethodResponseType pUTPaymentMethods(paymentMethodId, request)

Update payment method

Updates an existing credit card payment method for the specified customer account. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentMethodsApi;


PaymentMethodsApi apiInstance = new PaymentMethodsApi();
String paymentMethodId = "paymentMethodId_example"; // String | Unique ID of the payment method to update.
PUTPaymentMethodType request = new PUTPaymentMethodType(); // PUTPaymentMethodType | 
try {
    PUTPaymentMethodResponseType result = apiInstance.pUTPaymentMethods(paymentMethodId, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentMethodsApi#pUTPaymentMethods");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **paymentMethodId** | **String**| Unique ID of the payment method to update. |
 **request** | [**PUTPaymentMethodType**](PUTPaymentMethodType.md)|  |

### Return type

[**PUTPaymentMethodResponseType**](PUTPaymentMethodResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyDELETEPaymentMethod"></a>
# **proxyDELETEPaymentMethod**
> ProxyDeleteResponse proxyDELETEPaymentMethod(id)

CRUD: Delete PaymentMethod



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentMethodsApi;


PaymentMethodsApi apiInstance = new PaymentMethodsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEPaymentMethod(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentMethodsApi#proxyDELETEPaymentMethod");
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

<a name="proxyGETPaymentMethod"></a>
# **proxyGETPaymentMethod**
> ProxyGetPaymentMethod proxyGETPaymentMethod(id, fields)

CRUD: Retrieve PaymentMethod



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentMethodsApi;


PaymentMethodsApi apiInstance = new PaymentMethodsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetPaymentMethod result = apiInstance.proxyGETPaymentMethod(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentMethodsApi#proxyGETPaymentMethod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetPaymentMethod**](ProxyGetPaymentMethod.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPOSTPaymentMethod"></a>
# **proxyPOSTPaymentMethod**
> ProxyCreateOrModifyResponse proxyPOSTPaymentMethod(createRequest)

CRUD: Create PaymentMethod



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentMethodsApi;


PaymentMethodsApi apiInstance = new PaymentMethodsApi();
ProxyCreatePaymentMethod createRequest = new ProxyCreatePaymentMethod(); // ProxyCreatePaymentMethod | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPOSTPaymentMethod(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentMethodsApi#proxyPOSTPaymentMethod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyCreatePaymentMethod**](ProxyCreatePaymentMethod.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPUTPaymentMethod"></a>
# **proxyPUTPaymentMethod**
> ProxyCreateOrModifyResponse proxyPUTPaymentMethod(id, modifyRequest)

CRUD: Update PaymentMethod



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentMethodsApi;


PaymentMethodsApi apiInstance = new PaymentMethodsApi();
String id = "id_example"; // String | Object id
ProxyModifyPaymentMethod modifyRequest = new ProxyModifyPaymentMethod(); // ProxyModifyPaymentMethod | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPUTPaymentMethod(id, modifyRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentMethodsApi#proxyPUTPaymentMethod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **modifyRequest** | [**ProxyModifyPaymentMethod**](ProxyModifyPaymentMethod.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

