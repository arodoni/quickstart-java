
# ProxyCreateInvoice

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** |  | 
**adjustmentAmount** | **Double** |  The amount of the invoice adjustments associated with the invoice. **Character limi**t: 16 **Values**: a valid currency amount  | 
**body** | **String** |  Required  | 
**creditBalanceAdjustmentAmount** | **Double** |  The currency amount of the adjustment applied to the customer&#39;s credit balance. **Character limit**: 16 **Values**: a valid currency amount This field is only available if the [Zuora Global Support](http://support.zuora.com/) to enable this feature.    | 
**includesOneTime** | **Boolean** |  Specifies whether the invoice includes one-time charges. You can use this field only with the &#x60;generate()&#x60; call for the Invoice object. **Character limit**: 5 **Values**: automatically generated from one of the following: &#x60;True&#x60; (default), &#x60;False&#x60;  |  [optional]
**includesRecurring** | **Boolean** |  Specifies whether the invoice includes recurring charges. You can use this field only with the &#x60;generate() &#x60;call for the Invoice object. **Character limit**: 5 **Values**: automatically generated from one of the following: &#x60;True&#x60; (default), &#x60;False&#x60;  |  [optional]
**includesUsage** | **Boolean** |  Specifies whether the invoice includes usage charges. You can use this field only with the &#x60;generate() &#x60;call for the Invoice object. **Character limit**: 5 **Values**: automatically generated from one of the following: &#x60;True &#x60;(default), &#x60;False&#x60;  |  [optional]
**invoiceDate** | [**LocalDate**](LocalDate.md) |  Specifies the date on which to generate the invoice. **Character limit**: 29 **Version notes**: --  |  [optional]
**paymentAmount** | **Double** |  The amount of payments applied to the invoice. **Character limit**: 16 **Value**s: automatically generated  | 
**refundAmount** | **Double** |  Specifies the amount of a refund that was applied against an earlier payment on the invoice. **Character limit**: 16 **Values**: automatically generated  | 
**targetDate** | [**LocalDate**](LocalDate.md) |  This date is used to determine which charges are to be billed. All charges that are to be billed on this date or prior will be included in this bill run. **Character limit**: 29 **Version notes**: --  |  [optional]
**taxAmount** | **Double** |  The total amount of the taxes applied to the invoice. **Character limit**: 16 **Values**: automatically generated  | 
**taxExemptAmount** | **Double** |  The total amount of the invoice that is exempt from taxation. **Character limit**: 16 **Values**: automatically generated  | 



