# RSASignaturesApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**pOSTDecryptResponse**](RSASignaturesApi.md#pOSTDecryptResponse) | **POST** /rsa-signatures/decrypt | Decrypt RSA signature
[**pOSTRSASignature**](RSASignaturesApi.md#pOSTRSASignature) | **POST** /rsa-signatures | Generate RSA signature


<a name="pOSTDecryptResponse"></a>
# **pOSTDecryptResponse**
> POSTDecryptResponseType pOSTDecryptResponse(request)

Decrypt RSA signature

 The REST API used in Payment Pages 2.0 are CORS (Cross-Origin Resource Sharing) enabled and therefore requires a digital signature. You use rsa_signatures to generate the required digital signature and token for a Payment Pages 2.0 form, and then you use the decrypt REST service to decrypt the signature to validate the signature and key.  This REST service should be used only when you implement Payment Pages 2.0.  

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RSASignaturesApi;


RSASignaturesApi apiInstance = new RSASignaturesApi();
POSTDecryptionType request = new POSTDecryptionType(); // POSTDecryptionType | 
try {
    POSTDecryptResponseType result = apiInstance.pOSTDecryptResponse(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RSASignaturesApi#pOSTDecryptResponse");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**POSTDecryptionType**](POSTDecryptionType.md)|  |

### Return type

[**POSTDecryptResponseType**](POSTDecryptResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pOSTRSASignature"></a>
# **pOSTRSASignature**
> POSTRSASignatureResponseType pOSTRSASignature(request)

Generate RSA signature

 The REST API used in Payment Pages 2.0 are CORS (Cross-Origin Resource Sharing) enabled and therefore requires a digital signature. The POST rsa_signatures call generates and returns the required digital signature and token for a Payment Pages 2.0 form. You need to pass the generated signature to your client for it to access Payment Pages 2.0.     This REST service should be used only when you implement Payment Pages 2.0.  

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RSASignaturesApi;


RSASignaturesApi apiInstance = new RSASignaturesApi();
POSTRSASignatureType request = new POSTRSASignatureType(); // POSTRSASignatureType | 
try {
    POSTRSASignatureResponseType result = apiInstance.pOSTRSASignature(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RSASignaturesApi#pOSTRSASignature");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**POSTRSASignatureType**](POSTRSASignatureType.md)|  |

### Return type

[**POSTRSASignatureResponseType**](POSTRSASignatureResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

