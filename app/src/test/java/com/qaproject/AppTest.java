package com.qaproject;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AppTest {

    private App app;

    @BeforeClass
    public void setUp() {
        app = new App();
    }

    @Test(groups = "smoke")
    public void testGreeting() {
        String result = app.getGreeting();
        Assert.assertNotNull(result);
        Assert.assertTrue(result.contains("Pipeline"));
    }

    @Test(groups = "smoke")
    public void testAddPositiveNumbers() {
        Assert.assertEquals(app.add(3, 4), 7);
    }

    @Test(groups = "smoke")
    public void testAddWithZero() {
        Assert.assertEquals(app.add(0, 5), 5);
    }

    @Test(groups = "smoke")
    public void testAddNegativeNumbers() {
        Assert.assertEquals(app.add(-3, -2), -5);
    }

    @DataProvider(name = "validPolicies")
    public Object[][] validPolicies() {
        return new Object[][] {
            {"POL-123456", true},
            {"POL-000001", true},
            {"INVALID",    false},
            {"",           false},
            {null,         false},
            {"POL-12345",  false},
            {"pol-123456", false},
        };
    }

    @Test(dataProvider = "validPolicies", groups = "smoke")
    public void testPolicyValidation(String policyNumber, boolean expected) {
        Assert.assertEquals(app.isPolicyValid(policyNumber), expected,
            "Policy validation failed for: " + policyNumber);
    }
}