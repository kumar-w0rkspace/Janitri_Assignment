package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class TestCase extends BaseClass {
	LoginPage lp;

	@Test(priority = 1, dependsOnMethods = { "checkPageElementsPresence" })
	public void testLoginButtonDisabledWhenFieldAreEmpty() {
		lp = new LoginPage(driver);
		Assert.assertFalse(lp.btn_Login.isEnabled(), "Login button is not disabled while cred fields are empty");

	}

	@Test(priority = 2, dependsOnMethods = { "checkPageElementsPresence" })
	public void testInvalidLoginShowErrorMsg() {
		lp = new LoginPage(driver);
		lp.enterUserName("JamesDoe");
		lp.enterPassword("John123");
		lp.clickLoginBtn();
		Assert.assertTrue(lp.msg_ErrorNotice.isDisplayed(), "Error msg must be displayed for invalid cred");
		System.out.println("Captured msg :" + lp.getErrorText());
	}

	@Test(priority = 3, dependsOnMethods = { "checkPageElementsPresence" })
	public void testPasswordMaskedbutton() {
		lp = new LoginPage(driver);
		Assert.assertEquals(lp.txt_Password.getAttribute("type"), "password", "Password should be masked initially");
		lp.icn_Eye.click();
		Assert.assertEquals(lp.txt_Password.getAttribute("type"), "text", "Password should be visible after toggle");
		lp.icn_Eye.click();
		Assert.assertEquals(lp.txt_Password.getAttribute("type"), "password",
				"Password should be masked again after toggling again");
	}

	@Test
	public void checkPageElementsPresence() {
		lp = new LoginPage(driver);
		Assert.assertTrue(driver.getTitle().equals("Janitri"), "Title dont match");
		Assert.assertTrue(lp.txt_UserID.isDisplayed(), "UserID field is not displayed");
		Assert.assertTrue(lp.txt_Password.isDisplayed(), "Password field is not displayed");
		Assert.assertTrue(lp.btn_Login.isEnabled(), "Login Button is not enabled");
		Assert.assertTrue(lp.icn_Eye.isDisplayed(), "Eye icon field is not displayed");
	}

}
