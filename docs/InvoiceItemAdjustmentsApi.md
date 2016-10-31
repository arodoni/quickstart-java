# InvoiceItemAdjustmentsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEInvoiceItemAdjustment**](InvoiceItemAdjustmentsApi.md#proxyDELETEInvoiceItemAdjustment) | **DELETE** /object/invoice-item-adjustment/{id} | CRUD: Delete InvoiceItemAdjustment
[**proxyGETInvoiceItemAdjustment**](InvoiceItemAdjustmentsApi.md#proxyGETInvoiceItemAdjustment) | **GET** /object/invoice-item-adjustment/{id} | CRUD: Retrieve InvoiceItemAdjustment


<a name="proxyDELETEInvoiceItemAdjustment"></a>
# **proxyDELETEInvoiceItemAdjustment**
> ProxyDeleteResponse proxyDELETEInvoiceItemAdjustment(id)

CRUD: Delete InvoiceItemAdjustment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoiceItemAdjustmentsApi;


InvoiceItemAdjustmentsApi apiInstance = new InvoiceItemAdjustmentsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEInvoiceItemAdjustment(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoiceItemAdjustmentsApi#proxyDELETEInvoiceItemAdjustment");
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

<a name="proxyGETInvoiceItemAdjustment"></a>
# **proxyGETInvoiceItemAdjustment**
> ProxyGetInvoiceItemAdjustment proxyGETInvoiceItemAdjustment(id, fields)

CRUD: Retrieve InvoiceItemAdjustment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoiceItemAdjustmentsApi;


InvoiceItemAdjustmentsApi apiInstance = new InvoiceItemAdjustmentsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetInvoiceItemAdjustment result = apiInstance.proxyGETInvoiceItemAdjustment(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoiceItemAdjustmentsApi#proxyGETInvoiceItemAdjustment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetInvoiceItemAdjustment**](ProxyGetInvoiceItemAdjustment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

