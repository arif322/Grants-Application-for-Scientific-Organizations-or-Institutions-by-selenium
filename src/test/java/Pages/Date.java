package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;

import Utilities.ExtentITestListenerClassAdapter;

@Listeners(ExtentITestListenerClassAdapter.class)
public class Date extends ExtentITestListenerClassAdapter  {
	
	String month = "May";
	  String date = "16";
	 String year = "2023";
	

	WebElement DateSelect = driver.findElement(By.id("implementedActivitiesForm_implemented_date"));
	DateSelect.c
	Thread.sleep(1000);
	
	while (true) {
		String text = driver.findElement(By.xpath("//div[@class='ant-picker-header-view']")).getText();
		String arr[] =text.split(" ");
		String Month = arr[0];
		String Year = arr[1];
		       
		if (Month.equalsIgnoreCase(month) && Year.equals(year)) {
			break;
		}
		else {
		 
		driver.findElement(By.xpath("//span[@class='ant-picker-prev-icon']")).click();	
		}
	}
	
	List<WebElement> alldata = driver.findElements(By.xpath("//div[@class='ant-picker-dropdown ant-picker-dropdown-placement-topLeft ']//td"));
	
	for (WebElement ele :alldata) {
		String dt = ele.getText();
		if(dt.equals(date)) {
			ele.click();
			break;
		}
		
	}

}
