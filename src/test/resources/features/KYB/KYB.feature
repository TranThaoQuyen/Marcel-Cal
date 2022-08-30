Feature: Create KYB
  Background:
    Given logged in

  @CreateKYB
  Scenario Outline: Create KYC successfully
    When user create KYB with "<companyName>" and "<registerNumber>" and "<placeOfCommercialRegister>" and "<companyShareCapital>" and "<companyPlace>"  and "<companyAddress>" and "<companyPostalCode>" as credentials
    Then show Thank you for your Submission
    Examples:
      | companyName | registerNumber | placeOfCommercialRegister  | companyShareCapital |companyPlace         | companyAddress | companyPostalCode|
      | data test   | 4534535435435  | data test                  | data test           | data test           | data test       |   7000           |
