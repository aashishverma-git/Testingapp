package LoginNewPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageNew {
	WebDriver driver;
	
	public LoginPageNew(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//button[@type='submit']") WebElement login_button;
	
	public void loginOragngeHRM(String uid, String pass) {
		username.sendKeys(uid);
		password.sendKeys(pass);
		login_button.click();
	}

}
