package helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableHelper {
    @Step("Получение данных из таблицы транзакций")
    public static List<String[]> getTableData(WebElement table) {
        List<String[]> data = new ArrayList<String[]>();
        List<WebElement> rowsList = table.findElements(By.cssSelector("tbody tr"));
        List<WebElement> columnsList = null;
        for (WebElement row : rowsList) {
            columnsList = row.findElements(By.tagName("td"));
            String[] rowsData = new String[columnsList.size()];
            for (int i = 0; i < columnsList.size(); i++) {
                rowsData[i] = columnsList.get(i).getText();
            }
            data.add(rowsData);
        }
        return data;
    }
}
