package guru99bank.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99CustomerResultPage {
private WebDriver driver;
	


	@FindBy(name = "gender")
	private WebElement gender;
	
	@FindBy(name = "dob")
	private WebElement dob;
	
	@FindBy(name = "name")
	private WebElement customerName;
	
	public Guru99CustomerResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	

	public String getGender() {
		return gender.getAttribute("value");
	}



	public String getDob() {
		return dob.getAttribute("value");
	}
	

	public String getCustomerName() {
		return customerName.getAttribute("value");
	}

	
	
	

}
