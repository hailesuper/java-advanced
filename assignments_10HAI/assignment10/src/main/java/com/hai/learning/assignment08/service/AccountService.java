package com.hai.learning.assignment08.service;

import com.hai.learning.assignment08.entity.Account;
import com.hai.learning.assignment08.form.CreateAccountForm;
import com.hai.learning.assignment08.repository.IAccountRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

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
    public Account getAccountByUsername(String name) {
        return accountRepository.getByUsername(name);
    }


    @Transactional
    @Override
    public void createAccount(CreateAccountForm createAccountForm) {
        // skip the id field
        var typeMap = modelMapper.getTypeMap(CreateAccountForm.class, Account.class);
        if (typeMap == null) {
            modelMapper.addMappings(new PropertyMap<CreateAccountForm, Account>() {
                @Override
                protected void configure() {
                    skip(destination.getId());
                }
            });
        }
        // convert Form
        var account = modelMapper.map(createAccountForm, Account.class);
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

    @Override
    public boolean isAccountExistsByUsername(String username) {
        return accountRepository.existByUsername(username) != null;
    }


    @Override
    public boolean isAccountExistsByEmail(String email) {
        return accountRepository.existByEmail(email) != null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var account = accountRepository.getByUsername(username);

        if (account == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(account.getUsername(),
                account.getPassword(),
                AuthorityUtils.createAuthorityList(account.getRole().toString()));
    }
}
