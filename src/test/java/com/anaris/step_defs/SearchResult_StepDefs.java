package com.anaris.step_defs;

import com.anaris.pages.LibrLoginPage;
import com.anaris.utilities.BrowserUtils;
import com.anaris.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class SearchResult_StepDefs {


LibrLoginPage librLoginPage = new LibrLoginPage();
    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
        librLoginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("librarian"));
        librLoginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("librarian.pass"));
       librLoginPage.loginButton.click();
    }
    @Given("I click on {string} link")
    public void i_click_on_link(String moduleName) {
        BrowserUtils.waitForVisibility(librLoginPage.usersBtn,10);
        librLoginPage.selectTopModule(moduleName);

    }
    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> dataTable) {

        BrowserUtils.waitForVisibility(librLoginPage.usersBtn,10);

        List<String> actualTableHeader = BrowserUtils.getElementsTextByList(librLoginPage.usersTableHeader);

        Assert.assertEquals(dataTable,actualTableHeader);



    }

}
