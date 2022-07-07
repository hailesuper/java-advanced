package com.hai.learning.assignment08.controller;

import com.hai.learning.assignment08.dto.DepartmentDTO;
import com.hai.learning.assignment08.entity.Account;
import com.hai.learning.assignment08.dto.AccountDTO;
import com.hai.learning.assignment08.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Page<AccountDTO>> getAllAccounts(Pageable pageable) {
        Page<Account> accountPage = accountService.getAllAccounts(pageable);
        List<AccountDTO> accountDTOList = modelMapper.map(
                accountPage.getContent(),
                new TypeToken<List<AccountDTO>>() {}.getType()
        );

        Page<AccountDTO> accountDTOPage = new PageImpl<>(accountDTOList,pageable, accountPage.getTotalElements());
        return new ResponseEntity<>(accountDTOPage, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public AccountDTO getAccountById(@PathVariable int id) {
        var accountEntity = accountService.getAccountById(id);

        var accountDTO = modelMapper.map(accountEntity, AccountDTO.class);

        return accountDTO;
    }
}
