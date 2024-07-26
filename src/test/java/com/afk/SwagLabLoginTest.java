package com.afk;

import com.afk.driver.DriverManager;
import com.afk.pages.LoginPageSwaglab;
import com.afk.testdata.TestData;
import com.afk.utils.DataProviderUtils;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabLoginTest extends BaseTest {

    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    @Description("Test Description: This test is to verify the login functionality of SwagLab")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("AFK")
    public void loginTest(TestData testData) {
        WebDriver driver = DriverManager.getDriver();

        LoginPageSwaglab loginPage = new LoginPageSwaglab();
        titleValidatingTest(driver, loginPage, testData.getUsername(), testData.getPassword(), testData.getExpectedTitle());
    }

    @Step("Perform login with username: {username} and verify the title")
    private void titleValidatingTest(WebDriver driver, LoginPageSwaglab loginPage, String username, String password, String expectedTitle) {
        String actualTitle = loginPage
                .loginToApplication(driver, username, password)
                .getHomePageTitle();

        System.out.println("actualTitle = " + actualTitle);
        System.out.println("expectedTitle = " + expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
