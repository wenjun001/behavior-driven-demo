package guru99bank.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99BalanceEnquiryPage {
	private WebDriver driver;
	
	@FindBy(name = "accountno")
	private WebElement accountno;
	
	@FindBy(name = "AccSubmit")
	private WebElement submitButton;
	
	public Guru99BalanceEnquiryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public Guru99BalanceResultPage submitQuery(String acct) {
		accountno.clear();
		accountno.sendKeys(acct);
		submitButton.click();
		return new Guru99BalanceResultPage(driver);
	}
}
