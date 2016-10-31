
# GETAmendmentType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**autoRenew** | **Boolean** | Determines whether the subscription is automatically renewed, or whether it expires at the end of the term and needs to be manually renewed.   |  [optional]
**baseRatePlanId** | **String** | The rate plan ID on which changes are made. Only the Update or Remove amendment returns a base rate plan ID.  |  [optional]
**baseSubscriptionId** | **String** | The ID of the subscription based on which the amendment is created.  |  [optional]
**code** | **String** | The amendment code.  |  [optional]
**contractEffectiveDate** | [**LocalDate**](LocalDate.md) | The date when the amendment becomes effective for billing purposes, as &#x60;yyyy-mm-dd&#x60;.  |  [optional]
**currentTerm** | **Long** | The length of the period for the current subscription term.   |  [optional]
**currentTermPeriodType** | **String** | The period type for the current subscription term. Possible values are:  - Month - Year - Day - Week  |  [optional]
**customerAcceptanceDate** | [**LocalDate**](LocalDate.md) | The date when the customer accepts the amendment changes to the subscription, as &#x60;yyyy-mm-dd&#x60;.  |  [optional]
**description** | **String** | Description of the amendment.  |  [optional]
**destinationAccountId** | **String** | The ID of the account that the subscription is being transferred to.  |  [optional]
**destinationInvoiceOwnerId** | **String** | The ID of the invoice that the subscription is being transferred to.  |  [optional]
**effectiveDate** | [**LocalDate**](LocalDate.md) | The date when the amendment changes take effective.   |  [optional]
**id** | **String** | The amendment ID.  |  [optional]
**name** | **String** | The name of the amendment.  |  [optional]
**newRatePlanId** | **String** | The ID of the rate plan charge on which amendment is made. Only the Add or Update amendment returns a new rate plan ID.  |  [optional]
**newSubscriptionId** | **String** | The ID of the subscription that the amendment changes.  |  [optional]
**renewalSetting** | **String** | Specifies whether a termed subscription will remain termed or change to evergreen when it is renewed. Possible values are:  - RENEW_WITH_SPECIFIC_TERM - RENEW_TO_EVERGREEN  |  [optional]
**renewalTerm** | **Long** | The term of renewal for the amended subscription.  |  [optional]
**renewalTermPeriodType** | **String** | The period type for the subscription renewal term. Possible values are:  - Month - Year - Day - Week  |  [optional]
**resumeDate** | [**LocalDate**](LocalDate.md) | The date when the subscription resumption takes effect, as &#x60;yyyy-mm-dd&#x60;.  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  |  [optional]
**serviceActivationDate** | [**LocalDate**](LocalDate.md) | The date when service is activated, as &#x60;yyyy-mm-dd&#x60;.  |  [optional]
**specificUpdateDate** | [**LocalDate**](LocalDate.md) | The date when the Update Product amendment takes effect.  Only for the Update Product amendments if there is already a future-dated Update Product amendment on the subscription.  |  [optional]
**status** | **String** | The status of the amendment. Possible values are:  - Draft  - Pending Activation - Pending Acceptance - Completed  |  [optional]
**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional]
**suspendDate** | [**LocalDate**](LocalDate.md) | The date when the subscription suspension takes effect, as &#x60;yyyy-mm-dd&#x60;.  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  |  [optional]
**termStartDate** | [**LocalDate**](LocalDate.md) | The date when the new terms and conditions take effect.  |  [optional]
**termType** | **String** | Indicates if the subscription is &#x60;TERMED&#x60; or &#x60;EVERGREEN&#x60;.  |  [optional]
**type** | **String** | Type of the amendment. Possible values are:  - Cancellation - NewProduct - OwnerTransfer - RemoveProduct - Renewal - UpdateProduct - TermsAndConditions  |  [optional]



