package com.bancolombia.soporte.finacle.screenplay.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Interface_Select_Finacle_Core 
{
	
	public static final Target SELECT_OPTION  =  Target.the("List options").locatedBy("//*[@name='appSelect']");
	public static final Target FINCORE  =  Target.the("Fincore").locatedBy("//*[contains(text(),'FINCORE')]");
 
	 
	
}