
# POSTDecryptResponseType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**decryptedSignature** | **String** | The string of a list of the following items: Payment Pages 2.0 URL, tenant ID, timestamp,the Payment Page ID  The items are separated by &#39;#&#39;, e.g., \&quot;/apps/publichostedpagelite.do#12271#rvBp1AxBJwk6FrT7aqFuABIINiRbwJCc #1418848373103#2c92c0f948f899\&quot;  |  [optional]
**publicKey** | **String** | The public key passed in as a request parameter.  |  [optional]
**signature** | **String** | The signature passed in as a request parameter.  |  [optional]
**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional]



