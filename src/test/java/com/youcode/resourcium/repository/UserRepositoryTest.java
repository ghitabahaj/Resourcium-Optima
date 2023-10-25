package com.youcode.resourcium.repository;

import com.youcode.resourcium.Entities.Departement;
import com.youcode.resourcium.Entities.Role;
import com.youcode.resourcium.Entities.User;
import com.youcode.resourcium.Service.DepartementService;
import com.youcode.resourcium.Service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UserRepositoryTest{


    @Test
    public void invalid_password() {
        // Arrange
        UserRepository userRepository = mock(UserRepository.class);
        DepartementRepository departementRepository = mock(DepartementRepository.class);
        DepartementService departementService = new DepartementService(departementRepository);
        UserService userService = new UserService(userRepository);
        Departement departement = new Departement("Departement","description");
        departementService.saveDepartement(departement);
        User user = new User("john", "password", "John", "john@example.com", new Role(), "1234567890");
        user.setDepartement(departement);
        when(userRepository.getUserByUsername("john")).thenReturn(user);


        // Act
        User result = userService.authenticateUser("john", "wrong_password");


        assertNull(result);
    }

}