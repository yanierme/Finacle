package com.bancolombia.soporte.finacle.screenplay.tasks;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_GoXML;
import com.bancolombia.soporte.finacle.screenplay.utils.Utilities_Finacle;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class RunXml implements Task {
	
	String action;
	Utilities_Finacle utilities; 
	WebDriver hisBrowser;
	
	public RunXml(String action,WebDriver hisBrowser) {
	 
		this.action = action;
		this.hisBrowser = hisBrowser;
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		
		
		utilities.swithWindows(hisBrowser);
		Interface_GoXML.CLEAR.resolveFor(actor).waitUntilVisible();
		actor.attemptsTo(Click.on(Interface_GoXML.CLEAR),Click.on(Interface_GoXML.REQUEST_XML));
		
		String fileXml=utilities.fileXmlAction(action);
		
		try {
			utilities.copyPaste(fileXml);
		} catch (AWTException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static RunXml with(String action,WebDriver hisBrowser) {

		return Tasks.instrumented(RunXml.class,action, hisBrowser);
	}

	
 
}
