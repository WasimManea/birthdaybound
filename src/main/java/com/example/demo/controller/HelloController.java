package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.TestMessageService;
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
