package com.para.qa.testcases;

import com.para.qa.base.TestBase;
import com.para.qa.pages.BillPayPage;
import com.para.qa.pages.LoginPage;
import com.para.qa.pages.OverviewPage;
import com.para.qa.pages.SignUpPage;
import com.para.qa.util.TestUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUpPageTest extends TestBase {

    LoginPage loginPage;
    SignUpPage signUpPage;

    OverviewPage overviewPage;

    TestUtil testUtil;
    String sheetName = "Registration";

    public SignUpPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new LoginPage();
        overviewPage = new OverviewPage();
        signUpPage = loginPage.clickRegisterLink();
    }

    @Test(priority = 1)
    public void verifySignupPageText(){
        String signUpPageText = signUpPage.validateSignUpPageText();
        Assert.assertEquals(signUpPageText,"Signing up is easy!");
    }

    @DataProvider
    public Object[][] getRegisterData(){
        try {
            Object data[][] = testUtil.getTestData(sheetName);
            return data;
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }
    }
    @Test(priority = 2,dataProvider = "getRegisterData")
    public void createNewRegistration(String FirstName,String LastName,String Address,String City, String State,String Zip, String Phone,String SNN, String UserName, String Password, String ConfirmPassword)
    {
        signUpPage.createNewUser(FirstName,LastName,Address,City, State, Zip,  Phone,SNN, UserName, Password, ConfirmPassword);
        String successMsg= overviewPage.verifyRegisterSuccess();
        Assert.assertEquals(successMsg,"Your account was created successfully. You are now logged in.");
        overviewPage.clickLogout();
    }

    @AfterMethod()
    public void tearDown(){
        driver.quit();
    }

}
