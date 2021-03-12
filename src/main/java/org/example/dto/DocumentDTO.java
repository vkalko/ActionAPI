package org.example.dto;

import org.springframework.hateoas.RepresentationModel;

public class DocumentDTO extends RepresentationModel<DocumentDTO> {

    private String name;

    public DocumentDTO() {
    }

    public DocumentDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
