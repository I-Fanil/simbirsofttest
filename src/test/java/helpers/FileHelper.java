package helpers;

import com.opencsv.CSVWriter;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    @Step("Формирование файла формата csv")
    @Attachment
    public static byte[] writeCSVFile(String filePath, List<String[]> data) {
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
        byte[] bytes = new byte[(int) file.length()];
        try(FileInputStream fis = new FileInputStream(file)) {
            fis.read(bytes);
            return bytes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
