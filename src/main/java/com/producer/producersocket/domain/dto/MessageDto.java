package com.producer.producersocket.domain.dto;

public class MessageDto {
    private boolean isActive;
    private String color;
    private int number;
    private String message;
    private String userId;


    public MessageDto(boolean isActive, String color, int number, String message, String userId) {
        this.isActive = isActive;
        this.color = color;
        this.number = number;
        this.message = message;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
