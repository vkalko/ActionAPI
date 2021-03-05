package org.example.entity;

public class User {

    private int userId;
    private String userFirstName;
    private String userLastName;
    private String userTaxNumber;

    public User() {
    }

    public User(int userId, String userFirstName, String userLastName, String userTaxNumber) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userTaxNumber = userTaxNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserTaxNumber() {
        return userTaxNumber;
    }

    public void setUserTaxNumber(String userTaxNumber) {
        this.userTaxNumber = userTaxNumber;
    }
}
