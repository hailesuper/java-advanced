package com.hai.learning.assignment08.service;

import com.hai.learning.assignment08.entity.Account;
import com.hai.learning.assignment08.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Page<Account> getAllAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    @Override
    public Account getAccountById(int id) {
        return accountRepository.findById(id).get();
//        return  accountRepository.getById((int) id);
//        return  accountRepository.getReferenceById((int)id);
    }

    @Override
    public Account getAccountByName(String name) {
        return accountRepository.getByFirstName(name);
    }

    @Override
    public void createAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void updateAccount(short id, String newFirstname) {
        var tempAccount = getAccountById(id);
        tempAccount.setFirstName(newFirstname);
        accountRepository.save(tempAccount);
    }

    @Override
    public void updateAccount(Account account) {
        if (accountRepository.existsById((int) account.getId())) {
            var oldAccount = getAccountById(account.getId());
            if (account.getFirstName() == null)
                account.setFirstName(oldAccount.getFirstName());
            accountRepository.save(account);
        }
        else
            throw new NoSuchElementException("Account " + account.getId() + " doesn't exists");
    }

    @Override
    public void deleteAccount(short id) {
        accountRepository.deleteById((int) id);
    }

    @Override
    public boolean isAccountExistsById(short id) {
        return accountRepository.existsById((int) id);
    }

    @Override
    public boolean isAccountExistsByName(String name) {
        return accountRepository.existByName(name) != null;
    }
}
