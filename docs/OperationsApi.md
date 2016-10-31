# OperationsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**pOSTTransactionInvoicePayment**](OperationsApi.md#pOSTTransactionInvoicePayment) | **POST** /operations/invoice-collect | Invoice and collect


<a name="pOSTTransactionInvoicePayment"></a>
# **pOSTTransactionInvoicePayment**
> POSTInvoiceCollectResponseType pOSTTransactionInvoicePayment(request)

Invoice and collect

Generates invoices and collects payments for a specified account.  This method can generate invoices and collect payments on the invoices generated, or else simply collect payment on a specified existing invoice. The customer&#39;s default payment method is used, and the full amount due is collected. The operation depends on the parameters you specify  - To generate one or more new invoices for that customer and collect payment on the generated invoice(s), leave the **invoiceId** field empty.   - To collect payment on an existing invoice, specify the invoice ID.    The operation is atomic; if any part is unsuccessful, the entire operation is rolled back.   ## Notes  Timeouts may occur when using this method on an account that has an extremely high number of subscriptions. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OperationsApi;


OperationsApi apiInstance = new OperationsApi();
POSTInvoiceCollectType request = new POSTInvoiceCollectType(); // POSTInvoiceCollectType | Customer account ID or account number.
try {
    POSTInvoiceCollectResponseType result = apiInstance.pOSTTransactionInvoicePayment(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OperationsApi#pOSTTransactionInvoicePayment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**POSTInvoiceCollectType**](POSTInvoiceCollectType.md)| Customer account ID or account number. |

### Return type

[**POSTInvoiceCollectResponseType**](POSTInvoiceCollectResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

