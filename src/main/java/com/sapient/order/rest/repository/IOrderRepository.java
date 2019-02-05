package com.sapient.order.rest.repository;

import com.sapient.order.rest.dto.Order;

public interface IOrderRepository {

	void save(Order order) throws Exception;

	void delete(Order order);

	Order get(Order order);

}