
# PUTSubscriptionSuspendResponseType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**invoiceId** | **String** | Invoice ID, if an invoice is generated during the subscription process.  |  [optional]
**paidAmount** | **String** | Payment amount, if a payment is collected.  |  [optional]
**paymentId** | **String** | Payment ID, if a payment is collected.  |  [optional]
**resumeDate** | [**LocalDate**](LocalDate.md) | The date when subscription resumption takes effect, in the format yyyy-mm-dd.  |  [optional]
**subscriptionId** | **String** | The subscription ID.  |  [optional]
**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional]
**suspendDate** | [**LocalDate**](LocalDate.md) | The date when subscription suspension takes effect, in the format yyyy-mm-dd.  |  [optional]
**termEndDate** | [**LocalDate**](LocalDate.md) | The date when the new subscription term ends, in the format yyyy-mm-dd.  |  [optional]
**totalDeltaTcv** | **String** | Change in the total contracted value of the subscription as a result of the update.  |  [optional]



