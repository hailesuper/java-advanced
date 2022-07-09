package com.hai.learning.assignment08.controller;

import com.hai.learning.assignment08.dto.DepartmentDTO;
import com.hai.learning.assignment08.entity.Account;
import com.hai.learning.assignment08.dto.AccountDTO;
import com.hai.learning.assignment08.entity.Department;
import com.hai.learning.assignment08.form.CreateAccountForm;
import com.hai.learning.assignment08.service.IAccountService;
import com.hai.learning.assignment08.validation.PageableConstraint;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/accounts")
@Validated
public class AccountRestController {
    @Autowired
    private IAccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<Page<AccountDTO>> getAllAccounts(@PageableConstraint Pageable pageable) {
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

    @PostMapping()
    public ResponseEntity<String> createAccount(
            @RequestBody @Valid CreateAccountForm createAccountForm
            ) {
        accountService.createAccount(createAccountForm);
        return new ResponseEntity<>(createAccountForm.toString() +
                "\nhas been created", HttpStatus.CREATED);
    }



    @GetMapping("/check/email/{email}")
    public ResponseEntity<String> isAccountExistsByEmail(@PathVariable String email) {
        var flagExist = accountService.isAccountExistsByEmail(email);
        if (flagExist) {
            return new ResponseEntity<>(email +
                    "\nexists", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(email +
                    "\ndoesn't exists", HttpStatus.OK);
        }

    }

    @GetMapping("/check/username/{username}")
    public ResponseEntity<String> isAccountExistsByUsername(@PathVariable String username) {
        var flagExist = accountService.isAccountExistsByUsername(username);
        if (flagExist) {
            return new ResponseEntity<>(username +
                    "\nexists", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(username +
                    "\ndoesn't exists", HttpStatus.OK);
        }

    }

    // EXCEPTION HANDLING
    @GetMapping("/exception")
    public void testException() throws Exception {
        // ... other logic
        throw new EntityNotFoundException("... Exception Information");
        // ... other code
    }

}
