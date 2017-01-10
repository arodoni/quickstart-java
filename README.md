# Zuora REST API Quick Start for Java

## Overview

This sample code is to help you quickly integrate with Zuora through the use of the Zuora REST API and Java. For additional information on the Zuora API, visit the [Zuora Developer Center](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference).

The sample code is provided “AS IS”, for demonstration purposes only. Zuora does not guarantee or make any representations regarding the use, results of use, accuracy, security, timeliness, or completeness of any data or information relating to the sample code. You, the customer, are responsible for making sure that your implementation is functional and secure.

Go to [Zuora Community](http://community.zuora.com) to report issues or discuss these samples with your peers.

The sample code demonstrates how to invoke the REST resources to
implement the following use cases:

1. Retrieve the Zuora product catalog

2. Create an account and a subscription

3. Upgrade a subscription

4. Cancel a subscription 

The API calls used in this example are shown in cURL in [Zuora Developer Quick Start](https://www.zuora.com/developer/quick-start/).

## Requirements

To build and execute the sample code, you need the following:

* Zuora Test Drive Tenant

  The Test Drive tenant comes with seed data, such as a sample product catalog, which will be used in the sample code. Go to [Zuora Test Drive](https://www.zuora.com/resource/zuora-test-drive/) and sign up for a trial tenant.

* [Maven](https://maven.apache.org/)

  Maven is used to build the QuickStart project in the local repository.

* Java 1.8 or later

  Zuora enforces the use of TLS 1.1, and thus this project was built using Java 1.8.

## Installation and Execution

The QuickStart project contains the following major components:

* ZuoraRestService-1.0.jar 

  This file contains the the Zuora REST client libraries and is located in archive\zuora\com\rest\ZuoraRestService\1.0. 

* zuora.com.rest.ZuoraQuickstart.ZuoraController.java

  This is the class with the QuickStart sample code that uses the Zuora REST API.

Follow these steps to generate the QuickStart project and run thru the use cases:

1. Download or clone the project on your local drive.

2. From the root folder of the project, change directory to ZuoraQuickstart. You should see the pom.xml file in the folder:

   ```shell
   cd ZuoraQuickStart
   ```

3. From the directory where pom.xml resides, execute the following command to install the API client library to your local Maven repository:

   ```shell
   mvn install
   ```

4. Execute the QuickStart. The arguments passed are the user ID and password for your Zuora Test Drive tenant.
   
   ```shell
   mvn exec:java -Dexec.args="TenantUID TenantPWD"
   ```

## Author

docs@zuora.com
