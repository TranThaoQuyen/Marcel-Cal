Feature: Create KYC Individual
  Background:
    Given user logged in

  @CreateKYCIndividual
  Scenario Outline: Create KYC successfully
    When user create KYC with "<identificationNum>" and "<dateOfBirth>" and "<placeOfBirth>" and "<residentialAddress>" and "<city>" and "<postalCode>" as credentials
    Then show submission header
    Examples:
      | identificationNum | dateOfBirth | placeOfBirth  | residentialAddress |city         | postalCode |
      | 123456789         | 01.01.1991  |data test      | data test          | data test   | 7000    |
