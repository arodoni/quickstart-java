
# POSTRevenueScheduleByTransactionType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**notes** | **String** | Additional information about this record.  Character Limit: 2,000  |  [optional]
**revenueDistributions** | [**List&lt;POSTDistributionItemType&gt;**](POSTDistributionItemType.md) | An array of revenue distributions. Represents how you want to distribute revenue for this revenue schedule. You can distribute revenue into a maximum of 250 accounting periods with one revenue schedule.  The sum of newAmounts must equal the the Charge Amount of the specified Invoice Item.  |  [optional]
**revenueEvent** | [**POSTRevenueScheduleByTransactionTypeRevenueEvent**](POSTRevenueScheduleByTransactionTypeRevenueEvent.md) |  |  [optional]



