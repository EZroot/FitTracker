package ca.ezroot.fittracker.data;

import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Date;

public class LiftData
{
	String name;
	int reps;
	int sets;
	String todaysDate;
	
	public void log(String name, int reps)
	{
		this.name = name;
		this.reps = reps;
		this.sets = 1;
		this.todaysDate = getFormattedDate();
	}
	
	public void logAll(String name, int totalreps, int totalsets)
	{
		this.name = name;
		this.reps = totalreps;
		this.sets = totalsets;
		this.todaysDate = getFormattedDate();
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getReps()
	{
		return this.reps;
	}
	
	public int getSets()
	{
		return this.sets;
	}
	
	//This is automatically set
	public String getTodaysDate()
	{
		return this.todaysDate;
	}
	
	/*Used to set the date when returning Liftdata data
	  * as an object from a JsonObject since
	  *  we cant do it with log() or logAll()
	  */
	public void setTodaysDate(String todaysDate)
	{
		this.todaysDate = todaysDate;
	}
	
	private String getFormattedDate()
	{
		Date d = Calendar.getInstance().getTime();
		
		String dayOfTheWeek = (String) DateFormat.format("EEEE", d); // Thursday
		String day          = (String) DateFormat.format("dd",   d); // 20
		String monthString  = (String) DateFormat.format("MMM",  d); // Jun
		String monthNumber  = (String) DateFormat.format("MM",   d); // 06
		String year         = (String) DateFormat.format("yyyy", d); // 2013
		
		return (String)DateFormat.format("EEEE, MMM dd, yyyy",d);
	}
}
