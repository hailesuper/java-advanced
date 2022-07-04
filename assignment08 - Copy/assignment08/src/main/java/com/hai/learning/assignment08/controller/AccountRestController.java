package com.hai.learning.assignment08.controller;

import com.hai.learning.assignment08.entity.Account;
import com.hai.learning.assignment08.dto.AccountDTO;
import com.hai.learning.assignment08.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountRestController {
    @Autowired
    private IAccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public AccountDTO getAccountById(@PathVariable int id) {
        var accountEntity = accountService.getAccountById(id);

        var accountDTO = modelMapper.map(accountEntity, AccountDTO.class);

        return accountDTO;
    }
}
