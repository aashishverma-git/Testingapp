package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LearnigClass {
	WebDriver driver;
	
	@Test(dataProvider ="logindata", dataProviderClass=DataSupplier.class)
	public void loginPage(String username, String password) {
		//WebElement u = driver.findElement(By.id("user"));
		// WebElement p = driver.findElement(By.id("user"));
		System.out.print(username + " " + password);
		
	}
	
	
}
