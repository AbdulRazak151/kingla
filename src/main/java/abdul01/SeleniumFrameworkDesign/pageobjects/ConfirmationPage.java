package abdul01.SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abdul01.SeleniumFrameworkDesign.AbstractComponents.AbstractComponenet;

public class ConfirmationPage extends AbstractComponenet {
WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	public String verifyConfirmationMessage() {
		return confirmationMessage.getText();
	}
	

}
