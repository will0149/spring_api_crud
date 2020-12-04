package com.example.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.users.entities.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer>{

}
