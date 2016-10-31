# ActionsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyActionPOSTamend**](ActionsApi.md#proxyActionPOSTamend) | **POST** /action/amend | Amend
[**proxyActionPOSTcreate**](ActionsApi.md#proxyActionPOSTcreate) | **POST** /action/create | Create
[**proxyActionPOSTdelete**](ActionsApi.md#proxyActionPOSTdelete) | **POST** /action/delete | Delete
[**proxyActionPOSTexecute**](ActionsApi.md#proxyActionPOSTexecute) | **POST** /action/execute | Execute
[**proxyActionPOSTgenerate**](ActionsApi.md#proxyActionPOSTgenerate) | **POST** /action/generate | Generate
[**proxyActionPOSTgetUserInfo**](ActionsApi.md#proxyActionPOSTgetUserInfo) | **POST** /action/getUserInfo | GetUserInfo
[**proxyActionPOSTlogin**](ActionsApi.md#proxyActionPOSTlogin) | **POST** /action/login | Login
[**proxyActionPOSTquery**](ActionsApi.md#proxyActionPOSTquery) | **POST** /action/query | Query
[**proxyActionPOSTqueryMore**](ActionsApi.md#proxyActionPOSTqueryMore) | **POST** /action/queryMore | QueryMore
[**proxyActionPOSTsubscribe**](ActionsApi.md#proxyActionPOSTsubscribe) | **POST** /action/subscribe | Subscribe
[**proxyActionPOSTupdate**](ActionsApi.md#proxyActionPOSTupdate) | **POST** /action/update | Update


<a name="proxyActionPOSTamend"></a>
# **proxyActionPOSTamend**
> ProxyActionamendResponse proxyActionPOSTamend(amendRequest)

Amend



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ActionsApi;


ActionsApi apiInstance = new ActionsApi();
ProxyActionamendRequest amendRequest = new ProxyActionamendRequest(); // ProxyActionamendRequest | 
try {
    ProxyActionamendResponse result = apiInstance.proxyActionPOSTamend(amendRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionsApi#proxyActionPOSTamend");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **amendRequest** | [**ProxyActionamendRequest**](ProxyActionamendRequest.md)|  |

### Return type

[**ProxyActionamendResponse**](ProxyActionamendResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyActionPOSTcreate"></a>
# **proxyActionPOSTcreate**
> ProxyActioncreateResponse proxyActionPOSTcreate(createRequest)

Create



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ActionsApi;


ActionsApi apiInstance = new ActionsApi();
ProxyActioncreateRequest createRequest = new ProxyActioncreateRequest(); // ProxyActioncreateRequest | 
try {
    ProxyActioncreateResponse result = apiInstance.proxyActionPOSTcreate(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionsApi#proxyActionPOSTcreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyActioncreateRequest**](ProxyActioncreateRequest.md)|  |

### Return type

[**ProxyActioncreateResponse**](ProxyActioncreateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyActionPOSTdelete"></a>
# **proxyActionPOSTdelete**
> ProxyActiondeleteResponse proxyActionPOSTdelete(deleteRequest)

Delete

Deletes one or more objects of the same type. You can specify different types in different delete calls, but each delete call must only apply to one type of object.  You can use this call with a string type of [zObject](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/zObject) and a list of IDs of that type. It returns an array of [DeleteResult](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/F_SOAP_API_Complex_Types/DeleteResult), indicating the success or failure of deleting each object.  The following information applies to this call:  * You will need to first determine the IDs for the objects you wish to delete. * You cannot pass in any null IDs. * All objects in a specific delete call must be of the same type.   ### Objects per Call 50 objects are supported in a single call.  ### Rate Limiting 1,000 calls are supported per 10-minute time window per tenant.  If you approach or exceed this limit, you will receive a 429 error. Multi-threading causes you to approach this limit more quickly. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ActionsApi;


ActionsApi apiInstance = new ActionsApi();
ProxyActiondeleteRequest deleteRequest = new ProxyActiondeleteRequest(); // ProxyActiondeleteRequest | 
try {
    ProxyActiondeleteResponse result = apiInstance.proxyActionPOSTdelete(deleteRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionsApi#proxyActionPOSTdelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deleteRequest** | [**ProxyActiondeleteRequest**](ProxyActiondeleteRequest.md)|  |

### Return type

[**ProxyActiondeleteResponse**](ProxyActiondeleteResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyActionPOSTexecute"></a>
# **proxyActionPOSTexecute**
> ProxyActionexecuteResponse proxyActionPOSTexecute(executeRequest)

Execute

Use the execute call to execute a process to split an invoice into multiple invoices. The original invoice must be in draft status. The resulting invoices are called split invoices. ## Note This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com).   To split a draft invoice into multiple split invoices:  1. Use the create call to create a separate [InvoiceSplitItem object](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/InvoiceSplitItem) for each split invoice that you want to create from the original draft invoice. 2. Use the create call to create a single [InvoiceSplit object](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/InvoiceSplit) to collect all of the InvoiceSplitItem objects. 3. Use the execute call to split the draft invoice into multiple split invoices.  You need to create InvoiceSplitItem objects and an InvoiceSplit object before you can use the execute call.   * Supported objects: InvoiceSplit * Asynchronous process: yes 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ActionsApi;


ActionsApi apiInstance = new ActionsApi();
ProxyActionexecuteRequest executeRequest = new ProxyActionexecuteRequest(); // ProxyActionexecuteRequest | 
try {
    ProxyActionexecuteResponse result = apiInstance.proxyActionPOSTexecute(executeRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionsApi#proxyActionPOSTexecute");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **executeRequest** | [**ProxyActionexecuteRequest**](ProxyActionexecuteRequest.md)|  |

### Return type

[**ProxyActionexecuteResponse**](ProxyActionexecuteResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyActionPOSTgenerate"></a>
# **proxyActionPOSTgenerate**
> ProxyActiongenerateResponse proxyActionPOSTgenerate(generateRequest)

Generate

Use the generate call to generate an on demand invoice for a specific customer. This process is similar to the process in the Zuora user interface in which you create an ad-hoc bill run for a specific customer account.  * Supported objects: Invoice * Asynchronous process: yes  The id of the generated invoice is returned in the response. If multiple invoices are generated, only the id of the first invoice generated is returned. This occurs when an account has multiple subscriptions with the [invoice subscription separately](https://knowledgecenter.zuora.com/BC_Subscription_Management/Subscriptions/B_Creating_Subscriptions/Invoicing_Subscriptions_Separately) option enabled.  ## Limits Rate limit: 8000 calls per 10-minute block, per-tenant  If you approach or exceed the limits, then you receive a 429 error. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ActionsApi;


ActionsApi apiInstance = new ActionsApi();
ProxyActiongenerateRequest generateRequest = new ProxyActiongenerateRequest(); // ProxyActiongenerateRequest | 
try {
    ProxyActiongenerateResponse result = apiInstance.proxyActionPOSTgenerate(generateRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionsApi#proxyActionPOSTgenerate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **generateRequest** | [**ProxyActiongenerateRequest**](ProxyActiongenerateRequest.md)|  |

### Return type

[**ProxyActiongenerateResponse**](ProxyActiongenerateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyActionPOSTgetUserInfo"></a>
# **proxyActionPOSTgetUserInfo**
> ProxyActiongetUserInfoResponse proxyActionPOSTgetUserInfo()

GetUserInfo



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ActionsApi;


ActionsApi apiInstance = new ActionsApi();
try {
    ProxyActiongetUserInfoResponse result = apiInstance.proxyActionPOSTgetUserInfo();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionsApi#proxyActionPOSTgetUserInfo");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ProxyActiongetUserInfoResponse**](ProxyActiongetUserInfoResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyActionPOSTlogin"></a>
# **proxyActionPOSTlogin**
> ProxyActionloginResponse proxyActionPOSTlogin(loginRequest)

Login



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ActionsApi;


ActionsApi apiInstance = new ActionsApi();
ProxyActionloginRequest loginRequest = new ProxyActionloginRequest(); // ProxyActionloginRequest | 
try {
    ProxyActionloginResponse result = apiInstance.proxyActionPOSTlogin(loginRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionsApi#proxyActionPOSTlogin");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **loginRequest** | [**ProxyActionloginRequest**](ProxyActionloginRequest.md)|  |

### Return type

[**ProxyActionloginResponse**](ProxyActionloginResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyActionPOSTquery"></a>
# **proxyActionPOSTquery**
> ProxyActionqueryResponse proxyActionPOSTquery(queryRequest)

Query

The query call sends a query expression by specifying the object to query, the fields to retrieve from that object, and any filters to determine whether a given object should be queried.   You can use [Zuora Object Query Language](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/M_Zuora_Object_Query_Language) construct those queries, passing them through the &#x60;queryString&#x60;.   Once the call is made, the API executes the query against the specified object and returns a query response object to your application. Your application can then iterate through rows in the query response to retrieve information.  ## Limitations   This call has the following limitations:  * All keywords must be in lower case. * The number of records returned is limited to 2000 records 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ActionsApi;


ActionsApi apiInstance = new ActionsApi();
ProxyActionqueryRequest queryRequest = new ProxyActionqueryRequest(); // ProxyActionqueryRequest | 
try {
    ProxyActionqueryResponse result = apiInstance.proxyActionPOSTquery(queryRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionsApi#proxyActionPOSTquery");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **queryRequest** | [**ProxyActionqueryRequest**](ProxyActionqueryRequest.md)|  |

### Return type

[**ProxyActionqueryResponse**](ProxyActionqueryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyActionPOSTqueryMore"></a>
# **proxyActionPOSTqueryMore**
> ProxyActionqueryMoreResponse proxyActionPOSTqueryMore(queryMoreRequest)

QueryMore

Use queryMore to request additional results from a previous query call. If your initial query call returns more than 2000 results, you can use queryMore to query for the additional results.   Any &#x60;queryLocator&#x60; results greater than 2,000, will only be stored by Zuora for 5 days before it is deleted.    This call sends a request for additional results from an initial query call. If the initial query call returns more than 2000 results, you can use the &#x60;queryLocator&#x60; returned from query to request the next set of results.   **Note:** Zuora expires queryMore cursors after 15 minutes of activity.   To use queryMore, you first construct a query call. By default, the query call will return up to 2000 results. If there are more than 2000 results, query will return a boolean &#x60;done&#x60;, which will be marked as &#x60;false&#x60;, and a &#x60;queryLocator&#x60;, which is a marker you will pass to queryMore to get the next set of results. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ActionsApi;


ActionsApi apiInstance = new ActionsApi();
ProxyActionqueryMoreRequest queryMoreRequest = new ProxyActionqueryMoreRequest(); // ProxyActionqueryMoreRequest | 
try {
    ProxyActionqueryMoreResponse result = apiInstance.proxyActionPOSTqueryMore(queryMoreRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionsApi#proxyActionPOSTqueryMore");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **queryMoreRequest** | [**ProxyActionqueryMoreRequest**](ProxyActionqueryMoreRequest.md)|  |

### Return type

[**ProxyActionqueryMoreResponse**](ProxyActionqueryMoreResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyActionPOSTsubscribe"></a>
# **proxyActionPOSTsubscribe**
> ProxyActionsubscribeResponse proxyActionPOSTsubscribe(subscribeRequest)

Subscribe



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ActionsApi;


ActionsApi apiInstance = new ActionsApi();
ProxyActionsubscribeRequest subscribeRequest = new ProxyActionsubscribeRequest(); // ProxyActionsubscribeRequest | 
try {
    ProxyActionsubscribeResponse result = apiInstance.proxyActionPOSTsubscribe(subscribeRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionsApi#proxyActionPOSTsubscribe");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscribeRequest** | [**ProxyActionsubscribeRequest**](ProxyActionsubscribeRequest.md)|  |

### Return type

[**ProxyActionsubscribeResponse**](ProxyActionsubscribeResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyActionPOSTupdate"></a>
# **proxyActionPOSTupdate**
> ProxyActionupdateResponse proxyActionPOSTupdate(updateRequest)

Update



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ActionsApi;


ActionsApi apiInstance = new ActionsApi();
ProxyActionupdateRequest updateRequest = new ProxyActionupdateRequest(); // ProxyActionupdateRequest | 
try {
    ProxyActionupdateResponse result = apiInstance.proxyActionPOSTupdate(updateRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActionsApi#proxyActionPOSTupdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updateRequest** | [**ProxyActionupdateRequest**](ProxyActionupdateRequest.md)|  |

### Return type

[**ProxyActionupdateResponse**](ProxyActionupdateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

