package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractComponent {
    WebDriver driver;
    public OrderPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "tr td:nth-child(3)")
    private List<WebElement> productTitles;
    @FindBy(css = "li[class='totalRow'] button[type='button']")
    WebElement checkoutButton;
    @FindBy(css = "input[placeholder='Select Country']")
    WebElement countryInput;
    public Boolean verifyOrderDisplay(String productName){
        Boolean match = productTitles.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
        return match;
    } ;

    public CheckoutPage cartCheckout(){
        checkoutButton.click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }




}
