package sauceDemo.pages;

import sauceDemo.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {

    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginBtn;

    @FindBy(css = "div.error-message-container.error")
    public WebElement errorMsg;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        sendText(usernameBox, username);
        sendText(passwordBox, password);
    }

    public void clickOnLoginBtn() {
        click(loginBtn);
    }

    public String getErrorMessageText() {
        return errorMsg.getText();
    }
}
