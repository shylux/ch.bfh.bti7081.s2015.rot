package ch.bfh.bti7081.s2015.red.PatientApp.Db;


import java.net.UnknownHostException;
import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class MongoDbAdapter {
	private MongoClient mongoDbClient;
	private DB db;
	private DBCollection collection;
	
	public MongoDbAdapter()
	{
		try {
			mongoDbClient = new MongoClient("192.168.193.135");
		} 
		catch (UnknownHostException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db = mongoDbClient.getDB("patientapp");
		collection = db.getCollection("patient-data");
	}
	
	/**
	 * update  a given collection and stores the updates in the database 
	 * @param entries
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
	 * @param entry
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
	 * @param persistable
	 * @return
	 */
	public Persistable getEntryFromDatabase(Persistable persistable)
	{
	
		BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(persistable.getId()));
	    DBObject dbObj = collection.findOne(query);
	    
		Gson gson = new Gson();
		Persistable createdClass  =  generateClassFromDbObject(dbObj,persistable);
		createdClass.setId(dbObj.get("_id").toString());
		
		return (Persistable)createdClass;
	}
	/**
	 * get a collection of the given datatypes
	 * @param persistable
	 */
	public ArrayList<Persistable> getSpecificCollection(Persistable persistable)
	{
		BasicDBObject query = new BasicDBObject();
	    query.put("type", persistable.getClass().toString());
	    DBCursor cursor = collection.find(query);
	    
	    ArrayList<Persistable> persistables = new ArrayList<Persistable>();
		
	    try 
	    {
	    	   while(cursor.hasNext()) 
	    	   {
	    		   DBObject record = cursor.next();
	    		   Gson gson = new Gson();
	    		   Persistable createdClass  =  generateClassFromDbObject(record,persistable);
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
	
	/**
	 * insert a new collection into database
	 * @param entries
	 */
	public void insertIntoDatabase(ArrayList<Persistable>entries)
	{
		for(Persistable entry: entries)
		{
			insertIntoDatabase(entry);
		}
	}
	/**
	 * insert a single persistable entry into database
	 * @param entry
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
	}
	private Persistable generateClassFromDbObject(DBObject record,Persistable persistable)
	{
		Gson gson = new Gson();
		Persistable createdClass  =  gson.fromJson(record.toString(),persistable.getClass());
		return createdClass;
	}
}
