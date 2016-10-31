
# POSTAccountTypeBillToContact

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**address1** | **String** | First address line, 255 characters or less.  |  [optional]
**address2** | **String** | Second address line, 255 characters or less.  |  [optional]
**city** | **String** | City, 40 characters or less.  |  [optional]
**country** | **String** | Country; must be a [valid country name or abbreviation](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/J_Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes). If using [Z-Tax](https://knowledgecenter.zuora.com/CB_Billing/J_Billing_Operations/L_Taxes/A_Z-Tax), must specify a country in the sold-to contact to calculate tax. A bill-to contact may be used if no sold-to contact is provided.  |  [optional]
**county** | **String** | County; 32 characters or less. May optionally be used by [Z-Tax](https://knowledgecenter.zuora.com/CB_Billing/J_Billing_Operations/L_Taxes/A_Z-Tax) to calculate county tax.  |  [optional]
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**fax** | **String** | Fax phone number, 40 characters or less.  |  [optional]
**firstName** | **String** | First name, 100 characters or less.  | 
**homePhone** | **String** | Home phone number, 40 characters or less.  |  [optional]
**lastName** | **String** | Last name, 100 characters or less.  | 
**mobilePhone** | **String** | Mobile phone number, 40 characters or less.  |  [optional]
**nickname** | **String** | Nickname for this contact  |  [optional]
**otherPhone** | **String** | Other phone number, 40 characters or less.  |  [optional]
**otherPhoneType** | **String** | Possible values are: &#x60;Work&#x60;, &#x60;Mobile&#x60;, &#x60;Home&#x60;, &#x60;Other&#x60;.  |  [optional]
**personalEmail** | **String** | Personal email address, 80 characters or less.  |  [optional]
**state** | **String** | State; must be a [valid state or province name or 2-character abbreviation](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/J_Country%2C_State%2C_and_Province_Codes/B_State_Names_and_2-Digit_Codes). If using Z-Tax, be aware that [Z-Tax](https://knowledgecenter.zuora.com/CB_Billing/J_Billing_Operations/L_Taxes/A_Z-Tax) requires a state (in the US) or province (in Canada) in this field for the sold-to contact to calculate tax, and that a bill-to contact may be used if no sold-to contact is provided.  |  [optional]
**taxRegion** | **String** | If using [Z-Tax](https://knowledgecenter.zuora.com/CB_Billing/J_Billing_Operations/L_Taxes/A_Z-Tax), a region string as optionally defined in your tax rules. Not required.  |  [optional]
**workEmail** | **String** | Work email address, 80 characters or less.  |  [optional]
**workPhone** | **String** | Work phone number, 40 characters or less.  |  [optional]
**zipCode** | **String** | Zip code, 20 characters or less.  |  [optional]



