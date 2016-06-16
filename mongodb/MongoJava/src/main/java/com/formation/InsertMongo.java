package com.formation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class InsertMongo {
	private final static String HOST = "localhost";
	private final static int PORT = 27017;

	public static void main(String args[]) {
		try {
			MongoClient mongoClient = new MongoClient(HOST, PORT);
			// Now connect to the test database
			MongoDatabase db = mongoClient.getDatabase("test");
			System.out.println("Connect to database successfully ");

			// Document doc = new Document("name", "john").append("age",
			// 25).append("phone", "321-654-987");
			// coll.insertOne(doc);

			// Document doc = new Document("name", "louis").
			// append("age", 29).
			// append("info",new Document("email", "louis@mail.com")
			// .append("phone", "876-134-667"));
			// coll.insertOne(doc);

			// MongoCollection<Document> coll = db.getCollection("users");
			// List<Document> documents = new ArrayList<Document>();
			// for (int i = 0; i < 10; i++) {
			// documents.add(new Document("key", UUID.randomUUID().toString()));
			// }
			// coll.insertMany(documents);

			MongoCollection<Document> coll = db.getCollection("users");
			MongoCursor<Document> cursor = coll.find().iterator();
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
