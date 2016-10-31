# TransactionsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gETInvoice**](TransactionsApi.md#gETInvoice) | **GET** /transactions/invoices/accounts/{account-key} | Get invoices
[**gETPayments**](TransactionsApi.md#gETPayments) | **GET** /transactions/payments/accounts/{account-key} | Get payments


<a name="gETInvoice"></a>
# **gETInvoice**
> GETInvoiceFileWrapper gETInvoice(accountKey)

Get invoices

Retrieves invoices for a specified account.  Invoices are returned in reverse chronological order by **updatedDate**. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TransactionsApi;


TransactionsApi apiInstance = new TransactionsApi();
String accountKey = "accountKey_example"; // String | Account number or account ID. 
try {
    GETInvoiceFileWrapper result = apiInstance.gETInvoice(accountKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionsApi#gETInvoice");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountKey** | **String**| Account number or account ID.  |

### Return type

[**GETInvoiceFileWrapper**](GETInvoiceFileWrapper.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETPayments"></a>
# **gETPayments**
> GETPaymentsType gETPayments(accountKey)

Get payments

Retrieves payments for a specified account. Payments are returned in reverse chronological order by **updatedDate**. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TransactionsApi;


TransactionsApi apiInstance = new TransactionsApi();
String accountKey = "accountKey_example"; // String | Account number or account ID.
try {
    GETPaymentsType result = apiInstance.gETPayments(accountKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionsApi#gETPayments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountKey** | **String**| Account number or account ID. |

### Return type

[**GETPaymentsType**](GETPaymentsType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

