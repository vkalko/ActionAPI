package org.example.dto;

import org.springframework.hateoas.RepresentationModel;

public class OrderDTO extends RepresentationModel<OrderDTO> {

    private int serviceId;
    private int orderId;
    private String description;
    private String status;

    public OrderDTO() {
    }

    public OrderDTO(int serviceId, int orderId, String description, String status) {
        this.serviceId = serviceId;
        this.orderId = orderId;
        this.description = description;
        this.status = status;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
