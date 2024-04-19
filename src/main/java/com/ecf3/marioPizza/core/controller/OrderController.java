/**
 * 
 */
package com.ecf3.marioPizza.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecf3.marioPizza.core.dto.OrderDTO;
import com.ecf3.marioPizza.core.dto.mapper.OrderMapper;
import com.ecf3.marioPizza.core.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@PostMapping("/")
	public OrderDTO save(@RequestBody final OrderDTO order) {
		return OrderMapper.orderToDto(orderService.save(OrderMapper.dtoToEntity(order)));
	}

}
