package com.hai.learning.assignment08.service;

import com.hai.learning.assignment08.entity.Account;
import com.hai.learning.assignment08.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {
    List<Account> getAllAccounts();
    Page<Account> getAllAccounts(Pageable pageable);

    Account getAccountById(int id);
    Account getAccountByName(String name);
    void createAccount(Account department);
    void updateAccount(short id, String newName);
    void updateAccount(Account department);
    void deleteAccount(short id);
    boolean isAccountExistsById(short id);
    boolean isAccountExistsByName(String name);
}
