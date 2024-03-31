package Pages;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.ExtentITestListenerClassAdapter;
import Utilities.MasterData;

@Listeners(ExtentITestListenerClassAdapter.class)
public class ApplicationPage extends ExtentITestListenerClassAdapter {
	
	MasterData info =  new MasterData();
	
	@Test
	public void ApplictionsPage() throws InterruptedException {
		
		driver.get(info.baseUrl);		
		Thread.sleep(3000);
				
	}

}
