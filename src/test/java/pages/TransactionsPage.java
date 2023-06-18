package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionsPage extends BasePage {
    private By backButton = By.xpath("//button[normalize-space()='Back']");
    private By dateStartRow = By.cssSelector("input#start");
    private By dateEndRow = By.cssSelector("input#end");
    private By debitTransaction = By.xpath("//tr/td[normalize-space()='Debit']");
    private By creditTransaction = By.xpath("//tr/td[normalize-space()='Credit']");

    public TransactionsPage(WebDriver driver) {
        super(driver);
        waitVisibility(dateStartRow);
    }

    @Step("Клик по стартовой строке даты для обновления таблицы")
    public TransactionsPage clickOnDateStartRow() {
        driver.findElement(dateEndRow).sendKeys("999");
        driver.findElement(dateStartRow).sendKeys("000");
        waitVisibility(debitTransaction);
        return this;
    }

    @Step("Нажатие кнопки перехода назад")
    public CustomerAccountPage clickBackButton() {
        driver.findElement(backButton).click();
        return new CustomerAccountPage(driver);
    }

    @Step("Проверка наличия транзакций")
    public boolean isTransactionsPresentOnPage() {
        waitVisibility(debitTransaction);
        return (driver.findElement(debitTransaction).isDisplayed() && driver.findElement(creditTransaction).isDisplayed());
    }
}
