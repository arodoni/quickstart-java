# InvoiceAdjustmentsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEInvoiceAdjustment**](InvoiceAdjustmentsApi.md#proxyDELETEInvoiceAdjustment) | **DELETE** /object/invoice-adjustment/{id} | CRUD: Delete InvoiceAdjustment
[**proxyGETInvoiceAdjustment**](InvoiceAdjustmentsApi.md#proxyGETInvoiceAdjustment) | **GET** /object/invoice-adjustment/{id} | CRUD: Retrieve InvoiceAdjustment
[**proxyPOSTInvoiceAdjustment**](InvoiceAdjustmentsApi.md#proxyPOSTInvoiceAdjustment) | **POST** /object/invoice-adjustment | CRUD: Create InvoiceAdjustment
[**proxyPUTInvoiceAdjustment**](InvoiceAdjustmentsApi.md#proxyPUTInvoiceAdjustment) | **PUT** /object/invoice-adjustment/{id} | CRUD: Update InvoiceAdjustment


<a name="proxyDELETEInvoiceAdjustment"></a>
# **proxyDELETEInvoiceAdjustment**
> ProxyDeleteResponse proxyDELETEInvoiceAdjustment(id)

CRUD: Delete InvoiceAdjustment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoiceAdjustmentsApi;


InvoiceAdjustmentsApi apiInstance = new InvoiceAdjustmentsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEInvoiceAdjustment(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoiceAdjustmentsApi#proxyDELETEInvoiceAdjustment");
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

<a name="proxyGETInvoiceAdjustment"></a>
# **proxyGETInvoiceAdjustment**
> ProxyGetInvoiceAdjustment proxyGETInvoiceAdjustment(id, fields)

CRUD: Retrieve InvoiceAdjustment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoiceAdjustmentsApi;


InvoiceAdjustmentsApi apiInstance = new InvoiceAdjustmentsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetInvoiceAdjustment result = apiInstance.proxyGETInvoiceAdjustment(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoiceAdjustmentsApi#proxyGETInvoiceAdjustment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetInvoiceAdjustment**](ProxyGetInvoiceAdjustment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPOSTInvoiceAdjustment"></a>
# **proxyPOSTInvoiceAdjustment**
> ProxyCreateOrModifyResponse proxyPOSTInvoiceAdjustment(createRequest)

CRUD: Create InvoiceAdjustment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoiceAdjustmentsApi;


InvoiceAdjustmentsApi apiInstance = new InvoiceAdjustmentsApi();
ProxyCreateInvoiceAdjustment createRequest = new ProxyCreateInvoiceAdjustment(); // ProxyCreateInvoiceAdjustment | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPOSTInvoiceAdjustment(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoiceAdjustmentsApi#proxyPOSTInvoiceAdjustment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyCreateInvoiceAdjustment**](ProxyCreateInvoiceAdjustment.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPUTInvoiceAdjustment"></a>
# **proxyPUTInvoiceAdjustment**
> ProxyCreateOrModifyResponse proxyPUTInvoiceAdjustment(id, modifyRequest)

CRUD: Update InvoiceAdjustment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoiceAdjustmentsApi;


InvoiceAdjustmentsApi apiInstance = new InvoiceAdjustmentsApi();
String id = "id_example"; // String | Object id
ProxyModifyInvoiceAdjustment modifyRequest = new ProxyModifyInvoiceAdjustment(); // ProxyModifyInvoiceAdjustment | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPUTInvoiceAdjustment(id, modifyRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoiceAdjustmentsApi#proxyPUTInvoiceAdjustment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **modifyRequest** | [**ProxyModifyInvoiceAdjustment**](ProxyModifyInvoiceAdjustment.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

