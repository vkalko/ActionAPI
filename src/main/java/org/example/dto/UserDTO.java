package org.example.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

public class UserDTO extends RepresentationModel<UserDTO> {

    private int userId;
    private String userFirstName;
    private String userLastName;
    private String userTaxNumber;

    public UserDTO() {
    }

    @JsonCreator
    public UserDTO(@JsonProperty("userId") int userId,
                   @JsonProperty("userFirstName") String userFirstName,
                   @JsonProperty("userLastName") String userLastName,
                   @JsonProperty("userTaxNumber") String userTaxNumber) {
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
