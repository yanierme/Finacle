package com.bancolombia.soporte.finacle.screenplay.runners;

import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features="src/test/resources/com/bancolombia/soporte/finacle/features/Inquire_CDT_on_screen.feature",
		glue="com.bancolombia.soporte.finacle.screenplay.stepdefinitions",
		snippets=SnippetType.CAMELCASE,
		tags="@InquireCDTForScreen"
)

public class InquireCdtForScreen {

}
