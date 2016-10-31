# AccountingCodesApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**dELETEAccountingCode**](AccountingCodesApi.md#dELETEAccountingCode) | **DELETE** /accounting-codes/{ac-id} | Delete accounting code
[**gETAccountingCodeItem**](AccountingCodesApi.md#gETAccountingCodeItem) | **GET** /accounting-codes/{ac-id} | Query an accounting code
[**gETAccountingCodes**](AccountingCodesApi.md#gETAccountingCodes) | **GET** /accounting-codes | Get all accounting codes
[**pOSTAccountingCode**](AccountingCodesApi.md#pOSTAccountingCode) | **POST** /accounting-codes | Create accounting code
[**pUTAccountingCode**](AccountingCodesApi.md#pUTAccountingCode) | **PUT** /accounting-codes/{ac-id} | Update an accounting code
[**pUTActivateAccountingCode**](AccountingCodesApi.md#pUTActivateAccountingCode) | **PUT** /accounting-codes/{ac-id}/activate | Activate accounting code
[**pUTDeactivateAccountingCode**](AccountingCodesApi.md#pUTDeactivateAccountingCode) | **PUT** /accounting-codes/{ac-id}/deactivate | Deactivate accounting code
[**proxyDELETEAccountingCode**](AccountingCodesApi.md#proxyDELETEAccountingCode) | **DELETE** /object/accounting-code/{id} | CRUD: Delete AccountingCode
[**proxyGETAccountingCode**](AccountingCodesApi.md#proxyGETAccountingCode) | **GET** /object/accounting-code/{id} | CRUD: Retrieve AccountingCode
[**proxyPOSTAccountingCode**](AccountingCodesApi.md#proxyPOSTAccountingCode) | **POST** /object/accounting-code | CRUD: Create AccountingCode
[**proxyPUTAccountingCode**](AccountingCodesApi.md#proxyPUTAccountingCode) | **PUT** /object/accounting-code/{id} | CRUD: Update AccountingCode


<a name="dELETEAccountingCode"></a>
# **dELETEAccountingCode**
> CommonResponseType dELETEAccountingCode(acId)

Delete accounting code

This reference describes how to [delete an accounting code](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/G_Chart_of_Accounts/A_Set_Up_Chart_of_Accounts#Delete_an_Accounting_Code) through the REST API. ## Prerequisites If you have Z-Finance enabled on your tenant, then you must have the Z-Finance Delete Unused Accounting Code permission. See [Z-Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles). ## Limitations You can only delete accounting codes that have never been associated with any transactions. An accounting code must be deactivated before you can delete it. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingCodesApi;


AccountingCodesApi apiInstance = new AccountingCodesApi();
String acId = "acId_example"; // String | ID of the accounting code you want to delete.
try {
    CommonResponseType result = apiInstance.dELETEAccountingCode(acId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingCodesApi#dELETEAccountingCode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **acId** | **String**| ID of the accounting code you want to delete. |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETAccountingCodeItem"></a>
# **gETAccountingCodeItem**
> GETAccountingCodeItemType gETAccountingCodeItem(acId)

Query an accounting code

This reference describes how to query an accounting code through the REST API.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingCodesApi;


AccountingCodesApi apiInstance = new AccountingCodesApi();
String acId = "acId_example"; // String | ID of the accounting code you want to query.
try {
    GETAccountingCodeItemType result = apiInstance.gETAccountingCodeItem(acId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingCodesApi#gETAccountingCodeItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **acId** | **String**| ID of the accounting code you want to query. |

### Return type

[**GETAccountingCodeItemType**](GETAccountingCodeItemType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETAccountingCodes"></a>
# **gETAccountingCodes**
> GETAccountingCodesType gETAccountingCodes()

Get all accounting codes

This reference describes how to query all accounting codes in your chart of accounts through the REST API.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingCodesApi;


AccountingCodesApi apiInstance = new AccountingCodesApi();
try {
    GETAccountingCodesType result = apiInstance.gETAccountingCodes();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingCodesApi#gETAccountingCodes");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GETAccountingCodesType**](GETAccountingCodesType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pOSTAccountingCode"></a>
# **pOSTAccountingCode**
> POSTAccountingCodeResponseType pOSTAccountingCode(request)

Create accounting code

This reference describes how to create a new accounting code through the REST API.  The accounting code will be active as soon as it has been created.  ## Prerequisites   If you have Z-Finance enabled on your tenant, you must have the Z-Finance Create Accounting Code permission. See [Z-Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles). 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingCodesApi;


AccountingCodesApi apiInstance = new AccountingCodesApi();
POSTAccountingCodeType request = new POSTAccountingCodeType(); // POSTAccountingCodeType | 
try {
    POSTAccountingCodeResponseType result = apiInstance.pOSTAccountingCode(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingCodesApi#pOSTAccountingCode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**POSTAccountingCodeType**](POSTAccountingCodeType.md)|  |

### Return type

[**POSTAccountingCodeResponseType**](POSTAccountingCodeResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTAccountingCode"></a>
# **pUTAccountingCode**
> CommonResponseType pUTAccountingCode(acId, request)

Update an accounting code

This reference describes how to update an existing accounting code through the REST API. ## Prerequisites   If you have Z-Finance enabled on your tenant, you must have the Z-Finance Manage Accounting Code permission. See [Z-Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles). ## Limitations You can only update accounting codes that are not already associated with any transactions. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingCodesApi;


AccountingCodesApi apiInstance = new AccountingCodesApi();
String acId = "acId_example"; // String | ID of the accounting code you want to update.
PUTAccountingCodeType request = new PUTAccountingCodeType(); // PUTAccountingCodeType | 
try {
    CommonResponseType result = apiInstance.pUTAccountingCode(acId, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingCodesApi#pUTAccountingCode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **acId** | **String**| ID of the accounting code you want to update. |
 **request** | [**PUTAccountingCodeType**](PUTAccountingCodeType.md)|  |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTActivateAccountingCode"></a>
# **pUTActivateAccountingCode**
> CommonResponseType pUTActivateAccountingCode(acId)

Activate accounting code

This reference describes how to [activate an accounting code](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/G_Chart_of_Accounts/A_Set_Up_Chart_of_Accounts#Activate_or_Deactivate_an_Accounting_Code) through the REST API.  Prerequisites ------------- If you have Z-Finance enabled on your tenant, you must have the Z-Finance Manage Accounting Code permission. See [Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles). 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingCodesApi;


AccountingCodesApi apiInstance = new AccountingCodesApi();
String acId = "acId_example"; // String | ID of the accounting code you want to activate.
try {
    CommonResponseType result = apiInstance.pUTActivateAccountingCode(acId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingCodesApi#pUTActivateAccountingCode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **acId** | **String**| ID of the accounting code you want to activate. |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTDeactivateAccountingCode"></a>
# **pUTDeactivateAccountingCode**
> CommonResponseType pUTDeactivateAccountingCode(acId)

Deactivate accounting code

This reference describes how to [deactivate an accounting code](https://knowledgecenter.zuora.com/CC_Finance/A_Z-Finance/G_Chart_of_Accounts/A_Set_Up_Chart_of_Accounts#Activate_or_Deactivate_an_Accounting_Code) through the REST API.  ## Prerequisites If you have Z-Finance enabled on your tenant, you must have the Z-Finance Manage Accounting Code permission. See [Z-Finance Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/f_Finance_Roles). ## Limitations You can only deactivate accounting codes that are not associated with any transactions.  You cannot disable accounting codes of type AccountsReceivable. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingCodesApi;


AccountingCodesApi apiInstance = new AccountingCodesApi();
String acId = "acId_example"; // String | ID of the accounting code you want to deactivate.
try {
    CommonResponseType result = apiInstance.pUTDeactivateAccountingCode(acId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingCodesApi#pUTDeactivateAccountingCode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **acId** | **String**| ID of the accounting code you want to deactivate. |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyDELETEAccountingCode"></a>
# **proxyDELETEAccountingCode**
> ProxyDeleteResponse proxyDELETEAccountingCode(id)

CRUD: Delete AccountingCode



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingCodesApi;


AccountingCodesApi apiInstance = new AccountingCodesApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEAccountingCode(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingCodesApi#proxyDELETEAccountingCode");
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

<a name="proxyGETAccountingCode"></a>
# **proxyGETAccountingCode**
> ProxyGetAccountingCode proxyGETAccountingCode(id, fields)

CRUD: Retrieve AccountingCode



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingCodesApi;


AccountingCodesApi apiInstance = new AccountingCodesApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetAccountingCode result = apiInstance.proxyGETAccountingCode(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingCodesApi#proxyGETAccountingCode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetAccountingCode**](ProxyGetAccountingCode.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPOSTAccountingCode"></a>
# **proxyPOSTAccountingCode**
> ProxyCreateOrModifyResponse proxyPOSTAccountingCode(createRequest)

CRUD: Create AccountingCode



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingCodesApi;


AccountingCodesApi apiInstance = new AccountingCodesApi();
ProxyCreateAccountingCode createRequest = new ProxyCreateAccountingCode(); // ProxyCreateAccountingCode | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPOSTAccountingCode(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingCodesApi#proxyPOSTAccountingCode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyCreateAccountingCode**](ProxyCreateAccountingCode.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPUTAccountingCode"></a>
# **proxyPUTAccountingCode**
> ProxyCreateOrModifyResponse proxyPUTAccountingCode(id, modifyRequest)

CRUD: Update AccountingCode



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AccountingCodesApi;


AccountingCodesApi apiInstance = new AccountingCodesApi();
String id = "id_example"; // String | Object id
ProxyModifyAccountingCode modifyRequest = new ProxyModifyAccountingCode(); // ProxyModifyAccountingCode | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPUTAccountingCode(id, modifyRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountingCodesApi#proxyPUTAccountingCode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **modifyRequest** | [**ProxyModifyAccountingCode**](ProxyModifyAccountingCode.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

