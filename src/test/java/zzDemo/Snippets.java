package zzDemo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Snippets {

	public static void main(String[] args) {

		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissions.default.desktop-notification", 2);

		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);

		WebDriver driver = new FirefoxDriver(options);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://dev-dash.janitri.in/");
		driver.findElement(By.xpath("//input[@id='formEmail']")).sendKeys("abcxyz");
		driver.findElement(By.xpath("//input[@id='formPassword']")).sendKeys("123456");
		driver.findElement(By.xpath("//img[@alt='Password Not Visible']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		List<WebElement> inputFields = new ArrayList<WebElement>();
		inputFields.add(driver.findElement(By.xpath("//input[@id='formEmail']")));
		inputFields.add(driver.findElement(By.xpath("//input[@id='formPassword']")));
		inputFields.add(driver.findElement(By.xpath("//button[@type='submit']")));

		boolean elementPresence = true;
		for (int i = 0; i < inputFields.size(); i++) {
			if (!inputFields.get(i).isDisplayed()) {
				elementPresence = false;
			} else
				elementPresence = true;
		}

		System.out.println("Titles match?: " + (driver.getTitle().equals("Janitri") ? "Match" : "No Match"));
		System.out.println("All elements present?: " + (elementPresence ? "Yes" : "No"));
		System.out.println("Eye Icon is Visible?: "
				+ (driver.findElement(By.xpath("//img[@class='passowrd-visible']")).isDisplayed() ? "Yes" : "No"));

		driver.quit();
	}

}