
# GETProductRatePlanType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**description** | **String** | Rate plan description.  |  [optional]
**effectiveEndDate** | [**LocalDate**](LocalDate.md) | Final date the rate plan is active, as &#x60;yyyy-mm-dd&#x60;. After this date, the rate plan status is &#x60;Expired&#x60;.  |  [optional]
**effectiveStartDate** | [**LocalDate**](LocalDate.md) | First date the rate plan is active (i.e., available to be subscribed to), as &#x60;yyyy-mm-dd&#x60;.  Before this date, the status is &#x60;NotStarted&#x60;.  |  [optional]
**id** | **String** | Unique product rate-plan charge ID.  |  [optional]
**name** | **String** | Name of the product rate-plan charge. (Not required to be unique.)  |  [optional]
**productRatePlanCharges** | [**List&lt;GETProductRatePlanChargeType&gt;**](GETProductRatePlanChargeType.md) | Field attributes describing the product rate plan charges:  |  [optional]
**status** | **String** | Possible vales are: &#x60;Active&#x60;, &#x60;Expired&#x60;, &#x60;NotStarted&#x60;.  |  [optional]



