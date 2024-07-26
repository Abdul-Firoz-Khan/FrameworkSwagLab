package com.afk.driver;

import com.afk.config.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public final class Driver {
  private Driver(){}


    public static void initDriver() {
        String browser = ConfigFactory.getConfig().browser();
        String runmode= ConfigFactory.getConfig().runmode();
        if (DriverManager.getDriver() == null) {
            WebDriver driver= DriverFactory.getDriver(runmode,browser);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(ConfigFactory.getConfig().url());
            DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        }

    }

    public static void quiteDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.setDriver(null);
        }
    }
}
