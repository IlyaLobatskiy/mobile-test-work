package org.my.test.app.framework;

import org.my.test.app.managers.DriverManager;
import org.my.test.app.managers.PageManager;
import org.my.test.app.managers.TestPropManager;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected final DriverManager driver = DriverManager.getDriverManager();
    protected final PageManager pageManager = PageManager.getPageManager();
    protected final TestPropManager prop = TestPropManager.getTestPropManager();

    /**
     * Проверяет нахождение элемента на странице
     *
     * @param element - элемент который надо проверить
     */
    public boolean isDisplayedElement(WebElement element) {
        return element.isDisplayed();
    }

    /**
     * Заполнение поля ввода
     *
     * @param element - путь к полю ввода
     * @param content - контент которым заполняется поле
     */
    public void fillingInInputField(WebElement element, String content) {
        element.sendKeys(content);
    }

    /**
     * Нажатие на элемент
     *
     * @param element - Элемент на который нажимаем
     */
    public void clickElement(WebElement element) {
        element.click();
    }

    /**
     * Возвращает текст элемента
     *
     * @param element - элемент текст которого возвращаем
     */
    public String getTextElement(WebElement element) {
        return element.getText();
    }
}
