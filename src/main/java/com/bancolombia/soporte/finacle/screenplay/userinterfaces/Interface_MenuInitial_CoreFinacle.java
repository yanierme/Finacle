package com.bancolombia.soporte.finacle.screenplay.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class Interface_MenuInitial_CoreFinacle {
	
	public static final Target MENU_VALIDATION = Target.the("Menu validation").located(By.id("FAVMNU_anc"));
	public static final Target SELECT_FINACLE_CORE = Target.the("Select Core finacle").located(By.id("menuName"));
	public static final Target FINACLE_CORE = Target.the("option Core finacle").located(By.id("gotomenu"));
}
