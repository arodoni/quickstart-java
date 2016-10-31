
# GETInvoiceType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | Customer account ID.  |  [optional]
**accountName** | **String** | Customer account name.  |  [optional]
**accountNumber** | **String** | Customer account number.  |  [optional]
**amount** | **String** | Amount of the invoice before adjustments, discounts, and similar items.  |  [optional]
**balance** | **String** | Balance remaining due on the invoice (after adjustments, discounts, etc.)  |  [optional]
**body** | **String** | The REST URL of the invoice PDF file.  |  [optional]
**createdBy** | **String** | User ID of the person who created the invoice. If a bill run generated the invoice, then this is the user ID of person who created the bill run.  |  [optional]
**creditBalanceAdjustmentAmount** | **String** | dummy |  [optional]
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**dueDate** | [**LocalDate**](LocalDate.md) | Payment due date as _yyyy-mm-dd_.  |  [optional]
**id** | **String** | Invoice ID.  |  [optional]
**invoiceDate** | [**LocalDate**](LocalDate.md) | Invoice date as _yyyy-mm-dd_  |  [optional]
**invoiceFiles** | [**List&lt;GETInvoiceFileType&gt;**](GETInvoiceFileType.md) | Information about the invoice PDF file:  |  [optional]
**invoiceItems** | [**List&lt;GETInvoicesInvoiceItemType&gt;**](GETInvoicesInvoiceItemType.md) | Information on one or more items on this invoice:  |  [optional]
**invoiceNumber** | **String** | Unique invoice ID, returned as a string.  |  [optional]
**invoiceTargetDate** | [**LocalDate**](LocalDate.md) | Date through which charges on this invoice are calculated, as _yyyy-mm-dd_.  |  [optional]
**status** | **String** | Status of the invoice in the system - not the payment status, but the status of the invoice itself. Possible values are: &#x60;Posted&#x60;, &#x60;Draft&#x60;, &#x60;Canceled&#x60;, &#x60;Error&#x60;.  |  [optional]



