package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerAccountPage extends BasePage {
    private By transactionsButton = By.xpath("//button[normalize-space()='Transactions']");
    private By depositButton = By.xpath("//button[normalize-space()='Deposit']");
    private By withdrawlButton = By.xpath("//button[normalize-space()='Withdrawl']");
    private By depositAmountInput = By.xpath("//input[preceding-sibling::label[contains(normalize-space(),'Deposited')]]");
    private By withdrawnAmountInput = By.xpath("//input[preceding-sibling::label[contains(normalize-space(),'Withdrawn')]]");
    private By applyButton = By.cssSelector("button[type='submit']");
    private By successDeposit = By.xpath("//span[normalize-space()='Deposit Successful']");
    private By successTransact = By.xpath("//span[normalize-space()='Transaction successful']");
    private By balanceValue = By.xpath("(//node()[contains(normalize-space(),'Balance')])[last()]/following-sibling::*[1]");

    private By userSelector = By.id("userSelect");
    public CustomerAccountPage(WebDriver driver) {
        super(driver);
    }
}
