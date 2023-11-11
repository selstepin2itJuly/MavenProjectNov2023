package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testcases.LoginTest;

public class LoginPage {
	static final Logger logger = LogManager.getLogger(LoginPage.class.getName());
	private WebDriver d;
	public LoginPage(WebDriver dr)
	{
		logger.info("Login Page constructor");
		this.d=dr;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(css="input[name='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(css="button[type='submit']")
	private WebElement submit;
	
	@FindBy(xpath="//*[text()='Invalid credentials']")
	private WebElement error;
	
	@FindBy(xpath="//p[text()='Forgot your password? ']")
	private WebElement fgp;
	
	public void clickOnForgotPassword()
	{
		fgp.click();
	}
	public void loginToApplication(String user, String pass)
	{
		logger.info("Login to Application with User:"+user+ " "+ "Password:"+pass);
		username.clear();
		username.sendKeys(user);
		password.click();
		password.sendKeys(pass);
		submit.click();
	}
	
	public boolean isLoginPageDisplayed()
	{
		boolean b=false;
		try
		{
			b = username.isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("Login status->"+b);
		return b;
	}
	
	public boolean isErrorDisplayed()
	{
		boolean b=false;
		try
		{
			b = error.isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("Login status->"+b);
		return b;
	}
	
	
}
