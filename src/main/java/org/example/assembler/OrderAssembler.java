package org.example.assembler;

import org.example.controller.ServiceController;
import org.example.dto.OrderDTO;
import org.example.entity.Order;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderAssembler extends RepresentationModelAssemblerSupport<Order, OrderDTO> {

    public OrderAssembler() {
        super(ServiceController.class, OrderDTO.class);
    }


    @Override
    public OrderDTO toModel(Order entity) {

        OrderDTO orderDTO = instantiateModel(entity);

        orderDTO.setServiceId(entity.getServiceId());
        orderDTO.setOrderId(entity.getOrderId());
        orderDTO.setStatus(entity.getStatus());
        orderDTO.setDescription(entity.getDescription());

        orderDTO.add(linkTo(methodOn(ServiceController.class)
                .getOrderStatus(entity.getServiceId(), entity.getOrderId())).withSelfRel());
        orderDTO.add(linkTo(methodOn(ServiceController.class)
                .getServiceDescription(entity.getServiceId())).withRel("get-service-description"));
        orderDTO.add(linkTo(methodOn(ServiceController.class).getServicesList()).withRel("get-service-list"));

        return orderDTO;
    }
}
