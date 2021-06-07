package com.nopcommerce.demo.computer;

import com.nopcommerce.demo.page.BuildYourOwnComputer;
import com.nopcommerce.demo.page.ComputerPage;
import com.nopcommerce.demo.page.DesktopPage;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends TestBase {

    ComputerPage computerpage =new ComputerPage();
    DesktopPage desktopPage = new DesktopPage();
    BuildYourOwnComputer buildYourOwnComputer = new BuildYourOwnComputer();

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        computerpage.clickOnComputer();
        computerpage.clickOnDesktop();
        desktopPage.sortFilterZtoA();
        Thread.sleep(2000);
        List<String> actualProductNameList = desktopPage.verifyProductArrangeZtoAOrder();
        List<String> sortedList = new ArrayList<>(actualProductNameList);
        Collections.sort(sortedList,Collections.<String>reverseOrder());
        Assert.assertEquals(actualProductNameList,sortedList);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        computerpage.clickOnComputer();
        Thread.sleep(2000);
        computerpage.clickOnDesktop();
        desktopPage.sortFilterAtoZ();
        Thread.sleep(2000);
        desktopPage.clickOnAddToCartOnBuildYourOwnComputer();

        String expected = "Build your own computer";
        Assert.assertEquals(expected,buildYourOwnComputer.verifyTextBuildYourOwnComputer());
        buildYourOwnComputer.selectProcessor();
        Thread.sleep(2000);
        buildYourOwnComputer.selectRam();
        Thread.sleep(2000);
        buildYourOwnComputer.selectHDD();
        Thread.sleep(2000);
        buildYourOwnComputer.selectOS();
        Thread.sleep(2000);
        buildYourOwnComputer.selectSoftware();
        Thread.sleep(2000);

        String expectedPrice = "$1,475.00";
        Thread.sleep(2000);
        Assert.assertEquals(expectedPrice,buildYourOwnComputer.actualPriceValue());
        Thread.sleep(2000);
        buildYourOwnComputer.clickOnAddToCartButton();
        Thread.sleep(2000);

        String expectedGreenBarText = "The product has been added to your shopping cart";
        Assert.assertEquals(expectedGreenBarText,buildYourOwnComputer.actualGreenBarText());


    }


}
