package com.para.qa.pages;

import com.para.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //define pagefactory;

    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//input[@type='submit']")
    WebElement loginBtn;

    @FindBy(linkText = "Register")
    WebElement RegisterLink;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public SignUpPage clickRegisterLink(){
        RegisterLink.click();
        return new SignUpPage();

    }

    public HomePage login(String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
        return new HomePage();
    }










}
