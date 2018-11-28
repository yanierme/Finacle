package com.bancolombia.soporte.finacle.screenplay.tasks;

import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_GoMenuInitial;

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

		if (!Interface_GoMenuInitial.MENU_VALIDATION.resolveFor(actor).isVisible()) {

			Interface_GoMenuInitial.MENU_VALIDATION.resolveFor(actor).waitUntilVisible();

		}

		actor.attemptsTo(Enter.theValue(menu).into(Interface_GoMenuInitial.MENU),
				Click.on(Interface_GoMenuInitial.GOTO_MENU));

	}

	public static GoTo_Menu_Initial on(String menu) {
		return new GoTo_Menu_Initial(menu);
	}

}
