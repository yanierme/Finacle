package com.bancolombia.soporte.finacle.screenplay.tasks;
import java.util.Calendar;
import java.util.Date;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
 
public class Wait implements Task{

	private int milliseconds;
	
	public Wait(int milliseconds) {
		
		this.milliseconds = milliseconds;
	}

	 
	@Override
	public <T extends Actor> void performAs(T actor) {
		
		Calendar calendar = Calendar.getInstance();
		Date hour = new Date();
		calendar.setTime(hour);
		
		if (milliseconds >= 1000) {
			
			calendar.add(Calendar.SECOND,(milliseconds/1000));
			
		}else if(milliseconds < 1000) {
			
			calendar.add(Calendar.MILLISECOND, (milliseconds));
			
		}
		while (hour.compareTo(calendar.getTime()) < 0) {
			
			hour = new Date();
			
		}
		
		
	}
	
	public static Wait inMillisecons(int milliseconds) {
		
		return Tasks.instrumented(Wait.class, milliseconds);
	}

}
