package com.example.demo.api.persistence.dao;

import com.example.demo.api.persistence.entity.TicketEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDao extends CrudRepository<TicketEntity, Long> {
}
