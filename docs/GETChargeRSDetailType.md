
# GETChargeRSDetailType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | An account ID.  |  [optional]
**amount** | **String** | The revenue schedule amount, which is the sum of all revenue items. This field cannot be null and must be formatted based on the currency, such as *JPY 30* or USD *30.15*. Test out the currency to ensure you are using the proper formatting otherwise, the response will fail and this error message is returned:  *\&quot;Allocation amount with wrong decimal places.\&quot;*  |  [optional]
**currency** | **String** | The type of currency used.   |  [optional]
**notes** | **String** | Additional information about this record.  |  [optional]
**number** | **String** | The charge revenue summary number.  |  [optional]
**recognitionRuleName** | **String** | The name of the recognition rule.  |  [optional]
**recognizedRevenue** | **String** | The revenue that was distributed in a closed accounting period.  |  [optional]
**revenueItems** | [**List&lt;GETRevenueItemType&gt;**](GETRevenueItemType.md) | Revenue items are listed in ascending order by the accounting period start date.  |  [optional]
**subscriptionChargeId** | **String** | The original subscription charge ID.  |  [optional]
**subscriptionId** | **String** | The original subscription ID.  |  [optional]
**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional]
**undistributedUnrecognizedRevenue** | **String** | Revenue in the open-ended accounting period.  |  [optional]
**unrecognizedRevenue** | **String** | Revenue distributed in all open accounting periods, which includes the open-ended accounting period.  |  [optional]



