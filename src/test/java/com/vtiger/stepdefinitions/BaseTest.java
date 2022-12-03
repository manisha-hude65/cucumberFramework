package com.vtiger.stepdefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.common.Xls_Reader;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static Properties prop;
	public static WebDriver driver;
	public static Map<String,Map<String,String>> Data;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public String TCName;
	
	
	public static LoginPage lp;
	public static HomePage hp;
	public static LeadPage ldp;
	
	public void init() 
	{
		
		try {
			ReadSettings();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		launchApp();
		Data = ReadExcelData(System.getProperty("user.dir")+"/src/test/resources/TestData/Data.xlsx", "Sheet1");
		
	}
	
	
	public void closeApp()
	{
		driver.quit();
	}
	
	
	public void launchApp()
	{
		if(prop.getProperty("Browser").equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(prop.getProperty("Browser").equals("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("AppUrl"));
	}
	
	public void ReadSettings() throws Exception
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/Settings.properties");
		prop.load(fis);
	}
	
	public void createReport() 
	{
		
		DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
		Date d = new Date();
		String str = f.format(d);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+str+".html");
    	// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test Hub");
		    	extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Rajesh U");
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
		            // Name of the report
		htmlReporter.config().setReportName("Name of the Report Comes here "); 
		            // Dark Theme
		htmlReporter.config().setTheme(Theme.DARK); 
	}
	
	public Map<String,Map<String,String>> ReadExcelData(String path, String sheetName)
	{
		Map<String,Map<String,String>> AllData = new HashMap<String,Map<String,String>>();
		Xls_Reader xr = new Xls_Reader(path);
		int rcnt = xr.getRowCount(sheetName);
		int ccnt = xr.getColumnCount(sheetName);
		for(int i=2;i<=rcnt;i++)
		{
			Map<String,String> rowdata = new HashMap<String,String>();
			for(int j=1;j<=ccnt;j++)
			{
				String key = xr.getCellData(sheetName, j, 1).trim();
				String cellData = xr.getCellData(sheetName, j, i).trim();
				rowdata.put(key, cellData);
			}
			
			AllData.put(xr.getCellData(sheetName, 0, i), rowdata);
		}
		
		return AllData;		
	}

}
