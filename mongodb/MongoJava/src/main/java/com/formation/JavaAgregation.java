package com.formation;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class JavaAgregation {

	private final static String HOST = "localhost";
	private final static int PORT = 27017;

	public static void main(String args[]) {
		try {
			MongoClient mongoClient = new MongoClient(HOST, PORT);
			MongoDatabase db = mongoClient.getDatabase("test");
			MongoCollection<Document> coll = db.getCollection("countries");

			Document match = Document.parse("{$match: {'continent.name':{ $in:['Africa','Europe','Asia'] }}}");

			Document project = Document.parse("{$project:{'continent.name':1,'area':1,'_id':0}}");

			Document group = Document.parse("{$group:{'_id':'$continent.name','average':{'$avg':'$area'}}}");

			List<Document> operations = new ArrayList<Document>();
			operations.add(match);
			operations.add(project);
			operations.add(group);
			
			AggregateIterable<Document> iterable = coll.aggregate(operations);

			iterable.forEach(new Block<Document>() {
			    @Override
			    public void apply(final Document document) {
			        System.out.println(document.toJson());
			    }
			});

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}
