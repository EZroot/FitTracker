package ca.ezroot.fittracker.workout;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Vector;

import ca.ezroot.fittracker.LogExerciseActivity;
import ca.ezroot.fittracker.R;
import ca.ezroot.fittracker.data.LiftData;
import ca.ezroot.fittracker.parser.DataConverter;
import ca.ezroot.fittracker.parser.DataHandler;

public class LiftingActivity extends Activity
{
	//Database
	Vector<LiftData> database;
	
	//Form data
	Button logBtn;
	
	EditText nameText;
	EditText repText;
	EditText setText;
	
	public void onInit()
	{
		//Read database from file if it exists
		//database = getDatabaseFromFile();
		File f = new File(getApplicationContext().getFilesDir().getPath(), "data.txt");
		if(f.exists())
		{
			database = DataConverter.convertFromJsonStringDatabase(DataHandler.read(getApplicationContext()));
		}
		else
		{
			database = new Vector<>();
		}
		
		//Assign form data
		logBtn = (Button)findViewById(R.id.logLiftButton);
		
		nameText = (EditText)findViewById(R.id.nameEditText);
		repText = (EditText)findViewById(R.id.repsEditText);
		setText = (EditText)findViewById(R.id.setsEditText);
	}
	
	public void onListen()
	{
		logBtn.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				logData();
			}
		});
		
		//saves database after DONE is clicked on SOFTKEYBOARD
		/*repText.setOnEditorActionListener(new TextView.OnEditorActionListener()
		{
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
			{
				if(actionId== EditorInfo.IME_ACTION_DONE){
					logData();
				}
				return false;
			}
		});*/
	}
	
	/* records the form data, processes it, and saves it to text file in json format */
	/* records name, reps, set = 1 */
	/* records todays date */
	/* in statsActivity, when read file, compare all dates and sort accordingly. */
	private void logData()
	{
		//Reset and read database
		File f = new File(getApplicationContext().getFilesDir().getPath(), "data.txt");
		if(f.exists())
		{
			database = DataConverter.convertFromJsonStringDatabase(DataHandler.read(getApplicationContext()));
			Toast.makeText(getApplicationContext(),"Database read successfully!", Toast.LENGTH_SHORT).show();
		}
		
		//Parse data
		LiftData data = new LiftData();
		try
		{
			if(nameText.getText().toString().trim().length()>0)
			{
				if (setText.getText().toString().trim().length() > 0)
				{
					//with sets
					data.logAll(nameText.getText().toString().trim(), Integer.parseInt(repText.getText().toString()), Integer.parseInt(setText.getText().toString()));
				} else
				{
					//default set = 1
					data.log(nameText.getText().toString().trim(), Integer.parseInt(repText.getText().toString()));
				}
				
				//Add to database
				database.add(data);
				
				
				//Write database file if its not empty
				if(database.size() > 0)
				{
					//Write database
					DataHandler.write(getApplicationContext(), DataConverter.convertToJsonStringDatabase(database));
					Toast.makeText(getApplicationContext(),"Database saved!", Toast.LENGTH_SHORT).show();
				}
				else
				{
					Toast.makeText(getApplicationContext(),"Failed to write. No data!", Toast.LENGTH_SHORT).show();
				}
			}
			else
			{
				Toast.makeText(getApplicationContext(),"Error: name doesn't exist", Toast.LENGTH_LONG).show();
			}
		}
		catch(IllegalArgumentException e)
		{
			Toast.makeText(getApplicationContext(),"Error: "+e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lifting);
		
		onInit();
		onListen();
	}
	
}
