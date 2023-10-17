package com.youcode.resourcium.Service;

import com.youcode.resourcium.repository.UserRepository;
import com.youcode.resourcium.Entities.User;


public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticateUser(String username, String password) {
        return userRepository.userExistsInDatabase(username, password);
    }

    public void addNewUser(User user){
        userRepository.persistUser(user);
    }
}
