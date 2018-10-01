package ca.ezroot.fittracker.data;

import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Date;

public class LiftData
{
	String name;
	int reps;
	int sets;
	
	public void log(String name, int reps)
	{
		this.name = name;
		this.reps = reps;
		this.sets = 1;
	}
	
	public void logAll(String name, int totalreps, int totalsets)
	{
		this.name = name;
		this.reps = totalreps;
		this.sets = totalsets;
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
}
