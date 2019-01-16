package com.training.pom;


	import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class ViewDetailsofUserPOM{
		private WebDriver driver;
		public ViewDetailsofUserPOM(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy (id="login")
		private WebElement userName;
		
		@FindBy (id="password")
		private WebElement password;
		
		@FindBy (id="formLogin_submitAuth")
		private WebElement loginBtn;
		
		@FindBy (linkText="Homepage")
		private WebElement homepage;
		
		@FindBy (id="profile_password0")
		private WebElement Pass;
		
		
		@FindBy (id="profile_apply_change")
		private WebElement SaveChanges;
		
		@FindBy (linkText="Administration")
		private WebElement Administration;
		
		@FindBy (linkText="User list")
		private WebElement Userlist;
		
		@FindBy (xpath="//*[@id=\"search_simple_keyword\"]")
		private WebElement keyword;
	
		@FindBy (xpath="//button[@id='search_simple_submit']")
		private WebElement Search;
		
		
		public void sendUserName(String userName) {
			this.userName.clear();
			this.userName.sendKeys(userName);
		}
		
		public void sendPassword(String password) {
			this.password.clear();
			this.password.sendKeys(password);	
		}
		
		public void clickLoginBtn(){
			this.loginBtn.click();
		}
		
		public void clickhomepage() {
			this.homepage.click();
		}
			
		public void sendPass(String Pass) {
			this.Pass.clear();
			this.Pass.sendKeys(Pass);	
		}
		
		
		
		public void clickSaveChanges() {
			this.SaveChanges.click();
		}
		
		public void clickAdministration() {
			this.Administration.click();
		}
		
		public void clickuserlist() {
			this.Userlist.click();
		}
		
		public void sendkeyword(String Keyword) {
			this.keyword.clear();
			this.keyword.sendKeys(Keyword);	
		}
		
		public void clickSearch() {
			this.Search.click();
		}
		
		public void clickEditIcon() {
			//count the number of rows
			List<WebElement> rows=driver.findElements(By.xpath("//table/tbody/tr"));
			int rowsize=rows.size();
			System.out.println(rowsize);
			for(int i=2;i<=rowsize-1;i++) {
				String name=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				System.out.println(name);
				//checking the names
				if(name.equalsIgnoreCase("prasanna1"))
				{
					String Profile=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
					System.out.println(Profile);
					//clicking edit button for trainer
					if(Profile.equalsIgnoreCase("Trainer")) {
					driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[11]/a[5]/img")).click();
					System.out.println("found text");
					}
					//clicking edit button for learner
					else if(Profile.equalsIgnoreCase("learner"))
					{
						driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[11]/a[6]/img")).click();
						System.out.println("found text");	
						
					}
				}
				else
				{
					System.out.println("they are not equal");
				}
				
			}
		}
		
		
		
		
}


