package PageObjectPackage;

import org.openqa.selenium.By;

import backbaseAssignment.driver;

public class UpdateComputerPage extends driver
{
	By SaveThisComputerButton = By.xpath("//*[@id=\"main\"]/form[1]/div/input");
	By DeleteThisComputerButton = By.xpath("//*[@id=\"main\"]/form[2]/input");
	
	//Click on Save this computer button
	public void PressSaveThisComputer()
	{
		driver.findElement(SaveThisComputerButton).click();
	}
	
	//Click on Save this computer button
	public void PressDeleteThisComputer()
	{
		driver.findElement(DeleteThisComputerButton).click();
	}
}
