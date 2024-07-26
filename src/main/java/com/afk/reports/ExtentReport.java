package com.afk.reports;

import com.afk.contants.FrameworkConstants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReport {
    private ExtentReport() {
    }

    public static ExtentReports extent;
    public static ExtentTest extentTest;


    public static void initReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getReportPath());
        extent.attachReporter(spark);
    }

    public static void flushReports() {
        extent.flush();
    }

    public static void createTest(String testCaseName) {
        extentTest = extent.createTest(testCaseName);
        ExtentManager.setExtentTest(extentTest);
    }

}
