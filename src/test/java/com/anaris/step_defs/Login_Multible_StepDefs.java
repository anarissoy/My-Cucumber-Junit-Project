package com.anaris.step_defs;

import com.anaris.pages.LibrLoginPage;
import com.anaris.utilities.BrowserUtils;
import com.anaris.utilities.ConfigurationReader;
import com.anaris.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class Login_Multible_StepDefs {

    LibrLoginPage librLoginPage = new LibrLoginPage();

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library.url"));
    }

    @When("I login using {string} and {string}")
    public void iLoginUsingAnd(String username, String password) {

        librLoginPage.inputUsername.sendKeys(username);
        librLoginPage.inputPassword.sendKeys(password);
        librLoginPage.loginButton.click();
    }
    @Then("account holder name should be {string}")
    public void accountHolderNameShouldBe(String accountName) {
        BrowserUtils.waitForVisibility(librLoginPage.accountName,10);
        System.out.println(librLoginPage.accountName.getText());


        Assert.assertEquals(accountName,librLoginPage.accountName.getText());
    }

    //****************************************************************************

    @When("I enter username {string}")
    public void iEnterUsername(String username) {

        librLoginPage.inputUsername.sendKeys(username);
    }

    @And("I enter password {string}")
    public void iEnterPasswordIFFPPf(String password) {

        librLoginPage.inputPassword.sendKeys(password);
    }

    @And("click the sign in button")
    public void clickTheSignInButton() {

        librLoginPage.loginButton.click();
    }

    @Then("dashboard should be displayed")
    public void dashboardShouldBeDisplayed() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains("dashboard"));

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
    }

    //*********************************************************************************

    @And("there should be {int} users")
    public void thereShouldBeUsers(int expectedNumber) {

        String expectectedUserNum = String.valueOf(expectedNumber);
        BrowserUtils.waitForVisibility(librLoginPage.userCount,10);
        Assert.assertEquals("User count is failing!",expectectedUserNum,librLoginPage.userCount.getText());
    }

    @When("User login using {string} and {string}")
    public void userLoginUsingAnd(String username, String password) {
        librLoginPage.inputUsername.sendKeys(username);
        librLoginPage.inputPassword.sendKeys(password);
        librLoginPage.loginButton.click();
    }

}
