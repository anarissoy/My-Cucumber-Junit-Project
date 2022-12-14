package com.anaris.pages;

import com.anaris.utilities.BrowserUtils;
import com.anaris.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class UserStory6Page extends BasePage{


    //====================================================

    @FindBy (css = "li[data-id='files'] > a > svg > image")
    public WebElement fileButton;

    @FindBy (xpath = "//tr[1]/td[2]/a/span[2]/a[2]/span[1]")
    public WebElement actionsButton;

    @FindBy (xpath = "//*[@id='rightClickMenu']/ul/li[1]")
    public WebElement addToFavorites;

    @FindBy (xpath = "//*[@id='fileList']/tr/td[1]/a/span[1]/span[1]")
    public WebElement verifyFavorites;

    @FindBy (xpath = "//h2[normalize-space()='No favorites yet']")
    public WebElement verifyNoFavorites;

    @FindBy (xpath = "//li[@data-id='favorites']")
    public WebElement favoritesBtn;

    @FindBy (xpath = "(//span[@class='nametext'])[1]") // name="permissions"
    public WebElement rightClickOnFile;

    //@FindBy (name = "permissions")


    //TC2

    @FindBy (xpath = "//span[@class='icon icon-add']")
    public WebElement addIconButton;

    @FindBy (xpath = "//label[@data-action='upload']")
    public WebElement uploadButton;

    @FindBy (xpath = "//input[@type ='file']")
    public WebElement inputButton;

    @FindBy (css= "#uploadprocessbar")
    public WebElement uploadBar;

    @FindBy (xpath = "//tbody[@id='fileList']/tr")  // //tbody[@id="fileList"]/tr
    public List<WebElement> recommendBtn;

    @FindBy (xpath = "//span[@class='nametext']") // (//span[@class='nametext'])[5]
    public List<WebElement> uploadedFileList;

    public List<String> fileCount(){
        JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        //js.executeScript("window.scrollBy(0,1200)");
        int count = 0;
        List<String> fileList = new ArrayList<>();
        for(int i = 0; i< recommendBtn.size(); i++) {
            BrowserUtils.hover(recommendBtn.get(i));
            recommendBtn.get(i).isEnabled();
            //count++;
            fileList.add(recommendBtn.get(i).getAttribute("data-file"));
        }
        return fileList;
    }

    public void verifyUS8TC2(String verify){
        JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.scrollBy(0,1000)");
        String after = "";
        String before = "";
        int count = 0;
        for (int i = recommendBtn.size()-1; i >= 0; i--) {
            BrowserUtils.hover(recommendBtn.get(i));
            before += " "+recommendBtn.get(i).getAttribute("data-file");
            //BrowserUtils.waitFor(1);
            recommendBtn.get(i).isEnabled();
            count++;
            if(recommendBtn.get(i).getAttribute("data-file").equals(verify)){
                after += recommendBtn.get(i).getAttribute("data-file");
                break;
            }
        }
        System.out.println(count);
        System.out.println(before);
        Assert.assertTrue(after.equalsIgnoreCase(verify));
    }







}
