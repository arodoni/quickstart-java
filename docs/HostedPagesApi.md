# HostedPagesApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getHostedPages**](HostedPagesApi.md#getHostedPages) | **GET** /hostedpages | Return hosted pages


<a name="getHostedPages"></a>
# **getHostedPages**
> GetHostedPagesType getHostedPages(versionNumber)

Return hosted pages

The hostedpages call returns the Payment Pages configuration metadata, specifically, page ID, page version, payment method type.  The following are the version-specific and general REST requests for Payment Pages:  * The request for Payment Pages 1.0 configuration information: &#x60;GET &lt;BaseURL&gt;/hostedpages?version&#x3D;1&#x60; * The request for Payment Pages 2.0 configuration information: &#x60;GET &lt;BaseURL&gt;/hostedpages?version&#x3D;2&#x60; * The request for all versions of Payment Pages configuration information: &#x60;GET &lt;BaseURL&gt;/hostedpages&#x60;  ## Notes If you do not have the corresponding tenant setting enabled, e.g., the request &#x60;version&#x60; parameter set to 2 with the Payment Pages 2.0 setting disabled, you will receive an error. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.HostedPagesApi;


HostedPagesApi apiInstance = new HostedPagesApi();
String versionNumber = "versionNumber_example"; // String | Version of the Payment Pages for which you want to retrieve the configuration information. Specify 1 for Payment Pages 1.0 or 2 for Payment Pages 2.0. If omitted, information for all versions of Payment Pages are returned.  The response also depends on your tenant settings for Payment Pages 1.0 and Payment Pages 2.0. For example, if only the tenant setting for Payment Pages 2.0 is enabled, the response will only contain information for Payment Pages 2.0 forms even when this parameter is omitted. 
try {
    GetHostedPagesType result = apiInstance.getHostedPages(versionNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling HostedPagesApi#getHostedPages");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **versionNumber** | **String**| Version of the Payment Pages for which you want to retrieve the configuration information. Specify 1 for Payment Pages 1.0 or 2 for Payment Pages 2.0. If omitted, information for all versions of Payment Pages are returned.  The response also depends on your tenant settings for Payment Pages 1.0 and Payment Pages 2.0. For example, if only the tenant setting for Payment Pages 2.0 is enabled, the response will only contain information for Payment Pages 2.0 forms even when this parameter is omitted.  | [optional]

### Return type

[**GetHostedPagesType**](GetHostedPagesType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

