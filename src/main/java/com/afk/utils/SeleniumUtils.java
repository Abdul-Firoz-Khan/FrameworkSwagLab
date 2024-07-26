package com.afk.utils;

import com.afk.reports.ExtentLogger;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtils {

    @Step("Entering value: {value} into element: {elementName}")
    public static void visible(WebDriver driver, By by, String value, String elementName) {
        WebElement element = waitUntilElementIsPresent(driver, by);
        element.sendKeys(value);
        String screenshot = null;
        ExtentLogger.pass(value + " is entered Successfully in " + elementName);
        // Capture and attach screenshot
        screenshot = ScreenshotUtils.getScreenshotAsBase64();
        if (screenshot != null) {
            ExtentLogger.pass("Screenshot after entering value into " + elementName);
        }
    }

    @Step("Clicking on element: {elementName}")
    public static void click(WebDriver driver, By by, String elementName) {
        WebElement element = waitUntilElementIsPresent(driver, by);
        element.click();
        String screenshot = null;
        ExtentLogger.pass(elementName + " is Clicked Successfully");
        // Capture and attach screenshot
        screenshot = ScreenshotUtils.getScreenshotAsBase64();
        if (screenshot != null) {
            ExtentLogger.pass("Screenshot after clicking on " + elementName);
        }
    }

    private static WebElement waitUntilElementIsPresent(WebDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
