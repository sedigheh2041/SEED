package com.example.demo234.service;

import com.example.demo234.model.EventEntity;
import com.example.demo234.repository.UserRepository;
import jdk.jfr.Timestamp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.*;
import java.time.LocalDateTime;

import static java.util.concurrent.CompletableFuture.runAsync;

@Component
@Service
@Slf4j
public class UserService {

    @Autowired
    @Lazy
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Timestamp
    public EventEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public EventEntity findBytTimeStamp(Long timeStamp){
        return userRepository.findByDateCreated(LocalDateTime.ofEpochSecond(timeStamp,0, ZoneOffset.UTC));
    }

  public List<EventEntity> getAllUser() {return userRepository.findAll();}

    public void saveUser(EventEntity user) {

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }





}




//
//    public void  setUserRepositoryType(String type){
//        UserEntity userEntity2=new UserEntity();
//        userEntity2.setType(type);
//        userRepository.save(userEntity2);
//    }
// public  void metaEntity(String key,String value){
//        UserEntity userEntity3=new UserEntity();
//        userEntity3.setKey(key);
//        userEntity3.setValue(value);
//        userRepository.save(userEntity3);
//        userEntity3.getSeen();
// }

////    Map<String, String> dictionary = new HashMap<>();
////    dictionary.put("key", "value");
////    String value = dictionary.get("key");
//
//    Dictionary<String,String> dict= new Hashtable<>();
//        dict.put("key", "value");
//    Enumeration<String> k = dict.keys();
//        while (k.hasMoreElements()){
//        String key = k.nextElement();
//        System.out.println("Key: " + key + ", Value: "
//                + dict.get(key));
//    }

//
////    public void metaMethod() {
////        UserEntity user = new UserEntity();
////        user.setMeta("{key}:{value}");
////        String metaValue = user.getMeta();
////        System.out.println(metaValue);
////    }

//    public UserEntity updateUserEntity(UserEntity user) {
//        user = userRepository.findById(user.getId()).orElse(null);
//        LocalDateTime createDate = user.getDateCreated();
//        LocalDateTime lastUpdateDate = user.getLastUpdate();
//        System.out.println(createDate);
//        System.out.println(lastUpdateDate);
//        return user;
//    }
//}

////    public LocalDateTime gerDateCreated(){
////     return dateCreated;
//// }

////    public List findByDate(String date) {
////        Instant startOfDay = Instant.parse(date).truncatedTo(ChronoUnit.DAYS);
////        Instant endOfDay = startOfDay.plus(Duration.ofDays(1));
////        return saleOrderRepository.findBySaleTimeAfterAndSaleTimeBefore(startOfDay, endOfDay);
////    }
//    //     return user.findBySaleTimeAfterAndSaleTimeBefore(createDate, lastUpdateDate);
////        return  userRepository.save(user);
////
////     LocalDateTime localDateTime5;
////     localDateTime5 = LocalDateTime.of(createDate, lastUpdateDate);
