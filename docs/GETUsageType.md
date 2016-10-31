
# GETUsageType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | Customer account ID.  |  [optional]
**accountName** | **String** | Customer account name.  |  [optional]
**accountNumber** | **String** | Customer account number.  |  [optional]
**chargeNumber** | **String** | Number of the rate-plan charge that pays for this usage.  |  [optional]
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**id** | **String** | Unique ID for the usage item.  |  [optional]
**quantity** | **String** | Number of units used.  |  [optional]
**sourceName** | **String** | Source of the usage data. Possible values are: &#x60;Import&#x60;, &#x60;API&#x60;.  |  [optional]
**startDateTime** | [**DateTime**](DateTime.md) | Start date of the time period in which usage is tracked. Zuora uses this field value to determine the usage date.  |  [optional]
**status** | **String** | Possible values are: &#x60;Importing&#x60;, &#x60;Pending&#x60;, &#x60;Processed&#x60;.  |  [optional]
**submissionDateTime** | [**DateTime**](DateTime.md) | Date when usage was submitted.  |  [optional]
**subscriptionNumber** | **String** | Number of the subscription covering this usage.  |  [optional]
**unitOfMeasure** | **String** | Unit used to measure consumption, as configured in the web-based UI at **Z-Billing &gt; Settings**.  |  [optional]



