# ChargeRevenueSummariesApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gETCRSByCRSNumber**](ChargeRevenueSummariesApi.md#gETCRSByCRSNumber) | **GET** /charge-revenue-summaries/{crs-number} | Get charge summary details by CRS number
[**gETCRSByChargeID**](ChargeRevenueSummariesApi.md#gETCRSByChargeID) | **GET** /charge-revenue-summaries/subscription-charges/{charge-key} | Get charge summary details by charge ID


<a name="gETCRSByCRSNumber"></a>
# **gETCRSByCRSNumber**
> GETChargeRSDetailType gETCRSByCRSNumber(crsNumber)

Get charge summary details by CRS number

This REST API reference describes how to retrieve the details of a charge revenue summary by specifying the charge revenue summary number. The response includes all revenue items associated with the charge revenue summary. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ChargeRevenueSummariesApi;


ChargeRevenueSummariesApi apiInstance = new ChargeRevenueSummariesApi();
String crsNumber = "crsNumber_example"; // String | The charge revenue summary number. 
try {
    GETChargeRSDetailType result = apiInstance.gETCRSByCRSNumber(crsNumber);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ChargeRevenueSummariesApi#gETCRSByCRSNumber");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **crsNumber** | **String**| The charge revenue summary number.  |

### Return type

[**GETChargeRSDetailType**](GETChargeRSDetailType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETCRSByChargeID"></a>
# **gETCRSByChargeID**
> GETChargeRSDetailType gETCRSByChargeID(chargeKey)

Get charge summary details by charge ID

This REST API reference describes how to retrieve the details of a charge revenue summary by specifying the subscription charge ID. This response retrieves all revenue items associated with a charge revenue summary. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ChargeRevenueSummariesApi;


ChargeRevenueSummariesApi apiInstance = new ChargeRevenueSummariesApi();
String chargeKey = "chargeKey_example"; // String | ID of the subscription rate plan charge; for example, 402892793e173340013e173b81000012. 
try {
    GETChargeRSDetailType result = apiInstance.gETCRSByChargeID(chargeKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ChargeRevenueSummariesApi#gETCRSByChargeID");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **chargeKey** | **String**| ID of the subscription rate plan charge; for example, 402892793e173340013e173b81000012.  |

### Return type

[**GETChargeRSDetailType**](GETChargeRSDetailType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

