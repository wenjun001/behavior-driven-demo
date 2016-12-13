package bmicalculate.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class BmiCalculateStepDefs {
	private WebDriver driver;
	private BmiPage page;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", 
			"./drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given("the user is on the BMI Calculate page")
	public void theUserIsOnBmiPage() {
		page = new BmiPage(driver);
	}
	
	@When("he calculate BMI using \"([^\"]*)\" as height and \"([^\"]*)\" as weight")
	public void heCalculateBmi(String height, String weight) {
		page.calculateBmi(height, weight);
	}
	
	@When("he enters \"([^\"]*)\" as height")
	public void heEntersHeight(String height) {
		page.setHeight(height);
	}
	
	@And("he enters \"([^\"]*)\" as weight")
	public void heEntersWeight(String weight) {
		page.setWeight(weight);
	}
	
	@And("he clicks the Calculate button")
	public void heClicksButton() {
		page.calculate();
	}
	
	@Then("ensure the bmi category is \"([^\"]*)\"")
	public void ensureBmiCategory(String category) {
		assertEquals(category, page.getBmiCategory());
	}
	
	@And("ensure the bmi value is \"([^\"]*)\"")
	public void ensureBmiValue(String bmiValue) {
		assertEquals(bmiValue, page.getBmiValue());
	}
}
