package PageObjectPackage;

import org.openqa.selenium.By;

import backbaseAssignment.driver;

public class ComputerDataBaseHomePage extends driver
{
	By AddaNewComputerButton = By.xpath("//*[@id=\"add\"]");
	By FilterByComputerNameField = By.id("searchbox");
	By FilterByNameButton = By.id("searchsubmit");
	By SearchResultField = By.xpath("//*[@id=\"main\"]/table/tbody/tr[1]/td[1]/a");
	By StatusUpdateMessage = By.xpath("//*[@id=\"main\"]/div[1]");
	
	//Click on Add A Computer Button
	public void PressAddComputerButton()
	{
		driver.findElement(AddaNewComputerButton).click();
	}
	
	//Click on Filter By Name Button
	public void PressFilterByNameButton()
	{
		driver.findElement(FilterByNameButton).click();
	}
	
	//Click on Search Result field item
	public void PressSearchResultField()
	{
		driver.findElement(SearchResultField).click();
	}
	
	//Get Text From the search result field
	public String GetTextFromSearchResultField()
	{
		return driver.findElement(SearchResultField).getText();
	}
	
	//Type the name of the computer in the Filter By Computer Name field
	public void TypeFilterByComputerName(String ComputerName)
	{
		driver.findElement(FilterByComputerNameField).sendKeys(ComputerName);;
	}
	
	//Get the status of the Add, Update or Delete of computer.
	public String GetStatusUpdateMessage()
	{
		return driver.findElement(StatusUpdateMessage).getText();
	}
}
