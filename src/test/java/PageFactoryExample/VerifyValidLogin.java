package PageFactoryExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import LoginNewPageFactory.LoginPageNew;

public class VerifyValidLogin {
	
	@Test
	public void checkValidUser() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		LoginPageNew login_page = PageFactory.initElements(driver, LoginPageNew.class);
		login_page.loginOragngeHRM("Admin", "admin123");
		Thread.sleep(3000);
		driver.quit();
	}

}
