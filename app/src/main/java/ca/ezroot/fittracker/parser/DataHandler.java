package ca.ezroot.fittracker.parser;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DataHandler
{
	public static void write(Context context, String data)
	{
		try
		{
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("data.txt", Context.MODE_PRIVATE));
			outputStreamWriter.write(data);
			outputStreamWriter.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static String read(Context context)
	{
		String result = "";
		
		try
		{
			InputStream inputStream = context.openFileInput("data.txt");
			
			if ( inputStream != null )
			{
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String receiveString = "";
				StringBuilder stringBuilder = new StringBuilder();
				
				while ( (receiveString = bufferedReader.readLine()) != null )
				{
					stringBuilder.append(receiveString);
				}
				
				inputStream.close();
				result = stringBuilder.toString();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
}
