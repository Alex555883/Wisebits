package com.web.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LandingPage {
    private final String landingMainSignupXpath = "//div[@class='landing-main__signup']";
    private final String usernameFieldXpath = landingMainSignupXpath + "//input[@name='username']";
    private final String emailFieldXpath = landingMainSignupXpath + "//input[@name='email']";
    private final String passwordFieldXpath = landingMainSignupXpath + "//input[@name='password']";
    private final String startEarningButtonXpath = landingMainSignupXpath + "//button[@type='submit']";

    @Step("Open the landing page")
    public LandingPage openPage() {
        open("");
        return this;
    }

    @Step("Fill the username field with: {username}")
    public LandingPage fillUsername(String username) {
        $x(usernameFieldXpath).setValue(username);
        return this;
    }

    @Step("Fill the email field with: {email}")
    public LandingPage fillEmail(String email) {
        $x(emailFieldXpath).setValue(email);
        return this;
    }

    @Step("Fill the password field with: {password}")
    public LandingPage fillPassword(String password) {
        $x(passwordFieldXpath).setValue(password);
        return this;
    }

    @Step("Click on the 'Get started' button")
    public AccountTypePage clickGetStartedButton() {
        $x(startEarningButtonXpath).click();
        return new AccountTypePage();
    }

    @Step("Verify that the user is on the landing page")
    public boolean isOnLandingPage() {
        return $x(landingMainSignupXpath).shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }
}
