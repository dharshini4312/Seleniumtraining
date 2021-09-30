package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.BaseClass;

public class LoginTest extends BaseClass {
WebDriver driver;

	@Test
	public void login() throws IOException {
		   driver= initializeDriver();
		 driver.get(prop.getProperty("url"));
		 
		 LandingPage landingPage= new LandingPage(driver);
		 landingPage.myAccountDropdown().click();
		 landingPage.loginOption().click();		 
		
		 
		 LoginPage loginPage= new LoginPage(driver);
		 loginPage.emailAddressField().sendKeys(prop.getProperty("email"));
		 loginPage.passwordField().sendKeys(prop.getProperty("password"));
		 loginPage.loginButton().click();
		 Assert.assertTrue(loginPage.EditYourAccountInfo().isDisplayed());
	
}
	@AfterMethod
	public void closure() {
		driver.close();
	}
	
	
}
