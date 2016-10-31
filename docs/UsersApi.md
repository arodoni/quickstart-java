# UsersApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**proxyDELETEUser**](UsersApi.md#proxyDELETEUser) | **DELETE** /object/user/{id} | CRUD: Delete User
[**proxyGETUser**](UsersApi.md#proxyGETUser) | **GET** /object/user/{id} | CRUD: Retrieve User
[**proxyPUTUser**](UsersApi.md#proxyPUTUser) | **PUT** /object/user/{id} | CRUD: Update User


<a name="proxyDELETEUser"></a>
# **proxyDELETEUser**
> ProxyDeleteResponse proxyDELETEUser(id)

CRUD: Delete User



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UsersApi;


UsersApi apiInstance = new UsersApi();
String id = "id_example"; // String | Object id
try {
    ProxyDeleteResponse result = apiInstance.proxyDELETEUser(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#proxyDELETEUser");
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

<a name="proxyGETUser"></a>
# **proxyGETUser**
> ProxyGetUser proxyGETUser(id, fields)

CRUD: Retrieve User



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UsersApi;


UsersApi apiInstance = new UsersApi();
String id = "id_example"; // String | Object id
String fields = "fields_example"; // String | Object fields to return
try {
    ProxyGetUser result = apiInstance.proxyGETUser(id, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#proxyGETUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **fields** | **String**| Object fields to return | [optional]

### Return type

[**ProxyGetUser**](ProxyGetUser.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxyPUTUser"></a>
# **proxyPUTUser**
> ProxyCreateOrModifyResponse proxyPUTUser(id, modifyRequest)

CRUD: Update User



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UsersApi;


UsersApi apiInstance = new UsersApi();
String id = "id_example"; // String | Object id
ProxyModifyUser modifyRequest = new ProxyModifyUser(); // ProxyModifyUser | 
try {
    ProxyCreateOrModifyResponse result = apiInstance.proxyPUTUser(id, modifyRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#proxyPUTUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Object id |
 **modifyRequest** | [**ProxyModifyUser**](ProxyModifyUser.md)|  |

### Return type

[**ProxyCreateOrModifyResponse**](ProxyCreateOrModifyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

