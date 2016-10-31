
# GETSubscriptionTypeWithSuccess

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cpqBundleJsonIdQT** | **String** |  |  [optional]
**opportunityCloseDateQT** | **String** | The closing date of the Opportunity. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information.  |  [optional]
**opportunityNameQT** | **String** | The unique identifier of the Opportunity. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information.  |  [optional]
**quoteBusinessTypeQT** | **String** | The specific identifier for the type of business transaction the Quote represents such as New, Upsell, Downsell, Renewal, or Churn. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information.  |  [optional]
**quoteNumberQT** | **String** | The unique identifier of the Quote. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.  See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information.  |  [optional]
**quoteTypeQT** | **String** | The Quote type that represents the subscription lifecycle stage such as New, Amendment, Renew or Cancel. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information.  |  [optional]
**accountId** | **String** |  |  [optional]
**accountName** | **String** |  |  [optional]
**accountNumber** | **String** |  |  [optional]
**autoRenew** | **Boolean** | If &#x60;true&#x60;, the subscription automatically renews at the end of the term. Default is &#x60;false&#x60;.  |  [optional]
**contractEffectiveDate** | [**LocalDate**](LocalDate.md) | Effective contract date for this subscription, as yyyy-mm-dd.  |  [optional]
**contractedMrr** | **String** | Monthly recurring revenue of the subscription.  |  [optional]
**currentTerm** | **Long** | The length of the period for the current subscription term.  |  [optional]
**currentTermPeriodType** | **String** | The period type for the current subscription term.  Values are:  * &#x60;Month&#x60; (default) * &#x60;Year&#x60; * &#x60;Day&#x60; * &#x60;Week&#x60;  |  [optional]
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**customerAcceptanceDate** | [**LocalDate**](LocalDate.md) | The date on which the services or products within a subscription have been accepted by the customer, as yyyy-mm-dd.  |  [optional]
**id** | **String** | Subscription ID.  |  [optional]
**initialTerm** | **Long** | The length of the period for the first subscription term.  |  [optional]
**initialTermPeriodType** | **String** | The period type for the first subscription term.  Values are:  * &#x60;Month&#x60; (default) * &#x60;Year&#x60; * &#x60;Day&#x60; * &#x60;Week&#x60;  |  [optional]
**invoiceOwnerAccountId** | **String** |  |  [optional]
**invoiceOwnerAccountName** | **String** |  |  [optional]
**invoiceOwnerAccountNumber** | **String** |  |  [optional]
**invoiceSeparately** | **String** | Separates a single subscription from other subscriptions and creates an invoice for the subscription.   If the value is &#x60;true&#x60;, the subscription is billed separately from other subscriptions. If the value is &#x60;false&#x60;, the subscription is included with other subscriptions in the account invoice.  |  [optional]
**notes** | **String** | A string of up to 65,535 characters.  |  [optional]
**ratePlans** | [**List&lt;GETSubscriptionRatePlanType&gt;**](GETSubscriptionRatePlanType.md) | Container for rate plans.  |  [optional]
**renewalSetting** | **String** | Specifies whether a termed subscription will remain &#x60;TERMED&#x60; or change to &#x60;EVERGREEN&#x60; when it is renewed.   Values are:  * &#x60;RENEW_WITH_SPECIFIC_TERM&#x60; (default) * &#x60;RENEW_TO_EVERGREEN&#x60;  |  [optional]
**renewalTerm** | **Long** | The length of the period for the subscription renewal term.  |  [optional]
**renewalTermPeriodType** | **String** | The period type for the subscription renewal term.  Values are:  * &#x60;Month&#x60; (default) * &#x60;Year&#x60; * &#x60;Day&#x60; * &#x60;Week&#x60;  |  [optional]
**serviceActivationDate** | [**LocalDate**](LocalDate.md) | The date on which the services or products within a subscription have been activated and access has been provided to the customer, as yyyy-mm-dd  |  [optional]
**status** | **String** | Subscription status; possible values are:  * &#x60;Draft&#x60; * &#x60;PendingActivation&#x60; * &#x60;PendingAcceptance&#x60; * &#x60;Active&#x60; * &#x60;Cancelled&#x60; * &#x60;Suspended&#x60; (This value is in Limited Availability.)  |  [optional]
**subscriptionNumber** | **String** |  |  [optional]
**subscriptionStartDate** | [**LocalDate**](LocalDate.md) | Date the subscription becomes effective.  |  [optional]
**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional]
**termEndDate** | [**LocalDate**](LocalDate.md) | Date the subscription term ends. If the subscription is evergreen, this is null or is the cancellation date (if one has been set).  |  [optional]
**termStartDate** | [**LocalDate**](LocalDate.md) | Date the subscription term begins. If this is a renewal subscription, this date is different from the subscription start date.  |  [optional]
**termType** | **String** | Possible values are: &#x60;TERMED&#x60;, &#x60;EVERGREEN&#x60;.  |  [optional]
**totalContractedValue** | **String** | Total contracted value of the subscription.  |  [optional]



