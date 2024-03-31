package Utilities;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;




import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentITestListenerClassAdapter implements ITestListener{
	
	private static ExtentReports extent = new ExtentReports();
	private static ExtentTest test;

	protected static WebDriver driver;



	@Parameters("browser")
	@BeforeSuite(alwaysRun = true)
	public void setUp(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();              
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();              
			driver = new FirefoxDriver();  
			driver.manage().window().maximize();
		}
		else {
			throw new IllegalArgumentException("Invalid browser value provided");
		}
	}



	
	@AfterSuite
	public void tearDown() {
		// Close the browser
		driver.quit();
	}




	@Override
	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Test-Report-" + timeStamp + ".html";
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/testReport/" + reportName);
		extent.attachReporter(htmlReporter);


		htmlReporter.config().setDocumentTitle("Functional Testing Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setReportName("Functional Test Report of the Application");


		extent.setSystemInfo("Tester's Name", "S. M. Ariful Islam");
		extent.setSystemInfo("OS", "Windows-11");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Date", timeStamp);

	}


	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName() +"has passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());

		// Capture screenshot on test failure
		captureScreenshot(driver, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Do nothing
	}



	//Method for taking screenshot

	void captureScreenshot(WebDriver driver, String methodName) {


		// Cast WebDriver to TakesScreenshot
		TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

		// Capture screenshot as a file
		File screenshot = null;

		// Specify the directory to save the screenshot
		String screenshotDirectory = System.getProperty("user.dir") + "/screenshots/";
		String screenshotFilePath = screenshotDirectory + methodName + ".png";


		try {
			screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);


			// Create the directory if it doesn't exist
			File directory = new File(screenshotDirectory);
			if (!directory.exists()) {
				directory.mkdirs();
			}

			// Save the screenshot with a unique filename
			File screenshotFile = new File(screenshotFilePath);
			Files.copy(screenshot.toPath(), screenshotFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

		} 

		catch (Exception e) {
			// Print the exception stack trace
			e.printStackTrace();
			// Log a message indicating the failure to capture screenshot
			System.out.println("Failed to capture screenshot: " + e.getMessage());
		}

		if (screenshot != null) {
			try {
				// Attach screenshot to the report
				test.fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotFilePath).build());
			} catch (Exception e) {
				// Print the exception stack trace
				e.printStackTrace();
				// Log a message indicating the failure to attach screenshot to the report
				System.out.println("Failed to attach screenshot to report: " + e.getMessage());
			}
		}
	}
	
	public static void Scroller() {
	        // Create JavaScript executor
	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Scroll down slowly
	        scrollDownSlowly(js);
	        
	        // Close the browser
	        driver.quit();
	    }

	    private static void scrollDownSlowly(JavascriptExecutor js) {
	        // Define the scroll amount
	        long scrollHeight = (long) js.executeScript("return document.body.scrollHeight");

	        // Scroll down slowly
	        for (int i = 0; i < scrollHeight; i += 5) {
	            js.executeScript("window.scrollTo(0, " + i + ")");
	            try {
	                Thread.sleep(10); // Adjust the sleep time for desired scrolling speed
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
