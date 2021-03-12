package org.example.dto;

import org.springframework.hateoas.RepresentationModel;

public class ServiceDTO extends RepresentationModel<ServiceDTO> {

    private int id;
    private String name;
    private String Description;

    public ServiceDTO() {
    }

    public ServiceDTO(int id, String name, String description) {
        this.id = id;
        this.name = name;
        Description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
