# InvoicePaymentsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEInvoicePayment**](InvoicePaymentsApi.md#proxyDELETEInvoicePayment) | **DELETE** /object/invoice-payment/{id} | CRUD: Delete InvoicePayment
[**proxyGETInvoicePayment**](InvoicePaymentsApi.md#proxyGETInvoicePayment) | **GET** /object/invoice-payment/{id} | CRUD: Retrieve InvoicePayment
[**proxyPOSTInvoicePayment**](InvoicePaymentsApi.md#proxyPOSTInvoicePayment) | **POST** /object/invoice-payment | CRUD: Create InvoicePayment
[**proxyPUTInvoicePayment**](InvoicePaymentsApi.md#proxyPUTInvoicePayment) | **PUT** /object/invoice-payment/{id} | CRUD: Update InvoicePayment


<a name="proxyDELETEInvoicePayment"></a>
# **proxyDELETEInvoicePayment**
> ProxyDeleteResponse proxyDELETEInvoicePayment(id)

CRUD: Delete InvoicePayment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoicePaymentsApi;


InvoicePaymentsApi apiInstance = new InvoicePaymentsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEInvoicePayment(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicePaymentsApi#proxyDELETEInvoicePayment");
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

<a name="proxyGETInvoicePayment"></a>
# **proxyGETInvoicePayment**
> ProxyGetInvoicePayment proxyGETInvoicePayment(id, fields)

CRUD: Retrieve InvoicePayment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoicePaymentsApi;


InvoicePaymentsApi apiInstance = new InvoicePaymentsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetInvoicePayment result = apiInstance.proxyGETInvoicePayment(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicePaymentsApi#proxyGETInvoicePayment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetInvoicePayment**](ProxyGetInvoicePayment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPOSTInvoicePayment"></a>
# **proxyPOSTInvoicePayment**
> ProxyCreateOrModifyResponse proxyPOSTInvoicePayment(createRequest)

CRUD: Create InvoicePayment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoicePaymentsApi;


InvoicePaymentsApi apiInstance = new InvoicePaymentsApi();
ProxyCreateInvoicePayment createRequest = new ProxyCreateInvoicePayment(); // ProxyCreateInvoicePayment | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPOSTInvoicePayment(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicePaymentsApi#proxyPOSTInvoicePayment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyCreateInvoicePayment**](ProxyCreateInvoicePayment.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPUTInvoicePayment"></a>
# **proxyPUTInvoicePayment**
> ProxyCreateOrModifyResponse proxyPUTInvoicePayment(id, modifyRequest)

CRUD: Update InvoicePayment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InvoicePaymentsApi;


InvoicePaymentsApi apiInstance = new InvoicePaymentsApi();
String id = "id_example"; // String | Object id
ProxyModifyInvoicePayment modifyRequest = new ProxyModifyInvoicePayment(); // ProxyModifyInvoicePayment | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPUTInvoicePayment(id, modifyRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicePaymentsApi#proxyPUTInvoicePayment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **modifyRequest** | [**ProxyModifyInvoicePayment**](ProxyModifyInvoicePayment.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

