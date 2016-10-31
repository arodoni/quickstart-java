
# ProxyGetTaxationItem

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountingCode** | **String** |  The [Chart of Accounts](/CB_Billing/W_Billing_and_Payments_Settings/V_Configure_Accounting_Codes/D_Set_Up_Chart_of_Accounts)  |  [optional]
**createdById** | **String** |  The ID of the user who created the taxation item. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**createdDate** | [**DateTime**](DateTime.md) |  The date when the payment was created in the Zuora system. **Character limit**: 29 **Values**: automatically generated  |  [optional]
**exemptAmount** | **Double** |  The amount of taxes or VAT for which the customer has an exemption. **Character limit**: 16 **Values**: a decimal value  |  [optional]
**id** | **String** | Object identifier. |  [optional]
**invoiceItemId** | **String** |  The ID of the specific invoice item that the taxation information applies to. **Character limit**: 32 **Values**: a valid [invoice item ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/InvoiceItem)  |  [optional]
**jurisdiction** | **String** |  The jurisdiction that applies the tax or VAT. This value is typically a state, province, county, or city. **Character limit**: 32 **Values**: a string of 32 characterrs or fewer  |  [optional]
**locationCode** | **String** |  The identifier for the location based on the value of the &#x60;TaxCode&#x60; field. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**name** | **String** |  The name of the tax rate, such as sales tax or GST. This name is displayed on invoices. **Character limit**: 128 **Values**: a string of 128 characters or fewer  |  [optional]
**taxAmount** | **Double** |  The amount of the tax applied to the charge. **Character limit**: 16 **Values**: a decimal value  |  [optional]
**taxCode** | **String** |  The tax code identifies which tax rules and tax rates to apply to a specific charge. **Character limit**: 32 **Values**: a string of 32 characters or fewer  |  [optional]
**taxCodeDescription** | **String** |  The description for the tax code. **Character limit**: 255 **Values**: a string of 255 characters or fewer  |  [optional]
**taxDate** | [**LocalDate**](LocalDate.md) |  The date that the tax is applied to the charge. **Character limit**: 29 **Values**: [a valid date and time value](/CB_Billing/WA_Dates_in_Zuora/A_Date_and_dateTime_Format)  |  [optional]
**taxRate** | **Double** |  The tax rate applied to the charge. **Character limit**: 16 **Values**: a valid decimal value  |  [optional]
**taxRateDescription** | **String** |  The description of the tax rate. **Character limit**: 255 **Values**: a string of 255 characters or fewer  |  [optional]
**taxRateType** | **String** |  The type of the tax rate applied to the charge. **Character limit**: 10 **Values**: &#x60;Percentage&#x60;, &#x60;FlatFee&#x60;  |  [optional]
**updatedById** | **String** |  The ID of the user who last updated the taxation item. **Character limit**: **Values**: automatically generated  |  [optional]
**updatedDate** | [**DateTime**](DateTime.md) | The date when the taxation item was last updated. **Character limit**: **Values**: automatically generated  |  [optional]



