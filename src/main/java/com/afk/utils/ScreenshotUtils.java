package com.afk.utils;

import com.afk.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotUtils {

    private ScreenshotUtils() {
        // Private constructor to prevent instantiation
    }

    public static String getScreenshotAsBase64() {
        try {
            TakesScreenshot screenshotDriver = (TakesScreenshot) DriverManager.getDriver();
            if (screenshotDriver == null) {
                return null;
            }
            return screenshotDriver.getScreenshotAs(OutputType.BASE64);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
