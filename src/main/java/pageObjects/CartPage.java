package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractComponent;

import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;
    public CartPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".cartSection h3")
    private List<WebElement> productTitles;
    @FindBy(css = "li[class='totalRow'] button[type='button']")
    WebElement checkoutButton;
    @FindBy(css = "input[placeholder='Select Country']")
    WebElement countryInput;
    public Boolean verifyProductDisplay(String productName){
        Boolean match = productTitles.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
        return match;
    } ;

    public CheckoutPage cartCheckout(){
        checkoutButton.click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }




}
