package astest.aboutexcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AboutExcel {

    /**
     * 根据sheet页、开始行号、开始列号获取excel中所有单元格的值
     * @param path excel路径
     * @param sheetnum sheet页页码
     * @param startrow 开始行号
     * @param startcol 开始列号
     * @param offsetnum 读取excel行的偏移量，偏移量为0时加载所有行
     * @return 返回一个二位list对象
     */
    public static List<Object> getExcelList(String path,int sheetnum,int startrow,int startcol,int offsetnum){
        //初始化文件和结果表
        File file = new File(path);
        List<Object> list = new ArrayList<>();
        try {
            //获取输入流
            InputStream inputStream = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(sheetnum);
            //列表值获取
            for(int i = startrow;i <= sheet.getLastRowNum();i++){
                //超出读取范围（开始行号+偏移量）
                if(offsetnum!=0&&i>=startrow+offsetnum){
                    break;
                }
                Row row = sheet.getRow(i);//获取每一行的值
                List<Object> rowlist = new ArrayList<>();
                if(row == null){
                    list.add(null);
                    continue;
                }
                for(int j = startcol;j < row.getLastCellNum();j++){
                    Cell cell = row.getCell(j);
                    rowlist.add(getCellValue(cell));
                }
                list.add(rowlist);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return list;
    }

    /**
     * 获取单元格的值，单元格类型不同返回值不同。
     * @param cell
     * @return Object对象
     */
    private static Object getCellValue(Cell cell) {
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
     * 在控制台打印一个列表
     * @param list 输入为一个list<object>
     */
    public static void outputListValue(List<Object> list) {
        // System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            List listcell = (List) list.get(i);
            for (int j = 0; j < listcell.size(); j++) {
                System.out.print(listcell.get(j) + " ");
            }
            System.out.println();
        }
    }


}
