
# POSTAccountTypeTaxInfo

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**vATId** | **String** | EU Value Added Tax ID.   **Note:** This feature is in Limited Availability. If you wish to have access to the feature, submit a request at [Zuora Global Support](https://support.zuora.com).  |  [optional]
**companyCode** | **String** | Unique code that identifies a company account in Avalara. Use this field to calculate taxes based on origin and sold-to addresses in Avalara.  **Note:** This feature is in Limited Availability. If you wish to have access to the feature, submit a request at [Zuora Global Support](https://support.zuora.com).   |  [optional]
**exemptCertificateId** | **String** | ID of the customer tax exemption certificate. Requires Z-Tax.  |  [optional]
**exemptCertificateType** | **String** | Type of tax exemption certificate that the customer holds. Requires Z-Tax.  |  [optional]
**exemptDescription** | **String** | Description of the tax exemption certificate that the customer holds. Requires Z-Tax.  |  [optional]
**exemptEffectiveDate** | [**LocalDate**](LocalDate.md) | Date when the customer tax exemption starts. Requires Z-Tax.  Format: &#x60;yyyy-mm-dd&#x60;. Defaults to the current date.  |  [optional]
**exemptExpirationDate** | [**LocalDate**](LocalDate.md) | Date when the customer tax exemption expires. Requires Z-Tax.  Format: &#x60;yyyy-mm-dd&#x60;. Defaults to the current date.  |  [optional]
**exemptIssuingJurisdiction** | **String** | Jurisdiction in which the customer tax exemption certificate was issued.  |  [optional]
**exemptStatus** | **String** | Status of the account tax exemption. Requires Z-Tax.  Required if you use Z-Tax. This field is unavailable if Z-Tax is not used.  Values: &#x60;Yes&#x60;, &#x60;No&#x60;, &#x60;pendingVerification&#x60;.  |  [optional]



