# TaxationItemsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETETaxationItem**](TaxationItemsApi.md#proxyDELETETaxationItem) | **DELETE** /object/taxation-item/{id} | CRUD: Delete TaxationItem
[**proxyGETTaxationItem**](TaxationItemsApi.md#proxyGETTaxationItem) | **GET** /object/taxation-item/{id} | CRUD: Retrieve TaxationItem
[**proxyPOSTTaxationItem**](TaxationItemsApi.md#proxyPOSTTaxationItem) | **POST** /object/taxation-item | CRUD: Create TaxationItem
[**proxyPUTTaxationItem**](TaxationItemsApi.md#proxyPUTTaxationItem) | **PUT** /object/taxation-item/{id} | CRUD: Update TaxationItem


<a name="proxyDELETETaxationItem"></a>
# **proxyDELETETaxationItem**
> ProxyDeleteResponse proxyDELETETaxationItem(id)

CRUD: Delete TaxationItem



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TaxationItemsApi;


TaxationItemsApi apiInstance = new TaxationItemsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETETaxationItem(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaxationItemsApi#proxyDELETETaxationItem");
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

<a name="proxyGETTaxationItem"></a>
# **proxyGETTaxationItem**
> ProxyGetTaxationItem proxyGETTaxationItem(id, fields)

CRUD: Retrieve TaxationItem



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TaxationItemsApi;


TaxationItemsApi apiInstance = new TaxationItemsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetTaxationItem result = apiInstance.proxyGETTaxationItem(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaxationItemsApi#proxyGETTaxationItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetTaxationItem**](ProxyGetTaxationItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPOSTTaxationItem"></a>
# **proxyPOSTTaxationItem**
> ProxyCreateOrModifyResponse proxyPOSTTaxationItem(createRequest)

CRUD: Create TaxationItem



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TaxationItemsApi;


TaxationItemsApi apiInstance = new TaxationItemsApi();
ProxyCreateTaxationItem createRequest = new ProxyCreateTaxationItem(); // ProxyCreateTaxationItem | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPOSTTaxationItem(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaxationItemsApi#proxyPOSTTaxationItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyCreateTaxationItem**](ProxyCreateTaxationItem.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPUTTaxationItem"></a>
# **proxyPUTTaxationItem**
> ProxyCreateOrModifyResponse proxyPUTTaxationItem(id, modifyRequest)

CRUD: Update TaxationItem



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TaxationItemsApi;


TaxationItemsApi apiInstance = new TaxationItemsApi();
String id = "id_example"; // String | Object id
ProxyModifyTaxationItem modifyRequest = new ProxyModifyTaxationItem(); // ProxyModifyTaxationItem | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPUTTaxationItem(id, modifyRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaxationItemsApi#proxyPUTTaxationItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **modifyRequest** | [**ProxyModifyTaxationItem**](ProxyModifyTaxationItem.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

