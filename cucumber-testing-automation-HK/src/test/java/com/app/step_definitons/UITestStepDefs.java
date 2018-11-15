package com.app.step_definitons;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.app.pages.SuiteCRMdashboardPage;
import com.app.pages.SuiteCRMloginPage;
import com.app.pages.SuiteCSRMSearchResultsPage;
import com.app.utilities.Driver;
import com.app.utilities.configReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UITestStepDefs {
	private WebDriver driver = Driver.getDriver();
	SuiteCRMloginPage loginPage = new SuiteCRMloginPage();
	SuiteCRMdashboardPage dashboardPage = new SuiteCRMdashboardPage();
	SuiteCSRMSearchResultsPage searchResultsPage = new SuiteCSRMSearchResultsPage();

	@Given("^I logged into suiteCRM$")
	public void i_logged_into_suiteCRM() {
		driver.get(configReader.getProperty("url"));
		driver.manage().window().fullscreen();
		loginPage.login(configReader.getProperty("username"), configReader.getProperty("password"));
	}

	@Then("^CRM name should be SuiteCRM$")
	public void crm_name_should_be_SuiteCRM() {
		assertTrue(driver.getTitle().endsWith("SuiteCRM"));
	}

	@Then("^Modules should be displayed$")
	public void modules_should_be_displayed() {
		assertTrue(dashboardPage.sales.isDisplayed());
		assertTrue(dashboardPage.support.isDisplayed());
		assertTrue(dashboardPage.activities.isDisplayed());
		assertTrue(dashboardPage.marketing.isDisplayed());
		assertTrue(dashboardPage.collaboration.isDisplayed());
		assertTrue(dashboardPage.all.isDisplayed());
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String searchTerm) {
		try {
			assertTrue(dashboardPage.searchInput.isDisplayed());
		} catch (AssertionError e) {
			dashboardPage.searchButton.click();
		}
		dashboardPage.searchInput.sendKeys(searchTerm + Keys.ENTER);
	 
	}

	@Then("^link for user \"([^\"]*)\" should be displayed$")
	public void link_for_user_should_be_displayed(String searchTerm) {
		assertTrue(searchResultsPage.resultLink(searchTerm).isDisplayed(), searchTerm + " was not displayed");

	   
	}
		

		@Then("^there should be (\\d+) result for \"([^\"]*)\"$")
		public void there_should_be_result_for(int count, String searchTerm) {
			int actual = searchResultsPage.resultsLink(searchTerm).size();
			assertEquals(actual, count, "number of results did not match");
	}

}
