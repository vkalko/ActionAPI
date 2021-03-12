package org.example.assembler;

import org.example.controller.ServiceController;
import org.example.dto.ServiceDTO;
import org.example.entity.Service;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ServiceAssembler extends RepresentationModelAssemblerSupport<Service, ServiceDTO> {

    public ServiceAssembler() {
        super(ServiceController.class, ServiceDTO.class);
    }

    @Override
    public ServiceDTO toModel(Service entity) {

        ServiceDTO serviceDTO = instantiateModel(entity);

        serviceDTO.add(linkTo(methodOn(ServiceController.class).getServicesList()).withSelfRel());
        serviceDTO.add(linkTo(methodOn(ServiceController.class).getServiceDescription(entity.getId())).withRel("get-service-by-id"));
        serviceDTO.add(linkTo(methodOn(ServiceController.class).getOrderStatus(entity.getId(), 1)).withRel("get-order-status"));

        serviceDTO.setId(entity.getId());
        serviceDTO.setName(entity.getName());
        serviceDTO.setDescription(entity.getDescription());

        return serviceDTO;
    }

    @Override
    public CollectionModel<ServiceDTO> toCollectionModel(Iterable<? extends Service> entities) {
        CollectionModel<ServiceDTO> collectionModel = super.toCollectionModel(entities);
        collectionModel.add(linkTo(methodOn(ServiceController.class).getServicesList()).withSelfRel());
        return collectionModel;
    }
}
