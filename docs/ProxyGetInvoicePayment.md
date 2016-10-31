
# ProxyGetInvoicePayment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **Double** |  The amount of the payment. **Character limit**: 16 **Values**: a valid currency amount  |  [optional]
**createdById** | **String** |  The user ID of the person who created the invoice payment. **Character limit**: 32 **V****alues**: automatically generated  |  [optional]
**createdDate** | [**DateTime**](DateTime.md) |  The date when the invoice payment was generated. **Character limit**: 29 **V****alues**: automatically generated  |  [optional]
**id** | **String** | Object identifier. |  [optional]
**invoiceId** | **String** |  The unique ID of the invoice associated with this invoice payment. **Character limit**: 32 **Values**: a valid invoice ID  |  [optional]
**paymentId** | **String** |  The unique ID of the payment associated with this invoice payment. **Character limit**: 32 **V****alues**: a valid payment ID  |  [optional]
**refundAmount** | **Double** | Specifies the amount of a refund applied against this InvoicePayment. **Character limit**: 16 **Values**: automatically generated  |  [optional]
**updatedById** | **String** |  The ID of the user who last updated the invoice payment. **Character limit**: 32 **V****alues**: automatically generated  |  [optional]
**updatedDate** | [**DateTime**](DateTime.md) |  The date when the invoice payment was last updated. **Character limit**: 29 **V****alues**: automatically generated  |  [optional]



