package com.example.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.users.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
