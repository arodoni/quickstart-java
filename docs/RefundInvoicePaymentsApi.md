# RefundInvoicePaymentsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETERefundInvoicePayment**](RefundInvoicePaymentsApi.md#proxyDELETERefundInvoicePayment) | **DELETE** /object/refund-invoice-payment/{id} | CRUD: Delete RefundInvoicePayment
[**proxyGETRefundInvoicePayment**](RefundInvoicePaymentsApi.md#proxyGETRefundInvoicePayment) | **GET** /object/refund-invoice-payment/{id} | CRUD: Retrieve RefundInvoicePayment


<a name="proxyDELETERefundInvoicePayment"></a>
# **proxyDELETERefundInvoicePayment**
> ProxyDeleteResponse proxyDELETERefundInvoicePayment(id)

CRUD: Delete RefundInvoicePayment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RefundInvoicePaymentsApi;


RefundInvoicePaymentsApi apiInstance = new RefundInvoicePaymentsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETERefundInvoicePayment(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RefundInvoicePaymentsApi#proxyDELETERefundInvoicePayment");
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

<a name="proxyGETRefundInvoicePayment"></a>
# **proxyGETRefundInvoicePayment**
> ProxyGetRefundInvoicePayment proxyGETRefundInvoicePayment(id, fields)

CRUD: Retrieve RefundInvoicePayment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RefundInvoicePaymentsApi;


RefundInvoicePaymentsApi apiInstance = new RefundInvoicePaymentsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetRefundInvoicePayment result = apiInstance.proxyGETRefundInvoicePayment(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RefundInvoicePaymentsApi#proxyGETRefundInvoicePayment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetRefundInvoicePayment**](ProxyGetRefundInvoicePayment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

