package ca.ezroot.fittracker.statistics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;

import ca.ezroot.fittracker.R;
import ca.ezroot.fittracker.adapter.RecyclerViewAdapter;
import ca.ezroot.fittracker.data.StatsData;
import ca.ezroot.fittracker.parser.DataHandler;

public class StatsActivity extends AppCompatActivity
{
	//Data
	StatsData statsData;
	RecyclerView recyclerView;
	RecyclerViewAdapter recyclerViewAdapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stats);
		
		//get database from hardcoded file
		statsData = new StatsData(getApplicationContext());
		
		//get recycler view
		 recyclerView = findViewById(R.id.recyclerView);
		 
		 //set recycler view
		 recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), statsData);
		 recyclerView.setAdapter(recyclerViewAdapter);
		 recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
	}
}
