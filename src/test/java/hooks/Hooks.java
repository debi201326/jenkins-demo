package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import base.DriverFactory;
import utils.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Hooks {

    static ExtentReports extent = ExtentManager.getInstance();
    static ExtentTest test;

    @Before
    public void setup(Scenario scenario) {
        test = extent.createTest(scenario.getName());
        DriverFactory.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        DriverFactory.quitDriver();
        extent.flush();
    }
}