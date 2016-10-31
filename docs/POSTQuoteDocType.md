
# POSTQuoteDocType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**apiuser** | **String** | If not using Salesforce locale, this API Zuora user will be used to retrieve the locale from Zuora.  |  [optional]
**documentType** | **String** | Type of the document to generate: &#x60;PDF&#x60; or &#x60;DOC&#x60;.  | 
**locale** | **String** | Salesforce locale value to use.  |  [optional]
**password** | **String** | dummy |  [optional]
**quoteId** | **String** | ｜ Id of the quote。 | 
**sandbox** | **String** | dummy |  [optional]
**serverUrl** | **String** | SOAP URL used to login to Salesforce to get data. You can get the value with the following code in a Visualforce page: &#x60;{!$Api.Partner_Server_URL_100}&#x60;  | 
**sessionId** | **String** | Salesforce session id used to log in to Salesforce to get data. You can get the value with the following code in a Visualforce page: *{!$Api.Session_ID}*  | 
**templateId** | **String** | Id of the quote template in Zuora.  | 
**token** | **String** | dummy |  [optional]
**useSFDCLocale** | **String** | If using Salesforce org locale, set this to a value that is not null.  |  [optional]
**username** | **String** | dummy |  [optional]
**zquotesMajorVersion** | **String** | The major version number of Zuora Quotes you are generating the quote document in. You can use a quote template with hierarchy sizes bigger than 3 if this is set to 7 or higher.  |  [optional]
**zquotesMinorVersion** | **String** | The minor version number of Zuora Quotes you are generating the quote document in.  |  [optional]



