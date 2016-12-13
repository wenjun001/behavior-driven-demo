package guru99bank.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99LoginPage {
	private WebDriver driver;
	
	@FindBy(name = "uid")
	private WebElement useridField;
	
	@FindBy(name = "password")
	private WebElement passwordField;
	
	@FindBy(name = "btnLogin")
	private WebElement loginButton;
	
	private String url = "http://demo.guru99.com/v4/";
	
	public Guru99LoginPage(WebDriver driver) {
		this.driver = driver;
		this.driver.get(url);
		PageFactory.initElements(this.driver, this);
	}
	
	public void setUserId(String uid) {
		useridField.clear();
		useridField.sendKeys(uid);
	}
	
	public void setPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}
	
	public Guru99HomePage clickLogin() {
		loginButton.click();
		return new Guru99HomePage(driver);
	}
	
	public Guru99HomePage login(String uid, String pwd) {
		setUserId(uid);
		setPassword(pwd);
		return clickLogin();
	}
}
