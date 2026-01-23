package com.example.demo.repository;

import com.example.demo.entity.TestMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMessageRepository extends JpaRepository<TestMessage, Integer> {
}
