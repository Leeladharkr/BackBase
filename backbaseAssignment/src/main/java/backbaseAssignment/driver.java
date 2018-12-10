package backbaseAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class driver 
{
	public static WebDriver driver = null;
	
	@BeforeMethod
	public void OpenApplication()
	{
		Reporter.log("-----------Starting a new Chrome Browser Session-------------");
		String url = ClassLoader.getSystemResource("chromedriver.exe").getPath();
		System.setProperty("webdriver.chrome.driver",url);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://computer-database.herokuapp.com/computers");
		Assert.assertEquals("Computers database", driver.getTitle());
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		Reporter.log("-----------Ended Chrome Browser Session-------------");
	}
}
