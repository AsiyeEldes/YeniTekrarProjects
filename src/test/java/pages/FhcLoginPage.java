package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.getDriver;
    //pages package de her pencere icin(sayfa)ayri class olusturulur
    //her page icin de ayri test class i olusturulur.
    //utilities package ortak kullanilir
    //Driver tektir yani singleton dur
public class FhcLoginPage {
        WebDriver driver;

        //bu sinifta test siniflarinda kullanacagimiz WebElementlerin bulunmus locatorlari vardir
        //(driver,this)...driver internete baglansin diye yazdik...
        // this kelimesini de bu sinifa yazilan web elementleri initialize et demek(@FindBy ile yazilan)
        public FhcLoginPage(WebDriver driver) {
            PageFactory.initElements(driver,this);//sayfanin instance driveridir.this ile sayfa instance edilmis
        }

        //page objects
        @FindBy(id = "UserName")
        public WebElement username;
        @FindBy(id="Password")
        public  WebElement password;
        @FindBy(id = "btnSubmit")
        public WebElement submitButton;
        @FindBy(xpath = "//div[@id='divMessageResult']")
        public WebElement error_message;

        //creating a log in method
        public void login(String user, String pass) {
            //login("manager2","Manager2!");==> user=manager2,pass=Manager2!
            //login("asdga","asdga");==>user="asdga" , pass="asdga"
            username.sendKeys(user);
            password.sendKeys(pass);
            submitButton.click();

        }
    }

