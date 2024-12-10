package com.example.demo.api.persistence.dao;

import com.example.demo.api.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<UserEntity, Long> {
}
