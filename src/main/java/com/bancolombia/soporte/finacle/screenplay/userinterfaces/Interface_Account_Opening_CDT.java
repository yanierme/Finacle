package com.bancolombia.soporte.finacle.screenplay.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class Interface_Account_Opening_CDT {

	public static final Target GENERAL = Target.the("general").located(By.id("tugen"));
	public static final Target OPENING_DATE = Target.the("opening_date").located(By.id("acctOpenDate_ui"));
	public static final Target STATEMENT = Target.the("Statement").located(By.id("pbPsFlg"));
	public static final Target INTEREST_AND_TAX = Target.the("Interest and tax").located(By.id("tuint"));
	public static final Target WITHHOLDING_TAX_BORNE_BY  = Target.the("Withholding Tax Borne By").locatedBy("(//input[@id='wtaxAmtScopeFlg'])[2]");
	
	public static final Target SCHEME = Target.the("scheme").located(By.id("tusch"));
	public static final Target INITIAL_DEPOSIT = Target.the("Initial Deposit").located(By.id("depAmt"));
	public static final Target TENURE_DAYS = Target.the("Tenure in Days").located(By.id("cTenureDays"));
	public static final Target INTEREST_RATE = Target.the("Spread Interest Rate").located(By.id("cIntRate"));
	public static final Target FREQUENCY = Target.the("Payout Frequency (Days)").located(By.id("custIPF"));
	public static final Target FLOWS = Target.the("general").located(By.id("tuflw"));
	public static final Target RELATED = Target.the("Related").located(By.id("turelatedpartydetails"));
	public static final Target RENEWAL_AND_CLOSURE = Target.the("Renewal").located(By.id("turen"));
	public static final Target SUBMIT_ACCOUNT = Target.the("Submit account").located(By.id("Submit"));
	public static final Target ACCOUNT_VALIDATIONM = Target.the("Account validation").locatedBy("//table[@class='resultpage']/tbody/tr/td[2]/font");
	public static final Target OK = Target.the("Account validation").located(By.id("Back"));
}
 