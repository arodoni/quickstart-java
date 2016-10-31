# ProductRatePlanChargeTiersApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEProductRatePlanChargeTier**](ProductRatePlanChargeTiersApi.md#proxyDELETEProductRatePlanChargeTier) | **DELETE** /object/product-rate-plan-charge-tier/{id} | CRUD: Delete ProductRatePlanChargeTier
[**proxyGETProductRatePlanChargeTier**](ProductRatePlanChargeTiersApi.md#proxyGETProductRatePlanChargeTier) | **GET** /object/product-rate-plan-charge-tier/{id} | CRUD: Retrieve ProductRatePlanChargeTier


<a name="proxyDELETEProductRatePlanChargeTier"></a>
# **proxyDELETEProductRatePlanChargeTier**
> ProxyDeleteResponse proxyDELETEProductRatePlanChargeTier(id)

CRUD: Delete ProductRatePlanChargeTier



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductRatePlanChargeTiersApi;


ProductRatePlanChargeTiersApi apiInstance = new ProductRatePlanChargeTiersApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEProductRatePlanChargeTier(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductRatePlanChargeTiersApi#proxyDELETEProductRatePlanChargeTier");
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

<a name="proxyGETProductRatePlanChargeTier"></a>
# **proxyGETProductRatePlanChargeTier**
> ProxyGetProductRatePlanChargeTier proxyGETProductRatePlanChargeTier(id, fields)

CRUD: Retrieve ProductRatePlanChargeTier



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductRatePlanChargeTiersApi;


ProductRatePlanChargeTiersApi apiInstance = new ProductRatePlanChargeTiersApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetProductRatePlanChargeTier result = apiInstance.proxyGETProductRatePlanChargeTier(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductRatePlanChargeTiersApi#proxyGETProductRatePlanChargeTier");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetProductRatePlanChargeTier**](ProxyGetProductRatePlanChargeTier.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

