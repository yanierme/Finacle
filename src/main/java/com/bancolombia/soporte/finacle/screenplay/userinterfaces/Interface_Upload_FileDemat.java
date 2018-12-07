package com.bancolombia.soporte.finacle.screenplay.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class Interface_Upload_FileDemat {

	public static final Target SELECT_OPTION = Target.the("Select upload file").located(By.id("fun"));
	public static final Target GOTO_INQUERI = Target.the("Goto inqueri").located(By.id("Accept"));
}
