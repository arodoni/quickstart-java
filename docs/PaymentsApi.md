# PaymentsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEPayment**](PaymentsApi.md#proxyDELETEPayment) | **DELETE** /object/payment/{id} | CRUD: Delete Payment
[**proxyGETPayment**](PaymentsApi.md#proxyGETPayment) | **GET** /object/payment/{id} | CRUD: Retrieve Payment
[**proxyPOSTPayment**](PaymentsApi.md#proxyPOSTPayment) | **POST** /object/payment | CRUD: Create Payment
[**proxyPUTPayment**](PaymentsApi.md#proxyPUTPayment) | **PUT** /object/payment/{id} | CRUD: Update Payment


<a name="proxyDELETEPayment"></a>
# **proxyDELETEPayment**
> ProxyDeleteResponse proxyDELETEPayment(id)

CRUD: Delete Payment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentsApi;


PaymentsApi apiInstance = new PaymentsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEPayment(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#proxyDELETEPayment");
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

<a name="proxyGETPayment"></a>
# **proxyGETPayment**
> ProxyGetPayment proxyGETPayment(id, fields)

CRUD: Retrieve Payment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentsApi;


PaymentsApi apiInstance = new PaymentsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetPayment result = apiInstance.proxyGETPayment(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#proxyGETPayment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetPayment**](ProxyGetPayment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPOSTPayment"></a>
# **proxyPOSTPayment**
> ProxyCreateOrModifyResponse proxyPOSTPayment(createRequest)

CRUD: Create Payment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentsApi;


PaymentsApi apiInstance = new PaymentsApi();
ProxyCreatePayment createRequest = new ProxyCreatePayment(); // ProxyCreatePayment | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPOSTPayment(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#proxyPOSTPayment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyCreatePayment**](ProxyCreatePayment.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPUTPayment"></a>
# **proxyPUTPayment**
> ProxyCreateOrModifyResponse proxyPUTPayment(id, modifyRequest)

CRUD: Update Payment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentsApi;


PaymentsApi apiInstance = new PaymentsApi();
String id = "id_example"; // String | Object id
ProxyModifyPayment modifyRequest = new ProxyModifyPayment(); // ProxyModifyPayment | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPUTPayment(id, modifyRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#proxyPUTPayment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **modifyRequest** | [**ProxyModifyPayment**](ProxyModifyPayment.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

