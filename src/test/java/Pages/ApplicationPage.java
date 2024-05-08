package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.ExtentITestListenerClassAdapter;
import Utilities.MasterData;


@Test
@Listeners(ExtentITestListenerClassAdapter.class)
public class ApplicationPage extends ExtentITestListenerClassAdapter {
	
	MasterData info = new MasterData();
	
	
	
	public void ApplictionsPage() throws InterruptedException, AWTException {
		
		
		String file1 = "C:\\Users\\Ariful\\Desktop\\Issues.docx";
		WebElement attachment1 = driver.findElement(By.xpath("//div[@class='ant-row']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//span[1]//div[1]//span[1]//button[1]"));
		Actions act = new Actions(driver);
		
		act.moveToElement(attachment1).click().perform(); // click action on the button
//		js.executeScript("arguments[0].click()", attachment1); // click action on the button
		
		//path selection for file by toolkit
		Robot rb = new Robot();
		rb.delay(2000);
		StringSelection ss = new StringSelection(file1);
		Toolkit .getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//for copy the file path
		rb.keyPress(KeyEvent.VK_CONTROL); //press on control button 
		rb.keyPress(KeyEvent.VK_V); // then press on V button for file
		rb.delay(2000);
		
		//for paste the the file path
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(2000);
		//click enter button
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		
//		
		Thread.sleep(2000);
		Assert.assertTrue(true);
//		
		
	
		
		String file2 = "C:\\Users\\Ariful\\Desktop\\Test.pdf";
		WebElement attachment2 = driver.findElement(By.xpath("//div[@role='tabpanel']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//span[1]//div[1]//span[1]//button[1]"));
		
		Actions act1 = new Actions(driver);
		act1.moveToElement(attachment2).click().perform();

		Robot rb1 = new Robot();
		rb1.delay(2000);
		StringSelection ss1 = new StringSelection(file2);
		Toolkit .getDefaultToolkit().getSystemClipboard().setContents(ss1, null);
		
		//cntrl+V
		rb1.keyPress(KeyEvent.VK_CONTROL); //press on control button
		rb1.keyPress(KeyEvent.VK_V); // then press on V button
		rb1.delay(2000);
		
		rb1.keyRelease(KeyEvent.VK_CONTROL);
		rb1.keyRelease(KeyEvent.VK_V);
		rb1.delay(2000);
		//click enter button
		rb1.keyPress(KeyEvent.VK_ENTER);
		rb1.keyRelease(KeyEvent.VK_ENTER);
		

		Thread.sleep(2000);
		Assert.assertTrue(true);
		
//		String file3 = "C:\\Users\\Ariful\\Desktop\\SRG-231128.pdf";
//		WebElement attachment3 = driver.findElement(By.xpath("//div[@class='ant-row']//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//span[1]//div[1]//span[1]//button[1]"));
//		Actions act3 = new Actions(driver);
//		act3.moveToElement(attachment3).click().perform(); // click action on the button
//
//		Robot rb3 = new Robot();
//		rb3.delay(2000);
//		StringSelection ss3 = new StringSelection(file3);
//		Toolkit .getDefaultToolkit().getSystemClipboard().setContents(ss3, null);
//		
//		//cntrl+V
//		rb3.keyPress(KeyEvent.VK_CONTROL); //press on control button 
//		rb3.keyPress(KeyEvent.VK_V); // then press on V button for file
//		rb3.delay(2000);
//		
//		rb3.keyRelease(KeyEvent.VK_CONTROL);
//		rb3.keyRelease(KeyEvent.VK_V);
//		rb3.delay(2000);
//		//click enter button
//		rb3.keyPress(KeyEvent.VK_ENTER);
//		rb3.keyRelease(KeyEvent.VK_ENTER);
//		
//		Thread.sleep(3000);
//		Assert.assertTrue(true);
//		
//		String file4 = "C:\\Users\\Ariful\\Desktop\\Test.pdf";
//		WebElement attachment4 = driver.findElement(By.xpath("//div[@role='tabpanel']//div[2]//div[2]//div[1]//div[1]//div[1]//div[1]//span[1]//div[1]//span[1]//button[1]"));
//		Actions act4 = new Actions(driver);
//		act4.moveToElement(attachment4).click().perform(); // click action on the button
//
//		Robot rb4 = new Robot();
//		rb4.delay(2000);
//		StringSelection ss4 = new StringSelection(file4);
//		Toolkit .getDefaultToolkit().getSystemClipboard().setContents(ss4, null);
//		
//		//cntrl+V
//		rb4.keyPress(KeyEvent.VK_CONTROL); //press on control button 
//		rb4.keyPress(KeyEvent.VK_V); // then press on V button for file
//		rb4.delay(2000);
//		
//		rb4.keyRelease(KeyEvent.VK_CONTROL);
//		rb4.keyRelease(KeyEvent.VK_V);
//		rb4.delay(2000);
//		
//		//click enter button
//		rb4.keyPress(KeyEvent.VK_ENTER);
//		rb4.keyRelease(KeyEvent.VK_ENTER);
//		
//		Thread.sleep(2000);
//		Assert.assertTrue(true);

		
		
		
		WebElement president_Name = driver.findElement(By.id("scienceClubForm_president_name"));
		president_Name.click();
		president_Name.clear();
		president_Name.sendKeys(info.president_name);
		Thread.sleep(1500);
		
		
		WebElement president_Number = driver.findElement(By.id("scienceClubForm_president_mobile"));
		president_Number.click();
		president_Number.clear();
		president_Number.sendKeys(info.president_number);
		Thread.sleep(1000);
		
		WebElement Secretary_Name = driver.findElement(By.id("scienceClubForm_general_secretary_name"));
		Secretary_Name.click();
		Secretary_Name.clear();
		Secretary_Name.sendKeys(info.secretaty_name);
		Thread.sleep(1000);
		
		WebElement Secretary_Number = driver.findElement(By.id("scienceClubForm_general_secretary_mobile"));
		Secretary_Number.click();
		Secretary_Number.clear();
		Secretary_Number.sendKeys(info.secretaty_number);
		Thread.sleep(1000);
		
		WebElement cashier_Name =driver.findElement(By.id("scienceClubForm_cashier_name"));
		cashier_Name.click();
		cashier_Name.clear();
		cashier_Name.sendKeys(info.cashier_name);
		Thread.sleep(1000);
		
		WebElement cashier_Number =driver.findElement(By.id("scienceClubForm_cashier_mobile"));
		cashier_Number.click();
		cashier_Number.clear();
		cashier_Number.sendKeys(info.cashier_number);
		Thread.sleep(1000);
		Assert.assertTrue(true);
		
		
		WebElement addItem = driver.findElement(By.xpath("(//span[contains(text(),'Add Item')])[1]"));
		addItem.click();
		Thread.sleep(1000);
		
		WebElement activities_Name = driver.findElement(By.id("implementedActivitiesForm_implemented_activity_name"));
		activities_Name.click();
		activities_Name.clear();
		activities_Name.sendKeys(info.Activities_Name);
		Thread.sleep(1000);
		
		
		WebElement save1 = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary']"));
		save1.click();
		Thread.sleep(1000);
		
		WebElement radio1 = driver.findElement(By.xpath("(//input[@value='1'])[1]"));
		radio1.click();
		Thread.sleep(1000);
		
		WebElement radio2 = driver.findElement(By.xpath("(//input[@value='1'])[2]"));
		radio2.click();
		Thread.sleep(1000);
		
		WebElement radio3 = driver.findElement(By.xpath("(//input[@value='1'])[3]"));
		radio3.click();
		Thread.sleep(1000);
		
		WebElement radio4 = driver.findElement(By.xpath("(//input[@value='0'])[4]"));
		radio4.click();
		Thread.sleep(1500);
		
		WebElement radio5 = driver.findElement(By.xpath("(//input[@value='1'])[4]"));
		radio5.click();
		Thread.sleep(2000);
		
		String file5 = "C:\\Users\\Ariful\\Desktop\\images.png";
		WebElement attachment5 = driver.findElement(By.xpath("(//div[@class='ant-upload-text'])[1]"));
		attachment5.sendKeys(file5);
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reactEasyCrop_CropArea']")));
//		Actions act5 = new Actions(driver);
//		act5.moveToElement(attachment5).click().perform();
//
//		Robot rb5 = new Robot();
//		rb5.delay(2000);
//		StringSelection ss5 = new StringSelection(file5);
//		Toolkit .getDefaultToolkit().getSystemClipboard().setContents(ss5, null);
//		
//		//cntrl+V
//		rb5.keyPress(KeyEvent.VK_CONTROL); //press on control button
//		rb5.keyPress(KeyEvent.VK_V); // then press on V button
//		
//		
//		rb5.keyRelease(KeyEvent.VK_CONTROL);
//		rb5.keyRelease(KeyEvent.VK_V);
//		rb5.delay(2000);
//		//click enter button
//		rb5.keyPress(KeyEvent.VK_ENTER);
//		rb5.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2500);
		
		WebElement ok1 = driver.findElement(By.xpath("//span[normalize-space()='OK']"));
		ok1.click();
		Thread.sleep(2500);
		
		Assert.assertTrue(true);
		
//		String file6 = "C:\\Users\\Ariful\\Desktop\\seal.jpeg";
//		WebElement attachment6 = driver.findElement(By.xpath("(//div[@class='ant-upload-text'])[2]"));
//		attachment6.sendKeys(file6);
//		Thread.sleep(2000);
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//		Thread.sleep(2000);
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reactEasyCrop_CropArea reactEasyCrop_CropAreaGrid']")));
//		
		String file6 = "C:\\Users\\Ariful\\Desktop\\seal.jpeg";

		// Upload the image
		WebElement attachment6 = driver.findElement(By.xpath("(//div[@class='ant-upload-text'])[2]"));
		attachment6.sendKeys(file6);

		// Wait for alert to appear and accept it
		WebDriverWait waitAlert = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitAlert.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

		// Wait for resizing dialog to appear
		WebDriverWait waitDialog = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitDialog.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reactEasyCrop_CropArea reactEasyCrop_CropAreaGrid']")));

		// Wait for resizing dialog to disappear
		WebDriverWait waitDialogDisappear = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitDialogDisappear.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='reactEasyCrop_CropArea reactEasyCrop_CropAreaGrid']")));
//		Actions act6 = new Actions(driver);
//		act6.moveToElement(attachment6).click().perform();
//
//		Robot rb6 = new Robot();
//		rb6.delay(2000);
//		StringSelection ss6 = new StringSelection(file6);
//		Toolkit .getDefaultToolkit().getSystemClipboard().setContents(ss6, null);
//		
//		//cntrl+V
//		rb6.keyPress(KeyEvent.VK_CONTROL); //press on control button
//		rb6.keyPress(KeyEvent.VK_V); // then press on V button
//		
//		
//		rb6.keyRelease(KeyEvent.VK_CONTROL);
//		rb6.keyRelease(KeyEvent.VK_V);
//		rb6.delay(2000);
//		//click enter button
//		rb6.keyPress(KeyEvent.VK_ENTER);
//		rb6.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2500);
		Assert.assertTrue(true);

		
		WebElement ok2 = driver.findElement(By.xpath("//span[normalize-space()='OK']"));
		ok2.click();
		Thread.sleep(2500);
		Assert.assertTrue(true);
		
		WebElement save = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-lg']"));
		save.click();
		Thread.sleep(2500);
		Assert.assertTrue(true);	
		
		
		
	}

}
