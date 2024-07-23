package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestotomasyonuPage {

    //Her page classinda kullanilacak driver objesi class a tanitilmalidir
    //Bunun icin constructor'i gorunur hale getirip
    //constructor icinde driver i class a tanimlariz

    public TestotomasyonuPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    //WebElement aramakutusu = Driver.getDriver().findElement(By.id("global-search"));
    //List<WebElement> resultElementList =Driver.getDriver().findElements(By.className("prod-img"));

    @FindBy(id = "global-search")
    public WebElement searchBox;

    @FindBy(className = "product-count-text")
    public WebElement searchElement;

    @FindBy(className = "prod-img")
    public List<WebElement> resultElementList;
}
