package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    private By homeButton = By.xpath("//button[normalize-space()='Home']");
    private By customerLoginButton = By.xpath("//button[normalize-space()='Customer Login']");
    private By managerLoginButton = By.xpath("//button[normalize-space()='Bank Manager Login']");

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public CustomerLoginPage customerLogin() {
        waitAndClick(customerLoginButton);
        return new CustomerLoginPage(driver);
    }
}
