package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import ObjectRepositoryLocators.MyElementLocator;
import Reporting.Report;
import ReusableFunctions.MyFunctions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class MyActionCode 
{

	public static WebDriver driver;
	public static String myitemTitle;
	public static String chromeDriverPath=System.getProperty("user.dir")+"\\SupportingFiles\\chromedriver.exe";
	public static String ieDriverPath=System.getProperty("user.dir")+"\\SupportingFiles\\IEDriverServer.exe";
	public static String homeURL;
	public static MyFunctions myfunction=new MyFunctions();
	public static MyElementLocator myobjrep=new MyElementLocator();
	//--for reporting------------
    public static ArrayList<String> mylist_serialnumber=new ArrayList<String>();
	public static ArrayList<String> mylist_stepdescription=new ArrayList<String>();
	public static ArrayList<String> mylist_actualresult=new ArrayList<String>();
	public static ArrayList<String> mylist_status=new ArrayList<String>();
	//-------------
	
@Given("^I open the \"([^\"]*)\" and application URL such as \"([^\"]*)\"$")
public void Open_Browser(String browserName, String applicationURL)
{
		
	try
	{
	
	 if(browserName.equalsIgnoreCase("Chrome"))	
	 {	 
		 
	 homeURL=applicationURL;
	 System.setProperty("webdriver.chrome.driver", chromeDriverPath);			
	 driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);			
	 driver.manage().window().maximize();			
	 driver.get(homeURL);
	 myfunction.myexplicitWaitOperation(myobjrep.homepage_search_textbox);
	 
	 }
	 if(browserName.equalsIgnoreCase("IE"))	
	 {
		 
	 homeURL=applicationURL;	 
	 System.setProperty("webdriver.ie.driver", ieDriverPath);			
	 driver=new InternetExplorerDriver();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);			
	 driver.manage().window().maximize();			
	 driver.get(homeURL);
	 myfunction.myexplicitWaitOperation(myobjrep.homepage_search_textbox);
	 
	 }
	 
	 mylist_serialnumber.add("1");
	 mylist_stepdescription.add("Verify Opening the browser and application URL");
	 mylist_actualresult.add("Opening the browser and application URL operation is working");
	 mylist_status.add("Pass");
	}
	catch(Exception e)
	{
		e.printStackTrace();
		mylist_serialnumber.add("1");
		mylist_stepdescription.add("Verify Opening the browser and application URL");
		mylist_actualresult.add("Opening the browser and application URL operation is not working");
		mylist_status.add("Fail");
	}

}
	


@When("^I enter search text \"([^\"]*)\" in search text box and click on search icon button$")
public void Search_Item_Search_Page(String itemsearchText)
{
		
	try
	{
	

		 driver.findElement(myobjrep.homepage_search_textbox).sendKeys(itemsearchText.trim());
		 driver.findElement(myobjrep.homepage_search_icon).click();
		 myfunction.myexplicitWaitOperation(myobjrep.itemfilterpage_brand_text);
		 mylist_serialnumber.add("2");
		 mylist_stepdescription.add("Verify item"+" "+"<b>"+itemsearchText+"</b>"+" "+"entered and search operation");
		 mylist_actualresult.add("Item"+" "+"<b>"+itemsearchText+"</b>"+" "+"entered and search operation is working");
		 mylist_status.add("Pass");
		 
	 
	}
	catch(Exception e)
	{
		e.printStackTrace();
		 mylist_serialnumber.add("2");
		 mylist_stepdescription.add("Verify item"+" "+"<b>"+itemsearchText+"</b>"+" "+"entered and search operation");
		 mylist_actualresult.add("Item"+" "+"<b>"+itemsearchText+"</b>"+" "+"entered and search operation is not working");
		 mylist_status.add("Fail");
	}

}

@And("^I select brand as \"([^\"]*)\"$")
public void Item_Filter(String brandName)
{
		
	try
	{
	
		 List<WebElement> my_brand_list=driver.findElements(myobjrep.itemfilterpage_brand_name_list);
		 List<WebElement> my_brand_list_checkbox=driver.findElements(myobjrep.itemfilterpage_brand_checkbox_list);
		 int my_required_index=0;
		 for(WebElement my_element: my_brand_list )
		 {
			 if(my_element.getAttribute("value").equalsIgnoreCase(brandName.trim()))
			 {
				 my_required_index=my_brand_list.indexOf(my_element);
				 break;
			 }
		 }
		 
		 my_brand_list_checkbox.get(my_required_index).click();
		 myfunction.myexplicitWaitOperation(myobjrep.itemfilterpage_clearall_text);
		 mylist_serialnumber.add("3");
		 mylist_stepdescription.add("Verify item brand selection filter");
		 mylist_actualresult.add("Item brand selection filter is working");
		 mylist_status.add("Pass");
	 
	}
	catch(Exception e)
	{
		e.printStackTrace();
		 mylist_serialnumber.add("3");
		 mylist_stepdescription.add("Verify item brand selection filter");
		 mylist_actualresult.add("Item brand selection filter is not working");
		 mylist_status.add("Fail");
	}

}

@And("^I select item number as (\\d+) from items search list$")
public void Item_Selection(int itemNumber)
{
		
	try
	{
	
		 List<WebElement> my_item_list=driver.findElements(myobjrep.itemfilterpage_allfilter_items_list);		
		 my_item_list.get(itemNumber-1).click();
		 myfunction.myexplicitWaitOperation(myobjrep.addtocartpage_myshoppingbag_button);
		 mylist_serialnumber.add("4");
		 mylist_stepdescription.add("Verify required item selection from item filter list");
		 mylist_actualresult.add("Required item selection from item filter list is working");
		 mylist_status.add("Pass");

	}
	catch(Exception e)
	{
		e.printStackTrace();
		 mylist_serialnumber.add("4");
		 mylist_stepdescription.add("Verify required item selection from item filter list");
		 mylist_actualresult.add("Required item selection from item filter list is not working");
		 mylist_status.add("Fail");
	}

}

@And("^I select size as \"([^\"]*)\" and click on \"([^\"]*)\" button$")
public void Item_Selection(String myitemSize, String buttonName)
{
		
	try
	{
	
		if(buttonName.trim().equalsIgnoreCase("ADD TO CART"))
		{

			 myfunction.scrolldownOperation();
			 List<WebElement> my_item_size_list=driver.findElements(myobjrep.addtocartpage_itemsize_list);
			 for(WebElement my_element: my_item_size_list )
			 {
				 if(  my_element.getText().trim().equalsIgnoreCase(myitemSize.trim())  )
				 {

					 my_element.click();
					 Thread.sleep(2000);
					 break;
				 }
			 }
			 
			 driver.findElement(myobjrep.addtocartpage_addtocart_button).click();
			 Thread.sleep(2000);
			 myitemTitle=driver.findElement(myobjrep.addtocartpage_item_name_text).getText();
			 Thread.sleep(1000);
			 mylist_serialnumber.add("5");
			 mylist_stepdescription.add("Verify item size selection and adding item on shopping bags/Item Cart");
			 mylist_actualresult.add("Item size selection and adding item on shopping bags/Item Cart operation is working");
			 mylist_status.add("Pass");
		}


	}
	catch(Exception e)
	{
		e.printStackTrace();
		 mylist_serialnumber.add("5");
		 mylist_stepdescription.add("Verify item size selection and adding item on shopping bags/Item Cart");
		 mylist_actualresult.add("Item size selection and adding item on shopping bags/Item Cart operation is not working");
		 mylist_status.add("Fail");
	}

}

@And("^I click on \"([^\"]*)\" icon button$")
public void Shopping_Bag_Navigation(String buttonName)
{
		
	try
	{
	
		if(buttonName.trim().equalsIgnoreCase("My Shopping Bag"))
		{
			 WebElement myelement=driver.findElement(myobjrep.addtocartpage_myshoppingbag_button);
			 myelement.click();
			 Thread.sleep(3000);
			 mylist_serialnumber.add("6");
			 mylist_stepdescription.add("Verify My Shopping Bag page navigation");
			 mylist_actualresult.add("My Shopping Bag page navigation is working");
			 mylist_status.add("Pass");
			 
		}


	}
	catch(Exception e)
	{
		e.printStackTrace();
		 mylist_serialnumber.add("6");
		 mylist_stepdescription.add("Verify My Shopping Bag page navigation");
		 mylist_actualresult.add("My Shopping Bag page navigation is not working");
		 mylist_status.add("Pass");
	}

}

@Then("^I am able to view my added items in my shopping bags/my cart$")
public void Validation_AddedItems( )
{
		
	try
	{
	
		 List<WebElement> my_item_added_shoppingbags_list=driver.findElements(myobjrep.myshoppingbagpage_allitemsname_list);
		 
		 boolean my_present_flag=false;
		 
          for(WebElement my_element: my_item_added_shoppingbags_list)
          {
        	  if(my_element.getText().trim().equalsIgnoreCase(myitemTitle.trim()))
        	  {
        		  my_present_flag=true;
        		  break;
        	  }
          }


          if(my_present_flag)
          {
        	 System.out.println("validate is passed");
 			 mylist_serialnumber.add("7");
 			 mylist_stepdescription.add("Verify added items are displayed in my shopping bag list");
 			 mylist_actualresult.add("Added items are displayed in my shopping bag list");
 			 mylist_status.add("Pass");
 			 driver.get(homeURL);
          }
          else
          {
        	 System.out.println("validate is failed");
  			 mylist_serialnumber.add("7");
  			 mylist_stepdescription.add("Verify added items are displayed in my shopping bag list");
  			 mylist_actualresult.add("Added items are not displayed in my shopping bag list");
  			 mylist_status.add("Fail");
  			 driver.get(homeURL);
          }

	}
	catch(Exception e)
	{
		e.printStackTrace();
			 mylist_serialnumber.add("7");
			 mylist_stepdescription.add("Verify added items are displayed in my shopping bag list");
			 mylist_actualresult.add("Added items are not displayed in my shopping bag list");
			 mylist_status.add("Fail");
			 driver.get(homeURL);
	}

}

@Given("^I close the application and browser$")
public void Close_Browser( ) throws IOException
{
		
	try
	{
	
       driver.close();
       driver.quit();
  	   mylist_serialnumber.add("8");
  	   mylist_stepdescription.add("Verify closing the browser and application URL");
  	   mylist_actualresult.add("Verify closing the browser and application URL is working");
  	   mylist_status.add("Pass");
  	   //Report.writeReport();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	  	mylist_serialnumber.add("8");
	  	mylist_stepdescription.add("Verify closing the browser and application URL");
	  	mylist_actualresult.add("Verify closing the browser and application URL is not working");
	  	mylist_status.add("Fail");
	  	//Report.writeReport();
	}

}
}
