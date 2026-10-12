package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[text()='My Account']")
	WebElement inkMyAccount;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement inkRegister;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement linkLogin;
	
	public void clickMyAccount() {
		inkMyAccount.click();
	}
	
	public void clickRegister() {
		inkRegister.click();
	}
	
	public void clickLogin() {
		linkLogin.click();
	}
	
}
