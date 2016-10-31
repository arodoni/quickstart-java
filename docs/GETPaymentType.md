
# GETPaymentType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountID** | **String** | Customer account ID.  |  [optional]
**accountName** | **String** | Customer account name.  |  [optional]
**accountNumber** | **String** | Customer account number.  |  [optional]
**amount** | **String** | Payment amount.  |  [optional]
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**effectiveDate** | [**LocalDate**](LocalDate.md) | Effective payment date as _yyyy-mm-dd_.  |  [optional]
**gatewayTransactionNumber** | **String** | Transaction ID from payment gateway.  |  [optional]
**id** | **String** | PaymentID.  |  [optional]
**paidInvoices** | [**List&lt;GETPaidInvoicesType&gt;**](GETPaidInvoicesType.md) | Information about one or more invoices to which this payment was applied:  |  [optional]
**paymentMethodID** | **String** | Payment method.  |  [optional]
**paymentNumber** | **String** | Unique payment number.  |  [optional]
**status** | **String** | Possible values are: &#x60;Draft&#x60;, &#x60;Processing&#x60;, &#x60;Processed&#x60;, &#x60;Error&#x60;, &#x60;Voided&#x60;, &#x60;Canceled&#x60;, &#x60;Posted.  |  [optional]
**type** | **String** | Possible values are: &#x60;External&#x60;, &#x60;Electronic&#x60;.  |  [optional]



