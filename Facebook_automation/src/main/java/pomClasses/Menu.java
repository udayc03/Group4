package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

	@FindBy(xpath =("(//div[@id='nav-xshop']//a)[1]"))
	private WebElement deal ;
	
	@FindBy(xpath =("(//div[@id='nav-xshop']//a)[2]"))
	private WebElement mobile;
	
	@FindBy(xpath ="(//div[@id='nav-xshop']//a)[3]")
	private WebElement service;
	
	@FindBy(xpath ="(//div[@id='nav-xshop']//a)[3]")
	private WebElement hello;
	
	
	public Menu(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickdeal() {
	deal.click();
}
	public void cliclevents() {
	mobile.click();
	}
	public void clickgroups() {
	service.click();
	}
	public void clickhello() {
	hello.click();
	}
}
