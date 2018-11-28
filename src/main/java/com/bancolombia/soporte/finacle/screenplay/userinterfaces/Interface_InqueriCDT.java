package com.bancolombia.soporte.finacle.screenplay.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class Interface_InqueriCDT {

	public static final Target NUMBER = Target.the("Number title").located(By.id("titleNo"));
	public static final Target GOTO_INQUERI = Target.the("Goto inqueri").located(By.id("Accept"));
}
