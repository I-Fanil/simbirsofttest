import com.google.common.io.Resources;
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

        HomePage homePage = new HomePage(driver);
        CustomerLoginPage customerLoginPage= homePage.openCustomerLoginPage();
        CustomerAccountPage customerAccountPage = customerLoginPage
                .loginAs("Harry Potter")
                .refillDepositForAmount(100)
                .withdrawForAmount(100);
        Assertions.assertTrue(customerAccountPage.isBalanceEqualsToValue(0));
        TransactionsPage transactionsPage = customerAccountPage
                .openTransactionsPage();
        Assertions.assertTrue(transactionsPage.isTransactionsPresentOnPage());
//                .clickBackButton()
//                .openTransactionsPage();
//                .clickOnDateStartRow()
//                .clickBackButton();

//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        driver.close();
    }
}
