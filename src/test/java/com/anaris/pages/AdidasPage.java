package com.anaris.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdidasPage extends BasePage {

    @FindBy(xpath = "//a[.='Laptops']")
    public WebElement laptopsButton;

    @FindBy(xpath = "//a[.='Sony vaio i5']")
    public WebElement sonyi5Button;

    @FindBy(xpath = "//a[@href='prod.html?idp_=12']")
    public WebElement delli78GbButton;

    @FindBy(css = "a[class='btn btn-success btn-lg']")
    public WebElement addToCartButton;

    @FindBy(css = "div[id='navbarExample']>ul>li>a")
    public WebElement homeButton;

    @FindBy(css = "a#cartur")
    public WebElement cartButton;

    @FindBy(xpath = "//a[.='Delete']")
    public List<WebElement> deleteProduct;

    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeOrderButton;

    @FindBy(css = "input#name")
    public WebElement inputName;

    @FindBy(css = "input#country")
    public WebElement inputCountry;

    @FindBy(css = "input#city")
    public WebElement inputCity;

    @FindBy(css = "input#card")
    public WebElement inputCard;

    @FindBy(css = "input#month")
    public WebElement inputMonth;

    @FindBy(css = "input#year")
    public WebElement inputYear;

    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchaseButton;

    @FindBy(xpath = "//body/div[9]/p/text()[1]")
    public WebElement purchaseID;

    @FindBy(xpath = "//p[@style='display: block;']")
    public WebElement amount;

    @FindBy(css = "button[class='confirm btn btn-lg btn-primary']")
    public WebElement confirmButton;

    @FindBy(xpath = "//tr[@class='success']")
    public List<WebElement> productsInCart;

    public void deleteProduct() {
        for (int i = 0; i < productsInCart.size(); i++) {
            if (productsInCart.get(i).getText().contains("Dell i7 8gb")) {
                deleteProduct.get(i).click();
            }
        }
    }

    public void idAndAmount() {
        if (amount.getText().contains("Amount") && amount.getText().contains("Id")) {
            System.out.println(amount.getText());
        } else {
            System.out.println("FAILED");
        }
    }


}
