package com.afk.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class LocalDriveFactory {
    private LocalDriveFactory() {
    }

    public static @NotNull WebDriver getLocalDriver(String browser) {
        WebDriver driver = null;

        if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();// Setup WebDriver for Edge browser
            driver = new EdgeDriver(); // Initialize EdgeDriver
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();// Setup WebDriver for Edge browser
            driver = new FirefoxDriver(); // Initialize EdgeDriver
        } else {
            WebDriverManager.chromedriver().setup();// Setup WebDriver for Edge browser
            driver = new ChromeDriver(); // Initialize EdgeDriver

        }
        return driver;

    }
}
