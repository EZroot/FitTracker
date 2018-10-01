package ca.ezroot.fittracker.statistics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;

import ca.ezroot.fittracker.R;
import ca.ezroot.fittracker.parser.DataHandler;

public class StatsActivity extends AppCompatActivity
{
	TextView text;
	
	public void onInit()
	{
		text = (TextView)findViewById(R.id.textView);
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
