package astest;

import astest.aboutexcel.AboutExcel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.math.BigDecimal;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 用于练习excel文件导入相关操作
 */
public class ExcelTest {
    @Test
    public void excelfunTest (){
        List<Object> list = AboutExcel.getExcelList("C:\\Users\\AS\\Desktop\\aspagesql\\novels.xlsx",0,0,0,0);
        //AboutExcel.outputListValue(list);
        String path = ".\\src\\test\\testfile\\novels2.xlsx";
        AboutExcel.writeExcel(path,list);
    }
    @Test
    public void testfun() throws IOException, InvalidFormatException {
        String path = ".\\src\\test\\testfile\\novels2.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("ccxs");
        FileOutputStream out = new FileOutputStream(new File(path));
        workbook.write(out);
        workbook.close();
        System.out.println(System.getProperty("user.dir"));

    }
    @Test
    public void test2() throws IOException {
        String filePath = ".\\src\\test\\testfile\\novels2.xlsx";
        // 输出流
        try {
            FileInputStream is = new FileInputStream(filePath);
            Workbook wb = new XSSFWorkbook(is);
            //System.out.println("aaa");
            Sheet sheet1 = wb.getSheetAt(0);//获取第一sheet页
            //System.out.println(sheet1.getLastRowNum());
            Row row = sheet1.getRow(sheet1.getLastRowNum() -2);
            row.setHeightInPoints((short) 25);
            // 给这一行赋值
            row.createCell(0).setCellValue("12");
            row.createCell(1).setCellValue("23");
            FileOutputStream os = new FileOutputStream(filePath);
            wb.write(os);
            is.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


}
