
# POSTAccountType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountNumber** | **String** | A unique account number, up to 50 characters that do not begin with the default account number prefix.  If no account number is specified, one is generated.  |  [optional]
**applyCreditBalance** | **Boolean** | Applies a credit balance to an invoice.   If the value is &#x60;true&#x60;, the credit balance is applied to the invoice. If the value is &#x60;false&#x60;, no action is taken.  Prerequisite: &#x60;invoice&#x60; must be &#x60;true&#x60;.   **Note:** If you are using the field &#x60;invoiceCollect&#x60; rather than the field &#x60;invoice&#x60;, the &#x60;invoiceCollect&#x60; value must be &#x60;true&#x60;.  To view the credit balance adjustment, retrieve the details of the invoice using the Get Invoices method.  |  [optional]
**autoPay** | **Boolean** | Specifies whether future payments are to be automatically billed when they are due. Possible values are: &#x60;true&#x60;, &#x60;false&#x60;.  |  [optional]
**batch** | **String** | The alias name given to a batch. A string of 50 characters or less.  |  [optional]
**billCycleDay** | **Long** | The account&#39;s bill cycle day (BCD), when bill runs generate invoices for the account.  Specify any day of the month (1-31, where 31 &#x3D; end-of-month), or 0 for auto-set.  Required if no subscription will be created.   Optional if a subscription is created and defaults to the day-of-the-month of the subscription&#39;s &#x60;contractEffectiveDate&#x60;.  |  [optional]
**billToContact** | [**POSTAccountTypeBillToContact**](POSTAccountTypeBillToContact.md) |  |  [optional]
**collect** | **String** | Collects an automatic payment for a subscription. The collection generated in this operation is only for this subscription, not for the entire customer account.  If the value is &#x60;true&#x60;, the automatic payment is collected. If the value is &#x60;false&#x60;, no action is taken.  The default value is &#x60;true&#x60;.  Prerequisite: invoice must be &#x60;true&#x60;.   **Note:** This field is in Zuora REST API version control. Supported minor versions are 196.0 or later. To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header. See [Zuora REST API Versions](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information.  |  [optional]
**communicationProfileId** | **String** | The ID of a [communication profile](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Communication_Profile).   |  [optional]
**creditCard** | [**POSTAccountTypeCreditCard**](POSTAccountTypeCreditCard.md) |  |  [optional]
**crmId** | **String** | CRM account ID for the account, up to 100 characters.  |  [optional]
**currency** | **String** | A currency as defined in [Billing Settings in the Zuora UI](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Customize_Currencies).  | 
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**hpmCreditCardPaymentMethodId** | **String** | The ID of the HPM credit card payment method associated with this account. You must provide either this field or the &#x60;creditCard&#x60; structure, but not both.  **Note:** Non-credit card payment methods are not supported.  |  [optional]
**invoice** | **String** | Creates an invoice for a subscription. The invoice generated in this operation is only for this subscription, not for the entire customer account.  If the value is &#x60;true&#x60;, an invoice is created. If the value is &#x60;false&#x60;, no action is taken.  The default value is &#x60;true&#x60;.   **Note:** This field is in Zuora REST API version control. Supported minor versions are 196.0 or later. To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header. See [Zuora REST API Versions](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information.  |  [optional]
**invoiceCollect** | **Boolean** | **Note:** This field has been replaced by the &#x60;invoice&#x60; field and the &#x60;collect&#x60; field. &#x60;invoiceCollect&#x60; is available only for backward compatibility.  If &#x60;true&#x60; (default), and a subscription is created, an invoice is generated at account creation time and payment is immediately collected using the account&#39;s default payment method.  This field is in Zuora REST API version control. Supported minor versions are 186.0, 187.0, 188.0, 189.0, and 196.0. See [Zuora REST API Versions](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics) for more information.  |  [optional]
**invoiceTargetDate** | [**LocalDate**](LocalDate.md) | If &#x60;invoiceCollect&#x60; is true, the target date for the invoice (that is, the date through which charges should be calculated). In &#x60;yyyy-mm-dd&#x60; format; defaults to the current date.  |  [optional]
**invoiceTemplateId** | **String** | Invoice template ID, configured in [Billing Settings in the Zuora UI](https://knowledgecenter.zuora.com/CB_Billing/IA_Invoices/Creating_a_Custom_Invoice_Template).  |  [optional]
**name** | **String** | Account name, up to 255 characters.  | 
**notes** | **String** | A string of up to 65,535 characters.  |  [optional]
**paymentGateway** | **String** | The name of the payment gateway instance. If null or left unassigned, the Account will use the Default Gateway.  |  [optional]
**paymentTerm** | **String** | Payment terms for this account. Possible values are: &#x60;Due Upon Receipt&#x60;, &#x60;Net 30&#x60;, &#x60;Net 60&#x60;, &#x60;Net 90&#x60;.  |  [optional]
**soldToContact** | [**POSTAccountTypeSoldToContact**](POSTAccountTypeSoldToContact.md) |  |  [optional]
**subscription** | [**POSTAccountTypeSubscription**](POSTAccountTypeSubscription.md) |  |  [optional]
**tagging** | **String** | dummy |  [optional]
**taxInfo** | [**POSTAccountTypeTaxInfo**](POSTAccountTypeTaxInfo.md) |  |  [optional]



