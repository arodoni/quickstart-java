
# ProxyModifyPayment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** |  The unique account ID for the customer that the payment is for. **Character limit**: 32 **Values**: a valid [account ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account)  |  [optional]
**accountingCode** | **String** |  The [Chart of Accounts](/CB_Billing/W_Billing_and_Payments_Settings/V_Configure_Accounting_Codes/D_Set_Up_Chart_of_Accounts)  |  [optional]
**amount** | **Double** |  The amount of the payment. **Character limit**: 16 **Values**: a valid currency value  |  [optional]
**comment** | **String** |  Additional information related to the payment. **Character limit**: 255 **Values**: a string of 255 characters or fewer  |  [optional]
**effectiveDate** | [**LocalDate**](LocalDate.md) |  The date when the payment takes effect. **Character limit**: 29 **Values**: [a valid date and time value](/CB_Billing/WA_Dates_in_Zuora/A_Date_Format_and_Datetimes_in_Zuora)  |  [optional]
**paymentMethodId** | **String** |  The ID of the payment method used for the payment. Required for Create. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**referenceId** | **String** |  The transaction ID returned by the payment gateway. Use this field to reconcile payments between your gateway and Z-Payments. **Character limit**: 60 **Values**: a string of 60 characters or fewer  |  [optional]
**status** | **String** |  The status of the payment in Zuora. The value depends on the type of payment. **Character limit**: 11 **Values**: one of the following:  -  Electronic payments: &#x60;Processed&#x60;, &#x60;Error&#x60;, &#x60;Voided&#x60;  -  External payments: &#x60;Processed&#x60;, &#x60;Canceled&#x60;  See [Troubleshooting Payment Runs](https://knowledgecenter.zuora.com/CB_Billing/K_Payment_Operations/CA_Payment_Runs/Troubleshooting_Payment_Runs) for more information. * Update of status can change value from &#x60;Processed&#x60; to &#x60;Canceled&#x60; when the payment type is external.  |  [optional]
**transferredToAccounting** | **String** |  Indicates if the payment was transferred to an external accounting system. Use this field for integration with accounting systems, such as NetSuite. **Character limit**: 11 **Values**: &#x60;Processing&#x60;, &#x60;Yes&#x60;, &#x60;Error&#x60;, &#x60;Ignore&#x60;  |  [optional]
**type** | **String** |  Indicates if the payment is external or electronic. **Character limit**: 10 **Values**: &#x60;External&#x60;, &#x60;Electronic&#x60;  |  [optional]



