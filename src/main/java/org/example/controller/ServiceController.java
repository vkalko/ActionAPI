package org.example.controller;

import org.example.entity.Order;
import org.example.entity.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/services", produces = "application/json")
public class ServiceController {

    @GetMapping()
    public ResponseEntity<List<Service>> getServicesList() {
        var services = List.of(new Service(1, "Service1", "Description of Service 1"),
                new Service(2, "Service2", "Description of Service 2"));

        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> getServiceDescription(
            @PathVariable("id") int serviceId) {
        Service exampleService = new Service(1, "Service Name", "Service Description");

        return new ResponseEntity<>(exampleService, HttpStatus.OK);
    }

    @PostMapping("/{id}/orders")
    public ResponseEntity<Integer> createOrderForService(
            @PathVariable("id") int serviceId) {
        int newOrderId = 5;

        return new ResponseEntity<>(newOrderId, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}/orders/{oid}")
    public ResponseEntity<Order> getOrderStatus(
            @PathVariable("id") int serviceId,
            @PathVariable("oid") int orderId) {
        Order myOrder = new Order(1, "Order Description", "processing");

        return new ResponseEntity<>(myOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/orders/{oid}")
    public ResponseEntity<String> removeOrderedService(
            @PathVariable("id") int serviceId,
            @PathVariable("oid") int orderId) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/orders/{oid}")
    public ResponseEntity<String> updateOrderInformation(
            @PathVariable("id") int serviceId,
            @PathVariable("oid") int orderId) {

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
