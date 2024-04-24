/**
 */
package com.ecf3.marioPizza.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecf3.marioPizza.core.domain.Order;
import com.ecf3.marioPizza.core.repository.IOrderRepository;
import com.ecf3.marioPizza.core.service.IOrderService;

@Service
public final class OrderService implements IOrderService {

	/**
	 * repository for pizza.
	 */
	@Autowired
	private IOrderRepository orderRepo;

	@Override
	public Order save(final Order order) {
		return orderRepo.saveAndFlush(order);
	}

}
