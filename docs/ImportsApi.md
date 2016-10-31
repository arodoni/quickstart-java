# ImportsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEImport**](ImportsApi.md#proxyDELETEImport) | **DELETE** /object/import/{id} | CRUD: Delete Import
[**proxyGETImport**](ImportsApi.md#proxyGETImport) | **GET** /object/import/{id} | CRUD: Retrieve Import
[**proxyPOSTImport**](ImportsApi.md#proxyPOSTImport) | **POST** /object/import | CRUD: Create Import


<a name="proxyDELETEImport"></a>
# **proxyDELETEImport**
> ProxyDeleteResponse proxyDELETEImport(id)

CRUD: Delete Import



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImportsApi;


ImportsApi apiInstance = new ImportsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEImport(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImportsApi#proxyDELETEImport");
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

<a name="proxyGETImport"></a>
# **proxyGETImport**
> ProxyGetImport proxyGETImport(id, fields)

CRUD: Retrieve Import



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImportsApi;


ImportsApi apiInstance = new ImportsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetImport result = apiInstance.proxyGETImport(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImportsApi#proxyGETImport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetImport**](ProxyGetImport.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPOSTImport"></a>
# **proxyPOSTImport**
> ProxyCreateOrModifyResponse proxyPOSTImport(createRequest)

CRUD: Create Import



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImportsApi;


ImportsApi apiInstance = new ImportsApi();
ProxyCreateImport createRequest = new ProxyCreateImport(); // ProxyCreateImport | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPOSTImport(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImportsApi#proxyPOSTImport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyCreateImport**](ProxyCreateImport.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

