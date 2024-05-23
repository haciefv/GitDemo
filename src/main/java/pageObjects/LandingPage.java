package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
//    public static Object loginApplication;
    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //Page Factory
    @FindBy(id = "userEmail")
    WebElement userEmailEle;

    @FindBy(id = "userPassword")
    WebElement passwordEle;
    @FindBy(id = "login")
    WebElement submitEle;
    @FindBy (css = "div[aria-label='Incorrect email or password.']")
    WebElement warningMessage;

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }
    public String getErrorMessage(){
        waitForElementToAppear(warningMessage);
        String errorMessageText =  warningMessage.getText();
        return errorMessageText;

    }
    public ProductCatalogue loginApplication(String email,String password){
        userEmailEle.sendKeys(email);
        passwordEle.sendKeys(password);
        submitEle.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;
    }


}
