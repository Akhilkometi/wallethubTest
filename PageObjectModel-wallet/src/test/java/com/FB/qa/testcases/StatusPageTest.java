/*
 * @autor : Akhil Kometi
 *
 */
package com.FB.qa.testcases;

import com.FB.qa.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FB.qa.base.TestBase;
import com.FB.qa.pages.HomePage;
import com.FB.qa.pages.LoginPage;
import com.FB.qa.pages.ProfilePage;
import com.FB.qa.util.TestUtil;

public class StatusPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	TestUtil testUtil;
	//ContactsPage contactsPage;

	public StatusPageTest() {
		super();
	}

	/**test cases should be separated -- independent with each other
	@before Method each test case -- launch the browser and login
	@test -- execute test case
	@after Method each test case -- close the browser */

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		driver.get(prop.getProperty("FBurl"));
		/* username and password getting from config properties*/
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		profilePage=new ProfilePage();
	}


	@Test(priority=1)
	public void verifyStatusMessageTest(){
		homePage.profileClick();
		String statusMessage = profilePage.story();
		Assert.assertEquals(statusMessage,prop.getProperty("StoryMessage"));
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
