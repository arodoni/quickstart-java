
# POSTAccountResponseType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | Auto-generated account ID.  |  [optional]
**accountNumber** | **String** | Account number.  |  [optional]
**contractedMrr** | **String** | Contracted [monthly recurring revenue](https://knowledgecenter.zuora.com/BC_Subscription_Management/Customer_Accounts/A_How_to_Manage_Customer_Accounts/E_Key_Metrics/A_Monthly_Recurring_Revenue) of the subscription.  |  [optional]
**invoiceId** | **String** | ID of the invoice generated at account creation, if applicable.  |  [optional]
**paidAmount** | **String** | Amount collected on the invoice generated at account creation, if applicable.  |  [optional]
**paymentId** | **String** | ID of the payment collected on the invoice generated at account creation, if applicable.  |  [optional]
**paymentMethodId** | **String** | ID of the payment method that was set up at account creation, which automatically becomes the default payment method for this account.  |  [optional]
**subscriptionId** | **String** | ID of the subscription that was set up at account creation, if applicable.  |  [optional]
**subscriptionNumber** | **String** | Number of the subscription that was set up at account creation, if applicable.  |  [optional]
**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional]
**totalContractedValue** | **String** | [Total contracted value](https://knowledgecenter.zuora.com/P_Glossary) of the subscription.  |  [optional]



