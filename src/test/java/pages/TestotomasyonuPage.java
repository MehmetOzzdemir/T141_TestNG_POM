package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestotomasyonuPage {

    //Her page classinda kullanilacak driver objesi class a tanitilmalidir
    //Bunun icin constructor'i gorunur hale getirip
    //constructor icinde driver i class a tanimlariz

    public TestotomasyonuPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id = "global-search")
    public WebElement searchBox;

    @FindBy(className = "product-count-text")
    public WebElement searchElement;
}
