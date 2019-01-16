package com.training.sanity.tests;


import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.EditProfliePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EditProfile {

	private WebDriver driver;
	private String baseUrl;
	private EditProfliePOM EditProfilePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		EditProfilePOM = new EditProfliePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		//log in as admin
		EditProfilePOM.sendUserName("admin"); 
		EditProfilePOM.sendPassword("admin@123");
		screenShot.captureScreenShot("zero");
		EditProfilePOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		EditProfilePOM.clickhomepage();
		//change the admin password
		EditProfilePOM.clickeditprofile();
		EditProfilePOM.sendPass("admin@123");
		EditProfilePOM.sendNewPassword("admin@123");
		EditProfilePOM.sendConfirmPassword("admin@123");
		EditProfilePOM.clickSaveChanges();
		//assertion
		String Expected="Your new profile has been saved";
		String Actual=driver.findElement(By.xpath("//section/div/div[2]/div/div")).getText();
		Assert.assertEquals(Actual, Expected);
		
		
	}
}
