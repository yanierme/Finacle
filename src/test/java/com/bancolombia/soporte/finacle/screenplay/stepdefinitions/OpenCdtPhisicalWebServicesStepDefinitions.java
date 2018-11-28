package com.bancolombia.soporte.finacle.screenplay.stepdefinitions;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;
import com.bancolombia.soporte.finacle.screenplay.questions.ValidateAccountCDTForWebServices;
import com.bancolombia.soporte.finacle.screenplay.tasks.Go_FinacleXML;
import com.bancolombia.soporte.finacle.screenplay.tasks.Go_OpenCDTForXml;
import com.bancolombia.soporte.finacle.screenplay.tasks.OpenTheBrowser;
import com.bancolombia.soporte.finacle.screenplay.utils.Utilities_Finacle;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

public class OpenCdtPhisicalWebServicesStepDefinitions {

	Utilities_Finacle utilities;

	@Managed(driver = "iexplorer")
	private WebDriver hisBrowser;

	private Actor usuario = Actor.named("Usuario");

	@Before
	public void setUP() {
		usuario.can(BrowseTheWeb.with(hisBrowser));
	}

	@Given("^that user is the page of finacle integrator$")
	public void thatUserIsThePageOfFinacleIntegrator() {

		usuario.wasAbleTo(
				OpenTheBrowser.on("https://wsfinaclecdtperf.bancolombia.corp:11111/fiui/services/RetCustAdd.html"));

	}

	@When("^the User enters the next detais of the account$")
	public void theUserEntersTheNextDetaisOfTheAccount(Map<String, String> dataUser)
			throws ParserConfigurationException, SAXException, IOException, TransformerException, AWTException {
 
		utilities.updateXml(dataUser);
		usuario.attemptsTo(Go_FinacleXML.by());
		utilities.swithWindows(hisBrowser);
		usuario.attemptsTo(Go_OpenCDTForXml.on());
		utilities.loadXMLToString();
		utilities.copyPaste();

	}

	@Then("^he should see the CDT for web servicescreated successfully$")
	public void heShouldSeeTheCDTForWebServicescreatedSuccessfully() throws Exception {

		usuario.should(GivenWhenThen.seeThat(ValidateAccountCDTForWebServices.successful()));
	}

}
