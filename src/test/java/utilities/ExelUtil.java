package utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Bu exel sinifini exel dosyalari okumak icin(xls,xlsx..)kullanabiliriz
//tekrar tekrar kullanabiliriz
public class ExelUtil {
    private Workbook workBook;
    private Sheet workSheet;
    private String path;

    public void ExcelUtil(String path, String sheetName) {//Bu Constructor excel file ni acar ve giris yapar
        this.path = path;
        try {
            //  Excel file aciyoruz
            FileInputStream fileInputStream = new FileInputStream(path);
            //  workbook a giris yapiyoruz
            workBook = WorkbookFactory.create(fileInputStream);
            //sayfayi aliyoruz
            workSheet = workBook.getSheet(sheetName);
            //Sayfada veri var mi yok mu dogreuluyoruz
            Assert.assertNotNull(workSheet, "Worksheet: \"" + sheetName + "\" was not found\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //===============Belirli bir satirdaki sutun sayisini alma=================
    public int columnCount() {
        //satir 1 de kac sayi aliriz.belirli sutunu temsil eden hucreyi alir
        return workSheet.getRow(0).getLastCellNum();
    }
    //===============son satir nosunu nasil aliriz.index  0 dan baslar====================
    public int rowCount() {
        return workSheet.getLastRowNum() + 1; }//Gercek sayiyi elde etmek icin 1 ekleme

    //==============Satir ve sutun sayisi girdiginizde veriyi/datayi alma==========
    public String getCellData(int rowNum, int colNum) {
        Cell cell;
        try {
            cell = workSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //============tum datalari  two dimentional array e eklemek and return etmek icin===
    public String[][] getDataArray() {
        String[][] data = new String[rowCount()][columnCount()];
        for (int i = 0; i < rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);
                data[i][j] = value;
            }
        }
        return data;
    }
    //bu excel dosyasindaki verilerin listesini alacak
    //Bu bir map listesidir
    //Bu verileri String olarak alir.Bir Map string olarak dondurur
    public List<Map<String, String>> getDataList() {

        // butun satirlari alir
        List<String> columns = getColumnsNames();
        // method bunu dondurecek
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();

        for (int i = 1; i < rowCount(); i++) {
            // diger satiri alir
            Row row = workSheet.getRow(i);
            // Sutun and value/deger kullanarak satirin Map listesini olusturma
            // key=column, value=cell
            Map<String, String> rowMap = new HashMap<String, String>();
            for (Cell cell : row) {
                int columnIndex = cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex), cell.toString());
            }
            data.add(rowMap);
        }

        return data;
    }
    //==============ilk satira git ve satiri tek tek oku==================//
    public List<String> getColumnsNames() {
        List<String> columns = new ArrayList<String>();
        for (Cell cell : workSheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }

    //=========Satir ve sutun sayisi girdiginde value dondurur===============//
    public void setCellData(String value, int rowNum, int colNum) {
        Cell cell;
        Row row;
        try {
            row = workSheet.getRow(rowNum);
            cell = row.getCell(colNum);
            if (cell == null) {//if there is no value, create a cell.
                cell = row.createCell(colNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workBook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCellData(String value, String columnName, int row) {
        int column = getColumnsNames().indexOf(columnName);
        setCellData(value, row, column);
    }

}


