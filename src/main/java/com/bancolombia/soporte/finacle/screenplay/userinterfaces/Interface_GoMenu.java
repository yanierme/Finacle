package com.bancolombia.soporte.finacle.screenplay.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class Interface_GoMenu {

	public static final Target MENU = Target.the("Select Core finacle").located(By.id("menuName"));
	public static final Target GOTO_MENU = Target.the("option Core finacle").located(By.id("gotomenu"));
}
