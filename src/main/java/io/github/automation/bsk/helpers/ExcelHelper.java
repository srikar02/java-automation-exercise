package io.github.automation.bsk.helpers;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelHelper {

    public static List<Object[]> excelDataAsListOfObjects(String spreadSheet, String sheet) throws IOException, InvalidFormatException {

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new File(spreadSheet));
        DataFormatter dataFormatter = new DataFormatter();
        XSSFSheet selectedSheet = xssfWorkbook.getSheet(sheet);
        xssfWorkbook.close();

        List<String> columnList = new ArrayList<>();
        List<Object[]> rowList = new ArrayList<>();

        for(Row row:selectedSheet){
            for(Cell cell:row){
                columnList.add(dataFormatter.formatCellValue(cell));
            }
            String[] columnArray = new String[columnList.size()];
            columnArray = columnList.toArray(columnArray);
            rowList.add(columnArray);
            columnList.clear();
        }

        //Remove header row
        rowList.remove(0);
        return rowList;
    }


    public static List<Object[]> excelDataAsListofMaps(String spreadSheet, String sheet) throws IOException, InvalidFormatException {

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new File(spreadSheet));
        DataFormatter dataFormatter = new DataFormatter();
        XSSFSheet selectedSheet = xssfWorkbook.getSheet(sheet);
        xssfWorkbook.close();

        List<Object[]> rowList = new ArrayList<>();
        List<Map<String,String>> rowAsListofMappedValues = new ArrayList<>();

        for(Row row:selectedSheet){
            Map<String,String> rowColumnMap = new LinkedHashMap<>();
            for(Cell cell:row){
                rowColumnMap.put(selectedSheet.getRow(0).getCell(cell.getColumnIndex()).toString(),dataFormatter.formatCellValue(cell));
            }
            //System.out.println(rowColumnMap);
            rowAsListofMappedValues.add(rowColumnMap);
        }
        //System.out.println(rowAsListofMappedValues);
        for(Map<String,String> mappedValues:rowAsListofMappedValues){
            rowList.add(new Object[]{mappedValues});
        }
        //Remove header row
        rowList.remove(0);
        return rowList;
    }

}
