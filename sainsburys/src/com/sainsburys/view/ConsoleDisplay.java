package com.sainsburys.view;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sainsburys.model.Results;

public class ConsoleDisplay {

	public void displayResultsAsJson(Results results)
	{
		// Use Gson to convert from Java object to JSON format
		Gson gson = new GsonBuilder()
		.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
		.setPrettyPrinting()
		.disableHtmlEscaping()
		.create();
		
		if (results != null)
		{
			
			String json = gson.toJson(results);
			System.out.println(json);
		}
		else
		{
			System.out.println("NULL");
		};
	}
}
