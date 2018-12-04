package com.bancolombia.soporte.finacle.screenplay.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.bancolombia.soporte.finacle.screenplay.tasks.GoTo_Menu_Initial;
import com.bancolombia.soporte.finacle.screenplay.tasks.Inqueri_CDT;
import com.bancolombia.soporte.finacle.screenplay.tasks.SelectFinacleCore;
import com.bancolombia.soporte.finacle.screenplay.utils.Utilities_Finacle;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

public class InqueriCDTonScreenStepDefinitons {

	@Managed(driver = "iexplorer")
	private WebDriver hisBrowser;

	private Actor yanier = Actor.named("yanier");

	@Before
	public void setUP() {

		yanier.can(BrowseTheWeb.with(hisBrowser));
	}

	Utilities_Finacle utilities = new Utilities_Finacle();

	@When("^the User enters the next detais the inquire$")
	public void theUserEntersTheNextDetaisOfTheCDT(List<Map<String, String>> numberTitle) throws InterruptedException {

		yanier.attemptsTo(SelectFinacleCore.in());
		utilities.selecFrame(hisBrowser, "CoreServer");
		yanier.attemptsTo(GoTo_Menu_Initial.on("CDTINQ"));
		yanier.attemptsTo(Inqueri_CDT.the(numberTitle));

	}

	@Then("^you should see the CDT information on the screen$")
	public void youShouldSeeTheCDTInformationOnTheScreen() {

	}

}
