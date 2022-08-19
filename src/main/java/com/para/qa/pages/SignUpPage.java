package com.para.qa.pages;


import com.para.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends TestBase {

    @FindBy(xpath="//div[@id='rightPanel']/h1")
    WebElement signUpLabel;

     @FindBy(xpath="//input[@id='customer.firstName']")
        WebElement firstName;
    @FindBy(xpath="//input[@id='customer.lastName']")
    WebElement lastName;

    @FindBy(xpath="//input[@id='customer.address.street']")
    WebElement street;

    @FindBy(xpath="//input[@id='customer.address.city']")
    WebElement city;

    @FindBy(xpath="//input[@id='customer.address.state']")
    WebElement state;

    @FindBy(xpath="//input[@id='customer.address.zipCode']")
    WebElement zip;

    @FindBy(xpath="//input[@id='customer.phoneNumber']")
    WebElement phone;

    @FindBy(xpath="//input[@id='customer.ssn']")
    WebElement ssn;

    @FindBy(xpath="//input[@id='customer.username']")
    WebElement user;

    @FindBy(xpath="//input[@id='customer.password']")
    WebElement password;

    @FindBy(xpath="//input[@id='repeatedPassword']")
    WebElement confirmPassword;

    @FindBy(xpath="//form[@id='customerForm']//input[@type='submit']")
    WebElement registerBtn;

    @FindBy(xpath="//div[@id='rightPanel']//following::p[1]")
    WebElement successLabel;

    @FindBy(xpath="//a[contains(text(),'Log Out')]")
    WebElement logOutLink;

    public SignUpPage(){
        PageFactory.initElements(driver,this);
    }

    public String validateSignUpPageText(){

        return signUpLabel.getText();
    }

    public OverviewPage createNewUser(String FirstName,String LastName,String Address,String City, String State,String Zip, String Phone,String SNN, String UserName, String Password, String ConfirmPassword){
        firstName.sendKeys(FirstName);
        lastName.sendKeys(LastName);
        street.sendKeys(Address);
        city.sendKeys(City);
        state.sendKeys(State);
        zip.sendKeys(Zip);
        phone.sendKeys(Phone);
        ssn.sendKeys(SNN);
        user.sendKeys(UserName);
        password.sendKeys(Password);
        confirmPassword.sendKeys(ConfirmPassword);
        registerBtn.click();
        return new OverviewPage();
    }


    public void clickLogout(){
        logOutLink.click();

    }










}
