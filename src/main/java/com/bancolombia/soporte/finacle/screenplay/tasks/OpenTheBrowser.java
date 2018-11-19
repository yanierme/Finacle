package com.bancolombia.soporte.finacle.screenplay.tasks;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.bancolombia.soporte.finacle.screenplay.userinterfaces.FinacleHomePage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenTheBrowser implements Task {

	@Override
	@Step("{0} Opens the Browser on Finacle Home Page")
	public <T extends Actor> void performAs(T actor) {
		 
		actor.attemptsTo(Open.browserOn(new FinacleHomePage()));
		
		}

	public static OpenTheBrowser on() {
		//return new OpenTheBrowser();
		return instrumented(OpenTheBrowser.class);
	}

}
