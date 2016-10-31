# InvoiceItemsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEInvoiceItem**](InvoiceItemsApi.md#proxyDELETEInvoiceItem) | **DELETE** /object/invoice-item/{id} | CRUD: Delete InvoiceItem
[**proxyGETInvoiceItem**](InvoiceItemsApi.md#proxyGETInvoiceItem) | **GET** /object/invoice-item/{id} | CRUD: Retrieve InvoiceItem


<a name="proxyDELETEInvoiceItem"></a>
# **proxyDELETEInvoiceItem**
> ProxyDeleteResponse proxyDELETEInvoiceItem(id)

CRUD: Delete InvoiceItem



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoiceItemsApi;


InvoiceItemsApi apiInstance = new InvoiceItemsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEInvoiceItem(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoiceItemsApi#proxyDELETEInvoiceItem");
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

<a name="proxyGETInvoiceItem"></a>
# **proxyGETInvoiceItem**
> ProxyGetInvoiceItem proxyGETInvoiceItem(id, fields)

CRUD: Retrieve InvoiceItem



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoiceItemsApi;


InvoiceItemsApi apiInstance = new InvoiceItemsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetInvoiceItem result = apiInstance.proxyGETInvoiceItem(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoiceItemsApi#proxyGETInvoiceItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetInvoiceItem**](ProxyGetInvoiceItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

