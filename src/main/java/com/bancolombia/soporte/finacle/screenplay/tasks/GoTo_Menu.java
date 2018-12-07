package com.bancolombia.soporte.finacle.screenplay.tasks;

import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_GoMenu;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class GoTo_Menu implements Task {

	private String menu;

	public GoTo_Menu(String menu) {

		this.menu = menu;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Enter.theValue(menu).into(Interface_GoMenu.MENU), Click.on(Interface_GoMenu.GOTO_MENU));


	}

	public static GoTo_Menu on(String menu) {
		return Tasks.instrumented(GoTo_Menu.class, menu);
	}

}
