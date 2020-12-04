package com.example.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.users.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
