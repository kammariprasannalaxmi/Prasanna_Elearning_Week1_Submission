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
import com.training.pom.ViewDetailsofUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ViewDetailsofUser {

	private WebDriver driver;
	private String baseUrl;
	private ViewDetailsofUserPOM ViewDetailsofUserPOM;
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
		ViewDetailsofUserPOM = new ViewDetailsofUserPOM(driver); 
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
	public void validViewDetailsofUser() throws InterruptedException {
		ViewDetailsofUserPOM.sendUserName("admin"); 
		ViewDetailsofUserPOM.sendPassword("admin@123");
		screenShot.captureScreenShot("zero");
		ViewDetailsofUserPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		ViewDetailsofUserPOM.clickhomepage();
		ViewDetailsofUserPOM.clickAdministration();
		ViewDetailsofUserPOM.clickuserlist();
		ViewDetailsofUserPOM.sendkeyword("prasanna1");
		ViewDetailsofUserPOM.clickSearch();
		Thread.sleep(5000);
		ViewDetailsofUserPOM.clickEditIcon();	
		Thread.sleep(5000);
		String Expected="Edit user information";
		String Actual=driver.findElement(By.xpath("//*[@id='user_edit']/fieldset/legend")).getText();
		Assert.assertEquals(Actual, Expected);
	}
	
	
}
