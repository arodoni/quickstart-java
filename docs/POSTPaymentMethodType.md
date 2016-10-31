
# POSTPaymentMethodType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountKey** | **String** | ID of the customer account to update.  | 
**cardHolderInfo** | [**POSTPaymentMethodTypeCardHolderInfo**](POSTPaymentMethodTypeCardHolderInfo.md) |  |  [optional]
**creditCardNumber** | **String** | Credit card number, a string of up to 16 characters. This field can only be set when creating a new payment method; it cannot be queried or updated.  | 
**creditCardType** | **String** | Possible values are: &#x60;Visa&#x60;, &#x60;MasterCard&#x60;, &#x60;AmericanExpress&#x60;, &#x60;Discover&#x60;.  | 
**defaultPaymentMethod** | **Boolean** | Specify true to make this card the default payment method; otherwise, omit this parameter to keep the current default payment method.  |  [optional]
**expirationMonth** | **String** | Two-digit expiration month (01-12).  | 
**expirationYear** | **String** | Four-digit expiration year.  | 
**securityCode** | **String** | The CVV or CVV2 security code for the credit card or debit card. Only required if changing expirationMonth, expirationYear, or cardHolderName. To ensure PCI compliance, this value isn&#39;t stored and can&#39;t be queried. For more information, see [How do I control what information Zuora sends over to the Payment Gateway?](https://knowledgecenter.zuora.com/kb/How_do_I_control_what_information_Zuora_sends_over_to_the_payment_gateway_when_verifying_payment_methods%3F)  |  [optional]



