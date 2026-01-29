package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "test_messages")
public class TestMessage {

    @Id
    private Integer rowKey;

    private String message;
    private String email;

    public TestMessage() {
    }

    public TestMessage(Integer rowKey, String message, String email) {
        this.rowKey = rowKey;
        this.message = message;
        this.email = email;
    }

    public Integer getRowKey() {
        return rowKey;
    }

    public void setRowKey(Integer rowKey) {
        this.rowKey = rowKey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
