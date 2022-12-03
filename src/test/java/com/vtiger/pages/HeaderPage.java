package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.CommonMethods;

public class HeaderPage {
	
	 WebDriver driver;
	CommonMethods cm;
	 ExtentTest logger;
	
	public HeaderPage(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
		cm = new CommonMethods(driver,logger);
	}
	
	@FindBy(linkText="Logout")
	WebElement lnk_Logout;
	
	@FindBy(linkText="New Lead")
	WebElement lnk_NewLead;
	
	@FindBy(linkText="Leads")
	WebElement lnk_Leads;
	
	public void clickLogout()
	{
		cm.clickElement(lnk_Logout, "Clicked on logout link");
	}
	
	public void clickNewLead()
	{
		cm.clickElement(lnk_NewLead, "Clicked on New Lead link");
	}
	
	public void clickLeads()
	{
		cm.clickElement(lnk_Leads, "Clicked on Leads link");
	}

}
