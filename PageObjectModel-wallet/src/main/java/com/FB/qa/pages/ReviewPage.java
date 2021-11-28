package com.FB.qa.pages;

import com.FB.qa.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class ReviewPage extends TestBase {

    @FindBy(xpath = "//span[normalize-space()='Your Review']")
    List<WebElement> YourReview;

    @FindBy(xpath = "//button[@class='btn blue-transparent fixed-small']")
    WebElement EditYourReview;
    @FindBy(xpath = "//textarea[@placeholder='Write your review']")
    WebElement EditYourReviewWithNull;
    @FindBy(xpath = "//span[contains(text(),'Submit')]")
    WebElement ReviewSubmitButton;

    @FindBy(xpath = "//span[contains(text(),'Contact')]/ancestor::div[1]/following-sibling::div//button[contains(text(),'Write a Review')]")
    WebElement WriteAReviewButton;
    @FindBy (xpath = "//write-review//*[local-name()='svg'][4]")
    WebElement FourstarReview;
    @FindBy(xpath = "//div[@class='dropdown second']/span[contains(text(),'Select...')]")
    WebElement SelectDropdown;
    @FindBy(xpath = "//div[@class='dropdown second opened']//li[contains(text(),'Health Insurance')]")
    WebElement CategoryDropdown;
    @FindBy(xpath = " //textarea[@placeholder='Write your review...']")
    WebElement ReviewMessage;


    @FindBy(xpath = "//div[contains(text(),'Submit')]")
    WebElement SubmitButton;
    @FindBy(xpath = "//div/h4")
    WebElement SuccessMessage;
    @FindBy(xpath = "//div[@class='info text-select']/h1")
    WebElement CompanyName;
    @FindBy(xpath = "//div[@class='brgm-button brgm-user brgm-list-box']/span[@class='brgm-list-title']")
    WebElement ProfileName;
    @FindBy(xpath = "//a[@class='brgm-list-it'][normalize-space()='Profile']")
    WebElement ProfileButton;
    @FindBy(xpath = "//div[@class='pr-rec-texts-container']/a")
    WebElement CompanyNameOnProfile;

    WalletLoginPage walletLoginPage;
    ReviewPage reviewPage;

    // Initializing the Page Objects:
    public ReviewPage() {
        PageFactory.initElements(driver, this);
        walletLoginPage=new WalletLoginPage();


    }
    /** Method to Write Review and return Review success message */
    public String review()
    {
        WriteAReviewButton.click();
        //Creating object of an Actions class
        Actions action = new Actions(driver);

        //Performing the mouse hover action on the target element.
        action.moveToElement(FourstarReview).perform();
        FourstarReview.click();

        //Selecting category form Dropdown using value
        SelectDropdown.click();
        CategoryDropdown.click();

        ReviewMessage.sendKeys(prop.getProperty("reviewMessage"));
        SubmitButton.click();
        return SuccessMessage.getText();

    }
    /** Method to Delete already existed Review and Add New Review */
    public String verifyReview() throws InterruptedException {
        reviewPage=new ReviewPage();
        if(!YourReview.isEmpty()){
            EditYourReview.click();

            //Use Keys.CONTROL if we execute in windows instead of Keys.COMMAND
            EditYourReviewWithNull.sendKeys(Keys.COMMAND+"a");
            EditYourReviewWithNull.sendKeys(Keys.DELETE);
            ReviewSubmitButton.click();
            walletLoginPage.companyURL();
        }
        return reviewPage.review();

    }
    /** Getting Company's name from company's profile  */
    public String verifyCompanyName(){
        return CompanyName.getText();
    }
    /** Getting company's name from Reviewer's profile */
    public String verifyReviewOnProfile(){

        Actions action = new Actions(driver);
        action.moveToElement(ProfileName).perform();
        ProfileButton.click();
        return CompanyNameOnProfile.getText();
    }

}
