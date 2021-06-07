package com.nopcommerce.demo.page;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;

public class ComputerPage extends Utility {

    HomePage homepage = new HomePage();
    By desktopLink =By.xpath("//h2[@class='title']//a[@href='/desktops']");

    public void clickOnComputer(){

        clickOnElement(waitUntilVisibilityOfElement(homepage.computersLink,20));

    }

    public void clickOnDesktop(){

        clickOnElement(waitUntilVisibilityOfElement(desktopLink,50));

    }



}
