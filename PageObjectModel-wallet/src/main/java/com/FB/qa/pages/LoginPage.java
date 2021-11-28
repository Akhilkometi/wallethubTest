package com.FB.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.FB.qa.base.TestBase;


public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(id="email")
	WebElement Username;
	
	@FindBy(id="pass")
	WebElement Password;

	
	@FindBy(xpath="//button[contains(text(),'Log In')]")
	WebElement loginBtn;
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}


	
	public HomePage login(String userName, String password){

		Username.sendKeys(userName);
		Password.sendKeys(password);
		loginBtn.click();
		return new HomePage();
	}
	
}
