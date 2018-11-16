package com.bancolombia.soporte.finacle.screenplay.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.bancolombia.soporte.finacle.screenplay.tasks.OpenTheBrowser;
import com.ibm.icu.impl.LocaleDisplayNamesImpl.DataTable;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

public class Open_Account_Finacle_Web_Services {
	
	@Managed(driver="iexplorer")
	private WebDriver hisBrowser;
	
	private Actor usuario = Actor.named("Usuario");
	
	@Before
	public void setUP()
		{
			usuario.can(BrowseTheWeb.with(hisBrowser));
		}
	
	@Given("^that user is the page of finacle integrator$")
	public void thatUserIsThePageOfFinacleIntegrator() throws Exception {
	 
		usuario.wasAbleTo(OpenTheBrowser.on());
	  
	}


	@When("^the User enters the next detais of the account$")
	public void theUserEntersTheNextDetaisOfTheAccount(DataTable arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	 
	}
	
}
