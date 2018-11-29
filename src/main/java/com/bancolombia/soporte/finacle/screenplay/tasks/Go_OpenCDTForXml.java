package com.bancolombia.soporte.finacle.screenplay.tasks;

import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_GoXML;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class Go_OpenCDTForXml implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		Interface_GoXML.CLEAR.resolveFor(actor).waitUntilVisible();
		actor.attemptsTo(Click.on(Interface_GoXML.CLEAR),Click.on(Interface_GoXML.REQUEST_XML));

	}

	public static Go_OpenCDTForXml on() {

		return Tasks.instrumented(Go_OpenCDTForXml.class);
	}
 
}
