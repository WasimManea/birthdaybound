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

    public TestMessage() {}

    public TestMessage(Integer rowKey, String message) {
        this.rowKey = rowKey;
        this.message = message;
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
}
