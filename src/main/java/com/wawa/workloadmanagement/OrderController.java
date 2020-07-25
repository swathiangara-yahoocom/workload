package com.wawa.workloadmanagement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wawa.workloadmanagement.model.Order;

@RestController
public class OrderController {

	@Autowire
	OrderQueueService orderQueueService;

	@RequestMapping("/createOrder")
    public Order createOrder(Order order) {
		//1. generate orderId
		//2. placing it in the queue
		orderQueueService.pushOrder(order);
		return order;
	}

	@RequestMapping("/getConsolidatedOrder")
	public Order getConsolidatedOrder(String orderId) {
		//1. return processed Order

		return order;
	}
}
