
# POSTJournalRunType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountingPeriodName** | **String** | Name of the accounting period.  This field determines the target start and end dates of the journal run.  Required if you don&#39;t include &#39;targetStartDate&#39; and &#39;targetEndDate&#39;.  |  [optional]
**journalEntryDate** | [**LocalDate**](LocalDate.md) | Date of the journal entry.  | 
**targetEndDate** | [**LocalDate**](LocalDate.md) | The target end date of the journal run.  If you include &#39;accountingPeriodName&#39;, the &#39;targetEndDate&#39; must be empty or the same as the end date of the accounting period specified in &#39;accountingPeriodName&#39;.  |  [optional]
**targetStartDate** | [**LocalDate**](LocalDate.md) | The target start date of the journal run.  Required if you include targetEndDate.  If you include &#39;accountingPeriodName&#39;, the &#39;targetStartDate&#39; must be empty or the same as the start date of the accounting period specified in &#39;accountingPeriodName&#39;.  |  [optional]
**transactionTypes** | [**List&lt;POSTJournalRunTransactionType&gt;**](POSTJournalRunTransactionType.md) | Transaction types included in the journal run.  You can include one or more transaction types.  | 



