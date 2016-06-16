package com.formation;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;

public class MongoFilter {

	private final static String HOST = "localhost";
	private final static int PORT = 27017;

	public static void main(String args[]) {
		try {
			MongoClient mongoClient = new MongoClient(HOST, PORT);
			MongoDatabase db = mongoClient.getDatabase("sampledb");
			 MongoCollection<Document> coll = db.getCollection("users");
//			 Document newDoc = new Document("name", "john").append("age",
//			 25).append("phone", "321-654-987");
//			 coll.insertOne(newDoc);
//			 MongoCursor<Document> cursor = coll.find(Filters.eq("name", "john")).iterator();
////			 MongoCursor<Document> cursor = coll.find(Filters.and(Filters.gt("age", 20),Filters.lte("age",  40))).iterator();

//			MongoCollection<Document> coll = db.getCollection("users");
//			Document newDoc = new Document("name", "john").append("age", 25).append("phone", "321-654-987");
//			coll.insertOne(newDoc);
//			coll.updateOne(Filters.eq("name", "john"), new Document("$set", new Document("age", 50)));
			
//			MongoCollection<Document> coll = db.getCollection("users");
//			UpdateResult updateResult = coll.updateMany(Filters.eq("name", "john"), new Document("$set", new Document("age", 50)));
//			System.out.println(updateResult.getModifiedCount());
//			
//			MongoCursor<Document> cursor = coll.find().iterator();
			 
			 MongoCursor<Document> cursor = coll.find(Document.parse("{name:'john',age:25}")).iterator();

			try {
				while (cursor.hasNext()) {
					Document doc = cursor.next();
					System.out.println(doc.toJson());
				}
			} finally {
				cursor.close();
			}
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

}
