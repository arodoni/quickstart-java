/**
 * Zuora REST API Reference
 *  # Introduction  Welcome to the reference documentation for the Zuora REST API!   [REST](http://en.wikipedia.org/wiki/REST_API \"http://en.wikipedia.org/wiki/REST_API\") is a web-service protocol that lends itself to rapid development by using everyday HTTP and JSON technology. REST offers the following:  *   Easy to use and learn for developers *   Works with virtually any language and platform *   Use case-oriented calls *   Well-suited for solutions that fall outside the traditional desktop application model  The Zuora REST API provides a set of use case-oriented calls that:  *   Enable Web Storefront integration between your websites. *   Support self-service subscriber sign-ups and account management. *   Process revenue schedules through custom revenue rule models.  ## Set up an API User Account  Few setup steps are required to use the Zuora REST API. No special software libraries or development tools are needed. Take a moment to set up an API user account. See [Creating an API](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/AB_Getting_started_with_the__SOAP_API/F_Create_an_API_User) user.  Note that a user role does not have write access to Zuora REST services unless it has the API Write Access permission as described in those instructions.  Use the API user account only for API calls, and avoid using it to log into the Zuora UI. Logging into the UI enables a security feature that periodically expires the account's password, which may eventually cause authentication failures with the API.  ## Authentication  There are three ways to authenticate:  * Use an authorization cookie. The cookie authorizes the user to make calls to the REST API for the duration specified in  **Administration > Security Policies > Session timeout**. The cookie expiration time is reset with this duration after every call to the REST API. To obtain a cookie, call the REST  `connections` resource with the following API user information:     *   ID     *   password     *   entity Id or entity name (Only for [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity \"Multi-entity\"). See \"Entity Id and Entity Name\" below for more information.)  *   Include the following parameters in the request header, which re-authenticates the user with each request:     *   `apiAccessKeyId`     *   `apiSecretAccessKey`     *   `entityId` or `entityName` (Only for [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity \"Multi-entity\"). See \"Entity Id and Entity Name\" below for more information.) *   For CORS-enabled APIs only: Include a 'single-use' token in the request header, which re-authenticates the user with each request. See below for more details.   ## Errors  Responses and error codes are detailed in [Responses and errors](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/3_Responses_and_errors \"Responses and errors\").   ## Entity Id and Entity Name  The `entityId` and `entityName`  parameters are only used for  [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity).  The  `entityId` parameter specifies the Id of the entity that you want to access. The `entityName` parameter specifies the [name of the entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity/B_Introduction_to_Entity_and_Entity_Hierarchy#Name_and_Display_Name \"Introduction to Entity and Entity Hierarchy\") that you want to access. Note that you must have permission to access the entity. You can get the entity Id and entity name through the REST GET Entities call.  You can specify either the  `entityId` or `entityName` parameter in the authentication to access and view an entity.  *   If both `entityId` and `entityName` are specified in the authentication, an error occurs.  *   If neither  `entityId` nor  `entityName` is specified in the authentication, you will log in to the entity in which your user account is created.   See [API User Authentication](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity/A_Overview_of_Multi-entity#API_User_Authentication \"Zuora Multi-entity\") for more information.  ## Token Authentication for CORS-Enabled APIs  The CORS mechanism enables REST API calls to Zuora to be made directly from your customer's browser, with all credit card and security information transmitted directly to Zuora. This minimizes your PCI compliance burden, allows you to implement advanced validation on your payment forms, and makes your payment forms look just like any other part of your website.  For security reasons, instead of using cookies, an API request via CORS uses **tokens** for authentication.  The token method of authentication is only designed for use with requests that must originate from your customer's browser; **it should not be considered a replacement to the existing cookie authentication** mechanism.  See [Zuora CORS REST ](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/G_CORS_REST \"Zuora CORS REST\")for details on how CORS works and how you can begin to implement customer calls to the Zuora REST APIs. See  [HMAC Signatures](/BC_Developers/REST_API/B_REST_API_reference/HMAC_Signatures \"HMAC Signatures\") for details on the HMAC method that returns the authentication token.   ## Zuora REST API Versions  The Zuora REST API is in version control. Versioning ensures that Zuora REST API changes are backward compatible. Zuora uses a major and minor version nomenclature to manage changes. By specifying a version in a REST request, you can get expected responses regardless of future changes to the API.   ### Major Version  The major version number of the REST API appears in the REST URL. Currently, Zuora only supports the **v1** major version. For example,  `POST https://rest.zuora.com/v1/subscriptions` .   ### Minor Version  Zuora uses minor versions for the REST API to control small changes. For example, a field in a REST method is deprecated and a new field is used to replace it.   Some fields in the REST methods are supported as of minor versions. If a field is not noted with a minor version, this field is available for all minor versions. If a field is noted with a minor version, this field is in version control. You must specify the supported minor version in the request header to process without an error.   If a field is in version control, it is either with a minimum minor version or a maximum minor version, or both of them. You can only use this field with the minor version between the minimum and the maximum minor versions. For example, the  `invoiceCollect` field in the POST Subscription method is in version control and its maximum minor version is 189.0. You can only use this field with the minor version 189.0 or earlier.  The supported minor versions are not serial, see [Zuora REST API Minor Version History](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/Zuora_REST_API_Minor_Version_History \"Zuora REST API Minor Version History\") for the fields and their supported minor versions. In our REST API documentation, if a field or feature requires a minor version number, we note that in the field description.  You only need to specify the version number when you use the fields require a minor version. To specify the minor version, set the `zuora-version` parameter to the minor version number in the request header for the request call. For example, the `collect` field is in 196.0 minor version. If you want to use this field for the POST Subscription method, set the  `zuora-version` parameter to `196.0` in the request header. The `zuora-version` parameter is case sensitive.   For all the REST API fields, by default, if the minor version is not specified in the request header, Zuora will use the minimum minor version of the REST API to avoid breaking your integration.    ## URLs and Endpoints  The following REST services are provided in Zuora.  | Service                 | Base URL for REST Endpoints                                                                                                                                         | |-------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------| | Production REST service | https://rest.zuora.com/v1                                                                                                                                           | | Sandbox REST service    | https://rest.apisandbox.zuora.com/v1                                                                                                                                | | Services REST service   | https://services123.zuora.com/apps/v1/  (where \"123\" is replaced by the number of your actual services environment)  The production service provides access to your live user data. The sandbox environment is a good place to test your code without affecting real-world data.  To use it, you must be provisioned with a sandbox tenant - your Zuora representative can help with this if needed.   ## Requests and Responses   ### HTTP Request Body  Most of the parameters and data accompanying your requests will be contained in the body of the HTTP request.  The Zuora REST API accepts JSON in the HTTP request body.  No other data format (e.g., XML) is supported.   #### Testing a Request  Use a third party client, such as Postman or Advanced REST Client, to test the Zuora REST API.  You can test the Zuora REST API from the Zuora sandbox or  production service. If connecting to the production service, bear in mind that you are working with your live production data, not sample data or test data.  #### Testing with Credit Cards  Sooner or later it will probably be necessary to test some transactions that involve credit cards. For suggestions on how to handle this, see [Going Live With Your Payment Gateway](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/C_Managing_Payment_Gateways/B_Going_Live_Payment_Gateways#Testing_with_Credit_Cards \"C_Zuora_User_Guides/A_Billing_and_Payments/M_Payment_Gateways/C_Managing_Payment_Gateways/B_Going_Live_Payment_Gateways#Testing_with_Credit_Cards\").   ## Request IDs  As a general rule, when asked to supply a \"key\" for an account or subscription (accountKey, account-key, subscriptionKey, subscription-key), you can provide either the actual ID or the number of the entity.  ## Pagination  When retrieving information (using GET methods), the optional `pageSize` query parameter sets the maximum number of rows to return in a response. The maximum is `40`; larger values are treated as `40`. If this value is empty or invalid, `pageSize` typically defaults to `10`.  The default value for the maximum number of rows retrieved can be overridden at the method level.  If more rows are available, the response will include a `nextPage` element, which contains a URL for requesting the next page.  If this value is not provided, no more rows are available. No \"previous page\" element is explicitly provided; to support backward paging, use the previous call.  ### Array Size  For data items that are not paginated, the REST API supports arrays of up to 300 rows.  Thus, for instance, repeated pagination can retrieve thousands of customer accounts, but within any account an array of no more than 300 rate plans is returned. 
 *
 * OpenAPI spec version: 0.0.1
 * Contact: docs@zuora.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Container for sold-to contact information. Uses the same field structure as billToContact. 
 */
@ApiModel(description = "Container for sold-to contact information. Uses the same field structure as billToContact. ")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class GETAccountTypeSoldToContact   {
  @SerializedName("address1")
  private String address1 = null;

  @SerializedName("address2")
  private String address2 = null;

  @SerializedName("city")
  private String city = null;

  @SerializedName("country")
  private String country = null;

  @SerializedName("county")
  private String county = null;

  @SerializedName("customField__c")
  private String customFieldC = null;

  @SerializedName("fax")
  private String fax = null;

  @SerializedName("firstName")
  private String firstName = null;

  @SerializedName("homePhone")
  private String homePhone = null;

  @SerializedName("lastName")
  private String lastName = null;

  @SerializedName("mobilePhone")
  private String mobilePhone = null;

  @SerializedName("nickname")
  private String nickname = null;

  @SerializedName("otherPhone")
  private String otherPhone = null;

  @SerializedName("otherPhoneType")
  private String otherPhoneType = null;

  @SerializedName("personalEmail")
  private String personalEmail = null;

  @SerializedName("state")
  private String state = null;

  @SerializedName("taxRegion")
  private String taxRegion = null;

  @SerializedName("workEmail")
  private String workEmail = null;

  @SerializedName("workPhone")
  private String workPhone = null;

  @SerializedName("zipCode")
  private String zipCode = null;

  public GETAccountTypeSoldToContact address1(String address1) {
    this.address1 = address1;
    return this;
  }

   /**
   * First address line, 255 characters or less. 
   * @return address1
  **/
  @ApiModelProperty(example = "null", value = "First address line, 255 characters or less. ")
  public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public GETAccountTypeSoldToContact address2(String address2) {
    this.address2 = address2;
    return this;
  }

   /**
   * Second address line, 255 characters or less. 
   * @return address2
  **/
  @ApiModelProperty(example = "null", value = "Second address line, 255 characters or less. ")
  public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public GETAccountTypeSoldToContact city(String city) {
    this.city = city;
    return this;
  }

   /**
   * City, 40 characters or less. 
   * @return city
  **/
  @ApiModelProperty(example = "null", value = "City, 40 characters or less. ")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public GETAccountTypeSoldToContact country(String country) {
    this.country = country;
    return this;
  }

   /**
   * [Country name or abbreviation](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/J_Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes). 
   * @return country
  **/
  @ApiModelProperty(example = "null", value = "[Country name or abbreviation](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/J_Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes). ")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public GETAccountTypeSoldToContact county(String county) {
    this.county = county;
    return this;
  }

   /**
   * County; 32 characters or less. [Z-Tax](https://knowledgecenter.zuora.com/CB_Billing/J_Billing_Operations/L_Taxes/A_Z-Tax) uses this information to calculate county taxation.           
   * @return county
  **/
  @ApiModelProperty(example = "null", value = "County; 32 characters or less. [Z-Tax](https://knowledgecenter.zuora.com/CB_Billing/J_Billing_Operations/L_Taxes/A_Z-Tax) uses this information to calculate county taxation.           ")
  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public GETAccountTypeSoldToContact customFieldC(String customFieldC) {
    this.customFieldC = customFieldC;
    return this;
  }

   /**
   * Any custom fields defined for this object. 
   * @return customFieldC
  **/
  @ApiModelProperty(example = "null", value = "Any custom fields defined for this object. ")
  public String getCustomFieldC() {
    return customFieldC;
  }

  public void setCustomFieldC(String customFieldC) {
    this.customFieldC = customFieldC;
  }

  public GETAccountTypeSoldToContact fax(String fax) {
    this.fax = fax;
    return this;
  }

   /**
   * Fax phone number, 40 characters or less. 
   * @return fax
  **/
  @ApiModelProperty(example = "null", value = "Fax phone number, 40 characters or less. ")
  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public GETAccountTypeSoldToContact firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * First name, 100 characters or less. 
   * @return firstName
  **/
  @ApiModelProperty(example = "null", value = "First name, 100 characters or less. ")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public GETAccountTypeSoldToContact homePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

   /**
   * Home phone number, 40 characters or less. 
   * @return homePhone
  **/
  @ApiModelProperty(example = "null", value = "Home phone number, 40 characters or less. ")
  public String getHomePhone() {
    return homePhone;
  }

  public void setHomePhone(String homePhone) {
    this.homePhone = homePhone;
  }

  public GETAccountTypeSoldToContact lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * Last name, 100 characters or less. 
   * @return lastName
  **/
  @ApiModelProperty(example = "null", value = "Last name, 100 characters or less. ")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public GETAccountTypeSoldToContact mobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

   /**
   * Mobile phone number, 40 characters or less. 
   * @return mobilePhone
  **/
  @ApiModelProperty(example = "null", value = "Mobile phone number, 40 characters or less. ")
  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public GETAccountTypeSoldToContact nickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

   /**
   * Nickname for this contact. 
   * @return nickname
  **/
  @ApiModelProperty(example = "null", value = "Nickname for this contact. ")
  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public GETAccountTypeSoldToContact otherPhone(String otherPhone) {
    this.otherPhone = otherPhone;
    return this;
  }

   /**
   * Other phone number, 40 characters or less. 
   * @return otherPhone
  **/
  @ApiModelProperty(example = "null", value = "Other phone number, 40 characters or less. ")
  public String getOtherPhone() {
    return otherPhone;
  }

  public void setOtherPhone(String otherPhone) {
    this.otherPhone = otherPhone;
  }

  public GETAccountTypeSoldToContact otherPhoneType(String otherPhoneType) {
    this.otherPhoneType = otherPhoneType;
    return this;
  }

   /**
   * Possible values are: `Work`, `Mobile`, `Home`, `Other`. 
   * @return otherPhoneType
  **/
  @ApiModelProperty(example = "null", value = "Possible values are: `Work`, `Mobile`, `Home`, `Other`. ")
  public String getOtherPhoneType() {
    return otherPhoneType;
  }

  public void setOtherPhoneType(String otherPhoneType) {
    this.otherPhoneType = otherPhoneType;
  }

  public GETAccountTypeSoldToContact personalEmail(String personalEmail) {
    this.personalEmail = personalEmail;
    return this;
  }

   /**
   * Personal email address, 80 characters or less. 
   * @return personalEmail
  **/
  @ApiModelProperty(example = "null", value = "Personal email address, 80 characters or less. ")
  public String getPersonalEmail() {
    return personalEmail;
  }

  public void setPersonalEmail(String personalEmail) {
    this.personalEmail = personalEmail;
  }

  public GETAccountTypeSoldToContact state(String state) {
    this.state = state;
    return this;
  }

   /**
   * [State name or 2-character abbreviation](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/J_Country%2C_State%2C_and_Province_Codes/B_State_Names_and_2-Digit_Codes). 
   * @return state
  **/
  @ApiModelProperty(example = "null", value = "[State name or 2-character abbreviation](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/J_Country%2C_State%2C_and_Province_Codes/B_State_Names_and_2-Digit_Codes). ")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public GETAccountTypeSoldToContact taxRegion(String taxRegion) {
    this.taxRegion = taxRegion;
    return this;
  }

   /**
   * A region string, defined in your [Z-Tax](https://knowledgecenter.zuora.com/CB_Billing/J_Billing_Operations/L_Taxes/A_Z-Tax) tax rules. 
   * @return taxRegion
  **/
  @ApiModelProperty(example = "null", value = "A region string, defined in your [Z-Tax](https://knowledgecenter.zuora.com/CB_Billing/J_Billing_Operations/L_Taxes/A_Z-Tax) tax rules. ")
  public String getTaxRegion() {
    return taxRegion;
  }

  public void setTaxRegion(String taxRegion) {
    this.taxRegion = taxRegion;
  }

  public GETAccountTypeSoldToContact workEmail(String workEmail) {
    this.workEmail = workEmail;
    return this;
  }

   /**
   * Work email address, 80 characters or less. 
   * @return workEmail
  **/
  @ApiModelProperty(example = "null", value = "Work email address, 80 characters or less. ")
  public String getWorkEmail() {
    return workEmail;
  }

  public void setWorkEmail(String workEmail) {
    this.workEmail = workEmail;
  }

  public GETAccountTypeSoldToContact workPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

   /**
   * Work phone number, 40 characters or less. 
   * @return workPhone
  **/
  @ApiModelProperty(example = "null", value = "Work phone number, 40 characters or less. ")
  public String getWorkPhone() {
    return workPhone;
  }

  public void setWorkPhone(String workPhone) {
    this.workPhone = workPhone;
  }

  public GETAccountTypeSoldToContact zipCode(String zipCode) {
    this.zipCode = zipCode;
    return this;
  }

   /**
   * Zip code, 20 characters or less. 
   * @return zipCode
  **/
  @ApiModelProperty(example = "null", value = "Zip code, 20 characters or less. ")
  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GETAccountTypeSoldToContact gETAccountTypeSoldToContact = (GETAccountTypeSoldToContact) o;
    return Objects.equals(this.address1, gETAccountTypeSoldToContact.address1) &&
        Objects.equals(this.address2, gETAccountTypeSoldToContact.address2) &&
        Objects.equals(this.city, gETAccountTypeSoldToContact.city) &&
        Objects.equals(this.country, gETAccountTypeSoldToContact.country) &&
        Objects.equals(this.county, gETAccountTypeSoldToContact.county) &&
        Objects.equals(this.customFieldC, gETAccountTypeSoldToContact.customFieldC) &&
        Objects.equals(this.fax, gETAccountTypeSoldToContact.fax) &&
        Objects.equals(this.firstName, gETAccountTypeSoldToContact.firstName) &&
        Objects.equals(this.homePhone, gETAccountTypeSoldToContact.homePhone) &&
        Objects.equals(this.lastName, gETAccountTypeSoldToContact.lastName) &&
        Objects.equals(this.mobilePhone, gETAccountTypeSoldToContact.mobilePhone) &&
        Objects.equals(this.nickname, gETAccountTypeSoldToContact.nickname) &&
        Objects.equals(this.otherPhone, gETAccountTypeSoldToContact.otherPhone) &&
        Objects.equals(this.otherPhoneType, gETAccountTypeSoldToContact.otherPhoneType) &&
        Objects.equals(this.personalEmail, gETAccountTypeSoldToContact.personalEmail) &&
        Objects.equals(this.state, gETAccountTypeSoldToContact.state) &&
        Objects.equals(this.taxRegion, gETAccountTypeSoldToContact.taxRegion) &&
        Objects.equals(this.workEmail, gETAccountTypeSoldToContact.workEmail) &&
        Objects.equals(this.workPhone, gETAccountTypeSoldToContact.workPhone) &&
        Objects.equals(this.zipCode, gETAccountTypeSoldToContact.zipCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address1, address2, city, country, county, customFieldC, fax, firstName, homePhone, lastName, mobilePhone, nickname, otherPhone, otherPhoneType, personalEmail, state, taxRegion, workEmail, workPhone, zipCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GETAccountTypeSoldToContact {\n");
    
    sb.append("    address1: ").append(toIndentedString(address1)).append("\n");
    sb.append("    address2: ").append(toIndentedString(address2)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    county: ").append(toIndentedString(county)).append("\n");
    sb.append("    customFieldC: ").append(toIndentedString(customFieldC)).append("\n");
    sb.append("    fax: ").append(toIndentedString(fax)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    homePhone: ").append(toIndentedString(homePhone)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    mobilePhone: ").append(toIndentedString(mobilePhone)).append("\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    otherPhone: ").append(toIndentedString(otherPhone)).append("\n");
    sb.append("    otherPhoneType: ").append(toIndentedString(otherPhoneType)).append("\n");
    sb.append("    personalEmail: ").append(toIndentedString(personalEmail)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    taxRegion: ").append(toIndentedString(taxRegion)).append("\n");
    sb.append("    workEmail: ").append(toIndentedString(workEmail)).append("\n");
    sb.append("    workPhone: ").append(toIndentedString(workPhone)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

