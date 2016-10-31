
# GETAccountingCodeItemType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category** | **String** | The category associated with the accounting code.  Possible values: * &#x60;Assets&#x60; * &#x60;Liabilities&#x60; * &#x60;Equity&#x60; * &#x60;Revenue&#x60; * &#x60;Expenses&#x60;  |  [optional]
**createdBy** | **String** | The ID of the user who created the accounting code.  |  [optional]
**createdOn** | [**DateTime**](DateTime.md) | Date and time when the accounting code was created.  |  [optional]
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**glAccountName** | **String** | Name of the account in your general ledger.  Field only available if you have Z-Finance enabled.  |  [optional]
**glAccountNumber** | **String** | Account number in your general ledger.  Field only available if you have Z-Finance enabled.  |  [optional]
**id** | **String** | ID of the accounting code.  |  [optional]
**name** | **String** | Name of the accounting code.  |  [optional]
**notes** | **String** | Any optional notes for the accounting code.  |  [optional]
**status** | **String** | The accounting code status.  Possible values: * &#x60;Active&#x60; * &#x60;Inactive&#x60;  |  [optional]
**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional]
**type** | **String** | Accounting code type.  Possible values: * &#x60;AccountsReceivable&#x60; * &#x60;Cash&#x60; * &#x60;OtherAssets&#x60; * &#x60;CustomerCashOnAccount&#x60; * &#x60;DeferredRevenue&#x60; * &#x60;SalesTaxPayable&#x60; * &#x60;OtherLiabilities&#x60; * &#x60;SalesRevenue&#x60; * &#x60;SalesDiscounts&#x60; * &#x60;OtherRevenue&#x60; * &#x60;OtherEquity&#x60; * &#x60;BadDebt&#x60; * &#x60;OtherExpenses&#x60;  |  [optional]
**updatedBy** | **String** | The ID of the user who last updated the accounting code.  |  [optional]
**updatedOn** | [**DateTime**](DateTime.md) | Date and time when the accounting code was last updated.  |  [optional]



