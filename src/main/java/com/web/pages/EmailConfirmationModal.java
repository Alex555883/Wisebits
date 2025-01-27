package com.web.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;

public class EmailConfirmationModal {
    private final String dismissAndDeleteAccountButtonXpath = "//div[@class = 'modal__container']//button[@type='submit']";
    private final String deleteButtonXpath = "//div[@id='modal-root']//div[@class = 'modal__container']//div[@class = 'modal__actions']/button[@data-testid = 'affidavit-dismiss-modal__ok']";

    @Step("Click on the 'Dismiss and delete my account' button")
    public EmailConfirmationModal dismissAndDeleteAccount() {
        $x(dismissAndDeleteAccountButtonXpath).click();
        return this;
    }

    @Step("Click confirmed button 'delete'")
    public LandingPage clickDeleteButton() {
        Selenide.executeJavaScript("arguments[0].click();", $x(deleteButtonXpath));
        return new LandingPage();
    }
}
