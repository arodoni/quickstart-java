
# ProxyModifyInvoiceAdjustment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**reasonCode** | **String** |  A code identifying the reason for the transaction. Must be an existing reason code or empty. If you do not specify a value, Zuora uses the default reason code. **Character limit**: 32 **V****alues**: a valid [reason code](/C_Zuora_User_Guides/A_Billing_and_Payments/R_Reason_Codes_for_Payment_Operations)  |  [optional]
**status** | **String** |  The status of the invoice adjustment. This field is required in &#x60;query()&#x60; calls, but is automatically generated in other calls. **Character limit**: 9 **Values**: &#x60;Canceled&#x60;, &#x60;Processed&#x60;  |  [optional]
**transferredToAccounting** | **String** |  Indicates the status of the adjustment&#39;s transfer to an external accounting system, such as NetSuite. **Character limit**: 10 **Values**: &#x60;Processing&#x60;, &#x60;Yes&#x60;, &#x60;Error&#x60;, &#x60;Ignore&#x60;  |  [optional]



