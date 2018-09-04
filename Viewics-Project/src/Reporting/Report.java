package Reporting;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import stepDefinitions.MyActionCode;


public class Report 
{

	

	public static String reportTemplatePath=System.getProperty("user.dir")+"\\Test_Reporting\\Report Template.html";
	public static String myReplaceFromTemplate="<My Replace tags>";
	public static String newCreatedReportPath=System.getProperty("user.dir")+"\\Test_Reporting\\Automation Report.html";
	public static int totaltestcasesexecutioncount=0;
	public static int totaltestcasespasscount=0;
	public static int totaltestcasesfailcount=0;
	
	
	public static void writeReport() throws IOException
	{
		
		File myreport=new File(newCreatedReportPath);
		if(myreport.exists())
		{
			myreport.delete();
			System.out.println("existing report is deleted before creating new report");
		}
		else
		{
			System.out.println("previous report is not available for delete");
		}
		
		String myValue = new String(Files.readAllBytes(Paths.get(reportTemplatePath)));
		
		totaltestcasesexecutioncount=MyActionCode.mylist_serialnumber.size();
		for(int i=0; i< MyActionCode.mylist_serialnumber.size(); i++)
		{
		  if(MyActionCode.mylist_status.get(i).equalsIgnoreCase("Pass"))
		  {
			  totaltestcasespasscount=totaltestcasespasscount+1;
				myValue=myValue.replaceFirst(myReplaceFromTemplate, 
		                   "<tr><td  style='background-color:powderblue;text-align:center'>"+Integer.toString(i+1)+
		                   "</td><td style='background-color:powderblue;text-align:center'>"+MyActionCode.mylist_stepdescription.get(i)+
		                   "</td><td style='background-color:powderblue;text-align:center'>"+MyActionCode.mylist_actualresult.get(i)+
		                   "</td><td style='background-color:green;text-align:center'>"+MyActionCode.mylist_status.get(i)+
		                   "</td></tr>"+myReplaceFromTemplate);
		  }
		  if(MyActionCode.mylist_status.get(i).equalsIgnoreCase("Fail"))
		  {
			  totaltestcasesfailcount=totaltestcasesfailcount+1;
				myValue=myValue.replaceFirst(myReplaceFromTemplate, 
		                   "<tr><td  style='background-color:powderblue;text-align:center'>"+Integer.toString(i+1)+
		                   "</td><td style='background-color:powderblue;text-align:center'>"+MyActionCode.mylist_stepdescription.get(i)+
		                   "</td><td style='background-color:powderblue;text-align:center'>"+MyActionCode.mylist_actualresult.get(i)+
		                   "</td><td style='background-color:red;text-align:center'>"+MyActionCode.mylist_status.get(i)+
		                   "</td></tr>"+myReplaceFromTemplate);
		  }
			
			
		}
		
		
		Files.write(Paths.get(newCreatedReportPath),myValue.getBytes(),StandardOpenOption.CREATE);
		System.out.println("New report is created successfully");
	}
	

}
