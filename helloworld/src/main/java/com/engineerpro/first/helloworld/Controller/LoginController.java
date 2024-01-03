package com.engineerpro.first.helloworld.Controller;

import com.engineerpro.first.helloworld.Entity.User;
import com.engineerpro.first.helloworld.Service.LoginService;
import com.engineerpro.first.helloworld.dto.UserDto;
import com.engineerpro.first.helloworld.repository.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping("/signin")
    public ResponseEntity<?> signin() {

     return new ResponseEntity<>( loginService.getAllUsers(), HttpStatus.OK);
    }
}
