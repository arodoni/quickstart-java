# GetFilesApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gETFiles**](GetFilesApi.md#gETFiles) | **GET** /files/{file-id} | Get files


<a name="gETFiles"></a>
# **gETFiles**
> gETFiles(fileId)

Get files

Retrieve a file by specifying its file ID. You can retrieve accounting period reports, such as the Revenue Detail report, as well as other files such as invoice PDFs.  ## Example  &#x60;&#x60;&#x60;curl curl -i -k -H \&quot;apiAccessKeyId:$USER_NAME\&quot; -H \&quot;apiSecretAccessKey:$PASSWORD\&quot; -H \&quot;Accept:application/pdf\&quot; -X GET https://apisandbox-api.zuora.com/rest/v1/files/2c92c08c55534cf00155581fb474314d -o /Users/jsmith/Downloads/invoiceFile1.pdf &#x60;&#x60;&#x60; The invoice PDF is downloaded to /Users/jsmith/Downloads and named invoiceFile1.pdf.  ## File Size Limitation The maximum export file size is 2047MB. If you have large data requests that go over this limit, you will get the following 403 HTTP response code from Zuora.  &#x60;&lt;security:max-object-size&gt;2047MB&lt;/security:max-object-size&gt;&#x60;  Submit a request at [Zuora Global Support](https://zuora.zendesk.com/agent/) if you require additional assistance.  We can work with you to determine if large file optimization is an option for you. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GetFilesApi;


GetFilesApi apiInstance = new GetFilesApi();
String fileId = "fileId_example"; // String | The Zuora ID of the file you want to retrieve.  See [Get Accounting Period](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Accounting_Periods/Get_Accounting_Period) for getting file IDs of accounting period reports, such as the Revenue Detail report. 
try {
    apiInstance.gETFiles(fileId);
} catch (ApiException e) {
    System.err.println("Exception when calling GetFilesApi#gETFiles");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileId** | **String**| The Zuora ID of the file you want to retrieve.  See [Get Accounting Period](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Accounting_Periods/Get_Accounting_Period) for getting file IDs of accounting period reports, such as the Revenue Detail report.  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

