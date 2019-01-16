package com.training.pom;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class EditProfliePOM{
		private WebDriver driver;
		public EditProfliePOM(WebDriver driver){
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

		@FindBy (linkText="Edit profile")
		private WebElement editprofile;
		
		@FindBy (id="profile_password0")
		private WebElement Pass;
		
		@FindBy (id="password1")
		private WebElement NewPassword;
		
		@FindBy (id="profile_password2")
		private WebElement ConfirmPassword;
		
		@FindBy (id="profile_apply_change")
		private WebElement SaveChanges;
		
	
		
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
		
		public void clickeditprofile() {
			this.editprofile.click();
		}
		
		public void sendPass(String Pass) {
			this.Pass.clear();
			this.Pass.sendKeys(Pass);	
		}
		
		public void sendNewPassword(String NewPassword) {
			this.NewPassword.clear();
			this.NewPassword.sendKeys(NewPassword);	
		}
		
		public void sendConfirmPassword(String ConfirmPassword) {
			this.ConfirmPassword.clear();
			this.ConfirmPassword.sendKeys(ConfirmPassword);	
		}
		
		public void clickSaveChanges() {
			this.SaveChanges.click();
		}
		
}


