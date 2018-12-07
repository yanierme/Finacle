package com.bancolombia.soporte.finacle.screenplay.tasks;

import java.io.IOException;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_GoXML;
import com.bancolombia.soporte.finacle.screenplay.utils.Utilities_Finacle;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class Update_FileXml implements Task {

	private String action;
	private String fileXml;
	private Map<String, String> dataUser;
	
	Utilities_Finacle utilities_Finacle;
	

	public Update_FileXml(String action, Map<String, String> dataUser) {
		 
		this.action = action;
		this.dataUser = dataUser;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		try {
			
			fileXml = utilities_Finacle.fileXmlAction(action);
			utilities_Finacle.updateXml(dataUser,fileXml);

		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {

			e.printStackTrace();
		}

		actor.attemptsTo(Click.on(Interface_GoXML.OPTION_XML), Click.on(Interface_GoXML.OPTION_SUBMIT));

	}

	public static Update_FileXml with(String action, Map<String, String> dataUser) {

		return Tasks.instrumented(Update_FileXml.class, action, dataUser);
	}

}
