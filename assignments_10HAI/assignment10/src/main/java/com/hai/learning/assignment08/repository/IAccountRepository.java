package com.hai.learning.assignment08.repository;

import com.hai.learning.assignment08.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    Account getByFirstName(String firstName);
    Account getByUsername(String username);


    @Query(value = "SELECT * FROM account WHERE firstName = ?1", nativeQuery = true)
    Account existByName(String name);

    @Query(value = "SELECT * FROM account WHERE username = ?1", nativeQuery = true)
    Account existByUsername(String username);

    @Query(value = "SELECT * FROM account WHERE email = ?1", nativeQuery = true)
    Account existByEmail(String email);

}
