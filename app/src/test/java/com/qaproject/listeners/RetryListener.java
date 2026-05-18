package com.qaproject.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * RetryListener — placeholder. Enables retry logic on flaky tests.
 * Attach RetryAnalyzer to @Test annotations automatically.
 */
public class RetryListener implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation,
                          Class testClass,
                          Constructor testConstructor,
                          Method testMethod) {
        // Retry logic can be added here later
        // annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}