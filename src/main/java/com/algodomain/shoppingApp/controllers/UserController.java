package com.algodomain.shoppingApp.controllers;

import com.algodomain.shoppingApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;


  @PostMapping("/search")
  public  List<Map<String, Object>>  getProduct(@RequestBody Map<String,String> searchBody) {
    List<Map<String, Object>> users = userService.getUserByUserName(searchBody);
    return users;
  }

  @CrossOrigin
  @PostMapping("/login")
  public Map<String,Object> authenticate(@RequestBody Map<String,String> searchBody) {
    if(searchBody.containsKey("username") && searchBody.containsKey("password")) {
      if( userService.authenticate(searchBody)){
        Map<String,Object> result = new HashMap<>();
        result.put("status",true);
        result.put("token",1234567890);
        return result;
      }
    }
    return null;
  }

}
