# MassUpdaterApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gETMassUpdate**](MassUpdaterApi.md#gETMassUpdate) | **GET** /bulk/{bulk-key} | Get mass action result
[**pOSTMassUpdate**](MassUpdaterApi.md#pOSTMassUpdate) | **POST** /bulk | Perform mass action
[**pUTMassUpdater**](MassUpdaterApi.md#pUTMassUpdater) | **PUT** /bulk/{bulk-key}/stop | Stop mass action


<a name="gETMassUpdate"></a>
# **gETMassUpdate**
> GETMassUpdateType gETMassUpdate(bulkKey)

Get mass action result

This reference describes how to get information about the result of a mass action through the REST API. See [Mass Updater](https://knowledgecenter.zuora.com/CC_Finance/Mass_Updater) for more information about mass actions. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MassUpdaterApi;


MassUpdaterApi apiInstance = new MassUpdaterApi();
String bulkKey = "bulkKey_example"; // String | String of 32 characters that identifies a mass action. You get the bulk-key after [performing a mass action](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Mass_Updater/A_Perform_Mass_Action) through the REST API. 
try {
    GETMassUpdateType result = apiInstance.gETMassUpdate(bulkKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MassUpdaterApi#gETMassUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bulkKey** | **String**| String of 32 characters that identifies a mass action. You get the bulk-key after [performing a mass action](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Mass_Updater/A_Perform_Mass_Action) through the REST API.  |

### Return type

[**GETMassUpdateType**](GETMassUpdateType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pOSTMassUpdate"></a>
# **pOSTMassUpdate**
> POSTMassUpdateResponseType pOSTMassUpdate(contentType, request)

Perform mass action

This reference describes how to perform a mass action through the REST API. See [Mass Updater](https://knowledgecenter.zuora.com/CC_Finance/Mass_Updater) for more information about performing mass actions.  Using this API method, you send a multipart/form-data request containing a &#x60;.csv&#x60; file with data about the mass action you want to perform. Zuora returns a key and then asynchronously processes the mass action. You can use the key to get details about the result of the mass action. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MassUpdaterApi;


MassUpdaterApi apiInstance = new MassUpdaterApi();
String contentType = "contentType_example"; // String | Must be multipart/form-data. 
POSTMassUpdateType request = new POSTMassUpdateType(); // POSTMassUpdateType | 
try {
    POSTMassUpdateResponseType result = apiInstance.pOSTMassUpdate(contentType, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MassUpdaterApi#pOSTMassUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**| Must be multipart/form-data.  |
 **request** | [**POSTMassUpdateType**](POSTMassUpdateType.md)|  |

### Return type

[**POSTMassUpdateResponseType**](POSTMassUpdateResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTMassUpdater"></a>
# **pUTMassUpdater**
> CommonResponseType pUTMassUpdater(bulkKey)

Stop mass action

This reference describes how to stop a mass action through the REST API. You can stop a mass action when its status is Pending or Processing. After you have stopped a mass action, you can get the [mass action result](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Mass_Updater/B_Get_Mass_Action_Result) to see details of the mass action.  - If you stop a mass action when its status is Pending, no response file is generated because no records have been processed.  - If you stop a mass action when its status is Processing, a response file is generated. You can check the response file to see which records have been processed and which have not. In the response file, the **Success** column has the value &#x60;Y&#x60; (successful) or &#x60;N&#x60; (failed) for processed records, and a blank value for unprocessed records.  Records that have already been processed when a mass action is stopped are not rolled back. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MassUpdaterApi;


MassUpdaterApi apiInstance = new MassUpdaterApi();
String bulkKey = "bulkKey_example"; // String | String of 32 characters that identifies a mass action. You get the bulk-key after [performing a mass action](https://knowledgecenter.zuora.com/BC_Developers/REST_API/B_REST_API_reference/Mass_Updater/A_Perform_Mass_Action) through the REST API. 
try {
    CommonResponseType result = apiInstance.pUTMassUpdater(bulkKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MassUpdaterApi#pUTMassUpdater");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bulkKey** | **String**| String of 32 characters that identifies a mass action. You get the bulk-key after [performing a mass action](https://knowledgecenter.zuora.com/BC_Developers/REST_API/B_REST_API_reference/Mass_Updater/A_Perform_Mass_Action) through the REST API.  |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

