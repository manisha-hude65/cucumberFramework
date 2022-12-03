package com.vtiger.stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Logindefinitions extends BaseTest {
	
	
	
	@Before
	public void GetScenario(Scenario scenario)
	{
		
		System.out.println("Login GetScenario method called");
		if(htmlReporter==null)
		{
		createReport();
		}
		TCName = scenario.getName();
		logger = extent.createTest(TCName);
	}
	
	@After
	public void savereport()
	{
		extent.flush();
		driver.quit();
	}
	
	@Given("user should be on login page")
	public void user_should_login_page()
	{
		init();
		lp = new LoginPage(driver,logger);
		
	}
	
	
	@When("user enters the invalid userid and password and click on login button")
	public void user_enters_the_invalid_userid_and_password_and_click_on_login_button() {
	    lp.login(Data.get(TCName).get("Userid"), Data.get(TCName).get("Password"));
	}
	
	
	@Then("user should get an error msg {string}")
	public void user_should_get_a_error_msg(String msg) {
	    lp.verifyErrorMsg();
	}
	
	
	@When("user enters the valid userid and password and click on login button")
	public void user_enters_the_valid_userid_and_password_and_click_on_login_button() {
		 lp.login(Data.get(TCName).get("Userid"), Data.get(TCName).get("Password"));
		 hp=new HomePage(driver,logger);
	}
	@Then("user shold be navigated to home page and can see logout link appear on top right corner")
	public void user_shold_be_navigated_to_home_page_and_can_see_logout_link_appear_on_top_right_corner() {
	  hp.verifyPipelineDisplay();
	}
	@When("user click on logout link")
	public void user_click_on_logout_link() {
		hp.clickLogout();
	}
	@Then("user should be navigated to login page")
	public void user_should_be_navigated_to_login_page() {
		lp.setUserid("test");
	}
	
	@When("user enters the invalid userid as {string} and password as {string} and click on login button")
	public void user_enters_the_invalid_userid_as_and_password_as_and_click_on_login_button(String uid, String pwd) {
		 lp.login(Data.get(TCName).get("Userid"), Data.get(TCName).get("Password"));
	}


	
	@Then("user can validate logo as well")
	public void user_can_validate_logo_as_well() {
	    lp.verifyLogo();
	}
	
	@When("user enters the valid userid as {string} and password as {string} and click on login button")
	public void user_enters_the_valid_userid_as_and_password_as_and_click_on_login_button(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
		
		 lp.login(Data.get(TCName).get("Userid"), Data.get(TCName).get("Password"));
	}






}
