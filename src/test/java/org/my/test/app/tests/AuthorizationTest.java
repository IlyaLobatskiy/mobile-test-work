package org.my.test.app.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.my.test.app.base.BaseTest;

public class AuthorizationTest extends BaseTest {
    @Test
    @DisplayName("Авторизация с валидными данными")
    public void authorization() {
        pageManager.getLoginPage()
                .checkTitleScreen()
                .authorizationValidData();
    }

    @Test
    @DisplayName("Авторизация с невалидными данными")
    public void errAuthorizationTest() {
        pageManager.getLoginPage()
                .checkTitleScreen()
                .authorizationInvalidData();
    }
}

