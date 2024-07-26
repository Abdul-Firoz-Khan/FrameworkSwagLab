package com.afk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.afk.utils.SeleniumUtils.*;

public class LoginPageSwaglab {
    private static final By TXTBOX_USERNAME = By.id("user-name");
    private static final By TXTBOX_PASSWORD = By.id("password");
    private static final By BTN_LOGIN = By.id("login-button");

    private LoginPageSwaglab setTxtUsername(WebDriver driver, String username) {
        visible(driver, TXTBOX_USERNAME, username, "Username TextBox");
        return this;
    }

    private LoginPageSwaglab setTxtPassword(WebDriver driver, String password) {
        visible(driver, TXTBOX_PASSWORD, password, "Password TextBox");
        return this;
    }

    private HomePageSwaglab setBtnLogin(WebDriver driver) {
        click(driver, BTN_LOGIN, "Login Button");
        return new HomePageSwaglab();
    }

    public HomePageSwaglab loginToApplication(WebDriver driver, String username, String password) {
        return setTxtUsername(driver, username).setTxtPassword(driver, password).setBtnLogin(driver);
    }

}
