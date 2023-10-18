package com.youcode.resourcium.Service;

import com.youcode.resourcium.Exceptions.UserAlreadyExistsException;
import com.youcode.resourcium.repository.UserRepository;
import com.youcode.resourcium.Entities.User;




public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User authenticateUser(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Username or password cannot be empty.");
        }

        User user = userRepository.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    public void addNewUser(User user) throws UserAlreadyExistsException {
        if (userRepository.isValidUser(user)) {
            if (!userRepository.doesUserExist(user.getUsername())) {
                if (userRepository.isValidEmail(user.getEmail()) && userRepository.isStrongPassword(user.getPassword())) {
                    userRepository.persistUser(user);
                } else {
                    throw new IllegalArgumentException("Invalid email or weak password.");
                }
            } else {
                throw new UserAlreadyExistsException("User with username " + user.getUsername() + " already exists.");
            }
        } else {
            throw new IllegalArgumentException("Username or password cannot be empty.");
        }
    }

    public String HashPass(String password){
       return userRepository.hashPassword(password);
    }
}
