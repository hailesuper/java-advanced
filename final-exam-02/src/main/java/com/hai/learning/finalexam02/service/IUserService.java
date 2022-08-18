package com.hai.learning.finalexam02.service;

import com.hai.learning.finalexam02.entity.User;
import com.hai.learning.finalexam02.form.CreateUserForm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface IUserService extends UserDetailsService {
    //CRUD
    void createUser(CreateUserForm createUserForm);
    List<User> getAllUsers();

    User getUserByUsername(String username);
}
