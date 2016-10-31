
# PUTAllocateManuallyType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**eventType** | **String** | Label of the revenue event type. Revenue event type labels can be duplicated. You can configure your revenue event type labels by navigating to **Settings &gt; Z-Finance Settings &gt; Configure Revenue Event Types** in the Zuora UI. The default revenue event types are: * Invoice Posted * Invoice Item Adjustment Created * Invoice Canceled * Invoice Item Adjustment Canceled * Revenue Distributed  You can create revenue event types from **Finance Settings &gt; Revenue Event Types**.  |  [optional]
**eventTypeSystemId** | **String** | System ID of the revenue event type. Each eventType has a unique system ID. You can configure your revenue event type system IDs by navigating to **Settings &gt; Z-Finance Settings &gt; Configure Revenue Event Types** in the Zuora UI.  Cannot be duplicated.  |  [optional]
**notes** | **String** | Additional information about this record.  |  [optional]
**revenueDistributions** | [**List&lt;POSTDistributionItemType&gt;**](POSTDistributionItemType.md) | An array of revenue distributions. Represents how you want to distribute revenue for this revenue schedule. You can distribute revenue into a maximum of 250 accounting periods with one revenue schedule.  |  [optional]



