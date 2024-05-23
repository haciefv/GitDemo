package AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CartPage;
import pageObjects.OrderPage;

import java.time.Duration;

public class AbstractComponent {
    WebDriver driver;
    @FindBy (css = "[routerlink*='cart']")
    WebElement cartButton;

    @FindBy (css = ".btn.btn-custom[routerlink='/dashboard/myorders']")
    WebElement ordersButton;
    public AbstractComponent(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver,this);

    }

    public  void waitForElementToAppear(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public  void waitForElementToAppear(WebElement findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }
    public void waitForElemntToDisapear(WebElement eles) throws InterruptedException {
        Thread.sleep(1000);
    }

    public CartPage goToCart(){
        cartButton.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
    public OrderPage goToOrders(){
        ordersButton.click();
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;
    }



}
