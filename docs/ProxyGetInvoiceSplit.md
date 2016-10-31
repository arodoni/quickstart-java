
# ProxyGetInvoiceSplit

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdById** | **String** | The ID of the Zuora user who created the InvoiceSplit object. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**createdDate** | [**DateTime**](DateTime.md) | The date when the InvoiceSplit object was created. **Character limit**: 29 **Values**: automatically generated  |  [optional]
**id** | **String** | Object identifier. |  [optional]
**invoiceId** | **String** |  The ID of the original invoice that the InvoiceSplit object splits. This field becomes read-only after the InvoiceSplit object is created. **Character limit**: 32 **Values**: a valid [invoice ID](https://knowledgecenter.zuora.com/BC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Invoice)  |  [optional]
**updatedById** | **String** | The ID of the Zuora user who last updated the invoice split. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**updatedDate** | [**DateTime**](DateTime.md) | The date when the invoice split was last updated. **Values**: automatically generated  |  [optional]



