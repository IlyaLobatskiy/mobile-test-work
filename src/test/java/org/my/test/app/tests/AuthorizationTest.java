package org.my.test.app.tests;

import org.junit.jupiter.api.*;
import org.my.test.app.base.BaseTest;
import org.my.test.app.utils.PropConst;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthorizationTest extends BaseTest {
    @Test
    @Order(0)
    @DisplayName("Проверка открытия приложени")
    public void openApp() {
        Assertions.assertTrue(pageManager.getLoginPage().checkTitleScreen(),
                "Приложение не запущено");
    }

    @Test
    @Order(1)
    @DisplayName("Авторизация с валидными данными")
    public void authorization() {
        Assertions.assertEquals("Welcome ! user",
                pageManager.getLoginPage()
                        .authorization(props.getProperty(PropConst.LOGIN),
                                props.getProperty(PropConst.PASSWORD)),
                "Пользователь не авторизован или неверный текст ошибки");
    }

    @Test
    @Order(2)
    @DisplayName("Авторизация с невалидными данными")
    public void errAuthorizationTest() {
        Assertions.assertEquals("Login failed",
                pageManager.getLoginPage().authorization("12", "1124")
                , "Пользователь авторизован или неверный текст ошибки");
    }

}

