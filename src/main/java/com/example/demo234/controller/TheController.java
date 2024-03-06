package com.example.demo234.controller;

import com.example.demo234.model.EventEntity;
import com.example.demo234.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
@RequestMapping("/")

public class TheController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<EventEntity> getHelloWorld() {
        return userRepository.findAll();
    }

//    public TheController(UserService userService) {
//        this.userService = userService;
//    }

//    @Autowired
//    private UserService userService;
//
//    @GetMapping
//    public List<EventEntity> getAllUsers() {
//        return userService.getAllUser();
//    }
//
//    @GetMapping("/id")
//    public EventEntity getUserById(@PathVariable Long id) {
//        return userService.getUserById(id);
//    }
//
//    @GetMapping("/timeStamp")
//    public  EventEntity getTimeStamp (Long timeStamp){
//        return  userService.findBytTimeStamp(timeStamp);
//    }
//
//    @DeleteMapping("/id")
//    public void deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//    }
//
//    @PostMapping
//    public void saveUser(@RequestBody EventEntity eventEntity) {
//        userService.saveUser(eventEntity);
//    }
//


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








