package guru99bank.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99CustomerEnquiryPage {
	private WebDriver driver;
	
	@FindBy(name = "cusid")
	private WebElement customerno;
	
	@FindBy(name = "AccSubmit")
	private WebElement submitButton;
	
	public Guru99CustomerEnquiryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	


	public Guru99CustomerResultPage submitQuery(String acct) {
		customerno.clear();
		customerno.sendKeys(acct);
		submitButton.click();
		return new Guru99CustomerResultPage(driver);
	}
}
