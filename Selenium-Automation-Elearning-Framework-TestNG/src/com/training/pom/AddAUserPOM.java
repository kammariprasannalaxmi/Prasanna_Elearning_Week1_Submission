package com.training.pom;


	import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

	public class AddAUserPOM{
		private WebDriver driver;
		public AddAUserPOM(WebDriver driver){
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
		
		
		@FindBy (linkText="Administration")
		private WebElement Administration;
		
		@FindBy (linkText="Add a user")
		private WebElement AddUser;
		
		@FindBy (id="firstname")
		private WebElement firstname;
		
		@FindBy (id="lastname")
		private WebElement lastname;
		
		@FindBy (id="email")
		private WebElement email;
		
		@FindBy (id="phone")
		private WebElement phone;
		
		@FindBy (id="username")
		private WebElement loginusername;
		
		@FindBy (name="password[password_auto]")
		private List<WebElement> radiobtn;
		
		@FindBy ( name="password[password]")	
		private WebElement password1;
		
		@FindBy (xpath="//*[@class='btn dropdown-toggle btn-default']")
		private WebElement country;
		
		@FindBy(name="submit")
		private WebElement Add;
		
		
		@FindBy (linkText="User list")
		private WebElement Userlist;
		
		@FindBy (xpath="//*[@id=\"search_simple_keyword\"]")
		private WebElement keyword;
	
		@FindBy (xpath="//*[@id='search_simple_submit']")
		private WebElement Search;
		
		public void selectdropdown()
		{
		 this.radiobtn.get(0).isSelected();
		}
		
		public void clickradiobtn() {
			this.radiobtn.get(1).isSelected();
			
		}
		
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
		
		public void clickAdministration() {
			this.Administration.click();
		}
		
		public void clickAddUser() {
			this.AddUser.click();
		}
		
		public void sendFirstName(String firstname) {
			this.firstname.clear();
			this.firstname.sendKeys(firstname);
		}
		
		public void sendlastName(String lastname) {
			this.lastname.clear();
			this.lastname.sendKeys(lastname);
		}
		
		public void sendEmail(String email) {
			this.email.clear();
			this.email.sendKeys(email);
		
		}
		
		public void sendphone(String phone) {
			this.phone.clear();
			this.phone.sendKeys(phone);
		
		}
		public void sendloginusername(String loginusername) {
			this.loginusername.clear();
			this.loginusername.sendKeys(loginusername);
		
		}
		
		public void sendpassword1(String password1) {
			this.password1.clear();
			this.password1.sendKeys(password1);
	}
		
		public void clickAdd() {
			this.Add.click();
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
				if(name.equalsIgnoreCase("Rishi"))
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
	

		
		
		
		
		
		
		



