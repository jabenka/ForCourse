package com.example.demo.api.service;

import com.example.demo.api.persistence.dao.ticketDAO;
import com.example.demo.api.persistence.dao.userDAO;
import com.example.demo.api.persistence.entity.ticketEntity;
import com.example.demo.api.persistence.entity.userEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class userService {


    @Value("${feature.user-update-and-ticket-create.enabled}")
    private boolean isFeatureEnabled;

    private final userDAO userDao;
    private final ticketDAO ticketDao;

    public userService(userDAO userDao, ticketDAO ticketDao) {
        this.userDao = userDao;
        this.ticketDao = ticketDao;
    }

    @Transactional
    public void updateUserAndCreateTicket(Long userId, String eventName) {
        if (!isFeatureEnabled) {
            throw new RuntimeException("Feature is disabled");
        }
        userEntity user=userDao.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        user.setStatus("ACTIVATED");
        userDao.saveAndFlush(user);

        ticketEntity ticket = new ticketEntity();
        ticket.setEvent(eventName);
        ticket.setUser(user);
        ticketDao.saveAndFlush(ticket);
    }





}
