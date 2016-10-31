
# ProxyGetInvoiceSplitItem

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdById** | **String** |  The ID of the Zuora user who created the InvoiceSplitItem object. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**createdDate** | [**DateTime**](DateTime.md) |  The date when the InvoiceSplitItem was created. **Values**: automatically generated  |  [optional]
**id** | **String** | Object identifier. |  [optional]
**invoiceDate** | [**LocalDate**](LocalDate.md) |  The generation date of the new split invoice. **Character limit**: 29 **Values**: [a valid date and time value](/CB_Billing/WA_Dates_in_Zuora/A_Date_Format_and_Datetimes_in_Zuora)  |  [optional]
**invoiceId** | **String** |  The new invoice after the split. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**invoiceSplitId** | **String** |  The ID of the invoice split associated with the individual invoice split item. **Character limit**: 32 **Values**: [a valid invoice split ID](https://knowledgecenter.zuora.com/BC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/InvoiceSplit)  |  [optional]
**paymentTerm** | **String** |  Indicates when the customer pays the split invoice. **Values**: [a valid, active payment term defined in the web-based UI administrative settings](/CB_Billing/W_Billing_and_Payments_Settings/K_Define_Payment_Terms)  |  [optional]
**splitPercentage** | **Double** |  Specifies the percentage of the original invoice that you want to be the balance of the split invoice. The total of the SplitPercentage field values for all of the InvoiceSplitItem objects in an InvoiceSplit object must equal 100. **Values**:  - If you&#39;re using WSDL 73.0 or earlier: a whole number between 1 and 100 - If you&#39;re using WSDL 74.0 or later: a decimal number with up to nine decimal places between 0.000000001 and 100, for example, &#x60;25&#x60; or &#x60;33.34&#x60;  |  [optional]
**updatedById** | **String** |  The ID of the Zuora user who last updated the invoice split. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**updatedDate** | [**DateTime**](DateTime.md) |  The date when the invoice split was last updated. **Values**: automatically generated  |  [optional]



