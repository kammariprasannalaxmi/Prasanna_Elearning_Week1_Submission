package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StudenttoComment_Week2POM {
private WebDriver driver; 
	
	public StudenttoComment_Week2POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}	

	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn;
	
	@FindBy(linkText="Course catalog")
	private WebElement coursecatalogue;
	
	@FindBy(name="search_term")
	private WebElement searchterm;
	
	@FindBy(xpath="//*[@type='submit']")
	private WebElement search;
	
	@FindBy(xpath="//*[@class='items items-courses']")
	private WebElement item;
	
	@FindBy(xpath="/html/body/div[1]/section/div/div[2]/div[2]/div/div/div/div[2]/div[4]/div[2]/div/a")
	private WebElement subscribe;
	
	@FindBy(linkText="selenium webdriver course by manipal_22")
	private WebElement coursetitle;
	
	@FindBy(linkText="eleaning_week2_22")
	private WebElement projecttitle;
	
	@FindBy(xpath="//*[@alt='Users management']")
	private WebElement usermanagement;
	
	@FindBy(name="user[]")
	private WebElement checkbox;
	
	@FindBy(linkText="Register")
	private WebElement register;
	
	@FindBy(linkText="elearning_student to comment_22")
	private WebElement task;
	
	@FindBy(id="add_post_title")
	private WebElement commenttitle;
	
	@FindBy(id="add_post_save")
	private WebElement savecomment;
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
		
	public void clickLoginBtn() {
			this.loginBtn.click(); 
			
	}
		
	public void clickCourseCatalogue() {
			this.coursecatalogue.click();
	}
	
	public void Sendsearchterm() {
		this.searchterm.clear();
		this.searchterm.sendKeys("Selenium webdriver course by manipal_22");
	}
	
	public void clicksearch() {
		this.search.click();
	}
	
	public void finditem()
	{
		Actions action=new Actions(driver);
		action.moveToElement(item).build().perform();
		
	}
	public void clicksubscribe() {
		this.subscribe.click();
	}
	
	public void clickcoursetitle() {
		this.coursetitle.click();
	}
	
	public void clickprojecttitle()
	{
		this.projecttitle.click();
	}
	
	public void clickusermanagement() {
		this.usermanagement.click();
	}
	
	public void clickcheckbox() {
		this.checkbox.click();
	}
	
	public void clickregister() {
		this.register.click();
	}
	
	public void clicktask() {
		this.task.click();
	}
	
	public void sendcommenttitle() {
		this.commenttitle.clear();
		this.commenttitle.sendKeys("Adding a comment");
	}
	
	public void sendcomment() {
		List<WebElement> framelist=driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//body")).sendKeys("I'm able to comment");
		driver.switchTo().defaultContent();
	}
	
	public void clicksavecomment() {
		this.savecomment.click();
	}
	
	public void commentisdisplayed() {
		String comment=driver.findElement(By.xpath("//*[@id='blog-header']/div[2]/article/div[2]/p")).getText();
		System.out.println(comment);
	}
	
		
		
		}



		
		