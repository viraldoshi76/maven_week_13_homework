package com.nopcommerce.demo.utility;

import com.nopcommerce.demo.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Utility extends BasePage {



    /**
     * this method will click on element
     * @param by
     */

    public void clickOnElement(By by){
        driver.findElement(by).click();

    }

    public void clickOnElement(WebElement element){
       element.click();

    }

    /**
     * This method will get text from element
     * @param by
     * @return
     */
    public String getTextFromElement(By by){
       return driver.findElement(by).getText();
    }

    public String getTextFromElement(WebElement element){
        return element.getText();
    }

    /**
     * This method will send text on element
     * @param by
     * @param text
     */
    public void sendTextToElement(By by,String text){

        driver.findElement(by).sendKeys(text);
    }

    public void sendTextToElement(WebElement element,String text){

        element.sendKeys(text);
    }


    /**
     * This method will select value from dropdown
     * @param by
     * @param value
     */
    public void selectByValueDropDown(By by,String value){
        Select select =new Select(driver.findElement(by));
        select.selectByValue(value);

    }

    public void selectByValueDropDown(WebElement element,String value){
        Select select =new Select(element);
        select.selectByValue(value);

    }

    public void selectByVisibleText(By by,String visibleText){
        Select select=new Select(driver.findElement(by));
        select.selectByVisibleText(visibleText);
    }

    public void selectByVisibleText(WebElement element,String visibleText){
        Select select=new Select(element);
        select.selectByVisibleText(visibleText);
    }
    public void selectByIndex(By by,int index){
        Select select=new Select(driver.findElement(by));
        select.selectByIndex(index);
    }

    public void selectByIndex(WebElement element,int index){
        Select select=new Select(element);
        select.selectByIndex(index);
    }

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void mouseHoverToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    /**
     * This method will used to wait until element located
     * @param by
     * @param timeout
     * @return
     */
    public WebElement waitUntilVisibilityOfElement(By by,int timeout){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        WebElement element=  wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;

    }

    public List<String> verifyProductInDescendingOrder(By by) throws InterruptedException {
        List<WebElement> productList = driver.findElements(by);
        List<String> productNameList = new ArrayList<>();


        for (WebElement list : productList) {
            Thread.sleep(2000);
            productNameList.add(list.getText());
        }
        System.out.println(productNameList);
        return productNameList;
    }




}
