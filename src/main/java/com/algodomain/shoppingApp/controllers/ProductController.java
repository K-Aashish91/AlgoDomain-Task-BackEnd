package com.algodomain.shoppingApp.controllers;

import com.algodomain.shoppingApp.models.Product;
import com.algodomain.shoppingApp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @CrossOrigin
  @GetMapping("/all")
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/{id}")
  public Product getProduct(@PathVariable("id") String id) {
    Product product = productService.getProductById(id);
    return product;
  }

  @CrossOrigin
  @PostMapping("/search")
  public List<Map<String,Object>>  searchProducts(@RequestBody Map<String,String> searchBody) {
    List<Map<String,Object>>  products = productService.searchProducts(searchBody);
    return products;
  }

  @PostMapping("/save")
  public Product saveProduct(@RequestBody Product searchBody) {
    Product  product = productService.saveProduct(searchBody);
    return product;
  }

}
