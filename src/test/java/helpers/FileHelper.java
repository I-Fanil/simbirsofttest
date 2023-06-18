package helpers;

import com.opencsv.CSVWriter;
import io.qameta.allure.Step;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    @Step("Формирование файла формата csv")
    public static void writeCSVFile(String filePath, List<String[]> data) {
        File file = new File(filePath);
        try {
            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile, ' ',
                    CSVWriter.NO_QUOTE_CHARACTER, '\u0000',
                    CSVWriter.DEFAULT_LINE_END);
            writer.writeAll(data);

            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
