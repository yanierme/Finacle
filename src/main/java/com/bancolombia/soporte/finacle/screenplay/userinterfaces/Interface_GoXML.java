package com.bancolombia.soporte.finacle.screenplay.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Interface_GoXML {

	public static final Target CLEAR = Target.the("Clear xml").locatedBy("//*[@name='clearBut']");
	public static final Target REQUEST_XML = Target.the("Request").locatedBy("//*[@name='ipXml']");
	public static final Target OPTION_XML = Target.the("Option the xml").locatedBy("//input[@value='HTTP']");
	public static final Target OPTION_SUBMIT = Target.the("Submit").locatedBy("//input[@value='Submit!']");

}
