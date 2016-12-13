package bmicalculate.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BmiPage {
	
	@FindBy(id = "heightCMS")
	private WebElement heightField;
	
	@FindBy(name = "weightKg")
	private WebElement weightField;
	
	@FindBy(how = How.CSS, using = "input[type='button']")
	private WebElement calculateBtn;
	
	@FindBy(id = "bmi")
	private WebElement bmiValueField;
	
	@FindBy(how = How.NAME, using = "bmi_category")
	private WebElement bmiCategoryField;
	
	private String url =
		"http://selenium-testing-winwust.c9users.io/bmicalculator.html";
	
	public BmiPage(WebDriver driver) {
		driver.get(url);
		PageFactory.initElements(driver, this);
	}
	
	public void setHeight(String height) {
		heightField.clear();
		heightField.sendKeys(height);
	}
	
	public void setWeight(String weight) {
		weightField.clear();
		weightField.sendKeys(weight);
	}
	
	public void calculate() {
		calculateBtn.click();
	}
	
	public String getBmiValue() {
		return bmiValueField.getAttribute("value");
	}
	
	public String getBmiCategory() {
		return bmiCategoryField.getAttribute("value");
	}
	
	public void calculateBmi(String height, String weight) {
		setHeight(height);
		setWeight(weight);
		calculate();
	}
}
