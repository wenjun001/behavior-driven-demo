package guru99bank.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99HomePage {
	private WebDriver driver;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")
	private WebElement welcome;
	
	@FindBy(css = "a[href='BalEnqInput.php']")
	private WebElement balanceEnquiryEntry;
	
	@FindBy(css = "a[href='EditCustomer.php']")
	private WebElement customerEnquiryEntry;
	
	public Guru99HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public String getWelcomeMessage() {
		return welcome.getText();
	}
	
	public Guru99BalanceEnquiryPage clickBalanceEnquiry() {
		balanceEnquiryEntry.click();
		return new Guru99BalanceEnquiryPage(driver);
	}
	

	public Guru99CustomerEnquiryPage clickCustomerEnquiry() {
		customerEnquiryEntry.click();
		return new Guru99CustomerEnquiryPage(driver);
	}
}
