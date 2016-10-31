# ProductRatePlansApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEProductRatePlan**](ProductRatePlansApi.md#proxyDELETEProductRatePlan) | **DELETE** /object/product-rate-plan/{id} | CRUD: Delete ProductRatePlan
[**proxyGETProductRatePlan**](ProductRatePlansApi.md#proxyGETProductRatePlan) | **GET** /object/product-rate-plan/{id} | CRUD: Retrieve ProductRatePlan
[**proxyPOSTProductRatePlan**](ProductRatePlansApi.md#proxyPOSTProductRatePlan) | **POST** /object/product-rate-plan | CRUD: Create ProductRatePlan
[**proxyPUTProductRatePlan**](ProductRatePlansApi.md#proxyPUTProductRatePlan) | **PUT** /object/product-rate-plan/{id} | CRUD: Update ProductRatePlan


<a name="proxyDELETEProductRatePlan"></a>
# **proxyDELETEProductRatePlan**
> ProxyDeleteResponse proxyDELETEProductRatePlan(id)

CRUD: Delete ProductRatePlan



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductRatePlansApi;


ProductRatePlansApi apiInstance = new ProductRatePlansApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEProductRatePlan(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductRatePlansApi#proxyDELETEProductRatePlan");
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

<a name="proxyGETProductRatePlan"></a>
# **proxyGETProductRatePlan**
> ProxyGetProductRatePlan proxyGETProductRatePlan(id, fields)

CRUD: Retrieve ProductRatePlan



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductRatePlansApi;


ProductRatePlansApi apiInstance = new ProductRatePlansApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetProductRatePlan result = apiInstance.proxyGETProductRatePlan(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductRatePlansApi#proxyGETProductRatePlan");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetProductRatePlan**](ProxyGetProductRatePlan.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPOSTProductRatePlan"></a>
# **proxyPOSTProductRatePlan**
> ProxyCreateOrModifyResponse proxyPOSTProductRatePlan(createRequest)

CRUD: Create ProductRatePlan



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductRatePlansApi;


ProductRatePlansApi apiInstance = new ProductRatePlansApi();
ProxyCreateProductRatePlan createRequest = new ProxyCreateProductRatePlan(); // ProxyCreateProductRatePlan | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPOSTProductRatePlan(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductRatePlansApi#proxyPOSTProductRatePlan");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyCreateProductRatePlan**](ProxyCreateProductRatePlan.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPUTProductRatePlan"></a>
# **proxyPUTProductRatePlan**
> ProxyCreateOrModifyResponse proxyPUTProductRatePlan(id, modifyRequest)

CRUD: Update ProductRatePlan



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductRatePlansApi;


ProductRatePlansApi apiInstance = new ProductRatePlansApi();
String id = "id_example"; // String | Object id
ProxyModifyProductRatePlan modifyRequest = new ProxyModifyProductRatePlan(); // ProxyModifyProductRatePlan | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPUTProductRatePlan(id, modifyRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductRatePlansApi#proxyPUTProductRatePlan");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **modifyRequest** | [**ProxyModifyProductRatePlan**](ProxyModifyProductRatePlan.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

