package com.FB.qa.pages;

import com.FB.qa.base.TestBase;
import com.FB.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.security.util.Password;

import java.util.concurrent.TimeUnit;

public class WalletLoginPage extends TestBase {
    //Page Factory - OR:
    @FindBy(xpath="//a[@class='login']")
    WebElement Login;
    @FindBy(xpath="//input[@id='email']")
    WebElement Username;

    @FindBy(xpath="//input[@id='password']")
    WebElement Password;


    @FindBy(xpath="//span[contains(text(),'Login')]")
    WebElement LoginBtn;



    // Initializing the Page Objects:
    public WalletLoginPage() {
        PageFactory.initElements(driver, this);
    }
/** Method to Login and return next page's Object */
    public ReviewPage login(String userName, String password)  {
;
        Login.click();
        Username.sendKeys(userName);
        Password.sendKeys(password);
        LoginBtn.click();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

        return new ReviewPage();
    }
    /** Method to Navigate to Company's URL  */
    public ReviewPage companyURL()throws InterruptedException
    {
        Thread.sleep(10000);
        driver.get(prop.getProperty("WalletCompanyProfileUrl"));
        return new ReviewPage();
    }

}
