
# ProxyGetCreditBalanceAdjustment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** |  The account ID of the credit balance&#39;s account. Zuora generates this value from the source transaction. **Character limit**: 32 **V****alues**: automatically generated from:  - CreditBalanceAdjustment.SourceTransactionId or - CreditBalanceAdjustment.SourceTransactionNumber  |  [optional]
**accountingCode** | **String** |  The [Chart of Accounts](/CB_Billing/W_Billing_and_Payments_Settings/V_Configure_Accounting_Codes/D_Set_Up_Chart_of_Accounts)  |  [optional]
**adjustmentDate** | [**LocalDate**](LocalDate.md) |  The date when the credit balance adjustment is applied. **Character limit**: 29 **Values**: automatically generated  |  [optional]
**amount** | **Double** |  The amount of the adjustment. **Character limit**: 16 **Values**: a valid currency amount  |  [optional]
**cancelledOn** | [**DateTime**](DateTime.md) |  The date when the credit balance adjustment was canceled. **Character limit**: 29 **Values**: automatically generated  |  [optional]
**comment** | **String** |  Use this field to record comments about the credit balance adjustment. **Character limit**: 255 **Values**: a string of 255 characters or fewer  |  [optional]
**createdById** | **String** |  The user ID of the person who created the credit balance adjustment. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**createdDate** | [**DateTime**](DateTime.md) |  The date when the credit balance adjustmentwas generated. **Character limit**: 29 **Values**: automatically generated  |  [optional]
**id** | **String** | Object identifier. |  [optional]
**integrationIdNS** | **String** |  |  [optional]
**integrationStatusNS** | **String** |  |  [optional]
**number** | **String** |  A unique identifier for the credit balance adjustment. Zuora generates this number in the format, &lt;em&gt;CBA-xxxxxxxx&lt;/em&gt;, such as CBA-00375919. **Character limit**: 255 **Values**: automatically generated  |  [optional]
**reasonCode** | **String** |  A code identifying the reason for the transaction. Must be an existing reason code or empty. If you do not specify a value, Zuora uses the default reason code. **Character limit**: 32 **V****alues**: a valid [reason code](/CB_Billing/K_Payment_Operations/Reason_Codes_for_Payment_Operations)  |  [optional]
**referenceId** | **String** |  The ID of the payment that the credit balance adjustment is for. **Character limit**: 32 **Values**: a string of 60 characters or fewer  |  [optional]
**sourceTransactionId** | **String** |  The ID of the object that the credit balance adjustment is applied to. You must specify a value for either the &#x60;SourceTransactionId&#x60; field or the &#x60;SourceTransactionNumber&#x60; field. **Character limit**: 32 **Values**: one of the following:  - InvoiceId - PaymentId - RefundId  |  [optional]
**sourceTransactionNumber** | **String** |  The number of the object that the credit balance adjustment is applied to. You must specify a value for either the &#x60;SourceTransactionId&#x60; field or the &#x60;SourceTransactionNumber&#x60; field. **Character limit**: 50 **Values**: one of the following:  - InvoiceNumber - PaymentNumber - RefundNumber  |  [optional]
**sourceTransactionType** | **String** |  The source of the credit balance adjustment. **Character limit**: **Values**: automatically generated; one of the following:  - Invoice - Payment - Refund  |  [optional]
**status** | **String** |  The status of the credit balance adjustment. **Character limit**: 9 **Values**: automatically generated; one of the following:  - Processed - Canceled  |  [optional]
**syncDateNS** | **String** |  |  [optional]
**transferredToAccounting** | **String** |  Indicates the status of the credit balance adjustment&#39;s transfer to an external accounting system, such as NetSuite. **Character limit**: **Values**: one of the following:  - Processing - Yes - Error - Ignore  |  [optional]
**type** | **String** | Create Query Filter |  [optional]
**updatedById** | **String** |  The ID of the user who last updated the credit balance adjustment. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**updatedDate** | [**DateTime**](DateTime.md) |  The date when the credit balance adjustment was last updated. **Character limit**: 29 **Values**: automatically generated  |  [optional]



