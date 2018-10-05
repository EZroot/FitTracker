package ca.ezroot.fittracker.statistics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
	CardView cardView;
	RelativeLayout relativeLayout;
	
	TextView textViewWorkoutName;
	TextView textViewWorkoutReps;
	TextView textViewWorkoutSets;
	TextView textViewWorkoutDate;
	
	//Multiple
	CardView cardView2;
	RelativeLayout relativeLayout2;
	TextView[] textViewData;
	
	public void onInit()
	{
		//data
		statsData = new StatsData(getApplicationContext());
		
		//forms
		scrollView = new ScrollView(getApplicationContext());
		linearLayout = (LinearLayout)findViewById(R.id.linearLayout);
		
		//Single card
		cardView = (CardView)findViewById(R.id.cardid);
		relativeLayout = (RelativeLayout)findViewById(R.id.relativelayoutid);
		
		textViewWorkoutName = (TextView)findViewById(R.id.workoutname);
		textViewWorkoutReps = (TextView)findViewById(R.id.workoutreps);
		textViewWorkoutSets = (TextView)findViewById(R.id.workoutsets);
		textViewWorkoutDate = (TextView)findViewById(R.id.workoutdate);
		
		//Multiple cards
		cardView2 = new CardView(getApplicationContext());
		cardView2.setLayoutParams(cardView.getLayoutParams());
		relativeLayout2 = new RelativeLayout(getApplicationContext());
		relativeLayout2.setLayoutParams(relativeLayout.getLayoutParams());
		
		textViewData = new TextView[4]; //divide by 4 or increment by 4
		textViewData[0] = new TextView(getApplicationContext()); //name
		textViewData[1] = new TextView(getApplicationContext()); //reps
		textViewData[2] = new TextView(getApplicationContext()); //sets
		textViewData[3] = new TextView(getApplicationContext()); //date
		
		//params
		textViewData[0].setLayoutParams(textViewWorkoutName.getLayoutParams());
		textViewData[1].setLayoutParams(textViewWorkoutReps.getLayoutParams());
		textViewData[2].setLayoutParams(textViewWorkoutSets.getLayoutParams());
		textViewData[3].setLayoutParams(textViewWorkoutDate.getLayoutParams());
		
		relativeLayout2.addView(textViewData[0]);
		relativeLayout2.addView(textViewData[1]);
		relativeLayout2.addView(textViewData[2]);
		relativeLayout2.addView(textViewData[3]);
		
		cardView2.addView(relativeLayout2);
		linearLayout.addView(cardView2);
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
			textViewWorkoutName.setText("Workout: "+statsData.getLiftingDatabase().get(1).getName());
			textViewWorkoutReps.setText("Reps: "+Integer.toString(statsData.getLiftingDatabase().get(1).getReps()));
			textViewWorkoutSets.setText("Sets:" +Integer.toString(statsData.getLiftingDatabase().get(1).getSets()));
			textViewWorkoutDate.setText(statsData.getLiftingDatabase().get(1).getTodaysDate().toString());
			
			textViewData[0].setText("Workout: "+statsData.getLiftingDatabase().get(0).getName());
			textViewData[1].setText("Reps: "+Integer.toString(statsData.getLiftingDatabase().get(0).getReps()));
			textViewData[2].setText("Sets:" +Integer.toString(statsData.getLiftingDatabase().get(0).getSets()));
			textViewData[3].setText(statsData.getLiftingDatabase().get(0).getTodaysDate().toString());
			
			//}
			//f.delete();
			
		}
	}
}
