package ca.ezroot.fittracker.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import ca.ezroot.fittracker.R;
import ca.ezroot.fittracker.data.StatsData;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
	private StatsData statsData;
	private Context context;
	
	public RecyclerViewAdapter(Context context, StatsData statsData)
	{
		this.statsData = statsData;
		this.context = context;
	}
	
	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
	{
		View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_stats_item, viewGroup,false);
		ViewHolder viewHolder = new ViewHolder(view);
		return viewHolder;
	}
	
	@Override
	public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
	{
		fillWidgetsWithData(viewHolder, i);
	}
	
	@Override
	public int getItemCount()
	{
		return statsData.getItemCount();
	}
	
	public class ViewHolder extends RecyclerView.ViewHolder
	{
		//init widgets
		TextView[] widgets; //name, reps, sets, date
		RelativeLayout relativeLayout;
		
		public ViewHolder(@NonNull View itemView)
		{
			super(itemView);
			
			//name, reps, sets, date
			widgets = new TextView[4];
			widgets[0] = itemView.findViewById(R.id.workout_name);
			widgets[1] = itemView.findViewById(R.id.workout_rep);
			widgets[2] = itemView.findViewById(R.id.workout_set);
			widgets[3] = itemView.findViewById(R.id.workout_date);
			
			//parent layout
			relativeLayout = itemView.findViewById(R.id.relative_layout);
		}
	}
	
	/*fills with statdata data from constructor*/
	private void fillWidgetsWithData(ViewHolder viewHolder, int i)
	{
		/*if file exists else */
		viewHolder.widgets[0].setText(statsData.getLiftingDatabase().get(i).getName());
		viewHolder.widgets[1].setText(Integer.toString(statsData.getLiftingDatabase().get(i).getReps()));
		viewHolder.widgets[2].setText(Integer.toString(statsData.getLiftingDatabase().get(i).getSets()));
		viewHolder.widgets[3].setText(statsData.getLiftingDatabase().get(i).getTodaysDate());
	}
}
