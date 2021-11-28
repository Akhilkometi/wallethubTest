package com.FB.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FB.qa.base.TestBase;

public class HomePage extends TestBase {


	@FindBy(xpath = "//div[@class='buofh1pr']//div/a[1]/div/div[1]/div")
	WebElement profileName;



	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public ProfilePage profileClick(){
		profileName.click();
		return new ProfilePage();
	}


}
