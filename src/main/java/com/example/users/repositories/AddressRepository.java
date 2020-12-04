package com.example.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.users.entities.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>{

}
