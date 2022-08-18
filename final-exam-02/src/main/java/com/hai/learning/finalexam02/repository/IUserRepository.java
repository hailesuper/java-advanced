package com.hai.learning.finalexam02.repository;

import com.hai.learning.finalexam02.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);

}
