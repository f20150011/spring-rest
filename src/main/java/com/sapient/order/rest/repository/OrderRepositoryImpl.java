package com.sapient.order.rest.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sapient.order.rest.dto.Order;

@Repository
public class OrderRepositoryImpl implements IOrderRepository {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void save(Order order) throws Exception {
		entityManager.persist(order);
	}

	@Override
	public void delete(Order order) {
		entityManager.remove(entityManager.merge(order));
	}

	@Override
	public Order get(Order order) {
		return entityManager.find(Order.class, order.getId());
	}
}
