package com.algodomain.shoppingApp.services;

import com.algodomain.shoppingApp.models.Product;
import com.algodomain.shoppingApp.repository.ProductRepository;
import com.algodomain.shoppingApp.repository.ProductSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductSearchRepository productSearchRepository;

  public List<Product> getAllProducts(){
    return productRepository.findAll();
  }

  public Product getProductById(String id){
    return productRepository.findById(id).get();
  }

  public List<Map<String,Object>> searchProducts(Map<String,String> map){
    return productSearchRepository.searchProduct(map);
  }

  public Product saveProduct(Product product){
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMMddhhmmssZ");
    String id = dateFormat.format(new Date());
    product.set_id(id);
   return productRepository.save(product);
  }

}
