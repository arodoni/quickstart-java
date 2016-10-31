
# PUTAccountingCodeType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**glAccountName** | **String** | Name of the account in your general ledger.  Field only available if you have Z-Finance enabled. Maximum of 255 characters.  |  [optional]
**glAccountNumber** | **String** | Account number in your general ledger.  Field only available if you have Z-Finance enabled. Maximum of 255 characters.  |  [optional]
**name** | **String** | Name of the accounting code.  Accounting code name must be unique. Maximum of 100 characters.  |  [optional]
**notes** | **String** | Maximum of 2,000 characters.  |  [optional]
**type** | **String** | Accounting code type.   Valid values are as follows: * &#x60;AccountsReceivable&#x60; * &#x60;Cash&#x60; * &#x60;OtherAssets&#x60; * &#x60;CustomerCashOnAccount&#x60; * &#x60;DeferredRevenue&#x60; * &#x60;SalesTaxPayable&#x60; * &#x60;OtherLiabilities&#x60; * &#x60;SalesRevenue&#x60; * &#x60;SalesDiscounts&#x60; * &#x60;OtherRevenue&#x60; * &#x60;OtherEquity&#x60; * &#x60;BadDebt&#x60; * &#x60;OtherExpenses&#x60;            You cannot change the type of an accounting code from &#x60;AccountsReceivable&#x60; to a different type.  |  [optional]



