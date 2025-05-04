package com.ocean.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtility {
	public String getDataFromJSONFile(String key) throws FileNotFoundException, IOException, ParseException  {
		FileReader file=new FileReader("./configAppData/Appcommondata.json");
		
		JSONParser jp=new JSONParser();
		Object obj = jp.parse(file);
		
		JSONObject map=(JSONObject)obj;
		String data=(String)map.get(key);
		return data;
	
		
	}

}
