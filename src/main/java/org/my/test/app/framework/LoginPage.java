package org.my.test.app.framework;

import org.my.test.app.managers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Страница авторизации
 */

public class LoginPage extends BasePage {

    DriverManager driver = DriverManager.getDriverManager();

    public LoginPage() {
        PageFactory.initElements(driver.getDriver(), this);
    }

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


    public boolean checkTitleScreen() {
        return isDisplayedElement(screenTitle);
    }

    public String authorization(String eml, String pass) {
        fillingInInputField(email, eml);
        fillingInInputField(password, pass);
        clickElement(singButton);

        return getTextElement(loginText);
    }
}
