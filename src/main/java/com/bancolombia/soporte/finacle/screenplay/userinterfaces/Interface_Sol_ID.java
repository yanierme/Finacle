package com.bancolombia.soporte.finacle.screenplay.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class Interface_Sol_ID {

	public static final Target SUCURSAL     =    Target.the("sucursal").located(By.id("targetSolId"));
	public static final Target SOL_BUTTON   =    Target.the("sol_button").located(By.id("Submit"));
	
}
