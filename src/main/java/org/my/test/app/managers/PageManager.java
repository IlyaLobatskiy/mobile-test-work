package org.my.test.app.managers;

import org.my.test.app.framework.LoginPage;

/**
 * Класс построен на основе паттерна синглтон.
 * Управляет созданием страниц.
 * Возвращает создает и возвращает страницу в единственном экземпляре
 */
public class PageManager {

    private static PageManager INSTANCE = null;

    private LoginPage loginPage = null;

    private PageManager() {

    }

    public static PageManager getPageManager() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }
}
