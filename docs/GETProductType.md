
# GETProductType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category** | **String** | Category of the product. Used by Zuora Quotes Guided Product Selector.  Possible values are:   - Base Products   - Add On Services   - Miscellaneous Products  |  [optional]
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**description** | **String** | Optional product description.  |  [optional]
**effectiveEndDate** | [**LocalDate**](LocalDate.md) | The date when the product expires and cannot be subscribed to anymore, as &#x60;yyyy-mm-dd&#x60;.  |  [optional]
**effectiveStartDate** | [**LocalDate**](LocalDate.md) | The date when the product becomes available and can be subscribed to, as &#x60;yyyy-mm-dd&#x60;.  |  [optional]
**id** | **String** | Product ID.  |  [optional]
**name** | **String** | Product name, up to 100 characters.  |  [optional]
**productFeatures** | [**List&lt;GetProductFeatureType&gt;**](GetProductFeatureType.md) | Container for one or more product features. Only available when the following settings are enabled: - The Entitlements feature in your tenant - The [Enable Feature Specification in Product and Subscriptions](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Default_Subscription_Settings#Enable_Feature_Specification_in_Products_and_Subscriptions.3F) setting in Z-Billing Settings  |  [optional]
**productRatePlans** | [**List&lt;GETProductRatePlanType&gt;**](GETProductRatePlanType.md) | Container for one or more product rate plans:  |  [optional]
**sku** | **String** | Unique product SKU, up to 50 characters.  |  [optional]
**tags** | **String** | dummy |  [optional]



