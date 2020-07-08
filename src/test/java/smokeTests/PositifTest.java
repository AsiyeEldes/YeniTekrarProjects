package smokeTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FhcLoginPage;

import utilities.ConfigReader;
import utilities.Driver;

public class PositifTest {

    @Test
    public void fhcLoginTest(){

        FhcLoginPage fhcLoginPage=new FhcLoginPage(Driver.getDriver());

        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));

        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("valid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("valid_password"));
        fhcLoginPage.submitButton.click();



    }
}



