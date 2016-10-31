
# GETCustomExchangeRatesType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**inverse** | **Boolean** | - If &#x60;true&#x60;, the exchange rate in the response is an inverse exchange rate. - If &#x60;false&#x60;, the exchange rate in the response is not an inverse exchange rate. The value is determined by the **Use inverse rate** checkbox in your Z-Finance [Manage Currency Conversion](https://knowledgecenter.zuora.com/CC_Finance/Foreign_Currency_Conversion#How_to_Enable_Foreign_Currency_Conversion) settings.  |  [optional]
**rates** | [**List&lt;GETCustomExchangeRatesDataType&gt;**](GETCustomExchangeRatesDataType.md) | Container for exchange rate data. Contains a set of fields that provide exchange rate data for each day between the specified &#x60;startDate&#x60; and &#x60;endDate&#x60; (inclusive).   |  [optional]
**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional]



