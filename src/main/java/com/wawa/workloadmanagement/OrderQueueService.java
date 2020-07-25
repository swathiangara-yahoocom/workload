package com.wawa.workloadmanagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.wawa.workloadmanagement.Dao.OrderDAO;
import com.wawa.workloadmanagement.model.OrderState;
import org.springframework.stereotype.Service;

import com.wawa.workloadmanagement.model.Order;
import com.wawa.workloadmanagement.model.OrderLineItem;
import com.wawa.workloadmanagement.model.Product;

@Service
public class OrderQueueService {
	private Map<Integer, Queue<OrderLineItem>> orderQueueByProductGroupIdMap = new HashMap<>();

	@Autowire
	OrderDAO orderDAO;


	public boolean pushOrder(Order order) {
		for(OrderLineItem orderItem : order.getOrderLineItems()) {
			Integer productGroupId = orderItem.getProduct().getProductGropId();
			if(!orderQueueByProductGroupIdMap.containsKey(productGroupId)) {
				orderQueueByProductGroupIdMap.put(productGroupId, new LinkedBlockingQueue<>());
			}
			orderQueueByProductGroupIdMap.get(productGroupId).add(orderItem);
		}
		order.setState(OrderState.INPROGRESS);
		orderDAO.updateOrder(order);
		return true;
	}
	
	public Queue<OrderLineItem>  receiveNextOrderLineItem(Integer productGroupId) {
		Queue<OrderLineItem> lineItemQueue = orderQueueByProductGroupIdMap.get(productGroupId);
		
		if(lineItemQueue == null) {
			return null;
		}
		 orderQueue.remove();
		return lineItemQueue;
	}
	
	
	
	
 }
