# SettingsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gETRevenueStartDateSetting**](SettingsApi.md#gETRevenueStartDateSetting) | **GET** /settings/finance/revenue-automation-start-date | Get the revenue automation start date


<a name="gETRevenueStartDateSetting"></a>
# **gETRevenueStartDateSetting**
> GETRevenueStartDateSettingType gETRevenueStartDateSetting()

Get the revenue automation start date

This REST API reference describes how to get the revenue automation start date. Request and response field descriptions and sample code are provided. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SettingsApi;


SettingsApi apiInstance = new SettingsApi();
try {
    GETRevenueStartDateSettingType result = apiInstance.gETRevenueStartDateSetting();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SettingsApi#gETRevenueStartDateSetting");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GETRevenueStartDateSettingType**](GETRevenueStartDateSettingType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

