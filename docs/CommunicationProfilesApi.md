# CommunicationProfilesApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETECommunicationProfile**](CommunicationProfilesApi.md#proxyDELETECommunicationProfile) | **DELETE** /object/communication-profile/{id} | CRUD: Delete CommunicationProfile
[**proxyGETCommunicationProfile**](CommunicationProfilesApi.md#proxyGETCommunicationProfile) | **GET** /object/communication-profile/{id} | CRUD: Retrieve CommunicationProfile


<a name="proxyDELETECommunicationProfile"></a>
# **proxyDELETECommunicationProfile**
> ProxyDeleteResponse proxyDELETECommunicationProfile(id)

CRUD: Delete CommunicationProfile



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CommunicationProfilesApi;


CommunicationProfilesApi apiInstance = new CommunicationProfilesApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETECommunicationProfile(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommunicationProfilesApi#proxyDELETECommunicationProfile");
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

<a name="proxyGETCommunicationProfile"></a>
# **proxyGETCommunicationProfile**
> ProxyGetCommunicationProfile proxyGETCommunicationProfile(id, fields)

CRUD: Retrieve CommunicationProfile



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CommunicationProfilesApi;


CommunicationProfilesApi apiInstance = new CommunicationProfilesApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetCommunicationProfile result = apiInstance.proxyGETCommunicationProfile(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommunicationProfilesApi#proxyGETCommunicationProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetCommunicationProfile**](ProxyGetCommunicationProfile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

