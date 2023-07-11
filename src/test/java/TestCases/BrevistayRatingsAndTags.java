package TestCases;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BrowserInitializeDetails.InitializeBrowser;
import BrowserInitializeDetails.PageSearch;
import BrowserInitializeDetails.VerifyRatings;

public class BrevistayRatingsAndTags {
	WebDriver driver;
	PageSearch objpagesearch = new PageSearch();
	VerifyRatings objVerifyRatings = new VerifyRatings();
	Pattern p;
	Matcher m;
	static String totalcountafterfilter = null, totalcount = null;

	@BeforeTest

	@Parameters({ "browsername", "city" })
	public void prerequisites(String browser, String city) throws InterruptedException {
		driver = InitializeBrowser.initialBrowser(browser);
		objpagesearch.homepage(driver);
		objpagesearch.login(driver);
		objpagesearch.selectCity(driver, city);
	}

	@Test(description = "Verify Ratings with four and half", priority = 1)
	public void verifyRatingFourAndHalf() throws InterruptedException, IOException {

		objVerifyRatings.verifyRatingsFourAndHalf();

	}

	@Test(description = "Verify Premium Tag", priority = 2)
	public void verifyingPremiumTag() throws InterruptedException {

		objVerifyRatings.verifyingPremiumTag();

	}

	@Test(description = "Verify Luxury Tag", priority = 3)
	public void verifyingLuxuryTag() throws InterruptedException {

		objVerifyRatings.verifyingLuxuryTag();

	}

}
