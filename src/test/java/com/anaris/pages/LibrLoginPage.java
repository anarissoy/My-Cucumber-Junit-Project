package com.anaris.pages;

import com.anaris.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LibrLoginPage {

    public LibrLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login(String userName, String passWord) {
        inputUsername.sendKeys(userName);
        inputPassword.sendKeys(passWord);
        loginButton.click();
    }

    @FindBy(css = "#inputEmail")
    public WebElement inputUsername;

    @FindBy(css = "#inputPassword")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[@class='title']")
    public WebElement booksIsDisplayed;

    @FindBy(xpath = "//a[@id='navbarDropdown']/span")  // //a[@id='navbarDropdown']/span
    public WebElement accountName;

    @FindBy (xpath = "(//span)[6]")
    public WebElement accountName2;

    @FindBy (xpath = "//h2[@id='user_count']")
    public WebElement userCount;

    @FindBy(xpath="//span[.='Users']")
    public WebElement usersBtn; // @FindBy(xpath="//span[.='Users']")

    @FindBy(tagName = "th")
    public List<WebElement> usersTableHeader;

    public void selectTopModule(String topModules){
        String locator = "//span[.='"+topModules+"']";
        Driver.getDriver().findElement(By.xpath(locator)).click();
    }
}
