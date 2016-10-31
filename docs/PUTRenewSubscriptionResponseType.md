
# PUTRenewSubscriptionResponseType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**invoiceId** | **String** | Invoice ID, if one is generated.  |  [optional]
**paidAmount** | **String** | Payment amount, if payment is collected.  |  [optional]
**paymentId** | **String** | Payment ID, if payment is collected.  |  [optional]
**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional]
**termEndDate** | [**LocalDate**](LocalDate.md) | Date the new subscription term ends, as yyyy-mm-dd.  |  [optional]
**termStartDate** | [**LocalDate**](LocalDate.md) | Date the new subscription term begins, as yyyy-mm-dd.  |  [optional]
**totalDeltaMrr** | **String** | Change in the subscription monthly recurring revenue as a result of the update. For a renewal, this is the MRR of the subscription in the new term.  |  [optional]
**totalDeltaTcv** | **String** | Change in the total contracted value of the subscription as a result of the update. For a renewal, this is the TCV of the subscription in the new term.  |  [optional]



