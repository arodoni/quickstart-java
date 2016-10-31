# RefundsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETERefund**](RefundsApi.md#proxyDELETERefund) | **DELETE** /object/refund/{id} | CRUD: Delete Refund
[**proxyGETRefund**](RefundsApi.md#proxyGETRefund) | **GET** /object/refund/{id} | CRUD: Retrieve Refund
[**proxyPOSTRefund**](RefundsApi.md#proxyPOSTRefund) | **POST** /object/refund | CRUD: Create Refund
[**proxyPUTRefund**](RefundsApi.md#proxyPUTRefund) | **PUT** /object/refund/{id} | CRUD: Update Refund


<a name="proxyDELETERefund"></a>
# **proxyDELETERefund**
> ProxyDeleteResponse proxyDELETERefund(id)

CRUD: Delete Refund



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RefundsApi;


RefundsApi apiInstance = new RefundsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETERefund(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RefundsApi#proxyDELETERefund");
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

<a name="proxyGETRefund"></a>
# **proxyGETRefund**
> ProxyGetRefund proxyGETRefund(id, fields)

CRUD: Retrieve Refund



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RefundsApi;


RefundsApi apiInstance = new RefundsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetRefund result = apiInstance.proxyGETRefund(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RefundsApi#proxyGETRefund");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetRefund**](ProxyGetRefund.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPOSTRefund"></a>
# **proxyPOSTRefund**
> ProxyCreateOrModifyResponse proxyPOSTRefund(createRequest)

CRUD: Create Refund



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RefundsApi;


RefundsApi apiInstance = new RefundsApi();
ProxyCreateRefund createRequest = new ProxyCreateRefund(); // ProxyCreateRefund | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPOSTRefund(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RefundsApi#proxyPOSTRefund");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyCreateRefund**](ProxyCreateRefund.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPUTRefund"></a>
# **proxyPUTRefund**
> ProxyCreateOrModifyResponse proxyPUTRefund(id, modifyRequest)

CRUD: Update Refund



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RefundsApi;


RefundsApi apiInstance = new RefundsApi();
String id = "id_example"; // String | Object id
ProxyModifyRefund modifyRequest = new ProxyModifyRefund(); // ProxyModifyRefund | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPUTRefund(id, modifyRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RefundsApi#proxyPUTRefund");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **modifyRequest** | [**ProxyModifyRefund**](ProxyModifyRefund.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

