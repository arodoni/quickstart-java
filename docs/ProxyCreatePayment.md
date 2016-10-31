
# ProxyCreatePayment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** |  The unique account ID for the customer that the payment is for. **Character limit**: 32 **Values**: a valid [account ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account)  | 
**accountingCode** | **String** |  The [Chart of Accounts](/CB_Billing/W_Billing_and_Payments_Settings/V_Configure_Accounting_Codes/D_Set_Up_Chart_of_Accounts)  |  [optional]
**amount** | **Double** |  The amount of the payment. **Character limit**: 16 **Values**: a valid currency value  | 
**appliedCreditBalanceAmount** | **Double** |  The amount of the payment to apply to a credit balance. This field is required in a create() call when the &#x60;AppliedInvoiceAmount&#x60; field value is null. **Character limit**: 16 **Values**: a valid currency value  | 
**authTransactionId** | **String** |  The authorization transaction ID from the payment gateway. Use this field for electronic payments, such as credit cards. **Character limit**: 50 **Values**: a string of 50 characters or fewer  |  [optional]
**comment** | **String** |  Additional information related to the payment. **Character limit**: 255 **Values**: a string of 255 characters or fewer  |  [optional]
**effectiveDate** | [**LocalDate**](LocalDate.md) |  The date when the payment takes effect. **Character limit**: 29 **Values**: [a valid date and time value](/CB_Billing/WA_Dates_in_Zuora/A_Date_Format_and_Datetimes_in_Zuora)  | 
**gateway** | **String** |  Name of the [gateway](/C_Zuora_User_Guides/A_Billing_and_Payments/M_Payment_Gateways) instance that processes the payment. When creating a Payment, this must be a valid gateway instance name and this gateway must support the specific payment method. If not specified, the default gateway on the Account will be used.  |  [optional]
**gatewayOrderId** | **String** |  A merchant-specified natural key value that can be passed to the electronic payment gateway when a payment is created. If not specified, the PaymentNumber will be passed in instead. **Character limit**: 70 **Values**: a string of 70 characters or fewer  |  [optional]
**gatewayResponse** | **String** |  The message returned from the payment gateway for the payment. This message is gateway-dependent. **Character limit**: 500 **Values**: automatically generated  | 
**gatewayResponseCode** | **String** |  The code returned from the payment gateway for the payment. This code is gateway-dependent. **Character limit**: 20 **Values**: automatically generated  | 
**gatewayState** | **String** |  The status of the payment in the gateway; use for reconciliation. **Character limit**: 19 **Values**: automatically generated  | 
**paymentMethodId** | **String** |  The ID of the payment method used for the payment. Required for Create. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**paymentNumber** | **String** |  The unique identification number of a payment. For example: P-00000028. **Character limit**: 32 **Values**: automatically generated  | 
**referenceId** | **String** |  The transaction ID returned by the payment gateway. Use this field to reconcile payments between your gateway and Z-Payments. **Character limit**: 60 **Values**: a string of 60 characters or fewer  |  [optional]
**softDescriptor** | **String** |  [A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/Supported_Payment_Gateways/Verifi_Global_Payment_Gateway#Soft_Descriptors_(Optional)). **Character limit**: 35 **Values**: &#x60;[SDMerchantName]*[SDProductionInfo]&#x60;  |  [optional]
**softDescriptorPhone** | **String** |  [A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/Supported_Payment_Gateways/Verifi_Global_Payment_Gateway#Soft_Descriptors_(Optional)). **Character limit**: 20 **Values**: &#x60;[SDPhone]&#x60;  |  [optional]
**status** | **String** |  The status of the payment in Zuora. The value depends on the type of payment. **Character limit**: 11 **Values**: one of the following:  -  Electronic payments: &#x60;Processed&#x60;, &#x60;Error&#x60;, &#x60;Voided&#x60;  -  External payments: &#x60;Processed&#x60;, &#x60;Canceled&#x60;  See [Troubleshooting Payment Runs](https://knowledgecenter.zuora.com/CB_Billing/K_Payment_Operations/CA_Payment_Runs/Troubleshooting_Payment_Runs) for more information. * Update of status can change value from &#x60;Processed&#x60; to &#x60;Canceled&#x60; when the payment type is external.  | 
**type** | **String** |  Indicates if the payment is external or electronic. **Character limit**: 10 **Values**: &#x60;External&#x60;, &#x60;Electronic&#x60;  | 



