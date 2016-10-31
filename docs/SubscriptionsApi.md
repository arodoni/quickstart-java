# SubscriptionsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gETOneSubscription**](SubscriptionsApi.md#gETOneSubscription) | **GET** /subscriptions/{subscription-key} | Get subscriptions by key
[**gETSubscription**](SubscriptionsApi.md#gETSubscription) | **GET** /subscriptions/accounts/{account-key} | Get subscriptions by account
[**pOSTSubscription**](SubscriptionsApi.md#pOSTSubscription) | **POST** /subscriptions | Create subscription
[**pOSTSubscriptionCancellation**](SubscriptionsApi.md#pOSTSubscriptionCancellation) | **PUT** /subscriptions/{subscription-key}/cancel | Cancel subscription
[**pOSTSubscriptionPreview**](SubscriptionsApi.md#pOSTSubscriptionPreview) | **POST** /subscriptions/preview | Preview subscription
[**pUTRenewSubscription**](SubscriptionsApi.md#pUTRenewSubscription) | **PUT** /subscriptions/{subscription-key}/renew | Renew subscription
[**pUTSubscription**](SubscriptionsApi.md#pUTSubscription) | **PUT** /subscriptions/{subscription-key} | Update subscription
[**pUTSubscriptionResume**](SubscriptionsApi.md#pUTSubscriptionResume) | **PUT** /subscriptions/{subscription-key}/resume | Resume subscription
[**pUTSubscriptionSuspend**](SubscriptionsApi.md#pUTSubscriptionSuspend) | **PUT** /subscriptions/{subscription-key}/suspend | Suspend subscription
[**proxyDELETESubscription**](SubscriptionsApi.md#proxyDELETESubscription) | **DELETE** /object/subscription/{id} | CRUD: Delete Subscription
[**proxyGETSubscription**](SubscriptionsApi.md#proxyGETSubscription) | **GET** /object/subscription/{id} | CRUD: Retrieve Subscription
[**proxyPOSTSubscription**](SubscriptionsApi.md#proxyPOSTSubscription) | **POST** /object/subscription | CRUD: Create Subscription
[**proxyPUTSubscription**](SubscriptionsApi.md#proxyPUTSubscription) | **PUT** /object/subscription/{id} | CRUD: Update Subscription


<a name="gETOneSubscription"></a>
# **gETOneSubscription**
> GETSubscriptionTypeWithSuccess gETOneSubscription(subscriptionKey, chargeDetail)

Get subscriptions by key

This REST API reference describes how to retrieve detailed information about a specified subscription in the latest version. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
String subscriptionKey = "subscriptionKey_example"; // String | Possible values are:   * a subscription number   * a subscription ID 
String chargeDetail = "chargeDetail_example"; // String |  The segmented rate plan charges. When an amendment results in a change to a charge, Zuora creates a segmented rate plan charge. Use this field to track segment charges.  Possible values are:   * __last-segment__: (Default) The last rate plan charge on the subscription. The last rate plan charge is the last one in the order of time on the subscription rather than the most recent changed charge on the subscription.  * __current-segment__: The segmented charge that is active on today’s date (effectiveStartDate <= today’s date < effectiveEndDate).    * __all-segments__: All the segmented charges.   * __specific-segment&as-of-date=date__: The segmented charge that is active on a date you specified (effectiveStartDate <= specific date < effectiveEndDate). The format of the date is yyyy-mm-dd. 
try {
    GETSubscriptionTypeWithSuccess result = apiInstance.gETOneSubscription(subscriptionKey, chargeDetail);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#gETOneSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscriptionKey** | **String**| Possible values are:   * a subscription number   * a subscription ID  |
 **chargeDetail** | **String**|  The segmented rate plan charges. When an amendment results in a change to a charge, Zuora creates a segmented rate plan charge. Use this field to track segment charges.  Possible values are:   * __last-segment__: (Default) The last rate plan charge on the subscription. The last rate plan charge is the last one in the order of time on the subscription rather than the most recent changed charge on the subscription.  * __current-segment__: The segmented charge that is active on today’s date (effectiveStartDate &lt;&#x3D; today’s date &lt; effectiveEndDate).    * __all-segments__: All the segmented charges.   * __specific-segment&amp;as-of-date&#x3D;date__: The segmented charge that is active on a date you specified (effectiveStartDate &lt;&#x3D; specific date &lt; effectiveEndDate). The format of the date is yyyy-mm-dd.  | [optional]

### Return type

[**GETSubscriptionTypeWithSuccess**](GETSubscriptionTypeWithSuccess.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETSubscription"></a>
# **gETSubscription**
> GETSubscriptionWrapper gETSubscription(accountKey, chargeDetail)

Get subscriptions by account

Retrieves all subscriptions associated with the specified account. Zuora only returns the latest version of the subscriptions.  Subscription data is returned in reverse chronological order based on &#x60;updatedDate&#x60;. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
String accountKey = "accountKey_example"; // String |  Possible values are: * an account number * an account ID 
String chargeDetail = "chargeDetail_example"; // String | The segmented rate plan charges.  When an amendment results in a change to a charge, Zuora creates a segmented rate plan charge. Use this field to track segment charges.  Possible values are:  * `last-segment`: (Default) The last rate plan charge on the subscription. The last rate plan charge is the last one in the order of time on the subscription rather than the most recent updated charge on the subscription. * `current-segment`: The segmented charge that is active on today’s date (**effectiveStartDate** <= today’s date < **effectiveEndDate**). * `all-segments`: All the segmented charges. * `specific-segment&as-of-date=date`: The segmented charge that is active on a date you specified (**effectiveStartDate** <= specific date < **effectiveEndDate**). The format of the date is yyyy-mm-dd. 
try {
    GETSubscriptionWrapper result = apiInstance.gETSubscription(accountKey, chargeDetail);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#gETSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountKey** | **String**|  Possible values are: * an account number * an account ID  |
 **chargeDetail** | **String**| The segmented rate plan charges.  When an amendment results in a change to a charge, Zuora creates a segmented rate plan charge. Use this field to track segment charges.  Possible values are:  * &#x60;last-segment&#x60;: (Default) The last rate plan charge on the subscription. The last rate plan charge is the last one in the order of time on the subscription rather than the most recent updated charge on the subscription. * &#x60;current-segment&#x60;: The segmented charge that is active on today’s date (**effectiveStartDate** &lt;&#x3D; today’s date &lt; **effectiveEndDate**). * &#x60;all-segments&#x60;: All the segmented charges. * &#x60;specific-segment&amp;as-of-date&#x3D;date&#x60;: The segmented charge that is active on a date you specified (**effectiveStartDate** &lt;&#x3D; specific date &lt; **effectiveEndDate**). The format of the date is yyyy-mm-dd.  | [optional]

### Return type

[**GETSubscriptionWrapper**](GETSubscriptionWrapper.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pOSTSubscription"></a>
# **pOSTSubscription**
> POSTSubscriptionResponseType pOSTSubscription(request, zuoraVersion)

Create subscription

This REST API reference describes how to create a new subscription for an existing customer account.  ## Notes If invoiceCollect is &#x60;true&#x60;, the call will not return success &#x3D; &#x60;true&#x60; unless the subscription, invoice, and payment are all successful.  Default values for **customerAcceptanceDate** and **serviceActivationDate** are set as follows.  |        | serviceActivationDate(SA) specified          | serviceActivationDate (SA) NOT specified  | | ------------- |:-------------:| -----:| | customerAcceptanceDate (CA) specified| SA uses value in the request call; CA uses value in the request call| CA uses value in the request call;SA uses CE as default | | customerAcceptanceDate (CA) NOT specified      | SA uses value in the request call; CA uses SA as default |   SA and CA use CE as default | 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
POSTSubscriptionType request = new POSTSubscriptionType(); // POSTSubscriptionType | 
String zuoraVersion = "zuoraVersion_example"; // String | The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information.
try {
    POSTSubscriptionResponseType result = apiInstance.pOSTSubscription(request, zuoraVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#pOSTSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**POSTSubscriptionType**](POSTSubscriptionType.md)|  |
 **zuoraVersion** | **String**| The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. | [optional]

### Return type

[**POSTSubscriptionResponseType**](POSTSubscriptionResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pOSTSubscriptionCancellation"></a>
# **pOSTSubscriptionCancellation**
> POSTSubscriptionCancellationResponseType pOSTSubscriptionCancellation(subscriptionKey, request, zuoraVersion)

Cancel subscription

This REST API reference describes how to cancel an active subscription. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
String subscriptionKey = "subscriptionKey_example"; // String | Subscription number or ID. Subscription status must be `Active`.
POSTSubscriptionCancellationType request = new POSTSubscriptionCancellationType(); // POSTSubscriptionCancellationType | 
String zuoraVersion = "zuoraVersion_example"; // String | The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information.
try {
    POSTSubscriptionCancellationResponseType result = apiInstance.pOSTSubscriptionCancellation(subscriptionKey, request, zuoraVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#pOSTSubscriptionCancellation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscriptionKey** | **String**| Subscription number or ID. Subscription status must be &#x60;Active&#x60;. |
 **request** | [**POSTSubscriptionCancellationType**](POSTSubscriptionCancellationType.md)|  |
 **zuoraVersion** | **String**| The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. | [optional]

### Return type

[**POSTSubscriptionCancellationResponseType**](POSTSubscriptionCancellationResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pOSTSubscriptionPreview"></a>
# **pOSTSubscriptionPreview**
> POSTSubscriptionPreviewResponseType pOSTSubscriptionPreview(request)

Preview subscription

The REST API reference describes how to create a new subscription in preview mode. This call does not require a valid customer account. It can be used to show potential new customers a preview of a subscription with complete details and charges before creating an account, or to let existing customers preview a subscription with all charges before committing.  ## Notes Default values for **customerAcceptanceDate** and **serviceActivationDate** are set as follows.  |        | serviceActivationDate (SA) specified          | serviceActivationDate (SA) NOT specified  | | ------------- |:-------------:| -----:| | customerAcceptanceDate (CA) specified      | SA uses value in the request call; CA uses value in the request call| CA uses value in the request call;SA uses CE as default | | customerAcceptanceDate (CA) NOT specified      | SA uses value in the request call; CA uses SA as default |   SA and CA use CE as default | 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
POSTSubscriptionPreviewType request = new POSTSubscriptionPreviewType(); // POSTSubscriptionPreviewType | 
try {
    POSTSubscriptionPreviewResponseType result = apiInstance.pOSTSubscriptionPreview(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#pOSTSubscriptionPreview");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**POSTSubscriptionPreviewType**](POSTSubscriptionPreviewType.md)|  |

### Return type

[**POSTSubscriptionPreviewResponseType**](POSTSubscriptionPreviewResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTRenewSubscription"></a>
# **pUTRenewSubscription**
> PUTRenewSubscriptionResponseType pUTRenewSubscription(subscriptionKey, request, zuoraVersion)

Renew subscription

Renews a termed subscription using existing renewal terms. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
String subscriptionKey = "subscriptionKey_example"; // String | Subscription number or ID
PUTRenewSubscriptionType request = new PUTRenewSubscriptionType(); // PUTRenewSubscriptionType | 
String zuoraVersion = "zuoraVersion_example"; // String | The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information.
try {
    PUTRenewSubscriptionResponseType result = apiInstance.pUTRenewSubscription(subscriptionKey, request, zuoraVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#pUTRenewSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscriptionKey** | **String**| Subscription number or ID |
 **request** | [**PUTRenewSubscriptionType**](PUTRenewSubscriptionType.md)|  |
 **zuoraVersion** | **String**| The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. | [optional]

### Return type

[**PUTRenewSubscriptionResponseType**](PUTRenewSubscriptionResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTSubscription"></a>
# **pUTSubscription**
> PUTSubscriptionResponseType pUTSubscription(subscriptionKey, request, zuoraVersion)

Update subscription

Use this call to make the following kinds of changes to a subscription:   * Add a note   * Change the renewal term or auto-renewal flag   * Change the term length or change between evergreen and termed   * Add a new product rate plan   * Remove an existing subscription rate plan   * Change the quantity or price of an existing subscription rate plan  ## Notes * The Update Subscription call creates a new subscription, which has the old subscription number but a new subscription ID.  The old subscription is canceled but remains in the system. * In one request, this call can make:   * Up to 9 combined add, update, and remove changes   * No more than 1 change to terms &amp; conditions * Updates are performed in the following sequence:   1. First change the notes on the existing subscription, if requested.   2. Then change the terms and conditions, if requested.   3. Then perform the remaining amendments based upon the effective dates specified. If multiple amendments have the same contract-effective dates, then execute adds before updates, and updates before removes. * The update operation is atomic. If any of the updates fails, the entire operation is rolled back.  ## Override a Tiered Price There are two ways you override a tiered price:  * Override a specific tier number For example: &#x60;tiers[{tier:1,price:8},{tier:2,price:6}]&#x60;  * Override the entire tier structure For example:  &#x60;tiers[{tier:1,price:8,startingUnit:1,endingUnit:100,priceFormat:\&quot;FlatFee\&quot;}, {tier:2,price:6,startingUnit:101,priceFormat:\&quot;FlatFee\&quot;}]&#x60;  If you just override a specific tier, do not include the &#x60;startingUnit&#x60; field in the request. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
String subscriptionKey = "subscriptionKey_example"; // String | Subscription number or ID.
PUTSubscriptionType request = new PUTSubscriptionType(); // PUTSubscriptionType | 
String zuoraVersion = "zuoraVersion_example"; // String | The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information.
try {
    PUTSubscriptionResponseType result = apiInstance.pUTSubscription(subscriptionKey, request, zuoraVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#pUTSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscriptionKey** | **String**| Subscription number or ID. |
 **request** | [**PUTSubscriptionType**](PUTSubscriptionType.md)|  |
 **zuoraVersion** | **String**| The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. | [optional]

### Return type

[**PUTSubscriptionResponseType**](PUTSubscriptionResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTSubscriptionResume"></a>
# **pUTSubscriptionResume**
> PUTSubscriptionResumeResponseType pUTSubscriptionResume(subscriptionKey, request, zuoraVersion)

Resume subscription

This REST API reference describes how to resume a suspended subscription.   This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://suport.zuora.com).  

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
String subscriptionKey = "subscriptionKey_example"; // String | Subscription number or ID. Subscription status must be Active.
PUTSubscriptionResumeType request = new PUTSubscriptionResumeType(); // PUTSubscriptionResumeType | 
String zuoraVersion = "zuoraVersion_example"; // String | The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information.
try {
    PUTSubscriptionResumeResponseType result = apiInstance.pUTSubscriptionResume(subscriptionKey, request, zuoraVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#pUTSubscriptionResume");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscriptionKey** | **String**| Subscription number or ID. Subscription status must be Active. |
 **request** | [**PUTSubscriptionResumeType**](PUTSubscriptionResumeType.md)|  |
 **zuoraVersion** | **String**| The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. | [optional]

### Return type

[**PUTSubscriptionResumeResponseType**](PUTSubscriptionResumeResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTSubscriptionSuspend"></a>
# **pUTSubscriptionSuspend**
> PUTSubscriptionSuspendResponseType pUTSubscriptionSuspend(subscriptionKey, request, zuoraVersion)

Suspend subscription

This REST API reference describes how to suspend an active subscription.   This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://suport.zuora.com). 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
String subscriptionKey = "subscriptionKey_example"; // String | Subscription number or ID. Subscription status must be Active.
PUTSubscriptionSuspendType request = new PUTSubscriptionSuspendType(); // PUTSubscriptionSuspendType | 
String zuoraVersion = "zuoraVersion_example"; // String | The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information.
try {
    PUTSubscriptionSuspendResponseType result = apiInstance.pUTSubscriptionSuspend(subscriptionKey, request, zuoraVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#pUTSubscriptionSuspend");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscriptionKey** | **String**| Subscription number or ID. Subscription status must be Active. |
 **request** | [**PUTSubscriptionSuspendType**](PUTSubscriptionSuspendType.md)|  |
 **zuoraVersion** | **String**| The minor version of the Zuora REST API. You only need to set this parameter if you use the __collect__ or __invoice__ field. See [REST API Basics](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information. | [optional]

### Return type

[**PUTSubscriptionSuspendResponseType**](PUTSubscriptionSuspendResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyDELETESubscription"></a>
# **proxyDELETESubscription**
> ProxyDeleteResponse proxyDELETESubscription(id)

CRUD: Delete Subscription



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETESubscription(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#proxyDELETESubscription");
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

<a name="proxyGETSubscription"></a>
# **proxyGETSubscription**
> ProxyGetSubscription proxyGETSubscription(id, fields)

CRUD: Retrieve Subscription



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetSubscription result = apiInstance.proxyGETSubscription(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#proxyGETSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetSubscription**](ProxyGetSubscription.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPOSTSubscription"></a>
# **proxyPOSTSubscription**
> ProxyCreateOrModifyResponse proxyPOSTSubscription(createRequest)

CRUD: Create Subscription



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
ProxyCreateSubscription createRequest = new ProxyCreateSubscription(); // ProxyCreateSubscription | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPOSTSubscription(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#proxyPOSTSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyCreateSubscription**](ProxyCreateSubscription.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPUTSubscription"></a>
# **proxyPUTSubscription**
> ProxyCreateOrModifyResponse proxyPUTSubscription(id, modifyRequest)

CRUD: Update Subscription



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
String id = "id_example"; // String | Object id
ProxyModifySubscription modifyRequest = new ProxyModifySubscription(); // ProxyModifySubscription | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPUTSubscription(id, modifyRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#proxyPUTSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **modifyRequest** | [**ProxyModifySubscription**](ProxyModifySubscription.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

