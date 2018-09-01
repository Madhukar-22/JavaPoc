package com.mongodb.basics;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MongoTest {

    private final static Logger logger = LoggerFactory.getLogger(MongoTest.class);

    public static void main(String[] args) {

        try {

            MongoClientURI uri = new MongoClientURI("mongodb+srv://mady:mady@mady-cluster-ynycv.mongodb.net/test?retryWrites=true");

            /** Get database
             If database doesn't exists, Mongo DB will create it for you */
            MongoClient mongo = new MongoClient(uri);

            /** To connect to a replica set
             * A replica set in MongoDB is a group of mongod processes that maintain the same data set.
             * */
            /*MongoClient mongoClient = new MongoClient(
                    Arrays.asList(new ServerAddress("host1", 27017),
                                  new ServerAddress("host2", 27017),
                                  new ServerAddress("host3", 27017)));*/

            /** Using MongoClientOptions to connect to a sharded cluster
             * Sharding is a method for distributing data across multiple machines.
             * MongoDB uses sharding to support deployments with very large data sets and
             * high throughput operations.
             *
             * MongoDB supports horizontal scaling through sharding.*/
            /*String user; // the user name
            String database; // the name of the database in which the user is defined
            char[] password; // the password as a character array
            // ...

            MongoCredential credential = MongoCredential.createCredential(user, database, password);

            MongoClientOptions options = MongoClientOptions.builder().sslEnabled(true).build();

            MongoClient mongoClient = new MongoClient(new ServerAddress("host1", 27017),
                    Arrays.asList(credential),
                    options);*/

             /**To enable TLS/SSl settings  */
            /*To specify TLS/SSL with with MongoClientOptions, set the sslEnabled property to true, as in:

            MongoClientOptions options = MongoClientOptions.builder().sslEnabled(true).build();
            MongoClient client = new MongoClient("localhost", options);*/

            MongoDatabase database = mongo.getDatabase("video");

            for (String name : database.listCollectionNames()) {
                logger.info("Existing collections : " + name);
            }

             /** For explicitly creating a collection and to drop a collection*/
            /*database.createCollection("cappedCollection",
                    new CreateCollectionOptions().capped(true).sizeInBytes(0x100000));
            MongoCollection<Document> collection = database.getCollection("contacts");
            collection.drop();*/

            /**Inserting a single document*/

            /*MongoCollection<Document> table = database.getCollection("testMovie");

            Document document = new Document();
            document.put("title", "Turtles");
            document.put("year", 2019);
            document.put("imdb", 5.2);
            document.put("genre", "Thriller");
            table.insertOne(document);

            logger.info("Insert Done ");
            */

            MongoCollection<Document> collection = database.getCollection("testMovie");
            logger.info("Count : "+collection.countDocuments());

            /**Inserting multiple documents ***********************************/

            /*List<Document> documents = new ArrayList<Document>();
            Document doc1 = new Document("name", "Eclipse")
                    .append("type", "IDE")
                    .append("count", 1)
                    .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                    .append("info", new Document("x", 203).append("y", 102));

            Document doc2 = new Document("name", "MongoDb")
                    .append("type", "Database")
                    .append("count", 1)
                    .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                    .append("info", new Document("x", 203).append("y", 102));

            documents.add(doc1);
            documents.add(doc2);

            collection.insertMany(documents);
            logger.info("Multiple Insert Done ");
            */

            /**Searching a single document ********************************** */

            /*Document myDoc = collection.find().first();
            logger.info("Resultset : "+myDoc.toJson()+"\n");*/



            /**Searching multiple documents  ***********************************/

            /*MongoCursor<Document> cursor = collection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    logger.info("Resultset : "+cursor.next().toJson());
                }
            } finally {
                cursor.close();
            }*/


            /**Filtering multiple documents ***********************************/

            /*Block<Document> printBlock = new Block<Document>() {
                @Override
                public void apply(final Document document) {
                    logger.info("Resultset : "+document.toJson());
                }
            };

            collection.find(eq("type", "IDE")).forEach(printBlock);*/

            /**Updating single document ***********************************/
            /*collection.updateOne(eq("name", "MongoDb"), new Document("$set", new Document("type", "No SQL Databse")));*/

            /**Updating multiple documents ***********************************/
            /*UpdateResult updateResult = collection.updateMany(eq("count", 1), inc("count", 9));
            logger.info("Resultset : "+updateResult.getModifiedCount());*/

            /**Deleting single document ***********************************/
            /*collection.deleteOne(eq("title", "Hichki"));*/

            /**Deleting multiple documents ***********************************/
            /*DeleteResult deleteResult = collection.deleteMany(lte("imdb", 6.0));
            logger.info("Resultset : "+deleteResult.getDeletedCount());*/

            mongo.close();
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}