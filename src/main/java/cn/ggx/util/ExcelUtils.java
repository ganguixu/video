package cn.ggx.util;

import com.alibaba.druid.sql.visitor.functions.Lcase;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    public static void createExcel(String[] titles, String[] fields, List<Map<String, String>> dataList, String suffix, String fileName) throws IOException {
        if (suffix == null || "xlsx".equals(suffix)) {
            createXlsxExcel(titles, fields, dataList, fileName);
        } else {
            //后缀为xls
        }
    }

    private static void createXlsxExcel(String[] titles, String[] fields, List<Map<String, String>> dataLists, String fileName) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow titleRow = sheet.createRow(0);
        for (int i = 0; i < titles.length; i++) {
            XSSFCell titleRowCell = titleRow.createCell(i);
            titleRowCell.setCellValue(titles[i]);
        }
        for (int i = 0; i < dataLists.size(); i++) {
            XSSFRow dataRow = sheet.createRow(i + 1);
            for (int j = 0; j < fields.length; j++) {
                XSSFCell dataRowCell = dataRow.createCell(j);
                Object obj = dataLists.get(i).get(fields[j]);
                Class clazz = obj.getClass();
                if (clazz == String.class) {
                    dataRowCell.setCellValue((String) obj);
                } else if (clazz == Integer.class || clazz == int.class) {
                    dataRowCell.setCellValue((Integer) obj);
                } else if (clazz == boolean.class) {
                    dataRowCell.setCellValue((Boolean) obj);
                } else {
                    //抛一个异常
                }
            }

        }
        workbook.write(new FileOutputStream("D:\\桌面\\" + fileName + ".xlsx"));
        workbook.close();
    }
}
