package com.algodomain.shoppingApp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "products")
public class Product {

  @Id
  private String _id;
  private String type;
  private String name;
  private String category;
  private double price;
  private Integer quantity;
  private String imageName;


  public Product(String _id, String type, String name, String category, double price, Integer quantity, String imageName) {
    this._id = _id;
    this.type = type;
    this.name = name;
    this.category = category;
    this.price = price;
    this.quantity = quantity;
    this.imageName = imageName;
  }

  public String get_id() {
    return _id;
  }

  public void set_id(String _id) {
    this._id = _id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public double getPrice() { return price; }

  public void setPrice(double price) { this.price = price; }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
