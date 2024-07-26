package com.afk.reports;

import com.afk.utils.ScreenshotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;

public final class ExtentLogger {

    private ExtentLogger() {
        // Private constructor to prevent instantiation
    }

    public static void pass(String message) {
        logWithScreenshot(message, Status.PASSED);
    }

    public static void fail(String message, String screenshot) {
        logWithScreenshot(message, Status.FAILED);
    }

    public static void info(String message) {
        logWithScreenshot(message, Status.PASSED); // or Status.INFO, depending on your needs
    }

    private static void logWithScreenshot(String message, Status allureStatus) {
        String screenshot = ScreenshotUtils.getScreenshotAsBase64(); // Updated method call
        if (screenshot == null) {
            screenshot = ""; // Provide a placeholder if screenshot is null
        }
        ExtentManager.getExtentTest().log(
                allureStatus == Status.FAILED ? com.aventstack.extentreports.Status.FAIL :
                        (allureStatus == Status.PASSED ? com.aventstack.extentreports.Status.PASS :
                                com.aventstack.extentreports.Status.INFO),
                message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build()
        );
        Allure.step(message, allureStatus);
    }
}
