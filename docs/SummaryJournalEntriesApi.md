# SummaryJournalEntriesApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**dELETESummaryJournalEntry**](SummaryJournalEntriesApi.md#dELETESummaryJournalEntry) | **DELETE** /journal-entries/{je-number} | Delete summary journal entry
[**gETJournalEntriesInJournalRun**](SummaryJournalEntriesApi.md#gETJournalEntriesInJournalRun) | **GET** /journal-entries/journal-runs/{jr-number} | Get all summary journal entries in a journal run
[**gETJournalEntryDetail**](SummaryJournalEntriesApi.md#gETJournalEntryDetail) | **GET** /journal-entries/{je-number} | Get summary journal entry
[**pOSTJournalEntry**](SummaryJournalEntriesApi.md#pOSTJournalEntry) | **POST** /journal-entries | Create summary journal entry
[**pUTBasicSummaryJournalEntry**](SummaryJournalEntriesApi.md#pUTBasicSummaryJournalEntry) | **PUT** /journal-entries/{je-number}/basic-information | Update basic information of a summary journal entry
[**pUTSummaryJournalEntry**](SummaryJournalEntriesApi.md#pUTSummaryJournalEntry) | **PUT** /journal-entries/{je-number}/cancel | Cancel summary journal entry


<a name="dELETESummaryJournalEntry"></a>
# **dELETESummaryJournalEntry**
> CommonResponseType dELETESummaryJournalEntry(jeNumber)

Delete summary journal entry

This reference describes how to delete a summary journal entry using the REST API.  You must have the \&quot;Delete Cancelled Journal Entry\&quot; [Z-Finance user permission](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/Administrator_Settings/User_Roles/Z-Finance_Roles) enabled to delete summary journal entries.  A summary journal entry must be canceled before it can be deleted. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SummaryJournalEntriesApi;


SummaryJournalEntriesApi apiInstance = new SummaryJournalEntriesApi();
String jeNumber = "jeNumber_example"; // String | Journal entry number in the format JE-00000001.
try {
    CommonResponseType result = apiInstance.dELETESummaryJournalEntry(jeNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SummaryJournalEntriesApi#dELETESummaryJournalEntry");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jeNumber** | **String**| Journal entry number in the format JE-00000001. |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETJournalEntriesInJournalRun"></a>
# **gETJournalEntriesInJournalRun**
> GETJournalEntriesInJournalRunType gETJournalEntriesInJournalRun(jrNumber)

Get all summary journal entries in a journal run

 This REST API reference describes how to retrieve information about all summary journal entries in a journal run. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SummaryJournalEntriesApi;


SummaryJournalEntriesApi apiInstance = new SummaryJournalEntriesApi();
String jrNumber = "jrNumber_example"; // String | Journal run number.
try {
    GETJournalEntriesInJournalRunType result = apiInstance.gETJournalEntriesInJournalRun(jrNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SummaryJournalEntriesApi#gETJournalEntriesInJournalRun");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jrNumber** | **String**| Journal run number. |

### Return type

[**GETJournalEntriesInJournalRunType**](GETJournalEntriesInJournalRunType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETJournalEntryDetail"></a>
# **gETJournalEntryDetail**
> GETJournalEntryDetailType gETJournalEntryDetail(jeNumber)

Get summary journal entry

This REST API reference describes how to get information about a summary journal entry by its journal entry number. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SummaryJournalEntriesApi;


SummaryJournalEntriesApi apiInstance = new SummaryJournalEntriesApi();
String jeNumber = "jeNumber_example"; // String | 
try {
    GETJournalEntryDetailType result = apiInstance.gETJournalEntryDetail(jeNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SummaryJournalEntriesApi#gETJournalEntryDetail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jeNumber** | **String**|  |

### Return type

[**GETJournalEntryDetailType**](GETJournalEntryDetailType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pOSTJournalEntry"></a>
# **pOSTJournalEntry**
> POSTJournalEntryResponseType pOSTJournalEntry(request)

Create summary journal entry

This REST API reference describes how to manually create a summary journal entry. Request and response field descriptions and sample code are provided. ## Requirements 1.The sum of debits must equal the sum of credits in the summary journal entry.  2.The following applies only if you use foreign currency conversion:   * If you have configured [Aggregate transactions with different currencies during a Journal Run](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/C_Configure_accounting_rules#Aggregate_transactions_with_different_currencies_during_a_Journal_Run) to \&quot;Yes\&quot;, the value of the **currency** field must be the same as your tenant&#39;s home currency. That is, you must create journal entries using your home currency.   * All journal entries in an accounting period must either all be aggregated or all be unaggregated. You cannot have a mix of aggregated and unaggregated journal entries in the same accounting period.  See [Foreign Currency Conversion for Summary Journal Entries](https://knowledgecenter.zuora.com/CC_Finance/Foreign_Currency_Conversion/Foreign_Currency_Conversion_for_Summary_Journal_Entries) for more information about currency aggregation. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SummaryJournalEntriesApi;


SummaryJournalEntriesApi apiInstance = new SummaryJournalEntriesApi();
POSTJournalEntryType request = new POSTJournalEntryType(); // POSTJournalEntryType | 
try {
    POSTJournalEntryResponseType result = apiInstance.pOSTJournalEntry(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SummaryJournalEntriesApi#pOSTJournalEntry");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**POSTJournalEntryType**](POSTJournalEntryType.md)|  |

### Return type

[**POSTJournalEntryResponseType**](POSTJournalEntryResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTBasicSummaryJournalEntry"></a>
# **pUTBasicSummaryJournalEntry**
> CommonResponseType pUTBasicSummaryJournalEntry(jeNumber, request)

Update basic information of a summary journal entry

 This REST API reference describes how to update the basic information of a summary journal entry. Request and response field descriptions and sample code are provided. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SummaryJournalEntriesApi;


SummaryJournalEntriesApi apiInstance = new SummaryJournalEntriesApi();
String jeNumber = "jeNumber_example"; // String | Journal entry number in the format JE-00000001.
PUTBasicSummaryJournalEntryType request = new PUTBasicSummaryJournalEntryType(); // PUTBasicSummaryJournalEntryType | 
try {
    CommonResponseType result = apiInstance.pUTBasicSummaryJournalEntry(jeNumber, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SummaryJournalEntriesApi#pUTBasicSummaryJournalEntry");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jeNumber** | **String**| Journal entry number in the format JE-00000001. |
 **request** | [**PUTBasicSummaryJournalEntryType**](PUTBasicSummaryJournalEntryType.md)|  |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTSummaryJournalEntry"></a>
# **pUTSummaryJournalEntry**
> CommonResponseType pUTSummaryJournalEntry(jeNumber)

Cancel summary journal entry

 This reference describes how to cancel a summary journal entry using the REST API.  You must have the \&quot;Cancel Journal Entry\&quot; [Z-Finance user permission](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/Administrator_Settings/User_Roles/Z-Finance_Roles) enabled to cancel summary journal entries.  A summary journal entry cannot be canceled if its Transferred to Accounting status is \&quot;Yes\&quot; or \&quot;Processing\&quot;. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SummaryJournalEntriesApi;


SummaryJournalEntriesApi apiInstance = new SummaryJournalEntriesApi();
String jeNumber = "jeNumber_example"; // String | Journal entry number in the format JE-00000001.
try {
    CommonResponseType result = apiInstance.pUTSummaryJournalEntry(jeNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SummaryJournalEntriesApi#pUTSummaryJournalEntry");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jeNumber** | **String**| Journal entry number in the format JE-00000001. |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

