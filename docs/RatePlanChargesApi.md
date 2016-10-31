# RatePlanChargesApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETERatePlanCharge**](RatePlanChargesApi.md#proxyDELETERatePlanCharge) | **DELETE** /object/rate-plan-charge/{id} | CRUD: Delete RatePlanCharge
[**proxyGETRatePlanCharge**](RatePlanChargesApi.md#proxyGETRatePlanCharge) | **GET** /object/rate-plan-charge/{id} | CRUD: Retrieve RatePlanCharge


<a name="proxyDELETERatePlanCharge"></a>
# **proxyDELETERatePlanCharge**
> ProxyDeleteResponse proxyDELETERatePlanCharge(id)

CRUD: Delete RatePlanCharge



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RatePlanChargesApi;


RatePlanChargesApi apiInstance = new RatePlanChargesApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETERatePlanCharge(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RatePlanChargesApi#proxyDELETERatePlanCharge");
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

<a name="proxyGETRatePlanCharge"></a>
# **proxyGETRatePlanCharge**
> ProxyGetRatePlanCharge proxyGETRatePlanCharge(id, fields)

CRUD: Retrieve RatePlanCharge



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RatePlanChargesApi;


RatePlanChargesApi apiInstance = new RatePlanChargesApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetRatePlanCharge result = apiInstance.proxyGETRatePlanCharge(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RatePlanChargesApi#proxyGETRatePlanCharge");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetRatePlanCharge**](ProxyGetRatePlanCharge.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

