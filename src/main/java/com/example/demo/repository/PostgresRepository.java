package com.example.demo.repository;

import com.example.demo.model.PostgresEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresRepository extends JpaRepository<PostgresEntity, Long> {
}
