package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerAccountPage extends BasePage {
    private By transactionsButton = By.xpath("//button[normalize-space()='Transactions']");
    private By depositButton = By.xpath("//button[normalize-space()='Deposit']");
    private By withdrawlButton = By.xpath("//button[normalize-space()='Withdrawl']");
    private By depositAmountInput = By.xpath("//input[preceding-sibling::label[contains(normalize-space(),'Deposited')]]");
    private By withdrawlAmountInput = By.xpath("//input[preceding-sibling::label[contains(normalize-space(),'Withdrawn')]]");
    private By applyButton = By.cssSelector("button[type='submit']");
    private By successDeposit = By.xpath("//span[normalize-space()='Deposit Successful']");
    private By successTransact = By.xpath("//span[normalize-space()='Transaction successful']");
    private By balanceValue = By.xpath("(//node()[contains(normalize-space(),'Balance')])[last()]/following-sibling::*[1]");

    public CustomerAccountPage(WebDriver driver) {
        super(driver);
        waitVisibility(depositButton);
    }

    @Step("Открытие страницы транзакций")
    public TransactionsPage openTransactionsPage() {
        driver.findElement(transactionsButton).click();
        return new TransactionsPage(driver);
    }

    @Step("Выбор функции пополнения счета")
    public CustomerAccountPage chooseRefillFunction() {
        driver.findElement(depositButton).click();
        return this;
    }

    @Step("Выбор функции списания со счета")
    public CustomerAccountPage chooseWithdrawlFunction() {
        driver.findElement(withdrawlButton).click();
        return this;
    }

    @Step("Ввод суммы пополнения: {amount}")
    public CustomerAccountPage enterDepositAmount(int amount) {
        waitVisibility(depositAmountInput);
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма не может быть меньше 0");
        }
        driver.findElement(depositAmountInput).sendKeys(Integer.toString(amount));
        return this;
    }

    @Step("Ввод суммы списания: {amount}")
    public CustomerAccountPage enterWithdrawlAmount(int amount) {
        waitVisibility(withdrawlAmountInput);
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма не может быть меньше 0");
        }
        driver.findElement(withdrawlAmountInput).sendKeys(Integer.toString(amount));
        return this;
    }

    @Step("Нажатие кнопки пополнить/списать")
    public CustomerAccountPage clickApply() {
        driver.findElement(applyButton).click();
        return this;
    }

    @Step("Пополнение счета на сумму: {amount}")
    public CustomerAccountPage refillDepositForAmount(int amount) {
        chooseRefillFunction();
        enterDepositAmount(amount);
        clickApply();
        waitVisibility(successDeposit);
        return this;
    }

    @Step("Списание со счета на сумму: {amount}")
    public CustomerAccountPage withdrawForAmount(int amount) {
        chooseWithdrawlFunction();
        enterWithdrawlAmount(amount);
        clickApply();
        waitVisibility(successTransact);
        return this;
    }

    @Step("Проверка, что баланс равен: {value}")
    public boolean isBalanceEqualsToValue(int value) {
        return driver.findElement(balanceValue).getText().equals(Integer.toString(value));
    }
}
