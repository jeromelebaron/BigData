/*
 * Créé le 15 juin 2016 par Jérome LE BARON
 */
package fr.afcepf.atod26.bigdata;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 * Description de la classe
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class ConnexionTest {

    private final static String HOST = "localhost";
    private final static int PORT = 27017;

    public static void main(String[] args) {
        try {
            MongoClient client = new MongoClient(HOST, PORT);
            MongoDatabase dataBase = client.getDatabase("test");
            System.out.println("connexion réussie");
            MongoCollection<Document> collection = dataBase.getCollection("countries");
            System.out.println(collection.count());
            MongoCursor<Document> cursor = collection.find().iterator();
            Document match = Document.parse("{$match:{'continent.name':{$in:['Africa', 'Europe', 'Asia']}}}");
            Document project = Document.parse("{$project:{'continent.name':1, 'area':1, '_id':0}}");
            Document group = Document.parse("{$group:{'_id':'$continent.name', 'average':{'$avg':'$area'}}}");
            List<Document> operation = new ArrayList<>();
            operation.add(match);
            operation.add(project);
            operation.add(group);
            AggregateIterable<Document> iterable = collection.aggregate(operation);
            iterable.forEach(new Block<Document>() {

                @Override
                public void apply(Document document) {
                    System.out.println(document.toJson());
                }
            });
            client.close();
        } catch (Exception e) {
            System.out.println("Erreur de connexion");
            e.printStackTrace();
        }
    }
}
