package com.formation;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.elasticsearch.script.ScriptService.ScriptType;
import org.elasticsearch.search.SearchHit;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import org.elasticsearch.index.query.QueryBuilders;

public class CopyOfESTest {

	public static void main(String[] args) {

		// node based client
		Node node = nodeBuilder().node();
		Client client = node.client();

		// créaion et indexation de document
		client.prepareIndex("my-index", "article", "1")
				.setSource(
						putJsonDocument(
								"ElasticSearch: Java",
								"ElasticSeach provides Java API, thus it executes all operations "
										+ "asynchronously by using client object..",
								new Date(), new String[] { "elasticsearch" },
								"Jean Henry")).execute().actionGet();

		// récupération de document
		GetResponse getResponse = client.prepareGet("my-index", "article", "1")
				.execute().actionGet();

		Map<String, Object> source = getResponse.getSource();

		System.out.println("------------------------------");
		System.out.println("Index: " + getResponse.getIndex());
		System.out.println("Type: " + getResponse.getType());
		System.out.println("Id: " + getResponse.getId());
		System.out.println("Version: " + getResponse.getVersion());
		System.out.println(source);
		System.out.println("------------------------------");
		
		 updateDocument(client, "my-index", "article", "1", "title", "ElasticSearch: Java API");
	       // updateDocument(client, "kodcucom", "article", "1", "tags", new String[]{"bigdata"});

	        getDocument(client, "my-index", "article", "1");

	}

	// insertion de document
	public static Map<String, Object> putJsonDocument(String title,
			String content, Date postDate, String[] tags, String author) {

		Map<String, Object> jsonDocument = new HashMap<String, Object>();

		jsonDocument.put("title", title);
		jsonDocument.put("content", content);
		jsonDocument.put("postDate", postDate);
		jsonDocument.put("tags", tags);
		jsonDocument.put("author", author);

		return jsonDocument;
	}

	// update de document
	public static void updateDocument(Client client, String index, String type,
			String id, String field, String newValue) {

		Map<String, Object> updateObject = new HashMap<String, Object>();
		updateObject.put(field, newValue);

		client.prepareUpdate(index, type, id).setScript("ctx._source." + field + "=" + field,ScriptType.INLINE)
				.setScriptParams(updateObject).execute().actionGet();
	}
	
	//get document
	
    public static void getDocument(Client client, String index, String type, String id){
        
        GetResponse getResponse = client.prepareGet(index, type, id)
                                        .execute()
                                        .actionGet();
        Map<String, Object> source = getResponse.getSource();
        
        System.out.println("------------------------------");
        System.out.println("Index: " + getResponse.getIndex());
        System.out.println("Type: " + getResponse.getType());
        System.out.println("Id: " + getResponse.getId());
        System.out.println("Version: " + getResponse.getVersion());
        System.out.println(source);
        System.out.println("------------------------------");   
    }
    
	// recherche
	public static void searchDocument(Client client, String index, String type,
			String field, String value) {

		SearchResponse response = client.prepareSearch(index).setTypes(type)
				.setSearchType(SearchType.QUERY_AND_FETCH)
				.setQuery(QueryBuilders.termQuery(field, value)).setFrom(0)
				.setSize(60).setExplain(true).execute().actionGet();

		SearchHit[] results = response.getHits().getHits();

		System.out.println("Current results: " + results.length);
		for (SearchHit hit : results) {
			System.out.println("------------------------------");
			Map<String, Object> result = hit.getSource();
			System.out.println(result);
		}
	}
}
