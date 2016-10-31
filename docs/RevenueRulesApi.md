# RevenueRulesApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gETRevenueRecognitionRuleAssociation**](RevenueRulesApi.md#gETRevenueRecognitionRuleAssociation) | **GET** /revenue-recognition-rules/subscription-charges/{charge-key} | Get the rule associated with a charge


<a name="gETRevenueRecognitionRuleAssociation"></a>
# **gETRevenueRecognitionRuleAssociation**
> GETRevenueRecognitionRuleAssociationType gETRevenueRecognitionRuleAssociation(chargeKey)

Get the rule associated with a charge

This REST API reference describes how to get the revenue recognition rule associated with a subscription charge by specifying the charge ID. Request and response field descriptions and sample code are provided. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RevenueRulesApi;


RevenueRulesApi apiInstance = new RevenueRulesApi();
String chargeKey = "chargeKey_example"; // String | ID of the subscription rate plan charge; for example, 402892793e173340013e173b81000012.
try {
    GETRevenueRecognitionRuleAssociationType result = apiInstance.gETRevenueRecognitionRuleAssociation(chargeKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevenueRulesApi#gETRevenueRecognitionRuleAssociation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **chargeKey** | **String**| ID of the subscription rate plan charge; for example, 402892793e173340013e173b81000012. |

### Return type

[**GETRevenueRecognitionRuleAssociationType**](GETRevenueRecognitionRuleAssociationType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

