# Zuora Quickstart

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

## Installation

### Maven Local Repository

The Zuora library has been condensed into a single jar file:
* ZuoraRestService-1.0.jar
This file is located in Git at archive\zuora\com\rest\ZuoraRestService\1.0.  Maven is used to create a local repository to hold
this file so the libraries are available at compile and runtime.  To create the local repository:
* Downloda/clone the project on your local drive
* Modify the pom.xml file to point to your archive directory.  For example replace:
```xml
  <repository>
    <id>Zuora</id>
    <url>file://<YOUR LOCAL DIRECTORY></url>
  </repository>
```

  With something like:
```xml
  <repository>
    <id>Zuora</id>
    <url>file://C:/zuora/archive</url>
  </repository>
```

### Project Generation and Execution
To install the API client library to your local Maven repository, from the directory that stores the pom.xml execute:

```shell
mvn install
```

To test the generated jar file, execute:

```shell
mvn exec:java -Dexec.args="TenantUID TenantPWD"
```

The arguments passed are the user ID and password for your Zuora tenant.  These can also be set inside of the
ZuoraController.java file at the lines that read:
```java
	//holds the tenant username (also known as apiAccessKeyId) to connect to the Zuora service
	static String uid = null;
	//holds the tenant password (also known as the apiSecretAccessKey) to connect to the Zuora service
	static String pwd = null;
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author

docs@zuora.com

## License

You are free to use this quickstart.  However, Zuora does not guarantee or make any representations 
regarding the use, results of use, accuracy, security, timeliness, or completeness of any data or 
information relating to the sample code. You, the customer, are responsible for making sure that 
your implementation is secure and functional.

