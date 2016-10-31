# PaymentTransactionLogsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEPaymentTransactionLog**](PaymentTransactionLogsApi.md#proxyDELETEPaymentTransactionLog) | **DELETE** /object/payment-transaction-log/{id} | CRUD: Delete PaymentTransactionLog
[**proxyGETPaymentTransactionLog**](PaymentTransactionLogsApi.md#proxyGETPaymentTransactionLog) | **GET** /object/payment-transaction-log/{id} | CRUD: Retrieve PaymentTransactionLog


<a name="proxyDELETEPaymentTransactionLog"></a>
# **proxyDELETEPaymentTransactionLog**
> ProxyDeleteResponse proxyDELETEPaymentTransactionLog(id)

CRUD: Delete PaymentTransactionLog



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentTransactionLogsApi;


PaymentTransactionLogsApi apiInstance = new PaymentTransactionLogsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEPaymentTransactionLog(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentTransactionLogsApi#proxyDELETEPaymentTransactionLog");
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

<a name="proxyGETPaymentTransactionLog"></a>
# **proxyGETPaymentTransactionLog**
> ProxyGetPaymentTransactionLog proxyGETPaymentTransactionLog(id, fields)

CRUD: Retrieve PaymentTransactionLog



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentTransactionLogsApi;


PaymentTransactionLogsApi apiInstance = new PaymentTransactionLogsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetPaymentTransactionLog result = apiInstance.proxyGETPaymentTransactionLog(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentTransactionLogsApi#proxyGETPaymentTransactionLog");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetPaymentTransactionLog**](ProxyGetPaymentTransactionLog.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

