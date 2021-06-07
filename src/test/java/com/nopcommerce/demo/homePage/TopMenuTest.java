package com.nopcommerce.demo.homePage;

import com.nopcommerce.demo.page.HomePage;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends TestBase {

    HomePage homepage=new HomePage();


    @Test
    public void selectMenuAndClick() throws InterruptedException {
        String expectedText=homepage.selectMenu("Computers");
        String actualText=homepage.getActualText();
        Assert.assertEquals(expectedText,actualText);

    }


}
