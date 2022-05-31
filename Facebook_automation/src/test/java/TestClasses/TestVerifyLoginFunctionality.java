package TestClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.LoginPage;

public class TestVerifyLoginFunctionality {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/login/");
        
        LoginPage loginpage = new LoginPage(driver);
        loginpage.sendemail();
        loginpage.sendpass();
        loginpage.clicklogin();
        
        
        
        String url = driver.getCurrentUrl();
        if(url.equals("https://www.facebook.com/?sk=welcome"))
        {
        	System.out.println("pass");
        }
        else
        {
        	System.out.println("fail");
        }
//        
//        Thread.sleep(2000);
//        loginpage.clickprofile();
//        Thread.sleep(2000);
//        loginpage.clicklogout();
//        
        
        
        
        
        
        
        
        
        
        
	}
	
	
	
}
