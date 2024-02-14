package org.my.test.app.framework;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Страница авторизации
 */

public class LoginPage extends BasePage {
    @FindBy(id = "com.example.login:id/toolbar")
    WebElement screenTitle;
    @FindBy(id = "com.example.login:id/username")
    WebElement email;
    @FindBy(id = "com.example.login:id/password")
    WebElement password;
    @FindBy(id = "com.example.login:id/login")
    WebElement singButton;
    @FindBy(id = "com.example.login:id/succestext")
    WebElement loginText;

    public LoginPage() {
        PageFactory.initElements(driver.getDriver(), this);
    }

    @Step("Проверяем запуск приложения на нужном экране")
    public LoginPage checkTitleScreen() {
        Assertions.assertTrue(isDisplayedElement(screenTitle), "Приложение не запущено");
        return pageManager.getLoginPage();
    }

    @Step("Авторизуемся с валидными данными")
    public LoginPage authorizationValidData(String eml, String psw) {
        fillingInInputField(email, eml);
        fillingInInputField(password, psw);
        clickElement(singButton);
        Assertions.assertEquals("Welcome ! user", getTextElement(loginText),
                "Пользователь авторизован или неверный текст ошибки");
        return pageManager.getLoginPage();
    }

    @Step("Авторизуемся с невалидными данными")
    public LoginPage authorizationInvalidData(String eml, String psw) {
        fillingInInputField(email, eml);
        fillingInInputField(password, psw);
        clickElement(singButton);
        Assertions.assertEquals("Login failed", getTextElement(loginText),
                "Пользователь авторизован или неверный текст ошибки");
        return pageManager.getLoginPage();
    }
}
