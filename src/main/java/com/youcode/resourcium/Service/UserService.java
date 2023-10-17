package com.youcode.resourcium.Service;

import com.youcode.resourcium.Exceptions.UserAlreadyExistsException;
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

    public void addNewUser(User user) throws UserAlreadyExistsException {
        if (!userRepository.doesUserExist(user.getUsername())) {
            userRepository.persistUser(user);
        } else {
            throw new UserAlreadyExistsException("User with username " + user.getUsername() + " already exists.");
        }
    }
}
