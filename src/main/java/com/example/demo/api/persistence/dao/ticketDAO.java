package com.example.demo.api.persistence.dao;

import com.example.demo.api.persistence.entity.ticketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ticketDAO extends JpaRepository<ticketEntity, Long> {
}
