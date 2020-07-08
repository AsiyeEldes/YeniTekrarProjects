package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //Bu sinifin amaci configuration.properties file ndaki datalari yani verileri okumaktir
    //Properties instance olusturulur
    private static Properties properties;


    //Bu File/dosyadaki properties yani ozellikleri yukluyoruz
    //Sonra properties FILE i okuyoruz
    //static block to initialize ediyoruz/baslangic olarak
    //ilk static bolk calisir
    //static olmasinin sebebi obje olusturmaya gerek kalmadan kullanmak
    static {
        /*
        Bir dosya okuyacaksam once dosya yolum olmali
        configuration.properties dosya yoluna gel-->sag tikla copy ye gel -->copy path tikla--->absolute path=Butun dosya yolunu verir
        -->path=Ayni projedeyse daha kisa dosya yolunu verir
         */
        String path = "configuration.properties";

        try {
            //FileInputStream kullanarak file yani dosya aciyoruz.obje olusturmam lazim,Try catch ile de handle etmem lazim
            FileInputStream file=new FileInputStream(path);//configuration.properties dosyasini aciyoruz
            properties=new Properties();// Dosyayi okumak icin Properties ile obje olustur
            properties.load(file);//dosyada okuyacagimiz seyleri yuklemis oluyoruz
            file.close();//dosyayi kapatiyoruz
        } catch (Exception e) {
            //System.out.println("Path is not found");
            e.printStackTrace();
        }
    }
    //okumak icin static method olusturuyoruz
    //bu     method kullanici key girdiginde  value return edecek,dondurecek,getirecek,

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

//    public static void main(String[] args) {
//        System.out.println(properties.getProperty("fhc_login_url"));
//        //fhc_login_url   ===>   http://www.fhctrip.com/Account/Logon
//    }

}

