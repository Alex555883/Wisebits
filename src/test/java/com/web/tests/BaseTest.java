package com.web.tests;

import com.web.utils.WebDriverUtils;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    public void setup() {
        WebDriverUtils.setupDriver();
    }
}