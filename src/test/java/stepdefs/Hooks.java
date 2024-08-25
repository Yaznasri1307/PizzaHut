package stepdefs;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	public static WebDriver driver;
	public static ExtentReports reports = new ExtentReports("HtmlResults.html", false);
	public static ExtentTest test;
	@Before
	public void openBrowser(Scenario scenario) {
		test = reports.startTest(scenario.getName());
		driver= new FirefoxDriver();
	}
	@After
	public void closeBrowser() {
		driver.close();
		reports.endTest(test);
		reports.close();
	}
	public static String CaptureScreen(WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File target = new File("screenshot/" + ".png");

		String absolutepath = target.getAbsolutePath();

		FileUtils.copyFile(src, target);
		return absolutepath;

	}

	}
	
	
	
	

