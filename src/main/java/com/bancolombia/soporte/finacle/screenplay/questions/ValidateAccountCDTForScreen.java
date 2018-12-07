package com.bancolombia.soporte.finacle.screenplay.questions;

import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_ValidationAccountForScreen;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateAccountCDTForScreen implements Question<Boolean> {

	private String validationCdt;
	private String numberCDT;
	private String resultSucceful;
	
		 
	public ValidateAccountCDTForScreen(String validationCdt) {

		this.validationCdt = validationCdt;

	} 

	@Override
	public Boolean answeredBy(Actor actor) {

		numberCDT = Interface_ValidationAccountForScreen.NUMBER.resolveFor(actor).getText()
				.substring(7,20);
		
		
		resultSucceful = Interface_ValidationAccountForScreen.ACCOUNT_VALIDATIONM.resolveFor(actor).getText()
				.substring(26, 38);
			
		if (resultSucceful.equalsIgnoreCase(validationCdt)) {
			return true;
		} else {
			return false;
		}
	}

	public static ValidateAccountCDTForScreen successful(String validationCdt) {

		return new ValidateAccountCDTForScreen(validationCdt);
	}
	
	public String getnumberCDT() {
		return numberCDT;
	}

}
