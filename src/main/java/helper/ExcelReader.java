package helper;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ExcelReader {

    public static Object[][] readExcelFile(File file) throws IOException {

        FileInputStream fileInput = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInput);

        Sheet sheet = workbook.getSheetAt(0);


        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        String[][] data = new String[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {

            Row row = sheet.getRow(i + 1);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                data[i][j] = row.getCell(j).getStringCellValue();

            }
        }
        return data;


    }
}










