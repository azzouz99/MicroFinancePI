package com.example.pidev_finance.services;

import com.example.pidev_finance.entities.User;
import java.util.List;



public interface UserService {
     List<User> getAllUsers();
    User getUserById(Integer id);
    User saveUser(User user);
    void deleteUser(Integer id);

}
