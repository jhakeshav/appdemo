package com.example.demo.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.example.demo.model.Company;

public interface CompanyRepository extends Neo4jRepository<Company,Long>{

}
