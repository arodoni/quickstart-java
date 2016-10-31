# CreditBalanceAdjustmentsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETECreditBalanceAdjustment**](CreditBalanceAdjustmentsApi.md#proxyDELETECreditBalanceAdjustment) | **DELETE** /object/credit-balance-adjustment/{id} | CRUD: Delete CreditBalanceAdjustment
[**proxyGETCreditBalanceAdjustment**](CreditBalanceAdjustmentsApi.md#proxyGETCreditBalanceAdjustment) | **GET** /object/credit-balance-adjustment/{id} | CRUD: Retrieve CreditBalanceAdjustment


<a name="proxyDELETECreditBalanceAdjustment"></a>
# **proxyDELETECreditBalanceAdjustment**
> ProxyDeleteResponse proxyDELETECreditBalanceAdjustment(id)

CRUD: Delete CreditBalanceAdjustment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CreditBalanceAdjustmentsApi;


CreditBalanceAdjustmentsApi apiInstance = new CreditBalanceAdjustmentsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETECreditBalanceAdjustment(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CreditBalanceAdjustmentsApi#proxyDELETECreditBalanceAdjustment");
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

<a name="proxyGETCreditBalanceAdjustment"></a>
# **proxyGETCreditBalanceAdjustment**
> ProxyGetCreditBalanceAdjustment proxyGETCreditBalanceAdjustment(id, fields)

CRUD: Retrieve CreditBalanceAdjustment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CreditBalanceAdjustmentsApi;


CreditBalanceAdjustmentsApi apiInstance = new CreditBalanceAdjustmentsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetCreditBalanceAdjustment result = apiInstance.proxyGETCreditBalanceAdjustment(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CreditBalanceAdjustmentsApi#proxyGETCreditBalanceAdjustment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetCreditBalanceAdjustment**](ProxyGetCreditBalanceAdjustment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

