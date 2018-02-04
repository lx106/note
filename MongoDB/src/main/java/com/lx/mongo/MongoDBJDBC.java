package com.lx.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MongoDBJDBC {
    public static void main(String args[]) {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            // 连接到数据库
            //MongoDatabase mongoDatabase = mongoClient.getDatabase("monitor");
            MongoDatabase mongoDatabase = getDateBase("admin");
            System.out.println(mongoDatabase);
            System.out.println("Connect to database successfully");

//            mongoDatabase.createCollection("test");
//            System.out.println("集合创建成功");
            MongoCollection<Document> collection = mongoDatabase.getCollection("monitor");
            System.out.println("集合 test 选择成功");

            Document document = new Document("monitor", "MongoDB").
                                                                append("description", "database").
                                                                append("likes", 100).
                                                                append("by", "Fly");
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            collection.insertMany(documents);
            System.out.println("文档插入成功");

            collection.updateMany(Filters.eq("likes", 100), new Document("$set",new Document("likes",200)));

            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }



        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static MongoDatabase getDateBase(String db){
        MongoDatabase database = null;
        try {
            //连接数据库 start
            MongoCredential credential = MongoCredential.createCredential("zhongzhu", db, "111111".toCharArray());
//          MongoCredential credential = MongoCredential.createMongoCRCredential("yutao", db, "yutao".toCharArray());
            ServerAddress serverAddress;
            serverAddress = new ServerAddress("10.136.15.102", 27017);
            List<ServerAddress> seeds = new ArrayList<ServerAddress>();
            seeds.add(serverAddress);
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            credentials.add(credential);
//          @SuppressWarnings("resource")
            MongoClient mongoClient = new MongoClient(seeds, credentials);
            database = mongoClient.getDatabase(db);
            System.out.println("Connect to database successfully");
            //连接数据库 end
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return database;
    }
}