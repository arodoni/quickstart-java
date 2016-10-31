# RevenueItemsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gETRevenueItemsByChargeRevenueEventNumber**](RevenueItemsApi.md#gETRevenueItemsByChargeRevenueEventNumber) | **GET** /revenue-items/revenue-events/{event-number} | Get revenue items by revenue event number
[**gETRevenueItemsByChargeRevenueSummaryNumber**](RevenueItemsApi.md#gETRevenueItemsByChargeRevenueSummaryNumber) | **GET** /revenue-items/charge-revenue-summaries/{crs-number} | Get revenue items by charge revenue summary number
[**gETRevenueItemsByRevenueSchedule**](RevenueItemsApi.md#gETRevenueItemsByRevenueSchedule) | **GET** /revenue-items/revenue-schedules/{rs-number} | Get revenue items by revenue schedule
[**pUTCustomFieldsonRevenueItemsByRevenueEvent**](RevenueItemsApi.md#pUTCustomFieldsonRevenueItemsByRevenueEvent) | **PUT** /revenue-items/revenue-events/{event-number} | Update custom fields on revenue items by revenue event number
[**pUTCustomFieldsonRevenueItemsByRevenueSchedule**](RevenueItemsApi.md#pUTCustomFieldsonRevenueItemsByRevenueSchedule) | **PUT** /revenue-items/revenue-schedules/{rs-number} | Update custom fields on revenue items by revenue schedule number


<a name="gETRevenueItemsByChargeRevenueEventNumber"></a>
# **gETRevenueItemsByChargeRevenueEventNumber**
> GETRevenueItemsType gETRevenueItemsByChargeRevenueEventNumber(eventNumber)

Get revenue items by revenue event number

This REST API reference describes how to get the details of each revenue item in a revenue event by specifying the revenue event number. Request and response field descriptions and sample code are provided. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueItemsApi;


RevenueItemsApi apiInstance = new RevenueItemsApi();
String eventNumber = "eventNumber_example"; // String | The number associated with the revenue event.
try {
    GETRevenueItemsType result = apiInstance.gETRevenueItemsByChargeRevenueEventNumber(eventNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueItemsApi#gETRevenueItemsByChargeRevenueEventNumber");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **eventNumber** | **String**| The number associated with the revenue event. |

### Return type

[**GETRevenueItemsType**](GETRevenueItemsType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETRevenueItemsByChargeRevenueSummaryNumber"></a>
# **gETRevenueItemsByChargeRevenueSummaryNumber**
> GETRevenueItemsType gETRevenueItemsByChargeRevenueSummaryNumber(crsNumber)

Get revenue items by charge revenue summary number

This REST API reference describes how to get the details for each revenue item in a charge revenue summary by specifying the charge revenue summary number. Request and response field descriptions and sample code are provided. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueItemsApi;


RevenueItemsApi apiInstance = new RevenueItemsApi();
String crsNumber = "crsNumber_example"; // String | The charge revenue summary number.
try {
    GETRevenueItemsType result = apiInstance.gETRevenueItemsByChargeRevenueSummaryNumber(crsNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueItemsApi#gETRevenueItemsByChargeRevenueSummaryNumber");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **crsNumber** | **String**| The charge revenue summary number. |

### Return type

[**GETRevenueItemsType**](GETRevenueItemsType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETRevenueItemsByRevenueSchedule"></a>
# **gETRevenueItemsByRevenueSchedule**
> GETRsRevenueItemsType gETRevenueItemsByRevenueSchedule(rsNumber)

Get revenue items by revenue schedule

This REST API reference describes how to get the details for each revenue items in a revenue schedule by specifying the revenue schedule number. Request and response field descriptions and sample code are provided. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueItemsApi;


RevenueItemsApi apiInstance = new RevenueItemsApi();
String rsNumber = "rsNumber_example"; // String | Revenue schedule number. The revenue schedule number is always prefixed with \"RS\", for example, \"RS-00000001\".
try {
    GETRsRevenueItemsType result = apiInstance.gETRevenueItemsByRevenueSchedule(rsNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueItemsApi#gETRevenueItemsByRevenueSchedule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rsNumber** | **String**| Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;. |

### Return type

[**GETRsRevenueItemsType**](GETRsRevenueItemsType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTCustomFieldsonRevenueItemsByRevenueEvent"></a>
# **pUTCustomFieldsonRevenueItemsByRevenueEvent**
> CommonResponseType pUTCustomFieldsonRevenueItemsByRevenueEvent(eventNumber, request)

Update custom fields on revenue items by revenue event number

This REST API reference describes how to update custom fields on revenue items by specifying the revenue event number. Request and response field descriptions and sample code are provided. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueItemsApi;


RevenueItemsApi apiInstance = new RevenueItemsApi();
String eventNumber = "eventNumber_example"; // String | The number associated with the revenue event.
PUTEventRIDetailType request = new PUTEventRIDetailType(); // PUTEventRIDetailType | 
try {
    CommonResponseType result = apiInstance.pUTCustomFieldsonRevenueItemsByRevenueEvent(eventNumber, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueItemsApi#pUTCustomFieldsonRevenueItemsByRevenueEvent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **eventNumber** | **String**| The number associated with the revenue event. |
 **request** | [**PUTEventRIDetailType**](PUTEventRIDetailType.md)|  |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTCustomFieldsonRevenueItemsByRevenueSchedule"></a>
# **pUTCustomFieldsonRevenueItemsByRevenueSchedule**
> CommonResponseType pUTCustomFieldsonRevenueItemsByRevenueSchedule(rsNumber, request)

Update custom fields on revenue items by revenue schedule number

This REST API reference describes how to update custom fields on revenue Items by specifying the revenue schedule number. Request and response field descriptions and sample code are provided. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueItemsApi;


RevenueItemsApi apiInstance = new RevenueItemsApi();
String rsNumber = "rsNumber_example"; // String | Revenue schedule number. The revenue schedule number is always prefixed with \"RS\", for example, \"RS-00000001\".
PUTScheduleRIDetailType request = new PUTScheduleRIDetailType(); // PUTScheduleRIDetailType | 
try {
    CommonResponseType result = apiInstance.pUTCustomFieldsonRevenueItemsByRevenueSchedule(rsNumber, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueItemsApi#pUTCustomFieldsonRevenueItemsByRevenueSchedule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rsNumber** | **String**| Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;. |
 **request** | [**PUTScheduleRIDetailType**](PUTScheduleRIDetailType.md)|  |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

