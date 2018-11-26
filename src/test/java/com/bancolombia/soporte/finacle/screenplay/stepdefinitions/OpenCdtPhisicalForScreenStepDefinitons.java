package com.bancolombia.soporte.finacle.screenplay.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.bancolombia.soporte.finacle.screenplay.questions.ValidateAccountCDTForScreen;
import com.bancolombia.soporte.finacle.screenplay.tasks.GoTo_Menu_Initial;
import com.bancolombia.soporte.finacle.screenplay.tasks.Go_Account_Opening;
import com.bancolombia.soporte.finacle.screenplay.tasks.Go_Sol_ID;
import com.bancolombia.soporte.finacle.screenplay.tasks.Login_On_Finacle_Page;
import com.bancolombia.soporte.finacle.screenplay.tasks.OpenTheBrowser;
import com.bancolombia.soporte.finacle.screenplay.tasks.Open_Account;
import com.bancolombia.soporte.finacle.screenplay.utils.Utilities_Finacle;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

public class OpenCdtPhisicalForScreenStepDefinitons {

	@Managed(driver = "iexplorer")
	private WebDriver hisBrowser;

	private Actor usuario = Actor.named("Usuario");

	@Before
	public void setUP() {
		usuario.can(BrowseTheWeb.with(hisBrowser));
	}

	Utilities_Finacle utilities = new Utilities_Finacle();

	@Given("^that user is logged in finacle with your$")
	public void thatUserIsLoggedInFinacleWithYour(List<Map<String, String>> dataUser) throws Exception {
		
		usuario.wasAbleTo(OpenTheBrowser.on("https://wsfinaclecdtperf.bancolombia.corp:11111/SSO/ui/SSOLogin.jsp"));
		utilities.selecFrame(hisBrowser, "loginFrame");
		usuario.wasAbleTo(Login_On_Finacle_Page.loginInPage(hisBrowser, dataUser));

	}
 
	@When("^he wants to open a CDT in finacle in the (.*)$")
	public void heWantsToOpenACDTInFinacleInThe(String solID) throws InterruptedException {

		utilities.selectFinacleCore(hisBrowser, "FINCORE");
		utilities.selecFrame(hisBrowser, "CoreServer");
		usuario.attemptsTo(GoTo_Menu_Initial.on("HCCS"));
		usuario.attemptsTo(Go_Sol_ID.solInPage(solID));

	}

	@When("^the User enters the next detais$")
	public void theUserEntersTheNextDetais(List<Map<String, String>> dataAccountCDT) throws Exception {

		utilities.GoToMenu(hisBrowser, "HOAACTU");
		usuario.attemptsTo(Go_Account_Opening.solAccountOpening(dataAccountCDT));
		usuario.attemptsTo(Open_Account.openAccount(dataAccountCDT));
		utilities.enterKey();

	}

	@Then("^he should see the CDT for screen created (.*)$")
	public void heShouldSeeTheCDTCreated(String validationCdt) {
		
		usuario.should(GivenWhenThen.seeThat(ValidateAccountCDTForScreen.successful(validationCdt)));
	}
}
