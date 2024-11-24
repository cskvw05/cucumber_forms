package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePages {

    private  WebDriver driver;

    private By welcomeMessage = By.id("welcome");
    private By logoutDrop = By.xpath("//ul[@class='oxd-dropdown-menu']");
    private By logoutButton = By.xpath("//a[text()='Logout']");
    private By pimTab = By.id("menu_pim_viewPimModule");
    private By leaveTab = By.id("menu_leave_viewLeaveModule");
    public HomePages(WebDriver driver) {
        this.driver=driver;
    }


    public String getWelcomeMessage() {
        return driver.findElement(welcomeMessage).getText();
    }

    public void logout() {
        driver.findElement(logoutDrop).click(); // Click welcome menu
        driver.findElement(logoutButton).click();   // Click logout
    }

}


