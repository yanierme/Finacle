package com.bancolombia.soporte.finacle.screenplay.tasks;

import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_MenuInitial_CoreFinacle;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class GoTo_Menu_Initial implements Task {
	
	String menu;
	
	public GoTo_Menu_Initial(String menu) {
	
		this.menu = menu;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		Interface_MenuInitial_CoreFinacle.SELECT_FINACLE_CORE.resolveFor(actor).waitUntilVisible();
		actor.attemptsTo(
				Enter.theValue(menu).into(Interface_MenuInitial_CoreFinacle.SELECT_FINACLE_CORE),
				Click.on(Interface_MenuInitial_CoreFinacle.FINACLE_CORE)
				);
	
	}

	public static GoTo_Menu_Initial on(String menu) {
 		return new GoTo_Menu_Initial(menu);
	}

}
