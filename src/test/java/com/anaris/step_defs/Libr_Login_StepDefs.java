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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Libr_Login_StepDefs {

    LibrLoginPage librLoginPage = new LibrLoginPage();

    @Given("user is on the library login page")
    public void user_is_on_the_library_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library.url"));
    }

    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        librLoginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("librarian"));
    }

    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        librLoginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("librarian.pass"));
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        librLoginPage.loginButton.click();


        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains("dashboard"));

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
    }

    @When("user enters student username")
    public void userEntersStudentUsername() {
        librLoginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("student"));
    }

    @And("user enters student password")
    public void userEntersStudentPassword() {
        librLoginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("student.pass"));
    }

    @Then("books should be displayed")
    public void booksShouldBeDisplayed() {
        librLoginPage.loginButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains("books"));

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("books"));

    }


}
