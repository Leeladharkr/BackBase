package PageObjectPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import backbaseAssignment.driver;

public class AddaComputerPage extends driver
{
	By AddComputerStatusPage = By.xpath("//*[@id=\"main\"]/h1");
	By ComputerName = By.name("name");
	By IntroducedDate = By.id("introduced");
	By DiscontinuedDate = By.id("discontinued");
	By CompanyName = By.id("company");
	By CreateThisComputer = By.xpath("//*[@id=\"main\"]/form/div/input");
	
	
	//Get the title of the add computer page
	public String GetStatusOfAddComputerPage()
	{
		return driver.findElement(AddComputerStatusPage).getText();
	}
	
	//Get the Value of the computer name field
	public String GetComputerName()
	{
		return driver.findElement(ComputerName).getAttribute("value");
	}
	
	//Clear the computer name filed before typing anything in that filed
	public void ClearComputerName()
	{
		driver.findElement(ComputerName).clear();
	}
	
	//Type the computer name in the computer name field
	public void TypeComputerName(String strComputerName)
	{
		driver.findElement(ComputerName).sendKeys(strComputerName);
	}
	
	//Get the Value of the IntroducedDate field
	public String GetIntroducedDate()
	{
		return driver.findElement(IntroducedDate).getAttribute("value");
	}
		
	//Clear the IntroducedDate field before typing anything in that filed
	public void ClearIntroducedDate()
	{
		driver.findElement(IntroducedDate).clear();
	}
		
	//Type the IntroducedDate in the computer name field
	public void TypeIntroducedDate(String strIntroducedDate)
	{
		driver.findElement(IntroducedDate).sendKeys(strIntroducedDate);
	}
	
	//Get the Value of the DiscontinuedDate field
	public String GetDiscontinuedDate()
	{
		return driver.findElement(DiscontinuedDate).getAttribute("value");
	}
		
	//Clear the DiscontinuedDate field before typing anything in that field
	public void ClearDiscontinuedDate()
	{
		driver.findElement(DiscontinuedDate).clear();
	}
		
	//Type the DiscontinuedDate in the DiscontinuedDate field
	public void TypeDiscontinuedDate(String strDiscontinuedDate)
	{
		driver.findElement(DiscontinuedDate).sendKeys(strDiscontinuedDate);
	}
	
	//Company DropDown field
	public WebElement CompanyDropDown()
	{
		return driver.findElement(CompanyName);
	}
	
	//Get the Value of the company field
	public String GetCompanyName()
	{
		return driver.findElement(CompanyName).getAttribute("text");
	}
		
	//Clear the CompanyName field before typing anything in that field
	public void ClearCompanyName()
	{
		driver.findElement(CompanyName).clear();
	}
		
	//Type the company name in the company name field
	public void TypeCompanyName(String strCompanyName)
	{
		driver.findElement(CompanyName).sendKeys(strCompanyName);
	}
	
	//Click on the Create this computer button
	public void PressCreateThisComputer()
	{
		driver.findElement(CreateThisComputer).click();
	}
		
}
