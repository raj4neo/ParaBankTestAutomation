package com.para.qa.testcases;

import com.para.qa.base.TestBase;
import com.para.qa.pages.BillPayPage;
import com.para.qa.pages.HomePage;
import com.para.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    BillPayPage billPayPage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new LoginPage();
        billPayPage = new BillPayPage();
        homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }
    @Test(priority = 1)
    public void verifyHomePageTitleTest(){
       String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle,"ParaBank | Accounts Overview","HomePage Title Matched");
    }

    @Test(priority = 2)
    public void verifyUserNameTest(){
        String user = homePage.verifyUserName();
        Assert.assertEquals(user,"Welcome Rajkumar Guruswamy");
    }

    @Test(priority = 3)
    public void clickBillPayPageLinkTest(){
        billPayPage = homePage.clickOnBillPayLink();
    }


    @AfterMethod()
    public void tearDown(){
        driver.quit();
    }

}
