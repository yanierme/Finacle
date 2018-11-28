package com.bancolombia.soporte.finacle.screenplay.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class Interface_Login_Finacle_Page 
{
	
	public static final Target USER_ID  =  Target.the("User_Id").located(By.id("usertxt"));
	public static final Target PASSWORD =  Target.the("password").located(By.id("passtxt"));
	public static final Target SUBMIT   =  Target.the("submit").located(By.id("Submit"));
	public static final Target USER_VALIDATION   =  Target.the("user validation").locatedBy("//input[@name='TZDetails']");
	public static final Target ALREADY_LOGGED_IN  =  Target.the("already logged in").locatedBy("//input[@name='Submit2']");
	public static final Target FRAME_LOGIN  =  Target.the("Frame login").locatedBy("//*[@name='loginFrame']");
	
	
	 
	
}