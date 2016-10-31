# RatePlansApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETERatePlan**](RatePlansApi.md#proxyDELETERatePlan) | **DELETE** /object/rate-plan/{id} | CRUD: Delete RatePlan
[**proxyGETRatePlan**](RatePlansApi.md#proxyGETRatePlan) | **GET** /object/rate-plan/{id} | CRUD: Retrieve RatePlan


<a name="proxyDELETERatePlan"></a>
# **proxyDELETERatePlan**
> ProxyDeleteResponse proxyDELETERatePlan(id)

CRUD: Delete RatePlan



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RatePlansApi;


RatePlansApi apiInstance = new RatePlansApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETERatePlan(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RatePlansApi#proxyDELETERatePlan");
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

<a name="proxyGETRatePlan"></a>
# **proxyGETRatePlan**
> ProxyGetRatePlan proxyGETRatePlan(id, fields)

CRUD: Retrieve RatePlan



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RatePlansApi;


RatePlansApi apiInstance = new RatePlansApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetRatePlan result = apiInstance.proxyGETRatePlan(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RatePlansApi#proxyGETRatePlan");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetRatePlan**](ProxyGetRatePlan.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

