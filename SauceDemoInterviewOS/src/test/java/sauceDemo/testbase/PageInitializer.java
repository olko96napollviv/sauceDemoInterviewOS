package sauceDemo.testbase;

import sauceDemo.pages.*;

public class PageInitializer extends BaseClass{

    public static LoginPage loginPage;
    public static ProductsPage productsPage;
    public static CheckoutPage checkoutPage;


    public static void initializePageObjects() {
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        checkoutPage = new CheckoutPage();


    }
}
