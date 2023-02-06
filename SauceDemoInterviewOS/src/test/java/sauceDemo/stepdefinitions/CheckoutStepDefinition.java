package sauceDemo.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import sauceDemo.pages.CheckoutPage;
import sauceDemo.pages.ProductsPage;
import sauceDemo.utils.CommonMethods;

import java.util.List;

public class CheckoutStepDefinition extends CommonMethods {
    @When("I add products to the shopping cart and verify they were added successfully")
    public void i_add_products_to_the_shopping_cart_and_verify_they_were_added_successfully(DataTable products){
        List<String> productsNames = products.asList();
        for (String prodName : productsNames
        ) {
            ProductsPage.findProductAndClick(prodName, ProductsPage.ProductName);
        }
        ProductsPage.ShoppingCart.click();
        for (String prodName : productsNames
        ) {
            ProductsPage.verifyProductsWereAdded(prodName, ProductsPage.ProductName);
        }
    }

    @When("I click checkout")
    public void i_click_checkout() {
        ProductsPage.Checkout.click();
    }

    @Then("I should be taken to Complete Checkout Page")
    public void i_should_be_taken_to_Complete_Checkout_Page() {
        Assert.assertTrue(CheckoutPage.CheckoutTitle.isDisplayed());
        checkoutPage.yourInfo("Alec", "Jobster", "22304");
        CheckoutPage.Continue.click();
    }

    @Then("I should be taken to enter personal info")
    public void i_should_be_taken_to_enter_personal_info() {
        Assert.assertTrue(CheckoutPage.CheckoutTitle.isDisplayed());
        CheckoutPage.Continue.click();
    }

    @Then("Verify Error Message Displayed")
    public void Verify_Error_Message_Displayed() {
        Assert.assertEquals("Verifying error message", "Error: First Name is required", CheckoutPage.PersonalInfoError.getText());
    }

    @Then("Successful Message Displayed")
    public void Successful_Message_Displayed() {
        CheckoutPage.Finish.click();
        CheckoutPage.SuccessfulMessage.isDisplayed();
    }


}
