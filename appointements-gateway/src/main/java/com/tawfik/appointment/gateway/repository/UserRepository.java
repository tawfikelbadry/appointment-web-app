package com.tawfik.appointment.gateway.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tawfik.appointment.gateway.model.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	Optional<User> findByUsername(String username);

}
