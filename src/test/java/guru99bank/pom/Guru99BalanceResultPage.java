package guru99bank.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99BalanceResultPage {
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"balenquiry\"]/tbody/tr[11]/td[2]")
	private WebElement acctType;
	
	@FindBy(xpath = "//*[@id=\"balenquiry\"]/tbody/tr[16]/td[2]")
	private WebElement balance;
	
	public Guru99BalanceResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public String getAccountType() {
		return acctType.getText();
	}
	
	public String getBalance() {
		return balance.getText();
	}
}
