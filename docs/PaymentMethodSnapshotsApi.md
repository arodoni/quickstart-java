# PaymentMethodSnapshotsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEPaymentMethodSnapshot**](PaymentMethodSnapshotsApi.md#proxyDELETEPaymentMethodSnapshot) | **DELETE** /object/payment-method-snapshot/{id} | CRUD: Delete PaymentMethodSnapshot
[**proxyGETPaymentMethodSnapshot**](PaymentMethodSnapshotsApi.md#proxyGETPaymentMethodSnapshot) | **GET** /object/payment-method-snapshot/{id} | CRUD: Retrieve PaymentMethodSnapshot


<a name="proxyDELETEPaymentMethodSnapshot"></a>
# **proxyDELETEPaymentMethodSnapshot**
> ProxyDeleteResponse proxyDELETEPaymentMethodSnapshot(id)

CRUD: Delete PaymentMethodSnapshot



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentMethodSnapshotsApi;


PaymentMethodSnapshotsApi apiInstance = new PaymentMethodSnapshotsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEPaymentMethodSnapshot(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentMethodSnapshotsApi#proxyDELETEPaymentMethodSnapshot");
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

<a name="proxyGETPaymentMethodSnapshot"></a>
# **proxyGETPaymentMethodSnapshot**
> ProxyGetPaymentMethodSnapshot proxyGETPaymentMethodSnapshot(id, fields)

CRUD: Retrieve PaymentMethodSnapshot



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PaymentMethodSnapshotsApi;


PaymentMethodSnapshotsApi apiInstance = new PaymentMethodSnapshotsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetPaymentMethodSnapshot result = apiInstance.proxyGETPaymentMethodSnapshot(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentMethodSnapshotsApi#proxyGETPaymentMethodSnapshot");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetPaymentMethodSnapshot**](ProxyGetPaymentMethodSnapshot.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

