
# GETAccountingPeriodType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdBy** | **String** | ID of the user who created the accounting period.  |  [optional]
**createdOn** | [**DateTime**](DateTime.md) | Date and time when the accounting period was created.  |  [optional]
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**endDate** | [**LocalDate**](LocalDate.md) | The end date of the accounting period.  |  [optional]
**fileIds** | [**List&lt;GETAccountingPeriodFileIdsType&gt;**](GETAccountingPeriodFileIdsType.md) | File IDs of the reports available for the accounting period. You can retrieve the reports by specifying the file ID in a [Get Files](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Get_Files) REST API call.  |  [optional]
**fiscalYear** | **String** | Fiscal year of the accounting period.  |  [optional]
**fiscalQuarter** | **Long** | dummy |  [optional]
**id** | **String** | ID of the accounting period.  |  [optional]
**name** | **String** | Name of the accounting period.  |  [optional]
**notes** | **String** | Any optional notes about the accounting period.  |  [optional]
**runTrialBalanceEnd** | [**DateTime**](DateTime.md) | Date and time that the trial balance was completed. If the trial balance status is &#x60;Pending&#x60;, &#x60;Processing&#x60;, or &#x60;Error&#x60;, this field is &#x60;null&#x60;.  |  [optional]
**runTrialBalanceErrorMessage** | **String** | If trial balance status is Error, an error message is returned in this field.  |  [optional]
**runTrialBalanceStart** | [**DateTime**](DateTime.md) | Date and time that the trial balance was run. If the trial balance status is Pending, this field is null.  |  [optional]
**runTrialBalanceStatus** | **String** | Status of the trial balance for the accounting period. Possible values:  * &#x60;Pending&#x60; * &#x60;Processing&#x60; * &#x60;Completed&#x60; * &#x60;Error&#x60;  |  [optional]
**startDate** | [**LocalDate**](LocalDate.md) | The start date of the accounting period.  |  [optional]
**status** | **String** | Status of the accounting period. Possible values: * &#x60;Open&#x60; * &#x60;PendingClose&#x60; * &#x60;Closed&#x60;  |  [optional]
**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional]
**updatedBy** | **String** | ID of the user who last updated the accounting period.  |  [optional]
**updatedOn** | [**DateTime**](DateTime.md) | Date and time when the accounting period was last updated.  |  [optional]



