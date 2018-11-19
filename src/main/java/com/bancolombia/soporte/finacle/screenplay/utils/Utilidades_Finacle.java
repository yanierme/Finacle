package com.bancolombia.soporte.finacle.screenplay.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Utilidades_Finacle extends PageObject {

	public void selecFrame(WebDriver hisBrowser, String frame) {

		if (frame == "loginFrame") {

			hisBrowser.switchTo().frame(hisBrowser.findElement(By.name("loginFrame")));
		} else if (frame == "CoreServer") {

			hisBrowser.switchTo().frame(hisBrowser.findElement(By.name("CoreServer")));
			hisBrowser.switchTo().frame(hisBrowser.findElement(By.name("FINW")));
		}

	}

	public void GoToMenu(WebDriver hisBrowser, String menu) throws InterruptedException {
		
		Thread.sleep(6000);
		hisBrowser.findElement(By.id("menuName")).clear();
		hisBrowser.findElement(By.id("menuName")).sendKeys(menu);
		hisBrowser.findElement(By.id("gotomenu")).click();
	
	}

	public void selectFinacleCore(WebDriver hisBrowser, String option) throws InterruptedException {

		Select element = new Select(hisBrowser.findElement(By.name("appSelect")));
		element.selectByVisibleText(option);
		hisBrowser.switchTo().alert().accept();
	}

	public void clicOnMessage(WebDriver hisBrowser) throws InterruptedException {
		Thread.sleep(3000);
		hisBrowser.switchTo().alert().accept();
	}

	public void enterKey() throws AWTException, InterruptedException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}

}
