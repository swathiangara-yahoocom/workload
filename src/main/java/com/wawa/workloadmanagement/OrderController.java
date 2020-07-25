package com.wawa.workloadmanagement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wawa.workloadmanagement.model.Order;

@RestController
public class OrderController {
	
	@RequestMapping("/createOrder")
    public Order createOrder(Order order) {
		//1. generate orderId
		//2. placing it in the queue
		return order;
	}
}
