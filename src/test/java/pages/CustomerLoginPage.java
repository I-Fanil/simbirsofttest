package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomerLoginPage extends BasePage {
    private By userSelector = By.id("userSelect");
    private By loginButton = By.cssSelector("button[type='submit']");

    public CustomerLoginPage(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
        new HomePage(driver).customerLogin(this);
    }

    @Step("Выбор пользователя {user}")
    public CustomerLoginPage selectUser(String user) {
        waitVisibility(userSelector);
        Select userSelect = new Select(driver.findElement(userSelector));
        userSelect.selectByVisibleText(user);

        return this;
    }

    @Step("Нажатие кнопки логина")
    public CustomerAccountPage clickLogin() {
        waitVisibility(loginButton);
        driver.findElement(loginButton).click();
        return new CustomerAccountPage(driver);
    }

    @Step("Залогиниться как {user}")
    public CustomerAccountPage loginAs(String user) {
        selectUser(user);
        return clickLogin();
    }
}
