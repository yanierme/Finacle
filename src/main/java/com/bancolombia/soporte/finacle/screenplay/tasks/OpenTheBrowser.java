package com.bancolombia.soporte.finacle.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenTheBrowser implements Task {

	String url;

	public OpenTheBrowser(String url) {

		this.url = url;
	}

	@Override
	@Step("{0} Opens the Browser on Finacle Home Page")
	public <T extends Actor> void performAs(T actor) {

		Open.browserOn();
		actor.attemptsTo(Open.url(url));

	}

	public static OpenTheBrowser on(String url) {

		return Tasks.instrumented(OpenTheBrowser.class, url);
	}

}
