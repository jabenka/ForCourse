package com.example.demo.api.persistence.dao;

import com.example.demo.api.persistence.entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userDAO extends JpaRepository<userEntity,Long> {
}
