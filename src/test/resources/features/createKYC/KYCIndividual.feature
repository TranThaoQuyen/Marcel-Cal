Feature: Create KYC Individual
  Background:
    Given user logged in

  @CreateKYCIndividual
  Scenario Outline: Create KYC successfully
    When user create KYC with "<identificationNum>" and "<dateOfBirth>" and "<placeOfBirth>" and "<residentialAddress>" and "<city>" and "<postalCode>" as credentials
    Then direct user to dashboard page
    Examples:
      | identificationNum | dateOfBirth | placeOfBirth  | residentialAddress |city         | postalCode |
      | 123456789         | 12.05.1995  |data test      | data test          | data test   | 70000      |
