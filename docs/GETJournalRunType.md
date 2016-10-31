
# GETJournalRunType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**aggregateCurrency** | **Boolean** | dummy |  [optional]
**executedOn** | [**DateTime**](DateTime.md) | Date and time the journal run was executed.  |  [optional]
**journalEntryDate** | [**LocalDate**](LocalDate.md) | Date of the journal entry.  |  [optional]
**number** | **String** | Journal run number.  |  [optional]
**segmentationRuleName** | **String** | Name of GL segmentation rule used in the journal run.  |  [optional]
**status** | **String** | Status of the journal run.   The possible values are: * Pending * Processing * Completed * Error * CancelInprogress * Cancelled * DeleteInprogress  |  [optional]
**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional]
**targetEndDate** | [**LocalDate**](LocalDate.md) | The target end date of the journal run.  |  [optional]
**targetStartDate** | [**LocalDate**](LocalDate.md) | The target start date of the journal run.  |  [optional]
**totalJournalEntryCount** | **Long** | Total number of journal entries in the journal run.  |  [optional]
**transactionTypes** | [**List&lt;GETJournalRunTransactionType&gt;**](GETJournalRunTransactionType.md) | Transaction types included in the journal run.  |  [optional]



