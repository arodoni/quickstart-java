
# RatePlanChargeTier

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdById** | **String** | The ID of the Zuora user who created the RatePlanChargeTier object. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**createdDate** | [**DateTime**](DateTime.md) |  The date when the RatePlanChargeTier object was created. **Character limit**: 29 **Values**: automatically generated  |  [optional]
**endingUnit** | **Double** |  The end number of a range of units for the tier. **Character limit**: 16 **Values**: any positive decimal value  |  [optional]
**id** | **String** |  The ID of this object. Upon creation, the ID of this object is &#x60;RatePlanChargeTierId&#x60;. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**isOveragePrice** | **Boolean** |  Indicates if the price is an overage price. An overage occurs when usage surpasses the last defined tier. This field is applicable only to tier pricing and volume pricing models. **Values**: true, false  |  [optional]
**price** | **Double** |  The price of the tier if the charge is a flat fee, or the price of each unit in the tier if the change model is tiered pricing. **Character limit**: 16 **Values**: any positive decimal value  |  [optional]
**priceFormat** | **String** |  Indicates if the price is a flat fee or is per unit. **Character limit**: 8 **Values**: &#x60;Flat Fee&#x60;, &#x60;Per Unit&#x60;  |  [optional]
**ratePlanChargeId** | **String** |  The ID of the subscription or amendment rate plan charge associated with this tier. You can&#39;t create an unassociated tier. **Character limit**: 32 **Values**: inherited from [&#x60;RatePlanCharge.Id&#x60;](https://knowledgecenter.zuora.com/BC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/RatePlanCharge#Id)  |  [optional]
**startingUnit** | **Double** |  The start number of a range of units for the tier. **Character limit**: 16 **Values**: any positive decimal value  |  [optional]
**tier** | **Integer** |  A unique number that identifies the tier that the price applies to. **Character limit**: 20 **Values**: automatically generated  |  [optional]
**updatedById** | **String** | The ID of the last user to update the object. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**updatedDate** | [**DateTime**](DateTime.md) |  The date when the object was last updated. **Character limit**: 29 **Values**: automatically generated  |  [optional]
**fieldsToNull** | **String** |  |  [optional]



