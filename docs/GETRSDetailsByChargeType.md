
# GETRSDetailsByChargeType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**revenueSchedules** | [**List&lt;GETRSDetailWithoutSuccessType&gt;**](GETRSDetailWithoutSuccessType.md) | Represents how revenue will be recognized over time.  This contains the details of a revenue schedule. If you do not specify the ｀pageSize｀ variable, the default number of revenue schedules returned per invocation is 8, and if there are more than 8 revenue schedules to be returned, the ｀nextPage｀ field will provide a hyperlink to view the next page(s) of revenue events. The order of revenue schedules is descending by the ｀updatedOn｀ field.  |  [optional]
**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional]



