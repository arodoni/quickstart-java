# ProductsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEProduct**](ProductsApi.md#proxyDELETEProduct) | **DELETE** /object/product/{id} | CRUD: Delete Product
[**proxyGETProduct**](ProductsApi.md#proxyGETProduct) | **GET** /object/product/{id} | CRUD: Retrieve Product
[**proxyPOSTProduct**](ProductsApi.md#proxyPOSTProduct) | **POST** /object/product | CRUD: Create Product
[**proxyPUTProduct**](ProductsApi.md#proxyPUTProduct) | **PUT** /object/product/{id} | CRUD: Update Product


<a name="proxyDELETEProduct"></a>
# **proxyDELETEProduct**
> ProxyDeleteResponse proxyDELETEProduct(id)

CRUD: Delete Product



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductsApi;


ProductsApi apiInstance = new ProductsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEProduct(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductsApi#proxyDELETEProduct");
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

<a name="proxyGETProduct"></a>
# **proxyGETProduct**
> ProxyGetProduct proxyGETProduct(id, fields)

CRUD: Retrieve Product



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductsApi;


ProductsApi apiInstance = new ProductsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetProduct result = apiInstance.proxyGETProduct(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductsApi#proxyGETProduct");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetProduct**](ProxyGetProduct.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPOSTProduct"></a>
# **proxyPOSTProduct**
> ProxyCreateOrModifyResponse proxyPOSTProduct(createRequest)

CRUD: Create Product



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductsApi;


ProductsApi apiInstance = new ProductsApi();
ProxyCreateProduct createRequest = new ProxyCreateProduct(); // ProxyCreateProduct | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPOSTProduct(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductsApi#proxyPOSTProduct");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyCreateProduct**](ProxyCreateProduct.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPUTProduct"></a>
# **proxyPUTProduct**
> ProxyCreateOrModifyResponse proxyPUTProduct(id, modifyRequest)

CRUD: Update Product



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductsApi;


ProductsApi apiInstance = new ProductsApi();
String id = "id_example"; // String | Object id
ProxyModifyProduct modifyRequest = new ProxyModifyProduct(); // ProxyModifyProduct | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPUTProduct(id, modifyRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductsApi#proxyPUTProduct");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **modifyRequest** | [**ProxyModifyProduct**](ProxyModifyProduct.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

