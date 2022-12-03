package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class LeadPage extends HeaderPage {

	public LeadPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="salutationtype")
	WebElement dp_salutationtype;
	
	@FindBy(name="firstname")
	WebElement tb_firstname;
	
	@FindBy(name="lastname")
	WebElement tb_lastname;
	
	@FindBy(name="company")
	WebElement tb_company;
	
	@FindBy(name="button")
	WebElement btn_save;
	
	public void verifyDatawithLabel(String Label,String Text)
	{
		cm.CheckDisplay(driver.findElement(By.xpath("//td[text()='"+Label+"']/following::td[text()='"+Text+"']")), Text+" is displaying inline with label "+Label);
	}
	
	public void CreateLeadwithMandatodaotyFields(String lname, String comp)
	{
		setLastname(lname);
		setCompanyname(comp);
		clickSave();
	}
	
	
	
	public void selectSalutation(String salutation)
	{
		cm.SelectByText(dp_salutationtype, salutation, salutation+" has been selected from salutation dropdown");
	}
	
	public void setFirstname(String fname)
	{
		cm.enterValue(tb_firstname, fname, fname +" entered into firstName textbox");
	}
	
	public void setLastname(String lname)
	{
		cm.enterValue(tb_lastname, lname, lname +" entered into LastName textbox");
	}
	
	public void setCompanyname(String comp)
	{
		cm.enterValue(tb_company, comp, comp +" entered into Company textbox");
	}
	
	public void clickSave()
	{
		cm.clickElement(btn_save, "Save button clicked");
	}

}
