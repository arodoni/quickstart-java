
# GETAccountSummaryType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**basicInfo** | [**GETAccountSummaryTypeBasicInfo**](GETAccountSummaryTypeBasicInfo.md) |  |  [optional]
**billToContact** | [**GETAccountSummaryTypeBillToContact**](GETAccountSummaryTypeBillToContact.md) |  |  [optional]
**invoices** | [**List&lt;GETAccountSummaryInvoiceType&gt;**](GETAccountSummaryInvoiceType.md) | Container for invoices. Only returns the last 6 invoices.  |  [optional]
**payments** | [**List&lt;GETAccountSummaryPaymentType&gt;**](GETAccountSummaryPaymentType.md) | Container for payments. Only returns the last 6 payments.  |  [optional]
**soldToContact** | [**GETAccountSummaryTypeSoldToContact**](GETAccountSummaryTypeSoldToContact.md) |  |  [optional]
**subscriptions** | [**List&lt;GETAccountSummarySubscriptionType&gt;**](GETAccountSummarySubscriptionType.md) | Container for subscriptions.  |  [optional]
**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional]
**taxInfo** | [**GETAccountSummaryTypeTaxInfo**](GETAccountSummaryTypeTaxInfo.md) |  |  [optional]
**usage** | [**List&lt;GETAccountSummaryUsageType&gt;**](GETAccountSummaryUsageType.md) | Container for usage data. Only returns the last 6 months of usage.  |  [optional]



