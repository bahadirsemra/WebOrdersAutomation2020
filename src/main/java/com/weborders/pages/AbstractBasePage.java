package com.weborders.pages;

import com.weborders.utilities.BrowserUtils;
import com.weborders.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//abstract means extends
public abstract class AbstractBasePage {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 20);

   //========================
    @FindBy (tagName = "h1")
    protected WebElement  pageLogo;

    public String getPageLogoText(){
        return pageLogo.getText();
    }

    //======================
    @FindBy(tagName = "h2")
    protected WebElement pageSubtitle;

    public String getPageSubtitleText(){
        BrowserUtils.waitForPageToLoad(10);
        return pageSubtitle.getText().trim();
    }
     //======================

    public AbstractBasePage() {
        PageFactory.initElements(driver, this);
        //for annotations findby-- execute automatically
    }

    //Specify component name as a parameter, like: View all product or Order
    public void navigateTo(String component){
        String locator = "//a[text()='"+ component +"']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
    }
}
