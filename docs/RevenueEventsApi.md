# RevenueEventsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gETRevenueEventDetails**](RevenueEventsApi.md#gETRevenueEventDetails) | **GET** /revenue-events/revenue-schedules/{rs-number} | Get revenue events for a revenue schedule
[**gETRevenueEventDetails_0**](RevenueEventsApi.md#gETRevenueEventDetails_0) | **GET** /revenue-events/{event-number} | Get revenue event details


<a name="gETRevenueEventDetails"></a>
# **gETRevenueEventDetails**
> GETRevenueEventDetailsType gETRevenueEventDetails(rsNumber)

Get revenue events for a revenue schedule

 This REST API reference describes how to get all revenue events in a revenue schedule by specifying the revenue schedule number. Request and response field descriptions and sample code are provided. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueEventsApi;


RevenueEventsApi apiInstance = new RevenueEventsApi();
String rsNumber = "rsNumber_example"; // String | Revenue schedule number. The revenue schedule number is always prefixed with \"RS\", for example, \"RS-00000001\".
try {
    GETRevenueEventDetailsType result = apiInstance.gETRevenueEventDetails(rsNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueEventsApi#gETRevenueEventDetails");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rsNumber** | **String**| Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;. |

### Return type

[**GETRevenueEventDetailsType**](GETRevenueEventDetailsType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETRevenueEventDetails_0"></a>
# **gETRevenueEventDetails_0**
> GETRevenueEventDetailType gETRevenueEventDetails_0(eventNumber)

Get revenue event details

 This REST API reference describes how to get revenue event details by specifying the revenue event number. Request and response field descriptions and sample code are provided. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueEventsApi;


RevenueEventsApi apiInstance = new RevenueEventsApi();
String eventNumber = "eventNumber_example"; // String | The number associated with the revenue event.
try {
    GETRevenueEventDetailType result = apiInstance.gETRevenueEventDetails_0(eventNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueEventsApi#gETRevenueEventDetails_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **eventNumber** | **String**| The number associated with the revenue event. |

### Return type

[**GETRevenueEventDetailType**](GETRevenueEventDetailType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

