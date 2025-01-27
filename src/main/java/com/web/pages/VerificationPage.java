package com.web.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class VerificationPage {
    private final String uploadPhotoPassportXpath = "//input[@id='field-element-passport']";
    private final String uploadPhotoCommercialXpath = "//input[@id='field-element-commercialRegisterExtract']";
    private final String uploadPhotoCertificateXpath = "//input[@id='field-element-certificateOfIncorporation']";
    private final String finishRegistrationButtonXpath = "//button[@type='submit']";

    @Step("Upload passport photo: {filePath}")
    public VerificationPage uploadPhotoPassport(String filePath) {
        $x(uploadPhotoPassportXpath).uploadFromClasspath(filePath);
        return this;
    }

    @Step("Upload commercial register photo: {filePath}")
    public VerificationPage uploadPhotoCommercial(String filePath) {
        $x(uploadPhotoCommercialXpath).uploadFromClasspath(filePath);
        return this;
    }

    @Step("Upload  certificate photo: {filePath}")
    public VerificationPage uploadPhotoCertificate(String filePath) {
        $x(uploadPhotoCertificateXpath).uploadFromClasspath(filePath);
        return this;
    }

    @Step("Click on the 'Finish Registration' button")
    public EmailConfirmationModal clickFinishRegistrationButton() {
        $x(finishRegistrationButtonXpath).click();
        return new EmailConfirmationModal();
    }
}
