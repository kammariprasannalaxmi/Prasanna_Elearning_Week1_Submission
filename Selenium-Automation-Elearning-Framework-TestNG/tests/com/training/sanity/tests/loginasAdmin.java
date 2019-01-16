package com.training.sanity.tests;


import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.loginasAdminPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class loginasAdmin {

	private WebDriver driver;
	private String baseUrl;
	private loginasAdminPOM LoginasAdminPOM;
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
		LoginasAdminPOM = new loginasAdminPOM(driver); 
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
	public void validloginasAdmin() {
		//To login using the admin credentials
		LoginasAdminPOM.sendUserName("admin"); 
		LoginasAdminPOM.sendPassword("admin@123");
		screenShot.captureScreenShot("zero");
		LoginasAdminPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
	
	}



}
