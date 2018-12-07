package com.bancolombia.soporte.finacle.screenplay.questions;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_ValidationAccountForwebServices;
import com.bancolombia.soporte.finacle.screenplay.utils.Utilities_Finacle;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateAccountCDTForWebServices implements Question<Boolean> {

	private String validationCdt;
	private String Xmlcdt;
	private String action;
	private String nodeParent = null;
	
	Utilities_Finacle utilities_Finacle;

	public ValidateAccountCDTForWebServices(String action) {

		this.action = action;

	}

	@Override
	public Boolean answeredBy(Actor actor) {

		if (action.equals("interest Payment")) {

			nodeParent = "executeFinacleScript_CustomData";

		} else if (action.equals("physical CDT")) {

			nodeParent = "UBUSTransaction";

		} else if (action.equals("inquire CDT")) {

			nodeParent = "HostTransaction";
		}

		Xmlcdt = Interface_ValidationAccountForwebServices.RESULT_XML.resolveFor(actor).getText();

		try {
			validationCdt = utilities_Finacle.readXML(Xmlcdt, nodeParent, "Status");
		} catch (SAXException | IOException | ParserConfigurationException e) {

			e.printStackTrace();
		}
		System.out.println(validationCdt);

		if (validationCdt.equals("SUCCESS") || validationCdt.equals("SUCCESSFUL")) {

			System.out.println("La apertura fue exitosa");
			return true;

		} else {

			System.out.println("La apertura fue fallida");
			return false;
		}

	}

	public static ValidateAccountCDTForWebServices successful(String action) {

		return new ValidateAccountCDTForWebServices(action);
	}

}
