package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class WebAppPage {

    public WebAppPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='signin_button']")
    public WebElement signinButton;

    @FindBy(xpath = "//*[@id='user_login']")
    public WebElement loginBox;

    @FindBy(xpath = "//*[@id='user_password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@name='submit']")
    public WebElement signinBox;

    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBankingLink;

    @FindBy(xpath = "//li[@id='onlineBankingMenu']")
    public WebElement onlineBankingMenu;

    @FindBy(xpath = "//span[text()='Pay Bills']")
    public WebElement payBillsLink;

    @FindBy(xpath = "//*[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrencyLink;

    @FindBy(xpath = "//*[@name='currency']")
    public WebElement currencyDropdown;
}
