package runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import Reporting.Report;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		           
		       features={"src/features/MyntraApplication.feature"},
		       glue={"stepDefinitions"},
		       tags={"@Precondition,@TestCase#1,@PostCondition"}
		
		      )


public class TestRunner
{
    @BeforeClass
    public static void Start_Up()
    {
    	System.out.println("Execution is started");
    }
	
	@AfterClass     
     public static void Report_Creation() throws IOException
     {
    	 Report.writeReport();
     }
} 
