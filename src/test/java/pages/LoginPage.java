package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='formEmail']")
	public WebElement txt_UserID;
	@FindBy(xpath = "//input[@id='formPassword']")
	public WebElement txt_Password;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement btn_Login;
	@FindBy(xpath = "//img[@class='passowrd-visible']")
	public WebElement icn_Eye;
	@FindBy(xpath = "//p[@class='normal-text']")
	public WebElement msg_ErrorNotice;

	public void enterUserName(String userName) {
		txt_UserID.clear();
		txt_UserID.sendKeys(userName);
	}

	public void enterPassword(String password) {
		txt_Password.clear();
		txt_Password.sendKeys(password);
	}

	public void clickLoginBtn() {
		myWait.until(ExpectedConditions.elementToBeClickable(btn_Login)).click();
	}

	public void toggleEyeIcon() {
		icn_Eye.click();
	}

	public String getErrorText() {
		return msg_ErrorNotice.getText();
	}
}
