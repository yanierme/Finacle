package com.bancolombia.soporte.finacle.screenplay.questions;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_ValidationAccountForwebServices;
import com.bancolombia.soporte.finacle.screenplay.utils.Utilities_Finacle;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

public class ValidateAccountCDTForWebServices implements Question<Boolean> {

	String validationCdt;
	private String Xmlcdt;
	Utilities_Finacle utilities_Finacle;

	@Override
	public Boolean answeredBy(Actor actor) {

		actor.attemptsTo(Click.on(Interface_ValidationAccountForwebServices.SUBMIT));
		Xmlcdt = Interface_ValidationAccountForwebServices.RESULT_XML.resolveFor(actor).getText();

		try {
			validationCdt = utilities_Finacle.readXML(Xmlcdt,"UBUSTransaction","Status");
		} catch (SAXException | IOException | ParserConfigurationException e) {

			e.printStackTrace();
		}
		
		if (validationCdt.equals("FAILED")) {
 
			System.out.println("La apertura fue fallida");
			return false;

		} else {

			System.out.println("La apertura fue exitosa"); 
			return true;
		}

	}

	public static ValidateAccountCDTForWebServices successful() {

		return new ValidateAccountCDTForWebServices();
	}

}
