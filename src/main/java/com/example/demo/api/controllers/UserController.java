package com.example.demo.api.controllers;

import com.beust.ah.A;
import com.example.demo.api.dto.AnswerDto;
import com.example.demo.api.dto.UserDto;
import com.example.demo.api.exception.UserNotFoundException;
import com.example.demo.api.persistence.dao.UserDao;
import com.example.demo.api.persistence.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final String USER_TICKETS="api/user";
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(USER_TICKETS)
    public ResponseEntity<?> getUsersTickets(@RequestParam(name = "id")String userId){
        Long id;
        try{
            id=Long.parseLong(userId);
        }catch (NumberFormatException e){
            throw new UserNotFoundException("user with id:"+userId+"not found");
        }
        if(userDao.findById(id).isPresent()){
            UserEntity entity=userDao.findById(id).get();
            AnswerDto answerDto= AnswerDto.builder().tickets(entity.getTickets()).build();
            return ResponseEntity.ok(answerDto);
        }else {
            throw new UserNotFoundException("user with id:"+userId+"not found");
        }
    }


}
