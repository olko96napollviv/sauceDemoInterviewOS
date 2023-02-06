package sauceDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sauceDemo.utils.CommonMethods;

import java.util.List;

public class CheckoutPage extends CommonMethods {

    @FindBy(css = ".title")
    public static WebElement CheckoutTitle;

    @FindBy(css = "#first-name")
    public static WebElement FirtNameField;

    @FindBy(css = "#last-name")
    public static WebElement LastNameField;

    @FindBy(css = "#postal-code")
    public static WebElement PostalCodeField;

    @FindBy(css = "#continue")
    public static WebElement Continue;

    @FindBy(css = "#finish")
    public static WebElement Finish;

    @FindBy(css = ".complete-header")
    public static WebElement SuccessfulMessage;

    @FindBy(xpath = "//h3[@data-test='error']")
    public static WebElement PersonalInfoError;

    public void yourInfo(String firstName, String lastName, String zipCode) {
        sendText(FirtNameField, firstName);
        sendText(LastNameField, lastName);
        sendText(PostalCodeField, zipCode);
    }

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }


}
