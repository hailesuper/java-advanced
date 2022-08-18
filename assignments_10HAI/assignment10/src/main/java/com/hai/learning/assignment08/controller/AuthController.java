package com.hai.learning.assignment08.controller;

import com.hai.learning.assignment08.dto.LoginInfoDto;
import com.hai.learning.assignment08.entity.Account;
import com.hai.learning.assignment08.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "api/v1/auth")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IAccountService accountService;

	@GetMapping("/login")
	public LoginInfoDto login(Principal principal) {

		String username = principal.getName();
		Account entity = accountService.getAccountByUsername(username);

		// convert entity --> dto
		LoginInfoDto dto = modelMapper.map(entity, LoginInfoDto.class);

		return dto;
	}
}
