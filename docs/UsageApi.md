# UsageApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gETUsage**](UsageApi.md#gETUsage) | **GET** /usage/accounts/{account-key} | Get usage
[**pOSTUsage**](UsageApi.md#pOSTUsage) | **POST** /usage | Post usage
[**proxyDELETEUsage**](UsageApi.md#proxyDELETEUsage) | **DELETE** /object/usage/{id} | CRUD: Delete Usage
[**proxyGETUsage**](UsageApi.md#proxyGETUsage) | **GET** /object/usage/{id} | CRUD: Retrieve Usage
[**proxyPOSTUsage**](UsageApi.md#proxyPOSTUsage) | **POST** /object/usage | CRUD: Create Usage
[**proxyPUTUsage**](UsageApi.md#proxyPUTUsage) | **PUT** /object/usage/{id} | CRUD: Update Usage


<a name="gETUsage"></a>
# **gETUsage**
> GETUsageWrapper gETUsage(accountKey)

Get usage

This REST API reference describes how to retrieve usage details for an account. Usage data is returned in reverse chronological order. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UsageApi;


UsageApi apiInstance = new UsageApi();
String accountKey = "accountKey_example"; // String | Account number or account ID.
try {
    GETUsageWrapper result = apiInstance.gETUsage(accountKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsageApi#gETUsage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountKey** | **String**| Account number or account ID. |

### Return type

[**GETUsageWrapper**](GETUsageWrapper.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pOSTUsage"></a>
# **pOSTUsage**
> POSTUsageResponseType pOSTUsage(contentType)

Post usage

 This REST API reference describes how to post or import usage data for one or more accounts in the CSV  format. There are no path or query parameters. The data is uploade using the HTTP multipart/form-data POST method and applied to the user&#39;s tenant.   ## How this REST API Call Works The content of the upload file must follow the [format](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Usage/1_POST_usage#Upload_File_Format) used by the UI import tool. It must be a comma-separated (CSV) file with a corresponding .csv extension. The file size must not exceed 4MB. Click [here](https://knowledgecenter.zuora.com/@api/deki/files/4105/UsageFileFormat.csv) to download the usage file template.  At the completion of the upload, before actually processing the file contents, theAPI returns a response containing the byte count of the received file and a URL for checking the status of the import process.  Of the five possible results displayed at that URL Pending, Processing, Completed, Canceled, and Failed) only a Completed status indicates that the import was successful.  The operation is atomic; if any record fails, the file is rejected.  In that case, the entire import is rolled back and all stored data is returned to its original state.  To view the actual import status, enter the resulting status URL from the checkImportStatus response using a tool such as POSTMAN.This additional step provides more information about why the import may have failed.  To manage the information after a successful upload, use the web-based UI.  ## Upload File Format The upload file uses the following headings:  | Heading         | Description   | Required | |-----------------|--------|----------| | ACCOUNT_ID      | Enter the account number, e.g., the default account number, such as A00000001, or your custom account number.,Although this field is labeled as Account_Id, it is not the actual Account ID nor Account Name.  | Yes      | | UOM             | Enter the unit of measure. This must match the UOM for the usage that is set up in **Z-Billing Settings &gt; Customize Units of Measure**. | Yes      | | QTY             | Enter the quantity.  | Yes      | | STARTDATE       | Enter the start date of the usage.,This date determines the invoice item service period the associated usage is billed to. Date format is based on locale of the current user. Default date format: &#x60;MM/DD/YYYY&#x60; | Yes      | | ENDDATE         | Enter the end date of the usage.,This is not used in calculations for usage billing and is optional. Date format is based on locale of the current user. Default date format: &#x60;MM/DD/YYYY&#x60;    | Yes      | | SUBSCRIPTION_ID | Enter the subscription number or subscription name. If you created the subscription in the Zuora application, Zuora created a number automatically in a format similar to A-S00000001. If you do not provide a value for this field, the associated usage will be added to all subscriptions for the specified Account that use this Unit Of Measure. If your Accounts can have multiple subscriptions and you do not want double or triple counting of usage, you must specify the Subscription or Charge ID in each usage record.  | Yes      | | CHARGE_ID       | Enter the charge number (not the charge name). You can see the charge ID, e.g., C-00000001, when you add your rate plan to your subscription and view your individual charges. See [Adding Products and Rate Plans](https://knowledgecenter.zuora.com/BC_Subscription_Management/Subscriptions/B_Creating_Subscriptions/Adding_Products_and_Rate_Plans) for additional information. If your Accounts can have multiple subscriptions and you do not want double or triple counting of usage, you must specify the specific Subscription or Charge ID in each usage record. This field is related to the Charge Number on the subscription rate plan.                       | Yes      | | DESCRIPTION     | Enter a description for the charge. | No       | 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UsageApi;


UsageApi apiInstance = new UsageApi();
String contentType = "contentType_example"; // String | Must be set to \"multipart/form-data\". 
try {
    POSTUsageResponseType result = apiInstance.pOSTUsage(contentType);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsageApi#pOSTUsage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**| Must be set to \&quot;multipart/form-data\&quot;.  |

### Return type

[**POSTUsageResponseType**](POSTUsageResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyDELETEUsage"></a>
# **proxyDELETEUsage**
> ProxyDeleteResponse proxyDELETEUsage(id)

CRUD: Delete Usage



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UsageApi;


UsageApi apiInstance = new UsageApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEUsage(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsageApi#proxyDELETEUsage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |

### Return type

[**ProxyDeleteResponse**](ProxyDeleteResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyGETUsage"></a>
# **proxyGETUsage**
> ProxyGetUsage proxyGETUsage(id, fields)

CRUD: Retrieve Usage



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UsageApi;


UsageApi apiInstance = new UsageApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetUsage result = apiInstance.proxyGETUsage(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsageApi#proxyGETUsage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetUsage**](ProxyGetUsage.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPOSTUsage"></a>
# **proxyPOSTUsage**
> ProxyCreateOrModifyResponse proxyPOSTUsage(createRequest)

CRUD: Create Usage



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UsageApi;


UsageApi apiInstance = new UsageApi();
ProxyCreateUsage createRequest = new ProxyCreateUsage(); // ProxyCreateUsage | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPOSTUsage(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsageApi#proxyPOSTUsage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyCreateUsage**](ProxyCreateUsage.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPUTUsage"></a>
# **proxyPUTUsage**
> ProxyCreateOrModifyResponse proxyPUTUsage(id, modifyRequest)

CRUD: Update Usage



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UsageApi;


UsageApi apiInstance = new UsageApi();
String id = "id_example"; // String | Object id
ProxyModifyUsage modifyRequest = new ProxyModifyUsage(); // ProxyModifyUsage | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPUTUsage(id, modifyRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsageApi#proxyPUTUsage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **modifyRequest** | [**ProxyModifyUsage**](ProxyModifyUsage.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

