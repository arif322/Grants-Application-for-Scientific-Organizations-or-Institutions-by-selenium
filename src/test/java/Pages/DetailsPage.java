package Pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.ExtentITestListenerClassAdapter;
import Utilities.MasterData;





@Listeners(ExtentITestListenerClassAdapter.class)
public class DetailsPage extends ExtentITestListenerClassAdapter {
	MasterData info =  new MasterData();

	@Test
	public void gotoApplication() throws InterruptedException {

		driver.get(info.baseUrl);

		Thread.sleep(3000);

		WebElement grant =  driver.findElement(By.xpath("(//span[@aria-label='arrow-right'])[1]"));
		grant.click();
		Thread.sleep(1500);	

		WebElement Scientific = driver.findElement(By.xpath("//a[contains(text(),'Grants Application for Scientific Organizations/In')]"));
		Scientific.click();
		Thread.sleep(1500);

		WebElement details = driver.findElement(By.xpath("//a[normalize-space()='Details']"));
		details.click();
		Thread.sleep(3000);

		WebElement apply = driver.findElement(By.xpath("//span[normalize-space()='Apply Now']"));
		apply.click();
		Thread.sleep(1500);

		WebElement Institute = driver.findElement(By.id("scienceClubForm_institute_name"));
		Institute.click();
		Institute.sendKeys(info.university);
		Institute.sendKeys(Keys.ARROW_DOWN);
		Institute.sendKeys(Keys.ENTER);
		Thread.sleep(1500);


		WebElement Profile = driver.findElement(By.xpath("//div[@class='ant-upload ant-upload-select ant-upload-select-picture-card']//span[@role='button']"));
		File file = new File("src/test/resources/image/images.jpg");
		Profile.sendKeys(file.getAbsolutePath());
		Thread.sleep(1200);

		WebElement House = driver.findElement(By.id("scienceClubForm_house_road_no"));
		House.click();
		House.clear();
		House.sendKeys(info.house);
		Thread.sleep(1500);

		WebElement village = driver.findElement(By.id("scienceClubForm_village"));
		village.click();
		village.clear();
		village.sendKeys(info.village);
		Thread.sleep(1500);

		WebElement PO = driver.findElement(By.id("scienceClubForm_post_office"));
		PO.click();
		PO.clear();
		PO.sendKeys(info.post_office);
		Thread.sleep(1500);

		WebElement Division = driver.findElement(By.id("scienceClubForm_division_id"));
		Division.click();
		Division.sendKeys(info.division);
		Division.sendKeys(Keys.ARROW_DOWN);
		Division.sendKeys(Keys.ENTER);
		Thread.sleep(1200);

		WebElement District = driver.findElement(By.id("scienceClubForm_district_id"));
		District.click();
		District.sendKeys(info.district);
		Thread.sleep(1200);
		District.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1200);
		District.sendKeys(Keys.ENTER);
		Thread.sleep(1200);

		WebElement Upz_thana = driver.findElement(By.id("scienceClubForm_upazilaThana_id"));
		Upz_thana.click();
		Upz_thana.sendKeys(info.upzila);
		Thread.sleep(1200);
		Upz_thana.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1200);
		Upz_thana.sendKeys(Keys.ENTER);
		Thread.sleep(1200);

		WebElement Office_number = driver.findElement(By.id("scienceClubForm_telephone_number"));
		Office_number.click();
		Office_number.clear();
		Office_number.sendKeys(info.office_phone_number);
		Thread.sleep(1500);

		WebElement Bank_select = driver.findElement(By.id("scienceClubForm_bank_name"));
		Bank_select.click();
		Bank_select.sendKeys(info.bank_name);
		Thread.sleep(1200);
		Bank_select.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1200);
		Bank_select.sendKeys(Keys.ENTER);
		Thread.sleep(1200);

		WebElement Branch_name = driver.findElement(By.id("scienceClubForm_bank_branch"));
		Branch_name.click();
		Branch_name.clear();
		Branch_name.sendKeys(info.branch_name);
		Thread.sleep(1500);
		WebElement Account_name = driver.findElement(By.id("scienceClubForm_account_name"));
		Account_name.click();
		Account_name.clear();
		Account_name.sendKeys(info.Acc_name);
		Thread.sleep(1500);

		WebElement Account_number = driver.findElement(By.id("scienceClubForm_account_number"));
		Account_number.click();
		Account_number.clear();
		Account_number.sendKeys(info.Acc_number);
		Thread.sleep(1500);

		WebElement designation = driver.findElement(By.id("scienceClubForm_applicant_designation"));
		designation.click();

		WebElement desig_select = driver.findElement(By.xpath("//div[contains(text(),'Administrative Officer')]"));
		desig_select.click();
		
		WebElement Home_select = driver.findElement(By.id("scienceClubForm_applicant_permanent_house_road_no"));
		Home_select.click();
		Home_select.clear();
		Home_select.sendKeys(info.Home);
		
		WebElement village_select = driver.findElement(By.id("scienceClubForm_applicant_permanent_village"));
		village_select.click();
		village_select.clear();
		village_select.sendKeys(info.Village);
		
		WebElement post_select = driver.findElement(By.id("scienceClubForm_applicant_permanent_post_office"));
		post_select.click();
		post_select.clear();
		post_select.sendKeys(info.post_office1);
				
		WebElement division_select = driver.findElement(By.id("scienceClubForm_applicant_permanent_division_id"));
		division_select.click();
		division_select.sendKeys(info.division_1);
		Thread.sleep(1200);
		division_select.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1200);
		division_select.sendKeys(Keys.ENTER);
		Thread.sleep(1200);
		
		WebElement district_select = driver.findElement(By.id("scienceClubForm_applicant_permanent_district_id"));
		district_select.click();
		district_select.sendKeys(info.district_1);
		Thread.sleep(1200);
		district_select.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1200);
		district_select.sendKeys(Keys.ENTER);
		Thread.sleep(1200);
		
		WebElement upozila_select = driver.findElement(By.id("scienceClubForm_applicant_permanent_upazilaThana_id"));
		upozila_select.click();
		upozila_select.sendKeys(info.upazila_1);
		Thread.sleep(1200);
		upozila_select.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1200);
		upozila_select.sendKeys(Keys.ENTER);
		Thread.sleep(1200);
		
		WebElement checkbox_select = driver.findElement(By.xpath("//input[@type='checkbox']"));
		checkbox_select.click();
		
		WebElement NID = driver.findElement(By.id("scienceClubForm_applicant_nid"));
		NID.click();
		NID.clear();
		NID.sendKeys(info.nid);
		
		WebElement mobile_number = driver.findElement(By.id("scienceClubForm_applicant_mobile_number"));
		mobile_number.click();
		mobile_number.clear();
		mobile_number.sendKeys(info.mobile);
		
		WebElement organization = driver.findElement(By.id("scienceClubForm_organizaition_registered_with"));
		organization.click();
		organization.clear();
		organization.sendKeys(info.department);
		
		WebElement reg_number = driver.findElement(By.id("scienceClubForm_organizaition_registration_no"));
		reg_number.click();
		reg_number.clear();
		reg_number.sendKeys(info.office_phone_number);
		Thread.sleep(1500);
		
		WebElement save_1st_step = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-lg']"));
		save_1st_step.click();
		
		

		//		Bank_select.sendKeys(info.upzila);
		//		Thread.sleep(1200);
		//		Bank_select.sendKeys(Keys.ARROW_DOWN);
		//		Thread.sleep(1200);
		//		Bank_select.sendKeys(Keys.ENTER);
		//		Thread.sleep(1200);







	}


}
