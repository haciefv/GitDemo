package stepDefinition;

import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import pageObjects.*;

import java.io.IOException;
import java.util.List;

public class StepDefinitionImpl extends BaseTest {
    public LandingPage landingPage;
    ProductCatalogue productCatalogue;
    ConfirmationPage confirmationPage;
    @Given("I landed on Ecommerce page")
    public void I_Landed_On_Ecommerce_Page() throws IOException {
        landingPage =launchApplication();
    }
    @Given ("^Logged in with username (.+) and password  (.+)$")
    public void logged_in_with_username_and_password(String username,String password){
         productCatalogue = landingPage.loginApplication(username,password);

    }
    @When("^I add (.+) to Cart$")
    public void i_add_product_to_cart(String productName) throws InterruptedException {
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
    }
    @When("^Checkout (.+) and submit the order$")
    public void checkout_and_submit_the_order(String productName){
        CartPage cartPage = productCatalogue.goToCart();
        Boolean match = cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.cartCheckout();
        checkoutPage.selectCountry();
        confirmationPage = checkoutPage.submitOrder();
    }

    @Then("{string} message is diplayed on Confirmation page")
    public void message_displayed_confirmationPage(String string){
        AssertJUnit.assertEquals(confirmationPage.getConfirmationMessage(), "THANKYOU FOR THE ORDER.");
        driver.close();
    }
    @Then("^\"([^\"]*)\" message is displayed on Confirmation page$")
    public void message_is_displayed_on_confirmation_page(String errorMessage) {
        AssertJUnit.assertEquals(errorMessage,landingPage.getErrorMessage());
        driver.close();
    }


}


C:\Users\Haci\Desktop\MavenLesson\PomLesson.pageobjects