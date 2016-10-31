
# GETAccountSummaryTypeBasicInfo

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountNumber** | **String** | Account number.  |  [optional]
**balance** | **String** | Current outstanding balance.  |  [optional]
**batch** | **String** | The alias name given to a batch. A string of 50 characters or less.  |  [optional]
**billCycleDay** | **String** | Billing cycle day (BCD), the day of the month when a bill run generates invoices for the account.  |  [optional]
**currency** | **String** | A currency value. See [Customize Currencies](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Customize_Currencies) for more information.  |  [optional]
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**defaultPaymentMethod** | [**GETAccountSummaryTypeBasicInfoDefaultPaymentMethod**](GETAccountSummaryTypeBasicInfoDefaultPaymentMethod.md) |  |  [optional]
**id** | **String** | Account ID.  |  [optional]
**lastInvoiceDate** | [**LocalDate**](LocalDate.md) | Date of the most recent invoice for the account; null if no invoice has ever been generated.  |  [optional]
**lastPaymentAmount** | **String** | Amount of the most recent payment collected for the account; null if no payment has ever been collected.  |  [optional]
**lastPaymentDate** | [**LocalDate**](LocalDate.md) | Date of the most recent payment collected for the account. Null if no payment has ever been collected.  |  [optional]
**name** | **String** | Account name.  |  [optional]
**status** | **String** | Account status; possible values are: &#x60;Active&#x60;, &#x60;Draft&#x60;, &#x60;Canceled&#x60;.  |  [optional]
**tags** | **String** | dummy |  [optional]



