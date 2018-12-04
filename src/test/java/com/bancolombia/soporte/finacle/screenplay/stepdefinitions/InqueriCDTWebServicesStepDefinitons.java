package com.bancolombia.soporte.finacle.screenplay.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.bancolombia.soporte.finacle.screenplay.utils.Utilities_Finacle;

import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Managed;

public class InqueriCDTWebServicesStepDefinitons {
	
	
	@Managed(driver = "iexplorer")
	private WebDriver hisBrowser;

	private Actor yanier = Actor.named("yanier");

	Utilities_Finacle utilities = new Utilities_Finacle();

// 	@Then("^you should see the CDT information on the xml$")
//	public void youShouldSeeTheCDTInformationOnTheXml()  {
//	    // Write code here that turns the phrase above into concrete actions
//	   
//	}
//

}
