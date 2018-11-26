package com.bancolombia.soporte.finacle.screenplay.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Interface_ValidationAccountForwebServices {
	
	public static final Target SUBMIT = Target.the("Submit").locatedBy("//*[@name='submitBut']");
	public static final Target RESULT_XML = Target.the("Result xml").locatedBy("//*[@name='opXml']");


}
