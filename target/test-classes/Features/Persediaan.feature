@Test
Feature: Menambahkan persediaan

  Background:
    Given User already login
    And User already in Persediaan page

  Scenario: Change stock with a valid data
    When User click on item checkbox
    And User click penyesuaian persediaan button
    And User fill the penyesuaian persediaan form with valid data
    Then User click simpan button
    And User will see success message

  Scenario: Change stock with a invalid data
    When User click on item checkbox
    And User click penyesuaian persediaan button
    And User fill the penyesuaian persediaan form with invalid data
    Then User click simpan button
    And User will see error message "Qty adjustment tidak boleh yang kosong"