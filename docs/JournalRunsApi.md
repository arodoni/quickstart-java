# JournalRunsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**dELETEJournalRun**](JournalRunsApi.md#dELETEJournalRun) | **DELETE** /journal-runs/{jr-number} | Delete journal run
[**gETJournalRun**](JournalRunsApi.md#gETJournalRun) | **GET** /journal-runs/{jr-number} | Get journal run
[**pOSTJournalRun**](JournalRunsApi.md#pOSTJournalRun) | **POST** /journal-runs | Create journal run
[**pUTJournalRun**](JournalRunsApi.md#pUTJournalRun) | **PUT** /journal-runs/{jr-number}/cancel | Cancel journal run


<a name="dELETEJournalRun"></a>
# **dELETEJournalRun**
> CommonResponseType dELETEJournalRun(jrNumber)

Delete journal run

This reference describes how to delete a journal run using the REST API.                         You can only delete journal runs that have already been canceled. See [Cancel Journal Run](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Journal_Runs/Cancel_Journal_Run) for more information.                         You must have the \&quot;Delete Cancelled Journal Run\&quot; [Z-Finance user permission](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles) enabled to delete journal runs. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.JournalRunsApi;


JournalRunsApi apiInstance = new JournalRunsApi();
String jrNumber = "jrNumber_example"; // String | Journal run number. Must be a valid journal run number in the format `JR-00000001`. 
try {
    CommonResponseType result = apiInstance.dELETEJournalRun(jrNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JournalRunsApi#dELETEJournalRun");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jrNumber** | **String**| Journal run number. Must be a valid journal run number in the format &#x60;JR-00000001&#x60;.  |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETJournalRun"></a>
# **gETJournalRun**
> GETJournalRunType gETJournalRun(jrNumber)

Get journal run

This REST API reference describes how to get information about a journal run. Request and response field descriptions and sample code are provided. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.JournalRunsApi;


JournalRunsApi apiInstance = new JournalRunsApi();
String jrNumber = "jrNumber_example"; // String | Journal run number. Must be a valid journal run number in the format `JR-00000001`. 
try {
    GETJournalRunType result = apiInstance.gETJournalRun(jrNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JournalRunsApi#gETJournalRun");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jrNumber** | **String**| Journal run number. Must be a valid journal run number in the format &#x60;JR-00000001&#x60;.  |

### Return type

[**GETJournalRunType**](GETJournalRunType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pOSTJournalRun"></a>
# **pOSTJournalRun**
> POSTJournalRunResponseType pOSTJournalRun(request)

Create journal run

This REST API reference describes how to create a journal run. Request and response field descriptions and sample code are provided. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.JournalRunsApi;


JournalRunsApi apiInstance = new JournalRunsApi();
POSTJournalRunType request = new POSTJournalRunType(); // POSTJournalRunType | 
try {
    POSTJournalRunResponseType result = apiInstance.pOSTJournalRun(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JournalRunsApi#pOSTJournalRun");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**POSTJournalRunType**](POSTJournalRunType.md)|  |

### Return type

[**POSTJournalRunResponseType**](POSTJournalRunResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTJournalRun"></a>
# **pUTJournalRun**
> CommonResponseType pUTJournalRun(jrNumber)

Cancel journal run

This reference describes how to cancel a journal run using the REST API.            The summary journal entries in the journal run are canceled asynchronously. See the \&quot;Example\&quot; section below for details.            You must have the \&quot;Cancel Journal Run\&quot; [Z-Finance user permission](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/Administrator_Settings/User_Roles/Z-Finance_Roles) enabled to cancel journal runs.  ## Notes When you cancel a journal run, the summary journal entries associated with that journal run are canceled asynchronously. A response of &#x60;{ \&quot;success\&quot;: true }&#x60; means only that the specified journal run has a status of \&quot;Pending\&quot;, \&quot;Error\&quot;, or \&quot;Completed\&quot; and therefore can be canceled, but does not mean that the whole journal run was successfully canceled.  For example, let&#39;s say you want to cancel journal run JR-00000075. The journal run status is \&quot;Completed\&quot; and it contains ten journal entries. One of the journal entries has its Transferred to Accounting status set to \&quot;Yes\&quot;, meaning that the entry cannot be canceled. The workflow might go as follows: 1. You make an API call to cancel the journal run. 2. The journal run status is \&quot;Completed\&quot;, so you receive a response of &#x60;{ \&quot;success\&quot;: true }&#x60;. 3. Zuora begins asynchronously canceling journal entries associated with the journal run. The journal entry whose Transferred to Accounting status is \&quot;Yes\&quot; fails to be canceled. The cancelation process continues, and the other journal entries are successfully canceled. 4. The journal run status remains as \&quot;Completed\&quot;. The status does not change to \&quot;Canceled\&quot; because the journal run still contains a journey entry that is not canceled. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.JournalRunsApi;


JournalRunsApi apiInstance = new JournalRunsApi();
String jrNumber = "jrNumber_example"; // String | Journal run number. Must be a valid journal run number in the format JR-00000001.  You can only cancel a journal run whose status is \"Pending\", \"Error\", or \"Completed\". 
try {
    CommonResponseType result = apiInstance.pUTJournalRun(jrNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JournalRunsApi#pUTJournalRun");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jrNumber** | **String**| Journal run number. Must be a valid journal run number in the format JR-00000001.  You can only cancel a journal run whose status is \&quot;Pending\&quot;, \&quot;Error\&quot;, or \&quot;Completed\&quot;.  |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

