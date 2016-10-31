
# POSTSubscriptionPreviewResponseType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **String** | Invoice amount.  |  [optional]
**amountWithoutTax** | **String** | Invoice amount minus tax.  |  [optional]
**chargeMetrics** | [**POSTSubscriptionPreviewResponseTypeChargeMetrics**](POSTSubscriptionPreviewResponseTypeChargeMetrics.md) |  |  [optional]
**contractedMrr** | **String** | Monthly recurring revenue of the subscription.  |  [optional]
**invoiceItems** | [**List&lt;POSTSubscriptionPreviewInvoiceItemsType&gt;**](POSTSubscriptionPreviewInvoiceItemsType.md) | Container for invoice items.  |  [optional]
**invoiceTargetDate** | [**LocalDate**](LocalDate.md) | Date through which charges are calculated on the invoice, as yyyy-mm-dd.  |  [optional]
**previewChargeMetricsResponse** | **String** |  |  [optional]
**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional]
**taxAmount** | **String** | Tax amount on the invoice.  |  [optional]
**totalContractedValue** | **String** | Total contracted value of the subscription.  |  [optional]



