package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import HomePage.Homepage;
import Loginpage.Login;

public class TC_003 {
	WebDriver driver;
	Login lp;
	Homepage hp;
	String logouttittle = "logout";

	@BeforeTest
	public void openurl() {

	}

	@DataProvider(name = "setofdata")
	public Object[][] getData() {
		Object[][] obj = new Object[3][2];
		obj[0][0] = "test122@gmail.com";
		obj[0][1] = "tes";
		obj[1][0] = "test";
		obj[1][1] = "test1234";
		obj[2][0] = "";
		obj[2][1] = "";
		return obj;
	}

	@Test(dataProvider = "setofdata")
	public void login(String username, String password) {
	//	open application
		driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php?");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	//create object for loginpage
		lp = new Login(driver);
		lp.loginbtn.click();

		lp.txt_username.sendKeys(username);
		lp.txt_password.sendKeys(password);
		lp.submit.click();
		String valmsg = lp.validationmessage.getText();
		System.out.println(valmsg);

		if (lp.validationmessage.getText().equalsIgnoreCase("Invalid password.")) {
			Assert.assertEquals(lp.validationmessage.getText(), "Invalid password.", "invalid passowrd");
		} else if (lp.validationmessage.getText().equalsIgnoreCase("Invalid email address.")) {
			Assert.assertEquals(lp.validationmessage.getText(), "Invalid email address.", "Invalid email address.");
		} else if (lp.validationmessage.getText().equalsIgnoreCase("An email address required.")) {
			Assert.assertEquals(lp.validationmessage.getText(), "An email address required.",
					"An email address required.");
		}

	}

	@AfterMethod
	public void closedriver() {
		driver.close();
	}

}
