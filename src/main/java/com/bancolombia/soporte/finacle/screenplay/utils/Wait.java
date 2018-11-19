package com.bancolombia.soporte.finacle.screenplay.utils;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;





public class Wait {

	public static void main(String[] args) {
		
		WaitUntil(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("prueba")));

	}

	private static void WaitUntil(
			ExpectedCondition<List<WebElement>> visibilityOfAllElementsLocatedBy) {
		
	}

}
