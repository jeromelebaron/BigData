package com.formation.dao.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.formation.dao.AbstractDAO;
import com.formation.dto.CategoryMontant;
import com.formation.entity.Product;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class MongoProductDao extends AbstractDAO implements ProductDao {

	public MongoProductDao() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("test");
		MongoCollection<Document> coll = db.getCollection("products");
		setDbCollection(coll);
	}

	@Override
	public Product create(Product product) {
		// Construction de l'objet
		Document doc = new Document("name", product.getName())
				.append("manufacturer", product.getManufacturer())
				.append("category", product.getCategory())
				.append("price", product.getPrice());
		coll.insertOne(doc);
		return product;
	}

	@Override
	public List<CategoryMontant> getCategoryMontant() {

		List<Document> operations = new ArrayList<Document>();

		final List<CategoryMontant> results = new ArrayList<CategoryMontant>();

		Document groupFields = new Document("_id", "$category");
		groupFields.put("montant", new Document("$sum", "$price"));
		Document group = new Document("$group", groupFields);
		operations.add(group);

		AggregateIterable<Document> iterable = coll.aggregate(operations);
		
		iterable.forEach(new Block<Document>() {
			CategoryMontant cat=null;
		    @Override
		    public void apply(final Document document) {
		    	cat=new CategoryMontant();
				cat.setCategory(document.get("_id").toString());
				cat.setMontant(document.get("montant").toString());
				results.add(cat);
		    }
		});

		return results;
	}
	
	

	@Override
	public Product findById(Long id) {
		// A FAIRE
		return null;
	}

	@Override
	public Product updaProducte(Product product) {
		// A FAIRE
		return null;
	}

	@Override
	public void delete(Product t) {
		// A FAIRE

	}

}

