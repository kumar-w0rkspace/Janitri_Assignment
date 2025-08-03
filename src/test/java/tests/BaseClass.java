package tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	WebDriver driver;

	@BeforeClass
	@Parameters({ "browser" })
	public void setup(String browser) {

		switch (browser.toLowerCase()) {
		case "firefox":
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("permissions.default.desktop-notification", 2);

			FirefoxOptions optionsF = new FirefoxOptions();
			optionsF.setProfile(profile);
			driver = new FirefoxDriver(optionsF);

			break;
		case "chrome":
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.default_content_setting_values.notifications", 2);

			ChromeOptions optionsC = new ChromeOptions();
			optionsC.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(optionsC);
			break;
		case "edge":
			Map<String, Object> edgePrefs = new HashMap<>();
			edgePrefs.put("profile.default_content_setting_values.notifications", 2);

			EdgeOptions optionsE = new EdgeOptions();
			optionsE.setExperimentalOption("prefs", edgePrefs);

			driver = new EdgeDriver(optionsE);
			break;
		default:
			System.out.println("Invalid browser name");
			return;
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://dev-dash.janitri.in/");

	}

	@AfterClass
	public void teardown() {

		driver.close();
	}

}
