package BrowserInitializeDetails;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageSearch {
	WebDriver driver;
	public void homepage(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		driver.get("https://www.brevistay.com/");
		driver.manage().window().maximize();
	}

	public void checkLinkStatusonHomepage(WebDriver driver) throws InterruptedException {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement link : links) {
            String url = link.getAttribute("href");
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                int responseCode = connection.getResponseCode();
                System.out.println("Link: " + url + " - Status code: " + responseCode);
            } catch (Exception e) {
                System.out.println("Error checking link " + url + ": " + e.getMessage());
	}
	
		}
	}

	public boolean login(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='Login / Sign Up']")).click();

		WebElement mobnum = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
		mobnum.sendKeys("9756601459");

		driver.findElement(By.xpath("//button[normalize-space()='Use password']")).click();

		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("123");

		driver.findElement(By.xpath("//button[@name='verifypassword']")).click();

		Thread.sleep(2000);

		WebElement profileButton = driver
				.findElement(By.xpath("//button[@id='headlessui-popover-button-:rn:']//*[name()='svg']"));
		profileButton.click();

		WebElement buttonElement = driver.findElement(By.xpath("//a[@href='/userprofile']"));
		// Check if the button is displayed
		boolean isDisplayed = buttonElement.isEnabled();
		profileButton.click();
		return isDisplayed;

	}

	public String selectCity(WebDriver driver, String city) {
		WebElement cityXDropdownElement = driver.findElement(By.xpath("//*[@id='headlessui-combobox-input-:r6:']"));
		cityXDropdownElement.click();
		WebElement selectcity = driver.findElement(By.xpath("//span[normalize-space()='Hyderabad']"));
		selectcity.click();
		WebElement searchButton = driver.findElement(By.xpath("//button[normalize-space()='Search']"));
		searchButton.click();

		// WebElement hyderabad =
		// driver.findElement(By.xpath("//p[@class='text-[1.125rem] font-poppins
		// text-primary capitalize']"));
		// String hyderabadlList = hyderabad.getText();

		WebElement totalcountforselectedcity = driver
				.findElement(By.xpath("//*[@id=\'__next\']/div/div/div/div/div[3]/div[2]/h2"));
		String totalcount = totalcountforselectedcity.getText();
		System.out.println(totalcount);

		return totalcount;
	}

	public String areaFilter() throws InterruptedException {
		WebElement inputText = driver.findElement(By.xpath("(//input[@placeholder='Search Areas in hyderabad'])"));
		inputText.click();
		inputText.sendKeys("M.g");
		WebElement suggestions = driver.findElement(By.xpath("//span[normalize-space()='M.G. Road']"));
		suggestions.click();
		Thread.sleep(2000);
		WebElement afterfilter = driver.findElement(By.xpath("//*[@id=\'__next\']/div/div/div/div/div[3]/div[2]/h2"));
		String totalcountafterfilter = afterfilter.getText();
		System.out.println(totalcountafterfilter);
		return totalcountafterfilter;

	}

	public String couplefriendly() throws InterruptedException {
		WebElement categorcouplefriendly = driver.findElement(By.xpath("//span[contains(text(),'Couple Friendly')]"));
		categorcouplefriendly.click();
		Thread.sleep(1000);
		WebElement couplefriendly = driver
				.findElement(By.xpath("//a[contains(@title,'The Manohar')]//p[contains(text(),'Couple Friendly')]"));
		String checkcouplefriendly = couplefriendly.getText();
		return checkcouplefriendly;

	}

	public String couplefriendlywithPAH() throws InterruptedException {
		WebElement categorcouplefriendlywithpah = driver
				.findElement(By.xpath("	//span[contains(text(),'Pay At Hotel')]"));
		categorcouplefriendlywithpah.click();
		Thread.sleep(1000);

		WebElement couplefriendlywithpah = driver.findElement(
				By.xpath("// a[contains(@title,'Hotel Heavens Inn')]//p[contains(text(),'Pay At Hotel')]"));
		String checkcouplefriendlywithpah = couplefriendlywithpah.getText();
		return checkcouplefriendlywithpah;

	}

}
