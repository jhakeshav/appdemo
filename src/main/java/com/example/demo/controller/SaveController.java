package com.example.demo.controller;

import com.example.demo.model.PostgresEntity;
import com.example.demo.model.Neo4jEntity;
import com.example.demo.repository.Neo4jRepo;
import com.example.demo.repository.PostgresRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveController {

    @Autowired
    private PostgresRepository postgresRepository;

    @Autowired
    private Neo4jRepo neo4jRepository;

    @PostMapping("/save")
    public String saveData(@RequestBody DataDto dataDto) {
        // Save data to PostgreSQL
        PostgresEntity postgresEntity = new PostgresEntity();
        postgresEntity.setId(dataDto.getId());
        postgresEntity.setName(dataDto.getName());
        postgresRepository.save(postgresEntity);

        // Save data to Neo4j
        Neo4jEntity neo4jEntity = new Neo4jEntity();
        neo4jEntity.setId((dataDto.getId()));
        neo4jEntity.setName(dataDto.getName());
        neo4jRepository.save(neo4jEntity);

        return "Data saved to both PostgreSQL and Neo4j!";
    }

    // Data transfer object for POST request
    public static class DataDto {
        
    	private String name;
    	private Long id;

        public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
