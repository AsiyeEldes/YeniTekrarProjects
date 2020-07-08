package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FHCReservationPage {
    public FHCReservationPage(WebDriver driver){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id = "IDUser")
    public WebElement idUserSelectUser;
    @FindBy(id = "IDHotelRoom")
    public WebElement idUserSelectRoom;
    @FindBy(id = "Price")
    public WebElement price;
    @FindBy(id = "DateStart")
    public WebElement dateStart;

    @FindBy(xpath = "(//tr//td)[25]")
    public WebElement dateStartNumber;

    @FindBy(id = "DateEnd")
    public WebElement dateEnd;

    @FindBy(xpath = "(//tr//td)[25]")
    public WebElement dateEndNumber;

    @FindBy(id = "AdultAmount")
    public WebElement adultAmount;
    @FindBy(id = "ChildrenAmount")
    public WebElement childrenAmount;
    @FindBy(id = "ContactNameSurname")
    public WebElement surname;
    @FindBy(id = "ContactPhone")
    public WebElement phone;
    @FindBy(id = "ContactEmail")
    public WebElement email;
    @FindBy(id = "Notes")
    public WebElement notes;
    @FindBy(id = "Approved")
    public WebElement isApproved;
    @FindBy(id = "IsPaid")
    public WebElement isPaid;
    @FindBy(id = "btnSubmit")
    public WebElement submitButton;
    @FindBy(className = "bootbox-body")
    public WebElement success_message;
    @FindBy(xpath = "//*[@data-bb-handler='ok']")
    public WebElement okButton;

}


