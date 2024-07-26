package com.afk.listeners;

import com.afk.reports.ExtentLogger;
import com.afk.reports.ExtentReport;
import com.afk.utils.ScreenshotUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // No screenshot parameter needed here
        ExtentLogger.pass(result.getName() + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Attach the screenshot
        String screenshot = ScreenshotUtils.getScreenshotAsBase64();
        if (screenshot != null) {
            ExtentLogger.fail("Screenshot of failure", screenshot);
        }

        // Log the exception message and stack trace
        ExtentLogger.fail(result.getThrowable().getMessage(), screenshot);
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()), screenshot);
    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReport.initReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.flushReports();
    }
}
