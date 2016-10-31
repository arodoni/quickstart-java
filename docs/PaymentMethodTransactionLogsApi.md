# PaymentMethodTransactionLogsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEPaymentMethodTransactionLog**](PaymentMethodTransactionLogsApi.md#proxyDELETEPaymentMethodTransactionLog) | **DELETE** /object/payment-method-transaction-log/{id} | CRUD: Delete PaymentMethodTransactionLog
[**proxyGETPaymentMethodTransactionLog**](PaymentMethodTransactionLogsApi.md#proxyGETPaymentMethodTransactionLog) | **GET** /object/payment-method-transaction-log/{id} | CRUD: Retrieve PaymentMethodTransactionLog


<a name="proxyDELETEPaymentMethodTransactionLog"></a>
# **proxyDELETEPaymentMethodTransactionLog**
> ProxyDeleteResponse proxyDELETEPaymentMethodTransactionLog(id)

CRUD: Delete PaymentMethodTransactionLog



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentMethodTransactionLogsApi;


PaymentMethodTransactionLogsApi apiInstance = new PaymentMethodTransactionLogsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEPaymentMethodTransactionLog(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentMethodTransactionLogsApi#proxyDELETEPaymentMethodTransactionLog");
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

<a name="proxyGETPaymentMethodTransactionLog"></a>
# **proxyGETPaymentMethodTransactionLog**
> ProxyGetPaymentMethodTransactionLog proxyGETPaymentMethodTransactionLog(id, fields)

CRUD: Retrieve PaymentMethodTransactionLog



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentMethodTransactionLogsApi;


PaymentMethodTransactionLogsApi apiInstance = new PaymentMethodTransactionLogsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetPaymentMethodTransactionLog result = apiInstance.proxyGETPaymentMethodTransactionLog(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentMethodTransactionLogsApi#proxyGETPaymentMethodTransactionLog");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetPaymentMethodTransactionLog**](ProxyGetPaymentMethodTransactionLog.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

