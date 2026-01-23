package com.example.demo.controller;

import com.example.demo.entity.TestMessage;
import com.example.demo.service.TestMessageService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final TestMessageService service;

     public HelloController(TestMessageService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public List<TestMessage> getMessages() {
        return service.getAllMessages();
    }
}
