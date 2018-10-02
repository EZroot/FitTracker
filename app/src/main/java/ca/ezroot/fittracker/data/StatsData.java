package ca.ezroot.fittracker.data;

import android.content.Context;

import java.io.File;
import java.util.Iterator;
import java.util.Vector;

import ca.ezroot.fittracker.parser.DataConverter;
import ca.ezroot.fittracker.parser.DataHandler;

public class StatsData
{
	/*
	StatsData
	-get workouts as a datastructure
	-sort datastructure by EARLIEST_DATE() to LATEST_DATE();
	-LATEST_DATE() is basically todays date. so current stats should be on top? Dynamic data? hmm...
	-organize workouts by data
	-display in a list organized by date.
	 */
	
	Vector<LiftData> workoutDatabase;
	
	//grab our data
	public StatsData(Context context)
	{
		workoutDatabase = getLiftDatabase(context);
	}
	
	/* display data in front-end format */
	public void displayData()
	{
		//card view? scrollable?
	}
	
	/* organizes by date
		maybe datastructure of datastructures? .. maybe
		if it slows down from a fucklod of cardviews i can limit the created ones
		and load in more as it scrolls. depending on the direction
	 */
	private Vector<LiftData> sortByDate(Vector<LiftData> database)
	{
		Vector<LiftData> result = new Vector<>();
		//SORT!!!!!!!!!!!!!!!!!!!!!? or group in to multiple data structures
		//which can be used to display multiple card view data
		return result;
	}
	
	/* returns json string database to vector data*/
	private Vector<LiftData> getLiftDatabase(Context context)
	{
		Vector<LiftData> result;
		
		File f = new File(context.getFilesDir().getPath(), "data.txt");
		if(f.exists())
		{
			result = DataConverter.convertFromJsonStringDatabase(DataHandler.read(context));
		}
		else
		{
			result = new Vector<>();
		}
		
		return result;
	}
}
