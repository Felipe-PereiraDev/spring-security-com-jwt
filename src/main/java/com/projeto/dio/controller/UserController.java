package com.projeto.dio.controller;


import com.projeto.dio.dto.UserCreate;
import com.projeto.dio.dto.ResponseUser;
import com.projeto.dio.model.User;
import com.projeto.dio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable("username") String username) {
        User user = userService.findByUsername(username);
        return ResponseEntity.ok(new ResponseUser(user.getUsername(), user.getPassword()));
    }


    @PostMapping("/register")
    public ResponseEntity<ResponseUser> createUser(@RequestBody UserCreate data) {
        System.out.println("/register chaamdo");
        System.out.println(data);
        User user = userService.createUser(data);
        return ResponseEntity.ok(new ResponseUser(user.getUsername(), user.getPassword()));
    }

    @GetMapping("/oi")
    public String  oi() {
        System.out.println("metodo oi sendo chamado ");
        return "oi";
    }
}
