
# ProxyGetAccountingPeriod

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdById** | **String** |  The identifier of the user who created the accounting code. **Character limit:** N/A **Z-Finance Required****: **No  |  [optional]
**createdDate** | [**DateTime**](DateTime.md) |  The date when the accounting code was created. **Character limit:** N/A **Z-Finance Required****: **No  |  [optional]
**endDate** | [**LocalDate**](LocalDate.md) |  The end date of the accounting period. **Character limit**: **Version notes**: Z-Finance  |  [optional]
**fiscalYear** | **Integer** |  The fiscal year for the accounting period. **Values**: a valid integer of the form, YYYY  |  [optional]
**id** | **String** | Object identifier. |  [optional]
**name** | **String** |  The name of the accounting period, which is displayed on the list of accounting periods on the All Accounting Periods page. **Character limit**:100 **Values**: a string of 100 characters or fewer  |  [optional]
**notes** | **String** | Use this field to record comments about the accounting period. **Character limit**: 255 **Values**: a string of 255 characters or fewer  |  [optional]
**startDate** | [**LocalDate**](LocalDate.md) |  The start date of the accounting period. **Character limit**: 29 **Values**: automatically generated after the first accounting period  |  [optional]
**status** | **String** |  The status of the accounting period. **Character limit**: 6 **Allowable values**: automatically generated on creattion; one of the following values:  - Open - Closed  |  [optional]
**updatedById** | **String** |  The identifier of the user who created the accounting code. **Character limit:** N/A **Z-Finance Required**: No  |  [optional]
**updatedDate** | [**DateTime**](DateTime.md) |  The date when the accounting code was updated. **Character limit:** N/A **Z-Finance Required****: **No  |  [optional]



