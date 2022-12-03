package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class HomePage extends HeaderPage {

	public HomePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(xpath="//img[@usemap='#pipeline']")
	WebElement img_pipeline;
	
	public void verifyPipelineDisplay()
	{
		cm.CheckDisplay(img_pipeline, "Pipeline box exists");
	}
	

}
