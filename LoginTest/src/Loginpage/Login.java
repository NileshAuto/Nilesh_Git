package Loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver driver;





 public Login(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

	@FindBy(xpath = "//*[@class='login']")
	public WebElement loginbtn;

	@FindBy(xpath = "//*[@id='email']")
	public WebElement txt_username;

	@FindBy(xpath = ".//*[@id='passwd']")
	public WebElement txt_password;

	@FindBy(xpath = ".//*[@id='SubmitLogin']")
	public WebElement submit;
	
	@FindBy(xpath="//*[@class='alert alert-danger']//li")
	public WebElement validationmessage;
	
	@FindBy(xpath="//a[@title='Recover your forgotten password']")
	public WebElement forgetpswd;
	
	

	public void loginby(String username, String password) {
		loginbtn.click();
		txt_username.sendKeys(username);
		txt_password.sendKeys(password);
		submit.click();
	}

}
