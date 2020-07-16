package com.capgemini.oms.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.oms.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username); 

}
