package TestCasesPackage;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObjectPackage.AddaComputerPage;
import PageObjectPackage.ComputerDataBaseHomePage;
import PageObjectPackage.UpdateComputerPage;
import backbaseAssignment.driver;
import Util.TestUtil;

public class TestCases extends driver
{
	ComputerDataBaseHomePage HomePage = new ComputerDataBaseHomePage();
	AddaComputerPage AddComputerPage = new AddaComputerPage();
	UpdateComputerPage UpdateComputer = new UpdateComputerPage();
	
	@DataProvider()
	public Object[][] getComputerData()
	{
		Object data[][] = TestUtil.getTestData("TestData");
		return data;
	}
	
	@Test(priority=0 , dataProvider = "getComputerData")
	public void CreateComputer(String ComputerName ,  String IntroducedDate,  String DiscontinuedDate, String ComputerNameUpdate,
			String IntroducedDateUpdate,String DiscontinuedDateUpdate)
	{
		//Click on Add a New Computer button
		HomePage.PressAddComputerButton();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//Verify if the add a computer screen is displayed
		Assert.assertEquals(AddComputerPage.GetStatusOfAddComputerPage() , "Add a computer");
		
		//Type name in the computer name field
		AddComputerPage.ClearComputerName();
		AddComputerPage.TypeComputerName(ComputerName);
		
		//Type date in the Introduce date field
		AddComputerPage.ClearIntroducedDate();
		AddComputerPage.TypeIntroducedDate(IntroducedDate);
		
		//Type date in the discontinued date field
		AddComputerPage.ClearDiscontinuedDate();
		AddComputerPage.TypeDiscontinuedDate(DiscontinuedDate);
		
		//Select company from the company dropdown
		Select dropdown = new Select(AddComputerPage.CompanyDropDown());
		dropdown.selectByIndex(5);
		
		//Click on create this computer button
		AddComputerPage.PressCreateThisComputer();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//Verify if the compuet has been creted
		//Type computer name created above in the filter field
		HomePage.TypeFilterByComputerName(ComputerName);
		
		//Click on the filter button
		HomePage.PressFilterByNameButton();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//Verify the compueter name
		Assert.assertEquals(HomePage.GetTextFromSearchResultField(), ComputerName);
		
	}
	
	@Test(priority=1, dataProvider = "getComputerData")
	public void UpdateComputer(String ComputerName ,  String IntroducedDate,  String DiscontinuedDate, String ComputerNameUpdate,
			String IntroducedDateUpdate,String DiscontinuedDateUpdate)
	{
		//Type computer name created above in the filter field
		HomePage.TypeFilterByComputerName(ComputerName);
				
		//Click on the filter button
		HomePage.PressFilterByNameButton();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				
		//Verify the compueter name from the search results
		Assert.assertEquals(HomePage.GetTextFromSearchResultField(), ComputerName);
		
		//Click on the name of the computer to edit it's details
		HomePage.PressSearchResultField();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//Verify the name of the computer from the computer name filed and change it's name to "Lee Test Updated"
		Assert.assertEquals(AddComputerPage.GetComputerName(), ComputerName);
		AddComputerPage.ClearComputerName();
		AddComputerPage.TypeComputerName(ComputerNameUpdate);
		
		//Verify the date of Introduce and change it to "2017-02-02"
		Assert.assertEquals(AddComputerPage.GetIntroducedDate(), IntroducedDate);
		AddComputerPage.ClearIntroducedDate();
		AddComputerPage.TypeIntroducedDate(IntroducedDateUpdate);
		
		//Verify the date of discontinued and change it to "2018-02-02"
		Assert.assertEquals(AddComputerPage.GetDiscontinuedDate(), DiscontinuedDate);
		AddComputerPage.ClearDiscontinuedDate();
		AddComputerPage.TypeDiscontinuedDate(DiscontinuedDateUpdate);
		
		//change the selected company name to RCA
		Select dropdown = new Select(AddComputerPage.CompanyDropDown());
		dropdown.selectByIndex(3);
		
		//Save the details by clicking on Save This Computer button
		UpdateComputer.PressSaveThisComputer();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//Verify if the updated message is displayed
		Assert.assertEquals(HomePage.GetStatusUpdateMessage(), "Done! Computer " + ComputerNameUpdate + " has been updated");
	}
	
	@Test(priority=2, dataProvider = "getComputerData" )
	public void DeleteComputer(String ComputerName ,  String IntroducedDate,  String DiscontinuedDate, String ComputerNameUpdate,
			String IntroducedDateUpdate,String DiscontinuedDateUpdate)
	{
		//Search the compueter which will be deleted
		//Type computer name created above in the filter field
		HomePage.TypeFilterByComputerName(ComputerNameUpdate);
						
		//Click on the filter button
		HomePage.PressFilterByNameButton();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
						
		//Verify the compueter name from the search results
		Assert.assertEquals(HomePage.GetTextFromSearchResultField(), ComputerNameUpdate);
				
		//Click on the name of the computer to edit it's details
		HomePage.PressSearchResultField();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//Verify the name of computer from the computer field name
		Assert.assertEquals(AddComputerPage.GetComputerName(), ComputerNameUpdate);
		
		//Click on Delete this computer
		UpdateComputer.PressDeleteThisComputer();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//Verify the compueter name from the search results
		Assert.assertEquals(HomePage.GetStatusUpdateMessage(), "Done! Computer has been deleted");
		
		
	}
	
}
