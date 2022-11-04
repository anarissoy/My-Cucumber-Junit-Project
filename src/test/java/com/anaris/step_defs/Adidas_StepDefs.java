package com.anaris.step_defs;

import com.anaris.pages.AdidasPage;
import com.anaris.utilities.BrowserUtils;
import com.anaris.utilities.ConfigurationReader;
import com.anaris.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Adidas_StepDefs {

    AdidasPage adidasPage = new AdidasPage();
    Faker faker = new Faker();

    @Given("user is on the main page")
    public void user_is_on_the_main_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("adidas.url"));
    }

    @When("user select Sony vaio i5 from laptop category, add to cart and accept pop up confirmation")
    public void user_select_sony_vaio_i5_from_laptop_category_add_to_cart_and_accept_pop_up_confirmation() {
        BrowserUtils.waitFor(1);
        adidasPage.laptopsButton.click();
        BrowserUtils.sleep(1);
        adidasPage.sonyi5Button.click();
        BrowserUtils.sleep(1);
        adidasPage.addToCartButton.click();
        BrowserUtils.sleep(1);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    @When("user return to main page, select Dell i7 8gb from laptop category, add to cart and accept pop up confirmation")
    public void user_return_to_main_page_select_dell_i7_8gb_from_laptop_category_add_to_cart_and_accept_pop_up_confirmation() {
        BrowserUtils.sleep(1);
        adidasPage.homeButton.click();
        BrowserUtils.sleep(1);
        adidasPage.laptopsButton.click();
        BrowserUtils.sleep(1);
        adidasPage.delli78GbButton.click();
        BrowserUtils.sleep(1);
        adidasPage.addToCartButton.click();
        BrowserUtils.sleep(1);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    @When("user delete Dell i7 8gb from cart")
    public void user_delete_dell_i7_8gb_from_cart() {
        BrowserUtils.sleep(1);
        adidasPage.cartButton.click();
        BrowserUtils.sleep(2);
        adidasPage.deleteProduct();
        BrowserUtils.sleep(1);
    }

    @When("user click on Place order")
    public void user_click_on_place_order() {
        adidasPage.placeOrderButton.click();
        BrowserUtils.sleep(1);
    }

    @When("user fill in all web form fields and click on Purchase")
    public void user_fill_in_all_web_form_fields_and_click_on_purchase() {
        BrowserUtils.sleep(1);
        adidasPage.inputName.sendKeys(faker.name().fullName());
        BrowserUtils.sleep(1);
        adidasPage.inputCountry.sendKeys(faker.address().country());
        BrowserUtils.sleep(1);
        adidasPage.inputCity.sendKeys(faker.address().city());
        BrowserUtils.sleep(1);
        adidasPage.inputCard.sendKeys(faker.finance().creditCard());
        BrowserUtils.sleep(1);
        adidasPage.inputMonth.sendKeys(faker.bothify("October"));
        BrowserUtils.sleep(1);
        adidasPage.inputYear.sendKeys(faker.bothify("2022"));
        BrowserUtils.sleep(1);
        adidasPage.purchaseButton.click();
        BrowserUtils.sleep(1);
    }

    @And("user capture and log purchase Id and Amount")
    public void userCaptureAndLogPurchaseIdAndAmount() {
        adidasPage.idAndAmount();
    }
    @When("Assert purchase amount equals expected")
    public void assert_purchase_amount_equals_expected() {
        Assert.assertTrue(adidasPage.amount.getText().contains("790 USD"));
    }
    @And("user click on Ok")
    public void userClickOnOk() {
        adidasPage.confirmButton.click();
    }





}
