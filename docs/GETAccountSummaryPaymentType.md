
# GETAccountSummaryPaymentType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**effectiveDate** | [**LocalDate**](LocalDate.md) | Effective date as &#x60;yyyy-mm-dd&#x60;.  |  [optional]
**id** | **String** | Payment ID.  |  [optional]
**paidInvoices** | [**List&lt;GETAccountSummaryPaymentInvoiceType&gt;**](GETAccountSummaryPaymentInvoiceType.md) | Container for paid invoices for this subscription.  |  [optional]
**paymentNumber** | **String** | Payment number.  |  [optional]
**paymentType** | **String** | Payment type; possible values are: &#x60;External&#x60;, &#x60;Electronic&#x60;.  |  [optional]
**status** | **String** | Payment status. Possible values are: &#x60;Draft&#x60;, &#x60;Processing&#x60;, &#x60;Processed&#x60;, &#x60;Error&#x60;, &#x60;Voided&#x60;, &#x60;Canceled&#x60;, &#x60;Posted&#x60;.  |  [optional]



