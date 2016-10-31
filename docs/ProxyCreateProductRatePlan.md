
# ProxyCreateProductRatePlan

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | A description of the product rate plan. **Character limit**: 500 **Values**: a string of 500 characters or fewer  |  [optional]
**effectiveEndDate** | [**LocalDate**](LocalDate.md) |  The date when the product rate plan expires and can&#39;t be subscribed to. **Character limit**: 29 **Values**: [a valid date and time value](/CB_Billing/WA_Dates_in_Zuora/A_Date_and_dateTime_Format)  |  [optional]
**effectiveStartDate** | [**LocalDate**](LocalDate.md) |  The date when the product rate plan becomes available and can be subscribed to. **Character limit**: 29 **Values**: [a valid date and time value](/CB_Billing/WA_Dates_in_Zuora/A_Date_and_dateTime_Format)  |  [optional]
**name** | **String** | The name of the product rate plan. The name doesn&#39;t have to be unique in a Product Catalog, but the name has to be unique within a product. **Character limit**: 100 **Values**: a string of 100 characters or fewer  | 
**productId** | **String** | The [ID of the product](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Product) that contains the product rate plan. **Character limit**: 32 **Values**: a string of 32 characters or fewer  |  [optional]



