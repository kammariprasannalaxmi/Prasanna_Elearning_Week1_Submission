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
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
		loginPOM = new LoginPOM(driver); 
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
		//login to Homelle page
		loginPOM.sendUserName("prasanna1"); 
		loginPOM.sendPassword("admin@123");
		screenShot.captureScreenShot("zero");
		loginPOM.clickLoginBtn(); 
		//Check the welcome message on the screen
		String expected="Hello prasanna laxmi and welcome,";
		String actual=driver.findElement(By.xpath("//*[@id='homepage-course']/div/p")).getText();
		Assert.assertEquals(actual, expected);
		screenShot.captureScreenShot("First");
		//To logout from the page
		loginPOM.clickuserDropdown();
		screenShot.captureScreenShot("second");
		loginPOM.clicklogOutBtn();
		screenShot.captureScreenShot("third");
		
		
	}
}
