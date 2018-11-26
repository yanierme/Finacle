package com.bancolombia.soporte.finacle.screenplay.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class Interface_ValidationAccountForScreen {
	
	public static final Target ACCOUNT_VALIDATIONM = Target.the("Account validation").locatedBy("//table[@class='resultpage']/tbody/tr/td[2]/font");
	public static final Target NUMBER  =  Target.the("Number Account").locatedBy("//table[@class='resultpage']/tbody/tr/td[2]/font");
	public static final Target BTN_OK =  Target.the("Button ok").located(By.id("Back"));
}
