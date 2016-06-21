package com.formation;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;

public class ESTest {

	public static void main(String[] args) {

		// on startup
		Node node = nodeBuilder().node();
		Client client = node.client();
		
		// Partie 1
	
		IndexResponse response = createIndex(client,"twitter" , "tweet" , "1" ,"kimchy" , new Date() , "trying out Elasticsearch");
		
		System.out.println("--------------Insert MetaData----------------");
		System.out.println("_index : "+response.getIndex());
		System.out.println("_type : "+response.getType());
		System.out.println("_id : "+response.getId());
		System.out.println("_version : "+response.getVersion());
		System.out.println("_created : "+response.isCreated());
		System.out.println();
		
		// Partie 2 
		
		GetResponse getResponse = getDocument(client,"twitter", "tweet", "1");

		Map<String, Object> source = getResponse.getSource();

		System.out.println("--------------GET----------------");
		System.out.println("Index: " + getResponse.getIndex());
		System.out.println("Type: " + getResponse.getType());
		System.out.println("Id: " + getResponse.getId());
		System.out.println("Version: " + getResponse.getVersion());
		System.out.println("Document : "+source);
		System.out.println();
		
		// Partie 3 delete
		 
//		DeleteResponse delResponse = deleteDocument(client,"twitter", "tweet", "1");
//		
//		System.out.println("------------DELETE------------------");
//		System.out.println("Index: " + delResponse.getIndex());
//		System.out.println("Type: " + delResponse.getType());
//		System.out.println("Id: " + delResponse.getId());
//		System.out.println("Version: " + delResponse.getVersion());
//		System.out.println("------------------------------");

		
		// on shutdown
		node.close();
	}
	
	//prepareIndex
	public static IndexResponse createIndex(Client client, String index,
			String type, String id,String user, Date postDate, String message) {
		
		IndexResponse response = null;
		
		try {
			response = client.prepareIndex(index,type , id )
			        .setSource(jsonBuilder()
			                    .startObject()
			                        .field("user", user )
			                        .field("postDate", postDate)
			                        .field("message", message )
			                    .endObject()
			                  )
			        .execute()
			        .actionGet();
		} catch (ElasticsearchException | IOException e) {
			System.out.println("Pb creation d'index "+e.getMessage());
		}
		
		return response;
	}
	
	//Get Document
	public static GetResponse  getDocument(Client client, String index,
			String type, String id) {
		
		GetResponse  response = null;
		
		try {
			response = client.prepareGet(index, type, id)
			        .execute()
			        .actionGet();
		} catch (ElasticsearchException e) {
			//System.out.println("Pb d'obtention de document "+e.getMessage());
			e.printStackTrace();
		}
		
		return response;
	}
	
	//delete Document
	public static DeleteResponse   deleteDocument(Client client, String index,
			String type, String id) {
		
		DeleteResponse   response = null;
		
		try {
			response = client.prepareDelete(index, type, id)
			        .execute()
			        .actionGet();
		} catch (ElasticsearchException e) {
			//System.out.println("Pb d'obtention de document "+e.getMessage());
			e.printStackTrace();
		}
		
		return response;
	}
}

