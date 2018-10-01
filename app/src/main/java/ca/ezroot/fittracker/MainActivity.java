package ca.ezroot.fittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ca.ezroot.fittracker.statistics.StatsActivity;

public class MainActivity extends AppCompatActivity
{
	Button logExercise;
	Button stats;
	
	/*Button setup*/
	public void onInit()
	{
		logExercise = (Button)findViewById(R.id.logExercistButton);
		stats = (Button)findViewById(R.id.statsButton);
	}
	
	/*Button triggers*/
	public void onListen()
	{
		logExercise.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				Intent intent = new Intent(getApplicationContext(), LogExerciseActivity.class);
				startActivity(intent);
			}
		});
		
		stats.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				Intent intent = new Intent(getApplicationContext(), StatsActivity.class);
				startActivity(intent);
			}
		});
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		onInit();
		onListen();
	}
}
