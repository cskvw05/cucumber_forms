package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePages;
import pages.LoginPages;
import utlis.DriverManager;

public class LogoutSteps {
    private WebDriver driver;
    private LoginPages loginPage;
    private HomePages homePages;

    public LogoutSteps() {
        DriverManager.setDriver();
        this.driver = DriverManager.getDriver();
        this.loginPage = new LoginPages(driver);
    }

    @Given("User is logged into the Orange HRM application with username {string} and password {string}")
    public void userIsLoggedIntoTheOrangeHRMApplication(String username, String password) {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        homePages = loginPage.loginAs(username, password); // Login and navigate to dashboard
    }

    @When("User logs out")
    public void userLogsOut() {
        homePages.logout(); // Perform logout
    }

    @Then("User should be redirected to the login page")
    public void userShouldBeRedirectedToTheLoginPage() {
        String currentURL = driver.getCurrentUrl(); // Get current URL
        Assert.assertTrue(currentURL.contains("auth/login"), "User is not on the login page after logout.");
    }
}
