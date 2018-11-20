package com.bancolombia.soporte.finacle.screenplay.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class Interface_Account_Opening {

	public static final Target CIF_ID = Target.the("cif_id").located(By.id("cifId"));
	public static final Target SCHEME_CODE = Target.the("scheme_code").located(By.id("schmCode"));
	public static final Target IR = Target.the("ir").located(By.id("Accept"));

}
