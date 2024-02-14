package org.my.test.app.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.my.test.app.base.BaseTest;
import org.my.test.app.test.data.TestDataConst;

public class AuthorizationTest extends BaseTest {
    @Test
    @DisplayName("Авторизация с валидными данными")
    public void authorization() {
        pageManager.getLoginPage()
                .checkTitleScreen()
                .authorizationValidData(TestDataConst.VALID_LOGIN, TestDataConst.VALID_PASSWORD);
    }

    @Test
    @DisplayName("Авторизация с невалидными данными")
    public void errAuthorizationTest() {
        pageManager.getLoginPage()
                .checkTitleScreen()
                .authorizationInvalidData(TestDataConst.INVALID_LOGIN, TestDataConst.INVALID_PASSWORD);
    }
}

