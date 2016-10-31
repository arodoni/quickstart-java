# NotificationHistoryApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gETCalloutHistoryVOs**](NotificationHistoryApi.md#gETCalloutHistoryVOs) | **GET** /notification-history/callout | Get callout notification histories
[**gETEmailHistoryVOs**](NotificationHistoryApi.md#gETEmailHistoryVOs) | **GET** /notification-history/email | Get email notification histories


<a name="gETCalloutHistoryVOs"></a>
# **gETCalloutHistoryVOs**
> GETCalloutHistoryVOsType gETCalloutHistoryVOs(endTime, startTime, objectId, failedOnly, eventCategory, includeResponseContent)

Get callout notification histories

This REST API reference describes how to get a notification history for callouts.  See [Notifications and Callouts](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Notifications) and [Create and Edit Notifications](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Notifications/C_Create_Notifications) for more information. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NotificationHistoryApi;


NotificationHistoryApi apiInstance = new NotificationHistoryApi();
DateTime endTime = new DateTime(); // DateTime | The final date and time of records to be returned. Defaults to now. Use format yyyy-MM-ddTHH:mm:ss.
DateTime startTime = new DateTime(); // DateTime | The initial date and time of records to be returned. Defaults to (end time - 1 day). Use format yyyy-MM-ddTHH:mm:ss.
String objectId = "objectId_example"; // String | The ID of an object that triggered a callout notification.
Boolean failedOnly = true; // Boolean | If `true`, only return failed records. If `false`, return all records in the given date range. The default value is `true`.
String eventCategory = "eventCategory_example"; // String | Category of records to be returned by [event category](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Notification_History/Z_Event_Categories).
Boolean includeResponseContent = true; // Boolean | 
try {
    GETCalloutHistoryVOsType result = apiInstance.gETCalloutHistoryVOs(endTime, startTime, objectId, failedOnly, eventCategory, includeResponseContent);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationHistoryApi#gETCalloutHistoryVOs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endTime** | **DateTime**| The final date and time of records to be returned. Defaults to now. Use format yyyy-MM-ddTHH:mm:ss. | [optional]
 **startTime** | **DateTime**| The initial date and time of records to be returned. Defaults to (end time - 1 day). Use format yyyy-MM-ddTHH:mm:ss. | [optional]
 **objectId** | **String**| The ID of an object that triggered a callout notification. | [optional]
 **failedOnly** | **Boolean**| If &#x60;true&#x60;, only return failed records. If &#x60;false&#x60;, return all records in the given date range. The default value is &#x60;true&#x60;. | [optional]
 **eventCategory** | **String**| Category of records to be returned by [event category](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Notification_History/Z_Event_Categories). | [optional]
 **includeResponseContent** | **Boolean**|  | [optional]

### Return type

[**GETCalloutHistoryVOsType**](GETCalloutHistoryVOsType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETEmailHistoryVOs"></a>
# **gETEmailHistoryVOs**
> GETEmailHistoryVOsType gETEmailHistoryVOs(endTime, startTime, objectId, failedOnly, eventCategory)

Get email notification histories

This REST API reference describes how to get a notification history for notification emails.  See [Notifications and Callouts](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Notifications) and [Create and Edit Notifications](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Notifications/C_Create_Notifications) for more information.  ## Notes Request parameters and their values may be appended with a \&quot;?\&quot; following the HTTPS GET request.  Additional request parameter are separated by \&quot;&amp;\&quot;.   For example:  &#x60;GET https://api.zuora.com/rest/v1/notification-history/email?startTime&#x3D;2015-01-12T00:00:00&amp;endTime&#x3D;2015-01-15T00:00:00&amp;failedOnly&#x3D;false&amp;eventCategory&#x3D;1000&amp;pageSize&#x3D;1&#x60; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NotificationHistoryApi;


NotificationHistoryApi apiInstance = new NotificationHistoryApi();
DateTime endTime = new DateTime(); // DateTime | The end date and time of records to be returned. Defaults to now. Use format yyyy-MM-ddTHH:mm:ss. The maximum date range (endTime - startTime) is three days.
DateTime startTime = new DateTime(); // DateTime | The initial date and time of records to be returned. Defaults to (end time - 1 day). Use format yyyy-MM-ddTHH:mm:ss. The maximum date range (endTime - startTime) is three days.
String objectId = "objectId_example"; // String | The Id of an object that triggered an email notification.
Boolean failedOnly = true; // Boolean | If `true`, only returns failed records. When `false`, returns all records in the given date range. Defaults to `true` when not specified.
String eventCategory = "eventCategory_example"; // String | Category of records to be returned by [event category](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Notification_History/Z_Event_Categories).
try {
    GETEmailHistoryVOsType result = apiInstance.gETEmailHistoryVOs(endTime, startTime, objectId, failedOnly, eventCategory);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationHistoryApi#gETEmailHistoryVOs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endTime** | **DateTime**| The end date and time of records to be returned. Defaults to now. Use format yyyy-MM-ddTHH:mm:ss. The maximum date range (endTime - startTime) is three days. | [optional]
 **startTime** | **DateTime**| The initial date and time of records to be returned. Defaults to (end time - 1 day). Use format yyyy-MM-ddTHH:mm:ss. The maximum date range (endTime - startTime) is three days. | [optional]
 **objectId** | **String**| The Id of an object that triggered an email notification. | [optional]
 **failedOnly** | **Boolean**| If &#x60;true&#x60;, only returns failed records. When &#x60;false&#x60;, returns all records in the given date range. Defaults to &#x60;true&#x60; when not specified. | [optional]
 **eventCategory** | **String**| Category of records to be returned by [event category](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Notification_History/Z_Event_Categories). | [optional]

### Return type

[**GETEmailHistoryVOsType**](GETEmailHistoryVOsType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

