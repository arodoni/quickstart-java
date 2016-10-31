# swagger-java-client

## Overview

Thank you for interest in the Zuora quickstart.

This quickstart is created to help you quickly integrate with Zuora through the use of the Zuora
REST APIs, without being burdened by the underlying HTTP mechanics.  For additional information on 
the Zuora APIs please visit the 
[Zuora Knowledgecenter](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference)

The sample code demonstrates how to invoke the REST resources via a Swagger.io generated framework, to
implement 5 use cases:
* Retrieve the Zuora product catalog
* Create an account and subscription
* Retrieve a subscription
* Upgrade a subscription
* Cancel a subscription 

The quickstart was generated using Swagger.io, and utilizes a single class to provide an example of
how to interact with the Zuora REST API: zuora.com.rest.ZuoraQuickstart.ZuoraController.java

### Zuora Test Drive

To complete this tutorial, you'll need a Zuora Test Drive tenant.

The Test Drive tenant comes with seed data, such as a sample product catalog, which will be used in the Exercises.
Go to [Zuora Test Drive](https://www.zuora.com/resource/zuora-test-drive/) and sign up for a tenant.

### Swagger.io

Swagger.io is a popular framework used for describing APIs, and generating REST based reference code 
against those APIs.  The code utilized in this quickstart was generated utilizing Swagger.  Swagger:
* Generates a model based on the API request and response
* Handles the communication and authentication to Zuora
* Ties perfectly with the Zuora documentation

View [Swagger.io](http://swagger.io/getting-started/) for more details on Swagger.

### Maven

Maven is the build manager utilized by Swagger.  Maven manages the projects build utilizing the 
pom.xml file.  This version of the quickstart will download the following libraries:
* swagger-annotations-1.5.9.jar
* okhttp:-2.7.5.jar
* okio-1.6.0.jar
* logging-interceptor-2.7.5.jar
* gson-2.6.2.jar
* joda-time-2.9.3.jar
* junit-4.12.jar
* hamcrest-core-1.3.jar

## Requirements

* Building the API client library requires [Maven](https://maven.apache.org/) to be installed.
* Zuora enforces the use of TLS 1.1 and thus this project has been built using Java 1.8, and Java 1.8 or higher is recommended
* Eclipse is not required, but this project was put togehter using Eclipse Luna

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.AccountingCodesApi;

import java.io.File;
import java.util.*;

public class AccountingCodesApiExample {

    public static void main(String[] args) {
        
        AccountingCodesApi apiInstance = new AccountingCodesApi();
        String acId = "acId_example"; // String | ID of the accounting code you want to delete.
        try {
            CommonResponseType result = apiInstance.dELETEAccountingCode(acId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccountingCodesApi#dELETEAccountingCode");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://rest.zuora.com/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AccountingCodesApi* | [**dELETEAccountingCode**](docs/AccountingCodesApi.md#dELETEAccountingCode) | **DELETE** /accounting-codes/{ac-id} | Delete accounting code
*AccountingCodesApi* | [**gETAccountingCodeItem**](docs/AccountingCodesApi.md#gETAccountingCodeItem) | **GET** /accounting-codes/{ac-id} | Query an accounting code
*AccountingCodesApi* | [**gETAccountingCodes**](docs/AccountingCodesApi.md#gETAccountingCodes) | **GET** /accounting-codes | Get all accounting codes
*AccountingCodesApi* | [**pOSTAccountingCode**](docs/AccountingCodesApi.md#pOSTAccountingCode) | **POST** /accounting-codes | Create accounting code
*AccountingCodesApi* | [**pUTAccountingCode**](docs/AccountingCodesApi.md#pUTAccountingCode) | **PUT** /accounting-codes/{ac-id} | Update an accounting code
*AccountingCodesApi* | [**pUTActivateAccountingCode**](docs/AccountingCodesApi.md#pUTActivateAccountingCode) | **PUT** /accounting-codes/{ac-id}/activate | Activate accounting code
*AccountingCodesApi* | [**pUTDeactivateAccountingCode**](docs/AccountingCodesApi.md#pUTDeactivateAccountingCode) | **PUT** /accounting-codes/{ac-id}/deactivate | Deactivate accounting code
*AccountingCodesApi* | [**proxyDELETEAccountingCode**](docs/AccountingCodesApi.md#proxyDELETEAccountingCode) | **DELETE** /object/accounting-code/{id} | CRUD: Delete AccountingCode
*AccountingCodesApi* | [**proxyGETAccountingCode**](docs/AccountingCodesApi.md#proxyGETAccountingCode) | **GET** /object/accounting-code/{id} | CRUD: Retrieve AccountingCode
*AccountingCodesApi* | [**proxyPOSTAccountingCode**](docs/AccountingCodesApi.md#proxyPOSTAccountingCode) | **POST** /object/accounting-code | CRUD: Create AccountingCode
*AccountingCodesApi* | [**proxyPUTAccountingCode**](docs/AccountingCodesApi.md#proxyPUTAccountingCode) | **PUT** /object/accounting-code/{id} | CRUD: Update AccountingCode
*AccountingPeriodsApi* | [**dELETEAccountingPeriod**](docs/AccountingPeriodsApi.md#dELETEAccountingPeriod) | **DELETE** /accounting-periods/{ap-id} | Delete accounting period
*AccountingPeriodsApi* | [**gETAccountingPeriod**](docs/AccountingPeriodsApi.md#gETAccountingPeriod) | **GET** /accounting-periods/{ap-id} | Get accounting period
*AccountingPeriodsApi* | [**gETAccountingPeriods**](docs/AccountingPeriodsApi.md#gETAccountingPeriods) | **GET** /accounting-periods | Get all accounting periods
*AccountingPeriodsApi* | [**pOSTAccountingPeriod**](docs/AccountingPeriodsApi.md#pOSTAccountingPeriod) | **POST** /accounting-periods | Create accounting period
*AccountingPeriodsApi* | [**pUTCloseAccountingPeriod**](docs/AccountingPeriodsApi.md#pUTCloseAccountingPeriod) | **PUT** /accounting-periods/{ap-id}/close | Close accounting period
*AccountingPeriodsApi* | [**pUTPendingCloseAccountingPeriod**](docs/AccountingPeriodsApi.md#pUTPendingCloseAccountingPeriod) | **PUT** /accounting-periods/{ap-id}/pending-close | Set accounting period to pending close
*AccountingPeriodsApi* | [**pUTReopenAccountingPeriod**](docs/AccountingPeriodsApi.md#pUTReopenAccountingPeriod) | **PUT** /accounting-periods/{ap-id}/reopen | Re-open accounting period
*AccountingPeriodsApi* | [**pUTRunTrialBalance**](docs/AccountingPeriodsApi.md#pUTRunTrialBalance) | **PUT** /accounting-periods/{ap-id}/run-trial-balance | Run trial balance
*AccountingPeriodsApi* | [**pUTUpdateAccountingPeriod**](docs/AccountingPeriodsApi.md#pUTUpdateAccountingPeriod) | **PUT** /accounting-periods/{ap-id} | Update accounting period
*AccountingPeriodsApi* | [**proxyDELETEAccountingPeriod**](docs/AccountingPeriodsApi.md#proxyDELETEAccountingPeriod) | **DELETE** /object/accounting-period/{id} | CRUD: Delete AccountingPeriod
*AccountingPeriodsApi* | [**proxyGETAccountingPeriod**](docs/AccountingPeriodsApi.md#proxyGETAccountingPeriod) | **GET** /object/accounting-period/{id} | CRUD: Retrieve AccountingPeriod
*AccountsApi* | [**gETAccount**](docs/AccountsApi.md#gETAccount) | **GET** /accounts/{account-key} | Get account
*AccountsApi* | [**gETAccountSummary**](docs/AccountsApi.md#gETAccountSummary) | **GET** /accounts/{account-key}/Summary | Get account summary
*AccountsApi* | [**pOSTAccount**](docs/AccountsApi.md#pOSTAccount) | **POST** /accounts | Create account
*AccountsApi* | [**pUTAccount**](docs/AccountsApi.md#pUTAccount) | **PUT** /accounts/{account-key} | Update account
*AccountsApi* | [**proxyDELETEAccount**](docs/AccountsApi.md#proxyDELETEAccount) | **DELETE** /object/account/{id} | CRUD: Delete Account
*AccountsApi* | [**proxyGETAccount**](docs/AccountsApi.md#proxyGETAccount) | **GET** /object/account/{id} | CRUD: Retrieve Account
*AccountsApi* | [**proxyPOSTAccount**](docs/AccountsApi.md#proxyPOSTAccount) | **POST** /object/account | CRUD: Create Account
*AccountsApi* | [**proxyPUTAccount**](docs/AccountsApi.md#proxyPUTAccount) | **PUT** /object/account/{id} | CRUD: Update Account
*ActionsApi* | [**proxyActionPOSTamend**](docs/ActionsApi.md#proxyActionPOSTamend) | **POST** /action/amend | Amend
*ActionsApi* | [**proxyActionPOSTcreate**](docs/ActionsApi.md#proxyActionPOSTcreate) | **POST** /action/create | Create
*ActionsApi* | [**proxyActionPOSTdelete**](docs/ActionsApi.md#proxyActionPOSTdelete) | **POST** /action/delete | Delete
*ActionsApi* | [**proxyActionPOSTexecute**](docs/ActionsApi.md#proxyActionPOSTexecute) | **POST** /action/execute | Execute
*ActionsApi* | [**proxyActionPOSTgenerate**](docs/ActionsApi.md#proxyActionPOSTgenerate) | **POST** /action/generate | Generate
*ActionsApi* | [**proxyActionPOSTgetUserInfo**](docs/ActionsApi.md#proxyActionPOSTgetUserInfo) | **POST** /action/getUserInfo | GetUserInfo
*ActionsApi* | [**proxyActionPOSTlogin**](docs/ActionsApi.md#proxyActionPOSTlogin) | **POST** /action/login | Login
*ActionsApi* | [**proxyActionPOSTquery**](docs/ActionsApi.md#proxyActionPOSTquery) | **POST** /action/query | Query
*ActionsApi* | [**proxyActionPOSTqueryMore**](docs/ActionsApi.md#proxyActionPOSTqueryMore) | **POST** /action/queryMore | QueryMore
*ActionsApi* | [**proxyActionPOSTsubscribe**](docs/ActionsApi.md#proxyActionPOSTsubscribe) | **POST** /action/subscribe | Subscribe
*ActionsApi* | [**proxyActionPOSTupdate**](docs/ActionsApi.md#proxyActionPOSTupdate) | **POST** /action/update | Update
*AmendmentsApi* | [**gETAmendment**](docs/AmendmentsApi.md#gETAmendment) | **GET** /amendments/{amendment-key} | Get amendments by key
*AmendmentsApi* | [**gETAmendmentsBySubscriptionID**](docs/AmendmentsApi.md#gETAmendmentsBySubscriptionID) | **GET** /amendments/subscriptions/{subscription-id} | Get amendments by subscription ID
*AmendmentsApi* | [**proxyDELETEAmendment**](docs/AmendmentsApi.md#proxyDELETEAmendment) | **DELETE** /object/amendment/{id} | CRUD: Delete Amendment
*AmendmentsApi* | [**proxyGETAmendment**](docs/AmendmentsApi.md#proxyGETAmendment) | **GET** /object/amendment/{id} | CRUD: Retrieve Amendment
*AmendmentsApi* | [**proxyPOSTAmendment**](docs/AmendmentsApi.md#proxyPOSTAmendment) | **POST** /object/amendment | CRUD: Create Amendment
*AmendmentsApi* | [**proxyPUTAmendment**](docs/AmendmentsApi.md#proxyPUTAmendment) | **PUT** /object/amendment/{id} | CRUD: Update Amendment
*AttachmentsApi* | [**dELETEAttachments**](docs/AttachmentsApi.md#dELETEAttachments) | **DELETE** /attachments/{attachment-id} | Delete attachments
*AttachmentsApi* | [**gETAttachments**](docs/AttachmentsApi.md#gETAttachments) | **GET** /attachments/{attachment-id} | View attachments
*AttachmentsApi* | [**gETAttachmentsResponse**](docs/AttachmentsApi.md#gETAttachmentsResponse) | **GET** /attachments/{object-type}/{object-key} | View attachments list
*AttachmentsApi* | [**pOSTAttachments**](docs/AttachmentsApi.md#pOSTAttachments) | **POST** /attachments | Add attachments
*AttachmentsApi* | [**pUTAttachments**](docs/AttachmentsApi.md#pUTAttachments) | **PUT** /attachments/{attachment-id} | Edit attachments
*CatalogApi* | [**gETCatalog**](docs/CatalogApi.md#gETCatalog) | **GET** /catalog/products | Get product catalog
*ChargeRevenueSummariesApi* | [**gETCRSByCRSNumber**](docs/ChargeRevenueSummariesApi.md#gETCRSByCRSNumber) | **GET** /charge-revenue-summaries/{crs-number} | Get charge summary details by CRS number
*ChargeRevenueSummariesApi* | [**gETCRSByChargeID**](docs/ChargeRevenueSummariesApi.md#gETCRSByChargeID) | **GET** /charge-revenue-summaries/subscription-charges/{charge-key} | Get charge summary details by charge ID
*CommunicationProfilesApi* | [**proxyDELETECommunicationProfile**](docs/CommunicationProfilesApi.md#proxyDELETECommunicationProfile) | **DELETE** /object/communication-profile/{id} | CRUD: Delete CommunicationProfile
*CommunicationProfilesApi* | [**proxyGETCommunicationProfile**](docs/CommunicationProfilesApi.md#proxyGETCommunicationProfile) | **GET** /object/communication-profile/{id} | CRUD: Retrieve CommunicationProfile
*ConnectionsApi* | [**pOSTConnections**](docs/ConnectionsApi.md#pOSTConnections) | **POST** /connections | Establish connection to Zuora REST API service
*ContactsApi* | [**proxyDELETEContact**](docs/ContactsApi.md#proxyDELETEContact) | **DELETE** /object/contact/{id} | CRUD: Delete Contact
*ContactsApi* | [**proxyGETContact**](docs/ContactsApi.md#proxyGETContact) | **GET** /object/contact/{id} | CRUD: Retrieve Contact
*ContactsApi* | [**proxyPOSTContact**](docs/ContactsApi.md#proxyPOSTContact) | **POST** /object/contact | CRUD: Create Contact
*ContactsApi* | [**proxyPUTContact**](docs/ContactsApi.md#proxyPUTContact) | **PUT** /object/contact/{id} | CRUD: Update Contact
*CreditBalanceAdjustmentsApi* | [**proxyDELETECreditBalanceAdjustment**](docs/CreditBalanceAdjustmentsApi.md#proxyDELETECreditBalanceAdjustment) | **DELETE** /object/credit-balance-adjustment/{id} | CRUD: Delete CreditBalanceAdjustment
*CreditBalanceAdjustmentsApi* | [**proxyGETCreditBalanceAdjustment**](docs/CreditBalanceAdjustmentsApi.md#proxyGETCreditBalanceAdjustment) | **GET** /object/credit-balance-adjustment/{id} | CRUD: Retrieve CreditBalanceAdjustment
*CustomExchangeRatesApi* | [**gETCustomExchangeRates**](docs/CustomExchangeRatesApi.md#gETCustomExchangeRates) | **GET** /custom-exchange-rates/{currency} | Get custom foreign currency exchange rates
*ExportsApi* | [**proxyDELETEExport**](docs/ExportsApi.md#proxyDELETEExport) | **DELETE** /object/export/{id} | CRUD: Delete Export
*ExportsApi* | [**proxyGETExport**](docs/ExportsApi.md#proxyGETExport) | **GET** /object/export/{id} | CRUD: Retrieve Export
*ExportsApi* | [**proxyPOSTExport**](docs/ExportsApi.md#proxyPOSTExport) | **POST** /object/export | CRUD: Create Export
*FeaturesApi* | [**proxyDELETEFeature**](docs/FeaturesApi.md#proxyDELETEFeature) | **DELETE** /object/feature/{id} | CRUD: Delete Feature
*FeaturesApi* | [**proxyGETFeature**](docs/FeaturesApi.md#proxyGETFeature) | **GET** /object/feature/{id} | CRUD: Retrieve Feature
*GetFilesApi* | [**gETFiles**](docs/GetFilesApi.md#gETFiles) | **GET** /files/{file-id} | Get files
*HMACSignaturesApi* | [**pOSTHMACSignature**](docs/HMACSignaturesApi.md#pOSTHMACSignature) | **POST** /hmac-signatures | Return HMAC signatures
*HostedPagesApi* | [**getHostedPages**](docs/HostedPagesApi.md#getHostedPages) | **GET** /hostedpages | Return hosted pages
*ImportsApi* | [**proxyDELETEImport**](docs/ImportsApi.md#proxyDELETEImport) | **DELETE** /object/import/{id} | CRUD: Delete Import
*ImportsApi* | [**proxyGETImport**](docs/ImportsApi.md#proxyGETImport) | **GET** /object/import/{id} | CRUD: Retrieve Import
*ImportsApi* | [**proxyPOSTImport**](docs/ImportsApi.md#proxyPOSTImport) | **POST** /object/import | CRUD: Create Import
*InvoiceAdjustmentsApi* | [**proxyDELETEInvoiceAdjustment**](docs/InvoiceAdjustmentsApi.md#proxyDELETEInvoiceAdjustment) | **DELETE** /object/invoice-adjustment/{id} | CRUD: Delete InvoiceAdjustment
*InvoiceAdjustmentsApi* | [**proxyGETInvoiceAdjustment**](docs/InvoiceAdjustmentsApi.md#proxyGETInvoiceAdjustment) | **GET** /object/invoice-adjustment/{id} | CRUD: Retrieve InvoiceAdjustment
*InvoiceAdjustmentsApi* | [**proxyPOSTInvoiceAdjustment**](docs/InvoiceAdjustmentsApi.md#proxyPOSTInvoiceAdjustment) | **POST** /object/invoice-adjustment | CRUD: Create InvoiceAdjustment
*InvoiceAdjustmentsApi* | [**proxyPUTInvoiceAdjustment**](docs/InvoiceAdjustmentsApi.md#proxyPUTInvoiceAdjustment) | **PUT** /object/invoice-adjustment/{id} | CRUD: Update InvoiceAdjustment
*InvoiceItemAdjustmentsApi* | [**proxyDELETEInvoiceItemAdjustment**](docs/InvoiceItemAdjustmentsApi.md#proxyDELETEInvoiceItemAdjustment) | **DELETE** /object/invoice-item-adjustment/{id} | CRUD: Delete InvoiceItemAdjustment
*InvoiceItemAdjustmentsApi* | [**proxyGETInvoiceItemAdjustment**](docs/InvoiceItemAdjustmentsApi.md#proxyGETInvoiceItemAdjustment) | **GET** /object/invoice-item-adjustment/{id} | CRUD: Retrieve InvoiceItemAdjustment
*InvoiceItemsApi* | [**proxyDELETEInvoiceItem**](docs/InvoiceItemsApi.md#proxyDELETEInvoiceItem) | **DELETE** /object/invoice-item/{id} | CRUD: Delete InvoiceItem
*InvoiceItemsApi* | [**proxyGETInvoiceItem**](docs/InvoiceItemsApi.md#proxyGETInvoiceItem) | **GET** /object/invoice-item/{id} | CRUD: Retrieve InvoiceItem
*InvoicePaymentsApi* | [**proxyDELETEInvoicePayment**](docs/InvoicePaymentsApi.md#proxyDELETEInvoicePayment) | **DELETE** /object/invoice-payment/{id} | CRUD: Delete InvoicePayment
*InvoicePaymentsApi* | [**proxyGETInvoicePayment**](docs/InvoicePaymentsApi.md#proxyGETInvoicePayment) | **GET** /object/invoice-payment/{id} | CRUD: Retrieve InvoicePayment
*InvoicePaymentsApi* | [**proxyPOSTInvoicePayment**](docs/InvoicePaymentsApi.md#proxyPOSTInvoicePayment) | **POST** /object/invoice-payment | CRUD: Create InvoicePayment
*InvoicePaymentsApi* | [**proxyPUTInvoicePayment**](docs/InvoicePaymentsApi.md#proxyPUTInvoicePayment) | **PUT** /object/invoice-payment/{id} | CRUD: Update InvoicePayment
*InvoiceSplitItemsApi* | [**proxyDELETEInvoiceSplitItem**](docs/InvoiceSplitItemsApi.md#proxyDELETEInvoiceSplitItem) | **DELETE** /object/invoice-split-item/{id} | CRUD: Delete InvoiceSplitItem
*InvoiceSplitItemsApi* | [**proxyGETInvoiceSplitItem**](docs/InvoiceSplitItemsApi.md#proxyGETInvoiceSplitItem) | **GET** /object/invoice-split-item/{id} | CRUD: Retrieve InvoiceSplitItem
*InvoiceSplitsApi* | [**proxyDELETEInvoiceSplit**](docs/InvoiceSplitsApi.md#proxyDELETEInvoiceSplit) | **DELETE** /object/invoice-split/{id} | CRUD: Delete InvoiceSplit
*InvoiceSplitsApi* | [**proxyGETInvoiceSplit**](docs/InvoiceSplitsApi.md#proxyGETInvoiceSplit) | **GET** /object/invoice-split/{id} | CRUD: Retrieve InvoiceSplit
*InvoicesApi* | [**proxyDELETEInvoice**](docs/InvoicesApi.md#proxyDELETEInvoice) | **DELETE** /object/invoice/{id} | CRUD: Delete Invoice
*InvoicesApi* | [**proxyGETInvoice**](docs/InvoicesApi.md#proxyGETInvoice) | **GET** /object/invoice/{id} | CRUD: Retrieve Invoice
*InvoicesApi* | [**proxyPOSTInvoice**](docs/InvoicesApi.md#proxyPOSTInvoice) | **POST** /object/invoice | CRUD: Create Invoice
*InvoicesApi* | [**proxyPUTInvoice**](docs/InvoicesApi.md#proxyPUTInvoice) | **PUT** /object/invoice/{id} | CRUD: Update Invoice
*JournalRunsApi* | [**dELETEJournalRun**](docs/JournalRunsApi.md#dELETEJournalRun) | **DELETE** /journal-runs/{jr-number} | Delete journal run
*JournalRunsApi* | [**gETJournalRun**](docs/JournalRunsApi.md#gETJournalRun) | **GET** /journal-runs/{jr-number} | Get journal run
*JournalRunsApi* | [**pOSTJournalRun**](docs/JournalRunsApi.md#pOSTJournalRun) | **POST** /journal-runs | Create journal run
*JournalRunsApi* | [**pUTJournalRun**](docs/JournalRunsApi.md#pUTJournalRun) | **PUT** /journal-runs/{jr-number}/cancel | Cancel journal run
*MassUpdaterApi* | [**gETMassUpdate**](docs/MassUpdaterApi.md#gETMassUpdate) | **GET** /bulk/{bulk-key} | Get mass action result
*MassUpdaterApi* | [**pOSTMassUpdate**](docs/MassUpdaterApi.md#pOSTMassUpdate) | **POST** /bulk | Perform mass action
*MassUpdaterApi* | [**pUTMassUpdater**](docs/MassUpdaterApi.md#pUTMassUpdater) | **PUT** /bulk/{bulk-key}/stop | Stop mass action
*NotificationHistoryApi* | [**gETCalloutHistoryVOs**](docs/NotificationHistoryApi.md#gETCalloutHistoryVOs) | **GET** /notification-history/callout | Get callout notification histories
*NotificationHistoryApi* | [**gETEmailHistoryVOs**](docs/NotificationHistoryApi.md#gETEmailHistoryVOs) | **GET** /notification-history/email | Get email notification histories
*OperationsApi* | [**pOSTTransactionInvoicePayment**](docs/OperationsApi.md#pOSTTransactionInvoicePayment) | **POST** /operations/invoice-collect | Invoice and collect
*PaymentMethodSnapshotsApi* | [**proxyDELETEPaymentMethodSnapshot**](docs/PaymentMethodSnapshotsApi.md#proxyDELETEPaymentMethodSnapshot) | **DELETE** /object/payment-method-snapshot/{id} | CRUD: Delete PaymentMethodSnapshot
*PaymentMethodSnapshotsApi* | [**proxyGETPaymentMethodSnapshot**](docs/PaymentMethodSnapshotsApi.md#proxyGETPaymentMethodSnapshot) | **GET** /object/payment-method-snapshot/{id} | CRUD: Retrieve PaymentMethodSnapshot
*PaymentMethodTransactionLogsApi* | [**proxyDELETEPaymentMethodTransactionLog**](docs/PaymentMethodTransactionLogsApi.md#proxyDELETEPaymentMethodTransactionLog) | **DELETE** /object/payment-method-transaction-log/{id} | CRUD: Delete PaymentMethodTransactionLog
*PaymentMethodTransactionLogsApi* | [**proxyGETPaymentMethodTransactionLog**](docs/PaymentMethodTransactionLogsApi.md#proxyGETPaymentMethodTransactionLog) | **GET** /object/payment-method-transaction-log/{id} | CRUD: Retrieve PaymentMethodTransactionLog
*PaymentMethodsApi* | [**dELETEPaymentMethods**](docs/PaymentMethodsApi.md#dELETEPaymentMethods) | **DELETE** /payment-methods/{payment-method-id} | Delete payment method
*PaymentMethodsApi* | [**gETPaymentMethods**](docs/PaymentMethodsApi.md#gETPaymentMethods) | **GET** /payment-methods/credit-cards/accounts/{account-key} | Get payment methods
*PaymentMethodsApi* | [**pOSTPaymentMethod**](docs/PaymentMethodsApi.md#pOSTPaymentMethod) | **POST** /payment-methods/credit-cards | Create payment method
*PaymentMethodsApi* | [**pUTPaymentMethods**](docs/PaymentMethodsApi.md#pUTPaymentMethods) | **PUT** /payment-methods/credit-cards/{payment-method-id} | Update payment method
*PaymentMethodsApi* | [**proxyDELETEPaymentMethod**](docs/PaymentMethodsApi.md#proxyDELETEPaymentMethod) | **DELETE** /object/payment-method/{id} | CRUD: Delete PaymentMethod
*PaymentMethodsApi* | [**proxyGETPaymentMethod**](docs/PaymentMethodsApi.md#proxyGETPaymentMethod) | **GET** /object/payment-method/{id} | CRUD: Retrieve PaymentMethod
*PaymentMethodsApi* | [**proxyPOSTPaymentMethod**](docs/PaymentMethodsApi.md#proxyPOSTPaymentMethod) | **POST** /object/payment-method | CRUD: Create PaymentMethod
*PaymentMethodsApi* | [**proxyPUTPaymentMethod**](docs/PaymentMethodsApi.md#proxyPUTPaymentMethod) | **PUT** /object/payment-method/{id} | CRUD: Update PaymentMethod
*PaymentTransactionLogsApi* | [**proxyDELETEPaymentTransactionLog**](docs/PaymentTransactionLogsApi.md#proxyDELETEPaymentTransactionLog) | **DELETE** /object/payment-transaction-log/{id} | CRUD: Delete PaymentTransactionLog
*PaymentTransactionLogsApi* | [**proxyGETPaymentTransactionLog**](docs/PaymentTransactionLogsApi.md#proxyGETPaymentTransactionLog) | **GET** /object/payment-transaction-log/{id} | CRUD: Retrieve PaymentTransactionLog
*PaymentsApi* | [**proxyDELETEPayment**](docs/PaymentsApi.md#proxyDELETEPayment) | **DELETE** /object/payment/{id} | CRUD: Delete Payment
*PaymentsApi* | [**proxyGETPayment**](docs/PaymentsApi.md#proxyGETPayment) | **GET** /object/payment/{id} | CRUD: Retrieve Payment
*PaymentsApi* | [**proxyPOSTPayment**](docs/PaymentsApi.md#proxyPOSTPayment) | **POST** /object/payment | CRUD: Create Payment
*PaymentsApi* | [**proxyPUTPayment**](docs/PaymentsApi.md#proxyPUTPayment) | **PUT** /object/payment/{id} | CRUD: Update Payment
*ProductFeaturesApi* | [**proxyDELETEProductFeature**](docs/ProductFeaturesApi.md#proxyDELETEProductFeature) | **DELETE** /object/product-feature/{id} | CRUD: Delete ProductFeature
*ProductFeaturesApi* | [**proxyGETProductFeature**](docs/ProductFeaturesApi.md#proxyGETProductFeature) | **GET** /object/product-feature/{id} | CRUD: Retrieve ProductFeature
*ProductRatePlanChargeTiersApi* | [**proxyDELETEProductRatePlanChargeTier**](docs/ProductRatePlanChargeTiersApi.md#proxyDELETEProductRatePlanChargeTier) | **DELETE** /object/product-rate-plan-charge-tier/{id} | CRUD: Delete ProductRatePlanChargeTier
*ProductRatePlanChargeTiersApi* | [**proxyGETProductRatePlanChargeTier**](docs/ProductRatePlanChargeTiersApi.md#proxyGETProductRatePlanChargeTier) | **GET** /object/product-rate-plan-charge-tier/{id} | CRUD: Retrieve ProductRatePlanChargeTier
*ProductRatePlanChargesApi* | [**proxyDELETEProductRatePlanCharge**](docs/ProductRatePlanChargesApi.md#proxyDELETEProductRatePlanCharge) | **DELETE** /object/product-rate-plan-charge/{id} | CRUD: Delete ProductRatePlanCharge
*ProductRatePlanChargesApi* | [**proxyGETProductRatePlanCharge**](docs/ProductRatePlanChargesApi.md#proxyGETProductRatePlanCharge) | **GET** /object/product-rate-plan-charge/{id} | CRUD: Retrieve ProductRatePlanCharge
*ProductRatePlansApi* | [**proxyDELETEProductRatePlan**](docs/ProductRatePlansApi.md#proxyDELETEProductRatePlan) | **DELETE** /object/product-rate-plan/{id} | CRUD: Delete ProductRatePlan
*ProductRatePlansApi* | [**proxyGETProductRatePlan**](docs/ProductRatePlansApi.md#proxyGETProductRatePlan) | **GET** /object/product-rate-plan/{id} | CRUD: Retrieve ProductRatePlan
*ProductRatePlansApi* | [**proxyPOSTProductRatePlan**](docs/ProductRatePlansApi.md#proxyPOSTProductRatePlan) | **POST** /object/product-rate-plan | CRUD: Create ProductRatePlan
*ProductRatePlansApi* | [**proxyPUTProductRatePlan**](docs/ProductRatePlansApi.md#proxyPUTProductRatePlan) | **PUT** /object/product-rate-plan/{id} | CRUD: Update ProductRatePlan
*ProductsApi* | [**proxyDELETEProduct**](docs/ProductsApi.md#proxyDELETEProduct) | **DELETE** /object/product/{id} | CRUD: Delete Product
*ProductsApi* | [**proxyGETProduct**](docs/ProductsApi.md#proxyGETProduct) | **GET** /object/product/{id} | CRUD: Retrieve Product
*ProductsApi* | [**proxyPOSTProduct**](docs/ProductsApi.md#proxyPOSTProduct) | **POST** /object/product | CRUD: Create Product
*ProductsApi* | [**proxyPUTProduct**](docs/ProductsApi.md#proxyPUTProduct) | **PUT** /object/product/{id} | CRUD: Update Product
*QuotesDocumentApi* | [**pOSTQuoteDoc**](docs/QuotesDocumentApi.md#pOSTQuoteDoc) | **POST** /quotes/document | Generate quotes document
*RSASignaturesApi* | [**pOSTDecryptResponse**](docs/RSASignaturesApi.md#pOSTDecryptResponse) | **POST** /rsa-signatures/decrypt | Decrypt RSA signature
*RSASignaturesApi* | [**pOSTRSASignature**](docs/RSASignaturesApi.md#pOSTRSASignature) | **POST** /rsa-signatures | Generate RSA signature
*RatePlanChargeTiersApi* | [**proxyDELETERatePlanChargeTier**](docs/RatePlanChargeTiersApi.md#proxyDELETERatePlanChargeTier) | **DELETE** /object/rate-plan-charge-tier/{id} | CRUD: Delete RatePlanChargeTier
*RatePlanChargeTiersApi* | [**proxyGETRatePlanChargeTier**](docs/RatePlanChargeTiersApi.md#proxyGETRatePlanChargeTier) | **GET** /object/rate-plan-charge-tier/{id} | CRUD: Retrieve RatePlanChargeTier
*RatePlanChargesApi* | [**proxyDELETERatePlanCharge**](docs/RatePlanChargesApi.md#proxyDELETERatePlanCharge) | **DELETE** /object/rate-plan-charge/{id} | CRUD: Delete RatePlanCharge
*RatePlanChargesApi* | [**proxyGETRatePlanCharge**](docs/RatePlanChargesApi.md#proxyGETRatePlanCharge) | **GET** /object/rate-plan-charge/{id} | CRUD: Retrieve RatePlanCharge
*RatePlansApi* | [**proxyDELETERatePlan**](docs/RatePlansApi.md#proxyDELETERatePlan) | **DELETE** /object/rate-plan/{id} | CRUD: Delete RatePlan
*RatePlansApi* | [**proxyGETRatePlan**](docs/RatePlansApi.md#proxyGETRatePlan) | **GET** /object/rate-plan/{id} | CRUD: Retrieve RatePlan
*RefundInvoicePaymentsApi* | [**proxyDELETERefundInvoicePayment**](docs/RefundInvoicePaymentsApi.md#proxyDELETERefundInvoicePayment) | **DELETE** /object/refund-invoice-payment/{id} | CRUD: Delete RefundInvoicePayment
*RefundInvoicePaymentsApi* | [**proxyGETRefundInvoicePayment**](docs/RefundInvoicePaymentsApi.md#proxyGETRefundInvoicePayment) | **GET** /object/refund-invoice-payment/{id} | CRUD: Retrieve RefundInvoicePayment
*RefundTransactionLogsApi* | [**proxyDELETERefundTransactionLog**](docs/RefundTransactionLogsApi.md#proxyDELETERefundTransactionLog) | **DELETE** /object/refund-transaction-log/{id} | CRUD: Delete RefundTransactionLog
*RefundTransactionLogsApi* | [**proxyGETRefundTransactionLog**](docs/RefundTransactionLogsApi.md#proxyGETRefundTransactionLog) | **GET** /object/refund-transaction-log/{id} | CRUD: Retrieve RefundTransactionLog
*RefundsApi* | [**proxyDELETERefund**](docs/RefundsApi.md#proxyDELETERefund) | **DELETE** /object/refund/{id} | CRUD: Delete Refund
*RefundsApi* | [**proxyGETRefund**](docs/RefundsApi.md#proxyGETRefund) | **GET** /object/refund/{id} | CRUD: Retrieve Refund
*RefundsApi* | [**proxyPOSTRefund**](docs/RefundsApi.md#proxyPOSTRefund) | **POST** /object/refund | CRUD: Create Refund
*RefundsApi* | [**proxyPUTRefund**](docs/RefundsApi.md#proxyPUTRefund) | **PUT** /object/refund/{id} | CRUD: Update Refund
*RevenueEventsApi* | [**gETRevenueEventDetails**](docs/RevenueEventsApi.md#gETRevenueEventDetails) | **GET** /revenue-events/revenue-schedules/{rs-number} | Get revenue events for a revenue schedule
*RevenueEventsApi* | [**gETRevenueEventDetails_0**](docs/RevenueEventsApi.md#gETRevenueEventDetails_0) | **GET** /revenue-events/{event-number} | Get revenue event details
*RevenueItemsApi* | [**gETRevenueItemsByChargeRevenueEventNumber**](docs/RevenueItemsApi.md#gETRevenueItemsByChargeRevenueEventNumber) | **GET** /revenue-items/revenue-events/{event-number} | Get revenue items by revenue event number
*RevenueItemsApi* | [**gETRevenueItemsByChargeRevenueSummaryNumber**](docs/RevenueItemsApi.md#gETRevenueItemsByChargeRevenueSummaryNumber) | **GET** /revenue-items/charge-revenue-summaries/{crs-number} | Get revenue items by charge revenue summary number
*RevenueItemsApi* | [**gETRevenueItemsByRevenueSchedule**](docs/RevenueItemsApi.md#gETRevenueItemsByRevenueSchedule) | **GET** /revenue-items/revenue-schedules/{rs-number} | Get revenue items by revenue schedule
*RevenueItemsApi* | [**pUTCustomFieldsonRevenueItemsByRevenueEvent**](docs/RevenueItemsApi.md#pUTCustomFieldsonRevenueItemsByRevenueEvent) | **PUT** /revenue-items/revenue-events/{event-number} | Update custom fields on revenue items by revenue event number
*RevenueItemsApi* | [**pUTCustomFieldsonRevenueItemsByRevenueSchedule**](docs/RevenueItemsApi.md#pUTCustomFieldsonRevenueItemsByRevenueSchedule) | **PUT** /revenue-items/revenue-schedules/{rs-number} | Update custom fields on revenue items by revenue schedule number
*RevenueRulesApi* | [**gETRevenueRecognitionRuleAssociation**](docs/RevenueRulesApi.md#gETRevenueRecognitionRuleAssociation) | **GET** /revenue-recognition-rules/subscription-charges/{charge-key} | Get the rule associated with a charge
*RevenueSchedulesApi* | [**dELETERS**](docs/RevenueSchedulesApi.md#dELETERS) | **DELETE** /revenue-schedules/{rs-number} | Delete revenue schedule
*RevenueSchedulesApi* | [**gETRSDetail**](docs/RevenueSchedulesApi.md#gETRSDetail) | **GET** /revenue-schedules/{rs-number} | Get revenue schedule details
*RevenueSchedulesApi* | [**gETRSDetailsByCharge**](docs/RevenueSchedulesApi.md#gETRSDetailsByCharge) | **GET** /revenue-schedules/subscription-charges/{charge-key} | Get revenue schedule by subscription charge
*RevenueSchedulesApi* | [**gETRSbyInvoiceItem**](docs/RevenueSchedulesApi.md#gETRSbyInvoiceItem) | **GET** /revenue-schedules/invoice-items/{invoice-item-id} | Get a revenue schedule by invoice item ID
*RevenueSchedulesApi* | [**gETRSbyInvoiceItemAdjustment**](docs/RevenueSchedulesApi.md#gETRSbyInvoiceItemAdjustment) | **GET** /revenue-schedules/invoice-item-adjustments/{invoice-item-adj-id}/ | Get a revenue schedule by invoice item adjustment
*RevenueSchedulesApi* | [**pOSTRSforInvoiceItemAdjustmentDistributeByDateRange**](docs/RevenueSchedulesApi.md#pOSTRSforInvoiceItemAdjustmentDistributeByDateRange) | **POST** /revenue-schedules/invoice-item-adjustments/{invoice-item-adj-key}/distribute-revenue-with-date-range | Create a revenue schedule for an Invoice Item Adjustment (distribute by date range)
*RevenueSchedulesApi* | [**pOSTRSforInvoiceItemAdjustmentManualDistribution**](docs/RevenueSchedulesApi.md#pOSTRSforInvoiceItemAdjustmentManualDistribution) | **POST** /revenue-schedules/invoice-item-adjustments/{invoice-item-adj-key} | Create a revenue schedule for an Invoice Item Adjustment (manual distribution)
*RevenueSchedulesApi* | [**pOSTRSforInvoiceItemDistributeByDateRange**](docs/RevenueSchedulesApi.md#pOSTRSforInvoiceItemDistributeByDateRange) | **POST** /revenue-schedules/invoice-items/{invoice-item-id}/distribute-revenue-with-date-range | Create a revenue schedule for an Invoice Item (distribute by date range)
*RevenueSchedulesApi* | [**pOSTRSforInvoiceItemManualDistribution**](docs/RevenueSchedulesApi.md#pOSTRSforInvoiceItemManualDistribution) | **POST** /revenue-schedules/invoice-items/{invoice-item-id} | Create a revenue schedule for an Invoice Item (manual distribution)
*RevenueSchedulesApi* | [**pOSTRevenueScheduleByChargeResponse**](docs/RevenueSchedulesApi.md#pOSTRevenueScheduleByChargeResponse) | **POST** /revenue-schedules/subscription-charges/{charge-key} | Create a revenue schedule on a subscription charge
*RevenueSchedulesApi* | [**pUTRSBasicInfo**](docs/RevenueSchedulesApi.md#pUTRSBasicInfo) | **PUT** /revenue-schedules/{rs-number}/basic-information | Update revenue schedule basic information
*RevenueSchedulesApi* | [**pUTRevenueAcrossAP**](docs/RevenueSchedulesApi.md#pUTRevenueAcrossAP) | **PUT** /revenue-schedules/{rs-number}/distribute-revenue-across-accounting-periods | Distribute revenue across accounting periods
*RevenueSchedulesApi* | [**pUTRevenueByRecognitionStartandEndDates**](docs/RevenueSchedulesApi.md#pUTRevenueByRecognitionStartandEndDates) | **PUT** /revenue-schedules/{rs-number}/distribute-revenue-with-date-range | Distribute revenue by recognition start and end dates
*RevenueSchedulesApi* | [**pUTRevenueSpecificDate**](docs/RevenueSchedulesApi.md#pUTRevenueSpecificDate) | **PUT** /revenue-schedules/{rs-number}/distribute-revenue-on-specific-date | Distribute revenue on a specific date
*SettingsApi* | [**gETRevenueStartDateSetting**](docs/SettingsApi.md#gETRevenueStartDateSetting) | **GET** /settings/finance/revenue-automation-start-date | Get the revenue automation start date
*SubscriptionProductFeaturesApi* | [**proxyDELETESubscriptionProductFeature**](docs/SubscriptionProductFeaturesApi.md#proxyDELETESubscriptionProductFeature) | **DELETE** /object/subscription-product-feature/{id} | CRUD: Delete SubscriptionProductFeature
*SubscriptionProductFeaturesApi* | [**proxyGETSubscriptionProductFeature**](docs/SubscriptionProductFeaturesApi.md#proxyGETSubscriptionProductFeature) | **GET** /object/subscription-product-feature/{id} | CRUD: Retrieve SubscriptionProductFeature
*SubscriptionsApi* | [**gETOneSubscription**](docs/SubscriptionsApi.md#gETOneSubscription) | **GET** /subscriptions/{subscription-key} | Get subscriptions by key
*SubscriptionsApi* | [**gETSubscription**](docs/SubscriptionsApi.md#gETSubscription) | **GET** /subscriptions/accounts/{account-key} | Get subscriptions by account
*SubscriptionsApi* | [**pOSTSubscription**](docs/SubscriptionsApi.md#pOSTSubscription) | **POST** /subscriptions | Create subscription
*SubscriptionsApi* | [**pOSTSubscriptionCancellation**](docs/SubscriptionsApi.md#pOSTSubscriptionCancellation) | **PUT** /subscriptions/{subscription-key}/cancel | Cancel subscription
*SubscriptionsApi* | [**pOSTSubscriptionPreview**](docs/SubscriptionsApi.md#pOSTSubscriptionPreview) | **POST** /subscriptions/preview | Preview subscription
*SubscriptionsApi* | [**pUTRenewSubscription**](docs/SubscriptionsApi.md#pUTRenewSubscription) | **PUT** /subscriptions/{subscription-key}/renew | Renew subscription
*SubscriptionsApi* | [**pUTSubscription**](docs/SubscriptionsApi.md#pUTSubscription) | **PUT** /subscriptions/{subscription-key} | Update subscription
*SubscriptionsApi* | [**pUTSubscriptionResume**](docs/SubscriptionsApi.md#pUTSubscriptionResume) | **PUT** /subscriptions/{subscription-key}/resume | Resume subscription
*SubscriptionsApi* | [**pUTSubscriptionSuspend**](docs/SubscriptionsApi.md#pUTSubscriptionSuspend) | **PUT** /subscriptions/{subscription-key}/suspend | Suspend subscription
*SubscriptionsApi* | [**proxyDELETESubscription**](docs/SubscriptionsApi.md#proxyDELETESubscription) | **DELETE** /object/subscription/{id} | CRUD: Delete Subscription
*SubscriptionsApi* | [**proxyGETSubscription**](docs/SubscriptionsApi.md#proxyGETSubscription) | **GET** /object/subscription/{id} | CRUD: Retrieve Subscription
*SubscriptionsApi* | [**proxyPOSTSubscription**](docs/SubscriptionsApi.md#proxyPOSTSubscription) | **POST** /object/subscription | CRUD: Create Subscription
*SubscriptionsApi* | [**proxyPUTSubscription**](docs/SubscriptionsApi.md#proxyPUTSubscription) | **PUT** /object/subscription/{id} | CRUD: Update Subscription
*SummaryJournalEntriesApi* | [**dELETESummaryJournalEntry**](docs/SummaryJournalEntriesApi.md#dELETESummaryJournalEntry) | **DELETE** /journal-entries/{je-number} | Delete summary journal entry
*SummaryJournalEntriesApi* | [**gETJournalEntriesInJournalRun**](docs/SummaryJournalEntriesApi.md#gETJournalEntriesInJournalRun) | **GET** /journal-entries/journal-runs/{jr-number} | Get all summary journal entries in a journal run
*SummaryJournalEntriesApi* | [**gETJournalEntryDetail**](docs/SummaryJournalEntriesApi.md#gETJournalEntryDetail) | **GET** /journal-entries/{je-number} | Get summary journal entry
*SummaryJournalEntriesApi* | [**pOSTJournalEntry**](docs/SummaryJournalEntriesApi.md#pOSTJournalEntry) | **POST** /journal-entries | Create summary journal entry
*SummaryJournalEntriesApi* | [**pUTBasicSummaryJournalEntry**](docs/SummaryJournalEntriesApi.md#pUTBasicSummaryJournalEntry) | **PUT** /journal-entries/{je-number}/basic-information | Update basic information of a summary journal entry
*SummaryJournalEntriesApi* | [**pUTSummaryJournalEntry**](docs/SummaryJournalEntriesApi.md#pUTSummaryJournalEntry) | **PUT** /journal-entries/{je-number}/cancel | Cancel summary journal entry
*TaxationItemsApi* | [**proxyDELETETaxationItem**](docs/TaxationItemsApi.md#proxyDELETETaxationItem) | **DELETE** /object/taxation-item/{id} | CRUD: Delete TaxationItem
*TaxationItemsApi* | [**proxyGETTaxationItem**](docs/TaxationItemsApi.md#proxyGETTaxationItem) | **GET** /object/taxation-item/{id} | CRUD: Retrieve TaxationItem
*TaxationItemsApi* | [**proxyPOSTTaxationItem**](docs/TaxationItemsApi.md#proxyPOSTTaxationItem) | **POST** /object/taxation-item | CRUD: Create TaxationItem
*TaxationItemsApi* | [**proxyPUTTaxationItem**](docs/TaxationItemsApi.md#proxyPUTTaxationItem) | **PUT** /object/taxation-item/{id} | CRUD: Update TaxationItem
*TransactionsApi* | [**gETInvoice**](docs/TransactionsApi.md#gETInvoice) | **GET** /transactions/invoices/accounts/{account-key} | Get invoices
*TransactionsApi* | [**gETPayments**](docs/TransactionsApi.md#gETPayments) | **GET** /transactions/payments/accounts/{account-key} | Get payments
*UnitOfMeasureApi* | [**proxyDELETEUnitOfMeasure**](docs/UnitOfMeasureApi.md#proxyDELETEUnitOfMeasure) | **DELETE** /object/unit-of-measure/{id} | CRUD: Delete UnitOfMeasure
*UnitOfMeasureApi* | [**proxyGETUnitOfMeasure**](docs/UnitOfMeasureApi.md#proxyGETUnitOfMeasure) | **GET** /object/unit-of-measure/{id} | CRUD: Retrieve UnitOfMeasure
*UnitOfMeasureApi* | [**proxyPOSTUnitOfMeasure**](docs/UnitOfMeasureApi.md#proxyPOSTUnitOfMeasure) | **POST** /object/unit-of-measure | CRUD: Create UnitOfMeasure
*UnitOfMeasureApi* | [**proxyPUTUnitOfMeasure**](docs/UnitOfMeasureApi.md#proxyPUTUnitOfMeasure) | **PUT** /object/unit-of-measure/{id} | CRUD: Update UnitOfMeasure
*UsageApi* | [**gETUsage**](docs/UsageApi.md#gETUsage) | **GET** /usage/accounts/{account-key} | Get usage
*UsageApi* | [**pOSTUsage**](docs/UsageApi.md#pOSTUsage) | **POST** /usage | Post usage
*UsageApi* | [**proxyDELETEUsage**](docs/UsageApi.md#proxyDELETEUsage) | **DELETE** /object/usage/{id} | CRUD: Delete Usage
*UsageApi* | [**proxyGETUsage**](docs/UsageApi.md#proxyGETUsage) | **GET** /object/usage/{id} | CRUD: Retrieve Usage
*UsageApi* | [**proxyPOSTUsage**](docs/UsageApi.md#proxyPOSTUsage) | **POST** /object/usage | CRUD: Create Usage
*UsageApi* | [**proxyPUTUsage**](docs/UsageApi.md#proxyPUTUsage) | **PUT** /object/usage/{id} | CRUD: Update Usage
*UsersApi* | [**proxyDELETEUser**](docs/UsersApi.md#proxyDELETEUser) | **DELETE** /object/user/{id} | CRUD: Delete User
*UsersApi* | [**proxyGETUser**](docs/UsersApi.md#proxyGETUser) | **GET** /object/user/{id} | CRUD: Retrieve User
*UsersApi* | [**proxyPUTUser**](docs/UsersApi.md#proxyPUTUser) | **PUT** /object/user/{id} | CRUD: Update User


## Documentation for Models

 - [Account](docs/Account.md)
 - [AmendOptions](docs/AmendOptions.md)
 - [AmendRequest](docs/AmendRequest.md)
 - [AmendResult](docs/AmendResult.md)
 - [Amendment](docs/Amendment.md)
 - [ChargeMetricsData](docs/ChargeMetricsData.md)
 - [CommonResponseType](docs/CommonResponseType.md)
 - [Contact](docs/Contact.md)
 - [DeleteResult](docs/DeleteResult.md)
 - [ElectronicPaymentOptions](docs/ElectronicPaymentOptions.md)
 - [Error](docs/Error.md)
 - [EventRevenueItemType](docs/EventRevenueItemType.md)
 - [ExecuteResult](docs/ExecuteResult.md)
 - [ExternalPaymentOptions](docs/ExternalPaymentOptions.md)
 - [GETAccountSummaryInvoiceType](docs/GETAccountSummaryInvoiceType.md)
 - [GETAccountSummaryPaymentInvoiceType](docs/GETAccountSummaryPaymentInvoiceType.md)
 - [GETAccountSummaryPaymentType](docs/GETAccountSummaryPaymentType.md)
 - [GETAccountSummarySubscriptionRatePlanType](docs/GETAccountSummarySubscriptionRatePlanType.md)
 - [GETAccountSummarySubscriptionType](docs/GETAccountSummarySubscriptionType.md)
 - [GETAccountSummaryType](docs/GETAccountSummaryType.md)
 - [GETAccountSummaryTypeBasicInfo](docs/GETAccountSummaryTypeBasicInfo.md)
 - [GETAccountSummaryTypeBasicInfoDefaultPaymentMethod](docs/GETAccountSummaryTypeBasicInfoDefaultPaymentMethod.md)
 - [GETAccountSummaryTypeBillToContact](docs/GETAccountSummaryTypeBillToContact.md)
 - [GETAccountSummaryTypeSoldToContact](docs/GETAccountSummaryTypeSoldToContact.md)
 - [GETAccountSummaryTypeTaxInfo](docs/GETAccountSummaryTypeTaxInfo.md)
 - [GETAccountSummaryUsageType](docs/GETAccountSummaryUsageType.md)
 - [GETAccountType](docs/GETAccountType.md)
 - [GETAccountTypeBasicInfo](docs/GETAccountTypeBasicInfo.md)
 - [GETAccountTypeBillToContact](docs/GETAccountTypeBillToContact.md)
 - [GETAccountTypeBillingAndPayment](docs/GETAccountTypeBillingAndPayment.md)
 - [GETAccountTypeMetrics](docs/GETAccountTypeMetrics.md)
 - [GETAccountTypeSoldToContact](docs/GETAccountTypeSoldToContact.md)
 - [GETAccountingCodeItemType](docs/GETAccountingCodeItemType.md)
 - [GETAccountingCodeItemWithoutSuccessType](docs/GETAccountingCodeItemWithoutSuccessType.md)
 - [GETAccountingCodesType](docs/GETAccountingCodesType.md)
 - [GETAccountingPeriodFileIdsType](docs/GETAccountingPeriodFileIdsType.md)
 - [GETAccountingPeriodType](docs/GETAccountingPeriodType.md)
 - [GETAccountingPeriodWithoutSuccessType](docs/GETAccountingPeriodWithoutSuccessType.md)
 - [GETAccountingPeriodsType](docs/GETAccountingPeriodsType.md)
 - [GETAmendmentType](docs/GETAmendmentType.md)
 - [GETAttachmentResponseType](docs/GETAttachmentResponseType.md)
 - [GETAttachmentResponseWithoutSuccessType](docs/GETAttachmentResponseWithoutSuccessType.md)
 - [GETAttachmentsResponseType](docs/GETAttachmentsResponseType.md)
 - [GETCalloutHistoryVOType](docs/GETCalloutHistoryVOType.md)
 - [GETCalloutHistoryVOsType](docs/GETCalloutHistoryVOsType.md)
 - [GETCatalogType](docs/GETCatalogType.md)
 - [GETChargeRSDetailType](docs/GETChargeRSDetailType.md)
 - [GETCustomExchangeRatesDataType](docs/GETCustomExchangeRatesDataType.md)
 - [GETCustomExchangeRatesDataTypeDATE](docs/GETCustomExchangeRatesDataTypeDATE.md)
 - [GETCustomExchangeRatesType](docs/GETCustomExchangeRatesType.md)
 - [GETEmailHistoryVOType](docs/GETEmailHistoryVOType.md)
 - [GETEmailHistoryVOsType](docs/GETEmailHistoryVOsType.md)
 - [GETInvoiceFileType](docs/GETInvoiceFileType.md)
 - [GETInvoiceFileWrapper](docs/GETInvoiceFileWrapper.md)
 - [GETInvoiceType](docs/GETInvoiceType.md)
 - [GETInvoicesInvoiceItemType](docs/GETInvoicesInvoiceItemType.md)
 - [GETJournalEntriesInJournalRunType](docs/GETJournalEntriesInJournalRunType.md)
 - [GETJournalEntryDetailType](docs/GETJournalEntryDetailType.md)
 - [GETJournalEntryDetailTypeWithoutSuccess](docs/GETJournalEntryDetailTypeWithoutSuccess.md)
 - [GETJournalEntryItemType](docs/GETJournalEntryItemType.md)
 - [GETJournalEntrySegmentType](docs/GETJournalEntrySegmentType.md)
 - [GETJournalRunTransactionType](docs/GETJournalRunTransactionType.md)
 - [GETJournalRunType](docs/GETJournalRunType.md)
 - [GETMassUpdateType](docs/GETMassUpdateType.md)
 - [GETPaidInvoicesType](docs/GETPaidInvoicesType.md)
 - [GETPaymentMethodType](docs/GETPaymentMethodType.md)
 - [GETPaymentMethodTypeCardHolderInfo](docs/GETPaymentMethodTypeCardHolderInfo.md)
 - [GETPaymentMethodsType](docs/GETPaymentMethodsType.md)
 - [GETPaymentType](docs/GETPaymentType.md)
 - [GETPaymentsType](docs/GETPaymentsType.md)
 - [GETProductRatePlanChargePricingTierType](docs/GETProductRatePlanChargePricingTierType.md)
 - [GETProductRatePlanChargePricingType](docs/GETProductRatePlanChargePricingType.md)
 - [GETProductRatePlanChargeType](docs/GETProductRatePlanChargeType.md)
 - [GETProductRatePlanChargeTypeFinanceInformation](docs/GETProductRatePlanChargeTypeFinanceInformation.md)
 - [GETProductRatePlanType](docs/GETProductRatePlanType.md)
 - [GETProductType](docs/GETProductType.md)
 - [GETRSDetailType](docs/GETRSDetailType.md)
 - [GETRSDetailWithoutSuccessType](docs/GETRSDetailWithoutSuccessType.md)
 - [GETRSDetailsByChargeType](docs/GETRSDetailsByChargeType.md)
 - [GETRevenueEventDetailType](docs/GETRevenueEventDetailType.md)
 - [GETRevenueEventDetailWithoutSuccessType](docs/GETRevenueEventDetailWithoutSuccessType.md)
 - [GETRevenueEventDetailsType](docs/GETRevenueEventDetailsType.md)
 - [GETRevenueItemType](docs/GETRevenueItemType.md)
 - [GETRevenueItemsType](docs/GETRevenueItemsType.md)
 - [GETRevenueRecognitionRuleAssociationType](docs/GETRevenueRecognitionRuleAssociationType.md)
 - [GETRevenueStartDateSettingType](docs/GETRevenueStartDateSettingType.md)
 - [GETRsRevenueItemType](docs/GETRsRevenueItemType.md)
 - [GETRsRevenueItemsType](docs/GETRsRevenueItemsType.md)
 - [GETSubscriptionProductFeatureType](docs/GETSubscriptionProductFeatureType.md)
 - [GETSubscriptionRatePlanChargesType](docs/GETSubscriptionRatePlanChargesType.md)
 - [GETSubscriptionRatePlanType](docs/GETSubscriptionRatePlanType.md)
 - [GETSubscriptionType](docs/GETSubscriptionType.md)
 - [GETSubscriptionTypeWithSuccess](docs/GETSubscriptionTypeWithSuccess.md)
 - [GETSubscriptionWrapper](docs/GETSubscriptionWrapper.md)
 - [GETTierType](docs/GETTierType.md)
 - [GETUsageType](docs/GETUsageType.md)
 - [GETUsageWrapper](docs/GETUsageWrapper.md)
 - [GatewayOption](docs/GatewayOption.md)
 - [GatewayOptionData](docs/GatewayOptionData.md)
 - [GetHostedPageType](docs/GetHostedPageType.md)
 - [GetHostedPagesType](docs/GetHostedPagesType.md)
 - [GetProductFeatureType](docs/GetProductFeatureType.md)
 - [Invoice](docs/Invoice.md)
 - [InvoiceData](docs/InvoiceData.md)
 - [InvoiceItem](docs/InvoiceItem.md)
 - [InvoiceProcessingOptions](docs/InvoiceProcessingOptions.md)
 - [InvoiceResult](docs/InvoiceResult.md)
 - [LoginResult](docs/LoginResult.md)
 - [NewChargeMetrics](docs/NewChargeMetrics.md)
 - [POSTAccountResponseType](docs/POSTAccountResponseType.md)
 - [POSTAccountType](docs/POSTAccountType.md)
 - [POSTAccountTypeBillToContact](docs/POSTAccountTypeBillToContact.md)
 - [POSTAccountTypeCreditCard](docs/POSTAccountTypeCreditCard.md)
 - [POSTAccountTypeCreditCardCardHolderInfo](docs/POSTAccountTypeCreditCardCardHolderInfo.md)
 - [POSTAccountTypeSoldToContact](docs/POSTAccountTypeSoldToContact.md)
 - [POSTAccountTypeSubscription](docs/POSTAccountTypeSubscription.md)
 - [POSTAccountTypeTaxInfo](docs/POSTAccountTypeTaxInfo.md)
 - [POSTAccountingCodeResponseType](docs/POSTAccountingCodeResponseType.md)
 - [POSTAccountingCodeType](docs/POSTAccountingCodeType.md)
 - [POSTAccountingPeriodResponseType](docs/POSTAccountingPeriodResponseType.md)
 - [POSTAccountingPeriodType](docs/POSTAccountingPeriodType.md)
 - [POSTAttachmentResponseType](docs/POSTAttachmentResponseType.md)
 - [POSTAttachmentType](docs/POSTAttachmentType.md)
 - [POSTDecryptResponseType](docs/POSTDecryptResponseType.md)
 - [POSTDecryptionType](docs/POSTDecryptionType.md)
 - [POSTDistributionItemType](docs/POSTDistributionItemType.md)
 - [POSTHMACSignatureResponseType](docs/POSTHMACSignatureResponseType.md)
 - [POSTHMACSignatureType](docs/POSTHMACSignatureType.md)
 - [POSTInvoiceCollectInvoicesType](docs/POSTInvoiceCollectInvoicesType.md)
 - [POSTInvoiceCollectResponseType](docs/POSTInvoiceCollectResponseType.md)
 - [POSTInvoiceCollectType](docs/POSTInvoiceCollectType.md)
 - [POSTJournalEntryItemType](docs/POSTJournalEntryItemType.md)
 - [POSTJournalEntryResponseType](docs/POSTJournalEntryResponseType.md)
 - [POSTJournalEntrySegmentType](docs/POSTJournalEntrySegmentType.md)
 - [POSTJournalEntryType](docs/POSTJournalEntryType.md)
 - [POSTJournalRunResponseType](docs/POSTJournalRunResponseType.md)
 - [POSTJournalRunTransactionType](docs/POSTJournalRunTransactionType.md)
 - [POSTJournalRunType](docs/POSTJournalRunType.md)
 - [POSTMassUpdateResponseType](docs/POSTMassUpdateResponseType.md)
 - [POSTMassUpdateType](docs/POSTMassUpdateType.md)
 - [POSTMassUpdateTypeParams](docs/POSTMassUpdateTypeParams.md)
 - [POSTPaymentMethodResponseType](docs/POSTPaymentMethodResponseType.md)
 - [POSTPaymentMethodType](docs/POSTPaymentMethodType.md)
 - [POSTPaymentMethodTypeCardHolderInfo](docs/POSTPaymentMethodTypeCardHolderInfo.md)
 - [POSTQuoteDocResponseType](docs/POSTQuoteDocResponseType.md)
 - [POSTQuoteDocType](docs/POSTQuoteDocType.md)
 - [POSTRSASignatureResponseType](docs/POSTRSASignatureResponseType.md)
 - [POSTRSASignatureType](docs/POSTRSASignatureType.md)
 - [POSTRevenueScheduleByChargeResponseType](docs/POSTRevenueScheduleByChargeResponseType.md)
 - [POSTRevenueScheduleByChargeType](docs/POSTRevenueScheduleByChargeType.md)
 - [POSTRevenueScheduleByChargeTypeRevenueEvent](docs/POSTRevenueScheduleByChargeTypeRevenueEvent.md)
 - [POSTRevenueScheduleByDateRangeType](docs/POSTRevenueScheduleByDateRangeType.md)
 - [POSTRevenueScheduleByDateRangeTypeRevenueEvent](docs/POSTRevenueScheduleByDateRangeTypeRevenueEvent.md)
 - [POSTRevenueScheduleByTransactionResponseType](docs/POSTRevenueScheduleByTransactionResponseType.md)
 - [POSTRevenueScheduleByTransactionType](docs/POSTRevenueScheduleByTransactionType.md)
 - [POSTRevenueScheduleByTransactionTypeRevenueEvent](docs/POSTRevenueScheduleByTransactionTypeRevenueEvent.md)
 - [POSTScCreateType](docs/POSTScCreateType.md)
 - [POSTSrpCreateType](docs/POSTSrpCreateType.md)
 - [POSTSubscriptionCancellationResponseType](docs/POSTSubscriptionCancellationResponseType.md)
 - [POSTSubscriptionCancellationType](docs/POSTSubscriptionCancellationType.md)
 - [POSTSubscriptionPreviewInvoiceItemsType](docs/POSTSubscriptionPreviewInvoiceItemsType.md)
 - [POSTSubscriptionPreviewResponseType](docs/POSTSubscriptionPreviewResponseType.md)
 - [POSTSubscriptionPreviewResponseTypeChargeMetrics](docs/POSTSubscriptionPreviewResponseTypeChargeMetrics.md)
 - [POSTSubscriptionPreviewType](docs/POSTSubscriptionPreviewType.md)
 - [POSTSubscriptionPreviewTypePreviewAccountInfo](docs/POSTSubscriptionPreviewTypePreviewAccountInfo.md)
 - [POSTSubscriptionPreviewTypePreviewAccountInfoBillToContact](docs/POSTSubscriptionPreviewTypePreviewAccountInfoBillToContact.md)
 - [POSTSubscriptionResponseType](docs/POSTSubscriptionResponseType.md)
 - [POSTSubscriptionType](docs/POSTSubscriptionType.md)
 - [POSTTierType](docs/POSTTierType.md)
 - [POSTUsageResponseType](docs/POSTUsageResponseType.md)
 - [PUTAccountType](docs/PUTAccountType.md)
 - [PUTAccountTypeBillToContact](docs/PUTAccountTypeBillToContact.md)
 - [PUTAccountTypeSoldToContact](docs/PUTAccountTypeSoldToContact.md)
 - [PUTAccountingCodeType](docs/PUTAccountingCodeType.md)
 - [PUTAccountingPeriodType](docs/PUTAccountingPeriodType.md)
 - [PUTAllocateManuallyType](docs/PUTAllocateManuallyType.md)
 - [PUTAttachmentType](docs/PUTAttachmentType.md)
 - [PUTBasicSummaryJournalEntryType](docs/PUTBasicSummaryJournalEntryType.md)
 - [PUTEventRIDetailType](docs/PUTEventRIDetailType.md)
 - [PUTJournalEntryItemType](docs/PUTJournalEntryItemType.md)
 - [PUTPaymentMethodResponseType](docs/PUTPaymentMethodResponseType.md)
 - [PUTPaymentMethodType](docs/PUTPaymentMethodType.md)
 - [PUTRSBasicInfoType](docs/PUTRSBasicInfoType.md)
 - [PUTRSTermType](docs/PUTRSTermType.md)
 - [PUTRenewSubscriptionResponseType](docs/PUTRenewSubscriptionResponseType.md)
 - [PUTRenewSubscriptionType](docs/PUTRenewSubscriptionType.md)
 - [PUTRevenueScheduleResponseType](docs/PUTRevenueScheduleResponseType.md)
 - [PUTScAddType](docs/PUTScAddType.md)
 - [PUTScUpdateType](docs/PUTScUpdateType.md)
 - [PUTScheduleRIDetailType](docs/PUTScheduleRIDetailType.md)
 - [PUTSpecificDateAllocationType](docs/PUTSpecificDateAllocationType.md)
 - [PUTSrpAddType](docs/PUTSrpAddType.md)
 - [PUTSrpRemoveType](docs/PUTSrpRemoveType.md)
 - [PUTSrpUpdateType](docs/PUTSrpUpdateType.md)
 - [PUTSubscriptionPreviewInvoiceItemsType](docs/PUTSubscriptionPreviewInvoiceItemsType.md)
 - [PUTSubscriptionResponseType](docs/PUTSubscriptionResponseType.md)
 - [PUTSubscriptionResponseTypeChargeMetrics](docs/PUTSubscriptionResponseTypeChargeMetrics.md)
 - [PUTSubscriptionResumeResponseType](docs/PUTSubscriptionResumeResponseType.md)
 - [PUTSubscriptionResumeType](docs/PUTSubscriptionResumeType.md)
 - [PUTSubscriptionSuspendResponseType](docs/PUTSubscriptionSuspendResponseType.md)
 - [PUTSubscriptionSuspendType](docs/PUTSubscriptionSuspendType.md)
 - [PUTSubscriptionType](docs/PUTSubscriptionType.md)
 - [PaymentMethod](docs/PaymentMethod.md)
 - [PreviewOptions](docs/PreviewOptions.md)
 - [ProxyActionamendRequest](docs/ProxyActionamendRequest.md)
 - [ProxyActionamendResponse](docs/ProxyActionamendResponse.md)
 - [ProxyActioncreateRequest](docs/ProxyActioncreateRequest.md)
 - [ProxyActioncreateResponse](docs/ProxyActioncreateResponse.md)
 - [ProxyActiondeleteRequest](docs/ProxyActiondeleteRequest.md)
 - [ProxyActiondeleteResponse](docs/ProxyActiondeleteResponse.md)
 - [ProxyActionexecuteRequest](docs/ProxyActionexecuteRequest.md)
 - [ProxyActionexecuteResponse](docs/ProxyActionexecuteResponse.md)
 - [ProxyActiongenerateRequest](docs/ProxyActiongenerateRequest.md)
 - [ProxyActiongenerateResponse](docs/ProxyActiongenerateResponse.md)
 - [ProxyActiongetUserInfoResponse](docs/ProxyActiongetUserInfoResponse.md)
 - [ProxyActionloginRequest](docs/ProxyActionloginRequest.md)
 - [ProxyActionloginResponse](docs/ProxyActionloginResponse.md)
 - [ProxyActionqueryMoreRequest](docs/ProxyActionqueryMoreRequest.md)
 - [ProxyActionqueryMoreResponse](docs/ProxyActionqueryMoreResponse.md)
 - [ProxyActionqueryRequest](docs/ProxyActionqueryRequest.md)
 - [ProxyActionqueryResponse](docs/ProxyActionqueryResponse.md)
 - [ProxyActionsubscribeRequest](docs/ProxyActionsubscribeRequest.md)
 - [ProxyActionsubscribeResponse](docs/ProxyActionsubscribeResponse.md)
 - [ProxyActionupdateRequest](docs/ProxyActionupdateRequest.md)
 - [ProxyActionupdateResponse](docs/ProxyActionupdateResponse.md)
 - [ProxyBadRequestResponse](docs/ProxyBadRequestResponse.md)
 - [ProxyBadRequestResponseErrors](docs/ProxyBadRequestResponseErrors.md)
 - [ProxyCreateAccount](docs/ProxyCreateAccount.md)
 - [ProxyCreateAccountingCode](docs/ProxyCreateAccountingCode.md)
 - [ProxyCreateAmendment](docs/ProxyCreateAmendment.md)
 - [ProxyCreateContact](docs/ProxyCreateContact.md)
 - [ProxyCreateExport](docs/ProxyCreateExport.md)
 - [ProxyCreateImport](docs/ProxyCreateImport.md)
 - [ProxyCreateInvoice](docs/ProxyCreateInvoice.md)
 - [ProxyCreateInvoiceAdjustment](docs/ProxyCreateInvoiceAdjustment.md)
 - [ProxyCreateInvoicePayment](docs/ProxyCreateInvoicePayment.md)
 - [ProxyCreateOrModifyResponse](docs/ProxyCreateOrModifyResponse.md)
 - [ProxyCreatePayment](docs/ProxyCreatePayment.md)
 - [ProxyCreatePaymentMethod](docs/ProxyCreatePaymentMethod.md)
 - [ProxyCreateProduct](docs/ProxyCreateProduct.md)
 - [ProxyCreateProductRatePlan](docs/ProxyCreateProductRatePlan.md)
 - [ProxyCreateRefund](docs/ProxyCreateRefund.md)
 - [ProxyCreateSubscription](docs/ProxyCreateSubscription.md)
 - [ProxyCreateTaxationItem](docs/ProxyCreateTaxationItem.md)
 - [ProxyCreateUnitOfMeasure](docs/ProxyCreateUnitOfMeasure.md)
 - [ProxyCreateUsage](docs/ProxyCreateUsage.md)
 - [ProxyDeleteResponse](docs/ProxyDeleteResponse.md)
 - [ProxyGetAccount](docs/ProxyGetAccount.md)
 - [ProxyGetAccountingCode](docs/ProxyGetAccountingCode.md)
 - [ProxyGetAccountingPeriod](docs/ProxyGetAccountingPeriod.md)
 - [ProxyGetAmendment](docs/ProxyGetAmendment.md)
 - [ProxyGetCommunicationProfile](docs/ProxyGetCommunicationProfile.md)
 - [ProxyGetContact](docs/ProxyGetContact.md)
 - [ProxyGetCreditBalanceAdjustment](docs/ProxyGetCreditBalanceAdjustment.md)
 - [ProxyGetExport](docs/ProxyGetExport.md)
 - [ProxyGetFeature](docs/ProxyGetFeature.md)
 - [ProxyGetImport](docs/ProxyGetImport.md)
 - [ProxyGetInvoice](docs/ProxyGetInvoice.md)
 - [ProxyGetInvoiceAdjustment](docs/ProxyGetInvoiceAdjustment.md)
 - [ProxyGetInvoiceItem](docs/ProxyGetInvoiceItem.md)
 - [ProxyGetInvoiceItemAdjustment](docs/ProxyGetInvoiceItemAdjustment.md)
 - [ProxyGetInvoicePayment](docs/ProxyGetInvoicePayment.md)
 - [ProxyGetInvoiceSplit](docs/ProxyGetInvoiceSplit.md)
 - [ProxyGetInvoiceSplitItem](docs/ProxyGetInvoiceSplitItem.md)
 - [ProxyGetPayment](docs/ProxyGetPayment.md)
 - [ProxyGetPaymentMethod](docs/ProxyGetPaymentMethod.md)
 - [ProxyGetPaymentMethodSnapshot](docs/ProxyGetPaymentMethodSnapshot.md)
 - [ProxyGetPaymentMethodTransactionLog](docs/ProxyGetPaymentMethodTransactionLog.md)
 - [ProxyGetPaymentTransactionLog](docs/ProxyGetPaymentTransactionLog.md)
 - [ProxyGetProduct](docs/ProxyGetProduct.md)
 - [ProxyGetProductFeature](docs/ProxyGetProductFeature.md)
 - [ProxyGetProductRatePlan](docs/ProxyGetProductRatePlan.md)
 - [ProxyGetProductRatePlanCharge](docs/ProxyGetProductRatePlanCharge.md)
 - [ProxyGetProductRatePlanChargeTier](docs/ProxyGetProductRatePlanChargeTier.md)
 - [ProxyGetRatePlan](docs/ProxyGetRatePlan.md)
 - [ProxyGetRatePlanCharge](docs/ProxyGetRatePlanCharge.md)
 - [ProxyGetRatePlanChargeTier](docs/ProxyGetRatePlanChargeTier.md)
 - [ProxyGetRefund](docs/ProxyGetRefund.md)
 - [ProxyGetRefundInvoicePayment](docs/ProxyGetRefundInvoicePayment.md)
 - [ProxyGetRefundTransactionLog](docs/ProxyGetRefundTransactionLog.md)
 - [ProxyGetSubscription](docs/ProxyGetSubscription.md)
 - [ProxyGetSubscriptionProductFeature](docs/ProxyGetSubscriptionProductFeature.md)
 - [ProxyGetTaxationItem](docs/ProxyGetTaxationItem.md)
 - [ProxyGetUnitOfMeasure](docs/ProxyGetUnitOfMeasure.md)
 - [ProxyGetUsage](docs/ProxyGetUsage.md)
 - [ProxyGetUser](docs/ProxyGetUser.md)
 - [ProxyModifyAccount](docs/ProxyModifyAccount.md)
 - [ProxyModifyAccountingCode](docs/ProxyModifyAccountingCode.md)
 - [ProxyModifyAmendment](docs/ProxyModifyAmendment.md)
 - [ProxyModifyContact](docs/ProxyModifyContact.md)
 - [ProxyModifyInvoice](docs/ProxyModifyInvoice.md)
 - [ProxyModifyInvoiceAdjustment](docs/ProxyModifyInvoiceAdjustment.md)
 - [ProxyModifyInvoicePayment](docs/ProxyModifyInvoicePayment.md)
 - [ProxyModifyPayment](docs/ProxyModifyPayment.md)
 - [ProxyModifyPaymentMethod](docs/ProxyModifyPaymentMethod.md)
 - [ProxyModifyProduct](docs/ProxyModifyProduct.md)
 - [ProxyModifyProductRatePlan](docs/ProxyModifyProductRatePlan.md)
 - [ProxyModifyRefund](docs/ProxyModifyRefund.md)
 - [ProxyModifySubscription](docs/ProxyModifySubscription.md)
 - [ProxyModifyTaxationItem](docs/ProxyModifyTaxationItem.md)
 - [ProxyModifyUnitOfMeasure](docs/ProxyModifyUnitOfMeasure.md)
 - [ProxyModifyUsage](docs/ProxyModifyUsage.md)
 - [ProxyModifyUser](docs/ProxyModifyUser.md)
 - [ProxyNoDataResponse](docs/ProxyNoDataResponse.md)
 - [QueryResult](docs/QueryResult.md)
 - [RatePlan](docs/RatePlan.md)
 - [RatePlanCharge](docs/RatePlanCharge.md)
 - [RatePlanChargeData](docs/RatePlanChargeData.md)
 - [RatePlanChargeTier](docs/RatePlanChargeTier.md)
 - [RatePlanData](docs/RatePlanData.md)
 - [RevenueScheduleItemType](docs/RevenueScheduleItemType.md)
 - [SaveResult](docs/SaveResult.md)
 - [SubscribeInvoiceProcessingOptions](docs/SubscribeInvoiceProcessingOptions.md)
 - [SubscribeOptions](docs/SubscribeOptions.md)
 - [SubscribeRequest](docs/SubscribeRequest.md)
 - [SubscribeResult](docs/SubscribeResult.md)
 - [Subscription](docs/Subscription.md)
 - [SubscriptionData](docs/SubscriptionData.md)
 - [SubscriptionProductFeature](docs/SubscriptionProductFeature.md)
 - [SubscriptionProductFeatureList](docs/SubscriptionProductFeatureList.md)
 - [ZObject](docs/ZObject.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author

docs@zuora.com

## License

You are free to use this quickstart.  However, Zuora does not guarantee or make any representations 
regarding the use, results of use, accuracy, security, timeliness, or completeness of any data or 
information relating to the sample code. You, the customer, are responsible for making sure that 
your implementation is secure and functional.

