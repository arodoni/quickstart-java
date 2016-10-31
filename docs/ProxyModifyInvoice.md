
# ProxyModifyInvoice

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | **String** |  The status of the invoice in the system. This status is not the status of the payment of the invoice, just the status of the invoice itself. **Character limit**: 8 **Values**: one of the following:  -  Draft (default, automatically set upon invoice creation)  -  Posted  -  Canceled   |  [optional]
**transferredToAccounting** | **String** |  Specifies whether or not the invoice was transferred to an external accounting system, such as NetSuite. **Character limit**: 10 **Values**: Processing, Yes, Error, Ignore  |  [optional]



