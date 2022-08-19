package com.para.qa.testcases;

import com.para.qa.base.TestBase;
import com.para.qa.pages.HomePage;
import com.para.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends TestBase {
    LoginPage loginPage; // object of login page class
    HomePage homePage; // object of Home page class

    public LoginPageTest() throws IOException{
        super(); // super keyword will call super class constructor, properties will be init
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage(); //  Login page class constructor
    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
       String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"ParaBank | Welcome | Online Banking");
    }

    @Test(priority = 2)
    public void loginTest(){
       homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
