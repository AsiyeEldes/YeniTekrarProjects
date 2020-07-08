package excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {
    @Test
    public void writeExcel() throws IOException {
        //Excel dosyasinin pathini verelim
        String pathFile = "C:\\Users\\user\\Downloads\\Book1.xlsx";
        //java dis kaynaktan VERI okurken FileInputStream( kullanir
        //dosyayi acalim
        FileInputStream file = new FileInputStream(pathFile);



        //Dosya okumayi WorkbookFactory yapiyor
        Workbook workbook = WorkbookFactory.create(file);

        //dosyanin ilk sayfasini verir.
        Sheet sheet = workbook.getSheetAt(0);

        //ilk sayfanin ilk satirini verir
        Row row = sheet.getRow(0);

        //yeni cell olusturur SUTUN Olusturur
        Cell rowCell = row.createCell(4);
        //yeni cell e veri koyar
        rowCell.setCellValue("Pankek");

        //cell siler
        row.removeCell(row.getCell(1));

        //java programindan dis kaynaga VERI gonderilirken FileOutputStream( kullanir
        FileOutputStream fileOutputStream = new FileOutputStream(pathFile);


        workbook.write(fileOutputStream);

        fileOutputStream.close();
        file.close();
        workbook.close();
    }

}
