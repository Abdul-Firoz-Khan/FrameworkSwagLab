package com.afk;

import com.afk.driver.Driver;
import com.afk.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseTest {


    @BeforeSuite
    public void beforeSuite() {
        ExtentReport.initReport();
    }

    @AfterSuite
    public void afterSuite() {
        ExtentReport.flushReports();
    }

    @BeforeMethod
    public void setUp(Method method) {
        ExtentReport.createTest(method.getName());
        Driver.initDriver();

    }

    @AfterMethod
    public void tearDown() {
        Driver.quiteDriver();

    }
}

