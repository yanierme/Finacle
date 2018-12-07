package com.bancolombia.soporte.finacle.screenplay.tasks;

import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_Upload_FileDemat;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class Upload_FileDemat implements Task {

	private String menu;

	public Upload_FileDemat(String menu) {

		this.menu = menu;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Click.on(Interface_Upload_FileDemat.SELECT_OPTION));
		


	}

	public static Upload_FileDemat on(String menu) {
		return Tasks.instrumented(Upload_FileDemat.class, menu);
	}

}
