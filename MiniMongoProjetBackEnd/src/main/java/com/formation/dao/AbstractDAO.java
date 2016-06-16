package com.formation.dao;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;


public  class AbstractDAO {
    
	protected MongoCollection<Document> coll;
    
    public AbstractDAO() {
    }

    protected void setDbCollection(MongoCollection<Document> coll) {
        this.coll = coll;
    }
    public  MongoCursor<Document> getAll(){
    	MongoCursor<Document> find = coll.find().iterator();
        return find;
    }
    public void insert(Document dbObject){
    	coll.insertOne(dbObject);
    }
    public void remove(Document dbObject){
    	coll.deleteOne(dbObject);
    }
    public void update(Document old,Document dbObject){
    	coll.updateOne(old, dbObject);
    }
    public Document getByID(int id){
    	Document returnObject=null;
    	Document query=new Document();
        query.put("id", new Integer(id));
        returnObject = coll.find(query).first();
        
        return returnObject;
    }
}

