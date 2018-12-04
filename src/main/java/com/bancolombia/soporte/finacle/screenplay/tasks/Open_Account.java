package com.bancolombia.soporte.finacle.screenplay.tasks;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_Account_Opening_CDT;
import com.bancolombia.soporte.finacle.screenplay.utils.Utilities_Finacle;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class Open_Account implements Task {
	
	Utilities_Finacle utilities; 
	private String openingDate;
	private String stament;
	private String initialDeposit;
	private String ternureDay;
	private String interestRate;
	private String frequency;

	public Open_Account(List<Map<String, String>> dataAccountCDT) {

		this.openingDate = dataAccountCDT.get(0).get("opening_date");
		this.stament = dataAccountCDT.get(0).get("stament");
		this.initialDeposit = dataAccountCDT.get(0).get("initial_Amt");
		this.ternureDay = dataAccountCDT.get(0).get("tenor");
		this.interestRate = dataAccountCDT.get(0).get("rate");
		this.frequency = dataAccountCDT.get(0).get("frecuency");

	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Click.on(Interface_Account_Opening_CDT.GENERAL),
				Enter.theValue(openingDate).into(Interface_Account_Opening_CDT.OPENING_DATE),
				SelectFromOptions.byValue(stament).from(Interface_Account_Opening_CDT.STATEMENT),
				Click.on(Interface_Account_Opening_CDT.INTEREST_AND_TAX),
				Click.on(Interface_Account_Opening_CDT.WITHHOLDING_TAX_BORNE_BY),
				Click.on(Interface_Account_Opening_CDT.SCHEME),
				Enter.theValue(initialDeposit).into(Interface_Account_Opening_CDT.INITIAL_DEPOSIT),
				Enter.theValue(ternureDay).into(Interface_Account_Opening_CDT.TENURE_DAYS),
				Enter.theValue(interestRate).into(Interface_Account_Opening_CDT.INTEREST_RATE),
				Enter.theValue(frequency).into(Interface_Account_Opening_CDT.FREQUENCY));

		if (!Interface_Account_Opening_CDT.FLOWS.resolveFor(actor).isVisible()) {

			Interface_Account_Opening_CDT.FLOWS.resolveFor(actor).waitUntilVisible();
		}

		actor.attemptsTo(Click.on(Interface_Account_Opening_CDT.FLOWS));
		actor.attemptsTo(Click.on(Interface_Account_Opening_CDT.RELATED),
				Click.on(Interface_Account_Opening_CDT.RENEWAL_AND_CLOSURE),
				Click.on(Interface_Account_Opening_CDT.INTEREST_AND_TAX));

		if (!Interface_Account_Opening_CDT.SCHEME.resolveFor(actor).isVisible()) {

			Interface_Account_Opening_CDT.SCHEME.resolveFor(actor).waitUntilVisible();
		}
		actor.attemptsTo(Click.on(Interface_Account_Opening_CDT.SCHEME));

		if (!Interface_Account_Opening_CDT.FLOWS.resolveFor(actor).isVisible()) {

			Interface_Account_Opening_CDT.FLOWS.resolveFor(actor).waitUntilVisible();
		}
		actor.attemptsTo(Click.on(Interface_Account_Opening_CDT.FLOWS),
				Click.on(Interface_Account_Opening_CDT.SUBMIT_ACCOUNT));
		
		
		try {
			utilities.enterKey();
		} catch (AWTException | InterruptedException e) {
		 
			e.printStackTrace();
		}

	}

	public static Open_Account openAccount(List<Map<String, String>> dataAccountCDT) {

		return Tasks.instrumented(Open_Account.class, dataAccountCDT);
	}

}
