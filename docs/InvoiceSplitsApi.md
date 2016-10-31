# InvoiceSplitsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEInvoiceSplit**](InvoiceSplitsApi.md#proxyDELETEInvoiceSplit) | **DELETE** /object/invoice-split/{id} | CRUD: Delete InvoiceSplit
[**proxyGETInvoiceSplit**](InvoiceSplitsApi.md#proxyGETInvoiceSplit) | **GET** /object/invoice-split/{id} | CRUD: Retrieve InvoiceSplit


<a name="proxyDELETEInvoiceSplit"></a>
# **proxyDELETEInvoiceSplit**
> ProxyDeleteResponse proxyDELETEInvoiceSplit(id)

CRUD: Delete InvoiceSplit



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoiceSplitsApi;


InvoiceSplitsApi apiInstance = new InvoiceSplitsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEInvoiceSplit(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoiceSplitsApi#proxyDELETEInvoiceSplit");
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

<a name="proxyGETInvoiceSplit"></a>
# **proxyGETInvoiceSplit**
> ProxyGetInvoiceSplit proxyGETInvoiceSplit(id, fields)

CRUD: Retrieve InvoiceSplit



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoiceSplitsApi;


InvoiceSplitsApi apiInstance = new InvoiceSplitsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetInvoiceSplit result = apiInstance.proxyGETInvoiceSplit(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoiceSplitsApi#proxyGETInvoiceSplit");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetInvoiceSplit**](ProxyGetInvoiceSplit.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

