package com.bancolombia.soporte.finacle.screenplay.tasks;

import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_GoMenu;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class GoTo_Menu implements Task {

	String menu;

	public GoTo_Menu(String menu) {

		this.menu = menu;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Enter.theValue(menu).into(Interface_GoMenu.MENU), Click.on(Interface_GoMenu.GOTO_MENU));

		BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();

	}

	public static GoTo_Menu on(String menu) {
		return Tasks.instrumented(GoTo_Menu.class, menu);
	}

}
