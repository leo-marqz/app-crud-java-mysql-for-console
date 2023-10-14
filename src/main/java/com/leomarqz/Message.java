package com.leomarqz;

public class Message {
    private int id;
    private String message;
    private String createdBy;
    private String createdAt;

    public Message() {
    }

    public Message(String message, String createdBy, String createdAt) {
        this.message = message;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Message(int id, String message) {
        this.message = message;
    }

    public Message(int id, String message, String createdBy, String createdAt) {
        this.id = id;
        this.message = message;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
