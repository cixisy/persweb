package astest;

import astest.aboutexcel.AboutExcel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import pers.as.pagedb.entity.novel.Novel;

import java.io.*;
import java.math.BigDecimal;
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
        AboutExcel.outputListValue(list);
    }





















    @Test
    public void importByExcel() {
        String pathname = "C:\\Users\\AS\\Desktop\\aspagesql\\novels.xlsx";
        int sheetnum = 0;
        System.out.println(pathname);
        File file = new File(pathname);
        List<Object> list = new ArrayList();
        try {
            InputStream inputStream = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(inputStream);
            //XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(1);
            Sheet sheet = workbook.getSheetAt(sheetnum);
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                List<Object> listcell = new ArrayList();
                if (row == null) {
                    list.add(null);
                    continue;
                }
                for (int j = 0; j < row.getLastCellNum(); j++) {

                    Cell cell = row.getCell(j);
                    listcell.add(getValve(cell));

                }
                list.add(listcell);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        outputListValue(list);

    }

    /**
     * 在控制台打印一个列表
     * @param list 输入为一个list<object>
     */
    public void outputListValue(List<Object> list) {
        // System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            List listcell = (List) list.get(i);
            for (int j = 0; j < listcell.size(); j++) {
                System.out.print(listcell.get(j) + " ");
            }
            System.out.println();
        }
    }

    /**
     * 获取excel 的单元格的值
     * @param cell 传入的excel 的单元格对象
     * @return 返回一个Object对象，String,Bollean,Numeric,
     */
    public Object getValve(Cell cell) {
        if (cell == null)
            return null;
        Object value = null;
        switch (cell.getCellType()) {
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case STRING:
                value = cell.getStringCellValue();
                break;
            case NUMERIC:
                value = new BigDecimal(cell.getNumericCellValue()) ;
            case FORMULA:
                switch (cell.getCachedFormulaResultType()){
                    case NUMERIC:
                        value = cell.getNumericCellValue();
                        break;
                    case STRING:
                        value = cell.getRichStringCellValue();
                    default:
                        value = cell.toString();
                        break;
                }
                break;
            default:
                value = cell.toString();
                break;
        }
        return value;
    }

    /**
     * 将一个一维或二维的list列表输出到一个Excel中
     * @param list 输入的List
     */
    public void outputExcel(List<Object> list){

    }

}
