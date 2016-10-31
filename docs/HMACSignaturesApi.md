# HMACSignaturesApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**pOSTHMACSignature**](HMACSignaturesApi.md#pOSTHMACSignature) | **POST** /hmac-signatures | Return HMAC signatures


<a name="pOSTHMACSignature"></a>
# **pOSTHMACSignature**
> POSTHMACSignatureResponseType pOSTHMACSignature(request)

Return HMAC signatures

This REST API reference describes how to return unique signature and token values that used to process a [CORS enabled API call](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/G_CORS_REST). 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.HMACSignaturesApi;


HMACSignaturesApi apiInstance = new HMACSignaturesApi();
POSTHMACSignatureType request = new POSTHMACSignatureType(); // POSTHMACSignatureType | 
try {
    POSTHMACSignatureResponseType result = apiInstance.pOSTHMACSignature(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling HMACSignaturesApi#pOSTHMACSignature");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**POSTHMACSignatureType**](POSTHMACSignatureType.md)|  |

### Return type

[**POSTHMACSignatureResponseType**](POSTHMACSignatureResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

