package com.sapient.order.rest.services;

import com.sapient.order.rest.dto.Order;

public interface IOrderService {
	
	int processOrder(Order order) throws Exception;
	void deleteOrder(int id);
	Order getOrder(int id);
	
}
