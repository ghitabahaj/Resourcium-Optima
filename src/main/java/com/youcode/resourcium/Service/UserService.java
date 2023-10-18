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
            throw new IllegalArgumentException("Username, email, or password cannot be empty.");
        }
    }

    public String HashPass(String password){
       return userRepository.hashPassword(password);
    }
}
