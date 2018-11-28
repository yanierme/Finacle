package com.bancolombia.soporte.finacle.screenplay.tasks;

import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_GoXML;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class Go_FinacleXML implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Click.on(Interface_GoXML.OPTION_XML), Click.on(Interface_GoXML.OPTION_SUBMIT));

	}

	public static Go_FinacleXML by() { 

		return new Go_FinacleXML();
	}

}
