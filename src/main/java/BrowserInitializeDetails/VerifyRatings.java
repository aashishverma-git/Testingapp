package BrowserInitializeDetails;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyRatings extends InitializeBrowser {

public Properties readPropertyFile() throws IOException {
	Properties prop = new Properties();
	File file = new File("C:\\Users\\aashi\\OneDrive\\Desktop\\Xpath.properties");
	 FileReader reader = new FileReader(file);
     prop.load(reader);
	return prop;

}
	public void verifyRatingsFourAndHalf() throws InterruptedException, IOException {
        Properties p = readPropertyFile();
        System.out.println(p.getProperty("ratingfourandhalf"));
		//WebElement ratingfourandhalf = driver.findElement(By.xpath("(//input[contains(@type,'radio')])[2]"));
        WebElement ratingfourandhalf = driver.findElement(By.xpath(p.getProperty("ratingfourandhalf")));
        ratingfourandhalf.click();

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");

		WebElement clickto = driver.findElement(By.xpath("//h3[contains(text(),'Click To Load More')]"));
		clickto.click();

		Thread.sleep(2000);
		List<WebElement> all = driver.findElements(By.tagName("a"));
		System.out.println(all.size());
		int l = 0;
		for (int i = 2; i < all.size(); i++) {
			if (i % 2 != 0) {
				l++;
				String pathforreviews = "(//span[starts-with(@class,'ml-0.5')])" + "[" + l + "]";
				WebElement reviews = driver.findElement(By.xpath(pathforreviews));
				System.out.println(all.get(i).getAttribute("href") + "=====" + reviews.getText());
			}
		}

	}
	
	public void verifyingPremiumTag() throws InterruptedException {
		WebElement clearall = driver.findElement(By.xpath("//button[normalize-space()='Clear All']"));
		clearall.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		 Thread.sleep(1000);
		WebElement premium = driver.findElement(By.xpath("(//input[starts-with(@class,'w-5 cur')])[6]"));
		premium.click();
		Thread.sleep(1000);
		WebElement premiumhotelcount = driver.findElement(By.xpath("//*[@id=\'__next\']/div/div/div/div/div[3]/div[2]/h2"));
		System.out.println(premiumhotelcount.getText());
		
	}
	

	public void verifyingLuxuryTag() throws InterruptedException {
		WebElement clearAll = driver.findElement(By.xpath("//button[normalize-space()='Clear All']"));
		clearAll.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		 Thread.sleep(1000);
		WebElement luxury = driver.findElement(By.xpath("(//input[starts-with(@class,'w-5 h')])[1]"));
		luxury.click();
		Thread.sleep(1000);
		WebElement premiumhotelcount = driver.findElement(By.xpath("//*[@id=\'__next\']/div/div/div/div/div[3]/div[2]/h2"));
		System.out.println(premiumhotelcount.getText());
		
	}
	
	

}
