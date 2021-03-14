package org.example.controller;

import org.example.assembler.OrderAssembler;
import org.example.assembler.ServiceAssembler;
import org.example.dto.OrderDTO;
import org.example.dto.ServiceDTO;
import org.example.entity.Order;
import org.example.entity.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/services", produces = "application/json")
public class ServiceController {

    private final ServiceAssembler serviceAssembler;
    private final OrderAssembler orderAssembler;

    @Autowired
    public ServiceController(ServiceAssembler serviceAssembler, OrderAssembler orderAssembler) {
        this.serviceAssembler = serviceAssembler;
        this.orderAssembler = orderAssembler;
    }

    @GetMapping()
    public ResponseEntity<CollectionModel<ServiceDTO>> getServicesList() {
        var services = List.of(new Service(1, "Service1", "Description of Service 1"),
                new Service(2, "Service2", "Description of Service 2"));

        return new ResponseEntity<>(serviceAssembler.toCollectionModel(services), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceDTO> getServiceDescription(
            @PathVariable("id") int serviceId) {
        Service exampleService = new Service(serviceId, "Service Name", "Service Description");

        return new ResponseEntity<>(serviceAssembler.toModel(exampleService), HttpStatus.OK);
    }

    @PostMapping("/{id}/orders")
    public ResponseEntity<Integer> createOrderForService(
            @PathVariable("id") int serviceId) {
        int newOrderId = 5;

        return new ResponseEntity<>(newOrderId, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}/orders/{oid}")
    public ResponseEntity<OrderDTO> getOrderStatus(
            @PathVariable("id") int serviceId,
            @PathVariable("oid") int orderId) {
        Order myOrder = new Order(serviceId, orderId, "Order Description", "processing");

        return new ResponseEntity<>(orderAssembler.toModel(myOrder), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/orders/{oid}")
    public ResponseEntity<Void> removeOrderedService(
            @PathVariable("id") int serviceId,
            @PathVariable("oid") int orderId) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/orders/{oid}")
    public ResponseEntity<Void> updateOrderInformation(
            @PathVariable("id") int serviceId,
            @PathVariable("oid") int orderId) {

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
