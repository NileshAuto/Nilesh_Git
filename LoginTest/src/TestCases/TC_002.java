package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HomePage.Homepage;
import Loginpage.Login;

public class TC_002 {

	WebDriver driver;
	Login lp;
	Homepage hp;
	  @BeforeTest
	  
  public void openapp() {
	driver=new FirefoxDriver();
	driver.get("http://automationpractice.com/index.php?");
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().window().maximize();
	  
	  }
	  @Test
	  public void loginapp() {
		  lp = new Login(driver);
		  lp.loginby("test122@gmail.com", "test1234");
		  hp= new Homepage(driver);
		String logout=  hp.logoutbtn.getAttribute("class");
	Assert.assertEquals(logout, "logout");
	  }
	
	  
	  
	  
	  
	  
	  @AfterMethod
		public void closedriver() {
			driver.close();
		}  
  }



