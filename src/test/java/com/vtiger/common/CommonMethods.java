package com.vtiger.common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class CommonMethods {
	private WebDriver driver;
	public ExtentTest logger;
	
	public CommonMethods(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger=logger;
	}
	
	public void enterValue(WebElement elm, String val,String msg)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(elm));
			elm.clear();
			elm.sendKeys(val);
			logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail(e.getMessage()+"<a href='"+getscreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	
	
	public void SelectByText(WebElement elm, String val,String msg)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeSelected(elm));
			Select sel = new Select(elm);
			sel.selectByVisibleText(val);
			logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail(e.getMessage()+"<a href='"+getscreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	
	public void clickElement(WebElement elm,String msg)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(elm));			
			elm.click();
			logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail(e.getMessage()+"<a href='"+getscreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	
	public void CheckDisplay(WebElement elm,String msg)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(elm));			
			elm.isDisplayed();
			logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail(e.getMessage()+"<a href='"+getscreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	
	
	public String getscreenshot() 
	{
		DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
		Date d = new Date();
		String str = f.format(d);
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/screenshots/image"+str+".png";
		//Move image file to new destination
		File DestFile=new File(path);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		
	}

}
