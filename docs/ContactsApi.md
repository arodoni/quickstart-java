# ContactsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEContact**](ContactsApi.md#proxyDELETEContact) | **DELETE** /object/contact/{id} | CRUD: Delete Contact
[**proxyGETContact**](ContactsApi.md#proxyGETContact) | **GET** /object/contact/{id} | CRUD: Retrieve Contact
[**proxyPOSTContact**](ContactsApi.md#proxyPOSTContact) | **POST** /object/contact | CRUD: Create Contact
[**proxyPUTContact**](ContactsApi.md#proxyPUTContact) | **PUT** /object/contact/{id} | CRUD: Update Contact


<a name="proxyDELETEContact"></a>
# **proxyDELETEContact**
> ProxyDeleteResponse proxyDELETEContact(id)

CRUD: Delete Contact



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEContact(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#proxyDELETEContact");
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

<a name="proxyGETContact"></a>
# **proxyGETContact**
> ProxyGetContact proxyGETContact(id, fields)

CRUD: Retrieve Contact



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetContact result = apiInstance.proxyGETContact(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#proxyGETContact");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetContact**](ProxyGetContact.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPOSTContact"></a>
# **proxyPOSTContact**
> ProxyCreateOrModifyResponse proxyPOSTContact(createRequest)

CRUD: Create Contact



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
ProxyCreateContact createRequest = new ProxyCreateContact(); // ProxyCreateContact | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPOSTContact(createRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#proxyPOSTContact");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createRequest** | [**ProxyCreateContact**](ProxyCreateContact.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPUTContact"></a>
# **proxyPUTContact**
> ProxyCreateOrModifyResponse proxyPUTContact(id, modifyRequest)

CRUD: Update Contact



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
String id = "id_example"; // String | Object id
ProxyModifyContact modifyRequest = new ProxyModifyContact(); // ProxyModifyContact | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPUTContact(id, modifyRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#proxyPUTContact");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **modifyRequest** | [**ProxyModifyContact**](ProxyModifyContact.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

