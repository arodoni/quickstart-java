# AccountingPeriodsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**dELETEAccountingPeriod**](AccountingPeriodsApi.md#dELETEAccountingPeriod) | **DELETE** /accounting-periods/{ap-id} | Delete accounting period
[**gETAccountingPeriod**](AccountingPeriodsApi.md#gETAccountingPeriod) | **GET** /accounting-periods/{ap-id} | Get accounting period
[**gETAccountingPeriods**](AccountingPeriodsApi.md#gETAccountingPeriods) | **GET** /accounting-periods | Get all accounting periods
[**pOSTAccountingPeriod**](AccountingPeriodsApi.md#pOSTAccountingPeriod) | **POST** /accounting-periods | Create accounting period
[**pUTCloseAccountingPeriod**](AccountingPeriodsApi.md#pUTCloseAccountingPeriod) | **PUT** /accounting-periods/{ap-id}/close | Close accounting period
[**pUTPendingCloseAccountingPeriod**](AccountingPeriodsApi.md#pUTPendingCloseAccountingPeriod) | **PUT** /accounting-periods/{ap-id}/pending-close | Set accounting period to pending close
[**pUTReopenAccountingPeriod**](AccountingPeriodsApi.md#pUTReopenAccountingPeriod) | **PUT** /accounting-periods/{ap-id}/reopen | Re-open accounting period
[**pUTRunTrialBalance**](AccountingPeriodsApi.md#pUTRunTrialBalance) | **PUT** /accounting-periods/{ap-id}/run-trial-balance | Run trial balance
[**pUTUpdateAccountingPeriod**](AccountingPeriodsApi.md#pUTUpdateAccountingPeriod) | **PUT** /accounting-periods/{ap-id} | Update accounting period
[**proxyDELETEAccountingPeriod**](AccountingPeriodsApi.md#proxyDELETEAccountingPeriod) | **DELETE** /object/accounting-period/{id} | CRUD: Delete AccountingPeriod
[**proxyGETAccountingPeriod**](AccountingPeriodsApi.md#proxyGETAccountingPeriod) | **GET** /object/accounting-period/{id} | CRUD: Retrieve AccountingPeriod


<a name="dELETEAccountingPeriod"></a>
# **dELETEAccountingPeriod**
> CommonResponseType dELETEAccountingPeriod(apId)

Delete accounting period

 Deletes an accounting period.  Prerequisites -------------   * You must have Zuora Finance enabled on your tenant.   * You must have the Delete Accounting Period user permission. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).   Limitations -----------  The accounting period to be deleted:  * Must be the most recent accounting period  * Must be an open accounting period  * Must have no revenue distributed into it  * Must not have any active journal entries  * Must not be the open-ended accounting period  * Must not be in the process of running a trial balance 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingPeriodsApi;


AccountingPeriodsApi apiInstance = new AccountingPeriodsApi();
String apId = "apId_example"; // String | ID of the accounting period you want to delete.
try {
    CommonResponseType result = apiInstance.dELETEAccountingPeriod(apId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingPeriodsApi#dELETEAccountingPeriod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apId** | **String**| ID of the accounting period you want to delete. |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETAccountingPeriod"></a>
# **gETAccountingPeriod**
> GETAccountingPeriodType gETAccountingPeriod(apId)

Get accounting period

Retrieves an accounting period. Prerequisites -------------  You must have Zuora Finance enabled on your tenant. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingPeriodsApi;


AccountingPeriodsApi apiInstance = new AccountingPeriodsApi();
String apId = "apId_example"; // String | ID of the accounting period you want to get.
try {
    GETAccountingPeriodType result = apiInstance.gETAccountingPeriod(apId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingPeriodsApi#gETAccountingPeriod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apId** | **String**| ID of the accounting period you want to get. |

### Return type

[**GETAccountingPeriodType**](GETAccountingPeriodType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETAccountingPeriods"></a>
# **gETAccountingPeriods**
> GETAccountingPeriodsType gETAccountingPeriods()

Get all accounting periods

Retrieves all accounting periods on your tenant.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingPeriodsApi;


AccountingPeriodsApi apiInstance = new AccountingPeriodsApi();
try {
    GETAccountingPeriodsType result = apiInstance.gETAccountingPeriods();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingPeriodsApi#gETAccountingPeriods");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GETAccountingPeriodsType**](GETAccountingPeriodsType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pOSTAccountingPeriod"></a>
# **pOSTAccountingPeriod**
> POSTAccountingPeriodResponseType pOSTAccountingPeriod(request)

Create accounting period

Creates an accounting period. Prerequisites ------------- * You must have Zuora Finance enabled on your tenant. * You must have the Create Accounting Period user permission. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/Z-Finance_Roles).  Limitations ----------- * When creating the first accounting period on your tenant, the start date must be equal to or earlier than the date of the earliest transaction on the tenant. * Start and end dates of accounting periods must be contiguous. For example, if one accounting period ends on January 31, the next period must start on February 1. * If you have the Revenue Recognition Package and have enabled the \&quot;Monthly recognition over time\&quot; revenue recognition model, the accounting period start date and end date must be on the first day and last day of the month, respectively. Note that the start and end dates do not necessarily have to be in the same month.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingPeriodsApi;


AccountingPeriodsApi apiInstance = new AccountingPeriodsApi();
POSTAccountingPeriodType request = new POSTAccountingPeriodType(); // POSTAccountingPeriodType | 
try {
    POSTAccountingPeriodResponseType result = apiInstance.pOSTAccountingPeriod(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingPeriodsApi#pOSTAccountingPeriod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**POSTAccountingPeriodType**](POSTAccountingPeriodType.md)|  |

### Return type

[**POSTAccountingPeriodResponseType**](POSTAccountingPeriodResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTCloseAccountingPeriod"></a>
# **pUTCloseAccountingPeriod**
> CommonResponseType pUTCloseAccountingPeriod(apId)

Close accounting period

Close an [accounting period](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods) by accounting period ID.  Prerequisites ------------- You must have Zuora Finance enabled on your tenant. You must have the Manage Close Process and Run Trial Balance user permissions. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles). Limitations ----------- * The accounting period cannot already be closed. * The accounting period cannot be in the process of running a trial balance. * All earlier accounting periods must be closed. * There must be no required action items for the accounting period. See [Reconcile Transactions Before Closing an Accounting Period](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/G_Reconcile_transactions_before_closing_an_accounting_period) for more information.  Notes ----- When you close an accounting period in Zuora, a trial balance is automatically run for that period. A successful response means only that the accounting period is now closed, but does not mean that the trial balance has successfully completed.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingPeriodsApi;


AccountingPeriodsApi apiInstance = new AccountingPeriodsApi();
String apId = "apId_example"; // String | ID of the accounting period you want to close.
try {
    CommonResponseType result = apiInstance.pUTCloseAccountingPeriod(apId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingPeriodsApi#pUTCloseAccountingPeriod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apId** | **String**| ID of the accounting period you want to close. |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTPendingCloseAccountingPeriod"></a>
# **pUTPendingCloseAccountingPeriod**
> CommonResponseType pUTPendingCloseAccountingPeriod(apId)

Set accounting period to pending close

Sets an accounting period to pending close.   Prerequisites -------------  * You must have Zuora Finance enabled on your tenant. * You must have the Manage Close Process and Run Trial Balance user permissions. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).              Limitations   -----------    * The accounting period cannot be closed or pending close.    * The accounting period cannot be in the process of running a trial balance.    * All earlier accounting periods must be closed.     Notes ----- When you set an accounting period to pending close in Zuora, a trial balance is automatically run for that period. A response of &#x60;{ \&quot;success\&quot;: true }&#x60;  means only that the accounting period status is now pending close, but does not mean that the trial balance has successfully completed. You can use the Get Accounting Period REST API call to view details about the outcome of the trial balance. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingPeriodsApi;


AccountingPeriodsApi apiInstance = new AccountingPeriodsApi();
String apId = "apId_example"; // String | ID of the accounting period you want to set to pending close.
try {
    CommonResponseType result = apiInstance.pUTPendingCloseAccountingPeriod(apId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingPeriodsApi#pUTPendingCloseAccountingPeriod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apId** | **String**| ID of the accounting period you want to set to pending close. |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTReopenAccountingPeriod"></a>
# **pUTReopenAccountingPeriod**
> CommonResponseType pUTReopenAccountingPeriod(apId)

Re-open accounting period

Re-opens an accounting period. See [Re-Open Accounting Periods](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/H_Reopen_accounting_periods) for more information. Prerequisites ------------- * You must have Zuora Finance enabled on your tenant. * You must have the Manage Close Process and Run Trial Balance user permissions. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).  Limitations ----------- * The accounting period must be closed or pending close. * You can only re-open an accounting period that is immediately previous to an open period. See [re-open an accounting period](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/H_Reopen_accounting_periods) for an example.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingPeriodsApi;


AccountingPeriodsApi apiInstance = new AccountingPeriodsApi();
String apId = "apId_example"; // String | ID of the accounting period that you want to re-open.
try {
    CommonResponseType result = apiInstance.pUTReopenAccountingPeriod(apId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingPeriodsApi#pUTReopenAccountingPeriod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apId** | **String**| ID of the accounting period that you want to re-open. |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTRunTrialBalance"></a>
# **pUTRunTrialBalance**
> CommonResponseType pUTRunTrialBalance(apId)

Run trial balance

Runs the trial balance for an accounting period. See [Run a Trial Balance](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/E_Accounting_Periods/D_Run_a_trial_balance) for more information.  Prerequisites -------------  * You must have Zuora Finance enabled on your tenant.  * You must have the Manage Close Process and Run Trial Balance user permissions. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).             Limitations  -----------    * The accounting period must be open.    * The accounting period cannot already be in the process of running a trial balance.   Notes ----- The trial balance is run asynchronously. A response of &#x60;{ \&quot;success\&quot;: true }&#x60; means only that the trial balance has started processing, but does not mean that the trial balance has successfully completed. You can use the [Get Accounting Period](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Accounting_Periods/Get_Accounting_Period) REST API call to view details about the outcome of the trial balance. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingPeriodsApi;


AccountingPeriodsApi apiInstance = new AccountingPeriodsApi();
String apId = "apId_example"; // String | ID of the accounting period for which you want to run a trial balance.
try {
    CommonResponseType result = apiInstance.pUTRunTrialBalance(apId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingPeriodsApi#pUTRunTrialBalance");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apId** | **String**| ID of the accounting period for which you want to run a trial balance. |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTUpdateAccountingPeriod"></a>
# **pUTUpdateAccountingPeriod**
> CommonResponseType pUTUpdateAccountingPeriod(apId, request)

Update accounting period

 Updates an accounting period.  Prerequisites -------------  * You must have Zuora Finance enabled on your tenant.  * You must have the Create Accounting Period user permission. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles).  Limitations -----------  * You can update the start date of only the earliest accounting period on your tenant. You cannot update the start date of later periods.  * If you update the earliest accounting period, the start date must be equal to or earlier than the date of the earliest transaction on the tenant.  * Start and end dates of accounting periods must be contiguous. For example, if one accounting period ends on January 31, the next period must start on February 1.  * If you have the Revenue Recognition Package and have enabled the \&quot;Monthly recognition over time\&quot; revenue recognition model, the accounting period start date and end date must be on the first day and last day of the month, respectively. Note that the start and end dates do not necessarily have to be in the same month.  * You cannot update the start date or end date of an accounting period if:   * Any revenue has been distributed into the period.   * The period has any active journal entries. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingPeriodsApi;


AccountingPeriodsApi apiInstance = new AccountingPeriodsApi();
String apId = "apId_example"; // String | ID of the accounting period you want to update.
PUTAccountingPeriodType request = new PUTAccountingPeriodType(); // PUTAccountingPeriodType | 
try {
    CommonResponseType result = apiInstance.pUTUpdateAccountingPeriod(apId, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingPeriodsApi#pUTUpdateAccountingPeriod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apId** | **String**| ID of the accounting period you want to update. |
 **request** | [**PUTAccountingPeriodType**](PUTAccountingPeriodType.md)|  |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyDELETEAccountingPeriod"></a>
# **proxyDELETEAccountingPeriod**
> ProxyDeleteResponse proxyDELETEAccountingPeriod(id)

CRUD: Delete AccountingPeriod



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingPeriodsApi;


AccountingPeriodsApi apiInstance = new AccountingPeriodsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEAccountingPeriod(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingPeriodsApi#proxyDELETEAccountingPeriod");
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

<a name="proxyGETAccountingPeriod"></a>
# **proxyGETAccountingPeriod**
> ProxyGetAccountingPeriod proxyGETAccountingPeriod(id, fields)

CRUD: Retrieve AccountingPeriod



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingPeriodsApi;


AccountingPeriodsApi apiInstance = new AccountingPeriodsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetAccountingPeriod result = apiInstance.proxyGETAccountingPeriod(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingPeriodsApi#proxyGETAccountingPeriod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetAccountingPeriod**](ProxyGetAccountingPeriod.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

