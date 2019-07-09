package com.orane.registration.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.orane.registration.entity.*;


public interface Repository extends CrudRepository<User, Integer> {
	
	List<User> findById(int id);

}
