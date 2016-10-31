
# GETProductRatePlanChargePricingType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**currency** | **String** | Currency used by the charge model. For example: USD or EUR  |  [optional]
**discountAmount** | **String** | Value subtracted from price in currency specified. Used only when the charge model is DiscountFixedAmount.  |  [optional]
**discountPercentage** | **String** | Percent discount applied to the price. Used only when the charge model is DiscountPercentage.  |  [optional]
**includedUnits** | **String** | Specifies the number of units in the base set of units when the charge model is Overage.  |  [optional]
**overagePrice** | **String** | Price per unit when base set of units is exceeded. Used only when charge model is Overage or Tiered with Overage.  |  [optional]
**price** | **String** | The decimal value that applies when the charge model is not tiered  |  [optional]
**tiers** | [**List&lt;GETProductRatePlanChargePricingTierType&gt;**](GETProductRatePlanChargePricingTierType.md) | Container for one or many defined tier ranges with distinct pricing.  Applies when model is &#x60;Tiered&#x60;, &#x60;TieredWithOverage&#x60;, or &#x60;Volume&#x60;  |  [optional]



