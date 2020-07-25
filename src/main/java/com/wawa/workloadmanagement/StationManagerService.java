package com.wawa.workloadmanagement;

import java.util.List;

import com.wawa.workloadmanagement.Dao.OrderDAO;
import com.wawa.workloadmanagement.model.*;
import com.wawa.workloadmanagement.ordermanagement.PrepareOrderWorker;
import org.springframework.stereotype.Service;

@Service
public class StationManagerService {
	private List<WawaStation> stations;

	@Autowire
	OrderQueueService orderQueueService;

	@Autowire
	PrepareOrderWorker prepareOrderWorker;

	@Autowire
	OrderDAO orderDAO;

	public boolean employyeLogin(WawaStation wa) {
		stations.add(wa);
		return true;
	}
	
	public void employyeLogout(Integer employeeId) {
		
	}
	
	public void processOrder(ProductGroup productGroup) {
		//1. get item from queue
		//2. iterate each Line Item and check which WawaStation can handle it
		//3.

			Integer productGroupId = productGroup.getProductGropId();
		Queue<OrderLineItem> lineItemQueue  = orderQueueService.receiveNextOrderLineItem(productGroupId);
		List<OrderLineItem> preparedOrders = new ArrayList();
		Integer orderId = null;
		for (OrderLineItem orderLineItem1 : lineItemQueue) {
			prepareOrderWorker.processLineItem(orderLineItem1);
			preparedOrders.add(orderLineItem1);
			if (orderId == null) {
				orderId = orderLineItem1.getOrderId();
			}
		}
		Order order = orderDAO.getOrder(orderId);
		order.setState(OrderState.COMPLETED);
		orderDAO.updateOrder(order);

		// send to Consolidation Station
		ConsolidationStation consolidation = new ConsolidationStation(orderId, preparedOrders);


	}

}
