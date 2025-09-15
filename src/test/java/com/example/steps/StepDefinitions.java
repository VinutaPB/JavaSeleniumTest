package com.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StepDefinitions {

    public static WebDriver driver; // make driver static to share with Hooks

    @Given("I open the browser")
    public void i_open_the_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("I navigate to {string}")
    public void i_navigate_to_url(String url) {
        driver.get(url);
    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        System.out.println("Page Title: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch!");
        // ❌ don't quit here, Hooks will handle driver.quit()
    }
}
