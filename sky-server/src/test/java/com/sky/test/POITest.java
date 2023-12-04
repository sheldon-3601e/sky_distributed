package com.sky.test;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

/**
 * @ClassName POITest
 * @Author 26483
 * @Date 2023/11/26 15:25
 * @Version 1.0
 * @Description POI操作excel
 */
//@SpringBootTest
public class POITest {
    public static void main(String[] args) throws IOException {
        //write();
        read();
    }

    public static void write() throws IOException {
        XSSFWorkbook excel = new XSSFWorkbook();
        XSSFSheet info = excel.createSheet("info");
        XSSFRow row = info.createRow(0);
        row.createCell(1).setCellValue("name");
        row.createCell(2).setCellValue("pwd");

        row = info.createRow(1);
        row.createCell(1).setCellValue("jake");
        row.createCell(2).setCellValue("123");

        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\Code\\Test\\info.xlsx"));
        excel.write(fileOutputStream);

        fileOutputStream.close();
        excel.close();
    }

    public static void read() throws IOException {

        FileInputStream in = new FileInputStream(new File("D:\\Code\\Test\\info.xlsx"));
        XSSFWorkbook excel = new XSSFWorkbook(in);

        XSSFSheet sheet = excel.getSheet("info");
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <= lastRowNum; i++) {
            XSSFRow row = sheet.getRow(i);
            String cellValue1 = row.getCell(1).getStringCellValue();
            String cellValue2 = row.getCell(2).getStringCellValue();
            System.out.println(cellValue1 +" "+cellValue2);
        }

        in.close();
        excel.close();

    }
}
