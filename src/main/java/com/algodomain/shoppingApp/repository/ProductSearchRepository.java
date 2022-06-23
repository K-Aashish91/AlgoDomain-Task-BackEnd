package com.algodomain.shoppingApp.repository;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProductSearchRepository extends AbstractRepository{

  public List<Map<String, Object>>  searchProduct(Map<String,String> conditonMap){
    List<Map<String, Object>> products = new ArrayList<>();
    BasicDBObject query = new BasicDBObject();
    List<BasicDBObject> andQuery = new ArrayList<BasicDBObject>();
    for(String key: conditonMap.keySet()) {

      if (key.equalsIgnoreCase("maxPrice")) {
        double priceValue = Double.parseDouble(conditonMap.get(key));
        andQuery.add(new BasicDBObject("price", new BasicDBObject("$lte", priceValue)));
      } else if (key.equalsIgnoreCase("minPrice")) {
        double priceValue = Double.parseDouble(conditonMap.get(key));
        andQuery.add(new BasicDBObject("price", new BasicDBObject("$gte", priceValue)));
      } else {
        andQuery.add(new BasicDBObject(key, conditonMap.get(key)));
      }
    }
    query.put("$and", andQuery);
    FindIterable<Document> documents = getCollection("products").find(query);
    for (Document doc : documents){
      if(null!=doc){
        products.add((Map<String, Object>) doc);
      }
    }
    return products;
  }
}
