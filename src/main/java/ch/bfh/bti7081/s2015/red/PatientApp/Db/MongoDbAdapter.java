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
	
	public MongoDbAdapter() throws UnknownHostException
	{
		mongoDbClient = new MongoClient("192.168.193.135");
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
			
			/*
			 * convert from json string to a mongo db specific format 
			 */
			String json = entry.serialize();
			BasicDBObject updateQuery = new BasicDBObject();
			updateQuery.append("_id", entry.getId());
			
			Object object = JSON.parse(json);
			BasicDBObject document = (BasicDBObject) object;
			
			collection.update(updateQuery, document);
		}
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
		Object createdClass  =  generateClassFromDbObject(dbObj,persistable);
		
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
	    		   Object createdClass  =  generateClassFromDbObject(record,persistable);
	    		   persistables.add((Persistable) createdClass);
	    	   }
	    } 
	    finally 
	    {
	    	   cursor.close();
	    	   return persistables;
	    }
	}
	private Persistable generateClassFromDbObject(DBObject record,Persistable persistable)
	{
		Gson gson = new Gson();
		Object createdClass  =  gson.fromJson(record.toString(),persistable.getClass());
		return (Persistable)createdClass;
	}
	
	
	
	
}
