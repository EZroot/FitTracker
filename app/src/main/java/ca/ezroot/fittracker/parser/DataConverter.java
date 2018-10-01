package ca.ezroot.fittracker.parser;

import android.arch.lifecycle.Lifecycle;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

import ca.ezroot.fittracker.data.LiftData;

public class DataConverter
{
	public static String convertToJsonString(LiftData data)
	{
		String result = "";
		try
		{
			//Lifedata to Json
			JSONObject dataObj = new JSONObject();
			dataObj.put("name", data.getName());
			dataObj.put("reps", data.getReps());
			dataObj.put("sets",data.getSets());
			//Json to string
			result = dataObj.toString();
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public static LiftData convertFromJsonString(String data)
	{
		Gson gson = new Gson();
		
		LiftData result = new LiftData();
		result = gson.fromJson(data, LiftData.class);
		return result;
	}
	
	public static String convertToJsonStringDatabase(Vector<LiftData> database)
	{
		JSONArray dataArray = new JSONArray();
		String result = "";
		
		for(int i = 0; i < database.size(); i++)
		{
			try
			{
				//Lifedata to Json
				JSONObject dataObj = new JSONObject();
				dataObj.put("name", database.get(i).getName());
				dataObj.put("reps", database.get(i).getReps());
				dataObj.put("sets", database.get(i).getSets());
				//add to array
				dataArray.put(dataObj);
			} catch (JSONException e)
			{
				e.printStackTrace();
			}
		}
		
		result = dataArray.toString();
		return result;
	}
	
	public static Vector<LiftData> convertFromJsonStringDatabase(String database)
	{
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonArray jsonArray = parser.parse(database).getAsJsonArray();
		
		Vector<LiftData> result = new Vector<>();
		
		for(JsonElement el : jsonArray)
		{
			JsonObject obj = el.getAsJsonObject();
			
			LiftData tmp = new LiftData();
			tmp.logAll(obj.get("name").getAsString(),obj.get("reps").getAsInt(), obj.get("sets").getAsInt());
			
			result.add(tmp);
		}
		return result;
	}
}
