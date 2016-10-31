
# GETSubscriptionRatePlanType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**id** | **String** | Rate plan ID.  |  [optional]
**lastChangeType** | **String** | The last amendment on the rate plan.  Possible Values:  * &#x60;Add&#x60; * &#x60;Update&#x60; * &#x60;Remove&#x60;  |  [optional]
**productId** | **String** |  |  [optional]
**productName** | **String** |  |  [optional]
**productRatePlanId** | **String** |  |  [optional]
**productSku** | **String** | The unique SKU for the product.  |  [optional]
**ratePlanCharges** | [**List&lt;GETSubscriptionRatePlanChargesType&gt;**](GETSubscriptionRatePlanChargesType.md) | Container for one or more charges.  |  [optional]
**ratePlanName** | **String** | Name of the rate plan.  |  [optional]
**subscriptionProductFeatures** | [**List&lt;GETSubscriptionProductFeatureType&gt;**](GETSubscriptionProductFeatureType.md) | Container for one or more features.   Only available when the following settings are enabled:  * The Entitlements feature in your tenant. * The [Enable Feature Specification in Product and Subscriptions](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Default_Subscription_Settings#Enable_Feature_Specification_in_Products_and_Subscriptions.3F) setting in Billing Settings.  |  [optional]



