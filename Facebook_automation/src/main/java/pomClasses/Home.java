package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
 
	@FindBy(xpath =("//div[@aria-label='Menu']"))
	private WebElement menu ;
	
	@FindBy(xpath =("//span[text()='Post']"))
	private WebElement post;
	
	@FindBy(xpath ="(//span[text()='Friends'])[2]")
	public WebElement friends;
	
	@FindBy(xpath ="//div[@aria-label='Close']")
	public WebElement close;
	
	
	
	public Home(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickmenu() {
	menu.click();
}
	public void clickpost() {
	post.click();
	}
	public void clickclose() {
		close.click();
	}
	
	
	
	
}
