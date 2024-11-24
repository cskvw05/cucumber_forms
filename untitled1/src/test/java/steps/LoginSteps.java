package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePages;

import pages.LoginPages;

import utlis.DriverManager;

public class LoginSteps {
    private WebDriver driver;
    private LoginPages loginPage;
    private HomePages homePages;

    public LoginSteps() {
        DriverManager.setDriver();
        this.driver = DriverManager.getDriver();
        this.loginPage = new LoginPages(driver);
    }

    @Given("User is on the Orange HRM login page")
    public void userIsOnTheOrangeHRMLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/"); // Orange HRM demo URL
    }

    @When("User logs in with username {string} and password {string}")
    public void userLogsInWithUsernameAndPassword(String username, String password) {

        homePages = loginPage.loginAs(username, password); // Login and navigate to dashboard
    }

    @Then("User should see the dashboard title as {string}")
    public void userShouldSeeTheDashboardTitleAs(String expectedTitle) {
        String actualTitle = driver.getTitle(); // Get the page title
        Assert.assertEquals(actualTitle, expectedTitle, "Dashboard title mismatch!");
       driver.quit();
    }
}

