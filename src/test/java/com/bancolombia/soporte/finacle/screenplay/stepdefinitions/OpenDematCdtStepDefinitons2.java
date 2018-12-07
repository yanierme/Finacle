package com.bancolombia.soporte.finacle.screenplay.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.bancolombia.soporte.finacle.screenplay.tasks.GoTo_Menu;
import com.bancolombia.soporte.finacle.screenplay.utils.Utilities_Finacle;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;


public class OpenDematCdtStepDefinitons2 {

	@Managed(driver = "iexplorer")
	private WebDriver hisBrowser;

	private Actor luis = Actor.named("luis");

	@Before
	public void setUP() {
		
		luis.can(BrowseTheWeb.with(hisBrowser));
	}

	Utilities_Finacle utilities = new Utilities_Finacle();

	@When("^the User enters the next detail the openning dematerialized$")
	public void theUserEntersTheNextDetailTheOpenningDematerialized(DataTable arg1)  {
	 
		luis.attemptsTo(GoTo_Menu.on("CUPLDMT"));
		//luis.attemptsTo(Upload_FileDemat.on(arg1));
	}
	
 
}

 