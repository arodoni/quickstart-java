
# ProxyGetRefundInvoicePayment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdById** | **String** |  The ID of the Zuora user who created the RefundInvoicePayment object. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**createdDate** | [**DateTime**](DateTime.md) |  The date when the RefundInvoicePayment object was created. **Character limit**: 29 **Values**: automatically generated  |  [optional]
**id** | **String** | Object identifier. |  [optional]
**invoiceId** | **String** |  The unique ID of the invoice associated with this refund invoice payment. **Character limit**: 32 **Values**: a valid invoice ID  |  [optional]
**invoicePaymentId** | **String** |  The ID of the [&#x60;InvoicePayment.Id&#x60;](https://knowledgecenter.zuora.com/BC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/InvoicePayment#Id)  |  [optional]
**refundAmount** | **Double** | Specifies the amount of a refund applied against a payment. **Character limit**: 16 **Values**: automatically generated  |  [optional]
**refundId** | **String** |  The ID of the [Refund object](https://knowledgecenter.zuora.com/BC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Refund) that created the refund. **Character limit**: 32 **Values**: inherited from &#x60;Refund.Id&#x60;  |  [optional]
**updatedById** | **String** |  The ID of the last user to update the object. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**updatedDate** | [**DateTime**](DateTime.md) |  The date when the object was last updated. **Character limit**: 29 **Values**: automatically generated  |  [optional]



