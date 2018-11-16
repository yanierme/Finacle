package com.bancolombia.soporte.finacle.screenplay.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OnWebDriver {
	
private static WebDriver driver;
	
	public static WebDriver onUrl(String url) {
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver ;
	}

}
