# ExportsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEExport**](ExportsApi.md#proxyDELETEExport) | **DELETE** /object/export/{id} | CRUD: Delete Export
[**proxyGETExport**](ExportsApi.md#proxyGETExport) | **GET** /object/export/{id} | CRUD: Retrieve Export
[**proxyPOSTExport**](ExportsApi.md#proxyPOSTExport) | **POST** /object/export | CRUD: Create Export


<a name="proxyDELETEExport"></a>
# **proxyDELETEExport**
> ProxyDeleteResponse proxyDELETEExport(id)

CRUD: Delete Export



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExportsApi;


ExportsApi apiInstance = new ExportsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEExport(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExportsApi#proxyDELETEExport");
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

<a name="proxyGETExport"></a>
# **proxyGETExport**
> ProxyGetExport proxyGETExport(id, fields)

CRUD: Retrieve Export



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExportsApi;


ExportsApi apiInstance = new ExportsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetExport result = apiInstance.proxyGETExport(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExportsApi#proxyGETExport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetExport**](ProxyGetExport.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPOSTExport"></a>
# **proxyPOSTExport**
> ProxyCreateOrModifyResponse proxyPOSTExport(createRequest)

CRUD: Create Export



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExportsApi;


ExportsApi apiInstance = new ExportsApi();
ProxyCreateExport createRequest = new ProxyCreateExport(); // ProxyCreateExport | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPOSTExport(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExportsApi#proxyPOSTExport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyCreateExport**](ProxyCreateExport.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

