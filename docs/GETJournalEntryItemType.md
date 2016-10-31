
# GETJournalEntryItemType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountingCodeName** | **String** | Name of the accounting code.  |  [optional]
**accountingCodeType** | **String** | Accounting code type. The accounting code types are:  * &#x60;AccountsReceivable&#x60; *  &#x60;Cash&#x60; *  &#x60;OtherAssets&#x60; *  &#x60;CustomerCashOnAccount &#x60; * &#x60;DeferredRevenue&#x60; * &#x60;SalesTaxPayable&#x60; * &#x60;OtherLiabilities&#x60; * &#x60;SalesRevenue&#x60; * &#x60;SalesDiscounts&#x60; * &#x60;OtherRevenue&#x60;  * &#x60;OtherEquity&#x60; * &#x60;BadDebt&#x60;   * &#x60;OtherExpenses&#x60;  |  [optional]
**amount** | **String** | Journal entry item amount in transaction currency.  |  [optional]
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**glAccountName** | **String** | The account number in the general ledger (GL) that corresponds to the accounting code.  |  [optional]
**glAccountNumber** | **String** | The account name in the general ledger (GL) that corresponds to the accounting code.  |  [optional]
**homeCurrencyAmount** | **String** | Journal entry item amount in home currency.  |  [optional]
**type** | **String** | Type of journal entry item. An enum with the value &#x60;Credit&#x60; or &#x60;Debit&#x60;.  |  [optional]



