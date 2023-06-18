import com.google.common.io.Resources;
import helpers.Calculation;
import helpers.DateHelper;
import helpers.FileHelper;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CustomerAccountPage;
import pages.CustomerLoginPage;
import pages.HomePage;
import pages.TransactionsPage;
//import org.junit.jupiter.api.parallel.Resources;

public class GlobalsqaTest {

    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", Resources.getResource("chromedriver.exe").getPath());


        WebDriver driver = new ChromeDriver();

        int today = DateHelper.getCurrentDayNumber();
        int amount = Calculation.calculateFibonacciNumber(today + 1);

        HomePage homePage = new HomePage(driver);
        CustomerLoginPage customerLoginPage= homePage.openCustomerLoginPage();
        CustomerAccountPage customerAccountPage = customerLoginPage
                .loginAs("Harry Potter")
                .refillDepositForAmount(amount)
                .withdrawForAmount(amount);
        Assertions.assertTrue(customerAccountPage.isBalanceEqualsToValue(0));
        TransactionsPage transactionsPage = customerAccountPage
                .openTransactionsPage();
        Assertions.assertTrue(transactionsPage.isTransactionsPresentOnPage());
        transactionsPage.getTableDataAndWriteCSVFile();

//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        driver.quit();
//        driver.close();
    }
}
