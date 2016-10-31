
# PUTSubscriptionResponseType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **String** | Invoice amount. Preview mode only.  |  [optional]
**amountWithoutTax** | **String** | Invoice amount minus tax. Preview mode only.  |  [optional]
**chargeMetrics** | [**PUTSubscriptionResponseTypeChargeMetrics**](PUTSubscriptionResponseTypeChargeMetrics.md) |  |  [optional]
**invoiceId** | **String** | Invoice ID, if an invoice is generated during the update.  |  [optional]
**invoiceItems** | [**List&lt;PUTSubscriptionPreviewInvoiceItemsType&gt;**](PUTSubscriptionPreviewInvoiceItemsType.md) | Container for invoice items.  |  [optional]
**invoiceTargetDate** | [**LocalDate**](LocalDate.md) | Date through which charges are calculated on the invoice, as yyyy-mm-dd. Preview mode only.  |  [optional]
**paidAmount** | **String** | Payment amount, if a payment is collected  |  [optional]
**paymentId** | **String** | Payment ID, if a payment is collected.  |  [optional]
**previewChargeMetricsResponse** | **String** |  |  [optional]
**subscriptionId** | **String** | The ID of the resulting new subscription.  |  [optional]
**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional]
**taxAmount** | **String** | Tax amount on the invoice.  |  [optional]
**totalDeltaMrr** | **String** | Change in the subscription monthly recurring revenue as a result of the update.  |  [optional]
**totalDeltaTcv** | **String** | Change in the total contracted value of the subscription as a result of the update.  |  [optional]



