package ca.ezroot.fittracker.workout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ca.ezroot.fittracker.R;
import ca.ezroot.fittracker.workout.LiftingActivity;

public class LogExerciseActivity extends AppCompatActivity
{
	Button liftingBtn;
	Button cardioBtn;
	
	public void onInit()
	{
		liftingBtn = (Button)findViewById(R.id.liftingButton);
		cardioBtn = (Button)findViewById(R.id.cardioButton);
		
	}
	
	public void onListen()
	{
		liftingBtn.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				Intent intent = new Intent(getApplicationContext(), LiftingActivity.class);
				startActivity(intent);
			}
		});
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_exercise);
		
		onInit();
		onListen();
	}
}
