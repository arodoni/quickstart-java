# RefundTransactionLogsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETERefundTransactionLog**](RefundTransactionLogsApi.md#proxyDELETERefundTransactionLog) | **DELETE** /object/refund-transaction-log/{id} | CRUD: Delete RefundTransactionLog
[**proxyGETRefundTransactionLog**](RefundTransactionLogsApi.md#proxyGETRefundTransactionLog) | **GET** /object/refund-transaction-log/{id} | CRUD: Retrieve RefundTransactionLog


<a name="proxyDELETERefundTransactionLog"></a>
# **proxyDELETERefundTransactionLog**
> ProxyDeleteResponse proxyDELETERefundTransactionLog(id)

CRUD: Delete RefundTransactionLog



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RefundTransactionLogsApi;


RefundTransactionLogsApi apiInstance = new RefundTransactionLogsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETERefundTransactionLog(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RefundTransactionLogsApi#proxyDELETERefundTransactionLog");
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

<a name="proxyGETRefundTransactionLog"></a>
# **proxyGETRefundTransactionLog**
> ProxyGetRefundTransactionLog proxyGETRefundTransactionLog(id, fields)

CRUD: Retrieve RefundTransactionLog



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RefundTransactionLogsApi;


RefundTransactionLogsApi apiInstance = new RefundTransactionLogsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetRefundTransactionLog result = apiInstance.proxyGETRefundTransactionLog(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RefundTransactionLogsApi#proxyGETRefundTransactionLog");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetRefundTransactionLog**](ProxyGetRefundTransactionLog.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

