package com.hai.learning.finalexam02.controller;

import com.hai.learning.finalexam02.dto.UserDto;
import com.hai.learning.finalexam02.entity.User;
import com.hai.learning.finalexam02.repository.IUserRepository;
import com.hai.learning.finalexam02.service.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin("*")
public class UserRestController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> users = userService.getAllUsers();

        List<UserDto> userDtos = modelMapper.map(users, new TypeToken<List<UserDto>>() {}.getType());

        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }


}
