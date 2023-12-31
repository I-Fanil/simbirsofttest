package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected static final String BASE_URL =
            "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    private static final Duration DEFAULT_TIMEOUT_SECONDS = Duration.ofSeconds(5);

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT_SECONDS);
    }

    @Step("Ожидание элемента с локатором {locator} и клик по нему")
    protected void waitAndClick(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    @Step("Ожидание элемента с локатором {locator}")
    protected WebElement waitVisibility(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
