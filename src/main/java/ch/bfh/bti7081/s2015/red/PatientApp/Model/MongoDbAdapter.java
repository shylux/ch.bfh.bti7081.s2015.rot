package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoDbAdapter {
	private MongoClient mongoDbClient;
	private DB db;
	private DBCollection collection;
	
	public MongoDbAdapter() throws UnknownHostException
	{
		mongoDbClient = new MongoClient("localhost");
		db = mongoDbClient.getDB("patientapp");
		BasicDBObject basic = new BasicDBObject();
		//TODO: Parse Json to DBObj 	
		//Object o = com.mongodb.util.JSON.parse("Your JSON structure or JSONObj.toString()");
		//DBObject dbObj = (DBObject) o;
		//
		
	}
}
