/*
 * @autor : Akhil Kometi
 *
 */
package com.FB.qa.testcases;

import com.FB.qa.base.TestBase;

import com.FB.qa.pages.ReviewPage;
import com.FB.qa.pages.WalletLoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class WalletReviewTest extends TestBase {
    ReviewPage reviewPage;
    WalletLoginPage walletLoginPage;
    public WalletReviewTest() {
        super();
    }

    /**test cases should be separated -- independent with each other
     @before Method each test case -- launch the browser and login
     @test -- execute test case
     @after Method each test case -- close the browser */
    @BeforeMethod

    public void setUp() {
        initialization();
        reviewPage=new ReviewPage();
        walletLoginPage=new WalletLoginPage();
        driver.get(prop.getProperty("WalletUrl"));

    }
    @Test(priority=1)
    public void verifyReviewTest() throws InterruptedException {
        walletLoginPage.login(prop.getProperty("WalletUsername"), prop.getProperty("WalletPassword") );
        walletLoginPage.companyURL();
        String CompanyName=reviewPage.verifyCompanyName();
        String successMessage=reviewPage.verifyReview();
        Assert.assertEquals(successMessage,prop.getProperty("SuccessMessage"));
        Assert.assertEquals(CompanyName,reviewPage.verifyReviewOnProfile());

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
