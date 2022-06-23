package com.algodomain.shoppingApp.services;

import com.algodomain.shoppingApp.repository.UserSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
  @Autowired
  private UserSearchRepository userRepository;

  public List<Map<String, Object>> getUserByUserName(Map<String,String> conditionMap) {
    return userRepository.searchUsers(conditionMap);
  }

  public boolean authenticate(Map<String, String> searchBody) {
    List<Map<String, Object>> users = userRepository.searchUsers(searchBody);
    if(CollectionUtils.isEmpty(users)) return false;
    return true;
  }
}
