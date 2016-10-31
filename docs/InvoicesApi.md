# InvoicesApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEInvoice**](InvoicesApi.md#proxyDELETEInvoice) | **DELETE** /object/invoice/{id} | CRUD: Delete Invoice
[**proxyGETInvoice**](InvoicesApi.md#proxyGETInvoice) | **GET** /object/invoice/{id} | CRUD: Retrieve Invoice
[**proxyPOSTInvoice**](InvoicesApi.md#proxyPOSTInvoice) | **POST** /object/invoice | CRUD: Create Invoice
[**proxyPUTInvoice**](InvoicesApi.md#proxyPUTInvoice) | **PUT** /object/invoice/{id} | CRUD: Update Invoice


<a name="proxyDELETEInvoice"></a>
# **proxyDELETEInvoice**
> ProxyDeleteResponse proxyDELETEInvoice(id)

CRUD: Delete Invoice



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoicesApi;


InvoicesApi apiInstance = new InvoicesApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEInvoice(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicesApi#proxyDELETEInvoice");
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

<a name="proxyGETInvoice"></a>
# **proxyGETInvoice**
> ProxyGetInvoice proxyGETInvoice(id, fields)

CRUD: Retrieve Invoice



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoicesApi;


InvoicesApi apiInstance = new InvoicesApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetInvoice result = apiInstance.proxyGETInvoice(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicesApi#proxyGETInvoice");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetInvoice**](ProxyGetInvoice.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPOSTInvoice"></a>
# **proxyPOSTInvoice**
> ProxyCreateOrModifyResponse proxyPOSTInvoice(createRequest)

CRUD: Create Invoice



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoicesApi;


InvoicesApi apiInstance = new InvoicesApi();
ProxyCreateInvoice createRequest = new ProxyCreateInvoice(); // ProxyCreateInvoice | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPOSTInvoice(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicesApi#proxyPOSTInvoice");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyCreateInvoice**](ProxyCreateInvoice.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPUTInvoice"></a>
# **proxyPUTInvoice**
> ProxyCreateOrModifyResponse proxyPUTInvoice(id, modifyRequest)

CRUD: Update Invoice



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoicesApi;


InvoicesApi apiInstance = new InvoicesApi();
String id = "id_example"; // String | Object id
ProxyModifyInvoice modifyRequest = new ProxyModifyInvoice(); // ProxyModifyInvoice | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPUTInvoice(id, modifyRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicesApi#proxyPUTInvoice");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **modifyRequest** | [**ProxyModifyInvoice**](ProxyModifyInvoice.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

