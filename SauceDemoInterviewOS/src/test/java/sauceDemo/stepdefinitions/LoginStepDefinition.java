package sauceDemo.stepdefinitions;

import sauceDemo.pages.ProductsPage;
import sauceDemo.utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition extends CommonMethods {

    @Given("navigate to SauceDemo login page")
    public void navigate_to_hrms_login_page() {
        setUp();
    }

    @When("enter valid {string} and {string}")
    public void enter_valid_and(String login, String password) {
        loginPage.login(login, password);
    }

    @When("click on login button")
    public void click_on_login_button() {
        loginPage.clickOnLoginBtn();
    }

    @When("enter valid credentials")
    public void enter_valid_credentials() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("verify products title is displayed")
    public void verify_products_title_is_displayed() {
        Assert.assertTrue(ProductsPage.ProductsTitle.isDisplayed());
    }

    @Then("quit the browser")
    public void quit_the_browser() {
        tearDown();
    }

    @When("enter invalid credentials")
    public void enter_invalid_credentials() {
        loginPage.login("Admin343", "InvalidPass");
    }

    @Then("verify error message")
    public void verify_error_message() {
        Assert.assertEquals("Verifying error message", "Epic sadface: Username and password do not match any user in this service", loginPage.getErrorMessageText());
    }

}
