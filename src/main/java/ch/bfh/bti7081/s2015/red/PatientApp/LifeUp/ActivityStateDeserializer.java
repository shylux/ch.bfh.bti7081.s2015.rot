package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;


import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.*; 

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class ActivityStateDeserializer implements JsonDeserializer<ActivityState> {
	 
 
	public ActivityState deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
 
		ActivityState obj = null;
		JsonObject jobject = (JsonObject) json; 
		try {
			
			String[] count = jobject.get("type").toString().split("\\.");
			String tmp = jobject.get("type").toString().split("\\.")[count.length - 1];			
			tmp = jobject.get("type").toString();

			//Class<?> clazz = Class.forName(jobject.get("type").getClass().toString());
			//Constructor<?> ctor = clazz.getConstructor(jobject.get("type").getClass().toString());
			//obj = (ActivityState) ctor.newInstance(); 
			
			switch (tmp) {
			case "TimeActivityReady": 
				obj = new TimeActivityReady();
			break;
			case "InProgress":  
				obj = new InProgress();
			break;
			case "Failed":
				obj = new Failed();
			break;
			case "FinishedInTime": 
				obj = new FinishedInTime();
			break;
			case "FinishedTooLate": 
				obj = new FinishedTooLate();
			break;
			case "Ready": 
				obj = new Ready();
			break;
			case "Started": 
				obj = new Started();
			break;
			case "Finished": 
				obj = new Finished();
			break;
			case "Closed": 
				obj = new Closed();
			break;
			}
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		// TODO Auto-generated method stub
		return obj;
	}
	
}
