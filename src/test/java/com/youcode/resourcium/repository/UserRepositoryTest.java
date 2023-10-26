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

        UserRepository userRepository = mock(UserRepository.class);
        DepartementRepository departementRepository = mock(DepartementRepository.class);
        DepartementService departementService = new DepartementService(departementRepository);
        UserService userService = new UserService(userRepository);
        Departement departement = new Departement("Departement","description");
        departementService.saveDepartement(departement);
        User user = new User("john", userService.hashPassword("password"), "John", "john@example.com", new Role(), "1234567890");
        user.setDepartement(departement);
        when(userRepository.getUserByUsername("john")).thenReturn(user);



        User result = userService.authenticateUser("john", "wrong_password");


        assertNull(result);
    }


    @Test
    public void null_password() {

        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        User result = userService.authenticateUser("john", null);


        assertNull(result);
    }


    @Test
    public void null_username() {

        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        User result = userService.authenticateUser(null, "password");


        assertNull(result);
    }

    @Test
    public void empty_username() {

        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService(userRepository);


        assertThrows(IllegalArgumentException.class, () -> {
            userService.authenticateUser("", "password");
        });
    }


}