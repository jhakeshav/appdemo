package com.example.demo.config;

import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Neo4jConfig {

    @Bean
    public Driver driver() {
        return GraphDatabase.driver("bolt://localhost:7687", org.neo4j.driver.AuthTokens.basic("neo4j", "testpassword"));
    }

    @Bean
    public Session session(Driver driver) {
        return driver.session();
    }
}
