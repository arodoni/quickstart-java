
# PUTAccountType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**autoPay** | **Boolean** | Specifies whether future payments are to be automatically billed when they are due. Possible values are: &#x60;true&#x60;, &#x60;false&#x60;.  |  [optional]
**batch** | **String** | The alias name given to a batch. A string of 50 characters or less.  |  [optional]
**billToContact** | [**PUTAccountTypeBillToContact**](PUTAccountTypeBillToContact.md) |  |  [optional]
**communicationProfileId** | **String** | The ID of a [communication profile](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Communication_Profile).  |  [optional]
**crmId** | **String** | CRM account ID for the account, up to 100 characters.  |  [optional]
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**invoiceTemplateId** | **String** | Invoice template ID, configured in [Billing Settings in the Zuora UI](https://knowledgecenter.zuora.com/CB_Billing/IA_Invoices/Creating_a_Custom_Invoice_Template).  |  [optional]
**name** | **String** | Account name, up to 255 characters.  |  [optional]
**notes** | **String** | A string of up to 65,535 characters.  |  [optional]
**paymentGateway** | **String** | The name of the payment gateway instance. If null or left unassigned, the Account will use the Default Gateway.  |  [optional]
**soldToContact** | [**PUTAccountTypeSoldToContact**](PUTAccountTypeSoldToContact.md) |  |  [optional]
**tagging** | **String** | dummy |  [optional]
**taxInfo** | [**POSTAccountTypeTaxInfo**](POSTAccountTypeTaxInfo.md) |  |  [optional]



