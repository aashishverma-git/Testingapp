package TestCases;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
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
import BrowserInitializeDetails.VerifyRatings;

public class Brevistay {
	WebDriver driver;
	PageSearch objpagesearch = new PageSearch();
	Pattern p;
	Matcher m;
	static String totalcountafterfilter = null, totalcount = null;

	@BeforeTest
	@Parameters("browsername")
	public void browser(String browser) {
		driver = InitializeBrowser.initialBrowser(browser);
	}

	@Test(description = "Launch homepage", priority = 1)
	public void launchHomepage() throws InterruptedException {
		objpagesearch.homepage(driver);
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		// Assert.assertEquals(actualtitle, "selenium - Google Search", "Title
		// matched......");
		// Shutterbug.shootPage(driver, Capture.FULL_SCROLL, 500,
		// true).save("C:\\Users\\aashi\\OneDrive\\Desktop\\NewPage.jpeg");
	}

	//@Test(description = "Verify Link status on homepage", priority = 2)
	//public void checkLinkStatus() throws InterruptedException {
		//objpagesearch.checkLinkStatusonHomepage(driver);
	//}

	@Test(description = "Login Check", priority = 3)
	public void login() throws InterruptedException {

		Boolean verifylogin = objpagesearch.login(driver);
		Assert.assertTrue(verifylogin);
		System.out.println("Successful Login..");
	}

	@Test(description = "Seach data with respective city", priority = 4)
	@Parameters("city")
	public void selectCity(String city) {
		String cityresultwithtotalcount = objpagesearch.selectCity(driver, city);
		p = Pattern.compile("\\d+");
		m = p.matcher(cityresultwithtotalcount);
		while (m.find()) {
			totalcount = m.group();
		}
		Assert.assertEquals("Showing  193  Best " + city + " Hotels", cityresultwithtotalcount);
		System.out.println("Hotels displayed... " + totalcount);

	}

	@Test(description = "Verify after filter applied", priority = 5)
	public void verifyingAreaFilter() throws InterruptedException {
		String afterfilter = objpagesearch.areaFilter();

		p = Pattern.compile("\\d+");
		m = p.matcher(afterfilter);

		while (m.find()) {
			totalcountafterfilter = m.group();
		}
		System.out.println("Hotels displayed after filter... " + totalcountafterfilter);
		boolean check = false;
		if (Integer.parseInt(totalcountafterfilter) <= Integer.parseInt(totalcount)) {
			check = true;
		}
		Assert.assertTrue(check);
		System.out.println("filter applied...");

	}

	@Test(description = "Apply filter couple friendly.", priority = 6)
	public void verifyingCoupleFriendly() throws InterruptedException {
		String checkcouplef = objpagesearch.couplefriendly();
		Assert.assertEquals(checkcouplef, "Couple Friendly");
		System.out.println("Couple fiendly filter applied...");

	}

	@Test(description = "Apply filter couple friendly with Pay at Hotel.", priority = 7)
	public void verifyingCoupleFriendlywithpah() throws InterruptedException {
		String checkcouplefwithpah = objpagesearch.couplefriendlywithPAH();
		Assert.assertEquals(checkcouplefwithpah, "Pay At Hotel");
		System.out.println("Couple fiendly with Pay at Hotel filter applied...");

	}

	/*
	 * @AfterTest public void tearDown() { driver.quit(); }
	 */

}
