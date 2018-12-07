package com.bancolombia.soporte.finacle.screenplay.stepdefinitions;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.bancolombia.soporte.finacle.screenplay.questions.ValidateAccountCDTForScreen;
import com.bancolombia.soporte.finacle.screenplay.tasks.GoTo_Menu;
import com.bancolombia.soporte.finacle.screenplay.tasks.GoTo_Menu_Initial;
import com.bancolombia.soporte.finacle.screenplay.tasks.Go_Account_Opening;
import com.bancolombia.soporte.finacle.screenplay.tasks.Go_Sol_ID;
import com.bancolombia.soporte.finacle.screenplay.tasks.Login_On_Finacle_Page;
import com.bancolombia.soporte.finacle.screenplay.tasks.OpenTheBrowser;
import com.bancolombia.soporte.finacle.screenplay.tasks.Open_Account;
import com.bancolombia.soporte.finacle.screenplay.tasks.SelectFinacleCore;
import com.bancolombia.soporte.finacle.screenplay.utils.Utilities_Finacle;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

public class OpenCdtPhysicalForScreenStepDefinitons {

	@Managed(driver = "iexplorer")
	private WebDriver hisBrowser;

	private Actor luis = Actor.named("luis");

	@Before
	public void setUP() {
		
		luis.can(BrowseTheWeb.with(hisBrowser));
	}

	Utilities_Finacle utilities = new Utilities_Finacle();

	@Given("^that user is logged in finacle with your$")
	public void thatUserIsLoggedInFinacleWithYour(List<Map<String, String>> dataUser) throws Exception {
		
		luis.wasAbleTo(OpenTheBrowser.on("https://wsfinaclecdtperf.bancolombia.corp:11111/SSO/ui/SSOLogin.jsp"));
		luis.wasAbleTo(Login_On_Finacle_Page.loginInPage(hisBrowser, dataUser));
			
	}
  
	@When("^he wants to work in finacle for branch office (.*)$")
	public void heWantsToWorkInFinacleForBranchOffice(String solID) throws InterruptedException {
		
		luis.wasAbleTo(SelectFinacleCore.in());
		utilities.selecFrame(hisBrowser, "CoreServer");
		luis.attemptsTo(GoTo_Menu_Initial.on("HCCS"));
		luis.attemptsTo(Go_Sol_ID.solInPage(solID));

	}

	@When("^the User enters the next detail the openning physical$")
	public void theUserEntersTheNextDetailTheOpenningPhysical(List<Map<String, String>> dataAccountCDT) throws Exception {

		luis.attemptsTo(GoTo_Menu.on("HOAACTU"));
		luis.attemptsTo(Go_Account_Opening.solAccountOpening(dataAccountCDT));
		luis.attemptsTo(Open_Account.openAccount(dataAccountCDT));
		

	}

	@Then("^he should see the CDT for screen created (.*)$")
	public void heShouldSeeTheCDTCreated(String validationCdt) {
		
		luis.should(GivenWhenThen.seeThat(ValidateAccountCDTForScreen.successful(validationCdt)));
	}
}
