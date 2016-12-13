package guru99bank.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import guru99bank.pom.Guru99HomePage;
import guru99bank.pom.Guru99LoginPage;

import static org.junit.Assert.*;

public class Guru99LoginStepDefs {
	private WebDriver driver;
	private Guru99LoginPage login;
	private Guru99HomePage home;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", 
			"./drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given("a user is on the login page")
	public void userIsOnLoginPage() {
		login = new Guru99LoginPage(driver);
	}
	
	@When("he enters \"([^\"]*)\" as user id")
	public void userEntersUserId(String uid) {
		login.setUserId(uid);
	}
	
	@And("he enters \"([^\"]*)\" as password")
	public void userEntersPassword(String password) {
		login.setPassword(password);
	}
	
	@And("he clicks the Login button")
	public void userClicksLoginButton() {
		home = login.clickLogin();
	}
	
	@Then("ensures the manager id is \"([^\"]*)\"")
	public void ensureManagerId(String mid) {
		assertTrue(home.getWelcomeMessage().endsWith(mid));
	}
}
