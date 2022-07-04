package com.hai.learning.assignment08.repository;

import com.hai.learning.assignment08.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    Account getByFirstName(String firstName);

    @Query(value = "SELECT * FROM account WHERE firstName = ?1", nativeQuery = true)
    Account existByName(String name);
}
