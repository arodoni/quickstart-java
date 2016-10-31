# FeaturesApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEFeature**](FeaturesApi.md#proxyDELETEFeature) | **DELETE** /object/feature/{id} | CRUD: Delete Feature
[**proxyGETFeature**](FeaturesApi.md#proxyGETFeature) | **GET** /object/feature/{id} | CRUD: Retrieve Feature


<a name="proxyDELETEFeature"></a>
# **proxyDELETEFeature**
> ProxyDeleteResponse proxyDELETEFeature(id)

CRUD: Delete Feature



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FeaturesApi;


FeaturesApi apiInstance = new FeaturesApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEFeature(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FeaturesApi#proxyDELETEFeature");
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

<a name="proxyGETFeature"></a>
# **proxyGETFeature**
> ProxyGetFeature proxyGETFeature(id, fields)

CRUD: Retrieve Feature



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FeaturesApi;


FeaturesApi apiInstance = new FeaturesApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetFeature result = apiInstance.proxyGETFeature(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FeaturesApi#proxyGETFeature");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetFeature**](ProxyGetFeature.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

