package com.example.demo.repository;

import com.example.demo.model.Neo4jEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface Neo4jRepo extends 	Neo4jRepository<Neo4jEntity, Long> {
}
