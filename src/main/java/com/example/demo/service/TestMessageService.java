package com.example.demo.service;

import com.example.demo.entity.TestMessage;
import com.example.demo.repository.TestMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestMessageService {

    private final TestMessageRepository repository;

    public TestMessageService(TestMessageRepository repository) {
        this.repository = repository;
    }

    public List<TestMessage> getAllMessages() {
        return repository.findAll();
    }
}
