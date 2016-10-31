# ProductFeaturesApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEProductFeature**](ProductFeaturesApi.md#proxyDELETEProductFeature) | **DELETE** /object/product-feature/{id} | CRUD: Delete ProductFeature
[**proxyGETProductFeature**](ProductFeaturesApi.md#proxyGETProductFeature) | **GET** /object/product-feature/{id} | CRUD: Retrieve ProductFeature


<a name="proxyDELETEProductFeature"></a>
# **proxyDELETEProductFeature**
> ProxyDeleteResponse proxyDELETEProductFeature(id)

CRUD: Delete ProductFeature



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductFeaturesApi;


ProductFeaturesApi apiInstance = new ProductFeaturesApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEProductFeature(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductFeaturesApi#proxyDELETEProductFeature");
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

<a name="proxyGETProductFeature"></a>
# **proxyGETProductFeature**
> ProxyGetProductFeature proxyGETProductFeature(id, fields)

CRUD: Retrieve ProductFeature



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductFeaturesApi;


ProductFeaturesApi apiInstance = new ProductFeaturesApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetProductFeature result = apiInstance.proxyGETProductFeature(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductFeaturesApi#proxyGETProductFeature");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetProductFeature**](ProxyGetProductFeature.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

