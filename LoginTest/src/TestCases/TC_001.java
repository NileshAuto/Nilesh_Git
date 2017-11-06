package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Loginpage.Login;

public class TC_001 {
	WebDriver driver;
	Login lp;

	@BeforeTest
	public void openurl() {
		driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php?");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void isPresentcheck() {
		String title = "Login - My Store";
		// Check field present or not on login page
		lp = new Login(driver);
		boolean loginbtn = lp.loginbtn.isEnabled();
		System.out.println(loginbtn);
		Assert.assertTrue(loginbtn);
		lp.loginbtn.click();
		Assert.assertTrue(lp.txt_username.isDisplayed());
		Assert.assertTrue(lp.txt_password.isDisplayed());
		Assert.assertTrue(lp.submit.isDisplayed());
		Assert.assertTrue(lp.forgetpswd.isDisplayed());
		String actual = driver.getTitle();
		Assert.assertEquals(actual, title);
	}

	@AfterMethod
	public void closedriver() {
		driver.close();
	}
}
