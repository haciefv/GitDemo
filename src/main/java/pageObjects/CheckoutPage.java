package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
    WebDriver driver;
    public CheckoutPage(WebDriver driver) {

        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "input[placeholder='Select Country']")
    WebElement countrySelector;
    @FindBy(xpath = "//span[normalize-space()='Azerbaijan']")
    WebElement country;

    @FindBy(xpath = "//a[normalize-space()='Place Order']")
    WebElement placeOrderButton;
    public void selectCountry(){

        countrySelector.sendKeys("Az");
        country.click();
    }
    public ConfirmationPage submitOrder(){

        placeOrderButton.click();
        return new ConfirmationPage(driver);
    }

}
