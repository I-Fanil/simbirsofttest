import com.google.common.io.Resources;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CustomerLoginPage;
//import org.junit.jupiter.api.parallel.Resources;

public class GlobalsqaTest {

    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", Resources.getResource("chromedriver.exe").getPath());

        WebDriver driver = new ChromeDriver();

        new CustomerLoginPage(driver)
                .loginAs("Harry Potter");

//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        driver.close();
    }
}
