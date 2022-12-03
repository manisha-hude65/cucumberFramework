package com.vtiger.stepdefinitions;

import com.vtiger.pages.LeadPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Leaddefinitions extends BaseTest {
	
	
	
	
	
	@When("user clicks on new lead link")
	public void user_clicks_on_new_lead_link() {
	    hp.clickNewLead();
	    ldp = new LeadPage(driver,logger);
	}
	@When("user enters the all mandatory fields and click on save button")
	public void user_enters_the_all_mandatory_fields_and_click_on_save_button() {
	    ldp.CreateLeadwithMandatodaotyFields(Data.get(TCName).get("LastName"), Data.get(TCName).get("Company"));
	}
	@Then("lead should be created successfully")
	public void lead_should_be_created_successfully() {
	    ldp.verifyDatawithLabel(Data.get(TCName).get("LabelLastName"), Data.get(TCName).get("LastName"));
	    ldp.verifyDatawithLabel(Data.get(TCName).get("LabelCompany"), Data.get(TCName).get("Company"));
	}


}
