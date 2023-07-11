package TestCases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import BrowserInitializeDetails.InitializeBrowser;
import BrowserInitializeDetails.PageSearch;

public class TestGooglePage {
	WebDriver driver;

	@BeforeTest
	@Parameters("browsername")
	public void browser(String browser) {
		driver = InitializeBrowser.initialBrowser(browser);
		

	}

	@Test
	public void testSearchData() throws InterruptedException {
		PageSearch p = new PageSearch();
		//p.pageSearch(driver);
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		Assert.assertEquals(actualtitle, "selenium - Google Search", "Title matched......");
		Shutterbug.shootPage(driver, Capture.FULL_SCROLL, 500, true).save("C:\\Users\\aashi\\OneDrive\\Desktop\\NewPage.jpeg");
		}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
