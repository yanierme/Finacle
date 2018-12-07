package com.bancolombia.soporte.finacle.screenplay.tasks;

import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_Select_Finacle_Core;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

public class SelectFinacleCore implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {

		Interface_Select_Finacle_Core.SELECT_OPTION.resolveFor(actor).waitUntilVisible();
		actor.attemptsTo(Click.on(Interface_Select_Finacle_Core.SELECT_OPTION),
				Click.on(Interface_Select_Finacle_Core.FINCORE));
		BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();

	} 

	public static SelectFinacleCore in() {

		return Tasks.instrumented(SelectFinacleCore.class);
	}

}
