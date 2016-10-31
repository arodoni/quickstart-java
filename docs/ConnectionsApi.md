# ConnectionsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**pOSTConnections**](ConnectionsApi.md#pOSTConnections) | **POST** /connections | Establish connection to Zuora REST API service


<a name="pOSTConnections"></a>
# **pOSTConnections**
> CommonResponseType pOSTConnections(apiAccessKeyId, apiSecretAccessKey, contentType)

Establish connection to Zuora REST API service

Establishes a connection to the Zuora REST API service based on a valid user credentials.  This call authenticates the user and returns an API session cookie that&#39;s used to authorize subsequent calls to the REST API. A call to &#x60;connections&#x60; is a required first step before using the Zuora REST API to access data.  The credentials must belong to a user account that has permission to access the API service.  As noted elsewhere, it&#39;s strongly recommended that an account used for Zuora API activity is never used to log into the Zuora UI.  Once an account is used to log into the UI, it may be subject to periodic forced password changes, which may eventually lead to authentication failures when using the API. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConnectionsApi;


ConnectionsApi apiInstance = new ConnectionsApi();
String apiAccessKeyId = "apiAccessKeyId_example"; // String | Account username 
String apiSecretAccessKey = "apiSecretAccessKey_example"; // String | Account password 
String contentType = "contentType_example"; // String | Must be set to \"application/json\" 
try {
    CommonResponseType result = apiInstance.pOSTConnections(apiAccessKeyId, apiSecretAccessKey, contentType);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectionsApi#pOSTConnections");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiAccessKeyId** | **String**| Account username  |
 **apiSecretAccessKey** | **String**| Account password  |
 **contentType** | **String**| Must be set to \&quot;application/json\&quot;  |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

