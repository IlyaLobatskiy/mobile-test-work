package org.my.test.app.base;

import org.junit.jupiter.api.AfterAll;
import org.my.test.app.managers.InitManager;
import org.my.test.app.managers.PageManager;
import org.my.test.app.managers.TestPropManager;

public class BaseTest {
    /**
     * Менаджер страниц. Возвращает единственный экземпляр страниц в классах наследниках.
     *
     * @see PageManager#getPageManager()
     */
    protected final PageManager pageManager = PageManager.getPageManager();

    /**
     * Менеджер properties
     *
     * @see TestPropManager#getTestPropManager()
     */
    protected static final TestPropManager props = TestPropManager.getTestPropManager();

    /**
     * Завершение работы фреймворка после прохождения всех тестов одного тестового класса
     *
     * @see InitManager#quitFramework()
     */

    @AfterAll
    public static void after() {
        InitManager.quitFramework();
    }

}
