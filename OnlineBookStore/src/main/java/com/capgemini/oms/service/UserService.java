package com.capgemini.oms.service;

import com.capgemini.oms.entity.User;

public interface UserService {

	User findByUsername(String name);

}
