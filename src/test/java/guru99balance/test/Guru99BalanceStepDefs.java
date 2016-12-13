package guru99balance.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import guru99bank.pom.Guru99BalanceEnquiryPage;
import guru99bank.pom.Guru99BalanceResultPage;
import guru99bank.pom.Guru99HomePage;
import guru99bank.pom.Guru99LoginPage;

import static org.junit.Assert.*;

public class Guru99BalanceStepDefs {
	private WebDriver driver;
	private Guru99HomePage home;
	private Guru99BalanceEnquiryPage enquiry;
	private Guru99BalanceResultPage result;
	
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
	
	@Given("a user has logged in user id \"([^\"]*)\" and password \"([^\"]*)\"")
	public void userHasLoggedIn(String uid, String pwd) {
		Guru99LoginPage login = new Guru99LoginPage(driver);
		home = login.login(uid, pwd);
	}
	
	@And("the user is on the Balance Enquiry page")
	public void userIsOnBalanceEnquiryPage() {
		enquiry = home.clickBalanceEnquiry();
	}
	
	@When("he submits \"([^\"]*)\" as account no")
	public void userSubmitsAccountNo(String ano) {
		result = enquiry.submitQuery(ano);
	}
	
	@Then("ensures the account type is \"([^\"]*)\"")
	public void userEnsuresAccountType(String atype) {
		assertEquals(atype, result.getAccountType());
	}
	
	@And("ensures the balance is \"([^\"]*)\"")
	public void userEnsuresBalance(String balance) {
		assertEquals(balance, result.getBalance());
	}
}
