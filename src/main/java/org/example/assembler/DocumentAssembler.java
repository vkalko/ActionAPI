package org.example.assembler;

import org.example.controller.DocumentController;
import org.example.controller.ServiceController;
import org.example.dto.DocumentDTO;
import org.example.entity.Document;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DocumentAssembler extends RepresentationModelAssemblerSupport<Document, DocumentDTO> {

    public DocumentAssembler() {
        super(DocumentController.class, DocumentDTO.class);
    }

    @Override
    public DocumentDTO toModel(Document entity) {

        DocumentDTO documentDTO = instantiateModel(entity);

        documentDTO.setName(entity.getName());

        documentDTO.add(linkTo(methodOn(DocumentController.class).getAllowedDocuments()).withSelfRel());
        documentDTO.add(linkTo(methodOn(ServiceController.class).getServicesList()).withRel("service-list"));

        return documentDTO;
    }

    @Override
    public CollectionModel<DocumentDTO> toCollectionModel(Iterable<? extends Document> entities) {
        CollectionModel<DocumentDTO> collectionModel = super.toCollectionModel(entities);
        collectionModel.add(linkTo(methodOn(DocumentController.class).getAllowedDocuments()).withSelfRel());

        return collectionModel;
    }
}
