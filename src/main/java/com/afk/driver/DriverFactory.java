package com.afk.driver;

import org.openqa.selenium.WebDriver;

public final class DriverFactory {
    private DriverFactory() {
    }

    public static WebDriver getDriver(String runmode, String browserName) {
        WebDriver driver = null;
        if (runmode.equalsIgnoreCase("local")) {
            driver = LocalDriveFactory.getLocalDriver(browserName);
        } else if (runmode.equalsIgnoreCase("remote")) {
            driver = RemoteDriveFactory.getRemoteDriver(browserName);
        }
        return driver;
    }
}
