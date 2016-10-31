
# Contact

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** |  The Zuora account ID associated with this contact. This field is not required when you use the subscribe() call. This field is required for all other calls. **Character limit: **32 **Values: **[a valid account ID](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/E1_SOAP_API_Object_Reference/Account#Id)  |  [optional]
**address1** | **String** |  The first line of the contact&#39;s address, which is often a street address or business name. **Character limit**: 255 **Values**: a string of 255 characters or fewer  |  [optional]
**address2** | **String** |  The second line of the contact&#39;s address. **Character limit**: 255 **Values**: a string of 255 characters or fewer  |  [optional]
**city** | **String** |  The city of the contact&#39;s address. **Character limit**: 40 **Values: **a string of 40 characters or fewer  |  [optional]
**country** | **String** |  The country of the contact&#39;s address. If using [a valid country name or abbreviation](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/J_Country%2C_State%2C_and_Province_Codes)  |  [optional]
**county** | **String** |  The country. May optionally be used by [Z-Tax](/C_Zuora_User_Guides/A_Billing_and_Payments/I_Taxes/Z-Tax) to calculate county tax. **Character limit**: 32 **Values**: a string of 32 characters or fewer  |  [optional]
**createdById** | **String** | The ID of the Zuora user who created the contact. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**createdDate** | [**DateTime**](DateTime.md) | The date when the contact was created. **Character limit**: 29 **Values**: automatically generated  |  [optional]
**description** | **String** |  A description for the contact. **Character limit**: 100 **Values**: a string of 100 characters or fewer  |  [optional]
**fax** | **String** |  The contact&#39;s fax number. **Character limit**: 40 **Values**: a string of 40 characters or fewer  |  [optional]
**firstName** | **String** |  The contact&#39;s first name. **Character limit**: 100 **Values**: a string of the contact&#39;s first name  |  [optional]
**homePhone** | **String** |  The contact&#39;s home phone number. **Character limit**: 40 **Values**: a string of 40 characters or fewer  |  [optional]
**id** | **String** |  The ID of this object. Upon creation of this object, this field becomes &#x60;ContactId&#x60;. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**lastName** | **String** |  The contact&#39;s last name. **Character limit**: 100 **Values**: a string of 100 characters or fewer  |  [optional]
**mobilePhone** | **String** |  The contact&#39;s mobile phone number. **Character limit**: 40 **Values**: a string of 40 characters or fewer  |  [optional]
**nickName** | **String** |  A nickname for the contact. **Character limit**: 100 **Values**: a string of 100 characters or fewer  |  [optional]
**otherPhone** | **String** |  An additional phone number for the contact. **Character limit**: 40 **Values**: a string of 40 characters or fewer  |  [optional]
**otherPhoneType** | **String** | The type of the &#x60;OtherPhone&#x60;. **Character limit**: 20 **Values**: &#x60;Work&#x60;, &#x60;Mobile&#x60;, &#x60;Home&#x60;, &#x60;Other&#x60;  |  [optional]
**personalEmail** | **String** |  The contact&#39;s personal email address. **Character limit**: 80 **Values**: a string of 80 characters or fewer  |  [optional]
**postalCode** | **String** |  The zip code for the contact&#39;s address. **Character limit:** 20 **Values: **a string of 20 characters or fewer  |  [optional]
**state** | **String** |  The state or province of the contact&#39;s address. If using [a valid state name or abbreviation](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/J_Country%2C_State%2C_and_Province_Codes/B_State_Names_and_2-Digit_Codes)  |  [optional]
**taxRegion** | **String** | If using [Z-Tax](https://knowledgecenter.zuora.com/CB_Billing/J_Billing_Operations/L_Taxes/A_Z-Tax) tax rules  |  [optional]
**updatedById** | **String** |  The ID of the user who lasted updated the contact. **Character limit**: 32 **Values**: automatically generated  |  [optional]
**updatedDate** | [**DateTime**](DateTime.md) |  The date when the contact was last updated. **Character limit**: 29 **Values**: automatically generated  |  [optional]
**workEmail** | **String** |  The contact&#39;s business email address. **Character limit**: 80 **Values**: a string of 80 characters or fewer  |  [optional]
**workPhone** | **String** |  The contact&#39;s business phone number. **Character limit**: 40 **notes**: -- **Values**: a string of 40 characters or fewer  |  [optional]
**fieldsToNull** | **String** |  |  [optional]



