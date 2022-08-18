package com.hai.learning.finalexam02.controller;

import com.hai.learning.finalexam02.dto.UserLoginDto;
import com.hai.learning.finalexam02.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/login")
@CrossOrigin("*")
public class LoginRestController {
    @Autowired
    private IUserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<UserLoginDto> login(Principal principal) {
        var username = principal.getName();
        var user = userService.getUserByUsername(username);
        var userLoginDto = modelMapper.map(user, UserLoginDto.class);
        return new ResponseEntity<>(userLoginDto,HttpStatus.OK);
    }
}
