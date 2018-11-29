package com.bancolombia.soporte.finacle.screenplay.tasks;

import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_Sol_ID;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Go_Sol_ID implements Task {

	private String solID;

	public Go_Sol_ID(String solID) {

		this.solID = solID;

	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		if (!Interface_Sol_ID.SUCURSAL.resolveFor(actor).isVisible()) {
			
			Interface_Sol_ID.SUCURSAL.resolveFor(actor).waitUntilVisible();
		}

		actor.attemptsTo(Enter.theValue(solID).into(Interface_Sol_ID.SUCURSAL));
		actor.attemptsTo(Click.on(Interface_Sol_ID.SOL_BUTTON));

	}

	public static Go_Sol_ID solInPage(String solID) {

		return Tasks.instrumented(Go_Sol_ID.class,solID);
	}

}
