package sauceDemo.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sauceDemo.utils.CommonMethods;

import java.util.List;

public class ProductsPage extends CommonMethods {

    @FindBy(xpath = "//span[@class = 'title']")
    public static WebElement ProductsTitle;

    @FindBy(css = ".shopping_cart_link")
    public static WebElement ShoppingCart;


    @FindBy(xpath = "//div[@class = 'inventory_item_name']")
    public static List<WebElement> ProductName;

    @FindBy(css = "#checkout")
    public static WebElement Checkout;

    private static int count;

    public static void findProductAndClick(String nameOfProduct, List<WebElement> elements) {
        for (int i = 0; i < elements.size(); i++) {
            int num = i + 1;
            if (elements.get(i).getText().equalsIgnoreCase(nameOfProduct)) {
                String productCustomXpath = "(" + "//button[@class = 'btn btn_primary btn_small btn_inventory']" + ")" + "[" + num + "]";
                driver.findElement(By.xpath(productCustomXpath)).click();
                count++;
                break;
            }
        }
    }

    public static void verifyProductsWereAdded(String nameOfProduct, List<WebElement> elements) {
        for (int i = 0; i > elements.size() - 1; i++) {
            String actual = elements.get(i).getText();
            String expected = nameOfProduct;
            if (elements.size() == count) {
                Assert.assertTrue(actual.equalsIgnoreCase(expected));
                break;
            }
        }
    }

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }
}
