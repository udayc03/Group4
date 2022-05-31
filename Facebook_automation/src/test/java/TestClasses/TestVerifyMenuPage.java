package TestClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pomClasses.Home;
import pomClasses.LoginPage;

public class TestVerifyMenuPage {
     WebDriver driver;
     LoginPage loginpage;
     Home home;
     
     @Parameters ("browserName")
 	@BeforeTest
 	private void lunchBrowser(String browser) {
 		System.out.println(browser);
 		
 		if(browser.equals("Chrome"))
 		{
 			driver = browsers.Base.openChromeDriver();
 		}
// 		if(browser.equals("Firefox"))
// 		{
// 			driver = browsers.Base.openFirefoxBrowser();
// 		}
// 		if(browser.equals("Edge"))
// 		{
// 			driver = browsers.Base.EdgeBrowser();
// 		}
//           driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     }  
     
	@BeforeClass
	public void beforeClass()
	{
		loginpage = new LoginPage(driver);
		home = new Home(driver);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		driver.get("https://www.facebook.com/login/");
		loginpage.sendemail();
        loginpage.sendpass();
        loginpage.clicklogin();
        
	}
	
	@Test
	public void verifytaskmenu() throws InterruptedException
	{
		home = new Home(driver);
		home.clickmenu();
		home.clickpost();
		Boolean button = home.friends.isDisplayed();
		home.clickclose();
		Assert.assertTrue(button);
	}
	@AfterMethod
	public void logoutFromApplication() throws InterruptedException
	{
		    loginpage.clickprofile(); 
	        loginpage.clicklogout();  
	}      
	   @AfterClass
	   private void clearObject() {
	      loginpage = null;
	      home = null;
   }
	   @AfterTest
	 		public void closeBrowser()
	 		{
	 			driver.close();
	 			driver = null;
	 			System.gc();
	 }
}