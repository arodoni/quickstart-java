
# GETInvoicesInvoiceItemType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**chargeAmount** | **String** | The amount of the charge. This amount doesn&#39;t include taxes regardless if the charge&#39;s tax mode is inclusive or exclusive.  |  [optional]
**chargeDescription** | **String** | Description of the charge.  |  [optional]
**chargeId** | **String** | ID of the charge.  |  [optional]
**chargeName** | **String** | Name of the charge.  |  [optional]
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**id** | **String** | Item ID.  |  [optional]
**productName** | **String** | Name of the product associated with this item.  |  [optional]
**quantity** | **String** | Quantity of this item, in the configured unit of measure for the charge.  |  [optional]
**serviceEndDate** | [**LocalDate**](LocalDate.md) | End date of the service period for this item, i.e., the last day of the service period, as _yyyy-mm-dd_.  |  [optional]
**serviceStartDate** | [**LocalDate**](LocalDate.md) | Start date of the service period for this item, as _yyyy-mm-dd_. For a one-time fee item, the date of the charge.  |  [optional]
**subscriptionId** | **String** | ID of the subscription for this item.  |  [optional]
**subscriptionName** | **String** | Name of the subscription for this item.  |  [optional]
**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional]
**taxAmount** | **String** | Tax applied to the charge.  |  [optional]
**unitOfMeasure** | **String** | Unit used to measure consumption, as configured in the web-based UI at **Z-Billing &gt; Settings**.  |  [optional]



