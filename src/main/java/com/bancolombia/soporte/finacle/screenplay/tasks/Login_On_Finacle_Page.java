package com.bancolombia.soporte.finacle.screenplay.tasks;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.bancolombia.soporte.finacle.screenplay.userinterfaces.Interface_Login_Finacle_Page;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Login_On_Finacle_Page implements Task {

	private String user;
	private String password;
	boolean bValue = true;

	public Login_On_Finacle_Page(List<Map<String, String>> dataUser) {

		this.user = dataUser.get(0).get("user");
		this.password = dataUser.get(0).get("password");

	}

	@Override
	public <T extends Actor> void performAs(T actor)

	{

		actor.attemptsTo(Enter.theValue(user).into(Interface_Login_Finacle_Page.USER_ID));

		while (bValue == true) {

			actor.attemptsTo(Enter.theValue(password).into(Interface_Login_Finacle_Page.PASSWORD),
					Click.on(Interface_Login_Finacle_Page.SUBMIT));

			bValue = false;

			if (Interface_Login_Finacle_Page.ALREADY_LOGGED_IN.resolveFor(actor).isVisible()) {

				BrowseTheWeb.as(actor).getDriver().findElement(By.xpath("//input[@name='Submit2']"))
						.sendKeys(Keys.ENTER);

				BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();
				bValue = true;

			}

			else if (Interface_Login_Finacle_Page.USER_ID.resolveFor(actor).isVisible()) {

				BrowseTheWeb.as(actor).getDriver().findElement(By.id("usertxt")).sendKeys(Keys.F5);
				bValue = true;
			}

		}
	}

	public static Login_On_Finacle_Page loginInPage(List<Map<String, String>> dataUser) {

		return new Login_On_Finacle_Page(dataUser);
	}

}
