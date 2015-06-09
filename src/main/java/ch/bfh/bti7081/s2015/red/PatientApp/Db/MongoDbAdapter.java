package ch.bfh.bti7081.s2015.red.PatientApp.Db;


import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.ActivityState;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.ActivityStateDeserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.*;
import com.mongodb.util.JSON;

import org.bson.types.ObjectId;
import org.reflections.Reflections;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.ArrayList;
import java.util.Set;


/**
 * An adapter for the document base database mongoDb
 * 
 * @author James Mayr
 *
 */
public class MongoDbAdapter {
	private MongoClient mongoDbClient;
	private DB db;
	private DBCollection collection;
	
	public MongoDbAdapter()
	{
		InputStream input = null;
		java.util.Properties prop = new java.util.Properties();
		try {
			input = new FileInputStream("db.properties");
			
			prop.load(input);
		
			/*MongoCredential credential = MongoCredential.createCredential(prop.getProperty("user"),
					prop.getProperty("db"), prop.getProperty("pass").toCharArray());*/

			mongoDbClient = new MongoClient(new ServerAddress(prop.getProperty("server")));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		db = mongoDbClient.getDB("patientapp");
		collection = db.getCollection("patient-data");
	}
	
	/**
	 * update  a given collection and stores the updates in the database 
	 */
	public void updateCollection(ArrayList<Persistable> entries)
	{
		/*
		 * update all Persistable objects
		 */
		for(Persistable entry : entries)
		{
			updateEntry(entry);
		}
	}
	
	/**
	 * update  a given entry and stores the update into database 
	 */
	public void updateEntry(Persistable entry)
	{
		/*
		 * convert from json string to a mongo db specific format 
		 */
		String json = entry.serialize();
		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.append("_id", new ObjectId(entry.getId()));
		
		Object object = JSON.parse(json);
		BasicDBObject document = (BasicDBObject) object;
		
		collection.update(updateQuery, document);
	}
	
	/**
	 * get the actual Data from an entry from the database
	 */
	public Persistable getEntryFromDatabase(Persistable persistable)
	{
		BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(persistable.getId()));
	    DBObject dbObj = collection.findOne(query);
	    
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

		Persistable createdClass  =  generateClassFromDbObject(dbObj,persistable.getClass());
		createdClass.setId(dbObj.get("_id").toString());

		return createdClass;

	}
	/**
	 * get a collection of the given datatype
	 * inclusive it's subtypes
	 */
	public <T>ArrayList<T> getSpecificCollection(Class<? extends Persistable> persistableClass,boolean withSubclasses)
	{
		
		if(withSubclasses)
		{	
			Reflections reflections = new Reflections("ch.bfh.bti7081.s2015.red.PatientApp.Model");
			ArrayList<T> entries = new ArrayList<T>();
			/*
			 * get all subtypes with reflection
			 */
			Set<?> subTypes = reflections.getSubTypesOf(persistableClass);
			for(Object subtype : subTypes )
			{
				BasicDBObject query =new BasicDBObject("type",subtype.toString());
				ArrayList<T> tmpList = (ArrayList<T>) getQueryResult(query,(Class<? extends Persistable>) subtype);
				entries.addAll(tmpList);
			}
			
			entries.addAll(((ArrayList<T>) getSpecificCollection(persistableClass)));
			return entries;
		}
		else
		{
			return getSpecificCollection(persistableClass);
		}
	}
	/**
	 * get a collection of the given datatype
	 */
	public <T>ArrayList<T> getSpecificCollection(Class<? extends Persistable> persistableClass)
	{
		BasicDBObject query = new BasicDBObject();
		query.put("type", persistableClass.toString());
		return (ArrayList<T>) getQueryResult(query,persistableClass);

	}
	/**
	 * erase Collection
	 */
	public void erase()
	{
		collection.drop();
		collection = db.getCollection("patient-data");
	}
	
	/**
	 * insert a new collection into database
	 */
	public void insertIntoDatabase(ArrayList<? extends Persistable> entries)
	{
		for(Persistable entry: entries)
		{
			insertIntoDatabase(entry);
		}
	}
	/**
	 * insert a single persistable entry into database
	 */
	public void insertIntoDatabase(Persistable entry)
	{
		/*
		 * convert from json string to a mongo db specific format 
		 */
		String json = entry.serialize();
		
		Object object = JSON.parse(json);
		BasicDBObject document = (BasicDBObject) object;
		
		collection.insert(document);
		ObjectId id = (ObjectId)document.get( "_id" );
		entry.setId(id.toString());
	}
	/**
	 * generate a object from a json string
	 */
	private Persistable generateClassFromDbObject(DBObject record,Class<? extends Persistable> persistableClass)
	{
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().registerTypeAdapter(ActivityState.class, new ActivityStateDeserializer()).
registerTypeAdapter(Date.class, new DateDeserializer()).create();
		Persistable createdClass  =  gson.fromJson(record.toString(),persistableClass);
 
		return createdClass;
	}
	/**
	 * just converts a queryResult in a ArrayList of Persistables
	 */
	private ArrayList<Persistable> getQueryResult(BasicDBObject query,Class<? extends Persistable> persistableClass)
	{
		DBCursor cursor = collection.find(query);
	    
	    ArrayList<Persistable> persistables = new ArrayList<Persistable>();
		
	    try 
	    {
	    	   while(cursor.hasNext()) 
	    	   {
	    		   DBObject record = cursor.next();
	    		   Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	    		   
	    		   Persistable createdClass  =  generateClassFromDbObject(record,persistableClass);
	    		   createdClass.setId(record.get("_id").toString());
	    		   persistables.add(createdClass);
	    	   }
	    } 
	    finally 
	    {
	    	   cursor.close();
	    	   return persistables;
	    }
	}
}