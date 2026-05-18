package com.qaproject;

public class App {

    public String getGreeting() {
        return "QA Automation Pipeline is Running!";
    }

    public int add(int a, int b) {
        return a + b;
    }

    public boolean isPolicyValid(String policyNumber) {
        if (policyNumber == null || policyNumber.isEmpty()) return false;
        return policyNumber.matches("POL-\\d{6}");
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.getGreeting());
    }
}