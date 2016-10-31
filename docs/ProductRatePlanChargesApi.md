# ProductRatePlanChargesApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEProductRatePlanCharge**](ProductRatePlanChargesApi.md#proxyDELETEProductRatePlanCharge) | **DELETE** /object/product-rate-plan-charge/{id} | CRUD: Delete ProductRatePlanCharge
[**proxyGETProductRatePlanCharge**](ProductRatePlanChargesApi.md#proxyGETProductRatePlanCharge) | **GET** /object/product-rate-plan-charge/{id} | CRUD: Retrieve ProductRatePlanCharge


<a name="proxyDELETEProductRatePlanCharge"></a>
# **proxyDELETEProductRatePlanCharge**
> ProxyDeleteResponse proxyDELETEProductRatePlanCharge(id)

CRUD: Delete ProductRatePlanCharge



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductRatePlanChargesApi;


ProductRatePlanChargesApi apiInstance = new ProductRatePlanChargesApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEProductRatePlanCharge(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductRatePlanChargesApi#proxyDELETEProductRatePlanCharge");
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

<a name="proxyGETProductRatePlanCharge"></a>
# **proxyGETProductRatePlanCharge**
> ProxyGetProductRatePlanCharge proxyGETProductRatePlanCharge(id, fields)

CRUD: Retrieve ProductRatePlanCharge



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductRatePlanChargesApi;


ProductRatePlanChargesApi apiInstance = new ProductRatePlanChargesApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetProductRatePlanCharge result = apiInstance.proxyGETProductRatePlanCharge(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductRatePlanChargesApi#proxyGETProductRatePlanCharge");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetProductRatePlanCharge**](ProxyGetProductRatePlanCharge.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

