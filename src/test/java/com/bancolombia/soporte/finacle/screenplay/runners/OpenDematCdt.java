package com.bancolombia.soporte.finacle.screenplay.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features="src/test/resources/com/bancolombia/soporte/finacle/features/open_demat_cdt.feature",
		glue="com.bancolombia.soporte.finacle.screenplay.stepdefinitions",
		snippets=SnippetType.CAMELCASE,
		tags="@AccountDematerialized"
)

public class OpenDematCdt {
	
}
