package com.web.pages;

import com.web.utils.RandomDataGenerator;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class BusinessAccountRegPage {
    private final String producerNameFieldXpath = "//input[@data-testid = 'field-element-producerName']";
    private final String contactFirstnameFieldXpath = "//input[@data-testid = 'field-element-contactFirstname']";
    private final String contactLastnameFieldXpath = "//input[@data-testid = 'field-element-contactLastname']";
    private final String directorFirstNameFieldXpath = "//input[@data-testid = 'field-element-directorFirstname']";
    private final String directorLastNameFieldXpath = "//input[@data-testid = 'field-element-directorLastname']";
    private final String companyNameFieldXpath = "//input[@data-testid = 'field-element-companyName']";
    private final String registrationNumberFieldXpath = "//input[@data-testid = 'field-element-registrationNumber']";
    private final String addressCountryCodeXpath = "//input[@data-testid = 'field-element-addressCountryCode']";
    private final String addressCountryCodeDropdownXpath = "//li[contains(@class, 'field-select__option')]//button";
    private final String addressCityFieldXpath = "//input[@data-testid = 'field-element-addressCity']";
    private final String addressRegionFieldXpath = "//input[@data-testid = 'field-element-addressRegion']";
    private final String addressPostCodeFieldXpath = "//input[@data-testid = 'field-element-addressPostCode']";
    private final String addressStreetFieldXpath = "//input[@data-testid = 'field-element-addressStreet']";
    private final String custodianOfRecordsAddressFieldXpath = "//textarea[@data-testid = 'field-element-custodianOfRecordsAddress']";
    private final String nextButtonXpath = "//button[@type='submit']";

    @Step("Fill the 'Producer Name' field with random data")
    public BusinessAccountRegPage fillProducerName() {
        $x(producerNameFieldXpath).setValue(RandomDataGenerator.generateRandomString(10));
        return this;
    }

    @Step("Fill the 'Contact First Name' field with random data")
    public BusinessAccountRegPage fillContactFirstName() {
        $x(contactFirstnameFieldXpath).setValue(RandomDataGenerator.generateRandomString(8));
        return this;
    }

    @Step("Fill the 'Contact Last Name' field with random data")
    public BusinessAccountRegPage fillContactLastName() {
        $x(contactLastnameFieldXpath).setValue(RandomDataGenerator.generateRandomString(8));
        return this;
    }

    @Step("Fill the 'Director First Name' field with random data")
    public BusinessAccountRegPage fillDirectorFirstName() {
        $x(directorFirstNameFieldXpath).setValue(RandomDataGenerator.generateRandomString(8));
        return this;
    }

    @Step("Fill the 'Director Last Name' field with random data")
    public BusinessAccountRegPage fillDirectorLastName() {
        $x(directorLastNameFieldXpath).setValue(RandomDataGenerator.generateRandomString(8));
        return this;
    }

    @Step("Fill the 'Company Name' field with random data")
    public BusinessAccountRegPage fillCompanyName() {
        $x(companyNameFieldXpath).setValue(RandomDataGenerator.generateRandomString(12));
        return this;
    }

    @Step("Fill the 'Registration Number' field with random data")
    public BusinessAccountRegPage fillRegistrationNumber() {
        $x(registrationNumberFieldXpath).setValue(RandomDataGenerator.generateRandomNumber(8));
        return this;
    }

    @Step("Select {country} from the country dropdown")
    public BusinessAccountRegPage selectCountryFromDropdown(String country) {
        $x(addressCountryCodeXpath).click();
        $$x(addressCountryCodeDropdownXpath).findBy(text(country)).click(); //
        return this;
    }

    @Step("Fill the 'City' field with random data")
    public BusinessAccountRegPage fillCity() {
        $x(addressCityFieldXpath).setValue(RandomDataGenerator.generateRandomString(8));
        return this;
    }

    @Step("Fill the 'Region' field with random data")
    public BusinessAccountRegPage fillRegion() {
        $x(addressRegionFieldXpath).setValue(RandomDataGenerator.generateRandomString(8));
        return this;
    }

    @Step("Fill the 'Post Code' field with random data")
    public BusinessAccountRegPage fillPostCode() {
        $x(addressPostCodeFieldXpath).setValue(RandomDataGenerator.generateRandomNumber(5));
        return this;
    }

    @Step("Fill the 'Street' field with random data")
    public BusinessAccountRegPage fillStreet() {
        $x(addressStreetFieldXpath).setValue(RandomDataGenerator.generateRandomString(10));
        return this;
    }

    @Step("Fill the 'Custodian of Records Address' field with random data")
    public BusinessAccountRegPage fillCustodianOfRecordsAddress() {
        $x(custodianOfRecordsAddressFieldXpath).setValue(RandomDataGenerator.generateRandomString(15));
        return this;
    }

    @Step("Click on the 'Next' button")
    public AgreementPage clickNextButton() {
        $x(nextButtonXpath).click();
        return new AgreementPage();
    }

}
