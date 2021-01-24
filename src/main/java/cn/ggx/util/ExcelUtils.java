package cn.ggx.util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    /**
     *
     * @param titles Excel第一行列表抬头
     * @param fields 属性
     * @param dataList 明细数据 List<Map<属性,值>>
     * @param suffix 后缀名
     * @param fileName 文件名
     * @throws IOException
     */
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
                String value = dataLists.get(i).get(fields[j]);
                dataRowCell.setCellValue(value);
            }

        }
        workbook.write(new FileOutputStream("D:\\桌面\\" + fileName + ".xlsx"));
        workbook.close();
    }
}

