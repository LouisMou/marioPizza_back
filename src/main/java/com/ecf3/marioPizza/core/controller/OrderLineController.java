/**
 * 
 */
package com.ecf3.marioPizza.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecf3.marioPizza.core.dto.OrderLineDTO;
import com.ecf3.marioPizza.core.dto.mapper.OrderLineMapper;
import com.ecf3.marioPizza.core.service.IOrderLineService;

@RestController
@RequestMapping("/orderline")
public class OrderLineController {

	@Autowired
	private IOrderLineService orderLineService;

	@PostMapping("/")
	public OrderLineDTO save(@RequestBody final OrderLineDTO order) {
		return OrderLineMapper.orderLineToDto(orderLineService.save(OrderLineMapper.dtoToEntity(order)));
	}

}
