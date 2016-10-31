# InvoiceSplitItemsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEInvoiceSplitItem**](InvoiceSplitItemsApi.md#proxyDELETEInvoiceSplitItem) | **DELETE** /object/invoice-split-item/{id} | CRUD: Delete InvoiceSplitItem
[**proxyGETInvoiceSplitItem**](InvoiceSplitItemsApi.md#proxyGETInvoiceSplitItem) | **GET** /object/invoice-split-item/{id} | CRUD: Retrieve InvoiceSplitItem


<a name="proxyDELETEInvoiceSplitItem"></a>
# **proxyDELETEInvoiceSplitItem**
> ProxyDeleteResponse proxyDELETEInvoiceSplitItem(id)

CRUD: Delete InvoiceSplitItem



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoiceSplitItemsApi;


InvoiceSplitItemsApi apiInstance = new InvoiceSplitItemsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEInvoiceSplitItem(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoiceSplitItemsApi#proxyDELETEInvoiceSplitItem");
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

<a name="proxyGETInvoiceSplitItem"></a>
# **proxyGETInvoiceSplitItem**
> ProxyGetInvoiceSplitItem proxyGETInvoiceSplitItem(id, fields)

CRUD: Retrieve InvoiceSplitItem



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoiceSplitItemsApi;


InvoiceSplitItemsApi apiInstance = new InvoiceSplitItemsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetInvoiceSplitItem result = apiInstance.proxyGETInvoiceSplitItem(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoiceSplitItemsApi#proxyGETInvoiceSplitItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetInvoiceSplitItem**](ProxyGetInvoiceSplitItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

