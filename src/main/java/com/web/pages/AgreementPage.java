package com.web.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class AgreementPage {
    private final String agreeCheckboxXpath = "//div[@data-testid='field-element-contractSigned']";
    private final String nextButtonXpath = "//button[@type='submit']";

    @Step("Agree with the terms and conditions")
    public AgreementPage agreeWithTerms() {
        $x(agreeCheckboxXpath).click();
        return this;
    }

    @Step("Click on the 'Next' button")
    public VerificationPage clickNextButton() {
        $x(nextButtonXpath).click();
        return new VerificationPage();
    }
}