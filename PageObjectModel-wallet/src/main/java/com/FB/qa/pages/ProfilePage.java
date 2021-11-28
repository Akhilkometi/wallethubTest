package com.FB.qa.pages;

import com.FB.qa.base.TestBase;
import com.FB.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ProfilePage extends TestBase
{

    @FindBy(xpath = "//span[contains(text(),'Add to Story')]")
    WebElement addStoryButton;

    @FindBy(xpath = "//div[contains(text(),'Create a Text Story')]")
    WebElement createStory;


    @FindBy(xpath = "//textarea[@dir='ltr']")
    WebElement storyTextMessage;

    @FindBy(xpath = "//span[contains(text(),'Share to Story')]")
    WebElement sharetoStoryButton;
    @FindBy(xpath = "//div[@aria-label='Profile picture actions']/div")
    WebElement profilePicture;
    @FindBy(xpath = "//span[contains(text(),'View story')]")
    WebElement viewStrory;
    @FindBy(xpath = "//div[@aria-label='Pause']")
    WebElement pauseStoryButton;

    @FindBy(xpath ="//div[@data-pagelet='Stories']/div[2]/div/div/div[1]")
    WebElement getStatusText;




    // Initializing the Page Objects:
    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }
    public String story(){
        addStoryButton.click();
        createStory.click();
        storyTextMessage.sendKeys(prop.getProperty("StoryMessage"));
        sharetoStoryButton.click();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        profilePicture.click();
        viewStrory.click();
        pauseStoryButton.click();
        String status=getStatusText.getText();
        return  status;
    }
}
