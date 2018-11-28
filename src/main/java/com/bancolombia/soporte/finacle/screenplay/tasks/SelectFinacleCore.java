package com.bancolombia.soporte.finacle.screenplay.tasks;

import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_Select_Finacle_Core;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class SelectFinacleCore implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {

		Interface_Select_Finacle_Core.select.resolveFor(actor).waitUntilVisible();
		actor.attemptsTo(SelectFromOptions.byValue("CoreServer").from(Interface_Select_Finacle_Core.select));
		BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();

	}

	public static SelectFinacleCore in( ) {

		return new SelectFinacleCore();
	}

}
