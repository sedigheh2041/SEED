package com.example.demo234.controller;

import com.example.demo234.model.EventEntity;
import com.example.demo234.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
@RestController
@RequestMapping("/api/users")

public class TheController {

    public TheController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserService userService;

    @GetMapping
    public list<EventEntity> getAllUsers() {
        return (list<EventEntity>) userService.getAllUser();
    }

    @GetMapping("/id")
    public EventEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/id")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }




    @PostMapping
    public void saveUser(@RequestBody EventEntity eventEntity) {
        userService.saveUser(eventEntity);
    }




}













//        UserService userService = new UserService();

    //    @SneakyThrows
//    @GetMapping("/username")
//    public List<UserEntity> getUsersByUsername(@RequestParam String username) {
//
//            try {
//                Thread.sleep(10000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        return userService.getUsersByUsername(username);
//    }








