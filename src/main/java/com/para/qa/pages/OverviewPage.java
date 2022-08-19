package com.para.qa.pages;

import com.para.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage extends TestBase {

    @FindBy(xpath="//div[@id='rightPanel']//following::p[1]")
    WebElement successLabel;

    @FindBy(xpath="//a[contains(text(),'Log Out')]")
    WebElement logOutLink;

    public OverviewPage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyRegisterSuccess(){
        return successLabel.getText();

    }

    public void clickLogout(){
        logOutLink.click();

    }


}
