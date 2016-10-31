# RatePlanChargeTiersApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETERatePlanChargeTier**](RatePlanChargeTiersApi.md#proxyDELETERatePlanChargeTier) | **DELETE** /object/rate-plan-charge-tier/{id} | CRUD: Delete RatePlanChargeTier
[**proxyGETRatePlanChargeTier**](RatePlanChargeTiersApi.md#proxyGETRatePlanChargeTier) | **GET** /object/rate-plan-charge-tier/{id} | CRUD: Retrieve RatePlanChargeTier


<a name="proxyDELETERatePlanChargeTier"></a>
# **proxyDELETERatePlanChargeTier**
> ProxyDeleteResponse proxyDELETERatePlanChargeTier(id)

CRUD: Delete RatePlanChargeTier



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RatePlanChargeTiersApi;


RatePlanChargeTiersApi apiInstance = new RatePlanChargeTiersApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETERatePlanChargeTier(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RatePlanChargeTiersApi#proxyDELETERatePlanChargeTier");
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

<a name="proxyGETRatePlanChargeTier"></a>
# **proxyGETRatePlanChargeTier**
> ProxyGetRatePlanChargeTier proxyGETRatePlanChargeTier(id, fields)

CRUD: Retrieve RatePlanChargeTier



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RatePlanChargeTiersApi;


RatePlanChargeTiersApi apiInstance = new RatePlanChargeTiersApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetRatePlanChargeTier result = apiInstance.proxyGETRatePlanChargeTier(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RatePlanChargeTiersApi#proxyGETRatePlanChargeTier");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetRatePlanChargeTier**](ProxyGetRatePlanChargeTier.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

