# RevenueSchedulesApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**dELETERS**](RevenueSchedulesApi.md#dELETERS) | **DELETE** /revenue-schedules/{rs-number} | Delete revenue schedule
[**gETRSDetail**](RevenueSchedulesApi.md#gETRSDetail) | **GET** /revenue-schedules/{rs-number} | Get revenue schedule details
[**gETRSDetailsByCharge**](RevenueSchedulesApi.md#gETRSDetailsByCharge) | **GET** /revenue-schedules/subscription-charges/{charge-key} | Get revenue schedule by subscription charge
[**gETRSbyInvoiceItem**](RevenueSchedulesApi.md#gETRSbyInvoiceItem) | **GET** /revenue-schedules/invoice-items/{invoice-item-id} | Get a revenue schedule by invoice item ID
[**gETRSbyInvoiceItemAdjustment**](RevenueSchedulesApi.md#gETRSbyInvoiceItemAdjustment) | **GET** /revenue-schedules/invoice-item-adjustments/{invoice-item-adj-id}/ | Get a revenue schedule by invoice item adjustment
[**pOSTRSforInvoiceItemAdjustmentDistributeByDateRange**](RevenueSchedulesApi.md#pOSTRSforInvoiceItemAdjustmentDistributeByDateRange) | **POST** /revenue-schedules/invoice-item-adjustments/{invoice-item-adj-key}/distribute-revenue-with-date-range | Create a revenue schedule for an Invoice Item Adjustment (distribute by date range)
[**pOSTRSforInvoiceItemAdjustmentManualDistribution**](RevenueSchedulesApi.md#pOSTRSforInvoiceItemAdjustmentManualDistribution) | **POST** /revenue-schedules/invoice-item-adjustments/{invoice-item-adj-key} | Create a revenue schedule for an Invoice Item Adjustment (manual distribution)
[**pOSTRSforInvoiceItemDistributeByDateRange**](RevenueSchedulesApi.md#pOSTRSforInvoiceItemDistributeByDateRange) | **POST** /revenue-schedules/invoice-items/{invoice-item-id}/distribute-revenue-with-date-range | Create a revenue schedule for an Invoice Item (distribute by date range)
[**pOSTRSforInvoiceItemManualDistribution**](RevenueSchedulesApi.md#pOSTRSforInvoiceItemManualDistribution) | **POST** /revenue-schedules/invoice-items/{invoice-item-id} | Create a revenue schedule for an Invoice Item (manual distribution)
[**pOSTRevenueScheduleByChargeResponse**](RevenueSchedulesApi.md#pOSTRevenueScheduleByChargeResponse) | **POST** /revenue-schedules/subscription-charges/{charge-key} | Create a revenue schedule on a subscription charge
[**pUTRSBasicInfo**](RevenueSchedulesApi.md#pUTRSBasicInfo) | **PUT** /revenue-schedules/{rs-number}/basic-information | Update revenue schedule basic information
[**pUTRevenueAcrossAP**](RevenueSchedulesApi.md#pUTRevenueAcrossAP) | **PUT** /revenue-schedules/{rs-number}/distribute-revenue-across-accounting-periods | Distribute revenue across accounting periods
[**pUTRevenueByRecognitionStartandEndDates**](RevenueSchedulesApi.md#pUTRevenueByRecognitionStartandEndDates) | **PUT** /revenue-schedules/{rs-number}/distribute-revenue-with-date-range | Distribute revenue by recognition start and end dates
[**pUTRevenueSpecificDate**](RevenueSchedulesApi.md#pUTRevenueSpecificDate) | **PUT** /revenue-schedules/{rs-number}/distribute-revenue-on-specific-date | Distribute revenue on a specific date


<a name="dELETERS"></a>
# **dELETERS**
> CommonResponseType dELETERS(rsNumber)

Delete revenue schedule

This REST API reference describes how to delete a revenue schedule by specifying its revenue schedule number ## Prerequisites You must have the Delete Custom Revenue Schedule [Z-Finance permission](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/Administrator_Settings/User_Roles/Z-Finance_Roles#Z-Finance_Permissions). 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueSchedulesApi;


RevenueSchedulesApi apiInstance = new RevenueSchedulesApi();
String rsNumber = "rsNumber_example"; // String |  Revenue schedule number of the revenue schedule you want to delete, for example, RS-00000256. To be deleted, the revenue schedule: * Must be using a custom unlimited recognition rule. * Cannot have any revenue in a closed accounting period. * Cannot be included in a summary journal entry. * Cannot have a revenue schedule date in a closed accounting period. 
try {
    CommonResponseType result = apiInstance.dELETERS(rsNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueSchedulesApi#dELETERS");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rsNumber** | **String**|  Revenue schedule number of the revenue schedule you want to delete, for example, RS-00000256. To be deleted, the revenue schedule: * Must be using a custom unlimited recognition rule. * Cannot have any revenue in a closed accounting period. * Cannot be included in a summary journal entry. * Cannot have a revenue schedule date in a closed accounting period.  |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETRSDetail"></a>
# **gETRSDetail**
> GETRSDetailType gETRSDetail(rsNumber)

Get revenue schedule details

This REST API reference describes how to get the details of a revenue schedule by specifying the revenue schedule number. Request and response field descriptions and sample code are provided.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueSchedulesApi;


RevenueSchedulesApi apiInstance = new RevenueSchedulesApi();
String rsNumber = "rsNumber_example"; // String | Revenue schedule number. The revenue schedule number is always prefixed with \"RS\", for example, \"RS-00000001\". 
try {
    GETRSDetailType result = apiInstance.gETRSDetail(rsNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueSchedulesApi#gETRSDetail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rsNumber** | **String**| Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  |

### Return type

[**GETRSDetailType**](GETRSDetailType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETRSDetailsByCharge"></a>
# **gETRSDetailsByCharge**
> GETRSDetailsByChargeType gETRSDetailsByCharge(chargeKey)

Get revenue schedule by subscription charge

This REST API reference describes how to get the revenue schedule details by specifying subscription charge ID. Request and response field descriptions and sample code are provided

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueSchedulesApi;


RevenueSchedulesApi apiInstance = new RevenueSchedulesApi();
String chargeKey = "chargeKey_example"; // String | ID of the subscription rate plan charge; for example, 402892793e173340013e173b81000012.
try {
    GETRSDetailsByChargeType result = apiInstance.gETRSDetailsByCharge(chargeKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueSchedulesApi#gETRSDetailsByCharge");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **chargeKey** | **String**| ID of the subscription rate plan charge; for example, 402892793e173340013e173b81000012. |

### Return type

[**GETRSDetailsByChargeType**](GETRSDetailsByChargeType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETRSbyInvoiceItem"></a>
# **gETRSbyInvoiceItem**
> GETRSDetailType gETRSbyInvoiceItem(invoiceItemId)

Get a revenue schedule by invoice item ID

This REST API reference describes how to get the details of a revenue schedule by specifying the invoice item ID.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueSchedulesApi;


RevenueSchedulesApi apiInstance = new RevenueSchedulesApi();
String invoiceItemId = "invoiceItemId_example"; // String | A valid Invoice Item ID.
try {
    GETRSDetailType result = apiInstance.gETRSbyInvoiceItem(invoiceItemId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueSchedulesApi#gETRSbyInvoiceItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **invoiceItemId** | **String**| A valid Invoice Item ID. |

### Return type

[**GETRSDetailType**](GETRSDetailType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETRSbyInvoiceItemAdjustment"></a>
# **gETRSbyInvoiceItemAdjustment**
> GETRSDetailType gETRSbyInvoiceItemAdjustment(invoiceItemAdjId)

Get a revenue schedule by invoice item adjustment

This REST API reference describes how to get the details of a revenue schedule by specifying a valid invoice item adjustment identifier. Request and response field descriptions and sample code are provided. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueSchedulesApi;


RevenueSchedulesApi apiInstance = new RevenueSchedulesApi();
String invoiceItemAdjId = "invoiceItemAdjId_example"; // String | ID or number of the Invoice Item Adjustment, for example, e20b07fd416dcfcf0141c81164fd0a72.
try {
    GETRSDetailType result = apiInstance.gETRSbyInvoiceItemAdjustment(invoiceItemAdjId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueSchedulesApi#gETRSbyInvoiceItemAdjustment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **invoiceItemAdjId** | **String**| ID or number of the Invoice Item Adjustment, for example, e20b07fd416dcfcf0141c81164fd0a72. |

### Return type

[**GETRSDetailType**](GETRSDetailType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pOSTRSforInvoiceItemAdjustmentDistributeByDateRange"></a>
# **pOSTRSforInvoiceItemAdjustmentDistributeByDateRange**
> POSTRevenueScheduleByTransactionResponseType pOSTRSforInvoiceItemAdjustmentDistributeByDateRange(invoiceItemAdjKey, request)

Create a revenue schedule for an Invoice Item Adjustment (distribute by date range)

This REST API reference describes how to create a revenue schedule for an Invoice Item Adjustment and distribute the revenue by specifying the recognition start and end dates.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueSchedulesApi;


RevenueSchedulesApi apiInstance = new RevenueSchedulesApi();
String invoiceItemAdjKey = "invoiceItemAdjKey_example"; // String | ID or number of the Invoice Item Adjustment, for example, e20b07fd416dcfcf0141c81164fd0a72. If the specified Invoice Item Adjustment is already associated with a revenue schedule, the call will fail. 
POSTRevenueScheduleByDateRangeType request = new POSTRevenueScheduleByDateRangeType(); // POSTRevenueScheduleByDateRangeType | 
try {
    POSTRevenueScheduleByTransactionResponseType result = apiInstance.pOSTRSforInvoiceItemAdjustmentDistributeByDateRange(invoiceItemAdjKey, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueSchedulesApi#pOSTRSforInvoiceItemAdjustmentDistributeByDateRange");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **invoiceItemAdjKey** | **String**| ID or number of the Invoice Item Adjustment, for example, e20b07fd416dcfcf0141c81164fd0a72. If the specified Invoice Item Adjustment is already associated with a revenue schedule, the call will fail.  |
 **request** | [**POSTRevenueScheduleByDateRangeType**](POSTRevenueScheduleByDateRangeType.md)|  |

### Return type

[**POSTRevenueScheduleByTransactionResponseType**](POSTRevenueScheduleByTransactionResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pOSTRSforInvoiceItemAdjustmentManualDistribution"></a>
# **pOSTRSforInvoiceItemAdjustmentManualDistribution**
> POSTRevenueScheduleByTransactionResponseType pOSTRSforInvoiceItemAdjustmentManualDistribution(invoiceItemAdjKey, request)

Create a revenue schedule for an Invoice Item Adjustment (manual distribution)

This REST API reference describes how to create a revenue schedule for an Invoice Item Adjustment and manually distribute the revenue.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueSchedulesApi;


RevenueSchedulesApi apiInstance = new RevenueSchedulesApi();
String invoiceItemAdjKey = "invoiceItemAdjKey_example"; // String | ID or number of the Invoice Item Adjustment, for example, e20b07fd416dcfcf0141c81164fd0a72. If the specified Invoice Item Adjustment is already associated with a revenue schedule, the call will fail. 
POSTRevenueScheduleByTransactionType request = new POSTRevenueScheduleByTransactionType(); // POSTRevenueScheduleByTransactionType | 
try {
    POSTRevenueScheduleByTransactionResponseType result = apiInstance.pOSTRSforInvoiceItemAdjustmentManualDistribution(invoiceItemAdjKey, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueSchedulesApi#pOSTRSforInvoiceItemAdjustmentManualDistribution");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **invoiceItemAdjKey** | **String**| ID or number of the Invoice Item Adjustment, for example, e20b07fd416dcfcf0141c81164fd0a72. If the specified Invoice Item Adjustment is already associated with a revenue schedule, the call will fail.  |
 **request** | [**POSTRevenueScheduleByTransactionType**](POSTRevenueScheduleByTransactionType.md)|  |

### Return type

[**POSTRevenueScheduleByTransactionResponseType**](POSTRevenueScheduleByTransactionResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pOSTRSforInvoiceItemDistributeByDateRange"></a>
# **pOSTRSforInvoiceItemDistributeByDateRange**
> POSTRevenueScheduleByTransactionResponseType pOSTRSforInvoiceItemDistributeByDateRange(invoiceItemId, request)

Create a revenue schedule for an Invoice Item (distribute by date range)

This REST API reference describes how to create a revenue schedule for an Invoice Item and distribute the revenue by specifying the recognition start and end dates.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueSchedulesApi;


RevenueSchedulesApi apiInstance = new RevenueSchedulesApi();
String invoiceItemId = "invoiceItemId_example"; // String | ID of the Invoice Item, for example, e20b07fd416dcfcf0141c81164fd0a75. If the specified Invoice Item is already associated with a revenue schedule, the call will fail. 
POSTRevenueScheduleByDateRangeType request = new POSTRevenueScheduleByDateRangeType(); // POSTRevenueScheduleByDateRangeType | 
try {
    POSTRevenueScheduleByTransactionResponseType result = apiInstance.pOSTRSforInvoiceItemDistributeByDateRange(invoiceItemId, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueSchedulesApi#pOSTRSforInvoiceItemDistributeByDateRange");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **invoiceItemId** | **String**| ID of the Invoice Item, for example, e20b07fd416dcfcf0141c81164fd0a75. If the specified Invoice Item is already associated with a revenue schedule, the call will fail.  |
 **request** | [**POSTRevenueScheduleByDateRangeType**](POSTRevenueScheduleByDateRangeType.md)|  |

### Return type

[**POSTRevenueScheduleByTransactionResponseType**](POSTRevenueScheduleByTransactionResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pOSTRSforInvoiceItemManualDistribution"></a>
# **pOSTRSforInvoiceItemManualDistribution**
> POSTRevenueScheduleByTransactionResponseType pOSTRSforInvoiceItemManualDistribution(invoiceItemId, request)

Create a revenue schedule for an Invoice Item (manual distribution)

This REST API reference describes how to create a revenue schedule for an Invoice Item and manually distribute the revenue.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueSchedulesApi;


RevenueSchedulesApi apiInstance = new RevenueSchedulesApi();
String invoiceItemId = "invoiceItemId_example"; // String | ID of the Invoice Item, for example, e20b07fd416dcfcf0141c81164fd0a75. If the specified Invoice Item is already associated with a revenue schedule, the call will fail. 
POSTRevenueScheduleByTransactionType request = new POSTRevenueScheduleByTransactionType(); // POSTRevenueScheduleByTransactionType | 
try {
    POSTRevenueScheduleByTransactionResponseType result = apiInstance.pOSTRSforInvoiceItemManualDistribution(invoiceItemId, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueSchedulesApi#pOSTRSforInvoiceItemManualDistribution");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **invoiceItemId** | **String**| ID of the Invoice Item, for example, e20b07fd416dcfcf0141c81164fd0a75. If the specified Invoice Item is already associated with a revenue schedule, the call will fail.  |
 **request** | [**POSTRevenueScheduleByTransactionType**](POSTRevenueScheduleByTransactionType.md)|  |

### Return type

[**POSTRevenueScheduleByTransactionResponseType**](POSTRevenueScheduleByTransactionResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pOSTRevenueScheduleByChargeResponse"></a>
# **pOSTRevenueScheduleByChargeResponse**
> POSTRevenueScheduleByChargeResponseType pOSTRevenueScheduleByChargeResponse(chargeKey, request)

Create a revenue schedule on a subscription charge

This REST API reference describes how to create a revenue schedule by specifying the subscription charge. This method is for custom unlimited revenue recognition only.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueSchedulesApi;


RevenueSchedulesApi apiInstance = new RevenueSchedulesApi();
String chargeKey = "chargeKey_example"; // String | ID of the subscription rate plan charge; for example, 402892793e173340013e173b81000012.
POSTRevenueScheduleByChargeType request = new POSTRevenueScheduleByChargeType(); // POSTRevenueScheduleByChargeType | 
try {
    POSTRevenueScheduleByChargeResponseType result = apiInstance.pOSTRevenueScheduleByChargeResponse(chargeKey, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueSchedulesApi#pOSTRevenueScheduleByChargeResponse");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **chargeKey** | **String**| ID of the subscription rate plan charge; for example, 402892793e173340013e173b81000012. |
 **request** | [**POSTRevenueScheduleByChargeType**](POSTRevenueScheduleByChargeType.md)|  |

### Return type

[**POSTRevenueScheduleByChargeResponseType**](POSTRevenueScheduleByChargeResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTRSBasicInfo"></a>
# **pUTRSBasicInfo**
> CommonResponseType pUTRSBasicInfo(rsNumber, request)

Update revenue schedule basic information

This REST API reference describes how to get basic information of a revenue schedule by specifying the revenue schedule number. Request and response field descriptions and sample code are provided. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueSchedulesApi;


RevenueSchedulesApi apiInstance = new RevenueSchedulesApi();
String rsNumber = "rsNumber_example"; // String | Revenue schedule number. The revenue schedule number is always prefixed with \"RS\", for example, \"RS-00000001\". 
PUTRSBasicInfoType request = new PUTRSBasicInfoType(); // PUTRSBasicInfoType | 
try {
    CommonResponseType result = apiInstance.pUTRSBasicInfo(rsNumber, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueSchedulesApi#pUTRSBasicInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rsNumber** | **String**| Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  |
 **request** | [**PUTRSBasicInfoType**](PUTRSBasicInfoType.md)|  |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTRevenueAcrossAP"></a>
# **pUTRevenueAcrossAP**
> PUTRevenueScheduleResponseType pUTRevenueAcrossAP(rsNumber, request)

Distribute revenue across accounting periods

This REST API reference describes how to distribute revenue by specifying the revenue schedule number. Request and response field descriptions and sample code are provided.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueSchedulesApi;


RevenueSchedulesApi apiInstance = new RevenueSchedulesApi();
String rsNumber = "rsNumber_example"; // String | Revenue schedule number. The revenue schedule number is always prefixed with \"RS\", for example, \"RS-00000001\". 
PUTAllocateManuallyType request = new PUTAllocateManuallyType(); // PUTAllocateManuallyType | 
try {
    PUTRevenueScheduleResponseType result = apiInstance.pUTRevenueAcrossAP(rsNumber, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueSchedulesApi#pUTRevenueAcrossAP");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rsNumber** | **String**| Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  |
 **request** | [**PUTAllocateManuallyType**](PUTAllocateManuallyType.md)|  |

### Return type

[**PUTRevenueScheduleResponseType**](PUTRevenueScheduleResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTRevenueByRecognitionStartandEndDates"></a>
# **pUTRevenueByRecognitionStartandEndDates**
> PUTRevenueScheduleResponseType pUTRevenueByRecognitionStartandEndDates(rsNumber, request)

Distribute revenue by recognition start and end dates

This REST API reference describes how to distribute revenue by specifying the recognition start and end dates. Request and response field descriptions and sample code are provided.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueSchedulesApi;


RevenueSchedulesApi apiInstance = new RevenueSchedulesApi();
String rsNumber = "rsNumber_example"; // String | Revenue schedule number. Specify the revenue schedule whose revenue you want to distribute.    The revenue schedule number is always prefixed with \"RS\", for example, \"RS-00000001\". 
PUTRSTermType request = new PUTRSTermType(); // PUTRSTermType | 
try {
    PUTRevenueScheduleResponseType result = apiInstance.pUTRevenueByRecognitionStartandEndDates(rsNumber, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueSchedulesApi#pUTRevenueByRecognitionStartandEndDates");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rsNumber** | **String**| Revenue schedule number. Specify the revenue schedule whose revenue you want to distribute.    The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  |
 **request** | [**PUTRSTermType**](PUTRSTermType.md)|  |

### Return type

[**PUTRevenueScheduleResponseType**](PUTRevenueScheduleResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTRevenueSpecificDate"></a>
# **pUTRevenueSpecificDate**
> PUTRevenueScheduleResponseType pUTRevenueSpecificDate(rsNumber, request)

Distribute revenue on a specific date

This REST API reference describes how to distribute revenue on a specific recognition date. Request and response field descriptions and sample code are provided.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueSchedulesApi;


RevenueSchedulesApi apiInstance = new RevenueSchedulesApi();
String rsNumber = "rsNumber_example"; // String | Revenue schedule number. The revenue schedule number is always prefixed with \"RS\", for example, \"RS-00000001\". 
PUTSpecificDateAllocationType request = new PUTSpecificDateAllocationType(); // PUTSpecificDateAllocationType | 
try {
    PUTRevenueScheduleResponseType result = apiInstance.pUTRevenueSpecificDate(rsNumber, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueSchedulesApi#pUTRevenueSpecificDate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rsNumber** | **String**| Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  |
 **request** | [**PUTSpecificDateAllocationType**](PUTSpecificDateAllocationType.md)|  |

### Return type

[**PUTRevenueScheduleResponseType**](PUTRevenueScheduleResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

