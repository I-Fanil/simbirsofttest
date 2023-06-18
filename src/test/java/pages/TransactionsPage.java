package pages;

import helpers.DateHelper;
import helpers.FileHelper;
import helpers.TableHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TransactionsPage extends BasePage {
    private By backButton = By.xpath("//button[normalize-space()='Back']");
    private By dateStartRow = By.cssSelector("input#start");
    private By debitTransaction = By.xpath("//tr/td[normalize-space()='Debit']");
    private By creditTransaction = By.xpath("//tr/td[normalize-space()='Credit']");
    private By transactionTable = By.tagName("table");

    public TransactionsPage(WebDriver driver) {
        super(driver);
        waitVisibility(dateStartRow);
        driver.navigate().refresh();
    }

    @Step("Нажатие кнопки перехода назад")
    public CustomerAccountPage clickBackButton() {
        driver.findElement(backButton).click();
        return new CustomerAccountPage(driver);
    }

    @Step("Проверка наличия транзакций")
    public boolean isTransactionsPresentOnPage() {
        waitVisibility(debitTransaction);
        return (driver.findElement(debitTransaction).isDisplayed()
                && driver.findElement(creditTransaction).isDisplayed());
    }

    @Step("Получение данных из таблицы транзакций и формирование файла формата csv")
    public TransactionsPage getTableDataAndWriteCSVFile() {
        WebElement table = driver.findElement(transactionTable);
        List<String[]> tableData = TableHelper.getTableData(table);
        for (String[] rowData : tableData) {
            String newDate = "\"" + DateHelper.convertDate(rowData[0]) + "\"";
            rowData[0] = newDate;
        }
        FileHelper.writeCSVFile("target/1.csv", tableData);
        return this;
    }
}