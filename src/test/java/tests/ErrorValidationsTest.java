package tests;

import TestComponents.BaseTest;
import TestComponents.Retry;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.ProductCatalogue;

import java.io.IOException;
import java.util.List;

public class ErrorValidationsTest extends BaseTest {

    @Test(groups = "ErrorHandling",retryAnalyzer = Retry.class)
    public void loginErrorValidation() throws IOException, InterruptedException {
//        ProductCatalogue productCatalogue = landingPage.loginApplication("haciefv@gmail.com", "Hci9509");
//        Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");
         landingPage.loginApplication("haciefv@gmail.com", "Haci95091");
        AssertJUnit.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
    }

    @Test
    public void     ProductErrorValidation() throws IOException, InterruptedException {
        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("haciefv@gmail.com", "Haci9509");
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCart();
        Boolean match = cartPage.verifyProductDisplay("ZARA COAT 3");
        AssertJUnit.assertTrue(match);
    }
}
