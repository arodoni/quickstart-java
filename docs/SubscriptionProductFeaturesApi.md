# SubscriptionProductFeaturesApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETESubscriptionProductFeature**](SubscriptionProductFeaturesApi.md#proxyDELETESubscriptionProductFeature) | **DELETE** /object/subscription-product-feature/{id} | CRUD: Delete SubscriptionProductFeature
[**proxyGETSubscriptionProductFeature**](SubscriptionProductFeaturesApi.md#proxyGETSubscriptionProductFeature) | **GET** /object/subscription-product-feature/{id} | CRUD: Retrieve SubscriptionProductFeature


<a name="proxyDELETESubscriptionProductFeature"></a>
# **proxyDELETESubscriptionProductFeature**
> ProxyDeleteResponse proxyDELETESubscriptionProductFeature(id)

CRUD: Delete SubscriptionProductFeature



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionProductFeaturesApi;


SubscriptionProductFeaturesApi apiInstance = new SubscriptionProductFeaturesApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETESubscriptionProductFeature(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionProductFeaturesApi#proxyDELETESubscriptionProductFeature");
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

<a name="proxyGETSubscriptionProductFeature"></a>
# **proxyGETSubscriptionProductFeature**
> ProxyGetSubscriptionProductFeature proxyGETSubscriptionProductFeature(id, fields)

CRUD: Retrieve SubscriptionProductFeature



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionProductFeaturesApi;


SubscriptionProductFeaturesApi apiInstance = new SubscriptionProductFeaturesApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetSubscriptionProductFeature result = apiInstance.proxyGETSubscriptionProductFeature(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionProductFeaturesApi#proxyGETSubscriptionProductFeature");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetSubscriptionProductFeature**](ProxyGetSubscriptionProductFeature.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

