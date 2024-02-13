package org.my.test.app.framework;

import org.junit.jupiter.api.Assertions;
import org.my.test.app.utils.PropConst;
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

    public LoginPage checkTitleScreen() {
        Assertions.assertTrue(isDisplayedElement(screenTitle), "Приложение не запущено");
        return pageManager.getLoginPage();
    }

    public LoginPage authorizationValidData() {
        fillingInInputField(email, prop.getProperty(PropConst.LOGIN));
        fillingInInputField(password, prop.getProperty(PropConst.PASSWORD));
        clickElement(singButton);
        Assertions.assertEquals("Welcome ! user", getTextElement(loginText),
                "Пользователь авторизован или неверный текст ошибки");
        return pageManager.getLoginPage();
    }

    public LoginPage authorizationInvalidData() {
        fillingInInputField(email, "123");
        fillingInInputField(password,"321");
        clickElement(singButton);
        Assertions.assertEquals("Login failed", getTextElement(loginText),
                "Пользователь авторизован или неверный текст ошибки");
        return pageManager.getLoginPage();
    }
}
