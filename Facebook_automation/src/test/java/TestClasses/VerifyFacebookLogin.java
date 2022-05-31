

package TestClasses;



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

import pomClasses.LoginPage;

public class VerifyFacebookLogin {
	
	WebDriver driver;
	LoginPage loginpage;
	
	@Parameters ("browserName")
	@BeforeTest
	private void lunchBrowser(String browser) {
		System.out.println("browser");
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = browsers.Base.openChromeDriver();
		}
//		if(browser.equals("Firefox"))
//		{
//			driver = browsers.Base.openFirefoxBrowser();
//		}
//		if(browser.equalsIgnoreCase("Edge"))
//		{
//			driver = browsers.Base.EdgeBrowser();
//		}
         // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@BeforeClass
	public void createObject()
	{
		loginpage = new LoginPage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		   this.driver.get("https://www.facebook.com/login/");
		    loginpage.sendemail();
	        loginpage.sendpass();
	        loginpage.clicklogin();  
	}
	
	@Test
	public void verifyTaskTab() throws InterruptedException
	{
		loginpage.clicklogin();  
		 String url = driver.getCurrentUrl();
		 String title = driver.getTitle();
	        Assert.assertEquals("https://www.facebook.com/login/",url);
	        Assert.assertEquals("Facebook", title);     
	}
//	@Test
//	public void verifytaskinvalid()
//	{
//		
//        loginpage.sendinvalidemail();
//        loginpage.sendinvalidpass();
//        loginpage.clicklogin();
//        
//		String error = loginpage.errorM.getText();
//		System.out.println(error);
//		String title = driver.getTitle();
//		Assert.assertEquals("Log in to Facebook", title);
//		
//	}
	
	@AfterMethod
	public void logoutFromApplication() throws InterruptedException
	{ 
		
	        loginpage.clickprofile();
	        Thread.sleep(2000);
	        loginpage.clicklogout();
	}      
	   @AfterClass
	   private void clearObject() {
		   loginpage = null;
	}
	   @AfterTest
		public void closeBrowser()
		{
			driver.close();
			driver = null;
			System.gc();
}
}