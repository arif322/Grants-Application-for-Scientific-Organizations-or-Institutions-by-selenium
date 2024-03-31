package Pages;

import org.openqa.selenium.*;
import org.testng.annotations.*;
import Utilities.ExtentITestListenerClassAdapter;
import Utilities.MasterData;





@Listeners(ExtentITestListenerClassAdapter.class)
public class LoginPage extends ExtentITestListenerClassAdapter {

	MasterData info =  new MasterData();

	@Test
	public void loginPages() throws Exception{
		driver.get(info.baseUrl);

		//		driver.get("https://translate.google.com/");

		Thread.sleep(3000);




		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		Thread.sleep(1500);

		WebElement userName= driver.findElement(By.id("loginForm_username"));
		userName.click();
		userName.clear();
		userName.sendKeys(info.userName);

		WebElement passWord = driver.findElement(By.id("loginForm_password"));
		passWord.click();
		passWord.clear();
		passWord.isDisplayed();
		passWord.sendKeys(info.password);


		WebElement remember = driver.findElement(By.id("loginForm_remember"));
		remember.click();

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		Thread.sleep(1500);



	}


}


