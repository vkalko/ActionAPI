package org.example.controller;

import org.example.assembler.DocumentAssembler;
import org.example.dto.DocumentDTO;
import org.example.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(value = "/api/v1/documents", produces = "application/json")
public class DocumentController {

    @Autowired
    private DocumentAssembler documentAssembler;

    @GetMapping()
    public ResponseEntity<CollectionModel<DocumentDTO>> getAllowedDocuments() {
        var allowedDocuments = List.of(new Document("DocumentType1"),
                new Document("DocumentType2"), new Document("DocumentType3"));

        return new ResponseEntity<>(documentAssembler.toCollectionModel(allowedDocuments), HttpStatus.OK);
    }

}
