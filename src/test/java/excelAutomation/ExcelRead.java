package excelAutomation;


import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelRead {
    @Test
    public void ExcelReadFile() throws IOException {
        /*
        bu bir excel ornegi=
         MEYVE	SEBZE	TATLI	KAHVALTI
        1elma	domates	tramisu	tost
        2armut	biber	trilice	peynir
        3erik	patlicankadayif	kizartma
        4cilek	kabak	kazandibibal
        5seftalilahana	baklava	kaymak
        6avakadofasulye	sufle	peynir
        7mango	bamya	tulumba	recel
        8muz	bezelye	profitrolcikolata

         */
        /*
        https://mvnrepository.com den dependencyi al
        (Apache POI is the Java API to access microsoft offices.
        Poi.apache.com -> the official documentation is there ) al
        ve pomxml e ekle
        */
        /*
        <dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi</artifactId>
        <version>4.1.2</version>
    </dependency>
         */

        //Excel dosyasinin pathini verelim
        String pathFile = "C:\\Users\\user\\Documents\\Book1.xlsx";

        //dosyayi acalim
        FileInputStream fileInput = new FileInputStream(pathFile);


        //Dosya okumayi WorkbookFactory yapiyor
        Workbook workbook = WorkbookFactory.create(fileInput);

        //dosyanin ilk sayfa nosunu verir.
        Sheet sheet = workbook.getSheetAt(0);

        //java da  indexler 0 dan baslar
        //Bu method ise normal insana gore 1 den baslayan index e gore gorur.
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        System.out.println(physicalNumberOfRows);

        //ilk sayfanin ilk satirini verir
        Row row = sheet.getRow(0);



        //ilk satirin ilk verisini verir
        Cell cellFirst = row.getCell(0);
        System.out.println(cellFirst);


        //method zinciri seklinde de yazabiliriz
        String data = workbook.getSheetAt(0).getRow(1).getCell(0).toString();
        System.out.println(data);

        //son satir numarasini nasil alirsiniz
        int lastRowNum = sheet.getLastRowNum();
        System.out.println(lastRowNum);

        //satir sayisini nasil alirsiniz
        int rowCount =sheet.getPhysicalNumberOfRows();
        System.out.println(rowCount);

        //(3,2)
        Map<String,String> excelVeri=new HashMap<String,String>();
        int meyveColumn=0;
        int tatlicolumn=1;

        for(rowCount=1;rowCount<=lastRowNum;rowCount++){

            String s1 = sheet.getRow(rowCount).getCell(meyveColumn).toString();
            System.out.println("S1="+ s1);

            String s2=sheet.getRow(rowCount).getCell(tatlicolumn).toString();
            System.out.println("S2="+ s2);

            System.out.println("***************");
            excelVeri.put(s1, s2);
        }

        System.out.println("#######");
        System.out.println(excelVeri);
        printData(3,2);


        //dosyalari  kapatalim
        fileInput.close();
        workbook.close();
    }

      public void  printData(int rowIndex, int cellIndex) {
          System.out.println("bisey");
      }
}
