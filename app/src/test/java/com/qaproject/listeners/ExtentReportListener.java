package com.qaproject.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Basic TestNG Listener — placeholder until ExtentReports is fully configured.
 * Prints pass/fail to console. Replace with full ExtentReports implementation later.
 */
public class ExtentReportListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ PASSED : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ FAILED : " + result.getName());
        System.out.println("   Reason : " + result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⏭ SKIPPED: " + result.getName());
    }
}