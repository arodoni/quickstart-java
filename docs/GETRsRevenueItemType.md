
# GETRsRevenueItemType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountingPeriodEndDate** | [**LocalDate**](LocalDate.md) | The accounting period end date. The accounting period end date of the open-ended accounting period is null.  |  [optional]
**accountingPeriodName** | **String** | Name of the accounting period. The open-ended accounting period is named &#x60;Open-Ended&#x60;.   |  [optional]
**accountingPeriodStartDate** | [**LocalDate**](LocalDate.md) | The accounting period start date.  |  [optional]
**amount** | **String** | The amount of the revenue item.  |  [optional]
**currency** | **String** | The type of currency used.  |  [optional]
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**deferredRevenueAccountingCode** | **String** | The accounting code for deferred revenue, such as Monthly Recurring Liability. Required only when &#x60;overrideChargeAccountingCodes&#x60; is &#x60;true&#x60;. Otherwise this value is ignored.  |  [optional]
**deferredRevenueAccountingCodeType** | **String** | The type associated with the deferred revenue accounting code, such as Deferred Revenue. Required only when &#x60;overrideChargeAccountingCodes&#x60; is &#x60;true&#x60;. Otherwise this value is ignored.  |  [optional]
**isAccountingPeriodClosed** | **Boolean** | Indicates if the accounting period is closed or open.  |  [optional]
**recognizedRevenueAccountingCode** | **String** | The accounting code for recognized revenue, such as Monthly Recurring Charges or Overage Charges. Required only when &#x60;overrideChargeAccountingCodes&#x60; is &#x60;true&#x60;. Otherwise the value is ignored.  |  [optional]
**recognizedRevenueAccountingCodeType** | **String** | The type associated with the recognized revenue accounting code, such as Sales Revenue or Sales Discount. Required only when &#x60;overrideChargeAccountingCodes&#x60; is &#x60;true&#x60;. Otherwise this value is ignored.  |  [optional]



