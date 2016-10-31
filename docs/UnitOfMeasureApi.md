# UnitOfMeasureApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEUnitOfMeasure**](UnitOfMeasureApi.md#proxyDELETEUnitOfMeasure) | **DELETE** /object/unit-of-measure/{id} | CRUD: Delete UnitOfMeasure
[**proxyGETUnitOfMeasure**](UnitOfMeasureApi.md#proxyGETUnitOfMeasure) | **GET** /object/unit-of-measure/{id} | CRUD: Retrieve UnitOfMeasure
[**proxyPOSTUnitOfMeasure**](UnitOfMeasureApi.md#proxyPOSTUnitOfMeasure) | **POST** /object/unit-of-measure | CRUD: Create UnitOfMeasure
[**proxyPUTUnitOfMeasure**](UnitOfMeasureApi.md#proxyPUTUnitOfMeasure) | **PUT** /object/unit-of-measure/{id} | CRUD: Update UnitOfMeasure


<a name="proxyDELETEUnitOfMeasure"></a>
# **proxyDELETEUnitOfMeasure**
> ProxyDeleteResponse proxyDELETEUnitOfMeasure(id)

CRUD: Delete UnitOfMeasure



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UnitOfMeasureApi;


UnitOfMeasureApi apiInstance = new UnitOfMeasureApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEUnitOfMeasure(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UnitOfMeasureApi#proxyDELETEUnitOfMeasure");
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

<a name="proxyGETUnitOfMeasure"></a>
# **proxyGETUnitOfMeasure**
> ProxyGetUnitOfMeasure proxyGETUnitOfMeasure(id, fields)

CRUD: Retrieve UnitOfMeasure



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UnitOfMeasureApi;


UnitOfMeasureApi apiInstance = new UnitOfMeasureApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetUnitOfMeasure result = apiInstance.proxyGETUnitOfMeasure(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UnitOfMeasureApi#proxyGETUnitOfMeasure");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetUnitOfMeasure**](ProxyGetUnitOfMeasure.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPOSTUnitOfMeasure"></a>
# **proxyPOSTUnitOfMeasure**
> ProxyCreateOrModifyResponse proxyPOSTUnitOfMeasure(createRequest)

CRUD: Create UnitOfMeasure



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UnitOfMeasureApi;


UnitOfMeasureApi apiInstance = new UnitOfMeasureApi();
ProxyCreateUnitOfMeasure createRequest = new ProxyCreateUnitOfMeasure(); // ProxyCreateUnitOfMeasure | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPOSTUnitOfMeasure(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UnitOfMeasureApi#proxyPOSTUnitOfMeasure");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyCreateUnitOfMeasure**](ProxyCreateUnitOfMeasure.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPUTUnitOfMeasure"></a>
# **proxyPUTUnitOfMeasure**
> ProxyCreateOrModifyResponse proxyPUTUnitOfMeasure(id, modifyRequest)

CRUD: Update UnitOfMeasure



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UnitOfMeasureApi;


UnitOfMeasureApi apiInstance = new UnitOfMeasureApi();
String id = "id_example"; // String | Object id
ProxyModifyUnitOfMeasure modifyRequest = new ProxyModifyUnitOfMeasure(); // ProxyModifyUnitOfMeasure | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPUTUnitOfMeasure(id, modifyRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UnitOfMeasureApi#proxyPUTUnitOfMeasure");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **modifyRequest** | [**ProxyModifyUnitOfMeasure**](ProxyModifyUnitOfMeasure.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

