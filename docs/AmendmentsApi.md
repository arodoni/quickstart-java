# AmendmentsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gETAmendment**](AmendmentsApi.md#gETAmendment) | **GET** /amendments/{amendment-key} | Get amendments by key
[**gETAmendmentsBySubscriptionID**](AmendmentsApi.md#gETAmendmentsBySubscriptionID) | **GET** /amendments/subscriptions/{subscription-id} | Get amendments by subscription ID
[**proxyDELETEAmendment**](AmendmentsApi.md#proxyDELETEAmendment) | **DELETE** /object/amendment/{id} | CRUD: Delete Amendment
[**proxyGETAmendment**](AmendmentsApi.md#proxyGETAmendment) | **GET** /object/amendment/{id} | CRUD: Retrieve Amendment
[**proxyPOSTAmendment**](AmendmentsApi.md#proxyPOSTAmendment) | **POST** /object/amendment | CRUD: Create Amendment
[**proxyPUTAmendment**](AmendmentsApi.md#proxyPUTAmendment) | **PUT** /object/amendment/{id} | CRUD: Update Amendment


<a name="gETAmendment"></a>
# **gETAmendment**
> GETAmendmentType gETAmendment(amendmentKey)

Get amendments by key

Retrieves detailed information about the specified subscription amendment.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AmendmentsApi;


AmendmentsApi apiInstance = new AmendmentsApi();
String amendmentKey = "amendmentKey_example"; // String | Can be the amendment ID or the amendment code.
try {
    GETAmendmentType result = apiInstance.gETAmendment(amendmentKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AmendmentsApi#gETAmendment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **amendmentKey** | **String**| Can be the amendment ID or the amendment code. |

### Return type

[**GETAmendmentType**](GETAmendmentType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETAmendmentsBySubscriptionID"></a>
# **gETAmendmentsBySubscriptionID**
> GETAmendmentType gETAmendmentsBySubscriptionID(subscriptionId)

Get amendments by subscription ID

Retrieves detailed information about the amendment with the specified subscription.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AmendmentsApi;


AmendmentsApi apiInstance = new AmendmentsApi();
String subscriptionId = "subscriptionId_example"; // String | The ID of the subscription whose amendment changes you want to retrieve.
try {
    GETAmendmentType result = apiInstance.gETAmendmentsBySubscriptionID(subscriptionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AmendmentsApi#gETAmendmentsBySubscriptionID");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscriptionId** | **String**| The ID of the subscription whose amendment changes you want to retrieve. |

### Return type

[**GETAmendmentType**](GETAmendmentType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyDELETEAmendment"></a>
# **proxyDELETEAmendment**
> ProxyDeleteResponse proxyDELETEAmendment(id)

CRUD: Delete Amendment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AmendmentsApi;


AmendmentsApi apiInstance = new AmendmentsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEAmendment(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AmendmentsApi#proxyDELETEAmendment");
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

<a name="proxyGETAmendment"></a>
# **proxyGETAmendment**
> ProxyGetAmendment proxyGETAmendment(id, fields)

CRUD: Retrieve Amendment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AmendmentsApi;


AmendmentsApi apiInstance = new AmendmentsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetAmendment result = apiInstance.proxyGETAmendment(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AmendmentsApi#proxyGETAmendment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetAmendment**](ProxyGetAmendment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPOSTAmendment"></a>
# **proxyPOSTAmendment**
> ProxyCreateOrModifyResponse proxyPOSTAmendment(createRequest)

CRUD: Create Amendment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AmendmentsApi;


AmendmentsApi apiInstance = new AmendmentsApi();
ProxyCreateAmendment createRequest = new ProxyCreateAmendment(); // ProxyCreateAmendment | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPOSTAmendment(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AmendmentsApi#proxyPOSTAmendment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyCreateAmendment**](ProxyCreateAmendment.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPUTAmendment"></a>
# **proxyPUTAmendment**
> ProxyCreateOrModifyResponse proxyPUTAmendment(id, modifyRequest)

CRUD: Update Amendment



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AmendmentsApi;


AmendmentsApi apiInstance = new AmendmentsApi();
String id = "id_example"; // String | Object id
ProxyModifyAmendment modifyRequest = new ProxyModifyAmendment(); // ProxyModifyAmendment | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPUTAmendment(id, modifyRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AmendmentsApi#proxyPUTAmendment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **modifyRequest** | [**ProxyModifyAmendment**](ProxyModifyAmendment.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

