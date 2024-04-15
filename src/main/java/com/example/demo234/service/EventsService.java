package com.example.demo234.service;

import com.example.demo234.model.EntityDto;
import com.example.demo234.model.EventEntity;
import com.example.demo234.repository.EventsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EventsService {


    private final EventsRepository eventsRepository;

    public EventsService(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    public List<EntityDto> findAll() {

        List<EventEntity> instanc = eventsRepository.findAll();
        List<EntityDto> dtol = new ArrayList<>();
        for (EventEntity item : instanc) {
            dtol.add(ConvertEntityToDto(item));
        }
        return dtol;
    }


    public List<EntityDto> findEventByUsernameAndTimestamp(String username, Long timestamp) {

        List<EventEntity> result = eventsRepository.findByUsernameAndTimestamp(username, timestamp);
        List<EventEntity> filteredResult=result.stream().filter(event->event.getTimestamp()>timestamp).collect(Collectors.toList());
        List<EntityDto> dtos = new ArrayList<>();
        for (EventEntity item : filteredResult) {
            dtos.add(ConvertEntityToDto(item));
        }
        return dtos;
    }

    public EntityDto findEventById(Long id) {

        EventEntity item = eventsRepository.findById(id).orElse(null);
        return ConvertEntityToDto(item);
    }

    private EntityDto ConvertEntityToDto(EventEntity entity) {
        EntityDto entityDto = new EntityDto();
        entityDto.setId(entity.getId());
        entityDto.setTimestamp(entity.getTimestamp());
        entityDto.setSeen(entity.getSeen());
        entityDto.setUsername(entity.getUsername());
        entityDto.setUserId(entity.getUserId());
        entityDto.setType(entity.getType());



        ObjectMapper obj=new ObjectMapper();
       Map<String, Object > metaMap=null;
        try {
              metaMap  = obj.readValue(entity.getMeta(), Map.class);
        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
            log.error("Exception",e);
        }

         entityDto.setMeta(metaMap );
        return entityDto;
    }

    public EntityDto saveEvent(EventEntity event) {
        EventEntity save = eventsRepository.save(event);
        return ConvertEntityToDto(save);
    }

    public void deleteUser(Long id) {
        eventsRepository.deleteById(id);
    }


}




//public List<EntityDto> findEventByUsernameAndTimestamp(String username, Long timestamp) {
//
//    List<EventEntity> result = eventsRepository.findByUsernameAndTimestamp(username, timestamp);
//    List<EntityDto> dtos = new ArrayList<>();
//    for (EventEntity item : result) {
//        dtos.add(ConvertEntityToDto(item));
//        if(timestamp>= 1000)
//            return ;
//    }
//    return dtos;
//}




//    public List<EventEntity> findAllByUsername(String username) {
//
//        return eventsRepository.findAllByUsername(username);
//    }
//    public List <EventEntity> findEventByTimestamp(Long timestamp){
//        return eventsRepository.findByTimestamp(timestamp);}

//@Override
//public ApplicationResponse<UserDto> saveUser(SaveUserRequest saveUserRequest)
//        throws UserException.DuplicateUsernameException {
//    UserEntity userEntity = UserMapper.INSTANCE.toEntity(saveUserRequest);
//    try {
//        userEntity = userRepository.save(userEntity);
//    } catch (Exception e) {
//        throw new UserException.DuplicateUsernameException(userEntity.getUsername());
//    }
//    return new ApplicationResponse<>(UserMapper.INSTANCE.toDTO(userEntity));
//}
//public List <EventEntity> findEventByTimestamp(Long timestamp){
//        return eventsRepository.findByTimestamp(timestamp);}

//public EventEntity saveEvent(EventEntity event) {
//    return eventsRepository.save(event);
//}
//String meta=entity.getMeta();
//String parts[] = meta.split(",");
//        for (String part : parts) {
//String stuData[] = part.split(":");
//
//String stuName= stuData[0].trim();
//String stuObject  = stuData[1].trim();
//            metaMap.put(stuName , stuObject);
//        }