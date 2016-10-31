
# GETRevenueEventDetailWithoutSuccessType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | An account ID.  |  [optional]
**createdOn** | [**DateTime**](DateTime.md) | The date when the record was created in YYYY-MM-DD HH:MM:SS format.  |  [optional]
**currency** | **String** | The type of currency used.   |  [optional]
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**eventType** | **String** | Label of the revenue event type. Revenue event type labels can be duplicated. You can configure your revenue event type labels by navigating to **Settings &gt; Z-Finance Settings &gt; Configure Revenue Event Types** in the Zuora UI. The default revenue event types are:    * Invoice Posted   * Invoice Item Adjustment Created   * Invoice Canceled   * Invoice Item Adjustment Canceled   * Revenue Distributed  |  [optional]
**notes** | **String** | Additional information about this record.  |  [optional]
**number** | **String** | The revenue event number created when a revenue event occurs.  |  [optional]
**recognitionEnd** | [**LocalDate**](LocalDate.md) |  The end date of a recognition period in YYYY-MM-DD format.   The maximum difference of the recognitionStart and recognitionEnd date fields is equal to 250 multiplied by the length of an accounting period.  |  [optional]
**recognitionStart** | [**LocalDate**](LocalDate.md) | The start date of a recognition period in YYYY-MM-DD format.  |  [optional]
**revenueItems** | [**List&lt;GETRevenueItemType&gt;**](GETRevenueItemType.md) | Revenue items are listed in ascending order by the accounting period start date.  |  [optional]
**subscriptionChargeId** | **String** | The original subscription charge ID.  |  [optional]
**subscriptionId** | **String** | The original subscription ID.  |  [optional]



