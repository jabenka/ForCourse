package com.example.demo.api.controller;


import com.example.demo.api.controller.dto.responseDTO;
import com.example.demo.api.persistence.dao.userDAO;
import com.example.demo.api.persistence.entity.userEntity;
import com.example.demo.api.service.userService;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    private final userService service;
    private final userDAO userDAO;

    public userController(userService service, com.example.demo.api.persistence.dao.userDAO userDAO) {
        this.service = service;
        this.userDAO = userDAO;
    }


    @PostMapping("/user")
    public responseDTO updateUser(@RequestParam(name = "id") String id, @RequestParam(name = "name")String name) throws BadRequestException {
        Long ID=-1L;
        try{
            ID=Long.parseLong(id);
        }catch (NumberFormatException e){
            throw new BadRequestException("Invalid input");
        }

        userEntity userBefore=userDAO.findById(ID).orElse(null);


        service.updateUserAndCreateTicket(ID,name);

        userEntity userAfter=userDAO.findById(ID).orElse(null);

        return responseDTO.builder()
                .userBefore(userBefore)
                .userAfter(userAfter)
                .build();
    }


}
