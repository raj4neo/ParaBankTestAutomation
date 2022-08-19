package com.para.qa.pages;

import com.para.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {


    @FindBy(xpath="//div[@id='leftPanel']//following::p[1]")
    WebElement userNameLabel;

    @FindBy(xpath="//a[contains(text(),'Bill Pay')]")
    WebElement billPayLink;

    @FindBy(xpath="//a[contains(text(),'Home')]")
    WebElement homeLink;

    @FindBy(xpath="//a[contains(text(),'Find Transactions')]")
    WebElement transactionsLink;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyHomePageTitle(){
        return driver.getTitle();
    }

    public String verifyUserName(){
        return userNameLabel.getText();
    }

    public BillPayPage clickOnBillPayLink(){
        billPayLink.click();
        return new BillPayPage();

    }

    public void clickHome(){
        homeLink.click();
    }

    public FindTransactionsPage clickonFindTransactionsPageLink(){
        transactionsLink.click();
        return new FindTransactionsPage();
    }


}
