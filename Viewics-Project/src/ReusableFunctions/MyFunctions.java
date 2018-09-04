package ReusableFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinitions.MyActionCode;

public class MyFunctions extends MyActionCode
{

	
	public void myexplicitWaitOperation(By locatorValue)
	{
		WebDriverWait myexplicitwait=new WebDriverWait(driver, 30);
		myexplicitwait.until(ExpectedConditions.visibilityOfElementLocated(locatorValue));
				
	}
	
	public void scrolldownOperation( )
	{
		 JavascriptExecutor je=(JavascriptExecutor) driver;
		 je.executeScript("window.scrollBy(0,450)","");
				
	}
}
