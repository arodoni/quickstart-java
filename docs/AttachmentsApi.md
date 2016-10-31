# AttachmentsApi

All URIs are relative to *https://rest.zuora.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**dELETEAttachments**](AttachmentsApi.md#dELETEAttachments) | **DELETE** /attachments/{attachment-id} | Delete attachments
[**gETAttachments**](AttachmentsApi.md#gETAttachments) | **GET** /attachments/{attachment-id} | View attachments
[**gETAttachmentsResponse**](AttachmentsApi.md#gETAttachmentsResponse) | **GET** /attachments/{object-type}/{object-key} | View attachments list
[**pOSTAttachments**](AttachmentsApi.md#pOSTAttachments) | **POST** /attachments | Add attachments
[**pUTAttachments**](AttachmentsApi.md#pUTAttachments) | **PUT** /attachments/{attachment-id} | Edit attachments


<a name="dELETEAttachments"></a>
# **dELETEAttachments**
> CommonResponseType dELETEAttachments(attachmentId)

Delete attachments

Use the Delete Attachment REST request to delete an attachment from a Zuora object.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AttachmentsApi;


AttachmentsApi apiInstance = new AttachmentsApi();
String attachmentId = "attachmentId_example"; // String | Id of the attachment to be deleted.
try {
    CommonResponseType result = apiInstance.dELETEAttachments(attachmentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AttachmentsApi#dELETEAttachments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **attachmentId** | **String**| Id of the attachment to be deleted. |

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETAttachments"></a>
# **gETAttachments**
> GETAttachmentResponseType gETAttachments(attachmentId)

View attachments

Use the View Attachment REST request to retrieve information about an attachment document.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AttachmentsApi;


AttachmentsApi apiInstance = new AttachmentsApi();
String attachmentId = "attachmentId_example"; // String | Id of the attachment you want to view.
try {
    GETAttachmentResponseType result = apiInstance.gETAttachments(attachmentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AttachmentsApi#gETAttachments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **attachmentId** | **String**| Id of the attachment you want to view. |

### Return type

[**GETAttachmentResponseType**](GETAttachmentResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gETAttachmentsResponse"></a>
# **gETAttachmentsResponse**
> GETAttachmentsResponseType gETAttachmentsResponse(objectType, objectKey)

View attachments list

Use the View Attachment REST request to get a list of attachments on an account, an invoice, or a subscription.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AttachmentsApi;


AttachmentsApi apiInstance = new AttachmentsApi();
String objectType = "objectType_example"; // String |  Specify one of the following: * Account  * Subscription  * Invoice 
String objectKey = "objectKey_example"; // String | Id of the attachment. This id is included in the response from the Add Attachment request.
try {
    GETAttachmentsResponseType result = apiInstance.gETAttachmentsResponse(objectType, objectKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AttachmentsApi#gETAttachmentsResponse");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **objectType** | **String**|  Specify one of the following: * Account  * Subscription  * Invoice  |
 **objectKey** | **String**| Id of the attachment. This id is included in the response from the Add Attachment request. |

### Return type

[**GETAttachmentsResponseType**](GETAttachmentsResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pOSTAttachments"></a>
# **pOSTAttachments**
> POSTAttachmentResponseType pOSTAttachments(associatedObjectType, associatedObjectKey, request, description)

Add attachments

Use the Add Attachment REST request with a multipart/form-data to attach a document file to an Account, a Subscription, or an Invoice.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AttachmentsApi;


AttachmentsApi apiInstance = new AttachmentsApi();
String associatedObjectType = "associatedObjectType_example"; // String | Specify one of the following values: Account, Subscription, or Invoice. 
String associatedObjectKey = "associatedObjectKey_example"; // String | For the Subscription type, specify the Subscription Number. An attachment is tied tied to the Subscription Number and thus viewable with every subscription version.  For Account and Invoice, specify the id. 
POSTAttachmentType request = new POSTAttachmentType(); // POSTAttachmentType | 
String description = "description_example"; // String | Description of the attachment document. 
try {
    POSTAttachmentResponseType result = apiInstance.pOSTAttachments(associatedObjectType, associatedObjectKey, request, description);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AttachmentsApi#pOSTAttachments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **associatedObjectType** | **String**| Specify one of the following values: Account, Subscription, or Invoice.  |
 **associatedObjectKey** | **String**| For the Subscription type, specify the Subscription Number. An attachment is tied tied to the Subscription Number and thus viewable with every subscription version.  For Account and Invoice, specify the id.  |
 **request** | [**POSTAttachmentType**](POSTAttachmentType.md)|  |
 **description** | **String**| Description of the attachment document.  | [optional]

### Return type

[**POSTAttachmentResponseType**](POSTAttachmentResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pUTAttachments"></a>
# **pUTAttachments**
> CommonResponseType pUTAttachments(attachmentId, request)

Edit attachments

Use the Edit Attachment REST request to make changes to the descriptive fields of an attachment, such as the description and the file name. You cannot change the actual content of the attached file in Zuora. If you need to change the actual content, you need to delete the attachment and add the updated file as a new attachment.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AttachmentsApi;


AttachmentsApi apiInstance = new AttachmentsApi();
String attachmentId = "attachmentId_example"; // String | Id of the attachment to be updated.
PUTAttachmentType request = new PUTAttachmentType(); // PUTAttachmentType | 
try {
    CommonResponseType result = apiInstance.pUTAttachments(attachmentId, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AttachmentsApi#pUTAttachments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **attachmentId** | **String**| Id of the attachment to be updated. |
 **request** | [**PUTAttachmentType**](PUTAttachmentType.md)|  | [optional]

### Return type

[**CommonResponseType**](CommonResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

