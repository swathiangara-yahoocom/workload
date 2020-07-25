package com.wawa.workloadmanagement.Dao;

import com.wawa.workloadmanagement.model.Order;
import org.springframework.stereotype.Component;

@Component(name = "orderDao")
public class OrderDAO {

    public Order getOrder(Integer orderId) {
        // retrieve from DB
        Order order = new Order(orderId);
        return order;
    }

    public boolean updateOrder(Order order) {
        // update in DB
        return true;
    }
}
