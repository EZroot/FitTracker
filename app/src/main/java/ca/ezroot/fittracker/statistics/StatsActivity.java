package ca.ezroot.fittracker.statistics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;

import ca.ezroot.fittracker.R;
import ca.ezroot.fittracker.data.StatsData;
import ca.ezroot.fittracker.parser.DataHandler;

public class StatsActivity extends AppCompatActivity
{
	//Data
	StatsData statsData;
	
	//Form data
	ScrollView scrollView;
	LinearLayout linearLayout;
	
	TextView textViewWorkoutName;
	TextView textViewWorkoutReps;
	TextView textViewWorkoutSets;
	TextView textViewWorkoutDate;
	
	public void onInit()
	{
		//data
		statsData = new StatsData(getApplicationContext());
		
		//forms
		scrollView = new ScrollView(getApplicationContext());
		linearLayout = (LinearLayout)findViewById(R.id.linearLayout);
		
		textViewWorkoutName = (TextView)findViewById(R.id.workoutname);
		textViewWorkoutReps = (TextView)findViewById(R.id.workoutreps);
		textViewWorkoutSets = (TextView)findViewById(R.id.workoutsets);
		textViewWorkoutDate = (TextView)findViewById(R.id.workoutdate);
	}
	
	public void displayData()
	{
		//statsData.displayData();
		//stats.calculate date
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stats);
		
		onInit();
		File f = new File(getApplicationContext().getFilesDir().getPath(), "data.txt");
		if(f.exists())
		{
			/* for each saved workout, create a new linearlayout + children and FILL it*/
			//for(int i = 0; i < statsData.getItemCount(); i++)
			//{
			textViewWorkoutName.setText("Workout: "+statsData.getLiftingDatabase().get(0).getName());
			textViewWorkoutReps.setText("Reps: "+Integer.toString(statsData.getLiftingDatabase().get(0).getReps()));
			textViewWorkoutSets.setText("Sets:" +Integer.toString(statsData.getLiftingDatabase().get(0).getSets()));
			textViewWorkoutDate.setText(statsData.getLiftingDatabase().get(0).getTodaysDate().toString());
			//}
			f.delete();
		}
	}
}
