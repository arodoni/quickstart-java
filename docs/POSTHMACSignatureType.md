
# POSTHMACSignatureType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountKey** | **String** | Customer account number or ID.  Specifies this field only when creating signatures for [Create payment method](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Payment_methods/1_Create_payment_method).  |  [optional]
**method** | **String** | Possible values are: &#39;GET&#39;, &#39;POST&#39;, &#39;PUT&#39;, &#39;DELETE&#39;, &#39;OPTIONS&#39;.  | 
**name** | **String** | Account name.  Specifies this field only when creating signatures for [Create account](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Accounts/1_Create_account).  |  [optional]
**pageId** | **String** | The page id of your Payment Pages 2.0 form. Click **Show Page Id** next to the Payment Page name in the Hosted Page List to retrieve the page id.  Specifies this field only when creating signatures for [RSA Signatures](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/RSA_Signatures).  |  [optional]
**uri** | **String** | The URI of the API object the customer will make a CORS enabled call to. e.g. \&quot;https://api.zuora.com/rest/v1/payment-methods/credit-cards\&quot;  | 



