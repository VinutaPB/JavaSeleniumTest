package com.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        if (StepDefinitions.driver != null) {
            if (scenario.isFailed()) {
                try {
                    // Capture screenshot as file
                    File screenshot = ((TakesScreenshot) StepDefinitions.driver).getScreenshotAs(OutputType.FILE);

                    // Save screenshot to target/screenshots/
                    File destination = new File("target/screenshots/" + scenario.getName() + ".png");
                    destination.getParentFile().mkdirs(); // create folder if missing
                    Files.copy(screenshot.toPath(), destination.toPath());

                    System.out.println("📸 Screenshot saved at: " + destination.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // Quit browser after each scenario
            StepDefinitions.driver.quit();
        }
    }
}
