
# POSTSubscriptionCancellationResponseType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cancelledDate** | [**LocalDate**](LocalDate.md) | The date that the subscription was canceled.  |  [optional]
**invoiceId** | **String** | ID of the invoice, if one is generated.  |  [optional]
**paidAmount** | **String** | Amount paid.  |  [optional]
**paymentId** | **String** | ID of the payment, if a payment is collected.  |  [optional]
**subscriptionId** | **String** | The subscription ID.  |  [optional]
**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional]
**totalDeltaMrr** | **String** | Change in the subscription monthly recurring revenue as a result of the update.  |  [optional]
**totalDeltaTcv** | **String** | Change in the total contracted value of the subscription as a result of the update.  |  [optional]



