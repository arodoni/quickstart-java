
# RatePlan

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amendmentId** | **String** |  The ID of the amendment associated with the rate plan. This field only applies to amendment rate plans. **Character limit**: 32 **Values**: a valid amendment ID  |  [optional]
**amendmentSubscriptionRatePlanId** | **String** | The ID of the subscription rate plan modified by the amendment. This field only applies to amendment rate plans. **Character limit**: 32 **Values**: a valid rate plan ID  |  [optional]
**amendmentType** | **String** | The type of amendment associated with the rate plan. This field only applies to amendment rate plans. **Character limit**: 18 **Values**: inherited from &#x60;Amendment.Type&#x60;  |  [optional]
**createdById** | **String** | The ID of the Zuora user who created the RatePlan object. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**createdDate** | [**DateTime**](DateTime.md) | The date when the &#x60;RatePlan&#x60; object was last updated. **Character limit**: 29 **Values**: automatically generated  |  [optional]
**id** | **String** | The ID of this object. Upon creation, the ID of this object is &#x60;RatePlanId&#x60;. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**name** | **String** | The name of the rate plan. Leave this null in a subscribe() call to to inherited the &#x60;ProductRatePlan.Name&#x60; field value. **Character limit**: 100 **Values**: a string of 100 characters or fewer or inherited from ProductRatePlan.Name  |  [optional]
**productRatePlanId** | **String** | The ID of the associated product rate plan. **Character limit**: 32 **Values**: a valid product rate plan ID  |  [optional]
**subscriptionId** | **String** | The ID of the subscription that the rate plan belongs to. **Character limit**: 32 **Values**: a valid subscription ID  |  [optional]
**updatedById** | **String** |  The ID of the user who last updated the rate plan. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**updatedDate** | [**DateTime**](DateTime.md) |  The date when the rate plan was last updated. **Character limit**: 29 **Values**: automatically generated  |  [optional]
**fieldsToNull** | **String** |  |  [optional]



