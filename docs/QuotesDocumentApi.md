# QuotesDocumentApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**pOSTQuoteDoc**](QuotesDocumentApi.md#pOSTQuoteDoc) | **POST** /quotes/document | Generate quotes document


<a name="pOSTQuoteDoc"></a>
# **pOSTQuoteDoc**
> POSTQuoteDocResponseType pOSTQuoteDoc(request)

Generate quotes document

The &#x60;document&#x60; call generates a quote document and returns the generated document URL. You can directly access the generated quote file through the returned URL.  The &#x60;document&#x60; call should be only used from Zuora Quotes.   ## File Size Limitation  The maximum export file size is 2047MB. If you have large data requests that go over this limit, you will get the following 403 HTTP response code from Zuora: &#x60;security:max-object-size&gt;2047MB&lt;/security:max-object-size&gt;&#x60;  Submit a request at [Zuora Global Support](http://support.zuora.com/) if you require additional assistance.  We can work with you to determine if large file optimization is an option for you. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.QuotesDocumentApi;


QuotesDocumentApi apiInstance = new QuotesDocumentApi();
POSTQuoteDocType request = new POSTQuoteDocType(); // POSTQuoteDocType | 
try {
    POSTQuoteDocResponseType result = apiInstance.pOSTQuoteDoc(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling QuotesDocumentApi#pOSTQuoteDoc");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**POSTQuoteDocType**](POSTQuoteDocType.md)|  |

### Return type

[**POSTQuoteDocResponseType**](POSTQuoteDocResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

