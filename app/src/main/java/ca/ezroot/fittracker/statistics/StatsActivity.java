package ca.ezroot.fittracker.statistics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;

import ca.ezroot.fittracker.R;
import ca.ezroot.fittracker.data.StatsData;
import ca.ezroot.fittracker.parser.DataHandler;

public class StatsActivity extends AppCompatActivity
{
	//Data
	StatsData statsData;
	
	//Form data
	TextView text;
	
	public void onInit()
	{
		//data
		statsData = new StatsData();
		
		//forms
		text = (TextView)findViewById(R.id.textView);
	}
	
	public void displayData()
	{
		//statsData.displayData();
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
			text.setText(DataHandler.read(getApplicationContext()));
			f.delete();
		}
	}
}
