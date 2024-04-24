/**
 */
package com.ecf3.marioPizza.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecf3.marioPizza.core.domain.OrderLine;
import com.ecf3.marioPizza.core.repository.IOLineRepository;
import com.ecf3.marioPizza.core.service.IOrderLineService;

@Service
public final class OrderLineService implements IOrderLineService {

	/**
	 * repository for pizza.
	 */
	@Autowired
	private IOLineRepository orderLineRepo;

	@Override
	public OrderLine save(final OrderLine orderLine) {
		return orderLineRepo.saveAndFlush(orderLine);
	}

}
