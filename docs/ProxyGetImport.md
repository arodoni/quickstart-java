
# ProxyGetImport

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdById** | **String** |  The user ID of the person who created the import. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**createdDate** | [**DateTime**](DateTime.md) |  The date when the import was created. **Character limit**: 29 **Values**: automatically generated  |  [optional]
**id** | **String** | Object identifier. |  [optional]
**importType** | **String** |  The type of item imported. **Character limit**: 7 **Values**: Usage  |  [optional]
**importedCount** | **Integer** | The number of records successfully imported. **Character limit**: **Values**: automatically generated  |  [optional]
**md5** | **String** |  A check to validate the import file&#39;s integrity. **Character limi**t: 32 **System-generated**: no **Values**: a string of 32 characters or fewer  |  [optional]
**name** | **String** |  A descriptive name for the import. **Character limi**t: 100 **Values**: one of the following:  - a string of 100 characters or fewer - if NULL default is:&#x60; import &lt;ImportType_value&gt;&#x60;  |  [optional]
**originalResourceUrl** | **String** |  The URL for your import file, which contains your records for upload. When you upload the file, Zuora assigns it to this address. **Character limit**: **Values**: automatic dynamically-generated URL  |  [optional]
**resultResourceUrl** | **String** |  The URL for the import result file, which is a zipped CSV file. **Character limit**: **Values**: automatic dynamically-generated URL  |  [optional]
**status** | **String** | The status of the import process. **Character limit**: 10 **Values**: automatically generated using one of the following values:  - Pending - Processing - Completed - Failed  |  [optional]
**statusReason** | **String** |  The reason for the system-generated status. Use this information if the import fails. **Character limit**: 2000 **Values**: automatically generated error message  |  [optional]
**totalCount** | **Integer** |  The number of records in the import file. **Character limit**: **Values**: automatically generated  |  [optional]
**updatedById** | **String** |  The ID of the user who last updated the import. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**updatedDate** | [**DateTime**](DateTime.md) |  The date when the import was last updated. **Character limi**t: 29 **Values**: automatically generated  |  [optional]



