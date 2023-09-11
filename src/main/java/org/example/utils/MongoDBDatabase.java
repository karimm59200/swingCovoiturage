package org.example.utils;

import com.mongodb.DBCursor;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBDatabase {

    private static String uri= "mongodb://localhost:27017/covoiturageMongo";

    private static String dbName="covoiturageMongo";


    static MongoClient mongoClient = null;
    DBCursor cursor = null;

    public static MongoDatabase getMongoConnection() {
        mongoClient = MongoClients.create(uri);
        return mongoClient.getDatabase(dbName);
    }


}
