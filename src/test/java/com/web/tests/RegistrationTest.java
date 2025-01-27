package com.web.tests;

import com.web.pages.*;
import com.web.utils.RandomDataGenerator;
import io.qameta.allure.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Execution(ExecutionMode.CONCURRENT)
@Epic("User Registration")
@Feature("Complete Registration Flow")
public class RegistrationTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "Serbia, regtest1.png",
            "Cyprus, regtest1.png"
    })
    @Story("User completes registration and deletes account")
    @Description("This test verifies that a user can complete the registration process and delete the account.")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistration(String country, String docPhoto) {

        new LandingPage()
                .openPage();

        Allure.step("Fill registration form with random valid data and click next button", () -> {
            new LandingPage()
                    .fillUsername(RandomDataGenerator.generateRandomString(10))
                    .fillEmail(RandomDataGenerator.generateRandomEmail())
                    .fillPassword(RandomDataGenerator.generateRandomPassword())
                    .clickGetStartedButton();
        });
        Allure.step("Choose business account and fill fields", () -> {
            new AccountTypePage().selectBusinessAccount()
                    .fillProducerName()
                    .fillContactFirstName()
                    .fillContactLastName()
                    .fillDirectorFirstName()
                    .fillDirectorLastName()
                    .fillCompanyName()
                    .fillRegistrationNumber()
                    .selectCountryFromDropdown(country)
                    .fillCity()
                    .fillRegion()
                    .fillPostCode()
                    .fillStreet()
                    .fillCustodianOfRecordsAddress()
                    .clickNextButton();
        });
        Allure.step("Agree with terms and click next button", () -> {
            new AgreementPage().agreeWithTerms()
                    .clickNextButton();
        });
        Allure.step("Upload documents", () -> {
            new VerificationPage().uploadPhotoPassport(docPhoto)
                    .uploadPhotoCommercial(docPhoto)
                    .uploadPhotoCertificate(docPhoto)
                    .clickFinishRegistrationButton();
        });
        Allure.step("Dismiss and delete account", () -> {
            new EmailConfirmationModal().dismissAndDeleteAccount()
                    .clickDeleteButton();
        });

        boolean isOnLandingPage = new LandingPage()
                .isOnLandingPage();

        assertTrue(isOnLandingPage, "User should be redirected to the landing page after deleting the account.");
    }
}