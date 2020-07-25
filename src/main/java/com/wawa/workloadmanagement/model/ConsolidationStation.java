package com.wawa.workloadmanagement.model;

public class ConsolidationStation {

    Integer orderId;
    List<OrderLineItem> orderLineItems;

    public ConsolidationStation(Integer orderId, List<OrderLineItem> orderLineItems) {
        this.orderId = orderId;
        this.orderLineItems = orderLineItems;
    }
}
