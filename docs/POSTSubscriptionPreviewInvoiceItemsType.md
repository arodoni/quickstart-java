
# POSTSubscriptionPreviewInvoiceItemsType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**chargeAmount** | **String** | The amount of the charge. This amount doesn&#39;t include taxes unless the charge&#39;s tax mode is inclusive.  |  [optional]
**chargeDescription** | **String** | Description of the charge.  |  [optional]
**chargeName** | **String** | Name of the charge.  |  [optional]
**productName** | **String** | Name of the product associated with this item.  |  [optional]
**productRatePlanChargeId** | **String** | ID of the product rate plan charge.  |  [optional]
**quantity** | **String** | Quantity of this item.  |  [optional]
**serviceEndDate** | [**LocalDate**](LocalDate.md) | End date of the service period for this item, i.e., the last day of the period, as yyyy-mm-dd.  |  [optional]
**serviceStartDate** | [**LocalDate**](LocalDate.md) | Service start date as yyyy-mm-dd. If the charge is a one-time fee, this is the date of that charge.  |  [optional]
**unitOfMeasure** | **String** |  |  [optional]



