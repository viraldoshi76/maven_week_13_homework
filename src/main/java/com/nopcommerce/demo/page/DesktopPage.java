package com.nopcommerce.demo.page;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DesktopPage extends Utility {

    By sortByFilterLink = By.id("products-orderby");
    By sortFilterByZToA = By.xpath("//h2[@class='product-title']");
    By addToCartButton = By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/1/1/1\"),!1']");


    public void sortFilterZtoA() {

        selectByValueDropDown(waitUntilVisibilityOfElement(sortByFilterLink, 50), "6");

    }

    public List<String> verifyProductArrangeZtoAOrder() throws InterruptedException {

        //List<WebElement> productList = driver.findElements(By.xpath("//h2[@class='product-title']"));

        return verifyProductInDescendingOrder(sortFilterByZToA);
    }

    public void sortFilterAtoZ(){
        selectByValueDropDown(waitUntilVisibilityOfElement(sortByFilterLink,50),"5");
    }

    public void clickOnAddToCartOnBuildYourOwnComputer(){
        clickOnElement(waitUntilVisibilityOfElement(addToCartButton,50));
    }



}



