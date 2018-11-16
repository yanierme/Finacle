package com.bancolombia.soporte.finacle.screenplay.questions;

import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_Account_Opening_CDT;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateAccountCDT implements Question<Boolean> {

	private String validationCdt;

	public ValidateAccountCDT(String validationCdt) {

		this.validationCdt = validationCdt;

	}

	@Override
	public Boolean answeredBy(Actor actor) {

		String resultSucceful = Interface_Account_Opening_CDT.ACCOUNT_VALIDATIONM.resolveFor(actor).getText()
				.substring(26, 38);
		if (resultSucceful.equalsIgnoreCase(validationCdt)) {
			return true;
		} else {
			return false;
		}
	}

	public static ValidateAccountCDT successful(String validationCdt) {

		return new ValidateAccountCDT(validationCdt);
	}

}
