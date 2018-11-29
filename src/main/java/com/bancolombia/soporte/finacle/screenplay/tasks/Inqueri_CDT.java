package com.bancolombia.soporte.finacle.screenplay.tasks;

import java.util.List;
import java.util.Map;

import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_InqueriCDT;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Inqueri_CDT implements Task {

	private String numberTitle;

	public Inqueri_CDT(List<Map<String, String>> numberTitle) {

		this.numberTitle = numberTitle.get(0).get("Number_CDT");

	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Enter.theValue(numberTitle).into(Interface_InqueriCDT.NUMBER),
				Click.on(Interface_InqueriCDT.GOTO_INQUERI));

	}

	public static Inqueri_CDT the(List<Map<String, String>> numberTitle) {

		return Tasks.instrumented(Inqueri_CDT.class, numberTitle);
	}

}
