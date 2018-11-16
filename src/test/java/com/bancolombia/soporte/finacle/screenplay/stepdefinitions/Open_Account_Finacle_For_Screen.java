package com.bancolombia.soporte.finacle.screenplay.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.bancolombia.soporte.finacle.screenplay.tasks.Account_Number;
import com.bancolombia.soporte.finacle.screenplay.tasks.Go_Account_Opening;
import com.bancolombia.soporte.finacle.screenplay.tasks.Go_Sol_ID;
import com.bancolombia.soporte.finacle.screenplay.tasks.Login_On_Finacle_Page;
import com.bancolombia.soporte.finacle.screenplay.tasks.OpenTheBrowser;
import com.bancolombia.soporte.finacle.screenplay.tasks.Open_Account;
import com.bancolombia.soporte.finacle.screenplay.utils.Utilidades_Finacle;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

public class Open_Account_Finacle_For_Screen {

	@Managed(driver = "iexplorer")
	private WebDriver hisBrowser;

	private Actor usuario = Actor.named("Usuario");

	@Before
	public void setUP() {
		usuario.can(BrowseTheWeb.with(hisBrowser));
	}

	Utilidades_Finacle utilidades = new Utilidades_Finacle();

	@Given("^that user is logged in finacle with your$")
	public void thatUserIsLoggedInFinacleWithYour(List<Map<String, String>> dataUser) throws Exception {

		usuario.wasAbleTo(OpenTheBrowser.on());
		utilidades.selecFrame(hisBrowser, "loginFrame");
		usuario.wasAbleTo(Login_On_Finacle_Page.loginInPage(dataUser));

	}

	@When("^he wants to open a CDT in finacle in the (.*)$")
	public void heWantsToOpenACDTInFinacleInThe(String solID) throws InterruptedException {

		utilidades.selectFinacleCore(hisBrowser, "FINCORE");
		utilidades.clicOnMessage(hisBrowser);
		utilidades.selecFrame(hisBrowser, "CoreServer");
		utilidades.GoToMenu(hisBrowser, "HCCS");
		usuario.attemptsTo(Go_Sol_ID.solInPage(solID));

	}

	@When("^the User enters the next detais$")
	public void theUserEntersTheNextDetais(List<Map<String, String>> dataAccountCDT) throws Exception {

		utilidades.GoToMenu(hisBrowser, "HOAACTU");
		utilidades.clicOnMessage(hisBrowser);

		for (int i = 0; i < dataAccountCDT.size(); i++) {

			usuario.attemptsTo(Go_Account_Opening.solAccountOpening(dataAccountCDT, i));
			usuario.attemptsTo(Open_Account.openAccount(dataAccountCDT, i));
			utilidades.enterKey();
			usuario.attemptsTo(Account_Number.saveAccount());

		}
	}

	@Then("^he should see the CDT created (.*)$")
	public void heShouldSeeTheCDTCreated(String validationCdt) {

		// usuario.should(GivenWhenThen.seeThat(ValidateAccountCDT.successful(validationCdt)));
	}
}
