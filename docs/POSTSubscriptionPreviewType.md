
# POSTSubscriptionPreviewType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**opportunityCloseDateQT** | **String** | The closing date of the Opportunity. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information.  |  [optional]
**opportunityNameQT** | **String** | The unique identifier of the Opportunity. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information.  |  [optional]
**quoteBusinessTypeQT** | **String** | The specific identifier for the type of business transaction the Quote represents such as New, Upsell, Downsell, Renewal, or Churn. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information.  |  [optional]
**quoteNumberQT** | **String** | The unique identifier of the Quote. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information.  |  [optional]
**quoteTypeQT** | **String** | The Quote type that represents the subscription lifecycle stage such as New, Amendment, Renew or Cancel. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information.  |  [optional]
**accountKey** | **String** |  Customer account number or ID.  You must specify the account information either in this field or in the &#x60;previewAccountInfo&#x60; field with the following conditions:           * If you already have a customer account, specify the account number or ID in this field. * If you do not have a customer account, provide account information in the &#x60;previewAccountInfo&#x60; field.  |  [optional]
**contractEffectiveDate** | [**LocalDate**](LocalDate.md) | Effective contract date for this subscription, as yyyy-mm-dd.  | 
**customerAcceptanceDate** | [**LocalDate**](LocalDate.md) | The date on which the services or products within a subscription have been accepted by the customer, as yyyy-mm-dd.  Default value is dependent on the value of other fields. See **Notes** section for more details.  |  [optional]
**includeExistingDraftInvoiceItems** | **Boolean** | Specifies whether to include draft invoice items in subscription previews.  Values:   * &#x60;true&#x60; (default). Includes draft invoice items in amendment previews.  * &#x60;false&#x60;. Excludes draft invoice items in amendment previews.  |  [optional]
**initialTerm** | **Long** | Duration of the first term of the subscription, in whole months. Default is &#x60;0&#x60;. If &#x60;termType&#x60; is &#x60;TERMED&#x60;, then this field is required, and the value must be greater than &#x60;0&#x60;. If &#x60;termType&#x60; is &#x60;EVERGREEN&#x60;, this field is ignored.  |  [optional]
**initialTermPeriodType** | **String** | The period type of the initial term.   Supported values are:  * &#x60;Month&#x60; * &#x60;Year&#x60; * &#x60;Day&#x60; * &#x60;Week&#x60;  |  [optional]
**invoiceOwnerAccountKey** | **String** | Invoice owner account number or ID.  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  |  [optional]
**invoiceTargetDate** | [**LocalDate**](LocalDate.md) | Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date.  |  [optional]
**notes** | **String** | String of up to 500 characters. |  [optional]
**previewAccountInfo** | [**POSTSubscriptionPreviewTypePreviewAccountInfo**](POSTSubscriptionPreviewTypePreviewAccountInfo.md) |  |  [optional]
**previewType** | **String** | The type of preview you will receive. The possible values are &#x60;invoiceItem&#x60;, &#x60;chargeMetrics&#x60;, or &#x60;InvoiceItemChargeMetrics&#x60;. The default is &#x60;invoiceItem&#x60;.  |  [optional]
**serviceActivationDate** | [**LocalDate**](LocalDate.md) | The date on which the services or products within a subscription have been activated and access has been provided to the customer, as yyyy-mm-dd.  Default value is dependent on the value of other fields. See **Notes** section for more details.  |  [optional]
**subscribeToRatePlans** | [**List&lt;POSTSrpCreateType&gt;**](POSTSrpCreateType.md) | Container for one or more rate plans for this subscription.  | 
**termStartDate** | [**LocalDate**](LocalDate.md) | The date on which the subscription term begins, as yyyy-mm-dd. If this is a renewal subscription, this date is different from the subscription start date.  |  [optional]
**termType** | **String** | Possible values are: &#x60;TERMED&#x60;, &#x60;EVERGREEN&#x60;.  | 



