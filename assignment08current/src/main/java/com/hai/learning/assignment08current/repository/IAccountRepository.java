package com.hai.learning.assignment08current.repository;

import com.hai.learning.assignment08current.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
}
