package com.web.utils;

import com.codeborne.selenide.Configuration;
import com.web.config.TestConfig;

public class WebDriverUtils {
    public static void setupDriver() {
        Configuration.browser = TestConfig.getBrowser();
        Configuration.baseUrl = TestConfig.getBaseUrl();
        Configuration.browserSize = TestConfig.getWindowsSizeWait();
        Configuration.timeout = Long.parseLong(TestConfig.getImplicitWait());
    }
}