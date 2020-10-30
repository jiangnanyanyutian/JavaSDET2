package app.testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    public static Object[][] getexceldata(String filepath, String filename, String sheetname,int Column) throws IOException {
        File file = new File(filepath + "\\" + filename);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;
        String fileextensionname = filename.substring(filename.indexOf("."));
        int Columnum = Column;  //此处是有值得列数，不能包含空列；

        // System.out.println(fileextensionname);
        if (fileextensionname.equals(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);

        } else if (fileextensionname.equals(".xls")) {
            workbook = new HSSFWorkbook(inputStream);

        }

        Sheet sheet = workbook.getSheet(sheetname);
        int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        ArrayList<Object[]> records = new ArrayList<Object[]>();
        /// 去掉表头，从excel表中第二行开始读取

        for (int i = 1; i < rowcount + 1; i++) {
            Row row = sheet.getRow(i);
            // String fields[] = new String[row.getLastCellNum()];

            String fields[] = new String[Columnum];

            for (int j = 1; j < (Columnum+1); j++) {
                fields[j - 1] = row.getCell(j).getStringCellValue(); // 将每行中读取的列值放到数组中

            }
            records.add(fields);
        }
        Object[][] results = new Object[records.size()][];
        for (int i = 0; i < records.size(); i++) {
            results[i] = records.get(i);
        }
        return results;
    }

}
