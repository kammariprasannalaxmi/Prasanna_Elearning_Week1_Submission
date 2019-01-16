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
import com.training.pom.AddAUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddAUser {

	private WebDriver driver;
	private String baseUrl;
	private AddAUserPOM AddAUserPOM;
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
		AddAUserPOM = new AddAUserPOM(driver); 
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
	@Test(priority=1)
	public void validViewDetailsofUser() throws InterruptedException {
		//giving all the credendials of new user
		AddAUserPOM.sendUserName("admin"); 
		AddAUserPOM.sendPassword("admin@123");
		screenShot.captureScreenShot("zero");
		AddAUserPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		AddAUserPOM.clickhomepage();
		AddAUserPOM.clickAdministration();
		AddAUserPOM.clickAddUser();
		AddAUserPOM.sendFirstName("Rishi");
		AddAUserPOM.sendlastName("Kalpaguri");
		AddAUserPOM.sendEmail("rishi@gmail.com");
		AddAUserPOM.sendphone("9876543210");
		AddAUserPOM.sendloginusername("Rishi");
		AddAUserPOM.clickradiobtn();
		Thread.sleep(5000);
		AddAUserPOM.sendpassword1("admin@123");
		AddAUserPOM.selectdropdown();
		Thread.sleep(5000);
		AddAUserPOM.clickAdd();
		Thread.sleep(5000);
			//to check if the user is present in the userlist
			AddAUserPOM.clickAdministration();
			AddAUserPOM.clickuserlist();
			AddAUserPOM.sendkeyword("Rishi");
			AddAUserPOM.clickSearch();
			Thread.sleep(5000);
			AddAUserPOM.clickEditIcon();	
			Thread.sleep(5000);
			String Expected="Edit user information";
			String Actual=driver.findElement(By.xpath("//*[@id='user_edit']/fieldset/legend")).getText();
			Assert.assertEquals(Actual, Expected);

		
		

	}
	
	
}
