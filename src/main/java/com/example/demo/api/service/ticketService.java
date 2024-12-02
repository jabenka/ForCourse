package com.example.demo.api.service;

import com.example.demo.api.persistence.entity.ticketEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ticketService {

    @Autowired
    private ResourceLoader resourceLoader;

    public List<ticketEntity> loadTicketsFromFile() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:tickets.json");
        InputStream inputStream = resource.getInputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<ticketEntity>> typeReference = new TypeReference<List<ticketEntity>>() {};
        return objectMapper.readValue(inputStream, typeReference);
    }
}
