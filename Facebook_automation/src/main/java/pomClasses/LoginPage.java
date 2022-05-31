package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	

	@FindBy(xpath =("//input[@id='email']"))
	public WebElement email ;
	
	@FindBy(xpath =("//div[@class='_9ay5']"))
	public WebElement errorM ;
	
	@FindBy(xpath =("//input[@id='pass']"))
	private WebElement pass;
	
	@FindBy(xpath ="//button[text()='Log In']")
	private WebElement login;
	
	@FindBy(xpath ="(//div[@role='button'])[2]")
	private WebElement profile;
	
	@FindBy(xpath ="//span[text()='Log Out']")
	private WebElement logout;

	
	
	
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendemail() {
	email.sendKeys("9890603636");
    }
	public void sendpass() {
	pass.sendKeys("uday1234");
	}
	public void clicklogin() {
		login.click();
	}
	public void clickprofile() {
		profile.click();
	}
	public void clicklogout() {
		logout.click();
	}
    public void sendinvalidemail() {
		email.sendKeys("4568745656");	
	}
    public void sendinvalidpass() {
		pass.sendKeys("yrty4567");	
	}	   
	
}
