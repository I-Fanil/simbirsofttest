import com.google.common.io.Resources;
import helpers.Calculation;
import helpers.DateHelper;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.CustomerAccountPage;
import pages.CustomerLoginPage;
import pages.HomePage;
import pages.TransactionsPage;

import java.net.MalformedURLException;
import java.net.URL;

public class GlobalsqaTest {
    private WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", Resources.getResource("chromedriver.exe").getPath());
    }

    @BeforeEach
    public void setUpThis() throws MalformedURLException {
        System.out.println("Browser opened");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WIN10);
        capabilities.setBrowserName("chrome");

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Browser closed");
    }

    @Test
    @DisplayName("Тестовое задание")
    public void test() {
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
    }
}
