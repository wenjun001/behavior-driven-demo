package guru99customer.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import guru99bank.pom.Guru99CustomerEnquiryPage;
import guru99bank.pom.Guru99CustomerResultPage;
import guru99bank.pom.Guru99HomePage;
import guru99bank.pom.Guru99LoginPage;

import static org.junit.Assert.*;

public class Guru99CustomerStepDefs {
	private WebDriver driver;
	private Guru99HomePage home;
	private Guru99CustomerEnquiryPage enquiry;
	private Guru99CustomerResultPage result;
	
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
	
	@And("the user is on the Edit Customer page")
	public void userIsOnBalanceEnquiryPage() {
		enquiry = home.clickCustomerEnquiry();
	}
	
	@When("he submits \"([^\"]*)\" as customer id")
	public void userSubmitsCustomerNo(String customerId) {
		result = enquiry.submitQuery(customerId);
	}
	

	@Then("ensures the customer name is \"([^\"]*)\"")
	public void userEnsuresCustomerName(String customerName) {
		assertEquals(customerName, result.getCustomerName());
	}
	
	@And("ensures the customer gender is \"([^\"]*)\"")
	public void userEnsuresCustomerGender(String gender) {
		assertEquals(gender, result.getGender());
	}
	
	@And("ensures that DoB is \"([^\"]*)\"")
	public void userEnsuresDOB(String dob) {
		assertEquals(dob, result.getDob());
	}
}
