package org.my.test.app.managers;

public class InitManager {

    /**
     * Driver manager
     *
     * @see DriverManager#getDriverManager()
     */
    private static final DriverManager driverManager = DriverManager.getDriverManager();

    /**
     * Завершение работы фреймворка. Гасит драйвер и закрывает App
     *
     * @see DriverManager#quitDriver()
     */

    public static void quitFramework() {
        driverManager.quitDriver();
    }

}
