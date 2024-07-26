package com.afk.driver;

import com.afk.config.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriveFactory {
    private RemoteDriveFactory() {
        // Private constructor to prevent instantiation
    }

    public static WebDriver getRemoteDriver(String browser) {
        WebDriver driver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();

        try {
            if (browser.equalsIgnoreCase("edge")) {
                capabilities.setBrowserName("edge");
            } else if (browser.equalsIgnoreCase("firefox")) {
                capabilities.setBrowserName("firefox");
            } else if (browser.equalsIgnoreCase("chrome")) {
                capabilities.setBrowserName("chrome");
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            driver = new RemoteWebDriver(new URL(ConfigFactory.getConfig().remoteurl()), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid remote URL", e);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new RuntimeException("Error initializing remote driver", e);
        }

        return driver;
    }
}
