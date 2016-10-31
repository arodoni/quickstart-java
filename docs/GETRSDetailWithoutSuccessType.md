
# GETRSDetailWithoutSuccessType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | An account ID.  |  [optional]
**amount** | **String** | The revenue schedule amount, which is the sum of all revenue items. This field cannot be null and must be formatted based on the currency, such as &#x60;JPY 30&#x60; or &#x60;USD 30.15&#x60;. Test out the currency to ensure you are using the proper formatting otherwise, the response will fail and this error message is returned: &#x60;Allocation amount with wrong decimal places.&#x60;  |  [optional]
**createdOn** | [**DateTime**](DateTime.md) | The date when the record was created in &#x60;YYYY-MM-DD HH:MM:SS&#x60; format.  |  [optional]
**currency** | **String** | The type of currency used.  |  [optional]
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**linkedTransactionId** | **String** | The linked transaction ID for billing transactions. This field is used for all rules except the custom unlimited or manual recognition rule models. If using the custom unlimited rule model, then the field value must be null. If the field is not null, then the referenceId field must be null.   |  [optional]
**linkedTransactionNumber** | **String** | The number for the linked invoice item or invoice item adjustment transaction. This field is used for all rules except the custom unlimited or manual recognition rule models.  If using the custom unlimited or manual recognition rule models, then the field value is null.   |  [optional]
**linkedTransactionType** | **String** | The type of linked transaction for billing transactions, which can be invoice item or invoice item adjustment. This field is used for all rules except the custom unlimited or manual recognition rule models.  |  [optional]
**notes** | **String** | Additional information about this record.  |  [optional]
**number** | **String** | Revenue schedule number. The revenue schedule number is always prefixed with \&quot;RS\&quot;, for example, \&quot;RS-00000001\&quot;.  |  [optional]
**recognitionRuleName** | **String** | The name of the recognition rule.  |  [optional]
**recognizedRevenue** | **String** | The revenue that was distributed in a closed accounting period.  |  [optional]
**referenceId** | **String** | Reference ID is used only in the custom unlimited rule to create a revenue schedule. In this scenario, the revenue schedule is not linked to an invoice item or invoice item adjustment.  |  [optional]
**revenueItems** | [**List&lt;GETRsRevenueItemType&gt;**](GETRsRevenueItemType.md) | Revenue items are listed in ascending order by the accounting period start date.  |  [optional]
**revenueScheduleDate** | [**LocalDate**](LocalDate.md) | The effective date of the revenue schedule. For example, the revenue schedule date for bookings-based revenue recognition is typically set to the order date or contract date.  The date cannot be in a closed accounting period. The date must be in the &#x60;YYYY-MM-DD&#x60; format.  |  [optional]
**subscriptionChargeId** | **String** | The original subscription charge ID.  |  [optional]
**subscriptionId** | **String** | The original subscription ID.  |  [optional]
**undistributedUnrecognizedRevenue** | **String** | Revenue in the open-ended accounting period.  |  [optional]
**unrecognizedRevenue** | **String** | Revenue distributed in all open accounting periods, which includes the open-ended accounting period.  |  [optional]
**updatedOn** | [**DateTime**](DateTime.md) | The date when the revenue automation start date was set.  |  [optional]



