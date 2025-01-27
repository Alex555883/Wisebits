package com.web.pages;

import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;

public class AccountTypePage {
    private final String businessAccountRadioXpath = "//div[contains(@class,'value-business')]";
    private final String nextButtonXpath = "//div[@data-testid = 'wizard-business-form-submit-btn']";

    @Step("Select 'Business' account type")
    public BusinessAccountRegPage selectBusinessAccount() {
        $x(businessAccountRadioXpath).click();
        return new BusinessAccountRegPage();
    }

    @Step("Click on the 'Next' button")
    public AgreementPage clickNextButton() {
        $x(nextButtonXpath).click();
        return new AgreementPage();
    }
}
