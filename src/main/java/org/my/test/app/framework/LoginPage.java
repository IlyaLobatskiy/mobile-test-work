package org.my.test.app.framework;

import org.my.test.app.managers.DriverMansger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    DriverMansger driver = DriverMansger.getDriverManager();
    public LoginPage() throws Exception {
        PageFactory.initElements(driver.getDriver(), this);
    }

    @FindBy(id = "com.example.login:id/toolbar")
    WebElement screenTitle;
    @FindBy(id= "com.example.login:id/username")
    WebElement email;
    @FindBy(id= "com.example.login:id/password")
    WebElement password;
    @FindBy(id = "com.example.login:id/login")
    WebElement singButton;
    @FindBy(id = "com.example.login:id/succestext")
    WebElement loginText;



    public boolean checkTitleScreen(){
        return screenTitle.isDisplayed();
    }

    public void emailInput(String eml){
        email.sendKeys(eml);
    }

    public void passwordInput(String pass){
        password.sendKeys(pass);
    }

    public void singButtonClick(){
        singButton.click();
    }

    public String authorization(String eml, String pass){
        emailInput(eml);
        passwordInput(pass);
        singButtonClick();
        return loginText.getText();
    }
}
