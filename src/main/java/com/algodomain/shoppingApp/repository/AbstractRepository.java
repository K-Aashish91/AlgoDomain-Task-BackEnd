package com.algodomain.shoppingApp.repository;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class AbstractRepository {

  @Autowired
  MongoTemplate mongoTemplate;

  protected MongoCollection<Document> getCollection(String collection) {
    MongoDatabase database = mongoTemplate.getDb();
    return database.getCollection(collection);
  }

}
